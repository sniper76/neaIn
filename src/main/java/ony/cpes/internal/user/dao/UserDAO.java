package ony.cpes.internal.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.user.bean.UserAplcBean;
import ony.cpes.internal.user.bean.UserOfferBean;
import ony.cpes.internal.user.bean.UserIntvwBean;
import ony.cpes.internal.user.bean.UserReferralBean;
import ony.cpes.internal.user.bean.UserFairBean;
import ony.cpes.internal.user.bean.UserJobskBean;

import ony.cpes.internal.user.bean.UserResumeBean;
import ony.cpes.internal.user.bean.UserResumeIscoBean;
import ony.cpes.internal.user.bean.UserResumeLocBean;
import ony.cpes.internal.user.bean.UserResumeSpcEduBean;
import ony.cpes.internal.user.bean.UserResumeOtrTrnngBean;
import ony.cpes.internal.user.bean.UserResumeLangBean;
import ony.cpes.internal.user.bean.UserResumeWorkExpBean;
import ony.cpes.internal.user.bean.UserResumeSkillBean;
import ony.cpes.internal.user.bean.UserResumeRefmanBean;


@Repository("userDAO")
public class UserDAO extends EgovAbstractMapper{
	
	/*
	 * User List
	 */
	public List<UserBean> selectUserInfoListAjax(UserBean param) {
        return getSqlSession().selectList("user.selectUserInfoListAjax", param);
    }
	
	public int selectUserInfoListTotalCnt(UserBean param) {
        return getSqlSession().selectOne("user.selectUserInfoListTotalCnt", param);
	}	
	
	public int updateUserStsAjax(UserBean param) {
        return getSqlSession().update("setUser.updateUserStsAjax", param);
	}
	
	public int deleteUserInfoAjax(UserBean param) {
        return getSqlSession().update("setUser.deleteUserInfoAjax", param);
	}	

	/*
	 * User Detail Info Main
	 */
	public UserBean selectUserDtlInfoMain(UserBean param) {
        return getSqlSession().selectOne("user.selectUserDtlInfoMain", param);
    }
	
	/*
	 * User Detail Info Base
	 */
	public UserBean selectUserDtlInfoBaseAjax(UserBean param) {
        return getSqlSession().selectOne("user.selectUserDtlInfoBaseAjax", param);
    }
	
	/*
	 * Resume Human info
	 */
	public UserResumeBean selectResumeHumanInfoAjax(UserResumeBean param) {
        return getSqlSession().selectOne("user.selectResumeHumanInfoAjax", param);
    }
	
	/*
	 * Disable Option Code
	 */
	public UserResumeBean selectDisableOptNm(UserResumeBean param) {
        return getSqlSession().selectOne("user.selectDisableOptNm", param);
    }
	
	/*
	 * Resume ISCO Info
	 */
	public List<UserResumeIscoBean> selectIscoList(UserResumeIscoBean param) {
        return getSqlSession().selectList("user.selectIscoList", param);
    }
	
	/*
	 * Resume Prefer Work Loc
	 */
	public List<UserResumeLocBean> selectPreferWorkLocList(UserResumeLocBean param) {
        return getSqlSession().selectList("user.selectPreferWorkLocList", param);
    }
	
	/*
	 * Resume Special Education info
	 */
	public List<UserResumeSpcEduBean> selectResumeSpcEduInfoAjax(UserResumeSpcEduBean param) {
        return getSqlSession().selectList("user.selectResumeSpcEduInfoAjax", param);
    }	

	/*
	 * Resume Other Training info
	 */
	public List<UserResumeOtrTrnngBean> selectResumeOtrTrngInfoAjax(UserResumeOtrTrnngBean param) {
        return getSqlSession().selectList("user.selectResumeOtrTrngInfoAjax", param);
    }
	
	/*
	 * Resume Language info
	 */
	public List<UserResumeLangBean> selectResumeLangInfoAjax(UserResumeLangBean param) {
        return getSqlSession().selectList("user.selectResumeLangInfoAjax", param);
    }	
	
	/*
	 * Resume Work Exp info
	 */
	public List<UserResumeWorkExpBean> selectResumeWorkExpInfoAjax(UserResumeWorkExpBean param) {
        return getSqlSession().selectList("user.selectResumeWorkExpInfoAjax", param);
    }
	
	/*
	 * Resume Skill info Title
	 */
	public List<UserResumeSkillBean> selectResumeSkillInfoAjax(UserResumeSkillBean param) {
        return getSqlSession().selectList("user.selectResumeSkillInfoAjax", param);
    }	
		
	/*
	 * Resume Skill info Dtl
	 */
	public List<UserResumeSkillBean> selectResumeSkillInfoDtlAjax(UserResumeSkillBean param) {
        return getSqlSession().selectList("user.selectResumeSkillInfoDtlAjax", param);
    }
	
	/*
	 * Resume Refman Info
	 */
	public List<UserResumeRefmanBean> selectResumeRefmanInfoAjax(UserResumeRefmanBean param) {
        return getSqlSession().selectList("user.selectResumeRefmanInfoAjax", param);
    }	
	
	/*
	 * User Detail Info Job Seek
	 */
	public List<UserJobskBean> selectUserDtlInfoJobskAjax(UserJobskBean param) {
        return getSqlSession().selectList("user.selectUserDtlInfoJobskAjax", param);
    }	
	
	public int selectUserDtlInfoJobskTotalCnt(UserJobskBean param) {
        return getSqlSession().selectOne("user.selectUserDtlInfoJobskTotalCnt", param);
	}	
	
	/**
	 * regist user information
	 * @param param
	 * @return
	 */
	public int insertUserDtlInfo(UserBean param) {
        return getSqlSession().insert("setUser.insertUserDtlInfo", param);
    }
	
	/**
	 * check dupl
	 * @param param
	 * @return
	 */
	public int selectUserDuplAjax(UserBean param) {
        return getSqlSession().selectOne("user.selectUserDuplAjax", param);
    }
	
	/*
	 * User Company Application List
	 */
	public List<UserAplcBean> selectUserDtlInfoAplcList(UserAplcBean param) {
        return getSqlSession().selectList("user.selectUserDtlInfoAplcList", param);
    }
	
	public int selectUserDtlInfoAplcListTotalCnt(UserAplcBean param) {
        return getSqlSession().selectOne("user.selectUserDtlInfoAplcListTotalCnt", param);
	}	
	
	/*
	 * User Company Offer List
	 */
	public List<UserOfferBean> selectUserDtlInfoOfferList(UserOfferBean param) {
        return getSqlSession().selectList("user.selectUserDtlInfoOfferList", param);
    }
	
	public int selectUserDtlInfoOfferListTotalCnt(UserOfferBean param) {
        return getSqlSession().selectOne("user.selectUserDtlInfoOfferListTotalCnt", param);
	}
	
	/*
	 * User Company Interview List
	 */
	public List<UserIntvwBean> selectUserDtlInfoIntvwList(UserIntvwBean param) {
        return getSqlSession().selectList("user.selectUserDtlInfoIntvwList", param);
    }
	
	public int selectUserDtlInfoIntvwListTotalCnt(UserIntvwBean param) {
        return getSqlSession().selectOne("user.selectUserDtlInfoIntvwListTotalCnt", param);
	}
	
	/*
	 * User Company referral List
	 */
	public List<UserReferralBean> selectUserDtlInfoReferralList(UserReferralBean param) {
        return getSqlSession().selectList("user.selectUserDtlInfoReferralList", param);
    }
	
	public int selectUserDtlInfoReferralListTotalCnt(UserReferralBean param) {
        return getSqlSession().selectOne("user.selectUserDtlInfoReferralListTotalCnt", param);
	}	
	
	/*
	 * User Job Fair List
	 */
	public List<UserFairBean> selectUserDtlInfoFairList(UserFairBean param) {
        return getSqlSession().selectList("user.selectUserDtlInfoFairList", param);
    }
	
	public int selectUserDtlInfoFairListTotalCnt(UserFairBean param) {
        return getSqlSession().selectOne("user.selectUserDtlInfoFairListTotalCnt", param);
	}		
	
	public int updateUserDetailInfo(UserBean param) {
        return getSqlSession().selectOne("setUser.updateUserDetailInfo", param);
	}
	
	public UserBean selectUserDtlInfo(UserBean param) {
        return getSqlSession().selectOne("user.selectUserDtlInfo", param);
	}
	
	public int updateUserPassword(UserBean param) {
        return getSqlSession().update("setUser.updateUserPassword", param);
	}
	
}
