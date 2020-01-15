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

import ony.cmm.common.bean.IscoBean;
import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.common.bean.IscedCdMngBean;
import ony.cpes.internal.common.bean.IscoCdMngBean;
import ony.cpes.internal.common.dao.IscedCdMngDAO;
import ony.cpes.internal.common.service.IscedCdMngService;
import ony.framework.bean.PagingBean;
import ony.framework.util.Encryption;


@Service("IscedCdMngServiceImpl")
public class IscedCdMngServiceImpl implements IscedCdMngService{
	
	private static Log log = LogFactory.getLog(IscedCdMngServiceImpl.class);
    
	@Autowired
	private IscedCdMngDAO iscedCdMngDAO;
	
	@Autowired MessageSource messageSource;
	
	
	@Autowired SessionLocaleResolver localeResolver;
	
	/**
	 * selectGrpCdList
	 * @param param
	 * @return CommCdBean
	 * @throws Exception
	 */
	public IscedCdMngBean selectIscedCdMngList(IscedCdMngBean param) throws Exception {
        
		int totalCount = iscedCdMngDAO.selectIscedCdMngListTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);

		List<IscedCdMngBean> list = iscedCdMngDAO.selectIscedCdMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	public IscedCdMngBean selectIscedOneList(IscedCdMngBean param) throws Exception {
		IscedCdMngBean iscedBean = new IscedCdMngBean();
		try {
			List<IscedCdMngBean> list = iscedCdMngDAO.selectIscedOneList(param);
			iscedBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscedBean;
	}
	
	public IscedCdMngBean selectIscedTwoList(IscedCdMngBean param) throws Exception {
		IscedCdMngBean iscedBean = new IscedCdMngBean();
		try {
			List<IscedCdMngBean> list = iscedCdMngDAO.selectIscedTwoList(param);
			iscedBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscedBean;
	}
	
	public IscedCdMngBean selectIscedThreeList(IscedCdMngBean param) throws Exception {
		IscedCdMngBean iscedBean = new IscedCdMngBean();
		try {
			List<IscedCdMngBean> list = iscedCdMngDAO.selectIscedThreeList(param);
			iscedBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscedBean;
	}
	
	/**
	 * insertIscedCdMng
	 * @param request,param
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String,Object> insertIscedCdMng(HttpServletRequest request,IscedCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		String iscedId = (String) iscedCdMngDAO.selectIscedIdGet();
		String iscedSeq = iscedCdMngDAO.selectIscedSeq();
		
		param.setIscedId(iscedId);
		param.setIscedCd(iscedSeq);
		
		int resultCd = iscedCdMngDAO.insertIscedCdMng(param);
		
		if(resultCd > 0) {
			result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request))); //success
			result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
		}else {
			result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
			result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return result;
	}
	
	public IscedCdMngBean selectIscedCdMngDetail(IscedCdMngBean param) throws Exception {
		IscedCdMngBean IscedCdMngBean = new IscedCdMngBean();
		IscedCdMngBean = iscedCdMngDAO.selectIscedCdMngDetail(param);
		
		return IscedCdMngBean;
	}
	
	/**
	 * insertIscoCdMng
	 * @param request,param
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String,Object> updateIscedCdMng(HttpServletRequest request,IscedCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		
		int resultCd = iscedCdMngDAO.updateIscedCdMng(param);
		
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
