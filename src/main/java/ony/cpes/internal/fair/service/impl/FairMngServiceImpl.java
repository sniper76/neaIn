package ony.cpes.internal.fair.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.bean.JobFairBean;
import ony.cpes.internal.fair.dao.FairMngDAO;
import ony.cpes.internal.fair.service.FairMngService;
import ony.framework.util.StringUtil;

@Service("FairMngService")
public class FairMngServiceImpl implements FairMngService{

	@Autowired
	private FairMngDAO fairMngDAO;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;	

	@Autowired
	private CommonService commonService;
	
	/**
	 * 채용행사 등록 목록 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	@Override
	public FairMngBean selectJobFairMngList(FairMngBean param) throws Exception {
		int totalCount = (int) fairMngDAO.selectJobFairMngListTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<FairMngBean> list = fairMngDAO.selectJobFairMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}
	
    
	/**
     * 채용행사 등록 관리 목록 조회 Layer
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean selectJobFairListLayer(FairMngBean param) throws Exception {
    	List<FairMngBean> list = fairMngDAO.selectJobFairListLayer(param);
    	param.setList(list);
    	return 	param;	
    }	
	
	/**
     * 채용행사 등록 관리 상세 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean selectJobFairMngDetail(FairMngBean param) throws Exception {
    	return fairMngDAO.selectJobFairMngDetail(param);
    }
	
	/**
     * 채용행사 등록 관리 등록
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean insertJobFairMng(FairMngBean param) throws Exception {
    	FairMngBean jobFairMngVo = new FairMngBean();

    	String thumbFileGrpSeq = "";
    	String fairFileGrpSeq = "";
    	String supporterFileGrpSeq = "";
    	String sponsorFileGrpSeq = "";
    	String boothFileGrpSeq = "";
    	
		param.setDelYn("N");
		
		
		//file Upload
		if(!StringUtil.isEmpty(param.getThumbCommonUploadFairResult())) {
			thumbFileGrpSeq = commonService.dext5UploadInsert(param.getThumbCommonUploadFairResult(), param.getRegUserSeq(), param.getThumbFileGrpSeq());
    		param.setThumbFileGrpSeq(thumbFileGrpSeq);
		}
		
		//file Upload
		if(!StringUtil.isEmpty(param.getFairCommonUploadFairResult())) {
			fairFileGrpSeq = commonService.dext5UploadInsert(param.getFairCommonUploadFairResult(), param.getRegUserSeq(), param.getFairFileGrpSeq());
    		param.setFairFileGrpSeq(fairFileGrpSeq);
		}
		
		//file Upload
		if(!StringUtil.isEmpty(param.getSupporterCommonUploadFairResult())) {
			supporterFileGrpSeq = commonService.dext5UploadInsert(param.getSupporterCommonUploadFairResult(), param.getRegUserSeq(), param.getSupporterFileGrpSeq());
    		param.setSupporterFileGrpSeq(supporterFileGrpSeq);
		}
		
		//file Upload
		if(!StringUtil.isEmpty(param.getSponsorCommonUploadFairResult())) {
			sponsorFileGrpSeq = commonService.dext5UploadInsert(param.getSponsorCommonUploadFairResult(), param.getRegUserSeq(), param.getSponsorFileGrpSeq());
    		param.setSponsorFileGrpSeq(sponsorFileGrpSeq);
		}
		
		//file Upload
		if(!StringUtil.isEmpty(param.getBoothCommonUploadFairResult())) {
			boothFileGrpSeq = commonService.dext5UploadInsert(param.getBoothCommonUploadFairResult(), param.getRegUserSeq(), param.getBoothFileGrpSeq());
    		param.setBoothFileGrpSeq(boothFileGrpSeq);
		}
		
		param.setFairSeq(fairMngDAO.selectUUID());
				
    	if (fairMngDAO.insertJobFairMng(param) > 0) {
        	jobFairMngVo.setThumbFileGrpSeq(thumbFileGrpSeq);
        	jobFairMngVo.setFairFileGrpSeq(fairFileGrpSeq);
        	jobFairMngVo.setSupporterFileGrpSeq(supporterFileGrpSeq);
        	jobFairMngVo.setSponsorFileGrpSeq(sponsorFileGrpSeq);
        	jobFairMngVo.setBoothFileGrpSeq(boothFileGrpSeq);
    	} else {
			throw new Exception("시스템 에러");
    	}
    	
    	return jobFairMngVo;
    }

    
	/**
     * 채용행사 등록 관리 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
	@Override
    public FairMngBean updateJobFairMng(FairMngBean param) throws Exception {
		
		FairMngBean fairMngVo = fairMngDAO.selectJobFairMngDetail(param);
		if (!ObjectUtils.isEmpty(fairMngVo) && StringUtils.isNotBlank(fairMngVo.getFairSeq())) {
			fairMngDAO.updateJobFairMng(param);
		} else {
			throw new Exception("권한 인증 실패");
		}
		
    	return fairMngVo;
    }

    
	/**
     * 채용행사 등록 관리 삭제
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean deleteJobFairMng(FairMngBean param) throws Exception {
		FairMngBean fairMngVo = fairMngDAO.selectJobFairMngDetail(param);
		if (!ObjectUtils.isEmpty(fairMngVo) && StringUtils.isNotBlank(fairMngVo.getFairSeq())) {
			fairMngDAO.deleteJobFairMng(param);
		} else {
			throw new Exception("권한 인증 실패");
		}
		
    	return fairMngVo;
    } 
	
	/**
	 * Job Fair Detail Info
	 * @param JobFairBean
	 * @return JobFairBean
	 */
	@Override
	public JobFairBean selectJobFairDtlInfo(JobFairBean param) throws Exception {
		return fairMngDAO.selectJobFairDtlInfo(param);
	}	

	
	/**
     * 주소 2 Depth 목록 조회
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
	@Override	
	public CommDtlCdBean selectLoc1DepthList() throws Exception {
		CommDtlCdBean param = new CommDtlCdBean();
		int totalCount = (int) fairMngDAO.selectLoc1DepthTotalCount();
		List<CommDtlCdBean> list = fairMngDAO.selectLoc1DepthList();

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
    	return param;
    }
}
