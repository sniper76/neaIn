package ony.cpes.internal.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;


@Repository("JobCenterDAO")
public class JobCenterDAO extends EgovAbstractMapper{
    

	/**
	 * inquiry of job_center info
	 * @param JobCenterBean
	 * @return List<JobCenterBean>
	 */
	public List<JobCenterBean> selectJobCenterList(JobCenterBean paramObj) throws Exception {
        return getSqlSession().selectList("jobCenter.selectJobCenterList", paramObj);
    }
	
	/**
	 * get list count
	 * @param JobCenterBean
	 * @return INT
	 */
	public int selectJobCenterListTotalCount(JobCenterBean paramObj) throws Exception {
        return getSqlSession().selectOne("jobCenter.selectJobCenterListTotalCount", paramObj);
    }
	
	public String selectJcCd(JobCenterBean paramObj) throws Exception {
        return getSqlSession().selectOne("jobCenter.selectJcCd", paramObj);
    }
	
	public int insertJobCenter(JobCenterBean paramObj) throws Exception {
        return getSqlSession().insert("setJobCenter.insertJobCenter", paramObj);
    }
	
	/**
	 * JobCenter Detail
	 * @param param
	 * @return JobCenterBean
	 */
	public JobCenterBean selectJobCenterDtl(JobCenterBean param) {
        return getSqlSession().selectOne("jobCenter.selectJobCenterDtl", param);
	}
	
	
	public int updateJobCenter(JobCenterBean paramObj) throws Exception {
        return getSqlSession().insert("setJobCenter.updateJobCenter", paramObj);
    }
	
	public int deleteJobCenterDtl(JobCenterBean paramObj) throws Exception {
        return getSqlSession().insert("setJobCenter.deleteJobCenterDtl", paramObj);
    }
}
