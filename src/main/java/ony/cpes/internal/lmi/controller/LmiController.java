package ony.cpes.internal.lmi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.lmi.bean.LmiIndicDataBean;
import ony.cpes.internal.lmi.bean.LmiYearBaseIndicBean;
import ony.cpes.internal.lmi.service.LmiService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;
import ony.framework.util.StringUtil;

@RequestMapping("/internal/lmi")
@Controller
public class LmiController extends BaseController {
	private static Log log = LogFactory.getLog(LmiController.class);

	@Autowired
	private LmiService lmiService;

	@Autowired
	private CommonService commonService;

	@RequestMapping("/insertLmiForm")
	public ModelAndView insertLmiForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("lmi/lmiInsert" + ".all");
		return mv;
	}

	@RequestMapping("/selectLmiDepthListAjax")
	public ModelAndView selectLmiDepthListAjax(@ModelAttribute("LmiYearBaseIndicBean") LmiYearBaseIndicBean lmiYearBaseIndicBean,
	HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.addObject("result", lmiService.selectLmiDepthList(lmiYearBaseIndicBean));

		mv.setViewName("jsonView");
		return mv;
	}

	@RequestMapping("/insertLmiAjax")
	public ModelAndView insertLmiAjax(@ModelAttribute("LmiYearBaseIndicBean") LmiYearBaseIndicBean lmiYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		lmiYearBaseIndicBean.setRegUserSeq(sessUser.getUserSeq());
		lmiYearBaseIndicBean.setModUserSeq(sessUser.getUserSeq());
		mv.addObject("result", lmiService.insertLmi(lmiYearBaseIndicBean));

		mv.setViewName("jsonView");
		return mv;
	}

	@RequestMapping("/insertLmiDataForm")
	public ModelAndView insertLmiDataForm(@ModelAttribute("LmiYearBaseIndicBean") LmiYearBaseIndicBean lmiYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		if(!StringUtil.isEmpty(lmiYearBaseIndicBean.getYear())) {
			mv.addObject("resultList", lmiService.selectLmiDataList(lmiYearBaseIndicBean));
			mv.addObject("year", lmiYearBaseIndicBean.getYear());
		}

		mv.setViewName("lmi/lmiDataInsert" + ".all");
		return mv;
	}

	@RequestMapping("/insertLmiDataAjax")
	public ModelAndView insertLmiDataAjax(@ModelAttribute("LmiIndicDataBean") LmiIndicDataBean lmiIndicDataBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		lmiIndicDataBean.setRegUserSeq(sessUser.getUserSeq());
		lmiIndicDataBean.setModUserSeq(sessUser.getUserSeq());

		mv.addObject("result", lmiService.insertLmiIndicData(lmiIndicDataBean));

		mv.setViewName("jsonView");
		return mv;
	}

	@RequestMapping("/selectLmiDetailForm")
	public ModelAndView selectLmiDetailForm(@ModelAttribute("LmiYearBaseIndicBean") LmiYearBaseIndicBean lmiYearBaseIndicBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		if(!StringUtil.isEmpty(lmiYearBaseIndicBean.getYear())) {
			mv.addObject("resultList", lmiService.selectLmiDataList(lmiYearBaseIndicBean));
			mv.addObject("year", lmiYearBaseIndicBean.getYear());
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String currentYear = sdf.format(new Date());
			lmiYearBaseIndicBean.setYear(currentYear);
			mv.addObject("resultList", lmiService.selectLmiDataList(lmiYearBaseIndicBean));
			mv.addObject("year", currentYear);
		}

		mv.setViewName("lmi/lmiList" + ".all");
		return mv;
	}

}
