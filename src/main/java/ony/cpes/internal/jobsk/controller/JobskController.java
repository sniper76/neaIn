package ony.cpes.internal.jobsk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.google.common.base.CaseFormat;

import ony.cpes.internal.jobsk.service.JobskService;
import ony.cpes.internal.jobsk.bean.JobskBean;
import ony.cpes.internal.jobsk.bean.JobskIscoBean;
import ony.cpes.internal.jobsk.bean.JobskLocBean;
import ony.cpes.internal.jobsk.bean.JobskSpcEduBean;
import ony.cpes.internal.jobsk.bean.JobskOtrTrnngBean;
import ony.cpes.internal.jobsk.bean.JobskLangBean;
import ony.cpes.internal.jobsk.bean.JobskWorkExpBean;
import ony.cpes.internal.jobsk.bean.JobskSkillBean;
import ony.cpes.internal.jobsk.bean.JobskRcmdmanBean;
import ony.cpes.internal.jobsk.bean.JobskVacancyBean;
import ony.cpes.internal.jobsk.bean.JobskApplicBean;
import ony.cpes.internal.jobsk.bean.JobskOfferBean;
import ony.cpes.internal.jobsk.bean.JobskIntvwBean;
import ony.cpes.internal.jobsk.bean.JobskVdoIntvwBean;
import ony.framework.BaseController;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.vacancy.bean.VacancyBean;
import ony.cpes.internal.vacancy.bean.VacancyLangBean;
import ony.cpes.internal.vacancy.bean.VacancyLocBean;
import ony.cpes.internal.vacancy.bean.VacancyPreferntBean;
import ony.cpes.internal.vacancy.service.VacancyService;
import ony.cmm.common.service.CommonService;

@RequestMapping("/internal/jobsk")
@Controller
public class JobskController extends BaseController{

	private static Log log = LogFactory.getLog(JobskController.class);
  
	@Autowired
	private JobskService jobskService;

	@Autowired
	private VacancyService vacancyService;
	
	@Autowired
	private CommonService CommonService;

	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;	
		
    /**
     * Job Seek List
     * @param JobskBean
     * @param 
     * @return JobskBean
     * @throws Exception
     */
	@RequestMapping("/jobskList")
	public String jobSkList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "jobsk/jobskList.all";
	}    	
	
    @RequestMapping(value="/selectJobskListAjax")    
	public ModelAndView selectJobskListAjax(@ModelAttribute("JobskBean") JobskBean jobskBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		jobskBean.setLang(locale.getLanguage().toLowerCase());
  		
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			jobskBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			jobskBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			jobskBean.setOrderColumn(orderColumn);
  			
  			JobskBean result = (JobskBean) jobskService.selectJobskList(jobskBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", jobskBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}
    
    /**
     * Job Seek Detail Info
     * @param JobskBean
     * @param 
     * @return JobskBean
     * @throws Exception
     */   
    @RequestMapping(value= {"/selectJobskDtlInfoAjax", "selectJobskDtlInfoModifyAjax"}) 
    public ModelAndView selectJobskDtlInfoAjax(@ModelAttribute("JobskBean") JobskBean jobskBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	ModelAndView mv = new ModelAndView();
    	
    	JobskIscoBean jobskIscoBean = new JobskIscoBean();
    	JobskIscoBean rtnIsco = new JobskIscoBean();
    	
    	JobskLocBean jobskLocBean = new JobskLocBean();
    	JobskLocBean rtnLoc = new JobskLocBean();
    	
    	JobskSpcEduBean jobskSpcEduBean = new JobskSpcEduBean();
    	JobskSpcEduBean rtnSpcEdu = new JobskSpcEduBean();
    	
    	JobskOtrTrnngBean jobskOtrTrnngBean = new JobskOtrTrnngBean();
    	JobskOtrTrnngBean rtnOtrTrnng = new JobskOtrTrnngBean();
    	
    	JobskLangBean jobskLangBean = new JobskLangBean();
    	JobskLangBean rtnLang = new JobskLangBean();
    	
    	JobskWorkExpBean jobskWorkExpBean = new JobskWorkExpBean();
    	JobskWorkExpBean rtnWorkExp = new JobskWorkExpBean();
    	
    	JobskSkillBean jobskSkillBean = new JobskSkillBean();
    	JobskSkillBean rtnSkillTitle = new JobskSkillBean();
    	
    	JobskSkillBean jobskSkillParam = new JobskSkillBean();
    	JobskSkillBean jobskSkillDtl = new JobskSkillBean();
		
    	JobskRcmdmanBean jobskRcmdmanBean = new JobskRcmdmanBean();
    	JobskRcmdmanBean rtnRcmdman = new JobskRcmdmanBean();
    	
    	jobskBean.setLang(locale.getLanguage().toLowerCase());
    	JobskBean rtnBase = (JobskBean) jobskService.selectJobskDtlInfoBase(jobskBean);
    	
    	if(rtnBase != null) {
	    	
    		JobskBean DisableOptParam = new JobskBean();
        	JobskBean DisableOptRtnParam = new JobskBean();
        	String strDisableOptCd = "";
        	String rtnDisableOptNm = "";
        	
    		// Disable Option Cd + Disable Etc
        	if(rtnBase.getDisablEtc() != null && rtnBase.getDisablEtc().toString() != "") {
		    	strDisableOptCd = rtnBase.getDisablEtc().toString();
				String[] arrDisableOptCd = strDisableOptCd.split(",");
		
				for(int i=0; i<arrDisableOptCd.length;i++) {
					DisableOptParam.setDisablOptionCd(arrDisableOptCd[i].toString());
					DisableOptParam.setLang(locale.getLanguage().toLowerCase());
					DisableOptRtnParam = jobskService.selectJobskDisableOptNm(DisableOptParam);
					if(DisableOptRtnParam != null) {
						if(i == 0) {
							rtnDisableOptNm += DisableOptRtnParam.getDisablOptionNm().toString();
						} else {
							rtnDisableOptNm += "," + DisableOptRtnParam.getDisablOptionNm().toString();
						}
					}
				}
				
				if(rtnDisableOptNm == null || rtnDisableOptNm == "") {
					rtnDisableOptNm = rtnBase.getDisablOptionNm().toString();
				} else {
					rtnDisableOptNm += "," + rtnBase.getDisablOptionNm().toString();
				}
				rtnBase.setDisablOptionNm(rtnDisableOptNm);
        	}
        	
			// ISCO Data Info
			jobskIscoBean.setResumeSeq(rtnBase.getResumeSeq().toString());
			jobskIscoBean.setLang(locale.getLanguage().toLowerCase());
			rtnIsco = jobskService.selectJobskIscoList(jobskIscoBean);
			
			// Prefer Work Location Info
			jobskLocBean.setResumeSeq(rtnBase.getResumeSeq().toString());
			jobskLocBean.setLang(locale.getLanguage().toLowerCase());
			rtnLoc = jobskService.selectJobskPreferWorkLocList(jobskLocBean);
	
			// Prefer Work Week Day
			String preferWorkWeekDay = "";
			if (rtnBase.getPreferDayMon().toString().equals("Y")) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.mon", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.mon", null, "Error", localeResolver.resolveLocale(request));
				}	
			}
			if (rtnBase.getPreferDayTue().toString().equals("Y")) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.tue", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.tue", null, "Error", localeResolver.resolveLocale(request));
				}	
			}
			if (rtnBase.getPreferDayWed().toString().equals("Y")) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.wed", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.wed", null, "Error", localeResolver.resolveLocale(request));
				}	
			}
			if (rtnBase.getPreferDayThu().toString().equals("Y")) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.thu", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.thu", null, "Error", localeResolver.resolveLocale(request));
				}	
			}
			if (rtnBase.getPreferDayFri().toString().equals("Y")) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.fri", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.fri", null, "Error", localeResolver.resolveLocale(request));
				}	
			}
			if (rtnBase.getPreferDaySat().toString().equals("Y")) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.sat", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.sat", null, "Error", localeResolver.resolveLocale(request));
				}	
			}
			if (rtnBase.getPreferDaySun().toString().equals("Y")) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.sun", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.sun", null, "Error", localeResolver.resolveLocale(request));
				}	
			}
			rtnBase.setPreferWorkWeekDay(preferWorkWeekDay);
			
			jobskSpcEduBean.setResumeSeq(jobskBean.getResumeSeq().toString());
			jobskSpcEduBean.setLang(locale.getLanguage().toLowerCase());
			rtnSpcEdu = jobskService.selectJobskSpcEduList(jobskSpcEduBean);
	    	
			jobskOtrTrnngBean.setResumeSeq(jobskBean.getResumeSeq().toString());
			jobskOtrTrnngBean.setLang(locale.getLanguage().toLowerCase());
			rtnOtrTrnng = jobskService.selectJobskOtrTrnngList(jobskOtrTrnngBean);
	    			
			jobskLangBean.setResumeSeq(jobskBean.getResumeSeq().toString());
			jobskLangBean.setLang(locale.getLanguage().toLowerCase());
			rtnLang = jobskService.selectJobskLangList(jobskLangBean);
	    	
			jobskWorkExpBean.setResumeSeq(jobskBean.getResumeSeq().toString());
			jobskWorkExpBean.setLang(locale.getLanguage().toLowerCase());
			rtnWorkExp = jobskService.selectJobskWorkExpList(jobskWorkExpBean);
	    	
			jobskSkillBean.setUserSeq(jobskBean.getUserSeq().toString());
			jobskSkillBean.setLang(locale.getLanguage().toLowerCase());
			rtnSkillTitle = jobskService.selectJobskSkillList(jobskSkillBean);
			
			ArrayList<HashMap<String, Object>> SkillList = new ArrayList<HashMap<String, Object>>();
			jobskSkillParam.setResumeSeq(rtnSkillTitle.getResumeSeq().toString());
			jobskSkillParam.setLang(locale.getLanguage().toLowerCase());
			String grpCd = "";
			jobskSkillDtl.setUserSeq(rtnSkillTitle.getResumeSeq().toString());
			jobskSkillDtl.setLang(locale.getLanguage().toLowerCase());
			String strSkillSubscript = "";
	
			for (int i = 0; i<rtnSkillTitle.getList().size();i++) {
				grpCd = rtnSkillTitle.getList().get(i).getSkillCd().toString().substring(0, 11);
				jobskSkillParam.setSkillCd(grpCd);
				jobskSkillParam.setLang(locale.getLanguage().toLowerCase());
				jobskSkillDtl = (JobskSkillBean) jobskService.selectJobskSkillDtlList(jobskSkillParam);
	
				strSkillSubscript = "";
				if (jobskSkillDtl != null) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					for (int k=0; k<jobskSkillDtl.getList().size();k++) {
						if (k == 0) {
							strSkillSubscript += jobskSkillDtl.getList().get(k).getSkillNm().toString(); 
						} else {
							strSkillSubscript += ", " + jobskSkillDtl.getList().get(k).getSkillNm().toString();
						}
					}
					
					//map.put("skillTitle", rtnSkillTitleData.getList().get(i).getSkillNm().toString());
					//map.put("skillSubscript", strSkillSubscript);
					map.put(jobskSkillDtl.getList().get(i).getSkillNm().toString(), strSkillSubscript);
					
					SkillList.add(map);
				}
				
			}
			jobskSkillBean.setSkillList(SkillList);
			
			jobskRcmdmanBean.setResumeSeq(jobskBean.getResumeSeq().toString());
			jobskRcmdmanBean.setLang(locale.getLanguage().toLowerCase());
			rtnRcmdman = jobskService.selectJobskRcmdmanList(jobskRcmdmanBean);
    	}
    	
		mv.addObject("rtnBase", rtnBase);
		mv.addObject("rtnIsco", rtnIsco.getList());					//Resume Perfer Work Loc Data    	
		mv.addObject("rtnLoc", rtnLoc.getList());					//Resume Perfer Work Loc Data    	
		mv.addObject("rtnSpcEdu", rtnSpcEdu.getList());				//Resume Special Education Data
    	mv.addObject("rtnOtrTrnng", rtnOtrTrnng.getList());			//Resume Other Training Data
    	mv.addObject("rtnLang", rtnLang.getList());					//Resume Language Data
    	mv.addObject("rtnWorkExp", rtnWorkExp.getList());			//Resume Work Exp Data
    	mv.addObject("rtnSkill", jobskSkillBean.getSkillList());	//Resume Skill Data
    	mv.addObject("rtnRcmdman", rtnRcmdman.getList());			//Resume Recommended man Data

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	
    	if (lastPath.equals("selectJobskDtlInfoAjax")) {
    		mv.setViewName("jobsk/jobskDtlInfo" + ".all");
    	} else {
    		mv.setViewName("jobsk/jobskDtlInfoModify" + ".all");
    	}
    	
    	return mv;
	}    
    
    /**
     * Delete Job Seek Request
     * @param jobskBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */ 
    @RequestMapping(value="/deleteJobskRequestAjax")
    public ModelAndView deleteJobskRequestAjax(@ModelAttribute("JobskBean") JobskBean jobskBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	JobskBean resultParam = new JobskBean();

        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();        
        jobskBean.setModUserSeq(sessUser.getUserSeq());
        jobskBean.setLang(locale.getLanguage().toLowerCase());
        
    	try {
        	
			resultParam = jobskService.deleteJobskRequest(jobskBean);
    		
    		if(resultParam.getResultCode() == "0000") {
    			result.put("resultCode", "success");
    			result.put("resultMsg", "Save Success");
    		} else {
    			result.put("resultCode", resultParam.getResultCode());
    			result.put("resultMsg", resultParam.getMsg()); 
    		}
    	        
        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage()); 		
       	} 
    	
  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;   
    }

    /**
     * Update Job Seek Detail Info
     * @param jobskIscoBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */ 
    @RequestMapping(value="/updateJobskDtlInfoAjax")
    public ModelAndView updateJobskDtlInfoAjax(@ModelAttribute("JobskIscoBean") JobskIscoBean jobskIscoBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	JobskIscoBean resultParam = new JobskIscoBean();
    	JobskIscoBean iscoParam = new JobskIscoBean();

    	// login user setting
        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
        jobskIscoBean.setRegUserSeq(sessUser.getUserSeq());
        jobskIscoBean.setModUserSeq(sessUser.getUserSeq());
        jobskIscoBean.setLang(locale.getLanguage().toLowerCase());
        
        iscoParam.setRegUserSeq(sessUser.getUserSeq());
        iscoParam.setModUserSeq(sessUser.getUserSeq());
        iscoParam.setLang(locale.getLanguage().toLowerCase());
        
    	String strIscoCd = "";
    	strIscoCd = jobskIscoBean.getIscoCd();
    	
    	String strJcAgreeStsCd = "";
    	strJcAgreeStsCd = jobskIscoBean.getJcAgreeStsCd().toString();
    	
    	try {
        		
    			if (strIscoCd != null && !strIscoCd.equals("")) {
    				resultParam = jobskService.deleteJobskDtlInfoIsco(jobskIscoBean);
    				
    				if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
    					if (strIscoCd != null && strIscoCd != "") {
    						
    						String[] arrIscoCd = strIscoCd.split(",");   	
    				    	
    						for(int i=0; i<arrIscoCd.length;i++) {
    							iscoParam.setResumeSeq(jobskIscoBean.getResumeSeq().toString());
    							iscoParam.setIscoCd(arrIscoCd[i].toString());
    							iscoParam.setLang(locale.getLanguage().toLowerCase());
    							
    							resultParam = jobskService.insertJobskDtlInfoIsco(iscoParam);
    							
    							if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
    								result.put("resultCode", "success");
    			    				result.put("resultMsg", "Save Success");
    				    		} else {
    				    			result.put("resultCode", resultParam.getResultCode());
    				    			result.put("resultMsg", resultParam.getMsg()); 
    				    		}
    						}     						
    					}
    				} else {
        				result.put("resultCode", "success");
        				result.put("resultMsg", "Save Success");    				
    				}
    			}
    			
    			if (strJcAgreeStsCd != null && !strJcAgreeStsCd.equals("")) {
    				
    				resultParam = jobskService.updateJobskRequestJcAgreeSts(jobskIscoBean);
    				
					if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
						result.put("resultCode", "success");
	    				result.put("resultMsg", "Save Success");
		    		} else {
		    			result.put("resultCode", resultParam.getResultCode());
		    			result.put("resultMsg", resultParam.getMsg()); 
		    		}   				
    			}    			
    	        
        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage()); 		
       	} 
    	
  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;   
    }
    
	/*
	 * Job Seek Vacancy List
	 */
    @RequestMapping("/jobskVacancyList")
	public String jobskVacancyList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "jobsk/jobskVacancyList.all";
	}    
    
    @RequestMapping(value="/selectJobskVacancyListAjax")    
	public ModelAndView selectJobskVacancyListAjax(@ModelAttribute("JobskVacancyBean") JobskVacancyBean jobskVacancyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		
  		jobskVacancyBean.setLang(locale.getLanguage().toLowerCase());
  		
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			jobskVacancyBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			jobskVacancyBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			jobskVacancyBean.setOrderColumn(orderColumn);
  			
  			JobskVacancyBean result = (JobskVacancyBean) jobskService.selectJobskVacancyList(jobskVacancyBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", jobskVacancyBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}
    
    /**
     * Delete Job Seek Vacancy
     * @param JobskVacancyBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */ 
    @RequestMapping(value="/deleteJobskVacancyAjax")
    public ModelAndView deleteJobskVacancyAjax(@ModelAttribute("JobskVacancyBean") JobskVacancyBean jobskVacancyBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	JobskVacancyBean resultParam = new JobskVacancyBean();

        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();        
        jobskVacancyBean.setUserSeq(sessUser.getUserSeq());
        jobskVacancyBean.setLang(locale.getLanguage().toLowerCase());
        
    	try {
        	
			resultParam = jobskService.deleteJobskVacancy(jobskVacancyBean);
    		
    		if(resultParam.getResultCode() == "0000") {
    			result.put("resultCode", "success");
    			result.put("resultMsg", "Save Success");
    		} else {
    			result.put("resultCode", resultParam.getResultCode());
    			result.put("resultMsg", resultParam.getMsg()); 
    		}
    	        
        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage()); 		
       	} 
    	
  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;   
    }

    /**
     * Update Job Seek Vacancy Detail Info
     * @param JobskVacancyBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */ 
    @RequestMapping(value="/updateJobskVacancyDtlInfoAjax")
    public ModelAndView updateJobskVacancyDtlInfoAjax(@ModelAttribute("JobskVacancyBean") JobskVacancyBean jobskVacancyBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	JobskVacancyBean resultParam = new JobskVacancyBean();
    	
    	try {
	    	// login user setting
	        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
	        jobskVacancyBean.setUserSeq(sessUser.getUserSeq());
	        jobskVacancyBean.setLang(locale.getLanguage().toLowerCase());
	        
			resultParam = jobskService.updateJobskVacancyDtlInfo(jobskVacancyBean);
	    				
			if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
				result.put("resultCode", "success");
				result.put("resultMsg", "Save Success");
			} else {
				result.put("resultCode", resultParam.getResultCode());
				result.put("resultMsg", resultParam.getMsg()); 
			}   				
 			    	        
        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage()); 		
       	} 
    	
  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;   
    }
    
    
    /**
     * Job Seek Vacancy Detail Info
     * @param vacancyBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/selectJobskVacancyDtlInfoAjax", "/selectJobskVacancyDtlInfoModifyAjax"}) 
    public ModelAndView selectJobskVacancyDtlInfoAjax(@ModelAttribute("VacancyBean") VacancyBean vacancyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	ModelAndView mv = new ModelAndView();
    	VacancyBean rtnBase = new VacancyBean();
    	VacancyLocBean rtnLoc = new VacancyLocBean();
		VacancyLangBean rtnLang = new VacancyLangBean();
		VacancyPreferntBean rtnPrefernt = new VacancyPreferntBean();
    	
    	rtnBase = vacancyService.selectVacancyDtlInfo(vacancyBean);
    	
    	if(rtnBase != null) {
    		
    		rtnLoc.setVacancySeq(rtnBase.getVacancySeq().toString());
    		rtnLoc.setLang(locale.getLanguage().toLowerCase());
    		rtnLoc = vacancyService.selectVacancyDtlInfoLoc(rtnLoc);

    		rtnLang.setVacancySeq(rtnBase.getVacancySeq().toString());
    		rtnLang.setLang(locale.getLanguage().toLowerCase());
    		rtnLang = vacancyService.selectVacancyDtlInfoLang(rtnLang);

    		rtnPrefernt.setVacancySeq(rtnBase.getVacancySeq().toString());
    		rtnPrefernt.setLang(locale.getLanguage().toLowerCase());
    		rtnPrefernt = vacancyService.selectVacancyDtlInfoPrefernt(rtnPrefernt);
    		
    	}
		
    	mv.addObject("rtnBase", rtnBase);							//Vacancy Detail Info Base Data
    	mv.addObject("rtnLoc", rtnLoc.getList());					//Vacancy Detail Info Location Data  	
    	mv.addObject("rtnLang", rtnLang.getList());					//Vacancy Detail Info Language Data
    	mv.addObject("rtnPrefernt", rtnPrefernt.getList());			//Vacancy Detail Info Preferential Data
    	
    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	
    	if (lastPath.equals("selectJobskVacancyDtlInfoAjax")) {
    		mv.setViewName("jobsk/jobskVacancyDtlInfo" + ".all");
    	} else {
    		mv.setViewName("jobsk/jobskVacancyDtlInfoModify" + ".all");
    	}
    	
    	return mv;
	}     
    
	/*
	 * Job Seek Application List
	 */
    @RequestMapping("/jobskApplicList")
	public String JobskApplicList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "jobsk/jobskApplicList.all";
	}    
    
    @RequestMapping(value="/selectJobskApplicListAjax")    
	public ModelAndView selectJobskApplicListAjax(@ModelAttribute("JobskApplicBean") JobskApplicBean jobskApplicBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		jobskApplicBean.setLang(locale.getLanguage().toLowerCase());
  		
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			jobskApplicBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			jobskApplicBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			jobskApplicBean.setOrderColumn(orderColumn);
  			
  			JobskApplicBean result = (JobskApplicBean) jobskService.selectJobskApplicList(jobskApplicBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", jobskApplicBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}
    
	/*
	 * Job Seek Offer List
	 */
    @RequestMapping("/jobskOfferList")
	public String JobskOfferList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "jobsk/jobskOfferList.all";
	}    
    
    @RequestMapping(value="/selectJobskOfferListAjax")    
	public ModelAndView selectJobskOfferListAjax(@ModelAttribute("JobskOfferBean") JobskOfferBean jobskOfferBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		jobskOfferBean.setLang(locale.getLanguage().toLowerCase());
  		
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			jobskOfferBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			jobskOfferBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			jobskOfferBean.setOrderColumn(orderColumn);
  			
  			JobskOfferBean result = (JobskOfferBean) jobskService.selectJobskOfferList(jobskOfferBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", jobskOfferBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	} 
    
	/*
	 * Job Seek Interview List
	 */
    @RequestMapping("/jobskIntvwList")
	public String JobskInterviewList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "jobsk/jobskIntvwList.all";
	}    
    
    @RequestMapping(value="/selectJobskIntvwListAjax")    
	public ModelAndView selectJobskIntvwListAjax(@ModelAttribute("JobskIntvwBean") JobskIntvwBean jobskIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		jobskIntvwBean.setLang(locale.getLanguage().toLowerCase());
  		
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			jobskIntvwBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			jobskIntvwBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			jobskIntvwBean.setOrderColumn(orderColumn);
  			
  			JobskIntvwBean result = (JobskIntvwBean) jobskService.selectJobskIntvwList(jobskIntvwBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", jobskIntvwBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}     

	/*
	 * Job Seek Video Interview List
	 */
    @RequestMapping("/jobskVdoIntvwList")
	public String JobskVdoInterviewList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "jobsk/jobskVdoIntvwList.all";
	}    
    
    @RequestMapping(value="/selectJobskVdoIntvwListAjax")    
	public ModelAndView selectJobskVdoIntvwListAjax(@ModelAttribute("JobskVdoIntvwBean") JobskVdoIntvwBean jobskVdoIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		jobskVdoIntvwBean.setLang(locale.getLanguage().toLowerCase());
  		
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			jobskVdoIntvwBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			jobskVdoIntvwBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			jobskVdoIntvwBean.setOrderColumn(orderColumn);
  			
  			JobskVdoIntvwBean result = (JobskVdoIntvwBean) jobskService.selectJobskVdoIntvwList(jobskVdoIntvwBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", jobskVdoIntvwBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}
    
    /**
     * Job Seek Video Interview Detail Info
     * @param JobskVdoIntvwBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectJobskVdoIntvwDtlInfoAjax") 
    public ModelAndView selectJobskVdoIntvwDtlInfoAjax(@ModelAttribute("JobskVdoIntvwBean") JobskVdoIntvwBean jobskVdoIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	ModelAndView mv = new ModelAndView();
    	jobskVdoIntvwBean.setLang(locale.getLanguage().toLowerCase());
    	JobskVdoIntvwBean rtnBase = new JobskVdoIntvwBean();
    	
    	rtnBase = jobskService.selectJobskVdoIntvwDtlInfo(jobskVdoIntvwBean);
    	
    	mv.addObject("rtnBase", rtnBase);
    	mv.setViewName("jobsk/jobskVdoIntvwDtlInfo" + ".all");
    	return mv;
	} 
    
    /**
     * Delete Job Seek Video Interview
     * @param JobskVdoIntvwBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */ 
    @RequestMapping(value="/deleteJobskVdoIntvwAjax")
    public ModelAndView deleteJobskVdoIntvwAjax(@ModelAttribute("JobskVdoIntvwBean") JobskVdoIntvwBean jobskVdoIntvwBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	JobskVdoIntvwBean resultParam = new JobskVdoIntvwBean();

        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();        
        jobskVdoIntvwBean.setRegUserSeq(sessUser.getUserSeq());
        jobskVdoIntvwBean.setModUserSeq(sessUser.getUserSeq());
        jobskVdoIntvwBean.setLang(locale.getLanguage().toLowerCase());
        
    	try {
        	
			resultParam = jobskService.deleteJobskVdoIntvw(jobskVdoIntvwBean);
    		
    		if(resultParam.getResultCode() == "0000") {
    			result.put("resultCode", "success");
    			result.put("resultMsg", "Save Success");
    		} else {
    			result.put("resultCode", resultParam.getResultCode());
    			result.put("resultMsg", resultParam.getMsg()); 
    		}
    	        
        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage()); 		
       	} 
    	
  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;   
    }

    /**
     * Update Job Seek Video Interview Detail Info
     * @param JobskVdoIntvwBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */ 
    @RequestMapping(value="/updateJobskVdoIntvwDtlInfoAjax")
    public ModelAndView updateJobskVdoIntvwDtlInfoAjax(@ModelAttribute("JobskVdoIntvwBean") JobskVdoIntvwBean jobskVdoIntvwBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	JobskVdoIntvwBean resultParam = new JobskVdoIntvwBean();
    	
    	try {
	    	// login user setting
	        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
	        jobskVdoIntvwBean.setRegUserSeq(sessUser.getUserSeq());
	        jobskVdoIntvwBean.setModUserSeq(sessUser.getUserSeq());
	        jobskVdoIntvwBean.setLang(locale.getLanguage().toLowerCase());
	        
			resultParam = jobskService.updateJobskVdoIntvwDtlInfo(jobskVdoIntvwBean);
	    				
			if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
				result.put("resultCode", "success");
				result.put("resultMsg", "Save Success");
			} else {
				result.put("resultCode", resultParam.getResultCode());
				result.put("resultMsg", resultParam.getMsg()); 
			}   				
 			    	        
        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage()); 		
       	} 
    	
  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;   
    }    
    
    
}
