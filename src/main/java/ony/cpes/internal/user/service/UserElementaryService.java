package ony.cpes.internal.user.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.counsel.bean.CounselBean;
import ony.cpes.internal.user.bean.UserElementaryBean;
import ony.cpes.internal.user.bean.UserElementaryIntvwBean;

public interface UserElementaryService {

	/**
     * User List Using Elementary Job Seeker
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
     */
    public UserElementaryBean selectUserElementaryInfoList(UserElementaryBean param, HttpServletRequest request) throws Exception;

	/**
     * Registration User Info By Excel
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
	*/
    //public UserElementaryBean insertUserElementaryRegUserInfoByExcel(UserElementaryBean param) throws Exception;
    public UserElementaryBean insertUserElementaryRegUserInfoByExcel(List<Map<String, Object>> param, Locale locale, HttpServletRequest request) throws Exception;
    
	/**
     * User Detail Info Main Using Elementary Job Seeker
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
     */
    public UserElementaryBean selectUserElementaryDtlInfoMain(UserElementaryBean param) throws Exception;

	/**
     * User Detail Info Base Using Elementary Job Seeker
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
     */
    public UserElementaryBean selectUserElementaryDtlInfoBase(UserElementaryBean param) throws Exception;

	/**
     * Delete User Detail Info
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
	*/
    public UserElementaryBean deleteUserElementaryInfo(UserElementaryBean param) throws Exception;

	/**
     * Update User Detail Info
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
	*/
    public UserElementaryBean updateUserElementaryDtlInfo(UserElementaryBean param) throws Exception;

	/**
	 * Registration User Base Info
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	public UserElementaryBean selectUserElementaryRegBaseInfo(UserElementaryBean param) throws Exception;

	/**
     * Check User Cell Duplication
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
     */
    public UserElementaryBean selectUserCellDuplicationCheck(UserElementaryBean param) throws Exception;

	/**
	 * Job Center Code by Address Code
	 * @param UserElementaryBean
	 * @return
	 */
	public UserElementaryBean selectJobCenterCdByAddrCd(UserElementaryBean param) throws Exception;

	/**
     * Registration User Detail Info
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
	*/
    public UserElementaryBean insertUserElementaryInfo(UserElementaryBean param) throws Exception;
    
	/**
     * Change User Type
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
	*/
    public UserElementaryBean selectUserElementaryDtlInfoUserTypeChg(UserElementaryBean param) throws Exception;    

	/**
	 * Update User Type
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	public UserElementaryBean insertUserElementaryDtlInfoUserTypeChg(UserElementaryBean param) throws Exception;

	/**
     * User Detail Info Interview History List
     *
     * @param UserElementaryIntvwBean
     * @return UserElementaryIntvwBean
     */
    public UserElementaryIntvwBean selectUserElementaryDtlInfoIntvwList(UserElementaryIntvwBean param) throws Exception;

	/**
	 * Registration User Detail Info Interview History
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
    public UserElementaryIntvwBean insertUserElementaryDtlInfoIntvw(UserElementaryIntvwBean param) throws Exception;

	/**
	 * User Interview Detail Info for Modify
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	public UserElementaryIntvwBean selectUserElementaryDtlInfoIntvwModify(UserElementaryIntvwBean param) throws Exception;

	/**
	 * Update User Detail Info Interview History
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	public UserElementaryIntvwBean updateUserElementaryDtlInfoIntvwModify(UserElementaryIntvwBean param) throws Exception;
	
	public UserElementaryBean selectelementaryUserInfo(CounselBean param) throws Exception;
	
	public CounselBean selectCounselUserInfo(CounselBean param) throws Exception;
	
	public Map<String,Object> insertElemtryCounsel(HttpServletRequest request,CounselBean param) throws Exception;

}
