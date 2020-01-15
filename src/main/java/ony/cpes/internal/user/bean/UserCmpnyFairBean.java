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
 *  2019.11.08 		Joo
 *
 * </pre>
 */
public class UserCmpnyFairBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	compnySeq				= "";
	private String	vacancySeq				= "";
	private String	fairSeq					= "";
	private String	fairDivCd				= "";
	private String	fairNmKh				= "";
	private String	fairNmEn				= "";
	private String	fairBgnDt				= "";
	private String	fairEndDt				= "";
	private String	addrCd					= "";
	private String	regDt					= "";
	
	private List<UserCmpnyFairBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	fairDivNm				= "";
	private String	fairNm					= "";
	private String	fairTerm				= "";
	private String	addrNm					= "";
	private String	fairVacancyCnt			= "";
	
	
	
	
	
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
	 * @return the fairBgnDt
	 */
	public String getFairBgnDt() {
		return fairBgnDt;
	}
	/**
	 * @param fairBgnDt the fairBgnDt to set
	 */
	public void setFairBgnDt(String fairBgnDt) {
		this.fairBgnDt = fairBgnDt;
	}
	/**
	 * @return the fairEndDt
	 */
	public String getFairEndDt() {
		return fairEndDt;
	}
	/**
	 * @param fairEndDt the fairEndDt to set
	 */
	public void setFairEndDt(String fairEndDt) {
		this.fairEndDt = fairEndDt;
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
	public List<UserCmpnyFairBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserCmpnyFairBean> list) {
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
	 * @return the addrNm
	 */
	public String getAddrNm() {
		return addrNm;
	}
	/**
	 * @param addrNm the addrNm to set
	 */
	public void setAddrNm(String addrNm) {
		this.addrNm = addrNm;
	}
	/**
	 * @return the fairVacancyCnt
	 */
	public String getFairVacancyCnt() {
		return fairVacancyCnt;
	}
	/**
	 * @param fairVacancyCnt the fairVacancyCnt to set
	 */
	public void setFairVacancyCnt(String fairVacancyCnt) {
		this.fairVacancyCnt = fairVacancyCnt;
	}
		

	
}
