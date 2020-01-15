package ony.cpes.internal.jobsk.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 * Job Seek ISCO Bean
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
public class JobskIscoBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	// Base Parameter
	private String	resumeIscoSeq			= "";
	private String 	iscoCd					= "";
	private String 	resumeSeq				= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";

	private List<JobskIscoBean> list;
	
	// Additional Parameter
	private String 	iscoNm					= "";
	private String	jcAgreeStsCd			= "";
	private String	jobskReqSeq				= "";
	private String	agreeRejectReason		= "";
	
	
	
	
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
	 * @return the resumeIscoSeq
	 */
	public String getResumeIscoSeq() {
		return resumeIscoSeq;
	}
	/**
	 * @param resumeIscoSeq the resumeIscoSeq to set
	 */
	public void setResumeIscoSeq(String resumeIscoSeq) {
		this.resumeIscoSeq = resumeIscoSeq;
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
	public List<JobskIscoBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<JobskIscoBean> list) {
		this.list = list;
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


	
}
