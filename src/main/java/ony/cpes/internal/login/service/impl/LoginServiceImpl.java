package ony.cpes.internal.login.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cmm.common.bean.SmsBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.login.dao.LoginDAO;
import ony.cpes.internal.login.service.LoginService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.util.CommUtil;
import ony.framework.util.IdFormatterUtil;

@Service("LoginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDAO loginDao;
	
	@Autowired
	private CommonService commSvc;
	
	@Autowired SessionLocaleResolver localeResolver;
    
    @Autowired MessageSource messageSource;
    
	/**
	 * search admin user Email
	 * @param param UserBean
	 * @return UserBean
	 */
    @Override
    public UserBean selectSearchId(HttpServletRequest request, UserBean param) throws Exception {
    	
    	/** if search for userEmail **/
		/**
		 * step 1. search name
		 * step 2. search email
		 */
		try {
				// step 1 : search name
				UserBean tempParam = new UserBean();
				tempParam.setUserNmEn(param.getUserNm());
				tempParam.setUserNmKh(param.getUserNm());
				tempParam.setUserNm(param.getUserNm());
				tempParam.setMngId(param.getMngId());
				tempParam.setUserEmail(param.getUserEmail());
				
				UserBean result = loginDao.selectSearchIdPwd(tempParam);
				
				if (result == null) {
					param.setResultCode("0001");		// name not found
					param.setMsg(messageSource.getMessage("login.idsearch.name.incorrect",null, "Error", localeResolver.resolveLocale(request)));
					return param;
				} else {
					
					BeanUtils.copyProperties(result, param);
					
					// step 2 : check email
					if((param.getUserEmail()).equals(result.getUserEmail())) {	// equals user email
						//success
						param.setResultCode("0000");
						String maskId = IdFormatterUtil.getMaskedId(result.getMngId());
						
						param.setMngId(maskId);
						
					} else {
						param.setResultCode("0002");		// name not found
						param.setMsg(messageSource.getMessage("login.idsearch.email.incorrect",null, "Error", localeResolver.resolveLocale(request)));
					}
				}
		} catch (Exception e) {
			param.setResultCode("9999");		// name not found
			param.setMsg(messageSource.getMessage("fail.common.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		return param;
    }
	
	/**
	 * search admin pwd
	 * @param param UserBean
	 * @return UserBean
	 */
	public UserBean selectSearchPwd(HttpServletRequest request, UserBean param) throws Exception {
		/** if search for userEmail **/
		/**
		 * step 1. search id
		 * step 2. search name, email
		 * step 3. set session and create auth number
		 */
		
		// step 1 : search id
		UserBean tempParam = new UserBean();
		tempParam.setUserNmEn(param.getUserNm());
		tempParam.setUserNmKh(param.getUserNm());
		//tempParam.setUserNm(param.getUserNm());
		tempParam.setMngId(param.getMngId());
		//tempParam.setUserEmail(param.getUserEmail());
		
		try {
			UserBean result = loginDao.selectSearchIdPwd(tempParam);
			if (result == null) {
				param.setResultCode("0001");		// id not found
				param.setMsg(messageSource.getMessage("login.idsearch.mngid.incorrect",null, "Error", localeResolver.resolveLocale(request)));			
				return param;
			} else {
				// step 2 : check Email and Name
				if(!(param.getUserEmail()).equals(result.getUserEmail())) {	// equals user Name
					param.setResultCode("0002");		// name not found
					param.setMsg(messageSource.getMessage("login.idsearch.email.incorrect",null, "Error", localeResolver.resolveLocale(request)));				
					return param;
				}
				if(!(param.getUserNm()).equals(result.getUserNm())) {	// equals user Email
					param.setResultCode("0003");		// name not found
					param.setMsg(messageSource.getMessage("login.idsearch.name.incorrect",null, "Error", localeResolver.resolveLocale(request)));
					return param;
				}
				
				//success
				param.setResultCode("0000");
				//set session
				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("UserBean", result);
				
				// creation auth number
				String authNum = CommUtil.randomChar(6, "unt");
				result.setEmailUserAuthValue(authNum);
				loginDao.updateEmailUserAuthValue(result);
				
				/* send SMS */
//	            String msg = messageSource.getMessage("sms.user.chg.passwd.msg",null, "Verification No : ", localeResolver.resolveLocale(request)) + authNum;
				String msg = "Verification No : " + authNum;
	            SmsBean sms = new SmsBean();
	            sms.setSmsText(msg);
	            sms.setSmsTo(result.getUserCell());
	            commSvc.insertSmsLog(sms);
			}
		} catch (Exception e) {
			param.setResultCode("9999");		// name not found
			param.setMsg(messageSource.getMessage("fail.common.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		return param;
	}
	
	
	/**
	 * update AuthPwd
	 * @param param UserBean
	 * @return UserBean
	 */
	public UserBean updateAuthPwd(HttpServletRequest request, UserBean param) throws Exception {
		
		
		// 1. get session
		// 2. check auth number
		HttpSession httpSession = request.getSession(true);
		UserBean sUserBean = (UserBean) httpSession.getAttribute("UserBean");
		
		if(sUserBean != null) {
		    // inquiry user info
			UserBean user = loginDao.selectSearchIdPwd(sUserBean);
			
			// check auth no
			if(user != null) {
				// update password
				user.setUserSeq(sUserBean.getUserSeq());
				user.setUserNewPwd(param.getUserNewPwd());
				user.setAccntLockStsCd("ALS0000000001");
				loginDao.updateUserPwd(user);
				param.setResultCode("0000");		// success
				param.setMsg(messageSource.getMessage("login.pwdsearch.pwdupdate.success",null, "Error", localeResolver.resolveLocale(request)));
				httpSession.invalidate();
			} else {
				param.setResultCode("0001");		// user not found
				param.setMsg(messageSource.getMessage("login.pwdsearch.emailuserauthvalue.incorrect",null, "Error", localeResolver.resolveLocale(request)));
				return param;
			}
		} else {
			param.setResultCode("0001");		// user not found
			param.setMsg(messageSource.getMessage("cpes.error",null, "Error", localeResolver.resolveLocale(request)));
			return param;
		}
		
		return param;
	}
	
	/**
	 * update password for over duration
	 * @param param UserBean
	 * @return UserBean
	 */
	public UserBean updateOverDuraPwd(HttpServletRequest request, UserBean param) throws Exception {
		
		
		// 로그인을 한 경우, 시큐리티에서 사용자 정보를 조회한다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		param.setMngId((String) authentication.getPrincipal());

		// 현재 비밀번호를 체크 한다.
		UserBean ub = loginDao.selectSearchIdPwd(param);
		
		if(ub != null) {
			// update new password
			ub.setUserNewPwd(param.getUserNewPwd());
			ub.setAccntLockStsCd("ALS0000000001");
			loginDao.updateUserPwd(ub);
			param.setResultCode("0000");		// update password
			param.setMsg(messageSource.getMessage("login.pwdsearch.pwdupdate.success",null, "Success", localeResolver.resolveLocale(request)));
		} else {
			param.setResultCode("0001");		// user not found
			param.setMsg(messageSource.getMessage("security.error.BadCredentials",null, "Error", localeResolver.resolveLocale(request)));
			return param;
		}
		
		return param;
	}
	
	/**
	 * update password for over duration
	 * @param param UserBean
	 * @return UserBean
	 */
	public UserBean updateLogin(HttpServletRequest request, UserBean param) throws Exception {
		
		loginDao.updateLogin(param);
		
		return param;
	}
	
	
	public UserBean updateLoginFail(HttpServletRequest request, UserBean param) throws Exception {
		
		loginDao.updateLoginFail(param);
		
		return param;
	}
}
