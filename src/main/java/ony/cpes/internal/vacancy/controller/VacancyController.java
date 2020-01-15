package ony.cpes.internal.vacancy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.vacancy.bean.VacancyBean;
import ony.cpes.internal.vacancy.bean.VacancyLocBean;
import ony.cpes.internal.vacancy.bean.VacancyLangBean;
import ony.cpes.internal.vacancy.bean.VacancyPreferntBean;

import ony.cpes.internal.vacancy.service.VacancyService;

import ony.framework.BaseController;

@RequestMapping("/internal/vacancy")
@Controller
public class VacancyController extends BaseController{

	private static Log log = LogFactory.getLog(VacancyController.class);
  
	@Autowired
	private VacancyService vacancyService;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;	

    /*
     * Vacancy Detail Info
     */   
    @RequestMapping(value="/selectVacancyDtlInfoAjax") 
    public ModelAndView selectVacancyDtlInfoAjax(@ModelAttribute("VacancyBean") VacancyBean vacancyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	ModelAndView mv = new ModelAndView();
    	VacancyBean rtnBase = new VacancyBean();
    	VacancyLocBean rtnLoc = new VacancyLocBean();
		VacancyLangBean rtnLang = new VacancyLangBean();
		VacancyPreferntBean rtnPrefernt = new VacancyPreferntBean();
		
		vacancyBean.setLang(locale.getLanguage().toLowerCase());
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
    	mv.setViewName("vacancy/vacancyDtlInfo" + ".empty");
    	return mv;
	} 

}
