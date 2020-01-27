package ony.cpes.internal.iscoMng.controller;

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

import ony.cmm.common.bean.CommonBean;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.communityMng.bean.CommunityMngBean;
import ony.cpes.internal.iscoMng.service.IscoMngService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/iscoMng")
public class IscoMngController extends BaseController {

	@Autowired
	private IscoMngService iscoMngService;

	@Autowired
	private CommonService commonService;

	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView mv = new ModelAndView();

		CommonBean commonBean = new CommonBean();
		mv.addObject("depth1List", commonService.selectIscoCdList(commonBean));
    	mv.setViewName("iscoMng/iscoMngList.all");

	  	return mv;
	}

	@RequestMapping("/selectIscoMngListAjax")
	public ModelAndView selectIscoMngListAjax(@ModelAttribute("IscoBean") IscoBean iscoBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		iscoBean.setLang(locale.getLanguage().toLowerCase());

		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			iscoBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			iscoBean.setOrderColumnSort(orderDir);

		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			iscoBean.setOrderColumn(orderColumn);

  			IscoBean result = iscoMngService.selectIscoMngList(iscoBean);

  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", result.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

    	mv.setViewName("jsonView");
	  	return mv;
	}

	@RequestMapping("/detail")
	public ModelAndView detail(@ModelAttribute("IscoBean") IscoBean iscoBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.addObject("result", iscoMngService.selectIscoMngDetail(iscoBean));
    	mv.setViewName("iscoMng/iscoMngDetail.all");

	  	return mv;
	}

	@RequestMapping("/updateIscoMngAjax")
	public ModelAndView updateIscoMngAjax(@ModelAttribute("IscoBean") IscoBean iscoBean, @RequestParam(required = false) MultipartFile uploadImgFile,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		iscoBean.setModUserSeq(sessUser.getUserSeq());
		iscoBean.setDetailIscoCd(iscoBean.getIscoCd());
		IscoBean detailIscoBean = iscoMngService.selectIscoMngDetail(iscoBean);

		if(uploadImgFile != null) {
			String fileSeq = commonService.inserCommonFile(uploadImgFile, "", sessUser.getUserSeq(), detailIscoBean.getThumbFileGrpSeq());
			iscoBean.setThumbFileGrpSeq(fileSeq);
		}

		mv.addObject("result", iscoMngService.updateIscoMng(iscoBean));
    	mv.setViewName("jsonView");

	  	return mv;
	}

}
