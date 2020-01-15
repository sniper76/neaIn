package ony.cpes.internal.trnng.service;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cpes.internal.counsel.bean.CounselBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cpes.internal.trnng.bean.EduTrnngBean;

public interface EduTrnngMngService {
	/**
     * 전공코드 목록 조회
     *
     * @param param CommDtlCdBean
     * @return CommDtlCdBean
     */
    public CommDtlCdBean selectInsttMajorCodeList(CommDtlCdBean param)  throws Exception;
    
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
	 * Education Training Detail Info
	 * @param EduTrnngBean
	 * @return EduTrnngBean
	 */
	public EduTrnngBean selectEduTrnngDtlInfo(EduTrnngBean param) throws Exception;    
}
