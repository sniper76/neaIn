package ony.cpes.internal.lmi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ony.cpes.internal.lmi.bean.LmiIndicDataBean;
import ony.cpes.internal.lmi.bean.LmiYearBaseIndicBean;
import ony.cpes.internal.lmi.dao.LmiDAO;
import ony.cpes.internal.lmi.service.LmiService;
import ony.framework.util.StringUtil;

@Service("LmiService")
public class LmiServiceImpl implements LmiService{

	@Autowired
	private LmiDAO lmiDAO;

	@Override
	public List<LmiYearBaseIndicBean> selectLmiDepthList(LmiYearBaseIndicBean param) {
		return lmiDAO.selectLmiDepthList(param);
	}

	@Override
	public int insertLmi(LmiYearBaseIndicBean param) {
		int result = 0;

		if(lmiDAO.checkDuplLmi(param) == 0) {
			result = lmiDAO.insertLmi(param);
		}else {
			result = 99;
		}

		return result;
	}

	@Override
	public List<LmiYearBaseIndicBean> selectLmiDataList(LmiYearBaseIndicBean param) {
		param.setDepth("1");
		List<LmiYearBaseIndicBean> resultList = lmiDAO.selectLmiDepthList(param);

		for(LmiYearBaseIndicBean lmiYearBaseIndicBean : resultList) {
			param.setDepth("2");
			param.setUpperLmiYearBaseIndicSeq(lmiYearBaseIndicBean.getLmiYearBaseIndicSeq());
			List<LmiYearBaseIndicBean> depth2List = lmiDAO.selectLmiDepthList(param);
			lmiYearBaseIndicBean.setUnderList(depth2List);

			for(LmiYearBaseIndicBean depth2 : depth2List) {
				param.setDepth("3");
				param.setUpperLmiYearBaseIndicSeq(depth2.getLmiYearBaseIndicSeq());
				depth2.setUnderList(lmiDAO.selectLmiDepthList(param));
			}
		}

		return resultList;
	}

	@Override
	public int insertLmiIndicData(LmiIndicDataBean param) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		int result = 0;
		List<LmiIndicDataBean> paramList = mapper.readValue(param.getListStr(), new TypeReference<List<LmiIndicDataBean>>(){});

		for(LmiIndicDataBean lmiIndicData : paramList) {
			lmiIndicData.setRegUserSeq(param.getRegUserSeq());
			lmiIndicData.setModUserSeq(param.getModUserSeq());

			if(!StringUtil.isEmpty(lmiIndicData.getLmiIndicDataSeq())) {
				result = lmiDAO.updateLmiIndicData(lmiIndicData);
			}else {
				result = lmiDAO.insertLmiIndicData(lmiIndicData);
			}
		}

		return result;
	}

	@Override
	public int updateLmiIndicData(LmiIndicDataBean param) {
		return lmiDAO.updateLmiIndicData(param);
	}

}
