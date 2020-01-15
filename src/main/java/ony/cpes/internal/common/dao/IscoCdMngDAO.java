package ony.cpes.internal.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.IscoBean;
import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.common.bean.IscoCdMngBean;

@Repository("iscoCdMngDAO")
public class IscoCdMngDAO extends EgovAbstractMapper{
    

	/**
	 * selectGrpCdList
	 * @param paramObj
	 * @return List<CommCdBean>
	 * @throws Exception
	 */
	public List<IscoCdMngBean> selectIscoCdMngList(IscoCdMngBean paramObj) throws Exception {
        return getSqlSession().selectList("iscoCdMng.selectIscoCdMngList", paramObj);
    }
	
	/**
	 * selectGrpCdListTotalCount
	 * @param paramObj
	 * @return int
	 * @throws Exception
	 */
	public int selectIscoCdMngListTotalCount(IscoCdMngBean paramObj) throws Exception {
        return getSqlSession().selectOne("iscoCdMng.selectIscoCdMngListTotalCount", paramObj);
    }
	
	public List<IscoBean> selectIscoOneList(IscoCdMngBean paramObj) throws Exception {
        return getSqlSession().selectList("iscoCdMng.selectIscoOneList", paramObj);
    }
	
	public List<IscoBean> selectIscoTwoList(IscoBean param) {
        return getSqlSession().selectList("iscoCdMng.selectIscoTwoList", param);
    }
	
	public List<IscoBean> selectIscoThreeList(IscoBean param) {
        return getSqlSession().selectList("iscoCdMng.selectIscoThreeList", param);
    }
	
	public int insertIscoCdMng(IscoCdMngBean paramObj) throws Exception {
        return getSqlSession().insert("setIscoCdMng.insertIscoCdMng", paramObj);
    }
	
	public int selectIscoIdGet() throws Exception {
        return getSqlSession().selectOne("iscoCdMng.selectIscoIdGet");
    }
	
	public String selectIscoSeq() {
        return getSqlSession().selectOne("iscoCdMng.selectIscoSeq");
	}
	
	public IscoCdMngBean selectIscoCdMngDetail(IscoCdMngBean param) {
        return getSqlSession().selectOne("iscoCdMng.selectIscoCdMngDetail",param);
	}
	
	public int updateIscoCdMng(IscoCdMngBean paramObj) throws Exception {
        return getSqlSession().insert("setIscoCdMng.updateIscoCdMng", paramObj);
    }
	
}
