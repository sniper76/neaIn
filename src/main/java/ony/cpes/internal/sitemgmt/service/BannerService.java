package ony.cpes.internal.sitemgmt.service;

import java.util.Map;


import ony.cpes.internal.sitemgmt.bean.BannerBean;

public interface BannerService {
	/**
     * 배너 관리목록 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BannerBean selectBannerList(BannerBean param) throws Exception;
    
    
    /**
     * 배너관리 추가
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> insertBanner(BannerBean param) throws Exception;
    
    /**
     * 배너 상세 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BannerBean selectBannerDtl(BannerBean param) throws Exception;
    
    /**
     * 배너관리 수정
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> updateBanner(BannerBean param) throws Exception;
    
    /**
     * 배너관리 삭제
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> deleteBannerDtl(BannerBean param) throws Exception;
    
    

}
