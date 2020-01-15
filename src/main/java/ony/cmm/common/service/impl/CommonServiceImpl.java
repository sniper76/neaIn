package ony.cmm.common.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.bean.CommonBean;
import ony.cmm.common.bean.FileBean;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.bean.IsicBean;
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.bean.SmsBean;
import ony.cmm.common.bean.SysConnLogBean;
import ony.cmm.common.dao.CommonDAO;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.common.dao.JobCenterDAO;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseConfig;
import ony.framework.util.FileUtil;
import ony.framework.util.KeyGenerateUtil;
import ony.framework.util.StringUtil;

@Service("CommonService")
public class CommonServiceImpl implements CommonService{

	@Autowired
	private CommonDAO commonDao;

	@Autowired
	private JobCenterDAO jobCenterDao;

	@Override
	/**
	 * 공통코드 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public CommDtlCdBean selectCommCodeList(CommDtlCdBean param) throws Exception {

		int totalCount = (int) commonDao.selectCommCodeListTotalCount(param);
		List<CommDtlCdBean> list = commonDao.selectCommCodeList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);

		return param;
    }


	/**
	 * inquiry of job_center info
	 * @param username
	 * @return
	 */
	public JobCenterBean selectJcCodeList(JobCenterBean param) throws Exception {
		param.setStart(0);
		param.setLength(999);
		List<JobCenterBean> list = jobCenterDao.selectJobCenterList(param);
		param.setList(list);

		return param;
    }

	/**
	 *
	 */
	public UserBean selectCommonUserDtlInfo() throws Exception {
		UserBean user = new UserBean();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user.setMngId((String) authentication.getPrincipal());
		try {
			user = commonDao.selectCommonUserDtlInfo(user);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return user;
	}


	/**
	 * 주소찾기 팝업
	 */
	public LocationBean selectLoction(LocationBean param) throws Exception {

		try {
			List<LocationBean> list = commonDao.selectLoction(param);
			param.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return param;
	}


	public IscoBean selectIscoCd(IscoBean param) throws Exception {
		try {
			List<IscoBean> list = commonDao.selectIscoCd(param);
			param.setList(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return param;
	}

	public List<CommonBean> selectIscoCdList(CommonBean param) throws Exception {
		return commonDao.selectIscoCdList(param);
	}


	public SmsBean insertSmsLog(SmsBean param) throws Exception {


		String respContent	= "";

		if (param == null) {

		}

		if(param.getSmsUsername() == null || "".equals(param.getSmsUsername())) {

		}

		if(param.getSmsPassword() == null || "".equals(param.getSmsPassword())) {

		}

		if(param.getSmsFrom() == null || "".equals(param.getSmsFrom())) {

		}

		if(param.getSmsTo() == null || "".equals(param.getSmsTo())) {

		}

		String smsUrl = "http://tool.plasgate.com:11040/cgi-bin/sendsms";

		param.setSmsUsername("minlwapi_pop");
		param.setSmsPassword("Mi!kw@81");
		param.setSmsFrom("SMS info");



		int sendResult = commonDao.insertSmsLog(param);

		if(sendResult > 0) {
//			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(smsUrl);
			CloseableHttpClient client = HttpClientBuilder.create().build();

			List<NameValuePair> params = new ArrayList<NameValuePair>();

			params.add(new BasicNameValuePair("gw-username", param.getSmsUsername()));
			params.add(new BasicNameValuePair("gw-password", param.getSmsPassword()));
			params.add(new BasicNameValuePair("gw-from", param.getSmsFrom()));
			params.add(new BasicNameValuePair("gw-to", param.getSmsTo()));
			params.add(new BasicNameValuePair("gw-text", param.getSmsText()));

			try {
				httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// writing error to Log
				e.printStackTrace();
			}

			try {

				HttpResponse response =    client.execute(httpPost);
				HttpEntity respEntity = response.getEntity();
				if (respEntity != null)
				{
					// EntityUtils to get the reponse content
					respContent = EntityUtils.toString(respEntity);
					Map<String, String> queryMap = getQueryParser(respContent);

					if(queryMap != null && queryMap.get("status") != null) {
						param.setSmsStatus(queryMap.get("status"));
					}
					if(queryMap != null && queryMap.get("err_msg") != null) {
						param.setSmsErrMsg(queryMap.get("err_msg"));
					}
					if(queryMap != null && queryMap.get("msgid") != null) {
						param.setSmsMsgid(queryMap.get("msgid"));
					}


				} else {
					param.setResultCode("9999");
					param.setSmsStatus("9999");
					param.setSmsErrMsg("ERROR");
				}


			} catch (Exception e) {
				param.setResultCode("9999");
				param.setSmsStatus("9999");
				param.setSmsErrMsg(e.toString());

			} finally {
				int result2 = commonDao.updateSmsLog(param);
			}
		}


		return param ;
	}


	public static Map<String, String> getQueryParser(String query) {

        Map<String, String> returnData = new HashMap<String, String>();
        // query is from getQuery()
        StringTokenizer st = new StringTokenizer(query, "&", false);

        while (st.hasMoreElements()) {
            // First Pass to retrive the
            // "parametername=value" combo
            String paramValueToken = st.nextElement().toString();
            // StringTokenizer stParamVal = new StringTokenizer(paramValueToken,"=", false );

            //방식 변경
            String[] strParamVal = paramValueToken.split("=", 2);
            String paramName = strParamVal[0];
            String paramValue = strParamVal[1];
            returnData.put(paramName, paramValue);

             /* int i = 0;
            while (stParamVal.hasMoreElements()) {
                //Second pass to separate the "paramname" and "value".
                // 1st token is param name
                // 2nd token is param value

                String separatedToken = stParamVal.nextElement().toString();

                if ( i== 0) {
                    //This indicates that it is the param name : ex val4,val5 etc
                    paramName = separatedToken;
                } else {
                    // This will hold value of the parameter
                    paramValue = separatedToken;
                }

                i++;
            }*/
        }
        return returnData;

    }


	@Override
	public List<JobCenterBean> selectJobCenterListForSelectBox() {
		return commonDao.selectJobCenterListForSelectBox();
	}


	@Override
	public int insertAttachFiles(FileBean param) {
		return commonDao.insertAttachFiles(param);
	}


	@Override
	public List<FileBean> selectAttachFilesList(FileBean param) {
		return commonDao.selectAttachFilesList(param);
	}

	@Override
	public String dext5UploadInsert(String param, String userSeq, String fileGrpSeq) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String fileSeq = "";

		Map<String, Map<String, List<String>>> fileList = mapper.readValue(param, new TypeReference<Map<String, Map<String, List<String>>>>(){});

		Map<String, List<String>> oldList = fileList.get("webFile");
		int oldListSize = oldList.get("originalName").size();
		List<FileBean> oldFileList = null;

		if(!StringUtil.isEmpty(fileGrpSeq)) {
			FileBean checkFileBean = new FileBean();
			checkFileBean.setFileGrpSeq(fileGrpSeq);
			oldFileList = commonDao.selectAttachFilesList(checkFileBean);

			for(FileBean fb : oldFileList) {
				boolean flag = false;
				for(int i = 0; i<oldListSize; i++) {
					String oldListKey = oldList.get("uniqKey").get(i);

					if(fb.getFileSeq().equals(oldListKey)) {
						flag = true;
					}
				}

				if(!flag) {
					File deleteFile = new File(fb.getSaveFilePath());
	              	if(deleteFile.exists()) {
	              		deleteFile.delete();
	              		commonDao.deleteAttachFiles(fb);
	              	}
				}
			}
		}

		Map<String, List<String>> newList = fileList.get("newFile");
		int listSize = newList.get("originalName").size();

		for(int i = 0; i<listSize; i++) {
			FileBean fileBean = new FileBean();
			fileBean.setOriginalNm(newList.get("originalName").get(i));
			fileBean.setSaveNm(newList.get("uploadName").get(i));
			fileBean.setSaveFilePath(newList.get("uploadPath").get(i));
			fileBean.setFileSize(newList.get("size").get(i));
			fileBean.setRegUserSeq(userSeq);

			String extension = newList.get("extension").get(i).toLowerCase();
			fileBean.setFileExtension(extension);

			if(StringUtil.isEmpty(fileGrpSeq)) {
				//FileBean fileBean1 = new FileBean();
				fileGrpSeq = commonDao.selectUUID();
			}
			fileBean.setFileGrpSeq(fileGrpSeq);
			commonDao.insertAttachFiles(fileBean);
		}

		return fileGrpSeq;
	}


	@Override
	public List<IsicBean> selectIsicCdList(IsicBean param) {
		return commonDao.selectIsicCdList(param);
	}


	public int insertLoginSuccessLog(SysConnLogBean sysConnLogBean){

		int result = 0;
		result = commonDao.insertLoginSuccessLog(sysConnLogBean);

		return result;
	}

	public int insertPageConnLog(SysConnLogBean sysConnLogBean){

		int result = 0;
		result = commonDao.insertPageConnLog(sysConnLogBean);

		return result;
	}


	public SysConnLogBean selectProgramSeqSameUrl(SysConnLogBean sysConnLogBean){
		sysConnLogBean = commonDao.selectProgramSeqSameUrl(sysConnLogBean);

		return sysConnLogBean;
	}


	public int updateSysConnLog(SysConnLogBean sysConnLogBean) {
		return commonDao.updateSysConnLog(sysConnLogBean);
	}

	@Override
	public String inserCommonFile(MultipartFile uploadFile, String fileGrpSeq, String regUserSeq, String deleteFileSeq) throws Exception {
		String result = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String uploadPath = BaseConfig.getValue("fileUploadDir") + BaseConfig.getValue("SEPARATOR") + sdf.format(new Date());//저장경로

        try {
        	// 기존에 등록되어 있는 파일 삭제
          	if(!StringUtil.isEmpty(deleteFileSeq)) {
          		FileBean fileBean = new FileBean();
          		fileBean.setFileSeq(deleteFileSeq);
          		fileBean = commonDao.selectAttachFiles(fileBean);

          		File deleteFile = new File(fileBean.getSaveFilePath());
              	if(deleteFile.exists()) {
              		deleteFile.delete();
              		commonDao.deleteAttachFiles(fileBean);
              	}
          	}

          	if(uploadFile != null) {
          		// 폴더 생성
                File fDir = new File(uploadPath);

                if (!fDir.exists()) {
        			fDir.mkdirs();
        		}

                FileBean file = new FileBean();
    			file.setOriginalNm(uploadFile.getOriginalFilename());
    			String saveNm = (KeyGenerateUtil.getUUID()).replaceAll("-", "") + "." + FileUtil.getFileType(uploadFile.getOriginalFilename());
    			file.setSaveNm(saveNm);
    			file.setSaveFilePath(uploadPath + BaseConfig.getValue("SEPARATOR") + saveNm);
    			file.setFileSize(String.valueOf(uploadFile.getSize()));
    			file.setFileExtension(FileUtil.getFileType(uploadFile.getOriginalFilename()));
    			file.setContentType(uploadFile.getContentType());
    			file.setFileGrpSeq(fileGrpSeq);
    			file.setRegUserSeq(regUserSeq);

    			File destFile = new File(uploadPath, saveNm);
    			uploadFile.transferTo(destFile);

    			commonDao.insertAttachFiles(file);
    			result = file.getFileSeq();
          	}

        } catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}


	@Override
	public FileBean selectAttachFiles(FileBean param) throws Exception {
		return commonDao.selectAttachFiles(param);
	}
}
