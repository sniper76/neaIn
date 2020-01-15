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
public class StatInsttTrnngController extends BaseController{

	private static Log log = LogFactory.getLog(StatInsttTrnngController.class);

	@Autowired 
	MessageSource messageSource;

	@Autowired 
	SessionLocaleResolver localeResolver;

    @RequestMapping("/statInsttTrnngStatus")
	public String statInsttTrnngStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "stat/statInsttTrnngStatus.all";
	}
    
    @RequestMapping(value="/statInsttTrnngTotalStatusDailyAjax")
	public ModelAndView statInsttTrnngTotalStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String insttCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String activeInsttCnt = messageSource.getMessage("field.dic.active.instt", null, "Error", localeResolver.resolveLocale(request));
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String trnngProgCnt = messageSource.getMessage("field.dic.trnng.prog", null, "Error", localeResolver.resolveLocale(request));
    	String scholarshipProgCnt = messageSource.getMessage("field.dic.trnng.scholarship", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("insttCnt", insttCnt);    	
    	request.setAttribute("activeInsttCnt", activeInsttCnt);
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("trnngProgCnt", trnngProgCnt);    	
    	request.setAttribute("scholarshipProgCnt", scholarshipProgCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statInsttTrnngTotalStatusDaily.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statInsttTrnngTotalStatusMonthlyAjax")
	public ModelAndView statInsttTrnngTotalStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String insttCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String activeInsttCnt = messageSource.getMessage("field.dic.active.instt", null, "Error", localeResolver.resolveLocale(request));
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String trnngProgCnt = messageSource.getMessage("field.dic.trnng.prog", null, "Error", localeResolver.resolveLocale(request));
    	String scholarshipProgCnt = messageSource.getMessage("field.dic.trnng.scholarship", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("insttCnt", insttCnt);    	
    	request.setAttribute("activeInsttCnt", activeInsttCnt);
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("trnngProgCnt", trnngProgCnt);    	
    	request.setAttribute("scholarshipProgCnt", scholarshipProgCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statInsttTrnngTotalStatusMonthly.empty");
	  	return mv;
    }     
    
    @RequestMapping(value="/statInsttTrnngJobCenterStatusDailyAjax")
	public ModelAndView statInsttTrnngJobCenterStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String insttCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String activeInsttCnt = messageSource.getMessage("field.dic.active.instt", null, "Error", localeResolver.resolveLocale(request));
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String trnngProgCnt = messageSource.getMessage("field.dic.trnng.prog", null, "Error", localeResolver.resolveLocale(request));
    	String scholarshipProgCnt = messageSource.getMessage("field.dic.trnng.scholarship", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("jobCenter", jobCenter);    	
    	request.setAttribute("insttCnt", insttCnt);    	
    	request.setAttribute("activeInsttCnt", activeInsttCnt);
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("trnngProgCnt", trnngProgCnt);    	
    	request.setAttribute("scholarshipProgCnt", scholarshipProgCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statInsttTrnngJobCenterStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statInsttTrnngJobCenterStatusMonthlyAjax")
	public ModelAndView statInsttTrnngJobCenterStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String insttCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String activeInsttCnt = messageSource.getMessage("field.dic.active.instt", null, "Error", localeResolver.resolveLocale(request));
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String trnngProgCnt = messageSource.getMessage("field.dic.trnng.prog", null, "Error", localeResolver.resolveLocale(request));
    	String scholarshipProgCnt = messageSource.getMessage("field.dic.trnng.scholarship", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("jobCenter", jobCenter);    	
    	request.setAttribute("insttCnt", insttCnt);    	
    	request.setAttribute("activeInsttCnt", activeInsttCnt);
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("trnngProgCnt", trnngProgCnt);    	
    	request.setAttribute("scholarshipProgCnt", scholarshipProgCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statInsttTrnngJobCenterStatusMonthly.empty");
	  	return mv;
    }     

    @RequestMapping(value="/statInsttTrnngLocationStatusDailyAjax")
	public ModelAndView statInsttTrnngLocationStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String location = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String insttCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String activeInsttCnt = messageSource.getMessage("field.dic.active.instt", null, "Error", localeResolver.resolveLocale(request));
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String trnngProgCnt = messageSource.getMessage("field.dic.trnng.prog", null, "Error", localeResolver.resolveLocale(request));
    	String scholarshipProgCnt = messageSource.getMessage("field.dic.trnng.scholarship", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("location", location);    	
    	request.setAttribute("insttCnt", insttCnt);    	
    	request.setAttribute("activeInsttCnt", activeInsttCnt);
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("trnngProgCnt", trnngProgCnt);    	
    	request.setAttribute("scholarshipProgCnt", scholarshipProgCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statInsttTrnngLocationStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statInsttTrnngLocationStatusMonthlyAjax")
	public ModelAndView statInsttTrnngLocationStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String location = messageSource.getMessage("field.dic.area", null, "Error", localeResolver.resolveLocale(request));
    	String insttCnt = messageSource.getMessage("field.dic.instt", null, "Error", localeResolver.resolveLocale(request));
    	String activeInsttCnt = messageSource.getMessage("field.dic.active.instt", null, "Error", localeResolver.resolveLocale(request));
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String trnngProgCnt = messageSource.getMessage("field.dic.trnng.prog", null, "Error", localeResolver.resolveLocale(request));
    	String scholarshipProgCnt = messageSource.getMessage("field.dic.trnng.scholarship", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("location", location);    	
    	request.setAttribute("insttCnt", insttCnt);    	
    	request.setAttribute("activeInsttCnt", activeInsttCnt);
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("trnngProgCnt", trnngProgCnt);    	
    	request.setAttribute("scholarshipProgCnt", scholarshipProgCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statInsttTrnngLocationStatusMonthly.empty");
	  	return mv;
    }
    
}
