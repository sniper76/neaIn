package ony.cpes.internal.jobsk.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Job Seek Language Bean
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
 *  2019.11.28 		Joo
 *
 * </pre>
 */
public class JobskLangBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	// Base Parameter
	private String	resumeLangSeq			= "";
	private String 	resumeSeq				= "";
	private String 	resumeLangId			= "";
	private String 	langCd					= "";
	private String 	langLvlCd				= "";
	private String 	langTypeCd				= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";

	private List<JobskLangBean> list;
	
	// Additional Parameter
	private String 	langNm					= "";
	private String 	langLvlNm				= "";
	private String 	langTypeNm				= "";
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
	 * @return the resumeLangSeq
	 */
	public String getResumeLangSeq() {
		return resumeLangSeq;
	}
	/**
	 * @param resumeLangSeq the resumeLangSeq to set
	 */
	public void setResumeLangSeq(String resumeLangSeq) {
		this.resumeLangSeq = resumeLangSeq;
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
	 * @return the resumeLangId
	 */
	public String getResumeLangId() {
		return resumeLangId;
	}
	/**
	 * @param resumeLangId the resumeLangId to set
	 */
	public void setResumeLangId(String resumeLangId) {
		this.resumeLangId = resumeLangId;
	}
	/**
	 * @return the langCd
	 */
	public String getLangCd() {
		return langCd;
	}
	/**
	 * @param langCd the langCd to set
	 */
	public void setLangCd(String langCd) {
		this.langCd = langCd;
	}
	/**
	 * @return the langLvlCd
	 */
	public String getLangLvlCd() {
		return langLvlCd;
	}
	/**
	 * @param langLvlCd the langLvlCd to set
	 */
	public void setLangLvlCd(String langLvlCd) {
		this.langLvlCd = langLvlCd;
	}
	/**
	 * @return the langTypeCd
	 */
	public String getLangTypeCd() {
		return langTypeCd;
	}
	/**
	 * @param langTypeCd the langTypeCd to set
	 */
	public void setLangTypeCd(String langTypeCd) {
		this.langTypeCd = langTypeCd;
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
	public List<JobskLangBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<JobskLangBean> list) {
		this.list = list;
	}
	/**
	 * @return the langNm
	 */
	public String getLangNm() {
		return langNm;
	}
	/**
	 * @param langNm the langNm to set
	 */
	public void setLangNm(String langNm) {
		this.langNm = langNm;
	}
	/**
	 * @return the langLvlNm
	 */
	public String getLangLvlNm() {
		return langLvlNm;
	}
	/**
	 * @param langLvlNm the langLvlNm to set
	 */
	public void setLangLvlNm(String langLvlNm) {
		this.langLvlNm = langLvlNm;
	}
	/**
	 * @return the langTypeNm
	 */
	public String getLangTypeNm() {
		return langTypeNm;
	}
	/**
	 * @param langTypeNm the langTypeNm to set
	 */
	public void setLangTypeNm(String langTypeNm) {
		this.langTypeNm = langTypeNm;
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
