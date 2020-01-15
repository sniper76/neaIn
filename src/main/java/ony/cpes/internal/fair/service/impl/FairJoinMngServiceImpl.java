package ony.cpes.internal.fair.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ony.cpes.internal.annualPlan.bean.APIndicDataBean;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.dao.FairJoinMngDAO;
import ony.cpes.internal.fair.service.FairJoinMngService;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;

@Service("FairJoinMngService")
public class FairJoinMngServiceImpl implements FairJoinMngService{

	@Autowired
	private FairJoinMngDAO fairJoinMngDao;

	/**
	 * 상담 목록 조회
	 * @param FairMngBean param
	 * @return List<FairMngBean>
	 */
	@Override
	public FairMngBean selectJobFairJoinStsList(FairMngBean param) throws Exception {
		int totalCount = (int) fairJoinMngDao.selectJobFairJoinMngListTotalCount(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<FairMngBean> list = fairJoinMngDao.selectJobFairJoinMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	/**
     * 채용행사 개인회원 참가 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean selectPrivateUserJoinMngList(FairMngBean param) throws Exception {
		String[] pAge = (StringUtils.isNotBlank(param.getAge())) ? (param.getAge()).split(",") : new String []{} ;
		String[] pPreferntCondCd = (StringUtils.isNotBlank(param.getPreferntCondCd())) ? (param.getPreferntCondCd()).split(",") : new String []{} ;

		param.setAgeList( Arrays.asList(pAge) );
		param.setPreferntCondCdList( Arrays.asList(pPreferntCondCd) );

		int totalCount = (int) fairJoinMngDao.selectPrivateUserJoinMngTotalCount(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<FairMngBean> list = fairJoinMngDao.selectPrivateUserJoinMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	/**
     * 채용행사 개인회원 참가 관리 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean updatePrivateUserJoinMng(FairMngBean param) throws Exception {
		FairMngBean fairMngVo = fairJoinMngDao.selectPrivateUserJoinMngDetail(param);
		if (!ObjectUtils.isEmpty(fairMngVo) && StringUtils.isNotBlank(fairMngVo.getUserSeq())) {
			fairJoinMngDao.updatePrivateUserJoinMng(param);
		} else {
			throw new Exception("권한 인증 실패");
		}
    	return fairMngVo;
	}

	/**
     * 채용행사 기업회원 참가 초청기업 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean selectCompnyMngList(FairMngBean param) throws Exception {
		int totalCount = (int) fairJoinMngDao.selectCompnyMngTotalCount(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<FairMngBean> list = fairJoinMngDao.selectCompnyMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
    }

	/**
     * 채용행사 기업회원 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean selectInviteCompnyList(FairMngBean param) throws Exception {
		int totalCount = (int) fairJoinMngDao.selectInviteCompnyTotalCount(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<FairMngBean> list = fairJoinMngDao.selectInviteCompnyList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
    }

    /**
     * 채용행사 기업회원 초청 등록
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean insertInviteCompny(FairMngBean param) throws Exception {
    	FairMngBean fairMngVo = null;

  		if ( param.getCompnySeqList().size() > 0 ) {
  			for(String seq: param.getCompnySeqList() ) {
  				FairMngBean vo = new FairMngBean();
  	  			vo.setCompnySeq(seq);
  	  			vo.setUser(param.getUser());
  	  			vo.setFairSeq(param.getFairSeq());
  	  			vo.setJcAgreeStsCd(param.getJcAgreeStsCd());
  	  			vo.setCompnyRespYn(param.getCompnyRespYn());
  	  			vo.setInviteYn(param.getInviteYn());

  	  			vo.setRegUserSeq(param.getRegUserSeq());
  	  			fairMngVo = fairJoinMngDao.selectInviteCompnyDetail(vo);
  	  			if (!ObjectUtils.isEmpty(fairMngVo) && StringUtils.isNotBlank(fairMngVo.getCompnySeq())) {
  	  				fairJoinMngDao.insertInviteCompny(vo);

  	  			} else {
  	  				throw new Exception("권한 인증 실패");
  	  			}
  			}
  		}

  		return fairMngVo;
    }

    /**
     * 채용행사 기업회원 참가 신청기업 승인상태 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean updateCompnyRequestMng(FairMngBean param) throws Exception {
		FairMngBean fairMngVo = fairJoinMngDao.selectCompnyMngDetail(param);
		if (!ObjectUtils.isEmpty(fairMngVo) && StringUtils.isNotBlank(fairMngVo.getCompnySeq())) {
			fairJoinMngDao.updateCompnyRequestMng(param);
		} else {
			throw new Exception("권한 인증 실패");
		}

    	return fairMngVo;
    }

	/**
     * 채용행사 기관회원 참가기관 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean selectInsttMngList(FairMngBean param) throws Exception {
		int totalCount = (int) fairJoinMngDao.selectInsttMngTotalCount(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<FairMngBean> list = fairJoinMngDao.selectInsttMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
    }

	/**
     * 채용행사 기관회원 목록 조회
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean selectInviteInsttList(FairMngBean param) throws Exception {
		int totalCount = (int) fairJoinMngDao.selectInviteInsttTotalCount(param);
		param.setTotalCount(totalCount);

		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);

		List<FairMngBean> list = fairJoinMngDao.selectInviteInsttList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
    }

    /**
     * 채용행사 기관회원 초청 등록
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
	@Override
    public FairMngBean insertInviteInstt(FairMngBean param) throws Exception {
    	FairMngBean fairMngVo = null;

  		if ( param.getInsttSeqList().size() > 0 ) {
  			for(String seq: param.getInsttSeqList() ) {
  				FairMngBean vo = new FairMngBean();
  	  			vo.setInsttSeq(seq);
  	  			vo.setUser(param.getUser());
  	  			vo.setFairSeq(param.getFairSeq());
  	  			vo.setJcAgreeStsCd(param.getJcAgreeStsCd());
  	  			vo.setInsttRespYn(param.getInsttRespYn());
  	  			vo.setInviteYn(param.getInviteYn());

  	  			vo.setRegUserSeq(param.getRegUserSeq());
  	  			fairMngVo = fairJoinMngDao.selectInviteInsttDetail(vo);
  	  			if (!ObjectUtils.isEmpty(fairMngVo) && StringUtils.isNotBlank(fairMngVo.getInsttSeq())) {
  	  				fairJoinMngDao.insertInviteInstt(vo);

  	  			} else {
  	  				throw new Exception("권한 인증 실패");
  	  			}
  			}
  		}

  		return fairMngVo;
	}

    /**
     * 채용행사 기관회원 참가 신청기관 승인상태 수정
     *
     * @param FairMngBean param
     * @return FairMngBean
     */
    public FairMngBean updateInsttRequestMng(FairMngBean param) throws Exception {
		FairMngBean fairMngVo = fairJoinMngDao.selectInsttMngDetail(param);
		if (!ObjectUtils.isEmpty(fairMngVo) && StringUtils.isNotBlank(fairMngVo.getInsttSeq())) {
			fairJoinMngDao.updateInsttRequestMng(param);
		} else {
			throw new Exception("권한 인증 실패");
		}

    	return fairMngVo;
    }

	@Override
	public List<FairMngBean> selectCoInvitationList(FairMngBean param) throws Exception {
		return fairJoinMngDao.selectCoInvitationList(param);
	}

	@Override
	public int insertFairPatcptnCompny(FairMngBean param) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		int result = 0;
		List<String> compnySeqList = mapper.readValue(param.getCompnySeqListStr(), new TypeReference<List<String>>(){});

		for(String compnySeq : compnySeqList) {
			param.setCompnySeq(compnySeq);
			result += fairJoinMngDao.insertFairPatcptnCompny(param);
		}

		return result;
	}

	@Override
	public List<FairMngBean> selectInsttInvitationList(FairMngBean param) {
		return fairJoinMngDao.selectInsttInvitationList(param);
	}

	@Override
	public int insertFairPatcptnInstt(FairMngBean param) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		int result = 0;
		List<String> insttSeqList = mapper.readValue(param.getInsttSeqListStr(), new TypeReference<List<String>>(){});

		for(String insttSeq : insttSeqList) {
			param.setInsttSeq(insttSeq);
			result += fairJoinMngDao.insertFairPatcptnInstt(param);
		}

		return result;
	}
}
