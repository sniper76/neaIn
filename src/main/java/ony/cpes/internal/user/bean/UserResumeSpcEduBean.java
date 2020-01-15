package ony.cpes.internal.user.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cmm.common.bean.LocationBean;

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
 *  2019.10.31 		Joo
 *
 * </pre>
 */
public class UserResumeSpcEduBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	//0. System Parameter
	private String sysLangCd				= "";

	//1. Base Parameter
	private String	specialStudySeq			= "";
	private String 	specialStudyNm			= "";
	private String 	duraMonthCnt			= "";
	private String 	bgnDt					= "";
	private String 	endDt					= "";
	private String 	insttNm					= "";
	private String 	cntryCd					= "";
	private String 	provcCd					= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";
	private String 	resumeSeq				= "";

	private List<UserResumeSpcEduBean> list;

	//2. Additional Parameter
	private String 	cntryNm					= "";
	private String 	provcNm					= "";
	private String 	userSeq					= "";

	private String bgnDtYy;
	private String bgnDtMm;
	private String endDtYy;
	private String endDtMm;

	private List<LocationBean> provcCdList;

	public List<LocationBean> getProvcCdList() {
		return provcCdList;
	}
	public void setProvcCdList(List<LocationBean> provcCdList) {
		this.provcCdList = provcCdList;
	}
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
	 * @return the specialStudySeq
	 */
	public String getSpecialStudySeq() {
		return specialStudySeq;
	}
	/**
	 * @param specialStudySeq the specialStudySeq to set
	 */
	public void setSpecialStudySeq(String specialStudySeq) {
		this.specialStudySeq = specialStudySeq;
	}
	/**
	 * @return the specialStudyNm
	 */
	public String getSpecialStudyNm() {
		return specialStudyNm;
	}
	/**
	 * @param specialStudyNm the specialStudyNm to set
	 */
	public void setSpecialStudyNm(String specialStudyNm) {
		this.specialStudyNm = specialStudyNm;
	}
	/**
	 * @return the duraMonthCnt
	 */
	public String getDuraMonthCnt() {
		return duraMonthCnt;
	}
	/**
	 * @param duraMonthCnt the duraMonthCnt to set
	 */
	public void setDuraMonthCnt(String duraMonthCnt) {
		this.duraMonthCnt = duraMonthCnt;
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
	 * @return the cntryCd
	 */
	public String getCntryCd() {
		return cntryCd;
	}
	/**
	 * @param cntryCd the cntryCd to set
	 */
	public void setCntryCd(String cntryCd) {
		this.cntryCd = cntryCd;
	}
	/**
	 * @return the provcCd
	 */
	public String getProvcCd() {
		return provcCd;
	}
	/**
	 * @param provcCd the provcCd to set
	 */
	public void setProvcCd(String provcCd) {
		this.provcCd = provcCd;
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
	 * @return the list
	 */
	public List<UserResumeSpcEduBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserResumeSpcEduBean> list) {
		this.list = list;
	}
	/**
	 * @return the cntryNm
	 */
	public String getCntryNm() {
		return cntryNm;
	}
	/**
	 * @param cntryNm the cntryNm to set
	 */
	public void setCntryNm(String cntryNm) {
		this.cntryNm = cntryNm;
	}
	/**
	 * @return the provcNm
	 */
	public String getProvcNm() {
		return provcNm;
	}
	/**
	 * @param provcNm the provcNm to set
	 */
	public void setProvcNm(String provcNm) {
		this.provcNm = provcNm;
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
