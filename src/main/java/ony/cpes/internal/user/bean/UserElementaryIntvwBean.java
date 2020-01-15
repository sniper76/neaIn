package ony.cpes.internal.user.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Elementary User Bean
 * @author onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * 
 *
 *  Modify Date     Modifier    Description
 *  ------------- 	-------- 	---------------------------
 *  2019.12.05 		Joo
 *
 * </pre>
 */
public class UserElementaryIntvwBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String 	intvwHisSeq				= "";
	private String	userSeq					= "";
	private String	resumeSeq				= "";
	private String	compnySeq				= "";
	private String	intvwDt					= "";
	private String	intvwDtHour				= "";
	private String	intvwDtMinute			= "";
	private String	intvwDtAmpm				= "";
	private String	addrCd					= "";
	private String	addrFullCd				= "";
	private String	addrFullNm				= "";
	private String	addrDtl					= "";
	private String	jcCd					= "";
	private String	regUserSeq				= "";
	private String	regDt					= "";
	private String	modUserSeq				= "";
	private String	modDt					= "";
	private String	content					= "";
	
	private List<UserElementaryIntvwBean> list;
	
	//Additional Data Parameter
	private String	compnyNm				= "";
	private String	compnyNmKh				= "";
	private String	compnyNmEn				= "";
	private String	jcNm					= "";
	private String	regUserNm				= "";
	private String	modUserNm				= "";
	private String	intvwAddr				= "";
	
	
	
	
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
	 * @return the intvwHisSeq
	 */
	public String getIntvwHisSeq() {
		return intvwHisSeq;
	}
	/**
	 * @param intvwHisSeq the intvwHisSeq to set
	 */
	public void setIntvwHisSeq(String intvwHisSeq) {
		this.intvwHisSeq = intvwHisSeq;
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
	 * @return the intvwDtHour
	 */
	public String getIntvwDtHour() {
		return intvwDtHour;
	}
	/**
	 * @param intvwDtHour the intvwDtHour to set
	 */
	public void setIntvwDtHour(String intvwDtHour) {
		this.intvwDtHour = intvwDtHour;
	}
	/**
	 * @return the intvwDtMinute
	 */
	public String getIntvwDtMinute() {
		return intvwDtMinute;
	}
	/**
	 * @param intvwDtMinute the intvwDtMinute to set
	 */
	public void setIntvwDtMinute(String intvwDtMinute) {
		this.intvwDtMinute = intvwDtMinute;
	}
	/**
	 * @return the intvwDtAmpm
	 */
	public String getIntvwDtAmpm() {
		return intvwDtAmpm;
	}
	/**
	 * @param intvwDtAmpm the intvwDtAmpm to set
	 */
	public void setIntvwDtAmpm(String intvwDtAmpm) {
		this.intvwDtAmpm = intvwDtAmpm;
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
	 * @return the list
	 */
	public List<UserElementaryIntvwBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserElementaryIntvwBean> list) {
		this.list = list;
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
	 * @return the jcNm
	 */
	public String getJcNm() {
		return jcNm;
	}
	/**
	 * @param jcNm the jcNm to set
	 */
	public void setJcNm(String jcNm) {
		this.jcNm = jcNm;
	}
	/**
	 * @return the regUserNm
	 */
	public String getRegUserNm() {
		return regUserNm;
	}
	/**
	 * @param regUserNm the regUserNm to set
	 */
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}
	/**
	 * @return the modUserNm
	 */
	public String getModUserNm() {
		return modUserNm;
	}
	/**
	 * @param modUserNm the modUserNm to set
	 */
	public void setModUserNm(String modUserNm) {
		this.modUserNm = modUserNm;
	}
	/**
	 * @return the intvwAddr
	 */
	public String getIntvwAddr() {
		return intvwAddr;
	}
	/**
	 * @param intvwAddr the intvwAddr to set
	 */
	public void setIntvwAddr(String intvwAddr) {
		this.intvwAddr = intvwAddr;
	}	
	

	
	
}
