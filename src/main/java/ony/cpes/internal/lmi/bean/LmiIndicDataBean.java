package ony.cpes.internal.lmi.bean;

import ony.cmm.common.bean.CommonBean;

public class LmiIndicDataBean extends CommonBean {
	private String lmiIndicDataSeq;
	private String lmiYearBaseIndicSeq;
	private String jcCd;
	private String content;
	private String year;
	private String depth;
	private String sort;
	private String indicItemNm;
	private String viewYn;
	private String reportCycleCd;

	private String listStr;

	public String getListStr() {
		return listStr;
	}
	public void setListStr(String listStr) {
		this.listStr = listStr;
	}
	public String getLmiIndicDataSeq() {
		return lmiIndicDataSeq;
	}
	public void setLmiIndicDataSeq(String lmiIndicDataSeq) {
		this.lmiIndicDataSeq = lmiIndicDataSeq;
	}
	public String getLmiYearBaseIndicSeq() {
		return lmiYearBaseIndicSeq;
	}
	public void setLmiYearBaseIndicSeq(String lmiYearBaseIndicSeq) {
		this.lmiYearBaseIndicSeq = lmiYearBaseIndicSeq;
	}
	public String getJcCd() {
		return jcCd;
	}
	public void setJcCd(String jcCd) {
		this.jcCd = jcCd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getIndicItemNm() {
		return indicItemNm;
	}
	public void setIndicItemNm(String indicItemNm) {
		this.indicItemNm = indicItemNm;
	}
	public String getViewYn() {
		return viewYn;
	}
	public void setViewYn(String viewYn) {
		this.viewYn = viewYn;
	}
	public String getReportCycleCd() {
		return reportCycleCd;
	}
	public void setReportCycleCd(String reportCycleCd) {
		this.reportCycleCd = reportCycleCd;
	}
}
