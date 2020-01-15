package ony.cpes.internal.common.service;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.user.bean.UserBean;



public interface MngerMngService {
    
	/**
	 * @param MenuBean
	 * @return List<MenuBean>
	 */
	public UserBean selectMngerJcDetailInfo(HttpServletRequest request,UserBean param) throws Exception;
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public MenuBean selectMenuMngList(HttpServletRequest request,MenuBean param) throws Exception;
	
	
	/**
	 * @param MenuBean
	 * @return int
	 */
//	public ProgramBean selectProgramMng(HttpServletRequest request,ProgramBean param) throws Exception;
	
	/**
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public UserMenuBean insertUserMenuProgramAuth(HttpServletRequest request,UserMenuBean param) throws Exception;
	
}