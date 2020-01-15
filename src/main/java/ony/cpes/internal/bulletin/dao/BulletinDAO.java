package ony.cpes.internal.bulletin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.bulletin.bean.BulletinBean;


@Repository("BulletinDAO")
public class BulletinDAO extends EgovAbstractMapper{
	
	public String getUUID() {
        return getSqlSession().selectOne("bulletin.getUUID");
	}	
    
	public int selectBulletinBasicTotalCount(BulletinBean param) {
        return getSqlSession().selectOne("bulletin.selectBulletinBasicTotalCount", param);
	}
    
	/**
	 * 사용자 조회
	 * @param userName
	 * @return
	 */
	public String selectUserInfo(Map<String,Object> param) {
        return getSqlSession().selectOne("bulletin.selectUserInfo", param);
	}
	
	/**
	 * 총공지글수 조회
	 * @param userName
	 * @return
	 */
	public int selectBulletinNoticeCnt(BulletinBean param) {
        return getSqlSession().selectOne("bulletin.selectBulletinNoticeCnt", param);
	}
	
	/**
	 * 게시판 설정 조회
	 * @param userName
	 * @return
	 */
	public BulletinBean selectBulletinConf(Map<String,Object> param) {
        return getSqlSession().selectOne("bulletin.selectBulletinConf", param);
	}
	
	/**
	 * 게시판목록 조회
	 * @param userName
	 * @return
	 */
	public List<BulletinBean> selectBulletinBasicList(BulletinBean param) {
        return getSqlSession().selectList("bulletin.selectBulletinBasicList", param);
    }
	
	/**
	 * 게시판 일반 추가
	 * @param userName
	 * @return
	 */
	public int insertBulletinBasic(BulletinBean param) {
		
        return getSqlSession().insert("setBulletin.insertBulletinBasic", param);
    }
	
	/**
	 * 게시판 상세 조회
	 * @param userName
	 * @return
	 */
	public BulletinBean selectBulletinDtl(BulletinBean param) {
        return getSqlSession().selectOne("bulletin.selectBulletinDtl", param);
	}
	
	/**
	 * 게시판 삭제
	 * @param userName
	 * @return
	 */
	public int deleteBulletinDtl(BulletinBean param) {
		
        return getSqlSession().update("setBulletin.deleteBulletinDtl", param);
    }
	
	/**
	 * 게시판 수정
	 * @param userName
	 * @return
	 */
	public int updateBulletinDtl(BulletinBean param) {
		
        return getSqlSession().update("setBulletin.updateBulletinDtl", param);
    }

	
	/**
	 * 게시판 카테고리 목록 조회
	 * @param userName
	 * @return
	 */
	public List<BulletinBean> selectBulletinCateList(BulletinBean param) {
        return getSqlSession().selectList("bulletin.selectBulletinCateList", param);
    }
}
