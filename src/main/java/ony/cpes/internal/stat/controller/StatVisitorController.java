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
public class StatVisitorController extends BaseController{

	private static Log log = LogFactory.getLog(StatVisitorController.class);

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
    @RequestMapping("/statVisitorStatus")
	public String statVisitorStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "stat/statVisitorStatus.all";
	}
    
    @RequestMapping(value="/statVisitorStatusDailyAjax")
	public ModelAndView statVisitorStatusDailyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalVisitorCnt = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String totalPcCnt = messageSource.getMessage("field.dic.total.pc.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String totalMobileCnt = messageSource.getMessage("field.dic.total.mobile.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String guestCnt = messageSource.getMessage("field.dic.guest.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String normalCnt = messageSource.getMessage("field.dic.normal.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String stditCnt = messageSource.getMessage("field.dic.stdit.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String compnyCnt = messageSource.getMessage("field.dic.compny.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String insttCnt = messageSource.getMessage("field.dic.instt.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("totalVisitorCnt", totalVisitorCnt);
    	request.setAttribute("totalPcCnt", totalPcCnt);    	
    	request.setAttribute("totalMobileCnt", totalMobileCnt);
    	request.setAttribute("guestCnt", guestCnt);    	
    	request.setAttribute("normalCnt", normalCnt);    	
    	request.setAttribute("stditCnt", stditCnt);    	
    	request.setAttribute("compnyCnt", compnyCnt);    	
    	request.setAttribute("insttCnt", insttCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statVisitorStatusDaily.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/statVisitorStatusMonthlyAjax")
	public ModelAndView statVisitorStatusMonthlyAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String totalVisitorCnt = messageSource.getMessage("field.dic.total.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String totalPcCnt = messageSource.getMessage("field.dic.total.pc.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String totalMobileCnt = messageSource.getMessage("field.dic.total.mobile.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String guestCnt = messageSource.getMessage("field.dic.guest.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String normalCnt = messageSource.getMessage("field.dic.normal.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String stditCnt = messageSource.getMessage("field.dic.stdit.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String compnyCnt = messageSource.getMessage("field.dic.compny.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String insttCnt = messageSource.getMessage("field.dic.instt.visitor.cnt", null, "Error", localeResolver.resolveLocale(request));
    	String regDt = messageSource.getMessage("field.dic.date", null, "Error", localeResolver.resolveLocale(request));
    	
    	request.setAttribute("startDate", request.getParameter("startDate"));
    	request.setAttribute("endDate", request.getParameter("endDate"));
    	request.setAttribute("totalVisitorCnt", totalVisitorCnt);
    	request.setAttribute("totalPcCnt", totalPcCnt);    	
    	request.setAttribute("totalMobileCnt", totalMobileCnt);
    	request.setAttribute("guestCnt", guestCnt);    	
    	request.setAttribute("normalCnt", normalCnt);    	
    	request.setAttribute("stditCnt", stditCnt);    	
    	request.setAttribute("compnyCnt", compnyCnt);    	
    	request.setAttribute("insttCnt", insttCnt);    	
    	request.setAttribute("regDt", regDt);    	
    	request.setAttribute("sysLangCd", locale.getLanguage().toLowerCase());
    	
    	mv.setViewName("stat/statVisitorStatusMonthly.empty");
	  	return mv;
    }
    
}
