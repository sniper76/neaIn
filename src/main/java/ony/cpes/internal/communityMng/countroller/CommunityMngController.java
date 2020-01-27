package ony.cpes.internal.communityMng.countroller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cpes.internal.communityMng.bean.CommunityMngBean;
import ony.cpes.internal.communityMng.service.CommunityMngService;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/community")
public class CommunityMngController extends BaseController {

	@Autowired
	private CommunityMngService communityMngService;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();

    	mv.setViewName("communityMng/communityMngList.all");

	  	return mv;
	}

	@RequestMapping("/selectBanworkIncludeListAjax")
	public ModelAndView selectBanworkIncludeListAjax(@ModelAttribute("CommunityMngBean") CommunityMngBean communityMngBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		communityMngBean.setLang(locale.getLanguage().toLowerCase());

		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			communityMngBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			communityMngBean.setOrderColumnSort(orderDir);

		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			communityMngBean.setOrderColumn(orderColumn);

  			CommunityMngBean result = communityMngService.selectBanwordIncludeList(communityMngBean);

  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", result.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

    	mv.setViewName("jsonView");
	  	return mv;
	}

	@RequestMapping("/detail")
	public ModelAndView detail(@ModelAttribute("CommunityMngBean") CommunityMngBean communityMngBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.addObject("param", communityMngBean);
		mv.addObject("result", communityMngService.selectCommunityDetail(communityMngBean));
    	mv.setViewName("communityMng/communityMngDetail.all");

	  	return mv;
	}

	@RequestMapping("/updateCommunityMngAgreeAjax")
	public ModelAndView updateCommunityMngAgreeAjax(@ModelAttribute("CommunityMngBean") CommunityMngBean communityMngBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.addObject("result", communityMngService.updateCommunityAgree(communityMngBean));
    	mv.setViewName("jsonView");

	  	return mv;
	}

}
