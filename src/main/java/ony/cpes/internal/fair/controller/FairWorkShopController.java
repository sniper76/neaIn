package ony.cpes.internal.fair.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.bean.FairWorkshopBean;
import ony.cpes.internal.fair.bean.FairWorkshopPatcptnBean;
import ony.cpes.internal.fair.service.FairMngService;
import ony.cpes.internal.fair.service.FairWorkshopService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/workshop")
public class FairWorkShopController extends BaseController {

	@Autowired
	private FairWorkshopService fairWorkshopService;

	@Autowired
	private FairMngService fairMngService;

	@Autowired
	private CommonService commonService;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("fair/workshopList.all");
  		return mv;
	}

	@RequestMapping("/selectWorkshopListAjax")
	public ModelAndView selectWorkshopListAjax(@ModelAttribute("FairWorkshopBean") FairWorkshopBean fairWorkshopBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

    	fairWorkshopBean.setLang(locale.getLanguage().toLowerCase());

		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			fairWorkshopBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			fairWorkshopBean.setOrderColumnSort(orderDir);

		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			fairWorkshopBean.setOrderColumn(orderColumn);

  			FairWorkshopBean result = fairWorkshopService.selectFairWorkshopList(fairWorkshopBean);

  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", result.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

		mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping("/workshopReg")
	public ModelAndView workshopReg(@ModelAttribute("FairWorkshopBean") FairWorkshopBean fairWorkshopBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.addObject("param", fairWorkshopBean);

		FairMngBean fairMngBean = new FairMngBean();
		fairMngBean.setFairSeq(fairWorkshopBean.getFairSeq());
		mv.addObject("fairInfo", fairMngService.selectJobFairMngDetail(fairMngBean));

		mv.setViewName("fair/workshopReg.all");
  		return mv;
	}

	@RequestMapping("/insertWorkshopAjax")
	public ModelAndView insertWorkshopAjax(@ModelAttribute("FairWorkshopBean") FairWorkshopBean fairWorkshopBean,
			@RequestParam MultipartFile thumFileImg, @RequestParam MultipartFile teacherPhoto1Img, @RequestParam MultipartFile teacherPhoto2Img,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		fairWorkshopBean.setRegUserSeq(sessUser.getUserSeq());
		fairWorkshopBean.setModUserSeq(sessUser.getUserSeq());

		String thumFileImgSeq = commonService.inserCommonFile(thumFileImg, "", sessUser.getUserSeq(), "");
		String teacherPhoto1ImgSeq = commonService.inserCommonFile(teacherPhoto1Img, "", sessUser.getUserSeq(), "");
		String teacherPhoto2ImgSeq = commonService.inserCommonFile(teacherPhoto2Img, "", sessUser.getUserSeq(), "");

		fairWorkshopBean.setWorkshopThumFileGrpSeq(thumFileImgSeq);
		fairWorkshopBean.setTeacherPhoto1FileGrpSeq(teacherPhoto1ImgSeq);
		fairWorkshopBean.setTeacherPhoto2FileGrpSeq(teacherPhoto2ImgSeq);

		mv.addObject("result", fairWorkshopService.insertFairWorkshop(fairWorkshopBean));

		mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping("/workshopMod")
	public ModelAndView workshopUpdate(@ModelAttribute("FairWorkshopBean") FairWorkshopBean fairWorkshopBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = workshopReg(fairWorkshopBean, locale, request, response);

		mv.addObject("result", fairWorkshopService.selectWorkshopDetail(fairWorkshopBean));

		mv.setViewName("fair/workshopMod.all");
  		return mv;
	}

	@RequestMapping("/updateWorkshopAjax")
	public ModelAndView updateWorkshopAjax(@ModelAttribute("FairWorkshopBean") FairWorkshopBean fairWorkshopBean,
			@RequestParam(required = false) MultipartFile thumFileImg,
			@RequestParam(required = false) MultipartFile teacherPhoto1Img,
			@RequestParam(required = false) MultipartFile teacherPhoto2Img,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		fairWorkshopBean.setModUserSeq(sessUser.getUserSeq());

		FairWorkshopBean detailBean = fairWorkshopService.selectWorkshopDetail(fairWorkshopBean);

		if(thumFileImg != null) {
			String thumFileImgSeq = commonService.inserCommonFile(thumFileImg, "", sessUser.getUserSeq(), detailBean.getWorkshopThumFileGrpSeq());
			fairWorkshopBean.setWorkshopThumFileGrpSeq(thumFileImgSeq);
		}
		if(teacherPhoto1Img != null) {
			String teacherPhoto1ImgSeq = commonService.inserCommonFile(teacherPhoto1Img, "", sessUser.getUserSeq(), detailBean.getTeacherPhoto1FileGrpSeq());
			fairWorkshopBean.setTeacherPhoto1FileGrpSeq(teacherPhoto1ImgSeq);
		}
		if(teacherPhoto2Img != null) {
			String teacherPhoto2ImgSeq = commonService.inserCommonFile(teacherPhoto2Img, "", sessUser.getUserSeq(), detailBean.getTeacherPhoto2FileGrpSeq());
			fairWorkshopBean.setTeacherPhoto2FileGrpSeq(teacherPhoto2ImgSeq);
		}

		mv.addObject("result", fairWorkshopService.updateFairWorkshop(fairWorkshopBean));

		mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping("/deleteWorkshopAjax")
	public ModelAndView deleteWorkshopAjax(@ModelAttribute("FairWorkshopBean") FairWorkshopBean fairWorkshopBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		fairWorkshopBean.setModUserSeq(sessUser.getUserSeq());
		mv.addObject("result", fairWorkshopService.deleteFairWorkshop(fairWorkshopBean));

		mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping("/workshopPatcptnList")
	public ModelAndView workshopPatcptnList(@ModelAttribute("FairWorkshopBean") FairWorkshopBean fairWorkshopBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		FairMngBean fairMngBean = new FairMngBean();
		fairMngBean.setFairSeq(fairWorkshopBean.getFairSeq());
		mv.addObject("fairMngInfo", fairMngService.selectJobFairMngDetail(fairMngBean));
		mv.addObject("fairWorkshopInfo", fairWorkshopService.selectWorkshopDetail(fairWorkshopBean));

		mv.setViewName("fair/workshopPatcptnList.all");
  		return mv;
	}

	@RequestMapping("/selectWorkshopPatcptnListAjax")
	public ModelAndView selectWorkshopPatcptnListAjax(@ModelAttribute("FairWorkshopPatcptnBean") FairWorkshopPatcptnBean fairWorkshopPatcptnBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		fairWorkshopPatcptnBean.setLang(locale.getLanguage().toLowerCase());

		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			fairWorkshopPatcptnBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			fairWorkshopPatcptnBean.setOrderColumnSort(orderDir);

		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			fairWorkshopPatcptnBean.setOrderColumn(orderColumn);

  			FairWorkshopPatcptnBean result = fairWorkshopService.selectWorkshopPatcptnList(fairWorkshopPatcptnBean);

  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", result.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

		mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping("/updateWorkshopPatcptnJcAgreeCdAjax")
	public ModelAndView updateWorkshopPatcptnJcAgreeCdAjax(@ModelAttribute("FairWorkshopPatcptnBean") FairWorkshopPatcptnBean fairWorkshopPatcptnBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		fairWorkshopPatcptnBean.setModUserSeq(sessUser.getUserSeq());
		mv.addObject("result", fairWorkshopService.updateWorkshopPatcptnJcAgreeCd(fairWorkshopPatcptnBean));

		mv.setViewName("jsonView");
  		return mv;
	}
}
