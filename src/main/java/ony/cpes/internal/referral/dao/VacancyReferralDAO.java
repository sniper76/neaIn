package ony.cpes.internal.referral.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.VacancyReferralBean;
import ony.cpes.internal.user.bean.UserCmpnyBean;


@Repository("VacancyReferralDAO")
public class VacancyReferralDAO extends EgovAbstractMapper{
    

	public List<VacancyReferralBean> selectVacancyReferralReqList(VacancyReferralBean param) {
        return getSqlSession().selectList("vacancyReferral.selectVacancyReferralReqList", param);
    }
	
	public int selectVacancyReferralTotalCount(VacancyReferralBean param) {
        return getSqlSession().selectOne("vacancyReferral.selectVacancyReferralTotalCount", param);
	}
	
	public List<JobCenterBean> selectJcList(VacancyReferralBean param) {
        return getSqlSession().selectList("vacancyReferral.selectJcList", param);
    }
	
	public List<UserCmpnyBean> selectReferralCmpnySearchList(VacancyReferralBean param) {
        return getSqlSession().selectList("vacancyReferral.selectReferralCmpnySearchList", param);
    }
}
