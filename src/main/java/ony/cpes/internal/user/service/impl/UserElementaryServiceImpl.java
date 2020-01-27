package ony.cpes.internal.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.user.bean.UserElementaryBean;
import ony.cpes.internal.user.bean.UserElementaryIntvwBean;
import ony.cpes.internal.user.dao.UserElementaryDAO;
import ony.cpes.internal.user.service.UserElementaryService;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.counsel.bean.CounselBean;

@Service("UserElementaryService")
public class UserElementaryServiceImpl implements UserElementaryService{

	@Autowired
	private UserElementaryDAO userElementaryDAO;

	@Autowired MessageSource messageSource;

	@Autowired SessionLocaleResolver localeResolver;

	/**
	 * User List Using Elementary Job Seeker
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	@Override
	public UserElementaryBean selectUserElementaryInfoList(UserElementaryBean param, HttpServletRequest request) throws Exception {

		if (param.getSrchDivCd() != null && param.getSrchDivCd() != "") {
			if (param.getSrchDivCd().toString().equals("SUD0000000001")) {
				//USER NAME
				param.setUserNm(param.getSrchDivKeyword().toString());
			}
			else if (param.getSrchDivCd().toString().equals("SUD0000000002")){
				//USER EMAIL
				param.setUserEmail(param.getSrchDivKeyword().toString());
			}
			else if (param.getSrchDivCd().toString().equals("SUD0000000003")){
				//USER CELL
				param.setUserCell(param.getSrchDivKeyword().toString());
			}
		}

		int totalCount = (int) userElementaryDAO.selectUserElementaryInfoListTotalCnt(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<UserElementaryBean> list = userElementaryDAO.selectUserElementaryInfoList(param);

		for(UserElementaryBean userElementaryBean : list) {
			String resumeCnt = userElementaryBean.getResumeCnt();

			if(Integer.parseInt(resumeCnt) == 0) {
				String resumeInsertHtml = "<button type=\"button\" class=\"bbs_btn type03 registration\" "
						+ "onclick=\"fnUserResumeRegistration('" + userElementaryBean.getUserSeq() + "');\">" +
						messageSource.getMessage("field.dic.resume.registration", null, "Error", localeResolver.resolveLocale(request)) + "</button>";
				userElementaryBean.setResumeCnt(resumeInsertHtml);
			}else {
				userElementaryBean.setResumeCnt("");
			}
		}
		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * Insert User Info By Excel
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	*/
	@Override
	//public UserElementaryBean insertUserElementaryRegUserInfoByExcel(UserElementaryBean param) throws Exception {
	public UserElementaryBean insertUserElementaryRegUserInfoByExcel(List<Map<String, Object>> param, Locale locale, HttpServletRequest request) throws Exception {

		UserElementaryBean resultParam = new UserElementaryBean();
		UserElementaryBean userInfoParam = new UserElementaryBean();
		UserElementaryBean cdParam = new UserElementaryBean();
		UserElementaryBean rtnCdParam = new UserElementaryBean();
        
		try {
			int result = 0;
			int loopCnt = param.size();
			
			for (int i = 0; i < loopCnt; i++) {
				
				userInfoParam.setJcCd(param.get(i).get("jcCd").toString());
				userInfoParam.setRegUserSeq(param.get(i).get("regUserSeq").toString());
				userInfoParam.setUserNmKh(param.get(i).get("userNmKh").toString());
				userInfoParam.setUserNmEn(param.get(i).get("userNmEn").toString());
				userInfoParam.setUserEmail(param.get(i).get("userEmail").toString());
				userInfoParam.setUserCell(param.get(i).get("userCell").toString());
				userInfoParam.setUserPasswd(param.get(i).get("userPasswd").toString());
				userInfoParam.setBirth(param.get(i).get("userBirth").toString());
				userInfoParam.setGenderCd(param.get(i).get("userGender").toString());
				
				cdParam.setAddrCd(param.get(i).get("userAddrCd").toString());
				rtnCdParam = userElementaryDAO.selectAddrFullCdByAddrCd(cdParam);
				userInfoParam.setAddrFullCd(rtnCdParam.getAddrFullCd());
				
				userInfoParam.setAddrDtl(param.get(i).get("userDtlAddr").toString());
				
				result = userElementaryDAO.insertUserElementaryRegUserInfoByExcel(userInfoParam);
		
			    if(result > 0) {
		    		resultParam.setResultCode("0000");
			    	resultParam.setMsg("Success");
		
			    } else {
			    	// Later Change to ResultCode as ErrCode
			    	resultParam.setResultCode(Integer.toString(result));
			    	resultParam.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
			    }
			}
		
		    
		} catch (Exception e) {
			resultParam.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			resultParam.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return resultParam;
		
    }	
	
	/**
	 * User Detail Info Main Using Elementary Job Seeker
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	@Override
	public UserElementaryBean selectUserElementaryDtlInfoMain(UserElementaryBean param) throws Exception {
		return userElementaryDAO.selectUserElementaryDtlInfoMain(param);
	}

	/**
	 * User Detail Info Base Using Elementary Job Seeker
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	@Override
	public UserElementaryBean selectUserElementaryDtlInfoBase(UserElementaryBean param) throws Exception {
		return userElementaryDAO.selectUserElementaryDtlInfoBase(param);
	}

	/**
	 * Delete User Detail Info
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	*/
	@Override
	public UserElementaryBean deleteUserElementaryInfo(UserElementaryBean param) throws Exception {

		UserElementaryBean resultParam = new UserElementaryBean();

		int result = 0;
		result = userElementaryDAO.deleteUserElementryInfo(param);

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
	 * Update User Detail Info
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	*/
	@Override
	public UserElementaryBean updateUserElementaryDtlInfo(UserElementaryBean param) throws Exception {

		UserElementaryBean resultParam = new UserElementaryBean();

		int result = 0;
		result = userElementaryDAO.updateUserElementaryDtlInfo(param);

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
     * Registration User Base Info
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
     */
	@Override
	public UserElementaryBean selectUserElementaryRegBaseInfo(UserElementaryBean param) throws Exception {
		return userElementaryDAO.selectUserElementaryRegBaseInfo(param);
	}

	/**
     * Check User Cell Duplication
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
     */
	@Override
	public UserElementaryBean selectUserCellDuplicationCheck(UserElementaryBean param) throws Exception {
		return userElementaryDAO.selectUserCellDuplicationCheck(param);
	}

	/**
     * Job Center Code By Address Code
     *
     * @param UserElementaryBean
     * @return UserElementaryBean
     */
	@Override
	public UserElementaryBean selectJobCenterCdByAddrCd(UserElementaryBean param) throws Exception {
		return userElementaryDAO.selectJobCenterCdByAddrCd(param);
	}

	/**
	 * Registration User Detail Info
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	*/
	@Override
	public UserElementaryBean insertUserElementaryInfo(UserElementaryBean param) throws Exception {

		String srchAddrCd = "";
		srchAddrCd = param.getAddrFullCd().toString();
		String[] arrSrchAddrCd = srchAddrCd.split(",");
		
		if (arrSrchAddrCd.length > 1) {
			srchAddrCd = arrSrchAddrCd[0] + arrSrchAddrCd[1];
		} else {
			srchAddrCd = arrSrchAddrCd[0];
		}
		
		param.setSrchAddrCd(srchAddrCd);

		UserElementaryBean jcRtnParam = new UserElementaryBean();
		jcRtnParam = userElementaryDAO.selectJobCenterCdByAddrCd(param);

		if (jcRtnParam != null) {
			param.setJcCd(jcRtnParam.getJcCd().toString());
		}

		UserElementaryBean resultParam = new UserElementaryBean();

		int result = 0;
		result = userElementaryDAO.insertUserElementaryInfo(param);

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
	 * Change User Type
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	 */
	@Override
	public UserElementaryBean selectUserElementaryDtlInfoUserTypeChg(UserElementaryBean param) throws Exception {
		return userElementaryDAO.selectUserElementaryDtlInfoUserTypeChg(param);
	}	

	/**
	 * Update User Type
	 * @param UserElementaryBean
	 * @return UserElementaryBean
	*/
	@Override
	public UserElementaryBean insertUserElementaryDtlInfoUserTypeChg(UserElementaryBean param) throws Exception {

		UserElementaryBean resultParam = new UserElementaryBean();

		int result = 0;
		result = userElementaryDAO.insertUserElementaryDtlInfoUserTypeChg(param);

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
	 * User Detail Info Interview History List
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	@Override
	public UserElementaryIntvwBean selectUserElementaryDtlInfoIntvwList(UserElementaryIntvwBean param) throws Exception {

		int totalCount = (int) userElementaryDAO.selectUserElementaryDtlInfoIntvwListTotalCnt(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<UserElementaryIntvwBean> list = userElementaryDAO.selectUserElementaryDtlInfoIntvwList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}

	/**
	 * Registration User Detail Info Interview History
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	*/
	@Override
	public UserElementaryIntvwBean insertUserElementaryDtlInfoIntvw(UserElementaryIntvwBean param) throws Exception {

		UserElementaryIntvwBean rtnResumeSeq = new UserElementaryIntvwBean();
		rtnResumeSeq = userElementaryDAO.selectResumeSeqUsingByUserSeq(param);

		if (rtnResumeSeq != null) {
			param.setResumeSeq(rtnResumeSeq.getResumeSeq().toString());
		}

		UserElementaryIntvwBean resultParam = new UserElementaryIntvwBean();

		int result = 0;
		result = userElementaryDAO.insertUserElementaryDtlInfoIntvwHis(param);

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
	 * User Interview Detail Info for Modify
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	@Override
	public UserElementaryIntvwBean selectUserElementaryDtlInfoIntvwModify(UserElementaryIntvwBean param) throws Exception {
		return userElementaryDAO.selectUserElementaryDtlInfoIntvwModify(param);
	}

	/**
	 * Update User Detail Info Interview History
	 * @param UserElementaryIntvwBean
	 * @return UserElementaryIntvwBean
	 */
	@Override
	public UserElementaryIntvwBean updateUserElementaryDtlInfoIntvwModify(UserElementaryIntvwBean param) throws Exception {

		UserElementaryIntvwBean resultParam = new UserElementaryIntvwBean();

		int result = 0;
		result = userElementaryDAO.updateUserElementaryDtlInfoIntvwModify(param);

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
	public UserElementaryBean selectelementaryUserInfo(CounselBean param) throws Exception {
		return userElementaryDAO.selectelementaryUserInfo(param);
	}	
	
	
	@Override
	public CounselBean selectCounselUserInfo(CounselBean param) throws Exception {
		return userElementaryDAO.selectCounselUserInfo(param);
	}
	
	
	public Map<String,Object> insertElemtryCounsel(HttpServletRequest request,CounselBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = userElementaryDAO.insertElemtryCounsel(param);
		
		if(resultCd > 0) {
			result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request))); //success
			result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
		}else {
			result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request))); //fail
			result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return result;
	}

}
