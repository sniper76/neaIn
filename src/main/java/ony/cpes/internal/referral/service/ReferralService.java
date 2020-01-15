package ony.cpes.internal.referral.service;

import java.util.List;
import java.util.Map;

import ony.cpes.internal.referral.bean.ReferralBean;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.vacancy.bean.VacancyBean;

public interface ReferralService {
	
	/**
     * Referral History Management List
     *
     * @param ReferralBean
     * @return ReferralBean
     */
    public List<ReferralBean> selectReferralHisMngList(ReferralBean param) throws Exception;
    
	/**
     * Referral History Delete
     *
     * @param ReferralBean
     * @return ReferralBean
     */
    public ReferralBean deleteReferralHisMngList(ReferralBean param) throws Exception;
    
    
    public ReferralBean selectReferralManage(ReferralBean param) throws Exception;
    
    public VacancyBean selectReferralManageVacancy(ReferralBean param) throws Exception;
    
    public ResumeBean selectReferralManageResume(ReferralBean param) throws Exception;
    
    public Map<String,Object> insertReferralMgmt(ReferralBean param) throws Exception;
    
    public ReferralBean selectJobReferralRecordList(ReferralBean param) throws Exception;
    
}
