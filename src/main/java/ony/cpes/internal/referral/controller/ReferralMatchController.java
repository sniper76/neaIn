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

import ony.cpes.internal.referral.service.ReferralMatchService;
import ony.cpes.internal.user.bean.UserBean;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.cpes.internal.referral.bean.ReferralMatchBean;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.framework.BaseController;


@RequestMapping("/internal/referral")
@Controller
public class ReferralMatchController extends BaseController{

	private static Log log = LogFactory.getLog(ReferralMatchController.class);
  
	@Autowired
	private ReferralMatchService referralMatchService;
	
	@Autowired
	private CommonService commonService;
	
	
    /**
     * 
     * @param ReferralMatchBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/jobReferralMatchList")    
    public ModelAndView jobskReferralReqList(@ModelAttribute("ReferralMatchBean") ReferralMatchBean ReferralMatchBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	IscoBean iscoVo = new IscoBean();
    	LocationBean locVo = new LocationBean();
    	ReferralMatchBean.setLang(locale.getLanguage().toLowerCase());
    	
    	ReferralMatchBean = referralMatchService.selectResumeInfo(ReferralMatchBean);
    	iscoVo = referralMatchService.selectIscoOneList(ReferralMatchBean);
    	locVo = referralMatchService.selectProvincList(ReferralMatchBean);
    	
    	mv.addObject("ReferralMatchBean", ReferralMatchBean);
    	mv.addObject("oneDepth", iscoVo.getList());
    	mv.addObject("provin", locVo.getList());
    	mv.setViewName("referral/jobskReferralMatchList.all");
    	return mv;
    }
    
	/**
	 * selectResumeInfoAjax
	 * @param ReferralMatchBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectResumeInfoAjax")    
    public ModelAndView selectResumeInfoAjax(@ModelAttribute("ReferralMatchBean") ReferralMatchBean ReferralMatchBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	
    	ReferralMatchBean = referralMatchService.selectResumeInfo(ReferralMatchBean);
    	
    	
    	
    	mv.addObject("ReferralMatchBean", ReferralMatchBean);
    	mv.setViewName("jsonView");
    	return mv;
    }
	
	@RequestMapping(value="/vacancyReferralMatchList")    
    public ModelAndView vacancyReferralMatchList(@ModelAttribute("ReferralMatchBean") ReferralMatchBean ReferralMatchBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	IscoBean iscoVo = new IscoBean();
    	LocationBean locVo = new LocationBean();
    	ReferralMatchBean.setLang(locale.getLanguage().toLowerCase());
    	
    	ReferralMatchBean = referralMatchService.selectCmpnyInfo(ReferralMatchBean);
    	iscoVo = referralMatchService.selectIscoOneList(ReferralMatchBean);
    	locVo = referralMatchService.selectProvincList(ReferralMatchBean);
    	
    	mv.addObject("ReferralMatchBean", ReferralMatchBean);
    	mv.addObject("oneDepth", iscoVo.getList());
    	mv.addObject("provin", locVo.getList());
    	mv.setViewName("referral/vacancyReferralMatchList.all");
    	return mv;
    }
	
	/**
	 * selectCmpnyInfoAjax
	 * @param ReferralMatchBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCmpnyInfoAjax")    
    public ModelAndView selectCmpnyInfoAjax(@ModelAttribute("ReferralMatchBean") ReferralMatchBean ReferralMatchBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	ReferralMatchBean = referralMatchService.selectCmpnyInfo(ReferralMatchBean);
    	
    	mv.addObject("ReferralMatchBean", ReferralMatchBean);
    	mv.setViewName("jsonView");
    	return mv;
    }
	
	@RequestMapping(value="/selectIscoTwoListAjax")    
    public ModelAndView selectIscoTwoListAjax(@ModelAttribute("IscoBean") IscoBean IscoBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	IscoBean.setLang(locale.getLanguage().toLowerCase());
    	IscoBean iscoVo = referralMatchService.selectIscoTwoList(IscoBean);
    	
    	
    	
    	mv.addObject("twoDepth", iscoVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
	
	@RequestMapping(value="/selectIscoThreeListAjax")    
    public ModelAndView selectIscoThreeListAjax(@ModelAttribute("IscoBean") IscoBean IscoBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	IscoBean.setLang(locale.getLanguage().toLowerCase());
    	IscoBean iscoVo = referralMatchService.selectIscoThreeList(IscoBean);
    	
    	
    	
    	mv.addObject("threeDepth", iscoVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
	
	@RequestMapping(value="/selectIscoFourListAjax")    
    public ModelAndView selectIscoFourListAjax(@ModelAttribute("IscoBean") IscoBean IscoBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	IscoBean.setLang(locale.getLanguage().toLowerCase());
    	IscoBean iscoVo = referralMatchService.selectIscoFourList(IscoBean);
    	
    	
    	
    	mv.addObject("fourDepth", iscoVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
	
	@RequestMapping(value="/selectDistrictListAjax")    
    public ModelAndView selectDistrictListAjax(@ModelAttribute("LocationBean") LocationBean LocationBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	LocationBean.setLang(locale.getLanguage().toLowerCase());
    	LocationBean locVo = referralMatchService.selectDistrictList(LocationBean);
    	
    	
    	
    	mv.addObject("distrc", locVo.getList());
    	mv.setViewName("jsonView");
    	return mv;
    }
	
	
	@RequestMapping(value="/selectJobskReferralMatchListAjax")    
    public ModelAndView selectJobskReferralMatchListAjax(@ModelAttribute("ReferralMatchBean") ReferralMatchBean ReferralMatchBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
      		
    	ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			ReferralMatchBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			ReferralMatchBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			ReferralMatchBean.setOrderColumn(orderColumn);
  			ReferralMatchBean.setLang(locale.getLanguage().toLowerCase());
  			ReferralMatchBean result = referralMatchService.selectJobskReferralMatchList(ReferralMatchBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", ReferralMatchBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		mv.setViewName("jsonView");
	  	return mv;
	}
	
	@RequestMapping(value="/selectVacancyReferralMatchListAjax")    
    public ModelAndView selectVacancyReferralMatchListAjax(@ModelAttribute("ReferralMatchBean") ReferralMatchBean ReferralMatchBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
      		
    	ModelAndView mv = new ModelAndView();
    	String orderColumnIndex = "0";
    	// sorting
  		orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			ReferralMatchBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			ReferralMatchBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			ReferralMatchBean.setOrderColumn(orderColumn);
  			ReferralMatchBean.setLang(locale.getLanguage().toLowerCase());
  			ReferralMatchBean result = referralMatchService.selectVacancyReferralMatchList(ReferralMatchBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", ReferralMatchBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		mv.setViewName("jsonView");
	  	return mv;
	}
    

}
