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
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.common.bean.UserProgramBean;
import ony.cpes.internal.common.dao.MngerMngDAO;
import ony.cpes.internal.common.service.MngerMngService;
import ony.cpes.internal.user.bean.UserBean;


@Service("MngerMngService")
public class MngerMngServiceImpl implements MngerMngService{
    
	@Autowired
	private MngerMngDAO mngerMngDao;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;
	
	
	/**
	 * 
	 */
	public UserBean selectMngerJcDetailInfo(HttpServletRequest request,UserBean param) throws Exception {
		
		param = mngerMngDao.selectMngerJcDetailInfo(param);
		
        return param;
    }
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public MenuBean selectMenuMngList(HttpServletRequest request,MenuBean param) throws Exception {
		
		// inquiry 1d menu
		if (param == null)
			param = new MenuBean();

		param.setMenuLvl("1");
		param.setRangeCd("RNG0000000002");
		List<MenuBean> menu1 = mngerMngDao.selectMenuMngList(param);
		
		// inquiry 2d menu
		param.setMenuLvl("2");
		List<MenuBean> menu2 = mngerMngDao.selectMenuMngList(param);
				
		// inquiry 3d menu
		param.setMenuLvl("3");
		List<MenuBean> menu3 = mngerMngDao.selectMenuMngList(param);

		// inquiry 4d menu
		param.setMenuLvl("4");
		List<MenuBean> menu4 = mngerMngDao.selectMenuMngList(param);
		
		for(MenuBean m1 : menu1) {
			
			if (m1.getMenuAuthYn() != null && !"".equals(m1.getMenuAuthYn())) {
				m1.setMenu1AuthYn(m1.getMenuAuthYn());
			}
			
			List<MenuBean> m2List = new ArrayList<MenuBean>();
			
			for(MenuBean m2 : menu2) {
				if (m1.getMenuCd().equals(m2.getUpperMenuCd())) {
					m2List.add(m2);
				}
				
				List<MenuBean> m3List = new ArrayList<MenuBean>();
				for(MenuBean m3 : menu3) {
					
					if (m2.getMenuCd().equals(m3.getUpperMenuCd())) {
						m3List.add(m3);
					} 
					
					List<MenuBean> m4List = new ArrayList<MenuBean>();
					for(MenuBean m4 : menu4) {
						
						if (m3.getMenuCd().equals(m4.getUpperMenuCd())) {
							m4List.add(m4);
						} 
					}
					m3.setTailListMenu(m4List);
				}
				m2.setTailListMenu(m3List);
			}
			m1.setTailListMenu(m2List);
		}
		
		param.setTailListMenu(menu1);
		
		MenuBean result = makeHtml(param);
		
		return result;
    }
	
	
	private MenuBean makeHtml(MenuBean menu) throws Exception {
		
		// inquiry program
		MenuProgramMapBean uParam = new MenuProgramMapBean();
		uParam.setUserSeq(menu.getUserSeq());
		List<MenuProgramMapBean> userProgram = mngerMngDao.selectProgramMng(uParam);
				
		List<MenuBean> retList = new ArrayList<MenuBean>();
		MenuBean ret = new MenuBean();
		try {
			for(MenuBean m1 : menu.getTailListMenu()) {
				
				m1.setMenu1DepthCd(m1.getMenuCd());
				m1.setMenu1DepthNm(m1.getMenuNmEn());
				m1.setMenu1AuthYn(m1.getMenuAuthYn());
				
				List<MenuProgramMapBean> m1pList = new ArrayList<MenuProgramMapBean>();
				for(MenuProgramMapBean up1 : userProgram) {
					if (m1.getMenuCd().equals(up1.getMenuCd())) {
						up1.setDepthNm("1Depth ");
						m1pList.add(up1);
					}
				}
				//m1.setMenuProgramMapList(m1pList);
				
				// 다음 단계의 메뉴가 없다면 현재 단계를 리스트 형식으로 저장
				if (m1.getTailListMenu() == null|| m1.getTailListMenu().size() < 1) {
					m1.setMenuProgramMapList(m1pList);
					retList.add(m1);
					m1pList = new ArrayList<MenuProgramMapBean>();
				} else {
					
					for(MenuBean m2 : m1.getTailListMenu()) {

						if (m2.getMenuAuthYn() != null && !"".equals(m2.getMenuAuthYn())) {
							m2.setMenu1AuthYn(m2.getMenuAuthYn());
						}

						m2.setMenu1DepthCd(m1.getMenuCd());
						m2.setMenu1DepthNm(m1.getMenuNmEn());
						m2.setMenu2DepthCd(m2.getMenuCd());
						m2.setMenu2DepthNm(m2.getMenuNmEn());
						m2.setMenu1AuthYn(m1.getMenuAuthYn());
						m2.setMenu2AuthYn(m2.getMenuAuthYn());
						
						//List<MenuProgramMapBean> m2pList = new ArrayList<MenuProgramMapBean>();
						for(MenuProgramMapBean up2 : userProgram) {
							if (m2.getMenuCd().equals(up2.getMenuCd())) {
								up2.setDepthNm("2Depth ");
								m1pList.add(up2);
							}
						}
						//m1.setMenuProgramMapList(m1pList);
						
						if (m2.getTailListMenu() == null|| m2.getTailListMenu().size() < 1) {
							m2.setMenuProgramMapList(m1pList);
							retList.add(m2);
							m1pList = new ArrayList<MenuProgramMapBean>();
						} else {
							for(MenuBean m3 : m2.getTailListMenu()) {
								
								if (m3.getMenuAuthYn() != null && !"".equals(m3.getMenuAuthYn())) {
									m3.setMenu1AuthYn(m3.getMenuAuthYn());
								}
								m3.setMenu1DepthCd(m1.getMenuCd());
								m3.setMenu1DepthNm(m1.getMenuNmEn());
								m3.setMenu2DepthCd(m2.getMenuCd());
								m3.setMenu2DepthNm(m2.getMenuNmEn());
								m3.setMenu3DepthCd(m3.getMenuCd());
								m3.setMenu3DepthNm(m3.getMenuNmEn());
								m3.setMenu1AuthYn(m1.getMenuAuthYn());
								m3.setMenu2AuthYn(m2.getMenuAuthYn());
								m3.setMenu3AuthYn(m3.getMenuAuthYn());
								
								//List<MenuProgramMapBean> m3pList = new ArrayList<MenuProgramMapBean>();
								for(MenuProgramMapBean up3 : userProgram) {
									if (m3.getMenuCd().equals(up3.getMenuCd())) {
										up3.setDepthNm("3Depth ");
										m1pList.add(up3);
									}
								}
								//m1.setMenuProgramMapList(m1pList);
								
								if (m3.getTailListMenu() == null || m3.getTailListMenu().size() < 1) {
									m3.setMenuProgramMapList(m1pList);
									retList.add(m3);
									m1pList = new ArrayList<MenuProgramMapBean>();
								} else {
									for(MenuBean m4 : m3.getTailListMenu()) {
										
										//List<MenuProgramMapBean> m4pList = new ArrayList<MenuProgramMapBean>();
										for(MenuProgramMapBean up4 : userProgram) {
											if (m4.getMenuCd().equals(up4.getMenuCd())) {
												up4.setDepthNm("4Depth ");
												m1pList.add(up4);
											}
										}
										//m4.setMenuProgramMapList(m4pList);

										if (m4.getMenuAuthYn() != null && !"".equals(m4.getMenuAuthYn())) {
											m4.setMenu1AuthYn(m4.getMenuAuthYn());
										}
										m4.setMenu1DepthCd(m1.getMenuCd());
										m4.setMenu1DepthNm(m1.getMenuNmEn());
										m4.setMenu2DepthCd(m2.getMenuCd());
										m4.setMenu2DepthNm(m2.getMenuNmEn());
										m4.setMenu3DepthCd(m3.getMenuCd());
										m4.setMenu3DepthNm(m3.getMenuNmEn());
										m4.setMenu4DepthCd(m4.getMenuCd());
										m4.setMenu4DepthNm(m4.getMenuNmEn());
										m4.setMenu1AuthYn(m1.getMenuAuthYn());
										m4.setMenu2AuthYn(m2.getMenuAuthYn());
										m4.setMenu3AuthYn(m3.getMenuAuthYn());
										m4.setMenu4AuthYn(m4.getMenuAuthYn());
										
										m4.setMenuProgramMapList(m1pList);
										retList.add(m4);
										m1pList = new ArrayList<MenuProgramMapBean>();
									}
								}
							}
						}
						
					}
					
				}
			}
		} catch (Exception e) {
			
		} finally {
			ret.setTailListMenu(retList);
		}
		
		return ret;
		
	}
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	/*public ProgramBean selectProgramMng(HttpServletRequest request,ProgramBean param) throws Exception {
		param = mngerMngDao.selectProgramMng(param);
		return param;
    }*/
	
	/**
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public UserMenuBean insertUserMenuProgramAuth(HttpServletRequest request,UserMenuBean param) throws Exception {
			
			mngerMngDao.deleteUserMenu(param);
			mngerMngDao.deleteUserProgram(param);
		
			for(String m1 : param.getM1List()) {
				
				if (!"0".equals(m1)) {
					UserMenuBean m1Bean = new UserMenuBean();
					m1Bean.setUserSeq(param.getUserSeq());
					m1Bean.setMenuCd(m1);
					m1Bean.setRegUserSeq(param.getRegUserSeq());
					m1Bean.setModUserSeq(param.getModUserSeq());
					mngerMngDao.insertUserMenu(m1Bean);
				}
			}
			
			for(String m2 : param.getM2List()) {
				if (!"0".equals(m2)) {
					UserMenuBean m2Bean = new UserMenuBean();
					m2Bean.setUserSeq(param.getUserSeq());
					m2Bean.setMenuCd(m2);
					m2Bean.setRegUserSeq(param.getRegUserSeq());
					m2Bean.setModUserSeq(param.getModUserSeq());
					int result = mngerMngDao.insertUserMenu(m2Bean);
				}
			}
			
			for(String m3 : param.getM3List()) {
				if (!"0".equals(m3)) {
					UserMenuBean m3Bean = new UserMenuBean();
					m3Bean.setUserSeq(param.getUserSeq());
					m3Bean.setMenuCd(m3);
					m3Bean.setRegUserSeq(param.getRegUserSeq());
					m3Bean.setModUserSeq(param.getModUserSeq());
					int result = mngerMngDao.insertUserMenu(m3Bean);
				}
			}
			
			for(String m4 : param.getM4List()) {
				if (!"0".equals(m4)) {
					UserMenuBean m4Bean = new UserMenuBean();
					m4Bean.setUserSeq(param.getUserSeq());
					m4Bean.setMenuCd(m4);
					m4Bean.setRegUserSeq(param.getRegUserSeq());
					m4Bean.setModUserSeq(param.getModUserSeq());
					int result = mngerMngDao.insertUserMenu(m4Bean);
				}
			}
		
			for(String menuProgramSeq : param.getProList()) {
				if (!"0".equals(menuProgramSeq)) {
					UserProgramBean proBean = new UserProgramBean();
					proBean.setUserSeq(param.getUserSeq());
					proBean.setMenuProgramMapSeq(menuProgramSeq);
					proBean.setRegUserSeq(param.getRegUserSeq());
					proBean.setModUserSeq(param.getModUserSeq());
					int result = mngerMngDao.insertUserProgram(proBean);
				}
			}

		return param;
    }
}
