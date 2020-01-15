package ony.cpes.internal.bulletin.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * 게시판 관리 목록 조회
 * @author (주)한신정보기술 연구개발팀 최관형
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일           수정자     수정내용
 *  ------------- -------- ---------------------------
 *  2019.10.07 CKW
 *
 * </pre>
 */
public class BulletinCateBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	private String bulletinCateSeq       = "";
	private String bulletinMngSeq    = "";
	private String bulletinCateNm        = "";
	private String CateCnt  = "";
	private int    sort;
	
	
	
	private String contentType;
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getBulletinCateSeq() {
		return bulletinCateSeq;
	}
	public void setBulletinCateSeq(String bulletinCateSeq) {
		this.bulletinCateSeq = bulletinCateSeq;
	}
	public String getBulletinMngSeq() {
		return bulletinMngSeq;
	}
	public void setBulletinMngSeq(String bulletinMngSeq) {
		this.bulletinMngSeq = bulletinMngSeq;
	}
	public String getBulletinCateNm() {
		return bulletinCateNm;
	}
	public void setBulletinCateNm(String bulletinCateNm) {
		this.bulletinCateNm = bulletinCateNm;
	}
	public String getCateCnt() {
		return CateCnt;
	}
	public void setCateCnt(String cateCnt) {
		CateCnt = cateCnt;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}


	private List<BulletinCateBean> list;
	
	
	public List<BulletinCateBean> getList() {
		return list;
	}
	public void setList(List<BulletinCateBean> list) {
		this.list = list;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
