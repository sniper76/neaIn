package ony.cpes.internal.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cpes.internal.user.service.UserInsttService;
import ony.cpes.internal.user.bean.UserInsttBean;
import ony.cpes.internal.user.bean.UserInsttEduBean;
import ony.cpes.internal.user.bean.UserInsttFairBean;
import ony.framework.BaseController;

@RequestMapping("/internal/user")
@Controller
public class UserInsttController extends BaseController{

	private static Log log = LogFactory.getLog(UserInsttController.class);
  
	@Autowired
	private UserInsttService userInsttService;
	
	/*
	 * User List
	 */
    @RequestMapping("/userInsttInfoList")
	public String userInsttInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "user/userInsttInfoList.all";
	}    
    
    @RequestMapping(value="/selectUserInsttInfoList")    
	public ModelAndView selectUserInsttInfoListAjax(@ModelAttribute("userInsttBean") UserInsttBean userInsttBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
  		ModelAndView mv = new ModelAndView();
  		userInsttBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			userInsttBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userInsttBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userInsttBean.setOrderColumn(orderColumn);
  			
  			UserInsttBean result = (UserInsttBean) userInsttService.selectUserInsttInfoListAjax(userInsttBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userInsttBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}
    
    @RequestMapping(value="/deleteUserInsttInfo")
    public ModelAndView deleteUserInsttInfoAjax(@ModelAttribute("UserInsttBean") UserInsttBean userInsttBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	UserInsttBean resultParam = new UserInsttBean();
    	int selectedCnt = userInsttBean.getSelectedList().size();
    	
    	for (int i=0; i<selectedCnt; i++) {
    		
    		userInsttBean.setUserSeq(userInsttBean.getSelectedList().get(i).toString());
    		userInsttBean.setLang(locale.getLanguage().toLowerCase());
        	try {
        		
        		resultParam = userInsttService.deleteUserInsttInfoAjax(userInsttBean);
        		
        		if(resultParam.getResultCode() == "0000")
    			result.put("resultCode", "success");
    			result.put("resultMsg", "Delete Success");
    	        
        	} catch (Exception e) {
    			result.put("resultCode", resultParam.getResultCode());
    			result.put("resultMsg", e.getCause().getMessage()); 		
        	} 
    	}

  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;  
    }
    
    /*
     * Institution User Detail Info Main
     */   
    @RequestMapping(value="/selectUserInsttDtlInfoMainAjax") 
    public ModelAndView selectUserInsttDtlInfoMainAjax(@ModelAttribute("UserInsttBean") UserInsttBean userInsttBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userInsttBean.setLang(locale.getLanguage().toLowerCase());
    	UserInsttBean rtnData = (UserInsttBean) userInsttService.selectUserInsttDtlInfoMain(userInsttBean);
    	if (userInsttBean != null && userInsttBean.getPreviousUrl() != null) {
    		rtnData.setPreviousUrl(userInsttBean.getPreviousUrl());
    	}
		
    	mv.addObject("rtnData", rtnData);
    	mv.setViewName("user/userInsttDtlInfoMain" + ".all");
    	return mv;
	}
    
    /*
     * Institution User Detail Info Base
     */   
    @RequestMapping(value="/selectUserInsttDtlInfoBaseAjax") 
    public ModelAndView selectUserInsttDtlInfoBaseAjax(@ModelAttribute("UserInsttBean") UserInsttBean userInsttBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userInsttBean.setLang(locale.getLanguage().toLowerCase());
    	UserInsttBean rtnData = (UserInsttBean) userInsttService.selectUserInsttDtlInfoBaseAjax(userInsttBean);
		
    	mv.addObject("rtnData", rtnData);
    	mv.setViewName("user/userInsttDtlInfoBase" + ".empty");
    	return mv;
	} 
    
    /*
     * Institution Detail Info Profile
     */   
    @RequestMapping(value="/selectUserInsttDtlInfoProfileAjax") 
    public ModelAndView selectUserInsttDtlInfoProfileAjax(@ModelAttribute("UserInsttBean") UserInsttBean userInsttBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	userInsttBean.setLang(locale.getLanguage().toLowerCase());
    	UserInsttBean resultUserProf = (UserInsttBean) userInsttService.selectUserInsttDtlInfoProfile(userInsttBean);
    	//UserInsttBean resultUserImg = (UserInsttBean) userCmpnyService.selectUserInsttDtlInfoImg(userInsttBean);
		
    	mv.addObject("rtnProfData", resultUserProf);
    	//mv.addObject("rtnImgData", resultUserImg);
    	mv.setViewName("user/userInsttDtlInfoProfile" + ".empty");
    	return mv;
	} 
    
    /*
    * Institution Detail Info Education Training
    */   
   @RequestMapping(value="/selectUserInsttDtlInfoEduMainAjax") 
   public ModelAndView selectUserInsttDtlInfoEduMainAjax(@ModelAttribute("UserInsttEduBean") UserInsttEduBean userInsttEduBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
   	ModelAndView mv = new ModelAndView();

   	mv.addObject("rtnInsttSeq", userInsttEduBean.getInsttSeq());		
   	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());
   	mv.setViewName("user/userInsttDtlInfoEduList" + ".empty");
   	return mv;
	}    
   
   @RequestMapping(value="/selectUserInsttDtlInfoEduListSubAjax")    
	public ModelAndView selectUserInsttDtlInfoEduListSubAjax(@ModelAttribute("UserInsttEduBean") UserInsttEduBean userInsttEduBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
   	
 		ModelAndView mv = new ModelAndView();
 		userInsttEduBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
 		String orderColumnIndex = request.getParameter("order[0][column]");
 		if (orderColumnIndex != null) 
 			userInsttEduBean.setOrderStr(Integer.parseInt(orderColumnIndex));
 		
 		String orderDir = request.getParameter("order[0][dir]");
 		if (orderDir != null)
 			userInsttEduBean.setOrderColumnSort(orderDir);
 		
 		String orderColumns = request.getParameter("orderColumns");
 		String orderColumn = "";
 		if(orderColumns != null) {
 			String[] temp = orderColumns.split(",");
 			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
 			userInsttEduBean.setOrderColumn(orderColumn);
 			
 			UserInsttEduBean result = (UserInsttEduBean) userInsttService.selectUserInsttDtlInfoEduList(userInsttEduBean);
 			
 	  	    mv.addObject("aaData", result.getList());
 			mv.addObject("draw", userInsttEduBean.getDraw());
 	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
 			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
 		}
 		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}     

   /*
   * Institution Detail Info Job Fair
   */   
  @RequestMapping(value="/selectUserInsttDtlInfoJobfairMainAjax") 
  public ModelAndView selectUserInsttDtlInfoJobfairMainAjax(@ModelAttribute("UserInsttFairBean") UserInsttFairBean userInsttFairBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  	ModelAndView mv = new ModelAndView();

  	mv.addObject("rtnInsttSeq", userInsttFairBean.getInsttSeq());		
  	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());
  	mv.setViewName("user/userInsttDtlInfoFairList" + ".empty");
  	return mv;
	}    
  
  @RequestMapping(value="/selectUserInsttDtlInfoJobfairSubAjax")    
	public ModelAndView selectUserInsttDtlInfoJobfairSubAjax(@ModelAttribute("UserInsttFairBean") UserInsttFairBean userInsttFairBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  	
		ModelAndView mv = new ModelAndView();
		userInsttFairBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
		String orderColumnIndex = request.getParameter("order[0][column]");
		if (orderColumnIndex != null) 
			userInsttFairBean.setOrderStr(Integer.parseInt(orderColumnIndex));
		
		String orderDir = request.getParameter("order[0][dir]");
		if (orderDir != null)
			userInsttFairBean.setOrderColumnSort(orderDir);
		
		String orderColumns = request.getParameter("orderColumns");
		String orderColumn = "";
		if(orderColumns != null) {
			String[] temp = orderColumns.split(",");
			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
			userInsttFairBean.setOrderColumn(orderColumn);
			
			UserInsttFairBean result = (UserInsttFairBean) userInsttService.selectUserInsttDtlInfoJobfairList(userInsttFairBean);
			
	  	    mv.addObject("aaData", result.getList());
			mv.addObject("draw", userInsttFairBean.getDraw());
	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
		}
		
	  	mv.setViewName("jsonView");
	  	return mv;  
	}  
  
}
