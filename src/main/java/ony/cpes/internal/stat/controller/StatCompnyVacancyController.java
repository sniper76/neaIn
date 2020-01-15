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
public class StatCompnyVacancyController extends BaseController{

	private static Log log = LogFactory.getLog(StatCompnyVacancyController.class);

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
    @RequestMapping("/statCompnyVacancyStatus")
	public String statCompnyVacancyStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "stat/statCompnyVacancyStatus.all";
	}
    
    @RequestMapping(value="/statCompnyVacancyTotalStatusDailyAjax")
	public ModelAndView statCompnyVacancyTotalStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String compnyCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("compnyCnt", compnyCnt);
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statCompnyVacancyTotalStatusDaily.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statCompnyVacancyTotalStatusMonthlyAjax")
	public ModelAndView statCompnyVacancyTotalStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String compnyCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("compnyCnt", compnyCnt);
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statCompnyVacancyTotalStatusMonthly.empty");
	  	return mv;
    }     
    
    @RequestMapping(value="/statCompnyVacancyJobCenterStatusDailyAjax")
	public ModelAndView statCompnyVacancyJobCenterStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String compnyCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("jobCenter", jobCenter);
    	request.setAttribute("compnyCnt", compnyCnt);
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statCompnyVacancyJobCenterStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statCompnyVacancyJobCenterStatusMonthlyAjax")
	public ModelAndView statCompnyVacancyJobCenterStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String compnyCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("jobCenter", jobCenter);
    	request.setAttribute("compnyCnt", compnyCnt);
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statCompnyVacancyJobCenterStatusMonthly.empty");
	  	return mv;
    }     

    @RequestMapping(value="/statCompnyVacancyLocationStatusDailyAjax")
	public ModelAndView statCompnyVacancyLocationStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String location = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String compnyCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("location", location);
    	request.setAttribute("compnyCnt", compnyCnt);
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statCompnyVacancyLocationStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statCompnyVacancyLocationStatusMonthlyAjax")
	public ModelAndView statCompnyVacancyLocationStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String location = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String compnyCnt = messageSource.getMessage("field.dic.compny", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("location", location);
    	request.setAttribute("compnyCnt", compnyCnt);
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statCompnyVacancyLocationStatusMonthly.empty");
	  	return mv;
    }
    
}
