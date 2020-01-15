package ony.cpes.internal.counsel.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;
public class CounselBean extends CommonBean {
	private String counselSeq;
	private String userSeq;
	private String counselMethodDivCd;
	private String counselCateDivCd;
	private String counselTargetCd;
	private String iscoCd;
	private String qustTitle;
	private String qustContent;
	private String qustEtcReq;
	private String hopeCounselDt;
	private String qustRegUserSeq;
	private String qustRegDt;
	private String qustFileGrpSeq;
	private String ansTitle;
	private String ansContent;
	private String ansFileGrpSeq;
	private String ansRegUserSeq;
	private String ansRegDt;
	private String ansModUserSeq;
	private String ansModDt;
	private String counselStsCd;
	private String jcCd;
	private String jcNm;
	private String jcUserSeq;
	private String jcUserNm;

	private String delYn;

	private String secretYn;

	private int likeCnt;
	private int viewCnt;

	private String userNm;

	private String searchKeyword;
	private String searchValue;
	private String userAuthCd;

	private String counselDt;
	private String counselHour;
	private String counselMinute;
	private String counselAmpm;
	private String counselNtce;
	private String qustJcCd;
	private String counselMethodDivNm;

	private UserBean user = new UserBean();

	private List<CounselBean> list;

	private String uploadResult;

	public String getUploadResult() {
		return uploadResult;
	}
	public void setUploadResult(String uploadResult) {
		this.uploadResult = uploadResult;
	}
	/**
	 * @return the counselSeq
	 */
	public String getCounselSeq() {
		return counselSeq;
	}
	/**
	 * @param counselSeq the counselSeq to set
	 */
	public void setCounselSeq(String counselSeq) {
		this.counselSeq = counselSeq;
	}
	/**
	 * @return the userSeq
	 */
	public String getUserSeq() {
		return userSeq;
	}
	/**
	 * @param userSeq the userSeq to set
	 */
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}
	/**
	 * @return the counselMethodDivCd
	 */
	public String getCounselMethodDivCd() {
		return counselMethodDivCd;
	}
	/**
	 * @param counselMethodDivCd the counselMethodDivCd to set
	 */
	public void setCounselMethodDivCd(String counselMethodDivCd) {
		this.counselMethodDivCd = counselMethodDivCd;
	}
	/**
	 * @return the counselCateDivCd
	 */
	public String getCounselCateDivCd() {
		return counselCateDivCd;
	}
	/**
	 * @param counselCateDivCd the counselCateDivCd to set
	 */
	public void setCounselCateDivCd(String counselCateDivCd) {
		this.counselCateDivCd = counselCateDivCd;
	}
	/**
	 * @return the counselTargetCd
	 */
	public String getCounselTargetCd() {
		return counselTargetCd;
	}
	/**
	 * @param counselTargetCd the counselTargetCd to set
	 */
	public void setCounselTargetCd(String counselTargetCd) {
		this.counselTargetCd = counselTargetCd;
	}
	/**
	 * @return the iscoCd
	 */
	public String getIscoCd() {
		return iscoCd;
	}
	/**
	 * @param iscoCd the iscoCd to set
	 */
	public void setIscoCd(String iscoCd) {
		this.iscoCd = iscoCd;
	}
	/**
	 * @return the qustTitle
	 */
	public String getQustTitle() {
		return qustTitle;
	}
	/**
	 * @param qustTitle the qustTitle to set
	 */
	public void setQustTitle(String qustTitle) {
		this.qustTitle = qustTitle;
	}
	/**
	 * @return the qustContent
	 */
	public String getQustContent() {
		return qustContent;
	}
	/**
	 * @param qustContent the qustContent to set
	 */
	public void setQustContent(String qustContent) {
		this.qustContent = qustContent;
	}
	/**
	 * @return the qustEtcReq
	 */
	public String getQustEtcReq() {
		return qustEtcReq;
	}
	/**
	 * @param qustEtcReq the qustEtcReq to set
	 */
	public void setQustEtcReq(String qustEtcReq) {
		this.qustEtcReq = qustEtcReq;
	}
	/**
	 * @return the hopeCounselDt
	 */
	public String getHopeCounselDt() {
		return hopeCounselDt;
	}
	/**
	 * @param hopeCounselDt the hopeCounselDt to set
	 */
	public void setHopeCounselDt(String hopeCounselDt) {
		this.hopeCounselDt = hopeCounselDt;
	}
	/**
	 * @return the qustRegUserSeq
	 */
	public String getQustRegUserSeq() {
		return qustRegUserSeq;
	}
	/**
	 * @param qustRegUserSeq the qustRegUserSeq to set
	 */
	public void setQustRegUserSeq(String qustRegUserSeq) {
		this.qustRegUserSeq = qustRegUserSeq;
	}
	/**
	 * @return the qustRegDt
	 */
	public String getQustRegDt() {
		return qustRegDt;
	}
	/**
	 * @param qustRegDt the qustRegDt to set
	 */
	public void setQustRegDt(String qustRegDt) {
		this.qustRegDt = qustRegDt;
	}
	/**
	 * @return the qustFileGrpSeq
	 */
	public String getQustFileGrpSeq() {
		return qustFileGrpSeq;
	}
	/**
	 * @param qustFileGrpSeq the qustFileGrpSeq to set
	 */
	public void setQustFileGrpSeq(String qustFileGrpSeq) {
		this.qustFileGrpSeq = qustFileGrpSeq;
	}
	/**
	 * @return the ansTitle
	 */
	public String getAnsTitle() {
		return ansTitle;
	}
	/**
	 * @param ansTitle the ansTitle to set
	 */
	public void setAnsTitle(String ansTitle) {
		this.ansTitle = ansTitle;
	}
	/**
	 * @return the ansContent
	 */
	public String getAnsContent() {
		return ansContent;
	}
	/**
	 * @param ansContent the ansContent to set
	 */
	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}
	/**
	 * @return the ansFileGrpSeq
	 */
	public String getAnsFileGrpSeq() {
		return ansFileGrpSeq;
	}
	/**
	 * @param ansFileGrpSeq the ansFileGrpSeq to set
	 */
	public void setAnsFileGrpSeq(String ansFileGrpSeq) {
		this.ansFileGrpSeq = ansFileGrpSeq;
	}
	/**
	 * @return the ansRegUserSeq
	 */
	public String getAnsRegUserSeq() {
		return ansRegUserSeq;
	}
	/**
	 * @param ansRegUserSeq the ansRegUserSeq to set
	 */
	public void setAnsRegUserSeq(String ansRegUserSeq) {
		this.ansRegUserSeq = ansRegUserSeq;
	}
	/**
	 * @return the ansRegDt
	 */
	public String getAnsRegDt() {
		return ansRegDt;
	}
	/**
	 * @param ansRegDt the ansRegDt to set
	 */
	public void setAnsRegDt(String ansRegDt) {
		this.ansRegDt = ansRegDt;
	}
	/**
	 * @return the ansModUserSeq
	 */
	public String getAnsModUserSeq() {
		return ansModUserSeq;
	}
	/**
	 * @param ansModUserSeq the ansModUserSeq to set
	 */
	public void setAnsModUserSeq(String ansModUserSeq) {
		this.ansModUserSeq = ansModUserSeq;
	}
	/**
	 * @return the ansModDt
	 */
	public String getAnsModDt() {
		return ansModDt;
	}
	/**
	 * @param ansModDt the ansModDt to set
	 */
	public void setAnsModDt(String ansModDt) {
		this.ansModDt = ansModDt;
	}
	/**
	 * @return the counselStsCd
	 */
	public String getCounselStsCd() {
		return counselStsCd;
	}
	/**
	 * @param counselStsCd the counselStsCd to set
	 */
	public void setCounselStsCd(String counselStsCd) {
		this.counselStsCd = counselStsCd;
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
	 * @return the delYn
	 */
	public String getDelYn() {
		return delYn;
	}
	/**
	 * @param delYn the delYn to set
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	/**
	 * @return the secretYn
	 */
	public String getSecretYn() {
		return secretYn;
	}
	/**
	 * @param secretYn the secretYn to set
	 */
	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
	}
	/**
	 * @return the likeCnt
	 */
	public int getLikeCnt() {
		return likeCnt;
	}
	/**
	 * @param likeCnt the likeCnt to set
	 */
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	/**
	 * @return the viewCnt
	 */
	public int getViewCnt() {
		return viewCnt;
	}
	/**
	 * @param viewCnt the viewCnt to set
	 */
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	/**
	 * @return the userNm
	 */
	public String getUserNm() {
		return userNm;
	}
	/**
	 * @param userNm the userNm to set
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	/**
	 * @return the searchKeyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}
	/**
	 * @param searchKeyword the searchKeyword to set
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	/**
	 * @return the searchValue
	 */
	public String getSearchValue() {
		return searchValue;
	}
	/**
	 * @param searchValue the searchValue to set
	 */
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	/**
	 * @return the userAuthCd
	 */
	public String getUserAuthCd() {
		return userAuthCd;
	}
	/**
	 * @param userAuthCd the userAuthCd to set
	 */
	public void setUserAuthCd(String userAuthCd) {
		this.userAuthCd = userAuthCd;
	}
	/**
	 * @return the jcNm
	 */
	public String getJcNm() {
		return jcNm;
	}
	/**
	 * @param jcNm the jcNm to set
	 */
	public void setJcNm(String jcNm) {
		this.jcNm = jcNm;
	}
	/**
	 * @return the jcUserNm
	 */
	public String getJcUserNm() {
		return jcUserNm;
	}
	/**
	 * @param jcUserNm the jcUserNm to set
	 */
	public void setJcUserNm(String jcUserNm) {
		this.jcUserNm = jcUserNm;
	}
	/**
	 * @return the counselDt
	 */
	public String getCounselDt() {
		return counselDt;
	}
	/**
	 * @param counselDt the counselDt to set
	 */
	public void setCounselDt(String counselDt) {
		this.counselDt = counselDt;
	}
	/**
	 * @return the counselHour
	 */
	public String getCounselHour() {
		return counselHour;
	}
	/**
	 * @param counselHour the counselHour to set
	 */
	public void setCounselHour(String counselHour) {
		this.counselHour = counselHour;
	}
	/**
	 * @return the counselMinute
	 */
	public String getCounselMinute() {
		return counselMinute;
	}
	/**
	 * @param counselMinute the counselMinute to set
	 */
	public void setCounselMinute(String counselMinute) {
		this.counselMinute = counselMinute;
	}
	/**
	 * @return the counselAmpm
	 */
	public String getCounselAmpm() {
		return counselAmpm;
	}
	/**
	 * @param counselAmpm the counselAmpm to set
	 */
	public void setCounselAmpm(String counselAmpm) {
		this.counselAmpm = counselAmpm;
	}
	/**
	 * @return the counselNtce
	 */
	public String getCounselNtce() {
		return counselNtce;
	}
	/**
	 * @param counselNtce the counselNtce to set
	 */
	public void setCounselNtce(String counselNtce) {
		this.counselNtce = counselNtce;
	}
	/**
	 * @return the qustJcCd
	 */
	public String getQustJcCd() {
		return qustJcCd;
	}
	public String getCounselMethodDivNm() {
		return counselMethodDivNm;
	}
	public void setCounselMethodDivNm(String counselMethodDivNm) {
		this.counselMethodDivNm = counselMethodDivNm;
	}
	/**
	 * @param qustJcCd the qustJcCd to set
	 */
	public void setQustJcCd(String qustJcCd) {
		this.qustJcCd = qustJcCd;
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
	public List<CounselBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<CounselBean> list) {
		this.list = list;
	}
}
