package ony.cpes.internal.communityMng.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;

public class CommunityMngBean extends CommonBean {
	private String seq;
	private String banwordContent;
	private String viewYn;
	private String viewCnt;
	private String regNm;
	private String likeCnt;
	private String filteringStsNm;

	private String filteringStsCd;
	private String contentsFlag;

	private List<CommunityMngBean> list;

	public String getContentsFlag() {
		return contentsFlag;
	}
	public void setContentsFlag(String contentsFlag) {
		this.contentsFlag = contentsFlag;
	}
	public String getFilteringStsCd() {
		return filteringStsCd;
	}
	public void setFilteringStsCd(String filteringStsCd) {
		this.filteringStsCd = filteringStsCd;
	}
	public List<CommunityMngBean> getList() {
		return list;
	}
	public void setList(List<CommunityMngBean> list) {
		this.list = list;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getBanwordContent() {
		return banwordContent;
	}
	public void setBanwordContent(String banwordContent) {
		this.banwordContent = banwordContent;
	}
	public String getViewYn() {
		return viewYn;
	}
	public void setViewYn(String viewYn) {
		this.viewYn = viewYn;
	}
	public String getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getRegNm() {
		return regNm;
	}
	public void setRegNm(String regNm) {
		this.regNm = regNm;
	}
	public String getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(String likeCnt) {
		this.likeCnt = likeCnt;
	}
	public String getFilteringStsNm() {
		return filteringStsNm;
	}
	public void setFilteringStsNm(String filteringStsNm) {
		this.filteringStsNm = filteringStsNm;
	}

}
