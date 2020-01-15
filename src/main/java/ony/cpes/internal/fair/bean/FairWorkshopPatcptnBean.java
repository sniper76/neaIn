package ony.cpes.internal.fair.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;

public class FairWorkshopPatcptnBean extends CommonBean {
	private String fairWorkshopPatcptnSeq;
	private String fairSeq;
	private String fairWorkshopSeq;
	private String userSeq;
	private String jcAgreeStsCd;
	private String jcUserSeq;
	private String jcAgreeDt;

	private String userAuthNm;
	private String userNm;
	private String userEmail;
	private String userCell;
	private String userAge;
	private String userGenderNm;
	private String jcUserNm;

	private List<FairWorkshopPatcptnBean> list;

	public List<FairWorkshopPatcptnBean> getList() {
		return list;
	}
	public void setList(List<FairWorkshopPatcptnBean> list) {
		this.list = list;
	}
	public String getUserAuthNm() {
		return userAuthNm;
	}
	public void setUserAuthNm(String userAuthNm) {
		this.userAuthNm = userAuthNm;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserCell() {
		return userCell;
	}
	public void setUserCell(String userCell) {
		this.userCell = userCell;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserGenderNm() {
		return userGenderNm;
	}
	public void setUserGenderNm(String userGenderNm) {
		this.userGenderNm = userGenderNm;
	}
	public String getJcUserNm() {
		return jcUserNm;
	}
	public void setJcUserNm(String jcUserNm) {
		this.jcUserNm = jcUserNm;
	}
	public String getFairWorkshopPatcptnSeq() {
		return fairWorkshopPatcptnSeq;
	}
	public void setFairWorkshopPatcptnSeq(String fairWorkshopPatcptnSeq) {
		this.fairWorkshopPatcptnSeq = fairWorkshopPatcptnSeq;
	}
	public String getFairSeq() {
		return fairSeq;
	}
	public void setFairSeq(String fairSeq) {
		this.fairSeq = fairSeq;
	}
	public String getFairWorkshopSeq() {
		return fairWorkshopSeq;
	}
	public void setFairWorkshopSeq(String fairWorkshopSeq) {
		this.fairWorkshopSeq = fairWorkshopSeq;
	}
	public String getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}
	public String getJcAgreeStsCd() {
		return jcAgreeStsCd;
	}
	public void setJcAgreeStsCd(String jcAgreeStsCd) {
		this.jcAgreeStsCd = jcAgreeStsCd;
	}
	public String getJcUserSeq() {
		return jcUserSeq;
	}
	public void setJcUserSeq(String jcUserSeq) {
		this.jcUserSeq = jcUserSeq;
	}
	public String getJcAgreeDt() {
		return jcAgreeDt;
	}
	public void setJcAgreeDt(String jcAgreeDt) {
		this.jcAgreeDt = jcAgreeDt;
	}
}
