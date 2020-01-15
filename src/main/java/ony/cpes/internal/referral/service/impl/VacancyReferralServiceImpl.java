package ony.cpes.internal.referral.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.referral.service.VacancyReferralService;
import ony.cpes.internal.referral.dao.VacancyReferralDAO;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.VacancyReferralBean;
import ony.cpes.internal.user.bean.UserCmpnyBean;

@Service("VacancyReferralService")
public class VacancyReferralServiceImpl implements VacancyReferralService{

	@Autowired
	private VacancyReferralDAO vacancyReferralDAO;
	
	/**
	 * 
	 */
	@Override
	public VacancyReferralBean selectVacancyReferralReqList(VacancyReferralBean param) throws Exception {
        
		int totalCount = vacancyReferralDAO.selectVacancyReferralTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);
		List<VacancyReferralBean> list = vacancyReferralDAO.selectVacancyReferralReqList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	/**
	 * 
	 */
	public JobCenterBean selectJcList(VacancyReferralBean param) throws Exception {
		JobCenterBean jcBean = new JobCenterBean();
		try {
			List<JobCenterBean> list = vacancyReferralDAO.selectJcList(param);
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
	public VacancyReferralBean selectReferralCmpnySearchList(VacancyReferralBean param) throws Exception {
        
		//int totalCount = jobskReferralDAO.selectJobskReferralTotalCount(param);
		List<UserCmpnyBean> list = vacancyReferralDAO.selectReferralCmpnySearchList(param);

		param.setCmpnyList(list);
		
		return param;
    }
	
}
