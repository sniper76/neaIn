package ony.cpes.internal.common.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cpes.internal.common.bean.JobCenterBean;
import ony.cpes.internal.common.service.JobCenterService;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;



@RequestMapping("/internal/common")
@Controller
public class JobCenterController extends BaseController{

  private static Log log = LogFactory.getLog(JobCenterController.class);

  @Autowired
  private JobCenterService jobCenterService;

  @Autowired
  private CommonService CommonService;

  /**
   * inquiry of job center
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  	@RequestMapping("/selectJobCenterListAjax")
	public ModelAndView selectJobCenterListAjax(@ModelAttribute("jobCenterBean") JobCenterBean jobCenterBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView();

    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			jobCenterBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			jobCenterBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			jobCenterBean.setOrderColumn(orderColumn);
  			jobCenterBean.setLang(locale.getLanguage().toLowerCase());
  			JobCenterBean result = jobCenterService.selectJobCenterList(jobCenterBean);

  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", jobCenterBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;
	}

  	/**
     * view job center List
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/jobCenterList")
  	public String jobCenter(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	return "common/jobCenterList.all";
  	}

    /**
     * jobcenter update view open
     * @param JobCenterBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/jobcenterMod")
	public ModelAndView jobceterMod(@ModelAttribute("JobCenterBean") JobCenterBean JobCenterBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	//JobCenterBean.setUser(sessUser);

        String jcCd = JobCenterBean.getJcCd();
    	mv.addObject("jcCd",jcCd);
    	mv.addObject("userNm",sessUser.getUserNm());
    	mv.setViewName("common/jobCenterMod.all");

	  	return mv;
	}

    /**
     * jobcenter insert view open
     * @param JobCenterBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/jobcenterReg")
	public ModelAndView jobcenterReg(@ModelAttribute("JobCenterBean") JobCenterBean JobCenterBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	//JobCenterBean.setUser(sessUser);


    	mv.addObject("userNm",sessUser.getUserNm());
    	mv.setViewName("common/jobCenterReg.all");

	  	return mv;
	}

    /**
     * insert jobcenter
     * @param JobCenterBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertJobCenterAjax")
	public ModelAndView insertJobCenterAjax(@ModelAttribute("JobCenterBean") JobCenterBean JobCenterBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();

		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	JobCenterBean.setUser(sessUser);

		result = jobCenterService.insertJobCenter(JobCenterBean);

		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * select jobcenter detail
     * @param JobCenterBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectJobCenterDtlAjax")
	public ModelAndView selectJobCenterDtlAjax(@ModelAttribute("JobCenterBean") JobCenterBean JobCenterBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	JobCenterBean dtlList = new JobCenterBean();

    	dtlList = jobCenterService.selectJobCenterDtl(JobCenterBean);

    	mv.addObject("dtlList",dtlList);
    	mv.setViewName("jsonView");

	  	return mv;
	}

    /**
     * update job center
     * @param JobCenterBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateJobCenterAjax")
	public ModelAndView updateJobCenterAjax(@ModelAttribute("JobCenterBean") JobCenterBean JobCenterBean, @RequestParam MultipartFile uploadImgFile,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();

		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	JobCenterBean.setUser(sessUser);

    	JobCenterBean dtlList = jobCenterService.selectJobCenterDtl(JobCenterBean);
    	String fileSeq = CommonService.inserCommonFile(uploadImgFile, "", sessUser.getUserSeq(), dtlList.getFileGrpSeq());

    	JobCenterBean.setFileGrpSeq(fileSeq);
		result = jobCenterService.updateJobCenter(JobCenterBean);

		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * delete jobcenter
     * @param JobCenterBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteJobCenterDtlAjax")
	public ModelAndView deleteJobCenterDtlAjax(@ModelAttribute("JobCenterBean") JobCenterBean JobCenterBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();


		result = jobCenterService.deleteJobCenterDtl(JobCenterBean);

		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}

}
