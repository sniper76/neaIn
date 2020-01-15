package ony.cpes.internal.bulletin.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.google.common.base.CaseFormat;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.bulletin.bean.BulletinMNGBean;
import ony.cpes.internal.bulletin.service.BulletinMNGService;
import ony.cpes.internal.bulletin.service.BulletinService;
import ony.cpes.internal.user.bean.UserBean;
import ony.framework.BaseController;


@RequestMapping("/internal/bulletin")
@Controller
public class BulletinController extends BaseController{

	private static Log log = LogFactory.getLog(BulletinController.class);

	@Autowired SessionLocaleResolver localeResolver;

	@Autowired
	private BulletinService BulletinService;

	@Autowired
	private BulletinMNGService bulletinMNGService;

	@Autowired
	private CommonService CommonService;

	@RequestMapping("/bulletinBasic")
	public String bulletin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String programId = request.getParameter("programId");
		if (programId != null) {
			String[] programIdArr = programId.split(",");
			if(programIdArr[0] != null) {
				programId = programIdArr[0];
			}
		}
		
		request.setAttribute("programId", programId);

		return "bulletin/bulletinBasic.all";
	}

	@RequestMapping("/bulletinAtch")
	public String bulletinAtch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String programId = request.getParameter("programId");
		if (programId != null) {
			String[] programIdArr = programId.split(",");
			if(programIdArr[0] != null) {
				programId = programIdArr[0];
			}
		}
		request.setAttribute("programId", programId);
		return "bulletin/bulletinAtch.all";
	}

	@RequestMapping("/bulletinFaq")
	public String bulletinFaq(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String programId = request.getParameter("programId");
		if (programId != null) {
			String[] programIdArr = programId.split(",");
			if(programIdArr[0] != null) {
				programId = programIdArr[0];
			}
		}
		request.setAttribute("programId", programId);
		return "bulletin/bulletinFaq.all";
	}

	@RequestMapping("/bulletinPhoto")
	public String bulletinPhoto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String programId = request.getParameter("programId");
		if (programId != null) {
			String[] programIdArr = programId.split(",");
			if(programIdArr[0] != null) {
				programId = programIdArr[0];
			}
		}
		request.setAttribute("programId", programId);
		return "bulletin/bulletinPhoto.all";
	}

	@RequestMapping("/bulletinThumb")
	public String bulletinThumb(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String programId = request.getParameter("programId");
		if (programId != null) {
			String[] programIdArr = programId.split(",");
			if(programIdArr[0] != null) {
				programId = programIdArr[0];
			}
		}
		request.setAttribute("programId", programId);
		return "bulletin/bulletinThumb.all";
	}

	@RequestMapping("/selectBulletinBasicListAjax")
	public ModelAndView selectBulletinBasicList(@ModelAttribute("BulletinBean") BulletinBean BulletinBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	String programId = BulletinBean.getProgramId();
		
    	if (programId != null) {
			String[] programIdArr = programId.split(",");
			if(programIdArr[0] != null) {
				BulletinBean.setProgramId(programIdArr[0]);
			}
		}
		
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			BulletinBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			BulletinBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			BulletinBean.setOrderColumn(orderColumn);
  			BulletinBean.setBulletinTypeCd(request.getParameter("bulletinTypeCd"));
  			BulletinBean result = BulletinService.selectBulletinList(BulletinBean);

  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", BulletinBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;


	}

	@RequestMapping("/bulletinBasicReg")
	public String bulletinBasicInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String programId = request.getParameter("programId");
		
		if (programId != null) {
			String[] programIdArr = programId.split(",");
			if(programIdArr[0] != null) {
				programId = programIdArr[0];
			}
		}
		
		request.setAttribute("programId", programId);

		BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		bulletinMNGBean.setProgramId(programId);
		request.setAttribute("bulletinMngInfo", bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean));

		return "bulletin/bulletinBasicReg.all";
	}

	@RequestMapping("/bulletinThumbReg")
	public String bulletinThumbInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		bulletinBasicInsert(request, response);
		return "bulletin/bulletinThumbReg.all";
	}

	@RequestMapping("/bulletinPhotoReg")
	public String bulletinPhotoInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		bulletinBasicInsert(request, response);
		return "bulletin/bulletinPhotoReg.all";
	}

	@RequestMapping("/bulletinAtchReg")
	public String bulletinAtchInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		bulletinBasicInsert(request, response);
		return "bulletin/bulletinAtchReg.all";
	}

	@RequestMapping("/bulletinFaqReg")
	public ModelAndView bulletinFaqInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		BulletinBean bulletin = new BulletinBean();

		String programId = request.getParameter("programId");
		
		if (programId != null) {
			String[] programIdArr = programId.split(",");
			if(programIdArr[0] != null) {
				programId = programIdArr[0];
			}
		}
		
		request.setAttribute("programId", programId);
		bulletin.setProgramId(programId);

		BulletinBean cate = BulletinService.selectBulletinCateList(bulletin);

		BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		bulletinMNGBean.setProgramId(programId);

		mv.addObject("cateList",cate.getList());
		mv.addObject("bulletinMngInfo", bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean));
		mv.setViewName("bulletin/bulletinFaqReg.all");
	  	return mv;
	}

	@RequestMapping("/selectUserInfoAjax")
	public ModelAndView selectUserInfoAjax(Locale locale,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> resInfo = new HashMap<String,Object>();
    	Map<String,Object> paramInfo = new HashMap<String,Object>();


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String lang = locale.getLanguage().toLowerCase();

        paramInfo.put("id", (String) authentication.getPrincipal());// 관리자 id
        paramInfo.put("lang", lang);

        String userNm = BulletinService.selectUserInfo(paramInfo);

    	mv.addObject("userNm",userNm);
    	mv.setViewName("jsonView");

	  	return mv;
	}

	@RequestMapping("/selectBulletinNotiCntAjax")
	public ModelAndView selectBulletinNotiCntAjax(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
        /*
    	* 조회 조건 수정 후 주석 처리 함 - 유승우
    	Map<String,Object> resInfo = new HashMap<String,Object>();
    	Map<String,Object> paramInfo = new HashMap<String,Object>();

        paramInfo.put("id", (String) request.getParameter("bulletinMngSeq"));// To-Do 게시판관리번호 임의셋팅 메뉴관리에서 가져올지 화면에서 넘겨올지 결정
        paramInfo.put("sysLangCd", request.getParameter("sysLangCd"));

        BulletinBean bulletinBean = BulletinService.selectBulletinNotiCnt(paramInfo);
        */
    	
    	
    	String lang = locale.getLanguage().toLowerCase();

    	bulletinBean.setLang(lang);
        BulletinBean result = BulletinService.selectBulletinNotiCnt(bulletinBean);

    	mv.addObject("notiCnt", result.getNotiCnt());
    	mv.setViewName("jsonView");

	  	return mv;
	}

	@RequestMapping("/selectBulletinConfAjax")
	public ModelAndView selectBulletinConfAjax(Locale locale,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> resInfo = new HashMap<String,Object>();
    	Map<String,Object> paramInfo = new HashMap<String,Object>();

    	String lang = locale.getLanguage().toLowerCase();


        paramInfo.put("id", (String) request.getParameter("programId"));// To-Do 게시판관리번호 임의셋팅 메뉴관리에서 가져올지 화면에서 넘겨올지 결정
        paramInfo.put("lang", lang);

        BulletinBean bulletinBean = BulletinService.selectBulletinConf(paramInfo);

    	mv.addObject("fileCnt",bulletinBean.getFileQty());
    	mv.addObject("fileSize",bulletinBean.getFileSize());
    	mv.addObject("fileYn",bulletinBean.getFileYn());
    	mv.setViewName("jsonView");

	  	return mv;
	}

	@RequestMapping("/insertBulletinBasicAjax")
	public ModelAndView insertBulletinBasicAjax(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,Locale locale,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();

		String lang = locale.getLanguage().toLowerCase();

		bulletinBean.setLang(lang);

		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	bulletinBean.setUser(sessUser);

    	String programId = bulletinBean.getProgramId();
		
    	if (programId != null) {
			String[] programIdArr = programId.split(",");
			if(programIdArr[0] != null) {
				bulletinBean.setProgramId(programIdArr[0]);
			}
		}
    	
		result = BulletinService.insertBulletinBasic(bulletinBean);

		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}

	@RequestMapping("/bulletinBasicDtl")
	public ModelAndView BulletinBasicDtl(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,Locale locale,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	BulletinBean dtlList = new BulletinBean();

    	String lang = locale.getLanguage().toLowerCase();
    	bulletinBean.setLang(lang);
    	
        String bulletinSeq = bulletinBean.getBulletinSeq();
        String programId = request.getParameter("programId");
        
		
        bulletinBean.setBulletinSeq(bulletinSeq);
        //dtlList = BulletinService.selectBulletinDtl(bulletinBean);

        BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		bulletinMNGBean.setProgramId(programId);

    	mv.addObject("dtlList",dtlList);
    	mv.addObject("programId", programId);
    	mv.addObject("bulletinSeq",bulletinSeq);
    	mv.addObject("bulletinMngInfo", bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean));
    	mv.addObject("bulletinInfo", BulletinService.selectBulletinDtl(bulletinBean));
    	mv.setViewName("bulletin/bulletinBasicMod.all");

	  	return mv;
	}

	@RequestMapping("/bulletinThumbDtl")
	public ModelAndView BulletinThumbDtl(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

        String bulletinSeq = bulletinBean.getBulletinSeq();
        String programId = request.getParameter("programId");

        BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		bulletinMNGBean.setProgramId(programId);

    	mv.addObject("programId", programId);
    	mv.addObject("bulletinSeq",bulletinSeq);
    	mv.addObject("bulletinMngInfo", bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean));
    	mv.addObject("bulletinInfo", BulletinService.selectBulletinDtl(bulletinBean));
    	mv.setViewName("bulletin/bulletinThumbMod.all");

	  	return mv;
	}

	@RequestMapping("/bulletinPhotoDtl")
	public ModelAndView BulletinPhotoDtl(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

        String bulletinSeq = bulletinBean.getBulletinSeq();
        String programId = request.getParameter("programId");

        BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		bulletinMNGBean.setProgramId(programId);

    	mv.addObject("programId", programId);
    	mv.addObject("bulletinSeq",bulletinSeq);
    	mv.addObject("bulletinMngInfo", bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean));
    	mv.addObject("bulletinInfo", BulletinService.selectBulletinDtl(bulletinBean));
    	mv.setViewName("bulletin/bulletinPhotoMod.all");

	  	return mv;
	}

	@RequestMapping("/bulletinAtchDtl")
	public ModelAndView BulletinAtchDtl(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

        String bulletinSeq = bulletinBean.getBulletinSeq();
        String programId = request.getParameter("programId");

        BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		bulletinMNGBean.setProgramId(programId);

    	mv.addObject("programId", programId);
    	mv.addObject("bulletinSeq",bulletinSeq);
    	mv.addObject("bulletinMngInfo", bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean));
    	mv.addObject("bulletinInfo", BulletinService.selectBulletinDtl(bulletinBean));
    	mv.setViewName("bulletin/bulletinAtchMod.all");

	  	return mv;
	}

	@RequestMapping("/bulletinFaqDtl")
	public ModelAndView BulletinFaqDtl(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

        String bulletinSeq = bulletinBean.getBulletinSeq();
        String programId = request.getParameter("programId");

        BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		bulletinMNGBean.setProgramId(programId);

    	mv.addObject("programId", programId);
    	mv.addObject("bulletinSeq",bulletinSeq);
    	mv.addObject("bulletinMngInfo", bulletinMNGService.selectBulletinMngByProgramId(bulletinMNGBean));
    	mv.addObject("bulletinInfo", BulletinService.selectBulletinDtl(bulletinBean));
    	mv.setViewName("bulletin/bulletinFaqMod.all");

	  	return mv;
	}

	@RequestMapping("/selectBulletinDtlAjax")
	public ModelAndView selectBulletinDtlAjax(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,Locale locale,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	BulletinBean dtlList = new BulletinBean();

    	String lang = locale.getLanguage().toLowerCase();
    	bulletinBean.setLang(lang);

    	dtlList = BulletinService.selectBulletinDtl(bulletinBean);


    	mv.addObject("dtlList",dtlList);
    	mv.setViewName("jsonView");

	  	return mv;
	}

	@RequestMapping("/deleteBulletinDtlAjax")
	public ModelAndView deleteBulletinDtlAjax(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,Locale locale,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();

    	String lang = locale.getLanguage().toLowerCase();
    	bulletinBean.setLang(lang);

    	// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	bulletinBean.setUser(sessUser);
    	bulletinBean.setDelYn("Y");

    	result = BulletinService.deleteBulletinDtl(bulletinBean);


    	mv.addObject("stat",result.get("stat"));
    	mv.addObject("msg",result.get("msg"));
    	mv.setViewName("jsonView");

	  	return mv;
	}

	@RequestMapping("/updateBulletinNotiAjax")
	public ModelAndView updateBulletinNotiAjax(@ModelAttribute("BulletinBean") BulletinBean bulletinBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();

    	// login user setting
    	bulletinBean.setLang(locale.getLanguage().toLowerCase());
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	bulletinBean.setUser(sessUser);

    	result = BulletinService.updateBulletinDtl(request, bulletinBean, locale);

    	mv.addObject("stat",result.get("stat"));
    	mv.addObject("msg",result.get("msg"));
    	mv.setViewName("jsonView");

	  	return mv;
	}

	@RequestMapping("/updateBulletinDtlAjax")
	public ModelAndView updateBulletinDtlAjax(@ModelAttribute("BulletinBean") BulletinBean bulletinBean,Locale locale,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();

    	String lang = locale.getLanguage().toLowerCase();
    	bulletinBean.setLang(lang);

    	// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	bulletinBean.setUser(sessUser);

    	result = BulletinService.updateBulletinDtl(request, bulletinBean, locale);


    	mv.addObject("stat",result.get("stat"));
    	mv.addObject("msg",result.get("msg"));
    	mv.setViewName("jsonView");

	  	return mv;
	}



}
