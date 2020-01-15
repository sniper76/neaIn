package ony.cpes.internal.fair.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cpes.internal.fair.bean.JobFairBean;

@Repository("FairVccyMngDAO")
public class FairVccyMngDAO extends EgovAbstractMapper{
	
	/**
	 * 시퀀스 채번
	 * @param
	 * @return String uuid
	 */	
	public String selectUUID() {
        return getSqlSession().selectOne("fairMng.selectUUID");
	}	

	/**
	 * 채용행사 - 운영관리 - 채용공고 갯수
	 * @param FairMngBean param
	 * @return int
	 */
	public int selectEmpmnAncmtMngTotalCount(FairMngBean param) {
		return getSqlSession().selectOne("fairVccyMng.selectEmpmnAncmtMngTotalCount", param);
	}

	/**
	 * 채용행사 - 운영관리 - 채용공고 목록
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectEmpmnAncmtMngList(FairMngBean param) {
        return getSqlSession().selectList("fairVccyMng.selectEmpmnAncmtMngList", param);
	}

	/**
	 * 채용행사 - 운영관리 - 채용공고 상세
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public FairMngBean selectEmpmnAncmtMngDetail(FairMngBean param) {
		return getSqlSession().selectOne("fairVccyMng.selectEmpmnAncmtMngDetail", param);
	}

	/**
	 * 채용행사 - 운영관리 - 채용공고 - 승인상태 수정
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public void updateEmpmnAncmtMng(FairMngBean param) {
		getSqlSession().update("setFairVccyMng.updateEmpmnAncmtMng", param);		
	}

	/**
	 * 채용행사 - 운영관리 - 매핑 안된 채용공고 갯수
	 * @param FairMngBean param
	 * @return int
	 */
	public int selectEmpmnAncmtJoinTotalCount(FairMngBean param) {
		return getSqlSession().selectOne("fairVccyMng.selectEmpmnAncmtJoinTotalCount", param);
	}

	/**
	 * 채용행사 - 운영관리 - 매핑 안된 채용공고 목록
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectEmpmnAncmtJoinList(FairMngBean param) {
        return getSqlSession().selectList("fairVccyMng.selectEmpmnAncmtJoinList", param);
	}

	/**
	 * 채용행사 - 운영관리 - 매핑 안된 채용공고 상세
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public FairMngBean selectEmpmnAncmtJoinDetail(FairMngBean param) {
		return getSqlSession().selectOne("fairVccyMng.selectEmpmnAncmtJoinDetail", param);
	}

	/**
	 * 채용행사 - 운영관리 - 매핑 안된 채용공고 매핑
	 * @param FairMngBean param
	 * @return void
	 */
	public int insertEmpmnAncmtJoin(FairMngBean param) {
		return getSqlSession().insert("setFairVccyMng.insertEmpmnAncmtJoin", param);		
	}
	
	/**
	 * 채용행사 - 운영관리 - 매핑 안된 채용공고 매핑 후 승인상태 수정
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public void updateEmpmnAncmtJoin(FairMngBean param) {
		getSqlSession().update("setFairVccyMng.updateEmpmnAncmtJoin", param);		
	}

	/**
	 * 채용행사 - 운영관리 - 입사지원 목록 갯수
	 * @param FairMngBean param
	 * @return int
	 */
	public int selectApplicMngTotalCount(FairMngBean param) {
		return getSqlSession().selectOne("fairVccyMng.selectApplicMngTotalCount", param);
	}

	/**
	 * 채용행사 - 운영관리 - 입사지원 목록
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectApplicMngList(FairMngBean param) {
		return getSqlSession().selectList("fairVccyMng.selectApplicMngList", param);
	}

	/**
	 * 채용행사 - 운영관리 - 면접제의 목록 갯수
	 * @param FairMngBean param
	 * @return int
	 */
	public int selectIntvwMngTotalCount(FairMngBean param) {
		return getSqlSession().selectOne("fairVccyMng.selectIntvwMngTotalCount", param);
	}

	/**
	 * 채용행사 - 운영관리 - 면접제의 목록
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectIntvwMngList(FairMngBean param) {
		return getSqlSession().selectList("fairVccyMng.selectIntvwMngList", param);
	}
	
}
