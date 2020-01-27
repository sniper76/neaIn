package ony.cpes.internal.iscoMng.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.IscoBean;

@Repository("IscoMngDAO")
public class IscoMngDAO extends EgovAbstractMapper {

	public List<IscoBean> selectIscoMngList(IscoBean param){
		return getSqlSession().selectList("iscoMng.selectIscoMngList", param);
	}

	public int selectIscoMngTotCnt(IscoBean param) {
		return getSqlSession().selectOne("iscoMng.selectIscoMngTotCnt", param);
	}

	public IscoBean selectIscoMngDetail(IscoBean param) {
		return getSqlSession().selectOne("iscoMng.selectIscoMngDetail", param);
	}

	public int updateIscoMng(IscoBean param) {
		return getSqlSession().update("setIscoMng.updateIscoMng", param);
	}
}
