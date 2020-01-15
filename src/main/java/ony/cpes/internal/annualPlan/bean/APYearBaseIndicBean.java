package ony.cpes.internal.annualPlan.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

public class APYearBaseIndicBean extends CommonBean{
	private String yearBaseIndicSeq;
	private String baseIndicSeq;
	private String depth;
	private String sort;
	private String indicItemNm;
	private String year;
	private String viewYn;
	private String upperYearBaseIndicSeq;
	private String fullYearBaseIndicSeq;
	private String title;

	private String jcCd;
	private String number;
	private String content;
	private String indicDataSeq;
	private List<APYearBaseIndicBean> underList;

	private List<APIndicDataBean> dataList;

	public void setDefaultDataList() {
		dataList = new ArrayList<APIndicDataBean>();
		for(int i = 1; i <= 12; i++) {
			APIndicDataBean APIndicDataBean = new APIndicDataBean();
			APIndicDataBean.setMonth(String.valueOf(i));
			dataList.add(APIndicDataBean);
		}
	}

	public String getJcCd() {
		return jcCd;
	}
	public void setJcCd(String jcCd) {
		this.jcCd = jcCd;
	}
	public List<APIndicDataBean> getDataList() {
		return dataList;
	}
	public void setDataList(List<APIndicDataBean> dataList) {
		this.dataList = dataList;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIndicDataSeq() {
		return indicDataSeq;
	}
	public void setIndicDataSeq(String indicDataSeq) {
		this.indicDataSeq = indicDataSeq;
	}
	public List<APYearBaseIndicBean> getUnderList() {
		return underList;
	}
	public void setUnderList(List<APYearBaseIndicBean> underList) {
		this.underList = underList;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYearBaseIndicSeq() {
		return yearBaseIndicSeq;
	}
	public void setYearBaseIndicSeq(String yearBaseIndicSeq) {
		this.yearBaseIndicSeq = yearBaseIndicSeq;
	}
	public String getBaseIndicSeq() {
		return baseIndicSeq;
	}
	public void setBaseIndicSeq(String baseIndicSeq) {
		this.baseIndicSeq = baseIndicSeq;
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
	public String getUpperYearBaseIndicSeq() {
		return upperYearBaseIndicSeq;
	}
	public void setUpperYearBaseIndicSeq(String upperYearBaseIndicSeq) {
		this.upperYearBaseIndicSeq = upperYearBaseIndicSeq;
	}
	public String getFullYearBaseIndicSeq() {
		return fullYearBaseIndicSeq;
	}
	public void setFullYearBaseIndicSeq(String fullYearBaseIndicSeq) {
		this.fullYearBaseIndicSeq = fullYearBaseIndicSeq;
	}
}
