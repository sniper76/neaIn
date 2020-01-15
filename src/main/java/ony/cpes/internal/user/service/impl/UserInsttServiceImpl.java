package ony.cpes.internal.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.user.service.UserInsttService;
import ony.cpes.internal.user.dao.UserInsttDAO;
import ony.cpes.internal.user.bean.UserInsttBean;
import ony.cpes.internal.user.bean.UserInsttEduBean;
import ony.cpes.internal.user.bean.UserInsttFairBean;


@Service("UserInsttService")
public class UserInsttServiceImpl implements UserInsttService{

	@Autowired
	private UserInsttDAO userInsttDAO;
	
	/**
	 * Institution User List
	 * @param UserInsttBean
	 * @return UserInsttBean
	 */
	@Override
	public UserInsttBean selectUserInsttInfoListAjax(UserInsttBean param) throws Exception {
		
		if (param.getSrchDivCd() != null && !"".equals(param.getSrchDivCd().toString())){
			if (param.getSrchDivCd().toString().equals("SID0000000001")) {
				//institution name
				param.setInsttNm(param.getSrchDivKeyword().toString());
			}
			else if (param.getSrchDivCd().toString().equals("SID0000000002")){
				//institution responsible person
				param.setInsttMngerNm(param.getSrchDivKeyword().toString());
			}
			else if (param.getSrchDivCd().toString().equals("SID0000000003")){
				//institution email
				param.setInsttEmail(param.getSrchDivKeyword().toString());
			}
			else if (param.getSrchDivCd().toString().equals("SID0000000004")){
				//institution cell number
				param.setInsttCell(param.getSrchDivKeyword().toString());
			}
			else if (param.getSrchDivCd().toString().equals("SID0000000005")){
				//institution license or registration number
				param.setRegNm(param.getSrchDivKeyword().toString());
			}
		}
		
		int totalCount = (int) userInsttDAO.selectUserInsttInfoListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
				
		List<UserInsttBean> list = userInsttDAO.selectUserInsttInfoListAjax(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * Delete Institution User Info
	 * @param UserInsttBean
	 * @return UserInsttBean
	 */
	@Override
	public UserInsttBean deleteUserInsttInfoAjax(UserInsttBean param) throws Exception {
		
		UserInsttBean resultParam = new UserInsttBean();
		
		int result = 0;
		result = userInsttDAO.deleteUserInfoAjax(param);
		
	    if(result > 0) {
	    	result = userInsttDAO.deleteInsttInfoAjax(param);
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
	 * Institution User Detail Main
	 * @param UserInsttBean
	 * @return UserInsttBean
	 */
	@Override
	public UserInsttBean selectUserInsttDtlInfoMain(UserInsttBean param) throws Exception {
		return userInsttDAO.selectUserInsttDtlInfoMain(param);
	}	
	
	/**
	 * Institution User Detail Base
	 * @param UserInsttBean
	 * @return UserInsttBean
	 */
	@Override
	public UserInsttBean selectUserInsttDtlInfoBaseAjax(UserInsttBean param) throws Exception {
		return userInsttDAO.selectUserInsttDtlInfoBaseAjax(param);
	}
	
	/**
	 * Institution Detail Profile
	 * @param UserInsttBean
	 * @return UserInsttBean
	 */
	@Override
	public UserInsttBean selectUserInsttDtlInfoProfile(UserInsttBean param) throws Exception {
		return userInsttDAO.selectUserInsttDtlInfoProfile(param);
	}
	
	/**
	 * Institution Detail Profile Image
	 * @param UserInsttBean
	 * @return UserInsttBean
	 */
	@Override
	public UserInsttBean selectUserInsttDtlInfoImg(UserInsttBean param) throws Exception {
		return userInsttDAO.selectUserInsttDtlInfoImg(param);
	} 
	
	/**
	 * Institution Detail Education Training
	 * @param UserInsttEduBean
	 * @return UserInsttEduBean
	 */
	@Override
	public UserInsttEduBean selectUserInsttDtlInfoEduList(UserInsttEduBean param) throws Exception {

		int totalCount = (int) userInsttDAO.selectUserInsttDtlInfoEduListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
				
		List<UserInsttEduBean> list = userInsttDAO.selectUserInsttDtlInfoEduList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	/**
	 * Institution Detail Job Fair
	 * @param UserInsttFairBean
	 * @return UserInsttFairBean
	 */
	@Override
	public UserInsttFairBean selectUserInsttDtlInfoJobfairList(UserInsttFairBean param) throws Exception {

		int totalCount = (int) userInsttDAO.selectUserInsttDtlInfoJobfairListTotalCnt(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<UserInsttFairBean> list = userInsttDAO.selectUserInsttDtlInfoJobfairList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;

	}
	
	
}
