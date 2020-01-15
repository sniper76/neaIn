package ony.cpes.internal.lmi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.lmi.bean.LmiIndicDataBean;
import ony.cpes.internal.lmi.bean.LmiYearBaseIndicBean;

@Repository("lmiDAO")
public class LmiDAO extends EgovAbstractMapper{

	public List<LmiYearBaseIndicBean> selectLmiDepthList(LmiYearBaseIndicBean param){
		return getSqlSession().selectList("lmi.selectLmiDepthList", param);
	}

	public int insertLmi(LmiYearBaseIndicBean param) {
		return getSqlSession().insert("setLmi.insertLmi", param);
	}

	public int checkDuplLmi(LmiYearBaseIndicBean param) {
		return getSqlSession().selectOne("lmi.checkDuplLmi", param);
	}

	public int insertLmiIndicData(LmiIndicDataBean param) {
		return getSqlSession().insert("setLmi.insertLmiIndicData", param);
	}

	public int updateLmiIndicData(LmiIndicDataBean param) {
		return getSqlSession().update("setLmi.updateLmiIndicData", param);
	}
}
