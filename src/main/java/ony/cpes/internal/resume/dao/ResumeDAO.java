package ony.cpes.internal.resume.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.resume.bean.ResumeDisablBean;
import ony.cpes.internal.resume.bean.ResumeGenrlEduBean;
import ony.cpes.internal.resume.bean.ResumeHopeWorkLocBean;
import ony.cpes.internal.resume.bean.ResumeIscoBean;
import ony.cpes.internal.resume.bean.ResumeLangBean;
import ony.cpes.internal.resume.bean.ResumeLocBean;
import ony.cpes.internal.resume.bean.ResumeOtrTrngBean;
import ony.cpes.internal.resume.bean.ResumeRefmanBean;
import ony.cpes.internal.resume.bean.ResumeSkillBean;
import ony.cpes.internal.resume.bean.ResumeSpcEduBean;
import ony.cpes.internal.resume.bean.ResumeWorkExpBean;

@Repository("resumeDAO")
public class ResumeDAO extends EgovAbstractMapper{

	/*
	 * Resume Human info
	 */
	public ResumeBean selectResumeHumanInfo(ResumeBean param) {
        return getSqlSession().selectOne("resume.selectResumeHumanInfo", param);
    }

	/*
	 * Disable Option Code
	 */
	public ResumeBean selectDisableOptNm(ResumeBean param) {
        return getSqlSession().selectOne("resume.selectDisableOptNm", param);
    }

	/*
	 * Resume ISCO Info
	 */
	public List<ResumeIscoBean> selectIscoList(ResumeIscoBean param) {
        return getSqlSession().selectList("resume.selectIscoList", param);
    }

	/*
	 * Resume Prefer Work Loc
	 */
	public List<ResumeLocBean> selectPreferWorkLocList(ResumeLocBean param) {
        return getSqlSession().selectList("resume.selectPreferWorkLocList", param);
    }

	/*
	 * Resume Special Education info
	 */
	public List<ResumeSpcEduBean> selectResumeSpcEduInfo(ResumeSpcEduBean param) {
        return getSqlSession().selectList("resume.selectResumeSpcEduInfo", param);
    }

	/*
	 * Resume Other Training info
	 */
	public List<ResumeOtrTrngBean> selectResumeOtrTrngInfo(ResumeOtrTrngBean param) {
        return getSqlSession().selectList("resume.selectResumeOtrTrngInfo", param);
    }

	/*
	 * Resume Language info
	 */
	public List<ResumeLangBean> selectResumeLangInfo(ResumeLangBean param) {
        return getSqlSession().selectList("resume.selectResumeLangInfo", param);
    }

	/*
	 * Resume Work Exp info
	 */
	public List<ResumeWorkExpBean> selectResumeWorkExpInfo(ResumeWorkExpBean param) {
        return getSqlSession().selectList("resume.selectResumeWorkExpInfo", param);
    }

	/*
	 * Resume Skill info Title
	 */
	public List<ResumeSkillBean> selectResumeSkillInfo(ResumeSkillBean param) {
        return getSqlSession().selectList("resume.selectResumeSkillInfo", param);
    }

	/*
	 * Resume Skill info Dtl
	 */
	public List<ResumeSkillBean> selectResumeSkillDtlInfo(ResumeSkillBean param) {
        return getSqlSession().selectList("resume.selectResumeSkillDtlInfo", param);
    }

	/*
	 * Resume Refman Info
	 */
	public List<ResumeRefmanBean> selectResumeRefmanInfo(ResumeRefmanBean param) {
        return getSqlSession().selectList("resume.selectResumeRefmanInfo", param);
    }

	public int insertResume(ResumeBean param) {
		return getSqlSession().insert("setResume.insertResume", param);
	}

	public int insertResumeHopeWorkLoc(ResumeHopeWorkLocBean param) {
		return getSqlSession().insert("setResume.insertResumeHopeWorkLoc", param);
	}

	public int insertResumeSpecialStudy(ResumeSpcEduBean param) {
		return getSqlSession().insert("setResume.insertResumeSpecialStudy", param);
	}

	public int insertResumeOtherTrnng(ResumeOtrTrngBean param) {
		return getSqlSession().insert("setResume.insertResumeOtherTrnng", param);
	}

	public int insertResumeLang(ResumeLangBean param) {
		return getSqlSession().insert("setResume.insertResumeLang", param);
	}

	public int insertResumeWorkExp(ResumeWorkExpBean param) {
		return getSqlSession().insert("setResume.insertResumeWorkExp", param);
	}

	public int insertResumeSkill(ResumeSkillBean param) {
		return getSqlSession().insert("setResume.insertResumeSkill", param);
	}

	public int insertResumeRefMan(ResumeRefmanBean param) {
		return getSqlSession().insert("setResume.insertResumeRefMan", param);
	}

	public int insertResumeDisable(ResumeDisablBean param) {
		return getSqlSession().insert("setResume.insertResumeDisable", param);
	}

	public int insertResumeGenrlEdu(ResumeGenrlEduBean param) {
		return getSqlSession().insert("setResume.insertResumeGenrlEdu", param);
	}

	public int selectResumeTotCnt(ResumeBean param) {
		return getSqlSession().selectOne("resume.selectResumeTotCnt", param);
	}

	public int insertResumeIsco(ResumeIscoBean param) {
		return getSqlSession().insert("setResume.insertResumeIsco", param);
	}

	public List<ResumeDisablBean> selectResumeDisableDetail(ResumeBean param){
		return getSqlSession().selectList("resume.selectResumeDisableDetail", param);
	}

	public ResumeGenrlEduBean selectResumeGenrlEduDetail(ResumeBean param) {
		return getSqlSession().selectOne("resume.selectResumeGenrlEduDetail", param);
	}

	public List<ResumeSkillBean> selectResumeSkillDetail(ResumeBean param){
		return getSqlSession().selectList("resume.selectResumeSkillDetail", param);
	}

	public ResumeBean selectResumeDetail(ResumeBean param) {
		return getSqlSession().selectOne("resume.selectResumeDetail", param);
	}

	public List<ResumeIscoBean> selectResumeIsco(ResumeBean param) {
		return getSqlSession().selectList("resume.selectResumeIsco", param);
	}

	public List<ResumeRefmanBean> selectResumeRefManDetail(ResumeBean param){
		return getSqlSession().selectList("resume.selectResumeRefManDetail", param);
	}

	public int updateResume(ResumeBean param) {
		return getSqlSession().update("setResume.updateResume", param);
	}

	public int deleteResumeHopeWorkLoc(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeHopeWorkLoc", param);
	}

	public int deleteResumeGenrlEdu(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeGenrlEdu", param);
	}

	public int deleteResumeSpecialStudy(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeSpecialStudy", param);
	}

	public int deleteResumeOtherTrnng(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeOtherTrnng", param);
	}

	public int deleteResumeLang(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeLang", param);
	}

	public int deleteResumeWorkExp(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeWorkExp", param);
	}

	public int deleteResumeSkill(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeSkill", param);
	}

	public int deleteResumeRefMan(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeRefMan", param);
	}

	public int deleteResumeDisabl(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeDisabl", param);
	}

	public int deleteResumeIsco(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResumeIsco", param);
	}

	public int deleteResume(ResumeBean param) {
		return getSqlSession().update("setResume.deleteResume", param);
	}
}
