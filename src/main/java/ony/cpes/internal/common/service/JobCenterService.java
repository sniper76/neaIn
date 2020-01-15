package ony.cpes.internal.common.service;

import java.util.List;
import java.util.Map;

import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;



public interface JobCenterService {
    

	/**
	 * inquiry of job_center info
	 * @param username
	 * @return
	 */
	public JobCenterBean selectJobCenterList(JobCenterBean param) throws Exception;
	
	/**
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> insertJobCenter(JobCenterBean param) throws Exception;
	
	/**
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JobCenterBean selectJobCenterDtl(JobCenterBean param) throws Exception;
	
	
	public Map<String,Object> updateJobCenter(JobCenterBean param) throws Exception;
	
	public Map<String,Object> deleteJobCenterDtl(JobCenterBean param) throws Exception;
	
}