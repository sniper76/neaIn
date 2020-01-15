package ony.cpes.internal.user.service;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ony.cpes.internal.user.bean.UserChgBean;

public interface UserChgService {
	
	/**
	 * UserChange List
	 * @param UserBean
	 * @return UserBean
	 */
	public UserChgBean selectUserChgList(UserChgBean param) throws Exception;

	/**
	 * UserChange Detail List
	 * @param UserBean
	 * @return UserBean
	 */
	public UserChgBean selectUserChgDetail(UserChgBean param) throws Exception;
	
	/**
	 * change status for user 
	 * @param param
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public UserChgBean updateUserChgSts(HttpServletRequest request, UserChgBean param, Locale locale) throws Exception;
}
