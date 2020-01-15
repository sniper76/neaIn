package ony.cpes.internal.user.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * 사용자 변경 목록조회
 * @author
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일           수정자     수정내용
 *  ------------- -------- ---------------------------
 *  2019.10.07 Joo
 *
 * </pre>
 */
public class UserChgBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	/* Data Variable */
	private String userChgSeq 	= "";
	
	private String chgPrevCd 	= "";
	private String chgPrevNm 	= "";
	private String chgNextCd 	= "";
	private String chgNextNm 	= "";
	
	private String chgReason 	= "";
	private String chgAgreeStsCd= "";
	private String chgAgreeStsNm= "";
	private String jcUserSeq 	= "";
	private String jcCd 		= "";
	private String jcNm 		= "";
	
	private String stsChgDt		= "";
	private String agreeRejectReason = "";
	
	private String disable		= "";
	
	private List<UserChgBean> list;
	
	private UserBean user = new UserBean();
	
	public String getDisable() {
		return disable;
	}

	public void setDisable(String disable) {
		this.disable = disable;
	}

	public String getAgreeRejectReason() {
		return agreeRejectReason;
	}

	public void setAgreeRejectReason(String agreeRejectReason) {
		this.agreeRejectReason = agreeRejectReason;
	}

	public String getStsChgDt() {
		return stsChgDt;
	}

	public void setStsChgDt(String stsChgDt) {
		this.stsChgDt = stsChgDt;
	}

	public String getUserChgSeq() {
		return userChgSeq;
	}

	public void setUserChgSeq(String userChgSeq) {
		this.userChgSeq = userChgSeq;
	}

	public String getChgPrevCd() {
		return chgPrevCd;
	}

	public void setChgPrevCd(String chgPrevCd) {
		this.chgPrevCd = chgPrevCd;
	}

	public String getChgPrevNm() {
		return chgPrevNm;
	}

	public void setChgPrevNm(String chgPrevNm) {
		this.chgPrevNm = chgPrevNm;
	}

	public String getChgNextCd() {
		return chgNextCd;
	}

	public void setChgNextCd(String chgNextCd) {
		this.chgNextCd = chgNextCd;
	}

	public String getChgNextNm() {
		return chgNextNm;
	}

	public void setChgNextNm(String chgNextNm) {
		this.chgNextNm = chgNextNm;
	}

	public String getChgReason() {
		return chgReason;
	}

	public void setChgReason(String chgReason) {
		this.chgReason = chgReason;
	}

	public String getChgAgreeStsCd() {
		return chgAgreeStsCd;
	}

	public void setChgAgreeStsCd(String chgAgreeStsCd) {
		this.chgAgreeStsCd = chgAgreeStsCd;
	}

	public String getChgAgreeStsNm() {
		return chgAgreeStsNm;
	}

	public void setChgAgreeStsNm(String chgAgreeStsNm) {
		this.chgAgreeStsNm = chgAgreeStsNm;
	}

	public String getJcUserSeq() {
		return jcUserSeq;
	}

	public void setJcUserSeq(String jcUserSeq) {
		this.jcUserSeq = jcUserSeq;
	}

	public String getJcCd() {
		return jcCd;
	}

	public void setJcCd(String jcCd) {
		this.jcCd = jcCd;
	}

	public String getJcNm() {
		return jcNm;
	}

	public void setJcNm(String jcNm) {
		this.jcNm = jcNm;
	}

	public List<UserChgBean> getList() {
		return list;
	}

	public void setList(List<UserChgBean> list) {
		this.list = list;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	
	
	
}
