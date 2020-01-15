package ony.cpes.internal.common.service;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.common.bean.NeaUserMngBean;



public interface NeaUserMngService {
    

	/**
	 * selectNeaUserList
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public NeaUserMngBean selectNeaUserList(NeaUserMngBean param) throws Exception;
	
	/**
	 * insertNeaUser
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> insertNeaUser(HttpServletRequest request,NeaUserMngBean param) throws Exception;
	
	/**
	 * selectNeaUserMngDtl
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public NeaUserMngBean selectNeaUserMngDtl(Locale locale, NeaUserMngBean param) throws Exception;
	
	
	/**
	 * updateNeaUser
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> updateNeaUser(HttpServletRequest request,NeaUserMngBean param) throws Exception;
	
	/**
	 * deleteNeaUser
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> deleteNeaUser(HttpServletRequest request,NeaUserMngBean param) throws Exception;
	
}