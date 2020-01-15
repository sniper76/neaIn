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
public class UserOfferBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	compnySeq				= "";
	private String	resumeSeq				= "";
	private String	userSeq					= "";
	private String	compnyNmKh				= "";
	private String	compnyNmEn				= "";
	private String	mngerNm					= "";
	private String	mngerEmail				= "";
	private String	mngerTel				= "";
	private String	resumeTitle				= "";
	private String	offerDt					= "";
	private String	offerOpenYn				= "";
	private String	offerOpenDt				= "";
	private String	aplcYn					= "";
	
	private List<UserOfferBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	compnyNm				= "";
	
	
	
	
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
	 * @return the resumeTitle
	 */
	public String getResumeTitle() {
		return resumeTitle;
	}
	/**
	 * @param resumeTitle the resumeTitle to set
	 */
	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}
	/**
	 * @return the offerDt
	 */
	public String getOfferDt() {
		return offerDt;
	}
	/**
	 * @param offerDt the offerDt to set
	 */
	public void setOfferDt(String offerDt) {
		this.offerDt = offerDt;
	}
	/**
	 * @return the offerOpenYn
	 */
	public String getOfferOpenYn() {
		return offerOpenYn;
	}
	/**
	 * @param offerOpenYn the offerOpenYn to set
	 */
	public void setOfferOpenYn(String offerOpenYn) {
		this.offerOpenYn = offerOpenYn;
	}
	/**
	 * @return the offerOpenDt
	 */
	public String getOfferOpenDt() {
		return offerOpenDt;
	}
	/**
	 * @param offerOpenDt the offerOpenDt to set
	 */
	public void setOfferOpenDt(String offerOpenDt) {
		this.offerOpenDt = offerOpenDt;
	}
	/**
	 * @return the aplcYn
	 */
	public String getAplcYn() {
		return aplcYn;
	}
	/**
	 * @param aplcYn the aplcYn to set
	 */
	public void setAplcYn(String aplcYn) {
		this.aplcYn = aplcYn;
	}
	/**
	 * @return the list
	 */
	public List<UserOfferBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserOfferBean> list) {
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


	
}
