package ony.cpes.internal.sitemgmt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cpes.internal.sitemgmt.service.PopUpService;
import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.login.service.LoginService;
import ony.cpes.internal.user.bean.UserBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;
import ony.framework.BaseController;


@RequestMapping("/internal/sitemgmt")
@Controller
public class PopUpController extends BaseController{

	private static Log log = LogFactory.getLog(PopUpController.class);
  
	@Autowired
	private PopUpService popUpService;
	
	@Autowired
	private CommonService CommonService;
	
	@RequestMapping("/popUpList")
	public String siteMgmt(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "siteMgmt/popUpList.all";
	}
	
	@RequestMapping("/popUpReg")
	public String popUpReg(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "siteMgmt/popUpReg.all";
	}
	
	
	@RequestMapping("/popUpMod")
	public ModelAndView popUpMod(@ModelAttribute("PopUpBean") PopUpBean PopUpBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
        
        String popupSeq = PopUpBean.getPopupSeq();
    	mv.addObject("popupSeq",popupSeq);
    	mv.setViewName("siteMgmt/popUpMod.all");
    	
	  	return mv;  
	}
	
	@RequestMapping("/selectPopUpDtlAjax")
	public ModelAndView selectPopUpDtlAjax(@ModelAttribute("PopUpBean") PopUpBean PopUpBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	PopUpBean dtlList = new PopUpBean();
        
    	dtlList = popUpService.selectPopUpDtl(PopUpBean);
    	
    	mv.addObject("dtlList",dtlList);
    	mv.setViewName("jsonView");
    	
	  	return mv;  
	}
	
	
	@RequestMapping("/selectPopUpList")
	public ModelAndView selectPopUpListAjax(@ModelAttribute("PopUpBean") PopUpBean PopUpBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			PopUpBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			PopUpBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			PopUpBean.setOrderColumn(orderColumn);
  			PopUpBean.setLang(locale.getLanguage().toLowerCase());
  			PopUpBean result = popUpService.selectPopUpList(PopUpBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", PopUpBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;  
    	
    	
	}
	
	
	@RequestMapping("/insertPopUp")
	public ModelAndView insertPopUpAjax(@ModelAttribute("PopUpBean") PopUpBean PopUpBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	PopUpBean.setUser(sessUser);
		
		result = popUpService.insertPopUp(PopUpBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	
	@RequestMapping("/updatePopUpAjax")
	public ModelAndView updatePopUpAjax(@ModelAttribute("PopUpBean") PopUpBean PopUpBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	PopUpBean.setUser(sessUser);
		
		result = popUpService.updatePopUp(PopUpBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	@RequestMapping("/deletePopUpDtlAjax")
	public ModelAndView deletePopUpDtlAjax(@ModelAttribute("PopUpBean") PopUpBean PopUpBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		
		result = popUpService.deletePopUp(PopUpBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	
    
}
