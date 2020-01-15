package ony.cmm.common.handler;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import ony.cmm.common.bean.SysConnLogBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.common.dao.MngerMngDAO;
import ony.cpes.internal.common.service.MenuService;


public class CustomLogoutSuccessHandler implements LogoutSuccessHandler{

    @Inject
    private CommonService commonService;
    
	@Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                             Authentication authentication) throws IOException, ServletException {
        if (authentication != null && authentication.getDetails() != null) {
            try {
            	 
            	// Get current Session value
            	HttpSession hs = request.getSession();
            	
            	UserMenuBean userMenu = (UserMenuBean)hs.getAttribute("sessUser");
            	SysConnLogBean sb = new SysConnLogBean(); 
        	    sb.setUserIp(request.getRemoteAddr());
        	    sb.setSessionId(hs.getId());
        	    sb.setUserSeq(userMenu.getUser().getUserSeq());
        	      
        	    commonService.updateSysConnLog(sb);
            	
                request.getSession().invalidate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/");
    }
}
