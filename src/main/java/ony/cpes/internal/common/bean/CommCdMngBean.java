package ony.cpes.internal.common.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 * bean 공통정보를 담는 bean
 *
 * @author 우성택
 * @version 1.0
 * @since 2019.01.02
 */
public class CommCdMngBean extends CommonBean{

	private String dtlCd = "";
	private String grpCd = "";
	private String cdKhNm = "";
	private String cdEnNm = "";
	private String cdContent = "";
	private String useYn = "";
	private String sort = "";
	private String grpNm       = "";
	private String regUserSeq  = "";
	private String regDt       = "";
	private String modUserSeq  = "";
	private String modDt       = "";
	private String regUserNm   = "";
	private String expln       = "";
	
	private String commGrpUseYn = "";
	private List<String> commGrpCdList = new ArrayList<String>();
	private UserBean user = new UserBean();
	
	private List<CommCdMngBean> list;
	
	public String getDtlCd() {
		return dtlCd;
	}
	public void setDtlCd(String dtlCd) {
		this.dtlCd = dtlCd;
	}
	public String getGrpCd() {
		return grpCd;
	}
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	public String getCdKhNm() {
		return cdKhNm;
	}
	public void setCdKhNm(String cdKhNm) {
		this.cdKhNm = cdKhNm;
	}
	public String getCdEnNm() {
		return cdEnNm;
	}
	public void setCdEnNm(String cdEnNm) {
		this.cdEnNm = cdEnNm;
	}
	public String getCdContent() {
		return cdContent;
	}
	public void setCdContent(String cdContent) {
		this.cdContent = cdContent;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * @return the commGrpUseYn
	 */
	public String getCommGrpUseYn() {
		return commGrpUseYn;
	}
	/**
	 * @param commGrpUseYn the commGrpUseYn to set
	 */
	public void setCommGrpUseYn(String commGrpUseYn) {
		this.commGrpUseYn = commGrpUseYn;
	}
	/**
	 * @return the commGrpCdList
	 */
	public List<String> getCommGrpCdList() {
		return commGrpCdList;
	}
	/**
	 * @param commGrpCdList the commGrpCdList to set
	 */
	public void setCommGrpCdList(List<String> commGrpCdList) {
		this.commGrpCdList = commGrpCdList;
	}

	public List<CommCdMngBean> getList() {
		return list;
	}
	public void setList(List<CommCdMngBean> list) {
		this.list = list;
	}
	/**
	 * @return the grpNm
	 */
	public String getGrpNm() {
		return grpNm;
	}
	/**
	 * @param grpNm the grpNm to set
	 */
	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
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
	 * @return the regUserNm
	 */
	public String getRegUserNm() {
		return regUserNm;
	}
	/**
	 * @param regUserNm the regUserNm to set
	 */
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}
	/**
	 * @return the expln
	 */
	public String getExpln() {
		return expln;
	}
	/**
	 * @param expln the expln to set
	 */
	public void setExpln(String expln) {
		this.expln = expln;
	}
	/**
	 * @return the user
	 */
	public UserBean getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserBean user) {
		this.user = user;
	}
	
}
