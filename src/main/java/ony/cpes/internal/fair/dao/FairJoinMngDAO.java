package ony.cpes.internal.fair.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.fair.bean.FairMngBean;

@Repository("FairJoinMngDAO")
public class FairJoinMngDAO extends EgovAbstractMapper{

	/**
	 * 시퀀스 채번
	 * @param
	 * @return String uuid
	 */
	public String selectUUID() {
        return getSqlSession().selectOne("fairJoinMng.selectUUID");
	}

	/**
	 * 채용행사 참가현황 목록 갯수 조회
	 * @param FairMngBean param
	 * @return int
	 */
	public int selectJobFairJoinMngListTotalCount(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectJobFairJoinMngTotalCount", param);
	}

	/**
	 * 채용행사 참가현황 목록 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectJobFairJoinMngList(FairMngBean param) {
        return getSqlSession().selectList("fairJoinMng.selectJobFairJoinMngList", param);
    }

	/**
	 * 채용행사 개인회원 참가 목록 갯수 조회
	 * @param FairMngBean param
	 * @return int
	 */
	public int selectPrivateUserJoinMngTotalCount(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectPrivateUserJoinMngTotalCount", param);
	}

	/**
	 * 채용행사 개인회원 참가 목록 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectPrivateUserJoinMngList(FairMngBean param) {
        return getSqlSession().selectList("fairJoinMng.selectPrivateUserJoinMngList", param);
    }

	/**
	 * 채용행사 개인회원 참가 상세 조회
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public FairMngBean selectPrivateUserJoinMngDetail(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectPrivateUserJoinMngDetail", param);
    }

	/**
	 * 채용행사 개인회원 참가 관리 수정
	 * @param FairMngBean param
	 * @return int
	 */
	public int updatePrivateUserJoinMng(FairMngBean param) {
		return getSqlSession().update("setFairJoinMng.updatePrivateUserJoinMng", param);
	}

	/**
	 * 채용행사 기업회원 참가기업 갯수 조회
	 * @param FairMngBean param
	 * @return int
	 */
	public int selectCompnyMngTotalCount(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectCompnyMngTotalCount", param);
	}

	/**
	 * 채용행사 기업회원 참가기업 목록 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectCompnyMngList(FairMngBean param) {
        return getSqlSession().selectList("fairJoinMng.selectCompnyMngList", param);
    }

	/**
	 * 채용행사 기업회원 참가기업 상세
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public FairMngBean selectCompnyMngDetail(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectCompnyMngDetail", param);
    }

	/**
	 * 채용행사 기업회원 신청 승인상태 수정
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public void updateCompnyRequestMng(FairMngBean param) {
        getSqlSession().insert("setFairJoinMng.updateCompnyRequestMng", param);
    }

	/**
	 * 채용행사 기업회원  갯수 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public int selectInviteCompnyTotalCount(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectInviteCompnyTotalCount", param);
    }

	/**
	 * 채용행사 기업회원 목록 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectInviteCompnyList(FairMngBean param) {
        return getSqlSession().selectList("fairJoinMng.selectInviteCompnyList", param);
    }

	/**
	 * 채용행사 기업회원 상세
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public FairMngBean selectInviteCompnyDetail(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectInviteCompnyDetail", param);
    }

	/**
	 * 채용행사 기업회원 초청 등록
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public void insertInviteCompny(FairMngBean param) {
        getSqlSession().insert("setFairJoinMng.insertInviteCompny", param);
    }

	/**
	 * 채용행사 기관회원 참가기관 갯수 조회
	 * @param FairMngBean param
	 * @return int
	 */
	public int selectInsttMngTotalCount(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectInsttMngTotalCount", param);
	}

	/**
	 * 채용행사 기관회원 참가기관 목록 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectInsttMngList(FairMngBean param) {
        return getSqlSession().selectList("fairJoinMng.selectInsttMngList", param);
    }

	/**
	 * 채용행사 기관회원  갯수 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public int selectInviteInsttTotalCount(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectInviteInsttTotalCount", param);
    }

	/**
	 * 채용행사 기관회원 목록 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	public List<FairMngBean> selectInviteInsttList(FairMngBean param) {
        return getSqlSession().selectList("fairJoinMng.selectInviteInsttList", param);
    }

	/**
	 * 채용행사 기관회원 상세
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public FairMngBean selectInviteInsttDetail(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectInviteInsttDetail", param);
    }

	/**
	 * 채용행사 기관회원 초청 등록
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public void insertInviteInstt(FairMngBean param) {
        getSqlSession().insert("setFairJoinMng.insertInviteInstt", param);
    }

	/**
	 * 채용행사 기관회원 참가기관 상세
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public FairMngBean selectInsttMngDetail(FairMngBean param) {
        return getSqlSession().selectOne("fairJoinMng.selectInsttMngDetail", param);
    }

	/**
	 * 채용행사 기관회원 신청 승인상태 수정
	 * @param FairMngBean param
	 * @return FairMngBean
	 */
	public void updateInsttRequestMng(FairMngBean param) {
        getSqlSession().insert("setFairJoinMng.updateInsttRequestMng", param);
    }

	public List<FairMngBean> selectCoInvitationList(FairMngBean param){
		return getSqlSession().selectList("fairJoinMng.selectCoInvitationList", param);
	}

	public int insertFairPatcptnCompny(FairMngBean param) {
		return getSqlSession().insert("setFairJoinMng.insertFairPatcptnCompny", param);
	}

	public List<FairMngBean> selectInsttInvitationList(FairMngBean param){
		return getSqlSession().selectList("fairJoinMng.selectInsttInvitationList", param);
	}

	public int insertFairPatcptnInstt(FairMngBean param) {
		return getSqlSession().insert("setFairJoinMng.insertFairPatcptnInstt", param);
	}

}
