package ony.framework.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ony.cmm.common.bean.SysConnLogBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.MenuProgramMapBean;
import ony.cpes.internal.common.bean.UserMenuBean;

public class OnyCommonInterceptor extends HandlerInterceptorAdapter {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Inject
  private CommonService cs;


  public static final String IS_MOBILE = "MOBILE";
  private static final String IS_PHONE = "PHONE";
  public static final String IS_TABLET = "TABLET";
  public static final String IS_PC = "PC";

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


    logger.info("===========================        Common interceptor Start		===========================");
    HttpSession hs = request.getSession();
    String urlPath = request.getRequestURI().toString();
    // 로그인이 아니면
    if (!"/authLogin.do".equals(urlPath)) {

    	if(hs.getAttribute("sessUser") != null) {

    		// Case User have auth
    		if (hs.getAttribute("sessAuth") != null) {

    			@SuppressWarnings("unchecked")
				List<MenuProgramMapBean> authList = (List<MenuProgramMapBean>) hs.getAttribute("sessAuth");

    			boolean pageAuth = false;

    			for (MenuProgramMapBean mpm : authList) {
    				if(urlPath.contains(mpm.getProgramUrl())) {
        				pageAuth = true;
        				break;
        			}
    			}

    			if(pageAuth) {
    				SysConnLogBean sb = new SysConnLogBean();
  	      	      	sb.setUserIp(request.getRemoteAddr());
  	      	      	sb.setRangeCd("RNG0000000002");
  	      	      	sb.setSessionId(hs.getId());
  	      	      	sb.setUrl(urlPath);
  	      	      	sb.setMobilePcDivCd(isDevice(request));
  	      	      	UserMenuBean userMenu = (UserMenuBean)hs.getAttribute("sessUser");
  	      	      	sb.setUserSeq(userMenu.getUser().getUserSeq());
  	      	      	SysConnLogBean chk = cs.selectProgramSeqSameUrl(sb);
  	      	      	if(chk != null && chk.getProgramSeq() != null && !"".equals(chk.getProgramSeq())) {
  	      	      		int result = cs.insertPageConnLog(sb);
  	      	      	}
    			} else {
    				// 권한이 없는경우
    				response.setContentType("text/html; charset=UTF-8");
//    	            PrintWriter out = response.getWriter();
//    	            out.println("<script>alert('You have not Authority!'); history.go(-1);</script>");
//    	            out.flush();
    			}
    		} else {
    			// 세션이 끊긴 경우
    			response.setContentType("text/html; charset=UTF-8");
//	            PrintWriter out = response.getWriter();
//	            out.println("<script>alert('Lost Session'); history.go(-1);</script>");
//	            out.flush();
    		}

    	} else {
    		// 세션이 끊긴 경우
    		response.setContentType("text/html; charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            out.println("<script>alert('Lost Session.'); history.go(-1);</script>");
//            out.flush();
    	}
    }


    return super.preHandle(request, response, handler);

  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

    logger.info("===========================          Common interceptor END           ===========================");

  }


  /**
   * 모바일,타블렛,PC구분
   * @param req
   * @return
   */
  public static String isDevice(HttpServletRequest req) {
      String userAgent = req.getHeader("User-Agent").toUpperCase();

      if(userAgent.indexOf(IS_MOBILE) > -1) {
          if(userAgent.indexOf(IS_PHONE) == -1)
  	    return IS_MOBILE;
  	else
  	    return IS_TABLET;
      } else
  return IS_PC;
  }
}