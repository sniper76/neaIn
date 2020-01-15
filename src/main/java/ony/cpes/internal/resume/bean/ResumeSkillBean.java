package ony.cpes.internal.resume.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Resume
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
 *  2019.10.24 		Joo
 *
 * </pre>
 */
public class ResumeSkillBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	//0. System Parameter
	private String	sysLangCd				= "";

	//1. Base Parameter
	private String	resumeSkillSeq			= "";
	private String 	resumeSeq				= "";
	private String 	resumeSkillId;
	private String 	skillCd					= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";

	private List<ResumeSkillBean> list;

	//2. Additional Parameter
	private String 	userSeq					= "";
	private String 	skillNm					= "";
	private ArrayList<HashMap<String, Object>> SkillList 		= new ArrayList<HashMap<String, Object>>();




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
	 * @return the resumeSkillSeq
	 */
	public String getResumeSkillSeq() {
		return resumeSkillSeq;
	}
	/**
	 * @param resumeSkillSeq the resumeSkillSeq to set
	 */
	public void setResumeSkillSeq(String resumeSkillSeq) {
		this.resumeSkillSeq = resumeSkillSeq;
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
	 * @return the resumeSkillId
	 */
	public String getResumeSkillId() {
		return resumeSkillId;
	}
	/**
	 * @param resumeSkillId the resumeSkillId to set
	 */
	public void setResumeSkillId(String resumeSkillId) {
		this.resumeSkillId = resumeSkillId;
	}
	/**
	 * @return the skillCd
	 */
	public String getSkillCd() {
		return skillCd;
	}
	/**
	 * @param skillCd the skillCd to set
	 */
	public void setSkillCd(String skillCd) {
		this.skillCd = skillCd;
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
	 * @return the list
	 */
	public List<ResumeSkillBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<ResumeSkillBean> list) {
		this.list = list;
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
	 * @return the skillNm
	 */
	public String getSkillNm() {
		return skillNm;
	}
	/**
	 * @param skillNm the skillNm to set
	 */
	public void setSkillNm(String skillNm) {
		this.skillNm = skillNm;
	}
	/**
	 * @return the skillList
	 */
	public ArrayList<HashMap<String, Object>> getSkillList() {
		return SkillList;
	}
	/**
	 * @param skillList the skillList to set
	 */
	public void setSkillList(ArrayList<HashMap<String, Object>> skillList) {
		SkillList = skillList;
	}



}
