package ony.cpes.internal.user.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Resume
 * @author onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << (Modification Information) >>
 *
 *  Modify Date     Modifier    Description
 *  ------------- 	-------- 	---------------------------
 *  2019.10.22 		Joo
 *
 * </pre>
 */
public class UserResumeWorkExpBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	//0. System Parameter
	private String sysLangCd				= "";

	//1. Base Parameter
	private String	resumeWorkExpSeq		= "";
	private String 	resumeSeq				= "";
	private String 	resumeWorkExpId			= "";
	private String 	bgnDt					= "";
	private String 	endDt					= "";
	private String 	iscoCd					= "";
	private String 	isicCd					= "";
	private String 	orgnzNm					= "";
	private String 	selfempYn				= "";
	private String 	leaveReason				= "";
	private String 	addrProvcCd				= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";
	private String	jobSector				= "";
	private String	jobPosition				= "";

	private List<UserResumeWorkExpBean> list;

	//2. Additional Parameter
	private String 	addrProvcNm				= "";
	private String 	iscoNm					= "";
	private String 	isicNm					= "";
	private String 	userSeq					= "";

	private String bgnDtYy;
	private String bgnDtMm;
	private String endDtYy;
	private String endDtMm;

	public String getBgnDtYy() {
		return bgnDtYy;
	}
	public void setBgnDtYy(String bgnDtYy) {
		this.bgnDtYy = bgnDtYy;
	}
	public String getBgnDtMm() {
		return bgnDtMm;
	}
	public void setBgnDtMm(String bgnDtMm) {
		this.bgnDtMm = bgnDtMm;
	}
	public String getEndDtYy() {
		return endDtYy;
	}
	public void setEndDtYy(String endDtYy) {
		this.endDtYy = endDtYy;
	}
	public String getEndDtMm() {
		return endDtMm;
	}
	public void setEndDtMm(String endDtMm) {
		this.endDtMm = endDtMm;
	}
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
	 * @return the resumeWorkExpSeq
	 */
	public String getResumeWorkExpSeq() {
		return resumeWorkExpSeq;
	}
	/**
	 * @param resumeWorkExpSeq the resumeWorkExpSeq to set
	 */
	public void setResumeWorkExpSeq(String resumeWorkExpSeq) {
		this.resumeWorkExpSeq = resumeWorkExpSeq;
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
	 * @return the resumeWorkExpId
	 */
	public String getResumeWorkExpId() {
		return resumeWorkExpId;
	}
	/**
	 * @param resumeWorkExpId the resumeWorkExpId to set
	 */
	public void setResumeWorkExpId(String resumeWorkExpId) {
		this.resumeWorkExpId = resumeWorkExpId;
	}
	/**
	 * @return the bgnDt
	 */
	public String getBgnDt() {
		return bgnDt;
	}
	/**
	 * @param bgnDt the bgnDt to set
	 */
	public void setBgnDt(String bgnDt) {
		this.bgnDt = bgnDt;
	}
	/**
	 * @return the endDt
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * @param endDt the endDt to set
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
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
	 * @return the orgnzNm
	 */
	public String getOrgnzNm() {
		return orgnzNm;
	}
	/**
	 * @param orgnzNm the orgnzNm to set
	 */
	public void setOrgnzNm(String orgnzNm) {
		this.orgnzNm = orgnzNm;
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
	 * @return the leaveReason
	 */
	public String getLeaveReason() {
		return leaveReason;
	}
	/**
	 * @param leaveReason the leaveReason to set
	 */
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	/**
	 * @return the addrProvcCd
	 */
	public String getAddrProvcCd() {
		return addrProvcCd;
	}
	/**
	 * @param addrProvcCd the addrProvcCd to set
	 */
	public void setAddrProvcCd(String addrProvcCd) {
		this.addrProvcCd = addrProvcCd;
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
	 * @return the jobSector
	 */
	public String getJobSector() {
		return jobSector;
	}
	/**
	 * @param jobSector the jobSector to set
	 */
	public void setJobSector(String jobSector) {
		this.jobSector = jobSector;
	}
	/**
	 * @return the jobPosition
	 */
	public String getJobPosition() {
		return jobPosition;
	}
	/**
	 * @param jobPosition the jobPosition to set
	 */
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	/**
	 * @return the list
	 */
	public List<UserResumeWorkExpBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserResumeWorkExpBean> list) {
		this.list = list;
	}
	/**
	 * @return the addrProvcNm
	 */
	public String getAddrProvcNm() {
		return addrProvcNm;
	}
	/**
	 * @param addrProvcNm the addrProvcNm to set
	 */
	public void setAddrProvcNm(String addrProvcNm) {
		this.addrProvcNm = addrProvcNm;
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



}
