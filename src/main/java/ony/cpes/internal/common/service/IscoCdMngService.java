package ony.cpes.internal.common.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ony.cmm.common.bean.IscoBean;
import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.common.bean.IscoCdMngBean;


public interface IscoCdMngService {
    

	/**
	 * selectIscoCdMngList
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public IscoCdMngBean selectIscoCdMngList(IscoCdMngBean param) throws Exception;
	
	public IscoBean selectIscoOneList(IscoCdMngBean param) throws Exception;
	
	public IscoBean selectIscoTwoList(IscoBean param) throws Exception;
	
	public IscoBean selectIscoThreeList(IscoBean param) throws Exception;
	
	public Map<String,Object> insertIscoCdMng(HttpServletRequest request,IscoCdMngBean param) throws Exception;
	
	public IscoCdMngBean selectIscoCdMngDetail(IscoCdMngBean param) throws Exception;
	
	public Map<String,Object> updateIscoCdMng(HttpServletRequest request,IscoCdMngBean param) throws Exception;
	
}