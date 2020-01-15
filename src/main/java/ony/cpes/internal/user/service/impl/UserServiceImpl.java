package ony.cpes.internal.user.service.impl;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.bean.SmsBean;
import ony.cmm.common.service.CommonService;
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
import ony.cpes.internal.user.dao.UserDAO;
import ony.cpes.internal.user.service.UserService;
import ony.framework.util.Encryption;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;

	@Autowired 
	MessageSource messageSource;

	@Autowired 
	SessionLocaleResolver localeResolver;

	@Autowired 
	CommonService commSvc;
	
	/**
	 * Method for User List
	 * @param UserBean
	 * @return UserBean
	 */
	@Override
	public UserBean selectUserInfoListAjax(UserBean param) throws Exception {

		if (param.getSrchDivCd() != null && param.getSrchDivCd() != "") {
			if (("SUD0000000001").equals(param.getSrchDivCd().toString())) {
				//USER NAME
				param.setUserNm(param.getSrchDivKeyword().toString());
			}
			else if (("SUD0000000002").equals(param.getSrchDivCd().toString())){
				//USER EMAIL
				param.setUserEmail(param.getSrchDivKeyword().toString());
			}
			else if (("SUD0000000003").equals(param.getSrchDivCd().toString())){
				//USER CELL
				param.setUserCell(param.getSrchDivKeyword().toString());
			}
		}

		// get Total Count
		int totalCount = (int) userDAO.selectUserInfoListTotalCnt(param);
		param.setTotalCount(totalCount);

		// get Paging number
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		// get List
		List<UserBean> list = userDAO.selectUserInfoListAjax(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	/**
	 * Process User Status
	 * @param UserBean
	 * @return UserBean
	 */
	@Override
	public UserBean updateUserStsAjax(UserBean param) throws Exception {

		UserBean resultParam = new UserBean();

		int result = 0;
		result = userDAO.updateUserStsAjax(param);

	    if(result > 0) {
	    	resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
	    } else {
	    	/* Later Change to ResultCode as ErrCode */
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }

	    return resultParam;
    }

	/**
	 * Delete User Info
	 * @param UserBean
	 * @return UserBean
	 */
	@Override
	public UserBean deleteUserInfoAjax(UserBean param) throws Exception {

		UserBean resultParam = new UserBean();

		int result = 0;
		result = userDAO.deleteUserInfoAjax(param);

	    if(result > 0) {
	    	resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
	    } else {
	    	/* Later Change to ResultCode as ErrCode */
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }

	    return resultParam;
    }

	/**
	 * User Detail Main
	 * @param UserBean
	 * @return UserBean
	 */
	@Override
	public UserBean selectUserDtlInfoMain(UserBean param) throws Exception {
		return userDAO.selectUserDtlInfoMain(param);
	}

	/**
	 * User Base info
	 * @param UserBean
	 * @return UserBean
	 */
	@Override
	public UserBean selectUserDtlInfoBaseAjax(UserBean param) throws Exception {
		return userDAO.selectUserDtlInfoBaseAjax(param);
	}

	/**
	 * Resume Human Info
	 * @param UserResumeBean
	 * @return UserResumeBean
	 */
	@Override
	public UserResumeBean selectResumeHumanInfoAjax(UserResumeBean param) throws Exception {
		return userDAO.selectResumeHumanInfoAjax(param);
	}

	/**
	 * Disable Option Code
	 * @param UserResumeBean
	 * @return UserResumeBean
	 */
	@Override
	public UserResumeBean selectDisableOptNm(UserResumeBean param) throws Exception	{
		return userDAO.selectDisableOptNm(param);
	}

	/**
	 * Resume ISCO Info
	 * @param UserResumeIscoBean
	 * @return UserResumeIscoBean
	 */
	@Override
	public UserResumeIscoBean selectIscoList(UserResumeIscoBean param) throws Exception {
		List<UserResumeIscoBean> list = userDAO.selectIscoList(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Prefer Work Loc Info
	 * @param UserResumeLocBean
	 * @return UserResumeLocBean
	 */
	@Override
	public UserResumeLocBean selectPreferWorkLocList(UserResumeLocBean param) throws Exception {
		List<UserResumeLocBean> list = userDAO.selectPreferWorkLocList(param);
		param.setList(list);

		return param;
	}

	/**
     * Resume Special Education Info
     *
     * @param UserResumeSpcEduBean
     * @return UserResumeSpcEduBean
     */
	@Override
	public UserResumeSpcEduBean selectResumeSpcEduInfoAjax(UserResumeSpcEduBean param) throws Exception {
		List<UserResumeSpcEduBean> list = userDAO.selectResumeSpcEduInfoAjax(param);

		for(UserResumeSpcEduBean userResumeSpcEduBean : list) {
			LocationBean locationBean = new LocationBean();
	  		locationBean.setDepth("99");
	  		locationBean.setCondGrpCd(userResumeSpcEduBean.getCntryCd());
	  		locationBean.setCdLength(String.valueOf(userResumeSpcEduBean.getCntryCd().length()));
	    	LocationBean locCd = commSvc.selectLoction(locationBean);
	    	userResumeSpcEduBean.setProvcCdList(locCd.getList());
		}

		param.setList(list);

		return param;
	}

	/**
	 * Resume Other Training Info
	 * @param UserResumeOtrTrnngBean
	 * @return UserResumeOtrTrnngBean
	 */
	@Override
	public UserResumeOtrTrnngBean selectResumeOtrTrngInfoAjax(UserResumeOtrTrnngBean param) throws Exception {
		List<UserResumeOtrTrnngBean> list = userDAO.selectResumeOtrTrngInfoAjax(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Language Info
	 * @param UserResumeLangBean
	 * @return UserResumeLangBean
	 */
	@Override
	public UserResumeLangBean selectResumeLangInfoAjax(UserResumeLangBean param) throws Exception {
		List<UserResumeLangBean> list = userDAO.selectResumeLangInfoAjax(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Work Exp Info
	 * @param UserResumeWorkExpBean
	 * @return UserResumeWorkExpBean
	 */
	@Override
	public UserResumeWorkExpBean selectResumeWorkExpInfoAjax(UserResumeWorkExpBean param) throws Exception {
		List<UserResumeWorkExpBean> list = userDAO.selectResumeWorkExpInfoAjax(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Skill Info
	 * @param UserResumeSkillBean
	 * @return UserResumeSkillBean
	 */
	@Override
	public UserResumeSkillBean selectResumeSkillInfoAjax(UserResumeSkillBean param) throws Exception {
		List<UserResumeSkillBean> list = userDAO.selectResumeSkillInfoAjax(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Work Exp Info
	 * @param UserResumeSkillBean
	 * @return UserResumeSkillBean
	 */
	@Override
	public UserResumeSkillBean selectResumeSkillInfoDtlAjax(UserResumeSkillBean param) throws Exception {
		List<UserResumeSkillBean> list = userDAO.selectResumeSkillInfoDtlAjax(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Refman Info
	 * @param UserResumeRefmanBean
	 * @return UserResumeRefmanBean
	 */
	@Override
	public UserResumeRefmanBean selectResumeRefmanInfoAjax(UserResumeRefmanBean param) throws Exception {
		List<UserResumeRefmanBean> list = userDAO.selectResumeRefmanInfoAjax(param);
		param.setList(list);

		return param;
	}


	/**
	 * User Detail Job Seek
	 * @param UserJobskBean
	 * @return UserJobskBean
	 */
	@Override
	public UserJobskBean selectUserDtlInfoJobskAjax(UserJobskBean param) throws Exception {

		int totalCount = (int) userDAO.selectUserDtlInfoJobskTotalCnt(param);
		param.setTotalCount(totalCount);

		// get pageing number
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<UserJobskBean> list = userDAO.selectUserDtlInfoJobskAjax(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * User Detail Application List
	 * @param UserAplcBean
	 * @return UserAplcBean
	 */
	@Override
	public UserAplcBean selectUserDtlInfoAplcList(UserAplcBean param) throws Exception {

		int totalCount = (int) userDAO.selectUserDtlInfoAplcListTotalCnt(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<UserAplcBean> list = userDAO.selectUserDtlInfoAplcList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * User Detail Offer List
	 * @param UserAplcBean
	 * @return UserAplcBean
	 */
	@Override
	public UserOfferBean selectUserDtlInfoOfferList(UserOfferBean param) throws Exception {

		int totalCount = (int) userDAO.selectUserDtlInfoOfferListTotalCnt(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<UserOfferBean> list = userDAO.selectUserDtlInfoOfferList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * User Detail Interview List
	 * @param UserIntvwBean
	 * @return UserIntvwBean
	 */
	@Override
	public UserIntvwBean selectUserDtlInfoIntvwList(UserIntvwBean param) throws Exception {

		int totalCount = (int) userDAO.selectUserDtlInfoIntvwListTotalCnt(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<UserIntvwBean> list = userDAO.selectUserDtlInfoIntvwList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * User Detail Referral List
	 * @param UserReferralBean
	 * @return UserReferralBean
	 */
	@Override
	public UserReferralBean selectUserDtlInfoReferralList(UserReferralBean param) throws Exception {

		int totalCount = (int) userDAO.selectUserDtlInfoReferralListTotalCnt(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<UserReferralBean> list = userDAO.selectUserDtlInfoReferralList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * User Detail Fair List
	 * @param UserFairBean
	 * @return UserFairBean
	 */
	@Override
	public UserFairBean selectUserDtlInfoFairList(UserFairBean param) throws Exception {

		int totalCount = (int) userDAO.selectUserDtlInfoFairListTotalCnt(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<UserFairBean> list = userDAO.selectUserDtlInfoFairList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * regist user information
	 * @param NeaUserBean
	 * @return UserBean
	 */
	public UserBean insertUserDtlInfo(HttpServletRequest request, UserBean param) throws Exception {

		UserBean temp = new UserBean();
		temp.setUserEmail(param.getUserEmail());

		try {

			int tempResult = userDAO.selectUserInfoListTotalCnt(temp);

			// dupl Email
			if (tempResult > 0) {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("user.regist.dupl.email.error",null, "Error", localeResolver.resolveLocale(request)));
				return param;
			}

			temp = null;
			temp = new UserBean();
			temp.setUserCell(param.getUserCell());
			int tempResult2 = userDAO.selectUserInfoListTotalCnt(temp);

			// dupl Cell
			if (tempResult2 > 0) {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("user.regist.dupl.cell.error",null, "Error", localeResolver.resolveLocale(request)));
				return param;
			}

			// Encrypt password SHA512
			param.setUserPwd(Encryption.getSHA512(param.getUserPwd()));
			if("USS0000000002".equals(param.getUserStsCd())) {
				param.setDormancyYn("Y");
			}


			int result = userDAO.insertUserDtlInfo(param);

			if (result > 0) {
				param.setResultCode(messageSource.getMessage("cpes.success.code",null, "0000", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.reg.success.msg",null, "Success", localeResolver.resolveLocale(request)));
			} else {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("fail.common.msg",null, "Error", localeResolver.resolveLocale(request)));
			}
		} catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("fail.common.msg",null, "Error", localeResolver.resolveLocale(request)));
			return param;
		}

		return  param;
	}

	public UserBean selectUserEmailDupl(HttpServletRequest request, UserBean param) throws Exception {
		int result = userDAO.selectUserDuplAjax(param);
		if (result > 0) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("user.regist.dupl.email.error",null, "Error", localeResolver.resolveLocale(request)));

		} else {

			param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("cpes.use.ok.msg",null, "Success", localeResolver.resolveLocale(request)));
		}
		return param;
	}

	public UserBean selectUserCellDupl(HttpServletRequest request, UserBean param) throws Exception {
		int result = userDAO.selectUserDuplAjax(param);
		if (result > 0) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("user.regist.dupl.cell.error",null, "Error", localeResolver.resolveLocale(request)));

		} else {

			param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("cpes.use.ok.msg",null, "Success", localeResolver.resolveLocale(request)));
		}
		return param;
	}

	/**
	 * modify user info.
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public UserBean updateUserDetailInfo(HttpServletRequest request, UserBean param) throws Exception {

		try {
			int result = userDAO.updateUserDetailInfo(param);

			if (result < 1) {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("user.regist.dupl.cell.error",null, "Error", localeResolver.resolveLocale(request)));
			} else {
				param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.use.ok.msg",null, "Success", localeResolver.resolveLocale(request)));
			}
		} catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("user.regist.dupl.cell.error",null, "Error", localeResolver.resolveLocale(request)));
		} finally {

		}
		return param;
	}

	/**
	 * modify user info.
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public UserBean selectUserDtlInfo(HttpServletRequest request, UserBean param) throws Exception {

		param.setLang(LocaleContextHolder.getLocale().getLanguage());

		try {
			param = userDAO.selectUserDtlInfo(param);

			if (param.getBirth() != null && !"".equals(param.getBirth())) {
				String [] birthArr = param.getBirth().split("-");

				if(birthArr[0] != null && !"".equals(birthArr[0])) {
					param.setBirthY(birthArr[0]);
				}
				if(birthArr[1] != null && !"".equals(birthArr[1])) {
					param.setBirthM(birthArr[1]);
				}
				if(birthArr[2] != null && !"".equals(birthArr[2])) {
					param.setBirthD(birthArr[2]);
				}
			}

			if (param.getAuthCmpltYn() != null && "Y".equals(param.getAuthCmpltYn())) {
				param.setAuthCmpltNm(messageSource.getMessage("data.complete.value",null, "Complete", localeResolver.resolveLocale(request)));
			} else {
				param.setAuthCmpltNm(messageSource.getMessage("data.incomplete.value",null, "InComplete", localeResolver.resolveLocale(request)));
			}

		} catch (Exception e) {

		} finally {

		}
		return param;
	}


	public UserBean updateUserPassword(HttpServletRequest request, UserBean param) throws Exception  {
		try {

				int pwdLength = 8;
				char[] passwordTable =  { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
		                                            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
		                                            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
		                                            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
		                                            'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&', '*',
		                                            '(', ')', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

				Random random = new Random(System.currentTimeMillis());
		        int tablelength = passwordTable.length;
		        StringBuffer buf = new StringBuffer();

		        for(int i = 0; i < pwdLength; i++) {
		            buf.append(passwordTable[random.nextInt(tablelength)]);
		        }

				String rPwd = buf.toString();

				param.setUserPwd(Encryption.getSHA512(rPwd));
				int result = userDAO.updateUserPassword(param);

				if (result > 0) {
					param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
					param.setMsg(messageSource.getMessage("cpes.use.ok.msg",null, "Success", localeResolver.resolveLocale(request)));

					/* send SMS */
					String msg = messageSource.getMessage("sms.user.chg.passwd.msg",null, "Changed Password : ", localeResolver.resolveLocale(request)) + rPwd;
					SmsBean sms = new SmsBean();
					sms.setSmsText(msg);
					sms.setSmsTo("85581609370");
					commSvc.insertSmsLog(sms);

				} else {
					param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
					param.setMsg(messageSource.getMessage("user.regist.dupl.cell.error",null, "Error", localeResolver.resolveLocale(request)));
				}
		} catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("user.regist.dupl.cell.error",null, "Error", localeResolver.resolveLocale(request)));
		}
		return param;
	}
}
