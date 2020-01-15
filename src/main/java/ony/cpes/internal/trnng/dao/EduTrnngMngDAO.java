package ony.cpes.internal.trnng.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.CommDtlCdBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cpes.internal.trnng.bean.EduTrnngBean;


@Repository("EduTrnngMngDAO")
public class EduTrnngMngDAO extends EgovAbstractMapper{
	
	/**
	 * 시퀀스 채번
	 * @param
	 * @return String uuid
	 */	
	public String selectUUID() {
        return getSqlSession().selectOne("eduTrnngMng.selectUUID");
	}	

	/**
	 * 전공리스트
	 * @param param 
	 * @param
	 * @return List<CommDtlCdBean>
	 */	
	public List<CommDtlCdBean> selectInsttMajorCodeList(CommDtlCdBean param) {
        return getSqlSession().selectList("eduTrnngMng.selectInsttMajorCodeList");
	}	

	/**
	 * 기관/훈련 총 갯수 조회
	 * @param CounselBean param
	 * @return int
	 */	
	public int selectEduTrnngTotalCount(EduTrnngMngBean param) {
        return getSqlSession().selectOne("eduTrnngMng.selectEduTrnngTotalCount", param);
	}

	/**
	 * 기관/훈련 목록 조회
	 * @param CounselBean param
	 * @return List<EduTrnngMngBean>
	 */
	public List<EduTrnngMngBean> selectEduTrnngList(EduTrnngMngBean param) {
		return getSqlSession().selectList("eduTrnngMng.selectEduTrnngList", param);
    }
	
	/**
	 * 기관/훈련 상세 조회
	 * @param EduTrnngMngBean param
	 * @return EduTrnngMngBean
	 */
	public EduTrnngMngBean selectEduTrnngDetail(EduTrnngMngBean param) {
        return getSqlSession().selectOne("eduTrnngMng.selectEduTrnngDetail", param);
    }
	
	/**
	 * 기관/훈련 수정 Table 1
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int updateEduTrnng(EduTrnngMngBean param) {
		return getSqlSession().update("setEduTrnngMng.updateEduTrnng", param);
	}
	
	/**
	 * 기관/훈련 수정 Table 2
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int updateEduTrnngSub(EduTrnngMngBean param) {
		return getSqlSession().update("setEduTrnngMng.updateEduTrnngSub", param);
	}

	/**
	 * 기관/훈련 로그 등록 Table 1
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int insertEduTrnngLog(EduTrnngMngBean param) {
		return getSqlSession().update("setEduTrnngMng.insertEduTrnngLog", param);
	}
	
	/**
	 * 기관/훈련 로그 등록 Table 2
	 * @param EduTrnngMngBean param
	 * @return int
	 */
	public int insertEduTrnngSubLog(EduTrnngMngBean param) {
		return getSqlSession().update("setEduTrnngMng.insertEduTrnngSubLog", param);
	}
	
	/**
	 * Education Training Detail Info
	 * @param EduTrnngBean
	 * @return EduTrnngBean
	 */
	public EduTrnngBean selectEduTrnngDtlInfo(EduTrnngBean param) {
        return getSqlSession().selectOne("eduTrnngMng.selectEduTrnngDtlInfo", param);
    }	
}
