package ony.cpes.internal.user.bean;

import java.util.ArrayList;
import java.util.List;
import ony.cmm.common.bean.CommonBean;

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
 *  2019.11.01 		Joo
 *
 * </pre>
 */
public class UserJobskBean extends CommonBean{

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
	private String	delYn					= "";
	private String	delDt					= "";
	private String	resumeOpenDt			= "";
	 
	private List<UserJobskBean> list;
	
	//2. Additional Search Condition Parameter
	private String	jcAgreeStsNm			= "";
	private String	userSeq					= "";
	private String	userId					= "";
	private String	resumeTitle				= "";
	private String	urgentJobseekYn			= "";
	private String	nowWorkYn				= "";
	private String	jobskStscd				= "";
	private String	jobskStsNm				= "";
	private String 	jcUserNm				= "";
	
	
	
	
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
	 * @return the delYn
	 */
	public String getDelYn() {
		return delYn;
	}
	/**
	 * @param delYn the delYn to set
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	/**
	 * @return the delDt
	 */
	public String getDelDt() {
		return delDt;
	}
	/**
	 * @param delDt the delDt to set
	 */
	public void setDelDt(String delDt) {
		this.delDt = delDt;
	}
	/**
	 * @return the resumeOpenDt
	 */
	public String getResumeOpenDt() {
		return resumeOpenDt;
	}
	/**
	 * @param resumeOpenDt the resumeOpenDt to set
	 */
	public void setResumeOpenDt(String resumeOpenDt) {
		this.resumeOpenDt = resumeOpenDt;
	}
	/**
	 * @return the list
	 */
	public List<UserJobskBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserJobskBean> list) {
		this.list = list;
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
	 * @return the jobskStscd
	 */
	public String getJobskStscd() {
		return jobskStscd;
	}
	/**
	 * @param jobskStscd the jobskStscd to set
	 */
	public void setJobskStscd(String jobskStscd) {
		this.jobskStscd = jobskStscd;
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

	

}
