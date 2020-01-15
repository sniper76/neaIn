package ony.cpes.internal.jobsk.bean;

import java.util.ArrayList;
import java.util.List;
import ony.cmm.common.bean.CommonBean;

/**
 * JOB SEEK VIDEO INTERVIEW BEAN
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
 *  2019.11.20 		Joo
 *
 * </pre>
 */
public class JobskVdoIntvwBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	videoIntvwSeq			= "";
	private String	videoIntvwUserSeq		= "";
	private String	compnySeq				= "";
	private String	userSeq					= "";
	private String 	compnyNmKh				= "";
	private String 	compnyNmEn				= "";
	private String 	mngerNm					= "";
	private String 	mngerCell				= "";
	private String 	mngerTel				= "";
	private String 	mngerEmail				= "";
	private String	compnyJcCd				= "";
	private String	userAuthCd				= "";
	private String 	userNmKh				= "";
	private String 	userNmEn				= "";
	private String	userCell				= "";
	private String	userTel					= "";
	private String	userEmail				= "";
	private String	userJcCd				= "";
	private String 	regDt					= "";
	private String	jcAgreeStsCd			= "";
	private String	jcAgreeDt				= "";
	private String	videoIntvwTime			= "";
	private String	videoIntvwBgnDt			= "";
	private String	videoIntvwBgnHour		= "";
	private String	videoIntvwBgnMinute		= "";
	private String	videoIntvwBgnAmpm		= "";
	private String	videoIntvwEndDt			= "";
	private String	videoIntvwEndHour		= "";
	private String	videoIntvwEndMinute		= "";
	private String	videoIntvwEndAmpm		= "";
	private String	intvwMnger				= "";
	private String	mngerUserNm				= "";
	private String	reqContent				= "";
	private String	regUserSeq				= "";
	private String	modUserSeq				= "";
	private String	jcUserSeq				= "";
	private String	delYn					= "";
	private String	intvwDt					= "";
	private List<JobskVdoIntvwBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String 	compnyNm				= "";
	private String	compnyJcNm				= "";
	private String	userAuthNm				= "";
	private String 	userNm					= "";
	private String	userJcNm				= "";
	private String	jcAgreeStsNm			= "";
	private String	intvwDtAgreeOpt			= "";
	
	// Search Condition Parameter
	private String	srchJcCd				= "";
	private String	srchDivCd				= "";
	private String	srchDivKeyword			= "";
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
	 * @return the videoIntvwSeq
	 */
	public String getVideoIntvwSeq() {
		return videoIntvwSeq;
	}
	/**
	 * @param videoIntvwSeq the videoIntvwSeq to set
	 */
	public void setVideoIntvwSeq(String videoIntvwSeq) {
		this.videoIntvwSeq = videoIntvwSeq;
	}
	/**
	 * @return the videoIntvwUserSeq
	 */
	public String getVideoIntvwUserSeq() {
		return videoIntvwUserSeq;
	}
	/**
	 * @param videoIntvwUserSeq the videoIntvwUserSeq to set
	 */
	public void setVideoIntvwUserSeq(String videoIntvwUserSeq) {
		this.videoIntvwUserSeq = videoIntvwUserSeq;
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
	 * @return the compnyJcCd
	 */
	public String getCompnyJcCd() {
		return compnyJcCd;
	}
	/**
	 * @param compnyJcCd the compnyJcCd to set
	 */
	public void setCompnyJcCd(String compnyJcCd) {
		this.compnyJcCd = compnyJcCd;
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
	 * @return the userCell
	 */
	public String getUserCell() {
		return userCell;
	}
	/**
	 * @param userCell the userCell to set
	 */
	public void setUserCell(String userCell) {
		this.userCell = userCell;
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
	 * @return the userJcCd
	 */
	public String getUserJcCd() {
		return userJcCd;
	}
	/**
	 * @param userJcCd the userJcCd to set
	 */
	public void setUserJcCd(String userJcCd) {
		this.userJcCd = userJcCd;
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
	 * @return the videoIntvwTime
	 */
	public String getVideoIntvwTime() {
		return videoIntvwTime;
	}
	/**
	 * @param videoIntvwTime the videoIntvwTime to set
	 */
	public void setVideoIntvwTime(String videoIntvwTime) {
		this.videoIntvwTime = videoIntvwTime;
	}
	/**
	 * @return the videoIntvwBgnDt
	 */
	public String getVideoIntvwBgnDt() {
		return videoIntvwBgnDt;
	}
	/**
	 * @param videoIntvwBgnDt the videoIntvwBgnDt to set
	 */
	public void setVideoIntvwBgnDt(String videoIntvwBgnDt) {
		this.videoIntvwBgnDt = videoIntvwBgnDt;
	}
	/**
	 * @return the videoIntvwBgnHour
	 */
	public String getVideoIntvwBgnHour() {
		return videoIntvwBgnHour;
	}
	/**
	 * @param videoIntvwBgnHour the videoIntvwBgnHour to set
	 */
	public void setVideoIntvwBgnHour(String videoIntvwBgnHour) {
		this.videoIntvwBgnHour = videoIntvwBgnHour;
	}
	/**
	 * @return the videoIntvwBgnMinute
	 */
	public String getVideoIntvwBgnMinute() {
		return videoIntvwBgnMinute;
	}
	/**
	 * @param videoIntvwBgnMinute the videoIntvwBgnMinute to set
	 */
	public void setVideoIntvwBgnMinute(String videoIntvwBgnMinute) {
		this.videoIntvwBgnMinute = videoIntvwBgnMinute;
	}
	/**
	 * @return the videoIntvwBgnAmpm
	 */
	public String getVideoIntvwBgnAmpm() {
		return videoIntvwBgnAmpm;
	}
	/**
	 * @param videoIntvwBgnAmpm the videoIntvwBgnAmpm to set
	 */
	public void setVideoIntvwBgnAmpm(String videoIntvwBgnAmpm) {
		this.videoIntvwBgnAmpm = videoIntvwBgnAmpm;
	}
	/**
	 * @return the videoIntvwEndDt
	 */
	public String getVideoIntvwEndDt() {
		return videoIntvwEndDt;
	}
	/**
	 * @param videoIntvwEndDt the videoIntvwEndDt to set
	 */
	public void setVideoIntvwEndDt(String videoIntvwEndDt) {
		this.videoIntvwEndDt = videoIntvwEndDt;
	}
	/**
	 * @return the videoIntvwEndHour
	 */
	public String getVideoIntvwEndHour() {
		return videoIntvwEndHour;
	}
	/**
	 * @param videoIntvwEndHour the videoIntvwEndHour to set
	 */
	public void setVideoIntvwEndHour(String videoIntvwEndHour) {
		this.videoIntvwEndHour = videoIntvwEndHour;
	}
	/**
	 * @return the videoIntvwEndMinute
	 */
	public String getVideoIntvwEndMinute() {
		return videoIntvwEndMinute;
	}
	/**
	 * @param videoIntvwEndMinute the videoIntvwEndMinute to set
	 */
	public void setVideoIntvwEndMinute(String videoIntvwEndMinute) {
		this.videoIntvwEndMinute = videoIntvwEndMinute;
	}
	/**
	 * @return the videoIntvwEndAmpm
	 */
	public String getVideoIntvwEndAmpm() {
		return videoIntvwEndAmpm;
	}
	/**
	 * @param videoIntvwEndAmpm the videoIntvwEndAmpm to set
	 */
	public void setVideoIntvwEndAmpm(String videoIntvwEndAmpm) {
		this.videoIntvwEndAmpm = videoIntvwEndAmpm;
	}
	/**
	 * @return the intvwMnger
	 */
	public String getIntvwMnger() {
		return intvwMnger;
	}
	/**
	 * @param intvwMnger the intvwMnger to set
	 */
	public void setIntvwMnger(String intvwMnger) {
		this.intvwMnger = intvwMnger;
	}
	/**
	 * @return the mngerUserNm
	 */
	public String getMngerUserNm() {
		return mngerUserNm;
	}
	/**
	 * @param mngerUserNm the mngerUserNm to set
	 */
	public void setMngerUserNm(String mngerUserNm) {
		this.mngerUserNm = mngerUserNm;
	}
	/**
	 * @return the reqContent
	 */
	public String getReqContent() {
		return reqContent;
	}
	/**
	 * @param reqContent the reqContent to set
	 */
	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
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
	 * @return the list
	 */
	public List<JobskVdoIntvwBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<JobskVdoIntvwBean> list) {
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
	 * @return the compnyJcNm
	 */
	public String getCompnyJcNm() {
		return compnyJcNm;
	}
	/**
	 * @param compnyJcNm the compnyJcNm to set
	 */
	public void setCompnyJcNm(String compnyJcNm) {
		this.compnyJcNm = compnyJcNm;
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
	 * @return the userJcNm
	 */
	public String getUserJcNm() {
		return userJcNm;
	}
	/**
	 * @param userJcNm the userJcNm to set
	 */
	public void setUserJcNm(String userJcNm) {
		this.userJcNm = userJcNm;
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
	 * @return the intvwDtAgreeOpt
	 */
	public String getIntvwDtAgreeOpt() {
		return intvwDtAgreeOpt;
	}
	/**
	 * @param intvwDtAgreeOpt the intvwDtAgreeOpt to set
	 */
	public void setIntvwDtAgreeOpt(String intvwDtAgreeOpt) {
		this.intvwDtAgreeOpt = intvwDtAgreeOpt;
	}
	/**
	 * @return the srchJcCd
	 */
	public String getSrchJcCd() {
		return srchJcCd;
	}
	/**
	 * @param srchJcCd the srchJcCd to set
	 */
	public void setSrchJcCd(String srchJcCd) {
		this.srchJcCd = srchJcCd;
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

	

}
