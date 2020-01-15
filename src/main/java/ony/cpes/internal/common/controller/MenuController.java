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

import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.ProgramBean;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.common.service.MenuService;
import ony.framework.BaseController;



@RequestMapping("/internal/common")
@Controller
public class MenuController extends BaseController{

  private static Log log = LogFactory.getLog(MenuController.class);
  
	 @Autowired
	 private MenuService menuService;
  
	 /**
	  * menu list
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/menuMngInternalList")
	 public String menuMngInternalList(@ModelAttribute("MenuBean") MenuBean menuBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 menuBean.setRangeCd("RNG0000000002");
		 request.setAttribute("menuBean", menuBean);
		 return "common/menuMngList.all";
	 }
	 
	 @RequestMapping("/menuMngExternalList")
	 public String menuMngExternalList(@ModelAttribute("MenuBean") MenuBean menuBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 menuBean.setRangeCd("RNG0000000003");
		 request.setAttribute("menuBean", menuBean);
		 return "common/menuMngList.all";
	 }
	 
	 /**
	  * inquiry MENU list 
	  * @param menuBean
	  * @param request
	  * @param response
	  * @throws Exception
	  */
	 @RequestMapping("/selectMenuMngListAjax")
	 public ModelAndView selectMenuMngListAjax(@ModelAttribute("MenuBean") MenuBean menuBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 	ModelAndView mv = new ModelAndView();
		 	menuBean.setLang(locale.getLanguage());
		 
			// sorting
			String orderColumnIndex = request.getParameter("order[0][column]");
			if (orderColumnIndex != null) 
				menuBean.setOrderStr(Integer.parseInt(orderColumnIndex));
			
			String orderDir = request.getParameter("order[0][dir]");
			if (orderDir != null)
				menuBean.setOrderColumnSort(orderDir);
			
			String orderColumns = request.getParameter("orderColumns");
			String orderColumn = "";
			if(orderColumns != null) {
				String[] temp = orderColumns.split(",");
				orderColumn = temp[Integer.parseInt(orderColumnIndex)];
				menuBean.setOrderColumn(orderColumn);
			}
				
			if(orderColumns != null) {
	  			String[] temp = orderColumns.split(",");
	  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
	  			menuBean.setOrderColumn(orderColumn);
	  			MenuBean result = (MenuBean) menuService.selectMenuMngList(menuBean);
				
	  	  	    mv.addObject("aaData", result.getTailListMenu());
	  			mv.addObject("draw", menuBean.getDraw());
	  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
	  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
	  		}
				
			mv.setViewName("jsonView");
			
			return mv;
		}
	  
	  
	 /**
	  * menu list
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/menuMngInternalReg")
	 public String menuMngInternalReg(@ModelAttribute("MenuBean") MenuBean menuBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 if (menuBean != null && menuBean.getMenuCd() != null && !"".equals(menuBean.getMenuCd())) {
			 menuBean = menuService.selectMenuMngDetail(menuBean);
		 }
		 
		 menuBean.setRangeCd("RNG0000000002");
		 request.setAttribute("menu", menuBean);
		 
		 return "common/menuMngReg.all";
	 }
	 
	 
	 /**
	  * menu list
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/menuMngExternalReg")
	 public String menuMngExternalReg(@ModelAttribute("MenuBean") MenuBean menuBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 if (menuBean != null && menuBean.getMenuCd() != null && !"".equals(menuBean.getMenuCd())) {
			 menuBean = menuService.selectMenuMngDetail(menuBean);
		 }
		 
		 menuBean.setRangeCd("RNG0000000003");
		 request.setAttribute("menu", menuBean);
		 
		 
		 return "common/menuMngReg.all";
	 }
	 
	 
	/**
	 * insert menu
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("/insertMenuMng")
	 public void insertMenuMng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    	
		 MenuBean param = (MenuBean) getObjectFromJSON(request, MenuBean.class);
		 MenuBean menu = new MenuBean();
		 
		 HttpSession session = request.getSession();
		 UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");
		 
		 if (userMenu != null) {
			 param.setRegUserSeq(userMenu.getUser().getUserSeq());
			 param.setModUserSeq(userMenu.getUser().getUserSeq());
		 } else {
			 param.setRegUserSeq("SYSTEM");
			 param.setModUserSeq("SYSTEM");
		 }

		 if (param != null && param.getMenuCd() != null && !"".equals(param.getMenuCd())) {
			 menu = (MenuBean) menuService.updateMenuMng(request, param);
		 } else {
			 menu = (MenuBean) menuService.insertMenuMng(request, param);
		 }
		
    	 this.outputJSON(request, response, menu);
    	 
    	 
	 }
	
	/**
	 * update menu
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("/updateMenuMng")
	 public void updateMenuMng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 MenuBean param = (MenuBean) getObjectFromJSON(request, MenuBean.class);
		 MenuBean menu = (MenuBean) menuService.updateMenuMng(request, param);
		
    	 this.outputJSON(request, response, menu);
	 }
	 
	 /**
	 * update menu
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("/deleteMenuMng")
	 public void deleteMenuMng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 MenuBean param = (MenuBean) getObjectFromJSON(request, MenuBean.class);
		 MenuBean menu = (MenuBean) menuService.deleteMenuMng(request, param);
		
    	 this.outputJSON(request, response, menu);
	 }
	 
	 /**
	  * inquiry menu detail
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/selectMenuMngDetail")
	 public String selectMenuMngDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 ModelAndView mav = new ModelAndView("");
		 
		 MenuBean param = (MenuBean) getObjectFromJSON(request, MenuBean.class);
		 MenuBean menuDtl = new MenuBean();
		 if (param != null && param.getMenuCd() != null && !"".equals(param.getMenuCd())) {
			 menuDtl = (MenuBean) menuService.selectMenuMngDetail(param);
		 }

		 request.setAttribute("menuDtl", menuDtl);
    	 return "common/menuMngReg.all";
	 }
	 
	 /**
	  * inquiry menu list of the upper menu
	  * @param request
	  * @param response
	  * @throws Exception
	  */
	 @RequestMapping("/selectCurrentLvlMenuMngListAjax")
	 public void selectCurrentLvlMenuMngList(@ModelAttribute("MenuBean") MenuBean menuBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 MenuBean menu = (MenuBean) menuService.selectCurrentLvlMenuMngList(request, menuBean);
		
    	 this.outputJSON(request, response, menu);
	 }
	 
}
