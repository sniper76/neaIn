package ony.cpes.internal.referral.service;

import java.util.List;

import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.bean.LocationBean;
import ony.cpes.internal.referral.bean.ReferralMatchBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.resume.bean.ResumeBean;

public interface ReferralMatchService {
	
	/**
	 * referral match user info
	 * @param param
	 * @return
	 * @throws Exception
	 */
    public ReferralMatchBean selectResumeInfo(ReferralMatchBean param) throws Exception;
    
    /**
     * selectCmpnyInfo
     * @param param
     * @return
     * @throws Exception
     */
    public ReferralMatchBean selectCmpnyInfo(ReferralMatchBean param) throws Exception;
    
    
    public IscoBean selectIscoOneList(ReferralMatchBean param) throws Exception;
    
    public IscoBean selectIscoTwoList(IscoBean param) throws Exception;
    
    public IscoBean selectIscoThreeList(IscoBean param) throws Exception;
    
    public IscoBean selectIscoFourList(IscoBean param) throws Exception;
    
    public LocationBean selectProvincList(ReferralMatchBean param) throws Exception;
    
    public LocationBean selectDistrictList(LocationBean param) throws Exception;
    
    public ReferralMatchBean selectJobskReferralMatchList(ReferralMatchBean param) throws Exception;
    
    public ReferralMatchBean selectVacancyReferralMatchList(ReferralMatchBean param) throws Exception;
    
}
