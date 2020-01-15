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

import ony.cpes.internal.referral.service.VacancyReferralService;
import ony.cpes.internal.user.bean.UserBean;
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.VacancyReferralBean;
import ony.framework.BaseController;


@RequestMapping("/internal/referral")
@Controller
public class VacancyReferralController extends BaseController{

	private static Log log = LogFactory.getLog(VacancyReferralController.class);
  
	@Autowired
	private VacancyReferralService vacancyReferralService;
	
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
	@RequestMapping(value="/vacancyReferralReqList")    
    public ModelAndView vacancyReferralReqList(@ModelAttribute("VacancyReferralBean") VacancyReferralBean VacancyReferralBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
    	VacancyReferralBean.setUser(sessUser);
    	
    	JobCenterBean jcList = (JobCenterBean) vacancyReferralService.selectJcList(VacancyReferralBean);
    	
    	mv.addObject("userAuth", VacancyReferralBean.getUser());
    	mv.addObject("jcList", jcList.getList());
    	mv.setViewName("referral/vacancyReferralReqList.all");
    	return mv;
    }
    
	
	/**
	 * 
	 * @param JobskReferralBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping(value="/selectVacancyReferralReqListAjax")    
    public ModelAndView selectVacancyReferralReqListAjax(@ModelAttribute("VacancyReferralBean") VacancyReferralBean VacancyReferralBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
      		
    	ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			VacancyReferralBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			VacancyReferralBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			VacancyReferralBean.setOrderColumn(orderColumn);
  			VacancyReferralBean.setLang(locale.getLanguage().toLowerCase());
  			VacancyReferralBean result = vacancyReferralService.selectVacancyReferralReqList(VacancyReferralBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", VacancyReferralBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		mv.setViewName("jsonView");
	  	return mv;
	}
	
    
    @RequestMapping(value="/referralCmpnySearchLayerAjax")
	public ModelAndView referralCmpnySearchLayerAjax(@ModelAttribute("VacancyReferralBean") VacancyReferralBean VacancyReferralBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	//mv.addObject("setLang",JobskReferralBean.getLang());
    	mv.setViewName("referral/referralCmpnySearchPop.empty");
	  	return mv;
    }
    
    
    /**
     * 
     * @param VacancyReferralBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectReferralCmpnySearchListAjax")    
    public ModelAndView selectReferralCmpnySearchListAjax(@ModelAttribute("VacancyReferralBean") VacancyReferralBean VacancyReferralBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
      		
    	ModelAndView mv = new ModelAndView();
    	
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
    	VacancyReferralBean.setUser(sessUser);
    	
    	
    	VacancyReferralBean result = vacancyReferralService.selectReferralCmpnySearchList(VacancyReferralBean);
  			
  		mv.addObject("aaData", result.getCmpnyList());
  		
  		mv.setViewName("jsonView");
	  	return mv;
	}
    

}
