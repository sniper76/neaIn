package ony.cpes.internal.common.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.common.bean.CommCdMngBean;
import ony.cpes.internal.common.bean.IscedCdMngBean;
import ony.cpes.internal.common.bean.IscoCdMngBean;


public interface IscedCdMngService {
    

	/**
	 * selectIscoCdMngList
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public IscedCdMngBean selectIscedCdMngList(IscedCdMngBean param) throws Exception;
	
	public IscedCdMngBean selectIscedOneList(IscedCdMngBean param) throws Exception;
	
	public IscedCdMngBean selectIscedTwoList(IscedCdMngBean param) throws Exception;
	
	public IscedCdMngBean selectIscedThreeList(IscedCdMngBean param) throws Exception;
	
	public Map<String,Object> insertIscedCdMng(HttpServletRequest request,IscedCdMngBean param) throws Exception;
	
	public IscedCdMngBean selectIscedCdMngDetail(IscedCdMngBean param) throws Exception;
	
	public Map<String,Object> updateIscedCdMng(HttpServletRequest request,IscedCdMngBean param) throws Exception;
	
}