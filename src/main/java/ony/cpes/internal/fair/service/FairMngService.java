package ony.cpes.internal.fair.service;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.bean.JobFairBean;
import ony.cpes.internal.resume.bean.ResumeBean;

public interface FairMngService {
	
	/**
     * 채용행사 등록 관리 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean selectJobFairMngList(FairMngBean param) throws Exception;
    
	/**
     * 채용행사 등록 관리 목록 조회 Layer
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean selectJobFairListLayer(FairMngBean param) throws Exception;
    
    
	/**
     * 채용행사 등록 관리 상세 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean selectJobFairMngDetail(FairMngBean param) throws Exception;
    
    
	/**
     * 채용행사 등록 관리 등록
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
    public FairMngBean insertJobFairMng(FairMngBean param) throws Exception;

    
	/**
     * 채용행사 등록 관리 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
    public FairMngBean updateJobFairMng(FairMngBean param) throws Exception;

    
	/**
     * 채용행사 등록 관리 삭제
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
    public FairMngBean deleteJobFairMng(FairMngBean param) throws Exception;
    
	/**
     * Job Fair Detail Info
     *
     * @param JobFairBean
     * @return JobFairBean
     */
    public JobFairBean selectJobFairDtlInfo(JobFairBean param) throws Exception;
    
    
    public CommDtlCdBean selectLoc1DepthList() throws Exception;
}
