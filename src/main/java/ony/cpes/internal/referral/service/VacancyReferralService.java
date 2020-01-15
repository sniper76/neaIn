package ony.cpes.internal.referral.service;

import java.util.List;

import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.VacancyReferralBean;
import ony.cpes.internal.user.bean.UserBean;

public interface VacancyReferralService {
	
	/**
     * Referral History Management List
     *
     * @param ReferralBean
     * @return ReferralBean
     */
    public VacancyReferralBean selectVacancyReferralReqList(VacancyReferralBean param) throws Exception;
    
    
    public JobCenterBean selectJcList(VacancyReferralBean param) throws Exception;
    
    public VacancyReferralBean selectReferralCmpnySearchList(VacancyReferralBean param) throws Exception;
    
}
