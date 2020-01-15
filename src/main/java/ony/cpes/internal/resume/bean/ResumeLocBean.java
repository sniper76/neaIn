package ony.cpes.internal.resume.bean;

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
 *  2019.10.30 		Joo
 *
 * </pre>
 */
public class ResumeLocBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	// Base Parameter
	private String	resumeHopeWorkLocSeq	= "";
	private String 	resumeSeq				= "";
	private String 	addrCd					= "";
	private String 	addrDtl					= "";
	private String 	regUserSeq				= "";
	private String 	regDt					= "";
	private String 	modUserSeq				= "";
	private String 	modDt					= "";
	private String	addrFullCd				= "";
	private String	addrFullNm				= "";

	private List<ResumeLocBean> list;
	
	// Additional Parameter
	
	
	

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
	 * @return the resumeHopeWorkLocSeq
	 */
	public String getResumeHopeWorkLocSeq() {
		return resumeHopeWorkLocSeq;
	}

	/**
	 * @param resumeHopeWorkLocSeq the resumeHopeWorkLocSeq to set
	 */
	public void setResumeHopeWorkLocSeq(String resumeHopeWorkLocSeq) {
		this.resumeHopeWorkLocSeq = resumeHopeWorkLocSeq;
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
	 * @return the addrCd
	 */
	public String getAddrCd() {
		return addrCd;
	}

	/**
	 * @param addrCd the addrCd to set
	 */
	public void setAddrCd(String addrCd) {
		this.addrCd = addrCd;
	}

	/**
	 * @return the addrDtl
	 */
	public String getAddrDtl() {
		return addrDtl;
	}

	/**
	 * @param addrDtl the addrDtl to set
	 */
	public void setAddrDtl(String addrDtl) {
		this.addrDtl = addrDtl;
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
	 * @return the addrFullCd
	 */
	public String getAddrFullCd() {
		return addrFullCd;
	}

	/**
	 * @param addrFullCd the addrFullCd to set
	 */
	public void setAddrFullCd(String addrFullCd) {
		this.addrFullCd = addrFullCd;
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
	 * @return the list
	 */
	public List<ResumeLocBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<ResumeLocBean> list) {
		this.list = list;
	}	
	

	
}
