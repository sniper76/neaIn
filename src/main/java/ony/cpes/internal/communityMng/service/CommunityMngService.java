package ony.cpes.internal.communityMng.service;

import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.communityMng.bean.CommunityMngBean;

public interface CommunityMngService {
	public CommunityMngBean selectBanwordIncludeList(CommunityMngBean param) throws Exception;
	public BulletinBean selectCommunityDetail(CommunityMngBean param) throws Exception;
	public int updateCommunityAgree(CommunityMngBean param) throws Exception;
}
