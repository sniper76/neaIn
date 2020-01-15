package ony.cpes.internal.fair.controller;

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

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.service.FairVccyMngService;
import ony.cpes.internal.trnng.service.JobskPrepareMngService;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/fair")
public class FairVccyMngController extends BaseController {

	private static Log log = LogFactory.getLog(FairVccyMngController.class);

	@Autowired
	private CommonService commonService;		
	
	@Autowired
	private JobskPrepareMngService jobskPrepareMngService;
	
	@Autowired
	private FairVccyMngService fairVccyMngService;
	

	@RequestMapping(value="/empmnAncmtMng")
	public ModelAndView empmnAncmtMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

        fairMngBean.setMstJcCd(userMenu.getUser().getJcCd());
        mv.addObject("FairMngBean", fairMngBean);

    	CommDtlCdBean locCdBean = (CommDtlCdBean) jobskPrepareMngService.selectLOC2DepthList();
    	mv.addObject("LocCdBean", locCdBean.getList());
  		
    	mv.setViewName("fair/empmnAncmtMng.all");
	  	return mv;
	}
    
    @RequestMapping(value="/selectEmpmnAncmtMngListAjax")
	public ModelAndView selectEmpmnAncmtMngList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
        	fairMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
        	fairMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairMngBean.setRegUserSeq("SYSTEM");
        	fairMngBean.setModUserSeq("SYSTEM");
        }  		
  		fairMngBean.setLang(locale.getLanguage().toLowerCase());
    	
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			fairMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			fairMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			fairMngBean.setOrderColumn(orderColumn);

  			FairMngBean result = (FairMngBean) fairVccyMngService.selectEmpmnAncmtMngList(fairMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
  		return mv;
	}
    
	@RequestMapping(value="/updateEmpmnAncmtMngAjax")
	public ModelAndView updateEmpmnAncmtMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
        	fairMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
        	fairMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
    	} else {
        	fairMngBean.setRegUserSeq("SYSTEM");
        	fairMngBean.setModUserSeq("SYSTEM");
        }

        fairMngBean.setLang(locale.getLanguage().toLowerCase());

    	FairMngBean result = (FairMngBean) fairVccyMngService.updateEmpmnAncmtMng(fairMngBean);
  		mv.addObject("result", result);

	  	mv.setViewName("jsonView");
	  	return mv;
	}
	
    
    @RequestMapping(value="/empmnAncmtListLayer")
	public ModelAndView fairListLayer(@ModelAttribute("LocationBean") LocationBean locationBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	CommDtlCdBean locCdBean = (CommDtlCdBean) jobskPrepareMngService.selectLOC2DepthList();
    	mv.addObject("LocCdBean", locCdBean.getList());

    	mv.setViewName("common/empmnAncmtList.empty");
	  	return mv;
    }
    
    @RequestMapping(value="/selectEmpmnAncmtJoinListAjax")
	public ModelAndView selectEmpmnAncmtJoinList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
        	fairMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
        	fairMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairMngBean.setRegUserSeq("SYSTEM");
        	fairMngBean.setModUserSeq("SYSTEM");
        }  		
  		fairMngBean.setLang(locale.getLanguage().toLowerCase());
    	
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			fairMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			fairMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			fairMngBean.setOrderColumn(orderColumn);

  			FairMngBean result = (FairMngBean) fairVccyMngService.selectEmpmnAncmtJoinList(fairMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
  		return mv;
	}    
	
	@RequestMapping(value="/insertEmpmnAncmtJoinArrayAjax")
	public ModelAndView insertEmpmnAncmtJoinArray(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
        	fairMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
        	fairMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
    	} else {
        	fairMngBean.setRegUserSeq("SYSTEM");
        	fairMngBean.setModUserSeq("SYSTEM");
        }

        fairMngBean.setLang(locale.getLanguage().toLowerCase());

    	FairMngBean result = (FairMngBean) fairVccyMngService.insertEmpmnAncmtJoinArray(fairMngBean);
  		mv.addObject("result", result);

	  	mv.setViewName("jsonView");
	  	return mv;
	}

	@RequestMapping(value="/applicListMng")
	public ModelAndView applicListMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

        fairMngBean.setMstJcCd(userMenu.getUser().getJcCd());
        mv.addObject("FairMngBean", fairMngBean);
  		
    	mv.setViewName("fair/applicListMng.all");
	  	return mv;
	}

	@RequestMapping(value="/selectApplicMngListAjax")
	public ModelAndView selectApplicMngList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
        	fairMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
        	fairMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairMngBean.setRegUserSeq("SYSTEM");
        	fairMngBean.setModUserSeq("SYSTEM");
        }  		
  		fairMngBean.setLang(locale.getLanguage().toLowerCase());
    	
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			fairMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			fairMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			fairMngBean.setOrderColumn(orderColumn);

  			FairMngBean result = (FairMngBean) fairVccyMngService.selectApplicMngList(fairMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
  		return mv;
  	}
	
	@RequestMapping(value="/intvwListMng")
	public ModelAndView intvwListMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

        fairMngBean.setMstJcCd(userMenu.getUser().getJcCd());
        mv.addObject("FairMngBean", fairMngBean);
  		
    	mv.setViewName("fair/intvwListMng.all");
	  	return mv;
	}
	

	@RequestMapping(value="/selectIntvwMngListAjax")
	public ModelAndView selectIntvwMngList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
        	fairMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
        	fairMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairMngBean.setRegUserSeq("SYSTEM");
        	fairMngBean.setModUserSeq("SYSTEM");
        }  		
  		fairMngBean.setLang(locale.getLanguage().toLowerCase());
    	
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			fairMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			fairMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			fairMngBean.setOrderColumn(orderColumn);

  			FairMngBean result = (FairMngBean) fairVccyMngService.selectIntvwMngList(fairMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
  		return mv;
  	}	
	
}
