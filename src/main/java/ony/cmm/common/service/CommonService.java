package ony.cmm.common.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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

public interface CommonService {
	/**
     * 공통코드 목록 조회
     *
     * @param param CommDtlCdBean
     * @return CommDtlCdBean
     */
    public CommDtlCdBean selectCommCodeList(CommDtlCdBean param)  throws Exception;

    /**
     * 공통코드 목록 조회
     *
     * @param param CommDtlCdBean
     * @return CommDtlCdBean
     */
    public JobCenterBean selectJcCodeList(JobCenterBean param)  throws Exception;

    /**
     * 사용자 정보 조회
     * @param param
     * @return
     * @throws Exception
     */
    public UserBean selectCommonUserDtlInfo() throws Exception;

    /**
     * 주소조회
     * @param param
     * @return
     * @throws Exception
     */
    public LocationBean selectLoction(LocationBean param) throws Exception ;

    /**
     * inquiry isco
     * @param param
     * @return
     * @throws Exception
     */
    public IscoBean selectIscoCd(IscoBean param) throws Exception;

	/**
	 * 직종 코드 검색
	 * @param param
	 * @return
	 */
    public List<CommonBean> selectIscoCdList(CommonBean param) throws Exception;

    /**
     *
     * @param param
     * @return
     * @throws Exception
     */
    public SmsBean insertSmsLog(SmsBean param) throws Exception;

    public List<JobCenterBean> selectJobCenterListForSelectBox();

    public int insertAttachFiles(FileBean param);

    public List<FileBean> selectAttachFilesList(FileBean param);

    public String dext5UploadInsert(String param, String userSeq, String fileGrpSeq) throws Exception;

    public List<IsicBean> selectIsicCdList(IsicBean param);

    public int insertLoginSuccessLog(SysConnLogBean sysConnLogBean);

    public int insertPageConnLog(SysConnLogBean sysConnLogBean);


    public SysConnLogBean selectProgramSeqSameUrl(SysConnLogBean sysConnLogBean);


    public int updateSysConnLog(SysConnLogBean sysConnLogBean);

    public String inserCommonFile(MultipartFile uploadFile, String fileGrpSeq, String regUserSeq, String deleteFileSeq) throws Exception;

    public FileBean selectAttachFiles(FileBean param) throws Exception;
}
