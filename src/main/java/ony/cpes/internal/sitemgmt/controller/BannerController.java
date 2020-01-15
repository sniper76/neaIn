package ony.cpes.internal.sitemgmt.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;
import ony.cpes.internal.sitemgmt.service.BannerService;
import ony.cpes.internal.user.bean.UserBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.sitemgmt.bean.BannerBean;
import ony.framework.BaseController;


@RequestMapping("/internal/sitemgmt")
@Controller
public class BannerController extends BaseController{

	private static Log log = LogFactory.getLog(BannerController.class);
  
	@Autowired
	private BannerService bannerService;
	
	
	@Autowired
	private CommonService CommonService;
	
	/**
	 * banner search form open
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bannerList")
	public String bannerList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "siteMgmt/bannerList.all";
	}
	
	/**
	 * banner insert form open
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bannerReg")
	public String bannerReg(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "siteMgmt/bannerReg.all";
	}
	
	/**
	 * banner update form open
	 * @param BannerBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bannerMod")
	public ModelAndView bannerMod(@ModelAttribute("BannerBean") BannerBean BannerBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
        
        String bannerSeq = BannerBean.getBannerSeq();
    	mv.addObject("bannerSeq",bannerSeq);
    	mv.setViewName("siteMgmt/bannerMod.all");
    	
	  	return mv;  
	}
	
	/**
	 * banner detail value 
	 * @param BannerBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectBannerDtlAjax")
	public ModelAndView selectBannerDtlAjax(@ModelAttribute("BannerBean") BannerBean BannerBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	BannerBean dtlList = new BannerBean();
        
    	dtlList = bannerService.selectBannerDtl(BannerBean);
    	
    	mv.addObject("dtlList",dtlList);
    	mv.setViewName("jsonView");
    	
	  	return mv;  
	}
	
	/**
	 * banner search list
	 * @param BannerBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectBannerList")
	public ModelAndView selectBannerListAjax(@ModelAttribute("BannerBean") BannerBean BannerBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			BannerBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			BannerBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			BannerBean.setOrderColumn(orderColumn);
  			BannerBean.setLang(locale.getLanguage().toLowerCase());
  			BannerBean result = bannerService.selectBannerList(BannerBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", BannerBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;  
    	
    	
	}
	
	/**
	 * banner insert
	 * @param BannerBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertBanner")
	public ModelAndView insertBannerAjax(@ModelAttribute("BannerBean") BannerBean BannerBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	BannerBean.setUser(sessUser);
		
		result = bannerService.insertBanner(BannerBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	/**
	 * banner update
	 * @param BannerBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBannerAjax")
	public ModelAndView updateBannerAjax(@ModelAttribute("BannerBean") BannerBean BannerBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	BannerBean.setUser(sessUser);
		
		result = bannerService.updateBanner(BannerBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	/**
	 * banner delete
	 * @param BannerBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteBannerDtlAjax")
	public ModelAndView deleteBannerDtlAjax(@ModelAttribute("BannerBean") BannerBean BannerBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		
		result = bannerService.deleteBannerDtl(BannerBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}
	
	
    
}
