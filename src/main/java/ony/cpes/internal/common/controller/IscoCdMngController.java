package ony.cpes.internal.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.common.bean.IscoCdMngBean;
import ony.cpes.internal.common.service.IscoCdMngService;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;



@RequestMapping("/internal/common")
@Controller
public class IscoCdMngController extends BaseController{

  private static Log log = LogFactory.getLog(IscoCdMngController.class);
  
  @Autowired
  private IscoCdMngService iscoCdMngService;
  
  
  @Autowired
  private CommonService CommonService;
  
   
    
  	@RequestMapping("/selectIscoCdMngListAjax")
	public ModelAndView selectIscoCdMngListAjax(@ModelAttribute("IscoCdMngBean") IscoCdMngBean IscoCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		
		ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			IscoCdMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			IscoCdMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			IscoCdMngBean.setOrderColumn(orderColumn);
  			IscoCdMngBean.setLang(locale.getLanguage().toLowerCase());
  			
  			
  			IscoCdMngBean result = iscoCdMngService.selectIscoCdMngList(IscoCdMngBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", IscoCdMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;
	}
	
    
  	
    @RequestMapping("/iscoCdMngList")
  	public ModelAndView iscoCdMngList(@ModelAttribute("IscoCdMngBean") IscoCdMngBean IscoCdMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("common/iscoCdMngList.all");
	  	return mv;
  	}
    
    @RequestMapping("/iscoCdMngReg")
  	public ModelAndView iscoCdMngReg(@ModelAttribute("IscoCdMngBean") IscoCdMngBean IscoCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	IscoBean iscoVo = new IscoBean();
    	IscoCdMngBean.setLang(locale.getLanguage().toLowerCase());
    	
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	
    	iscoVo = iscoCdMngService.selectIscoOneList(IscoCdMngBean);
    	
    	mv.addObject("oneDepth", iscoVo.getList());
    	mv.addObject("regUser", sessUser.getUserNm());
    	mv.setViewName("common/iscoCdMngReg.all");
	  	return mv;
  	}
    
    @RequestMapping(value="/selectIscoOneListAjax")    
    public ModelAndView selectIscoOneListAjax(@ModelAttribute("IscoCdMngBean") IscoCdMngBean IscoCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	IscoCdMngBean.setLang(locale.getLanguage().toLowerCase());
    	IscoBean iscoVo = iscoCdMngService.selectIscoOneList(IscoCdMngBean);
    	
    	
    	
    	mv.addObject("oneDepth", iscoVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
    
    @RequestMapping(value="/selectIscoTwoListAjax")    
    public ModelAndView selectIscoTwoListAjax(@ModelAttribute("IscoBean") IscoBean IscoBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	IscoBean.setLang(locale.getLanguage().toLowerCase());
    	IscoBean iscoVo = iscoCdMngService.selectIscoTwoList(IscoBean);
    	
    	
    	
    	mv.addObject("twoDepth", iscoVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
    
    @RequestMapping(value="/selectIscoThreeListAjax")    
    public ModelAndView selectIscoThreeListAjax(@ModelAttribute("IscoBean") IscoBean IscoBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	IscoBean.setLang(locale.getLanguage().toLowerCase());
    	IscoBean iscoVo = iscoCdMngService.selectIscoThreeList(IscoBean);
    	
    	
    	
    	mv.addObject("threeDepth", iscoVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
    
    @RequestMapping("/insertIscoCdMngAjax")
	public ModelAndView insertIscoCdMngAjax(@ModelAttribute("IscoCdMngBean") IscoCdMngBean IscoCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	IscoCdMngBean.setUser(sessUser);
		
		result = iscoCdMngService.insertIscoCdMng(request,IscoCdMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    @RequestMapping("/iscoCdMngMod")
  	public ModelAndView iscoCdMngMod(@ModelAttribute("IscoCdMngBean") IscoCdMngBean IscoCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	IscoBean iscoVo = new IscoBean();
    	IscoCdMngBean.setLang(locale.getLanguage().toLowerCase());
    	
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	IscoCdMngBean.setUser(sessUser);
    	IscoCdMngBean = iscoCdMngService.selectIscoCdMngDetail(IscoCdMngBean);
    	iscoVo = iscoCdMngService.selectIscoOneList(IscoCdMngBean);
    	
    	
    	
    	mv.addObject("oneDepth", iscoVo.getList());
    	mv.addObject("regUser", sessUser.getUserNm());
    	mv.addObject("iscoCdMngBean", IscoCdMngBean);
    	mv.setViewName("common/iscoCdMngMod.all");
	  	return mv;
  	}
    
    @RequestMapping("/updateIscoCdMngAjax")
	public ModelAndView updateIscoCdMngAjax(@ModelAttribute("IscoCdMngBean") IscoCdMngBean IscoCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	IscoCdMngBean.setUser(sessUser);
		
		result = iscoCdMngService.updateIscoCdMng(request,IscoCdMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    
}
