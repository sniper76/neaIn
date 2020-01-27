package ony.cpes.internal.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.resume.bean.ResumeDisablBean;
import ony.cpes.internal.resume.bean.ResumeGenrlEduBean;
import ony.cpes.internal.resume.service.ResumeService;
import ony.cpes.internal.user.bean.UserAplcBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.user.bean.UserFairBean;
import ony.cpes.internal.user.bean.UserIntvwBean;
import ony.cpes.internal.user.bean.UserJobskBean;
import ony.cpes.internal.user.bean.UserOfferBean;
import ony.cpes.internal.user.bean.UserReferralBean;
import ony.cpes.internal.user.bean.UserResumeBean;
import ony.cpes.internal.user.bean.UserResumeIscoBean;
import ony.cpes.internal.user.bean.UserResumeLangBean;
import ony.cpes.internal.user.bean.UserResumeLocBean;
import ony.cpes.internal.user.bean.UserResumeOtrTrnngBean;
import ony.cpes.internal.user.bean.UserResumeRefmanBean;
import ony.cpes.internal.user.bean.UserResumeSkillBean;
import ony.cpes.internal.user.bean.UserResumeSpcEduBean;
import ony.cpes.internal.user.bean.UserResumeWorkExpBean;
import ony.cpes.internal.user.service.UserService;
import ony.framework.BaseController;

@RequestMapping("/internal/user")
@Controller
public class UserController extends BaseController{

	private static Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ResumeService resumeService;

	@Autowired MessageSource messageSource;

	@Autowired SessionLocaleResolver localeResolver;

	/**
	 * User Info List View
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
    @RequestMapping("/userInfoList")
	public String userList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "user/userInfoList.all";
	}

    /**
     * method for userList
     * @param userBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserInfoListAjax")
	public ModelAndView selectUserInfoListAjax(@ModelAttribute("userBean") UserBean userBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

  		ModelAndView mv = new ModelAndView();
  		userBean.setLang(locale.getLanguage().toLowerCase());
  		
		// For sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			userBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userBean.setOrderColumn(orderColumn);

  			// main method
  			UserBean result = (UserBean) userService.selectUserInfoListAjax(userBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * inquiry for user Detail info
     * @param userBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoMain")
    public ModelAndView selectUserDtlInfoMain(@ModelAttribute("UserBean") UserBean userBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userBean.setLang(locale.getLanguage().toLowerCase());
    	
    	// inquiry user main
    	UserBean resultUserMain = (UserBean) userService.selectUserDtlInfoMain(userBean);
    	
    	if (userBean != null && userBean.getPreviousUrl() != null) {
    		resultUserMain.setPreviousUrl(userBean.getPreviousUrl());
    	}

    	mv.addObject("resultUserMain", resultUserMain);
    	mv.setViewName("user/userDtlInfoMain" + ".all");
    	return mv;
	}

    /**
     * inquiry for user base info
     * @param userBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoBaseAjax")
    public ModelAndView selectUserDtlInfoBaseAjax(@ModelAttribute("UserBean") UserBean userBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean resultUserBase = (UserBean) userService.selectUserDtlInfoBaseAjax(userBean);

    	mv.addObject("resultUserBase", resultUserBase);
    	mv.setViewName("user/userDtlInfoBase" + ".empty");
    	return mv;
	}


    /**
     * inquiry resume info
     * @param userResumeBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/selectResumeDtlInfoAjax", "/selectElementaryResumeDtlInfoAjax"})
    public ModelAndView selectResumeDtlInfoAjax(@ModelAttribute("UserResumeBean") UserResumeBean userResumeBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	ModelAndView mv = new ModelAndView();
    	UserResumeBean rtnBaseData = new UserResumeBean();

    	// Location domain
    	UserResumeLocBean resumeLocBean = new UserResumeLocBean();
    	UserResumeLocBean rtnLocData = new UserResumeLocBean();

    	// Education Trainning domain 
		UserResumeOtrTrnngBean resumeOtrTrngBean = new UserResumeOtrTrnngBean();
		UserResumeOtrTrnngBean rtnOtrTrngData = new UserResumeOtrTrnngBean();

		// language domain
		UserResumeLangBean resumeLangBean = new UserResumeLangBean();
		UserResumeLangBean rtnLangData = new UserResumeLangBean();

		// special education domain
		UserResumeSpcEduBean resumeSpcEduBean = new UserResumeSpcEduBean();
		UserResumeSpcEduBean rtnSpcEduData = new UserResumeSpcEduBean();

		// work experience domain
		UserResumeWorkExpBean resumeWorkExpBean = new UserResumeWorkExpBean();
		UserResumeWorkExpBean rtnWorkExpData = new UserResumeWorkExpBean();

		// skill domain
		UserResumeSkillBean resumeSkillBean = new UserResumeSkillBean();
		UserResumeSkillBean rtnSkillTitleData = new UserResumeSkillBean();

		// skill detail domain
		UserResumeSkillBean resumeSkillParam = new UserResumeSkillBean();
		UserResumeSkillBean resumeSkillDtlData = new UserResumeSkillBean();

		// reference man domain
		UserResumeRefmanBean resumeRefmanBean = new UserResumeRefmanBean();
		UserResumeRefmanBean rtnRefmanData = new UserResumeRefmanBean();

		List<ResumeDisablBean> disablList = null;
		ResumeGenrlEduBean resumeGenrlEduBean = null;
		List<CommDtlCdBean> skillCdList = null;
		
		userResumeBean.setLang(locale.getLanguage().toLowerCase());
    	rtnBaseData = userService.selectResumeHumanInfoAjax(userResumeBean);

    	if(rtnBaseData != null) {

    		// disablCd
        	ResumeBean resumeBean = new ResumeBean();
        	resumeBean.setResumeSeq(rtnBaseData.getResumeSeq());
        	resumeBean.setLang(locale.getLanguage().toLowerCase());

        	if("Y".equals(rtnBaseData.getDisablYn())) {
        		disablList = resumeService.selectResumeDisableDetail(resumeBean);
        	}

        	resumeGenrlEduBean = resumeService.selectResumeGenrlEduDetail(resumeBean);

        	// skill 조회
      		skillCdList = resumeService.selectResumeSkillForDetail(resumeBean);

			// ISCO Data Info
			UserResumeIscoBean resumeIscoBean = new UserResumeIscoBean();
			resumeIscoBean.setResumeSeq(rtnBaseData.getResumeSeq().toString());
			resumeIscoBean.setLang(locale.getLanguage().toLowerCase());
			UserResumeIscoBean rtnIscoData = (UserResumeIscoBean) userService.selectIscoList(resumeIscoBean);
			String strIscoList = "";

			if (rtnIscoData != null) {
				for(int i=0; i<rtnIscoData.getList().size();i++) {
					if (i==0) {
						strIscoList += rtnIscoData.getList().get(i).getIscoNm().toString();
					} else {
						strIscoList += ", " + rtnIscoData.getList().get(i).getIscoNm().toString();
					}
				}
			}
			rtnBaseData.setIscoList(strIscoList);

			// Prefer Work Loc Info
			resumeLocBean.setResumeSeq(rtnBaseData.getResumeSeq().toString());
			resumeLocBean.setLang(locale.getLanguage().toLowerCase());
			rtnLocData = userService.selectPreferWorkLocList(resumeLocBean);

			/* Prefer Work Week Day */
			String preferWorkWeekDay = "";
			if (rtnBaseData.getPreferDayMon() != null && !"".equals(rtnBaseData.getPreferDayMon()) && "Y".equals(rtnBaseData.getPreferDayMon())) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.mon", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.mon", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			if (rtnBaseData.getPreferDayTue() != null && !"".equals(rtnBaseData.getPreferDayTue()) && "Y".equals(rtnBaseData.getPreferDayTue().toString())) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.tue", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.tue", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			if (rtnBaseData.getPreferDayWed() != null && !"".equals(rtnBaseData.getPreferDayWed()) && "Y".equals(rtnBaseData.getPreferDayWed().toString())) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.wed", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.wed", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			if (rtnBaseData.getPreferDayThu() != null && !"".equals(rtnBaseData.getPreferDayThu()) && "Y".equals(rtnBaseData.getPreferDayThu().toString())) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.thu", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.thu", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			if (rtnBaseData.getPreferDayFri() != null && !"".equals(rtnBaseData.getPreferDayFri()) && "Y".equals(rtnBaseData.getPreferDayFri().toString())) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.fri", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.fri", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			if (rtnBaseData.getPreferDaySat() != null && !"".equals(rtnBaseData.getPreferDaySat()) && "Y".equals(rtnBaseData.getPreferDaySat().toString())) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.sat", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.sat", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			if (rtnBaseData.getPreferDaySun() != null && !"".equals(rtnBaseData.getPreferDaySun()) && "Y".equals(rtnBaseData.getPreferDaySun().toString())) {
				if (preferWorkWeekDay == "") {
					preferWorkWeekDay += messageSource.getMessage("field.dic.day.sun", null, "Error", localeResolver.resolveLocale(request));
				} else {
					preferWorkWeekDay += "," + messageSource.getMessage("field.dic.day.sun", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			rtnBaseData.setPreferWorkWeekDay(preferWorkWeekDay);

			/* Additional Work */
			String additionalWorkOver = "";
			if (rtnBaseData.getNightWorkYn() != null && !"".equals(rtnBaseData.getNightWorkYn()) && "Y".equals(rtnBaseData.getNightWorkYn().toString())) {
				if (additionalWorkOver == "") {
					additionalWorkOver += messageSource.getMessage("field.dic.work.night", null, "Error", localeResolver.resolveLocale(request));
				} else {
					additionalWorkOver += "," + messageSource.getMessage("field.dic.work.night", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			if (rtnBaseData.getOverTimeWorkYn() != null && !"".equals(rtnBaseData.getOverTimeWorkYn()) && "Y".equals(rtnBaseData.getOverTimeWorkYn().toString())) {
				if (additionalWorkOver == "") {
					additionalWorkOver += messageSource.getMessage("field.dic.work.over", null, "Error", localeResolver.resolveLocale(request));
				} else {
					additionalWorkOver += "," + messageSource.getMessage("field.dic.work.over", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			if (rtnBaseData.getHldayWorkYn() != null && !"".equals(rtnBaseData.getHldayWorkYn()) && "Y".equals(rtnBaseData.getHldayWorkYn().toString())) {
				if (additionalWorkOver == "") {
					additionalWorkOver += messageSource.getMessage("field.dic.work.holiday", null, "Error", localeResolver.resolveLocale(request));
				} else {
					additionalWorkOver += "," + messageSource.getMessage("field.dic.work.holiday", null, "Error", localeResolver.resolveLocale(request));
				}
			}
			rtnBaseData.setAdditionalWorkOver(additionalWorkOver);

			resumeOtrTrngBean.setResumeSeq(rtnBaseData.getResumeSeq().toString());
			resumeOtrTrngBean.setLang(locale.getLanguage().toLowerCase());
			rtnOtrTrngData = userService.selectResumeOtrTrngInfoAjax(resumeOtrTrngBean);

			resumeLangBean.setResumeSeq(rtnBaseData.getResumeSeq().toString());
			resumeLangBean.setLang(locale.getLanguage().toLowerCase());
			rtnLangData = userService.selectResumeLangInfoAjax(resumeLangBean);

			resumeSpcEduBean.setResumeSeq(rtnBaseData.getResumeSeq().toString());
			resumeSpcEduBean.setLang(locale.getLanguage().toLowerCase());
			rtnSpcEduData = userService.selectResumeSpcEduInfoAjax(resumeSpcEduBean);

			resumeWorkExpBean.setResumeSeq(rtnBaseData.getResumeSeq().toString());
			resumeWorkExpBean.setLang(locale.getLanguage().toLowerCase());
			rtnWorkExpData = userService.selectResumeWorkExpInfoAjax(resumeWorkExpBean);

			resumeSkillBean.setResumeSeq(rtnBaseData.getResumeSeq().toString());
			resumeSkillBean.setLang(locale.getLanguage().toLowerCase());
			rtnSkillTitleData = userService.selectResumeSkillInfoAjax(resumeSkillBean);

			ArrayList<HashMap<String, Object>> SkillList = new ArrayList<HashMap<String, Object>>();
			resumeSkillParam.setResumeSeq(rtnSkillTitleData.getResumeSeq().toString());
			resumeSkillParam.setLang(locale.getLanguage().toLowerCase());
			String grpCd = "";
			resumeSkillDtlData.setResumeSeq(rtnSkillTitleData.getResumeSeq().toString());
			resumeSkillDtlData.setLang(locale.getLanguage().toLowerCase());
			String strSkillSubscript = "";

			if (rtnSkillTitleData.getList() != null && rtnSkillTitleData.getList().size() > 0) {
				for (int i = 0; i<rtnSkillTitleData.getList().size();i++) {
					grpCd = rtnSkillTitleData.getList().get(i).getSkillCd().toString().substring(0, 11);
					resumeSkillParam.setSkillCd(grpCd);
					resumeSkillParam.setLang(locale.getLanguage().toLowerCase());
					resumeSkillDtlData = (UserResumeSkillBean) userService.selectResumeSkillInfoDtlAjax(resumeSkillParam);

					strSkillSubscript = "";
					if (resumeSkillDtlData != null) {
						HashMap<String, Object> map = new HashMap<String, Object>();
						for (int k=0; k<resumeSkillDtlData.getList().size();k++) {
							if (k == 0) {
								strSkillSubscript += resumeSkillDtlData.getList().get(k).getSkillNm().toString();
							} else {
								strSkillSubscript += ", " + resumeSkillDtlData.getList().get(k).getSkillNm().toString();
							}
						}

						map.put(rtnSkillTitleData.getList().get(i).getSkillNm().toString(), strSkillSubscript);

						SkillList.add(map);
					}

				}
				resumeSkillBean.setSkillList(SkillList);
			}

			resumeRefmanBean.setResumeSeq(rtnBaseData.getResumeSeq().toString());
			resumeRefmanBean.setLang(locale.getLanguage().toLowerCase());
			rtnRefmanData = userService.selectResumeRefmanInfoAjax(resumeRefmanBean);

    	}

    	mv.addObject("rtnBaseData", rtnBaseData);							//Resume Base(Human) Data
    	mv.addObject("rtnLocData", rtnLocData.getList());					//Resume Perfer Work Loc Data
    	mv.addObject("rtnSpcEduData", rtnSpcEduData.getList());				//Resume Special Education Data
    	mv.addObject("rtnOtrTrngData", rtnOtrTrngData.getList());			//Resume Other Training Data
    	mv.addObject("rtnLangData", rtnLangData.getList());					//Resume Language Data
    	mv.addObject("rtnWorkExpData", rtnWorkExpData.getList());			//Resume Work Exp Data
    	mv.addObject("rtnRefmanData", rtnRefmanData.getList());				//Resume Refman Data
    	mv.addObject("rtnDisablData", disablList);							//Resume disablCd Data
    	mv.addObject("rtnGenrlEduData", resumeGenrlEduBean);				//Resume genrlEdu Data
    	mv.addObject("skillCdList", skillCdList);

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

    	if (lastPath.equals("selectResumeDtlInfoAjax")) {
    		mv.setViewName("user/userDtlInfoResume" + ".empty");
    	} else {
    		mv.setViewName("user/userElementaryDtlInfoResume" + ".empty");
    	}

    	return mv;
	}

    
    /**
     * view : request of job seeker
     * @param userJobskBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoJobskMainAjax")
    public ModelAndView selectUserDtlInfoJobskMainAjax(@ModelAttribute("UserJobskBean") UserJobskBean userJobskBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.addObject("rtnUserSeq", userJobskBean.getUserSeq());			//Resume Base(Human) Data
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());
    	mv.setViewName("user/userDtlInfoJobsk.empty");
    	return mv;
	}
    
    /**
     * inquiry requset for job seek
     * @param userJobskBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoJobskSubAjax")
    public ModelAndView selectUserDtlInfoJobskSubAjax(@ModelAttribute("UserJobskBean") UserJobskBean userJobskBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userJobskBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			userJobskBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userJobskBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userJobskBean.setOrderColumn(orderColumn);

  			UserJobskBean result = (UserJobskBean) userService.selectUserDtlInfoJobskAjax(userJobskBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userJobskBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * Application List main Ajax
     * @param userAplcBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoAplcListMainAjax")
    public ModelAndView selectUserDtlInfoAplcListMainAjax(@ModelAttribute("UserAplcBean") UserAplcBean userAplcBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("rtnUserSeq", userAplcBean.getUserSeq());			//Resume Base(Human) Data
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());		//
    	mv.setViewName("user/userDtlInfoAplcList" + ".empty");
    	return mv;
	}

    /**
     * Application List Sub Ajax
     * @param userAplcBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoAplcListSubAjax")
	public ModelAndView selectUserDtlInfoAplcListSubAjax(@ModelAttribute("UserAplcBean") UserAplcBean userAplcBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

  		ModelAndView mv = new ModelAndView();
  		userAplcBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			userAplcBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userAplcBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userAplcBean.setOrderColumn(orderColumn);

  			UserAplcBean result = (UserAplcBean) userService.selectUserDtlInfoAplcList(userAplcBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userAplcBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * offer List Main in user Detail
     * @param userOfferBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoOfferListMainAjax")
    public ModelAndView selectUserDtlInfoOfferListMainAjax(@ModelAttribute("UserOfferBean") UserOfferBean userOfferBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();


    	mv.addObject("rtnUserSeq", userOfferBean.getUserSeq());
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());		//
    	mv.setViewName("user/userDtlInfoOfferList" + ".empty");
    	return mv;
	}

    /**
     * offer list sub in user detail
     * @param userOfferBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoOfferListSubAjax")
	public ModelAndView selectUserDtlInfoOfferListSubAjax(@ModelAttribute("UserOfferBean") UserOfferBean userOfferBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

  		ModelAndView mv = new ModelAndView();
  		userOfferBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			userOfferBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userOfferBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userOfferBean.setOrderColumn(orderColumn);

  			UserOfferBean result = (UserOfferBean) userService.selectUserDtlInfoOfferList(userOfferBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userOfferBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * interview list main in user detail
     * @param userIntvwBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoIntvwListMainAjax")
    public ModelAndView selectUserDtlInfoIntvwListMainAjax(@ModelAttribute("UserIntvwBean") UserIntvwBean userIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();


    	mv.addObject("rtnUserSeq", userIntvwBean.getUserSeq());
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());		//
    	mv.setViewName("user/userDtlInfoIntvwList" + ".empty");
    	return mv;
	}

    /**
     * interview list sub in user detail
     * @param userIntvwBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoIntvwListSubAjax")
	public ModelAndView selectUserDtlInfoIntvwListSubAjax(@ModelAttribute("UserIntvwBean") UserIntvwBean userIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

  		ModelAndView mv = new ModelAndView();
  		userIntvwBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			userIntvwBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userIntvwBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userIntvwBean.setOrderColumn(orderColumn);

  			UserIntvwBean result = (UserIntvwBean) userService.selectUserDtlInfoIntvwList(userIntvwBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userIntvwBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * referral list main in user detail
     * @param userReferralBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoReferralListMainAjax")
    public ModelAndView selectUserDtlInfoReferralListMainAjax(@ModelAttribute("UserReferralBean") UserReferralBean userReferralBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.addObject("rtnUserSeq", userReferralBean.getUserSeq());
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());		//
    	mv.setViewName("user/userDtlInfoReferralList" + ".empty");
    	return mv;
	}

    /**
     * referral list sub in user detail
     * @param userReferralBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoReferralListSubAjax")
	public ModelAndView selectUserDtlInfoReferralListSubAjax(@ModelAttribute("UserReferralBean") UserReferralBean userReferralBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

  		ModelAndView mv = new ModelAndView();
  		userReferralBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			userReferralBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userReferralBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userReferralBean.setOrderColumn(orderColumn);

  			UserReferralBean result = (UserReferralBean) userService.selectUserDtlInfoReferralList(userReferralBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userReferralBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * Fair list main in user detail
     * @param userFairBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoFairListMainAjax")
    public ModelAndView selectUserDtlInfoFairListMainAjax(@ModelAttribute("UserFairBean") UserFairBean userFairBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.addObject("rtnUserSeq", userFairBean.getUserSeq());
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());		//
    	mv.setViewName("user/userDtlInfoFairList" + ".empty");
    	return mv;
	}

    /**
     * fair list sub in user detail
     * @param userFairBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfoFairListSubAjax")
	public ModelAndView selectUserDtlInfoFairListSubAjax(@ModelAttribute("UserFairBean") UserFairBean userFairBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

  		ModelAndView mv = new ModelAndView();
  		userFairBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			userFairBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userFairBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userFairBean.setOrderColumn(orderColumn);

  			UserFairBean result = (UserFairBean) userService.selectUserDtlInfoFairList(userFairBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userFairBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * egist Screen  User Info
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/userDtlInfoReg")
	public String userDtlInfoReg(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "user/userDtlInfoReg.all";
	}

    /**
     * Regist user info.
     * @param userBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/insertUserDtlInfoAjax")
    public void insertUserDtlInfoAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	UserBean param = (UserBean) getObjectFromJSON(request, UserBean.class);
    	UserBean user = (UserBean) userService.insertUserDtlInfo(request, param);

    	this.outputJSON(request, response, user);

	}

    /**
     * screen Regist User Info
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/userDtlInfoModify")
	public ModelAndView userDtlInfoModify(@ModelAttribute("userBean") UserBean userBean, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	ModelAndView mav = new ModelAndView();
    	UserBean rtnUser = new UserBean();
    	rtnUser = userService.selectUserDtlInfo(request, userBean);
    	rtnUser.setPreviousUrl(userBean.getPreviousUrl().toString());
    	
    	mav.addObject("user",rtnUser);

    	mav.setViewName("user/userDtlInfoModify.all");
		return mav;
	}


    /**
     * process update for user info
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/updateUserDtlInfoAjax")
    public void updateUserDtlInfoAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	UserBean param = (UserBean) getObjectFromJSON(request, UserBean.class);
    	UserBean user = (UserBean) userService.updateUserDetailInfo(request, param);

    	this.outputJSON(request, response, user);

	}

    /**
     * Email Duplication check
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/selectUserEmailDuplAjax")
    public void selectUserEmailDuplAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	UserBean param = (UserBean) getObjectFromJSON(request, UserBean.class);
    	UserBean user = (UserBean) userService.selectUserEmailDupl(request, param);

    	this.outputJSON(request, response, user);
	}


    /**
     * cell duplication check
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCellDuplAjax")
    public void selectUserCellDuplAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	UserBean param = (UserBean) getObjectFromJSON(request, UserBean.class);
    	UserBean user = (UserBean) userService.selectUserCellDupl(request, param);

    	this.outputJSON(request, response, user);
	}

    /**
     * Screen for counsel info in user detail 
     * @param userBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value= {"/selectCounselInfoAjax", "/selectCompnyCounselInfoAjax", "/selectInsttCounselInfoAjax"})
    public ModelAndView selectCounselInfoAjax(@ModelAttribute("UserBean") UserBean userBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.addObject("rtnUserSeq", (String) userBean.getUserSeq());			//Resume Base(Human) Data
    	mv.addObject("rtnLangCd", (String) userBean.getSysLangCd());		//
    	mv.setViewName("user/counselList.empty");
    	return mv;
	}


    /**
     * inquiry user info detail
     * @param userBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserDtlInfo")
    public ModelAndView selectUserDtlInfo(@ModelAttribute("UserBean") UserBean userBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean resultUserMain = (UserBean) userService.selectUserDtlInfo(request, userBean);

    	mv.addObject("resultUserMain", resultUserMain);
    	mv.setViewName("user/userDtlInfoMain" + ".all");
    	return mv;
	}

    /**
     * update user password
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/updateUserPasswordAjax")
    public ModelAndView updateUserPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	UserBean userBean = (UserBean) getObjectFromJSON(request, UserBean.class);
    	userBean = userService.updateUserPassword(request, userBean);

    	mv.addObject("userBean", userBean);
    	mv.setViewName("user/userDtlInfoMain" + ".all");
    	return mv;
	}


}
