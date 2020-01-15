package ony.cpes.internal.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.IscoBean;
import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.common.bean.IscedCdMngBean;
import ony.cpes.internal.common.bean.IscoCdMngBean;

@Repository("iscedCdMngDAO")
public class IscedCdMngDAO extends EgovAbstractMapper{
    

	/**
	 * selectGrpCdList
	 * @param paramObj
	 * @return List<CommCdBean>
	 * @throws Exception
	 */
	public List<IscedCdMngBean> selectIscedCdMngList(IscedCdMngBean paramObj) throws Exception {
        return getSqlSession().selectList("iscedCdMng.selectIscedCdMngList", paramObj);
    }
	
	/**
	 * selectGrpCdListTotalCount
	 * @param paramObj
	 * @return int
	 * @throws Exception
	 */
	public int selectIscedCdMngListTotalCount(IscedCdMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("iscedCdMng.selectIscedCdMngListTotalCount", paramObj);
    }
	
	public List<IscedCdMngBean> selectIscedOneList(IscedCdMngBean paramObj) throws Exception {
        return getSqlSession().selectList("iscedCdMng.selectIscedOneList", paramObj);
    }
	
	public List<IscedCdMngBean> selectIscedTwoList(IscedCdMngBean paramObj) throws Exception {
        return getSqlSession().selectList("iscedCdMng.selectIscedTwoList", paramObj);
    }
	
	public List<IscedCdMngBean> selectIscedThreeList(IscedCdMngBean paramObj) throws Exception {
        return getSqlSession().selectList("iscedCdMng.selectIscedThreeList", paramObj);
    }
	
	public int insertIscedCdMng(IscedCdMngBean paramObj) throws Exception {
        return getSqlSession().insert("setIscedCdMng.insertIscedCdMng", paramObj);
    }
	
	public String selectIscedIdGet() throws Exception {
        return getSqlSession().selectOne("iscedCdMng.selectIscedIdGet");
    }
	
	public String selectIscedSeq() {
        return getSqlSession().selectOne("iscedCdMng.selectIscedSeq");
	}
	
	public IscedCdMngBean selectIscedCdMngDetail(IscedCdMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("iscedCdMng.selectIscedCdMngDetail", paramObj);
    }
	
	public int updateIscedCdMng(IscedCdMngBean paramObj) throws Exception {
        return getSqlSession().insert("setIscedCdMng.updateIscedCdMng", paramObj);
    }
	
	
}
