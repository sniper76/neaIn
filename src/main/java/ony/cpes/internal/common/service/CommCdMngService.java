package ony.cpes.internal.common.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.common.bean.CommCdMngBean;


public interface CommCdMngService {
    

	/**
	 * selectJobReschMngList
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public CommCdMngBean selectGrpCdMngList(CommCdMngBean param) throws Exception;
	
	/**
	 * selectChkGrpCd
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> selectChkGrpCd(HttpServletRequest request,CommCdMngBean param) throws Exception;
	
	/**
	 * insertGrpCd
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> insertGrpCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception;
	
	/**
	 * selectGrpCdDtl
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public CommCdMngBean selectGrpCdMngDtl(CommCdMngBean param) throws Exception;
	
	/**
	 * updateGrpCd
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> updateGrpCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception;
	
	/**
	 * deleteGrpCd
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> deleteGrpCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception;
	
	
	/**
	 * selectDtlMngGrpCdListAjax
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public CommCdMngBean selectDtlMngGrpCdList(CommCdMngBean param) throws Exception;
	
	
	public CommCdMngBean selectDtlMngDtlCdList(CommCdMngBean param) throws Exception;
	
	public Map<String,Object> saveDtlCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception;
	
	public Map<String,Object> deleteDtlCdMng(HttpServletRequest request,CommCdMngBean param) throws Exception;
	
}