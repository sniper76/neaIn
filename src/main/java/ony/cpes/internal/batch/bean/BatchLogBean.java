package ony.cpes.internal.batch.bean;

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
public class BatchLogBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	private String batchLogSeq = "";
	private String batchKindCd = "";
	private String batchKindNm = ""; 
	private String batchBgnDt  = "";
	private String batchEndDt  = "";
	private String successYn   = "";
	
	
	public String getBatchLogSeq() {
		return batchLogSeq;
	}
	public void setBatchLogSeq(String batchLogSeq) {
		this.batchLogSeq = batchLogSeq;
	}
	public String getBatchKindCd() {
		return batchKindCd;
	}
	public void setBatchKindCd(String batchKindCd) {
		this.batchKindCd = batchKindCd;
	}
	public String getBatchKindNm() {
		return batchKindNm;
	}
	public void setBatchKindNm(String batchKindNm) {
		this.batchKindNm = batchKindNm;
	}
	public String getBatchBgnDt() {
		return batchBgnDt;
	}
	public void setBatchBgnDt(String batchBgnDt) {
		this.batchBgnDt = batchBgnDt;
	}
	public String getBatchEndDt() {
		return batchEndDt;
	}
	public void setBatchEndDt(String batchEndDt) {
		this.batchEndDt = batchEndDt;
	}
	public String getSuccessYn() {
		return successYn;
	}
	public void setSuccessYn(String successYn) {
		this.successYn = successYn;
	}

	
	
	
}
