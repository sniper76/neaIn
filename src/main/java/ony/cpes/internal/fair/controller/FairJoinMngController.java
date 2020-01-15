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
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.UserMenuBean;
import ony.cpes.internal.fair.bean.FairMngBean;
import ony.cpes.internal.fair.service.FairJoinMngService;
import ony.cpes.internal.trnng.bean.EduTrnngMngBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;

@Controller
@RequestMapping("/internal/fair")
public class FairJoinMngController extends BaseController {

	private static Log log = LogFactory.getLog(FairJoinMngController.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private FairJoinMngService fairJoinMngService;


	@RequestMapping(value="/jobFairJoinSts")
	public ModelAndView jobFairMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.setViewName("fair/jobFairJoinSts.all");

	  	return mv;
	}

    @RequestMapping(value="/selectJobFairJoinStsListAjax")
	public ModelAndView selectJobFairJoinStsList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
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

  			FairMngBean result = (FairMngBean) fairJoinMngService.selectJobFairJoinStsList(fairMngBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
  		return mv;
	}


    @RequestMapping(value="/fairListLayer")
	public ModelAndView fairListLayer(@ModelAttribute("LocationBean") LocationBean locationBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

		CommDtlCdBean commDtlCdBean = new CommDtlCdBean();
		List<String> commGrpCdList = new ArrayList<String>();
	  	commGrpCdList.add("FAIR_DIV_CD");
	  	commDtlCdBean.setCommGrpCdList(commGrpCdList);
	  	CommDtlCdBean commCode = (CommDtlCdBean) commonService.selectCommCodeList(commDtlCdBean);
  		mv.addObject("CommonCodeDtlBean", commCode.getList());

    	mv.setViewName("common/fairList.empty");
	  	return mv;
    }

	@RequestMapping(value="/privateUserJoinMng")
	public ModelAndView jobFairPrivateJoinMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

        fairMngBean.setMstJcCd(userMenu.getUser().getJcCd());
        mv.addObject("FairMngBean", fairMngBean);

    	mv.setViewName("fair/privateUserJoinMng.all");

	  	return mv;
	}

    @RequestMapping(value="/selectPrivateUserJoinMngListAjax")
	public ModelAndView selectPrivateUserJoinList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
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

  			FairMngBean result = (FairMngBean) fairJoinMngService.selectPrivateUserJoinMngList(fairMngBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping(value="/updatePrivateUserJoinMngAjax")
	public ModelAndView updatePrivateUserJoinMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
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

    	FairMngBean result = (FairMngBean) fairJoinMngService.updatePrivateUserJoinMng(fairMngBean);
  		mv.addObject("result", result);

	  	mv.setViewName("jsonView");
	  	return mv;
	}

	@RequestMapping(value={"/compnyTotalMng", "/insttTotalMng"})
	public ModelAndView compnyTotalMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

    	mv.setViewName("fair/" + lastPath + ".all");
	  	return mv;
	}

	@RequestMapping(value={"/compnyJoinMng", "/compnyRequestMng", "/compnyInviteMng"})
	public ModelAndView inviteCompnyMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

    	mv.addObject("fairMngBean", fairMngBean);
    	mv.setViewName("fair/" + lastPath + ".all");
	  	return mv;
	}

	@RequestMapping(value={"/selectCompnyJoinMngListAjax", "/selectCompnyRequestMngListAjax", "/selectCompnyInviteMngListAjax"})
	public ModelAndView selectCompnyMngList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

  		if (lastPath.equals("selectCompnyJoinMngListAjax")) {
  			fairMngBean.setFairMngDiv("JOIN");
  		} else if (lastPath.equals("selectCompnyRequestMngListAjax")) {
  			fairMngBean.setFairMngDiv("REQUEST");
  		} else {
  			fairMngBean.setFairMngDiv("INVITE");
  		}

  		fairMngBean.setCompnyInsttDivCd("CIDC000000001");

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

  			FairMngBean result = (FairMngBean) fairJoinMngService.selectCompnyMngList(fairMngBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping(value={"/inviteCompnyListLayer", "/inviteInsttListLayer"})
	public ModelAndView inviteCompnyList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

    	fairMngBean.setJcAgreeStsCd("JAS0000000002");
    	fairMngBean.setCompnyRespYn("N");
    	fairMngBean.setInsttRespYn("N");
    	fairMngBean.setInviteYn("Y");
    	mv.addObject("FairMngBean", fairMngBean);

    	if ("inviteCompnyListLayer".equals(lastPath)) {
        	mv.setViewName("common/inviteCompnyList.empty");
    	} else {
        	mv.setViewName("common/inviteInsttList.empty");
    	}

    	return mv;
	}

    @RequestMapping(value={"/selectInviteCompnyListAjax", "/selectInviteInsttListAjax"})
	public ModelAndView selectInviteCompnyList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
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

  	  		FairMngBean result = null;
  	  		if (lastPath.equals("selectInviteCompnyListAjax")) {
  	  			result = (FairMngBean) fairJoinMngService.selectInviteCompnyList(fairMngBean);
  	  		} else {
  	  			result = (FairMngBean) fairJoinMngService.selectInviteInsttList(fairMngBean);
  	  		}

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
  		return mv;
	}

    @RequestMapping(value={"/insertInviteCompnyArrayAjax", "/insertInviteInsttArrayAjax"})
	public ModelAndView insertInviteArray(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

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

  		FairMngBean result = null;
	  	if (lastPath.equals("insertInviteCompnyArrayAjax")) {
  	  		result = (FairMngBean) fairJoinMngService.insertInviteCompny(fairMngBean);
  	  	} else {
  	  		result = (FairMngBean) fairJoinMngService.insertInviteInstt(fairMngBean);
  	  	}

  		mv.addObject("result", result);
  		mv.setViewName("jsonView");
  		return mv;
	}

    @RequestMapping(value={"/updateCompnyRequestMngAjax", "/updateInsttRequestMngAjax"})
	public ModelAndView updateCompnyRequestMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

    	HttpSession session = request.getSession();
        UserMenuBean userMenu = (UserMenuBean)session.getAttribute("sessUser");

    	if (userMenu != null) {
        	fairMngBean.setUser(userMenu.getUser());
        	fairMngBean.setModUserSeq(userMenu.getUser().getUserSeq());
        	fairMngBean.setJcAgreeUserSeq(userMenu.getUser().getUserSeq());
        } else {
        	fairMngBean.setRegUserSeq("SYSTEM");
        	fairMngBean.setModUserSeq("SYSTEM");
        }
  		fairMngBean.setLang(locale.getLanguage().toLowerCase());

  		FairMngBean result = null;
	  	if (lastPath.equals("updateCompnyRequestMngAjax")) {
  	  		result = (FairMngBean) fairJoinMngService.updateCompnyRequestMng(fairMngBean);
  	  	} else {
  	  		result = (FairMngBean) fairJoinMngService.updateInsttRequestMng(fairMngBean);
  	  	}

  		mv.addObject("result", result);
  		mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping(value={"/insttJoinMng", "/insttRequestMng", "/insttInviteMng"})
	public ModelAndView inviteInsttMng(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

    	mv.setViewName("fair/" + lastPath + ".all");
	  	return mv;
	}


	@RequestMapping(value={"/selectInsttJoinMngListAjax", "/selectInsttRequestMngListAjax", "/selectInsttInviteMngListAjax"})
	public ModelAndView selectInsttMngList(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

  		if (lastPath.equals("selectInsttJoinMngListAjax")) {
  			fairMngBean.setFairMngDiv("JOIN");
  		} else if (lastPath.equals("selectInsttRequestMngListAjax")) {
  			fairMngBean.setFairMngDiv("REQUEST");
  		} else {
  			fairMngBean.setFairMngDiv("INVITE");
  		}

  		fairMngBean.setCompnyInsttDivCd("CIDC000000002");

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

  			FairMngBean result = (FairMngBean) fairJoinMngService.selectInsttMngList(fairMngBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", fairMngBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping(value = "/searchCoInvitation")
	public ModelAndView searchCoInvitation(@ModelAttribute("FairMngBean") FairMngBean fairMngBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

  		List<FairMngBean> result = fairJoinMngService.selectCoInvitationList(fairMngBean);

  		mv.addObject("result", result);
		mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping("/insertFairPatcptnCompny")
	public ModelAndView insertFairPatcptnCompny(@ModelAttribute("FairMngBean") FairMngBean fairMngBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		fairMngBean.setRegUserSeq(sessUser.getUserSeq());
		fairMngBean.setModUserSeq(sessUser.getUserSeq());
		mv.addObject("result", fairJoinMngService.insertFairPatcptnCompny(fairMngBean));

		mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping("/searchInsttInvitation")
	public ModelAndView searchInsttInvitation(@ModelAttribute("FairMngBean") FairMngBean fairMngBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

  		List<FairMngBean> result = fairJoinMngService.selectInsttInvitationList(fairMngBean);

  		mv.addObject("result", result);
		mv.setViewName("jsonView");
  		return mv;
	}

	@RequestMapping("/insertFairPatcptnInstt")
	public ModelAndView insertFairPatcptnInstt(@ModelAttribute("FairMngBean") FairMngBean fairMngBean,
			Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		UserBean sessUser = (UserBean) commonService.selectCommonUserDtlInfo();
		fairMngBean.setRegUserSeq(sessUser.getUserSeq());
		fairMngBean.setModUserSeq(sessUser.getUserSeq());
		mv.addObject("result", fairJoinMngService.insertFairPatcptnInstt(fairMngBean));

		mv.setViewName("jsonView");
  		return mv;
	}

}
