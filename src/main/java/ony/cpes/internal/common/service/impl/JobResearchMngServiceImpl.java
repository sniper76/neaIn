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

import ony.cpes.internal.bulletin.service.impl.BulletinMNGServiceImpl;
import ony.cpes.internal.common.bean.JobResearchMngBean;
import ony.cpes.internal.common.bean.NeaUserMngBean;
import ony.cpes.internal.common.dao.JobResearchMngDAO;
import ony.cpes.internal.common.service.JobResearchMngService;
import ony.framework.bean.PagingBean;
import ony.framework.util.Encryption;


@Service("JobResearchMngServiceImpl")
public class JobResearchMngServiceImpl implements JobResearchMngService{
	
	private static Log log = LogFactory.getLog(JobResearchMngServiceImpl.class);
    
	@Autowired
	private JobResearchMngDAO jobResearchMngDAO;
	
	@Autowired MessageSource messageSource;
	
	
	@Autowired SessionLocaleResolver localeResolver;
	
	/**
	 * selectJobReschMngList
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JobResearchMngBean selectJobReschMngList(JobResearchMngBean param) throws Exception {
        
		int totalCount = jobResearchMngDAO.selectJobReschMngListTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);

		List<JobResearchMngBean> list = jobResearchMngDAO.selectJobReschMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	/**
	 * selectCateOneList
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JobResearchMngBean selectCateOneList(JobResearchMngBean param) throws Exception {
		JobResearchMngBean jrVo = new JobResearchMngBean();
		try {
			List<JobResearchMngBean> list = jobResearchMngDAO.selectCateOneList(param);
			jrVo.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return jrVo;
	}
    
	/**
	 * selectJobReschMngDtl
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JobResearchMngBean selectJobReschMngDtl(JobResearchMngBean param) throws Exception {
		JobResearchMngBean jrVo = new JobResearchMngBean();
		jrVo = jobResearchMngDAO.selectJobReschMngDtl(param);
		return jrVo;
	}
	
	
	@Override
	public Map<String,Object> updateJobReschMng(HttpServletRequest request, JobResearchMngBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		int resultCd = 0;
		
		try {
			
			resultCd = jobResearchMngDAO.updateJobReschMng(param);
			
			
			if(resultCd > 0) {
				result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request))); //success
				result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
			}else {
				result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
				result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
			}
		} catch(Exception e) {
			result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
			result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return result;
	}
	
}
