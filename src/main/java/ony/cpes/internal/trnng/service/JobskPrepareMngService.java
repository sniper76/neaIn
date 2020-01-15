package ony.cpes.internal.trnng.service;

import java.util.List;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;

public interface JobskPrepareMngService {
    
	/**
     * 주소 2 Depth 목록 조회
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
    public CommDtlCdBean selectLOC2DepthList() throws Exception;

	/**
     * 기관/훈련 목록 조회
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
    public EduTrnngMngBean selectEduTrnngList(EduTrnngMngBean param) throws Exception;
    
	/**
     * 기관/훈련 상세 조회
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
    public EduTrnngMngBean selectEduTrnngDetail(EduTrnngMngBean param) throws Exception;
    
	/**
     * 기관/훈련 수정
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
    public EduTrnngMngBean updateEduTrnng(EduTrnngMngBean param) throws Exception;

	/**
     * 기관/훈련 등록
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */    
	public EduTrnngMngBean insertEduTrnng(EduTrnngMngBean param) throws Exception;

	/**
     * 기관/훈련 삭제
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */    	
	public EduTrnngMngBean deleteEduTrnng(EduTrnngMngBean param) throws Exception;

	/**
     * 구직준비교육신청자 목록 조회
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
    public EduTrnngMngBean selectJobskPrepareSubscriberList(EduTrnngMngBean param) throws Exception;

    /**
     * 구직준비교육신청자 상태 수정
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
    public EduTrnngMngBean updateJobskPrepareSubscriber(EduTrnngMngBean param) throws Exception;
    
    public String selectUUID() throws Exception;
}
