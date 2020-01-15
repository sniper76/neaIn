package ony.cpes.internal.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.common.bean.NeaUserMngBean;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;


@Repository("EmpUserMngDAO")
public class NeaUserMngDAO extends EgovAbstractMapper{
    

	/**
	 *  selectNeaUserList
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public List<NeaUserMngBean> selectNeaUserList(NeaUserMngBean paramObj) throws Exception {
        return getSqlSession().selectList("neaUserMng.selectNeaUserList", paramObj);
    }
	
	/**
	 * selectNeaUserListTotalCount
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int selectNeaUserListTotalCount(NeaUserMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("neaUserMng.selectNeaUserListTotalCount", paramObj);
    }
	
	/**
	 * insertNeaUser
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int insertNeaUser(NeaUserMngBean paramObj) throws Exception {
        return getSqlSession().insert("setNeaUserMng.insertNeaUser", paramObj);
    }
	
	
	/**
	 * selectUserSeq
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public String selectUserSeq(NeaUserMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("neaUserMng.selectUserSeq", paramObj);
    }
	
	/**
	 * selectNeaUserMngDtl
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public NeaUserMngBean selectNeaUserMngDtl(NeaUserMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("neaUserMng.selectNeaUserMngDtl", paramObj);
    }
	
	/**
	 * updateNeaUser
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int updateNeaUser(NeaUserMngBean paramObj) throws Exception {
        return getSqlSession().insert("setNeaUserMng.updateNeaUser", paramObj);
    }
	
	
	public int deleteNeaUser(NeaUserMngBean paramObj) throws Exception {
        return getSqlSession().insert("setNeaUserMng.deleteNeaUser", paramObj);
    }
}
