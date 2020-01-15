package ony.cpes.internal.annualPlan.service;

import java.util.List;

import ony.cpes.internal.annualPlan.bean.APIndicDataBean;
import ony.cpes.internal.annualPlan.bean.APYearBaseIndicBean;

public interface AnnualPlanService {
	public List<APYearBaseIndicBean> selectAnnualPlanList(APYearBaseIndicBean param);
	public int insertAnnualPlan(APYearBaseIndicBean param);
	public List<APYearBaseIndicBean> selectAPDepthList(APYearBaseIndicBean param);
	public int insertAPIndicData(APIndicDataBean param) throws Exception;
	public List<APYearBaseIndicBean> selectAPIndicDataList(List<APYearBaseIndicBean> paramList, APYearBaseIndicBean param);
}
