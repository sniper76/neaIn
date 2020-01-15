package ony.cpes.internal.fair.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.fair.bean.FairBoothMngBean;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.service.FairBoothMngService;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/fair")
public class FairBoothMngController extends BaseController {

	private static Log log = LogFactory.getLog(FairBoothMngController.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private FairBoothMngService fairBoothMngService;

	@RequestMapping(value="/boothTotalMng")
	public ModelAndView compnyTotalMng(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("fair/boothTotalMng.all");
	  	return mv;
	}

	@RequestMapping(value = {"/boothRegMng", "/boothReqMng", "/boothResvMng"})
	public ModelAndView jobFairMng(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean, Locale locale,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

    	String[] servletPath = ((String) request.getServletPath()).split("/"); 
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	
    	mv.setViewName("fair/" + lastPath + ".empty");
	  	return mv;
	}

	@RequestMapping(value = "/selectBoothRegListAjax")
	public ModelAndView selectBoothRegList(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		UserMenuBean userMenu = (UserMenuBean) session.getAttribute("sessUser");

		if (userMenu != null) {
			fairBoothMngBean.setUser(userMenu.getUser());
			fairBoothMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
			fairBoothMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
		} else {
			fairBoothMngBean.setRegUserSeq("SYSTEM");
			fairBoothMngBean.setModUserSeq("SYSTEM");
		}
		fairBoothMngBean.setLang(locale.getLanguage().toLowerCase());

		FairBoothMngBean result = fairBoothMngService.selectBoothRegList(fairBoothMngBean);
	  	mv.addObject("result", result);

		mv.setViewName("jsonView");
		return mv;
	}
	
	@RequestMapping(value = "/mergeBoothRegMngAjax")
	public ModelAndView insertBoothRegMng(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		UserMenuBean userMenu = (UserMenuBean) session.getAttribute("sessUser");

		if (userMenu != null) {
			fairBoothMngBean.setUser(userMenu.getUser());
			fairBoothMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
			fairBoothMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
		} else {
			fairBoothMngBean.setRegUserSeq("SYSTEM");
			fairBoothMngBean.setModUserSeq("SYSTEM");
		}
		fairBoothMngBean.setLang(locale.getLanguage().toLowerCase());

		FairBoothMngBean result = fairBoothMngService.mergeBoothRegMng(fairBoothMngBean);
	  	mv.addObject("result", result);

		mv.setViewName("jsonView");
		return mv;
	}
    
    @RequestMapping(value="/selectBoothReqMngListAjax")
	public ModelAndView selectBoothReqMngList(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		fairBoothMngBean.setUser(userMenu.getUser());
    		fairBoothMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		fairBoothMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairBoothMngBean.setRegUserSeq("SYSTEM");
        	fairBoothMngBean.setModUserSeq("SYSTEM");
        }  		
    	fairBoothMngBean.setLang(locale.getLanguage().toLowerCase());
    	
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			fairBoothMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			fairBoothMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			fairBoothMngBean.setOrderColumn(orderColumn);

  			FairBoothMngBean result = (FairBoothMngBean) fairBoothMngService.selectBoothReqMngList(fairBoothMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairBoothMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
  		return mv;
	}
    
	@RequestMapping(value="/updateBoothReqMngAjax")
	public ModelAndView updateBoothReqMng(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		fairBoothMngBean.setUser(userMenu.getUser());
    		fairBoothMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		fairBoothMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
    	} else {
    		fairBoothMngBean.setRegUserSeq("SYSTEM");
    		fairBoothMngBean.setModUserSeq("SYSTEM");
        }

    	fairBoothMngBean.setLang(locale.getLanguage().toLowerCase());

    	FairBoothMngBean result = (FairBoothMngBean) fairBoothMngService.updateBoothReqMng(fairBoothMngBean);
  		mv.addObject("result", result);

	  	mv.setViewName("jsonView");
	  	return mv;
	}
   
    
	@RequestMapping(value="/deleteBoothReqMngAjax")
	public ModelAndView deleteBoothReqMng(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		fairBoothMngBean.setUser(userMenu.getUser());
    		fairBoothMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		fairBoothMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
    	} else {
    		fairBoothMngBean.setRegUserSeq("SYSTEM");
    		fairBoothMngBean.setModUserSeq("SYSTEM");
        }

    	fairBoothMngBean.setLang(locale.getLanguage().toLowerCase());

    	FairBoothMngBean result = (FairBoothMngBean) fairBoothMngService.deleteBoothReqMng(fairBoothMngBean);
  		mv.addObject("result", result);

	  	mv.setViewName("jsonView");
	  	return mv;
	}
    
	@RequestMapping(value="/updateBoothCompnyInsttMngAjax")
	public ModelAndView updateBoothCompnyInsttMng(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		fairBoothMngBean.setUser(userMenu.getUser());
    		fairBoothMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		fairBoothMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
    	} else {
    		fairBoothMngBean.setRegUserSeq("SYSTEM");
    		fairBoothMngBean.setModUserSeq("SYSTEM");
        }

    	fairBoothMngBean.setLang(locale.getLanguage().toLowerCase());

    	FairBoothMngBean result = (FairBoothMngBean) fairBoothMngService.updateBoothCompnyInsttMng(fairBoothMngBean);
  		mv.addObject("result", result);

	  	mv.setViewName("jsonView");
	  	return mv;
	}

	@RequestMapping(value="/selectBoothResvMngListAjax")
	public ModelAndView selectBoothResvMngList(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		fairBoothMngBean.setUser(userMenu.getUser());
    		fairBoothMngBean.setRegUserSeq(userMenu.getUser().getUserSeq());
    		fairBoothMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairBoothMngBean.setRegUserSeq("SYSTEM");
        	fairBoothMngBean.setModUserSeq("SYSTEM");
        }  		
    	fairBoothMngBean.setLang(locale.getLanguage().toLowerCase());
    	
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			fairBoothMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			fairBoothMngBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			fairBoothMngBean.setOrderColumn(orderColumn);

  			FairBoothMngBean result = (FairBoothMngBean) fairBoothMngService.selectBoothResvMngList(fairBoothMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairBoothMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
  		return mv;
	}
	
    @RequestMapping(value="/boothReqLayer")
	public ModelAndView boothReqLayer(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	
		CommDtlCdBean commDtlCdBean = new CommDtlCdBean();
		List<String> commGrpCdList = new ArrayList<String>();
	  	commGrpCdList.add("COMPNY_INSTT_DIV_CD");
	  	commDtlCdBean.setCommGrpCdList(commGrpCdList);
	  	CommDtlCdBean commCode = (CommDtlCdBean) commonService.selectCommCodeList(commDtlCdBean);
  		mv.addObject("CommonCodeDtlBean", commCode.getList());
    	
    	mv.setViewName("common/boothReqList.empty");
	  	return mv;
    } 
    
    @RequestMapping(value="/selectBoothReqListLayerAjax")
	public ModelAndView selectBoothReqListLayer(@ModelAttribute("FairBoothMngBean") FairBoothMngBean fairBoothMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
    		fairBoothMngBean.setUser(userMenu.getUser());
    		fairBoothMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairBoothMngBean.setRegUserSeq("SYSTEM");
        	fairBoothMngBean.setModUserSeq("SYSTEM");
        }
    	
    	fairBoothMngBean.setLang(locale.getLanguage().toLowerCase());
    	FairBoothMngBean result = (FairBoothMngBean) fairBoothMngService.selectBoothReqListLayer(fairBoothMngBean);
	  	mv.addObject("list", result.getList());

	  	mv.setViewName("jsonView");
  		return mv;
	}    
        
}
