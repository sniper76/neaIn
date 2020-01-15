package ony.cpes.internal.resume.controller;

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

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.resume.bean.ResumeIscoBean;
import ony.cpes.internal.resume.bean.ResumeLangBean;
import ony.cpes.internal.resume.bean.ResumeLocBean;
import ony.cpes.internal.resume.bean.ResumeOtrTrngBean;
import ony.cpes.internal.resume.bean.ResumeRefmanBean;
import ony.cpes.internal.resume.bean.ResumeSkillBean;
import ony.cpes.internal.resume.bean.ResumeSpcEduBean;
import ony.cpes.internal.resume.bean.ResumeWorkExpBean;
import ony.cpes.internal.resume.service.ResumeService;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.user.bean.UserResumeLangBean;
import ony.cpes.internal.user.bean.UserResumeLocBean;
import ony.cpes.internal.user.bean.UserResumeOtrTrnngBean;
import ony.cpes.internal.user.bean.UserResumeSpcEduBean;
import ony.cpes.internal.user.bean.UserResumeWorkExpBean;
import ony.cpes.internal.user.service.UserService;
import ony.framework.BaseController;

@RequestMapping("/internal/resume")
@Controller
public class ResumeController extends BaseController{

	private static Log log = LogFactory.getLog(ResumeController.class);

	@Autowired
	private ResumeService resumeService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private UserService userService;

	@Autowired MessageSource messageSource;

	@Autowired SessionLocaleResolver localeResolver;

    /*
     * User Detail Info Base
     */
    @RequestMapping(value="/selectResumeDtlInfoAjax")
    public ModelAndView selectResumeDtlInfoAjax(@ModelAttribute("ResumeBean") ResumeBean resumeBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	ModelAndView mv = new ModelAndView();
    	ResumeBean rtnBaseData = new ResumeBean();

    	ResumeLocBean resumeLocBean = new ResumeLocBean();
		ResumeLocBean rtnLocData = new ResumeLocBean();

		ResumeOtrTrngBean resumeOtrTrngBean = new ResumeOtrTrngBean();
		ResumeOtrTrngBean rtnOtrTrngData = new ResumeOtrTrngBean();

		ResumeLangBean resumeLangBean = new ResumeLangBean();
		ResumeLangBean rtnLangData = new ResumeLangBean();

		ResumeSpcEduBean resumeSpcEduBean = new ResumeSpcEduBean();
		ResumeSpcEduBean rtnSpcEduData = new ResumeSpcEduBean();

		ResumeWorkExpBean resumeWorkExpBean = new ResumeWorkExpBean();
		ResumeWorkExpBean rtnWorkExpData = new ResumeWorkExpBean();

		ResumeSkillBean resumeSkillBean = new ResumeSkillBean();
		ResumeSkillBean rtnSkillTitleData = new ResumeSkillBean();

		ResumeSkillBean resumeSkillParam = new ResumeSkillBean();
		ResumeSkillBean resumeSkillDtlData = new ResumeSkillBean();

		ResumeRefmanBean resumeRefmanBean = new ResumeRefmanBean();
		ResumeRefmanBean rtnRefmanData = new ResumeRefmanBean();
		
		resumeBean.setLang(locale.getLanguage().toLowerCase());
    	rtnBaseData = resumeService.selectResumeHumanInfo(resumeBean);

    	if(rtnBaseData != null) {

    		ResumeBean DisableOptParam = new ResumeBean();
        	ResumeBean DisableOptRtnParam = new ResumeBean();
        	String strDisableOptCd = "";
        	String rtnDisableOptNm = "";

	    	/* Disable Option Cd + Disable Etc */
	    	if(rtnBaseData.getDisablEtc() != null && rtnBaseData.getDisablEtc().toString() != "") {
		    	strDisableOptCd = rtnBaseData.getDisablEtc().toString();
				String[] arrDisableOptCd = strDisableOptCd.split(",");

				for(int i=0; i<arrDisableOptCd.length;i++) {
					DisableOptParam.setDisablOptionCd(arrDisableOptCd[i].toString());
					DisableOptParam.setLang(locale.getLanguage().toLowerCase());
					DisableOptRtnParam = resumeService.selectDisableOptNm(DisableOptParam);
					if(DisableOptRtnParam != null) {
						if(i == 0) {
							rtnDisableOptNm += DisableOptRtnParam.getDisablOptionNm().toString();
						} else {
							rtnDisableOptNm += "," + DisableOptRtnParam.getDisablOptionNm().toString();
						}
					}
				}

				if(rtnDisableOptNm == null || rtnDisableOptNm == "") {
					rtnDisableOptNm = rtnBaseData.getDisablOptionNm().toString();
				} else {
					rtnDisableOptNm += "," + rtnBaseData.getDisablOptionNm().toString();
				}
				rtnBaseData.setDisablOptionNm(rtnDisableOptNm);
	    	}

			// ISCO Data Info
			ResumeIscoBean resumeIscoBean = new ResumeIscoBean();
			resumeIscoBean.setResumeSeq(rtnBaseData.getResumeSeq().toString());
			resumeIscoBean.setLang(locale.getLanguage().toLowerCase());
			ResumeIscoBean rtnIscoData = (ResumeIscoBean) resumeService.selectIscoList(resumeIscoBean);
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
			rtnLocData = resumeService.selectPreferWorkLocList(resumeLocBean);

			/* Prefer Work Week Day */
			String preferWorkWeekDay = "";
			if (rtnBaseData.getPreferDayMon() != null && !"".equals(rtnBaseData.getPreferDayMon()) && "Y".equals(rtnBaseData.getPreferDayMon().toString())) {
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

			// Immediate work
			String workBgnAbleWithin = "";
			if (rtnBaseData.getWorkBgnAbleYn() != null && !"".equals(rtnBaseData.getWorkBgnAbleYn()) && "Y".equals(rtnBaseData.getWorkBgnAbleYn().toString())) {
				workBgnAbleWithin = messageSource.getMessage("field.dic.able.immediate", null, "Error", localeResolver.resolveLocale(request));
			}
			rtnBaseData.setWorkBgnAbleWithin(workBgnAbleWithin);

			resumeOtrTrngBean.setResumeSeq(resumeBean.getResumeSeq().toString());
			resumeOtrTrngBean.setLang(locale.getLanguage().toLowerCase());
			rtnOtrTrngData = resumeService.selectResumeOtrTrngInfo(resumeOtrTrngBean);

			resumeLangBean.setResumeSeq(resumeBean.getResumeSeq().toString());
			resumeLangBean.setLang(locale.getLanguage().toLowerCase());
			rtnLangData = resumeService.selectResumeLangInfo(resumeLangBean);

			resumeSpcEduBean.setResumeSeq(resumeBean.getResumeSeq().toString());
			resumeSpcEduBean.setLang(locale.getLanguage().toLowerCase());
			rtnSpcEduData = resumeService.selectResumeSpcEduInfo(resumeSpcEduBean);

			resumeWorkExpBean.setResumeSeq(resumeBean.getResumeSeq().toString());
			resumeWorkExpBean.setLang(locale.getLanguage().toLowerCase());
			rtnWorkExpData = resumeService.selectResumeWorkExpInfo(resumeWorkExpBean);

			resumeSkillBean.setResumeSeq(resumeBean.getResumeSeq().toString());
			resumeSkillBean.setLang(locale.getLanguage().toLowerCase());
			rtnSkillTitleData = resumeService.selectResumeSkillInfo(resumeSkillBean);

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
					resumeSkillDtlData = (ResumeSkillBean) resumeService.selectResumeSkillDtlInfo(resumeSkillParam);

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


			resumeRefmanBean.setResumeSeq(resumeBean.getResumeSeq().toString());
			resumeRefmanBean.setLang(locale.getLanguage().toLowerCase());
			rtnRefmanData = resumeService.selectResumeRefmanInfo(resumeRefmanBean);

    	}

    	mv.addObject("rtnBaseData", rtnBaseData);							//Resume Base(Human) Data
    	mv.addObject("rtnLocData", rtnLocData.getList());					//Resume Perfer Work Loc Data
    	mv.addObject("rtnSpcEduData", rtnSpcEduData.getList());				//Resume Special Education Data
    	mv.addObject("rtnOtrTrngData", rtnOtrTrngData.getList());			//Resume Other Training Data
    	mv.addObject("rtnLangData", rtnLangData.getList());					//Resume Language Data
    	mv.addObject("rtnWorkExpData", rtnWorkExpData.getList());			//Resume Work Exp Data
    	mv.addObject("rtnSkillData", resumeSkillBean.getSkillList());		//Resume Skill Data
    	mv.addObject("rtnRefmanData", rtnRefmanData.getList());				//Resume Refman Data
    	mv.setViewName("resume/resumeDtlInfo" + ".empty");
    	return mv;
	}

    @RequestMapping("/resumeInsertForm")
    public ModelAndView resumeInsertForm(@ModelAttribute("ResumeBean") ResumeBean resumeBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	LocationBean locationBean = new LocationBean();

    	mv.addObject("userSeq", resumeBean.getUserSeq());

    	// 국가 조회
    	locationBean.setDepth("0");
    	LocationBean nationality = commonService.selectLoction(locationBean);
  		mv.addObject("nationalityList", nationality.getList());

  		// 지역 조회
  		locationBean.setDepth("999");
    	LocationBean locCd = commonService.selectLoction(locationBean);
  		mv.addObject("locCdList", locCd.getList());

  		// skill 조회
  		CommDtlCdBean commDtlCdBean = new CommDtlCdBean();
  		commDtlCdBean.setGrpCd("SKILL_CD");
  		List<CommDtlCdBean> skillCdList = resumeService.selectResumeSkillList(commDtlCdBean);
  		mv.addObject("skillCdList", skillCdList);

    	mv.setViewName("resume/resumeInsert" + ".all");
    	return mv;
    }

    @RequestMapping("/addrNextDepthSelectAjax")
    public ModelAndView addrNextDepthSelectAjax(@ModelAttribute("LocationBean") LocationBean locationBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	LocationBean locCd = commonService.selectLoction(locationBean);
  		mv.addObject("result", locCd.getList());

    	mv.setViewName("jsonView");
    	return mv;
    }

    @RequestMapping("/insertResumeAjax")
    public ModelAndView insertResumeAjax(@ModelAttribute("ResumeBean") ResumeBean resumeBean,
    		HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
    	resumeBean.setRegUserSeq(sessUser.getUserSeq());
    	resumeBean.setModUserSeq(sessUser.getUserSeq());

    	int result = resumeService.insertResume(resumeBean);

    	if(result > 0) {//입력성공, insert success
  			mv.addObject("result", "Y");
  		}else if(result == 99){
  			mv.addObject("result", "FULL");
  		}else {
  			mv.addObject("result", "N");
  		}

    	mv.setViewName("jsonView");
    	return mv;
    }

    @RequestMapping("/resumeUpdateForm")
    public ModelAndView resumeUpdateForm(@ModelAttribute("ResumeBean") ResumeBean resumeBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = resumeInsertForm(resumeBean, request, response);

    	mv.addObject("resumeDetail", resumeService.selectResumeDetail(resumeBean));
    	mv.addObject("disableList", resumeService.selectResumeDisableForUpdate(resumeBean));
    	mv.addObject("genrlEdu", resumeService.selectResumeGenrlEduDetail(resumeBean));
    	mv.addObject("skillList", resumeService.selectResumeSkillDetail(resumeBean));
    	mv.addObject("iscoList", resumeService.selectResumeIsco(resumeBean));
    	mv.addObject("refManList", resumeService.selectResumeRefManDetail(resumeBean));

    	UserResumeLocBean resumeLocBean = new UserResumeLocBean();
    	resumeLocBean.setResumeSeq(resumeBean.getResumeSeq());
    	UserResumeLocBean userResumeLocBean = userService.selectPreferWorkLocList(resumeLocBean);
    	mv.addObject("hopeWorkLocList", userResumeLocBean.getList());

    	UserResumeOtrTrnngBean resumeOtrTrngBean = new UserResumeOtrTrnngBean();
    	resumeOtrTrngBean.setResumeSeq(resumeBean.getResumeSeq());
    	UserResumeOtrTrnngBean userResumeOtrTrnngBean = userService.selectResumeOtrTrngInfoAjax(resumeOtrTrngBean);
    	mv.addObject("otherTrnngList", userResumeOtrTrnngBean.getList());

    	UserResumeLangBean resumeLangBean = new UserResumeLangBean();
    	resumeLangBean.setResumeSeq(resumeBean.getResumeSeq());
    	UserResumeLangBean userResumeLangBean = userService.selectResumeLangInfoAjax(resumeLangBean);
    	mv.addObject("langResult", userResumeLangBean.getList());

    	UserResumeSpcEduBean resumeSpcEduBean = new UserResumeSpcEduBean();
    	resumeSpcEduBean.setResumeSeq(resumeBean.getResumeSeq());
    	UserResumeSpcEduBean specialStudyList = userService.selectResumeSpcEduInfoAjax(resumeSpcEduBean);
    	mv.addObject("specialStudyList", specialStudyList.getList());

    	UserResumeWorkExpBean resumeWorkExpBean = new UserResumeWorkExpBean();
    	resumeWorkExpBean.setResumeSeq(resumeBean.getResumeSeq());
    	UserResumeWorkExpBean userResumeWorkExpBean = userService.selectResumeWorkExpInfoAjax(resumeWorkExpBean);
    	mv.addObject("workExpList", userResumeWorkExpBean.getList());

    	mv.setViewName("resume/resumeUpdate" + ".all");
    	return mv;
    }

    @RequestMapping("/updateResumeAjax")
    public ModelAndView updateResumeAjax(@ModelAttribute("ResumeBean") ResumeBean resumeBean,
    		HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	int result = resumeService.updateResume(resumeBean);

    	if(result > 0) {//입력성공, insert success
    		mv.addObject("result", "Y");
  		}else {
  			mv.addObject("result", "N");
  		}

    	mv.setViewName("jsonView");
    	return mv;
    }

    @RequestMapping("/deleteResumeAjax")
    public ModelAndView deleteResumeAjax(@ModelAttribute("ResumeBean") ResumeBean resumeBean,
    		HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
    	resumeBean.setModUserSeq(sessUser.getUserSeq());

    	mv.addObject("result", resumeService.deleteResume(resumeBean));

    	mv.setViewName("jsonView");
    	return mv;
    }

}
