package ony.cpes.internal.fair.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.fair.bean.FairBoothMngBean;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.dao.FairBoothMngDAO;
import ony.cpes.internal.fair.dao.FairMngDAO;
import ony.cpes.internal.fair.service.FairBoothMngService;

@Service("FairBoothMngService")
public class FairBoothMngServiceImpl implements FairBoothMngService{

	@Autowired
	private FairMngDAO fairMngDAO;
	
	@Autowired
	private FairBoothMngDAO fairBoothMngDAO;

	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;

	
	/**
     * 채용행사 부스 관리 목록 조회
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	@Override
    public FairBoothMngBean selectBoothRegList(FairBoothMngBean param) throws Exception {    	
		FairMngBean fairMng = new FairMngBean();
    	fairMng.setFairSeq(param.getFairSeq());
    	fairMng = fairMngDAO.selectJobFairMngDetail(fairMng);

    	List<FairBoothMngBean> list = fairBoothMngDAO.selectBoothRegList(param);

    	param.setBoothEmail(fairMng.getBoothEmail());
    	param.setBoothTel(fairMng.getBoothTel());
    	param.setBoothFeeExpln(fairMng.getBoothFeeExpln());
    	param.setList(list);

    	return param;
	}
	
	/**
     * 채용행사 부스 관리 등록 및 수정
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	@Override
    public FairBoothMngBean mergeBoothRegMng(FairBoothMngBean param) throws Exception {
    	List<FairBoothMngBean> insertList = new ArrayList<FairBoothMngBean>();  
    	List<FairBoothMngBean> updateList = new ArrayList<FairBoothMngBean>();
    	FairBoothMngBean updateVo = null;
    	FairBoothMngBean insertVo = null;
    	
		fairBoothMngDAO.updateFairMng(param);
    	
    	if ( param.getBoothSeqList().size() > 0 ) {
    		int i = 0;
        	
    		for(String boothSeq: param.getBoothSeqList() ) {
        		if (StringUtils.isNoneBlank(boothSeq)) {
        			updateVo = new FairBoothMngBean();
        			updateVo.setBoothSeq(boothSeq);
        			updateVo.setFairSeq(param.getFairSeq());
        			updateVo.setBoothNm(param.getBoothNmList().get(i));
        			updateVo.setBoothFee(param.getBoothFeeList().get(i));
        			updateVo.setUseYn(param.getUseYnList().get(i));
        			updateVo.setRegUserSeq(param.getRegUserSeq());
        			updateList.add(updateVo);
        		} else {
        			insertVo = new FairBoothMngBean();
        			insertVo.setFairSeq(param.getFairSeq());
        			insertVo.setBoothNm(param.getBoothNmList().get(i));
        			insertVo.setBoothFee(param.getBoothFeeList().get(i));
        			insertVo.setUseYn(param.getUseYnList().get(i));
        			insertVo.setBoothStsCd("BSC0000000001");
        			insertVo.setRegUserSeq(param.getRegUserSeq());
        			insertList.add(insertVo);
        		}        		
        	
        		i++;
        	}

        	if(updateList.size() > 0) {
        		updateVo.setList(updateList);
        		fairBoothMngDAO.updateBoothRegMng(updateVo);
        	}

        	if(insertList.size() > 0) {
        		insertVo.setList(insertList);
        		fairBoothMngDAO.insertBoothRegMng(insertVo);
        	}
    	}

    	return param;
    }
    
	/**
     * 채용행사 부스 관리 - 신청 목록
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	@Override
	public FairBoothMngBean selectBoothReqMngList(FairBoothMngBean param) throws Exception {
		int totalCount = (int) fairBoothMngDAO.selectBoothReqMngTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<FairBoothMngBean> list = fairBoothMngDAO.selectBoothReqMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}
	
	/**
     * 채용행사 부스 관리 - 예비 신청 목록
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	@Override	
	public FairBoothMngBean selectBoothResvMngList(FairBoothMngBean param) throws Exception {
		int totalCount = (int) fairBoothMngDAO.selectBoothResvMngTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<FairBoothMngBean> list = fairBoothMngDAO.selectBoothResvMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	/**
     * 채용행사 부스 관리 - 예약상태 변경
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	@Override
	public FairBoothMngBean updateBoothReqMng(FairBoothMngBean param) throws Exception {
		FairBoothMngBean fairBoothMngVo = fairBoothMngDAO.selectBoothReqMngDetail(param);
		if (!ObjectUtils.isEmpty(fairBoothMngVo) && StringUtils.isNotBlank(fairBoothMngVo.getBoothSeq())) {
			fairBoothMngDAO.updateBoothReqMng(param);
		} else {
			throw new Exception("Authority Fail");
		}
    	return fairBoothMngVo;
	}

	/**
     * 채용행사 부스 관리 - 기업/기관 부스 매핑 해제
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	@Override
	public FairBoothMngBean deleteBoothReqMng(FairBoothMngBean param) throws Exception {
		FairBoothMngBean fairBoothMngVo = fairBoothMngDAO.selectBoothReqMngDetail(param);
		if (!ObjectUtils.isEmpty(fairBoothMngVo) && StringUtils.isNotBlank(fairBoothMngVo.getBoothSeq())) {
			fairBoothMngDAO.deleteBoothReqMng(param);
		} else {
			throw new Exception("Authority Fail");
		}
    	return fairBoothMngVo;
	}

	/**
     * 채용행사 부스 관리 - 기업/기관 부스 변경
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */
	@Override
	public FairBoothMngBean updateBoothCompnyInsttMng(FairBoothMngBean param) throws Exception {
		FairBoothMngBean fairBoothMngVo = fairBoothMngDAO.selectBoothReqMngDetail(param);
		if (!ObjectUtils.isEmpty(fairBoothMngVo) && StringUtils.isNotBlank(fairBoothMngVo.getBoothSeq())) {
			fairBoothMngDAO.updateBoothCompnyInsttMng(param);
		} else {
			throw new Exception("Authority Fail");
		}
    	return fairBoothMngVo;
	}
	


	/**
     * 채용행사 부스 관리 - 기업/기관 선택 팝업 조회 리스트
     *
     * @param FairBoothMngBean param
     * @return FairBoothMngBean
     */	
	public FairBoothMngBean selectBoothReqListLayer(FairBoothMngBean param) throws Exception {
		List<FairBoothMngBean> list = null;
		String searchReqDiv = StringUtils.isBlank(param.getSearchReqDiv()) ? "A" : param.getSearchReqDiv() ;
		if ("A".equals(searchReqDiv)) {
	    	list = fairBoothMngDAO.selectBoothReqListLayerA(param);
		} else {
			list = fairBoothMngDAO.selectBoothReqListLayerB(param);
		}
    	param.setList(list);
    	return 	param;	
	}
	
}
