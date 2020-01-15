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
public class UserFairBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	userSeq					= "";
	private String	fairSeq					= "";
	private String	fairDivCd				= "";
	private String	fairNmKh				= "";
	private String	fairNmEn				= "";
	private String	AddrCd					= "";
	private String	jcCd					= "";
	private String	recrumtTerm				= "";
	private String	fairTerm				= "";
	private String	fairStsCd				= "";
	private String	jcAgreeStsCd			= "";
	private String	regDt					= "";
	
	private List<UserFairBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	fairDivNm				= "";
	private String	fairNm					= "";
	private String	AddrNm					= "";
	private String	jcNm					= "";
	private String	fairStsNm				= "";
	private String	jcAgreeStsNm			= "";
	
	
	
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
	 * @return the fairSeq
	 */
	public String getFairSeq() {
		return fairSeq;
	}
	/**
	 * @param fairSeq the fairSeq to set
	 */
	public void setFairSeq(String fairSeq) {
		this.fairSeq = fairSeq;
	}
	/**
	 * @return the fairDivCd
	 */
	public String getFairDivCd() {
		return fairDivCd;
	}
	/**
	 * @param fairDivCd the fairDivCd to set
	 */
	public void setFairDivCd(String fairDivCd) {
		this.fairDivCd = fairDivCd;
	}
	/**
	 * @return the fairNmKh
	 */
	public String getFairNmKh() {
		return fairNmKh;
	}
	/**
	 * @param fairNmKh the fairNmKh to set
	 */
	public void setFairNmKh(String fairNmKh) {
		this.fairNmKh = fairNmKh;
	}
	/**
	 * @return the fairNmEn
	 */
	public String getFairNmEn() {
		return fairNmEn;
	}
	/**
	 * @param fairNmEn the fairNmEn to set
	 */
	public void setFairNmEn(String fairNmEn) {
		this.fairNmEn = fairNmEn;
	}
	/**
	 * @return the addrCd
	 */
	public String getAddrCd() {
		return AddrCd;
	}
	/**
	 * @param addrCd the addrCd to set
	 */
	public void setAddrCd(String addrCd) {
		AddrCd = addrCd;
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
	 * @return the recrumtTerm
	 */
	public String getRecrumtTerm() {
		return recrumtTerm;
	}
	/**
	 * @param recrumtTerm the recrumtTerm to set
	 */
	public void setRecrumtTerm(String recrumtTerm) {
		this.recrumtTerm = recrumtTerm;
	}
	/**
	 * @return the fairTerm
	 */
	public String getFairTerm() {
		return fairTerm;
	}
	/**
	 * @param fairTerm the fairTerm to set
	 */
	public void setFairTerm(String fairTerm) {
		this.fairTerm = fairTerm;
	}
	/**
	 * @return the fairStsCd
	 */
	public String getFairStsCd() {
		return fairStsCd;
	}
	/**
	 * @param fairStsCd the fairStsCd to set
	 */
	public void setFairStsCd(String fairStsCd) {
		this.fairStsCd = fairStsCd;
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
	public List<UserFairBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserFairBean> list) {
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
	 * @return the fairDivNm
	 */
	public String getFairDivNm() {
		return fairDivNm;
	}
	/**
	 * @param fairDivNm the fairDivNm to set
	 */
	public void setFairDivNm(String fairDivNm) {
		this.fairDivNm = fairDivNm;
	}
	/**
	 * @return the fairNm
	 */
	public String getFairNm() {
		return fairNm;
	}
	/**
	 * @param fairNm the fairNm to set
	 */
	public void setFairNm(String fairNm) {
		this.fairNm = fairNm;
	}
	/**
	 * @return the addrNm
	 */
	public String getAddrNm() {
		return AddrNm;
	}
	/**
	 * @param addrNm the addrNm to set
	 */
	public void setAddrNm(String addrNm) {
		AddrNm = addrNm;
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
	 * @return the fairStsNm
	 */
	public String getFairStsNm() {
		return fairStsNm;
	}
	/**
	 * @param fairStsNm the fairStsNm to set
	 */
	public void setFairStsNm(String fairStsNm) {
		this.fairStsNm = fairStsNm;
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
		

	
}
