package ony.cpes.internal.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.MenuProgramMapBean;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.common.bean.UserProgramBean;
import ony.cpes.internal.user.bean.UserBean;


@Repository("MngerMngDAO")
public class MngerMngDAO extends EgovAbstractMapper{
    
	/**
	 * @param MenuBean
	 * @return List<MenuBean>
	 */
	public UserBean selectMngerJcDetailInfo(UserBean param) throws Exception {
        return getSqlSession().selectOne("mngerMng.selectMngerJcDetailInfo", param);
    }
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public List<MenuBean> selectMenuMngList(MenuBean paramObj) throws Exception {
        return getSqlSession().selectList("mngerMng.selectMenuMngList", paramObj);
    }
	
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public List<MenuProgramMapBean> selectProgramMng(MenuProgramMapBean paramObj) throws Exception {
        return getSqlSession().selectList("mngerMng.selectProgramMng", paramObj);
    }
	
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public List<MenuProgramMapBean> selectProgramAuth(MenuProgramMapBean paramObj) throws Exception {
        return getSqlSession().selectList("mngerMng.selectProgramAuth", paramObj);
    }
	
	/**
	 * 
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int insertUserProgram(UserProgramBean paramObj) throws Exception {
        return getSqlSession().insert("setMngerMng.insertUserProgram", paramObj);
    }
	
	/**
	 * 
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int insertUserMenu(UserMenuBean paramObj) throws Exception {
        return getSqlSession().insert("setMngerMng.insertUserMenu", paramObj);
    }
	
	/**
	 * 
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int deleteUserMenu(UserMenuBean paramObj) throws Exception {
        return getSqlSession().delete("setMngerMng.deleteUserMenu", paramObj);
    }
	
	/**
	 * 
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int deleteUserProgram(UserMenuBean paramObj) throws Exception {
        return getSqlSession().delete("setMngerMng.deleteUserProgram", paramObj);
    }
}
