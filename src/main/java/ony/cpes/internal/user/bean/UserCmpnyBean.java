package ony.cpes.internal.user.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Company User Bean
 * @author onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << (Modification Information) >>
 *
 *  Modify Date     Modifier    Description
 *  -------------	-------- 	---------------------------
 *  2019.10.26		Joo			
 *
 * </pre>
 */
public class UserCmpnyBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String	sysLangCd				= "";
	
	//1. Base Parameter
	private String 	compnySeq				= "";
	private String 	compnyId				= "";
	private String 	compnyNmKh				= "";
	private String 	compnyNmEn				= "";
	private String 	compnyTypeCd			= "";
	private String 	userSeq					= "";
	private String 	userId					= "";
	private String 	jcCd					= "";
	private String 	jcUserSeq				= "";
	private String 	isicCd					= "";
	private String 	regNum					= "";
	private String 	patentNum				= "";
	private String 	ownerNationCd			= "";
	private String	employeeTotCnt			= "";
	private String 	femaleEmployeeTotCnt	= "";
	private String 	disablEmployeeTotCnt	= "";
	private String 	forgnerTotCnt			= "";
	private String 	mainJobNm				= "";
	private String	mainJobPercent			= "";
	private String 	iscoCd					= "";
	private String 	addrDtl					= "";
	private String 	addrCd					= "";
	private String 	mngerNm					= "";
	private String 	mngerPosition			= "";
	private String 	mngerCell				= "";
	private String 	mngerEmail				= "";
	private String 	mngerTel				= "";
	private String 	compnyFax				= "";
	private String 	compnyWebsite			= "";
	private String 	compnyFacebook			= "";
	private String	lngtd					= "";
	private String	lattd					= "";
	private String 	profile					= "";
	private String 	fileGrpSeq				= "";
	private String 	bkmkCnt					= "";
	private String 	likeCnt					= "";
	private String 	useYn					= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";
	private String	exeEmployeeTotCnt		= "";
	private String	compnyHis				= "";
	private String  filePath                = "";
	
	private List<UserCmpnyBean> list;

	//2. Additional Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String 	compnyTypeNm			= "";
	private String 	jcNm					= "";
	private String 	ownerNationNm			= "";
	private String 	iscoNm					= "";
	private String 	isicNm					= "";
	private String 	userStsCd				= "";
	private String 	userStsNm				= "";
	private String 	compnyNm				= "";
	private String 	srchDivCd				= "";
	private String 	srchDivKeyword			= "";
	private String	smsNcteAgreeYn			= "";
	private String	emailNcteAgreeYn		= "";
	private String	exeEmployeeRate			= "";
		
		
	

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
	 * @return the compnySeq
	 */
	public String getCompnySeq() {
		return compnySeq;
	}

	/**
	 * @param compnySeq the compnySeq to set
	 */
	public void setCompnySeq(String compnySeq) {
		this.compnySeq = compnySeq;
	}

	/**
	 * @return the compnyId
	 */
	public String getCompnyId() {
		return compnyId;
	}

	/**
	 * @param compnyId the compnyId to set
	 */
	public void setCompnyId(String compnyId) {
		this.compnyId = compnyId;
	}

	/**
	 * @return the compnyNmKh
	 */
	public String getCompnyNmKh() {
		return compnyNmKh;
	}

	/**
	 * @param compnyNmKh the compnyNmKh to set
	 */
	public void setCompnyNmKh(String compnyNmKh) {
		this.compnyNmKh = compnyNmKh;
	}

	/**
	 * @return the compnyNmEn
	 */
	public String getCompnyNmEn() {
		return compnyNmEn;
	}

	/**
	 * @param compnyNmEn the compnyNmEn to set
	 */
	public void setCompnyNmEn(String compnyNmEn) {
		this.compnyNmEn = compnyNmEn;
	}

	/**
	 * @return the compnyTypeCd
	 */
	public String getCompnyTypeCd() {
		return compnyTypeCd;
	}

	/**
	 * @param compnyTypeCd the compnyTypeCd to set
	 */
	public void setCompnyTypeCd(String compnyTypeCd) {
		this.compnyTypeCd = compnyTypeCd;
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
	 * @return the regNum
	 */
	public String getRegNum() {
		return regNum;
	}

	/**
	 * @param regNum the regNum to set
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	/**
	 * @return the patentNum
	 */
	public String getPatentNum() {
		return patentNum;
	}

	/**
	 * @param patentNum the patentNum to set
	 */
	public void setPatentNum(String patentNum) {
		this.patentNum = patentNum;
	}

	/**
	 * @return the ownerNationCd
	 */
	public String getOwnerNationCd() {
		return ownerNationCd;
	}

	/**
	 * @param ownerNationCd the ownerNationCd to set
	 */
	public void setOwnerNationCd(String ownerNationCd) {
		this.ownerNationCd = ownerNationCd;
	}

	/**
	 * @return the employeeTotCnt
	 */
	public String getEmployeeTotCnt() {
		return employeeTotCnt;
	}

	/**
	 * @param employeeTotCnt the employeeTotCnt to set
	 */
	public void setEmployeeTotCnt(String employeeTotCnt) {
		this.employeeTotCnt = employeeTotCnt;
	}

	/**
	 * @return the femaleEmployeeTotCnt
	 */
	public String getFemaleEmployeeTotCnt() {
		return femaleEmployeeTotCnt;
	}

	/**
	 * @param femaleEmployeeTotCnt the femaleEmployeeTotCnt to set
	 */
	public void setFemaleEmployeeTotCnt(String femaleEmployeeTotCnt) {
		this.femaleEmployeeTotCnt = femaleEmployeeTotCnt;
	}

	/**
	 * @return the disablEmployeeTotCnt
	 */
	public String getDisablEmployeeTotCnt() {
		return disablEmployeeTotCnt;
	}

	/**
	 * @param disablEmployeeTotCnt the disablEmployeeTotCnt to set
	 */
	public void setDisablEmployeeTotCnt(String disablEmployeeTotCnt) {
		this.disablEmployeeTotCnt = disablEmployeeTotCnt;
	}

	/**
	 * @return the forgnerTotCnt
	 */
	public String getForgnerTotCnt() {
		return forgnerTotCnt;
	}

	/**
	 * @param forgnerTotCnt the forgnerTotCnt to set
	 */
	public void setForgnerTotCnt(String forgnerTotCnt) {
		this.forgnerTotCnt = forgnerTotCnt;
	}

	/**
	 * @return the mainJobNm
	 */
	public String getMainJobNm() {
		return mainJobNm;
	}

	/**
	 * @param mainJobNm the mainJobNm to set
	 */
	public void setMainJobNm(String mainJobNm) {
		this.mainJobNm = mainJobNm;
	}

	/**
	 * @return the mainJobPercent
	 */
	public String getMainJobPercent() {
		return mainJobPercent;
	}

	/**
	 * @param mainJobPercent the mainJobPercent to set
	 */
	public void setMainJobPercent(String mainJobPercent) {
		this.mainJobPercent = mainJobPercent;
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
	 * @return the mngerNm
	 */
	public String getMngerNm() {
		return mngerNm;
	}

	/**
	 * @param mngerNm the mngerNm to set
	 */
	public void setMngerNm(String mngerNm) {
		this.mngerNm = mngerNm;
	}

	/**
	 * @return the mngerPosition
	 */
	public String getMngerPosition() {
		return mngerPosition;
	}

	/**
	 * @param mngerPosition the mngerPosition to set
	 */
	public void setMngerPosition(String mngerPosition) {
		this.mngerPosition = mngerPosition;
	}

	/**
	 * @return the mngerCell
	 */
	public String getMngerCell() {
		return mngerCell;
	}

	/**
	 * @param mngerCell the mngerCell to set
	 */
	public void setMngerCell(String mngerCell) {
		this.mngerCell = mngerCell;
	}

	/**
	 * @return the mngerEmail
	 */
	public String getMngerEmail() {
		return mngerEmail;
	}

	/**
	 * @param mngerEmail the mngerEmail to set
	 */
	public void setMngerEmail(String mngerEmail) {
		this.mngerEmail = mngerEmail;
	}

	/**
	 * @return the mngerTel
	 */
	public String getMngerTel() {
		return mngerTel;
	}

	/**
	 * @param mngerTel the mngerTel to set
	 */
	public void setMngerTel(String mngerTel) {
		this.mngerTel = mngerTel;
	}

	/**
	 * @return the compnyFax
	 */
	public String getCompnyFax() {
		return compnyFax;
	}

	/**
	 * @param compnyFax the compnyFax to set
	 */
	public void setCompnyFax(String compnyFax) {
		this.compnyFax = compnyFax;
	}

	/**
	 * @return the compnyWebsite
	 */
	public String getCompnyWebsite() {
		return compnyWebsite;
	}

	/**
	 * @param compnyWebsite the compnyWebsite to set
	 */
	public void setCompnyWebsite(String compnyWebsite) {
		this.compnyWebsite = compnyWebsite;
	}

	/**
	 * @return the compnyFacebook
	 */
	public String getCompnyFacebook() {
		return compnyFacebook;
	}

	/**
	 * @param compnyFacebook the compnyFacebook to set
	 */
	public void setCompnyFacebook(String compnyFacebook) {
		this.compnyFacebook = compnyFacebook;
	}

	/**
	 * @return the lngtd
	 */
	public String getLngtd() {
		return lngtd;
	}

	/**
	 * @param lngtd the lngtd to set
	 */
	public void setLngtd(String lngtd) {
		this.lngtd = lngtd;
	}

	/**
	 * @return the lattd
	 */
	public String getLattd() {
		return lattd;
	}

	/**
	 * @param lattd the lattd to set
	 */
	public void setLattd(String lattd) {
		this.lattd = lattd;
	}

	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
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
	 * @return the bkmkCnt
	 */
	public String getBkmkCnt() {
		return bkmkCnt;
	}

	/**
	 * @param bkmkCnt the bkmkCnt to set
	 */
	public void setBkmkCnt(String bkmkCnt) {
		this.bkmkCnt = bkmkCnt;
	}

	/**
	 * @return the likeCnt
	 */
	public String getLikeCnt() {
		return likeCnt;
	}

	/**
	 * @param likeCnt the likeCnt to set
	 */
	public void setLikeCnt(String likeCnt) {
		this.likeCnt = likeCnt;
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
	 * @return the exeEmployeeTotCnt
	 */
	public String getExeEmployeeTotCnt() {
		return exeEmployeeTotCnt;
	}

	/**
	 * @param exeEmployeeTotCnt the exeEmployeeTotCnt to set
	 */
	public void setExeEmployeeTotCnt(String exeEmployeeTotCnt) {
		this.exeEmployeeTotCnt = exeEmployeeTotCnt;
	}

	/**
	 * @return the compnyHis
	 */
	public String getCompnyHis() {
		return compnyHis;
	}

	/**
	 * @param compnyHis the compnyHis to set
	 */
	public void setCompnyHis(String compnyHis) {
		this.compnyHis = compnyHis;
	}

	/**
	 * @return the list
	 */
	public List<UserCmpnyBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<UserCmpnyBean> list) {
		this.list = list;
	}

	/**
	 * @return the compnyTypeNm
	 */
	public String getCompnyTypeNm() {
		return compnyTypeNm;
	}

	/**
	 * @param compnyTypeNm the compnyTypeNm to set
	 */
	public void setCompnyTypeNm(String compnyTypeNm) {
		this.compnyTypeNm = compnyTypeNm;
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
	 * @return the ownerNationNm
	 */
	public String getOwnerNationNm() {
		return ownerNationNm;
	}

	/**
	 * @param ownerNationNm the ownerNationNm to set
	 */
	public void setOwnerNationNm(String ownerNationNm) {
		this.ownerNationNm = ownerNationNm;
	}

	/**
	 * @return the iscoNm
	 */
	public String getIscoNm() {
		return iscoNm;
	}

	/**
	 * @param iscoNm the iscoNm to set
	 */
	public void setIscoNm(String iscoNm) {
		this.iscoNm = iscoNm;
	}

	/**
	 * @return the isicNm
	 */
	public String getIsicNm() {
		return isicNm;
	}

	/**
	 * @param isicNm the isicNm to set
	 */
	public void setIsicNm(String isicNm) {
		this.isicNm = isicNm;
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
	 * @return the compnyNm
	 */
	public String getCompnyNm() {
		return compnyNm;
	}

	/**
	 * @param compnyNm the compnyNm to set
	 */
	public void setCompnyNm(String compnyNm) {
		this.compnyNm = compnyNm;
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
	 * @return the smsNcteAgreeYn
	 */
	public String getSmsNcteAgreeYn() {
		return smsNcteAgreeYn;
	}

	/**
	 * @param smsNcteAgreeYn the smsNcteAgreeYn to set
	 */
	public void setSmsNcteAgreeYn(String smsNcteAgreeYn) {
		this.smsNcteAgreeYn = smsNcteAgreeYn;
	}

	/**
	 * @return the emailNcteAgreeYn
	 */
	public String getEmailNcteAgreeYn() {
		return emailNcteAgreeYn;
	}

	/**
	 * @param emailNcteAgreeYn the emailNcteAgreeYn to set
	 */
	public void setEmailNcteAgreeYn(String emailNcteAgreeYn) {
		this.emailNcteAgreeYn = emailNcteAgreeYn;
	}

	/**
	 * @return the exeEmployeeRate
	 */
	public String getExeEmployeeRate() {
		return exeEmployeeRate;
	}

	/**
	 * @param exeEmployeeRate the exeEmployeeRate to set
	 */
	public void setExeEmployeeRate(String exeEmployeeRate) {
		this.exeEmployeeRate = exeEmployeeRate;
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
