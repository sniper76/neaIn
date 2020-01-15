package ony.cpes.internal.bulletin.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.bulletin.bean.BulletinCateBean;
import ony.cpes.internal.bulletin.bean.BulletinMNGBean;

public interface BulletinMNGService {
	/**
     * 게시판 관리목록 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BulletinMNGBean selectBulletinMNGList(BulletinMNGBean param) throws Exception;
    
    /**
     * 게시판 관리 추가
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> insertBulletinMNG(HttpServletRequest request, BulletinMNGBean param,Map<String,Object> mp) throws Exception;
    
    /**
     * 게시판 관리 삭제
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> deleteBulletinMNG(BulletinMNGBean param) throws Exception;
    
    /**
     * 게시판 관리 수정
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> updateBulletinMNG(BulletinMNGBean param,Map<String,Object> mp) throws Exception;
    
    /**
     * 게시판 관리상세 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BulletinMNGBean selectBulletinMngDtl(BulletinMNGBean param) throws Exception;
    
    /**
     * 게시판 관리 카테고리 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BulletinCateBean selectBulletinCateList(BulletinMNGBean param) throws Exception;
    
    /**
     * 게시판 관리상세 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BulletinMNGBean selectBulletinMngByProgramId(BulletinMNGBean param) throws Exception;
    

}
