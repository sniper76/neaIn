package ony.cpes.internal.sitemgmt.bean;

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
public class BannerBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	private String bannerSeq     = "";
	private String width         = "";
	private String height        = "";
	private String topPosition   = "";
	private String leftPosition  = "";
	private String bgnDt         = "";
	private String endDt         = "";
	private String content       = "";
	private String useYn         = "";
	private String regUserSeq    = "";
	private String regDt         = "";
	private String modUserSeq    = "";
	private String modDt         = "";
	private String keyword       = "";
	private String keywordSel    = "";
	private String title         = "";
	private String bgnHour       = "";
	private String endHour       = "";
	private String bgnMinute     = "";
	private String endMinute     = "";
	private String bgnAmpm       = "";
	private String endAmpm       = "";
	private String resvYn        = "";
	private String regUserNm     = "";
	private String modUserNm     = "";
	private String bgnDate       = "";
	private String endDate       = "";
	private String todayOpenYn   = "";
	private String connUrl       = "";


	
	
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
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getBannerSeq() {
		return bannerSeq;
	}
	public void setBannerSeq(String bannerSeq) {
		this.bannerSeq = bannerSeq;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getTopPosition() {
		return topPosition;
	}
	public void setTopPosition(String topPosition) {
		this.topPosition = topPosition;
	}
	public String getLeftPosition() {
		return leftPosition;
	}
	public void setLeftPosition(String leftPosition) {
		this.leftPosition = leftPosition;
	}
	public String getBgnDt() {
		return bgnDt;
	}
	public void setBgnDt(String bgnDt) {
		this.bgnDt = bgnDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getRegUserSeq() {
		return regUserSeq;
	}
	public void setRegUserSeq(String regUserSeq) {
		this.regUserSeq = regUserSeq;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getModUserSeq() {
		return modUserSeq;
	}
	public void setModUserSeq(String modUserSeq) {
		this.modUserSeq = modUserSeq;
	}
	public String getModDt() {
		return modDt;
	}
	public void setModDt(String modDt) {
		this.modDt = modDt;
	}
	public List<String> getSelectedList() {
		return selectedList;
	}
	public void setSelectedList(List<String> selectedList) {
		this.selectedList = selectedList;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBgnHour() {
		return bgnHour;
	}
	public void setBgnHour(String bgnHour) {
		this.bgnHour = bgnHour;
	}
	public String getEndHour() {
		return endHour;
	}
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	public String getBgnMinute() {
		return bgnMinute;
	}
	public void setBgnMinute(String bgnMinute) {
		this.bgnMinute = bgnMinute;
	}
	public String getEndMinute() {
		return endMinute;
	}
	public void setEndMinute(String endMinute) {
		this.endMinute = endMinute;
	}
	public String getBgnAmpm() {
		return bgnAmpm;
	}
	public void setBgnAmpm(String bgnAmpm) {
		this.bgnAmpm = bgnAmpm;
	}
	public String getEndAmpm() {
		return endAmpm;
	}
	public void setEndAmpm(String endAmpm) {
		this.endAmpm = endAmpm;
	}
	public String getResvYn() {
		return resvYn;
	}
	public void setResvYn(String resvYn) {
		this.resvYn = resvYn;
	}
	public String getRegUserNm() {
		return regUserNm;
	}
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}
	public String getModUserNm() {
		return modUserNm;
	}
	public void setModUserNm(String modUserNm) {
		this.modUserNm = modUserNm;
	}
	public String getBgnDate() {
		return bgnDate;
	}
	public void setBgnDate(String bgnDate) {
		this.bgnDate = bgnDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTodayOpenYn() {
		return todayOpenYn;
	}
	public void setTodayOpenYn(String todayOpenYn) {
		this.todayOpenYn = todayOpenYn;
	}
	public String getConnUrl() {
		return connUrl;
	}
	public void setConnUrl(String connUrl) {
		this.connUrl = connUrl;
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



	private List<BannerBean> list;
	
	
	public List<BannerBean> getList() {
		return list;
	}
	public void setList(List<BannerBean> list) {
		this.list = list;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
