package ony.framework.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ony.cmm.common.bean.SysConnLogBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.UserMenuBean;
 
public class OnyCommonInterceptor extends HandlerInterceptorAdapter {
   
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
   
  @Inject
  private CommonService cs;
  
  
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
 
    logger.info("===========================        Common interceptor Start		===========================");
    HttpSession hs = request.getSession();
    String urlPath = request.getRequestURI().toString();
    
    // 로그인이 아니면
    if (!"/authLogin.do".equals(urlPath)) {
    	
    	if(hs.getAttribute("sessUser") != null) {
//          insertSysConnLog
    		
    		  
    	      SysConnLogBean sb = new SysConnLogBean(); 
    	      sb.setUserIp(request.getRemoteAddr());
    	      sb.setRangeCd("RNG0000000002");
    	      sb.setSessionId(hs.getId());
    	      sb.setUrl(urlPath);
    	      UserMenuBean userMenu = (UserMenuBean)hs.getAttribute("sessUser");
    	      sb.setUserSeq(userMenu.getUser().getUserSeq());
    	      
    	      SysConnLogBean chk = cs.selectProgramSeqSameUrl(sb);
    	      
    	      if(chk != null && chk.getProgramSeq() != null && !"".equals(chk.getProgramSeq())) {
    	    	  int result = cs.insertPageConnLog(sb);
    	      }
    	}
    }
    
    
    return super.preHandle(request, response, handler);
 
  }
 
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
 
    logger.info("===========================          Common interceptor END           ===========================");
   
  }
  
	
}