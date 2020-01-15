package ony.cpes.internal.trnng.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cpes.internal.trnng.dao.JobskPrepareMngDAO;
import ony.cpes.internal.trnng.service.JobskPrepareMngService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.util.StringUtil;

@Service("JobskPrepareMngService")
public class JobskPrepareMngServiceImpl implements JobskPrepareMngService{

	@Autowired
	private JobskPrepareMngDAO jobskPrepareMngDao;
	
	@Autowired
	private CommonService commonService;

	/**
     * 주소 2 Depth 목록 조회
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
	@Override	
	public CommDtlCdBean selectLOC2DepthList() throws Exception {
		CommDtlCdBean param = new CommDtlCdBean();
		int totalCount = (int) jobskPrepareMngDao.selectLOC2DepthTotalCount();
		List<CommDtlCdBean> list = jobskPrepareMngDao.selectLOC2DepthList();

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
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
		int totalCount = (int) jobskPrepareMngDao.selectEduTrnngTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<EduTrnngMngBean> list = jobskPrepareMngDao.selectEduTrnngList(param);

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
		return jobskPrepareMngDao.selectEduTrnngDetail(param);
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
  	  			vo.setDelYn(param.getDelYn());
  	  			
  	  			eduTrnngMngVo = jobskPrepareMngDao.selectEduTrnngDetail(vo);
  	  			if (!ObjectUtils.isEmpty(eduTrnngMngVo) && StringUtils.isNotBlank(eduTrnngMngVo.getEduTrnngSeq())) {

  	  				jobskPrepareMngDao.updateEduTrnng(vo);
  	  				//jobskPrepareMngDao.updateEduTrnngSub(param);
  	  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
  	  				//String uuid = (String)jobskPrepareMngDao.selectUUID();
  	  				//param.setEduTrnngLogSeq(uuid);
  	  				//jobskPrepareMngDao.insertEduTrnngLog(param);
  	  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/

  	  				//param.setEduTrnngSubSeq(eduTrnngMngVo.getEduTrnngSubSeq());
  	  				//jobskPrepareMngDao.insertEduTrnngSubLog(param);
  	  			} else {
  	  				throw new Exception("권한 인증 실패");
  	  			}		
  			}
  			
  		} else {
  	    	eduTrnngMngVo = jobskPrepareMngDao.selectEduTrnngDetail(param);
  			if (!ObjectUtils.isEmpty(eduTrnngMngVo) && StringUtils.isNotBlank(eduTrnngMngVo.getEduTrnngSeq())) {
  				
  				String teachOneFileGrpSeq = "";
  				String teachTwoFileGrpSeq = "";
  				String lectureFileGrpSeq = "";
  				//file Upload
  				if(!StringUtil.isEmpty(param.getTeachOneCommonUploadResult())) {
  					teachOneFileGrpSeq = commonService.dext5UploadInsert(param.getTeachOneCommonUploadResult(), param.getRegUserSeq(), param.getTeacher1PhotoFileGrpSeq());
  		    		param.setTeacher1PhotoFileGrpSeq(teachOneFileGrpSeq);
  				}
  				
  				//file Upload
  				if(!StringUtil.isEmpty(param.getTeachTwoCommonUploadResult())) {
  					teachTwoFileGrpSeq = commonService.dext5UploadInsert(param.getTeachTwoCommonUploadResult(), param.getRegUserSeq(), param.getTeacher2PhotoFileGrpSeq());
  		    		param.setTeacher2PhotoFileGrpSeq(teachTwoFileGrpSeq);
  				}
  				
  				//file Upload
  				if(!StringUtil.isEmpty(param.getLectureCommonUploadResult())) {
  					lectureFileGrpSeq = commonService.dext5UploadInsert(param.getLectureCommonUploadResult(), param.getRegUserSeq(), param.getLecturePhotoFileGrpSeq());
  		    		param.setLecturePhotoFileGrpSeq(lectureFileGrpSeq);
  				}

  				jobskPrepareMngDao.updateEduTrnng(param);
  				jobskPrepareMngDao.updateEduTrnngSub(param);
  				
  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
  				//String uuid = (String)jobskPrepareMngDao.selectUUID();
  				//param.setEduTrnngLogSeq(uuid);
  				//jobskPrepareMngDao.insertEduTrnngLog(param);
  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
  				
  				//param.setEduTrnngSubSeq(eduTrnngMngVo.getEduTrnngSubSeq());
  				//jobskPrepareMngDao.insertEduTrnngSubLog(param);
	  		} else {
  	  			throw new Exception("권한 인증 실패");
  			}
  		}
    	
		return eduTrnngMngVo;    	
    }
	
	@Override
	public String selectUUID() throws Exception{
		String uuid = (String)jobskPrepareMngDao.selectUUID();
		return uuid;
	}
	
	/**
     * 기관/훈련 등록
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */    
	@Override
	public EduTrnngMngBean insertEduTrnng(EduTrnngMngBean param) throws Exception {
			EduTrnngMngBean eduTrnngMngVo = new EduTrnngMngBean();
			String uuid = (String)jobskPrepareMngDao.selectUUID();
			param.setEduTrnngSeq(uuid);
		
			param.setJcAgreeStsCd("JAS0000000001");
			param.setJcCd("JCT9999999999");
			param.setEduDivCd("EDC0000000001");
			
			//INSTT SEQ NEA 직원용 시퀀스 따주기로 함 일단 데이터 만들고 하드코딩함.
			param.setInsttSeq("3401a240ffadg3e9abf28cec4b8e345c");
			
			String subUuid = (String)jobskPrepareMngDao.selectUUID();
			param.setEduTrnngSubSeq(subUuid);
			
			String teachOneFileGrpSeq = "";
			String teachTwoFileGrpSeq = "";
			String lectureFileGrpSeq = "";
			
			//file Upload
			if(!StringUtil.isEmpty(param.getTeachOneCommonUploadResult())) {
				teachOneFileGrpSeq = commonService.dext5UploadInsert(param.getTeachOneCommonUploadResult(), param.getRegUserSeq(), param.getTeacher1PhotoFileGrpSeq());
	    		param.setTeacher1PhotoFileGrpSeq(teachOneFileGrpSeq);
			}
			
			//file Upload
			if(!StringUtil.isEmpty(param.getTeachTwoCommonUploadResult())) {
				teachTwoFileGrpSeq = commonService.dext5UploadInsert(param.getTeachTwoCommonUploadResult(), param.getRegUserSeq(), param.getTeacher2PhotoFileGrpSeq());
	    		param.setTeacher2PhotoFileGrpSeq(teachTwoFileGrpSeq);
			}
			
			//file Upload
			if(!StringUtil.isEmpty(param.getLectureCommonUploadResult())) {
				lectureFileGrpSeq = commonService.dext5UploadInsert(param.getLectureCommonUploadResult(), param.getRegUserSeq(), param.getLecturePhotoFileGrpSeq());
	    		param.setLecturePhotoFileGrpSeq(lectureFileGrpSeq);
			}

			jobskPrepareMngDao.insertEduTrnng(param);
			jobskPrepareMngDao.insertEduTrnngSub(param);
			
			/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
			//String uuid = (String)jobskPrepareMngDao.selectUUID();
			//param.setEduTrnngLogSeq(uuid);
			//jobskPrepareMngDao.insertEduTrnngLog(param);
			/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
			
			//param.setEduTrnngSubSeq(eduTrnngMngVo.getEduTrnngSubSeq());
			//jobskPrepareMngDao.insertEduTrnngSubLog(param);
			
			eduTrnngMngVo.setEduTrnngSeq(uuid);
		return eduTrnngMngVo;
	}
	
	/**
     * 

     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
	@Override
	public EduTrnngMngBean deleteEduTrnng(EduTrnngMngBean param) throws Exception {
    	EduTrnngMngBean eduTrnngMngVo = null;

  		if ( param.getEduTrnngSeqList().size() > 0 ) {
  			for(String seq: param.getEduTrnngSeqList() ) {
  	  			EduTrnngMngBean vo = new EduTrnngMngBean();
  	  			vo.setEduTrnngSeq(seq);
  	  			
  	  			eduTrnngMngVo = jobskPrepareMngDao.selectEduTrnngDetail(vo);
  	  			if (!ObjectUtils.isEmpty(eduTrnngMngVo) && StringUtils.isNotBlank(eduTrnngMngVo.getEduTrnngSeq())) {

  	  				jobskPrepareMngDao.deleteEduTrnng(vo);
  	  				//jobskPrepareMngDao.updateEduTrnngSub(param);
  	  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
  	  				//String uuid = (String)jobskPrepareMngDao.selectUUID();
  	  				//param.setEduTrnngLogSeq(uuid);
  	  				//jobskPrepareMngDao.insertEduTrnngLog(param);
  	  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/

  	  				//param.setEduTrnngSubSeq(eduTrnngMngVo.getEduTrnngSubSeq());
  	  				//jobskPrepareMngDao.insertEduTrnngSubLog(param);
  	  			} else {
  	  				throw new Exception("권한 인증 실패");
  	  			}		
  			}
  			
  		} else {
  	    	eduTrnngMngVo = jobskPrepareMngDao.selectEduTrnngDetail(param);
  			if (!ObjectUtils.isEmpty(eduTrnngMngVo) && StringUtils.isNotBlank(eduTrnngMngVo.getEduTrnngSeq())) {

  				jobskPrepareMngDao.deleteEduTrnng(param);
  				
  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
  				//String uuid = (String)jobskPrepareMngDao.selectUUID();
  				//param.setEduTrnngLogSeq(uuid);
  				//jobskPrepareMngDao.insertEduTrnngLog(param);
  				/*로그 테이블 컬럼 갱신 전으로 임시 주석 처리*/
  				
  				//param.setEduTrnngSubSeq(eduTrnngMngVo.getEduTrnngSubSeq());
  				//jobskPrepareMngDao.insertEduTrnngSubLog(param);
	  		} else {
  	  			throw new Exception("권한 인증 실패");
  			}
  		}
    	
		return eduTrnngMngVo;
	}
	
	/**
	 * 구직준비교육신청자 목록 조회
	 * @param param EduTrnngMngBean
	 * @return EduTrnngMngBean
	 */
	@Override	
	public EduTrnngMngBean selectJobskPrepareSubscriberList(EduTrnngMngBean param) throws Exception {
		int totalCount = (int) jobskPrepareMngDao.selectJobskPrepareSubscriberTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<EduTrnngMngBean> list = jobskPrepareMngDao.selectJobskPrepareSubscriberList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
	}
	
	/**
     * 구직준비교육신청자 상태 수정
     *
     * @param EduTrnngMngBean param
     * @return EduTrnngMngBean
     */
	@Override
    public EduTrnngMngBean updateJobskPrepareSubscriber(EduTrnngMngBean param) throws Exception {
    	EduTrnngMngBean eduTrnngMngVo = null;

  		if ( param.getSubscriberUserSeqList().size() > 0 ) {
  			for(String userSeq: param.getSubscriberUserSeqList() ) {
  	  			EduTrnngMngBean vo = new EduTrnngMngBean();
  	  			vo.setUserSeq(userSeq);
  	  			vo.setEduTrnngSeq(param.getEduTrnngSeq());
  	  			vo.setJcAgreeStsCd(param.getJcAgreeStsCd());
  	  			vo.setUser(param.getUser());
  	  			
  	  			eduTrnngMngVo = jobskPrepareMngDao.selectJobskPrepareSubscriberDetail(vo);
  	  			if (!ObjectUtils.isEmpty(eduTrnngMngVo) && StringUtils.isNotBlank(eduTrnngMngVo.getUserSeq())) {

  	  				jobskPrepareMngDao.updateJobskPrepareSubscriber(vo);
  	  			} else {

  	  				throw new Exception("권한 인증 실패");
  	  			}		
  			}
  			
  		}
    	
		return eduTrnngMngVo;    	
    }	
}
