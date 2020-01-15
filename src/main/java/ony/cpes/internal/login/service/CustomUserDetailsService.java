package ony.cpes.internal.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ony.cmm.common.bean.CustomUserDetailsBean;
import ony.cmm.common.bean.CustomUserMenuInfoBean;
import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.common.service.MenuService;
import ony.cpes.internal.login.dao.LoginDAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
	@Autowired
	LoginDAO userAuthDAO;
	
	
	@Autowired
    private MenuService menuSvc;
	
	/**
     * inquiry user information
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	// 여기서의 username 은 mngId 이다.
        CustomUserDetailsBean user = userAuthDAO.selectUserById(username);
        
        if(user==null) {
        	// not found mngId
            throw new InternalAuthenticationServiceException(username);
        } else {		// get menu list
//    		메뉴 목록 조회 및 세션 처리
//            List<CustomUserMenuInfoBean> menuList = selectMenuAuthByUser(user.getUsername());
//            if (menuList != null) {
//            	user.setMenuList(menuList);
//            }
            
        	
        }
        		
        return user;
    }
 
}