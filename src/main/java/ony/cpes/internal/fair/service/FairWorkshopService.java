package ony.cpes.internal.fair.service;

import ony.cpes.internal.fair.bean.FairWorkshopBean;
import ony.cpes.internal.fair.bean.FairWorkshopPatcptnBean;

public interface FairWorkshopService {
	public FairWorkshopBean selectFairWorkshopList(FairWorkshopBean param);
	public int insertFairWorkshop(FairWorkshopBean param) throws Exception;
	public FairWorkshopBean selectWorkshopDetail(FairWorkshopBean param) throws Exception;
	public int updateFairWorkshop(FairWorkshopBean param) throws Exception;
	public int deleteFairWorkshop(FairWorkshopBean param) throws Exception;
	public FairWorkshopPatcptnBean selectWorkshopPatcptnList(FairWorkshopPatcptnBean param);
	public int updateWorkshopPatcptnJcAgreeCd(FairWorkshopPatcptnBean param);
}
