package ony.cpes.internal.bulletin.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 * 게시판 관리
 * @author (주)한신정보기술 연구개발팀 최관형
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일           수정자     수정내용
 *  ------------- -------- ---------------------------
 *  2019.10.07 CKW
 *
 * </pre>
 */
public class BulletinMNGBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	private String bulletinMngSeq;
	private String fileGrpCd = "";
	private String bulletinNm = "";
	private String content = "";
	private String createDt = "";
	private String useYn = "";
	private String commentYn = "";
	private String fileYn = "";
	private String delYn = "";
	private String menuCd = "";
	private String menuCdDiv = "";
	private String bulletinTypeCd = "";
	private String bulletinTypeNm = "";
	private String bannerUseYn = "";
	private String strDate = "";
	private String endDate = "";
	private String userType = "";
	private String bulletinRangeCd = "";
	private String programSeq = "";
	private String rangeCd = "";
	private String keyword = "";
	private String keywordSel = "";
	private String programId = "";
	private String jobskYn = "";
	private String stdtYn = "";
	private String employYn = "";
	private String trnngInsttYn = "";
	private int fileQty;
	private String fileSize = "";
	private String likeYn = "";
	private String sysLangCd = "";
	private String userNm = "";

	// for parameter
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private int iTotalRecords;
	private int iTotalDisplayRecords;

    private int start = 0;
    private int length = 10;
    private int orderStr = 0;
    private String orderColumn = "";
    private String orderColumnSort = "";

    private UserBean user = new UserBean();

	private String contentType;

	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getBulletinMngSeq() {
		return bulletinMngSeq;
	}
	public void setBulletinMngSeq(String bulletinMngSeq) {
		this.bulletinMngSeq = bulletinMngSeq;
	}
	public String getFileGrpCd() {
		return fileGrpCd;
	}
	public void setFileGrpCd(String fileGrpCd) {
		this.fileGrpCd = fileGrpCd;
	}
	public String getBulletinNm() {
		return bulletinNm;
	}
	public void setBulletinNm(String bulletinNm) {
		this.bulletinNm = bulletinNm;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getCommentYn() {
		return commentYn;
	}
	public void setCommentYn(String commentYn) {
		this.commentYn = commentYn;
	}
	public String getFileYn() {
		return fileYn;
	}
	public void setFileYn(String fileYn) {
		this.fileYn = fileYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getMenuCd() {
		return menuCd;
	}
	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}
	public String getMenuCdDiv() {
		return menuCdDiv;
	}
	public void setMenuCdDiv(String menuCdDiv) {
		this.menuCdDiv = menuCdDiv;
	}
	public String getBulletinTypeCd() {
		return bulletinTypeCd;
	}
	public void setBulletinTypeCd(String bulletinTypeCd) {
		this.bulletinTypeCd = bulletinTypeCd;
	}
	public String getBulletinTypeNm() {
		return bulletinTypeNm;
	}
	public void setBulletinTypeNm(String bulletinTypeNm) {
		this.bulletinTypeNm = bulletinTypeNm;
	}
	public String getBannerUseYn() {
		return bannerUseYn;
	}
	public void setBannerUseYn(String bannerUseYn) {
		this.bannerUseYn = bannerUseYn;
	}

	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getProgramSeq() {
		return programSeq;
	}
	public void setProgramSeq(String programSeq) {
		this.programSeq = programSeq;
	}
	public String getBulletinRangeCd() {
		return bulletinRangeCd;
	}
	public void setBulletinRangeCd(String bulletinRangeCd) {
		this.bulletinRangeCd = bulletinRangeCd;
	}
	public String getRangeCd() {
		return rangeCd;
	}
	public void setRangeCd(String rangeCd) {
		this.rangeCd = rangeCd;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getKeywordSel() {
		return keywordSel;
	}
	public void setKeywordSel(String keywordSel) {
		this.keywordSel = keywordSel;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getJobskYn() {
		return jobskYn;
	}
	public void setJobskYn(String jobskYn) {
		this.jobskYn = jobskYn;
	}
	public String getStdtYn() {
		return stdtYn;
	}
	public void setStdtYn(String stdtYn) {
		this.stdtYn = stdtYn;
	}
	public String getEmployYn() {
		return employYn;
	}
	public void setEmployYn(String employYn) {
		this.employYn = employYn;
	}
	public String getTrnngInsttYn() {
		return trnngInsttYn;
	}
	public void setTrnngInsttYn(String trnngInsttYn) {
		this.trnngInsttYn = trnngInsttYn;
	}
	public int getFileQty() {
		return fileQty;
	}
	public void setFileQty(int fileQty) {
		this.fileQty = fileQty;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getLikeYn() {
		return likeYn;
	}
	public void setLikeYn(String likeYn) {
		this.likeYn = likeYn;
	}
	public String getSysLangCd() {
		return sysLangCd;
	}
	public void setSysLangCd(String sysLangCd) {
		this.sysLangCd = sysLangCd;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}



	// for parameter
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getOrderStr() {
		return orderStr;
	}
	public void setOrderStr(int orderStr) {
		this.orderStr = orderStr;
	}
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public String getOrderColumnSort() {
		return orderColumnSort;
	}
	public void setOrderColumnSort(String orderColumnSort) {
		this.orderColumnSort = orderColumnSort;
	}
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}



	private List<BulletinMNGBean> list;


	public List<BulletinMNGBean> getList() {
		return list;
	}
	public void setList(List<BulletinMNGBean> list) {
		this.list = list;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
