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
import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.bean.JobFairBean;
import ony.cpes.internal.fair.service.FairMngService;
import ony.cpes.internal.trnng.service.JobskPrepareMngService;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/fair")
public class FairMngController extends BaseController {

	private static Log log = LogFactory.getLog(FairMngController.class);

	@Autowired
	private CommonService commonService;		
	
	@Autowired
	private JobskPrepareMngService jobskPrepareMngService;
	
	@Autowired
	private FairMngService fairMngService;
	

	@RequestMapping(value="/jobFairMng")
	public ModelAndView jobFairMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();

    	CommDtlCdBean locCdBean = (CommDtlCdBean) fairMngService.selectLoc1DepthList();
    	mv.addObject("LocCdBean", locCdBean.getList());
  		
    	mv.setViewName("fair/jobFairMng.all");

	  	return mv;
	}
    
	@RequestMapping(value="/selectLOC1DepthListAjax")
	public ModelAndView selectLOC1DepthListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	CommDtlCdBean locCdBean = (CommDtlCdBean) fairMngService.selectLoc1DepthList();
    	mv.addObject("result", locCdBean.getList());
  		
  		mv.setViewName("jsonView");
	  	
  		return mv;
	} 
    
    @RequestMapping(value="/selectLOC2DepthListAjax")
	public ModelAndView selectLOC2DepthList(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		
    	CommDtlCdBean locCdBean = (CommDtlCdBean) jobskPrepareMngService.selectLOC2DepthList();
    	mv.addObject("result", locCdBean.getList());
  		
  		mv.setViewName("jsonView");
	  	
  		return mv;
	}    
    
    @RequestMapping(value="/selectJcCdListAjax")
	public ModelAndView selectMajorCodeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	JobCenterBean jcBean = new JobCenterBean();
    	jcBean = commonService.selectJcCodeList(jcBean);  		
  		mv.addObject("result", jcBean.getList());
  		
  		mv.setViewName("jsonView");
	  	
  		return mv;
	}
    
    @RequestMapping(value="/selectJobFairMngListAjax")
	public ModelAndView selectJobFairMngList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
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

  			if ("FAIR_DT".equals(orderColumn)) {
  				fairMngBean.setOrderColumn("FAIR_BGN_DT");
  			}
  			
  			if ("RECURMT_DT".equals(orderColumn)) {
  				fairMngBean.setOrderColumn("RECURMT_BGN_DT");
  			}
  			
  			
  			FairMngBean result = (FairMngBean) fairMngService.selectJobFairMngList(fairMngBean);
  			
  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  		
	  	mv.setViewName("jsonView");
  		return mv;
	}
   
    
    @RequestMapping(value="/selectJobFairListLayerAjax")
	public ModelAndView selectJobFairListLayer(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
        	fairMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairMngBean.setRegUserSeq("SYSTEM");
        	fairMngBean.setModUserSeq("SYSTEM");
        }
    	
  		fairMngBean.setLang(locale.getLanguage().toLowerCase());
		FairMngBean result = (FairMngBean) fairMngService.selectJobFairListLayer(fairMngBean);
	  	mv.addObject("list", result.getList());

	  	mv.setViewName("jsonView");
  		return mv;
	}    
    
    @RequestMapping(value= {"/jobFairMngDtl", "/jobFairMngReg"})
	public ModelAndView jobFairMngDtl(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {    	    	
    	ModelAndView mv = new ModelAndView();

    	
    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");
        
    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
        	fairMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairMngBean.setRegUserSeq("SYSTEM");
        	fairMngBean.setModUserSeq("SYSTEM");
        }

        fairMngBean.setLang(locale.getLanguage().toLowerCase());
        fairMngBean = (FairMngBean) fairMngService.selectJobFairMngDetail(fairMngBean);

        FairMngBean fairMngVo = new FairMngBean();
        fairMngVo.setUser(userMenu.getUser());
	  	fairMngVo.setFairStsCd("FAS0000000001");

		CommDtlCdBean commDtlCdBean = new CommDtlCdBean();
		List<String> commGrpCdList = new ArrayList<String>();
	  	
	  	commGrpCdList.add("FAIR_DIV_CD");
	  	commGrpCdList.add("FAIR_STS_CD");
	  	
	  	commDtlCdBean.setCommGrpCdList(commGrpCdList);
  		
	  	mv.addObject("FairMngBean", "jobFairMngDtl".equals(lastPath) ? fairMngBean  : fairMngVo );
	  	
	  	CommDtlCdBean commCode = (CommDtlCdBean) commonService.selectCommCodeList(commDtlCdBean);
	  	
  		mv.addObject("CommonCodeDtlBean", commCode.getList());  		
    	mv.addObject("lang",locale.getLanguage().toLowerCase());
    	mv.setViewName("fair/" + lastPath + ".all");

	  	return mv;
	}
    
	@RequestMapping(value="/insertJobFairMngAjax")
	public ModelAndView insertJobFairMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
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

    	FairMngBean result = (FairMngBean) fairMngService.insertJobFairMng(fairMngBean);
  		mv.addObject("result", result);

	  	mv.setViewName("jsonView");
	  	return mv;
	}
	
    
	@RequestMapping(value="/updateJobFairMngAjax")
	public ModelAndView updateJobFairMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
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

    	FairMngBean result = (FairMngBean) fairMngService.updateJobFairMng(fairMngBean);
  		mv.addObject("result", result);

	  	mv.setViewName("jsonView");
	  	return mv;
	}
	

	@RequestMapping(value="/deleteJobFairMngAjax")
	public ModelAndView deleteEduTrnngPreprareSkillMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        
    	FairMngBean result = (FairMngBean) fairMngService.deleteJobFairMng(fairMngBean);
  		
  		mv.addObject("result", result);
	  	mv.setViewName("jsonView");
	  	return mv;
	}
	
	/**\
	 * Job Fair Detail Info
	 * @param jobFairBean
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/selectJobFairDtlInfoAjax") 
    public ModelAndView selectJobFairDtlInfoAjax(@ModelAttribute("JobFairBean") JobFairBean jobFairBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	ModelAndView mv = new ModelAndView();
    	JobFairBean rtnData = new JobFairBean();
    	
    	jobFairBean.setLang(locale.getLanguage().toLowerCase());
    	rtnData = fairMngService.selectJobFairDtlInfo(jobFairBean);
		
    	mv.addObject("rtnData", rtnData);
    	mv.setViewName("fair/jobFairDtlInfo" + ".empty");
    	return mv;
	} 	
    
}
