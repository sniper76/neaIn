package ony.cpes.internal.user.controller;

import java.util.Locale;

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

import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.user.bean.UserChgBean;
import ony.cpes.internal.user.service.UserChgService;
import ony.framework.BaseController;

@RequestMapping("/internal/userChg")
@Controller
public class UserChgController extends BaseController{

	private static Log log = LogFactory.getLog(UserChgController.class);
  

	@Autowired
	private UserChgService userChgService;
	
	@RequestMapping("/userChgList")
	public String userChgList(HttpServletRequest request, HttpServletResponse response) throws Exception {    	
    	
		return "user/userChgList.all";
	}
	
	@RequestMapping(value="/selectUserChgListAjax")
	public ModelAndView selectUserChgListAjax(@ModelAttribute("UserChgBean") UserChgBean userChgBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

  		userChgBean.setLang(locale.getLanguage());
  		// EX : exception paramter
  		userChgBean.getUser().setUserAuthCd(request.getParameter("userAuthCd"));
  		userChgBean.getUser().setGenderCd(request.getParameter("genderCd"));
  		
  		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			userChgBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userChgBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userChgBean.setOrderColumn(orderColumn);
  			UserChgBean result = (UserChgBean) userChgService.selectUserChgList(userChgBean);
			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userChgBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
	  	return mv;
	}
	
	/**
	 * user detail for change status of type
	 * @param userChgBean
	 * @param locale
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userChgDtl")
	public ModelAndView userChgDtl(@ModelAttribute("UserChgBean") UserChgBean userChgBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

  		userChgBean.setLang(locale.getLanguage());
  		
  		UserChgBean result = (UserChgBean) userChgService.selectUserChgDetail(userChgBean);
	  	request.setAttribute("userChg", result);
	  	
  		mv.addObject("userChg", result);  		
    	mv.setViewName("user/userChgDtl.all");
  		
	  	return mv;
	  	
	}
	
	/**
	 * 
	 * @param locale
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/updateUserChgStsAjax")
	public void updateUserChgStsAjax(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserChgBean param = (UserChgBean) getObjectFromJSON(request, UserChgBean.class);
		this.outputJSON(request, response, userChgService.updateUserChgSts(request, param, locale));
	}
	
}
