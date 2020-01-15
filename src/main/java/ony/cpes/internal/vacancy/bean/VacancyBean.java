package ony.cpes.internal.vacancy.bean;

import java.util.ArrayList;
import java.util.List;
import ony.cmm.common.bean.CommonBean;

/**
 * VACANCY BEAN
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
 *  2019.11.21 		Joo
 *
 * </pre>
 */
public class VacancyBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd					= "";
	
	//1. Base Parameter
	private String 	vacancySeq					= "";
	private String	vacancyTitle				= "";
	private String 	employFormCd				= "";
	private String	spot						= "";
	private String	iscoCd						= "";
	private String 	recrumtMemb					= "";
	private String	bgnDt						= "";
	private String 	regDt						= "";
	private String	vacancyCloseDt				= "";
	private String	recrumtDiffcltYn			= "";
	private String  employCtrctCd				= "";
	private String 	employCtrctTypeCd			= "";
	private String	preferEmploymtTypeCd		= "";
	private String	workAfternnBgnTime			= "";
	private String	workAfternnEndTime			= "";
	private String	workMornBgnTime				= "";
	private String	workMornEndTime				= "";
	private String	dayWorkTime					= "";
	private String	weekWorkDay					= "";
	private String	nightWorkYn					= "";
	private String	hldayWorkYn					= "";
	private String	flexWorkYn					= "";
	private String	overWorkYn					= "";
	private String	probtYn						= "";
	private String	probtDura					= "";
	private String	trnngYn						= "";
	private String	trnngDura					= "";
	private String	salaryUnitCd				= "";
	private String	minSalaryAmt				= "";
	private String	maxSalaryAmt				= "";
	private String	nssfYn						= "";
	private String	etcInsuYn					= "";
	private String	minEduDegreeYn				= "";
	private String	minEduDegreeCd				= "";
	private String	iscedCd						= "";
	private String	prolicnsYn					= "";
	private String	minWorkExpYn				= "";
	private String	minWorkExp					= "";
	private String	isicCd						= "";
	private String	jobDesc						= "";
	private String	recrumtJobRefKnow			= "";
	private String	recrumtJobRefBasicSkill		= "";
	private String	recrumtJobRefWorkNeedItem	= "";
	private String	etc							= "";
	private String	workExpln					= "";
	private String	imgFileGrpSeq				= "";
	private String	mngerNm						= "";
	private String	mngerEmail					= "";
	private String	mngerCell					= "";
	private String	applicDt					= "";
	private String	jcAgreeStsCd				= "";
	private String	jcAgreeYn					= "";
	private String	jcAgreeDt					= "";
	private String	vacancyStsCd				= "";
	private String	jcUserSeq					= "";
	private String	agreeRejectReason			= "";
	
	private List<VacancyBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String 	employFormNm			= "";
	private String	iscoNm					= "";
	private String  employCtrctCond			= "";
	private String 	employCtrctTypeNm		= "";
	private String	preferEmploymtTypeNm	= "";
	private String	workAfternnTime			= "";
	private String	workMornTime			= "";
	private String	probtDesc				= "";
	private String	trnngDesc				= "";
	private String	salaryDesc				= "";
	private String	minEduDegreeNm			= "";
	private String	iscedNm					= "";
	private String	isicNm					= "";
	private String	jcAgreeStsNm			= "";
	private String	vacancyStsNm			= "";
	private String	jcUserNm				= "";
	private String	compnyNm			    = "";
	
	
	
	
	
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
	 * @return the spot
	 */
	public String getSpot() {
		return spot;
	}
	/**
	 * @param spot the spot to set
	 */
	public void setSpot(String spot) {
		this.spot = spot;
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
	 * @return the vacancyCloseDt
	 */
	public String getVacancyCloseDt() {
		return vacancyCloseDt;
	}
	/**
	 * @param vacancyCloseDt the vacancyCloseDt to set
	 */
	public void setVacancyCloseDt(String vacancyCloseDt) {
		this.vacancyCloseDt = vacancyCloseDt;
	}
	/**
	 * @return the recrumtDiffcltYn
	 */
	public String getRecrumtDiffcltYn() {
		return recrumtDiffcltYn;
	}
	/**
	 * @param recrumtDiffcltYn the recrumtDiffcltYn to set
	 */
	public void setRecrumtDiffcltYn(String recrumtDiffcltYn) {
		this.recrumtDiffcltYn = recrumtDiffcltYn;
	}
	/**
	 * @return the employCtrctCd
	 */
	public String getEmployCtrctCd() {
		return employCtrctCd;
	}
	/**
	 * @param employCtrctCd the employCtrctCd to set
	 */
	public void setEmployCtrctCd(String employCtrctCd) {
		this.employCtrctCd = employCtrctCd;
	}
	/**
	 * @return the employCtrctTypeCd
	 */
	public String getEmployCtrctTypeCd() {
		return employCtrctTypeCd;
	}
	/**
	 * @param employCtrctTypeCd the employCtrctTypeCd to set
	 */
	public void setEmployCtrctTypeCd(String employCtrctTypeCd) {
		this.employCtrctTypeCd = employCtrctTypeCd;
	}
	/**
	 * @return the preferEmploymtTypeCd
	 */
	public String getPreferEmploymtTypeCd() {
		return preferEmploymtTypeCd;
	}
	/**
	 * @param preferEmploymtTypeCd the preferEmploymtTypeCd to set
	 */
	public void setPreferEmploymtTypeCd(String preferEmploymtTypeCd) {
		this.preferEmploymtTypeCd = preferEmploymtTypeCd;
	}
	/**
	 * @return the workAfternnBgnTime
	 */
	public String getWorkAfternnBgnTime() {
		return workAfternnBgnTime;
	}
	/**
	 * @param workAfternnBgnTime the workAfternnBgnTime to set
	 */
	public void setWorkAfternnBgnTime(String workAfternnBgnTime) {
		this.workAfternnBgnTime = workAfternnBgnTime;
	}
	/**
	 * @return the workAfternnEndTime
	 */
	public String getWorkAfternnEndTime() {
		return workAfternnEndTime;
	}
	/**
	 * @param workAfternnEndTime the workAfternnEndTime to set
	 */
	public void setWorkAfternnEndTime(String workAfternnEndTime) {
		this.workAfternnEndTime = workAfternnEndTime;
	}
	/**
	 * @return the workMornBgnTime
	 */
	public String getWorkMornBgnTime() {
		return workMornBgnTime;
	}
	/**
	 * @param workMornBgnTime the workMornBgnTime to set
	 */
	public void setWorkMornBgnTime(String workMornBgnTime) {
		this.workMornBgnTime = workMornBgnTime;
	}
	/**
	 * @return the workMornEndTime
	 */
	public String getWorkMornEndTime() {
		return workMornEndTime;
	}
	/**
	 * @param workMornEndTime the workMornEndTime to set
	 */
	public void setWorkMornEndTime(String workMornEndTime) {
		this.workMornEndTime = workMornEndTime;
	}
	/**
	 * @return the dayWorkTime
	 */
	public String getDayWorkTime() {
		return dayWorkTime;
	}
	/**
	 * @param dayWorkTime the dayWorkTime to set
	 */
	public void setDayWorkTime(String dayWorkTime) {
		this.dayWorkTime = dayWorkTime;
	}
	/**
	 * @return the weekWorkDay
	 */
	public String getWeekWorkDay() {
		return weekWorkDay;
	}
	/**
	 * @param weekWorkDay the weekWorkDay to set
	 */
	public void setWeekWorkDay(String weekWorkDay) {
		this.weekWorkDay = weekWorkDay;
	}
	/**
	 * @return the nightWorkYn
	 */
	public String getNightWorkYn() {
		return nightWorkYn;
	}
	/**
	 * @param nightWorkYn the nightWorkYn to set
	 */
	public void setNightWorkYn(String nightWorkYn) {
		this.nightWorkYn = nightWorkYn;
	}
	/**
	 * @return the hldayWorkYn
	 */
	public String getHldayWorkYn() {
		return hldayWorkYn;
	}
	/**
	 * @param hldayWorkYn the hldayWorkYn to set
	 */
	public void setHldayWorkYn(String hldayWorkYn) {
		this.hldayWorkYn = hldayWorkYn;
	}
	/**
	 * @return the flexWorkYn
	 */
	public String getFlexWorkYn() {
		return flexWorkYn;
	}
	/**
	 * @param flexWorkYn the flexWorkYn to set
	 */
	public void setFlexWorkYn(String flexWorkYn) {
		this.flexWorkYn = flexWorkYn;
	}
	/**
	 * @return the overWorkYn
	 */
	public String getOverWorkYn() {
		return overWorkYn;
	}
	/**
	 * @param overWorkYn the overWorkYn to set
	 */
	public void setOverWorkYn(String overWorkYn) {
		this.overWorkYn = overWorkYn;
	}
	/**
	 * @return the probtYn
	 */
	public String getProbtYn() {
		return probtYn;
	}
	/**
	 * @param probtYn the probtYn to set
	 */
	public void setProbtYn(String probtYn) {
		this.probtYn = probtYn;
	}
	/**
	 * @return the probtDura
	 */
	public String getProbtDura() {
		return probtDura;
	}
	/**
	 * @param probtDura the probtDura to set
	 */
	public void setProbtDura(String probtDura) {
		this.probtDura = probtDura;
	}
	/**
	 * @return the trnngYn
	 */
	public String getTrnngYn() {
		return trnngYn;
	}
	/**
	 * @param trnngYn the trnngYn to set
	 */
	public void setTrnngYn(String trnngYn) {
		this.trnngYn = trnngYn;
	}
	/**
	 * @return the trnngDura
	 */
	public String getTrnngDura() {
		return trnngDura;
	}
	/**
	 * @param trnngDura the trnngDura to set
	 */
	public void setTrnngDura(String trnngDura) {
		this.trnngDura = trnngDura;
	}
	/**
	 * @return the salaryUnitCd
	 */
	public String getSalaryUnitCd() {
		return salaryUnitCd;
	}
	/**
	 * @param salaryUnitCd the salaryUnitCd to set
	 */
	public void setSalaryUnitCd(String salaryUnitCd) {
		this.salaryUnitCd = salaryUnitCd;
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
	 * @return the nssfYn
	 */
	public String getNssfYn() {
		return nssfYn;
	}
	/**
	 * @param nssfYn the nssfYn to set
	 */
	public void setNssfYn(String nssfYn) {
		this.nssfYn = nssfYn;
	}
	/**
	 * @return the etcInsuYn
	 */
	public String getEtcInsuYn() {
		return etcInsuYn;
	}
	/**
	 * @param etcInsuYn the etcInsuYn to set
	 */
	public void setEtcInsuYn(String etcInsuYn) {
		this.etcInsuYn = etcInsuYn;
	}
	/**
	 * @return the minEduDegreeYn
	 */
	public String getMinEduDegreeYn() {
		return minEduDegreeYn;
	}
	/**
	 * @param minEduDegreeYn the minEduDegreeYn to set
	 */
	public void setMinEduDegreeYn(String minEduDegreeYn) {
		this.minEduDegreeYn = minEduDegreeYn;
	}
	/**
	 * @return the minEduDegreeCd
	 */
	public String getMinEduDegreeCd() {
		return minEduDegreeCd;
	}
	/**
	 * @param minEduDegreeCd the minEduDegreeCd to set
	 */
	public void setMinEduDegreeCd(String minEduDegreeCd) {
		this.minEduDegreeCd = minEduDegreeCd;
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
	 * @return the prolicnsYn
	 */
	public String getProlicnsYn() {
		return prolicnsYn;
	}
	/**
	 * @param prolicnsYn the prolicnsYn to set
	 */
	public void setProlicnsYn(String prolicnsYn) {
		this.prolicnsYn = prolicnsYn;
	}
	/**
	 * @return the minWorkExpYn
	 */
	public String getMinWorkExpYn() {
		return minWorkExpYn;
	}
	/**
	 * @param minWorkExpYn the minWorkExpYn to set
	 */
	public void setMinWorkExpYn(String minWorkExpYn) {
		this.minWorkExpYn = minWorkExpYn;
	}
	/**
	 * @return the minWorkExp
	 */
	public String getMinWorkExp() {
		return minWorkExp;
	}
	/**
	 * @param minWorkExp the minWorkExp to set
	 */
	public void setMinWorkExp(String minWorkExp) {
		this.minWorkExp = minWorkExp;
	}
	/**
	 * @return the isicCd
	 */
	public String getIsicCd() {
		return isicCd;
	}
	/**
	 * @param isicCd the isicCd to set
	 */
	public void setIsicCd(String isicCd) {
		this.isicCd = isicCd;
	}
	/**
	 * @return the jobDesc
	 */
	public String getJobDesc() {
		return jobDesc;
	}
	/**
	 * @param jobDesc the jobDesc to set
	 */
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	/**
	 * @return the recrumtJobRefKnow
	 */
	public String getRecrumtJobRefKnow() {
		return recrumtJobRefKnow;
	}
	/**
	 * @param recrumtJobRefKnow the recrumtJobRefKnow to set
	 */
	public void setRecrumtJobRefKnow(String recrumtJobRefKnow) {
		this.recrumtJobRefKnow = recrumtJobRefKnow;
	}
	/**
	 * @return the recrumtJobRefBasicSkill
	 */
	public String getRecrumtJobRefBasicSkill() {
		return recrumtJobRefBasicSkill;
	}
	/**
	 * @param recrumtJobRefBasicSkill the recrumtJobRefBasicSkill to set
	 */
	public void setRecrumtJobRefBasicSkill(String recrumtJobRefBasicSkill) {
		this.recrumtJobRefBasicSkill = recrumtJobRefBasicSkill;
	}
	/**
	 * @return the recrumtJobRefWorkNeedItem
	 */
	public String getRecrumtJobRefWorkNeedItem() {
		return recrumtJobRefWorkNeedItem;
	}
	/**
	 * @param recrumtJobRefWorkNeedItem the recrumtJobRefWorkNeedItem to set
	 */
	public void setRecrumtJobRefWorkNeedItem(String recrumtJobRefWorkNeedItem) {
		this.recrumtJobRefWorkNeedItem = recrumtJobRefWorkNeedItem;
	}
	/**
	 * @return the etc
	 */
	public String getEtc() {
		return etc;
	}
	/**
	 * @param etc the etc to set
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
	/**
	 * @return the workExpln
	 */
	public String getWorkExpln() {
		return workExpln;
	}
	/**
	 * @param workExpln the workExpln to set
	 */
	public void setWorkExpln(String workExpln) {
		this.workExpln = workExpln;
	}
	/**
	 * @return the imgFileGrpSeq
	 */
	public String getImgFileGrpSeq() {
		return imgFileGrpSeq;
	}
	/**
	 * @param imgFileGrpSeq the imgFileGrpSeq to set
	 */
	public void setImgFileGrpSeq(String imgFileGrpSeq) {
		this.imgFileGrpSeq = imgFileGrpSeq;
	}
	/**
	 * @return the mngerNm
	 */
	public String getMngerNm() {
		return mngerNm;
	}
	/**
	 * @param mngerNm the mngerNm to set
	 */
	public void setMngerNm(String mngerNm) {
		this.mngerNm = mngerNm;
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
	 * @return the mngerCell
	 */
	public String getMngerCell() {
		return mngerCell;
	}
	/**
	 * @param mngerCell the mngerCell to set
	 */
	public void setMngerCell(String mngerCell) {
		this.mngerCell = mngerCell;
	}
	/**
	 * @return the applicDt
	 */
	public String getApplicDt() {
		return applicDt;
	}
	/**
	 * @param applicDt the applicDt to set
	 */
	public void setApplicDt(String applicDt) {
		this.applicDt = applicDt;
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
	public List<VacancyBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<VacancyBean> list) {
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
	 * @return the employCtrctCond
	 */
	public String getEmployCtrctCond() {
		return employCtrctCond;
	}
	/**
	 * @param employCtrctCond the employCtrctCond to set
	 */
	public void setEmployCtrctCond(String employCtrctCond) {
		this.employCtrctCond = employCtrctCond;
	}
	/**
	 * @return the employCtrctTypeNm
	 */
	public String getEmployCtrctTypeNm() {
		return employCtrctTypeNm;
	}
	/**
	 * @param employCtrctTypeNm the employCtrctTypeNm to set
	 */
	public void setEmployCtrctTypeNm(String employCtrctTypeNm) {
		this.employCtrctTypeNm = employCtrctTypeNm;
	}
	/**
	 * @return the preferEmploymtTypeNm
	 */
	public String getPreferEmploymtTypeNm() {
		return preferEmploymtTypeNm;
	}
	/**
	 * @param preferEmploymtTypeNm the preferEmploymtTypeNm to set
	 */
	public void setPreferEmploymtTypeNm(String preferEmploymtTypeNm) {
		this.preferEmploymtTypeNm = preferEmploymtTypeNm;
	}
	/**
	 * @return the workAfternnTime
	 */
	public String getWorkAfternnTime() {
		return workAfternnTime;
	}
	/**
	 * @param workAfternnTime the workAfternnTime to set
	 */
	public void setWorkAfternnTime(String workAfternnTime) {
		this.workAfternnTime = workAfternnTime;
	}
	/**
	 * @return the workMornTime
	 */
	public String getWorkMornTime() {
		return workMornTime;
	}
	/**
	 * @param workMornTime the workMornTime to set
	 */
	public void setWorkMornTime(String workMornTime) {
		this.workMornTime = workMornTime;
	}
	/**
	 * @return the probtDesc
	 */
	public String getProbtDesc() {
		return probtDesc;
	}
	/**
	 * @param probtDesc the probtDesc to set
	 */
	public void setProbtDesc(String probtDesc) {
		this.probtDesc = probtDesc;
	}
	/**
	 * @return the trnngDesc
	 */
	public String getTrnngDesc() {
		return trnngDesc;
	}
	/**
	 * @param trnngDesc the trnngDesc to set
	 */
	public void setTrnngDesc(String trnngDesc) {
		this.trnngDesc = trnngDesc;
	}
	/**
	 * @return the salaryDesc
	 */
	public String getSalaryDesc() {
		return salaryDesc;
	}
	/**
	 * @param salaryDesc the salaryDesc to set
	 */
	public void setSalaryDesc(String salaryDesc) {
		this.salaryDesc = salaryDesc;
	}
	/**
	 * @return the minEduDegreeNm
	 */
	public String getMinEduDegreeNm() {
		return minEduDegreeNm;
	}
	/**
	 * @param minEduDegreeNm the minEduDegreeNm to set
	 */
	public void setMinEduDegreeNm(String minEduDegreeNm) {
		this.minEduDegreeNm = minEduDegreeNm;
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
	 * @return the isicNm
	 */
	public String getIsicNm() {
		return isicNm;
	}
	/**
	 * @param isicNm the isicNm to set
	 */
	public void setIsicNm(String isicNm) {
		this.isicNm = isicNm;
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

	
	
}
