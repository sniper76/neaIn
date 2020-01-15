package ony.cpes.internal.jobsk.bean;

import java.util.ArrayList;
import java.util.List;
import ony.cmm.common.bean.CommonBean;

/**
 * JOB SEEK VACANCY BEAN
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
 *  2019.10.28 		Joo
 *
 * </pre>
 */
public class JobskVacancyBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String 	vacancySeq				= "";
	private String 	compnySeq				= "";
	private String 	vacancyId				= "";
	private String 	employFormCd			= "";
	private String 	compnyNmKh				= "";
	private String	compnyNmEn				= "";
	private String	vacancyTitle			= "";
	private String 	vacancyTerm				= "";
	private String 	regDt					= "";
	private String 	jcAgreeYn				= "";
	private String	jcAgreeDt				= "";
	private String 	jcAgreeStsCd			= "";
	private String 	vacancyStsCd			= "";
	private String 	recrumtMemb				= "";
	private String	applicCnt				= "";
	private String	passCnt					= "";
	private String	jcCd					= "";
	private String	jcKh					= "";
	private String	jcEn					= "";
	private String	agreeRejectReason		= "";
	
	private List<JobskVacancyBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String 	employFormNm			= "";
	private String 	compnyNm				= "";
	private String 	jcAgreeStsNm			= "";
	private String 	vacancyStsNm			= "";
	private String	jcNm					= "";
	private String	iscoCd					= "";
	private String	userSeq					= "";
	
	// Search Condition Parameter	
	private String	srchDivCd				= "";
	private String	srchDivKeyword			= "";
	private String	urgentVccyCd			= "";
	private String	vacancyPreferntCondCd	= "";
	private String	mngerTel				= "";
	
	
	
	
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
	 * @return the vacancyId
	 */
	public String getVacancyId() {
		return vacancyId;
	}
	/**
	 * @param vacancyId the vacancyId to set
	 */
	public void setVacancyId(String vacancyId) {
		this.vacancyId = vacancyId;
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
	 * @return the vacancyTerm
	 */
	public String getVacancyTerm() {
		return vacancyTerm;
	}
	/**
	 * @param vacancyTerm the vacancyTerm to set
	 */
	public void setVacancyTerm(String vacancyTerm) {
		this.vacancyTerm = vacancyTerm;
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
	 * @return the jcAgreeYn
	 */
	public String getJcAgreeYn() {
		return jcAgreeYn;
	}
	/**
	 * @param jcAgreeYn the jcAgreeYn to set
	 */
	public void setJcAgreeYn(String jcAgreeYn) {
		this.jcAgreeYn = jcAgreeYn;
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
	 * @return the vacancyStsCd
	 */
	public String getVacancyStsCd() {
		return vacancyStsCd;
	}
	/**
	 * @param vacancyStsCd the vacancyStsCd to set
	 */
	public void setVacancyStsCd(String vacancyStsCd) {
		this.vacancyStsCd = vacancyStsCd;
	}
	/**
	 * @return the recrumtMemb
	 */
	public String getRecrumtMemb() {
		return recrumtMemb;
	}
	/**
	 * @param recrumtMemb the recrumtMemb to set
	 */
	public void setRecrumtMemb(String recrumtMemb) {
		this.recrumtMemb = recrumtMemb;
	}
	/**
	 * @return the applicCnt
	 */
	public String getApplicCnt() {
		return applicCnt;
	}
	/**
	 * @param applicCnt the applicCnt to set
	 */
	public void setApplicCnt(String applicCnt) {
		this.applicCnt = applicCnt;
	}
	/**
	 * @return the passCnt
	 */
	public String getPassCnt() {
		return passCnt;
	}
	/**
	 * @param passCnt the passCnt to set
	 */
	public void setPassCnt(String passCnt) {
		this.passCnt = passCnt;
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
	 * @return the jcKh
	 */
	public String getJcKh() {
		return jcKh;
	}
	/**
	 * @param jcKh the jcKh to set
	 */
	public void setJcKh(String jcKh) {
		this.jcKh = jcKh;
	}
	/**
	 * @return the jcEn
	 */
	public String getJcEn() {
		return jcEn;
	}
	/**
	 * @param jcEn the jcEn to set
	 */
	public void setJcEn(String jcEn) {
		this.jcEn = jcEn;
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
	/**
	 * @return the list
	 */
	public List<JobskVacancyBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<JobskVacancyBean> list) {
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
	 * @return the vacancyStsNm
	 */
	public String getVacancyStsNm() {
		return vacancyStsNm;
	}
	/**
	 * @param vacancyStsNm the vacancyStsNm to set
	 */
	public void setVacancyStsNm(String vacancyStsNm) {
		this.vacancyStsNm = vacancyStsNm;
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
	 * @return the urgentVccyCd
	 */
	public String getUrgentVccyCd() {
		return urgentVccyCd;
	}
	/**
	 * @param urgentVccyCd the urgentVccyCd to set
	 */
	public void setUrgentVccyCd(String urgentVccyCd) {
		this.urgentVccyCd = urgentVccyCd;
	}
	/**
	 * @return the vacancyPreferntCondCd
	 */
	public String getVacancyPreferntCondCd() {
		return vacancyPreferntCondCd;
	}
	/**
	 * @param vacancyPreferntCondCd the vacancyPreferntCondCd to set
	 */
	public void setVacancyPreferntCondCd(String vacancyPreferntCondCd) {
		this.vacancyPreferntCondCd = vacancyPreferntCondCd;
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
	
	

}
