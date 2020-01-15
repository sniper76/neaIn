package ony.cpes.internal.bulletin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ony.cpes.internal.bulletin.service.BulletinService;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cmm.common.bean.FileBean;
import ony.cmm.common.dao.CommonDAO;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.bulletin.controller.BulletinController;
import ony.cpes.internal.bulletin.dao.BulletinDAO;
import ony.framework.bean.PagingBean;
import ony.framework.util.StringUtil;

@Service("BulletinService")
public class BulletinServiceImpl implements BulletinService{

	private static Log log = LogFactory.getLog(BulletinServiceImpl.class);

	@Autowired
	private BulletinDAO bulletinDAO;
	
	@Autowired
	private CommonService commonService;

	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;

	/**
	 * 게시판관리 목록 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
	@Override
	public BulletinBean selectBulletinList(BulletinBean param) throws Exception {

		int totalCount = bulletinDAO.selectBulletinBasicTotalCount(param);
		List<BulletinBean> list = bulletinDAO.selectBulletinBasicList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
    }


	/**
	 * 사용자조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
	@Override
	public String selectUserInfo(Map<String,Object> param) throws Exception {

		Map<String,Object> resInfo = new HashMap<String,Object>();

		String userNm = bulletinDAO.selectUserInfo(param);

		//resInfo.put("userNm", userNm);

		return userNm;
    }

	/**
	 * 게시판 설정 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
	@Override
	public BulletinBean selectBulletinConf(Map<String,Object> param) throws Exception {

		Map<String,Object> resInfo = new HashMap<String,Object>();

		BulletinBean bulletinBean = bulletinDAO.selectBulletinConf(param);

		return bulletinBean;
    }

	/**
	 * 게시판 공지수 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
	@Override
	public BulletinBean selectBulletinNotiCnt(BulletinBean param) throws Exception {

		BulletinBean bulletinBean = new BulletinBean();

		int noCnt = bulletinDAO.selectBulletinNoticeCnt(param);

		bulletinBean.setNotiCnt(noCnt);

		return bulletinBean;
    }


	/**
	 * 게시판 일반 추가
	 * @param param BsnsBean
	 * @return Map
	 */
	@Override
	public Map<String,Object> insertBulletinBasic(BulletinBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		String fileGrpSeq = "";


		String uuid = (String)bulletinDAO.getUUID();
		param.setBulletinSeq(uuid);
		
		
		//file Upload
		if(!StringUtil.isEmpty(param.getUploadResult())) {

    		fileGrpSeq = commonService.dext5UploadInsert(param.getUploadResult(), param.getUser().getUserSeq(), param.getFileGrpSeq());
    		param.setFileGrpSeq(fileGrpSeq);
		}

		param.setDelYn("N");

		int resultCd = bulletinDAO.insertBulletinBasic(param);

		if(resultCd > 0) {
			result.put("fileGrpSeq", fileGrpSeq);
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}

		return result;
    }


	/**
	 * 게시판 상세 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
	@Override
    public BulletinBean selectBulletinDtl(BulletinBean param) throws Exception {

		BulletinBean bulletinBean = new BulletinBean();

		bulletinBean = bulletinDAO.selectBulletinDtl(param);

		return bulletinBean;
    }

	/**
	 * 게시판관리 삭제
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
	@Override
	public Map<String,Object> deleteBulletinDtl(BulletinBean param) throws Exception {

		Map<String,Object> result = new HashMap<String,Object>();

		try {

				int resultCd = bulletinDAO.deleteBulletinDtl(param);

				if(resultCd > 0) {
					result.put("stat", "0000"); //success
					result.put("msg", "");
				}else {
					result.put("stat", "1111"); //fail
					result.put("msg", "");
				}


		} catch (Exception e) {
			result.put("stat", "1111");
			result.put("msg", e.getCause().getMessage());
    	}

		return result;

    }

	/**
	 * 게시판관리 수정
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
	@Override
	public Map<String,Object> updateBulletinDtl(HttpServletRequest request ,BulletinBean param,  Locale locale) throws Exception {
		BulletinBean bulletinBeanVo = null;
		Map<String,Object> result = new HashMap<String,Object>();
		int resultCd = 0;
 
		if (param.getBulletinSeqList().size() > 0) {
  			for(String seq: param.getBulletinSeqList() ) {
  				BulletinBean vo = new BulletinBean();
  	  			vo.setBulletinSeq(seq);
  	  			vo.setUser(param.getUser());
  	  			vo.setNtcYn(param.getNtcYn());
  	  			bulletinBeanVo = bulletinDAO.selectBulletinDtl(vo);
  	  			if (!ObjectUtils.isEmpty(bulletinBeanVo) && StringUtils.isNotBlank(bulletinBeanVo.getBulletinSeq())) {
  	  				resultCd += bulletinDAO.updateBulletinDtl(vo);
  	  			} else {
  	  				throw new Exception("권한 인증 실패");
  	  			}
  			}

			if(resultCd > 0) {
				result.put("stat", "0000"); //success
				result.put("msg", "");
			}else {
				result.put("stat", "1111"); //fail
				result.put("msg", "");
			}

		} else {
			try {
				
				if(!StringUtil.isEmpty(param.getUploadResult())) {
		    		String fileGrpSeq = commonService.dext5UploadInsert(param.getUploadResult(), param.getUser().getUserSeq(), param.getFileGrpSeq());
		    		
		    		param.setFileGrpSeq(fileGrpSeq);
				}

				resultCd = bulletinDAO.updateBulletinDtl(param);

				if(resultCd > 0) {
					result.put("stat", "0000"); //success
					result.put("msg", "");
				}else {
					result.put("stat", "1111"); //fail
					result.put("msg", "");
				}
			} catch (Exception e) {
				result.put("stat", messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				result.put("msg", messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
	    	}
		}

		return result;

    }

	/**
     * 게시판 FAQ 카테고리 목록 조회
     *
     * @param param MockQuestBean
     * @return MockAcntMstBean
     */
	@Override
	public BulletinBean selectBulletinCateList(BulletinBean param) throws Exception {
		List<BulletinBean> list = bulletinDAO.selectBulletinCateList(param);
		param.setList(list);
		return param;
	}
}
