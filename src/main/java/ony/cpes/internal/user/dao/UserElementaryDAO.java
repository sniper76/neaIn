package ony.cpes.internal.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.counsel.bean.CounselBean;
import ony.cpes.internal.user.bean.UserElementaryBean;
import ony.cpes.internal.user.bean.UserElementaryIntvwBean;

@Repository("userElementaryDAO")
public class UserElementaryDAO extends EgovAbstractMapper{
	
	/**
	 * User List Using Elementary Job Seeker
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	public List<UserElementaryBean> selectUserElementaryInfoList(UserElementaryBean param) {
        return getSqlSession().selectList("userElementary.selectUserElementaryInfoList", param);
    }
	
	public int selectUserElementaryInfoListTotalCnt(UserElementaryBean param) {
        return getSqlSession().selectOne("userElementary.selectUserElementaryInfoListTotalCnt", param);
	}	

	/**
	 * User Detail Info Main Using Elementary Job Seeker
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	public UserElementaryBean selectUserElementaryDtlInfoMain(UserElementaryBean param) {
        return getSqlSession().selectOne("userElementary.selectUserElementaryDtlInfoMain", param);
    }
	
	/**
	 * User Detail Info Base Using Elementary Job Seeker
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	public UserElementaryBean selectUserElementaryDtlInfoBase(UserElementaryBean param) {
        return getSqlSession().selectOne("userElementary.selectUserElementaryDtlInfoBase", param);
    }
	
	/**
	 * Delete User Detail Info
	 * @param UserElementaryBean
	 * @return
	 */
	public int deleteUserElementryInfo(UserElementaryBean param) {
        return getSqlSession().update("setUserElementary.deleteUserElementaryInfo", param);
	}
	
	/**
	 * Update User Detail Info
	 * @param UserElementaryBean
	 * @return
	 */
	public int updateUserElementaryDtlInfo(UserElementaryBean param) {
        return getSqlSession().update("setUserElementary.updateUserElementaryDtlInfo", param);
	}

	/**
	 * Registration User Base Info
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	public UserElementaryBean selectUserElementaryRegBaseInfo(UserElementaryBean param) {
        return getSqlSession().selectOne("userElementary.selectUserElementaryRegBaseInfo", param);
    }

	/**
	 * Check User Cell Duplication
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	public UserElementaryBean selectUserCellDuplicationCheck(UserElementaryBean param) {
        return getSqlSession().selectOne("userElementary.selectUserCellDuplicationCheck", param);
    }

	/**
	 * Job Center Code by Address Code
	 * @param UserElementaryBean
	 * @return
	 */
	public UserElementaryBean selectJobCenterCdByAddrCd(UserElementaryBean param) {
        return getSqlSession().selectOne("userElementary.selectJobCenterCdByAddrCd", param);
    }
	
	/**
	 * Registration User Detail Info
	 * @param UserElementaryBean
	 * @return
	 */
	public int insertUserElementaryInfo(UserElementaryBean param) {
        return getSqlSession().update("setUserElementary.insertUserElementaryInfo", param);
	}
	
	/**
	 * Change User Type
	 * @param UserElementaryBean
	 * @return
	 */
	public UserElementaryBean selectUserElementaryDtlInfoUserTypeChg(UserElementaryBean param) {
        return getSqlSession().selectOne("userElementary.selectUserElementaryDtlInfoUserTypeChg", param);
    }
	
	/**
	 * Update User Type
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	public int insertUserElementaryDtlInfoUserTypeChg(UserElementaryBean param) {
        return getSqlSession().update("setUserElementary.insertUserElementaryDtlInfoUserTypeChg", param);
	}	
	
	/**
	 * User Detail Info Interview History List 
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	public List<UserElementaryIntvwBean> selectUserElementaryDtlInfoIntvwList(UserElementaryIntvwBean param) {
        return getSqlSession().selectList("userElementary.selectUserElementaryDtlInfoIntvwList", param);
    }
	
	public int selectUserElementaryDtlInfoIntvwListTotalCnt(UserElementaryIntvwBean param) {
        return getSqlSession().selectOne("userElementary.selectUserElementaryDtlInfoIntvwListTotalCnt", param);
	}
	

	/**
	 * Get ResumeSeq Of User
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	public UserElementaryIntvwBean selectResumeSeqUsingByUserSeq(UserElementaryIntvwBean param) {
        return getSqlSession().selectOne("userElementary.selectResumeSeqUsingByUserSeq", param);
    }
	
	
	/**
	 * Registration User Detail Info Interview History
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	public int insertUserElementaryDtlInfoIntvwHis(UserElementaryIntvwBean param) {
        return getSqlSession().update("setUserElementary.insertUserElementaryDtlInfoIntvwHis", param);
	}	
	
	/**
	 * User Interview Detail Info for Modify
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	public UserElementaryIntvwBean selectUserElementaryDtlInfoIntvwModify(UserElementaryIntvwBean param) {
        return getSqlSession().selectOne("userElementary.selectUserElementaryDtlInfoIntvwModify", param);
    }
	
	/**
	 * Update User Detail Info Interview History
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	public int updateUserElementaryDtlInfoIntvwModify(UserElementaryIntvwBean param) {
        return getSqlSession().update("setUserElementary.updateUserElementaryDtlInfoIntvwModify", param);
	}		
	
	
	public UserElementaryBean selectelementaryUserInfo(CounselBean param) {
        return getSqlSession().selectOne("userElementary.selectelementaryUserInfo", param);
    }
	
	public CounselBean selectCounselUserInfo(CounselBean param) {
        return getSqlSession().selectOne("userElementary.selectCounselUserInfo", param);
    }
	
	public int insertElemtryCounsel(CounselBean param) {
        return getSqlSession().update("setUserElementary.insertElemtryCounsel", param);
	}
	
	public String selectSeq(CounselBean param) {
        return getSqlSession().selectOne("userElementary.selectSeq", param);
    }
	
}
