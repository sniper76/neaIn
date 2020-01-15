package ony.cmm.common.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import ony.cmm.common.bean.FileBean;
import ony.cmm.common.bean.IscoBean;
import ony.cmm.common.bean.LocationBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.ProgramBean;
import ony.cpes.internal.common.service.ProgramService;
import ony.framework.BaseConfig;
import ony.framework.BaseController;
import ony.framework.util.StringUtil;

@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	private static Log log = LogFactory.getLog(CommonController.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private ProgramService programService;

    @RequestMapping(value="/selectCommCodeListAjax")
	public ModelAndView selectCommCd(@ModelAttribute("CommDtlCdBean") CommDtlCdBean commDtlCdBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();

  		if ( commDtlCdBean.getCommGrpCdList().size() > 0 ) {
  	  		List<String> commGrpCdList = new ArrayList<String>();
  			commGrpCdList.addAll(commDtlCdBean.getCommGrpCdList());
  			commGrpCdList.replaceAll(e -> CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, e));
  			commDtlCdBean.setCommGrpCdList(commGrpCdList);
  		}

  		CommDtlCdBean result = (CommDtlCdBean) commonService.selectCommCodeList(commDtlCdBean);
  		mv.addObject("result", result.getList());

  		mv.setViewName("jsonView");
	  	return mv;
	}


    @RequestMapping(value="/selectLocList")
	public ModelAndView selectLocList(@ModelAttribute("LocationBean") LocationBean locationBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.setViewName("common/locList.empty");
	  	return mv;
    }

    @RequestMapping(value="/selectLocListAjax")
	public ModelAndView selectLocListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		LocationBean locationBean = (LocationBean) getObjectFromJSON(request, LocationBean.class);

  		if (locationBean.getCountryId() == null || "".equals(locationBean.getCountryId()))
  			locationBean.setCountryId("1");

  		if (locationBean.getLvl() == null || "".equals(locationBean.getLvl()))
  			locationBean.setLvl("2");

  		LocationBean result = (LocationBean) commonService.selectLoction(locationBean);
  		mv.addObject("data", result);

  		mv.setViewName("jsonView");
	  	return mv;
	}

    @RequestMapping(value="/selectIscoList")
	public ModelAndView selectIscoList(@ModelAttribute("IscoBean") IscoBean iscoBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.setViewName("common/iscoList.empty");
	  	return mv;
    }

    @RequestMapping(value="/selectIscoListAjax")
	public ModelAndView selectIscoListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		IscoBean iscoBean = (IscoBean) getObjectFromJSON(request, IscoBean.class);

  		if (iscoBean.getCdLvl() == null || "".equals(iscoBean.getCdLvl()))
  		{
  			int lvl = Integer.parseInt(iscoBean.getCdLvl());
  			iscoBean.setCdLvl(String.valueOf(lvl++));
  		}

  		IscoBean result = (IscoBean) commonService.selectIscoCd(iscoBean);
  		mv.addObject("data", result);

  		mv.setViewName("jsonView");
	  	return mv;
    }


    @RequestMapping(value="/selectProgramLayerList")
	public ModelAndView selectProgramLayerList(@ModelAttribute("ProgramBean") ProgramBean programBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

  		mv.setViewName("common/programLayerList.empty");

	  	return mv;
    }

    @RequestMapping(value="/selectProgramLayerListAjax")
	public ModelAndView selectProgramLayerListAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		ModelAndView mv = new ModelAndView();
  		ProgramBean programBean = (ProgramBean) getObjectFromJSON(request, ProgramBean.class);

  		ProgramBean result = new ProgramBean();

  		if (programBean != null) {
  			programBean.setStart(0);
  			programBean.setLength(9999);
  			programBean.setUseYn("Y");
  			result = (ProgramBean) programService.selectProgramMngList(programBean);
  		}

  		mv.addObject("data", result);

  		mv.setViewName("jsonView");
	  	return mv;
    }

	@RequestMapping(value="/viewCommonPopup")
	public ModelAndView viewIscoPopup(Principal principal,
		@ModelAttribute("CommonBean") CommonBean commonBean, HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView();

		if("isco".equals(commonBean.getFlag())) {
			mv.addObject("result", commonService.selectIscoCdList(commonBean));
		}

		mv.addObject("flag", commonBean.getFlag());
		mv.setViewName("common/iscoListLayer.empty");
		return mv;
	}

	@RequestMapping(value="/nextDepthCdSelectAjax")
	public ModelAndView selectIscoCdAjax(Locale locale, @ModelAttribute("CommonBean") CommonBean commonBean,
			Principal principal,HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView();

		if("isco".equals(commonBean.getFlag())) {
			mv.addObject("result", commonService.selectIscoCdList(commonBean));
		}

		mv.setViewName("jsonView");
		return mv;
	}

	/**
	 * ckeditor 이미지 업로드
	 *
	 * 파일은 MultipartFile 타입의 upload 란 이름으로 ckeditor에서 넘어옴
	 *
	 * @param request
	 * @param response
	 * @param upload
	 */
	@RequestMapping(value = "/ckeditorImgUpload", method = RequestMethod.POST)
	public void ckeditorImgUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) throws IOException {
        PrintWriter printWriter = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        try{

        	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            String fileName = upload.getOriginalFilename();
            String uploadPath = BaseConfig.getValue("ckeditorImgDir") + BaseConfig.getValue("SEPARATOR") + sdf.format(new Date());//저장경로

            // 폴더 생성
            File fDir = new File(uploadPath);

            if (!fDir.exists()) {
    			fDir.mkdirs();
    		}

            File destFile = new File(uploadPath, fileName);
            upload.transferTo(destFile);

            String callback = request.getParameter("CKEditorFuncNum");

            printWriter = response.getWriter();
            String fileUrl = uploadPath + BaseConfig.getValue("SEPARATOR") + fileName;

            printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
                    + callback
                    + ",'"
                    + "/common/imgLoading.do?url=" + fileUrl
                    + "','img upload complete.'"
                    + ")</script>");
            printWriter.flush();

        }catch(IOException e){
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
			    printWriter.close();
			}
        }
	}

	@RequestMapping("/selectDext5upload")
	public ModelAndView selectDext5upload(@ModelAttribute("FileBean") FileBean fileBean,
			Principal principal,HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView();

		List<FileBean> fileList = commonService.selectAttachFilesList(fileBean);

		mv.addObject("result", fileList);
		mv.setViewName("jsonView");
		return mv;
	}

	/**
	 * 이미지 로딩 (화면 출력)
	 * @param request
	 * @param response
	 * @param url
	 * @throws IOException
	 */
	@RequestMapping(value = "/imgLoading", method = RequestMethod.GET)
	public void imgLoading(HttpServletRequest request, HttpServletResponse response, @RequestParam String url) throws IOException {

		if(!StringUtil.isEmpty(url)) {
			String ext = url.split("[.]")[1];

			BufferedOutputStream out = null;
			InputStream in = null;

			try {
				response.setContentType("image/" + ext);
				File file = new File(url);
				if(file.exists()){
					in = new FileInputStream(file);
					out = new BufferedOutputStream(response.getOutputStream());
					int len;
					byte[] buf = new byte[1024];
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(out != null){ out.flush(); }
				if(out != null){ out.close(); }
				if(in != null){ in.close(); }
			}
		}
	}

}
