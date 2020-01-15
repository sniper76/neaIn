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
import ony.cpes.internal.common.bean.IscoCdMngBean;
import ony.cpes.internal.common.dao.IscoCdMngDAO;
import ony.cpes.internal.common.service.IscoCdMngService;
import ony.framework.bean.PagingBean;
import ony.framework.util.Encryption;


@Service("IscoCdMngServiceImpl")
public class IscoCdMngServiceImpl implements IscoCdMngService{
	
	private static Log log = LogFactory.getLog(IscoCdMngServiceImpl.class);
    
	@Autowired
	private IscoCdMngDAO iscoCdMngDAO;
	
	@Autowired MessageSource messageSource;
	
	
	@Autowired SessionLocaleResolver localeResolver;
	
	/**
	 * selectGrpCdList
	 * @param param
	 * @return CommCdBean
	 * @throws Exception
	 */
	public IscoCdMngBean selectIscoCdMngList(IscoCdMngBean param) throws Exception {
        
		int totalCount = iscoCdMngDAO.selectIscoCdMngListTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);

		List<IscoCdMngBean> list = iscoCdMngDAO.selectIscoCdMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	
	public IscoBean selectIscoOneList(IscoCdMngBean param) throws Exception {
		IscoBean iscoBean = new IscoBean();
		try {
			List<IscoBean> list = iscoCdMngDAO.selectIscoOneList(param);
			iscoBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscoBean;
	}
	
	public IscoBean selectIscoTwoList(IscoBean param) throws Exception {
		IscoBean iscoBean = new IscoBean();
		try {
			List<IscoBean> list = iscoCdMngDAO.selectIscoTwoList(param);
			iscoBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscoBean;
	}
	
	public IscoBean selectIscoThreeList(IscoBean param) throws Exception {
		IscoBean iscoBean = new IscoBean();
		try {
			List<IscoBean> list = iscoCdMngDAO.selectIscoThreeList(param);
			iscoBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscoBean;
	}
	
	
	/**
	 * insertIscoCdMng
	 * @param request,param
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String,Object> insertIscoCdMng(HttpServletRequest request,IscoCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		int iscoId = 0;
		iscoId = iscoCdMngDAO.selectIscoIdGet();
		String iscoSeq = iscoCdMngDAO.selectIscoSeq();
		
		param.setIscoId(iscoId);
		param.setIscoCd(iscoSeq);
		
		int resultCd = iscoCdMngDAO.insertIscoCdMng(param);
		
		if(resultCd > 0) {
			result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request))); //success
			result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
		}else {
			result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
			result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return result;
	}
	
	public IscoCdMngBean selectIscoCdMngDetail(IscoCdMngBean param) throws Exception {
		IscoCdMngBean IscoCdMngBean = new IscoCdMngBean();
		IscoCdMngBean = iscoCdMngDAO.selectIscoCdMngDetail(param);
		
		return IscoCdMngBean;
	}
	
	/**
	 * insertIscoCdMng
	 * @param request,param
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String,Object> updateIscoCdMng(HttpServletRequest request,IscoCdMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		
		int resultCd = iscoCdMngDAO.updateIscoCdMng(param);
		
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
