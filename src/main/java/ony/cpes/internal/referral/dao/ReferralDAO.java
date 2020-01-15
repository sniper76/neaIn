package ony.cpes.internal.referral.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.cpes.internal.referral.bean.ReferralBean;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.vacancy.bean.VacancyBean;


@Repository("ReferralDAO")
public class ReferralDAO extends EgovAbstractMapper{
    

	/**
	 * Referral History Management List
	 * @param ReferralBean
	 * @return List<<ReferralBean>>
	 */
	public List<ReferralBean> selectReferralHisMngList(ReferralBean paramObj) throws Exception {
        return getSqlSession().selectList("referral.selectReferralHisMngList", paramObj);
    }
	
	/**
	 * Referral History Management List Total Count
	 * @param JobCenterBean
	 * @return INT
	 */
	public int selectReferralHisMngListTotalCnt(ReferralBean paramObj) throws Exception {
        return getSqlSession().selectOne("referral.selectReferralHisMngListTotalCnt", paramObj);
    }
	
	/**
	 * Delete Referral History Management
	 * @param userName
	 * @return
	 */
	public int deleteReferralHisMngList(ReferralBean paramObj) {
		
        return getSqlSession().delete("setReferral.deleteReferralHisMngList", paramObj);
    }
	
	
	/**
	 * select referral Management 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ReferralBean selectReferralManage(ReferralBean param) throws Exception {
        return getSqlSession().selectOne("referral.selectReferralManage", param);
    }
	
	/**
	 * select referral resume 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ResumeBean selectReferralManageResume(ReferralBean param) throws Exception {
        return getSqlSession().selectOne("referral.selectReferralManageResume", param);
    }
	
	/**
	 * select referral vacancy 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public VacancyBean selectReferralManageVacancy(ReferralBean param) throws Exception {
        return getSqlSession().selectOne("referral.selectReferralManageVacancy", param);
    }
	
	/**
	 * insert referral Management
	 * @param param
	 * @return
	 */
	public int insertReferralMgmt(ReferralBean param) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("setReferral.insertReferralMgmt", param);
	}
	
	public int selectJobReferralRecordListTotalCount(ReferralBean param) {
        return getSqlSession().selectOne("referral.selectJobReferralRecordListTotalCount", param);
	}
	
	public List<ReferralBean> selectJobReferralRecordList(ReferralBean param) {
        return getSqlSession().selectList("referral.selectJobReferralRecordList", param);
    }
}
