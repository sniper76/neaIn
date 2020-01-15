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
public class StatVacancyController extends BaseController{

	private static Log log = LogFactory.getLog(StatVacancyController.class);

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
    @RequestMapping("/statVacancyStatus")
	public String statVacancyStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "stat/statVacancyStatus.all";
	}
    
    @RequestMapping(value="/statVacancyTotalStatusDailyAjax")
	public ModelAndView statVacancyTotalStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String offerCnt = messageSource.getMessage("field.dic.offer", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String maleCnt = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String femaleCnt = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("applicCnt", applicCnt);
    	request.setAttribute("offerCnt", offerCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statVacancyTotalStatusDaily.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statVacancyTotalStatusMonthlyAjax")
	public ModelAndView statVacancyTotalStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String offerCnt = messageSource.getMessage("field.dic.offer", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String maleCnt = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String femaleCnt = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("applicCnt", applicCnt);
    	request.setAttribute("offerCnt", offerCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statVacancyTotalStatusMonthly.empty");
	  	return mv;
    }     
    
    @RequestMapping(value="/statVacancyJobCenterStatusDailyAjax")
	public ModelAndView statVacancyJobCenterStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String offerCnt = messageSource.getMessage("field.dic.offer", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String maleCnt = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String femaleCnt = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("jobCenter", jobCenter);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("applicCnt", applicCnt);
    	request.setAttribute("offerCnt", offerCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statVacancyJobCenterStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statVacancyJobCenterStatusMonthlyAjax")
	public ModelAndView statVacancyJobCenterStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String offerCnt = messageSource.getMessage("field.dic.offer", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String maleCnt = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String femaleCnt = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("jobCenter", jobCenter);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("applicCnt", applicCnt);
    	request.setAttribute("offerCnt", offerCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statVacancyJobCenterStatusMonthly.empty");
	  	return mv;
    }     

    @RequestMapping(value="/statVacancyLocationStatusDailyAjax")
	public ModelAndView statVacancyLocationStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String location = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String offerCnt = messageSource.getMessage("field.dic.offer", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String maleCnt = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String femaleCnt = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("location", location);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("applicCnt", applicCnt);
    	request.setAttribute("offerCnt", offerCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statVacancyLocationStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statVacancyLocationStatusMonthlyAjax")
	public ModelAndView statVacancyLocationStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String location = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.dic.compny.vccy", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applic", null, "Error", localeResolver.resolveLocale(request));
    	String offerCnt = messageSource.getMessage("field.dic.offer", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String maleCnt = messageSource.getMessage("field.dic.male", null, "Error", localeResolver.resolveLocale(request));
    	String femaleCnt = messageSource.getMessage("field.dic.female", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("location", location);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("applicCnt", applicCnt);
    	request.setAttribute("offerCnt", offerCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statVacancyLocationStatusMonthly.empty");
	  	return mv;
    }
    
}
