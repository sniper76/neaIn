package ony.cpes.internal.fair.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.fair.bean.FairWorkshopBean;
import ony.cpes.internal.fair.bean.FairWorkshopPatcptnBean;
import ony.cpes.internal.fair.dao.FairWorkshopDAO;
import ony.cpes.internal.fair.service.FairWorkshopService;
import ony.framework.util.StringUtil;

@Service("FairWorkshopService")
public class FairWorkshopServiceImpl implements FairWorkshopService {

	@Autowired
	private FairWorkshopDAO fairWorkshopDAO;

	@Autowired
	private CommonService commonService;

	@Override
	public FairWorkshopBean selectFairWorkshopList(FairWorkshopBean param) {
		int totalCount = (int) fairWorkshopDAO.selectFairWorkshopTotCnt(param);

		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		param.setTotalCount(totalCount);
		List<FairWorkshopBean> list = fairWorkshopDAO.selectFairWorkshopList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	@Override
	public int insertFairWorkshop(FairWorkshopBean param) throws Exception {

		if(!StringUtil.isEmpty(param.getUploadResult())) {
			String fileGrpSeq = commonService.dext5UploadInsert(param.getUploadResult(), param.getRegUserSeq(), "");
			param.setTeachFileGrpSeq(fileGrpSeq);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		param.setWorkshopDtDate(sdf.parse(param.getWorkshopDt()));

		int result = fairWorkshopDAO.insertFairWorkshop(param);

		return result;
	}

	@Override
	public FairWorkshopBean selectWorkshopDetail(FairWorkshopBean param) throws Exception {
		return fairWorkshopDAO.selectWorkshopDetail(param);
	}

	@Override
	public int updateFairWorkshop(FairWorkshopBean param) throws Exception {

		if(!StringUtil.isEmpty(param.getUploadResult())) {
			commonService.dext5UploadInsert(param.getUploadResult(), param.getRegUserSeq(), param.getTeachFileGrpSeq());
		}

		int result = fairWorkshopDAO.updateFairWorkshop(param);
		return result;
	}

	@Override
	public int deleteFairWorkshop(FairWorkshopBean param) throws Exception {
		if(!StringUtil.isEmpty(param.getPatcptnCnt())) {
			fairWorkshopDAO.deleteFairWorkshopPatcptn(param);
		}
		param.setDelYn("Y");
		return fairWorkshopDAO.updateFairWorkshop(param);
	}

	@Override
	public FairWorkshopPatcptnBean selectWorkshopPatcptnList(FairWorkshopPatcptnBean param) {
		int totalCount = (int) fairWorkshopDAO.selectWorkshopPatcptnTotCnt(param);

		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		param.setTotalCount(totalCount);

		List<FairWorkshopPatcptnBean> list = fairWorkshopDAO.selectWorkshopPatcptnList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	@Override
	public int updateWorkshopPatcptnJcAgreeCd(FairWorkshopPatcptnBean param) {
		return fairWorkshopDAO.updateWorkshopPatcptnJcAgreeCd(param);
	}

}
