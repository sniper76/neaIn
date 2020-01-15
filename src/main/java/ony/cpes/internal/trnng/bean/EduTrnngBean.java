package ony.cpes.internal.trnng.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Education Training Detail Bean
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
 *  2019.11.27 		Joo
 *
 * </pre>
 */
public class EduTrnngBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String	sysLangCd				= "";
	
	//1. Base Parameter
	private	String	eduTrnngSeq				= "";
	private	String	eduTrnngNm				= "";
	private String	eduDivCd				= "";
	private String	skillJobProgramCorsCd	= "";
	private String	highGenrlEduCorsCd		= "";
	private String	recurmtTerm				= "";
	private String	eduTerm					= "";
	private String	eduDura					= "";
	private String	teachDt					= "";
	private String	teachTime				= "";
	private String	timeWeek				= "";
	private String	addrFullNm				= "";
	private String	programCorsTypeCd		= "";
	private String	major2depthCd			= "";
	private String	major1depthCd			= "";
	private String	freePaidYn				= "";
	private String	tuition					= "";
	private String	eduTarget				= "";
	private String	admssCriteria			= "";
	private String	content					= "";
	private String	enrolMethod				= "";
	private String	regDt					= "";
	private String	jcAgreeDt				= "";
	private String	jcAgreeStsCd			= "";
	private String	jcUserSeq				= "";
	
	private List<EduTrnngBean> list;
	
	//2. Additional Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	eduDivNm				= "";
	private String	skillJobProgramCorsNm	= "";
	private String	highGenrlEduCorsNm		= "";
	private String	programCorsTypeNm		= "";
	private String	major2depthNm			= "";
	private String	major1depthNm			= "";
	private String	jcAgreeStsNm			= "";
	private String	jcUserNm				= "";
	
	
	
	
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
	 * @return the eduTrnngSeq
	 */
	public String getEduTrnngSeq() {
		return eduTrnngSeq;
	}
	/**
	 * @param eduTrnngSeq the eduTrnngSeq to set
	 */
	public void setEduTrnngSeq(String eduTrnngSeq) {
		this.eduTrnngSeq = eduTrnngSeq;
	}
	/**
	 * @return the eduTrnngNm
	 */
	public String getEduTrnngNm() {
		return eduTrnngNm;
	}
	/**
	 * @param eduTrnngNm the eduTrnngNm to set
	 */
	public void setEduTrnngNm(String eduTrnngNm) {
		this.eduTrnngNm = eduTrnngNm;
	}
	/**
	 * @return the eduDivCd
	 */
	public String getEduDivCd() {
		return eduDivCd;
	}
	/**
	 * @param eduDivCd the eduDivCd to set
	 */
	public void setEduDivCd(String eduDivCd) {
		this.eduDivCd = eduDivCd;
	}
	/**
	 * @return the skillJobProgramCorsCd
	 */
	public String getSkillJobProgramCorsCd() {
		return skillJobProgramCorsCd;
	}
	/**
	 * @param skillJobProgramCorsCd the skillJobProgramCorsCd to set
	 */
	public void setSkillJobProgramCorsCd(String skillJobProgramCorsCd) {
		this.skillJobProgramCorsCd = skillJobProgramCorsCd;
	}
	/**
	 * @return the highGenrlEduCorsCd
	 */
	public String getHighGenrlEduCorsCd() {
		return highGenrlEduCorsCd;
	}
	/**
	 * @param highGenrlEduCorsCd the highGenrlEduCorsCd to set
	 */
	public void setHighGenrlEduCorsCd(String highGenrlEduCorsCd) {
		this.highGenrlEduCorsCd = highGenrlEduCorsCd;
	}
	/**
	 * @return the recurmtTerm
	 */
	public String getRecurmtTerm() {
		return recurmtTerm;
	}
	/**
	 * @param recurmtTerm the recurmtTerm to set
	 */
	public void setRecurmtTerm(String recurmtTerm) {
		this.recurmtTerm = recurmtTerm;
	}
	/**
	 * @return the eduTerm
	 */
	public String getEduTerm() {
		return eduTerm;
	}
	/**
	 * @param eduTerm the eduTerm to set
	 */
	public void setEduTerm(String eduTerm) {
		this.eduTerm = eduTerm;
	}
	/**
	 * @return the eduDura
	 */
	public String getEduDura() {
		return eduDura;
	}
	/**
	 * @param eduDura the eduDura to set
	 */
	public void setEduDura(String eduDura) {
		this.eduDura = eduDura;
	}
	/**
	 * @return the teachDt
	 */
	public String getTeachDt() {
		return teachDt;
	}
	/**
	 * @param teachDt the teachDt to set
	 */
	public void setTeachDt(String teachDt) {
		this.teachDt = teachDt;
	}
	/**
	 * @return the teachTime
	 */
	public String getTeachTime() {
		return teachTime;
	}
	/**
	 * @param teachTime the teachTime to set
	 */
	public void setTeachTime(String teachTime) {
		this.teachTime = teachTime;
	}
	/**
	 * @return the timeWeek
	 */
	public String getTimeWeek() {
		return timeWeek;
	}
	/**
	 * @param timeWeek the timeWeek to set
	 */
	public void setTimeWeek(String timeWeek) {
		this.timeWeek = timeWeek;
	}
	/**
	 * @return the addrFullNm
	 */
	public String getAddrFullNm() {
		return addrFullNm;
	}
	/**
	 * @param addrFullNm the addrFullNm to set
	 */
	public void setAddrFullNm(String addrFullNm) {
		this.addrFullNm = addrFullNm;
	}
	/**
	 * @return the programCorsTypeCd
	 */
	public String getProgramCorsTypeCd() {
		return programCorsTypeCd;
	}
	/**
	 * @param programCorsTypeCd the programCorsTypeCd to set
	 */
	public void setProgramCorsTypeCd(String programCorsTypeCd) {
		this.programCorsTypeCd = programCorsTypeCd;
	}
	/**
	 * @return the major2depthCd
	 */
	public String getMajor2depthCd() {
		return major2depthCd;
	}
	/**
	 * @param major2depthCd the major2depthCd to set
	 */
	public void setMajor2depthCd(String major2depthCd) {
		this.major2depthCd = major2depthCd;
	}
	/**
	 * @return the major1depthCd
	 */
	public String getMajor1depthCd() {
		return major1depthCd;
	}
	/**
	 * @param major1depthCd the major1depthCd to set
	 */
	public void setMajor1depthCd(String major1depthCd) {
		this.major1depthCd = major1depthCd;
	}
	/**
	 * @return the freePaidYn
	 */
	public String getFreePaidYn() {
		return freePaidYn;
	}
	/**
	 * @param freePaidYn the freePaidYn to set
	 */
	public void setFreePaidYn(String freePaidYn) {
		this.freePaidYn = freePaidYn;
	}
	/**
	 * @return the tuition
	 */
	public String getTuition() {
		return tuition;
	}
	/**
	 * @param tuition the tuition to set
	 */
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	/**
	 * @return the eduTarget
	 */
	public String getEduTarget() {
		return eduTarget;
	}
	/**
	 * @param eduTarget the eduTarget to set
	 */
	public void setEduTarget(String eduTarget) {
		this.eduTarget = eduTarget;
	}
	/**
	 * @return the admssCriteria
	 */
	public String getAdmssCriteria() {
		return admssCriteria;
	}
	/**
	 * @param admssCriteria the admssCriteria to set
	 */
	public void setAdmssCriteria(String admssCriteria) {
		this.admssCriteria = admssCriteria;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the enrolMethod
	 */
	public String getEnrolMethod() {
		return enrolMethod;
	}
	/**
	 * @param enrolMethod the enrolMethod to set
	 */
	public void setEnrolMethod(String enrolMethod) {
		this.enrolMethod = enrolMethod;
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
	 * @return the list
	 */
	public List<EduTrnngBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<EduTrnngBean> list) {
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
	 * @return the eduDivNm
	 */
	public String getEduDivNm() {
		return eduDivNm;
	}
	/**
	 * @param eduDivNm the eduDivNm to set
	 */
	public void setEduDivNm(String eduDivNm) {
		this.eduDivNm = eduDivNm;
	}
	/**
	 * @return the skillJobProgramCorsNm
	 */
	public String getSkillJobProgramCorsNm() {
		return skillJobProgramCorsNm;
	}
	/**
	 * @param skillJobProgramCorsNm the skillJobProgramCorsNm to set
	 */
	public void setSkillJobProgramCorsNm(String skillJobProgramCorsNm) {
		this.skillJobProgramCorsNm = skillJobProgramCorsNm;
	}
	/**
	 * @return the highGenrlEduCorsNm
	 */
	public String getHighGenrlEduCorsNm() {
		return highGenrlEduCorsNm;
	}
	/**
	 * @param highGenrlEduCorsNm the highGenrlEduCorsNm to set
	 */
	public void setHighGenrlEduCorsNm(String highGenrlEduCorsNm) {
		this.highGenrlEduCorsNm = highGenrlEduCorsNm;
	}
	/**
	 * @return the programCorsTypeNm
	 */
	public String getProgramCorsTypeNm() {
		return programCorsTypeNm;
	}
	/**
	 * @param programCorsTypeNm the programCorsTypeNm to set
	 */
	public void setProgramCorsTypeNm(String programCorsTypeNm) {
		this.programCorsTypeNm = programCorsTypeNm;
	}
	/**
	 * @return the major2depthNm
	 */
	public String getMajor2depthNm() {
		return major2depthNm;
	}
	/**
	 * @param major2depthNm the major2depthNm to set
	 */
	public void setMajor2depthNm(String major2depthNm) {
		this.major2depthNm = major2depthNm;
	}
	/**
	 * @return the major1depthNm
	 */
	public String getMajor1depthNm() {
		return major1depthNm;
	}
	/**
	 * @param major1depthNm the major1depthNm to set
	 */
	public void setMajor1depthNm(String major1depthNm) {
		this.major1depthNm = major1depthNm;
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
