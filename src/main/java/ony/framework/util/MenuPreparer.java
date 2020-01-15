package ony.framework.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.MenuProgramMapBean;
import ony.cpes.internal.common.bean.UserMenuBean;

/**
 * 
 * @author yhLee
 */
@Component
public class MenuPreparer implements ViewPreparer  {
	
	@Autowired SessionLocaleResolver localeResolver;

	@SuppressWarnings("unchecked")
	@Override
    public void execute(Request tilesContext, AttributeContext attributeContext) throws PreparerException {
        // TODO Auto-generated method stub
	    
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		String loc = localeResolver.resolveLocale(request).toString().toLowerCase();
		
		if (loc == null || "".equals(loc)) {
			loc = "kh";
		} else {
			try {
				loc = loc.substring(0,2);
			} catch (Exception e) {
				loc = "kh";
			}
		}
		
		//get current url path
		Enumeration<String> params = request.getParameterNames();
        String strParam = "";
        int i = 0;
        while(params.hasMoreElements()) {
            String name = (String)params.nextElement();
            String value = request.getParameter(name);
            if (i ==0) {
            	strParam += name + "=" + value;
            } else {
            	strParam += "&" + name + "=" + value;
            }
            i++;
        }
        
        String urlPath = "";
        if ("".equals(strParam)) {
        	urlPath = request.getRequestURI().toString();
        } else {
        	urlPath = request.getRequestURI().toString() + "?" + strParam;
        }
        // end get current url path
        
        
        
		int depth1	=	0;			// default 1depth Menu
		int depth2	=	0;
		int depth3	=	0;
		int depth4	=	0;
		String depth1Nm = "";
		String depth2Nm = "";
		String depth3Nm = "";
		String depth4Nm = "";
		
		String depth1Url = "";
		String depth2Url = "";
		String depth3Url = "";
		String depth4Url = "";
		String topUserName	= "";
		
		
		
		// 현재 URL과 같은 URL을 가지고 있는 프로그램을 조회한다.
		List<MenuBean> menuOneList = new ArrayList<MenuBean>();
		UserMenuBean userMenu = new UserMenuBean();
		
		boolean breakVal = false;
		
		try {
			userMenu = (UserMenuBean)session.getAttribute("sessUser");
			if (userMenu != null && userMenu.getUserMenuList() != null) {
				
				topUserName = userMenu.getUser().getUserNm();
				
				// 세션에서 메뉴를 가져온다.
				menuOneList = userMenu.getUserMenuList();
				
				for(MenuBean menu1 : menuOneList) {
					if (breakVal) break;
					if (menu1 != null && menu1.getMenuProgramMapList() != null) {
						for (MenuProgramMapBean m1pm : menu1.getMenuProgramMapList()) {
							if (urlPath.contains(m1pm.getProgramUrl().toString())) {
								depth1 		= Integer.parseInt(menu1.getMenuOrder());
								depth1Nm	=	menu1.getMenuNm();
								depth1Url	=	menu1.getMenuUrl();
							}
						}
					}
					
					for(MenuBean menu2 : menu1.getTailListMenu()) {
						if (breakVal) break;
							
						if (menu2 != null && menu2.getMenuProgramMapList() != null) {
							for (MenuProgramMapBean m2pm : menu2.getMenuProgramMapList()) {
								if (urlPath.contains(m2pm.getProgramUrl().toString())) {
									depth1 = Integer.parseInt(menu1.getMenuOrder());
									depth1Nm	=	menu1.getMenuNm();
									depth1Url	=	menu1.getMenuUrl();
									depth2 = Integer.parseInt(menu2.getMenuOrder());
									depth2Nm	=	menu2.getMenuNm();
									depth2Url	=	menu2.getMenuUrl();
									breakVal = true;
									break;
								}
							}
						}
						for(MenuBean menu3 : menu2.getTailListMenu()) {
							if (breakVal) break;
							if (menu3 != null && menu3.getMenuProgramMapList() != null) {
								for (MenuProgramMapBean m3pm : menu3.getMenuProgramMapList()) {
									if (breakVal) break;
									if (urlPath.contains(m3pm.getProgramUrl().toString())) {
										depth1 = Integer.parseInt(menu1.getMenuOrder());
										depth1Nm	=	menu1.getMenuNm();
										depth1Url	=	menu1.getMenuUrl();
										depth2 = Integer.parseInt(menu2.getMenuOrder());
										depth2Nm	=	menu2.getMenuNm();
										depth2Url	=	menu2.getMenuUrl();
										depth3 = Integer.parseInt(menu3.getMenuOrder());
										depth3Nm	=	menu3.getMenuNm();
										depth3Url	=	menu3.getMenuUrl();
										breakVal = true;
										break;
									}
								}
							}
							
							for(MenuBean menu4 : menu3.getTailListMenu()) {
								if (breakVal) break;
								if (menu4 != null && menu4.getMenuProgramMapList() != null) {
									for (MenuProgramMapBean m4pm : menu4.getMenuProgramMapList()) {
										if (breakVal) break;
										if (urlPath.contains(m4pm.getProgramUrl().toString())) {
											depth1 = Integer.parseInt(menu1.getMenuOrder());
											depth1Nm	=	menu1.getMenuNm();
											depth1Url	=	menu1.getMenuUrl();
											depth2 = Integer.parseInt(menu2.getMenuOrder());
											depth2Nm	=	menu2.getMenuNm();
											depth2Url	=	menu2.getMenuUrl();
											depth3 = Integer.parseInt(menu3.getMenuOrder());
											depth3Nm	=	menu3.getMenuNm();
											depth3Url	=	menu3.getMenuUrl();
											depth4 = Integer.parseInt(menu4.getMenuOrder());
											depth4Nm	=	menu4.getMenuNm();
											depth4Url	=	menu4.getMenuUrl();
											breakVal = true;
											break;
										}
									}
								}
							}
						}
					}
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			attributeContext.putAttribute("depth1", new Attribute(StringUtil.nvlNum(depth1)), true);
			attributeContext.putAttribute("depth2", new Attribute(StringUtil.nvlNum(depth2)), true);
			attributeContext.putAttribute("depth3", new Attribute(StringUtil.nvlNum(depth3)), true);
			attributeContext.putAttribute("depth4", new Attribute(StringUtil.nvlNum(depth4)), true);
			attributeContext.putAttribute("depth1Nm", new Attribute(StringUtil.nvl(depth1Nm)), true);
			attributeContext.putAttribute("depth2Nm", new Attribute(StringUtil.nvl(depth2Nm)), true);
			attributeContext.putAttribute("depth3Nm", new Attribute(StringUtil.nvl(depth3Nm)), true);
			attributeContext.putAttribute("depth4Nm", new Attribute(StringUtil.nvl(depth4Nm)), true);
			attributeContext.putAttribute("depth1Url", new Attribute(StringUtil.nvl(depth1Url)), true);
			attributeContext.putAttribute("depth2Url", new Attribute(StringUtil.nvl(depth2Url)), true);
			attributeContext.putAttribute("depth3Url", new Attribute(StringUtil.nvl(depth3Url)), true);
			attributeContext.putAttribute("depth4Url", new Attribute(StringUtil.nvl(depth4Url)), true);
	        attributeContext.putAttribute("menuList", new Attribute(menuOneList), true);
	        attributeContext.putAttribute("topUserName", new Attribute(topUserName), true);
	    }
    }

	public String getLocalNm(String menuNmKh, String menuNmEn, String lang) {
		String chgMenuNm = "";
		
		if ("en".equals(lang)) {
			chgMenuNm = menuNmEn;
		} else if ("ko".equals(lang)) {
			chgMenuNm = menuNmEn;
		} else {
			chgMenuNm = menuNmKh;
		}
		
		return chgMenuNm;
	}
}
