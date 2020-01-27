package ony.cpes.internal.communityMng.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.communityMng.bean.CommunityMngBean;

@Repository("CommunityMngDAO")
public class CommunityMngDAO extends EgovAbstractMapper{

	public List<CommunityMngBean> selectBanwordIncludeList(CommunityMngBean param){
		return getSqlSession().selectList("communityMng.selectBanwordIncludeList", param);
	}

	public int selectBanwordIncludeTotCnt(CommunityMngBean param) {
		return getSqlSession().selectOne("communityMng.selectBanwordIncludeTotCnt", param);
	}

	public BulletinBean selectBulletinDetail(CommunityMngBean param) {
		return getSqlSession().selectOne("communityMng.selectBulletinDetail", param);
	}

	public BulletinBean selectCommentDetail(CommunityMngBean param) {
		return getSqlSession().selectOne("communityMng.selectCommentDetail", param);
	}

	public int updateBulletinAgree(CommunityMngBean param) {
		return getSqlSession().update("setCommunityMng.updateBulletinAgree", param);
	}

	public int updateCommentAgree(CommunityMngBean param) {
		return getSqlSession().update("setCommunityMng.updateCommentAgree", param);
	}

}
