package ony.cpes.internal.user.service;

import ony.cpes.internal.user.bean.UserCmpnyBean;
import ony.cpes.internal.user.bean.UserCmpnyIsicBean;
import ony.cpes.internal.user.bean.UserCmpnyCommonBean;
import ony.cpes.internal.user.bean.UserCmpnyVccyBean;
import ony.cpes.internal.user.bean.UserCmpnyAplcBean;
import ony.cpes.internal.user.bean.UserCmpnyOfferBean;
import ony.cpes.internal.user.bean.UserCmpnyIntvwBean;
import ony.cpes.internal.user.bean.UserCmpnyFairBean;

public interface UserCmpnyService {
	
	/**
     * Company User List
     *
     * @param UserCmpnyBean
     * @return UserCmpnyBean
     */
    public UserCmpnyBean selectUserCmpnyInfoListAjax(UserCmpnyBean param) throws Exception;

	/**
     * ISIC (SECTOR) CODE LIST
     *
     * @param UserCmpnyIsicBean
     * @return UserCmpnyIsicBean
     */
    public UserCmpnyIsicBean selectIsicCdList(UserCmpnyIsicBean param) throws Exception;

    
	/**
     * Delete Company User Info
     *
     * @param UserCmpnyBean
     * @return UserCmpnyBean
     */
    public UserCmpnyBean deleteUserCmpnyInfoAjax(UserCmpnyBean param) throws Exception;    
    
	/**
     * User Company Detail Info Main
     *
     * @param UserCmpnyBean
     * @return UserCmpnyBean
     */
    public UserCmpnyBean selectUserCmpnyDtlInfoMain(UserCmpnyBean param) throws Exception;
    
	/**
     * User Company Detail Info Base
     *
     * @param UserCmpnyBean
     * @return UserCmpnyBean
     */
    public UserCmpnyBean selectUserCmpnyDtlInfoBaseAjax(UserCmpnyBean param) throws Exception; 
    
	/**
     * User Company Detail Info Profile
     *
     * @param UserCmpnyBean
     * @return UserCmpnyBean
     */
    public UserCmpnyBean selectUserCmpnyDtlInfoProfileAjax(UserCmpnyBean param) throws Exception;
    
	/**
     * User Company Detail Info History
     *
     * @param UserCmpnyBean
     * @return UserCmpnyBean
    public UserCmpnyBean selectUserCmpnyDtlInfoHisAjax(UserCmpnyBean param) throws Exception;
     */
    
	/**
     * User Company Detail Info Image
     *
     * @param UserCmpnyBean
     * @return UserCmpnyBean
     */
    public UserCmpnyBean selectUserCmpnyDtlInfoImgAjax(UserCmpnyBean param) throws Exception; 
    
	/**
     * Company Company Vacancy List
     *
     * @param UserCmpnyVccyBean
     * @return UserCmpnyVccyBean
     */
    public UserCmpnyVccyBean selectUserCmpnyDtlInfoVccyList(UserCmpnyVccyBean param) throws Exception;    

	/**
     * User Company Common Vacancy List
     *
     * @param UserCmpnyCommonBean
     * @return UserCmpnyCommonBean
     */
    public UserCmpnyCommonBean selectUserCmpnyCommonVccyList(UserCmpnyCommonBean param) throws Exception;

    /**
     * User Company Application List
     *
     * @param UserCmpnyAplcBean
     * @return UserCmpnyAplcBean
     */
    public UserCmpnyAplcBean selectUserCmpnyDtlInfoAplcList(UserCmpnyAplcBean param) throws Exception;

    /**
     * User Company Offer List
     *
     * @param UserCmpnyOfferBean
     * @return UserCmpnyOfferBean
     */
    public UserCmpnyOfferBean selectUserCmpnyDtlInfoOfferList(UserCmpnyOfferBean param) throws Exception;

    /**
     * User Company Interview List
     *
     * @param UserCmpnyIntvwBean
     * @return UserCmpnyIntvwBean
     */
    public UserCmpnyIntvwBean selectUserCmpnyDtlInfoIntvwList(UserCmpnyIntvwBean param) throws Exception;

    /**
     * User Company Job Fair List
     *
     * @param UserCmpnyFairBean
     * @return UserCmpnyFairBean
     */
    public UserCmpnyFairBean selectUserCmpnyDtlInfoJobfairList(UserCmpnyFairBean param) throws Exception;
    
}
