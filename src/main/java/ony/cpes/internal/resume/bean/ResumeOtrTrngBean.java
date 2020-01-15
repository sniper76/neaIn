package ony.cpes.internal.resume.bean;

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
 *  2019.10.24 		Joo
 *
 * </pre>
 */
public class ResumeOtrTrngBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	//0. System Parameter
	private String sysLangCd				= "";

	//1. Base Parameter
	private String	resumeOtherTrnngSeq		= "";
	private String 	resumeSeq				= "";
	private String 	resumeOtherTrnngId;
	private String 	bgnDt					= "";
	private String 	endDt					= "";
	private String 	trnngEduDegreeCd		= "";
	private String 	insttNm					= "";
	private String 	iscedCd					= "";
	private String 	addrProvcCd				= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";

	private List<ResumeOtrTrngBean> list;

	//2. Additional Parameter
	private String	iscedNm					= "";
	private String 	trnngEduDegreeNm		= "";
	private String 	otrTrngiscedNm			= "";
	private String	addrProvcNm				= "";
	private String 	userSeq					= "";



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
	 * @return the resumeOtherTrnngSeq
	 */
	public String getResumeOtherTrnngSeq() {
		return resumeOtherTrnngSeq;
	}
	/**
	 * @param resumeOtherTrnngSeq the resumeOtherTrnngSeq to set
	 */
	public void setResumeOtherTrnngSeq(String resumeOtherTrnngSeq) {
		this.resumeOtherTrnngSeq = resumeOtherTrnngSeq;
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
	 * @return the resumeOtherTrnngId
	 */
	public String getResumeOtherTrnngId() {
		return resumeOtherTrnngId;
	}
	/**
	 * @param resumeOtherTrnngId the resumeOtherTrnngId to set
	 */
	public void setResumeOtherTrnngId(String resumeOtherTrnngId) {
		this.resumeOtherTrnngId = resumeOtherTrnngId;
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
	 * @return the trnngEduDegreeCd
	 */
	public String getTrnngEduDegreeCd() {
		return trnngEduDegreeCd;
	}
	/**
	 * @param trnngEduDegreeCd the trnngEduDegreeCd to set
	 */
	public void setTrnngEduDegreeCd(String trnngEduDegreeCd) {
		this.trnngEduDegreeCd = trnngEduDegreeCd;
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
	 * @return the iscedCd
	 */
	public String getIscedCd() {
		return iscedCd;
	}
	/**
	 * @param iscedCd the iscedCd to set
	 */
	public void setIscedCd(String iscedCd) {
		this.iscedCd = iscedCd;
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
	 * @return the list
	 */
	public List<ResumeOtrTrngBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<ResumeOtrTrngBean> list) {
		this.list = list;
	}
	/**
	 * @return the iscedNm
	 */
	public String getIscedNm() {
		return iscedNm;
	}
	/**
	 * @param iscedNm the iscedNm to set
	 */
	public void setIscedNm(String iscedNm) {
		this.iscedNm = iscedNm;
	}
	/**
	 * @return the trnngEduDegreeNm
	 */
	public String getTrnngEduDegreeNm() {
		return trnngEduDegreeNm;
	}
	/**
	 * @param trnngEduDegreeNm the trnngEduDegreeNm to set
	 */
	public void setTrnngEduDegreeNm(String trnngEduDegreeNm) {
		this.trnngEduDegreeNm = trnngEduDegreeNm;
	}
	/**
	 * @return the otrTrngiscedNm
	 */
	public String getOtrTrngiscedNm() {
		return otrTrngiscedNm;
	}
	/**
	 * @param otrTrngiscedNm the otrTrngiscedNm to set
	 */
	public void setOtrTrngiscedNm(String otrTrngiscedNm) {
		this.otrTrngiscedNm = otrTrngiscedNm;
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
