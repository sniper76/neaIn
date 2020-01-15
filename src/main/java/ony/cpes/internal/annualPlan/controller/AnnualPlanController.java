package ony.cpes.internal.annualPlan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.annualPlan.bean.APIndicDataBean;
import ony.cpes.internal.annualPlan.bean.APYearBaseIndicBean;
import ony.cpes.internal.annualPlan.service.AnnualPlanService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;
import ony.framework.util.StringUtil;

@RequestMapping("/internal/annualPlan")
@Controller
public class AnnualPlanController extends BaseController {

	@Autowired
	private AnnualPlanService annualPlanService;

	@Autowired
	private CommonService commonService;

	@RequestMapping("/APList")
	public ModelAndView APlist(@ModelAttribute("LmiYearBaseIndicBean") APYearBaseIndicBean APYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		if(!StringUtil.isEmpty(APYearBaseIndicBean.getYear()) && !StringUtil.isEmpty(APYearBaseIndicBean.getTitle())) {
			mv.addObject("resultList", annualPlanService.selectAnnualPlanList(APYearBaseIndicBean));
			mv.addObject("param", APYearBaseIndicBean);
		}

		mv.setViewName("annualPlan/APList" + ".all");
		return mv;
	}

	@RequestMapping("/insertAPForm")
	public ModelAndView insertAPForm(@ModelAttribute("LmiYearBaseIndicBean") APYearBaseIndicBean APYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		if(!StringUtil.isEmpty(APYearBaseIndicBean.getYear()) && !StringUtil.isEmpty(APYearBaseIndicBean.getTitle())) {
			mv.addObject("resultList", annualPlanService.selectAnnualPlanList(APYearBaseIndicBean));
		}

		mv.addObject("param", APYearBaseIndicBean);
		mv.setViewName("annualPlan/APInsert" + ".all");
		return mv;
	}

	@RequestMapping("/selectAPDepthListAjax")
	public ModelAndView selectAPDepthListAjax(@ModelAttribute("APYearBaseIndicBean") APYearBaseIndicBean APYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.addObject("result", annualPlanService.selectAPDepthList(APYearBaseIndicBean));

		mv.setViewName("jsonView");
		return mv;
	}

	@RequestMapping("/insertAPAJax")
	public ModelAndView insertAPAJax(@ModelAttribute("APYearBaseIndicBean") APYearBaseIndicBean APYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		APYearBaseIndicBean.setRegUserSeq(sessUser.getUserSeq());
		APYearBaseIndicBean.setModUserSeq(sessUser.getUserSeq());
		mv.addObject("result", annualPlanService.insertAnnualPlan(APYearBaseIndicBean));
		mv.addObject("param", APYearBaseIndicBean);

		mv.setViewName("jsonView");
		return mv;
	}

	@RequestMapping("/insertAPIndicDataForm")
	public ModelAndView insertAPIndicDataForm(@ModelAttribute("APYearBaseIndicBean") APYearBaseIndicBean APYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("jobCenter", commonService.selectJobCenterListForSelectBox());

		if(!StringUtil.isEmpty(APYearBaseIndicBean.getYear()) && !StringUtil.isEmpty(APYearBaseIndicBean.getTitle())) {
			List<APYearBaseIndicBean> resultList = annualPlanService.selectAnnualPlanList(APYearBaseIndicBean);
			annualPlanService.selectAPIndicDataList(resultList, APYearBaseIndicBean);
			mv.addObject("resultList", resultList);
		}

		mv.addObject("param", APYearBaseIndicBean);
		mv.setViewName("annualPlan/APIndicDataInsert" + ".all");
		return mv;
	}

	@RequestMapping("/insertAPIndicDataAjax")
	public ModelAndView insertAPIndicDataAjax(@ModelAttribute("APIndicDataBean") APIndicDataBean APIndicDataBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		APIndicDataBean.setRegUserSeq(sessUser.getUserSeq());
		APIndicDataBean.setModUserSeq(sessUser.getUserSeq());
		mv.addObject("result", annualPlanService.insertAPIndicData(APIndicDataBean));

		mv.setViewName("jsonView");
		return mv;
	}

	@RequestMapping("/insertAPIndicDataResultForm")
	public ModelAndView insertAPIndicDataResultForm(@ModelAttribute("APYearBaseIndicBean") APYearBaseIndicBean APYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = insertAPIndicDataForm(APYearBaseIndicBean, request, response);

		mv.setViewName("annualPlan/APIndicDataResultInsert" + ".all");
		return mv;
	}

	@RequestMapping("/APIndicDataResultListForm")
	public ModelAndView APIndicDataResultListForm(@ModelAttribute("APYearBaseIndicBean") APYearBaseIndicBean APYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = insertAPIndicDataForm(APYearBaseIndicBean, request, response);

		mv.setViewName("annualPlan/APIndicDataResultList" + ".all");
		return mv;
	}

}
