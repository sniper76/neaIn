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
import ony.cpes.internal.common.bean.NeaUserMngBean;
import ony.cpes.internal.common.service.NeaUserMngService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;



@RequestMapping("/internal/common")
@Controller
public class NeaUserMngController extends BaseController{

  private static Log log = LogFactory.getLog(NeaUserMngController.class);
  
  @Autowired
  private NeaUserMngService empUserMngService;
  
  
  @Autowired
  private CommonService CommonService;
  
   
    /**
     * selectJobCenterListAjax
     * @param EmpUserMngBean
     * @param request
     * @param response
     * @return
     */
  	@RequestMapping("/selectNeaUserListAjax")
	public ModelAndView selectNeaUserListAjax(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		
		ModelAndView mv = new ModelAndView();
		String[] servletPath = ((String) request.getServletPath()).split("/"); 
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			NeaUserMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			NeaUserMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			NeaUserMngBean.setOrderColumn(orderColumn);
  			
  			
  			NeaUserMngBean result = empUserMngService.selectNeaUserList(NeaUserMngBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", NeaUserMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;
	}
	
    
  	/**
  	 * NeaUserList
  	 * @param request
  	 * @param response
  	 * @return
  	 * @throws Exception
  	 */
    @RequestMapping("/neaUserList")
  	public ModelAndView NeaUserList(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("common/neaUserList.all");
	  	return mv;
  	}
    
    @RequestMapping("/nonNeaUserList")
  	public ModelAndView nonNeaUserList(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("common/nonNeaUserList.all");
	  	return mv;
  	}
    
    @RequestMapping("/jobCenterUserList")
  	public ModelAndView jobCenterUserList(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("common/jobCenterUserList.all");
	  	return mv;
  	}
    
    
    /**
     * neaUserReg
     * @param NeaUserMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/neaUserReg")
  	public ModelAndView neaUserReg(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("common/neaUserReg.all");
	  	return mv;
  	}
    
    /**
     * nonNeaUserReg
     * @param NeaUserMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/nonNeaUserReg")
  	public ModelAndView nonNeaUserReg(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("common/nonNeaUserReg.all");
	  	return mv;
  	}
    
    /**
     * jobCenterUserReg
     * @param NeaUserMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/jobCenterUserReg")
  	public ModelAndView jobCenterUserReg(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("common/jobCenterUserReg.all");
	  	return mv;
  	}
    
    
    /**
     * neaUserMod
     * @param NeaUserMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/neaUserMod")
  	public ModelAndView neaUserMod(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	NeaUserMngBean user = new NeaUserMngBean();
    	
    	user = empUserMngService.selectNeaUserMngDtl(locale, NeaUserMngBean);
    	
    	mv.addObject("user",user);
    	mv.setViewName("common/neaUserMod.all");
	  	return mv;
  	}
    
    /**
     * nonNeaUserMod
     * @param NeaUserMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/nonNeaUserMod")
  	public ModelAndView nonNeaUserMod(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	NeaUserMngBean user = new NeaUserMngBean();
    	
    	user = empUserMngService.selectNeaUserMngDtl(locale, NeaUserMngBean);
    	
    	mv.addObject("user",user);
    	
    	mv.setViewName("common/nonNeaUserMod.all");
	  	return mv;
  	}
    
    /**
     * jobCenterUserMod
     * @param NeaUserMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/jobCenterUserMod")
  	public ModelAndView jobCenterUserMod(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
		
    	NeaUserMngBean user = new NeaUserMngBean();
    	user = empUserMngService.selectNeaUserMngDtl(locale , NeaUserMngBean);
    	
    	mv.addObject("user",user);
    	
    	mv.setViewName("common/jobCenterUserMod.all");
	  	return mv;
  	}
    
    
    /**
     * insertNeaUserAjax
     * @param NeaUserMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/insertNeaUserAjax", "/insertNoneNeaUserAjax", "insertJobCenterUserAjax"})
	public ModelAndView insertNeaUserAjax(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	NeaUserMngBean.setUser(sessUser);
		
		result = empUserMngService.insertNeaUser(request,NeaUserMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    
    /**
     * selectNeaUserMngDtlAjax
     * @param NeaUserMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
    @RequestMapping("/selectNeaUserMngDtlAjax")
	public ModelAndView selectNeaUserMngDtlAjax(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	NeaUserMngBean dtlList = new NeaUserMngBean();
        
    	dtlList = empUserMngService.selectNeaUserMngDtl(NeaUserMngBean);
    	
    	mv.addObject("dtlList",dtlList);
    	mv.setViewName("jsonView");
    	
	  	return mv;  
	}
    */
    
    /**
     * updateNeaUserAjax
     * @param NeaUserMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/updateNeaUserAjax", "/updateNoneNeaUserAjax", "updateJobCenterUserAjax"})
	public ModelAndView updateNeaUserAjax(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	NeaUserMngBean.setUser(sessUser);
		
		result = empUserMngService.updateNeaUser(request,NeaUserMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    @RequestMapping(value={"/deleteNeaUserAjax", "/deleteNoneNeaUserAjax", "deleteJobCenterUserAjax"})
	public ModelAndView deleteNeaUserAjax(@ModelAttribute("NeaUserMngBean") NeaUserMngBean NeaUserMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	NeaUserMngBean.setUser(sessUser);
		
		result = empUserMngService.deleteNeaUser(request,NeaUserMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    
   
    
}
