package ony.cpes.internal.annualPlan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.annualPlan.bean.APIndicDataBean;
import ony.cpes.internal.annualPlan.bean.APYearBaseIndicBean;

@Repository("annualPlanDAO")
public class AnnualPlanDAO extends EgovAbstractMapper {

	public List<APYearBaseIndicBean> selectAnnualPlanList(APYearBaseIndicBean param){
		return getSqlSession().selectList("annualPlan.selectAnnualPlanList", param);
	}

	public int insertAnnualPlan(APYearBaseIndicBean param) {
		return getSqlSession().insert("setAnnualPlan.insertAnnualPlan", param);
	}

	public int checkDuplAnnualPlan(APYearBaseIndicBean param) {
		return getSqlSession().selectOne("annualPlan.checkDuplAnnualPlan", param);
	}

	public int insertAPIndicData(APIndicDataBean param) {
		return getSqlSession().insert("setAnnualPlan.insertAPIndicData", param);
	}

	public List<APIndicDataBean> selectAPIndicDataList(APYearBaseIndicBean param){
		return getSqlSession().selectList("annualPlan.selectAPIndicDataList", param);
	}

	public int updateAPIndicData(APIndicDataBean param) {
		return getSqlSession().update("setAnnualPlan.updateAPIndicData", param);
	}

	public int deleteAPIndicData(APIndicDataBean param) {
		return getSqlSession().delete("setAnnualPlan.deleteAPIndicData", param);
	}

}
