package ony.cmm.common.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

import ony.cpes.internal.login.service.LoginService;
import ony.cpes.internal.user.bean.UserBean;


public class CustomLoginFailHandler implements AuthenticationFailureHandler {

	private String mngIdname;
    private String passwordname;
    private String errormsgname;
    private String defaultFailureUrl;

    @Autowired SessionLocaleResolver localeResolver;
    
    @Autowired MessageSource messageSource;

    @Inject
    private LoginService loginService;
    
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        
    	String mngId = request.getParameter("mngId");
    	String loginCd = "";
    	
    	UserBean ub = new UserBean();
    	ub.setMngId(mngId);
    	
    	try {
			ub = loginService.updateLoginFail(request, ub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        if(exception instanceof BadCredentialsException) {
        	errormsgname = messageSource.getMessage("security.error.BadCredentials",null, "Error", localeResolver.resolveLocale(request));
        	loginCd = "0001";
        } else if(exception instanceof InternalAuthenticationServiceException) {
        	errormsgname = messageSource.getMessage("security.error.InternalAuthenticationServiceException",null, "Error", localeResolver.resolveLocale(request));
        	loginCd = "0002";
        } else if(exception instanceof DisabledException) {
        	errormsgname = messageSource.getMessage("security.error.Disaled",null, "Error", localeResolver.resolveLocale(request));
        	loginCd = "0003";
        } else if(exception instanceof CredentialsExpiredException) {
        	errormsgname = messageSource.getMessage("security.error.CredentialsExpired",null, "Error", localeResolver.resolveLocale(request));
        	loginCd = "0004";
        	defaultFailureUrl = "/overFailPwd.do";
        }
        
        /*request.setAttribute("mngIdname", mngId);
        request.setAttribute("passwordname", password);
        request.setAttribute("errormsgname", errormsgname);
        request.setAttribute("loginCd", loginCd);
 
        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
        */
        
        ObjectMapper om = new ObjectMapper();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", false);
		map.put("message", errormsgname);
		map.put("loginCd", loginCd);
		map.put("defaultFailureUrl", defaultFailureUrl);

		// {"success" : false, "message" : "..."}
		String jsonString = om.writeValueAsString(map);

		OutputStream out = response.getOutputStream();
		out.write(jsonString.getBytes());
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


	public String getDefaultFailureUrl() {
        return defaultFailureUrl;
    }
 
    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

}
