package ony.cpes.internal.referral.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.cpes.internal.user.bean.UserBean;


@Repository("JobskReferralDAO")
public class JobskReferralDAO extends EgovAbstractMapper{
    

	public List<JobskReferralBean> selectJobskReferralReqList(JobskReferralBean param) {
        return getSqlSession().selectList("jobskReferral.selectJobskReferralReqList", param);
    }
	
	public int selectJobskReferralTotalCount(JobskReferralBean param) {
        return getSqlSession().selectOne("jobskReferral.selectJobskReferralTotalCount", param);
	}
	
	public List<JobCenterBean> selectJcList(JobskReferralBean param) {
        return getSqlSession().selectList("jobskReferral.selectJcList", param);
    }
	
	public List<UserBean> selectReferralUserSearchList(JobskReferralBean param) {
        return getSqlSession().selectList("jobskReferral.selectReferralUserSearchList", param);
    }
}
