package ony.cpes.internal.referral.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.bean.LocationBean;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.common.bean.JobResearchMngBean;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.cpes.internal.referral.bean.ReferralMatchBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.resume.bean.ResumeBean;


@Repository("ReferralMatchDAO")
public class ReferralMatchDAO extends EgovAbstractMapper{
    
	/**
	 * 
	 * @param param
	 * @return
	 */
	public ReferralMatchBean selectResumeInfo(ReferralMatchBean param) {
        return getSqlSession().selectOne("referralMatch.selectResumeInfo", param);
    }
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public ReferralMatchBean selectResumeSeq(ReferralMatchBean param) {
        return getSqlSession().selectOne("referralMatch.selectResumeSeq", param);
    }
	
	/**
	 * selectCmpnyInfo
	 * @param param
	 * @return
	 */
	public ReferralMatchBean selectCmpnyInfo(ReferralMatchBean param) {
        return getSqlSession().selectOne("referralMatch.selectCmpnyInfo", param);
    }
	
	
	public List<IscoBean> selectIscoOneList(ReferralMatchBean param) {
        return getSqlSession().selectList("referralMatch.selectIscoOneList", param);
    }
	
	public List<IscoBean> selectIscoTwoList(IscoBean param) {
        return getSqlSession().selectList("referralMatch.selectIscoTwoList", param);
    }
	
	public List<IscoBean> selectIscoThreeList(IscoBean param) {
        return getSqlSession().selectList("referralMatch.selectIscoThreeList", param);
    }
	
	public List<IscoBean> selectIscoFourList(IscoBean param) {
        return getSqlSession().selectList("referralMatch.selectIscoFourList", param);
    }
	
	public List<LocationBean> selectProvincList(ReferralMatchBean param) {
        return getSqlSession().selectList("referralMatch.selectProvincList", param);
    }
	
	public List<LocationBean> selectDistrictList(LocationBean param) {
        return getSqlSession().selectList("referralMatch.selectDistrictList", param);
    }
	
	public int selectJobskReferralMatchTotalCount(ReferralMatchBean param) {
        return getSqlSession().selectOne("referralMatch.selectJobskReferralMatchTotalCount", param);
	}
	
	public List<ReferralMatchBean> selectJobskReferralMatchList(ReferralMatchBean param) {
        return getSqlSession().selectList("referralMatch.selectJobskReferralMatchList", param);
    }
	
	public int selectVacancyReferralMatchTotalCount(ReferralMatchBean param) {
        return getSqlSession().selectOne("referralMatch.selectVacancyReferralMatchTotalCount", param);
	}
	
	public List<ReferralMatchBean> selectVacancyReferralMatchList(ReferralMatchBean param) {
        return getSqlSession().selectList("referralMatch.selectVacancyReferralMatchList", param);
    }
}
