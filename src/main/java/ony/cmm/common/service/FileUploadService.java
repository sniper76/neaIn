package ony.cmm.common.service;

import java.util.List;

import ony.cmm.common.bean.FileBean;

public interface FileUploadService{

    //파일명 변경
	  public String getRandomName(String oFileName) throws Exception ;

	  //DB에 파일저장
	  public FileBean setFileSave(FileBean bean, String saveDir) throws Exception;

	  public FileBean getFileList(FileBean FileBean) throws Exception;

	  public List <FileBean> getZipFileDownload(FileBean FileBean) throws Exception ;

	  //파일삭제
	  public int delTempFileSingle( String saveDirectory, String saveNm );

	  public int delFileSingle( int attachId );

	  public FileBean getAttachFileInfo(int attachId) ;

	  public List<FileBean> selectAttachFileList(FileBean FileBean) ;

	  public FileBean selectAttachFileDtl(FileBean FileBean) ;

	  public int insertAttachFile( FileBean FileBean ) ;

	  public int deleteAttachFile( String saveDirectory, String saveNm ) ;

	  public int deleteAllAttachFile( String baseDirectory, FileBean FileBean ) ;

}
