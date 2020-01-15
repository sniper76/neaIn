package ony.cpes.internal.bulletin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.bulletin.bean.BulletinCateBean;
import ony.cpes.internal.bulletin.bean.BulletinMNGBean;
import ony.cpes.internal.common.bean.ProgramBean;


@Repository("BulletinMNGDAO")
public class BulletinMNGDAO extends EgovAbstractMapper{
	
	public String selectUUID() {
        return getSqlSession().selectOne("bulletinMNG.selectUUID");
	}	
	
	public String selectPgmId() {
        return getSqlSession().selectOne("bulletinMNG.selectPgmId");
	}
    
	public int selectBulletinMNGTotalCount(BulletinMNGBean param) {
        return getSqlSession().selectOne("bulletinMNG.selectBulletinMNGTotalCount", param);
	}
    
	
	/**
	 * 게시판관리목록 조회
	 * @param userName
	 * @return
	 */
	public List<BulletinMNGBean> selectBulletinMNGList(BulletinMNGBean param) {
        return getSqlSession().selectList("bulletinMNG.selectBulletinMNGList", param);
    }
	
	/**
	 * 게시판관리 추가
	 * @param userName
	 * @return
	 */
	public int insertBulletinMNG(BulletinMNGBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBulletinMNG.insertBulletinMNG", param);
		
		return result;
    }
	
	/**
	 * 카테고리 추가
	 * @param userName
	 * @return
	 */
	public int insertBulletinCate(BulletinCateBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBulletinMNG.insertBulletinCate", param);
		
		return result;
    }
	
	/**
	 * 프로그램 추가
	 * @param userName
	 * @return
	 */
	public int insertProgram(ProgramBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBulletinMNG.insertProgram", param);
		
		return result;
    }
	
	
	/**
	 * 카테고리 수정
	 * @param userName
	 * @return
	 */
	public int updateBulletinCate(BulletinCateBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBulletinMNG.updateBulletinCate", param);
		
		return result;
    }
	
	/**
	 * 카테고리 삭제
	 * @param userName
	 * @return
	 */
	public int deleteBulletinCate(BulletinCateBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBulletinMNG.deleteBulletinCate", param);
		
		return result;
    }
	
	/**
	 * 게시판관리 삭제
	 * @param userName
	 * @return
	 */
	public int deleteBulletinMNG(BulletinMNGBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBulletinMNG.deleteBulletinMNG", param);
        
        return result;
    }
	
	/**
	 * 게시판관리 수정
	 * @param userName
	 * @return
	 */
	public int updateBulletinMNG(BulletinMNGBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBulletinMNG.updateBulletinMNG", param);
		
		return result;
    }
	
	/**
	 * 게시판관리 상세 조회
	 * @param userName
	 * @return
	 */
	public BulletinMNGBean selectBulletinMngDtl(BulletinMNGBean param) {
        return getSqlSession().selectOne("bulletinMNG.selectBulletinMngDtl", param);
    }
	
	/**
	 * 게시판관리 카테고리 조회
	 * @param userName
	 * @return
	 */
	public List<BulletinCateBean> selectBulletinCateList(BulletinMNGBean param) {
        return getSqlSession().selectList("bulletinMNG.selectBulletinCateList", param);
    }
	
	/**
	 * 게시판관리 카테고리 확인
	 * @param userName
	 * @return
	 */
	public int selectBulletinCate(BulletinCateBean param) {
        return getSqlSession().selectOne("bulletinMNG.selectBulletinCate", param);
    }
	
	/**
	 * 게시판관리 메뉴생성 확인
	 * @param userName
	 * @return
	 */
	public int selectMenuCnt(BulletinMNGBean param) {
        return getSqlSession().selectOne("bulletinMNG.selectMenuCnt", param);
    }
	
	
	/**
	 * 게시판관리 상세 조회
	 * @param userName
	 * @return
	 */
	public BulletinMNGBean selectBulletinMngByProgramId(BulletinMNGBean param) {
        return getSqlSession().selectOne("bulletinMNG.selectBulletinMngByProgramId", param);
    }	
	
}
