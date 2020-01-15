package ony.cmm.common.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import ony.cmm.common.bean.FileBean;
import ony.cmm.common.dao.FileUploadDAO;
import ony.cmm.common.service.FileUploadService;
import ony.framework.util.FtpMngUtil;

@Service("FileUploadServiceImpl")
public class FileUploadServiceImpl extends EgovAbstractServiceImpl implements FileUploadService {

	private static Log log = LogFactory.getLog(FileUploadServiceImpl.class);

	@Autowired
	private FtpMngUtil ftpUtil;

	/** DAO */
	@Resource(name = "FileUploadDAO")
	private FileUploadDAO FileUploadDAO;

	/**
	 * fileUploadCkEditor 2015. 6. 19.
	 *
	 * @param multipartRequest
	 * @param saveDirectory
	 * @return
	 * @throws Exception
	 * @Description 멀티파일 업로드
	 */

	public String getRandomName(String oFileName) throws Exception {
		String newFileName = "";
		String extention = "";

		for (int i = 1; i <= 8; i++) {
			if (i % 2 == 0) {
				char ch = (char) ((Math.random() * 26) + 97);
				newFileName += ch + "";
			} else {
				int n = (int) (Math.random() * 10) + 1;
				newFileName += n + "";
			}
		}
		extention = oFileName.toLowerCase().substring(oFileName.indexOf("."), oFileName.length());
		return newFileName + extention;
	}

	// DB에 파일저장
	public FileBean setFileSave(FileBean bean, String saveDir) throws Exception {

		String[] fileList = bean.getFiles();
		String[] fileNames = bean.getFileNames();
		String[] filesExtension = bean.getFilesExtension();
		String[] fileSize = bean.getFileSizes();
		String[] fileChks = bean.getFileChks();
		String[] attachIds = bean.getAttachIds();
		String[] newAttachIds = new String[fileList.length];

		int attachGroupId = bean.getAttachGroupId();

		if (fileList.length > 0) {
			for (int i = 0; i < fileList.length; i++) {
				// 파일기본셋팅
				bean.setSaveFilePath(saveDir + "/");
				bean.setSaveNm(fileList[i]);
				bean.setFileExtension(filesExtension[i]);
				bean.setOriginalNm(fileNames[i]);
				bean.setFileSize(fileSize[i]);

				newAttachIds[i] = attachIds[i];

				// 증명사진 업로드관련
				if (bean.getImgView().equals("Y") && bean.getAttachGroupId() > 0) {
					delFileAll(bean.getAttachGroupId());
				}

				if (fileChks[i].equals("2")) {
					delFileSingle(Integer.parseInt(attachIds[i]));
				} else {
					if (bean.getAttachGroupId() == 0) {
						// 파일 그룹아이디가 없을경우 즉, 신규입력상태
						attachGroupId = FileUploadDAO.getAttachGroupId();
						bean.setAttachGroupId(attachGroupId);
						FileUploadDAO.setFileInFst(bean);
					} else {
						// 파일 그룹아이디가 있을경우 즉, 수정상태일경우
						if (Integer.parseInt(attachIds[i]) == 0) {
							// 파일아이디가 없는경우
							bean.setAttachGroupId(bean.getAttachGroupId());
							FileUploadDAO.setFileInFst(bean);
						}
					}

					newAttachIds[i] = String.valueOf(bean.getAttachId());
				}
			}

			bean.setAttachIds(newAttachIds);
		}
		return bean;
	}

	public FileBean getFileList(FileBean FileBean) throws Exception {
		List<FileBean> list = FileUploadDAO.getFileGroupInfo(FileBean);
		FileBean.setList(list);
		return FileBean;
	}

	public List<FileBean> getZipFileDownload(FileBean FileBean) throws Exception {
		return FileUploadDAO.getFileGroupInfo(FileBean);
	}

	public int delTempFileSingle(String saveDirectory, String saveNm) {
		int result = 0;

		File file = new File(saveDirectory + "/" + saveNm); // jdk 1.6 version
		boolean isDel = false;

		if (file.exists()) {
			isDel = file.delete();

			if (isDel)
				result = 1; // 삭제완료
			else
				result = 0; // 삭제실패
		} else {
			result = -1; // 파일없음
		}
		return result;
	}

	public int delFileSingle(int attachId) {
		int result = 0;
		FileUploadDAO.setAttachFileDel(attachId);
		return result;
	}

	public int delFileAll(int attachGroupId) {
		int result = 0;
		FileUploadDAO.setAttachFileAllDel(attachGroupId);
		return result;
	}

	public FileBean getAttachFileInfo(int attachId) {
		return FileUploadDAO.getAttachFileInfo(attachId);
	}
	
	public List<FileBean> selectAttachFileList(FileBean FileBean) {
		return FileUploadDAO.selectAttachFileList(FileBean);
	}
	
	public FileBean selectAttachFileDtl(FileBean FileBean) {
		return FileUploadDAO.selectAttachFileDtl(FileBean);
	}
	
	public int insertAttachFile(FileBean fileBean) {
		int result = 0;
		for (int i = 0; i < fileBean.getFileSeqList().size(); i++) {
			FileBean vo = new FileBean();
			vo.setFileSeq((String)fileBean.getFileSeqList().get(i));
			vo.setFileGrpSeq((String)fileBean.getFileGrpSeqList().get(i));
			vo.setOriginalNm((String)fileBean.getOriginalNmList().get(i));
			vo.setSaveNm((String)fileBean.getSaveNmList().get(i));
			vo.setSaveFilePath((String)fileBean.getSaveFilePathList().get(i));
			vo.setFileExtension((String)fileBean.getFileExtensionList().get(i));
			vo.setFileSize((String)fileBean.getFileSizeList().get(i));
			vo.setUser(fileBean.getUser());
			result += FileUploadDAO.insertAttachFile(vo);
		}
		
		return result;
	}	
	
	public int deleteAttachFile(String saveDirectory, String saveNm) {
		int result = 0;

		FileBean param = new FileBean();
		int pos = saveNm.lastIndexOf(".");
		String fileSeq = saveNm.substring(0, pos);
		param.setFileSeq(fileSeq);
		param.setSaveFilePath(saveDirectory);
		
		FileUploadDAO.deleteAttachFile(param);
		
		File file = new File(saveDirectory + "/" + saveNm); // jdk 1.6 version
		boolean isDel = false;

		if (file.exists()) {
			isDel = file.delete();

			if (isDel)
				result = 1; // 삭제완료
			else
				result = 0; // 삭제실패
		} else {
			result = -1; // 파일없음
		}
		
		return result;
	}
	
	public int deleteAllAttachFile(String baseDirectory, FileBean fileBean) {
		int result = 0;
		
		List<FileBean> fileList = FileUploadDAO.selectAttachFileList(fileBean);
		
		for (FileBean vo : fileList) {
			
			File file = new File(baseDirectory + vo.getSaveFilePath() + "/" + vo.getSaveNm());
			boolean isDel = false;
			
			if (file.exists()) {
				isDel = file.delete();
				if (isDel) {
					result += 1; // 삭제완료
				}
			}
		}

		FileUploadDAO.deleteAttachFile(fileBean);

		return result;
	}	
}
