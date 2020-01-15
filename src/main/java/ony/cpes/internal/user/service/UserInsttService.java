package ony.cpes.internal.user.service;

import ony.cpes.internal.user.bean.UserInsttBean;
import ony.cpes.internal.user.bean.UserInsttEduBean;
import ony.cpes.internal.user.bean.UserInsttFairBean;

public interface UserInsttService {
	
	/**
     * Institution User List
     *
     * @param UserInsttBean
     * @return UserInsttBean
     */
    public UserInsttBean selectUserInsttInfoListAjax(UserInsttBean param) throws Exception;
    
	/**
     * Delete Institution User Info
     *
     * @param UserInsttBean
     * @return UserInsttBean
     */
    public UserInsttBean deleteUserInsttInfoAjax(UserInsttBean param) throws Exception;    
    
	/**
     * Institution User Detail Info Main
     *
     * @param UserInsttBean
     * @return UserInsttBean
     */
    public UserInsttBean selectUserInsttDtlInfoMain(UserInsttBean param) throws Exception;   

	/**
     * Institution User Detail Info Base
     *
     * @param UserInsttBean
     * @return UserInsttBean
     */
    public UserInsttBean selectUserInsttDtlInfoBaseAjax(UserInsttBean param) throws Exception;  

	/**
     * Institution Detail Info Profile
     *
     * @param UserInsttBean
     * @return UserInsttBean
     */
    public UserInsttBean selectUserInsttDtlInfoProfile(UserInsttBean param) throws Exception;
    
	/**
     * Institution Detail Info Image
     *
     * @param UserInsttBean
     * @return UserInsttBean
     */
    public UserInsttBean selectUserInsttDtlInfoImg(UserInsttBean param) throws Exception; 
    
    /**
     * Institution Detail Info Education Training
     *
     * @param UserInsttEduBean
     * @return UserInsttEduBean
     */
    public UserInsttEduBean selectUserInsttDtlInfoEduList(UserInsttEduBean param) throws Exception;
        
    /**
     * Institution Detail Info Education Training
     *
     * @param UserInsttFairBean
     * @return UserInsttFairBean
     */
    public UserInsttFairBean selectUserInsttDtlInfoJobfairList(UserInsttFairBean param) throws Exception;
      
}
