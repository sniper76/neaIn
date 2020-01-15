package ony.cpes.internal.fair.service;

import java.util.List;

import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;

public interface FairJoinMngService {

	/**
     * 채용행사 참가현황 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean selectJobFairJoinStsList(FairMngBean param) throws Exception;

	/**
     * 채용행사 개인회원 참가 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean selectPrivateUserJoinMngList(FairMngBean param) throws Exception;

	/**
     * 채용행사 개인회원 참가 관리 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean updatePrivateUserJoinMng(FairMngBean param) throws Exception;

	/**
     * 채용행사 기업회원 참가기업 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean selectCompnyMngList(FairMngBean param) throws Exception;

    /**
     * 채용행사 기업회원 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean selectInviteCompnyList(FairMngBean param) throws Exception;

    /**
     * 채용행사 기업회원 초청 등록
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean insertInviteCompny(FairMngBean param) throws Exception;

    /**
     * 채용행사 기업회원 참가 신청기업 승인상태 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean updateCompnyRequestMng(FairMngBean param) throws Exception;

	/**
     * 채용행사 기관회원 참가기관 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean selectInsttMngList(FairMngBean param) throws Exception;

    /**
     * 채용행사 기관회원 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean selectInviteInsttList(FairMngBean param) throws Exception;

    /**
     * 채용행사 기관회원 초청 등록
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean insertInviteInstt(FairMngBean param) throws Exception;

    /**
     * 채용행사 기업회원 참가 신청기업 승인상태 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean updateInsttRequestMng(FairMngBean param) throws Exception;

    /**
     * 채용행사 초청 대상 기업 조회
     * @param FairMngBean param
     * @return FairMngBean
     */
    public List<FairMngBean> selectCoInvitationList(FairMngBean param) throws Exception;

    /**
     * 채용행사 기업 초청
     * @param FairMngBean param
     * @return FairMngBean
     */
    public int insertFairPatcptnCompny(FairMngBean param) throws Exception;

    /**
     * 채용행사 초청 대상 교육기관 조회
     * @param FairMngBean param
     * @return FairMngBean
     */
    public List<FairMngBean> selectInsttInvitationList(FairMngBean param) throws Exception;

    /**
     * 채용행사 교육기관 초청
     * @param FairMngBean param
     * @return FairMngBean
     */
    public int insertFairPatcptnInstt(FairMngBean param) throws Exception;
}
