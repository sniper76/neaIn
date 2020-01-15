package ony.cpes.internal.trnng.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cpes.internal.trnng.service.JobskPrepareMngService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/trnng")
public class JobskPrepareMngController extends BaseController {

	private static Log log = LogFactory.getLog(JobskPrepareMngController.class);

	@Autowired
	private CommonService commonService;	
	
	@Autowired
	private JobskPrepareMngService jobskPrepareMngService;
    
    @RequestMapping(value= {"/jobskPrepareEduMng", "/softSkillEduMng"})
	public ModelAndView eduTrnngPreprareSkillMng(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();
    	
    	String[] servletPath = ((String) request.getServletPath()).split("/"); 
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	String neaEduDivCd = ( "jobskPrepareEduMng".contains(lastPath) ) ? "NED0000000001" : "NED0000000002" ;
    	eduTrnngMngBean.setEduDivCd("EDC0000000001"); 	//NEA교육
    	eduTrnngMngBean.setNeaEduDivCd(neaEduDivCd);	//구직준비(NED0000000001) | 소프트스킬(NED0000000002)
    	
    	CommDtlCdBean locCdBean = (CommDtlCdBean) jobskPrepareMngService.selectLOC2DepthList();

    	mv.addObject("LocCdBean", locCdBean.getList());
    	mv.addObject("EduTrnngMngBean", eduTrnngMngBean);
  		
    	mv.setViewName("trnng/" + lastPath + ".all");
	  	return mv;
	}
    
    @RequestMapping(value= {"/jobskPrepareEduMngDtl", "/jobskPrepareEduMngReg", "/softSkillEduMngDtl", "/softSkillEduMngReg"})
	public ModelAndView eduTrnngPreprareSkillMngDtl(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();
    	
    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		eduTrnngMngBean.setUser(userMenu.getUser());
    		eduTrnngMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		eduTrnngMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	eduTrnngMngBean.setRegUserSeq("SYSTEM");
        	eduTrnngMngBean.setModUserSeq("SYSTEM");
        }  		
    	eduTrnngMngBean.setLang(locale.getLanguage().toLowerCase());
    	
    	EduTrnngMngBean eduTrnngMng = (EduTrnngMngBean) jobskPrepareMngService.selectEduTrnngDetail(eduTrnngMngBean);
    	
    	
		CommDtlCdBean commDtlCdBean = new CommDtlCdBean();
		List<String> commGrpCdList = new ArrayList<String>();
	  	
	  	commGrpCdList.add("TRNNG_NATNEXP_DIV_CD");
	  	commGrpCdList.add("EDU_DIV_CD");
	  	commGrpCdList.add("INSTT_STS_CD");
	  	commGrpCdList.add("JC_AGREE_STS_CD");
	  	commGrpCdList.add("INSTT_OWNERSHIP_CD");
	  	commGrpCdList.add("RECRUMT_STS_CD");
	  	commGrpCdList.add("INSTT_TYPE_CD");
	  	commGrpCdList.add("JC_CD");
	  	commGrpCdList.add("PC_TYPE_CD");
	  	commGrpCdList.add("TVC_DIV_CD");
	  	commGrpCdList.add("HGEP_DIV_CD");
	  	commGrpCdList.add("NEA_EDU_DIV_CD");
	  	
	  	commDtlCdBean.setCommGrpCdList(commGrpCdList);
  		
	  	CommDtlCdBean commCode = (CommDtlCdBean) commonService.selectCommCodeList(commDtlCdBean);
	  	
	  	if ("jobskPrepareEduMngDtl".equals(lastPath) || "softSkillEduMngDtl".equals(lastPath)) {
	  		mv.addObject("EduTrnngMngBean", eduTrnngMng);
	  	} else {
	  		mv.addObject("EduTrnngMngBean", eduTrnngMngBean);	  		
	  	}
  		mv.addObject("CommonCodeDtlBean", commCode.getList());  		
    	
    	mv.setViewName("trnng/" + lastPath + ".all");
	  	return mv;
	}

    @RequestMapping(value={"/selectJobskPrepareEduMngListAjax", "/selectSoftSkillEduMngListAjax"})
	public ModelAndView selectEduTrnngPreprareSkillList(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		eduTrnngMngBean.setUser(userMenu.getUser());
    		eduTrnngMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		eduTrnngMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	eduTrnngMngBean.setRegUserSeq("SYSTEM");
        	eduTrnngMngBean.setModUserSeq("SYSTEM");
        }  		
    	eduTrnngMngBean.setLang(locale.getLanguage().toLowerCase());
    	
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			eduTrnngMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			eduTrnngMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			eduTrnngMngBean.setOrderColumn(orderColumn);
  			EduTrnngMngBean result = (EduTrnngMngBean) jobskPrepareMngService.selectEduTrnngList(eduTrnngMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", eduTrnngMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
  		return mv;
	}
    
    @RequestMapping(value={"/updateJobskPrepareEduMngArrayAjax", "/updateSoftSkillEduMngArrayAjax"})
	public ModelAndView updateEduTrnngProgramMngArray(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		eduTrnngMngBean.setUser(userMenu.getUser());
    		eduTrnngMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		eduTrnngMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	eduTrnngMngBean.setRegUserSeq("SYSTEM");
        	eduTrnngMngBean.setModUserSeq("SYSTEM");
        }  		
    	eduTrnngMngBean.setLang(locale.getLanguage().toLowerCase());

    	EduTrnngMngBean result = (EduTrnngMngBean) jobskPrepareMngService.updateEduTrnng(eduTrnngMngBean);
  		mv.addObject("result", result);

  		mv.setViewName("jsonView");
  		return mv;
	}
    
	@RequestMapping(value= {"/updateJobskPrepareEduMngAjax", "/updateSoftSkillEduMngAjax"})
	public ModelAndView updateEduTrnngPreprareSkillMng(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		eduTrnngMngBean.setUser(userMenu.getUser());
    		eduTrnngMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		eduTrnngMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	eduTrnngMngBean.setRegUserSeq("SYSTEM");
        	eduTrnngMngBean.setModUserSeq("SYSTEM");
        }  		
    	eduTrnngMngBean.setLang(locale.getLanguage().toLowerCase());
    	
    	

  		EduTrnngMngBean result = (EduTrnngMngBean) jobskPrepareMngService.updateEduTrnng(eduTrnngMngBean);
  		mv.addObject("result", result);

  		mv.setViewName("jsonView");
	  	return mv;
	} 

	@RequestMapping(value= {"/insertJobskPrepareEduMngAjax", "/insertSoftSkillEduMngAjax"})
	public ModelAndView insertEduTrnngPreprareSkillMng(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		eduTrnngMngBean.setUser(userMenu.getUser());
    		eduTrnngMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		eduTrnngMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	eduTrnngMngBean.setRegUserSeq("SYSTEM");
        	eduTrnngMngBean.setModUserSeq("SYSTEM");
        }  		
    	eduTrnngMngBean.setLang(locale.getLanguage().toLowerCase());
    	
    	
        
  		EduTrnngMngBean result = (EduTrnngMngBean) jobskPrepareMngService.insertEduTrnng(eduTrnngMngBean);
  		mv.addObject("result", result);

  		mv.setViewName("jsonView");
	  	return mv;
	}

	@RequestMapping(value= {"/deleteJobskPrepareEduMngAjax", "/deleteSoftSkillEduMngAjax"})
	public ModelAndView deleteEduTrnngPreprareSkillMng(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		eduTrnngMngBean.setUser(userMenu.getUser());
    		eduTrnngMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		eduTrnngMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	eduTrnngMngBean.setRegUserSeq("SYSTEM");
        	eduTrnngMngBean.setModUserSeq("SYSTEM");
        }  		
    	eduTrnngMngBean.setLang(locale.getLanguage().toLowerCase());

  		EduTrnngMngBean result = (EduTrnngMngBean) jobskPrepareMngService.deleteEduTrnng(eduTrnngMngBean);  		
  		mv.addObject("result", result);

	  	mv.setViewName("jsonView");
	  	return mv;
	}
	
	
    @RequestMapping(value= "jobskPrepareSubscriber")
	public ModelAndView jobskPrepareSubscriber(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		eduTrnngMngBean.setUser(userMenu.getUser());
    		eduTrnngMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		eduTrnngMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	eduTrnngMngBean.setRegUserSeq("SYSTEM");
        	eduTrnngMngBean.setModUserSeq("SYSTEM");
        }  		
    	eduTrnngMngBean.setLang(locale.getLanguage().toLowerCase());
    	
    	EduTrnngMngBean eduTrnngMng = (EduTrnngMngBean) jobskPrepareMngService.selectEduTrnngDetail(eduTrnngMngBean);
    	mv.addObject("EduTrnngMngBean", eduTrnngMng);
  		
    	mv.setViewName("trnng/jobskPrepareSubscriber.all");
	  	return mv;
	}
    
    
    @RequestMapping(value="/selectJobskPrepareSubscriberListAjax")
	public ModelAndView selectJobskPrepareSubscriberList(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		eduTrnngMngBean.setUser(userMenu.getUser());
    		eduTrnngMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		eduTrnngMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	eduTrnngMngBean.setRegUserSeq("SYSTEM");
        	eduTrnngMngBean.setModUserSeq("SYSTEM");
        }  		
    	eduTrnngMngBean.setLang(locale.getLanguage().toLowerCase());
    	
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			eduTrnngMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			eduTrnngMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			eduTrnngMngBean.setOrderColumn(orderColumn);
  			EduTrnngMngBean result = (EduTrnngMngBean) jobskPrepareMngService.selectJobskPrepareSubscriberList(eduTrnngMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", eduTrnngMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

  		mv.setViewName("jsonView");
  		return mv;
	}
    
    @RequestMapping(value="/updateJobskPrepareSubscriberArrayAjax")
	public ModelAndView updateJobskPrepareSubscriberArray(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		eduTrnngMngBean.setUser(userMenu.getUser());
    		eduTrnngMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		eduTrnngMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	eduTrnngMngBean.setRegUserSeq("SYSTEM");
        	eduTrnngMngBean.setModUserSeq("SYSTEM");
        }  		
    	eduTrnngMngBean.setLang(locale.getLanguage().toLowerCase());

    	EduTrnngMngBean result = (EduTrnngMngBean) jobskPrepareMngService.updateJobskPrepareSubscriber(eduTrnngMngBean);  		
  		mv.addObject("result", result);

  		mv.setViewName("jsonView");
  		return mv;
	}
    
}
