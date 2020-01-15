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
import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.common.service.CommCdMngService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;



@RequestMapping("/internal/common")
@Controller
public class CommCdMngController extends BaseController{

  private static Log log = LogFactory.getLog(CommCdMngController.class);
  
  @Autowired
  private CommCdMngService commCdMngService;
  
  
  @Autowired
  private CommonService CommonService;
  
   
    /**
     * selectGrpCdListAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
  	@RequestMapping("/selectGrpCdMngListAjax")
	public ModelAndView selectGrpCdMngListAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		
		ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			CommCdMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			CommCdMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			CommCdMngBean.setOrderColumn(orderColumn);
  			CommCdMngBean.setLang(locale.getLanguage().toLowerCase());
  			
  			CommCdMngBean result = commCdMngService.selectGrpCdMngList(CommCdMngBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", CommCdMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;
	}
	
    
  	/**
  	 * grpCdList
  	 * @param CommCdMngBean
  	 * @param request
  	 * @param response
  	 * @return
  	 * @throws Exception
  	 */
    @RequestMapping("/grpCdMngList")
  	public ModelAndView grpCdMngList(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("common/grpCdMngList.all");
	  	return mv;
  	}
    
    /**
     * grpCdReg
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/grpCdMngReg")
  	public ModelAndView grpCdMngReg(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
        
        
    	mv.addObject("userNm",sessUser.getUserNm());
    	mv.setViewName("common/grpCdMngReg.all");
	  	return mv;
  	}
    
    
    /**
     * selectChkGrpCdAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectChkGrpCdAjax")
  	public ModelAndView selectChkGrpCdAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();	
    	Map<String,Object> result = new HashMap<String,Object>();
    	
    	result = commCdMngService.selectChkGrpCd(request,CommCdMngBean);
        
    	mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
  	}
   
    /**
     * insertGrpCdAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertGrpCdMngAjax")
	public ModelAndView insertGrpCdMngAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	CommCdMngBean.setUser(sessUser);
		
		result = commCdMngService.insertGrpCdMng(request,CommCdMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    /**
     * grpCdMod
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/grpCdMngMod")
  	public ModelAndView grpCdMngMod(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
		
		mv.addObject("grpCd", CommCdMngBean.getGrpCd());
    	mv.setViewName("common/grpCdMngMod.all");
	  	return mv;
  	}
    
    /**
     * selectGrpCdMngDtlAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectGrpCdMngDtlAjax")
	public ModelAndView selectGrpCdMngDtlAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	CommCdMngBean dtlList = new CommCdMngBean();
        
    	dtlList = commCdMngService.selectGrpCdMngDtl(CommCdMngBean);
    	
    	mv.addObject("dtlList",dtlList);
    	mv.setViewName("jsonView");
    	
	  	return mv;  
	}
    
    /**
     * updateGrpCdMngAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateGrpCdMngAjax")
	public ModelAndView updateGrpCdMngAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	CommCdMngBean.setUser(sessUser);
		
		result = commCdMngService.updateGrpCdMng(request,CommCdMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    /**
     * deleteGrpCdMngAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteGrpCdMngAjax")
	public ModelAndView deleteGrpCdMngAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		
		
		result = commCdMngService.deleteGrpCdMng(request,CommCdMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    /**
     * dtlCdMngList
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/dtlCdMngList")
  	public ModelAndView dtlCdMngList(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("common/dtlCdMngList.all");
	  	return mv;
  	}
    
    /**
     * selectDtlMngGrpCdListAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectDtlMngGrpCdListAjax")
	public ModelAndView selectDtlMngGrpCdListAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		
		ModelAndView mv = new ModelAndView();
  			
  			
  		CommCdMngBean result = commCdMngService.selectDtlMngGrpCdList(CommCdMngBean);
  			
  		mv.addObject("aaData", result.getList());
		mv.setViewName("jsonView");
	  	return mv;
	}
    
    /**
     * selectDtlMngDtlCdListAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectDtlMngDtlCdListAjax")
	public ModelAndView selectDtlMngDtlCdListAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		
		ModelAndView mv = new ModelAndView();
  			
  			
  		CommCdMngBean result = commCdMngService.selectDtlMngDtlCdList(CommCdMngBean);
  			
  		mv.addObject("aaData", result.getList());
		mv.setViewName("jsonView");
	  	return mv;
	}
    
    /**
     * saveDtlCdMngAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveDtlCdMngAjax")
	public ModelAndView saveDtlCdMngAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	CommCdMngBean.setUser(sessUser);
		
		result = commCdMngService.saveDtlCdMng(request,CommCdMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    /**
     * deleteDtlCdMngAjax
     * @param CommCdMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteDtlCdMngAjax")
	public ModelAndView deleteDtlCdMngAjax(@ModelAttribute("CommCdMngBean") CommCdMngBean CommCdMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		result = commCdMngService.deleteDtlCdMng(request,CommCdMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
}
