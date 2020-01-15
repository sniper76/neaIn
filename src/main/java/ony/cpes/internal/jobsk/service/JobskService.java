package ony.cpes.internal.jobsk.service;

import java.util.List;

import ony.cpes.internal.jobsk.bean.JobskBean;
import ony.cpes.internal.jobsk.bean.JobskIscoBean;
import ony.cpes.internal.jobsk.bean.JobskLocBean;
import ony.cpes.internal.jobsk.bean.JobskSpcEduBean;
import ony.cpes.internal.jobsk.bean.JobskOtrTrnngBean;
import ony.cpes.internal.jobsk.bean.JobskLangBean;
import ony.cpes.internal.jobsk.bean.JobskWorkExpBean;
import ony.cpes.internal.jobsk.bean.JobskSkillBean;
import ony.cpes.internal.jobsk.bean.JobskRcmdmanBean;
import ony.cpes.internal.jobsk.bean.JobskVacancyBean;
import ony.cpes.internal.jobsk.bean.JobskApplicBean;
import ony.cpes.internal.jobsk.bean.JobskOfferBean;
import ony.cpes.internal.jobsk.bean.JobskIntvwBean;
import ony.cpes.internal.jobsk.bean.JobskVdoIntvwBean;

public interface JobskService {
	
	/**
     * Job Seek List
     *
     * @param JobskBean
     * @return JobskBean
     */
    public JobskBean selectJobskList(JobskBean jobskBean) throws Exception;
    
    /**
     * Job Seek Detail Info Base
     *
     * @param JobskBean
     * @return JobskBean
     */
    public JobskBean selectJobskDtlInfoBase(JobskBean param) throws Exception;   
    
	/**
     * Job Seek Detail Info Disable Option
     *
     * @param JobskBean
     * @return JobskBean
     */
    public JobskBean selectJobskDisableOptNm(JobskBean param) throws Exception;  

	/**
     * Job Seek Detail Info Isco
     *
     * @param JobskIscoBean
     * @return JobskIscoBean
     */    
    public JobskIscoBean selectJobskIscoList(JobskIscoBean param) throws Exception;    
    
	/**
     * Job Seek Detail Info Prefer Work Location
     *
     * @param JobskLocBean
     * @return JobskLocBean
     */
    public JobskLocBean selectJobskPreferWorkLocList(JobskLocBean param) throws Exception; 
    
	/**
     * Job Seek Detail Info Special Education Info
     *
     * @param JobskSpcEduBean
     * @return JobskSpcEduBean
     */
    public JobskSpcEduBean selectJobskSpcEduList(JobskSpcEduBean param) throws Exception;    

    /**
     * Job Seek Detail Info Other Training Info
     *
     * @param JobskOtrTrnngBean
     * @return JobskOtrTrnngBean
     */
    public JobskOtrTrnngBean selectJobskOtrTrnngList(JobskOtrTrnngBean param) throws Exception;

    /**
     * Job Seek Detail Info Language
     *
     * @param JobskLangBean
     * @return JobskLangBean
     */
    public JobskLangBean selectJobskLangList(JobskLangBean param) throws Exception;

    /**
     * Job Seek Detail Info Work Experience
     *
     * @param JobskWorkExpBean
     * @return JobskWorkExpBean
     */
    public JobskWorkExpBean selectJobskWorkExpList(JobskWorkExpBean param) throws Exception;

    /**
     * Job Seek Detail Info Skill
     *
     * @param JobskSkillBean
     * @return JobskSkillBean
     */
    public JobskSkillBean selectJobskSkillList(JobskSkillBean param) throws Exception;

    /**
     * Job Seek Detail Info Skill Detail
     *
     * @param JobskSkillBean
     * @return JobskSkillBean
     */
    public JobskSkillBean selectJobskSkillDtlList(JobskSkillBean param) throws Exception;

    /**
     * Job Seek Detail Info Recommended man
     *
     * @param JobskRcmdmanBean
     * @return JobskRcmdmanBean
     */
    public JobskRcmdmanBean selectJobskRcmdmanList(JobskRcmdmanBean param) throws Exception;

    
	/**
     * Update Job Seek JC Agree Status
     *
     * @param UserJobskBean
     * @return JobskBean
    public JobskBean selectJobskUserSeq(JobskBean param) throws Exception;          
    public JobskBean updateJobskStsAjax(JobskBean param) throws Exception;       
    */

	/**
     * Delete Job Seek Request
     *
     * @param JobskBean
     * @return JobskBean
	*/
    public JobskBean deleteJobskRequest(JobskBean param) throws Exception;  

	/**
     * Update Job Seek Detail Info ISCO
     *
     * @param JobskIscoBean
     * @return JobskIscoBean
	*/    
    public JobskIscoBean deleteJobskDtlInfoIsco(JobskIscoBean param) throws Exception;        
    public JobskIscoBean insertJobskDtlInfoIsco(JobskIscoBean param) throws Exception;        

	/**
     * Update Job Seek Request JC Agree Status
     *
     * @param JobskIscoBean
     * @return JobskIscoBean
	*/    
    public JobskIscoBean updateJobskRequestJcAgreeSts(JobskIscoBean param) throws Exception;  
    
    
	/**
     * Job Seek Vacancy List
     *
     * @param JobskVacancyBean
     * @return JobskVacancyBean
     */
    public JobskVacancyBean selectJobskVacancyList(JobskVacancyBean param) throws Exception;
    
	/**
     * Delete Job Seek Vacancy
     *
     * @param JobskVacancyBean
     * @return JobskVacancyBean
	*/
    public JobskVacancyBean deleteJobskVacancy(JobskVacancyBean param) throws Exception;  

	/**
     * Update Job Seek Vacancy Detail Info
     *
     * @param JobskVacancyBean
     * @return JobskVacancyBean
	*/    
    public JobskVacancyBean updateJobskVacancyDtlInfo(JobskVacancyBean param) throws Exception;  
    
    
    
	/**
     * Job Seek Application List
     *
     * @param JobskApplicBean
     * @return JobskApplicBean
     */
    public JobskApplicBean selectJobskApplicList(JobskApplicBean param) throws Exception;    

	/**
     * Job Seek Offer List
     *
     * @param JobskOfferBean
     * @return JobskOfferBean
     */
    public JobskOfferBean selectJobskOfferList(JobskOfferBean param) throws Exception;    

	/**
     * Job Seek Interview List
     *
     * @param JobskIntvwBean
     * @return JobskIntvwBean
     */
    public JobskIntvwBean selectJobskIntvwList(JobskIntvwBean param) throws Exception;    

	/**
     * Job Seek Video Interview List
     *
     * @param JobskVdoIntvwBean
     * @return JobskVdoIntvwBean
     */
    public JobskVdoIntvwBean selectJobskVdoIntvwList(JobskVdoIntvwBean param) throws Exception;    

    /**
     * Job Seek Video Interview Detail Info
     *
     * @param JobskVdoIntvwBean
     * @return JobskVdoIntvwBean
     */
    public JobskVdoIntvwBean selectJobskVdoIntvwDtlInfo(JobskVdoIntvwBean param) throws Exception;
    
	/**
     * Delete Job Seek Video Interview
     *
     * @param JobskVdoIntvwBean
     * @return JobskVdoIntvwBean
	*/
    public JobskVdoIntvwBean deleteJobskVdoIntvw(JobskVdoIntvwBean param) throws Exception;  

	/**
     * Update Job Seek Video Interview Detail Info
     *
     * @param JobskVdoIntvwBean
     * @return JobskVdoIntvwBean
	*/    
    public JobskVdoIntvwBean updateJobskVdoIntvwDtlInfo(JobskVdoIntvwBean param) throws Exception;  
    
}
