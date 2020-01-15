package ony.cpes.internal.annualPlan.bean;

import ony.cmm.common.bean.CommonBean;

public class APIndicDataBean extends CommonBean {
	private String indicDataSeq;
	private String yearBaseIndicSeq;
	private String jcCd;
	private String content;
	private String month;
	private String depth;
	private String sort;
	private String indicItemNm;
	private String viewYn;
	private String reportCycleCd;
	private String result;

	private String listStr;

	public String getListStr() {
		return listStr;
	}
	public void setListStr(String listStr) {
		this.listStr = listStr;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getIndicDataSeq() {
		return indicDataSeq;
	}
	public void setIndicDataSeq(String indicDataSeq) {
		this.indicDataSeq = indicDataSeq;
	}
	public String getYearBaseIndicSeq() {
		return yearBaseIndicSeq;
	}
	public void setYearBaseIndicSeq(String yearBaseIndicSeq) {
		this.yearBaseIndicSeq = yearBaseIndicSeq;
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
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
