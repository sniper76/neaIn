package ony.cmm.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 회원정보를 관리하기 위한 모델 클래스
 * @author (주)한신정보기술 연구개발팀 최관형
 * @since 2015.04.22
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일           수정자     수정내용
 *  ------------- -------- ---------------------------
 *  2015.04.22 최관형     최초 생성
 *
 * </pre>
 */
public class LocationBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	private String id					=	"";
	private String lvl			=	"";
	private String lvlCd			=	"";
	private String countryId			=	"";
	private String provinceId			=	"";
	private String districtId			=	"";
	private String communeId			=	"";
	private String villageId			=	"";
	private String parentId				=	"";
	private String nmEn					=	"";
	private String nmKh					=	"";
	private String provinceIdApi		=	"";
	private String nm					=	"";

	private List<LocationBean> list 	= new ArrayList<LocationBean>();

	private String depth;
	private String condGrpCd;
	private String cdLength;

	public String getCondGrpCd() {
		return condGrpCd;
	}
	public void setCondGrpCd(String condGrpCd) {
		this.condGrpCd = condGrpCd;
	}
	public String getCdLength() {
		return cdLength;
	}
	public void setCdLength(String cdLength) {
		this.cdLength = cdLength;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getLvl() {
		return lvl;
	}
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	public List<LocationBean> getList() {
		return list;
	}
	public void setList(List<LocationBean> list) {
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public String getCommuneId() {
		return communeId;
	}
	public void setCommuneId(String communeId) {
		this.communeId = communeId;
	}
	public String getVillageId() {
		return villageId;
	}
	public void setVillageId(String villageId) {
		this.villageId = villageId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getNmEn() {
		return nmEn;
	}
	public void setNmEn(String nmEn) {
		this.nmEn = nmEn;
	}
	public String getNmKh() {
		return nmKh;
	}
	public void setNmKh(String nmKh) {
		this.nmKh = nmKh;
	}
	public String getProvinceIdApi() {
		return provinceIdApi;
	}
	public void setProvinceIdApi(String provinceIdApi) {
		this.provinceIdApi = provinceIdApi;
	}
	public String getLvlCd() {
		return lvlCd;
	}
	public void setLvlCd(String lvlCd) {
		this.lvlCd = lvlCd;
	}
	/**
	 * @return the nm
	 */
	public String getNm() {
		return nm;
	}
	/**
	 * @param nm the nm to set
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}




}
