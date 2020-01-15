package ony.cpes.internal.referral.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.user.bean.UserCmpnyBean;

/**
 * referral
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
 *  2019.11.18 		ckw
 *
 * </pre>
 */
public class VacancyReferralBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	/* Data Variable */
	private String 	vacancySeq				= "";
	private String 	compnySeq				= "";
	private String 	vacancyId				= "";
	private String 	employFormCd			= "";
	private String 	compnyNm				= "";
	private String	vacancyTitle			= "";
	private String 	regDt					= "";
	private String 	jcAgreeYn				= "";
	private String	jcAgreeDt				= "";
	private String 	jcAgreeStsCd			= "";
	private String 	vacancyStsCd			= "";
	private String 	recrumtMemb				= "";
	private String	applicCnt				= "";
	private String	passCnt					= "";
	private String	jcCd					= "";
	private String	jcNm					= "";
	private String mngerNm                  = "";
	private String mngerCell                = "";
	private String mngerEmail               = "";
	private String endDt                    = "";
	private String keywordSel  = "";
	private String Keyword     = "";

	private List<VacancyReferralBean> list;
	
	/* Paging Variable */
	private int draw;
    private int recordsTotal		= 0;
    private int recordsFiltered		= 0;
    private int start 				= 0;
    private int length 				= 10;
    private int orderStr 			= 0;
    private String orderColumn 		= "";
    private String orderColumnSort 	= "";
	
    private UserBean user = new UserBean();
    private List<UserCmpnyBean> cmpnyList;
    
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the vacancyId
	 */
	public String getVacancyId() {
		return vacancyId;
	}
	/**
	 * @param vacancyId the vacancyId to set
	 */
	public void setVacancyId(String vacancyId) {
		this.vacancyId = vacancyId;
	}
	/**
	 * @return the endDt
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * @param endDt the endDt to set
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
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
	 * @return the mngerCell
	 */
	public String getMngerCell() {
		return mngerCell;
	}
	/**
	 * @param mngerCell the mngerCell to set
	 */
	public void setMngerCell(String mngerCell) {
		this.mngerCell = mngerCell;
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
	 * @return the employFormCd
	 */
	public String getEmployFormCd() {
		return employFormCd;
	}
	/**
	 * @param employFormCd the employFormCd to set
	 */
	public void setEmployFormCd(String employFormCd) {
		this.employFormCd = employFormCd;
	}
	
	/**
	 * @return the vacancyTitle
	 */
	public String getVacancyTitle() {
		return vacancyTitle;
	}
	/**
	 * @param vacancyTitle the vacancyTitle to set
	 */
	public void setVacancyTitle(String vacancyTitle) {
		this.vacancyTitle = vacancyTitle;
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
	 * @return the jcAgreeYn
	 */
	public String getJcAgreeYn() {
		return jcAgreeYn;
	}
	/**
	 * @param jcAgreeYn the jcAgreeYn to set
	 */
	public void setJcAgreeYn(String jcAgreeYn) {
		this.jcAgreeYn = jcAgreeYn;
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
	 * @return the vacancyStsCd
	 */
	public String getVacancyStsCd() {
		return vacancyStsCd;
	}
	/**
	 * @param vacancyStsCd the vacancyStsCd to set
	 */
	public void setVacancyStsCd(String vacancyStsCd) {
		this.vacancyStsCd = vacancyStsCd;
	}
	/**
	 * @return the recrumtMemb
	 */
	public String getRecrumtMemb() {
		return recrumtMemb;
	}
	/**
	 * @param recrumtMemb the recrumtMemb to set
	 */
	public void setRecrumtMemb(String recrumtMemb) {
		this.recrumtMemb = recrumtMemb;
	}
	/**
	 * @return the applicCnt
	 */
	public String getApplicCnt() {
		return applicCnt;
	}
	/**
	 * @param applicCnt the applicCnt to set
	 */
	public void setApplicCnt(String applicCnt) {
		this.applicCnt = applicCnt;
	}
	/**
	 * @return the passCnt
	 */
	public String getPassCnt() {
		return passCnt;
	}
	/**
	 * @param passCnt the passCnt to set
	 */
	public void setPassCnt(String passCnt) {
		this.passCnt = passCnt;
	}
	/**
	 * @return the cmpnyList
	 */
	public List<UserCmpnyBean> getCmpnyList() {
		return cmpnyList;
	}
	/**
	 * @param cmpnyList the cmpnyList to set
	 */
	public void setCmpnyList(List<UserCmpnyBean> cmpnyList) {
		this.cmpnyList = cmpnyList;
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
	 * @return the keywordSel
	 */
	public String getKeywordSel() {
		return keywordSel;
	}
	/**
	 * @param keywordSel the keywordSel to set
	 */
	public void setKeywordSel(String keywordSel) {
		this.keywordSel = keywordSel;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return Keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		Keyword = keyword;
	}
	/**
	 * @return the list
	 */
	public List<VacancyReferralBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<VacancyReferralBean> list) {
		this.list = list;
	}
	/**
	 * @return the draw
	 */
	public int getDraw() {
		return draw;
	}
	/**
	 * @param draw the draw to set
	 */
	public void setDraw(int draw) {
		this.draw = draw;
	}
	/**
	 * @return the recordsTotal
	 */
	public int getRecordsTotal() {
		return recordsTotal;
	}
	/**
	 * @param recordsTotal the recordsTotal to set
	 */
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	/**
	 * @return the recordsFiltered
	 */
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	/**
	 * @param recordsFiltered the recordsFiltered to set
	 */
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return the orderStr
	 */
	public int getOrderStr() {
		return orderStr;
	}
	/**
	 * @param orderStr the orderStr to set
	 */
	public void setOrderStr(int orderStr) {
		this.orderStr = orderStr;
	}
	/**
	 * @return the orderColumn
	 */
	public String getOrderColumn() {
		return orderColumn;
	}
	/**
	 * @param orderColumn the orderColumn to set
	 */
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	/**
	 * @return the orderColumnSort
	 */
	public String getOrderColumnSort() {
		return orderColumnSort;
	}
	/**
	 * @param orderColumnSort the orderColumnSort to set
	 */
	public void setOrderColumnSort(String orderColumnSort) {
		this.orderColumnSort = orderColumnSort;
	}
	/**
	 * @return the user
	 */
	public UserBean getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserBean user) {
		this.user = user;
	}
    
    
}