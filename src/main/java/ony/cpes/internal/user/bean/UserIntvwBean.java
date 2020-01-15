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
public class UserIntvwBean extends CommonBean{

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
	private String	aplcDt					= "";
	private String	intvwDt					= "";
	private String	intvwTypeCd				= "";
	private String	applicProcCd			= "";
	
	private List<UserIntvwBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	compnyNm				= "";
	private String	vacancyTypeNm			= "";
	private String	intvwTypeNm				= "";
	private String	applicProcNm			= "";
	
	
	
	
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
	 * @return the aplcDt
	 */
	public String getAplcDt() {
		return aplcDt;
	}
	/**
	 * @param aplcDt the aplcDt to set
	 */
	public void setAplcDt(String aplcDt) {
		this.aplcDt = aplcDt;
	}
	/**
	 * @return the intvwDt
	 */
	public String getIntvwDt() {
		return intvwDt;
	}
	/**
	 * @param intvwDt the intvwDt to set
	 */
	public void setIntvwDt(String intvwDt) {
		this.intvwDt = intvwDt;
	}
	/**
	 * @return the intvwTypeCd
	 */
	public String getIntvwTypeCd() {
		return intvwTypeCd;
	}
	/**
	 * @param intvwTypeCd the intvwTypeCd to set
	 */
	public void setIntvwTypeCd(String intvwTypeCd) {
		this.intvwTypeCd = intvwTypeCd;
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
	public List<UserIntvwBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserIntvwBean> list) {
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
	 * @return the intvwTypeNm
	 */
	public String getIntvwTypeNm() {
		return intvwTypeNm;
	}
	/**
	 * @param intvwTypeNm the intvwTypeNm to set
	 */
	public void setIntvwTypeNm(String intvwTypeNm) {
		this.intvwTypeNm = intvwTypeNm;
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
		

	
}
