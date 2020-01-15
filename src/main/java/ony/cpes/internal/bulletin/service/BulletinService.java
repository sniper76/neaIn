package ony.cpes.internal.bulletin.service;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.user.bean.UserChgBean;

public interface BulletinService {
	/**
     * 게시판 관리목록 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BulletinBean selectBulletinList(BulletinBean param) throws Exception;
    
    /**
     * 사용자정보 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public String selectUserInfo(Map<String,Object> param) throws Exception;
    
    /**
     * 게시판 설정 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BulletinBean selectBulletinConf(Map<String,Object> param) throws Exception;
    
    /**
     * 게시판 공지수 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BulletinBean selectBulletinNotiCnt(BulletinBean param) throws Exception;
    
    /**
     * 게시판 상세 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BulletinBean selectBulletinDtl(BulletinBean param) throws Exception;
    
    /**
     * 게시판 삭제
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> deleteBulletinDtl(BulletinBean param) throws Exception;
    
    /**
     * 게시판 일반 추가
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> insertBulletinBasic(BulletinBean param) throws Exception;
    
    
    
    /**
     * 게시판  수정
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public Map<String,Object> updateBulletinDtl(HttpServletRequest request, BulletinBean param, Locale locale ) throws Exception;
    
	/**
     * 게시판 FAQ 카테고리 목록 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
    public BulletinBean selectBulletinCateList(BulletinBean param) throws Exception;    
}
