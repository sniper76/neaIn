package ony.cpes.internal.fair.service;

import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.bean.JobFairBean;
import ony.cpes.internal.resume.bean.ResumeBean;

public interface FairVccyMngService {
	
	/**
     * 채용행사 - 운영관리 - 채용공고 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
    public FairMngBean selectEmpmnAncmtMngList(FairMngBean fairMngBean) throws Exception;


    /**
     * 채용행사 - 운영관리 - 채용공고 승인상태 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
    public FairMngBean updateEmpmnAncmtMng(FairMngBean fairMngBean) throws Exception;


	/**
     * 채용행사 - 운영관리 - 매핑 안된 채용공고 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
    public FairMngBean selectEmpmnAncmtJoinList(FairMngBean fairMngBean) throws Exception;


	/**
     * 채용행사 - 운영관리 - 매핑 안된 채용공고 매핑
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
	public FairMngBean insertEmpmnAncmtJoinArray(FairMngBean fairMngBean) throws Exception;


	/**
     * 채용행사 - 운영관리 - 입사지원 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
	public FairMngBean selectApplicMngList(FairMngBean fairMngBean) throws Exception;


	/**
     * 채용행사 - 운영관리 - 면접제의 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
	public FairMngBean selectIntvwMngList(FairMngBean fairMngBean) throws Exception;
}
