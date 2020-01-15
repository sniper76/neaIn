package ony.cpes.internal.fair.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

public class FairBoothMngBean extends CommonBean {
	
	private String 	fairSeq;
	private String 	boothSeq;
	private String 	boothTel;
	private String 	boothEmail;	
	private String 	boothFeeExpln;
	private String 	compnyInsttSeq;
	private String 	compnyInsttDivCd;
	private String 	boothNm;
	private String 	boothFee;
	private String 	boothReqDt;
	private String 	boothCancelReqDt;
	private String 	boothStsCd;
	private String 	useYn;
	private String 	jcCd;
	private String 	jcUserSeq;
	private String 	regUserSeq;
	private String 	regDt;

	private String 	change;
	private String 	compnyInsttNm;
	private String 	mngerNm;
	private String 	tel;
	private String 	email;
	private String 	regNum;
	
	private String 	searchReqDiv;

	private List<String> boothSeqList = new ArrayList<String>();
	private List<String> boothNmList = new ArrayList<String>();
	private List<String> boothFeeList = new ArrayList<String>();
	private List<String> useYnList = new ArrayList<String>();

	private UserBean user = new UserBean();
	
	private List<FairBoothMngBean> list;	


	
	
	/**
	 * @return the fairSeq
	 */
	public String getFairSeq() {
		return fairSeq;
	}


	/**
	 * @param fairSeq the fairSeq to set
	 */
	public void setFairSeq(String fairSeq) {
		this.fairSeq = fairSeq;
	}


	/**
	 * @return the boothTel
	 */
	public String getBoothTel() {
		return boothTel;
	}


	/**
	 * @param boothTel the boothTel to set
	 */
	public void setBoothTel(String boothTel) {
		this.boothTel = boothTel;
	}


	/**
	 * @return the boothEmail
	 */
	public String getBoothEmail() {
		return boothEmail;
	}


	/**
	 * @param boothEmail the boothEmail to set
	 */
	public void setBoothEmail(String boothEmail) {
		this.boothEmail = boothEmail;
	}


	/**
	 * @return the boothFeeExpln
	 */
	public String getBoothFeeExpln() {
		return boothFeeExpln;
	}


	/**
	 * @param boothFeeExpln the boothFeeExpln to set
	 */
	public void setBoothFeeExpln(String boothFeeExpln) {
		this.boothFeeExpln = boothFeeExpln;
	}

	/**
	 * @return the boothSeq
	 */
	public String getBoothSeq() {
		return boothSeq;
	}


	/**
	 * @param boothSeq the boothSeq to set
	 */
	public void setBoothSeq(String boothSeq) {
		this.boothSeq = boothSeq;
	}


	/**
	 * @return the compnyInsttSeq
	 */
	public String getCompnyInsttSeq() {
		return compnyInsttSeq;
	}


	/**
	 * @param compnyInsttSeq the compnyInsttSeq to set
	 */
	public void setCompnyInsttSeq(String compnyInsttSeq) {
		this.compnyInsttSeq = compnyInsttSeq;
	}


	/**
	 * @return the compnyInsttDivCd
	 */
	public String getCompnyInsttDivCd() {
		return compnyInsttDivCd;
	}


	/**
	 * @param compnyInsttDivCd the compnyInsttDivCd to set
	 */
	public void setCompnyInsttDivCd(String compnyInsttDivCd) {
		this.compnyInsttDivCd = compnyInsttDivCd;
	}


	/**
	 * @return the boothNm
	 */
	public String getBoothNm() {
		return boothNm;
	}


	/**
	 * @param boothNm the boothNm to set
	 */
	public void setBoothNm(String boothNm) {
		this.boothNm = boothNm;
	}


	/**
	 * @return the boothFee
	 */
	public String getBoothFee() {
		return boothFee;
	}


	/**
	 * @param boothFee the boothFee to set
	 */
	public void setBoothFee(String boothFee) {
		this.boothFee = boothFee;
	}


	/**
	 * @return the boothReqDt
	 */
	public String getBoothReqDt() {
		return boothReqDt;
	}


	/**
	 * @param boothReqDt the boothReqDt to set
	 */
	public void setBoothReqDt(String boothReqDt) {
		this.boothReqDt = boothReqDt;
	}


	/**
	 * @return the boothCancelReqDt
	 */
	public String getBoothCancelReqDt() {
		return boothCancelReqDt;
	}


	/**
	 * @param boothCancelReqDt the boothCancelReqDt to set
	 */
	public void setBoothCancelReqDt(String boothCancelReqDt) {
		this.boothCancelReqDt = boothCancelReqDt;
	}

	


	public String getBoothStsCd() {
		return boothStsCd;
	}


	public void setBoothStsCd(String boothStsCd) {
		this.boothStsCd = boothStsCd;
	}


	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}


	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}


	/**
	 * @return the jcCd
	 */
	public String getJcCd() {
		return jcCd;
	}


	/**
	 * @param jcCd the jcCd to set
	 */
	public void setJcCd(String jcCd) {
		this.jcCd = jcCd;
	}


	/**
	 * @return the jcUserSeq
	 */
	public String getJcUserSeq() {
		return jcUserSeq;
	}


	/**
	 * @param jcUserSeq the jcUserSeq to set
	 */
	public void setJcUserSeq(String jcUserSeq) {
		this.jcUserSeq = jcUserSeq;
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
	 * @return the boothSeqList
	 */
	public List<String> getBoothSeqList() {
		return boothSeqList;
	}


	/**
	 * @param boothSeqList the boothSeqList to set
	 */
	public void setBoothSeqList(List<String> boothSeqList) {
		this.boothSeqList = boothSeqList;
	}

	
	/**
	 * @return the boothNmList
	 */
	public List<String> getBoothNmList() {
		return boothNmList;
	}


	/**
	 * @param boothNmList the boothNmList to set
	 */
	public void setBoothNmList(List<String> boothNmList) {
		this.boothNmList = boothNmList;
	}


	/**
	 * @return the boothFeeList
	 */
	public List<String> getBoothFeeList() {
		return boothFeeList;
	}


	/**
	 * @param boothFeeList the boothFeeList to set
	 */
	public void setBoothFeeList(List<String> boothFeeList) {
		this.boothFeeList = boothFeeList;
	}
	

	/**
	 * @return the useYnList
	 */
	public List<String> getUseYnList() {
		return useYnList;
	}


	/**
	 * @param useYnList the useYnList to set
	 */
	public void setUseYnList(List<String> useYnList) {
		this.useYnList = useYnList;
	}

	
	/**
	 * @return the change
	 */
	public String getChange() {
		return change;
	}


	/**
	 * @param change the change to set
	 */
	public void setChange(String change) {
		this.change = change;
	}


	/**
	 * @return the compnyInsttNm
	 */
	public String getCompnyInsttNm() {
		return compnyInsttNm;
	}


	/**
	 * @param compnyInsttNm the compnyInsttNm to set
	 */
	public void setCompnyInsttNm(String compnyInsttNm) {
		this.compnyInsttNm = compnyInsttNm;
	}


	/**
	 * @return the mngerNm
	 */
	public String getMngerNm() {
		return mngerNm;
	}


	/**
	 * @param mngerNm the mngerNm to set
	 */
	public void setMngerNm(String mngerNm) {
		this.mngerNm = mngerNm;
	}


	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}


	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the regNum
	 */
	public String getRegNum() {
		return regNum;
	}


	/**
	 * @param regNum the regNum to set
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}


	/**
	 * @return the searchReqDiv
	 */
	public String getSearchReqDiv() {
		return searchReqDiv;
	}


	/**
	 * @param searchReqDiv the searchReqDiv to set
	 */
	public void setSearchReqDiv(String searchReqDiv) {
		this.searchReqDiv = searchReqDiv;
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


	/**
	 * @return the list
	 */
	public List<FairBoothMngBean> getList() {
		return list;
	}


	/**
	 * @param list the list to set
	 */
	public void setList(List<FairBoothMngBean> list) {
		this.list = list;
	}
}
