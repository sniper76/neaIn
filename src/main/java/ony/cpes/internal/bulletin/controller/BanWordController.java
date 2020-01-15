package ony.cpes.internal.bulletin.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.bulletin.bean.BanWordBean;
import ony.cpes.internal.bulletin.service.BanWordService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;


@RequestMapping("/internal/bulletin")
@Controller
public class BanWordController extends BaseController{

	private static Log log = LogFactory.getLog(BanWordController.class);
  
	@Autowired
	private BanWordService BanWordService;
	
	@Autowired
	private CommonService CommonService;
	
	@RequestMapping("/banWord")
	public String banWord(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "bulletin/banWord.all";
	}
	
	
    
	@RequestMapping("/selectBanWordList")
	public ModelAndView selectBulletinBasicListAjax(@ModelAttribute("BanWordBean") BanWordBean BanWordBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			BanWordBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			BanWordBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			BanWordBean.setOrderColumn(orderColumn);
  			BanWordBean.setLang(locale.getLanguage().toLowerCase());
  			BanWordBean result = BanWordService.selectBanWordList(BanWordBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", BanWordBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;  
    	
    	
	}
	
	
	@RequestMapping("/insertBanWordAjax")
	public ModelAndView insertBanWordAjax(@ModelAttribute("BanWordBean") BanWordBean BanWordBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	BanWordBean.setUser(sessUser);
		
		result = BanWordService.insertBanWord(BanWordBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	/**
	 * 
	 * @param BanWordBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBanWordAjax")
	public ModelAndView updateBanWordAjax(@ModelAttribute("BanWordBean") BanWordBean BanWordBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	BanWordBean.setUser(sessUser);
		
		result = BanWordService.updateBanWord(BanWordBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	/**
	 * 
	 * @param BanWordBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteBanWordAjax")
	public ModelAndView deleteBanWordAjax(@ModelAttribute("BanWordBean") BanWordBean BanWordBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		
		result = BanWordService.deleteBanWord(BanWordBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
	
    
}
