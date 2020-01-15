package ony.cpes.internal.fair.service;

import ony.cpes.internal.fair.bean.FairBoothMngBean;

public interface FairBoothMngService {
	
	/**
     * 채용행사 부스 관리 목록 조회
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
    public FairBoothMngBean selectBoothRegList(FairBoothMngBean param) throws Exception;
    
    
	/**
     * 채용행사 부스 관리 등록
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
    public FairBoothMngBean mergeBoothRegMng(FairBoothMngBean param) throws Exception;


	/**
     * 채용행사 부스 관리 - 신청 목록
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	public FairBoothMngBean selectBoothReqMngList(FairBoothMngBean fairBoothMngBean) throws Exception;


	/**
     * 채용행사 부스 관리 - 예비 신청 목록
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	public FairBoothMngBean selectBoothResvMngList(FairBoothMngBean fairBoothMngBean) throws Exception;


	/**
     * 채용행사 부스 관리 - 예약상태 변경
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	public FairBoothMngBean updateBoothReqMng(FairBoothMngBean fairBoothMngBean) throws Exception;
    

	/**
     * 채용행사 부스 관리 - 기업/기관 부스 매핑 해제
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	public FairBoothMngBean deleteBoothReqMng(FairBoothMngBean fairBoothMngBean) throws Exception;


	/**
     * 채용행사 부스 관리 - 기업/기관 부스 변경
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	public FairBoothMngBean updateBoothCompnyInsttMng(FairBoothMngBean fairBoothMngBean) throws Exception;


	/**
     * 채용행사 부스 관리 - 기업/기관 선택 팝업 조회 리스트
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */	
	public FairBoothMngBean selectBoothReqListLayer(FairBoothMngBean fairBoothMngBean) throws Exception;

}
