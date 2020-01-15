package ony.cpes.internal.resume.service;

import java.util.List;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.resume.bean.ResumeDisablBean;
import ony.cpes.internal.resume.bean.ResumeGenrlEduBean;
import ony.cpes.internal.resume.bean.ResumeIscoBean;
import ony.cpes.internal.resume.bean.ResumeLangBean;
import ony.cpes.internal.resume.bean.ResumeLocBean;
import ony.cpes.internal.resume.bean.ResumeOtrTrngBean;
import ony.cpes.internal.resume.bean.ResumeRefmanBean;
import ony.cpes.internal.resume.bean.ResumeSkillBean;
import ony.cpes.internal.resume.bean.ResumeSpcEduBean;
import ony.cpes.internal.resume.bean.ResumeWorkExpBean;

public interface ResumeService {

	/**
     * Resume Human Info
     *
     * @param ResumeBean
     * @return ResumeBean
     */
    public ResumeBean selectResumeHumanInfo(ResumeBean param) throws Exception;

	/**
     * Disable Option Code
     *
     * @param ResumeBean
     * @return ResumeBean
     */
    public ResumeBean selectDisableOptNm(ResumeBean param) throws Exception;

	/**
     * ISCO List
     *
     * @param ResumeBean
     * @return ResumeBean
     */
    public ResumeIscoBean selectIscoList(ResumeIscoBean param) throws Exception;

	/**
     * Prefer Work Loc List
     *
     * @param ResumeLocBean
     * @return ResumeLocBean
     */
    public ResumeLocBean selectPreferWorkLocList(ResumeLocBean param) throws Exception;

	/**
     * Resume Special Education Info
     *
     * @param ResumeSpcEduBean
     * @return ResumeSpcEduBean
     */
    public ResumeSpcEduBean selectResumeSpcEduInfo(ResumeSpcEduBean param) throws Exception;

    /**
     * Resume Other Training Info
     *
     * @param ResumeOtrTrngBean
     * @return ResumeOtrTrngBean
     */
    public ResumeOtrTrngBean selectResumeOtrTrngInfo(ResumeOtrTrngBean param) throws Exception;

	/**
     * Resume Language Info
     *
     * @param ResumeLangBean
     * @return ResumeLangBean
     */
    public ResumeLangBean selectResumeLangInfo(ResumeLangBean param) throws Exception;

	/**
     * Resume Work Exp Info
     *
     * @param ResumeWorkExpBean
     * @return ResumeWorkExpBean
     */
    public ResumeWorkExpBean selectResumeWorkExpInfo(ResumeWorkExpBean param) throws Exception;

	/**
     * Resume Skill Info Title
     *
     * @param ResumeSkillBean
     * @return ResumeSkillBean
     */
    public ResumeSkillBean selectResumeSkillInfo(ResumeSkillBean param) throws Exception;

	/**
     * Resume Skill Info Dtl
     *
     * @param ResumeSkillBean
     * @return ResumeSkillBean
     */
    public ResumeSkillBean selectResumeSkillDtlInfo(ResumeSkillBean param) throws Exception;

	/**
     * Resume Refman Info
     *
     * @param ResumeRefmanBean
     * @return ResumeRefmanBean
     */
    public ResumeRefmanBean selectResumeRefmanInfo(ResumeRefmanBean param) throws Exception;

    public List<CommDtlCdBean> selectResumeSkillList(CommDtlCdBean param)throws Exception;

    public int insertResume(ResumeBean param);

    public List<ResumeDisablBean> selectResumeDisableDetail(ResumeBean param);

    public ResumeGenrlEduBean selectResumeGenrlEduDetail(ResumeBean param);

    public List<CommDtlCdBean> selectResumeSkillForDetail(ResumeBean param) throws Exception;

    public ResumeBean selectResumeDetail(ResumeBean param);

    public List<ResumeIscoBean> selectResumeIsco(ResumeBean param);

    public List<ResumeRefmanBean> selectResumeRefManDetail(ResumeBean param);

    public List<ResumeSkillBean> selectResumeSkillDetail(ResumeBean param);

    public int updateResume(ResumeBean param);

    public String selectResumeDisableForUpdate(ResumeBean param);

    public int deleteResume(ResumeBean param);

}
