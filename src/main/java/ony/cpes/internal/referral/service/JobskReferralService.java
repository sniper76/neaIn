package ony.cpes.internal.referral.service;

import java.util.List;

import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.cpes.internal.user.bean.UserBean;

public interface JobskReferralService {
	
	/**
     * Referral History Management List
     *
     * @param ReferralBean
     * @return ReferralBean
     */
    public JobskReferralBean selectJobskReferralReqList(JobskReferralBean param) throws Exception;
    
    
    public JobCenterBean selectJcList(JobskReferralBean param) throws Exception;
    
    public JobskReferralBean selectReferralUserSearchList(JobskReferralBean param) throws Exception;
    
}
