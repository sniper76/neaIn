package ony.cpes.internal.user.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Company User Bean
 * @author onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << (Modification Information) >>
 *
 *  Modify Date     Modifier    Description
 *  -------------	-------- 	---------------------------
 *  2019.11.05		Joo			
 *
 * </pre>
 */
public class UserCmpnyVccyBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String	sysLangCd				= "";
	
	//1. Base Parameter
	private String	vacancySeq				= "";
	private String 	compnySeq				= "";
	private String 	vacancyId				= "";
	private String 	vacancyCertNo			= "";
	private String 	langCd					= "";
	private String 	jcCd					= "";
	private String 	jcUserSeq				= "";
	private String 	jcAgreeYn				= "";
	private String 	compnyId				= "";
	private String 	vacancyTitle			= "";
	private String 	internYn				= "";
	private String 	iscoCd					= "";
	private String 	bgnDt					= "";
	private String 	endDt					= "";
	private String 	workBgnDt				= "";
	private String 	recrumtDiffcltYn		= "";
	private String 	diffcltReason			= "";
	private String 	recrumtMemb				= "";
	private String 	employFormCd			= "";
	private String 	employCtrctCd			= "";
	private String 	employCtrctDura			= "";
	private String 	employCtrctTypeCd		= "";
	private String 	spot					= "";
	private String 	workExpln				= "";
	private String 	rspnsb					= "";
	private String 	duty					= "";
	private String 	workHourCd				= "";
	private String	workMornBgnTime			= "";
	private String	workMornEndTime			= "";
	private String	workAfternnBgnTime		= "";
	private String	workAfternnEndTime		= "";
	private String	workNightBgnTime		= "";
	private String	workNightEndTime		= "";
	private String	dayWorkTime				= "";
	private String	weekWorkDay				= "";
	private String	nightWorkYn				= "";
	private String	nightWorkSpec			= "";
	private String 	hldayWorkYn				= "";
	private String 	overWorkYn				= "";
	private String 	flexWorkYn				= "";
	private String 	probtYn					= "";
	private String  probtDura				= "";
	private String 	trnngYn					= "";
	private String	trnngDura				= "";
	private String  minSalaryAmt			= "";
	private String	maxSalaryAmt			= "";
	private String 	salaryUnitCd			= "";
	private String 	nssfYn					= "";
	private String 	etcInsuYn				= "";
	private String 	etcInsuSpec				= "";
	private String 	minEduDegreeCd			= "";
	private String 	iscedCd					= "";
	private String 	proLicnsYn				= "";
	private String 	proLicnsNm				= "";
	private String 	minWorkExp				= "";
	private String 	isicCd					= "";
	private String 	etcWorkExp				= "";
	private String 	etcSkillReq				= "";
	private String 	etcPref					= "";
	private String 	jobDesc					= "";
	private String 	recptMethod				= "";
	private String 	employerSign			= "";
	private String 	videoIntvwYn			= "";
	private String 	vacancyStsCd			= "";
	private String 	bkmkCnt					= "";
	private String 	jcModUserSeq			= "";
	private String 	jcModDt					= "";
	private String 	useYn					= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";
	private String	vacancyCloseDt			= "";
	private String	viewCnt					= "";
	
	private List<UserCmpnyVccyBean> list;

	//2. Additional Parameter
	private String	vacancyTypeNm			= "";
	private String	vacancyStsNm			= "";
	private String	applicTotCnt			= "";
	private String	resumeNotOpenCnt		= "";
	private String	resumeChkCnt			= "";
	private String	resumePassCnt			= "";
	private String	passCnt					= "";
	private String	vacancyTerm				= "";
	
	private List<String> selectedList 		= new ArrayList<String>();


	
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
	 * @return the vacancyCertNo
	 */
	public String getVacancyCertNo() {
		return vacancyCertNo;
	}

	/**
	 * @param vacancyCertNo the vacancyCertNo to set
	 */
	public void setVacancyCertNo(String vacancyCertNo) {
		this.vacancyCertNo = vacancyCertNo;
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
	 * @return the compnyId
	 */
	public String getCompnyId() {
		return compnyId;
	}

	/**
	 * @param compnyId the compnyId to set
	 */
	public void setCompnyId(String compnyId) {
		this.compnyId = compnyId;
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
	 * @return the internYn
	 */
	public String getInternYn() {
		return internYn;
	}

	/**
	 * @param internYn the internYn to set
	 */
	public void setInternYn(String internYn) {
		this.internYn = internYn;
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
	 * @return the workBgnDt
	 */
	public String getWorkBgnDt() {
		return workBgnDt;
	}

	/**
	 * @param workBgnDt the workBgnDt to set
	 */
	public void setWorkBgnDt(String workBgnDt) {
		this.workBgnDt = workBgnDt;
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
	 * @return the diffcltReason
	 */
	public String getDiffcltReason() {
		return diffcltReason;
	}

	/**
	 * @param diffcltReason the diffcltReason to set
	 */
	public void setDiffcltReason(String diffcltReason) {
		this.diffcltReason = diffcltReason;
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
	 * @return the employCtrctDura
	 */
	public String getEmployCtrctDura() {
		return employCtrctDura;
	}

	/**
	 * @param employCtrctDura the employCtrctDura to set
	 */
	public void setEmployCtrctDura(String employCtrctDura) {
		this.employCtrctDura = employCtrctDura;
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
	 * @return the rspnsb
	 */
	public String getRspnsb() {
		return rspnsb;
	}

	/**
	 * @param rspnsb the rspnsb to set
	 */
	public void setRspnsb(String rspnsb) {
		this.rspnsb = rspnsb;
	}

	/**
	 * @return the duty
	 */
	public String getDuty() {
		return duty;
	}

	/**
	 * @param duty the duty to set
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}

	/**
	 * @return the workHourCd
	 */
	public String getWorkHourCd() {
		return workHourCd;
	}

	/**
	 * @param workHourCd the workHourCd to set
	 */
	public void setWorkHourCd(String workHourCd) {
		this.workHourCd = workHourCd;
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
	 * @return the workNightBgnTime
	 */
	public String getWorkNightBgnTime() {
		return workNightBgnTime;
	}

	/**
	 * @param workNightBgnTime the workNightBgnTime to set
	 */
	public void setWorkNightBgnTime(String workNightBgnTime) {
		this.workNightBgnTime = workNightBgnTime;
	}

	/**
	 * @return the workNightEndTime
	 */
	public String getWorkNightEndTime() {
		return workNightEndTime;
	}

	/**
	 * @param workNightEndTime the workNightEndTime to set
	 */
	public void setWorkNightEndTime(String workNightEndTime) {
		this.workNightEndTime = workNightEndTime;
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
	 * @return the nightWorkSpec
	 */
	public String getNightWorkSpec() {
		return nightWorkSpec;
	}

	/**
	 * @param nightWorkSpec the nightWorkSpec to set
	 */
	public void setNightWorkSpec(String nightWorkSpec) {
		this.nightWorkSpec = nightWorkSpec;
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
	 * @return the etcInsuSpec
	 */
	public String getEtcInsuSpec() {
		return etcInsuSpec;
	}

	/**
	 * @param etcInsuSpec the etcInsuSpec to set
	 */
	public void setEtcInsuSpec(String etcInsuSpec) {
		this.etcInsuSpec = etcInsuSpec;
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
	 * @return the proLicnsYn
	 */
	public String getProLicnsYn() {
		return proLicnsYn;
	}

	/**
	 * @param proLicnsYn the proLicnsYn to set
	 */
	public void setProLicnsYn(String proLicnsYn) {
		this.proLicnsYn = proLicnsYn;
	}

	/**
	 * @return the proLicnsNm
	 */
	public String getProLicnsNm() {
		return proLicnsNm;
	}

	/**
	 * @param proLicnsNm the proLicnsNm to set
	 */
	public void setProLicnsNm(String proLicnsNm) {
		this.proLicnsNm = proLicnsNm;
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
	 * @return the etcWorkExp
	 */
	public String getEtcWorkExp() {
		return etcWorkExp;
	}

	/**
	 * @param etcWorkExp the etcWorkExp to set
	 */
	public void setEtcWorkExp(String etcWorkExp) {
		this.etcWorkExp = etcWorkExp;
	}

	/**
	 * @return the etcSkillReq
	 */
	public String getEtcSkillReq() {
		return etcSkillReq;
	}

	/**
	 * @param etcSkillReq the etcSkillReq to set
	 */
	public void setEtcSkillReq(String etcSkillReq) {
		this.etcSkillReq = etcSkillReq;
	}

	/**
	 * @return the etcPref
	 */
	public String getEtcPref() {
		return etcPref;
	}

	/**
	 * @param etcPref the etcPref to set
	 */
	public void setEtcPref(String etcPref) {
		this.etcPref = etcPref;
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
	 * @return the recptMethod
	 */
	public String getRecptMethod() {
		return recptMethod;
	}

	/**
	 * @param recptMethod the recptMethod to set
	 */
	public void setRecptMethod(String recptMethod) {
		this.recptMethod = recptMethod;
	}

	/**
	 * @return the employerSign
	 */
	public String getEmployerSign() {
		return employerSign;
	}

	/**
	 * @param employerSign the employerSign to set
	 */
	public void setEmployerSign(String employerSign) {
		this.employerSign = employerSign;
	}

	/**
	 * @return the videoIntvwYn
	 */
	public String getVideoIntvwYn() {
		return videoIntvwYn;
	}

	/**
	 * @param videoIntvwYn the videoIntvwYn to set
	 */
	public void setVideoIntvwYn(String videoIntvwYn) {
		this.videoIntvwYn = videoIntvwYn;
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
	 * @return the bkmkCnt
	 */
	public String getBkmkCnt() {
		return bkmkCnt;
	}

	/**
	 * @param bkmkCnt the bkmkCnt to set
	 */
	public void setBkmkCnt(String bkmkCnt) {
		this.bkmkCnt = bkmkCnt;
	}

	/**
	 * @return the jcModUserSeq
	 */
	public String getJcModUserSeq() {
		return jcModUserSeq;
	}

	/**
	 * @param jcModUserSeq the jcModUserSeq to set
	 */
	public void setJcModUserSeq(String jcModUserSeq) {
		this.jcModUserSeq = jcModUserSeq;
	}

	/**
	 * @return the jcModDt
	 */
	public String getJcModDt() {
		return jcModDt;
	}

	/**
	 * @param jcModDt the jcModDt to set
	 */
	public void setJcModDt(String jcModDt) {
		this.jcModDt = jcModDt;
	}

	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}

	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
	 * @return the viewCnt
	 */
	public String getViewCnt() {
		return viewCnt;
	}

	/**
	 * @param viewCnt the viewCnt to set
	 */
	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}

	/**
	 * @return the list
	 */
	public List<UserCmpnyVccyBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<UserCmpnyVccyBean> list) {
		this.list = list;
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
	 * @return the applicTotCnt
	 */
	public String getApplicTotCnt() {
		return applicTotCnt;
	}

	/**
	 * @param applicTotCnt the applicTotCnt to set
	 */
	public void setApplicTotCnt(String applicTotCnt) {
		this.applicTotCnt = applicTotCnt;
	}

	/**
	 * @return the resumeNotOpenCnt
	 */
	public String getResumeNotOpenCnt() {
		return resumeNotOpenCnt;
	}

	/**
	 * @param resumeNotOpenCnt the resumeNotOpenCnt to set
	 */
	public void setResumeNotOpenCnt(String resumeNotOpenCnt) {
		this.resumeNotOpenCnt = resumeNotOpenCnt;
	}

	/**
	 * @return the resumeChkCnt
	 */
	public String getResumeChkCnt() {
		return resumeChkCnt;
	}

	/**
	 * @param resumeChkCnt the resumeChkCnt to set
	 */
	public void setResumeChkCnt(String resumeChkCnt) {
		this.resumeChkCnt = resumeChkCnt;
	}

	/**
	 * @return the resumePassCnt
	 */
	public String getResumePassCnt() {
		return resumePassCnt;
	}

	/**
	 * @param resumePassCnt the resumePassCnt to set
	 */
	public void setResumePassCnt(String resumePassCnt) {
		this.resumePassCnt = resumePassCnt;
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


	
}
