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
 *  2019.11.09 		Joo
 *
 * </pre>
 */
public class UserInsttFairBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	insttSeq				= "";
	private String	eduTrnngSeq				= "";
	private String	fairSeq					= "";
	private String	fairDivCd				= "";
	private String	fairNmKh				= "";
	private String	fairNmEn				= "";
	private String	fairLoc					= "";
	private String	jcCd					= "";
	private String	recurmtBgnDt			= "";
	private String	recurmtEndDt			= "";
	private String	fairBgnDt				= "";
	private String	fairEndDt				= "";
	private String	fairStsCd				= "";
	private String	fairFullAddr			= "";
	private String	fairAddrDtl				= "";
	private String	eduTrnngNm				= "";
	private String	jcAgreeStsCd			= "";
	private String	jcAgreeDt				= "";
	private String	regDt					= "";
	
	private List<UserInsttFairBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	fairDivNm				= "";
	private String	fairNm					= "";
	private String	jcNm					= "";
	private String	recurmtTerm				= "";
	private String	fairTerm				= "";
	private String	fairAddr				= "";
	private String	fairStsNm				= "";
	private String	jcAgreeStsNm			= "";
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
	 * @return the insttSeq
	 */
	public String getInsttSeq() {
		return insttSeq;
	}
	/**
	 * @param insttSeq the insttSeq to set
	 */
	public void setInsttSeq(String insttSeq) {
		this.insttSeq = insttSeq;
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
	 * @return the fairLoc
	 */
	public String getFairLoc() {
		return fairLoc;
	}
	/**
	 * @param fairLoc the fairLoc to set
	 */
	public void setFairLoc(String fairLoc) {
		this.fairLoc = fairLoc;
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
	 * @return the recurmtBgnDt
	 */
	public String getRecurmtBgnDt() {
		return recurmtBgnDt;
	}
	/**
	 * @param recurmtBgnDt the recurmtBgnDt to set
	 */
	public void setRecurmtBgnDt(String recurmtBgnDt) {
		this.recurmtBgnDt = recurmtBgnDt;
	}
	/**
	 * @return the recurmtEndDt
	 */
	public String getRecurmtEndDt() {
		return recurmtEndDt;
	}
	/**
	 * @param recurmtEndDt the recurmtEndDt to set
	 */
	public void setRecurmtEndDt(String recurmtEndDt) {
		this.recurmtEndDt = recurmtEndDt;
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
	 * @return the fairFullAddr
	 */
	public String getFairFullAddr() {
		return fairFullAddr;
	}
	/**
	 * @param fairFullAddr the fairFullAddr to set
	 */
	public void setFairFullAddr(String fairFullAddr) {
		this.fairFullAddr = fairFullAddr;
	}
	/**
	 * @return the fairAddrDtl
	 */
	public String getFairAddrDtl() {
		return fairAddrDtl;
	}
	/**
	 * @param fairAddrDtl the fairAddrDtl to set
	 */
	public void setFairAddrDtl(String fairAddrDtl) {
		this.fairAddrDtl = fairAddrDtl;
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
	public List<UserInsttFairBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserInsttFairBean> list) {
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
	 * @return the fairAddr
	 */
	public String getFairAddr() {
		return fairAddr;
	}
	/**
	 * @param fairAddr the fairAddr to set
	 */
	public void setFairAddr(String fairAddr) {
		this.fairAddr = fairAddr;
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
