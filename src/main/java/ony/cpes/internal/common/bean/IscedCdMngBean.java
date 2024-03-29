package ony.cpes.internal.common.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 * ISCO
 * @author onycom
 * @since 2019.10.22
 * @version 1.0
 * @see
 *
 * <pre>
 * << Modification Information >>
 *
 *  updateDate updater desc
 *  ------------- -------- ---------------------------
 *
 * </pre>
 */
public class IscedCdMngBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	private String iscedCd		=	"";
	private String iscedId		=   "";
	private String enNm			=	"";
	private String khNm			=	"";
	private String upperCd		=	"";
	private String lvl			=	"";
	private String cdLvl		=	"";
	private String expln		=	"";
	private String cateNm		=	"";
	private String useYn		=	"";
	private String regUserNm	=	"";
	private String oneDepth     = "";
	private String twoDepth     = "";
	private String twoDepthNm   = "";
	private String threeDepth   = "";
	private String threeDepthNm = "";
	private String fourDepth    = "";
	private String depth        = "";
	private String regDt      = "";
	
	private List<IscedCdMngBean> list = new ArrayList<IscedCdMngBean>();
	
	private UserBean user = new UserBean();
	
	
	public List<IscedCdMngBean> getList() {
		return list;
	}
	public void setList(List<IscedCdMngBean> list) {
		this.list = list;
	}
	public String getEnNm() {
		return enNm;
	}
	public void setEnNm(String enNm) {
		this.enNm = enNm;
	}
	public String getKhNm() {
		return khNm;
	}
	public void setKhNm(String khNm) {
		this.khNm = khNm;
	}
	public String getUpperCd() {
		return upperCd;
	}
	public void setUpperCd(String upperCd) {
		this.upperCd = upperCd;
	}
	public String getLvl() {
		return lvl;
	}
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	public String getCdLvl() {
		return cdLvl;
	}
	public void setCdLvl(String cdLvl) {
		this.cdLvl = cdLvl;
	}
	public String getExpln() {
		return expln;
	}
	public void setExpln(String expln) {
		this.expln = expln;
	}
	public String getCateNm() {
		return cateNm;
	}
	public void setCateNm(String cateNm) {
		this.cateNm = cateNm;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
	 * @return the oneDepth
	 */
	public String getOneDepth() {
		return oneDepth;
	}
	/**
	 * @param oneDepth the oneDepth to set
	 */
	public void setOneDepth(String oneDepth) {
		this.oneDepth = oneDepth;
	}
	/**
	 * @return the twoDepth
	 */
	public String getTwoDepth() {
		return twoDepth;
	}
	/**
	 * @param twoDepth the twoDepth to set
	 */
	public void setTwoDepth(String twoDepth) {
		this.twoDepth = twoDepth;
	}
	/**
	 * @return the threeDepth
	 */
	public String getThreeDepth() {
		return threeDepth;
	}
	/**
	 * @param threeDepth the threeDepth to set
	 */
	public void setThreeDepth(String threeDepth) {
		this.threeDepth = threeDepth;
	}
	/**
	 * @return the fourDepth
	 */
	public String getFourDepth() {
		return fourDepth;
	}
	/**
	 * @param fourDepth the fourDepth to set
	 */
	public void setFourDepth(String fourDepth) {
		this.fourDepth = fourDepth;
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
	 * @return the depth
	 */
	public String getDepth() {
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(String depth) {
		this.depth = depth;
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
	 * @return the twoDepthNm
	 */
	public String getTwoDepthNm() {
		return twoDepthNm;
	}
	/**
	 * @param twoDepthNm the twoDepthNm to set
	 */
	public void setTwoDepthNm(String twoDepthNm) {
		this.twoDepthNm = twoDepthNm;
	}
	/**
	 * @return the threeDepthNm
	 */
	public String getThreeDepthNm() {
		return threeDepthNm;
	}
	/**
	 * @param threeDepthNm the threeDepthNm to set
	 */
	public void setThreeDepthNm(String threeDepthNm) {
		this.threeDepthNm = threeDepthNm;
	}
	/**
	 * @return the iscedCd
	 */
	public String getIscedCd() {
		return iscedCd;
	}
	/**
	 * @param iscedCd the iscedCd to set
	 */
	public void setIscedCd(String iscedCd) {
		this.iscedCd = iscedCd;
	}
	/**
	 * @return the iscedId
	 */
	public String getIscedId() {
		return iscedId;
	}
	/**
	 * @param iscedId the iscedId to set
	 */
	public void setIscedId(String iscedId) {
		this.iscedId = iscedId;
	}
	
	
}
