package ony.cpes.internal.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.JobResearchMngBean;
import ony.cpes.internal.common.bean.NeaUserMngBean;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;


@Repository("jobResearchMngDAO")
public class JobResearchMngDAO extends EgovAbstractMapper{
    

	/**
	 * selectJobReschMngList
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public List<JobResearchMngBean> selectJobReschMngList(JobResearchMngBean paramObj) throws Exception {
        return getSqlSession().selectList("jobResearchMng.selectJobReschMngList", paramObj);
    }
	
	/**
	 * selectJobReschMngListTotalCount
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int selectJobReschMngListTotalCount(JobResearchMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("jobResearchMng.selectJobReschMngListTotalCount", paramObj);
    }
	
	/**
	 * selectCateOneList
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public List<JobResearchMngBean> selectCateOneList(JobResearchMngBean paramObj) throws Exception {
        return getSqlSession().selectList("jobResearchMng.selectCateOneList", paramObj);
    }
	
	/**
	 * selectJobReschMngDtl
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public JobResearchMngBean selectJobReschMngDtl(JobResearchMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("jobResearchMng.selectJobReschMngDtl", paramObj);
    }
	
	/**
	 * updateJobReschMng
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int updateJobReschMng(JobResearchMngBean paramObj) throws Exception {
		return getSqlSession().insert("setJobReschMng.updateJobReschMng", paramObj);
    }
	
	
}
