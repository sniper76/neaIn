package ony.cpes.internal.referral.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.user.bean.UserCmpnyBean;
import ony.cpes.internal.vacancy.bean.VacancyBean;

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
 *  2019.10.11 		Joo
 *
 * </pre>
 */
public class ReferralBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	/* Data Variable */
	private String vacancySeq		= "";
	private String resumeSeq		= "";
	private String jcCd				= "";
	private String jcUserSeq		= "";
	private String regUserSeq		= "";
	private String regDt			= "";
	private String modUserSeq		= "";
	private String modDt			= "";
	private String referralTypeCd	= "";
	private String referralStsCd	= "";
	
	private String compnyNm			= "";
	private String vacancyTitle		= "";
	private String jcUserNm			= "";
	private String referralDate		= "";
	private String jcEn				= "";
	private String strDate			= "";
	private String referralCounselRecord			= "";
	private String mngerOpinion			= "";
	private String jobUserNm        = "";
	private String jcNm             = "";
	private String compnySeq        = "";
	private String userSeq          = "";
	private String referralTypeNm	= "";
	private String delYn            = "";
	private String keywordSel  = "";
	private String Keyword     = "";

	private List<ReferralBean> list;
	
	private UserBean user = new UserBean();
	
	private ResumeBean  resume = new ResumeBean();
	
	private UserCmpnyBean cmpny = new UserCmpnyBean();
	
	private VacancyBean vacancy = new VacancyBean();
	
	
	/* Paging Variable */
	private int draw;
    private int recordsTotal		= 0;
    private int recordsFiltered		= 0;
    private int start 				= 0;
    private int length 				= 10;
    private int orderStr 			= 0;
    private String orderColumn 		= "";
    private String orderColumnSort 	= "";
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
	 * @return the jcUserSeq
	 */
	public String getJcUserSeq() {
		return jcUserSeq;
	}
	/**
	 * @param jcUserSeq the jcUserSeq to set
	 */
	public void setJcUserSeq(String jcUserSeq) {
		this.jcUserSeq = jcUserSeq;
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
	 * @return the referralTypeCd
	 */
	public String getReferralTypeCd() {
		return referralTypeCd;
	}
	/**
	 * @param referralTypeCd the referralTypeCd to set
	 */
	public void setReferralTypeCd(String referralTypeCd) {
		this.referralTypeCd = referralTypeCd;
	}
	/**
	 * @return the referralStsCd
	 */
	public String getReferralStsCd() {
		return referralStsCd;
	}
	/**
	 * @param referralStsCd the referralStsCd to set
	 */
	public void setReferralStsCd(String referralStsCd) {
		this.referralStsCd = referralStsCd;
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
	 * @return the jcUserNm
	 */
	public String getJcUserNm() {
		return jcUserNm;
	}
	/**
	 * @param jcUserNm the jcUserNm to set
	 */
	public void setJcUserNm(String jcUserNm) {
		this.jcUserNm = jcUserNm;
	}
	/**
	 * @return the referralDate
	 */
	public String getReferralDate() {
		return referralDate;
	}
	/**
	 * @param referralDate the referralDate to set
	 */
	public void setReferralDate(String referralDate) {
		this.referralDate = referralDate;
	}
	/**
	 * @return the jcEn
	 */
	public String getJcEn() {
		return jcEn;
	}
	/**
	 * @param jcEn the jcEn to set
	 */
	public void setJcEn(String jcEn) {
		this.jcEn = jcEn;
	}
	/**
	 * @return the strDate
	 */
	public String getStrDate() {
		return strDate;
	}
	/**
	 * @param strDate the strDate to set
	 */
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	/**
	 * @return the referralCounselRecord
	 */
	public String getReferralCounselRecord() {
		return referralCounselRecord;
	}
	/**
	 * @param referralCounselRecord the referralCounselRecord to set
	 */
	public void setReferralCounselRecord(String referralCounselRecord) {
		this.referralCounselRecord = referralCounselRecord;
	}
	/**
	 * @return the mngerOpinion
	 */
	public String getMngerOpinion() {
		return mngerOpinion;
	}
	/**
	 * @param mngerOpinion the mngerOpinion to set
	 */
	public void setMngerOpinion(String mngerOpinion) {
		this.mngerOpinion = mngerOpinion;
	}
	/**
	 * @return the list
	 */
	public List<ReferralBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<ReferralBean> list) {
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
	/**
	 * @return the cmpny
	 */
	public UserCmpnyBean getCmpny() {
		return cmpny;
	}
	/**
	 * @param cmpny the cmpny to set
	 */
	public void setCmpny(UserCmpnyBean cmpny) {
		this.cmpny = cmpny;
	}
	/**
	 * @return the resume
	 */
	public ResumeBean getResume() {
		return resume;
	}
	/**
	 * @param resume the resume to set
	 */
	public void setResume(ResumeBean resume) {
		this.resume = resume;
	}
	/**
	 * @return the vacancy
	 */
	public VacancyBean getVacancy() {
		return vacancy;
	}
	/**
	 * @param vacancy the vacancy to set
	 */
	public void setVacancy(VacancyBean vacancy) {
		this.vacancy = vacancy;
	}
	/**
	 * @return the jobUserNm
	 */
	public String getJobUserNm() {
		return jobUserNm;
	}
	/**
	 * @param jobUserNm the jobUserNm to set
	 */
	public void setJobUserNm(String jobUserNm) {
		this.jobUserNm = jobUserNm;
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
	 * @return the referralTypeNm
	 */
	public String getReferralTypeNm() {
		return referralTypeNm;
	}
	/**
	 * @param referralTypeNm the referralTypeNm to set
	 */
	public void setReferralTypeNm(String referralTypeNm) {
		this.referralTypeNm = referralTypeNm;
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
	 * @return the delYn
	 */
	public String getDelYn() {
		return delYn;
	}
	/**
	 * @param delYn the delYn to set
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
    
    
}