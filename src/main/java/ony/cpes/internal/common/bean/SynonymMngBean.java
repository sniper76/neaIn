package ony.cpes.internal.common.bean;

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
public class SynonymMngBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	private String synonymSeq       = "";
	private String en    = "";
	private String kh    = "";
	private String regUserSeq  = "";
	private String regDt              = "";
	private String modUserSeq             = "";
	private String modDt           = "";
	private String useYn          = "";
	private String regUserNm          = "";
	private String modUserNm          = "";
	private String entxt    = "";
	private String khtxt    = "";
	
	
	// for parameter
	private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private int start = 0;
    private int length = 10;
    private int orderStr = 0;
    private String orderColumn = "";
    private String orderColumnSort = "";
    
    private UserBean user = new UserBean();
	
	private String contentType;
	
	private List<String> selectedList 		= new ArrayList<String>();
	
	
	
	
	/**
	 * @return the synonymSeq
	 */
	public String getSynonymSeq() {
		return synonymSeq;
	}
	/**
	 * @param synonymSeq the synonymSeq to set
	 */
	public void setSynonymSeq(String synonymSeq) {
		this.synonymSeq = synonymSeq;
	}
	/**
	 * @return the en
	 */
	public String getEn() {
		return en;
	}
	/**
	 * @param en the en to set
	 */
	public void setEn(String en) {
		this.en = en;
	}
	/**
	 * @return the kh
	 */
	public String getKh() {
		return kh;
	}
	/**
	 * @param kh the kh to set
	 */
	public void setKh(String kh) {
		this.kh = kh;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
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
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public List<String> getSelectedList() {
		return selectedList;
	}
	public void setSelectedList(List<String> selectedList) {
		this.selectedList = selectedList;
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

	/**
	 * @return the entxt
	 */
	public String getEntxt() {
		return entxt;
	}
	/**
	 * @param entxt the entxt to set
	 */
	public void setEntxt(String entxt) {
		this.entxt = entxt;
	}
	/**
	 * @return the khtxt
	 */
	public String getKhtxt() {
		return khtxt;
	}
	/**
	 * @param khtxt the khtxt to set
	 */
	public void setKhtxt(String khtxt) {
		this.khtxt = khtxt;
	}

	private List<SynonymMngBean> list;
	
	
	public List<SynonymMngBean> getList() {
		return list;
	}
	public void setList(List<SynonymMngBean> list) {
		this.list = list;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
