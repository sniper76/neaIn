package ony.cpes.internal.fair.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.fair.bean.FairBoothMngBean;

@Repository("FairBoothMngDAO")
public class FairBoothMngDAO extends EgovAbstractMapper{
	
	/**
	 * 시퀀스 채번
	 * @param
	 * @return String uuid
	 */	
	public String selectUUID() {
        return getSqlSession().selectOne("fairMng.selectUUID");
	}	

	/**
	 * 채용행사 부스 등록 관리 목록 조회
	 * @param FairBoothMngBean param
	 * @return List<FairBoothMngBean>
	 */
	public List<FairBoothMngBean> selectBoothRegList(FairBoothMngBean param) {
        return getSqlSession().selectList("fairBoothMng.selectBoothRegList", param);
    }
	
	/**
	 * 채용행사 등록 관리 부스정보 수정
	 * @param FairBoothMngBean param
	 * @return void
	 */
	public void updateFairMng(FairBoothMngBean param) {
        getSqlSession().update("setFairBoothMng.updateFairMng", param);
    }

	/**
	 * 채용행사 부스 등록 관리 등록
	 * @param FairBoothMngBean param
	 * @return void
	 */
	public void insertBoothRegMng(FairBoothMngBean param) {
        getSqlSession().insert("setFairBoothMng.insertBoothRegMng", param);
    }
	
	/**
	 * 채용행사 부스 등록 관리 수정
	 * @param FairBoothMngBean param
	 * @return void
	 */
	public void updateBoothRegMng(FairBoothMngBean param) {
        getSqlSession().update("setFairBoothMng.updateBoothRegMng", param);
    }

	/**
     * 채용행사 부스 관리 - 신청 목록 갯수
     *
     * @param FairBoothMngBean param
     * @return int
     */	
	public int selectBoothReqMngTotalCount(FairBoothMngBean param) {
		return getSqlSession().selectOne("fairBoothMng.selectBoothReqMngTotalCount", param);
	}

	/**
     * 채용행사 부스 관리 - 신청 목록
     *
     * @param FairBoothMngBean param
     * @return List<FairBoothMngBean>
     */	
	public List<FairBoothMngBean> selectBoothReqMngList(FairBoothMngBean param) {
		return getSqlSession().selectList("fairBoothMng.selectBoothReqMngList", param);
	}

	/**
     * 채용행사 부스 관리 - 부스 상세
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	public FairBoothMngBean selectBoothReqMngDetail(FairBoothMngBean param) {
		return getSqlSession().selectOne("fairBoothMng.selectBoothReqMngDetail", param);
	}

	/**
     * 채용행사 부스 관리 - 예약상태 변경
     *
     * @param FairBoothMngBean param
     * @return void
     */	
	public void updateBoothReqMng(FairBoothMngBean param) {
		getSqlSession().update("setFairBoothMng.updateBoothReqMng", param);
	}
	
	/**
     * 채용행사 부스 관리 - 기업/기관 부스 매핑 해제
     *
     * @param FairBoothMngBean param
     * @return void
     */	
	public void deleteBoothReqMng(FairBoothMngBean param) {
		getSqlSession().update("setFairBoothMng.deleteBoothReqMng", param);
	}
	
	/**
     * 채용행사 부스 관리 - 기업/기관 부스 변경
     *
     * @param FairBoothMngBean param
     * @return void
     */	
	public void updateBoothCompnyInsttMng(FairBoothMngBean param) {
		getSqlSession().update("setFairBoothMng.updateBoothCompnyInsttMng", param);
	}
	

	/**
     * 채용행사 부스 관리 - 예비 신청 목록 갯수
     *
     * @param FairBoothMngBean param
     * @return int
     */
	public int selectBoothResvMngTotalCount(FairBoothMngBean param) {
		return getSqlSession().selectOne("fairBoothMng.selectBoothResvMngTotalCount", param);
	}

	/**
     * 채용행사 부스 관리 - 예비 신청 목록
     *
     * @param FairBoothMngBean param
     * @return List<FairBoothMngBean>
     */		
	public List<FairBoothMngBean> selectBoothResvMngList(FairBoothMngBean param) {
		return getSqlSession().selectList("fairBoothMng.selectBoothResvMngList", param);
	}

	/**
     * 채용행사 부스 관리 - 기업/기관 선택 팝업 예비신청 조회 리스트
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */		
	public List<FairBoothMngBean> selectBoothReqListLayerA(FairBoothMngBean param) {
		return getSqlSession().selectList("fairBoothMng.selectBoothReqListLayerA", param);
	}

	/**
     * 채용행사 부스 관리 - 기업/기관 선택 팝업 채용행사참여 조회 리스트
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */		
	public List<FairBoothMngBean> selectBoothReqListLayerB(FairBoothMngBean param) {
		return getSqlSession().selectList("fairBoothMng.selectBoothReqListLayerB", param);
	}
}
