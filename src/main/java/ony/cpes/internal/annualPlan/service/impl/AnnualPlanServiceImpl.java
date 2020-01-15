package ony.cpes.internal.annualPlan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.annualPlan.bean.APIndicDataBean;
import ony.cpes.internal.annualPlan.bean.APYearBaseIndicBean;
import ony.cpes.internal.annualPlan.dao.AnnualPlanDAO;
import ony.cpes.internal.annualPlan.service.AnnualPlanService;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.framework.util.StringUtil;

@Service("annualPlanService")
public class AnnualPlanServiceImpl implements AnnualPlanService {

	@Autowired
	private AnnualPlanDAO annualPlanDAO;

	@Autowired
	private CommonService commonService;

	@Override
	public List<APYearBaseIndicBean> selectAnnualPlanList(APYearBaseIndicBean param) {
		param.setDepth("1");
		List<APYearBaseIndicBean> resultList = annualPlanDAO.selectAnnualPlanList(param);

		for(APYearBaseIndicBean APYearBaseIndicBean : resultList) {
			param.setDepth("2");
			param.setUpperYearBaseIndicSeq(APYearBaseIndicBean.getYearBaseIndicSeq());
			List<APYearBaseIndicBean> depth2List = annualPlanDAO.selectAnnualPlanList(param);
			APYearBaseIndicBean.setUnderList(depth2List);

			for(APYearBaseIndicBean depth2 : depth2List) {
				param.setDepth("3");
				param.setUpperYearBaseIndicSeq(depth2.getYearBaseIndicSeq());
				depth2.setUnderList(annualPlanDAO.selectAnnualPlanList(param));
			}

		}

		return resultList;
	}

	@Override
	public int insertAnnualPlan(APYearBaseIndicBean param) {
		int result = 0;

		if(annualPlanDAO.checkDuplAnnualPlan(param) == 0) {
			result += annualPlanDAO.insertAnnualPlan(param);
		}else {
			result = 99;
		}

		return result;
	}

	@Override
	public List<APYearBaseIndicBean> selectAPDepthList(APYearBaseIndicBean param) {
		return annualPlanDAO.selectAnnualPlanList(param);
	}

	@Override
	public int insertAPIndicData(APIndicDataBean param) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		int result = 0;
		List<APIndicDataBean> paramList = mapper.readValue(param.getListStr(), new TypeReference<List<APIndicDataBean>>(){});

		List<JobCenterBean> jobCenterList = commonService.selectJobCenterListForSelectBox();

		for(APIndicDataBean indicDataBean : paramList) {

			if(!StringUtil.isEmpty(indicDataBean.getJcCd())) {
				if(StringUtil.isEmpty(indicDataBean.getIndicDataSeq())) {
					indicDataBean.setRegUserSeq(param.getRegUserSeq());
					indicDataBean.setModUserSeq(param.getModUserSeq());
					result += annualPlanDAO.insertAPIndicData(indicDataBean);
				}else {
					indicDataBean.setModUserSeq(param.getModUserSeq());
					result += annualPlanDAO.updateAPIndicData(indicDataBean);
				}
			}else {

				if(!StringUtil.isEmpty(indicDataBean.getIndicDataSeq())) {
					annualPlanDAO.deleteAPIndicData(indicDataBean);
				}

				for(JobCenterBean jobCenterBean : jobCenterList) {
					indicDataBean.setRegUserSeq(param.getRegUserSeq());
					indicDataBean.setModUserSeq(param.getModUserSeq());
					indicDataBean.setJcCd(jobCenterBean.getJcCd());
					result += annualPlanDAO.insertAPIndicData(indicDataBean);
				}

			}

		}

		return result;
	}

	@Override
	public List<APYearBaseIndicBean> selectAPIndicDataList(List<APYearBaseIndicBean> paramList, APYearBaseIndicBean param) {

		for(APYearBaseIndicBean APYearBaseIndicBean : paramList) {
			APYearBaseIndicBean.setJcCd(param.getJcCd());
			List<APIndicDataBean> dataList = annualPlanDAO.selectAPIndicDataList(APYearBaseIndicBean);
			APYearBaseIndicBean.setDefaultDataList();

			for(APIndicDataBean depth1Target : APYearBaseIndicBean.getDataList()) {
				for(APIndicDataBean depth1Data : dataList) {
					if(depth1Target.getMonth().equals(depth1Data.getMonth())) {
						depth1Target.setIndicDataSeq(depth1Data.getIndicDataSeq());
						depth1Target.setYearBaseIndicSeq(depth1Data.getYearBaseIndicSeq());
						depth1Target.setContent(depth1Data.getContent());
						depth1Target.setResult(depth1Data.getResult());
					}
				}
			}

			for(APYearBaseIndicBean depth2 : APYearBaseIndicBean.getUnderList()) {
				depth2.setJcCd(param.getJcCd());
				List<APIndicDataBean> dataList2 = annualPlanDAO.selectAPIndicDataList(depth2);
				depth2.setDefaultDataList();

				for(APIndicDataBean depth2Target : depth2.getDataList()) {
					for(APIndicDataBean depth2Data : dataList2) {
						if(depth2Target.getMonth().equals(depth2Data.getMonth())) {
							depth2Target.setIndicDataSeq(depth2Data.getIndicDataSeq());
							depth2Target.setYearBaseIndicSeq(depth2Data.getYearBaseIndicSeq());
							depth2Target.setContent(depth2Data.getContent());
							depth2Target.setResult(depth2Target.getResult());
						}
					}
				}

				for(APYearBaseIndicBean depth3 : depth2.getUnderList()) {
					depth3.setJcCd(param.getJcCd());
					List<APIndicDataBean> dataList3 = annualPlanDAO.selectAPIndicDataList(depth3);
					depth3.setDefaultDataList();

					for(APIndicDataBean depth3Target : depth3.getDataList()) {
						for(APIndicDataBean depth3Data : dataList3) {
							if(depth3Target.getMonth().equals(depth3Data.getMonth())) {
								depth3Target.setIndicDataSeq(depth3Data.getIndicDataSeq());
								depth3Target.setYearBaseIndicSeq(depth3Data.getYearBaseIndicSeq());
								depth3Target.setContent(depth3Data.getContent());
								depth3Target.setResult(depth3Data.getResult());
							}
						}
					}
				}
			}
		}

		return paramList;
	}

}
