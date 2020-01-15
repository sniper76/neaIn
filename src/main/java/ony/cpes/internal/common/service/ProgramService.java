package ony.cpes.internal.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.common.bean.ProgramBean;



public interface ProgramService {

	/**
	 * inquiry of program list
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public ProgramBean selectProgramMngList(ProgramBean param) throws Exception;
	
	/**
	 * insert program
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ProgramBean insertProgramMng(HttpServletRequest request, ProgramBean param) throws Exception;
	
	/**
	 * update program
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ProgramBean updateProgramMng(HttpServletRequest request, ProgramBean param) throws Exception;
	
	/**
	 * delete program
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ProgramBean deleteProgramMng(HttpServletRequest request, ProgramBean param) throws Exception;
	
	/**
	 * inquiry programmngDetail
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public ProgramBean selectProgramMngDetail(ProgramBean paramObj) throws Exception;
}