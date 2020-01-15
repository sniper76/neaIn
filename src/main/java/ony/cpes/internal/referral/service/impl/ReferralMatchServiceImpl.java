package ony.cpes.internal.referral.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.referral.dao.ReferralMatchDAO;
import ony.cpes.internal.referral.service.ReferralMatchService;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.bean.LocationBean;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.referral.bean.JobskReferralBean;
import ony.cpes.internal.referral.bean.ReferralMatchBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.resume.bean.ResumeBean;

@Service("ReferralMatchService")
public class ReferralMatchServiceImpl implements ReferralMatchService{

	@Autowired
	private ReferralMatchDAO referralMatchDAO;
	
	/**
	 * 
	 */
	public ReferralMatchBean selectResumeInfo(ReferralMatchBean param) throws Exception {
		//ResumeBean resumeBean = new ResumeBean();
		Map<String,Object> resumeSeqInfo = new HashMap<String,Object>();
		ReferralMatchBean result = new ReferralMatchBean();
		
		try {
			if(param.getResumeSeq().equals("") || param.getResumeSeq() == null) {
				result = referralMatchDAO.selectResumeSeq(param);

				param.setResumeSeq(result.getResumeSeq());
				param.setResumeSeqCnt(result.getResumeSeqCnt());
				int seqCnt = Integer.parseInt((String) result.getResumeSeqCnt());
				if(seqCnt == 1) {
					result = referralMatchDAO.selectResumeInfo(param);
				}
				
			}else {
				result = referralMatchDAO.selectResumeInfo(param);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 */
	public ReferralMatchBean selectCmpnyInfo(ReferralMatchBean param) throws Exception {
		Map<String,Object> resumeSeqInfo = new HashMap<String,Object>();
		ReferralMatchBean result = new ReferralMatchBean();
		
		try {
			
			result = referralMatchDAO.selectCmpnyInfo(param);
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	
	public IscoBean selectIscoOneList(ReferralMatchBean param) throws Exception {
		IscoBean iscoBean = new IscoBean();
		try {
			List<IscoBean> list = referralMatchDAO.selectIscoOneList(param);
			iscoBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscoBean;
	}
	
	public IscoBean selectIscoTwoList(IscoBean param) throws Exception {
		IscoBean iscoBean = new IscoBean();
		try {
			List<IscoBean> list = referralMatchDAO.selectIscoTwoList(param);
			iscoBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscoBean;
	}
	
	public IscoBean selectIscoThreeList(IscoBean param) throws Exception {
		IscoBean iscoBean = new IscoBean();
		try {
			List<IscoBean> list = referralMatchDAO.selectIscoThreeList(param);
			iscoBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscoBean;
	}
	
	public IscoBean selectIscoFourList(IscoBean param) throws Exception {
		IscoBean iscoBean = new IscoBean();
		try {
			List<IscoBean> list = referralMatchDAO.selectIscoFourList(param);
			iscoBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return iscoBean;
	}
	
	public LocationBean selectProvincList(ReferralMatchBean param) throws Exception {
		LocationBean locationBean = new LocationBean();
		try {
			List<LocationBean> list = referralMatchDAO.selectProvincList(param);
			locationBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return locationBean;
	}
	
	public LocationBean selectDistrictList(LocationBean param) throws Exception {
		LocationBean locationBean = new LocationBean();
		try {
			List<LocationBean> list = referralMatchDAO.selectDistrictList(param);
			locationBean.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return locationBean;
	}
	
	
	@Override
	public ReferralMatchBean selectJobskReferralMatchList(ReferralMatchBean param) throws Exception {
        
		int totalCount = referralMatchDAO.selectJobskReferralMatchTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);
		List<ReferralMatchBean> list = referralMatchDAO.selectJobskReferralMatchList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	@Override
	public ReferralMatchBean selectVacancyReferralMatchList(ReferralMatchBean param) throws Exception {
        
		int totalCount = referralMatchDAO.selectVacancyReferralMatchTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);
		List<ReferralMatchBean> list = referralMatchDAO.selectVacancyReferralMatchList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
}
