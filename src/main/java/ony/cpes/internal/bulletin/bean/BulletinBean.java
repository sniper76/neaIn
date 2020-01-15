package ony.cpes.internal.bulletin.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 * 게시판 관리 목록 조회
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
public class BulletinBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	private String bulletinSeq       = "";
	private String bulletinMngSeq    = "";
	private String fileGrpSeq        = "";
	private String bulletinCateSeq   = "";
	private String bulletinCateNm    = "";
	private String sort              = "";
	private String depth             = "";
	private String writeDt           = "";
	private String writerNm          = "";
	private String titleEn           = "";
	private String titleKh           = "";
	private String contentEn         = "";
	private String contentKh         = "";
	private String title             = "";
	private String content           = "";
	private String viewCnt           = "";
	private String commentCnt        = "";
	private String useYn             = "";
	private String delYn             = "";
	private String jcCd              = "";
	private String strDate           = "";
	private String endDate           = "";
	private String viewYn            = "";
	private String agreeYn           = "";
	private String bulletinRangeCd   = "";
	private String likeCnt           = "";
	private String keyword           = "";
	private String keywordSel        = "";
	private String sysLangCd         = "";
	private String fileCnt           = "";
	private String fileQty           = "";
	private String fileYn            = "";
	private String fileSize          = "";
	private String likeYn            = "";
	private int    notiCnt;
	private String ntcYn          	 = "";
	private String bulletinTypeCd    = "";
	private String userNm 			 = "";
	private String programId 		 = "";

	private List<String> bulletinSeqList = new ArrayList<String>();

	private List<String> selectedList 		= new ArrayList<String>();

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

	private String uploadResult;

	public String getUploadResult() {
		return uploadResult;
	}
	public void setUploadResult(String uploadResult) {
		this.uploadResult = uploadResult;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getBulletinSeq() {
		return bulletinSeq;
	}
	public void setBulletinSeq(String bulletinSeq) {
		this.bulletinSeq = bulletinSeq;
	}
	public String getBulletinMngSeq() {
		return bulletinMngSeq;
	}
	public void setBulletinMngSeq(String bulletinMngSeq) {
		this.bulletinMngSeq = bulletinMngSeq;
	}
	public String getFileGrpSeq() {
		return fileGrpSeq;
	}
	public void setFileGrpSeq(String fileGrpSeq) {
		this.fileGrpSeq = fileGrpSeq;
	}
	public String getBulletinCateSeq() {
		return bulletinCateSeq;
	}
	public void setBulletinCateSeq(String bulletinCateSeq) {
		this.bulletinCateSeq = bulletinCateSeq;
	}
	public String getBulletinCateNm() {
		return bulletinCateNm;
	}
	public void setBulletinCateNm(String bulletinCateNm) {
		this.bulletinCateNm = bulletinCateNm;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getWriteDt() {
		return writeDt;
	}
	public void setWriteDt(String writeDt) {
		this.writeDt = writeDt;
	}
	public String getWriterNm() {
		return writerNm;
	}
	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}
	public String getTitleEn() {
		return titleEn;
	}
	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}
	public String getTitleKh() {
		return titleKh;
	}
	public void setTitleKh(String titleKh) {
		this.titleKh = titleKh;
	}
	public String getContentEn() {
		return contentEn;
	}
	public void setContentEn(String contentEn) {
		this.contentEn = contentEn;
	}
	public String getContentKh() {
		return contentKh;
	}
	public void setContentKh(String contentKh) {
		this.contentKh = contentKh;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(String commentCnt) {
		this.commentCnt = commentCnt;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getJcCd() {
		return jcCd;
	}
	public void setJcCd(String jcCd) {
		this.jcCd = jcCd;
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
	public String getViewYn() {
		return viewYn;
	}
	public void setViewYn(String viewYn) {
		this.viewYn = viewYn;
	}
	public String getAgreeYn() {
		return agreeYn;
	}
	public void setAgreeYn(String agreeYn) {
		this.agreeYn = agreeYn;
	}
	public String getBulletinRangeCd() {
		return bulletinRangeCd;
	}
	public void setBulletinRangeCd(String bulletinRangeCd) {
		this.bulletinRangeCd = bulletinRangeCd;
	}
	public String getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(String likeCnt) {
		this.likeCnt = likeCnt;
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
	public String getSysLangCd() {
		return sysLangCd;
	}
	public void setSysLangCd(String sysLangCd) {
		this.sysLangCd = sysLangCd;
	}
	public String getFileCnt() {
		return fileCnt;
	}
	public void setFileCnt(String fileCnt) {
		this.fileCnt = fileCnt;
	}
	public String getFileQty() {
		return fileQty;
	}
	public void setFileQty(String fileQty) {
		this.fileQty = fileQty;
	}
	public String getFileYn() {
		return fileYn;
	}
	public void setFileYn(String fileYn) {
		this.fileYn = fileYn;
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
	public int getNotiCnt() {
		return notiCnt;
	}
	public void setNotiCnt(int notiCnt) {
		this.notiCnt = notiCnt;
	}
	public String getNtcYn() {
		return ntcYn;
	}
	public void setNtcYn(String ntcYn) {
		this.ntcYn = ntcYn;
	}
	public String getBulletinTypeCd() {
		return bulletinTypeCd;
	}
	public void setBulletinTypeCd(String bulletinTypeCd) {
		this.bulletinTypeCd = bulletinTypeCd;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public List<String> getSelectedList() {
		return selectedList;
	}
	public void setSelectedList(List<String> selectedList) {
		this.selectedList = selectedList;
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

	/**
	 * @return the bulletinSeqList
	 */
	public List<String> getBulletinSeqList() {
		return bulletinSeqList;
	}
	/**
	 * @param bulletinSeqList the bulletinSeqList to set
	 */
	public void setBulletinSeqList(List<String> bulletinSeqList) {
		this.bulletinSeqList = bulletinSeqList;
	}

	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}



	private List<BulletinBean> list;


	public List<BulletinBean> getList() {
		return list;
	}
	public void setList(List<BulletinBean> list) {
		this.list = list;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
