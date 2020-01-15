package ony.cpes.internal.user.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * User Application Bean
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
 *  2019.11.05 		Joo
 *
 * </pre>
 */
public class UserInsttEduBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	insttSeq				= "";
	private String	eduTrnngSeq				= "";
	private String	eduTrnngId				= "";
	private String	eduDivCd				= "";
	private String 	eduTrnngNmKh			= "";
	private String	eduTrnngNmEn			= "";
	private String	recurmtTerm				= "";
	private String	regDt					= "";
	private String	eduCloseYn				= "";
	private String	eduCloseDt				= "";
	private String	eduTerm					= "";
	private String  addrCd					= "";
	private String	jcAgreeStsCd			= "";
	private String	bkmkCnt					= "";
	private String	viewCnt					= "";
	
	private List<UserInsttEduBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	eduDivNm				= "";
	private String	eduTrnngNm				= "";
	private String	jcAgreeStsNm			= "";
	private String	eduAddr					= "";
	
	
	
	
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
	 * @return the eduTrnngId
	 */
	public String getEduTrnngId() {
		return eduTrnngId;
	}
	/**
	 * @param eduTrnngId the eduTrnngId to set
	 */
	public void setEduTrnngId(String eduTrnngId) {
		this.eduTrnngId = eduTrnngId;
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
	 * @return the eduTrnngNmKh
	 */
	public String getEduTrnngNmKh() {
		return eduTrnngNmKh;
	}
	/**
	 * @param eduTrnngNmKh the eduTrnngNmKh to set
	 */
	public void setEduTrnngNmKh(String eduTrnngNmKh) {
		this.eduTrnngNmKh = eduTrnngNmKh;
	}
	/**
	 * @return the eduTrnngNmEn
	 */
	public String getEduTrnngNmEn() {
		return eduTrnngNmEn;
	}
	/**
	 * @param eduTrnngNmEn the eduTrnngNmEn to set
	 */
	public void setEduTrnngNmEn(String eduTrnngNmEn) {
		this.eduTrnngNmEn = eduTrnngNmEn;
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
	 * @return the eduCloseYn
	 */
	public String getEduCloseYn() {
		return eduCloseYn;
	}
	/**
	 * @param eduCloseYn the eduCloseYn to set
	 */
	public void setEduCloseYn(String eduCloseYn) {
		this.eduCloseYn = eduCloseYn;
	}
	/**
	 * @return the eduCloseDt
	 */
	public String getEduCloseDt() {
		return eduCloseDt;
	}
	/**
	 * @param eduCloseDt the eduCloseDt to set
	 */
	public void setEduCloseDt(String eduCloseDt) {
		this.eduCloseDt = eduCloseDt;
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
	public List<UserInsttEduBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserInsttEduBean> list) {
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
	 * @return the eduAddr
	 */
	public String getEduAddr() {
		return eduAddr;
	}
	/**
	 * @param eduAddr the eduAddr to set
	 */
	public void setEduAddr(String eduAddr) {
		this.eduAddr = eduAddr;
	}
		

	
}
