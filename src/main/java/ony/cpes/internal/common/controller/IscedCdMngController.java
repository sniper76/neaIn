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
import ony.cpes.internal.common.bean.IscedCdMngBean;
import ony.cpes.internal.common.bean.IscoCdMngBean;
import ony.cpes.internal.common.service.IscedCdMngService;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;



@RequestMapping("/internal/common")
@Controller
public class IscedCdMngController extends BaseController{

  private static Log log = LogFactory.getLog(IscedCdMngController.class);
  
  @Autowired
  private IscedCdMngService iscedCdMngService;
  
  
  @Autowired
  private CommonService CommonService;
  
   
    
  	@RequestMapping("/selectIscedCdMngListAjax")
	public ModelAndView selectIscedCdMngListAjax(@ModelAttribute("IscedCdMngBean") IscedCdMngBean IscedCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		
		ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			IscedCdMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			IscedCdMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			IscedCdMngBean.setOrderColumn(orderColumn);
  			IscedCdMngBean.setLang(locale.getLanguage().toLowerCase());
  			
  			
  			IscedCdMngBean result = iscedCdMngService.selectIscedCdMngList(IscedCdMngBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", IscedCdMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;
	}
	
    
  	
    @RequestMapping("/iscedCdMngList")
  	public ModelAndView iscoCdMngList(@ModelAttribute("IscedCdMngBean") IscedCdMngBean IscedCdMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("common/iscedCdMngList.all");
	  	return mv;
  	}
    
    
    @RequestMapping("/iscedCdMngReg")
  	public ModelAndView iscedCdMngReg(@ModelAttribute("IscedCdMngBean") IscedCdMngBean IscedCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	IscedCdMngBean iscedVo = new IscedCdMngBean();
    	IscedCdMngBean.setLang(locale.getLanguage().toLowerCase());
    	
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	
    	iscedVo = iscedCdMngService.selectIscedOneList(IscedCdMngBean);
    	
    	mv.addObject("oneDepth", iscedVo.getList());
    	mv.addObject("regUser", sessUser.getUserNm());
    	mv.setViewName("common/iscedCdMngReg.all");
	  	return mv;
  	}
    
    @RequestMapping(value="/selectIscedOneListAjax")    
    public ModelAndView selectIscedOneListAjax(@ModelAttribute("IscedCdMngBean") IscedCdMngBean IscedCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	IscedCdMngBean.setLang(locale.getLanguage().toLowerCase());
    	IscedCdMngBean iscedVo = iscedCdMngService.selectIscedOneList(IscedCdMngBean);
    	
    	
    	
    	mv.addObject("oneDepth", iscedVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
    
    @RequestMapping(value="/selectIscedTwoListAjax")    
    public ModelAndView selectIscedTwoListAjax(@ModelAttribute("IscedCdMngBean") IscedCdMngBean IscedCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	IscedCdMngBean.setLang(locale.getLanguage().toLowerCase());
    	IscedCdMngBean iscedVo = iscedCdMngService.selectIscedTwoList(IscedCdMngBean);
    	
    	
    	
    	mv.addObject("twoDepth", iscedVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
    
    @RequestMapping(value="/selectIscedThreeListAjax")    
    public ModelAndView selectIscedThreeListAjax(@ModelAttribute("IscedCdMngBean") IscedCdMngBean IscedCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	IscedCdMngBean.setLang(locale.getLanguage().toLowerCase());
    	IscedCdMngBean iscedVo = iscedCdMngService.selectIscedThreeList(IscedCdMngBean);
    	
    	
    	
    	mv.addObject("threeDepth", iscedVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
    
    @RequestMapping("/insertIscedCdMngAjax")
	public ModelAndView insertIscedCdMngAjax(@ModelAttribute("IscedCdMngBean") IscedCdMngBean IscedCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	IscedCdMngBean.setUser(sessUser);
		
		result = iscedCdMngService.insertIscedCdMng(request,IscedCdMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    @RequestMapping("/iscedCdMngMod")
  	public ModelAndView iscedCdMngMod(@ModelAttribute("IscedCdMngBean") IscedCdMngBean IscedCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	IscedCdMngBean iscedVo = new IscedCdMngBean();
    	IscedCdMngBean.setLang(locale.getLanguage().toLowerCase());
    	
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	IscedCdMngBean.setUser(sessUser);
    	IscedCdMngBean = iscedCdMngService.selectIscedCdMngDetail(IscedCdMngBean);
    	iscedVo = iscedCdMngService.selectIscedOneList(IscedCdMngBean);
    	
    	
    	
    	mv.addObject("oneDepth", iscedVo.getList());
    	mv.addObject("regUser", sessUser.getUserNm());
    	mv.addObject("iscedCdMngBean", IscedCdMngBean);
    	mv.setViewName("common/iscedCdMngMod.all");
	  	return mv;
  	}
    
    @RequestMapping("/updateIscedCdMngAjax")
	public ModelAndView updateIscedCdMngAjax(@ModelAttribute("IscedCdMngBean") IscedCdMngBean IscedCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	IscedCdMngBean.setUser(sessUser);
		
		result = iscedCdMngService.updateIscedCdMng(request,IscedCdMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
 }
