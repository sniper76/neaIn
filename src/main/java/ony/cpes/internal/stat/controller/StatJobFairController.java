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
public class StatJobFairController extends BaseController{

	private static Log log = LogFactory.getLog(StatJobFairController.class);

	@Autowired 
	MessageSource messageSource;

	@Autowired 
	SessionLocaleResolver localeResolver;

    @RequestMapping("/statJobFairStatus")
	public String statJobFairStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "stat/statJobFairStatus.all";
	}
    
    @RequestMapping(value="/statJobFairNCPFStatusDailyAjax")
	public ModelAndView statJobFairNCPFStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalJobFairCnt = messageSource.getMessage("field.dic.total.jobfair.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String compnyPatcptnCnt = messageSource.getMessage("field.dic.jobfair.compny.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String insttPatcptnCnt = messageSource.getMessage("field.dic.jobfair.instt.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskCnt = messageSource.getMessage("field.oper.list.jobsk.title", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.oper.list.jobsk.cnt.title", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String boothCnt = messageSource.getMessage("field.dic.jobfair.booth.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("totalJobFairCnt", totalJobFairCnt);    	
    	request.setAttribute("compnyPatcptnCnt", compnyPatcptnCnt);
    	request.setAttribute("insttPatcptnCnt", insttPatcptnCnt);    	
    	request.setAttribute("jobskCnt", jobskCnt);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("boothCnt", boothCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobFairNCPFStatusDaily.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statJobFairNCPFStatusMonthlyAjax")
	public ModelAndView statJobFairNCPFStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalJobFairCnt = messageSource.getMessage("field.dic.total.jobfair.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String compnyPatcptnCnt = messageSource.getMessage("field.dic.jobfair.compny.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String insttPatcptnCnt = messageSource.getMessage("field.dic.jobfair.instt.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskCnt = messageSource.getMessage("field.oper.list.jobsk.title", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.oper.list.jobsk.cnt.title", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String boothCnt = messageSource.getMessage("field.dic.jobfair.booth.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("totalJobFairCnt", totalJobFairCnt);    	
    	request.setAttribute("compnyPatcptnCnt", compnyPatcptnCnt);
    	request.setAttribute("insttPatcptnCnt", insttPatcptnCnt);    	
    	request.setAttribute("jobskCnt", jobskCnt);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("boothCnt", boothCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobFairNCPFStatusMonthly.empty");
	  	return mv;
    }     
    
    @RequestMapping(value="/statJobFairPCPFStatusDailyAjax")
	public ModelAndView statJobFairPCPFStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalJobFairCnt = messageSource.getMessage("field.dic.total.jobfair.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String compnyPatcptnCnt = messageSource.getMessage("field.dic.jobfair.compny.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String insttPatcptnCnt = messageSource.getMessage("field.dic.jobfair.instt.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskCnt = messageSource.getMessage("field.oper.list.jobsk.title", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.oper.list.jobsk.cnt.title", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String boothCnt = messageSource.getMessage("field.dic.jobfair.booth.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("totalJobFairCnt", totalJobFairCnt);    	
    	request.setAttribute("compnyPatcptnCnt", compnyPatcptnCnt);
    	request.setAttribute("insttPatcptnCnt", insttPatcptnCnt);    	
    	request.setAttribute("jobskCnt", jobskCnt);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("boothCnt", boothCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobFairPCPFStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statJobFairPCPFStatusMonthlyAjax")
	public ModelAndView statJobFairPCPFStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalJobFairCnt = messageSource.getMessage("field.dic.total.jobfair.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String compnyPatcptnCnt = messageSource.getMessage("field.dic.jobfair.compny.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String insttPatcptnCnt = messageSource.getMessage("field.dic.jobfair.instt.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskCnt = messageSource.getMessage("field.oper.list.jobsk.title", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.oper.list.jobsk.cnt.title", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String boothCnt = messageSource.getMessage("field.dic.jobfair.booth.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("totalJobFairCnt", totalJobFairCnt);    	
    	request.setAttribute("compnyPatcptnCnt", compnyPatcptnCnt);
    	request.setAttribute("insttPatcptnCnt", insttPatcptnCnt);    	
    	request.setAttribute("jobskCnt", jobskCnt);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("boothCnt", boothCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobFairPCPFStatusMonthly.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statJobFairEmploymentForumStatusDailyAjax")
	public ModelAndView statJobFairEmploymentForumStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalJobFairCnt = messageSource.getMessage("field.dic.total.jobfair.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String compnyPatcptnCnt = messageSource.getMessage("field.dic.jobfair.compny.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String insttPatcptnCnt = messageSource.getMessage("field.dic.jobfair.instt.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskCnt = messageSource.getMessage("field.oper.list.jobsk.title", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.oper.list.jobsk.cnt.title", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String boothCnt = messageSource.getMessage("field.dic.jobfair.booth.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("totalJobFairCnt", totalJobFairCnt);    	
    	request.setAttribute("compnyPatcptnCnt", compnyPatcptnCnt);
    	request.setAttribute("insttPatcptnCnt", insttPatcptnCnt);    	
    	request.setAttribute("jobskCnt", jobskCnt);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("boothCnt", boothCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobFairEmploymentForumStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statJobFairEmploymentForumStatusMonthlyAjax")
	public ModelAndView statJobFairEmploymentForumStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalJobFairCnt = messageSource.getMessage("field.dic.total.jobfair.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String compnyPatcptnCnt = messageSource.getMessage("field.dic.jobfair.compny.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String insttPatcptnCnt = messageSource.getMessage("field.dic.jobfair.instt.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String jobskCnt = messageSource.getMessage("field.oper.list.jobsk.title", null, "Error", localeResolver.resolveLocale(request));
    	String vacancyCnt = messageSource.getMessage("field.oper.list.jobsk.cnt.title", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String boothCnt = messageSource.getMessage("field.dic.jobfair.booth.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String passCnt = messageSource.getMessage("field.dic.pass.prsn", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	String jcCd = request.getParameter("jcCd");
    	if (jcCd == null || "".equals(jcCd)) {
    		jcCd = "";
    	}
    	request.setAttribute("jcCd", jcCd);
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("totalJobFairCnt", totalJobFairCnt);    	
    	request.setAttribute("compnyPatcptnCnt", compnyPatcptnCnt);
    	request.setAttribute("insttPatcptnCnt", insttPatcptnCnt);    	
    	request.setAttribute("jobskCnt", jobskCnt);    	
    	request.setAttribute("vacancyCnt", vacancyCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("boothCnt", boothCnt);    	
    	request.setAttribute("passCnt", passCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statJobFairEmploymentForumStatusMonthly.empty");
	  	return mv;
    }      
    
}
