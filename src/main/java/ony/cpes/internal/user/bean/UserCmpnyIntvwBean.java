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
 *  2019.11.07 		Joo
 *
 * </pre>
 */
public class UserCmpnyIntvwBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	compnySeq				= "";
	private String	vacancySeq				= "";
	private String	resumeSeq				= "";
	private String	userSeq					= "";
	private String	cmpltUserNmKh			= "";
	private String	cmpltUserNmEn			= "";
	private String	age						= "";
	private String	genderCd				= "";
	private String	resumeTitle				= "";
	private String	eduDegreeCd				= "";
	private String	iscedCd					= "";
	private String	iscoCd					= "";
	private String	totCareerTermYearCnt	= "";
	private String	totCareerTermMonthCnt	= "";
	private String	openYnNm				= "";
	private String	intvwOpenDt				= "";
	private String	intvwTypeCd				= "";
	private String	vacancyTitle			= "";
	private String	recruitStsNm			= "";
	private String	intvwDt					= "";
	private String	regDt					= "";
	
	private List<UserCmpnyIntvwBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	userNm					= "";
	private String	genderNm				= "";
	private String	eduDegreeNm				= "";
	private String	iscedNm					= "";
	private String	iscoNm					= "";
	private String	totCareerTerm			= "";
	private String	vacancyYear				= "";
	private String	vacancyStsCd			= "";
	private String	intvwTypeNm				= "";
	
	
	
	

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
	 * @return the cmpltUserNmKh
	 */
	public String getCmpltUserNmKh() {
		return cmpltUserNmKh;
	}
	/**
	 * @param cmpltUserNmKh the cmpltUserNmKh to set
	 */
	public void setCmpltUserNmKh(String cmpltUserNmKh) {
		this.cmpltUserNmKh = cmpltUserNmKh;
	}
	/**
	 * @return the cmpltUserNmEn
	 */
	public String getCmpltUserNmEn() {
		return cmpltUserNmEn;
	}
	/**
	 * @param cmpltUserNmEn the cmpltUserNmEn to set
	 */
	public void setCmpltUserNmEn(String cmpltUserNmEn) {
		this.cmpltUserNmEn = cmpltUserNmEn;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
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
	 * @return the eduDegreeCd
	 */
	public String getEduDegreeCd() {
		return eduDegreeCd;
	}
	/**
	 * @param eduDegreeCd the eduDegreeCd to set
	 */
	public void setEduDegreeCd(String eduDegreeCd) {
		this.eduDegreeCd = eduDegreeCd;
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
	 * @return the totCareerTermYearCnt
	 */
	public String getTotCareerTermYearCnt() {
		return totCareerTermYearCnt;
	}
	/**
	 * @param totCareerTermYearCnt the totCareerTermYearCnt to set
	 */
	public void setTotCareerTermYearCnt(String totCareerTermYearCnt) {
		this.totCareerTermYearCnt = totCareerTermYearCnt;
	}
	/**
	 * @return the totCareerTermMonthCnt
	 */
	public String getTotCareerTermMonthCnt() {
		return totCareerTermMonthCnt;
	}
	/**
	 * @param totCareerTermMonthCnt the totCareerTermMonthCnt to set
	 */
	public void setTotCareerTermMonthCnt(String totCareerTermMonthCnt) {
		this.totCareerTermMonthCnt = totCareerTermMonthCnt;
	}
	/**
	 * @return the openYnNm
	 */
	public String getOpenYnNm() {
		return openYnNm;
	}
	/**
	 * @param openYnNm the openYnNm to set
	 */
	public void setOpenYnNm(String openYnNm) {
		this.openYnNm = openYnNm;
	}
	/**
	 * @return the intvwOpenDt
	 */
	public String getIntvwOpenDt() {
		return intvwOpenDt;
	}
	/**
	 * @param intvwOpenDt the intvwOpenDt to set
	 */
	public void setIntvwOpenDt(String intvwOpenDt) {
		this.intvwOpenDt = intvwOpenDt;
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
	 * @return the recruitStsNm
	 */
	public String getRecruitStsNm() {
		return recruitStsNm;
	}
	/**
	 * @param recruitStsNm the recruitStsNm to set
	 */
	public void setRecruitStsNm(String recruitStsNm) {
		this.recruitStsNm = recruitStsNm;
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
	 * @return the list
	 */
	public List<UserCmpnyIntvwBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserCmpnyIntvwBean> list) {
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
	 * @return the eduDegreeNm
	 */
	public String getEduDegreeNm() {
		return eduDegreeNm;
	}
	/**
	 * @param eduDegreeNm the eduDegreeNm to set
	 */
	public void setEduDegreeNm(String eduDegreeNm) {
		this.eduDegreeNm = eduDegreeNm;
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
	 * @return the totCareerTerm
	 */
	public String getTotCareerTerm() {
		return totCareerTerm;
	}
	/**
	 * @param totCareerTerm the totCareerTerm to set
	 */
	public void setTotCareerTerm(String totCareerTerm) {
		this.totCareerTerm = totCareerTerm;
	}
	/**
	 * @return the vacancyYear
	 */
	public String getVacancyYear() {
		return vacancyYear;
	}
	/**
	 * @param vacancyYear the vacancyYear to set
	 */
	public void setVacancyYear(String vacancyYear) {
		this.vacancyYear = vacancyYear;
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
	
	

}
