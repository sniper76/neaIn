package ony.cpes.internal.fair.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.CommDtlCdBean;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cpes.internal.fair.bean.JobFairBean;

@Repository("FairMngDAO")
public class FairMngDAO extends EgovAbstractMapper{
	
	/**
	 * 시퀀스 채번
	 * @param
	 * @return String uuid
	 */	
	public String selectUUID() {
        return getSqlSession().selectOne("fairMng.selectUUID");
	}	

	/**
	 * 채용행사 등록 관리 목록 갯수 조회
	 * @param FairMngBean param
	 * @return int
	 */	
	public int selectJobFairMngListTotalCount(FairMngBean param) {
        return getSqlSession().selectOne("fairMng.selectJobFairMngTotalCount", param);
	}

	/**
	 * 채용행사 등록 관리 목록 목록 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectJobFairMngList(FairMngBean param) {
        return getSqlSession().selectList("fairMng.selectJobFairMngList", param);
    }
	
	/**
	 * 채용행사 등록 관리 목록 목록 조회 Layer
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectJobFairListLayer(FairMngBean param) {
        return getSqlSession().selectList("fairMng.selectJobFairListLayer", param);
    }
	
	/**
	 * 채용행사 등록 관리 상세 조회
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public FairMngBean selectJobFairMngDetail(FairMngBean param) {
        return getSqlSession().selectOne("fairMng.selectJobFairMngDetail", param);
    }
	
	/**
	 * 채용행사 등록 관리 등록
	 * @param FairMngBean param
	 * @return int
	 */
	public int insertJobFairMng(FairMngBean param) {
		return getSqlSession().insert("setFairMng.insertFairMng", param);
	}	

	/**
	 * 채용행사 등록 관리 수정
	 * @param FairMngBean param
	 * @return int
	 */
	public int updateJobFairMng(FairMngBean param) {
		return getSqlSession().update("setFairMng.updateFairMng", param);
	}	

	/**
	 * 채용행사 등록 관리 삭제
	 * @param FairMngBean param
	 * @return int
	 */
	public int deleteJobFairMng(FairMngBean param) {
		return getSqlSession().update("setFairMng.deleteFairMng", param);
	}	
	
	/**
	 * Job Fair Detail Info
	 * @param JobFairBean
	 * @return JobFairBean
	 */
	public JobFairBean selectJobFairDtlInfo(JobFairBean param) {
        return getSqlSession().selectOne("fairMng.selectJobFairDtlInfo", param);
    }	

	/**
	 * 주소1 Depth 목록 조회
	 * @param 
	 * @return List<CommDtlCdBean>
	 */
	public List<CommDtlCdBean> selectLoc1DepthList() {
		return getSqlSession().selectList("fairMng.selectLoc1DepthList");
    }
	
	/**
	 * 주소1 Depth 카운트 조회
	 * @param 
	 * @return List<CommDtlCdBean>
	 */
	public int selectLoc1DepthTotalCount() {
		return getSqlSession().selectOne("fairMng.selectLoc1DepthTotalCount");
    }
}
