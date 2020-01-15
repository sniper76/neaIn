package ony.cpes.internal.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.MenuProgramMapBean;
import ony.cpes.internal.common.bean.UserMenuBean;


@Repository("MenuDAO")
public class MenuDAO extends EgovAbstractMapper{
    

	/**
	 * @param MenuBean
	 * @return List<MenuBean>
	 */
	public List<MenuBean> selectUserMenuList(UserMenuBean paramObj) throws Exception {
        return getSqlSession().selectList("menu.selectUserMenuList", paramObj);
    }

	/**
	 * @param MenuBean
	 * @return List<MenuBean>
	 */
	public List<MenuBean> selectMenuMngList(MenuBean paramObj) throws Exception {
        return getSqlSession().selectList("menu.selectMenuMngList", paramObj);
    }
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public int selectMenuMngListTotalCount(MenuBean paramObj) throws Exception {
        return getSqlSession().selectOne("menu.selectMenuMngListTotalCount", paramObj);
    }
	
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public int insertMenuMng(MenuBean paramObj) throws Exception {
        return getSqlSession().insert("setMenu.insertMenuMng", paramObj);
    }
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public int updateMenuMng(MenuBean paramObj) throws Exception {
        return getSqlSession().update("setMenu.updateMenuMng", paramObj);
    }

	/**
	 * @param MenuBean
	 * @return int
	 */
	public int deleteMenuMng(MenuBean paramObj) throws Exception {
        return getSqlSession().delete("setMenu.deleteMenuMng", paramObj);
    }
	
	public List<MenuBean> selectCurrentLvlMenuMngList(MenuBean paramObj) throws Exception {
        return getSqlSession().selectList("menu.selectCurrentLvlMenuMngList", paramObj);
    }
	
	public MenuBean selectMenuMngDetail(MenuBean paramObj) throws Exception {
        return getSqlSession().selectOne("menu.selectMenuMngDetail", paramObj);
    }
	
	public String selectMenuCd(MenuBean paramObj) throws Exception {
        return getSqlSession().selectOne("menu.selectMenuCd", paramObj);
    }
	
	public int insertMenuProgramMap(MenuProgramMapBean paramObj) throws Exception {
        return getSqlSession().insert("setMenu.insertMenuProgramMap", paramObj);
    }
	
	public int deleteMenuProgramMap(MenuBean paramObj) throws Exception {
        return getSqlSession().delete("setMenu.deleteMenuProgramMap", paramObj);
    }
	
	public int updateMenuProgramMap(MenuProgramMapBean paramObj) throws Exception {
        return getSqlSession().delete("setMenu.updateMenuProgramMap", paramObj);
    }
	
	public List<MenuProgramMapBean> selectMenuProgramMapList(MenuBean paramObj) throws Exception {
        return getSqlSession().selectList("menu.selectMenuProgramMapList", paramObj);
    }
	
	
	public List<MenuProgramMapBean> selectMenuInfoByProgram(UserMenuBean paramObj) throws Exception {
        return getSqlSession().selectList("menu.selectMenuInfoByProgram", paramObj);
    }
	
}

