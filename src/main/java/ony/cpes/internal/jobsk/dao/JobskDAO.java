package ony.cpes.internal.jobsk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.jobsk.bean.JobskBean;
import ony.cpes.internal.jobsk.bean.JobskIscoBean;
import ony.cpes.internal.jobsk.bean.JobskLocBean;
import ony.cpes.internal.jobsk.bean.JobskSpcEduBean;
import ony.cpes.internal.jobsk.bean.JobskOtrTrnngBean;
import ony.cpes.internal.jobsk.bean.JobskLangBean;
import ony.cpes.internal.jobsk.bean.JobskWorkExpBean;
import ony.cpes.internal.resume.bean.ResumeLangBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.jobsk.bean.JobskSkillBean;
import ony.cpes.internal.jobsk.bean.JobskRcmdmanBean;
import ony.cpes.internal.jobsk.bean.JobskVacancyBean;
import ony.cpes.internal.jobsk.bean.JobskApplicBean;
import ony.cpes.internal.jobsk.bean.JobskOfferBean;
import ony.cpes.internal.jobsk.bean.JobskIntvwBean;
import ony.cpes.internal.jobsk.bean.JobskVdoIntvwBean;



@Repository("jobskDAO")
public class JobskDAO extends EgovAbstractMapper{
	
	/**
	 * Job Seek List
	 * @param JobskBean
	 * @return List<JobskBean>
	 */
	public List<JobskBean> selectJobskList(JobskBean param) {
        return getSqlSession().selectList("jobsk.selectJobskList", param);
    }
	
	public int selectJobskListTotalCnt(JobskBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskListTotalCnt", param);
	}
	
	/**
	 * Job Seek Detail Info Base
	 * @param JobskBean
	 * @return JobskBean
	 */
	public JobskBean selectJobskDtlInfoBase(JobskBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskDtlInfoBase", param);
    }

	/**
	 * Job Seek Detail Info Disable Option
	 * @param JobskBean
	 * @return JobskBean
	 */
	public JobskBean selectJobskDisableOptNm(JobskBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskDisableOptNm", param);
    }	

	/**
	 * Job Seek Detail Info Isco
	 * @param JobskIscoBean
	 * @return JobskIscoBean
	 */
	public List<JobskIscoBean> selectJobskIscoList(JobskIscoBean param) {
        return getSqlSession().selectList("jobsk.selectJobskIscoList", param);
    }
	
	/**
	 * Job Seek Detail Info Prefer Work Location
	 * @param JobskLocBean
	 * @return JobskLocBean
	 */	
	public List<JobskLocBean> selectJobskPreferWorkLocList(JobskLocBean param) {
        return getSqlSession().selectList("jobsk.selectJobskPreferWorkLocList", param);
    }

	/**
	 * Job Seek Detail Info Special Education
	 * @param JobskSpcEduBean
	 * @return JobskSpcEduBean
	 */		
	public List<JobskSpcEduBean> selectJobskSpcEduList(JobskSpcEduBean param) {
        return getSqlSession().selectList("jobsk.selectJobskSpcEduList", param);
    }	

	/**
	 * Job Seek Detail Info Other Training
	 * @param JobskOtrTrnngBean
	 * @return JobskOtrTrnngBean
	 */		
	public List<JobskOtrTrnngBean> selectJobskOtrTrnngList(JobskOtrTrnngBean param) {
        return getSqlSession().selectList("jobsk.selectJobskOtrTrnngList", param);
    }	

	/**
	 * Job Seek Detail Info Language
	 * @param JobskLangBean
	 * @return JobskLangBean
	 */		
	public List<JobskLangBean> selectJobskLangList(JobskLangBean param) {
        return getSqlSession().selectList("jobsk.selectJobskLangList", param);
    }

	/**
	 * Job Seek Detail Info Work Experience 
	 * @param JobskWorkExpBean
	 * @return JobskWorkExpBean
	 */		
	public List<JobskWorkExpBean> selectJobskWorkExpList(JobskWorkExpBean param) {
        return getSqlSession().selectList("jobsk.selectJobskWorkExpList", param);
    }

	/**
	 * Job Seek Detail Info Skill 
	 * @param JobskSkillBean
	 * @return JobskSkillBean
	 */		
	public List<JobskSkillBean> selectJobskSkillList(JobskSkillBean param) {
        return getSqlSession().selectList("jobsk.selectJobskSkillList", param);
    }	
	
	/**
	 * Job Seek Detail Info Skill Detail
	 * @param JobskSkillBean
	 * @return JobskSkillBean
	 */		
	public List<JobskSkillBean> selectJobskSkillDtlList(JobskSkillBean param) {
        return getSqlSession().selectList("jobsk.selectJobskSkillDtlList", param);
    }

	/**
	 * Job Seek Detail Info Recommended Man
	 * @param JobskRcmdmanBean
	 * @return JobskRcmdmanBean
	 */		
	public List<JobskRcmdmanBean> selectJobskRcmdmanList(JobskRcmdmanBean param) {
        return getSqlSession().selectList("jobsk.selectJobskRcmdmanList", param);
    }
	
	/*
	 * Update Job Seek JC Agree Status
	public JobskBean selectJobskUserSeq(JobskBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskUserSeq", param);
    }
	
	public int updateJobskStsAjax(JobskBean param) {
        return getSqlSession().update("setJobsk.udpateJobskStsAjax", param);
	}	
	*/
	
	/**
	 * Delete Job Seek Request 
	 * @param JobskBean
	 * @return
	 */
	public int deleteJobskRequest(JobskBean param) {
        return getSqlSession().update("setJobsk.deleteJobskRequest", param);
	}

	/**
	 * Update Job Seek Detail Info ISCO 
	 * @param JobskIscoBean
	 * @return
	 */	
	public int deleteJobskDtlInfoIsco(JobskIscoBean param) {
        return getSqlSession().update("setJobsk.deleteJobskDtlInfoIsco", param);
	}

	public int insertJobskDtlInfoIsco(JobskIscoBean param) {
        return getSqlSession().update("setJobsk.insertJobskDtlInfoIsco", param);
	}	

	/**
	 * Update Job Seek Request Jc Agree Status 
	 * @param JobskIscoBean
	 * @return
	 */	
	public int updateJobskRequestJcAgreeSts(JobskIscoBean param) {
        return getSqlSession().update("setJobsk.updateJobskRequestJcAgreeSts", param);
	}	
	
	/*
	 * Job Seek Vacancy List
	 */
	public List<JobskVacancyBean> selectJobskVacancyList(JobskVacancyBean param) {
        return getSqlSession().selectList("jobsk.selectJobskVacancyList", param);
    }
	
	public int selectJobskVacancyListTotalCnt(JobskVacancyBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskVacancyListTotalCnt", param);
	}
	
	/**
	 * Delete Job Seek Vacancy 
	 * @param JobskBean
	 * @return
	 */
	public int deleteJobskVacancy(JobskVacancyBean param) {
        return getSqlSession().update("setJobsk.deleteJobskVacancy", param);
	}

	/**
	 * Update Job Seek Vacancy Detail Info
	 * @param JobskVacancyBean
	 * @return
	 */	
	public int updateJobskVacancyDtlInfo(JobskVacancyBean param) {
        return getSqlSession().update("setJobsk.updateJobskVacancyDtlInfo", param);
	}	
	
	
	/*
	 * Job Seek Application List
	 */
	public List<JobskApplicBean> selectJobskApplicList(JobskApplicBean param) {
        return getSqlSession().selectList("jobsk.selectJobskApplicList", param);
    }
	
	public int selectJobskApplicListTotalCnt(JobskApplicBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskApplicListTotalCnt", param);
	}
	
	/*
	 * Job Seek Offer List
	 */
	public List<JobskOfferBean> selectJobskOfferList(JobskOfferBean param) {
        return getSqlSession().selectList("jobsk.selectJobskOfferList", param);
    }
	
	public int selectJobskOfferListTotalCnt(JobskOfferBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskOfferListTotalCnt", param);
	}	
	
	/*
	 * Job Seek Interview List
	 */
	public List<JobskIntvwBean> selectJobskIntvwList(JobskIntvwBean param) {
        return getSqlSession().selectList("jobsk.selectJobskIntvwList", param);
    }
	
	public int selectJobskIntvwListTotalCnt(JobskIntvwBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskIntvwListTotalCnt", param);
	}
	
	
	/*
	 * Job Seek Video Interview List
	 */
	public List<JobskVdoIntvwBean> selectJobskVdoIntvwList(JobskVdoIntvwBean param) {
        return getSqlSession().selectList("jobsk.selectJobskVdoIntvwList", param);
    }
	
	public int selectJobskVdoIntvwListTotalCnt(JobskVdoIntvwBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskVdoIntvwListTotalCnt", param);
	}	
	
	/**
	 * Job Seek Video Interview Detail Info
	 * @param JobskVdoIntvwBean
	 * @return JobskVdoIntvwBean
	 */	
	public JobskVdoIntvwBean selectJobskVdoIntvwDtlInfo(JobskVdoIntvwBean param) {
        return getSqlSession().selectOne("jobsk.selectJobskVdoIntvwDtlInfo", param);
    }
	
	/**
	 * Delete Job Seek Video Interview 
	 * @param JobskVdoIntvwBean
	 * @return
	 */
	public int deleteJobskVdoIntvw(JobskVdoIntvwBean param) {
        return getSqlSession().update("setJobsk.deleteJobskVdoIntvw", param);
	}

	/**
	 * Update Job Seek Video Interview Detail Info
	 * @param JobskVdoIntvwBean
	 * @return
	 */	
	public int updateJobskVdoIntvwDtlInfo(JobskVdoIntvwBean param) {
        return getSqlSession().update("setJobsk.updateJobskVdoIntvwDtlInfo", param);
	}		

}
