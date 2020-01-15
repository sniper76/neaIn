package ony.cpes.internal.common.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 * model for JobCenter
 * @author Onycom yhLee
 * @since 2019.10.09
 * @version 1.0
 * @see
 *
 * <pre>
 * << Modification Information >>
 *
 *  modify date           updater    description
 *  ------------- -------- ---------------------------
 *  2019.10.09 				yhLee     creation
 *
 * </pre>
 */
public class JobCenterBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	/** 사용자 구분 */
	private String jcCd                	= "";
	private String jcEn                	= "";
	private String jcKh                	= "";
	private String addrEn              	= "";
	private String addrKh              	= "";
	private String tel1                	= "";
	private String tel2                	= "";
	private String tel3                	= "";
	private String tel4                	= "";
	private String email               	= "";
	private String facebook            	= "";
	private String website             	= "";
	private String fileGrpSeq          	= "";
	private String addrCd              	= "";
	private String explnEn              = "";
	private String lngtd               	= "";
	private String lattd               	= "";
	private String explnKh             	= "";
	private String jcNm                 = "";
	private String addrNm               = "";
	private String locNm                = "";
	private String mapLink              = "";
	private String useYn                = "";
	private String modDt                = "";
	private String regUserNm            = "";
	private String regDt                = "";
	private String KeywordSel           = "";
	private String keyword              = "";
	private String addrFullCd           = "";
	private String addrFullNm           = "";
	
	/*for list*/
	//private List<JobCenterBean> list;
	
	// for parameter
	private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private int start = 0;
    private int length = 10;
    private int orderStr = 0;
    private String orderColumn = "";
    private String orderColumnSort = "";
    private List<JobCenterBean> list;
    
    private UserBean user = new UserBean();
    
    
    public List<JobCenterBean> getList() {
		return list;
	}
	public void setList(List<JobCenterBean> list) {
		this.list = list;
	}
	public String getOrderColumnSort() {
		return orderColumnSort;
	}
	public void setOrderColumnSort(String orderColumnSort) {
		this.orderColumnSort = orderColumnSort;
	}
	public int getOrderStr() {
		return orderStr;
	}
	public void setOrderStr(int orderStr) {
		this.orderStr = orderStr;
	}
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public String getJcCd() {
		return jcCd;
	}
	public void setJcCd(String jcCd) {
		this.jcCd = jcCd;
	}
	public String getJcEn() {
		return jcEn;
	}
	public void setJcEn(String jcEn) {
		this.jcEn = jcEn;
	}
	public String getJcKh() {
		return jcKh;
	}
	public void setJcKh(String jcKh) {
		this.jcKh = jcKh;
	}
	public String getAddrEn() {
		return addrEn;
	}
	public void setAddrEn(String addrEn) {
		this.addrEn = addrEn;
	}
	public String getAddrKh() {
		return addrKh;
	}
	public void setAddrKh(String addrKh) {
		this.addrKh = addrKh;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getTel4() {
		return tel4;
	}
	public void setTel4(String tel4) {
		this.tel4 = tel4;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getFileGrpSeq() {
		return fileGrpSeq;
	}
	public void setFileGrpSeq(String fileGrpSeq) {
		this.fileGrpSeq = fileGrpSeq;
	}
	public String getAddrCd() {
		return addrCd;
	}
	public void setAddrCd(String addrCd) {
		this.addrCd = addrCd;
	}
	public String getLngtd() {
		return lngtd;
	}
	public void setLngtd(String lngtd) {
		this.lngtd = lngtd;
	}
	public String getLattd() {
		return lattd;
	}
	public void setLattd(String lattd) {
		this.lattd = lattd;
	}
	public String getExplnKh() {
		return explnKh;
	}
	public void setExplnKh(String explnKh) {
		this.explnKh = explnKh;
	}
	public String getExplnEn() {
		return explnEn;
	}
	public void setExplnEn(String explnEn) {
		this.explnEn = explnEn;
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
	 * @return the addrNm
	 */
	public String getAddrNm() {
		return addrNm;
	}
	/**
	 * @param addrNm the addrNm to set
	 */
	public void setAddrNm(String addrNm) {
		this.addrNm = addrNm;
	}
	/**
	 * @return the locNm
	 */
	public String getLocNm() {
		return locNm;
	}
	/**
	 * @param locNm the locNm to set
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	/**
	 * @return the mapLink
	 */
	public String getMapLink() {
		return mapLink;
	}
	/**
	 * @param mapLink the mapLink to set
	 */
	public void setMapLink(String mapLink) {
		this.mapLink = mapLink;
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
	 * @return the keywordSel
	 */
	public String getKeywordSel() {
		return KeywordSel;
	}
	/**
	 * @param keywordSel the keywordSel to set
	 */
	public void setKeywordSel(String keywordSel) {
		KeywordSel = keywordSel;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	 * @return the addrFullCd
	 */
	public String getAddrFullCd() {
		return addrFullCd;
	}
	/**
	 * @param addrFullCd the addrFullCd to set
	 */
	public void setAddrFullCd(String addrFullCd) {
		this.addrFullCd = addrFullCd;
	}
	/**
	 * @return the addrFullNm
	 */
	public String getAddrFullNm() {
		return addrFullNm;
	}
	/**
	 * @param addrFullNm the addrFullNm to set
	 */
	public void setAddrFullNm(String addrFullNm) {
		this.addrFullNm = addrFullNm;
	}
	
	
}
