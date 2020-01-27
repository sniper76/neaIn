package ony.cpes.internal.user.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Elementary User Bean
 * @author onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 *
 *
 *  Modify Date     Modifier    Description
 *  ------------- 	-------- 	---------------------------
 *  2019.12.05 		Joo
 *
 * </pre>
 */
public class UserElementaryBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	//0. System Parameter
	private String sysLangCd				= "";

	//1. Base Parameter
	private String userSeq					= "";
	private String userId					= "";
	private String userAuthCd				= "";
	private String userEmail				= "";
	private String userCell					= "";
	private String userNm					= "";
	private String userNmEn					= "";
	private String userNmKh					= "";
	private String birth					= "";
	private String birthD					= "";
	private String birthM					= "";
	private String birthY					= "";
	private String genderCd					= "";
	private String birthLocCd				= "";
	private String addrCd					= "";
	private String addrDtl					= "";
	private String nationCd					= "";
	private String marriCd					= "";
	private String familyCnt				= "";
	private String nid						= "";
	private String jcCd						= "";
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
	private String userStsCd				= "";
	private String accntLockStsCd			= "";
	private String wthdrReasonCd			= "";
	private String wthdrReason				= "";
	private String fileGrpSeq				= "";
	private String lastLoginDt				= "";
	private String lastLoginIp				= "";
	private String regUserSeq				= "";
	private String regDt					= "";
	private String modUserSeq				= "";
	private String modDt					= "";
	private String authCmpltYn				= "";
	private String smsEmailAuthDivCd		= "";
	private String joinRouteDivCd 			= "";
	private String dormancyYn				= "";
	private String infoOpenYn				= "";
	private String concilReqYn				= "";
	private String neaJcDivCd               = "";
	private List<UserElementaryBean> list;

	//Additional Data Parameter
	private String mngId					= "";
	private String mngYn					= "";
    private String userNewPwd				= "";
	private String pwdChgYn					= "";
	private String jcNm						= "";
	private String userAuthNm				= "";
	private String age						= "";
	private String jobskStsNm				= "";
	private String genderNm					= "";
	private String userStsNm				= "";
	private List<String> selectedList 		= new ArrayList<String>();
	private String smsEmailAuthDivNm		= "";
	private String joinRouteDivNm 			= "";
	private String birthYear				= "";
	private String birthMonth				= "";
	private String birthDay					= "";
	private String smsNtceAgreeMsg			= "";
	private String userCellDup				= "";
	private String addrFullCd				= "";
	private String addrFullNm				= "";
	private String useYn					= "";
	private String authCmpltNm				= "";
	private String chgReason				= "";
	private String saveDt					= "";
	private String beforeUserAuthCd			= "";
	private String afterUserAuthCd			= "";
	private String userPasswd				= "";
	
	// Search Condition Parameter
	private String srchDivCd				= "";
	private String srchDivKeyword			= "";
	private String jobskStsCd				= "";
	private String srchAddrCd				= "";


	private String resumeCnt				= "";
	private String filePath                 = "";
	
	
	
	
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
	 * @return the userNmEn
	 */
	public String getUserNmEn() {
		return userNmEn;
	}
	/**
	 * @param userNmEn the userNmEn to set
	 */
	public void setUserNmEn(String userNmEn) {
		this.userNmEn = userNmEn;
	}
	/**
	 * @return the userNmKh
	 */
	public String getUserNmKh() {
		return userNmKh;
	}
	/**
	 * @param userNmKh the userNmKh to set
	 */
	public void setUserNmKh(String userNmKh) {
		this.userNmKh = userNmKh;
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
	 * @return the birthD
	 */
	public String getBirthD() {
		return birthD;
	}
	/**
	 * @param birthD the birthD to set
	 */
	public void setBirthD(String birthD) {
		this.birthD = birthD;
	}
	/**
	 * @return the birthM
	 */
	public String getBirthM() {
		return birthM;
	}
	/**
	 * @param birthM the birthM to set
	 */
	public void setBirthM(String birthM) {
		this.birthM = birthM;
	}
	/**
	 * @return the birthY
	 */
	public String getBirthY() {
		return birthY;
	}
	/**
	 * @param birthY the birthY to set
	 */
	public void setBirthY(String birthY) {
		this.birthY = birthY;
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
	 * @return the dormancyYn
	 */
	public String getDormancyYn() {
		return dormancyYn;
	}
	/**
	 * @param dormancyYn the dormancyYn to set
	 */
	public void setDormancyYn(String dormancyYn) {
		this.dormancyYn = dormancyYn;
	}
	/**
	 * @return the infoOpenYn
	 */
	public String getInfoOpenYn() {
		return infoOpenYn;
	}
	/**
	 * @param infoOpenYn the infoOpenYn to set
	 */
	public void setInfoOpenYn(String infoOpenYn) {
		this.infoOpenYn = infoOpenYn;
	}
	/**
	 * @return the concilReqYn
	 */
	public String getConcilReqYn() {
		return concilReqYn;
	}
	/**
	 * @param concilReqYn the concilReqYn to set
	 */
	public void setConcilReqYn(String concilReqYn) {
		this.concilReqYn = concilReqYn;
	}
	/**
	 * @return the neaJcDivCd
	 */
	public String getNeaJcDivCd() {
		return neaJcDivCd;
	}
	/**
	 * @param neaJcDivCd the neaJcDivCd to set
	 */
	public void setNeaJcDivCd(String neaJcDivCd) {
		this.neaJcDivCd = neaJcDivCd;
	}
	/**
	 * @return the list
	 */
	public List<UserElementaryBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserElementaryBean> list) {
		this.list = list;
	}
	/**
	 * @return the mngId
	 */
	public String getMngId() {
		return mngId;
	}
	/**
	 * @param mngId the mngId to set
	 */
	public void setMngId(String mngId) {
		this.mngId = mngId;
	}
	/**
	 * @return the mngYn
	 */
	public String getMngYn() {
		return mngYn;
	}
	/**
	 * @param mngYn the mngYn to set
	 */
	public void setMngYn(String mngYn) {
		this.mngYn = mngYn;
	}
	/**
	 * @return the userNewPwd
	 */
	public String getUserNewPwd() {
		return userNewPwd;
	}
	/**
	 * @param userNewPwd the userNewPwd to set
	 */
	public void setUserNewPwd(String userNewPwd) {
		this.userNewPwd = userNewPwd;
	}
	/**
	 * @return the pwdChgYn
	 */
	public String getPwdChgYn() {
		return pwdChgYn;
	}
	/**
	 * @param pwdChgYn the pwdChgYn to set
	 */
	public void setPwdChgYn(String pwdChgYn) {
		this.pwdChgYn = pwdChgYn;
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
	/**
	 * @return the smsEmailAuthDivNm
	 */
	public String getSmsEmailAuthDivNm() {
		return smsEmailAuthDivNm;
	}
	/**
	 * @param smsEmailAuthDivNm the smsEmailAuthDivNm to set
	 */
	public void setSmsEmailAuthDivNm(String smsEmailAuthDivNm) {
		this.smsEmailAuthDivNm = smsEmailAuthDivNm;
	}
	/**
	 * @return the joinRouteDivNm
	 */
	public String getJoinRouteDivNm() {
		return joinRouteDivNm;
	}
	/**
	 * @param joinRouteDivNm the joinRouteDivNm to set
	 */
	public void setJoinRouteDivNm(String joinRouteDivNm) {
		this.joinRouteDivNm = joinRouteDivNm;
	}
	/**
	 * @return the birthYear
	 */
	public String getBirthYear() {
		return birthYear;
	}
	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	/**
	 * @return the birthMonth
	 */
	public String getBirthMonth() {
		return birthMonth;
	}
	/**
	 * @param birthMonth the birthMonth to set
	 */
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	/**
	 * @return the birthDay
	 */
	public String getBirthDay() {
		return birthDay;
	}
	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * @return the smsNtceAgreeMsg
	 */
	public String getSmsNtceAgreeMsg() {
		return smsNtceAgreeMsg;
	}
	/**
	 * @param smsNtceAgreeMsg the smsNtceAgreeMsg to set
	 */
	public void setSmsNtceAgreeMsg(String smsNtceAgreeMsg) {
		this.smsNtceAgreeMsg = smsNtceAgreeMsg;
	}
	/**
	 * @return the userCellDup
	 */
	public String getUserCellDup() {
		return userCellDup;
	}
	/**
	 * @param userCellDup the userCellDup to set
	 */
	public void setUserCellDup(String userCellDup) {
		this.userCellDup = userCellDup;
	}
	/**
	 * @return the addrFullCd
	 */
	public String getAddrFullCd() {
		return addrFullCd;
	}
	/**
	 * @param addrFullCd the addrFullCd to set
	 */
	public void setAddrFullCd(String addrFullCd) {
		this.addrFullCd = addrFullCd;
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
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}
	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	/**
	 * @return the authCmpltNm
	 */
	public String getAuthCmpltNm() {
		return authCmpltNm;
	}
	/**
	 * @param authCmpltNm the authCmpltNm to set
	 */
	public void setAuthCmpltNm(String authCmpltNm) {
		this.authCmpltNm = authCmpltNm;
	}
	/**
	 * @return the chgReason
	 */
	public String getChgReason() {
		return chgReason;
	}
	/**
	 * @param chgReason the chgReason to set
	 */
	public void setChgReason(String chgReason) {
		this.chgReason = chgReason;
	}
	/**
	 * @return the saveDt
	 */
	public String getSaveDt() {
		return saveDt;
	}
	/**
	 * @param saveDt the saveDt to set
	 */
	public void setSaveDt(String saveDt) {
		this.saveDt = saveDt;
	}
	/**
	 * @return the beforeUserAuthCd
	 */
	public String getBeforeUserAuthCd() {
		return beforeUserAuthCd;
	}
	/**
	 * @param beforeUserAuthCd the beforeUserAuthCd to set
	 */
	public void setBeforeUserAuthCd(String beforeUserAuthCd) {
		this.beforeUserAuthCd = beforeUserAuthCd;
	}
	/**
	 * @return the afterUserAuthCd
	 */
	public String getAfterUserAuthCd() {
		return afterUserAuthCd;
	}
	/**
	 * @param afterUserAuthCd the afterUserAuthCd to set
	 */
	public void setAfterUserAuthCd(String afterUserAuthCd) {
		this.afterUserAuthCd = afterUserAuthCd;
	}
	/**
	 * @return the userPasswd
	 */
	public String getUserPasswd() {
		return userPasswd;
	}
	/**
	 * @param userPasswd the userPasswd to set
	 */
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
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
	 * @return the srchAddrCd
	 */
	public String getSrchAddrCd() {
		return srchAddrCd;
	}
	/**
	 * @param srchAddrCd the srchAddrCd to set
	 */
	public void setSrchAddrCd(String srchAddrCd) {
		this.srchAddrCd = srchAddrCd;
	}
	/**
	 * @return the resumeCnt
	 */
	public String getResumeCnt() {
		return resumeCnt;
	}
	/**
	 * @param resumeCnt the resumeCnt to set
	 */
	public void setResumeCnt(String resumeCnt) {
		this.resumeCnt = resumeCnt;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	


}
