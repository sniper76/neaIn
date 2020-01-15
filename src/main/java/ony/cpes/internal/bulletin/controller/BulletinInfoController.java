package ony.cpes.internal.bulletin.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.bulletin.bean.BulletinMNGBean;
import ony.cpes.internal.bulletin.service.BulletinMNGService;
import ony.cpes.internal.bulletin.service.BulletinService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;


@RequestMapping("/internal/info")
@Controller
public class BulletinInfoController extends BaseController{

	private static Log log = LogFactory.getLog(BulletinInfoController.class);
  
	@Autowired
	private BulletinService bulletinService;
	
	@Autowired
	private BulletinMNGService bulletinMNGService;
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value={"/bulletinManual", "/bulletinFaq", "/bulletinAncmt", "/bulletinNews"})
	public ModelAndView bulletin(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String[] servletPath = ((String) request.getServletPath()).split("/"); 
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	String viewName = "";
    	
    	bulletinBean.setLang(locale.getLanguage().toLowerCase());
    	
    	if ("bulletinManual".equals(lastPath)) {
    		bulletinBean.setBulletinTypeCd("BTC0000000001");
    		bulletinBean.setProgramId("PGM0000000056");
    		viewName = "bulletinBasic";
    		
    	} else if ("bulletinFaq".equals(lastPath)) {
    		bulletinBean.setBulletinTypeCd("BTC0000000005");
    		bulletinBean.setProgramId("PGM0000000057");
    		viewName = "bulletinFaq";
    	
    	} else if ("bulletinAncmt".equals(lastPath)) {
    		bulletinBean.setBulletinTypeCd("BTC0000000001");
    		bulletinBean.setProgramId("PGM0000000058");
    		viewName = "bulletinBasic";
    	
    	} else if ("bulletinNews".equals(lastPath)) {
    		bulletinBean.setBulletinTypeCd("BTC0000000002");
    		bulletinBean.setProgramId("PGM0000000059");
    		viewName = "bulletinThumb";

    	}

  		mv.addObject("BulletinBean", bulletinBean);  		
    	mv.setViewName("info/" + viewName + ".all");
  		
	  	return mv;
	}
	
    
	@RequestMapping(value= {"/bulletinManualReg", "/bulletinFaqReg", "/bulletinAncmtReg", "/bulletinNewsReg"})
	public ModelAndView bulletinReg(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale,  HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String[] servletPath = ((String) request.getServletPath()).split("/"); 
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	String viewName = "";
    	
    	bulletinBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();		
    	bulletinBean.setUser(sessUser);
    	
		BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		bulletinMNGBean.setProgramId(bulletinBean.getProgramId());
		BulletinMNGBean bulletinMng = bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean);
    	
    	BulletinBean cate = bulletinService.selectBulletinCateList(bulletinBean);
    	
    	if ("bulletinManualReg".equals(lastPath)) {
    		viewName = "bulletinBasicReg";
    		
    	} else if ("bulletinFaqReg".equals(lastPath)) {
    		viewName = "bulletinFaqReg";
    	
    	} else if ("bulletinAncmtReg".equals(lastPath)) {
    		viewName = "bulletinBasicReg";
    	
    	} else if ("bulletinNewsReg".equals(lastPath)) {
    		viewName = "bulletinThumbReg";

    	}

    	mv.addObject("BulletinMNGBean", bulletinMng);
    	mv.addObject("BulletinCateBean", cate.getList());
    	mv.addObject("BulletinBean", bulletinBean);  		
    	mv.setViewName("info/" + viewName + ".all");
  		
		return mv;
	}
	
	@RequestMapping(value= {"/bulletinManualMod", "/bulletinFaqMod", "/bulletinAncmtMod", "/bulletinNewsMod"})
	public ModelAndView bulletinDtl(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale,  HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	String[] servletPath = ((String) request.getServletPath()).split("/"); 
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
    	String viewName = "";
    	
    	bulletinBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();		
    	bulletinBean.setUser(sessUser);
    	
    	BulletinBean result = bulletinService.selectBulletinDtl(bulletinBean);    	
    	BulletinBean cate = bulletinService.selectBulletinCateList(bulletinBean);

		BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		bulletinMNGBean.setProgramId(bulletinBean.getProgramId());
		BulletinMNGBean bulletinMng = bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean);
    	
    	if ("bulletinManualMod".equals(lastPath)) {
    		viewName = "bulletinBasicMod";
    		
    	} else if ("bulletinFaqMod".equals(lastPath)) {
    		viewName = "bulletinFaqMod";
    	
    	} else if ("bulletinAncmtMod".equals(lastPath)) {
    		viewName = "bulletinBasicMod";
    	
    	} else if ("bulletinNewsMod".equals(lastPath)) {
    		viewName = "bulletinThumbMod";

    	}

    	mv.addObject("BulletinMNGBean", bulletinMng);
    	mv.addObject("BulletinCateBean", cate.getList());
  		mv.addObject("BulletinBean", result);
  		mv.setViewName("info/" + viewName + ".all");
  		
		return mv;
	}

	@RequestMapping("/selectBulletinListAjax")
	public ModelAndView selectBulletinList(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale,  HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	bulletinBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();		
    	bulletinBean.setUser(sessUser);
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			bulletinBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			bulletinBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			bulletinBean.setOrderColumn(orderColumn);
  			bulletinBean.setBulletinTypeCd(request.getParameter("bulletinTypeCd"));
  			BulletinBean result = bulletinService.selectBulletinList(bulletinBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", bulletinBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		mv.setViewName("jsonView");
	  	return mv;  
    	
    	
	}
	
	@RequestMapping("/selectBulletinNotiCntAjax")
	public ModelAndView selectBulletinNotiCnt(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	BulletinBean result = bulletinService.selectBulletinNotiCnt(bulletinBean);
    	
    	mv.addObject("notiCnt", result.getNotiCnt());
    	mv.setViewName("jsonView");
    	
	  	return mv;  
	}

	@RequestMapping("/insertBulletinAjax")
	public ModelAndView insertBulletin(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	bulletinBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();  		
    	bulletinBean.setUser(sessUser);
		
		result = bulletinService.insertBulletinBasic(bulletinBean);
		
		mv.addObject("fileGrpSeq", result.get("fileGrpSeq"));
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
	@RequestMapping("/updateBulletinAjax")
	public ModelAndView updateBulletin(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	
    	// login user setting
    	bulletinBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();  		
    	bulletinBean.setUser(sessUser);
        
    	result = bulletinService.updateBulletinDtl(request, bulletinBean, locale);
        
    	mv.addObject("stat",result.get("stat"));
    	mv.addObject("msg",result.get("msg"));
    	mv.setViewName("jsonView");
    	
	  	return mv;  
	}

	@RequestMapping("/updateBulletinArrayAjax")
	public ModelAndView updateBulletinArray(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	
    	// login user setting
    	bulletinBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();  		
    	bulletinBean.setUser(sessUser);
        
    	result = bulletinService.updateBulletinDtl(request, bulletinBean, locale);
        
    	mv.addObject("stat",result.get("stat"));
    	mv.addObject("msg",result.get("msg"));
    	mv.setViewName("jsonView");
    	
	  	return mv;  
	}

	@RequestMapping("/deleteBulletinAjax")
	public ModelAndView deleteBulletin(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	
    	// login user setting
    	bulletinBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();  		
    	bulletinBean.setUser(sessUser);
    	bulletinBean.setDelYn("Y");
        
    	result = bulletinService.deleteBulletinDtl(bulletinBean);
        
    	mv.addObject("stat",result.get("stat"));
    	mv.addObject("msg",result.get("msg"));
    	mv.setViewName("jsonView");
    	
	  	return mv;  
	}	

}
