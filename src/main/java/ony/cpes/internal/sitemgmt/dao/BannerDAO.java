package ony.cpes.internal.sitemgmt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.sitemgmt.bean.BannerBean;;


@Repository("BannerDAO")
public class BannerDAO extends EgovAbstractMapper{
	
	public String getUUID() {
        return getSqlSession().selectOne("banner.getUUID");
	}	
    
	public int selectPopUpTotalCount(BannerBean param) {
        return getSqlSession().selectOne("banner.selectBannerTotalCount", param);
	}
    
	/**
	 * 사용자 조회
	 * @param userName
	 * @return
	 */
	public String selectUserInfo(Map<String,Object> param) {
        return getSqlSession().selectOne("banner.selectUserInfo", param);
	}
	
	/**
	 * 배너목록 조회
	 * @param userName
	 * @return
	 */
	public List<BannerBean> selectBannerList(BannerBean param) {
        return getSqlSession().selectList("banner.selectBannerList", param);
    }
	
	/**
	 * 배너관리 추가
	 * @param userName
	 * @return
	 */
	public int insertBanner(BannerBean param) {
        return getSqlSession().insert("setBanner.insertBanner", param);
    }
	
	/**
	 * 배너 상세 조회
	 * @param userName
	 * @return
	 */
	public BannerBean selectBannerDtl(BannerBean param) {
        return getSqlSession().selectOne("banner.selectBannerDtl", param);
	}
	
	/**
	 * 배너관리 수정
	 * @param userName
	 * @return
	 */
	public int updateBanner(BannerBean param) {
        return getSqlSession().insert("setBanner.updateBanner", param);
    }
	
	/**
	 * 배너관리 수정
	 * @param userName
	 * @return
	 */
	public int deleteBannerDtl(BannerBean param) {
        return getSqlSession().insert("setBanner.deleteBanner", param);
    }
	
	
}
