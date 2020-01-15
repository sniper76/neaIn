package ony.cpes.internal.referral.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.referral.service.JobskReferralService;
import ony.cpes.internal.referral.dao.JobskReferralDAO;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.cpes.internal.user.bean.UserBean;

@Service("JobskReferralService")
public class JobskReferralServiceImpl implements JobskReferralService{

	@Autowired
	private JobskReferralDAO jobskReferralDAO;
	
	/**
	 * 
	 */
	@Override
	public JobskReferralBean selectJobskReferralReqList(JobskReferralBean param) throws Exception {
        
		int totalCount = jobskReferralDAO.selectJobskReferralTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);
		List<JobskReferralBean> list = jobskReferralDAO.selectJobskReferralReqList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	/**
	 * 
	 */
	public JobCenterBean selectJcList(JobskReferralBean param) throws Exception {
		JobCenterBean jcBean = new JobCenterBean();
		try {
			List<JobCenterBean> list = jobskReferralDAO.selectJcList(param);
			jcBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return jcBean;
	}
	
	
	/**
	 * 
	 */
	@Override
	public JobskReferralBean selectReferralUserSearchList(JobskReferralBean param) throws Exception {
        
		//int totalCount = jobskReferralDAO.selectJobskReferralTotalCount(param);
		List<UserBean> list = jobskReferralDAO.selectReferralUserSearchList(param);

		param.setUserList(list);
		
		return param;
    }
	
}
