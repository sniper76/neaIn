package ony.cpes.internal.fair.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.dao.FairVccyMngDAO;
import ony.cpes.internal.fair.service.FairVccyMngService;

@Service("FairVccyMngService")
public class FairVccyMngServiceImpl implements FairVccyMngService{

	@Autowired
	private FairVccyMngDAO fairVccyMngDao;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;	

	/**
     * 채용행사 - 운영관리 - 채용공고 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
    public FairMngBean selectEmpmnAncmtMngList(FairMngBean param) throws Exception {
		String[] pPreferntCondCd = (StringUtils.isNotBlank(param.getPreferntCondCd())) ? (param.getPreferntCondCd()).split(",") : new String []{} ;
		param.setPreferntCondCdList( Arrays.asList(pPreferntCondCd) );
    	
		int totalCount = (int) fairVccyMngDao.selectEmpmnAncmtMngTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<FairMngBean> list = fairVccyMngDao.selectEmpmnAncmtMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
    }
    
    /**
     * 채용행사 - 운영관리 - 채용공고 승인상태 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
    public FairMngBean updateEmpmnAncmtMng(FairMngBean param) throws Exception {
		FairMngBean fairMngVo = fairVccyMngDao.selectEmpmnAncmtMngDetail(param);
		if (!ObjectUtils.isEmpty(fairMngVo) && StringUtils.isNotBlank(fairMngVo.getVacancySeq())) {
			fairVccyMngDao.updateEmpmnAncmtMng(param);
		} else {
			throw new Exception("권한 인증 실패");
		}
    	return fairMngVo;		
    }
    
	/**
     * 채용행사 - 운영관리 - 매핑 안된 채용공고 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
    public FairMngBean selectEmpmnAncmtJoinList(FairMngBean param) throws Exception {
		String[] pPreferntCondCd = (StringUtils.isNotBlank(param.getPreferntCondCd())) ? (param.getPreferntCondCd()).split(",") : new String []{} ;
		param.setPreferntCondCdList( Arrays.asList(pPreferntCondCd) );
    	
		int totalCount = (int) fairVccyMngDao.selectEmpmnAncmtJoinTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<FairMngBean> list = fairVccyMngDao.selectEmpmnAncmtJoinList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
    }
    
	/**
     * 채용행사 - 운영관리 - 매핑 안된 채용공고 매핑
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
	public FairMngBean insertEmpmnAncmtJoinArray(FairMngBean param) throws Exception {
    	FairMngBean fairMngVo = null;

  		if ( param.getVacancySeqList().size() > 0 ) {
  			for(String seq: param.getVacancySeqList() ) {
  				FairMngBean vo = new FairMngBean();
  	  			vo.setVacancySeq(seq);
  	  			vo.setUser(param.getUser());
  	  			vo.setFairSeq(param.getFairSeq());
  	  			vo.setJcAgreeStsCd("JAS0000000001");
  	  			vo.setRegUserSeq(param.getRegUserSeq());
  	  			vo.setModUserSeq(param.getModUserSeq());
  	  			fairMngVo = fairVccyMngDao.selectEmpmnAncmtJoinDetail(vo);
  	  			if (!ObjectUtils.isEmpty(fairMngVo) && StringUtils.isNotBlank(fairMngVo.getVacancySeq())) {
  	  	  	  		vo.setCompnySeq(fairMngVo.getCompnySeq());

  	  	  	  		if (fairVccyMngDao.insertEmpmnAncmtJoin(vo) > 0) {
  	  	  				fairVccyMngDao.updateEmpmnAncmtJoin(vo);
  	  				} else {
  	  	  				throw new Exception("DB ERROR");
  	  				}
  	  			} else {
  	  				throw new Exception("권한 인증 실패");
  	  			}
  			}
  		}
  		
  		return fairMngVo;
	}
    
	/**
     * 채용행사 - 운영관리 - 입사지원 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
	public FairMngBean selectApplicMngList(FairMngBean param) throws Exception {
		String[] pPreferntCondCd = (StringUtils.isNotBlank(param.getPreferntCondCd())) ? (param.getPreferntCondCd()).split(",") : new String []{} ;
		param.setPreferntCondCdList( Arrays.asList(pPreferntCondCd) );
    	
		int totalCount = (int) fairVccyMngDao.selectApplicMngTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<FairMngBean> list = fairVccyMngDao.selectApplicMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}
	
	/**
     * 채용행사 - 운영관리 - 면접제의 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */    
	public FairMngBean selectIntvwMngList(FairMngBean param) throws Exception {
		String[] pPreferntCondCd = (StringUtils.isNotBlank(param.getPreferntCondCd())) ? (param.getPreferntCondCd()).split(",") : new String []{} ;
		param.setPreferntCondCdList( Arrays.asList(pPreferntCondCd) );
    	
		int totalCount = (int) fairVccyMngDao.selectIntvwMngTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<FairMngBean> list = fairVccyMngDao.selectIntvwMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}
	
}
