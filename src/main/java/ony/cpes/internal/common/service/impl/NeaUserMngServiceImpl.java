package ony.cpes.internal.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.common.bean.NeaUserMngBean;
import ony.cpes.internal.common.dao.JobCenterDAO;
import ony.cpes.internal.common.dao.NeaUserMngDAO;
import ony.cpes.internal.common.service.NeaUserMngService;
import ony.framework.util.Encryption;


@Service("NeaUserMngServiceImpl")
public class NeaUserMngServiceImpl implements NeaUserMngService{
    
	@Autowired
	private JobCenterDAO jobCenterDao;
	
	@Autowired MessageSource messageSource;
	
	@Autowired
	private NeaUserMngDAO empUserMngDAO;
	
	@Autowired SessionLocaleResolver localeResolver;
	
	/**
	 * inquiry of job_center info
	 * @param NeaUserMngBean
	 * @return NeaUserMngBean
	 */
	public NeaUserMngBean selectNeaUserList(NeaUserMngBean param) throws Exception {
        
		int totalCount = empUserMngDAO.selectNeaUserListTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);
	    
	    String urlChk = param.getUrlChk();
	    
	    if("nea".equals(urlChk)) {
			//기관 코드
	    	param.setInsttNmCd("INC0000000001");
	    	param.setNeaJcDivCd("NJD0000000001");
		}else if("nonNea".equals(urlChk)) {
			//기관 코드
			param.setInsttNmCd("INC0000000002");
			param.setNonNeaYn("Y");
		}else if("jobCenter".equals(urlChk)) {
			//기관 코드
			param.setInsttNmCd("INC0000000003");
			param.setNeaJcDivCd("NJD0000000002");
		}

		List<NeaUserMngBean> list = empUserMngDAO.selectNeaUserList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	
	/**
	 * insertNeaUser
	 * @param NeaUserMngBean, request
	 * @return Map
	 */
	@Override
	public Map<String,Object> insertNeaUser(HttpServletRequest request, NeaUserMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		int resultCd = 0;
    	
		if(param != null) {
			String uuid = (String)empUserMngDAO.selectUserSeq(param);
			param.setUserSeq(uuid);
			String urlChk = param.getUrlChk();
			if("nea".equals(urlChk)) {
				param.setNeaJcDivCd("NJD0000000001");
				param.setNonNeaYn("N");
				param.setWorkRetireCd("WRC0000000001");
			}else if("nonNea".equals(urlChk)) {
				param.setNonNeaYn("Y");
				param.setWorkRetireCd("WRC0000000001");
			}else if("jobCenter".equals(urlChk)) {
				param.setNeaJcDivCd("NJD0000000002");
				param.setNonNeaYn("N");
				param.setWorkRetireCd("WRC0000000001");
			}
			
			param.setDelYn("N");
			param.setPwdFailCnt(0);
			param.setNewPwdApplyYn("Y");
			param.setAccntLockStsCd("ALS0000000001");
			param.setPrivateInfoUseAgreeYn("Y");
			param.setSmsNtceAgreeYn("Y");
			param.setEmailNtceAgreeYn("Y");
			param.setUserStsCd("USS0000000000");
			param.setUserAuthCd("ROLE_ADMIN");
			String incriptPass = Encryption.getSHA512(param.getUserPwd());
			param.setUserPwd(incriptPass);
			
			resultCd = empUserMngDAO.insertNeaUser(param);
		}
		
		
		if(resultCd > 0) {
			result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request))); //success
			result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
		}else {
			result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
			result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return result;
    }
	
	/**
	 * selectNeaUserMngDtl
	 * @param NeaUserMngBean
	 * @return NeaUserMngBean
	 */
	@Override
	public NeaUserMngBean selectNeaUserMngDtl(Locale locale, NeaUserMngBean param) throws Exception {
		NeaUserMngBean neaUserMngBean = new NeaUserMngBean();
		
		param.setLang(locale.getCountry().toLowerCase());
		
		neaUserMngBean = empUserMngDAO.selectNeaUserMngDtl(param);
		
		return neaUserMngBean;
	}
	
	
	/**
	 * updateNeaUser
	 * @param NeaUserMngBean, request
	 * @return Map
	 */
	@Override
	public Map<String,Object> updateNeaUser(HttpServletRequest request, NeaUserMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		int resultCd = 0;
		
		if(param != null) {
			String newPass = param.getUserPwd();
			String oldPass = param.getOldPwd();
			
			if(!oldPass.equals(newPass)) {
				param.setUserPwd(Encryption.getSHA512(newPass));
			}
			
			resultCd = empUserMngDAO.updateNeaUser(param);
		}
		
		
		
		
		if(resultCd > 0) {
			result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request))); //success
			result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
		}else {
			result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
			result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return result;
	}
	
	
	@Override
	public Map<String,Object> deleteNeaUser(HttpServletRequest request, NeaUserMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		int resultCd = 0;
		
		if(param != null) {
			param.setDelYn("Y");
			resultCd = empUserMngDAO.deleteNeaUser(param);
		}
		
		
		
		if(resultCd > 0) {
			result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request))); //success
			result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
		}else {
			result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
			result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return result;
	}
	
}
