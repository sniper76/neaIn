package ony.cpes.internal.user.service.impl;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.user.bean.UserChgBean;
import ony.cpes.internal.user.dao.UserChgDAO;
import ony.cpes.internal.user.service.UserChgService;

@Service("UserChgService")
public class UserChgServiceImpl implements UserChgService{

	@Autowired
	private UserChgDAO userChgDAO;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;
	
	/**
	 * User List
	 * @param UserBean
	 * @return UserBean
	 */
	@Override
	public UserChgBean selectUserChgList(UserChgBean param) throws Exception {

		int totalCount = (int) userChgDAO.selectUserChgListTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<UserChgBean> list = userChgDAO.selectUserChgList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * User Detail List
	 * @param UserBean
	 * @return UserBean
	 */
	@Override
	public UserChgBean selectUserChgDetail(UserChgBean param) throws Exception {

		UserChgBean userChg = userChgDAO.selectUserChgDetail(param);

		if ("CAS0000000002".equals(userChg.getChgAgreeStsCd()) || "CAS0000000003".equals(userChg.getChgAgreeStsCd())) {
			userChg.setDisable("true");
		}
		
		return userChg;
	}	
	
	
	public UserChgBean updateUserChgSts(HttpServletRequest request, UserChgBean param, Locale locale) throws Exception {
		try {
			if(param.getUserChgSeq() != null && !"".equals(param.getUserChgSeq())) {
				
				String[] arrSeq = param.getUserChgSeq().split(",");
				
				for(String seq : arrSeq) {
					param.setUserChgSeq(seq);
					UserChgBean userChgBean = userChgDAO.selectUserChgDetail(param);
					
					if("CAS0000000001".equals(userChgBean.getChgAgreeStsCd())) {
						param.setChgPrevCd(userChgBean.getChgPrevCd());
						param.setChgNextCd(userChgBean.getChgNextCd());
						param.getUser().setUserSeq(userChgBean.getUser().getUserSeq());
						
						int result = userChgDAO.updateUserChgSts(param);
						if (result > 0) {
			
							param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
							param.setMsg(messageSource.getMessage("cpes.success.msg",null, "0000", localeResolver.resolveLocale(request)));
							
							// if agree then change user Auth code
							if("CAS0000000002".equals(param.getChgAgreeStsCd()))
								userChgDAO.updateUserChgAuthCd(param);
						}
					}
				}
			} else {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
			}
			
		}catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		return param;
	}
}
