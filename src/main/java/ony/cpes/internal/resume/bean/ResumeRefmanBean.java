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
 *  2019.10.25 		Joo
 *
 * </pre>
 */
public class ResumeRefmanBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	//0. System Parameter
	private String	sysLangCd				= "";

	//1. Base Parameter
	private String	resumeRefManSeq			= "";
	private String 	resumeSeq				= "";
	private String 	resumeRefManId;
	private String 	nm						= "";
	private String 	orgnzNm					= "";
	private String 	position				= "";
	private String 	ref						= "";
	private String 	cell					= "";
	private String 	email					= "";
	private String 	addrFullNm				= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt;
	private String  addrCd;
	private String  addrDtl;
	private String  addrFullCd;

	private List<ResumeRefmanBean> list;

	//2. Additional Parameter
	private String userSeq					= "";



	public String getAddrFullCd() {
		return addrFullCd;
	}

	public void setAddrFullCd(String addrFullCd) {
		this.addrFullCd = addrFullCd;
	}

	public String getAddrDtl() {
		return addrDtl;
	}

	public void setAddrDtl(String addrDtl) {
		this.addrDtl = addrDtl;
	}

	public String getAddrCd() {
		return addrCd;
	}

	public void setAddrCd(String addrCd) {
		this.addrCd = addrCd;
	}

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
	 * @return the resumeRefManSeq
	 */
	public String getResumeRefManSeq() {
		return resumeRefManSeq;
	}

	/**
	 * @param resumeRefManSeq the resumeRefManSeq to set
	 */
	public void setResumeRefManSeq(String resumeRefManSeq) {
		this.resumeRefManSeq = resumeRefManSeq;
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
	 * @return the resumeRefManId
	 */
	public String getResumeRefManId() {
		return resumeRefManId;
	}

	/**
	 * @param resumeRefManId the resumeRefManId to set
	 */
	public void setResumeRefManId(String resumeRefManId) {
		this.resumeRefManId = resumeRefManId;
	}

	/**
	 * @return the nm
	 */
	public String getNm() {
		return nm;
	}

	/**
	 * @param nm the nm to set
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}

	/**
	 * @return the orgnzNm
	 */
	public String getOrgnzNm() {
		return orgnzNm;
	}

	/**
	 * @param orgnzNm the orgnzNm to set
	 */
	public void setOrgnzNm(String orgnzNm) {
		this.orgnzNm = orgnzNm;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * @return the cell
	 */
	public String getCell() {
		return cell;
	}

	/**
	 * @param cell the cell to set
	 */
	public void setCell(String cell) {
		this.cell = cell;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	public List<ResumeRefmanBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<ResumeRefmanBean> list) {
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



}
