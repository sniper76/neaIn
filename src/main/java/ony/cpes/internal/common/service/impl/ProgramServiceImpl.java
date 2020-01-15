package ony.cpes.internal.common.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.ProgramBean;
import ony.cpes.internal.common.dao.ProgramDAO;
import ony.cpes.internal.common.service.ProgramService;
import ony.framework.bean.PagingBean;


@Service("ProgramService")
public class ProgramServiceImpl implements ProgramService{
    
	@Autowired
	private ProgramDAO programDao;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;
	
	
	/**
	 * inquiry of Program list
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public ProgramBean selectProgramMngList(ProgramBean param) throws Exception {
    	
    	int totalCount = (int) programDao.selectProgramMngListTotalCount(param);
		param.setTotalCount(totalCount);
		
		// PAGE 번호 구하기
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
		param.setPageNo(pageNo);
		
		List<ProgramBean> list = programDao.selectProgramMngList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		return param;
	}
	
	
	/**insert Program
	 * @param ProgramBean
	 * @return int
	 */
	public ProgramBean insertProgramMng(HttpServletRequest request, ProgramBean param) throws Exception {
		try {
			
			ProgramBean paramObj = programDao.selectProgramMngDetail(param);
			
			if (paramObj != null) {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("error.dupl.data.msg",null, "Error", localeResolver.resolveLocale(request)));
			} else {
				String programId = programDao.selectProgramId();
				
				if (programId != null) {
					param.setProgramId(programId);
				}
				
				int result = programDao.insertProgramMng(param);
		
				if (result > 0) {
					param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
					param.setMsg(messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
				} else {
					param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
					param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
				}
			}
			
			
		} catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return param;
    }
	
	/**
	 * @param paramObj
	 * @return ProgramBean
	 * @throws Exception
	 */
	public ProgramBean updateProgramMng(HttpServletRequest request, ProgramBean param) throws Exception {
		try {
			int result = programDao.updateProgramMng(param);
			
			if (result > 0) {
				param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
			} else {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
			}
		} catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return param;
    }
	
	/**
	 * @param paramObj
	 * @return ProgramBean
	 * @throws Exception
	 */
	public ProgramBean deleteProgramMng(HttpServletRequest request, ProgramBean param) throws Exception {
		try {
			int result = programDao.deleteProgramMng(param);
			
			if (result > 0) {
				param.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.delete.success.msg",null, "Success", localeResolver.resolveLocale(request)));
			} else {
				param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
			}
		} catch (Exception e) {
			param.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
			param.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
		}
		
		return param;
    }
	
	/**
	 * 
	 * @param paramObj
	 * @return ProgramBean
	 * @throws Exception
	 */
	public ProgramBean selectProgramMngDetail(ProgramBean paramObj) throws Exception {
		paramObj = programDao.selectProgramMngDetail(paramObj);
		
		return paramObj;
	}
}
