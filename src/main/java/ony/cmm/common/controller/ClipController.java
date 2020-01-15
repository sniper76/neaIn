package ony.cmm.common.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.CaseFormat;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.bean.CommonBean;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.ProgramBean;
import ony.cpes.internal.common.service.ProgramService;
import ony.framework.BaseConfig;
import ony.framework.BaseController;

@Controller
@RequestMapping("/clip")
public class ClipController extends BaseController {

	private static Log log = LogFactory.getLog(ClipController.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private ProgramService programService;

    @RequestMapping(value="/clip")
	public ModelAndView clipClip(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.setViewName("clip/Clip.all");
	  	return mv;
    }

    @RequestMapping(value="/test")
	public ModelAndView testClip(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.setViewName("clip/test.all");
	  	return mv;
    }
}
