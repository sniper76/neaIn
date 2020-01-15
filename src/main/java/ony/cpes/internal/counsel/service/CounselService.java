package ony.cpes.internal.counsel.service;

import ony.cpes.internal.counsel.bean.CounselBean;

public interface CounselService {
	
	/**
     * 상담 목록 조회
     *
     * @param CounselBean param
     * @return CounselBean
     */
    public CounselBean selectCounselList(CounselBean param) throws Exception;
    
    /**
     * 일반회원 상담내역 조회
     *
     * @param CounselBean param
     * @return CounselBean
     */
    public CounselBean selectUserCounselHis(CounselBean param) throws Exception;
    
	/**
     * 상담 상세 조회
     *
     * @param CounselBean param
     * @return CounselBean
     */
    public CounselBean selectCounselDetail(CounselBean param) throws Exception;
    
    /**
     * 상담내역 상세 조회
     *
     * @param CounselBean param
     * @return CounselBean
     */
    public CounselBean selectCounselHistDetail(CounselBean param) throws Exception;
    
	/**
     * 상담 등록
     *
     * @param CounselBean param
     * @return CounselBean
     */
    public CounselBean insertCounsel(CounselBean param) throws Exception; 
    
	/**
     * 상담 수정
     *
     * @param CounselBean param
     * @return CounselBean
     */
    public CounselBean updateCounsel(CounselBean param) throws Exception;
    
	/**
     * 상담 삭제
     *
     * @param CounselBean param
     * @return CounselBean
     */
    public CounselBean deleteCounsel(CounselBean param) throws Exception;
}
