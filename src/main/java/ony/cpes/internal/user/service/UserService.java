package ony.cpes.internal.user.service;

import javax.servlet.http.HttpServletRequest;

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

public interface UserService {
	/**
     * User List (Ajax)
     *
     * @param NeaUserBean
     * @return UserBean
     */
    public UserBean selectUserInfoListAjax(UserBean param) throws Exception;
    
	/**
     * Process User Status
     *
     * @param NeaUserBean
     * @return UserBean
     */
    public UserBean updateUserStsAjax(UserBean param) throws Exception; 
    
	/**
     * Delete User Info
     *
     * @param NeaUserBean
     * @return UserBean
     */
    public UserBean deleteUserInfoAjax(UserBean param) throws Exception;    
    
	/**
     * User Detail Info Main
     *
     * @param NeaUserBean
     * @return UserBean
     */
    public UserBean selectUserDtlInfoMain(UserBean param) throws Exception;   
    
	/**
     * User Detail Base info
     *
     * @param NeaUserBean
     * @return UserBean
     */
    public UserBean selectUserDtlInfoBaseAjax(UserBean param) throws Exception;      

	/**
     * Resume Human Info
     * @param UserResumeBean
     * @return UserResumeBean
     */
    public UserResumeBean selectResumeHumanInfoAjax(UserResumeBean param) throws Exception; 
    
	/**
     * Disable Option Code
     *
     * @param UserResumeBean
     * @return UserResumeBean
     */
    public UserResumeBean selectDisableOptNm(UserResumeBean param) throws Exception; 
    
	/**
     * ISCO List
     *
     * @param UserResumeIscoBean
     * @return UserResumeIscoBean
     */
    public UserResumeIscoBean selectIscoList(UserResumeIscoBean param) throws Exception;  
    
	/**
     * Prefer Work Loc List
     *
     * @param UserResumeLocBean
     * @return UserResumeLocBean
     */
    public UserResumeLocBean selectPreferWorkLocList(UserResumeLocBean param) throws Exception;      

	/**
     * Resume Special Education Info
     *
     * @param UserResumeSpcEduBean
     * @return UserResumeSpcEduBean
     */
    public UserResumeSpcEduBean selectResumeSpcEduInfoAjax(UserResumeSpcEduBean param) throws Exception; 

    /**
     * Resume Other Training Info
     *
     * @param UserResumeOtrTrnngBean
     * @return UserResumeOtrTrnngBean
     */
    public UserResumeOtrTrnngBean selectResumeOtrTrngInfoAjax(UserResumeOtrTrnngBean param) throws Exception; 
    
	/**
     * Resume Language Info
     *
     * @param UserResumeLangBean
     * @return UserResumeLangBean
     */
    public UserResumeLangBean selectResumeLangInfoAjax(UserResumeLangBean param) throws Exception; 
    
	/**
     * Resume Work Exp Info
     *
     * @param UserResumeWorkExpBean
     * @return UserResumeWorkExpBean
     */
    public UserResumeWorkExpBean selectResumeWorkExpInfoAjax(UserResumeWorkExpBean param) throws Exception; 
    
	/**
     * Resume Skill Info Title
     *
     * @param UserResumeSkillBean
     * @return UserResumeSkillBean
     */
    public UserResumeSkillBean selectResumeSkillInfoAjax(UserResumeSkillBean param) throws Exception; 
    
	/**
     * Resume Skill Info Dtl
     *
     * @param UserResumeSkillBean
     * @return UserResumeSkillBean
     */
    public UserResumeSkillBean selectResumeSkillInfoDtlAjax(UserResumeSkillBean param) throws Exception;   
    
	/**
     * Resume Refman Info
     *
     * @param UserResumeRefmanBean
     * @return UserResumeRefmanBean
     */
    public UserResumeRefmanBean selectResumeRefmanInfoAjax(UserResumeRefmanBean param) throws Exception;      
    
	/**
     * User Detail Info Job Seek
     *
     * @param UserJobskBean
     * @return UserJobskBean
     */
    public UserJobskBean selectUserDtlInfoJobskAjax(UserJobskBean param) throws Exception; 

    /**
     * regist user information
     * @param param
     * @return
     * @throws Exception
     */
    public UserBean insertUserDtlInfo(HttpServletRequest request, UserBean param) throws Exception;
    
	/**
     * User Company Application List
     *
     * @param UserAplcBean
     * @return UserAplcBean
     */
    public UserAplcBean selectUserDtlInfoAplcList(UserAplcBean param) throws Exception;    

	/**
     * User Company Offer List
     *
     * @param UserOfferBean
     * @return UserOfferBean
     */
    public UserOfferBean selectUserDtlInfoOfferList(UserOfferBean param) throws Exception; 
    
	/**
     * User Company Interview List
     *
     * @param UserIntvwBean
     * @return UserIntvwBean
     */
    public UserIntvwBean selectUserDtlInfoIntvwList(UserIntvwBean param) throws Exception;    

	/**
     * User Company Referral List
     *
     * @param UserReferralBean
     * @return UserReferralBean
     */
    public UserReferralBean selectUserDtlInfoReferralList(UserReferralBean param) throws Exception;  

	/**
     * User Job Fair List
     *
     * @param UserFairBean
     * @return UserFairBean
     */
    public UserFairBean selectUserDtlInfoFairList(UserFairBean param) throws Exception;  

    public UserBean selectUserEmailDupl(HttpServletRequest request, UserBean param) throws Exception;
    
    public UserBean selectUserCellDupl(HttpServletRequest request, UserBean param) throws Exception;
    
    
    /**
     * modify user info.
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    public UserBean updateUserDetailInfo(HttpServletRequest request, UserBean param) throws Exception;
    
    
    /**
     * User Detail Info Detail
     *
     * @param NeaUserBean
     * @return UserBean
     */
    public UserBean selectUserDtlInfo(HttpServletRequest request, UserBean param) throws Exception;
    
    /**
     * Initialize Password
     * @param param
     * @return
     * @throws Exception
     */
    public UserBean updateUserPassword(HttpServletRequest request, UserBean param) throws Exception;
}
