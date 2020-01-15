package ony.cpes.internal.referral.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

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
public class JobskReferralBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	/* Data Variable */
	private String resumeSeq   = "";
	private String userSeq     = "";
	private String userNm      = "";
	private String resumeTitle = "";
	private String nowWorkSts  = "";
	private String userAuthCd  = "";
	private String cell        = "";
	private String emailAddr   = "";
	private String modDt       = "";
	private String jcNm        = "";
	private String jcCd        = "";
	private String jobskStsCd  = "";
	private String jobskReqSeq = "";
	private String keywordSel  = "";
	private String Keyword     = "";

	private List<JobskReferralBean> list;
	
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
    private List<UserBean> userList;
    
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
	 * @return the jobskReqSeq
	 */
	public String getJobskReqSeq() {
		return jobskReqSeq;
	}
	/**
	 * @param jobskReqSeq the jobskReqSeq to set
	 */
	public void setJobskReqSeq(String jobskReqSeq) {
		this.jobskReqSeq = jobskReqSeq;
	}
	/**
	 * @return the userNm
	 */
	public String getUserNm() {
		return userNm;
	}
	/**
	 * @param userNm the userNm to set
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
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
	 * @return the nowWorkSts
	 */
	public String getNowWorkSts() {
		return nowWorkSts;
	}
	/**
	 * @param nowWorkSts the nowWorkSts to set
	 */
	public void setNowWorkSts(String nowWorkSts) {
		this.nowWorkSts = nowWorkSts;
	}
	/**
	 * @return the userAuthCd
	 */
	public String getUserAuthCd() {
		return userAuthCd;
	}
	/**
	 * @param userAuthCd the userAuthCd to set
	 */
	public void setUserAuthCd(String userAuthCd) {
		this.userAuthCd = userAuthCd;
	}
	/**
	 * @return the cell
	 */
	public String getCell() {
		return cell;
	}
	/**
	 * @param cell the cell to set
	 */
	public void setCell(String cell) {
		this.cell = cell;
	}
	/**
	 * @return the emailAddr
	 */
	public String getEmailAddr() {
		return emailAddr;
	}
	/**
	 * @param emailAddr the emailAddr to set
	 */
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	/**
	 * @return the jobskStsCd
	 */
	public String getJobskStsCd() {
		return jobskStsCd;
	}
	/**
	 * @param jobskStsCd the jobskStsCd to set
	 */
	public void setJobskStsCd(String jobskStsCd) {
		this.jobskStsCd = jobskStsCd;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the userList
	 */
	public List<UserBean> getUserList() {
		return userList;
	}
	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
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
	public List<JobskReferralBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<JobskReferralBean> list) {
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