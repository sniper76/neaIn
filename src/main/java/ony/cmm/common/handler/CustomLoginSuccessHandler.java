package ony.cmm.common.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import ony.cmm.common.bean.SysConnLogBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.MenuProgramMapBean;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.common.dao.MngerMngDAO;
import ony.cpes.internal.common.service.MenuService;
import ony.cpes.internal.login.service.LoginService;
import ony.cpes.internal.user.bean.UserBean;


public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    private String defaultUrl;
    private String mngIdname;
    private String passwordname;
    private String errormsgname;

    private RequestCache reqCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
    
    @Inject
    private LoginService loginService;
    
    @Inject
    private MenuService menuSvc;
    
    @Inject
    private CommonService cs;
    
    @Inject
	private MngerMngDAO mngerMngDao;
    
    @Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {

    	UserBean param = new UserBean();
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	try {
			param.setMngId((String) authentication.getPrincipal());
			param.setUserPwd((String) authentication.getCredentials());
    	} catch (Exception e) {
    		
    	}
		try {
			param = loginService.selectSearchId(req, param);
			if(param != null) {
				param.setMngId((String) authentication.getPrincipal());
				param.setUserPwd((String) authentication.getCredentials());
			} else {
				param = new UserBean();
				param.setMngId((String) authentication.getPrincipal());
				param.setUserPwd((String) authentication.getCredentials());
			}
			
		} catch (Exception e1) {
			
		}
		try {
			if ("N".equals(param.getPwdChgYn())) {
				param.setLastLoginIp(req.getRemoteAddr());
				loginService.updateLogin(req, param);
			} else {
				// over duration of password
				defaultUrl = "/overDayPwd.do";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/** inquiry menu and Set **/
		UserMenuBean param1 = new UserMenuBean();
		param1.setMngId(param.getMngId());
	    
		MenuBean menu = new MenuBean();
		
	    List<MenuBean> menuOneList	=	new ArrayList<MenuBean>();
	    List<MenuBean> menuTwoList	=	new ArrayList<MenuBean>();
	    List<MenuBean> menuThreeList	=	new ArrayList<MenuBean>();
	    List<MenuBean> menuFourList	=	new ArrayList<MenuBean>();
	    List<MenuProgramMapBean> menuProgramMapList	=	new ArrayList<MenuProgramMapBean>();
	    
	    param1.getMenu().setMenuLvl("1");			//1depth 메뉴를 구하기 위해
		try {
			menuOneList = menuSvc.selectUserMenuList(param1);
			param1.getMenu().setMenuLvl("2");					//2depth 메뉴를 구하기 위해
			menuTwoList = menuSvc.selectUserMenuList(param1);
			param1.getMenu().setMenuLvl("3");					//3depth 메뉴를 구하기 위해
			menuThreeList = menuSvc.selectUserMenuList(param1);
			param1.getMenu().setMenuLvl("4");					//4depth 메뉴를 구하기 위해
			menuFourList = menuSvc.selectUserMenuList(param1);
			menuProgramMapList = menuSvc.selectMenuInfoByProgram(param1);
			
			// For the menu numbering
			if(menuOneList != null && menuOneList.size() > 0) {
				int i = 1;
				for (MenuBean m1 : menuOneList) {
					int j = 1;
					m1.setMenuOrder(String.valueOf(i));
					List<MenuBean> tailTwoList	=	new ArrayList<MenuBean>();
					for (MenuBean m2 : menuTwoList) {
						if (m2.getUpperMenuCd().equals(m1.getMenuCd())) {
							m2.setMenuOrder(String.valueOf(j));
							tailTwoList.add(m2);
							int k = 1;
							List<MenuBean> tailThreeList	=	new ArrayList<MenuBean>();
							for (MenuBean m3 : menuThreeList) {
								if (m3.getUpperMenuCd().equals(m2.getMenuCd())) {
									m3.setMenuOrder(String.valueOf(k));
									tailThreeList.add(m3);
									
									int l = 1;
									List<MenuBean> tailFourList	=	new ArrayList<MenuBean>();
									for (MenuBean m4 : menuFourList) {
										if (m4.getUpperMenuCd().equals(m3.getMenuCd())) {
											m4.setMenuOrder(String.valueOf(l));
											tailFourList.add(m4);
											l++;
										}
										
										List<MenuProgramMapBean> m4MenuProgramList = new ArrayList<MenuProgramMapBean>();
										for (MenuProgramMapBean mpm : menuProgramMapList) {
											if (m4.getMenuCd().equals(mpm.getMenuCd())) {
												m4MenuProgramList.add(mpm);
											}
										}
										
										m4.setMenuProgramMapList(m4MenuProgramList);
										
									}
									
									
									m3.setTailListMenu(tailFourList);
									k++;
								}
								
								List<MenuProgramMapBean> m3MenuProgramList = new ArrayList<MenuProgramMapBean>();
								for (MenuProgramMapBean mpm : menuProgramMapList) {
									if (m3.getMenuCd().equals(mpm.getMenuCd())) {
										m3MenuProgramList.add(mpm);
									}
								}
								m3.setMenuProgramMapList(m3MenuProgramList);
							}
							m2.setTailListMenu(tailThreeList);
							j++;
						}
						
						List<MenuProgramMapBean> m2MenuProgramList = new ArrayList<MenuProgramMapBean>();
						for (MenuProgramMapBean mpm : menuProgramMapList) {
							if (m2.getMenuCd().equals(mpm.getMenuCd())) {
								m2MenuProgramList.add(mpm);
							}
						}
						m2.setMenuProgramMapList(m2MenuProgramList);
					}
					m1.setTailListMenu(tailTwoList);
					i++;
					
					List<MenuProgramMapBean> m1MenuProgramList = new ArrayList<MenuProgramMapBean>();
					for (MenuProgramMapBean mpm : menuProgramMapList) {
						if (m1.getMenuCd().equals(mpm.getMenuCd())) {
							m1MenuProgramList.add(mpm);
						}
					}
					m1.setMenuProgramMapList(m1MenuProgramList);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Create Menu session
		UserMenuBean	sessUser = new UserMenuBean();
		
		sessUser.setUserMenuList(menuOneList);
		sessUser.setUser(param);
		
		HttpSession menuSession = req.getSession();
		
		if (sessUser != null) {
			
			// if had session then erase session
			if(menuSession.getAttribute("sessUser") != null) {
				menuSession.removeAttribute("sessUser");
			}

			menuSession.setAttribute("sessUser", sessUser);
		}
		
		// if success login then insert log for login
		// if fail
    	if(sessUser != null) {
//	          insertSysConnLog
    	      SysConnLogBean sb = new SysConnLogBean(); 
    	      sb.setUserIp(req.getRemoteAddr());
    	      sb.setRangeCd("RNG0000000002");
    	      sb.setSessionId(menuSession.getId());
    	      sb.setUrl(req.getRequestURI().toString());
    	      sb.setUserSeq(sessUser.getUser().getUserSeq());
    	      int result = cs.insertLoginSuccessLog(sb);
    	}
		
		
//      erase login session
//        clrearAuthenticationAttributes(req);
        
		ObjectMapper om = new ObjectMapper();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		
		if (defaultUrl != null) {
			map.put("returnUrl", defaultUrl);
		} else {
			map.put("returnUrl", getReturnUrl(req, res));
		}
			
		

		// {"success" : true, "returnUrl" : "..."}
		String jsonString = om.writeValueAsString(map);

		OutputStream out = res.getOutputStream();
		out.write(jsonString.getBytes());
	}

	/**
	 * 로그인 하기 전의 요청했던 URL을 알아낸다.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private String getReturnUrl(HttpServletRequest request, HttpServletResponse response) {
		RequestCache requestCache = new HttpSessionRequestCache();
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest == null) {
			return "./internal/index.do";
		}
		return savedRequest.getRedirectUrl();
	}
    
    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

	public String getMngIdname() {
		return mngIdname;
	}

	public void setMngIdname(String mngIdname) {
		this.mngIdname = mngIdname;
	}

	public String getPasswordname() {
		return passwordname;
	}

	public void setPasswordname(String passwordname) {
		this.passwordname = passwordname;
	}

	public String getErrormsgname() {
		return errormsgname;
	}

	public void setErrormsgname(String errormsgname) {
		this.errormsgname = errormsgname;
	}

    
}
