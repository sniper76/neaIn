package ony.cpes.internal.user.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * User Interview Bean
 * @author onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << (Modification Information) >>
 *
 *  Modify Date   	Modifier 	Description
 *  ------------- 	-------- 	---------------------------
 *  2019.11.06 		Joo
 *
 * </pre>
 */
public class UserReferralBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	userSeq					= "";
	private String	resumeSeq				= "";
	private String	vacancySeq				= "";
	private String	compnySeq				= "";
	private String	vacancyId				= "";
	private String	compnyNmKh				= "";
	private String	compnyNmEn				= "";
	private String	vacancyTypeCd			= "";
	private String	vacancyTitle			= "";
	private String	recrumtMemb				= "";
	private String	minSalaryAmt			= "";
	private String	maxSalaryAmt			= "";
	private String	referralStsCd			= "";
	private String	referralRejectCd		= "";
	private String	applicProcCd			= "";
	
	private List<UserReferralBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	compnyNm				= "";
	private String	vacancyTypeNm			= "";
	private String	salaryAmt				= "";
	private String	referralStsNm			= "";
	private String	referralRejectNm		= "";
	private String	applicProcNm			= "";
	private String	referralDt				= "";
	private String 	workPlace				= "";
	
	
	
	
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
	 * @return the vacancyTypeCd
	 */
	public String getVacancyTypeCd() {
		return vacancyTypeCd;
	}
	/**
	 * @param vacancyTypeCd the vacancyTypeCd to set
	 */
	public void setVacancyTypeCd(String vacancyTypeCd) {
		this.vacancyTypeCd = vacancyTypeCd;
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
	 * @return the minSalaryAmt
	 */
	public String getMinSalaryAmt() {
		return minSalaryAmt;
	}
	/**
	 * @param minSalaryAmt the minSalaryAmt to set
	 */
	public void setMinSalaryAmt(String minSalaryAmt) {
		this.minSalaryAmt = minSalaryAmt;
	}
	/**
	 * @return the maxSalaryAmt
	 */
	public String getMaxSalaryAmt() {
		return maxSalaryAmt;
	}
	/**
	 * @param maxSalaryAmt the maxSalaryAmt to set
	 */
	public void setMaxSalaryAmt(String maxSalaryAmt) {
		this.maxSalaryAmt = maxSalaryAmt;
	}
	/**
	 * @return the referralStsCd
	 */
	public String getReferralStsCd() {
		return referralStsCd;
	}
	/**
	 * @param referralStsCd the referralStsCd to set
	 */
	public void setReferralStsCd(String referralStsCd) {
		this.referralStsCd = referralStsCd;
	}
	/**
	 * @return the referralRejectCd
	 */
	public String getReferralRejectCd() {
		return referralRejectCd;
	}
	/**
	 * @param referralRejectCd the referralRejectCd to set
	 */
	public void setReferralRejectCd(String referralRejectCd) {
		this.referralRejectCd = referralRejectCd;
	}
	/**
	 * @return the applicProcCd
	 */
	public String getApplicProcCd() {
		return applicProcCd;
	}
	/**
	 * @param applicProcCd the applicProcCd to set
	 */
	public void setApplicProcCd(String applicProcCd) {
		this.applicProcCd = applicProcCd;
	}
	/**
	 * @return the list
	 */
	public List<UserReferralBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserReferralBean> list) {
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
	 * @return the vacancyTypeNm
	 */
	public String getVacancyTypeNm() {
		return vacancyTypeNm;
	}
	/**
	 * @param vacancyTypeNm the vacancyTypeNm to set
	 */
	public void setVacancyTypeNm(String vacancyTypeNm) {
		this.vacancyTypeNm = vacancyTypeNm;
	}
	/**
	 * @return the salaryAmt
	 */
	public String getSalaryAmt() {
		return salaryAmt;
	}
	/**
	 * @param salaryAmt the salaryAmt to set
	 */
	public void setSalaryAmt(String salaryAmt) {
		this.salaryAmt = salaryAmt;
	}
	/**
	 * @return the referralStsNm
	 */
	public String getReferralStsNm() {
		return referralStsNm;
	}
	/**
	 * @param referralStsNm the referralStsNm to set
	 */
	public void setReferralStsNm(String referralStsNm) {
		this.referralStsNm = referralStsNm;
	}
	/**
	 * @return the referralRejectNm
	 */
	public String getReferralRejectNm() {
		return referralRejectNm;
	}
	/**
	 * @param referralRejectNm the referralRejectNm to set
	 */
	public void setReferralRejectNm(String referralRejectNm) {
		this.referralRejectNm = referralRejectNm;
	}
	/**
	 * @return the applicProcNm
	 */
	public String getApplicProcNm() {
		return applicProcNm;
	}
	/**
	 * @param applicProcNm the applicProcNm to set
	 */
	public void setApplicProcNm(String applicProcNm) {
		this.applicProcNm = applicProcNm;
	}
	/**
	 * @return the referralDt
	 */
	public String getReferralDt() {
		return referralDt;
	}
	/**
	 * @param referralDt the referralDt to set
	 */
	public void setReferralDt(String referralDt) {
		this.referralDt = referralDt;
	}
	/**
	 * @return the workPlace
	 */
	public String getWorkPlace() {
		return workPlace;
	}
	/**
	 * @param workPlace the workPlace to set
	 */
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
		

	
}
