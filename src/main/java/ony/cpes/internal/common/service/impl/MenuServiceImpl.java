package ony.cpes.internal.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.MenuProgramMapBean;
import ony.cpes.internal.common.bean.ProgramBean;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.common.dao.MenuDAO;
import ony.cpes.internal.common.dao.ProgramDAO;
import ony.cpes.internal.common.service.MenuService;


@Service("MenuService")
public class MenuServiceImpl implements MenuService{
    
	@Autowired
	private MenuDAO menuDao;
	
	@Autowired 
	MessageSource messageSource;
	
	@Autowired 
	SessionLocaleResolver localeResolver;
	
	@Autowired
	private ProgramDAO pdao;
	
	/**
	 * inquiry of usermenu info
	 * @param username
	 * @return
	 */
	public List<MenuBean> selectUserMenuList(UserMenuBean param) throws Exception {
		List<MenuBean> list = menuDao.selectUserMenuList(param);
		return list;
    }
	
	/**
	 * inquiry of menu list
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public MenuBean selectMenuMngList(MenuBean param) throws Exception {
    	
    	int totalCount = (int) menuDao.selectMenuMngListTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<MenuBean> list = menuDao.selectMenuMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setTailListMenu(list);
		return param;
	}
	
	
	/**insert menu
	 * @param MenuBean
	 * @return int
	 */
	public MenuBean insertMenuMng(HttpServletRequest request, MenuBean param) throws Exception {
		try {
			
			// GET Menu Code (Sequencial)
			String menuCd = menuDao.selectMenuCd(param);
			
			if (menuCd != null) {
				param.setMenuCd(menuCd);
				
				// regist base info of menu
				int result = menuDao.insertMenuMng(param);
	
				//if Succes then 
				if (result > 0) {
					param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
					param.setMsg(messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
					
					if (param.getProgramSeqArr() != null && !"".equals(param.getProgramSeqArr())) {
						String[] arrProgramSeq = param.getProgramSeqArr().split(",");
						for(String programSeq : arrProgramSeq) {
							MenuProgramMapBean mp = new MenuProgramMapBean();
							mp.setProgramSeq(programSeq);
							mp.setMenuCd(menuCd);
							
							if (param.getPriProgramSeq() != null && param.getPriProgramSeq().equals(programSeq)) {
								mp.setPriProgramYn("Y");
							} else {
								mp.setPriProgramYn("N");
							}
							mp.setRegUserSeq(param.getRegUserSeq());
							mp.setModUserSeq(param.getModUserSeq());
							menuDao.insertMenuProgramMap(mp);
							
						}
						
					}
					
				} else {
					param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
					param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
				}
				
				
			}
		} catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return param;
    }
	
	/**update menu
	 * @param MenuBean
	 * @return int
	 */
	public MenuBean updateMenuMng(HttpServletRequest request, MenuBean param) throws Exception {
		try {
			int result = menuDao.updateMenuMng(param);
			
			if (result > 0) {
				param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
				
				//menuDao.deleteMenuProgramMap(param);
				
				// 이전에 등록되어 있던 프로그램 정보를 조회한다.
				List<MenuProgramMapBean> oldMenuMapList = menuDao.selectMenuProgramMapList(param);
				
				try {
						// 넘어온 프로그램 이외의 프로그램은 삭제 처리 한다.
						if (param.getProgramSeqArr() != null && !"".equals(param.getProgramSeqArr())) {
							
							String[] arrProgramSeq = param.getProgramSeqArr().split(",");
							for(MenuProgramMapBean oldMp : oldMenuMapList) {
								String delYn = "Y";
								ProgramBean pbean = new ProgramBean();
								MenuBean mbean = new MenuBean();
								for(String programSeq : arrProgramSeq) {
									if (programSeq.equals(oldMp.getProgramSeq())) {
										delYn = "N";
										break;
									}
								}

								if ("Y".equals(delYn)) {
									pbean.setProgramSeq(oldMp.getProgramSeq());
									mbean.setProgramSeqTemp(oldMp.getProgramSeq());
									mbean.setMenuCd(param.getMenuCd());
									// 메뉴에 연결된 프로그램 삭제 후
									pdao.deleteOtherProgramMng(pbean);
									
								}
							}
						}
						
					
						if (param.getProgramSeqArr() != null && !"".equals(param.getProgramSeqArr())) {
							String[] arrProgramSeq = param.getProgramSeqArr().split(",");
							for(String programSeq : arrProgramSeq) {
								
								boolean sameProgramSeqYn = false;
								String menuProgramMapSeq = "";
								
								// 이전 프로그램과 동일한 프로그램이 존재할 경우 등록처리 하지 않는다.
								for(MenuProgramMapBean oldMp : oldMenuMapList) {
									if (programSeq.equals(oldMp.getProgramSeq())) {
										menuProgramMapSeq = oldMp.getMenuProgramMapSeq();
										sameProgramSeqYn = true;
										break;
									}
								}
								MenuProgramMapBean mp = new MenuProgramMapBean();
								mp.setProgramSeq(programSeq);
								mp.setMenuCd(param.getMenuCd());
								mp.setRegUserSeq(param.getRegUserSeq());
								mp.setModUserSeq(param.getModUserSeq());
								
								if (param.getPriProgramSeq() != null && param.getPriProgramSeq().equals(programSeq)) {
									mp.setPriProgramYn("Y");
								} else {
									mp.setPriProgramYn("N");
								}
								
								// same program = update process
								if (sameProgramSeqYn) {
									mp.setMenuProgramMapSeq(menuProgramMapSeq);
									menuDao.updateMenuProgramMap(mp);
								} else {
									
									menuDao.insertMenuProgramMap(mp);
								}
								
							}
							
							
							
							
						}
				} catch (Exception e) {
					
				}
				
			} else {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
			}
		} catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return param;
    }
	
	
	/**update menu
	 * @param MenuBean
	 * @return int
	 */
	public MenuBean deleteMenuMng(HttpServletRequest request, MenuBean param) throws Exception {
		try {
			int result = menuDao.deleteMenuMng(param);
			
			if (result > 0) {
				param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
				
				menuDao.deleteMenuProgramMap(param);
				
			} else {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
			}
		} catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return param;
    }
	
	
	public MenuBean selectCurrentLvlMenuMngList(HttpServletRequest request, MenuBean paramObj) throws Exception {
		List<MenuBean> list = menuDao.selectCurrentLvlMenuMngList(paramObj);
		
		if (list != null) {
			paramObj.setTailListMenu(list);
		}
		
		return paramObj;
			
	}
	
	public MenuBean selectMenuMngDetail(MenuBean paramObj) throws Exception {
		try {
			paramObj = menuDao.selectMenuMngDetail(paramObj);
			
			if (paramObj != null) {
				
				if (paramObj.getFullMenuCd() != null && !"".equals(paramObj.getFullMenuCd())) {
					String[] arrMenu = paramObj.getFullMenuCd().split(",");
					for(int i =0; i < arrMenu.length; i++) {
						if (i == 0) {paramObj.setMenu1DepthCd(arrMenu[0]);}
						if (i == 1) {paramObj.setMenu2DepthCd(arrMenu[1]);}
						if (i == 2) {paramObj.setMenu3DepthCd(arrMenu[2]);}
					}
				}
				
				List<MenuProgramMapBean> menuProgramMapList = new ArrayList<MenuProgramMapBean>();
				
				menuProgramMapList = menuDao.selectMenuProgramMapList(paramObj);
				
				if (menuProgramMapList != null) {
					paramObj.setMenuProgramMapList(menuProgramMapList);
				}
			}
		} catch (Exception e) {
			
		} finally {
			return paramObj;
		}
	}
	
	
	public List<MenuProgramMapBean> selectMenuInfoByProgram(UserMenuBean paramObj) throws Exception {
		List<MenuProgramMapBean> list = menuDao.selectMenuInfoByProgram(paramObj);
		return list;
	}
}
