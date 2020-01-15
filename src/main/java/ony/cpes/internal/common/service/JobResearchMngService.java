package ony.cpes.internal.common.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.common.bean.JobResearchMngBean;
import ony.cpes.internal.common.bean.NeaUserMngBean;



public interface JobResearchMngService {
    

	/**
	 * selectJobReschMngList
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JobResearchMngBean selectJobReschMngList(JobResearchMngBean param) throws Exception;
	
	/**
	 * selectCateOneList
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JobResearchMngBean selectCateOneList(JobResearchMngBean param) throws Exception;
	
	/**
	 * selectJobReschMngDtl
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JobResearchMngBean selectJobReschMngDtl(JobResearchMngBean param) throws Exception;
	
	/**
	 * updateJobReschMng
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> updateJobReschMng(HttpServletRequest request,JobResearchMngBean param) throws Exception;
	
	
}