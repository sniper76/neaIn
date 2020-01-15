package ony.cpes.internal.counsel.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.counsel.bean.CounselBean;


@Repository("CounselDAO")
public class CounselDAO extends EgovAbstractMapper{
	
	/**
	 * 시퀀스 채번
	 * @param
	 * @return String uuid
	 */	
	public String selectUUID() {
        return getSqlSession().selectOne("counsel.selectUUID");
	}	

	/**
	 * 상담 총 갯수 조회
	 * @param CounselBean param
	 * @return int
	 */	
	public int selectCounselListTotalCount(CounselBean param) {
        return getSqlSession().selectOne("counsel.selectCounselListTotalCount", param);
	}

	/**
	 * 상담 목록 조회
	 * @param CounselBean param
	 * @return List<CounselBean>
	 */
	public List<CounselBean> selectCounselList(CounselBean param) {
        return getSqlSession().selectList("counsel.selectCounselList", param);
    }
	
	/**
	 * 일반회원 상담내역 총 갯수 조회
	 * @param CounselBean param
	 * @return int
	 */	
	public int selectUserCounselHisTotalCount(CounselBean param) {
        return getSqlSession().selectOne("counsel.selectUserCounselHisTotalCount", param);
	}
	
	/**
	 * 일반회원 상담 내역 조회
	 * @param CounselBean param
	 * @return List<CounselBean>
	 */
	public List<CounselBean> selectUserCounselHis(CounselBean param) {
        return getSqlSession().selectList("counsel.selectUserCounselHis", param);
    }

	/**
	 * 상담 상세 조회
	 * @param CounselBean param
	 * @return CounselBean
	 */
	public CounselBean selectCounselDetail(CounselBean param) {
        return getSqlSession().selectOne("counsel.selectCounselDetail", param);
    }
	
	/**
	 * 상담내역 상세 조회
	 * @param CounselBean param
	 * @return CounselBean
	 */
	public CounselBean selectCounselHistDetail(CounselBean param) {
        return getSqlSession().selectOne("counsel.selectCounselHistDetail", param);
    }
	
	/**
	 * 상담 등록
	 * @param CounselBean param
	 * @return int
	 */
	public int insertCounsel(CounselBean param) {
		return getSqlSession().insert("setCounsel.insertCounsel", param);
	}

	/**
	 * 상담 수정
	 * @param CounselBean param
	 * @return int
	 */
	public int updateCounsel(CounselBean param) {
		return getSqlSession().update("setCounsel.updateCounsel", param);
	}
	
	/**
	 * 상담 삭제
	 * @param CounselBean param
	 * @return int
	 */
	public int deleteCounsel(CounselBean param) {
		return getSqlSession().update("setCounsel.deleteCounsel", param);
	}
}
