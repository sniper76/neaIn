package ony.cpes.internal.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

import ony.cpes.internal.user.bean.UserCmpnyBean;
import ony.cpes.internal.user.bean.UserCmpnyIsicBean;
import ony.cpes.internal.user.bean.UserCmpnyCommonBean;
import ony.cpes.internal.user.bean.UserCmpnyVccyBean;
import ony.cpes.internal.user.bean.UserCmpnyAplcBean;
import ony.cpes.internal.user.bean.UserCmpnyOfferBean;
import ony.cpes.internal.user.bean.UserCmpnyIntvwBean;
import ony.cpes.internal.user.bean.UserCmpnyFairBean;
import ony.cpes.internal.user.service.UserCmpnyService;
import ony.framework.BaseController;

@RequestMapping("/internal/user")
@Controller
public class UserCmpnyController extends BaseController{

	private static Log log = LogFactory.getLog(UserCmpnyController.class);
  
	@Autowired
	private UserCmpnyService userCmpnyService;

	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;

	/**
	 * Screen by Company User
	 * @param userCmpnyBean
	 * @param locale
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/userCmpnyInfoList") 
    public ModelAndView userCmpnyInfoList(@ModelAttribute("UserCmpnyBean") UserCmpnyBean userCmpnyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	UserCmpnyIsicBean param = new UserCmpnyIsicBean();
  		param.setLang(locale.getLanguage().toLowerCase());
  		UserCmpnyIsicBean rtnIsicCdList = (UserCmpnyIsicBean) userCmpnyService.selectIsicCdList(param);
  		
  		mv.addObject("rtnIsic", rtnIsicCdList.getList());
	  	mv.setViewName("user/userCmpnyInfoList.all");
    	return mv;
	}
    
    /**
     * inquiry company user list Ajax
     * @param userCmpnyBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyInfoListAjax")    
	public ModelAndView selectUserCmpnyInfoListAjax(@ModelAttribute("userCmpnyBean") UserCmpnyBean userCmpnyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		userCmpnyBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			userCmpnyBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userCmpnyBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userCmpnyBean.setOrderColumn(orderColumn);
  			
  			UserCmpnyBean result = (UserCmpnyBean) userCmpnyService.selectUserCmpnyInfoListAjax(userCmpnyBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userCmpnyBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
  		mv.setViewName("jsonView");
	  	return mv;  
	}

    /**
     * 
     * @param userCmpnyBean
     * @param locale
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/deleteUserCmpnyInfo")
    public ModelAndView deleteUserCmpnyInfoAjax(@ModelAttribute("UserCmpnyBean") UserCmpnyBean userCmpnyBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	UserCmpnyBean resultParam = new UserCmpnyBean();
    	int selectedCnt = userCmpnyBean.getSelectedList().size();
    	
    	for (int i=0; i<selectedCnt; i++) {
    		
    		userCmpnyBean.setUserSeq(userCmpnyBean.getSelectedList().get(i).toString());
    		userCmpnyBean.setLang(locale.getLanguage().toLowerCase());
        	try {
        		
        		resultParam = userCmpnyService.deleteUserCmpnyInfoAjax(userCmpnyBean);
        		
        		if(resultParam.getResultCode() == "0000")
    			result.put("resultCode", "success");
    			result.put("resultMsg", "Delete Success");
    	        
        	} catch (Exception e) {
    			result.put("resultCode", resultParam.getResultCode());
    			result.put("resultMsg", e.getCause().getMessage()); 		
        	} 
    	}

  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;  
    } 
    
    /**
     * screen info by Company user
     * @param userCmpnyBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     * IN_US_020102
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoMain") 
    public ModelAndView selectUserCmpnyDtlInfoMain(@ModelAttribute("UserCmpnyBean") UserCmpnyBean userCmpnyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	userCmpnyBean.setLang(locale.getLanguage().toLowerCase());
    	UserCmpnyBean resultUserMain = (UserCmpnyBean) userCmpnyService.selectUserCmpnyDtlInfoMain(userCmpnyBean);
    	resultUserMain.setPreviousUrl(userCmpnyBean.getPreviousUrl());
		
    	mv.addObject("rtnMainData", resultUserMain);
    	mv.setViewName("user/userCmpnyDtlInfoMain" + ".all");
    	return mv;
	}
    
    /**
     * detail company user info
     * @param userCmpnyBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     * IN_US_020102
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoBaseAjax") 
    public ModelAndView selectUserCmpnyDtlInfoBaseAjax(@ModelAttribute("UserCmpnyBean") UserCmpnyBean userCmpnyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	userCmpnyBean.setLang(locale.getLanguage().toLowerCase());
    	UserCmpnyBean resultUserBase = (UserCmpnyBean) userCmpnyService.selectUserCmpnyDtlInfoBaseAjax(userCmpnyBean);
		
    	mv.addObject("rtnBaseData", resultUserBase);
    	mv.setViewName("user/userCmpnyDtlInfoBase" + ".empty");
    	return mv;
	}
    
    /**
     * inquiry company profile (IN_US_020103)
     * @param userCmpnyBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoProfileAjax") 
    public ModelAndView selectUserCmpnyDtlInfoProfileAjax(@ModelAttribute("UserCmpnyBean") UserCmpnyBean userCmpnyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	userCmpnyBean.setLang(locale.getLanguage().toLowerCase());
    	UserCmpnyBean resultUserProf = (UserCmpnyBean) userCmpnyService.selectUserCmpnyDtlInfoProfileAjax(userCmpnyBean);
    	//UserCmpnyBean resultUserImg = (UserCmpnyBean) userCmpnyService.selectUserCmpnyDtlInfoImgAjax(userCmpnyBean);
		
    	mv.addObject("rtnProfData", resultUserProf);
    	//mv.addObject("rtnImgData", resultUserImg);
    	mv.setViewName("user/userCmpnyDtlInfoProfile" + ".empty");
    	return mv;
	}      

    /**
     * Screen by Vacancy info in detail of company
     * @param userCmpnyVccyBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoVccyListMainAjax") 
    public ModelAndView selectUserCmpnyDtlInfoVccyListMainAjax(@ModelAttribute("UserCmpnyVccyBean") UserCmpnyVccyBean userCmpnyVccyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
		
    	mv.addObject("rtnCompnySeq", userCmpnyVccyBean.getCompnySeq());			//Resume Base(Human) Data
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());		//
    	mv.setViewName("user/userCmpnyDtlInfoVccyList" + ".empty");
    	return mv;
	}
    
    /**
     * inquiry by Vacancy info List in Company
     * @param userCmpnyVccyBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoVccyListSubAjax")    
	public ModelAndView selectUserCmpnyDtlInfoVccyListSubAjax(@ModelAttribute("UserCmpnyVccyBean") UserCmpnyVccyBean userCmpnyVccyBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		userCmpnyVccyBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			userCmpnyVccyBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userCmpnyVccyBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userCmpnyVccyBean.setOrderColumn(orderColumn);
  			
  			UserCmpnyVccyBean result = (UserCmpnyVccyBean) userCmpnyService.selectUserCmpnyDtlInfoVccyList(userCmpnyVccyBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userCmpnyVccyBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}  

    /*
     * User Company Common Vacancy List
     */   
    @RequestMapping(value="/selectUserCmpnyCommonVccyListAjax") 
    public ModelAndView selectUserCmpnyCommonVccyListAjax(@ModelAttribute("UserCmpnyCommonBean") UserCmpnyCommonBean userCmpnyCommonBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userCmpnyCommonBean.setLang(locale.getLanguage().toLowerCase());
    	UserCmpnyCommonBean rtnVccyData = (UserCmpnyCommonBean) userCmpnyService.selectUserCmpnyCommonVccyList(userCmpnyCommonBean);
				
    	mv.addObject("rtnVccyData", rtnVccyData.getList());
    	mv.setViewName("jsonView");
    	return mv;
	}
    
    /**
     * Application screen in Company info
     * @param userCmpnyAplcBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoAplcListMainAjax") 
    public ModelAndView selectUserCmpnyDtlInfoAplcListMainAjax(@ModelAttribute("UserCmpnyAplcBean") UserCmpnyAplcBean userCmpnyAplcBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	UserCmpnyCommonBean userCmpnyCommonBean = new UserCmpnyCommonBean();
    	userCmpnyCommonBean.setCompnySeq(userCmpnyAplcBean.getCompnySeq());
    	userCmpnyCommonBean.setVacancyYear(userCmpnyAplcBean.getVacancyYear());
    	userCmpnyCommonBean.setLang(locale.getLanguage().toLowerCase());
    	UserCmpnyCommonBean rtnVccyData = (UserCmpnyCommonBean) userCmpnyService.selectUserCmpnyCommonVccyList(userCmpnyCommonBean);	
				
    	mv.addObject("rtnCompnySeq", userCmpnyAplcBean.getCompnySeq());		
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());
    	mv.addObject("rtnVccyData", rtnVccyData.getList());
    	mv.setViewName("user/userCmpnyDtlInfoAplcList" + ".empty");
    	return mv;
	}
    
    /**
     * Application list in company info
     * @param userCmpnyAplcBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoAplcListSubAjax")    
	public ModelAndView selectUserCmpnyDtlInfoAplcListSubAjax(@ModelAttribute("UserCmpnyAplcBean") UserCmpnyAplcBean userCmpnyAplcBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		userCmpnyAplcBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			userCmpnyAplcBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userCmpnyAplcBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userCmpnyAplcBean.setOrderColumn(orderColumn);
  			
  			UserCmpnyAplcBean result = (UserCmpnyAplcBean) userCmpnyService.selectUserCmpnyDtlInfoAplcList(userCmpnyAplcBean);
			String strCareerYear = "";
			String strCareerMonth = "";
			if (result.getTotCareerTermYearCnt() != null && 
					result.getTotCareerTermYearCnt() != "" &&
					Integer.parseInt(result.getTotCareerTermYearCnt()) > 0 ) {
	  			strCareerYear = result.getTotCareerTermYearCnt() +
	  						messageSource.getMessage("field.dic.year", null, null, localeResolver.resolveLocale(request));
	  		}
	  		
  			
			if (result.getTotCareerTermMonthCnt() != null && 
					result.getTotCareerTermMonthCnt() != "" &&
					Integer.parseInt(result.getTotCareerTermMonthCnt()) > 0 ) {
	  			strCareerMonth = result.getTotCareerTermMonthCnt() +
  						messageSource.getMessage("field.dic.month.cnt", null, null, localeResolver.resolveLocale(request));
  			}  			
  			result.setTotCareerTerm(strCareerYear + " " + strCareerMonth);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userCmpnyAplcBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}  

    /**
     * offer Screen in company detail
     * @param userCmpnyOfferBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoOfferMainAjax") 
    public ModelAndView selectUserCmpnyDtlInfoOfferMainAjax(@ModelAttribute("UserCmpnyOfferBean") UserCmpnyOfferBean userCmpnyOfferBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	UserCmpnyCommonBean userCmpnyCommonBean = new UserCmpnyCommonBean();
    	userCmpnyCommonBean.setCompnySeq(userCmpnyOfferBean.getCompnySeq());
    	userCmpnyCommonBean.setVacancyYear(userCmpnyOfferBean.getVacancyYear());
    	userCmpnyCommonBean.setLang(locale.getLanguage().toLowerCase());
    	UserCmpnyCommonBean rtnVccyData = (UserCmpnyCommonBean) userCmpnyService.selectUserCmpnyCommonVccyList(userCmpnyCommonBean);	
				
    	mv.addObject("rtnCompnySeq", userCmpnyOfferBean.getCompnySeq());		
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());
    	mv.addObject("rtnVccyData", rtnVccyData.getList());
    	mv.setViewName("user/userCmpnyDtlInfoOfferList" + ".empty");
    	return mv;
	}    
    
    /**
     * offer list in company detail
     * @param userCmpnyOfferBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoOfferListSubAjax")    
	public ModelAndView selectUserCmpnyDtlInfoOfferListSubAjax(@ModelAttribute("UserCmpnyOfferBean") UserCmpnyOfferBean userCmpnyOfferBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		userCmpnyOfferBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			userCmpnyOfferBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userCmpnyOfferBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userCmpnyOfferBean.setOrderColumn(orderColumn);
  			
  			UserCmpnyOfferBean result = (UserCmpnyOfferBean) userCmpnyService.selectUserCmpnyDtlInfoOfferList(userCmpnyOfferBean);
			String strCareerYear = "";
			String strCareerMonth = "";
			if (result.getTotCareerTermYearCnt() != null && 
					result.getTotCareerTermYearCnt() != "" &&
					Integer.parseInt(result.getTotCareerTermYearCnt()) > 0 ) {
	  			strCareerYear = result.getTotCareerTermYearCnt() +
	  						messageSource.getMessage("field.dic.year", null, null, localeResolver.resolveLocale(request));
	  		}
	  		
  			
			if (result.getTotCareerTermMonthCnt() != null && 
					result.getTotCareerTermMonthCnt() != "" &&
					Integer.parseInt(result.getTotCareerTermMonthCnt()) > 0 ) {
	  			strCareerMonth = result.getTotCareerTermMonthCnt() +
  						messageSource.getMessage("field.dic.month.cnt", null, null, localeResolver.resolveLocale(request));
  			}  			
  			result.setTotCareerTerm(strCareerYear + " " + strCareerMonth);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userCmpnyOfferBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}     

    /**
     * Interview Screen in company detail
     * @param userCmpnyIntvwBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoIntvwMainAjax") 
    public ModelAndView selectUserCmpnyDtlInfoIntvwMainAjax(@ModelAttribute("UserCmpnyIntvwBean") UserCmpnyIntvwBean userCmpnyIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	UserCmpnyCommonBean userCmpnyCommonBean = new UserCmpnyCommonBean();
    	userCmpnyCommonBean.setCompnySeq(userCmpnyIntvwBean.getCompnySeq());
    	userCmpnyCommonBean.setVacancyYear(userCmpnyIntvwBean.getVacancyYear());
    	userCmpnyCommonBean.setLang(locale.getLanguage().toLowerCase());
    	UserCmpnyCommonBean rtnVccyData = (UserCmpnyCommonBean) userCmpnyService.selectUserCmpnyCommonVccyList(userCmpnyCommonBean);	
				
    	mv.addObject("rtnCompnySeq", userCmpnyIntvwBean.getCompnySeq());		
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());
    	mv.addObject("rtnVccyData", rtnVccyData.getList());
    	mv.setViewName("user/userCmpnyDtlInfoIntvwList" + ".empty");
    	return mv;
	}    
    
    /**
     * Interview list in company detail
     * @param userCmpnyIntvwBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoIntvwListSubAjax")    
	public ModelAndView selectUserCmpnyDtlInfoIntvwListSubAjax(@ModelAttribute("UserCmpnyIntvwBean") UserCmpnyIntvwBean userCmpnyIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		userCmpnyIntvwBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			userCmpnyIntvwBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userCmpnyIntvwBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userCmpnyIntvwBean.setOrderColumn(orderColumn);
  			
  			UserCmpnyIntvwBean result = (UserCmpnyIntvwBean) userCmpnyService.selectUserCmpnyDtlInfoIntvwList(userCmpnyIntvwBean);
			String strCareerYear = "";
			String strCareerMonth = "";
			if (result.getTotCareerTermYearCnt() != null && 
					result.getTotCareerTermYearCnt() != "" &&
					Integer.parseInt(result.getTotCareerTermYearCnt()) > 0 ) {
	  			strCareerYear = result.getTotCareerTermYearCnt() +
	  						messageSource.getMessage("field.dic.year", null, null, localeResolver.resolveLocale(request));
	  		}
	  		
  			
			if (result.getTotCareerTermMonthCnt() != null && 
					result.getTotCareerTermMonthCnt() != "" &&
					Integer.parseInt(result.getTotCareerTermMonthCnt()) > 0 ) {
	  			strCareerMonth = result.getTotCareerTermMonthCnt() +
  						messageSource.getMessage("field.dic.month.cnt", null, null, localeResolver.resolveLocale(request));
  			}  			
  			result.setTotCareerTerm(strCareerYear + " " + strCareerMonth);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userCmpnyIntvwBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	} 

    /**
     * Participation Job Fair Main in company Detail
     * @param userCmpnyFairBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoJobfairMainAjax") 
    public ModelAndView selectUserCmpnyDtlInfoJobfairMainAjax(@ModelAttribute("UserCmpnyFairBean") UserCmpnyFairBean userCmpnyFairBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.addObject("rtnCompnySeq", userCmpnyFairBean.getCompnySeq());		
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());
    	mv.setViewName("user/userCmpnyDtlInfoFairList" + ".empty");
    	return mv;
	}    
    
    /**
     * Participation Job Fair Sub in company Detail
     * @param userCmpnyFairBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCmpnyDtlInfoJobfairListSubAjax")    
	public ModelAndView selectUserCmpnyDtlInfoJobfairListSubAjax(@ModelAttribute("UserCmpnyFairBean") UserCmpnyFairBean userCmpnyFairBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		userCmpnyFairBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			userCmpnyFairBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userCmpnyFairBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userCmpnyFairBean.setOrderColumn(orderColumn);
  			
  			UserCmpnyFairBean result = (UserCmpnyFairBean) userCmpnyService.selectUserCmpnyDtlInfoJobfairList(userCmpnyFairBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userCmpnyFairBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	} 
    
}
