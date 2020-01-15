package ony.cpes.internal.lmi.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;

public class LmiYearBaseIndicBean extends CommonBean {
	private String lmiYearBaseIndicSeq;
	private String lmiBaseIndicSeq;
	private String depth;
	private String sort;
	private String indicItemNm;
	private String year;
	private String viewYn;
	private String upperLmiYearBaseIndicSeq;
	private String fullLmiYearBaseIndicSeq;

	private String content;
	private String lmiIndicDataSeq;
	private List<LmiYearBaseIndicBean> underList;

	public String getLmiIndicDataSeq() {
		return lmiIndicDataSeq;
	}
	public void setLmiIndicDataSeq(String lmiIndicDataSeq) {
		this.lmiIndicDataSeq = lmiIndicDataSeq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<LmiYearBaseIndicBean> getUnderList() {
		return underList;
	}
	public void setUnderList(List<LmiYearBaseIndicBean> underList) {
		this.underList = underList;
	}
	public String getLmiYearBaseIndicSeq() {
		return lmiYearBaseIndicSeq;
	}
	public void setLmiYearBaseIndicSeq(String lmiYearBaseIndicSeq) {
		this.lmiYearBaseIndicSeq = lmiYearBaseIndicSeq;
	}
	public String getLmiBaseIndicSeq() {
		return lmiBaseIndicSeq;
	}
	public void setLmiBaseIndicSeq(String lmiBaseIndicSeq) {
		this.lmiBaseIndicSeq = lmiBaseIndicSeq;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getViewYn() {
		return viewYn;
	}
	public void setViewYn(String viewYn) {
		this.viewYn = viewYn;
	}
	public String getUpperLmiYearBaseIndicSeq() {
		return upperLmiYearBaseIndicSeq;
	}
	public void setUpperLmiYearBaseIndicSeq(String upperLmiYearBaseIndicSeq) {
		this.upperLmiYearBaseIndicSeq = upperLmiYearBaseIndicSeq;
	}
	public String getFullLmiYearBaseIndicSeq() {
		return fullLmiYearBaseIndicSeq;
	}
	public void setFullLmiYearBaseIndicSeq(String fullLmiYearBaseIndicSeq) {
		this.fullLmiYearBaseIndicSeq = fullLmiYearBaseIndicSeq;
	}
}
