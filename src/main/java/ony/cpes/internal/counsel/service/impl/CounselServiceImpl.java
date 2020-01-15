package ony.cpes.internal.counsel.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ony.cmm.common.bean.FileBean;
import ony.cmm.common.dao.CommonDAO;
import ony.cpes.internal.counsel.bean.CounselBean;
import ony.cpes.internal.counsel.dao.CounselDAO;
import ony.cpes.internal.counsel.service.CounselService;
import ony.framework.util.StringUtil;

@Service("CounselService")
public class CounselServiceImpl implements CounselService{

	@Autowired
	private CounselDAO counselDao;

	@Autowired
	private CommonDAO commonDAO;


	/**
	 * 상담 목록 조회
	 * @param CounselBean param
	 * @return List<CounselBean>
	 */
	@Override
	public CounselBean selectCounselList(CounselBean param) throws Exception {
		int totalCount = (int) counselDao.selectCounselListTotalCount(param);
		List<CounselBean> list = counselDao.selectCounselList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	/**
	 * 일반회원 상담내역 조회
	 * @param CounselBean param
	 * @return List<CounselBean>
	 */
	@Override
	public CounselBean selectUserCounselHis(CounselBean param) throws Exception {
		int totalCount = (int) counselDao.selectUserCounselHisTotalCount(param);
		List<CounselBean> list = counselDao.selectUserCounselHis(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
	}

	/**
	 * 상담 상세 조회
	 * @param CounselBean param
	 * @return CounselBean
	 */
	@Override
	public CounselBean selectCounselDetail(CounselBean param) throws Exception {
		return counselDao.selectCounselDetail(param);
	}

	/**
	 * 상담내역 상세 조회
	 * @param CounselBean param
	 * @return CounselBean
	 */
	@Override
	public CounselBean selectCounselHistDetail(CounselBean param) throws Exception {
		return counselDao.selectCounselHistDetail(param);
	}

	/**
	 * 상담 등록
	 * @param CounselBean param
	 * @return CounselBean
	 */
	@Override
	public CounselBean insertCounsel(CounselBean param) throws Exception {
		CounselBean returnResult = null;

		String uuid = (String)counselDao.selectUUID();
		param.setCounselSeq(uuid);

		int result = counselDao.insertCounsel(param);

		if(result > 0) {
			CounselBean resultParam = new CounselBean();
			resultParam.setCounselSeq(uuid);
			returnResult = counselDao.selectCounselDetail(resultParam);
		}

		return returnResult;
	}

	/**
	 * 상담 수정
	 * @param CounselBean param
	 * @return CounselBean
	 */
	@Override
	public CounselBean updateCounsel(CounselBean param) throws Exception {
		CounselBean counselVo = null;

		counselVo = counselDao.selectCounselDetail(param);
		if (!ObjectUtils.isEmpty(counselVo) && StringUtils.isNoneBlank(counselVo.getCounselSeq())) {

			if(!StringUtil.isEmpty(param.getUploadResult())) {
				ObjectMapper mapper = new ObjectMapper();
    			// 파일 그룹 seq
    	    	String ansFileGrpSeq = commonDAO.selectUUID();
    			Map<String, List<String>> fileList = mapper.readValue(param.getUploadResult(), new TypeReference<Map<String, List<String>>>(){});
    			int listSize = fileList.get("originalName").size();

    			for(int i = 0; i<listSize; i++) {
    				FileBean fileBean = new FileBean();
    				fileBean.setOriginalNm(fileList.get("originalName").get(i));
    				fileBean.setSaveNm(fileList.get("uploadName").get(i));
    				fileBean.setSaveFilePath(fileList.get("uploadPath").get(i));
    				fileBean.setFileSize(fileList.get("size").get(i));
    				fileBean.setRegUserSeq(param.getUser().getUserSeq());

    				String extension = fileList.get("extension").get(i).toLowerCase();
    				fileBean.setFileExtension(extension);

    				fileBean.setFileGrpSeq(ansFileGrpSeq);
    				param.setAnsFileGrpSeq(ansFileGrpSeq);

    				commonDAO.insertAttachFiles(fileBean);
    			}

    			counselDao.updateCounsel(param);
    		}

		}

		return counselVo;
	}

	/**
	 * 상담 삭제
	 * @param CounselBean param
	 * @return CounselBean
	 */
	@Override
	public CounselBean deleteCounsel(CounselBean param) throws Exception {
		CounselBean counselVo = null;

		counselVo = counselDao.selectCounselDetail(param);
		if (!ObjectUtils.isEmpty(counselVo) && StringUtils.isNoneBlank(counselVo.getCounselSeq())) {
			counselDao.deleteCounsel(param);
		}

		return counselVo;
	}
}
