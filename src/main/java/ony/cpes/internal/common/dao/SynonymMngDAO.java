package ony.cpes.internal.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.SynonymMngBean;


@Repository("SynonymMngDAO")
public class SynonymMngDAO extends EgovAbstractMapper{
	
	public String selectUUID() {
        return getSqlSession().selectOne("synonymMng.selectUUID");
	}	
    
	public int selectSynonymMngListTotalCount(SynonymMngBean param) {
        return getSqlSession().selectOne("synonymMng.selectSynonymMngListTotalCount", param);
	}
    
	
	/**
	 * selectSynonymMngList
	 * @param param
	 * @return List<SynonymMngBean>
	 */
	public List<SynonymMngBean> selectSynonymMngList(SynonymMngBean param) {
        return getSqlSession().selectList("synonymMng.selectSynonymMngList", param);
    }
	
	/**
	 * insertSynonymMng
	 * @param param
	 * @return
	 */
	public int insertSynonymMng(SynonymMngBean param) {
			
			int result = 0;
			
			result = getSqlSession().update("setSynonymMng.insertSynonymMng", param);
			
			return result;
    }
	
	/**
	 * deleteSynonymMng
	 * @param param
	 * @return
	 */
	public int deleteSynonymMng(SynonymMngBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setSynonymMng.deleteSynonymMng", param);
		
		return result;
	}
	
	
	/**
	 * deleteSynonymMng
	 * @param param
	 * @return
	 */
	public int updateSynonymMng(SynonymMngBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setSynonymMng.updateSynonymMng", param);
		
		return result;
	}
	
}
