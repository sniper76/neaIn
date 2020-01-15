package ony.cpes.internal.common.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.common.dao.CommCdMngDAO;
import ony.cpes.internal.common.service.CommCdMngService;
import ony.framework.bean.PagingBean;
import ony.framework.util.Encryption;


@Service("CommCdMngServiceImpl")
public class CommCdMngServiceImpl implements CommCdMngService{
	
	private static Log log = LogFactory.getLog(CommCdMngServiceImpl.class);
    
	@Autowired
	private CommCdMngDAO CommCdMngDAO;
	
	@Autowired MessageSource messageSource;
	
	
	@Autowired SessionLocaleResolver localeResolver;
	
	/**
	 * selectGrpCdList
	 * @param param
	 * @return CommCdBean
	 * @throws Exception
	 */
	public CommCdMngBean selectGrpCdMngList(CommCdMngBean param) throws Exception {
        
		int totalCount = CommCdMngDAO.selectGrpCdMngListTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);

		List<CommCdMngBean> list = CommCdMngDAO.selectGrpCdMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	
	/**
	 * selectChkGrpCd
	 * @param request,param
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String,Object> selectChkGrpCd(HttpServletRequest request,CommCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = CommCdMngDAO.selectChkGrpCd(param);
		
		if(resultCd > 0) {
			result.put("stat", "1"); //have Grp Code
			result.put("msg",messageSource.getMessage("grpcd.chk.error.msg",null, "Error", localeResolver.resolveLocale(request)));
		}else {
			result.put("stat", "0"); //Don't have Grp Code
			result.put("msg", messageSource.getMessage("grpcd.chk.sucess.msg",null, "Sucess", localeResolver.resolveLocale(request)));
		}
		
		return result;
	}
	
	/**
	 * selectChkGrpCd
	 * @param request,param
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String,Object> insertGrpCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = CommCdMngDAO.insertGrpCdMng(param);
		
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
	 * selectGrpCdDtl
	 * @param param
	 * @return CommCdBean
	 * @throws Exception
	 */
	public CommCdMngBean selectGrpCdMngDtl(CommCdMngBean param) throws Exception {
		CommCdMngBean CommCdBean = new CommCdMngBean();
		
		CommCdBean = CommCdMngDAO.selectGrpCdMngDtl(param);
		
		return CommCdBean;
	}
	
	/**
	 * updateGrpCd
	 * @param request,param
	 * @return CommCdBean
	 * @throws Exception
	 */
	public Map<String,Object> updateGrpCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = CommCdMngDAO.updateGrpCdMng(param);
		
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
	 * deleteGrpCd
	 * @param request,param
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String,Object> deleteGrpCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		int resultCd = 0;
		
		resultCd = CommCdMngDAO.selectDtlCdChk(param);
		
		if(resultCd > 0) { //Detail code already created
			result.put("stat", "1"); 
			result.put("msg", messageSource.getMessage("grpcd.chk.already.dtl",null, "Success", localeResolver.resolveLocale(request)));
			
		}else {
			resultCd = CommCdMngDAO.deleteGrpCdMng(param);
			
			if(resultCd > 0) {
				result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request))); //success
				result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
			}else {
				result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
				result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
			}
		}
		
		
		
		return result;
	}
	
	
	/**
	 * selectDtlMngGrpCdListAjax
	 * @param param
	 * @return CommCdBean
	 * @throws Exception
	 */
	public CommCdMngBean selectDtlMngGrpCdList(CommCdMngBean param) throws Exception {
        

		List<CommCdMngBean> list = CommCdMngDAO.selectDtlMngGrpCdList(param);

		param.setList(list);
		
		return param;
    }
	
	
	public CommCdMngBean selectDtlMngDtlCdList(CommCdMngBean param) throws Exception {
	        
	
		List<CommCdMngBean> list = CommCdMngDAO.selectDtlMngDtlCdList(param);

		param.setList(list);
		
		return param;
    }
	
	
	/**
	 * saveDtlCdMng
	 * @param request,param
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String,Object> saveDtlCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = CommCdMngDAO.saveDtlCdMng(param);
		
		if(resultCd > 0) {
			result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request))); //success
			result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
		}else {
			result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
			result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return result;
	}
	
	
	public Map<String,Object> deleteDtlCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = CommCdMngDAO.deleteDtlCdMng(param);
		
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
