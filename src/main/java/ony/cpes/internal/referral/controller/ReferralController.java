package ony.cpes.internal.referral.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import ony.cpes.internal.referral.service.ReferralService;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.sitemgmt.bean.BannerBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.vacancy.bean.VacancyBean;
import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.cpes.internal.referral.bean.ReferralBean;
import ony.cpes.internal.referral.bean.VacancyReferralBean;
import ony.framework.BaseController;


@RequestMapping("/internal/referral")
@Controller
public class ReferralController extends BaseController{

	private static Log log = LogFactory.getLog(ReferralController.class);
  
	@Autowired
	private ReferralService referralService;
	
	@Autowired
	private CommonService CommonService;
	
	@Autowired
	private JobskReferralService jobskReferralService;

    /*
     * Referral History Management List
     */	
    @RequestMapping("/referralHisMngList")
	public String ReferralHisMngList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "referral/referralHisMngList.all";
	}    
    
    @RequestMapping(value="/selectReferralHisMngListAjax")    
    public void selectReferralHisMngList(@ModelAttribute("referralBean") ReferralBean referralBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
      		
      		// sorting
      		String orderColumnIndex = request.getParameter("order[0][column]");
      		if (orderColumnIndex != null) 
      			referralBean.setOrderStr(Integer.parseInt(orderColumnIndex));
      		
      		String orderDir = request.getParameter("order[0][dir]");
      		if (orderDir != null)
      			referralBean.setOrderColumnSort(orderDir);
      		
      		String orderColumns = request.getParameter("orderColumns");
      		String orderColumn = "";
      		if(orderColumns != null) {
      			String[] temp = orderColumns.split(",");
      			orderColumn = temp[Integer.parseInt(orderColumnIndex)];
      			referralBean.setOrderColumn(orderColumn);
      		}
      			
    		this.outputJSON(request, response, referralService.selectReferralHisMngList(referralBean));
	}
	
    /*
     * Delete Referral History Management List
     */
    @RequestMapping(value="/deleteReferralHisMngListAjax", method=RequestMethod.POST)
    public Map<String, Object> deleteReferralHisMngList(HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ReferralBean param = new ReferralBean();
    	ReferralBean resultParam = new ReferralBean();
    	Map<String,Object> result = new HashMap<String,Object>();
    	
    	param.setVacancySeq(request.getParameter("vacancySeq"));
    	param.setResumeSeq(request.getParameter("resumeSeq"));
    	
    	try {
    		
    		resultParam = referralService.deleteReferralHisMngList(param);
    		
    		if(resultParam.getResultCode() == "0000")
			result.put("resultCode", "success");
			result.put("resultMsg", "");
	        return result;
	        
    	} catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage());
			return result;   		
    	}
    }
    
    
    @RequestMapping(value="/referralManageLayerAjax")
	public ModelAndView referralManageLayerAjax(@ModelAttribute("ReferralBean") ReferralBean ReferralBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	ReferralBean.setLang(locale.getLanguage().toLowerCase());
    	
    	ReferralBean result = referralService.selectReferralManage(ReferralBean);
    	VacancyBean  vacancy = referralService.selectReferralManageVacancy(ReferralBean);
    	ResumeBean  resume = referralService.selectReferralManageResume(ReferralBean);
    	
    	//CommDtlCdBean commDtlCdBean = new CommDtlCdBean();
	  	//List<String> commGrpCdList = new ArrayList<String>();
	  	
	  	//commGrpCdList.add("REFERRAL_STS_CD");

	  	//commDtlCdBean.setCommGrpCdList(commGrpCdList);
  		
	  	//CommDtlCdBean commCode = (CommDtlCdBean) CommonService.selectCommCodeList(commDtlCdBean);
    	
    	mv.addObject("vacancy",vacancy);
    	mv.addObject("resume",resume);
    	mv.addObject("referral",result);
    	mv.addObject("referralTypeCd",request.getParameter("referralTypeCd"));
    	mv.addObject("chk",request.getParameter("viewChk"));
    	mv.setViewName("referral/referralManagePop.empty");
	  	return mv;
    }
    
    
    @RequestMapping("/insertReferralMgmtAjax")
	public ModelAndView insertReferralMgmtAjax(@ModelAttribute("ReferralBean") ReferralBean ReferralBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	ReferralBean.setUser(sessUser);
    	ReferralBean.setDelYn("N");
    	
		
		result = referralService.insertReferralMgmt(ReferralBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    /**
     * 
     * @param JobskReferralBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/jobReferralRecordList")    
    public ModelAndView jobskReferralReqList(@ModelAttribute("ReferralBean") ReferralBean ReferralBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	JobskReferralBean jobskreBean = new JobskReferralBean();
    	
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	jobskreBean.setUser(sessUser);
    	
    	JobCenterBean jcList = (JobCenterBean) jobskReferralService.selectJcList(jobskreBean);
    	
    	mv.addObject("userAuth", ReferralBean.getUser());
    	mv.addObject("jcList", jcList.getList());
    	mv.setViewName("referral/jobReferralRecordList.all");
    	return mv;
    }
	
	
	/**
	 * 
	 * @param JobskReferralBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping(value="/selectJobReferralRecordListAjax")    
    public ModelAndView selectJobReferralRecordListAjax(@ModelAttribute("ReferralBean") ReferralBean ReferralBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
      		
    	ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			ReferralBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			ReferralBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			ReferralBean.setOrderColumn(orderColumn);
  			ReferralBean.setLang(locale.getLanguage().toLowerCase());
  			ReferralBean result = referralService.selectJobReferralRecordList(ReferralBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", ReferralBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		mv.setViewName("jsonView");
	  	return mv;
	}

}
