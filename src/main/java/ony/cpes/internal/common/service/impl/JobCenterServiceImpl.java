package ony.cpes.internal.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.common.dao.JobCenterDAO;
import ony.cpes.internal.common.service.JobCenterService;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;
import ony.framework.bean.PagingBean;


@Service("JobCenterService")
public class JobCenterServiceImpl implements JobCenterService{
    
	@Autowired
	private JobCenterDAO jobCenterDao;
	
	/**
	 * inquiry of job_center info
	 * @param username
	 * @return
	 */
	public JobCenterBean selectJobCenterList(JobCenterBean param) throws Exception {
        
		int totalCount = jobCenterDao.selectJobCenterListTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);

		List<JobCenterBean> list = jobCenterDao.selectJobCenterList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	/**
	 * 
	 */
	@Override
	public Map<String,Object> insertJobCenter(JobCenterBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
    	

		String uuid = (String)jobCenterDao.selectJcCd(param);
		param.setJcCd(uuid);
		
		int resultCd = jobCenterDao.insertJobCenter(param);
		
		if(resultCd > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
	/** JobCenter detail
	 * @param param
	 * @return JobCenterBean
	 */
	@Override
	public JobCenterBean selectJobCenterDtl(JobCenterBean param) throws Exception {
		JobCenterBean jobCenterBean = new JobCenterBean();
		
		jobCenterBean = jobCenterDao.selectJobCenterDtl(param);
		
		return jobCenterBean;
    }
	
	/**
	 * JobCenter update
	 * @param param JobCenterBean
	 * @return Map
	 */
	@Override
	public Map<String,Object> updateJobCenter(JobCenterBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = jobCenterDao.updateJobCenter(param);
		
		if(resultCd > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
	/**
	 * JobCenter delete
	 * @param param JobCenterBean
	 * @return Map
	 */
	@Override
	public Map<String,Object> deleteJobCenterDtl(JobCenterBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = jobCenterDao.deleteJobCenterDtl(param);
		
		if(resultCd > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
}
