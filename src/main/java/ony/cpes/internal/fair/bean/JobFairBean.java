package ony.cpes.internal.fair.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * Job Fair Detail Bean
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
 *  2019.11.26 		Joo
 *
 * </pre>
 */
public class JobFairBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String	sysLangCd				= "";
	
	//1. Base Parameter
	private	String	fairSeq					= "";
	private String	fairDivCd				= "";
	private String	fairNmKh				= "";					
	private String	fairNmEn				= "";
	private String	thumbFileGrpSeq			= "";
	private String	fairFileGrpSeq			= "";
	private String	jcCd					= "";
	private String	addrFullNm				= "";
	private String	fairTerm				= "";
	private String	recurmtTerm				= "";
	private String	tel1					= "";
	private String	tel2					= "";
	private String	email					= "";
	private String	boothFileGrpSeq			= "";
	private String	fairDtlExpln			= "";
	private String	fairHashtag				= "";
	private String	fairCompnyViewYn		= "";
	private String	fairVacancyViewYn		= "";
	private String	fairInsttViewYn			= "";
	private String	fairTrnngViewYn			= "";
	private String	useYn					= "";
	
	private List<JobFairBean> list;
	
	//2. Additional Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	fairDivNm				= "";
	private String	fairNm					= "";
	private String	jcNm					= "";
	
	
	
	
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
	 * @return the thumbFileGrpSeq
	 */
	public String getThumbFileGrpSeq() {
		return thumbFileGrpSeq;
	}
	/**
	 * @param thumbFileGrpSeq the thumbFileGrpSeq to set
	 */
	public void setThumbFileGrpSeq(String thumbFileGrpSeq) {
		this.thumbFileGrpSeq = thumbFileGrpSeq;
	}
	/**
	 * @return the fairFileGrpSeq
	 */
	public String getFairFileGrpSeq() {
		return fairFileGrpSeq;
	}
	/**
	 * @param fairFileGrpSeq the fairFileGrpSeq to set
	 */
	public void setFairFileGrpSeq(String fairFileGrpSeq) {
		this.fairFileGrpSeq = fairFileGrpSeq;
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
	 * @return the tel1
	 */
	public String getTel1() {
		return tel1;
	}
	/**
	 * @param tel1 the tel1 to set
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	/**
	 * @return the tel2
	 */
	public String getTel2() {
		return tel2;
	}
	/**
	 * @param tel2 the tel2 to set
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
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
	 * @return the boothFileGrpSeq
	 */
	public String getBoothFileGrpSeq() {
		return boothFileGrpSeq;
	}
	/**
	 * @param boothFileGrpSeq the boothFileGrpSeq to set
	 */
	public void setBoothFileGrpSeq(String boothFileGrpSeq) {
		this.boothFileGrpSeq = boothFileGrpSeq;
	}
	/**
	 * @return the fairDtlExpln
	 */
	public String getFairDtlExpln() {
		return fairDtlExpln;
	}
	/**
	 * @param fairDtlExpln the fairDtlExpln to set
	 */
	public void setFairDtlExpln(String fairDtlExpln) {
		this.fairDtlExpln = fairDtlExpln;
	}
	/**
	 * @return the fairHashtag
	 */
	public String getFairHashtag() {
		return fairHashtag;
	}
	/**
	 * @param fairHashtag the fairHashtag to set
	 */
	public void setFairHashtag(String fairHashtag) {
		this.fairHashtag = fairHashtag;
	}
	/**
	 * @return the fairCompnyViewYn
	 */
	public String getFairCompnyViewYn() {
		return fairCompnyViewYn;
	}
	/**
	 * @param fairCompnyViewYn the fairCompnyViewYn to set
	 */
	public void setFairCompnyViewYn(String fairCompnyViewYn) {
		this.fairCompnyViewYn = fairCompnyViewYn;
	}
	/**
	 * @return the fairVacancyViewYn
	 */
	public String getFairVacancyViewYn() {
		return fairVacancyViewYn;
	}
	/**
	 * @param fairVacancyViewYn the fairVacancyViewYn to set
	 */
	public void setFairVacancyViewYn(String fairVacancyViewYn) {
		this.fairVacancyViewYn = fairVacancyViewYn;
	}
	/**
	 * @return the fairInsttViewYn
	 */
	public String getFairInsttViewYn() {
		return fairInsttViewYn;
	}
	/**
	 * @param fairInsttViewYn the fairInsttViewYn to set
	 */
	public void setFairInsttViewYn(String fairInsttViewYn) {
		this.fairInsttViewYn = fairInsttViewYn;
	}
	/**
	 * @return the fairTrnngViewYn
	 */
	public String getFairTrnngViewYn() {
		return fairTrnngViewYn;
	}
	/**
	 * @param fairTrnngViewYn the fairTrnngViewYn to set
	 */
	public void setFairTrnngViewYn(String fairTrnngViewYn) {
		this.fairTrnngViewYn = fairTrnngViewYn;
	}
	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}
	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	/**
	 * @return the list
	 */
	public List<JobFairBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<JobFairBean> list) {
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


	
}
