package ony.cpes.internal.common.controller;

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
import ony.cpes.internal.common.bean.SynonymMngBean;
import ony.cpes.internal.common.service.SnonymMngService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;


@RequestMapping("/internal/common")
@Controller
public class SynonymMngController extends BaseController{

	private static Log log = LogFactory.getLog(SynonymMngController.class);
  
	@Autowired
	private SnonymMngService SnonymMngService;
	
	@Autowired
	private CommonService CommonService;
	
	
	@RequestMapping("/synonymMng")
  	public ModelAndView iscoCdMngList(@ModelAttribute("SynonymMngBean") SynonymMngBean SynonymMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("common/synonymMng.all");
	  	return mv;
  	}
    
	@RequestMapping("/selectSynonymMngListAjax")
	public ModelAndView selectSynonymMngListAjax(@ModelAttribute("SynonymMngBean") SynonymMngBean SynonymMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			SynonymMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			SynonymMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			SynonymMngBean.setOrderColumn(orderColumn);
  			SynonymMngBean.setLang(locale.getLanguage().toLowerCase());
  			SynonymMngBean result = SnonymMngService.selectSynonymMngList(SynonymMngBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", SynonymMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		mv.setViewName("jsonView");
	  	return mv;  
    	
    	
	}
	
	
	@RequestMapping("/insertSynonymMngAjax")
	public ModelAndView insertSynonymMngAjax(@ModelAttribute("SynonymMngBean") SynonymMngBean SynonymMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	SynonymMngBean.setUser(sessUser);
		
		result = SnonymMngService.insertSynonymMng(request,SynonymMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	
	@RequestMapping("/deleteSynonymMngAjax")
	public ModelAndView deleteSynonymMngAjax(@ModelAttribute("SynonymMngBean") SynonymMngBean SynonymMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		
		result = SnonymMngService.deleteSynonymMng(request,SynonymMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	
	@RequestMapping("/updateSynonymMngAjax")
	public ModelAndView updateSynonymMngAjax(@ModelAttribute("SynonymMngBean") SynonymMngBean SynonymMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	SynonymMngBean.setUser(sessUser);
		
		result = SnonymMngService.updateSynonymMng(request,SynonymMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
    
}
