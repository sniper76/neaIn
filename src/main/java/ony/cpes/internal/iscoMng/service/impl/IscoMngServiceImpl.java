package ony.cpes.internal.iscoMng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cmm.common.bean.IscoBean;
import ony.cpes.internal.iscoMng.dao.IscoMngDAO;
import ony.cpes.internal.iscoMng.service.IscoMngService;

@Service("IscoMngService")
public class IscoMngServiceImpl implements IscoMngService {

	@Autowired
	private IscoMngDAO iscoMngDAO;

	@Override
	public IscoBean selectIscoMngList(IscoBean param) {
		int totalCount = iscoMngDAO.selectIscoMngTotCnt(param);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		param.setTotalCount(totalCount);
		List<IscoBean> list = iscoMngDAO.selectIscoMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	@Override
	public IscoBean selectIscoMngDetail(IscoBean param) {
		return iscoMngDAO.selectIscoMngDetail(param);
	}

	@Override
	public int updateIscoMng(IscoBean param) {
		return iscoMngDAO.updateIscoMng(param);
	}

}
