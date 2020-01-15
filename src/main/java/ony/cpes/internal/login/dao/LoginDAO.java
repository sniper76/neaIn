package ony.cpes.internal.login.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.CustomUserDetailsBean;
import ony.cmm.common.bean.CustomUserMenuInfoBean;
import ony.cpes.internal.user.bean.UserBean;


@Repository("LoginDAO")
public class LoginDAO extends EgovAbstractMapper{
    

	/**
	 * 사용자 정보 조회
	 * @param username
	 * @return
	 */
	public CustomUserDetailsBean selectUserById(String userEmail) {
        return getSqlSession().selectOne("login.selectUserById", userEmail);
    }
	
	/**
	 * 사용자 메뉴 권한 목록 조회
	 * @param userName
	 * @return
	 */
	public List<CustomUserMenuInfoBean> selectMenuAuthByUser(String userName) {
        return getSqlSession().selectList("login.selectMenuAuthByUser", userName);
    }
	
	/**
	 * search User Id password - inquiry Mng Id
	 * @param username
	 * @return
	 */
	public UserBean selectSearchIdPwd(UserBean param) {
        return getSqlSession().selectOne("login.selectSearchIdPwd", param);
    }
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public int updateEmailUserAuthValue(UserBean param) {
        return getSqlSession().update("setLogin.updateEmailUserAuthValue", param);
    }
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public int updateUserPwd(UserBean param) {
        return getSqlSession().update("setLogin.updateUserPwd", param);
    }
	
	public int updateLogin(UserBean param) {
        return getSqlSession().update("setLogin.updateLogin", param);
    }
	
	public int updateLoginFail(UserBean param) {
        return getSqlSession().update("setLogin.updateLoginFail", param);
    }
	
}
