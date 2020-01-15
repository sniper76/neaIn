package ony.cpes.internal.stat.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.framework.BaseController;

@RequestMapping("/internal/stat")
@Controller
public class StatJobskController extends BaseController{

	private static Log log = LogFactory.getLog(StatUserController.class);

	@Autowired 
	MessageSource messageSource;

	@Autowired 
	SessionLocaleResolver localeResolver;

	/**
	 * Statistics Member Status
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/statJobskStatus")
	public String statJobskStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "stat/statJobskStatus.all";
	}
    
    @RequestMapping(value="/statJobskTotalStatusDailyAjax")
	public ModelAndView statJobskTotalStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskTotalStatusDaily.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statJobskTotalStatusMonthlyAjax")
	public ModelAndView statJobskTotalStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskTotalStatusMonthly.empty");
	  	return mv;
    }     
    
    @RequestMapping(value="/statJobskJobCenterStatusDailyAjax")
	public ModelAndView statJobskJobCenterStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fJobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fJobCenter", fJobCenter);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskJobCenterStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statJobskJobCenterStatusMonthlyAjax")
	public ModelAndView statJobskJobCenterStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fJobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fJobCenter", fJobCenter);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskJobCenterStatusMonthly.empty");
	  	return mv;
    }     

    @RequestMapping(value="/statJobskLocationStatusDailyAjax")
	public ModelAndView statJobskLocationStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fLocation = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fLocation", fLocation);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskLocationStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statJobskLocationStatusMonthlyAjax")
	public ModelAndView statJobskLocationStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fLocation = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fLocation", fLocation);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskLocationStatusMonthly.empty");
	  	return mv;
    }
    
    @RequestMapping(value="/statJobskAgeStatusDailyAjax")
	public ModelAndView statJobskAgeStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fAge = messageSource.getMessage("field.dic.age", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fAge", fAge);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskAgeStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statJobskAgeStatusMonthlyAjax")
	public ModelAndView statJobskAgeStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fAge = messageSource.getMessage("field.dic.age", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fAge", fAge);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskAgeStatusMonthly.empty");
	  	return mv;
    }    

    @RequestMapping(value="/statJobskEducationStatusDailyAjax")
	public ModelAndView statJobskEducationStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fEducation = messageSource.getMessage("field.dic.education", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fEducation", fEducation);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskEducationStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statJobskEducationStatusMonthlyAjax")
	public ModelAndView statJobskEducationStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fEducation = messageSource.getMessage("field.dic.education", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fEducation", fEducation);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskEducationStatusMonthly.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statJobskOccupationStatusDailyAjax")
	public ModelAndView statJobskOccupationStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fOccupation = messageSource.getMessage("field.dic.isco", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fOccupation", fOccupation);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskOccupationStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statJobskOccupationStatusMonthlyAjax")
	public ModelAndView statJobskOccupationStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fOccupation = messageSource.getMessage("field.dic.isco", null, "Error", localeResolver.resolveLocale(request));
    	String fJobsk = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String fActiveCV = messageSource.getMessage("field.dic.active.cv", null, "Error", localeResolver.resolveLocale(request));
    	String fMale = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String fFemale = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String fDisabled = messageSource.getMessage("field.dic.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String fNonDisabled = messageSource.getMessage("field.dic.non.disabled", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fOccupation", fOccupation);
    	request.setAttribute("fJobsk", fJobsk);
    	request.setAttribute("fActiveCV", fActiveCV);    	
    	request.setAttribute("fMale", fMale);
    	request.setAttribute("fFemale", fFemale);    	
    	request.setAttribute("fDisabled", fDisabled);
    	request.setAttribute("fNonDisabled", fNonDisabled);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobskOccupationStatusMonthly.empty");
	  	return mv;
    }
    
}
