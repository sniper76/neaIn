package ony.cpes.internal.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.MenuProgramMapBean;
import ony.cpes.internal.common.bean.UserMenuBean;



public interface MenuService {
    

	/**
	 * inquiry of job_center info
	 * @param username
	 * @return
	 */
	public List<MenuBean> selectUserMenuList(UserMenuBean param) throws Exception ;
	
	
	/**
	 * inquiry of menu list
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public MenuBean selectMenuMngList(MenuBean param) throws Exception;
	
	/**
	 * insert menu
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public MenuBean insertMenuMng(HttpServletRequest request, MenuBean param) throws Exception;
	
	/**
	 * update menu
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public MenuBean updateMenuMng(HttpServletRequest request, MenuBean param) throws Exception;
	
	/**
	 * delete menu
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public MenuBean deleteMenuMng(HttpServletRequest request, MenuBean param) throws Exception;

	/**
	 * 
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public MenuBean selectMenuMngDetail(MenuBean paramObj) throws Exception;
	
	/**
	 * 
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public MenuBean selectCurrentLvlMenuMngList(HttpServletRequest request, MenuBean paramObj) throws Exception ;
	
	/**
	 * 
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public List<MenuProgramMapBean> selectMenuInfoByProgram(UserMenuBean paramObj) throws Exception;
}