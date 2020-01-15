package ony.cpes.internal.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.CommCdMngBean;

@Repository("commCdDAO")
public class CommCdMngDAO extends EgovAbstractMapper{
    

	/**
	 * selectGrpCdList
	 * @param paramObj
	 * @return List<CommCdBean>
	 * @throws Exception
	 */
	public List<CommCdMngBean> selectGrpCdMngList(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().selectList("commCdMng.selectGrpCdList", paramObj);
    }
	
	/**
	 * selectGrpCdListTotalCount
	 * @param paramObj
	 * @return int
	 * @throws Exception
	 */
	public int selectGrpCdMngListTotalCount(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("commCdMng.selectGrpCdListTotalCount", paramObj);
    }
	
	/**
	 * selectChkGrpCd
	 * @param paramObj
	 * @return int
	 * @throws Exception
	 */
	public int selectChkGrpCd(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("commCdMng.selectChkGrpCd", paramObj);
    }
	
	/**
	 * insertGrpCd
	 * @param paramObj
	 * @return int
	 * @throws Exception
	 */
	public int insertGrpCdMng(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().insert("setCommCdMng.insertGrpCd", paramObj);
    }
	
	/**
	 * selectGrpCdDtl
	 * @param paramObj
	 * @return int
	 * @throws Exception
	 */
	public CommCdMngBean selectGrpCdMngDtl(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("commCdMng.selectGrpCdDtl", paramObj);
    }
	
	/**
	 * updateGrpCd
	 * @param paramObj
	 * @return int
	 * @throws Exception
	 */
	public int updateGrpCdMng(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().insert("setCommCdMng.updateGrpCd", paramObj);
    }
	
	/**
	 * deleteGrpCd
	 * @param paramObj
	 * @return int
	 * @throws Exception
	 */
	public int deleteGrpCdMng(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().insert("setCommCdMng.deleteGrpCd", paramObj);
    }
	
	/**
	 * selectDtlCdChk
	 * @param paramObj
	 * @return int
	 * @throws Exception
	 */
	public int selectDtlCdChk(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("commCdMng.selectDtlCdChk", paramObj);
    }
	
	
	public List<CommCdMngBean> selectDtlMngGrpCdList(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().selectList("commCdMng.selectDtlMngGrpCdList", paramObj);
    }
	
	public List<CommCdMngBean> selectDtlMngDtlCdList(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().selectList("commCdMng.selectDtlMngDtlCdList", paramObj);
    }
	
	public int saveDtlCdMng(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().insert("setCommCdMng.saveDtlCdMng", paramObj);
    }
	
	public int deleteDtlCdMng(CommCdMngBean paramObj) throws Exception {
        return getSqlSession().insert("setCommCdMng.deleteDtlCdMng", paramObj);
    }
}
