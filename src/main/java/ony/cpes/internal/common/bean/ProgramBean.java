package ony.cpes.internal.common.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

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
public class ProgramBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	private String programSeq     = "";
	private String programId      = "";
	private String menuCd         = "";
	private String programNm      = "";
	private String programNmKh    = "";
	private String programNmEn    = "";
	private String regUserSeq     = "";
	private String regDt          = "";
	private String modUserSeq     = "";
	private String modDt          = "";
	private String bulletinMngSeq = "";
	private String programUrl     = "";
	private String useYn          = "";
	private String rangeCd        = "";
	private String priProgramYn	  = "";
	
	// for parameter
	private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private int start = 0;
    private int length = 10;
    private int orderStr = 0;
    private String orderColumn = "";
    private String orderColumnSort = "";
	
	private String contentType;
	
	private List<ProgramBean> list = new ArrayList<ProgramBean>();
	
	public String getProgramNmKh() {
		return programNmKh;
	}
	public void setProgramNmKh(String programNmKh) {
		this.programNmKh = programNmKh;
	}
	public String getProgramNmEn() {
		return programNmEn;
	}
	public void setProgramNmEn(String programNmEn) {
		this.programNmEn = programNmEn;
	}
	public String getPriProgramYn() {
		return priProgramYn;
	}
	public void setPriProgramYn(String priProgramYn) {
		this.priProgramYn = priProgramYn;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getProgramSeq() {
		return programSeq;
	}
	public void setProgramSeq(String programSeq) {
		this.programSeq = programSeq;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getMenuCd() {
		return menuCd;
	}
	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}
	public String getProgramNm() {
		return programNm;
	}
	public void setProgramNm(String programNm) {
		this.programNm = programNm;
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
	public String getBulletinMngSeq() {
		return bulletinMngSeq;
	}
	public void setBulletinMngSeq(String bulletinMngSeq) {
		this.bulletinMngSeq = bulletinMngSeq;
	}
	public String getProgramUrl() {
		return programUrl;
	}
	public void setProgramUrl(String programUrl) {
		this.programUrl = programUrl;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getRangeCd() {
		return rangeCd;
	}
	public void setRangeCd(String rangeCd) {
		this.rangeCd = rangeCd;
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
	public List<ProgramBean> getList() {
		return list;
	}
	public void setList(List<ProgramBean> list) {
		this.list = list;
	}

	
	
	
}
