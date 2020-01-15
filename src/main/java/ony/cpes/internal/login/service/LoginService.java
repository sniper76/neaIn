package ony.cpes.internal.login.service;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.user.bean.UserBean;

public interface LoginService {
	
	/**
     * search user email (user id)
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public UserBean selectSearchId(HttpServletRequest request, UserBean param) throws Exception;
    
    /**
     * search User Password
     * @param param
     * @return
     * @throws Exception
     */
    public UserBean selectSearchPwd(HttpServletRequest request, UserBean param) throws Exception;
    
    /**
     * 
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    public UserBean updateAuthPwd(HttpServletRequest request, UserBean param) throws Exception;
    
    /**
     * 
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    public UserBean updateOverDuraPwd(HttpServletRequest request, UserBean param) throws Exception;
    
    /**
     * 
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    public UserBean updateLogin(HttpServletRequest request, UserBean param) throws Exception;
    
    /**
     * 
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    public UserBean updateLoginFail(HttpServletRequest request, UserBean param) throws Exception;
    
}
