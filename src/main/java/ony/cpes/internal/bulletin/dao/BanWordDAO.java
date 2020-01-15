package ony.cpes.internal.bulletin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.bulletin.bean.BanWordBean;
import ony.cpes.internal.bulletin.bean.BulletinMNGBean;


@Repository("BanWordDAO")
public class BanWordDAO extends EgovAbstractMapper{
	
	public String selectUUID() {
        return getSqlSession().selectOne("banWord.selectUUID");
	}	
    
	public int selectBanWordTotalCount(BanWordBean param) {
        return getSqlSession().selectOne("banWord.selectBanWordTotalCount", param);
	}
    
	
	/**
	 * 금지어목록 조회
	 * @param userName
	 * @return
	 */
	public List<BanWordBean> selectBanWordList(BanWordBean param) {
        return getSqlSession().selectList("banWord.selectBanWordList", param);
    }
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public int insertBanWord(BanWordBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBanWord.insertBanWord", param);
		
		return result;
    }
	
	public int updateBanWord(BanWordBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBanWord.updateBanWord", param);
		
		return result;
    }
	
	public int deleteBanWord(BanWordBean param) {
		
		int result = 0;
		
		result = getSqlSession().update("setBanWord.deleteBanWord", param);
		
		return result;
    }
	
}
