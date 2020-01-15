package ony.cmm.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.bean.CommonBean;
import ony.cmm.common.bean.FileBean;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.bean.IsicBean;
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.bean.SmsBean;
import ony.cmm.common.bean.SysConnLogBean;
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.user.bean.UserBean;


@Repository("CommonDAO")
public class CommonDAO extends EgovAbstractMapper{

	/**
	 * 공통코드 목록 조회
	 * @param userName
	 * @return
	 */
	public List<CommDtlCdBean> selectCommCodeList(CommDtlCdBean param) {
        return getSqlSession().selectList("commCode.selectCommCodeList", param);
    }

	/**
	 * 공통코드 목록 조회
	 * @param userName
	 * @return
	 */
	public int selectCommCodeListTotalCount(CommDtlCdBean param) {
        return getSqlSession().selectOne("commCode.selectCommCodeListTotalCount", param);
    }


	/**
	 * 사용자 정보 조회 공통
	 * @param userName
	 * @return
	 */
	public UserBean selectCommonUserDtlInfo(UserBean param) {
        return (UserBean) getSqlSession().selectOne("commCode.selectCommonUserDtlInfo", param);
    }

	/**
	 * 주소코드조회
	 * @return
	 * @throws Exception
	 */
	public List<LocationBean> selectLoction(LocationBean param) throws Exception {
		return getSqlSession().selectList("commCode.selectLoction", param);
	}

	/**
	 * ISCO코드조회
	 * @return
	 * @throws Exception
	 */
	public List<IscoBean> selectIscoCd(IscoBean param) throws Exception {
		return getSqlSession().selectList("commCode.selectIscoCd", param);
	}

	/**
	 * 직종 코드 검색
	 * @param param
	 * @return
	 */
	public List<CommonBean> selectIscoCdList(CommonBean param){
		return getSqlSession().selectList("commCode.selectIscoCdList", param);
	}

	/**
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int insertSmsLog(SmsBean param) throws Exception {
		return getSqlSession().insert("setSms.insertSmsLog", param);
	}

	/**
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int updateSmsLog(SmsBean param) throws Exception {
		return getSqlSession().insert("setSms.updateSmsLog", param);
	}

	public List<JobCenterBean> selectJobCenterListForSelectBox(){
		return getSqlSession().selectList("commCode.selectJobCenterListForSelectBox");
	}


	public int insertAttachFiles(FileBean param) {
		return getSqlSession().insert("setFile.insertAttachFiles", param);
	}

	public String selectUUID() {
		return getSqlSession().selectOne("file.selectUUID");
	}

	public List<FileBean> selectAttachFilesList(FileBean param){
		return getSqlSession().selectList("file.selectAttachFilesList", param);
	}

	public int deleteAttachFiles(FileBean param) {
		return getSqlSession().delete("setFile.deleteAttachFiles", param);
	}

	public List<IsicBean> selectIsicCdList(IsicBean param){
		return getSqlSession().selectList("commCode.selectIsicCdList", param);
	}

	public int getBatchConn(){
		return getSqlSession().selectOne("common.getBatchConn", null);
	}
	
	
	public int insertLoginSuccessLog(SysConnLogBean sysConnLogBean){
		return getSqlSession().insert("common.insertLoginSuccessLog", sysConnLogBean);
	}
	
	public int insertPageConnLog(SysConnLogBean sysConnLogBean){
		return getSqlSession().insert("common.insertPageConnLog", sysConnLogBean);
	}
	
	public SysConnLogBean selectProgramSeqSameUrl(SysConnLogBean sysConnLogBean){
		return getSqlSession().selectOne("common.selectProgramSeqSameUrl", sysConnLogBean);
	}

	public int updateSysConnLog(SysConnLogBean sysConnLogBean){
		return getSqlSession().update("common.updateSysConnLog", sysConnLogBean);
	}
	
	public FileBean selectAttachFiles(FileBean param) {
		return getSqlSession().selectOne("file.selectAttachFiles", param);
	}

}
