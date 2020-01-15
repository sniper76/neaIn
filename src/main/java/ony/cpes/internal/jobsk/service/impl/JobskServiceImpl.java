package ony.cpes.internal.jobsk.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


import ony.cpes.internal.jobsk.service.JobskService;
import ony.cpes.internal.jobsk.dao.JobskDAO;
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

@Service("JobskService")
public class JobskServiceImpl implements JobskService{

	@Autowired
	private JobskDAO jobskDAO;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;	
	
	/**
	 * Job Seek List
	 * @param UserJobskBean
	 * @return List<JobskBean>
	 */
	@Override
	public JobskBean selectJobskList(JobskBean param) throws Exception {
		if (param.getSrchDivCd() != null && param.getSrchDivCd() != "") {
			if (param.getSrchDivCd().toString().equals("SUD0000000001")) {
				//USER NAME
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserNm(param.getSrchDivKeyword().toString());
				}
			} 
			else if (param.getSrchDivCd().toString().equals("SUD0000000002")){
				//USER EMAIL
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserEmail(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SUD0000000003")){
				//USER CELL
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserCell(param.getSrchDivKeyword().toString());
				}
			}
		}
		
		int totalCount = (int) jobskDAO.selectJobskListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<JobskBean> list = jobskDAO.selectJobskList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * Job Seek Detail Info Base
	 * @param JobskBean
	 * @return JobskBean
	 */
	@Override
	public JobskBean selectJobskDtlInfoBase(JobskBean param) throws Exception {
		return jobskDAO.selectJobskDtlInfoBase(param);
	}
	
	/**
	 * Job Seek Detail Info Disable Option Code
	 * @param JobskBean
	 * @return JobskBean
	 */
	@Override	
	public JobskBean selectJobskDisableOptNm(JobskBean param) throws Exception	{
		return jobskDAO.selectJobskDisableOptNm(param);
	}
	
	/**
	 * Job Seek Detail Info Disable Option Code
	 * @param JobskIscoBean
	 * @return JobskIscoBean
	 */
	@Override
	public JobskIscoBean selectJobskIscoList(JobskIscoBean param) throws Exception {
		List<JobskIscoBean> list = jobskDAO.selectJobskIscoList(param);
		param.setList(list);

		return param;
	}	
	
	/**
	 * Job Seek Detail Info Prefer Work Loc Info
	 * @param JobskLocBean
	 * @return JobskLocBean
	 */
	@Override
	public JobskLocBean selectJobskPreferWorkLocList(JobskLocBean param) throws Exception {
		List<JobskLocBean> list = jobskDAO.selectJobskPreferWorkLocList(param);
		param.setList(list);

		return param;
	}		
	
	/**
     * Job Seek Detail Info Special Education Info
     *
     * @param JobskSpcEduBean
     * @return JobskSpcEduBean
     */
	@Override
	public JobskSpcEduBean selectJobskSpcEduList(JobskSpcEduBean param) throws Exception {
		List<JobskSpcEduBean> list = jobskDAO.selectJobskSpcEduList(param);
		param.setList(list);

		return param;
	}
	
	/**
	 * Job Seek Detail Info Other Training Info
	 * @param JobskOtrTrnngBean
	 * @return JobskOtrTrnngBean
	 */
	@Override
	public JobskOtrTrnngBean selectJobskOtrTrnngList(JobskOtrTrnngBean param) throws Exception {
		List<JobskOtrTrnngBean> list = jobskDAO.selectJobskOtrTrnngList(param);
		param.setList(list);

		return param;
	}
	
	/**
	 * Job Seek Detail Info Language
	 * @param JobskLangBean
	 * @return JobskLangBean
	 */
	@Override
	public JobskLangBean selectJobskLangList(JobskLangBean param) throws Exception {
		List<JobskLangBean> list = jobskDAO.selectJobskLangList(param);
		param.setList(list);

		return param;
	}

	/**
	 * Job Seek Detail Info Work Experience
	 * @param JobskWorkExpBean
	 * @return JobskWorkExpBean
	 */
	@Override
	public JobskWorkExpBean selectJobskWorkExpList(JobskWorkExpBean param) throws Exception {
		List<JobskWorkExpBean> list = jobskDAO.selectJobskWorkExpList(param);
		param.setList(list);

		return param;
	}

	/**
	 * Job Seek Detail Info Skill
	 * @param JobskSkillBean
	 * @return JobskSkillBean
	 */
	@Override
	public JobskSkillBean selectJobskSkillList(JobskSkillBean param) throws Exception {
		List<JobskSkillBean> list = jobskDAO.selectJobskSkillList(param);
		param.setList(list);

		return param;
	}

	/**
	 * Job Seek Detail Info Skill Detail
	 * @param JobskSkillBean
	 * @return JobskSkillBean
	 */
	@Override
	public JobskSkillBean selectJobskSkillDtlList(JobskSkillBean param) throws Exception {
		List<JobskSkillBean> list = jobskDAO.selectJobskSkillDtlList(param);
		param.setList(list);

		return param;
	}

	/**
	 * Job Seek Detail Info Recommended Man
	 * @param JobskRcmdmanBean
	 * @return JobskRcmdmanBean
	 */
	@Override
	public JobskRcmdmanBean selectJobskRcmdmanList(JobskRcmdmanBean param) throws Exception {
		List<JobskRcmdmanBean> list = jobskDAO.selectJobskRcmdmanList(param);
		param.setList(list);

		return param;
	}
	
	/**
	 * Update Job Seek JC Agree Status
	 * @param UserJobskBean
	 * @return JobskBean

	@Override
	public JobskBean selectJobskUserSeq(JobskBean param) throws Exception {
		return jobskDAO.selectJobskUserSeq(param);
	}	
	
	@Override
	public JobskBean updateJobskStsAjax(JobskBean param) throws Exception {
		
		JobskBean resultParam = new JobskBean();
		
		int result = 0;
		result = jobskDAO.updateJobskStsAjax(param);
		
	    if(result > 0) {
	    	resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
	    } else {
	    	//* Later Change to ResultCode as ErrCode 
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }
	*/
	

	/**
	 * Delete Job Seek Request
	 * @param JobskBean
	 * @return JobskBean
	*/
	@Override
	public JobskBean deleteJobskRequest(JobskBean param) throws Exception {
		
		JobskBean resultParam = new JobskBean();
		
		int result = 0;
		result = jobskDAO.deleteJobskRequest(param);
		
	    if(result > 0) {
	    	resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
	    } else {
	    	// Later Change to ResultCode as ErrCode 
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }
    	
	/**
	 * Update Job Seek Detail Info ISCO
	 * @param JobskIscoBean
	 * @return JobskIscoBean
	*/
	@Override
	public JobskIscoBean deleteJobskDtlInfoIsco(JobskIscoBean param) throws Exception {
		
		JobskIscoBean resultParam = new JobskIscoBean();
		
		int result = 0;
		result = jobskDAO.deleteJobskDtlInfoIsco(param);
		
	    if(result > 0) {
    		resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
		    
	    } else {
	    	// Later Change to ResultCode as ErrCode 
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }
	
	@Override
	public JobskIscoBean insertJobskDtlInfoIsco(JobskIscoBean param) throws Exception {
		
		JobskIscoBean resultParam = new JobskIscoBean();
		
		int result = 0;
		result = jobskDAO.insertJobskDtlInfoIsco(param);
		
	    if(result > 0) {
    		resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
		    
	    } else {
	    	// Later Change to ResultCode as ErrCode 
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }
	

	/**
	 * Update Job Seek Request JC Agree Status
	 * @param JobskBean
	 * @return JobskBean
	*/	
	@Override
	public JobskIscoBean updateJobskRequestJcAgreeSts(JobskIscoBean param) throws Exception {
		
		JobskIscoBean resultParam = new JobskIscoBean();
		
		int result = 0;
		result = jobskDAO.updateJobskRequestJcAgreeSts(param);
		
	    if(result > 0) {
    		resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
		    
	    } else {
	    	// Later Change to ResultCode as ErrCode 
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }

	
	/**
	 * Vacancy List
	 * @param VccyBean
	 * @return VccyBean
	 */
	@Override
	public JobskVacancyBean selectJobskVacancyList(JobskVacancyBean param) throws Exception {

		if (param.getSrchDivCd().toString().equals("SVD0000000001")) {
			// Company Name
			param.setCompnyNm(param.getSrchDivKeyword().toString());
		} 
		else if (param.getSrchDivCd().toString().equals("SVD0000000002")){
			// Vacancy Title
			param.setVacancyTitle(param.getSrchDivKeyword().toString());
		}
		else if (param.getSrchDivCd().toString().equals("SVD0000000003")){
			// Company Tel
			param.setMngerTel(param.getSrchDivKeyword().toString());
		}
			
		int totalCount = (int) jobskDAO.selectJobskVacancyListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
				
		List<JobskVacancyBean> list = jobskDAO.selectJobskVacancyList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * Delete Job Seek Vacancy
	 * @param JobskVacancyBean
	 * @return JobskVacancyBean
	*/
	@Override
	public JobskVacancyBean deleteJobskVacancy(JobskVacancyBean param) throws Exception {
		
		JobskVacancyBean resultParam = new JobskVacancyBean();
		
		int result = 0;
		result = jobskDAO.deleteJobskVacancy(param);
		
	    if(result > 0) {
	    	resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
	    } else {
	    	// Later Change to ResultCode as ErrCode 
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }
	
	/**
	 * Update Job Seek Vacancy Detail Info
	 * @param JobskVacancyBean
	 * @return JobskVacancyBean
	*/	
	@Override
	public JobskVacancyBean updateJobskVacancyDtlInfo(JobskVacancyBean param) throws Exception {
		
		JobskVacancyBean resultParam = new JobskVacancyBean();
		
		int result = 0;
		result = jobskDAO.updateJobskVacancyDtlInfo(param);
		
	    if(result > 0) {
    		resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
		    
	    } else {
	    	// Later Change to ResultCode as ErrCode 
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }	
	
	
	/**
	 * Job Seek Application List
	 * @param JobskApplicBean
	 * @return JobskApplicBean
	 */
	@Override
	public JobskApplicBean selectJobskApplicList(JobskApplicBean param) throws Exception {
		if (param.getSrchDivCd() != null && param.getSrchDivCd() != "") {
			if (param.getSrchDivCd().toString().equals("SDC0000000001")) {
				//USER NAME
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserNm(param.getSrchDivKeyword().toString());
				}
			} 
			else if (param.getSrchDivCd().toString().equals("SDC0000000002")){
				//USER EMAIL
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserEmail(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000003")){
				//USER CELL
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserTel(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000007")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setCompnyNm(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000008")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setVacancyTitle(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000010")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setResumeTitle(param.getSrchDivKeyword().toString());
				}
			}			
		}
		
		String vacancyPreferntCd = "";
		if (param.getPreferntCondCdDisabled() != null && param.getPreferntCondCdDisabled() != "") {
			if(vacancyPreferntCd != null && vacancyPreferntCd != "") {
				vacancyPreferntCd += ", " + param.getPreferntCondCdDisabled().toString();
			} else {
				vacancyPreferntCd += param.getPreferntCondCdDisabled().toString();
			}
		}
		
		if (param.getPreferntCondCdRtnLabor() != null && param.getPreferntCondCdRtnLabor() != "") {
			if(vacancyPreferntCd != null && vacancyPreferntCd != "") {
				vacancyPreferntCd += ", " + param.getPreferntCondCdRtnLabor().toString();
			} else {
				vacancyPreferntCd += param.getPreferntCondCdRtnLabor().toString();
			}
		}

		if (param.getPreferntCondCdYouth() != null && param.getPreferntCondCdYouth() != "") {
			if(vacancyPreferntCd != null && vacancyPreferntCd != "") {
				vacancyPreferntCd += ", " + param.getPreferntCondCdYouth().toString();
			} else {
				vacancyPreferntCd += param.getPreferntCondCdYouth().toString();
			}
		}
		
		param.setVacancyPreferntCd(vacancyPreferntCd);
		
		int totalCount = (int) jobskDAO.selectJobskApplicListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<JobskApplicBean> list = jobskDAO.selectJobskApplicList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}	

	/**
	 * Job Seek Offer List
	 * @param JobskOfferBean
	 * @return JobskOfferBean
	 */
	@Override
	public JobskOfferBean selectJobskOfferList(JobskOfferBean param) throws Exception {
		if (param.getSrchDivCd() != null && param.getSrchDivCd() != "") {
			if (param.getSrchDivCd().toString().equals("SDC0000000001")) {
				//USER NAME
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserNm(param.getSrchDivKeyword().toString());
				}
			} 
			else if (param.getSrchDivCd().toString().equals("SDC0000000002")){
				//USER EMAIL
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserEmail(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000003")){
				//USER CELL
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserTel(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000007")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setCompnyNm(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000008")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setVacancyTitle(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000010")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setResumeTitle(param.getSrchDivKeyword().toString());
				}
			}			
		}
		
		String vacancyPreferntCd = "";
		if (param.getPreferntCondCdDisabled() != null && param.getPreferntCondCdDisabled() != "") {
			if(vacancyPreferntCd != null && vacancyPreferntCd != "") {
				vacancyPreferntCd += ", " + param.getPreferntCondCdDisabled().toString();
			} else {
				vacancyPreferntCd += param.getPreferntCondCdDisabled().toString();
			}
		}
		
		if (param.getPreferntCondCdRtnLabor() != null && param.getPreferntCondCdRtnLabor() != "") {
			if(vacancyPreferntCd != null && vacancyPreferntCd != "") {
				vacancyPreferntCd += ", " + param.getPreferntCondCdRtnLabor().toString();
			} else {
				vacancyPreferntCd += param.getPreferntCondCdRtnLabor().toString();
			}
		}

		if (param.getPreferntCondCdYouth() != null && param.getPreferntCondCdYouth() != "") {
			if(vacancyPreferntCd != null && vacancyPreferntCd != "") {
				vacancyPreferntCd += ", " + param.getPreferntCondCdYouth().toString();
			} else {
				vacancyPreferntCd += param.getPreferntCondCdYouth().toString();
			}
		}		
		param.setVacancyPreferntCd(vacancyPreferntCd);
		
		int totalCount = (int) jobskDAO.selectJobskOfferListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<JobskOfferBean> list = jobskDAO.selectJobskOfferList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * Job Seek Interview List
	 * @param JobskIntvwBean
	 * @return JobskIntvwBean
	 */
	@Override
	public JobskIntvwBean selectJobskIntvwList(JobskIntvwBean param) throws Exception {
		if (param.getSrchDivCd() != null && param.getSrchDivCd() != "") {
			if (param.getSrchDivCd().toString().equals("SDC0000000001")) {
				//USER NAME
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserNm(param.getSrchDivKeyword().toString());
				}
			} 
			else if (param.getSrchDivCd().toString().equals("SDC0000000002")){
				//USER EMAIL
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserEmail(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000003")){
				//USER CELL
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserTel(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000007")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setCompnyNm(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000008")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setVacancyTitle(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000010")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setResumeTitle(param.getSrchDivKeyword().toString());
				}
			}			
		}
		
		String vacancyPreferntCd = "";
		if (param.getPreferntCondCdDisabled() != null && param.getPreferntCondCdDisabled() != "") {
			if(vacancyPreferntCd != null && vacancyPreferntCd != "") {
				vacancyPreferntCd += ", " + param.getPreferntCondCdDisabled().toString();
			} else {
				vacancyPreferntCd += param.getPreferntCondCdDisabled().toString();
			}
		}
		
		if (param.getPreferntCondCdRtnLabor() != null && param.getPreferntCondCdRtnLabor() != "") {
			if(vacancyPreferntCd != null && vacancyPreferntCd != "") {
				vacancyPreferntCd += ", " + param.getPreferntCondCdRtnLabor().toString();
			} else {
				vacancyPreferntCd += param.getPreferntCondCdRtnLabor().toString();
			}
		}

		if (param.getPreferntCondCdYouth() != null && param.getPreferntCondCdYouth() != "") {
			if(vacancyPreferntCd != null && vacancyPreferntCd != "") {
				vacancyPreferntCd += ", " + param.getPreferntCondCdYouth().toString();
			} else {
				vacancyPreferntCd += param.getPreferntCondCdYouth().toString();
			}
		}		
		param.setVacancyPreferntCd(vacancyPreferntCd);
		
		int totalCount = (int) jobskDAO.selectJobskIntvwListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<JobskIntvwBean> list = jobskDAO.selectJobskIntvwList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	
	/**
	 * Job Seek Video Interview List
	 * @param JobskVdoIntvwBean
	 * @return JobskVdoIntvwBean
	 */
	@Override
	public JobskVdoIntvwBean selectJobskVdoIntvwList(JobskVdoIntvwBean param) throws Exception {
		if (param.getSrchDivCd() != null && param.getSrchDivCd() != "") {
			if (param.getSrchDivCd().toString().equals("SDC0000000001")) {
				//USER NAME
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserNm(param.getSrchDivKeyword().toString());
				}
			} 
			else if (param.getSrchDivCd().toString().equals("SDC0000000003")){
				//USER CELL
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setUserTel(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000007")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setCompnyNm(param.getSrchDivKeyword().toString());
				}
			}
			else if (param.getSrchDivCd().toString().equals("SDC0000000009")){
				//Company Name
				if (param.getSrchDivKeyword() != null && param.getSrchDivKeyword() != "") {
					param.setMngerTel(param.getSrchDivKeyword().toString());
				}
			}		
		}
		
		int totalCount = (int) jobskDAO.selectJobskVdoIntvwListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<JobskVdoIntvwBean> list = jobskDAO.selectJobskVdoIntvwList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * Job Seek Video Interview Detail Info
	 * @param JobskVdoIntvwBean
	 * @return JobskVdoIntvwBean
	 */
	@Override
	public JobskVdoIntvwBean selectJobskVdoIntvwDtlInfo(JobskVdoIntvwBean param) throws Exception {
		return jobskDAO.selectJobskVdoIntvwDtlInfo(param);
	}
		
	/**
	 * Delete Job Seek Video Interview
	 * @param JobskVdoIntvwBean
	 * @return JobskVdoIntvwBean
	*/
	@Override
	public JobskVdoIntvwBean deleteJobskVdoIntvw(JobskVdoIntvwBean param) throws Exception {
		
		JobskVdoIntvwBean resultParam = new JobskVdoIntvwBean();
		
		int result = 0;
		result = jobskDAO.deleteJobskVdoIntvw(param);
		
	    if(result > 0) {
	    	resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
	    } else {
	    	// Later Change to ResultCode as ErrCode 
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }
	
	/**
	 * Update Job Seek Video Interview Detail Info
	 * @param JobskVdoIntvwBean
	 * @return JobskVdoIntvwBean
	*/	
	@Override
	public JobskVdoIntvwBean updateJobskVdoIntvwDtlInfo(JobskVdoIntvwBean param) throws Exception {
		
		JobskVdoIntvwBean resultParam = new JobskVdoIntvwBean();
		
		int result = 0;
		result = jobskDAO.updateJobskVdoIntvwDtlInfo(param);
		
	    if(result > 0) {
    		resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
		    
	    } else {
	    	// Later Change to ResultCode as ErrCode 
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }	
	
}
