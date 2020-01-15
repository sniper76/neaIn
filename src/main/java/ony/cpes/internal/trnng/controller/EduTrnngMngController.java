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
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cpes.internal.trnng.service.EduTrnngMngService;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.trnng.bean.EduTrnngBean;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/trnng")
public class EduTrnngMngController extends BaseController {

	private static Log log = LogFactory.getLog(EduTrnngMngController.class);

	@Autowired
	private CommonService commonService;	
	
	@Autowired
	private EduTrnngMngService eduTrnngMngService;

    @RequestMapping(value="/eduTrnngProgramMng")
	public ModelAndView eduTrnngProgramMng(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();
    	
    	eduTrnngMngBean.setEduDivCd("EDC0000000002"); 		//일반교육
  		mv.addObject("EduTrnngMngBean", eduTrnngMngBean);  		
    	
    	mv.setViewName("trnng/eduTrnngProgramMng.all");

	  	return mv;
	}
    
    @RequestMapping(value="/selectMajorCodeListAjax")
	public ModelAndView selectMajorCodeList(@ModelAttribute("CommDtlCdBean") CommDtlCdBean commDtlCdBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

  		CommDtlCdBean majorCode = (CommDtlCdBean) eduTrnngMngService.selectInsttMajorCodeList(commDtlCdBean);
  		mv.addObject("result", majorCode.getList());

  		mv.setViewName("jsonView");
	  	
  		return mv;
	}
    
    @RequestMapping(value="/eduTrnngProgramMngDtl")
	public ModelAndView eduTrnngProgramMngDtl(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
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
    	
    	EduTrnngMngBean eduTrnngMng = (EduTrnngMngBean) eduTrnngMngService.selectEduTrnngDetail(eduTrnngMngBean);
    	
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
	  	
	  	commDtlCdBean.setCommGrpCdList(commGrpCdList);
  		
	  	CommDtlCdBean commCode = (CommDtlCdBean) commonService.selectCommCodeList(commDtlCdBean);

		CommDtlCdBean majorDtlCdBean = new CommDtlCdBean();
	  	CommDtlCdBean majorCode = (CommDtlCdBean) eduTrnngMngService.selectInsttMajorCodeList(majorDtlCdBean);
    	
  		mv.addObject("EduTrnngMngBean", eduTrnngMng);
  		mv.addObject("CommonCodeDtlBean", commCode.getList());  		
  		mv.addObject("MajorCodeDtlBean", majorCode.getList());	  	
    	
    	mv.setViewName("trnng/eduTrnngProgramMngDtl.all");

	  	return mv;
	}

    @RequestMapping(value="/selectEduTrnngProgramMngListAjax")
	public ModelAndView selectEduTrnngProgramMngList(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
  			EduTrnngMngBean result = (EduTrnngMngBean) eduTrnngMngService.selectEduTrnngList(eduTrnngMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", eduTrnngMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
  		return mv;
	}

    @RequestMapping(value="/updateEduTrnngProgramMngAjax")
	public ModelAndView updateEduTrnngProgramMng(@ModelAttribute("EduTrnngMngBean") EduTrnngMngBean eduTrnngMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
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

    	EduTrnngMngBean result = (EduTrnngMngBean) eduTrnngMngService.updateEduTrnng(eduTrnngMngBean);
  		
  		mv.addObject("result", result);
  		mv.setViewName("jsonView");
  		return mv;
	}
    
    @RequestMapping(value="/updateEduTrnngProgramMngArrayAjax")
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

    	EduTrnngMngBean result = (EduTrnngMngBean) eduTrnngMngService.updateEduTrnng(eduTrnngMngBean);
  		
  		mv.addObject("result", result);
  		mv.setViewName("jsonView");
  		return mv;
	}  
    
	/**
	 * Education Training Detail Info
	 * @param EduTrnngBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/selectEduTrnngDtlInfoAjax") 
    public ModelAndView selectEduTrnngDtlInfoAjax(@ModelAttribute("EduTrnngBean") EduTrnngBean eduTrnngBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	ModelAndView mv = new ModelAndView();
    	EduTrnngBean rtnData = new EduTrnngBean();

    	rtnData = eduTrnngMngService.selectEduTrnngDtlInfo(eduTrnngBean);
		
    	mv.addObject("rtnData", rtnData);
    	mv.setViewName("trnng/eduTrnngDtlInfo" + ".empty");
    	return mv;
	}    
    
}
