package ony.cpes.internal.referral.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.framework.bean.PagingBean;
import ony.cpes.internal.referral.service.ReferralService;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.sitemgmt.bean.BannerBean;
import ony.cpes.internal.vacancy.bean.VacancyBean;
import ony.cpes.internal.referral.dao.ReferralDAO;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.cpes.internal.referral.bean.ReferralBean;

@Service("ReferralService")
public class ReferralServiceImpl implements ReferralService{

	@Autowired
	private ReferralDAO referralDAO;
	
	/**
	 * Referral History Management List
	 * @param ReferralBean
	 * @return List<ReferralBean>
	 */
	@Override
	public List<ReferralBean> selectReferralHisMngList(ReferralBean param) throws Exception {
        
		if (param == null) {
			param = new ReferralBean();
		}
    	if (param.getPaging() == null) {
    		param.setPaging(new PagingBean());
		}
    	param.getPaging().setTotalCount(referralDAO.selectReferralHisMngListTotalCnt(param));
    	param.getPaging().setListBlock(param.getListBlock());
    	param.getPaging().setPageNo(param.getPageNo());
    	param.setStartNum((param.getPageNo()-1) * param.getListBlock());
		List<ReferralBean> list = referralDAO.selectReferralHisMngList(param);
		//param.setList(list);
		
		return list;
    }
	
	/**
	 * Delete Referral History Management List
	 * @param ReferralBean
	 * @return ReferralBean
	 */
	@Override
	public ReferralBean deleteReferralHisMngList(ReferralBean param) throws Exception {
		ReferralBean resultParam = new ReferralBean();
		
		int result = 0;
		result = referralDAO.deleteReferralHisMngList(param);
		
	    if(result > 0) {
	    	resultParam.setResultCode("0000");
	    	resultParam.setMsg("Success");
	    } else {
	    	/* Later Change to ResultCode as ErrCode */
	    	resultParam.setResultCode(Integer.toString(result));
	    	resultParam.setMsg("fail");
	    }
	    
	    return resultParam;
    }	
	
	
	@Override
	public ReferralBean selectReferralManage(ReferralBean param) throws Exception {
		ReferralBean referral = new ReferralBean();
		
		referral = referralDAO.selectReferralManage(param);
		
		return referral;
	}
	
	@Override
	public VacancyBean selectReferralManageVacancy(ReferralBean param) throws Exception {
		VacancyBean vacancy = new VacancyBean();
		
		vacancy = referralDAO.selectReferralManageVacancy(param);

		return vacancy;
	}
	
	@Override
	public ResumeBean selectReferralManageResume(ReferralBean param) throws Exception {
		ResumeBean resume = new ResumeBean();
		
		resume = referralDAO.selectReferralManageResume(param);
		
		return resume;
	}
	
	/**
	 * 
	 */
	@Override
	public Map<String,Object> insertReferralMgmt(ReferralBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
    	
		
		int resultCd = referralDAO.insertReferralMgmt(param);
		
		if(resultCd > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
	
	@Override
	public ReferralBean selectJobReferralRecordList(ReferralBean param) throws Exception {
        
		int totalCount = referralDAO.selectJobReferralRecordListTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);
		List<ReferralBean> list = referralDAO.selectJobReferralRecordList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
}
