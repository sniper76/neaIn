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
public class StatUserController extends BaseController{

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
    @RequestMapping("/statUserStatus")
	public String statUserStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "stat/statUserStatus.all";
	}
    
    @RequestMapping(value="/statUserTotalStatusDailyAjax")
	public ModelAndView statUserTotalStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String userTotalCnt = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskUserCnt = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String compnyUserCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String insttUserCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("userTotalCnt", userTotalCnt);
    	request.setAttribute("jobskUserCnt", jobskUserCnt);    	
    	request.setAttribute("compnyUserCnt", compnyUserCnt);
    	request.setAttribute("insttUserCnt", insttUserCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	/*
    	mv.addObject("sysLangCd", locale.getLanguage().toLowerCase());
    	mv.addObject("jcCd", jcCd);
    	mv.addObject("startDate", request.getParameter("startDate"));
    	mv.addObject("endDate", request.getParameter("endDate"));
    	mv.addObject("userTotalCnt", userTotalCnt);
    	mv.addObject("jobskUserCnt", jobskUserCnt);    	
    	mv.addObject("compnyUserCnt", compnyUserCnt);
    	mv.addObject("insttUserCnt", insttUserCnt);    	
    	mv.addObject("regDt", regDt);    	
    	*/
    	mv.setViewName("stat/statUserTotalStatusDaily.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statUserTotalStatusMonthlyAjax")
	public ModelAndView statUserTotalStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String userTotalCnt = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskUserCnt = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String compnyUserCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String insttUserCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("userTotalCnt", userTotalCnt);
    	request.setAttribute("jobskUserCnt", jobskUserCnt);    	
    	request.setAttribute("compnyUserCnt", compnyUserCnt);
    	request.setAttribute("insttUserCnt", insttUserCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserTotalStatusMonthly.empty");
	  	return mv;
    }     
    
    @RequestMapping(value="/statUserJobCenterStatusDailyAjax")
	public ModelAndView statPrivateUserStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String userTotalCnt = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskUserCnt = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String compnyUserCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String insttUserCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("jobCenter", jobCenter);
    	request.setAttribute("userTotalCnt", userTotalCnt);
    	request.setAttribute("jobskUserCnt", jobskUserCnt);    	
    	request.setAttribute("compnyUserCnt", compnyUserCnt);
    	request.setAttribute("insttUserCnt", insttUserCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserJobCenterStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statUserJobCenterStatusMonthlyAjax")
	public ModelAndView statUserJobCenterStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String userTotalCnt = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskUserCnt = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String compnyUserCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String insttUserCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("jobCenter", jobCenter);
    	request.setAttribute("userTotalCnt", userTotalCnt);
    	request.setAttribute("jobskUserCnt", jobskUserCnt);    	
    	request.setAttribute("compnyUserCnt", compnyUserCnt);
    	request.setAttribute("insttUserCnt", insttUserCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserJobCenterStatusMonthly.empty");
	  	return mv;
    }     

    @RequestMapping(value="/statUserLocationStatusDailyAjax")
	public ModelAndView statUserLocationStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String location = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String userTotalCnt = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskUserCnt = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String compnyUserCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String insttUserCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("location", location);
    	request.setAttribute("userTotalCnt", userTotalCnt);
    	request.setAttribute("jobskUserCnt", jobskUserCnt);    	
    	request.setAttribute("compnyUserCnt", compnyUserCnt);
    	request.setAttribute("insttUserCnt", insttUserCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserLocationStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statUserLocationStatusMonthlyAjax")
	public ModelAndView statUserLocationStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String location = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String userTotalCnt = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskUserCnt = messageSource.getMessage("bulletin.dic.pms.jobsk", null, "Error", localeResolver.resolveLocale(request));
    	String compnyUserCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String insttUserCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("location", location);
    	request.setAttribute("userTotalCnt", userTotalCnt);
    	request.setAttribute("jobskUserCnt", jobskUserCnt);    	
    	request.setAttribute("compnyUserCnt", compnyUserCnt);
    	request.setAttribute("insttUserCnt", insttUserCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserLocationStatusMonthly.empty");
	  	return mv;
    }
    
    @RequestMapping(value="/statUserJobskStatusDailyAjax")
	public ModelAndView statUserJobskStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fTotal = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String fAcitve = messageSource.getMessage("field.dic.active", null, "Error", localeResolver.resolveLocale(request));
    	String fSecession = messageSource.getMessage("field.dic.secession", null, "Error", localeResolver.resolveLocale(request));
    	String fDormency = messageSource.getMessage("field.dic.dormency", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fTotal", fTotal);
    	request.setAttribute("fAcitve", fAcitve);
    	request.setAttribute("fSecession", fSecession);    	
    	request.setAttribute("fDormency", fDormency);   	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserJobskStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statUserJobskStatusMonthlyAjax")
	public ModelAndView statUserJobskStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fTotal = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String fAcitve = messageSource.getMessage("field.dic.active", null, "Error", localeResolver.resolveLocale(request));
    	String fSecession = messageSource.getMessage("field.dic.secession", null, "Error", localeResolver.resolveLocale(request));
    	String fDormency = messageSource.getMessage("field.dic.dormency", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fTotal", fTotal);
    	request.setAttribute("fAcitve", fAcitve);
    	request.setAttribute("fSecession", fSecession);    	
    	request.setAttribute("fDormency", fDormency);   	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserJobskStatusMonthly.empty");
	  	return mv;
    }    

    @RequestMapping(value="/statUserCompnyStatusDailyAjax")
	public ModelAndView statUserCompnyStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fTotal = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String fActive = messageSource.getMessage("field.dic.active", null, "Error", localeResolver.resolveLocale(request));
    	String fSecession = messageSource.getMessage("field.dic.secession", null, "Error", localeResolver.resolveLocale(request));
    	String fDormency = messageSource.getMessage("field.dic.dormency", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
            jcCd = "";
    	}    	
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fTotal", fTotal);
    	request.setAttribute("fActive", fActive);
    	request.setAttribute("fSecession", fSecession);
    	request.setAttribute("fDormency", fDormency);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserCompnyStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statUserCompnyStatusMonthlyAjax")
	public ModelAndView statUserCompnyStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fTotal = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String fActive = messageSource.getMessage("field.dic.active", null, "Error", localeResolver.resolveLocale(request));
    	String fSecession = messageSource.getMessage("field.dic.secession", null, "Error", localeResolver.resolveLocale(request));
    	String fDormency = messageSource.getMessage("field.dic.dormency", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
            jcCd = "";
    	}    	
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fTotal", fTotal);
    	request.setAttribute("fActive", fActive);
    	request.setAttribute("fSecession", fSecession);
    	request.setAttribute("fDormency", fDormency);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserCompnyStatusMonthly.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statUserInsttStatusDailyAjax")
	public ModelAndView statUserInsttStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fTotal = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String fActive = messageSource.getMessage("field.dic.active", null, "Error", localeResolver.resolveLocale(request));
    	String fSecession = messageSource.getMessage("field.dic.secession", null, "Error", localeResolver.resolveLocale(request));
    	String fDormency = messageSource.getMessage("field.dic.dormency", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
            jcCd = "";
    	}    	
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fTotal", fTotal);
    	request.setAttribute("fActive", fActive);
    	request.setAttribute("fSecession", fSecession);
    	request.setAttribute("fDormency", fDormency);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserInsttStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statUserInsttStatusMonthlyAjax")
	public ModelAndView statUserInsttStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String fTotal = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String fActive = messageSource.getMessage("field.dic.active", null, "Error", localeResolver.resolveLocale(request));
    	String fSecession = messageSource.getMessage("field.dic.secession", null, "Error", localeResolver.resolveLocale(request));
    	String fDormency = messageSource.getMessage("field.dic.dormency", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
            jcCd = "";
    	}    	
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("fTotal", fTotal);
    	request.setAttribute("fActive", fActive);
    	request.setAttribute("fSecession", fSecession);
    	request.setAttribute("fDormency", fDormency);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase()); 	
    	
    	mv.setViewName("stat/statUserInsttStatusMonthly.empty");
	  	return mv;
    }  
    
}
