package ony.cpes.internal.jobsk.bean;

import java.util.ArrayList;
import java.util.List;
import ony.cmm.common.bean.CommonBean;

/**
 * JOB SEEK OFFER BEAN
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
 *  2019.11.18 		Joo
 *
 * </pre>
 */
public class JobskOfferBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	compnySeq				= "";
	private String	resumeSeq				= "";
	private String	vacancySeq				= "";
	private String	userSeq					= "";
	private String 	compnyNmKh				= "";
	private String 	compnyNmEn				= "";
	private String 	employFormCd			= "";
	private String 	vacancyTitle			= "";
	private String 	mngerTel				= "";
	private String 	mngerEmail				= "";
	private String	userAuthCd				= "";
	private String 	userNmKh				= "";
	private String 	userNmEn				= "";
	private String 	userEmail				= "";
	private String	userTel					= "";
	private String 	regDt					= "";
	private String	offerAcptYn				= "";
	private String	offerAcptDt				= "";
	private String 	emailNtceYn				= "";
	private String 	referralYn				= "";
		
	private List<JobskOfferBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String 	compnyNm				= "";
	private String 	employFormNm			= "";
	private String	userAuthNm				= "";
	private String 	userNm					= "";
	
	// Search Condition Parameter
	private String	jcCd					= "";
	private String	jcNm					= "";
	private String	srchDivCd				= "";
	private String	srchDivKeyword			= "";
	private String	genderCd				= "";
	private String	genderNm				= "";
	private String	preferntCondCdDisabled	= "";
	private String	preferntCondCdRtnLabor	= "";
	private String	preferntCondCdYouth		= "";
	private String	vacancyPreferntCd		= "";
	private String resumeTitle				= "";
	
	
	
	
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
	 * @return the vacancySeq
	 */
	public String getVacancySeq() {
		return vacancySeq;
	}
	/**
	 * @param vacancySeq the vacancySeq to set
	 */
	public void setVacancySeq(String vacancySeq) {
		this.vacancySeq = vacancySeq;
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
	 * @return the employFormCd
	 */
	public String getEmployFormCd() {
		return employFormCd;
	}
	/**
	 * @param employFormCd the employFormCd to set
	 */
	public void setEmployFormCd(String employFormCd) {
		this.employFormCd = employFormCd;
	}
	/**
	 * @return the vacancyTitle
	 */
	public String getVacancyTitle() {
		return vacancyTitle;
	}
	/**
	 * @param vacancyTitle the vacancyTitle to set
	 */
	public void setVacancyTitle(String vacancyTitle) {
		this.vacancyTitle = vacancyTitle;
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
	 * @return the userTel
	 */
	public String getUserTel() {
		return userTel;
	}
	/**
	 * @param userTel the userTel to set
	 */
	public void setUserTel(String userTel) {
		this.userTel = userTel;
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
	 * @return the offerAcptYn
	 */
	public String getOfferAcptYn() {
		return offerAcptYn;
	}
	/**
	 * @param offerAcptYn the offerAcptYn to set
	 */
	public void setOfferAcptYn(String offerAcptYn) {
		this.offerAcptYn = offerAcptYn;
	}
	/**
	 * @return the offerAcptDt
	 */
	public String getOfferAcptDt() {
		return offerAcptDt;
	}
	/**
	 * @param offerAcptDt the offerAcptDt to set
	 */
	public void setOfferAcptDt(String offerAcptDt) {
		this.offerAcptDt = offerAcptDt;
	}
	/**
	 * @return the emailNtceYn
	 */
	public String getEmailNtceYn() {
		return emailNtceYn;
	}
	/**
	 * @param emailNtceYn the emailNtceYn to set
	 */
	public void setEmailNtceYn(String emailNtceYn) {
		this.emailNtceYn = emailNtceYn;
	}
	/**
	 * @return the referralYn
	 */
	public String getReferralYn() {
		return referralYn;
	}
	/**
	 * @param referralYn the referralYn to set
	 */
	public void setReferralYn(String referralYn) {
		this.referralYn = referralYn;
	}
	/**
	 * @return the list
	 */
	public List<JobskOfferBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<JobskOfferBean> list) {
		this.list = list;
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
	 * @return the preferntCondCdDisabled
	 */
	public String getPreferntCondCdDisabled() {
		return preferntCondCdDisabled;
	}
	/**
	 * @param preferntCondCdDisabled the preferntCondCdDisabled to set
	 */
	public void setPreferntCondCdDisabled(String preferntCondCdDisabled) {
		this.preferntCondCdDisabled = preferntCondCdDisabled;
	}
	/**
	 * @return the preferntCondCdRtnLabor
	 */
	public String getPreferntCondCdRtnLabor() {
		return preferntCondCdRtnLabor;
	}
	/**
	 * @param preferntCondCdRtnLabor the preferntCondCdRtnLabor to set
	 */
	public void setPreferntCondCdRtnLabor(String preferntCondCdRtnLabor) {
		this.preferntCondCdRtnLabor = preferntCondCdRtnLabor;
	}
	/**
	 * @return the preferntCondCdYouth
	 */
	public String getPreferntCondCdYouth() {
		return preferntCondCdYouth;
	}
	/**
	 * @param preferntCondCdYouth the preferntCondCdYouth to set
	 */
	public void setPreferntCondCdYouth(String preferntCondCdYouth) {
		this.preferntCondCdYouth = preferntCondCdYouth;
	}
	/**
	 * @return the vacancyPreferntCd
	 */
	public String getVacancyPreferntCd() {
		return vacancyPreferntCd;
	}
	/**
	 * @param vacancyPreferntCd the vacancyPreferntCd to set
	 */
	public void setVacancyPreferntCd(String vacancyPreferntCd) {
		this.vacancyPreferntCd = vacancyPreferntCd;
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
	
	

}
