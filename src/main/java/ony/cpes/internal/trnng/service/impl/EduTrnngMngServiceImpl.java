package ony.cpes.internal.trnng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.common.base.CaseFormat;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cpes.internal.trnng.bean.EduTrnngBean;
import ony.cpes.internal.trnng.dao.EduTrnngMngDAO;
import ony.cpes.internal.trnng.service.EduTrnngMngService;

@Service("EduTrnngMngService")
public class EduTrnngMngServiceImpl implements EduTrnngMngService{

	@Autowired
	private EduTrnngMngDAO eduTrnngMngDao;
	
	/**
	 * 공통코드 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
	@Override
	public CommDtlCdBean selectInsttMajorCodeList(CommDtlCdBean param) throws Exception {
    	
		List<CommDtlCdBean> list = eduTrnngMngDao.selectInsttMajorCodeList(param);
		param.setList(list);

		return param;
    }
	
	/**
	 * 기관/훈련 목록 조회
	 * @param param EduTrnngMngBean
	 * @return EduTrnngMngBean
	 */
	@Override	
	public EduTrnngMngBean selectEduTrnngList(EduTrnngMngBean param) throws Exception {
		int totalCount = (int) eduTrnngMngDao.selectEduTrnngTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<EduTrnngMngBean> list = eduTrnngMngDao.selectEduTrnngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
	}	

	/**
     * 기관/훈련 상세 조회
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
	@Override
    public EduTrnngMngBean selectEduTrnngDetail(EduTrnngMngBean param) throws Exception {
		return eduTrnngMngDao.selectEduTrnngDetail(param);
    }
    
	/**
     * 기관/훈련 수정
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
	@Override
    public EduTrnngMngBean updateEduTrnng(EduTrnngMngBean param) throws Exception {

    	EduTrnngMngBean eduTrnngMngVo = null;

  		if ( param.getEduTrnngSeqList().size() > 0 ) {
  			for(String seq: param.getEduTrnngSeqList() ) {
  	  			EduTrnngMngBean vo = new EduTrnngMngBean();
  	  			vo.setEduTrnngSeq(seq);
  	  			vo.setUser(param.getUser());
  	  			vo.setRecrumtStsCd(param.getRecrumtStsCd());
  	  			vo.setJcAgreeStsCd(param.getJcAgreeStsCd());
  	  			eduTrnngMngVo = eduTrnngMngDao.selectEduTrnngDetail(vo);
  	  			if (!ObjectUtils.isEmpty(eduTrnngMngVo) && StringUtils.isNotBlank(eduTrnngMngVo.getEduTrnngSeq())) {

  	  				eduTrnngMngDao.updateEduTrnng(vo);
  	  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
  	  				//String uuid = (String)eduTrnngMngDao.selectUUID();
  	  				//param.setEduTrnngLogSeq(uuid);
  	  				//eduTrnngMngDao.insertEduTrnngLog(param);
  	  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/

  	  				//param.setEduTrnngSubSeq(eduTrnngMngVo.getEduTrnngSubSeq());
  	  				//eduTrnngMngDao.updateEduTrnngSub(param);
  	  				//eduTrnngMngDao.insertEduTrnngSubLog(param);
  	  			} else {
  	  				throw new Exception("권한 인증 실패");
  	  			}		
  			}
  			
  		} else {
  	    	eduTrnngMngVo = eduTrnngMngDao.selectEduTrnngDetail(param);
  			if (!ObjectUtils.isEmpty(eduTrnngMngVo) && StringUtils.isNotBlank(eduTrnngMngVo.getEduTrnngSeq())) {

  				eduTrnngMngDao.updateEduTrnng(param);
  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
  				//String uuid = (String)eduTrnngMngDao.selectUUID();
  				//param.setEduTrnngLogSeq(uuid);
  				//eduTrnngMngDao.insertEduTrnngLog(param);
  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
  				
  				//param.setEduTrnngSubSeq(eduTrnngMngVo.getEduTrnngSubSeq());
  				//eduTrnngMngDao.updateEduTrnngSub(param);
  				//eduTrnngMngDao.insertEduTrnngSubLog(param);
	  		} else {
  	  			throw new Exception("권한 인증 실패");
  			}
  		}
    	
		return eduTrnngMngVo;    	
    }
	
	/**
	 * Education Training Detail Info
	 * @param EduTrnngBean
	 * @return EduTrnngBean
	 */
	@Override
	public EduTrnngBean selectEduTrnngDtlInfo(EduTrnngBean param) throws Exception {
		return eduTrnngMngDao.selectEduTrnngDtlInfo(param);
	}		
}
