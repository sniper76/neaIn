package ony.cmm.common.bean;

import java.util.List;

import ony.framework.bean.PagingBean;

/**
 * bean 공통정보를 담는 bean
 *
 * @author 우성택
 * @version 1.0
 * @since 2019.01.02
 */
public class CommonBean extends PagingBean{

	private String regDt;		//등록일시
	private String regUserSeq;		//등록자 일련번호
	private String regNm;		//등록자명
	private String modDt;		//수정일시
	private String modUserSeq;		//수정자 일련번호
	private String modNm;
	private String updNm;		//수정자명
	private String resultCode;  //결과코드
	private String msg;			//결과메시지

	//[2019-10-14 : Joo] Add Language Code
	private String lang;
	//[2019-10-15 : Joo] Add Row Num
	private String rowNum;
	//[2019-10-17 : Joo] Add Period Parameter
	private String startDate;
	private String endDate;

	// 공통 코드 관련
	private String CODE;
	private String CODE_NM;
	private List<CommonBean> commonList;

	/** 페이징관련 */
	/** 페이징 객체 */
	PagingBean paging;

	/* Paging Variable */
	private int draw						= 0;
    private int recordsTotal				= 0;
    private int recordsFiltered				= 0;
	private int iTotalRecords				= 0;
	private int iTotalDisplayRecords		= 0;
	private int start 						= 0;
    private int length 						= 10;
    private int pageNo						= 0;
    private int orderStr 					= 0;
    private String orderColumn 				= "";
    private String orderColumnSort 			= "";
    private String listNo;

    /*searching*/
    private String searchType 				= "";
    private String searchKeyword			= "";
    private String searchValue				= "";

	// 지역 및 직종 코드 조회시 사용
	private String depth					= "";
	private String cdLength					= "";
	private String cd						= "";
	private String cdNm						= "";
	private String flag						= "";

	private String orderBy					= "";
	private String previousUrl				= "";

	private String filePath;


	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	 * @return the regNm
	 */
	public String getRegNm() {
		return regNm;
	}
	/**
	 * @param regNm the regNm to set
	 */
	public void setRegNm(String regNm) {
		this.regNm = regNm;
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
	 * @return the modNm
	 */
	public String getModNm() {
		return modNm;
	}
	/**
	 * @param modNm the modNm to set
	 */
	public void setModNm(String modNm) {
		this.modNm = modNm;
	}
	/**
	 * @return the updNm
	 */
	public String getUpdNm() {
		return updNm;
	}
	/**
	 * @param updNm the updNm to set
	 */
	public void setUpdNm(String updNm) {
		this.updNm = updNm;
	}
	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	/**
	 * @return the rowNum
	 */
	public String getRowNum() {
		return rowNum;
	}
	/**
	 * @param rowNum the rowNum to set
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the cODE
	 */
	public String getCODE() {
		return CODE;
	}
	/**
	 * @param cODE the cODE to set
	 */
	public void setCODE(String cODE) {
		CODE = cODE;
	}
	/**
	 * @return the cODE_NM
	 */
	public String getCODE_NM() {
		return CODE_NM;
	}
	/**
	 * @param cODE_NM the cODE_NM to set
	 */
	public void setCODE_NM(String cODE_NM) {
		CODE_NM = cODE_NM;
	}
	/**
	 * @return the commonList
	 */
	public List<CommonBean> getCommonList() {
		return commonList;
	}
	/**
	 * @param commonList the commonList to set
	 */
	public void setCommonList(List<CommonBean> commonList) {
		this.commonList = commonList;
	}
	/**
	 * @return the paging
	 */
	public PagingBean getPaging() {
		return paging;
	}
	/**
	 * @param paging the paging to set
	 */
	public void setPaging(PagingBean paging) {
		this.paging = paging;
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
	 * @return the iTotalRecords
	 */
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	/**
	 * @param iTotalRecords the iTotalRecords to set
	 */
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	/**
	 * @return the iTotalDisplayRecords
	 */
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	/**
	 * @param iTotalDisplayRecords the iTotalDisplayRecords to set
	 */
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
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
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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
	 * @return the listNo
	 */
	public String getListNo() {
		return listNo;
	}
	/**
	 * @param listNo the listNo to set
	 */
	public void setListNo(String listNo) {
		this.listNo = listNo;
	}
	/**
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}
	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	/**
	 * @return the searchKeyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}
	/**
	 * @param searchKeyword the searchKeyword to set
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	/**
	 * @return the searchValue
	 */
	public String getSearchValue() {
		return searchValue;
	}
	/**
	 * @param searchValue the searchValue to set
	 */
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	/**
	 * @return the depth
	 */
	public String getDepth() {
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(String depth) {
		this.depth = depth;
	}
	/**
	 * @return the cdLength
	 */
	public String getCdLength() {
		return cdLength;
	}
	/**
	 * @param cdLength the cdLength to set
	 */
	public void setCdLength(String cdLength) {
		this.cdLength = cdLength;
	}
	/**
	 * @return the cd
	 */
	public String getCd() {
		return cd;
	}
	/**
	 * @param cd the cd to set
	 */
	public void setCd(String cd) {
		this.cd = cd;
	}
	/**
	 * @return the cdNm
	 */
	public String getCdNm() {
		return cdNm;
	}
	/**
	 * @param cdNm the cdNm to set
	 */
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return the orderBy
	 */
	public String getOrderBy() {
		return orderBy;
	}
	/**
	 * @param orderBy the orderBy to set
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * @return the previousUrl
	 */
	public String getPreviousUrl() {
		return previousUrl;
	}
	/**
	 * @param previousUrl the previousUrl to set
	 */
	public void setPreviousUrl(String previousUrl) {
		this.previousUrl = previousUrl;
	}






}
