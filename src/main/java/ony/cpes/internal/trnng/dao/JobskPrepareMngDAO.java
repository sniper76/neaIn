package ony.cpes.internal.trnng.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.CommDtlCdBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;


@Repository("JobskPrepareMngDAO")
public class JobskPrepareMngDAO extends EgovAbstractMapper{
	
	/**
	 * 시퀀스 채번
	 * @param
	 * @return String uuid
	 */	
	public String selectUUID() {
        return getSqlSession().selectOne("jobskPrepareMng.selectUUID");
	}	

	
	/**
	 * 주소 2 Depth 목록 총 갯수 조회
	 * @param CounselBean param
	 * @return int
	 */	
	public int selectLOC2DepthTotalCount() {
        return getSqlSession().selectOne("jobskPrepareMng.selectLOC2DepthTotalCount");
	}	
	
	
	/**
	 * 주소 2 Depth 목록 조회
	 * @param 
	 * @return List<CommDtlCdBean>
	 */
	public List<CommDtlCdBean> selectLOC2DepthList() {
		return getSqlSession().selectList("jobskPrepareMng.selectLOC2DepthList");
    }

	/**
	 * 기관/훈련 총 갯수 조회
	 * @param CounselBean param
	 * @return int
	 */	
	public int selectEduTrnngTotalCount(EduTrnngMngBean param) {
        return getSqlSession().selectOne("jobskPrepareMng.selectEduTrnngTotalCount", param);
	}

	/**
	 * 기관/훈련 목록 조회
	 * @param CounselBean param
	 * @return List<EduTrnngMngBean>
	 */
	public List<EduTrnngMngBean> selectEduTrnngList(EduTrnngMngBean param) {
		return getSqlSession().selectList("jobskPrepareMng.selectEduTrnngList", param);
    }
	
	/**
	 * 기관/훈련 상세 조회
	 * @param EduTrnngMngBean param
	 * @return EduTrnngMngBean
	 */
	public EduTrnngMngBean selectEduTrnngDetail(EduTrnngMngBean param) {
        return getSqlSession().selectOne("jobskPrepareMng.selectEduTrnngDetail", param);
    }
	
	/**
	 * 기관/훈련 수정 Table 1
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int updateEduTrnng(EduTrnngMngBean param) {
		return getSqlSession().update("setJobskPrepareMng.updateEduTrnng", param);
	}
	
	/**
	 * 기관/훈련 수정 Table 2
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int updateEduTrnngSub(EduTrnngMngBean param) {
		return getSqlSession().update("setJobskPrepareMng.updateEduTrnngSub", param);
	}

	/**
	 * 기관/훈련 등록 Table 1
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int insertEduTrnng(EduTrnngMngBean param) {
		return getSqlSession().insert("setJobskPrepareMng.insertEduTrnng", param);
	}
	
	/**
	 * 기관/훈련 등록 Table 2
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int insertEduTrnngSub(EduTrnngMngBean param) {
		return getSqlSession().insert("setJobskPrepareMng.insertEduTrnngSub", param);
	}

	/**
	 * 기관/훈련 로그 등록 Table 1
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int insertEduTrnngLog(EduTrnngMngBean param) {
		return getSqlSession().insert("setJobskPrepareMng.insertEduTrnngLog", param);
	}
	
	/**
	 * 기관/훈련 로그 등록 Table 2
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int insertEduTrnngSubLog(EduTrnngMngBean param) {
		return getSqlSession().insert("setJobskPrepareMng.insertEduTrnngSubLog", param);
	}
	
	/**
	 * 기관/훈련 삭제
	 * @param EduTrnngMngBean param
	 * @return void
	 */	
	
	public int deleteEduTrnng(EduTrnngMngBean param) {
		return getSqlSession().update("setJobskPrepareMng.deleteEduTrnng", param);
	}

	/**
	 * 구직준비교육신청자 총 갯수 조회
	 * @param CounselBean param
	 * @return int
	 */	
	public int selectJobskPrepareSubscriberTotalCount(EduTrnngMngBean param) {
        return getSqlSession().selectOne("jobskPrepareMng.selectJobskPrepareSubscriberTotalCount", param);
	}

	/**
	 * 구직준비교육신청자 목록 조회
	 * @param CounselBean param
	 * @return List<EduTrnngMngBean>
	 */
	public List<EduTrnngMngBean> selectJobskPrepareSubscriberList(EduTrnngMngBean param) {
		return getSqlSession().selectList("jobskPrepareMng.selectJobskPrepareSubscriberList", param);
    }
	
	/**
	 * 구직준비교육신청자 상세 조회
	 * @param EduTrnngMngBean param
	 * @return EduTrnngMngBean
	 */
	public EduTrnngMngBean selectJobskPrepareSubscriberDetail(EduTrnngMngBean param) {
        return getSqlSession().selectOne("jobskPrepareMng.selectJobskPrepareSubscriberDetail", param);
    }
	
	/**
	 * 구직준비교육신청자 상태 수정
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int updateJobskPrepareSubscriber(EduTrnngMngBean param) {
		return getSqlSession().update("setJobskPrepareMng.updateJobskPrepareSubscriber", param);
	}
	
}
