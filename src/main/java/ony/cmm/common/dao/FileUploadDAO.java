package ony.cmm.common.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.FileBean;

@Repository("FileUploadDAO")
public class FileUploadDAO extends EgovAbstractMapper {

	protected Log log = LogFactory.getLog(this.getClass());

	public int getAttachGroupId() {
		return getSqlSession().selectOne("fileUpload.getAttachGroupId");
	}

	public int setFileInFst(FileBean bean) {
		return getSqlSession().insert("fileUpload.setFileInFst", bean);
	}

	public int setFileInOth(FileBean bean) {
		return getSqlSession().insert("fileUpload.setFileInOth", bean);
	}

	public List<FileBean> getFileGroupInfo(FileBean bean) {
		return getSqlSession().selectList("fileUpload.getFileGroupInfo", bean);
	}

	public int setAttachFileDel(int attachId) {
		return getSqlSession().update("fileUpload.setAttachFileDel", attachId);
	}

	public int setAttachFileAllDel(int attachGroupId) {
		return getSqlSession().update("fileUpload.setAttachFileAllDel", attachGroupId);
	}

	public FileBean getAttachFileInfo(int attachId) {
		return getSqlSession().selectOne("fileUpload.getAttachFileInfo", attachId);
	}

	public List<FileBean> selectAttachFileList(FileBean param) {
		return getSqlSession().selectList("fileUpload.selectAttachFileList", param);
	}

	public FileBean selectAttachFileDtl(FileBean param) {
		return getSqlSession().selectOne("fileUpload.selectAttachFileDtl", param);
	}

	public int insertAttachFile(FileBean param) {
		return getSqlSession().insert("fileUpload.insertAttachFile", param);
	}

	public void deleteAttachFile(FileBean param) {
		getSqlSession().update("fileUpload.deleteAttachFile", param);
	}

}
