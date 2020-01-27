package ony.cpes.internal.communityMng.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.communityMng.bean.CommunityMngBean;
import ony.cpes.internal.communityMng.dao.CommunityMngDAO;
import ony.cpes.internal.communityMng.service.CommunityMngService;
import ony.cpes.internal.fair.bean.FairWorkshopBean;

@Service("CommunityMngService")
public class CommunityMngServiceImpl implements CommunityMngService {

	@Autowired
	private CommunityMngDAO communityMngDAO;

	@Override
	public CommunityMngBean selectBanwordIncludeList(CommunityMngBean param) throws Exception{

		int totalCount = communityMngDAO.selectBanwordIncludeTotCnt(param);

		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		param.setTotalCount(totalCount);
		List<CommunityMngBean> list = communityMngDAO.selectBanwordIncludeList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	@Override
	public BulletinBean selectCommunityDetail(CommunityMngBean param) throws Exception {
		BulletinBean result = null;

		if("BULLETIN".equals(param.getContentsFlag())) {
			result = communityMngDAO.selectBulletinDetail(param);
		}else if("COMMENT".equals(param.getContentsFlag())) {
			result = communityMngDAO.selectCommentDetail(param);
		}

		return result;
	}

	@Override
	public int updateCommunityAgree(CommunityMngBean param) throws Exception {
		int result = 0;

		if("BULLETIN".equals(param.getContentsFlag())) {
			result = communityMngDAO.updateBulletinAgree(param);
		}else if("COMMENT".equals(param.getContentsFlag())) {
			result = communityMngDAO.updateCommentAgree(param);
		}

		return result;
	}

}
