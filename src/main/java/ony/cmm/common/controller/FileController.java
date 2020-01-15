package ony.cmm.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ony.cmm.common.bean.FileBean;
import ony.cmm.common.service.CommonService;
import ony.cmm.common.service.FileUploadService;
import ony.cpes.internal.bulletin.bean.BulletinMNGBean;
import ony.cpes.internal.bulletin.service.BulletinMNGService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseConfig;
import ony.framework.BaseConstant;
import ony.framework.BaseController;
import ony.framework.util.FtpMngUtil;
import ony.framework.util.ParamCheckService;
import ony.framework.util.UploadBrowserCheck;
import ony.framework.util.download.DownloadHelper;
import ony.framework.util.upload.UploadHelper;


@Controller
@RequestMapping("/fileCommon")
public class FileController extends BaseController{

  private static Log log = LogFactory.getLog(FileController.class);

  @Autowired
  FileUploadService FileUploadService;

  @Autowired
  FtpMngUtil ftpUtil;

  @Autowired
  ParamCheckService paramCheckService;
  
  @Autowired
  private BulletinMNGService bulletinMNGService;
  
  @Autowired
  private CommonService commonService;
  
  /**
   * 파일 업로드
   */
  @RequestMapping("/uploadHelper.do")
  public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

    UploadHelper uploader = new UploadHelper(
          multipartRequest
        , BaseConfig.getValue("fileUploadDir")+BaseConfig.getValue("fileUploadUrl")
        , request.getParameter("bizName")
        , "");

		try {
			
	        JSONArray files = uploader.getFilesToJSONArray(multipartRequest);
	        JSONObject file = (JSONObject)files.get(0);
	        
	        int maxFileSize = 20 * 1024 * 1024;
	        int filSize = Integer.parseInt((String) file.get("fileSize"));	        
	        String originalNm = (String) file.get("originalNm");
			String programId = request.getParameter("programId");

			if (StringUtils.isNotBlank(programId)) {
				BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
				bulletinMNGBean.setProgramId(programId);
				BulletinMNGBean bulletinMng = bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean);
				maxFileSize = (StringUtils.isNotBlank(bulletinMng.getFileSize())) ? Integer.parseInt(bulletinMng.getFileSize()) * 1024 * 1024 : 0 ;
			}

			if (maxFileSize < filSize) {
				try {
					throw new Exception("FILE_SIZE_OVER");
				} catch (Exception e) {
					this.outputJSON(request, response, "601", originalNm + " FILE SIZE(" + Integer.toString((filSize / 1024 / 1024)) + "MB) > SIZE(" + Integer.toString((maxFileSize / 1024 / 1024)) + "MB)", e);
				}
			} else {
				uploader.upload();

				String userAgent = request.getHeader("User-Agent");
				int nMajorVer = UploadBrowserCheck.getBrowserMajorVersion(userAgent, "MSIE");
				if (nMajorVer > 0 && nMajorVer <= 9) {
					response.setHeader("IESupportJsonHack", "IESupportJsonHack");
				}
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

				this.outputJSONRaw(response, uploader.getResponseJSON());
			}

		} catch (Exception e) {
			e.printStackTrace();
			this.outputJSON(request, response, BaseConstant.SYSTEM_ERROR_CD, BaseConstant.SYSTEM_ERROR_NM, e);
		}
	}

  /**
   *  파일입력
   */
  @RequestMapping("/setFileSave.do")
  public void setFileSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
   FileBean FileBean = (FileBean)getObjectFromJSON(request,FileBean.class);
   String fileUrl = BaseConfig.getValue("fileUploadUrl") + BaseConfig.getValue("SEPARATOR")+FileBean.getBizName();
   this.outputJSON(request, response,  FileUploadService.setFileSave(FileBean, fileUrl));
  }

  /**
   * 파일 리스트
   */
  @RequestMapping("/getFileList.do")
  public void getFileList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    FileBean FileBean = (FileBean)getObjectFromJSON(request,FileBean.class);
    FileBean.setAttachGroupId(FileBean.getAttachGroupId());
    this.outputJSON(request, response, FileUploadService.getFileList(FileBean));
  }
  /**
   * temp 파일 삭제
   */
  @RequestMapping("/setTempFileDelete.do")
  public void setTempFileDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    FileBean FileBean = (FileBean)getObjectFromJSON(request,FileBean.class);
    String saveDirectory = BaseConfig.getValue("fileUploadDir")+BaseConfig.getValue("fileUploadUrl")+BaseConfig.getValue("SEPARATOR")+FileBean.getBizName();
    String saveNm = FileBean.getSaveNm();
    this.outputJSON(request, response,  FileUploadService.delTempFileSingle(saveDirectory, saveNm));
  }

  @RequestMapping("/getDownload.do")
  public void fileDown(HttpServletRequest request, HttpServletResponse response) throws Exception {

    FileBean FileBean = (FileBean)getObjectFromJSON(request,FileBean.class);
    FileBean = FileUploadService.getAttachFileInfo(FileBean.getAttachId());
    DownloadHelper.download(
              request,
              response,
              BaseConfig.getValue("fileUploadDir")+FileBean.getSaveFilePath(),
              FileBean.getSaveNm(),
              FileBean.getOriginalNm()
        );
  }

  /**
   * 파일 내용 리스트
   */
  @RequestMapping("/selectAttachFileListAjax.do")
  public ModelAndView selectAttachFileList(FileBean fileBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mv = new ModelAndView();

	mv.addObject("FileBean", FileUploadService.selectAttachFileList(fileBean));
	mv.setViewName("jsonView");
	
  	return mv;
  }
  
  /**
   * 파일 내용 저장
   */
  @RequestMapping("/insertAttachFileAjax.do")
  public ModelAndView insertAttachFile(FileBean fileBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mv = new ModelAndView();
	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
	fileBean.setUser(sessUser);
	
    mv.addObject("deleteCnt", FileUploadService.insertAttachFile(fileBean));
	mv.setViewName("jsonView");
	
  	return mv;
  }
  
  /**
   * 파일 삭제 및 데이터 제거
   */
  @RequestMapping("/deleteAttachFileAjax.do")
  public ModelAndView deleteAttachFile(@ModelAttribute("FileBean") FileBean fileBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
	  ModelAndView mv = new ModelAndView();
	String saveDirectory = BaseConfig.getValue("fileUploadDir")+BaseConfig.getValue("fileUploadUrl")+BaseConfig.getValue("SEPARATOR")+fileBean.getBizName();
    String saveNm = fileBean.getSaveNm();
    int result = FileUploadService.deleteAttachFile(saveDirectory, saveNm);
    mv.addObject("deleteCnt", result);
	mv.setViewName("jsonView");
	
  	return mv;
  }

  /**
   * 파일 그룹 전체 파일 삭제 및 데이터 제거
   */
  @RequestMapping("/deleteAllAttachFileAjax.do")
  public ModelAndView deleteAllAttachFileAjax(@ModelAttribute("FileBean") FileBean fileBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
	  ModelAndView mv = new ModelAndView();
	String baseDirectory = BaseConfig.getValue("fileUploadDir")+BaseConfig.getValue("fileUploadUrl")+BaseConfig.getValue("SEPARATOR");

	int result = FileUploadService.deleteAllAttachFile(baseDirectory, fileBean);
    mv.addObject("deleteCnt", result);
	mv.setViewName("jsonView");
	
  	return mv;
  }
  
  /**
   * 파일 다운로드
   */  
  @RequestMapping("/fileDownload.do")
  public void fileDownLoad(@ModelAttribute("FileBean") FileBean fileBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    fileBean = FileUploadService.selectAttachFileDtl(fileBean);
    DownloadHelper.download(
              request,
              response,
              BaseConfig.getValue("fileUploadDir")+fileBean.getSaveFilePath()+BaseConfig.getValue("SEPARATOR"),
              fileBean.getSaveNm(),
              fileBean.getOriginalNm()
        );
  }
}
