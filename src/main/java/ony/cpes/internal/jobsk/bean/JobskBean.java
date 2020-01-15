package ony.cpes.internal.jobsk.bean;

import java.util.ArrayList;
import java.util.List;
import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 * JOB SEEK BEAN
 * @author Onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << (Modification Information) >>
 *
 *  Date           	Modifier   	Description
 *  ------------- 	-------- 	---------------------------
 *  2019.10.28 		Joo
 *
 * </pre>
 */
public class JobskBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	jobskReqSeq				= "";
	private String 	resumeSeq				= "";
	private String 	jobskNum				= "";
	private String 	jcCd					= "";
	private String 	jcUserSeq				= "";
	private String	jcAgreeStsCd			= "";
	private String	jcAgreeDt				= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";
	private String	agreeRejectReason		= "";
	 
	private List<JobskBean> list;
	
	//2. Additional Search Condition Parameter
	private String	srchDivCd				= "";
	private String 	srchDivKeyword			= "";
	private String	userAuthCd				= "";
	private String	userAuthNm				= "";
	private String	jobskStsCd				= "";
	private String	jobskStsNm				= "";
	private String	genderCd				= "";
	private String	genderNm				= "";
	private String	userStsCd				= "";
	private String	userStsNm				= "";
	private String	jcAgreeStsNm			= "";
	private String	urgentJobseekYn			= "";
	private String	nowWorkYn				= "";
	
	//2.1 User
	private String userSeq					= "";
	private String userId					= "";
	private String userEmail				= "";
	private String userCell;
	private String userNm					= "";
	private String addrDtl					= "";
	private String addrFullNm				= "";
	private String nid						= "";
	private String userPwdOld				= "";
	private String userPwd					= "";
	private String newPwdApplyYn			= "";
	private String pwdCreatDt				= "";
	private String pwdFailCnt				= "";
	private String privateInfoUseAgreeYn	= "";
	private String smsNtceAgreeYn			= "";
	private String emailNtceAgreeYn			= "";
	private String emailUserAuthValue		= "";
	private String userGrpCd				= "";
	private String accntLockStsCd			= "";
	private String wthdrReasonCd			= "";
	private String wthdrReason				= "";
	private String lastLoginDt				= "";
	private String lastLoginIp				= "";
	private String authCmpltYn				= "";
	private String smsEmailAuthDivCd		= "";
	private String joinRouteDivCd 			= "";
	
	//2.2 Resume
	private String 	resumeId				= "";
	private String 	resumeTitle				= "";
	private String 	langUseCd				= "";
	private String 	priResumeYn				= "";
	private String 	resumeKeyword			= "";
	private String 	jcAgreeYn				= "";
	private String 	fullUserNmKh			= "";
	private String 	fullUserNmEn			= "";
	private String 	nationCd				= "";
	private String 	birth					= "";
	private String 	identiNo				= "";
	private String 	birthLocCd				= "";
	private String 	marriCd					= "";
	private String 	familyCnt				= "";
	private String 	underAge15FamilyCnt		= "";
	private String 	overAge64FamilyCnt		= "";
	private String 	addrCd					= "";
	private String 	frstimeJobSeekerYn		= "";
	private String 	studyingYn				= "";
	private String 	retMigratYn				= "";
	private String 	ruralLaboYn				= "";
	private String 	srvcYn					= "";
	private String 	ethnicMinorYn			= "";
	private String 	disablYn				= "";
	private String 	disablOptionCd			= "";
	private String 	disablEtc				= "";
	private String 	beforeWorkDura			= "";
	private String 	selfempYn				= "";
	private String 	selfempClassCd			= "";
	private String 	jobseekWaitDura			= "";
	private String 	fileGrpSeq				= "";
	private String 	proLicnsYn				= "";
	private String 	proLicnsSpec			= "";
	private String 	careerYn				= "";
	private String 	totCareerTermYearCnt	= "";
	private String 	totCareerTermMonthCnt	= "";
	private String 	jobCenterUserModDt		= "";
	private String 	jobCenterVerityUserSeq	= "";
	private String 	jobCenterNote			= "";
	private String 	uploadCv				= "";
	private String 	stepInput				= "";
	private String 	mobileId				= "";
	private String 	resumeStsCd				= "";
	private String 	lastModDt				= "";
	private String 	preferJobTitle			= "";
	private String 	iscoCd					= "";
	private String 	isicCd					= "";
	private String 	employmtFormCd			= "";
	private String 	preferEmployTypeCd		= "";
	private String 	typeEmployHourDay		= "";
	private String 	typeEmployDayWeek		= "";
	private String 	preferCrtctTerms		= "";
	private String 	preferCrtctTermsDura	= "";
	private String 	preferCrtctType			= "";
	private String 	nightWorkYn				= "";
	private String 	overTimeWorkYn			= "";
	private String 	hldayWorkYn				= "";
	private String	expctMinSalaryAmt		= "";
	private String	expctMaxSalaryAmt		= "";
	private String 	expctSalaryTypeCd		= "";
	private String 	diffProvcWorkYn			= "";
	private String 	workBgnAbleYn			= "";
	private String 	workBgnAbleWithin		= "";
	private String	birthAddrDtl			= "";
	private String 	preferPosition			= "";
	private String 	preferDayMon			= "";
	private String 	preferDayTue			= "";
	private String 	preferDayWed			= "";
	private String 	preferDayThu			= "";
	private String 	preferDayFri			= "";
	private String 	preferDaySat			= "";
	private String 	preferDaySun			= "";	
	
	//3. Additional Parameter
	private String 	jcNm					= "";
	private String	age						= "";
	private String 	marriNm					= "";
	private String	disablOptionNm			= "";
	private String	employFormNm			= "";
	private String	preferEmployTypeNm		= "";
	private String	preferCrtctTypeNm		= "";
	private String	preferWorkWeekDay		= "";
	private String 	additionalWorkOver		= "";
	private String	eduGnrlIscedNm			= "";
	private String	eduSkillIscedNm			= "";
	private String	iscoList				= "";
	private String 	preferWorkLocList		= "";
	private String	jcUserNm				= "";
	
	private List<String> selectedList 		= new ArrayList<String>();

	
	
	
	/**
	 * @return the sysLangCd
	 */
	public String getSysLangCd() {
		return sysLangCd;
	}

	/**
	 * @param sysLangCd the sysLangCd to set
	 */
	public void setSysLangCd(String sysLangCd) {
		this.sysLangCd = sysLangCd;
	}

	/**
	 * @return the jobskReqSeq
	 */
	public String getJobskReqSeq() {
		return jobskReqSeq;
	}

	/**
	 * @param jobskReqSeq the jobskReqSeq to set
	 */
	public void setJobskReqSeq(String jobskReqSeq) {
		this.jobskReqSeq = jobskReqSeq;
	}

	/**
	 * @return the resumeSeq
	 */
	public String getResumeSeq() {
		return resumeSeq;
	}

	/**
	 * @param resumeSeq the resumeSeq to set
	 */
	public void setResumeSeq(String resumeSeq) {
		this.resumeSeq = resumeSeq;
	}

	/**
	 * @return the jobskNum
	 */
	public String getJobskNum() {
		return jobskNum;
	}

	/**
	 * @param jobskNum the jobskNum to set
	 */
	public void setJobskNum(String jobskNum) {
		this.jobskNum = jobskNum;
	}

	/**
	 * @return the jcCd
	 */
	public String getJcCd() {
		return jcCd;
	}

	/**
	 * @param jcCd the jcCd to set
	 */
	public void setJcCd(String jcCd) {
		this.jcCd = jcCd;
	}

	/**
	 * @return the jcUserSeq
	 */
	public String getJcUserSeq() {
		return jcUserSeq;
	}

	/**
	 * @param jcUserSeq the jcUserSeq to set
	 */
	public void setJcUserSeq(String jcUserSeq) {
		this.jcUserSeq = jcUserSeq;
	}

	/**
	 * @return the jcAgreeStsCd
	 */
	public String getJcAgreeStsCd() {
		return jcAgreeStsCd;
	}

	/**
	 * @param jcAgreeStsCd the jcAgreeStsCd to set
	 */
	public void setJcAgreeStsCd(String jcAgreeStsCd) {
		this.jcAgreeStsCd = jcAgreeStsCd;
	}

	/**
	 * @return the jcAgreeDt
	 */
	public String getJcAgreeDt() {
		return jcAgreeDt;
	}

	/**
	 * @param jcAgreeDt the jcAgreeDt to set
	 */
	public void setJcAgreeDt(String jcAgreeDt) {
		this.jcAgreeDt = jcAgreeDt;
	}

	/**
	 * @return the regUserSeq
	 */
	public String getRegUserSeq() {
		return regUserSeq;
	}

	/**
	 * @param regUserSeq the regUserSeq to set
	 */
	public void setRegUserSeq(String regUserSeq) {
		this.regUserSeq = regUserSeq;
	}

	/**
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}

	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	/**
	 * @return the modUserSeq
	 */
	public String getModUserSeq() {
		return modUserSeq;
	}

	/**
	 * @param modUserSeq the modUserSeq to set
	 */
	public void setModUserSeq(String modUserSeq) {
		this.modUserSeq = modUserSeq;
	}

	/**
	 * @return the modDt
	 */
	public String getModDt() {
		return modDt;
	}

	/**
	 * @param modDt the modDt to set
	 */
	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	/**
	 * @return the agreeRejectReason
	 */
	public String getAgreeRejectReason() {
		return agreeRejectReason;
	}

	/**
	 * @param agreeRejectReason the agreeRejectReason to set
	 */
	public void setAgreeRejectReason(String agreeRejectReason) {
		this.agreeRejectReason = agreeRejectReason;
	}

	/**
	 * @return the list
	 */
	public List<JobskBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<JobskBean> list) {
		this.list = list;
	}

	/**
	 * @return the srchDivCd
	 */
	public String getSrchDivCd() {
		return srchDivCd;
	}

	/**
	 * @param srchDivCd the srchDivCd to set
	 */
	public void setSrchDivCd(String srchDivCd) {
		this.srchDivCd = srchDivCd;
	}

	/**
	 * @return the srchDivKeyword
	 */
	public String getSrchDivKeyword() {
		return srchDivKeyword;
	}

	/**
	 * @param srchDivKeyword the srchDivKeyword to set
	 */
	public void setSrchDivKeyword(String srchDivKeyword) {
		this.srchDivKeyword = srchDivKeyword;
	}

	/**
	 * @return the userAuthCd
	 */
	public String getUserAuthCd() {
		return userAuthCd;
	}

	/**
	 * @param userAuthCd the userAuthCd to set
	 */
	public void setUserAuthCd(String userAuthCd) {
		this.userAuthCd = userAuthCd;
	}

	/**
	 * @return the userAuthNm
	 */
	public String getUserAuthNm() {
		return userAuthNm;
	}

	/**
	 * @param userAuthNm the userAuthNm to set
	 */
	public void setUserAuthNm(String userAuthNm) {
		this.userAuthNm = userAuthNm;
	}

	/**
	 * @return the jobskStsCd
	 */
	public String getJobskStsCd() {
		return jobskStsCd;
	}

	/**
	 * @param jobskStsCd the jobskStsCd to set
	 */
	public void setJobskStsCd(String jobskStsCd) {
		this.jobskStsCd = jobskStsCd;
	}

	/**
	 * @return the jobskStsNm
	 */
	public String getJobskStsNm() {
		return jobskStsNm;
	}

	/**
	 * @param jobskStsNm the jobskStsNm to set
	 */
	public void setJobskStsNm(String jobskStsNm) {
		this.jobskStsNm = jobskStsNm;
	}

	/**
	 * @return the genderCd
	 */
	public String getGenderCd() {
		return genderCd;
	}

	/**
	 * @param genderCd the genderCd to set
	 */
	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}

	/**
	 * @return the genderNm
	 */
	public String getGenderNm() {
		return genderNm;
	}

	/**
	 * @param genderNm the genderNm to set
	 */
	public void setGenderNm(String genderNm) {
		this.genderNm = genderNm;
	}

	/**
	 * @return the userStsCd
	 */
	public String getUserStsCd() {
		return userStsCd;
	}

	/**
	 * @param userStsCd the userStsCd to set
	 */
	public void setUserStsCd(String userStsCd) {
		this.userStsCd = userStsCd;
	}

	/**
	 * @return the userStsNm
	 */
	public String getUserStsNm() {
		return userStsNm;
	}

	/**
	 * @param userStsNm the userStsNm to set
	 */
	public void setUserStsNm(String userStsNm) {
		this.userStsNm = userStsNm;
	}

	/**
	 * @return the jcAgreeStsNm
	 */
	public String getJcAgreeStsNm() {
		return jcAgreeStsNm;
	}

	/**
	 * @param jcAgreeStsNm the jcAgreeStsNm to set
	 */
	public void setJcAgreeStsNm(String jcAgreeStsNm) {
		this.jcAgreeStsNm = jcAgreeStsNm;
	}

	/**
	 * @return the urgentJobseekYn
	 */
	public String getUrgentJobseekYn() {
		return urgentJobseekYn;
	}

	/**
	 * @param urgentJobseekYn the urgentJobseekYn to set
	 */
	public void setUrgentJobseekYn(String urgentJobseekYn) {
		this.urgentJobseekYn = urgentJobseekYn;
	}

	/**
	 * @return the nowWorkYn
	 */
	public String getNowWorkYn() {
		return nowWorkYn;
	}

	/**
	 * @param nowWorkYn the nowWorkYn to set
	 */
	public void setNowWorkYn(String nowWorkYn) {
		this.nowWorkYn = nowWorkYn;
	}

	/**
	 * @return the userSeq
	 */
	public String getUserSeq() {
		return userSeq;
	}

	/**
	 * @param userSeq the userSeq to set
	 */
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userCell
	 */
	public String getUserCell() {
		return userCell;
	}

	/**
	 * @param userCell the userCell to set
	 */
	public void setUserCell(String userCell) {
		this.userCell = userCell;
	}

	/**
	 * @return the userNm
	 */
	public String getUserNm() {
		return userNm;
	}

	/**
	 * @param userNm the userNm to set
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	/**
	 * @return the addrDtl
	 */
	public String getAddrDtl() {
		return addrDtl;
	}

	/**
	 * @param addrDtl the addrDtl to set
	 */
	public void setAddrDtl(String addrDtl) {
		this.addrDtl = addrDtl;
	}

	/**
	 * @return the addrFullNm
	 */
	public String getAddrFullNm() {
		return addrFullNm;
	}

	/**
	 * @param addrFullNm the addrFullNm to set
	 */
	public void setAddrFullNm(String addrFullNm) {
		this.addrFullNm = addrFullNm;
	}

	/**
	 * @return the nid
	 */
	public String getNid() {
		return nid;
	}

	/**
	 * @param nid the nid to set
	 */
	public void setNid(String nid) {
		this.nid = nid;
	}

	/**
	 * @return the userPwdOld
	 */
	public String getUserPwdOld() {
		return userPwdOld;
	}

	/**
	 * @param userPwdOld the userPwdOld to set
	 */
	public void setUserPwdOld(String userPwdOld) {
		this.userPwdOld = userPwdOld;
	}

	/**
	 * @return the userPwd
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * @param userPwd the userPwd to set
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * @return the newPwdApplyYn
	 */
	public String getNewPwdApplyYn() {
		return newPwdApplyYn;
	}

	/**
	 * @param newPwdApplyYn the newPwdApplyYn to set
	 */
	public void setNewPwdApplyYn(String newPwdApplyYn) {
		this.newPwdApplyYn = newPwdApplyYn;
	}

	/**
	 * @return the pwdCreatDt
	 */
	public String getPwdCreatDt() {
		return pwdCreatDt;
	}

	/**
	 * @param pwdCreatDt the pwdCreatDt to set
	 */
	public void setPwdCreatDt(String pwdCreatDt) {
		this.pwdCreatDt = pwdCreatDt;
	}

	/**
	 * @return the pwdFailCnt
	 */
	public String getPwdFailCnt() {
		return pwdFailCnt;
	}

	/**
	 * @param pwdFailCnt the pwdFailCnt to set
	 */
	public void setPwdFailCnt(String pwdFailCnt) {
		this.pwdFailCnt = pwdFailCnt;
	}

	/**
	 * @return the privateInfoUseAgreeYn
	 */
	public String getPrivateInfoUseAgreeYn() {
		return privateInfoUseAgreeYn;
	}

	/**
	 * @param privateInfoUseAgreeYn the privateInfoUseAgreeYn to set
	 */
	public void setPrivateInfoUseAgreeYn(String privateInfoUseAgreeYn) {
		this.privateInfoUseAgreeYn = privateInfoUseAgreeYn;
	}

	/**
	 * @return the smsNtceAgreeYn
	 */
	public String getSmsNtceAgreeYn() {
		return smsNtceAgreeYn;
	}

	/**
	 * @param smsNtceAgreeYn the smsNtceAgreeYn to set
	 */
	public void setSmsNtceAgreeYn(String smsNtceAgreeYn) {
		this.smsNtceAgreeYn = smsNtceAgreeYn;
	}

	/**
	 * @return the emailNtceAgreeYn
	 */
	public String getEmailNtceAgreeYn() {
		return emailNtceAgreeYn;
	}

	/**
	 * @param emailNtceAgreeYn the emailNtceAgreeYn to set
	 */
	public void setEmailNtceAgreeYn(String emailNtceAgreeYn) {
		this.emailNtceAgreeYn = emailNtceAgreeYn;
	}

	/**
	 * @return the emailUserAuthValue
	 */
	public String getEmailUserAuthValue() {
		return emailUserAuthValue;
	}

	/**
	 * @param emailUserAuthValue the emailUserAuthValue to set
	 */
	public void setEmailUserAuthValue(String emailUserAuthValue) {
		this.emailUserAuthValue = emailUserAuthValue;
	}

	/**
	 * @return the userGrpCd
	 */
	public String getUserGrpCd() {
		return userGrpCd;
	}

	/**
	 * @param userGrpCd the userGrpCd to set
	 */
	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
	}

	/**
	 * @return the accntLockStsCd
	 */
	public String getAccntLockStsCd() {
		return accntLockStsCd;
	}

	/**
	 * @param accntLockStsCd the accntLockStsCd to set
	 */
	public void setAccntLockStsCd(String accntLockStsCd) {
		this.accntLockStsCd = accntLockStsCd;
	}

	/**
	 * @return the wthdrReasonCd
	 */
	public String getWthdrReasonCd() {
		return wthdrReasonCd;
	}

	/**
	 * @param wthdrReasonCd the wthdrReasonCd to set
	 */
	public void setWthdrReasonCd(String wthdrReasonCd) {
		this.wthdrReasonCd = wthdrReasonCd;
	}

	/**
	 * @return the wthdrReason
	 */
	public String getWthdrReason() {
		return wthdrReason;
	}

	/**
	 * @param wthdrReason the wthdrReason to set
	 */
	public void setWthdrReason(String wthdrReason) {
		this.wthdrReason = wthdrReason;
	}

	/**
	 * @return the lastLoginDt
	 */
	public String getLastLoginDt() {
		return lastLoginDt;
	}

	/**
	 * @param lastLoginDt the lastLoginDt to set
	 */
	public void setLastLoginDt(String lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}

	/**
	 * @return the lastLoginIp
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * @return the authCmpltYn
	 */
	public String getAuthCmpltYn() {
		return authCmpltYn;
	}

	/**
	 * @param authCmpltYn the authCmpltYn to set
	 */
	public void setAuthCmpltYn(String authCmpltYn) {
		this.authCmpltYn = authCmpltYn;
	}

	/**
	 * @return the smsEmailAuthDivCd
	 */
	public String getSmsEmailAuthDivCd() {
		return smsEmailAuthDivCd;
	}

	/**
	 * @param smsEmailAuthDivCd the smsEmailAuthDivCd to set
	 */
	public void setSmsEmailAuthDivCd(String smsEmailAuthDivCd) {
		this.smsEmailAuthDivCd = smsEmailAuthDivCd;
	}

	/**
	 * @return the joinRouteDivCd
	 */
	public String getJoinRouteDivCd() {
		return joinRouteDivCd;
	}

	/**
	 * @param joinRouteDivCd the joinRouteDivCd to set
	 */
	public void setJoinRouteDivCd(String joinRouteDivCd) {
		this.joinRouteDivCd = joinRouteDivCd;
	}

	/**
	 * @return the resumeId
	 */
	public String getResumeId() {
		return resumeId;
	}

	/**
	 * @param resumeId the resumeId to set
	 */
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}

	/**
	 * @return the resumeTitle
	 */
	public String getResumeTitle() {
		return resumeTitle;
	}

	/**
	 * @param resumeTitle the resumeTitle to set
	 */
	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}

	/**
	 * @return the langUseCd
	 */
	public String getLangUseCd() {
		return langUseCd;
	}

	/**
	 * @param langUseCd the langUseCd to set
	 */
	public void setLangUseCd(String langUseCd) {
		this.langUseCd = langUseCd;
	}

	/**
	 * @return the priResumeYn
	 */
	public String getPriResumeYn() {
		return priResumeYn;
	}

	/**
	 * @param priResumeYn the priResumeYn to set
	 */
	public void setPriResumeYn(String priResumeYn) {
		this.priResumeYn = priResumeYn;
	}

	/**
	 * @return the resumeKeyword
	 */
	public String getResumeKeyword() {
		return resumeKeyword;
	}

	/**
	 * @param resumeKeyword the resumeKeyword to set
	 */
	public void setResumeKeyword(String resumeKeyword) {
		this.resumeKeyword = resumeKeyword;
	}

	/**
	 * @return the jcAgreeYn
	 */
	public String getJcAgreeYn() {
		return jcAgreeYn;
	}

	/**
	 * @param jcAgreeYn the jcAgreeYn to set
	 */
	public void setJcAgreeYn(String jcAgreeYn) {
		this.jcAgreeYn = jcAgreeYn;
	}

	/**
	 * @return the fullUserNmKh
	 */
	public String getFullUserNmKh() {
		return fullUserNmKh;
	}

	/**
	 * @param fullUserNmKh the fullUserNmKh to set
	 */
	public void setFullUserNmKh(String fullUserNmKh) {
		this.fullUserNmKh = fullUserNmKh;
	}

	/**
	 * @return the fullUserNmEn
	 */
	public String getFullUserNmEn() {
		return fullUserNmEn;
	}

	/**
	 * @param fullUserNmEn the fullUserNmEn to set
	 */
	public void setFullUserNmEn(String fullUserNmEn) {
		this.fullUserNmEn = fullUserNmEn;
	}

	/**
	 * @return the nationCd
	 */
	public String getNationCd() {
		return nationCd;
	}

	/**
	 * @param nationCd the nationCd to set
	 */
	public void setNationCd(String nationCd) {
		this.nationCd = nationCd;
	}

	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * @return the identiNo
	 */
	public String getIdentiNo() {
		return identiNo;
	}

	/**
	 * @param identiNo the identiNo to set
	 */
	public void setIdentiNo(String identiNo) {
		this.identiNo = identiNo;
	}

	/**
	 * @return the birthLocCd
	 */
	public String getBirthLocCd() {
		return birthLocCd;
	}

	/**
	 * @param birthLocCd the birthLocCd to set
	 */
	public void setBirthLocCd(String birthLocCd) {
		this.birthLocCd = birthLocCd;
	}

	/**
	 * @return the marriCd
	 */
	public String getMarriCd() {
		return marriCd;
	}

	/**
	 * @param marriCd the marriCd to set
	 */
	public void setMarriCd(String marriCd) {
		this.marriCd = marriCd;
	}

	/**
	 * @return the familyCnt
	 */
	public String getFamilyCnt() {
		return familyCnt;
	}

	/**
	 * @param familyCnt the familyCnt to set
	 */
	public void setFamilyCnt(String familyCnt) {
		this.familyCnt = familyCnt;
	}

	/**
	 * @return the underAge15FamilyCnt
	 */
	public String getUnderAge15FamilyCnt() {
		return underAge15FamilyCnt;
	}

	/**
	 * @param underAge15FamilyCnt the underAge15FamilyCnt to set
	 */
	public void setUnderAge15FamilyCnt(String underAge15FamilyCnt) {
		this.underAge15FamilyCnt = underAge15FamilyCnt;
	}

	/**
	 * @return the overAge64FamilyCnt
	 */
	public String getOverAge64FamilyCnt() {
		return overAge64FamilyCnt;
	}

	/**
	 * @param overAge64FamilyCnt the overAge64FamilyCnt to set
	 */
	public void setOverAge64FamilyCnt(String overAge64FamilyCnt) {
		this.overAge64FamilyCnt = overAge64FamilyCnt;
	}

	/**
	 * @return the addrCd
	 */
	public String getAddrCd() {
		return addrCd;
	}

	/**
	 * @param addrCd the addrCd to set
	 */
	public void setAddrCd(String addrCd) {
		this.addrCd = addrCd;
	}

	/**
	 * @return the frstimeJobSeekerYn
	 */
	public String getFrstimeJobSeekerYn() {
		return frstimeJobSeekerYn;
	}

	/**
	 * @param frstimeJobSeekerYn the frstimeJobSeekerYn to set
	 */
	public void setFrstimeJobSeekerYn(String frstimeJobSeekerYn) {
		this.frstimeJobSeekerYn = frstimeJobSeekerYn;
	}

	/**
	 * @return the studyingYn
	 */
	public String getStudyingYn() {
		return studyingYn;
	}

	/**
	 * @param studyingYn the studyingYn to set
	 */
	public void setStudyingYn(String studyingYn) {
		this.studyingYn = studyingYn;
	}

	/**
	 * @return the retMigratYn
	 */
	public String getRetMigratYn() {
		return retMigratYn;
	}

	/**
	 * @param retMigratYn the retMigratYn to set
	 */
	public void setRetMigratYn(String retMigratYn) {
		this.retMigratYn = retMigratYn;
	}

	/**
	 * @return the ruralLaboYn
	 */
	public String getRuralLaboYn() {
		return ruralLaboYn;
	}

	/**
	 * @param ruralLaboYn the ruralLaboYn to set
	 */
	public void setRuralLaboYn(String ruralLaboYn) {
		this.ruralLaboYn = ruralLaboYn;
	}

	/**
	 * @return the srvcYn
	 */
	public String getSrvcYn() {
		return srvcYn;
	}

	/**
	 * @param srvcYn the srvcYn to set
	 */
	public void setSrvcYn(String srvcYn) {
		this.srvcYn = srvcYn;
	}

	/**
	 * @return the ethnicMinorYn
	 */
	public String getEthnicMinorYn() {
		return ethnicMinorYn;
	}

	/**
	 * @param ethnicMinorYn the ethnicMinorYn to set
	 */
	public void setEthnicMinorYn(String ethnicMinorYn) {
		this.ethnicMinorYn = ethnicMinorYn;
	}

	/**
	 * @return the disablYn
	 */
	public String getDisablYn() {
		return disablYn;
	}

	/**
	 * @param disablYn the disablYn to set
	 */
	public void setDisablYn(String disablYn) {
		this.disablYn = disablYn;
	}

	/**
	 * @return the disablOptionCd
	 */
	public String getDisablOptionCd() {
		return disablOptionCd;
	}

	/**
	 * @param disablOptionCd the disablOptionCd to set
	 */
	public void setDisablOptionCd(String disablOptionCd) {
		this.disablOptionCd = disablOptionCd;
	}

	/**
	 * @return the disablEtc
	 */
	public String getDisablEtc() {
		return disablEtc;
	}

	/**
	 * @param disablEtc the disablEtc to set
	 */
	public void setDisablEtc(String disablEtc) {
		this.disablEtc = disablEtc;
	}

	/**
	 * @return the beforeWorkDura
	 */
	public String getBeforeWorkDura() {
		return beforeWorkDura;
	}

	/**
	 * @param beforeWorkDura the beforeWorkDura to set
	 */
	public void setBeforeWorkDura(String beforeWorkDura) {
		this.beforeWorkDura = beforeWorkDura;
	}

	/**
	 * @return the selfempYn
	 */
	public String getSelfempYn() {
		return selfempYn;
	}

	/**
	 * @param selfempYn the selfempYn to set
	 */
	public void setSelfempYn(String selfempYn) {
		this.selfempYn = selfempYn;
	}

	/**
	 * @return the selfempClassCd
	 */
	public String getSelfempClassCd() {
		return selfempClassCd;
	}

	/**
	 * @param selfempClassCd the selfempClassCd to set
	 */
	public void setSelfempClassCd(String selfempClassCd) {
		this.selfempClassCd = selfempClassCd;
	}

	/**
	 * @return the jobseekWaitDura
	 */
	public String getJobseekWaitDura() {
		return jobseekWaitDura;
	}

	/**
	 * @param jobseekWaitDura the jobseekWaitDura to set
	 */
	public void setJobseekWaitDura(String jobseekWaitDura) {
		this.jobseekWaitDura = jobseekWaitDura;
	}

	/**
	 * @return the fileGrpSeq
	 */
	public String getFileGrpSeq() {
		return fileGrpSeq;
	}

	/**
	 * @param fileGrpSeq the fileGrpSeq to set
	 */
	public void setFileGrpSeq(String fileGrpSeq) {
		this.fileGrpSeq = fileGrpSeq;
	}

	/**
	 * @return the proLicnsYn
	 */
	public String getProLicnsYn() {
		return proLicnsYn;
	}

	/**
	 * @param proLicnsYn the proLicnsYn to set
	 */
	public void setProLicnsYn(String proLicnsYn) {
		this.proLicnsYn = proLicnsYn;
	}

	/**
	 * @return the proLicnsSpec
	 */
	public String getProLicnsSpec() {
		return proLicnsSpec;
	}

	/**
	 * @param proLicnsSpec the proLicnsSpec to set
	 */
	public void setProLicnsSpec(String proLicnsSpec) {
		this.proLicnsSpec = proLicnsSpec;
	}

	/**
	 * @return the careerYn
	 */
	public String getCareerYn() {
		return careerYn;
	}

	/**
	 * @param careerYn the careerYn to set
	 */
	public void setCareerYn(String careerYn) {
		this.careerYn = careerYn;
	}

	/**
	 * @return the totCareerTermYearCnt
	 */
	public String getTotCareerTermYearCnt() {
		return totCareerTermYearCnt;
	}

	/**
	 * @param totCareerTermYearCnt the totCareerTermYearCnt to set
	 */
	public void setTotCareerTermYearCnt(String totCareerTermYearCnt) {
		this.totCareerTermYearCnt = totCareerTermYearCnt;
	}

	/**
	 * @return the totCareerTermMonthCnt
	 */
	public String getTotCareerTermMonthCnt() {
		return totCareerTermMonthCnt;
	}

	/**
	 * @param totCareerTermMonthCnt the totCareerTermMonthCnt to set
	 */
	public void setTotCareerTermMonthCnt(String totCareerTermMonthCnt) {
		this.totCareerTermMonthCnt = totCareerTermMonthCnt;
	}

	/**
	 * @return the jobCenterUserModDt
	 */
	public String getJobCenterUserModDt() {
		return jobCenterUserModDt;
	}

	/**
	 * @param jobCenterUserModDt the jobCenterUserModDt to set
	 */
	public void setJobCenterUserModDt(String jobCenterUserModDt) {
		this.jobCenterUserModDt = jobCenterUserModDt;
	}

	/**
	 * @return the jobCenterVerityUserSeq
	 */
	public String getJobCenterVerityUserSeq() {
		return jobCenterVerityUserSeq;
	}

	/**
	 * @param jobCenterVerityUserSeq the jobCenterVerityUserSeq to set
	 */
	public void setJobCenterVerityUserSeq(String jobCenterVerityUserSeq) {
		this.jobCenterVerityUserSeq = jobCenterVerityUserSeq;
	}

	/**
	 * @return the jobCenterNote
	 */
	public String getJobCenterNote() {
		return jobCenterNote;
	}

	/**
	 * @param jobCenterNote the jobCenterNote to set
	 */
	public void setJobCenterNote(String jobCenterNote) {
		this.jobCenterNote = jobCenterNote;
	}

	/**
	 * @return the uploadCv
	 */
	public String getUploadCv() {
		return uploadCv;
	}

	/**
	 * @param uploadCv the uploadCv to set
	 */
	public void setUploadCv(String uploadCv) {
		this.uploadCv = uploadCv;
	}

	/**
	 * @return the stepInput
	 */
	public String getStepInput() {
		return stepInput;
	}

	/**
	 * @param stepInput the stepInput to set
	 */
	public void setStepInput(String stepInput) {
		this.stepInput = stepInput;
	}

	/**
	 * @return the mobileId
	 */
	public String getMobileId() {
		return mobileId;
	}

	/**
	 * @param mobileId the mobileId to set
	 */
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	/**
	 * @return the resumeStsCd
	 */
	public String getResumeStsCd() {
		return resumeStsCd;
	}

	/**
	 * @param resumeStsCd the resumeStsCd to set
	 */
	public void setResumeStsCd(String resumeStsCd) {
		this.resumeStsCd = resumeStsCd;
	}

	/**
	 * @return the lastModDt
	 */
	public String getLastModDt() {
		return lastModDt;
	}

	/**
	 * @param lastModDt the lastModDt to set
	 */
	public void setLastModDt(String lastModDt) {
		this.lastModDt = lastModDt;
	}

	/**
	 * @return the preferJobTitle
	 */
	public String getPreferJobTitle() {
		return preferJobTitle;
	}

	/**
	 * @param preferJobTitle the preferJobTitle to set
	 */
	public void setPreferJobTitle(String preferJobTitle) {
		this.preferJobTitle = preferJobTitle;
	}

	/**
	 * @return the iscoCd
	 */
	public String getIscoCd() {
		return iscoCd;
	}

	/**
	 * @param iscoCd the iscoCd to set
	 */
	public void setIscoCd(String iscoCd) {
		this.iscoCd = iscoCd;
	}

	/**
	 * @return the isicCd
	 */
	public String getIsicCd() {
		return isicCd;
	}

	/**
	 * @param isicCd the isicCd to set
	 */
	public void setIsicCd(String isicCd) {
		this.isicCd = isicCd;
	}

	/**
	 * @return the employmtFormCd
	 */
	public String getEmploymtFormCd() {
		return employmtFormCd;
	}

	/**
	 * @param employmtFormCd the employmtFormCd to set
	 */
	public void setEmploymtFormCd(String employmtFormCd) {
		this.employmtFormCd = employmtFormCd;
	}

	/**
	 * @return the preferEmployTypeCd
	 */
	public String getPreferEmployTypeCd() {
		return preferEmployTypeCd;
	}

	/**
	 * @param preferEmployTypeCd the preferEmployTypeCd to set
	 */
	public void setPreferEmployTypeCd(String preferEmployTypeCd) {
		this.preferEmployTypeCd = preferEmployTypeCd;
	}

	/**
	 * @return the typeEmployHourDay
	 */
	public String getTypeEmployHourDay() {
		return typeEmployHourDay;
	}

	/**
	 * @param typeEmployHourDay the typeEmployHourDay to set
	 */
	public void setTypeEmployHourDay(String typeEmployHourDay) {
		this.typeEmployHourDay = typeEmployHourDay;
	}

	/**
	 * @return the typeEmployDayWeek
	 */
	public String getTypeEmployDayWeek() {
		return typeEmployDayWeek;
	}

	/**
	 * @param typeEmployDayWeek the typeEmployDayWeek to set
	 */
	public void setTypeEmployDayWeek(String typeEmployDayWeek) {
		this.typeEmployDayWeek = typeEmployDayWeek;
	}

	/**
	 * @return the preferCrtctTerms
	 */
	public String getPreferCrtctTerms() {
		return preferCrtctTerms;
	}

	/**
	 * @param preferCrtctTerms the preferCrtctTerms to set
	 */
	public void setPreferCrtctTerms(String preferCrtctTerms) {
		this.preferCrtctTerms = preferCrtctTerms;
	}

	/**
	 * @return the preferCrtctTermsDura
	 */
	public String getPreferCrtctTermsDura() {
		return preferCrtctTermsDura;
	}

	/**
	 * @param preferCrtctTermsDura the preferCrtctTermsDura to set
	 */
	public void setPreferCrtctTermsDura(String preferCrtctTermsDura) {
		this.preferCrtctTermsDura = preferCrtctTermsDura;
	}

	/**
	 * @return the preferCrtctType
	 */
	public String getPreferCrtctType() {
		return preferCrtctType;
	}

	/**
	 * @param preferCrtctType the preferCrtctType to set
	 */
	public void setPreferCrtctType(String preferCrtctType) {
		this.preferCrtctType = preferCrtctType;
	}

	/**
	 * @return the nightWorkYn
	 */
	public String getNightWorkYn() {
		return nightWorkYn;
	}

	/**
	 * @param nightWorkYn the nightWorkYn to set
	 */
	public void setNightWorkYn(String nightWorkYn) {
		this.nightWorkYn = nightWorkYn;
	}

	/**
	 * @return the overTimeWorkYn
	 */
	public String getOverTimeWorkYn() {
		return overTimeWorkYn;
	}

	/**
	 * @param overTimeWorkYn the overTimeWorkYn to set
	 */
	public void setOverTimeWorkYn(String overTimeWorkYn) {
		this.overTimeWorkYn = overTimeWorkYn;
	}

	/**
	 * @return the hldayWorkYn
	 */
	public String getHldayWorkYn() {
		return hldayWorkYn;
	}

	/**
	 * @param hldayWorkYn the hldayWorkYn to set
	 */
	public void setHldayWorkYn(String hldayWorkYn) {
		this.hldayWorkYn = hldayWorkYn;
	}

	/**
	 * @return the expctMinSalaryAmt
	 */
	public String getExpctMinSalaryAmt() {
		return expctMinSalaryAmt;
	}

	/**
	 * @param expctMinSalaryAmt the expctMinSalaryAmt to set
	 */
	public void setExpctMinSalaryAmt(String expctMinSalaryAmt) {
		this.expctMinSalaryAmt = expctMinSalaryAmt;
	}

	/**
	 * @return the expctMaxSalaryAmt
	 */
	public String getExpctMaxSalaryAmt() {
		return expctMaxSalaryAmt;
	}

	/**
	 * @param expctMaxSalaryAmt the expctMaxSalaryAmt to set
	 */
	public void setExpctMaxSalaryAmt(String expctMaxSalaryAmt) {
		this.expctMaxSalaryAmt = expctMaxSalaryAmt;
	}

	/**
	 * @return the expctSalaryTypeCd
	 */
	public String getExpctSalaryTypeCd() {
		return expctSalaryTypeCd;
	}

	/**
	 * @param expctSalaryTypeCd the expctSalaryTypeCd to set
	 */
	public void setExpctSalaryTypeCd(String expctSalaryTypeCd) {
		this.expctSalaryTypeCd = expctSalaryTypeCd;
	}

	/**
	 * @return the diffProvcWorkYn
	 */
	public String getDiffProvcWorkYn() {
		return diffProvcWorkYn;
	}

	/**
	 * @param diffProvcWorkYn the diffProvcWorkYn to set
	 */
	public void setDiffProvcWorkYn(String diffProvcWorkYn) {
		this.diffProvcWorkYn = diffProvcWorkYn;
	}

	/**
	 * @return the workBgnAbleYn
	 */
	public String getWorkBgnAbleYn() {
		return workBgnAbleYn;
	}

	/**
	 * @param workBgnAbleYn the workBgnAbleYn to set
	 */
	public void setWorkBgnAbleYn(String workBgnAbleYn) {
		this.workBgnAbleYn = workBgnAbleYn;
	}

	/**
	 * @return the workBgnAbleWithin
	 */
	public String getWorkBgnAbleWithin() {
		return workBgnAbleWithin;
	}

	/**
	 * @param workBgnAbleWithin the workBgnAbleWithin to set
	 */
	public void setWorkBgnAbleWithin(String workBgnAbleWithin) {
		this.workBgnAbleWithin = workBgnAbleWithin;
	}

	/**
	 * @return the birthAddrDtl
	 */
	public String getBirthAddrDtl() {
		return birthAddrDtl;
	}

	/**
	 * @param birthAddrDtl the birthAddrDtl to set
	 */
	public void setBirthAddrDtl(String birthAddrDtl) {
		this.birthAddrDtl = birthAddrDtl;
	}

	/**
	 * @return the preferPosition
	 */
	public String getPreferPosition() {
		return preferPosition;
	}

	/**
	 * @param preferPosition the preferPosition to set
	 */
	public void setPreferPosition(String preferPosition) {
		this.preferPosition = preferPosition;
	}

	/**
	 * @return the preferDayMon
	 */
	public String getPreferDayMon() {
		return preferDayMon;
	}

	/**
	 * @param preferDayMon the preferDayMon to set
	 */
	public void setPreferDayMon(String preferDayMon) {
		this.preferDayMon = preferDayMon;
	}

	/**
	 * @return the preferDayTue
	 */
	public String getPreferDayTue() {
		return preferDayTue;
	}

	/**
	 * @param preferDayTue the preferDayTue to set
	 */
	public void setPreferDayTue(String preferDayTue) {
		this.preferDayTue = preferDayTue;
	}

	/**
	 * @return the preferDayWed
	 */
	public String getPreferDayWed() {
		return preferDayWed;
	}

	/**
	 * @param preferDayWed the preferDayWed to set
	 */
	public void setPreferDayWed(String preferDayWed) {
		this.preferDayWed = preferDayWed;
	}

	/**
	 * @return the preferDayThu
	 */
	public String getPreferDayThu() {
		return preferDayThu;
	}

	/**
	 * @param preferDayThu the preferDayThu to set
	 */
	public void setPreferDayThu(String preferDayThu) {
		this.preferDayThu = preferDayThu;
	}

	/**
	 * @return the preferDayFri
	 */
	public String getPreferDayFri() {
		return preferDayFri;
	}

	/**
	 * @param preferDayFri the preferDayFri to set
	 */
	public void setPreferDayFri(String preferDayFri) {
		this.preferDayFri = preferDayFri;
	}

	/**
	 * @return the preferDaySat
	 */
	public String getPreferDaySat() {
		return preferDaySat;
	}

	/**
	 * @param preferDaySat the preferDaySat to set
	 */
	public void setPreferDaySat(String preferDaySat) {
		this.preferDaySat = preferDaySat;
	}

	/**
	 * @return the preferDaySun
	 */
	public String getPreferDaySun() {
		return preferDaySun;
	}

	/**
	 * @param preferDaySun the preferDaySun to set
	 */
	public void setPreferDaySun(String preferDaySun) {
		this.preferDaySun = preferDaySun;
	}

	/**
	 * @return the jcNm
	 */
	public String getJcNm() {
		return jcNm;
	}

	/**
	 * @param jcNm the jcNm to set
	 */
	public void setJcNm(String jcNm) {
		this.jcNm = jcNm;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the marriNm
	 */
	public String getMarriNm() {
		return marriNm;
	}

	/**
	 * @param marriNm the marriNm to set
	 */
	public void setMarriNm(String marriNm) {
		this.marriNm = marriNm;
	}

	/**
	 * @return the disablOptionNm
	 */
	public String getDisablOptionNm() {
		return disablOptionNm;
	}

	/**
	 * @param disablOptionNm the disablOptionNm to set
	 */
	public void setDisablOptionNm(String disablOptionNm) {
		this.disablOptionNm = disablOptionNm;
	}

	/**
	 * @return the employFormNm
	 */
	public String getEmployFormNm() {
		return employFormNm;
	}

	/**
	 * @param employFormNm the employFormNm to set
	 */
	public void setEmployFormNm(String employFormNm) {
		this.employFormNm = employFormNm;
	}

	/**
	 * @return the preferEmployTypeNm
	 */
	public String getPreferEmployTypeNm() {
		return preferEmployTypeNm;
	}

	/**
	 * @param preferEmployTypeNm the preferEmployTypeNm to set
	 */
	public void setPreferEmployTypeNm(String preferEmployTypeNm) {
		this.preferEmployTypeNm = preferEmployTypeNm;
	}

	/**
	 * @return the preferCrtctTypeNm
	 */
	public String getPreferCrtctTypeNm() {
		return preferCrtctTypeNm;
	}

	/**
	 * @param preferCrtctTypeNm the preferCrtctTypeNm to set
	 */
	public void setPreferCrtctTypeNm(String preferCrtctTypeNm) {
		this.preferCrtctTypeNm = preferCrtctTypeNm;
	}

	/**
	 * @return the preferWorkWeekDay
	 */
	public String getPreferWorkWeekDay() {
		return preferWorkWeekDay;
	}

	/**
	 * @param preferWorkWeekDay the preferWorkWeekDay to set
	 */
	public void setPreferWorkWeekDay(String preferWorkWeekDay) {
		this.preferWorkWeekDay = preferWorkWeekDay;
	}

	/**
	 * @return the additionalWorkOver
	 */
	public String getAdditionalWorkOver() {
		return additionalWorkOver;
	}

	/**
	 * @param additionalWorkOver the additionalWorkOver to set
	 */
	public void setAdditionalWorkOver(String additionalWorkOver) {
		this.additionalWorkOver = additionalWorkOver;
	}

	/**
	 * @return the eduGnrlIscedNm
	 */
	public String getEduGnrlIscedNm() {
		return eduGnrlIscedNm;
	}

	/**
	 * @param eduGnrlIscedNm the eduGnrlIscedNm to set
	 */
	public void setEduGnrlIscedNm(String eduGnrlIscedNm) {
		this.eduGnrlIscedNm = eduGnrlIscedNm;
	}

	/**
	 * @return the eduSkillIscedNm
	 */
	public String getEduSkillIscedNm() {
		return eduSkillIscedNm;
	}

	/**
	 * @param eduSkillIscedNm the eduSkillIscedNm to set
	 */
	public void setEduSkillIscedNm(String eduSkillIscedNm) {
		this.eduSkillIscedNm = eduSkillIscedNm;
	}

	/**
	 * @return the iscoList
	 */
	public String getIscoList() {
		return iscoList;
	}

	/**
	 * @param iscoList the iscoList to set
	 */
	public void setIscoList(String iscoList) {
		this.iscoList = iscoList;
	}

	/**
	 * @return the preferWorkLocList
	 */
	public String getPreferWorkLocList() {
		return preferWorkLocList;
	}

	/**
	 * @param preferWorkLocList the preferWorkLocList to set
	 */
	public void setPreferWorkLocList(String preferWorkLocList) {
		this.preferWorkLocList = preferWorkLocList;
	}

	/**
	 * @return the jcUserNm
	 */
	public String getJcUserNm() {
		return jcUserNm;
	}

	/**
	 * @param jcUserNm the jcUserNm to set
	 */
	public void setJcUserNm(String jcUserNm) {
		this.jcUserNm = jcUserNm;
	}

	/**
	 * @return the selectedList
	 */
	public List<String> getSelectedList() {
		return selectedList;
	}

	/**
	 * @param selectedList the selectedList to set
	 */
	public void setSelectedList(List<String> selectedList) {
		this.selectedList = selectedList;
	}

  	
	

}
