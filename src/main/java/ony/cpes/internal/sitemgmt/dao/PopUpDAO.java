package ony.cpes.internal.sitemgmt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;


@Repository("PopUpDAO")
public class PopUpDAO extends EgovAbstractMapper{
	
	public String getUUID() {
        return getSqlSession().selectOne("popUp.getUUID");
	}	
    
	public int selectPopUpTotalCount(PopUpBean param) {
        return getSqlSession().selectOne("popUp.selectPopUpTotalCount", param);
	}
    
	/**
	 * 사용자 조회
	 * @param userName
	 * @return
	 */
	public String selectUserInfo(Map<String,Object> param) {
        return getSqlSession().selectOne("popUp.selectUserInfo", param);
	}
	
	/**
	 * 팝업목록 조회
	 * @param userName
	 * @return
	 */
	public List<PopUpBean> selectPopUpList(PopUpBean param) {
        return getSqlSession().selectList("popUp.selectPopUpList", param);
    }
	
	/**
	 * 팝업관리 추가
	 * @param userName
	 * @return
	 */
	public int insertPopUp(PopUpBean param) {
        return getSqlSession().insert("setPopUp.insertPopUp", param);
    }
	
	/**
	 * 팝업 상세 조회
	 * @param userName
	 * @return
	 */
	public PopUpBean selectPopUpDtl(PopUpBean param) {
        return getSqlSession().selectOne("popUp.selectPopUpDtl", param);
	}
	
	/**
	 * 팝업관리 수정
	 * @param userName
	 * @return
	 */
	public int updatePopUp(PopUpBean param) {
        return getSqlSession().insert("setPopUp.updatePopUp", param);
    }
	
	
	/**
	 * 팝업관리 삭제
	 * @param userName
	 * @return
	 */
	public int deletePopUp(PopUpBean param) {
        return getSqlSession().insert("setPopUp.deletePopUp", param);
    }
	
}
