package ony.cpes.internal.counsel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.counsel.bean.CounselBean;
import ony.cpes.internal.counsel.service.CounselService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/counsel")
public class CounselController extends BaseController {

	private static Log log = LogFactory.getLog(CounselController.class);

	@Autowired
	private CommonService commonService;	

	@Autowired
	private CounselService counselService;

    @RequestMapping(value={"/course", "/manToMan"})
	public ModelAndView counselList(@RequestParam(value = "method", required = false) String counselMethodDivCd,
			@ModelAttribute("CounselBean") CounselBean counselBean, Locale locale,
			HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();
    	
    	String[] servletPath = ((String) request.getServletPath()).split("/"); 
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	
  		counselBean.setLang(locale.getLanguage().toLowerCase());
    	
    	if ("course".equals(lastPath)) {
        	counselBean.setCounselCateDivCd("CCD0000000001");
    	} else if ("manToMan".equals(lastPath)) {
        	counselBean.setCounselCateDivCd("CCD0000000002");
    	}

		if (StringUtils.isBlank(counselMethodDivCd) || "ONLINE".equals(counselMethodDivCd)) {
    		counselBean.setCounselMethodDivCd("CMD0000000001");
    	} else if ("TEL".equals(counselMethodDivCd)) {
    		counselBean.setCounselMethodDivCd("CMD0000000002");
    	} else if ("CENTER".equals(counselMethodDivCd)) {
    		counselBean.setCounselMethodDivCd("CMD0000000003");
    	}
    	
  		mv.addObject("CounselBean", counselBean);  		
    	mv.setViewName("counsel/" + lastPath + ".all");
  		
	  	return mv;
	}
    
    @RequestMapping(value= {"/courseDtl", "/courseAnsReg", "/manToManDtl", "/manToManAnsReg", "/courseDtlUserAjax"})
	public ModelAndView counselDtl(@ModelAttribute("CounselBean") CounselBean counselBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	
    	ModelAndView mv = new ModelAndView();

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	
    	if("courseDtlUserAjax".equals(lastPath)) {
    		
    		lastPath = "user/"+lastPath.substring(0, 13)+".empty";
    	}else {
    		lastPath = "counsel/"+lastPath+".all";
    	}
    	
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();		
  		counselBean.setUser(sessUser);
  		counselBean.setLang(locale.getLanguage().toLowerCase());
    	
		CounselBean counsel = (CounselBean) counselService.selectCounselDetail(counselBean);
		
		CommDtlCdBean commDtlCdBean = new CommDtlCdBean();
	  	List<String> commGrpCdList = new ArrayList<String>();
	  	
	  	commGrpCdList.add("COUNSEL_CATE_DIV_CD");
	  	commGrpCdList.add("COUNSEL_METHOD_DIV_CD");
	  	commGrpCdList.add("COUNSEL_TARGET_CD");
	  	commGrpCdList.add("COUNSEL_STS_CD");
	  	commGrpCdList.add("USER_AUTH_CD");

	  	commDtlCdBean.setCommGrpCdList(commGrpCdList);
  		
	  	CommDtlCdBean commCode = (CommDtlCdBean) commonService.selectCommCodeList(commDtlCdBean);
		
  		mv.addObject("CounselBean", counsel);
  		mv.addObject("CommonCodeDtlBean", commCode.getList());  		

  		mv.setViewName(lastPath);
  		
	  	return mv;
	}
    
    @RequestMapping(value= {"/selectCounselHisDtlAjax","selectCompnyCounselHisDtlAjax","selectInsttCounselHisDtlAjax"})
	public ModelAndView counselHistDtl(@ModelAttribute("CounselBean") CounselBean counselBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	
    	ModelAndView mv = new ModelAndView();

    	
    	String lastPath = "";
    	String gubunChk = "";
    	gubunChk = request.getParameter("cateDivCd");
    	//gubunChk = counselBean.getCounselCateDivCd();
    	
    	if(gubunChk.equals("CCD0000000001")) {
    		lastPath = "courseHistDtl";
    	}else {
    		lastPath = "manToManHistDtl";
    	}
    	
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();		
  		counselBean.setUser(sessUser);
  		counselBean.setLang(locale.getLanguage().toLowerCase());
    	
		CounselBean counsel = (CounselBean) counselService.selectCounselHistDetail(counselBean);
		
		CommDtlCdBean commDtlCdBean = new CommDtlCdBean();
	  	List<String> commGrpCdList = new ArrayList<String>();
	  	
	  	commGrpCdList.add("COUNSEL_CATE_DIV_CD");
	  	commGrpCdList.add("COUNSEL_METHOD_DIV_CD");
	  	commGrpCdList.add("COUNSEL_TARGET_CD");
	  	commGrpCdList.add("COUNSEL_STS_CD");
	  	commGrpCdList.add("USER_AUTH_CD");

	  	commDtlCdBean.setCommGrpCdList(commGrpCdList);
  		
	  	CommDtlCdBean commCode = (CommDtlCdBean) commonService.selectCommCodeList(commDtlCdBean);
		
  		mv.addObject("CounselBean", counsel);
  		mv.addObject("CommonCodeDtlBean", commCode.getList());  		

  		mv.setViewName("user/" + lastPath + ".empty");
  		
	  	return mv;
	}

	@RequestMapping(value="/selectCounselListAjax")
	public ModelAndView selectCounselList(@ModelAttribute("CounselBean") CounselBean counselBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

  		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();  		
  		counselBean.setUser(sessUser);
  		
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			counselBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			counselBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			counselBean.setOrderColumn(orderColumn);
  			CounselBean result = (CounselBean) counselService.selectCounselList(counselBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", counselBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;
	}
	
	
	@RequestMapping(value="/selectUserCounselHisAjax")
	public ModelAndView selectUserCounselHis(@ModelAttribute("CounselBean") CounselBean counselBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

  		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();  		
  		counselBean.setUser(sessUser);
  		
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			counselBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			counselBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			counselBean.setOrderColumn(orderColumn);
  			counselBean.setLang(locale.getLanguage().toLowerCase());
  			CounselBean result = (CounselBean) counselService.selectUserCounselHis(counselBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", counselBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;
	}

	@RequestMapping(value="/updateCounselAjax")
	public ModelAndView updateCounsel(@ModelAttribute("CounselBean") CounselBean counselBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();		
  		counselBean.setUser(sessUser);

  		CounselBean result = (CounselBean) counselService.updateCounsel(counselBean);
  		
  		mv.addObject("result", result);
	  	mv.setViewName("jsonView");
	  	return mv;
	}

	@RequestMapping(value="/deleteCounselAjax")
	public ModelAndView deleteCounsel(@ModelAttribute("CounselBean") CounselBean counselBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();		
  		counselBean.setUser(sessUser);
  		
  		CounselBean result = (CounselBean) counselService.deleteCounsel(counselBean);
  		
  		mv.addObject("result", result);
	  	mv.setViewName("jsonView");
	  	return mv;
	}
}
