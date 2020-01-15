package ony.cpes.internal.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ony.cmm.common.bean.SysConnLogBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.login.service.LoginService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;




@Controller
public class LoginController extends BaseController{

  private static Log log = LogFactory.getLog(LoginController.class);
  
  @Autowired
  private LoginService loginService;
  
  @Autowired
  private CommonService commonService;
  
  /**
   * 관리자 로그인 화면
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
    @RequestMapping("/authLogin")
	public String authLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "auth/login.login";
	}
    
    @RequestMapping("/authLogout")
	public String authLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	// Get current Session value
    	HttpSession hs = request.getSession();
    	
    	UserMenuBean userMenu = (UserMenuBean)hs.getAttribute("sessUser");
    	SysConnLogBean sb = new SysConnLogBean(); 
	    sb.setUserIp(request.getRemoteAddr());
	    sb.setSessionId(hs.getId());
	    sb.setUserSeq(userMenu.getUser().getUserSeq());
	      
	    commonService.updateSysConnLog(sb);
	    
	    hs.invalidate();
    	
		return "auth/login.login";
	}
    
    /**
     * 관리자 로그인 처리
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/authProcess")
	public String authProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "auth/login.login";
	}
    
    /**
     * 관리자 로그인 거부화면
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/accessDeniedPage")
	public String accessDeniedPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "auth/accessDeniedPage.login";
	}
    
    
    /**
     * 아이디찾기 화면
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/searchId")
	public String searchId(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "auth/searchId.login";
	}
    
    /**
     * Search User  (account)
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/selectSearchIdAjax")
	public void selectSearchIdAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserBean param = (UserBean) getObjectFromJSON(request, UserBean.class);
//    	UserBean param = new UserBean();
//		param.setUserNm("leeyoounhee");
//		param.setUserEmail("uninim76@gmail.com");
		
		this.outputJSON(request, response, loginService.selectSearchId(request, param));
	}
    
    /**
     * 비밀번호 찾기 화면
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/searchPwd")
   	public String searchPwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	
   		return "auth/searchPwd.login";
   	}
    
    /**비밀번호를 찾기 처리
     * search User Password
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/selectSearchPwdAjax")
	public void selectSearchPwdAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserBean param = (UserBean) getObjectFromJSON(request, UserBean.class);
		this.outputJSON(request, response, loginService.selectSearchPwd(request, param));
	}
    
    
    /**
     * 비밀번호 수정 화면
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/updatePwd")
   	public String updatePwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	
   		return "auth/updatePwd.login";
   	}
    
    
    /**비밀번호를 수정 처리 (use auth number)
     * search User Password
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/updateAuthPwdAjax")
	public void updateAuthPwdAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserBean param = (UserBean) getObjectFromJSON(request, UserBean.class);
		this.outputJSON(request, response, loginService.updateAuthPwd(request, param));
	}
    
    /**
     * 비밀번호 인증 조회 화면
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/overDayPwd")
	public String overPwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "auth/overDayPwd.login";
	}
    
    /**비밀번호를 수정 처리 (change password)
     * search User Password
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/updateOverDuraPwdAjax")
	public void updateOverDuraPwdAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserBean param = (UserBean) getObjectFromJSON(request, UserBean.class);
		this.outputJSON(request, response, loginService.updateOverDuraPwd(request, param));
	}
    
    /**
     * 비밀번호 인증 조회 화면
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/overFailPwd")
	public String overFailPwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "auth/overFailPwd.login";
	}
}
