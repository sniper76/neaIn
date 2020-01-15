package ony.cpes.internal.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.user.service.UserCmpnyService;
import ony.cpes.internal.user.dao.UserCmpnyDAO;
import ony.cpes.internal.user.bean.UserCmpnyBean;
import ony.cpes.internal.user.bean.UserCmpnyIsicBean;
import ony.cpes.internal.user.bean.UserCmpnyCommonBean;
import ony.cpes.internal.user.bean.UserCmpnyVccyBean;
import ony.cpes.internal.user.bean.UserCmpnyAplcBean;
import ony.cpes.internal.user.bean.UserCmpnyOfferBean;
import ony.cpes.internal.user.bean.UserCmpnyIntvwBean;
import ony.cpes.internal.user.bean.UserCmpnyFairBean;

@Service("UserCmpnyService")
public class UserCmpnyServiceImpl implements UserCmpnyService{

	@Autowired
	private UserCmpnyDAO userCmpnyDAO;
	
	/**
	 * Company User List
	 * @param UserCmpnyBean
	 * @return UserCmpnyBean
	 */
	@Override
	public UserCmpnyBean selectUserCmpnyInfoListAjax(UserCmpnyBean param) throws Exception {
		
		if (param.getSrchDivCd().toString().equals("SCD0000000001")) {
			//Company name
			param.setCompnyNmKh(param.getSrchDivKeyword().toString());
		}
		else if (param.getSrchDivCd().toString().equals("SCD0000000002")) {
			//Company name
			param.setCompnyNmEn(param.getSrchDivKeyword().toString());
		}
		else if (param.getSrchDivCd().toString().equals("SCD0000000003")){
			//Company email
			param.setMngerEmail(param.getSrchDivKeyword().toString());
		}
		else if (param.getSrchDivCd().toString().equals("SCD0000000004")){
			//Company cell number
			param.setMngerCell(param.getSrchDivKeyword().toString());
		}
			
		int totalCount = (int) userCmpnyDAO.selectUserCmpnyInfoListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<UserCmpnyBean> list = userCmpnyDAO.selectUserCmpnyInfoListAjax(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * ISIC (SECTOR) CODE lIST
	 * @param UserCmpnyIsicBean
	 * @return UserCmpnyIsicBean
	 */
	@Override
	public UserCmpnyIsicBean selectIsicCdList(UserCmpnyIsicBean param) throws Exception {
		
		List<UserCmpnyIsicBean> list = userCmpnyDAO.selectIsicCdList(param);

		param.setList(list);

		return param;

	}	
	
	/**
	 * Delete Company User Info
	 * @param UserCmpnyBean
	 * @return UserCmpnyBean
	 */
	@Override
	public UserCmpnyBean deleteUserCmpnyInfoAjax(UserCmpnyBean param) throws Exception {
		
		UserCmpnyBean resultParam = new UserCmpnyBean();
		
		int result = 0;
		result = userCmpnyDAO.deleteUserInfoAjax(param);
		
	    if(result > 0) {
	    	result = userCmpnyDAO.deleteCmpnyInfoAjax(param);
	    	if(result > 0) {
	    		resultParam.setResultCode("0000");
	    		resultParam.setMsg("Success");
	    	} else {
		    	resultParam.setResultCode(Integer.toString(result));
		    	resultParam.setMsg("fail");	    		
	    	}
	    } else {
	    	/* Later Change to ResultCode as ErrCode */
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }
	
	/**
	 * User Company Detail Main
	 * @param UserCmpnyBean
	 * @return UserCmpnyBean
	 */
	@Override
	public UserCmpnyBean selectUserCmpnyDtlInfoMain(UserCmpnyBean param) throws Exception {
		return userCmpnyDAO.selectUserCmpnyDtlInfoMain(param);
	}
	
	/**
	 * User Company Detail Base
	 * @param UserCmpnyBean
	 * @return UserCmpnyBean
	 */
	@Override
	public UserCmpnyBean selectUserCmpnyDtlInfoBaseAjax(UserCmpnyBean param) throws Exception {
		return userCmpnyDAO.selectUserCmpnyDtlInfoBaseAjax(param);
	}
	
	/**
	 * User Company Detail Profile
	 * @param UserCmpnyBean
	 * @return UserCmpnyBean
	 */
	@Override
	public UserCmpnyBean selectUserCmpnyDtlInfoProfileAjax(UserCmpnyBean param) throws Exception {
		return userCmpnyDAO.selectUserCmpnyDtlInfoProfileAjax(param);
	}
	
	/**
	 * User Company Detail History
	 * @param UserCmpnyBean
	 * @return UserCmpnyBean

	@Override
	public UserCmpnyBean selectUserCmpnyDtlInfoHisAjax(UserCmpnyBean param) throws Exception {
		return userCmpnyDAO.selectUserCmpnyDtlInfoHisAjax(param);
	}
	 */
	
	/**
	 * User Company Detail Profile Image
	 * @param UserCmpnyBean
	 * @return UserCmpnyBean
	 */
	@Override
	public UserCmpnyBean selectUserCmpnyDtlInfoImgAjax(UserCmpnyBean param) throws Exception {
		return userCmpnyDAO.selectUserCmpnyDtlInfoImgAjax(param);
	}
	
	/**
	 * Company User Vacancy List
	 * @param UserCmpnyVccyBean
	 * @return UserCmpnyVccyBean
	 */
	@Override
	public UserCmpnyVccyBean selectUserCmpnyDtlInfoVccyList(UserCmpnyVccyBean param) throws Exception {

		int totalCount = (int) userCmpnyDAO.selectUserCmpnyDtlInfoVccyListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
				
		List<UserCmpnyVccyBean> list = userCmpnyDAO.selectUserCmpnyDtlInfoVccyList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * Company User Common Vacancy List
	 * @param UserCmpnyAplcBean
	 * @return UserCmpnyAplcBean
	 */
	
	@Override
	public UserCmpnyCommonBean selectUserCmpnyCommonVccyList(UserCmpnyCommonBean param) throws Exception {

		List<UserCmpnyCommonBean> list = userCmpnyDAO.selectUserCmpnyCommonVccyList(param);
		param.setList(list);

		return param;

	}	

	
	/**
	 * Company User Application List
	 * @param UserCmpnyAplcBean
	 * @return UserCmpnyAplcBean
	 */
	@Override
	public UserCmpnyAplcBean selectUserCmpnyDtlInfoAplcList(UserCmpnyAplcBean param) throws Exception {

		int totalCount = (int) userCmpnyDAO.selectUserCmpnyDtlInfoAplcListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
				
		List<UserCmpnyAplcBean> list = userCmpnyDAO.selectUserCmpnyDtlInfoAplcList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * Company User Offer List
	 * @param UserCmpnyOfferBean
	 * @return UserCmpnyOfferBean
	 */
	@Override
	public UserCmpnyOfferBean selectUserCmpnyDtlInfoOfferList(UserCmpnyOfferBean param) throws Exception {

		int totalCount = (int) userCmpnyDAO.selectUserCmpnyDtlInfoOfferListTotalCnt(param);	
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
				
		List<UserCmpnyOfferBean> list = userCmpnyDAO.selectUserCmpnyDtlInfoOfferList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * Company User Interview List
	 * @param UserCmpnyIntvwBean
	 * @return UserCmpnyIntvwBean
	 */
	@Override
	public UserCmpnyIntvwBean selectUserCmpnyDtlInfoIntvwList(UserCmpnyIntvwBean param) throws Exception {

		int totalCount = (int) userCmpnyDAO.selectUserCmpnyDtlInfoIntvwListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
				
		List<UserCmpnyIntvwBean> list = userCmpnyDAO.selectUserCmpnyDtlInfoIntvwList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * Company User Job Fair List
	 * @param UserCmpnyFairBean
	 * @return UserCmpnyFairBean
	 */
	@Override
	public UserCmpnyFairBean selectUserCmpnyDtlInfoJobfairList(UserCmpnyFairBean param) throws Exception {

		int totalCount = (int) userCmpnyDAO.selectUserCmpnyDtlInfoJobfairListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
				
		List<UserCmpnyFairBean> list = userCmpnyDAO.selectUserCmpnyDtlInfoJobfairList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}		
	
}	
