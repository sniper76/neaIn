package ony.cpes.internal.lmi.service;

import java.util.List;

import ony.cpes.internal.lmi.bean.LmiIndicDataBean;
import ony.cpes.internal.lmi.bean.LmiYearBaseIndicBean;

public interface LmiService {
	public List<LmiYearBaseIndicBean> selectLmiDepthList(LmiYearBaseIndicBean param);
	public int insertLmi(LmiYearBaseIndicBean param);
	public List<LmiYearBaseIndicBean> selectLmiDataList(LmiYearBaseIndicBean param);
	public int insertLmiIndicData(LmiIndicDataBean param) throws Exception;
	public int updateLmiIndicData(LmiIndicDataBean param);
}
