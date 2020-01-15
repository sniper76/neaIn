package ony.cpes.internal.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import ony.cmm.common.bean.CustomUserDetailsBean;
import ony.framework.util.Encryption;


public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    private UserDetailsService userDeSer;
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        String username = (String) authentication.getPrincipal();
        
        // Encrypt SHA256
        String password = Encryption.getSHA512((String)authentication.getCredentials());
        
        CustomUserDetailsBean user = (CustomUserDetailsBean) userDeSer.loadUserByUsername(username);
        
        if(!matchPassword(password, Encryption.getSHA512(user.getPassword()))) {
        	// wrong password
            throw new BadCredentialsException(username);
        } else {
        	if (user.getPwdFailCnt() > 4) {
        		throw new CredentialsExpiredException(username);
        	} else if (!"ALS0000000001".equals(user.getAccntLockStsCd())) {			// active user Code
        		throw new DisabledException(username);
        	}
        }
 
        if(!user.isEnabled()) {
            throw new BadCredentialsException(username);
        }
        
        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
    
    private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }
 
}


