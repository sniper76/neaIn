package ony.cpes.internal.common.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.NeaUserMngBean;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.common.service.MngerMngService;
import ony.cpes.internal.common.service.NeaUserMngService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;



@RequestMapping("/internal/common")
@Controller
public class MngerMngController extends BaseController{

  private static Log log = LogFactory.getLog(MngerMngController.class);
  
	 @Autowired
	 private MngerMngService mngerMngService;
	 
	 @Autowired
	 private CommonService commonService;
  
	 @Autowired MessageSource messageSource;
		
	 @Autowired SessionLocaleResolver localeResolver;
		
	 @Autowired
	 private NeaUserMngService empUserMngService;
		
	 /**
	  * Nea Menu Auth 
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/mngerNeaMenuAuth")
	 public String selectMngerNeaMenuAuth(HttpServletRequest request, Locale locale, HttpServletResponse response) throws Exception {
		 
		 String userSeq = request.getParameter("userSeq");
		 String rangeCd = "RNG0000000002";
		 NeaUserMngBean user = new NeaUserMngBean();
		 NeaUserMngBean NeaUserMngBean = new NeaUserMngBean ();
		 NeaUserMngBean.setUserSeq(userSeq);
		 
		 user = empUserMngService.selectNeaUserMngDtl(locale, NeaUserMngBean);
		 
		 request.setAttribute("user", user);
		 request.setAttribute("rangeCd", rangeCd);
		 
		 return "common/mngerJcDetailInfo.all";
	 }
	 
	 /**
	  * menu list
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/mngerNoneNeaMenuAuth")
	 public String selectMngerNoneNeaMenuAuth(HttpServletRequest request, Locale locale, HttpServletResponse response) throws Exception {
		 
		 String userSeq = request.getParameter("userSeq");
		 String rangeCd = "RNG0000000002";
		 NeaUserMngBean user = new NeaUserMngBean();
		 NeaUserMngBean NeaUserMngBean = new NeaUserMngBean ();
		 NeaUserMngBean.setUserSeq(userSeq);
		 
		 user = empUserMngService.selectNeaUserMngDtl(locale, NeaUserMngBean);
		 
		 request.setAttribute("user", user);
		 request.setAttribute("rangeCd", rangeCd);
		 
		 return "common/mngerJcDetailInfo.all";
	 }
	 
	 /**
	  * menu list
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/mngerJcMenuAuth")
	 public String mngerJcMenuAuth(HttpServletRequest request, Locale locale, HttpServletResponse response) throws Exception {
		 
		 String userSeq = request.getParameter("userSeq");
		 String rangeCd = "RNG0000000002";
		 NeaUserMngBean user = new NeaUserMngBean();
		 NeaUserMngBean NeaUserMngBean = new NeaUserMngBean ();
		 NeaUserMngBean.setUserSeq(userSeq);
		 
		 user = empUserMngService.selectNeaUserMngDtl(locale, NeaUserMngBean);
		 
		 request.setAttribute("user", user);
		 request.setAttribute("rangeCd", rangeCd);
		 
		 return "common/mngerJcDetailInfo.all";
	 }
	 
	 @RequestMapping("/mngerMenuAuthListAjax")
	 public String selectMngerMenuAuthListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 String userSeq = request.getParameter("userSeq");
		 MenuBean param = new MenuBean();
		 param.setUserSeq(userSeq);
		 MenuBean result = mngerMngService.selectMenuMngList(request, param);
		 request.setAttribute("menu", result);
		 return "common/mngerJcDetailInfoListAjax.empty";
	 }
	 
	 
	@RequestMapping(value="/updateMngerMenuAuthRegAjax", method=RequestMethod.POST)
	public ModelAndView updateMngerMenuAuthRegAjax(HttpServletRequest request, HttpServletResponse response,
	            @RequestParam(value="m1List[]") List<String> m1List,
	            @RequestParam(value="m2List[]") List<String> m2List,
	            @RequestParam(value="m3List[]") List<String> m3List,
	            @RequestParam(value="m4List[]") List<String> m4List,
	            @RequestParam(value="proList[]") List<String> proList,
	            @RequestParam(value="userSeq") String userSeq
	            ) throws Exception {
	        
			ModelAndView mv = new ModelAndView();
			
			// login user setting
	    	UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();  		
	    	
			UserMenuBean result = new UserMenuBean(); 
	        
			UserMenuBean userMenu = new UserMenuBean(); 
			
			userMenu.setRegUserSeq(sessUser.getUserSeq());
			userMenu.setModUserSeq(sessUser.getUserSeq());
			userMenu.setUserSeq(userSeq);
			userMenu.setM1List(m1List);
			userMenu.setM2List(m2List);
			userMenu.setM3List(m3List);
			userMenu.setM4List(m4List);
			userMenu.setProList(proList);
			
			try {
				result = mngerMngService.insertUserMenuProgramAuth(request, userMenu);
				result.setResultCode(messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
				result.setMsg(messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
				
			} catch (Exception e) {
				e.printStackTrace();
				result.setResultCode(messageSource.getMessage("cpes.error.code",null, "Error", localeResolver.resolveLocale(request)));
				result.setMsg(messageSource.getMessage("cpes.error.msg",null, "Error", localeResolver.resolveLocale(request)));
			}
			
			mv.addObject("result", result);
			mv.setViewName("jsonView");
	        return mv;
	 
	    }
	 	 
}
