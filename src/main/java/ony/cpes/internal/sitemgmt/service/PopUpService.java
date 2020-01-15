package ony.cpes.internal.sitemgmt.service;

import java.util.Map;

import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;

public interface PopUpService {
	/**
     * 팝업 관리목록 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public PopUpBean selectPopUpList(PopUpBean param) throws Exception;
    
    
    /**
     * 팝업관리 추가
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> insertPopUp(PopUpBean param) throws Exception;
    
    /**
     * 팝업 상세 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public PopUpBean selectPopUpDtl(PopUpBean param) throws Exception;
    
    /**
     * 팝업관리 수정
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> updatePopUp(PopUpBean param) throws Exception;
    
    /**
     * 팝업관리 삭제
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> deletePopUp(PopUpBean param) throws Exception;
    
    

}
