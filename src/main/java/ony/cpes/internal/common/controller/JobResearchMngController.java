package ony.cpes.internal.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import ony.cpes.internal.common.bean.JobResearchMngBean;
import ony.cpes.internal.common.bean.NeaUserMngBean;
import ony.cpes.internal.common.service.JobResearchMngService;
import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;



@RequestMapping("/internal/common")
@Controller
public class JobResearchMngController extends BaseController{

  private static Log log = LogFactory.getLog(JobResearchMngController.class);
  
  @Autowired
  private JobResearchMngService jobResearchMngService;
  
  
  @Autowired
  private CommonService CommonService;
  
   
    /**
     * selectJobCenterListAjax
     * @param JobResearchMngBean
     * @param request
     * @param response
     * @return
     */
  	@RequestMapping("/selectJobReschMngListAjax")
	public ModelAndView selectJobReschMngListAjax(@ModelAttribute("JobResearchMngBean") JobResearchMngBean JobResearchMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		
		ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			JobResearchMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			JobResearchMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			JobResearchMngBean.setOrderColumn(orderColumn);
  			
  			
  			JobResearchMngBean result = jobResearchMngService.selectJobReschMngList(JobResearchMngBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", JobResearchMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;
	}
	
    
  	/**
  	 * jobReschMngList
  	 * @param JobResearchMngBean
  	 * @param response
  	 * @return
  	 * @throws Exception
  	 */
    @RequestMapping("/jobReschMngList")
  	public ModelAndView jobReschMngList(@ModelAttribute("JobResearchMngBean") JobResearchMngBean JobResearchMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	JobResearchMngBean cateOne = jobResearchMngService.selectCateOneList(JobResearchMngBean);
    	
    	mv.addObject("cateOneList", cateOne.getList());
    	mv.setViewName("common/jobReschMngList.all");
	  	return mv;
  	}
    
    /**
     * jobReschMngMod
     * @param JobResearchMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/jobReschMngMod")
  	public ModelAndView jobReschMngMod(@ModelAttribute("JobResearchMngBean") JobResearchMngBean JobResearchMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	mv.addObject("iscoCd",JobResearchMngBean.getIscoCd());
    	mv.setViewName("common/jobReschMngMod.all");
	  	return mv;
  	}
    
    /**
     * selectJobReschMngDtlAjax
     * @param JobResearchMngBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectJobReschMngDtlAjax")
  	public ModelAndView selectJobReschMngDtlAjax(@ModelAttribute("JobResearchMngBean") JobResearchMngBean JobResearchMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	JobResearchMngBean dtlList = jobResearchMngService.selectJobReschMngDtl(JobResearchMngBean);
    	
    	mv.addObject("dtlList", dtlList);
    	mv.setViewName("jsonView");
	  	return mv;
  	}
    
    @RequestMapping("/updateJobReschMngAjax")
	public ModelAndView updateJobReschMngAjax(@ModelAttribute("JobResearchMngBean") JobResearchMngBean JobResearchMngBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	JobResearchMngBean.setUser(sessUser);
		
		result = jobResearchMngService.updateJobReschMng(request,JobResearchMngBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
}
