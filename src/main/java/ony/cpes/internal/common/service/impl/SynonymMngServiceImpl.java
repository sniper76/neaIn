package ony.cpes.internal.common.service.impl;

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

import ony.cpes.internal.common.bean.SynonymMngBean;
import ony.cpes.internal.common.dao.SynonymMngDAO;
import ony.cpes.internal.common.service.SnonymMngService;

@Service("SnonymMngService")
public class SynonymMngServiceImpl implements SnonymMngService{
	
	private static Log log = LogFactory.getLog(SynonymMngServiceImpl.class);
	
	@Autowired
	private SynonymMngDAO synonymMngDAO;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;
	
	@Override
	/**
	 * selectSynonymMngList
	 * @param param SynonymMngBean
	 * @return SynonymMngBean
	 */
    public SynonymMngBean selectSynonymMngList(SynonymMngBean param) throws Exception {
    	
		int totalCount = synonymMngDAO.selectSynonymMngListTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);

		List<SynonymMngBean> list = synonymMngDAO.selectSynonymMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	/**
	 * insertSynonymMng
	 * @param param SynonymMngBean
	 * @return Map<String,Object>
	 */
	@Override
	public Map<String,Object> insertSynonymMng(HttpServletRequest request,SynonymMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
    	

		String uuid = (String)synonymMngDAO.selectUUID();
		param.setSynonymSeq(uuid);
		param.setUseYn("Y");
		int resultCd = synonymMngDAO.insertSynonymMng(param);
		
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
	 * deleteSynonymMng
	 * @param param SynonymMngBean
	 * @return Map<String,Object>
	 */
	@Override
	public Map<String,Object> deleteSynonymMng(HttpServletRequest request,SynonymMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		int resultCd = 0;
		
		List<String> sList = param.getSelectedList();
		for(String s : sList) {
			param.setSynonymSeq(s);
			resultCd = synonymMngDAO.deleteSynonymMng(param);
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
	 * updateSynonymMng
	 * @param param SynonymMngBean
	 * @return Map<String,Object>
	 */
	@Override
	public Map<String,Object> updateSynonymMng(HttpServletRequest request,SynonymMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
    	
		int resultCd = synonymMngDAO.updateSynonymMng(param);
		
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
