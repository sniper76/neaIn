package ony.cpes.internal.common.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cpes.internal.common.bean.ProgramBean;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.common.service.ProgramService;
import ony.framework.BaseController;



@RequestMapping("/internal/common")
@Controller
public class ProgramController extends BaseController{

  private static Log log = LogFactory.getLog(ProgramController.class);
  
	 @Autowired
	 private ProgramService programService;
  
	 @RequestMapping("/selectProgramMngListAjax")
	 public ModelAndView selectProgramMngListAjax(@ModelAttribute("programBean") ProgramBean programBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 	ModelAndView mv = new ModelAndView();
		 	
		 	programBean.setLang(locale.getLanguage());
		 	
			// sorting
			String orderColumnIndex = request.getParameter("order[0][column]");
			if (orderColumnIndex != null) 
				programBean.setOrderStr(Integer.parseInt(orderColumnIndex));
			
			String orderDir = request.getParameter("order[0][dir]");
			if (orderDir != null)
				programBean.setOrderColumnSort(orderDir);
			
			String orderColumns = request.getParameter("orderColumns");
			String orderColumn = "";
			if(orderColumns != null) {
				String[] temp = orderColumns.split(",");
				orderColumn = temp[Integer.parseInt(orderColumnIndex)];
				programBean.setOrderColumn(orderColumn);
			}
			
			
			if(orderColumns != null) {
	  			String[] temp = orderColumns.split(",");
	  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
	  			programBean.setOrderColumn(orderColumn);
	  			ProgramBean result = (ProgramBean) programService.selectProgramMngList(programBean);
				
	  	  	    mv.addObject("aaData", result.getList());
	  			mv.addObject("draw", programBean.getDraw());
	  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
	  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
	  		}
				
			mv.setViewName("jsonView");
		  	return mv;
		}
	  
	  
	 @RequestMapping("/programMngInternalList")
	 public String programMngListInternalList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 request.setAttribute("rangeCd", "RNG0000000002");
		 return "common/programMngList.all";
	 }
	 
	 @RequestMapping("/programMngExternalList")
	 public String programMngListExternalList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 request.setAttribute("rangeCd", "RNG0000000003");
		 return "common/programMngList.all";
	 }
	 
	 /**
	  * menu list
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/programMngInternalReg")
	 public String programMngInternalReg(@ModelAttribute("programBean") ProgramBean programBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 if (programBean != null && programBean.getProgramSeq() != null && !"".equals(programBean.getProgramSeq())) {
			 programBean = programService.selectProgramMngDetail(programBean);
		 }
		 
		 programBean.setRangeCd("RNG0000000002");
		 
		 request.setAttribute("program", programBean);
		 return "common/programMngReg.all";
	 }
	 
	 /**
	  * menu list
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/programMngExternalReg")
	 public String programMngExternalReg(@ModelAttribute("programBean") ProgramBean programBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 if (programBean != null && programBean.getProgramSeq() != null && !"".equals(programBean.getProgramSeq())) {
			 programBean = programService.selectProgramMngDetail(programBean);
		 }
		 
		 programBean.setRangeCd("RNG0000000003");
		 
		 request.setAttribute("program", programBean);
		 return "common/programMngReg.all";
	 }
	 
	/**
	 * insert program
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("/insertProgramMng")
	 public void insertProgramMng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 ProgramBean program = new ProgramBean();	
		 ProgramBean param = (ProgramBean) getObjectFromJSON(request, ProgramBean.class);
		 
		 HttpSession session = request.getSession();
		 UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");
		 
		 if (userMenu != null) {
			 param.setRegUserSeq(userMenu.getUser().getUserSeq());
			 param.setModUserSeq(userMenu.getUser().getUserSeq());
		 } else {
			 param.setRegUserSeq("SYSTEM");
			 param.setModUserSeq("SYSTEM");
		 }
		 
		 if (param != null && param.getProgramSeq() != null && !"".equals(param.getProgramSeq())) {
			 program = (ProgramBean) programService.updateProgramMng(request, param);
		 } else {
			 program = (ProgramBean) programService.insertProgramMng(request, param);
		 }
		 
		
    	 this.outputJSON(request, response, program);
	 }
	
	/**
	 * update program
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("/updateProgramMng")
	 public void updateProgramMng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 ProgramBean param = (ProgramBean) getObjectFromJSON(request, ProgramBean.class);
		 ProgramBean program = (ProgramBean) programService.updateProgramMng(request, param);
		
    	 this.outputJSON(request, response, program);
	 }
	 
	 /**
	 * update program
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("/deleteProgramMng")
	 public void deleteProgramMng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 ProgramBean param = (ProgramBean) getObjectFromJSON(request, ProgramBean.class);
		 ProgramBean program = (ProgramBean) programService.deleteProgramMng(request, param);
		
    	 this.outputJSON(request, response, program);
	 }
	 
}
