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
public class StatNEATrnngController extends BaseController{

	private static Log log = LogFactory.getLog(StatNEATrnngController.class);

	@Autowired 
	MessageSource messageSource;

	@Autowired 
	SessionLocaleResolver localeResolver;

    @RequestMapping("/statNEATrnngStatus")
	public String statNEATrnngStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "stat/statNEATrnngStatus.all";
	}
    
    @RequestMapping(value="/statNEATrnngTotalStatusDailyAjax")
	public ModelAndView statNEATrnngTotalStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String preEmploymentCnt = messageSource.getMessage("field.dic.pre.employment", null, "Error", localeResolver.resolveLocale(request));
    	String softSkillCnt = messageSource.getMessage("field.dic.soft.skill", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applicantNm", null, "Error", localeResolver.resolveLocale(request));
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
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("preEmploymentCnt", preEmploymentCnt);
    	request.setAttribute("softSkillCnt", softSkillCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statNEATrnngTotalStatusDaily.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statNEATrnngTotalStatusMonthlyAjax")
	public ModelAndView statNEATrnngTotalStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String preEmploymentCnt = messageSource.getMessage("field.dic.pre.employment", null, "Error", localeResolver.resolveLocale(request));
    	String softSkillCnt = messageSource.getMessage("field.dic.soft.skill", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applicantNm", null, "Error", localeResolver.resolveLocale(request));
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
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("preEmploymentCnt", preEmploymentCnt);
    	request.setAttribute("softSkillCnt", softSkillCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statNEATrnngTotalStatusMonthly.empty");
	  	return mv;
    }     
    
    @RequestMapping(value="/statNEATrnngJobCenterStatusDailyAjax")
	public ModelAndView statNEATrnngJobCenterStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String preEmploymentCnt = messageSource.getMessage("field.dic.pre.employment", null, "Error", localeResolver.resolveLocale(request));
    	String softSkillCnt = messageSource.getMessage("field.dic.soft.skill", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applicantNm", null, "Error", localeResolver.resolveLocale(request));
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
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("preEmploymentCnt", preEmploymentCnt);
    	request.setAttribute("softSkillCnt", softSkillCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statNEATrnngJobCenterStatusDaily.empty");
	  	return mv;
    }  
    
    @RequestMapping(value="/statNEATrnngJobCenterStatusMonthlyAjax")
	public ModelAndView statNEATrnngJobCenterStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String jobCenter = messageSource.getMessage("field.dic.jobcntr", null, "Error", localeResolver.resolveLocale(request));
    	String totalTrnngCnt = messageSource.getMessage("field.dic.total.trnng", null, "Error", localeResolver.resolveLocale(request));
    	String preEmploymentCnt = messageSource.getMessage("field.dic.pre.employment", null, "Error", localeResolver.resolveLocale(request));
    	String softSkillCnt = messageSource.getMessage("field.dic.soft.skill", null, "Error", localeResolver.resolveLocale(request));
    	String recrumtCnt = messageSource.getMessage("field.dic.recrumt.memb", null, "Error", localeResolver.resolveLocale(request));
    	String applicCnt = messageSource.getMessage("field.dic.applicantNm", null, "Error", localeResolver.resolveLocale(request));
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
    	request.setAttribute("totalTrnngCnt", totalTrnngCnt);    	
    	request.setAttribute("preEmploymentCnt", preEmploymentCnt);
    	request.setAttribute("softSkillCnt", softSkillCnt);    	
    	request.setAttribute("recrumtCnt", recrumtCnt);    	
    	request.setAttribute("applicCnt", applicCnt);    	
    	request.setAttribute("maleCnt", maleCnt);    	
    	request.setAttribute("femaleCnt", femaleCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statNEATrnngJobCenterStatusMonthly.empty");
	  	return mv;
    }     
    
}
