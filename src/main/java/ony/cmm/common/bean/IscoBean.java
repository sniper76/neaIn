package ony.cmm.common.bean;

import java.util.ArrayList;
import java.util.List;

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
public class IscoBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	private String iscoCd		=	"";
	private String enNm			=	"";
	private String khNm			=	"";
	private String upperCd		=	"";
	private String lvl			=	"";
	private String cdLvl		=	"";
	private String expln		=	"";
	private String cateNm		=	"";
	private String useYn		=	"";
	private int    iscoId          ;
	
	private List<IscoBean> list = new ArrayList<IscoBean>();
	
	
	
	
	public List<IscoBean> getList() {
		return list;
	}
	public void setList(List<IscoBean> list) {
		this.list = list;
	}
	public String getIscoCd() {
		return iscoCd;
	}
	public void setIscoCd(String iscoCd) {
		this.iscoCd = iscoCd;
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
	 * @return the iscoId
	 */
	public int getIscoId() {
		return iscoId;
	}
	/**
	 * @param iscoId the iscoId to set
	 */
	public void setIscoId(int iscoId) {
		this.iscoId = iscoId;
	}
	
	
	
}
