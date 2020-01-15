package ony.cpes.internal.referral.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cpes.internal.referral.service.JobskReferralService;
import ony.cpes.internal.user.bean.UserBean;
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.framework.BaseController;


@RequestMapping("/internal/referral")
@Controller
public class JobskReferralController extends BaseController{

	private static Log log = LogFactory.getLog(JobskReferralController.class);
  
	@Autowired
	private JobskReferralService jobskReferralService;
	
	@Autowired
	private CommonService commonService;
	
	
    /**
     * 
     * @param JobskReferralBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/jobskReferralReqList")    
    public ModelAndView jobskReferralReqList(@ModelAttribute("JobskReferralBean") JobskReferralBean JobskReferralBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
    	JobskReferralBean.setUser(sessUser);
    	
    	JobCenterBean jcList = (JobCenterBean) jobskReferralService.selectJcList(JobskReferralBean);
    	
    	mv.addObject("userAuth", JobskReferralBean.getUser());
    	mv.addObject("jcList", jcList.getList());
    	mv.setViewName("referral/jobskReferralReqList.all");
    	return mv;
    }
    
	
	/**
	 * 
	 * @param JobskReferralBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping(value="/selectJobskReferralReqListAjax")    
    public ModelAndView selectJobskReferralReqListAjax(@ModelAttribute("JobskReferralBean") JobskReferralBean JobskReferralBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
      		
    	ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			JobskReferralBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			JobskReferralBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			JobskReferralBean.setOrderColumn(orderColumn);
  			JobskReferralBean.setLang(locale.getLanguage().toLowerCase());
  			JobskReferralBean result = jobskReferralService.selectJobskReferralReqList(JobskReferralBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", JobskReferralBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		mv.setViewName("jsonView");
	  	return mv;
	}
	
    
    @RequestMapping(value="/referralUserSearchLayerAjax")
	public ModelAndView referralUserSearchLayerAjax(@ModelAttribute("JobskReferralBean") JobskReferralBean JobskReferralBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	//mv.addObject("setLang",JobskReferralBean.getLang());
    	mv.setViewName("referral/referralUserSearchPop.empty");
	  	return mv;
    }
    
    
    /**
	 * 
	 * @param JobskReferralBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping(value="/selectReferralUserSearchListAjax")    
    public ModelAndView selectReferralUserSearchListAjax(@ModelAttribute("JobskReferralBean") JobskReferralBean JobskReferralBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
      		
    	ModelAndView mv = new ModelAndView();
    	
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
    	JobskReferralBean.setUser(sessUser);
    	
    	
  		JobskReferralBean result = jobskReferralService.selectReferralUserSearchList(JobskReferralBean);
  			
  		mv.addObject("aaData", result.getUserList());
  		
  		mv.setViewName("jsonView");
	  	return mv;
	}
    

}
