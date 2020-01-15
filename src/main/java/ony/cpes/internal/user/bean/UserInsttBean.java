package ony.cpes.internal.user.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Institution User Bean
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
 *  2019.10.20		Joo			
 *
 * </pre>
 */
public class UserInsttBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String		sysLangCd				= "";
	
	//1. Base Parameter
	private String 		insttSeq				= "";
	private String 		userSeq					= "";
	private String		insttNmKh				= "";
	private String		insttNmEn				= "";
	private String 		insttOwnerNm			= "";
	private String 		insttTypeCd				= "";
	private String 		insttTypeNm				= "";
	private String 		insttRegNum				= "";
	private String 		insttAddrCd				= "";
	private String		insttAddrDtl			= "";
	private String 		insttContent			= "";
	private String 		insttMngerNm			= "";
	private String 		insttOfficeTel			= "";
	private String 		insttCell				= "";
	private String 		insttFax				= "";
	private String 		insttEmail				= "";
	private String 		insttWebsite			= "";
	private String 		fileGrpSeq				= "";
	private String 		insttStsCd				= "";
	private String 		insttStsNm				= "";
	private String 		regUserSeq				= "";
	private String 		regDt					= "";
	private String 		modUserSeq				= "";
	private String 		modDt					= "";
	private String 		insttOwnerCd			= "";
	private String		insttProfile			= "";
	private String		insttHis				= "";
	private String		insttMapLink			= "";
	
	private List<UserInsttBean> list;
	
	//2. Additional Parameter
	private String 		insttNm					= "";
	private String 		userId					= "";
	private String		userStsCd				= "";
	private String		userStsNm				= "";
	private String 		srchDivCd				= "";
	private String 		srchDivKeyword			= "";
	private String 		jcCd					= "";
	private String		jcNm					= "";
	private String		authCmpltYn				= "";
	private String		smsEmailAuthDivNm		= "";
	private String 		insttOwnershipNm		= "";
	private String      filePath                = "";
	
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
	 * @return the insttSeq
	 */
	public String getInsttSeq() {
		return insttSeq;
	}

	/**
	 * @param insttSeq the insttSeq to set
	 */
	public void setInsttSeq(String insttSeq) {
		this.insttSeq = insttSeq;
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
	 * @return the insttNmKh
	 */
	public String getInsttNmKh() {
		return insttNmKh;
	}

	/**
	 * @param insttNmKh the insttNmKh to set
	 */
	public void setInsttNmKh(String insttNmKh) {
		this.insttNmKh = insttNmKh;
	}

	/**
	 * @return the insttNmEn
	 */
	public String getInsttNmEn() {
		return insttNmEn;
	}

	/**
	 * @param insttNmEn the insttNmEn to set
	 */
	public void setInsttNmEn(String insttNmEn) {
		this.insttNmEn = insttNmEn;
	}

	/**
	 * @return the insttOwnerNm
	 */
	public String getInsttOwnerNm() {
		return insttOwnerNm;
	}

	/**
	 * @param insttOwnerNm the insttOwnerNm to set
	 */
	public void setInsttOwnerNm(String insttOwnerNm) {
		this.insttOwnerNm = insttOwnerNm;
	}

	/**
	 * @return the insttTypeCd
	 */
	public String getInsttTypeCd() {
		return insttTypeCd;
	}

	/**
	 * @param insttTypeCd the insttTypeCd to set
	 */
	public void setInsttTypeCd(String insttTypeCd) {
		this.insttTypeCd = insttTypeCd;
	}

	/**
	 * @return the insttTypeNm
	 */
	public String getInsttTypeNm() {
		return insttTypeNm;
	}

	/**
	 * @param insttTypeNm the insttTypeNm to set
	 */
	public void setInsttTypeNm(String insttTypeNm) {
		this.insttTypeNm = insttTypeNm;
	}

	/**
	 * @return the insttRegNum
	 */
	public String getInsttRegNum() {
		return insttRegNum;
	}

	/**
	 * @param insttRegNum the insttRegNum to set
	 */
	public void setInsttRegNum(String insttRegNum) {
		this.insttRegNum = insttRegNum;
	}

	/**
	 * @return the insttAddrCd
	 */
	public String getInsttAddrCd() {
		return insttAddrCd;
	}

	/**
	 * @param insttAddrCd the insttAddrCd to set
	 */
	public void setInsttAddrCd(String insttAddrCd) {
		this.insttAddrCd = insttAddrCd;
	}

	/**
	 * @return the insttAddrDtl
	 */
	public String getInsttAddrDtl() {
		return insttAddrDtl;
	}

	/**
	 * @param insttAddrDtl the insttAddrDtl to set
	 */
	public void setInsttAddrDtl(String insttAddrDtl) {
		this.insttAddrDtl = insttAddrDtl;
	}

	/**
	 * @return the insttContent
	 */
	public String getInsttContent() {
		return insttContent;
	}

	/**
	 * @param insttContent the insttContent to set
	 */
	public void setInsttContent(String insttContent) {
		this.insttContent = insttContent;
	}

	/**
	 * @return the insttMngerNm
	 */
	public String getInsttMngerNm() {
		return insttMngerNm;
	}

	/**
	 * @param insttMngerNm the insttMngerNm to set
	 */
	public void setInsttMngerNm(String insttMngerNm) {
		this.insttMngerNm = insttMngerNm;
	}

	/**
	 * @return the insttOfficeTel
	 */
	public String getInsttOfficeTel() {
		return insttOfficeTel;
	}

	/**
	 * @param insttOfficeTel the insttOfficeTel to set
	 */
	public void setInsttOfficeTel(String insttOfficeTel) {
		this.insttOfficeTel = insttOfficeTel;
	}

	/**
	 * @return the insttCell
	 */
	public String getInsttCell() {
		return insttCell;
	}

	/**
	 * @param insttCell the insttCell to set
	 */
	public void setInsttCell(String insttCell) {
		this.insttCell = insttCell;
	}

	/**
	 * @return the insttFax
	 */
	public String getInsttFax() {
		return insttFax;
	}

	/**
	 * @param insttFax the insttFax to set
	 */
	public void setInsttFax(String insttFax) {
		this.insttFax = insttFax;
	}

	/**
	 * @return the insttEmail
	 */
	public String getInsttEmail() {
		return insttEmail;
	}

	/**
	 * @param insttEmail the insttEmail to set
	 */
	public void setInsttEmail(String insttEmail) {
		this.insttEmail = insttEmail;
	}

	/**
	 * @return the insttWebsite
	 */
	public String getInsttWebsite() {
		return insttWebsite;
	}

	/**
	 * @param insttWebsite the insttWebsite to set
	 */
	public void setInsttWebsite(String insttWebsite) {
		this.insttWebsite = insttWebsite;
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
	 * @return the insttStsCd
	 */
	public String getInsttStsCd() {
		return insttStsCd;
	}

	/**
	 * @param insttStsCd the insttStsCd to set
	 */
	public void setInsttStsCd(String insttStsCd) {
		this.insttStsCd = insttStsCd;
	}

	/**
	 * @return the insttStsNm
	 */
	public String getInsttStsNm() {
		return insttStsNm;
	}

	/**
	 * @param insttStsNm the insttStsNm to set
	 */
	public void setInsttStsNm(String insttStsNm) {
		this.insttStsNm = insttStsNm;
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
	 * @return the insttOwnerCd
	 */
	public String getInsttOwnerCd() {
		return insttOwnerCd;
	}

	/**
	 * @param insttOwnerCd the insttOwnerCd to set
	 */
	public void setInsttOwnerCd(String insttOwnerCd) {
		this.insttOwnerCd = insttOwnerCd;
	}

	/**
	 * @return the insttProfile
	 */
	public String getInsttProfile() {
		return insttProfile;
	}

	/**
	 * @param insttProfile the insttProfile to set
	 */
	public void setInsttProfile(String insttProfile) {
		this.insttProfile = insttProfile;
	}

	/**
	 * @return the insttHis
	 */
	public String getInsttHis() {
		return insttHis;
	}

	/**
	 * @param insttHis the insttHis to set
	 */
	public void setInsttHis(String insttHis) {
		this.insttHis = insttHis;
	}

	/**
	 * @return the insttMapLink
	 */
	public String getInsttMapLink() {
		return insttMapLink;
	}

	/**
	 * @param insttMapLink the insttMapLink to set
	 */
	public void setInsttMapLink(String insttMapLink) {
		this.insttMapLink = insttMapLink;
	}

	/**
	 * @return the list
	 */
	public List<UserInsttBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<UserInsttBean> list) {
		this.list = list;
	}

	/**
	 * @return the insttNm
	 */
	public String getInsttNm() {
		return insttNm;
	}

	/**
	 * @param insttNm the insttNm to set
	 */
	public void setInsttNm(String insttNm) {
		this.insttNm = insttNm;
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
	 * @return the insttOwnershipNm
	 */
	public String getInsttOwnershipNm() {
		return insttOwnershipNm;
	}

	/**
	 * @param insttOwnershipNm the insttOwnershipNm to set
	 */
	public void setInsttOwnershipNm(String insttOwnershipNm) {
		this.insttOwnershipNm = insttOwnershipNm;
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
