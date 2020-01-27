package ony.cpes.internal.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.google.common.base.CaseFormat;

import ony.cmm.common.service.CommonService;
import ony.cpes.internal.counsel.bean.CounselBean;
import ony.cpes.internal.user.bean.UserBean;
import ony.cpes.internal.user.bean.UserElementaryBean;
import ony.cpes.internal.user.bean.UserElementaryIntvwBean;
import ony.cpes.internal.user.service.UserElementaryService;
import ony.framework.BaseConfig;
import ony.framework.BaseController;
import ony.framework.util.Encryption;


@RequestMapping("/internal/user")
@Controller
public class UserElementaryController extends BaseController{

	private static Log log = LogFactory.getLog(UserElementaryController.class);

	@Autowired
	private CommonService CommonService;

	@Autowired
	private UserElementaryService userElementaryService;
	
	@Autowired MessageSource messageSource;

	@Autowired SessionLocaleResolver localeResolver;

	/**
	 * Screen Elementary Job Seeker
	 * @param UserElementaryBean
	 * @param UserElementaryBean
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/userElementaryInfoList")
	public String userList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "user/userElementaryInfoList.all";
	}

    /**
     * get Elementary Job Seeker List Ajax
     * @param userElementaryBean
     * @param locale
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserElementaryInfoListAjax")
	public ModelAndView selectUserElementaryInfoListAjax(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

  		ModelAndView mv = new ModelAndView();
  		userElementaryBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			userElementaryBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userElementaryBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userElementaryBean.setOrderColumn(orderColumn);

  			UserElementaryBean result = (UserElementaryBean) userElementaryService.selectUserElementaryInfoList(userElementaryBean, request);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userElementaryBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
	  	return mv;
	}
    
	/**
	 * User Info Excel Registration
	 * @param UserElementaryBean
	 * @param UserElementaryBean
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/userElementaryExcelReg")
	public String userElementaryExcelReg(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "user/userElementaryExcelReg.all";
	}
    
    /**
     * Upload User Information By Excel
     * @param UserElementaryBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"deprecation", "resource"})
    @RequestMapping(value="/insertUserInfoByExcel")
    public ModelAndView insertUserInfoByExcel(MultipartHttpServletRequest multiRequest, Locale locale, HttpServletRequest request, HttpServletResponse response ) throws Exception {
    	
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
    	MultipartFile resumeExcelFile = ((MultipartRequest) request).getFile("resumeExcelFile");
    	List<Map<String, Object>> userInfoList = new ArrayList<Map<String, Object>>();
    	UserElementaryBean rtnParam = new UserElementaryBean();
        
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
        String loginUserJcCd = sessUser.getJcCd();
        String loginUser = sessUser.getUserSeq();
        
    	String encUserEmail = "";
    	String encUserCell = "";
    	String encUserPasswd = "";
    	
        if(resumeExcelFile==null || resumeExcelFile.isEmpty()){
            throw new RuntimeException("Please, Select Excel File");
        }
        
        String uploadPath = BaseConfig.getValue("fileUploadDir") + "\\";
        // create folder
        File fDir = new File(uploadPath);

        if (!fDir.exists()) {
			fDir.mkdirs();
		}
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        
        String fileName = resumeExcelFile.getOriginalFilename(); 
        String[] arrFileExtension = fileName.split("\\.");
        String fileExtension = arrFileExtension[arrFileExtension.length - 1];
        String orginalFileName = arrFileExtension[0];
        fileExtension = fileExtension.toUpperCase();
        
        //File destFile = new File(uploadPath + resumeExcelFile.getOriginalFilename());
        File destFile = new File(uploadPath + orginalFileName + "_" + sdf.format(new Date()) + "." + fileExtension);
        
        try{
        	
        	resumeExcelFile.transferTo(destFile);
        	FileInputStream fis = new FileInputStream(destFile);
        	
        	if (fileExtension.equals("XLSX")) {
	        	
        		XSSFWorkbook workbook=new XSSFWorkbook(fis);
	        	XSSFSheet sheet=workbook.getSheetAt(0);
	        	int rows=sheet.getPhysicalNumberOfRows();
	        	
	        	for(int rowindex=1; rowindex < rows; rowindex++){
	        	    
	        		XSSFRow row=sheet.getRow(rowindex);
	        	    if(row !=null){
	        	    	
	        	    	Map<String,Object> mapUserInfo = new HashMap<String,Object>();
	        	    	
	        	    	//int cells = row.getLastCellNum();
	        	    	int cells = 8;
	        	    	
	        	    	for(int columnindex=0; columnindex < cells; columnindex++){
	        	    		
	        	        	XSSFCell cell=row.getCell(columnindex);
	        	            String value="";
	        	            
	        	            if(cell==null){
	        	                continue;
	        	            } else {
	        	            	
	        	            	switch (cell.getCellType()){
	        	                case XSSFCell.CELL_TYPE_FORMULA:
	        	                    value=cell.getCellFormula();
	        	                    break;
	        	                case XSSFCell.CELL_TYPE_NUMERIC:
	        	                    value=cell.getNumericCellValue()+"";
	        	                    break;
	        	                case XSSFCell.CELL_TYPE_STRING:
	        	                    value=cell.getStringCellValue()+"";
	        	                    break;
	        	                case XSSFCell.CELL_TYPE_BLANK:
	        	                    value=cell.getBooleanCellValue()+"";
	        	                    break;
	        	                case XSSFCell.CELL_TYPE_ERROR:
	        	                    value=cell.getErrorCellValue()+"";
	        	                    break;
	        	                }
	        	            	
	        	            	mapUserInfo.put("jcCd", loginUserJcCd);
	        	            	mapUserInfo.put("regUserSeq", loginUser);
	        	            	
	        	            	if (columnindex == 0) {
	        	            		mapUserInfo.put("userNmKh", value);
	        	            	} else if (columnindex == 1) {
	        	            		mapUserInfo.put("userNmEn", value);
	        	            	} else if (columnindex == 2) {
	        	            		encUserEmail = Encryption.encryptAES256(value);
	        	            		mapUserInfo.put("userEmail", encUserEmail);
	        	            	} else if (columnindex == 3) {
	        	            		encUserCell = Encryption.encryptAES256(value);
	        	            		mapUserInfo.put("userCell", encUserCell);
	        	            	} else if (columnindex == 4) {
	        	            		encUserPasswd = Encryption.encryptAES256(value);
	        	            		mapUserInfo.put("userPasswd", encUserPasswd);
	        	            	} else if (columnindex == 5) {
	        	            		mapUserInfo.put("userBirth", value);
	        	            	} else if (columnindex == 6) {
	        	            		mapUserInfo.put("userGender", value);
	        	            	} else if (columnindex == 7) {
	        	            		mapUserInfo.put("userAddrCd", value);
	        	            	} else {
	        	            		mapUserInfo.put("userDtlAddr", value);
	        	            	}
	        	            }
	        	        }
	        	    	
	        	    	userInfoList.add(mapUserInfo);
	        	    }  
	        	    
	        	}
	        	
        	} else {
        		
        		HSSFWorkbook workbook=new HSSFWorkbook(fis);
        		HSSFSheet sheet=workbook.getSheetAt(0);
        		int rows=sheet.getPhysicalNumberOfRows();
        		
        		for(int rowindex=0; rowindex < rows; rowindex++){
        		    
        			HSSFRow row=sheet.getRow(rowindex);
        		    if(row !=null){
        		    	
        		    	Map<String,Object> mapUserInfo = new HashMap<String,Object>();
    		        	
        		        //int cells=row.getPhysicalNumberOfCells();
        		    	int cells = 8;
        		        for(int columnindex=0; columnindex <=cells; columnindex++){
        		        	
        		        	HSSFCell cell=row.getCell(columnindex);
        		            String value="";
        		            
        		            if(cell==null){
        		                continue;
        		            }else{
        		                switch (cell.getCellType()){
        		                case HSSFCell.CELL_TYPE_FORMULA:
        		                    value=cell.getCellFormula();
        		                    break;
        		                case HSSFCell.CELL_TYPE_NUMERIC:
        		                    value=cell.getNumericCellValue()+"";
        		                    break;
        		                case HSSFCell.CELL_TYPE_STRING:
        		                    value=cell.getStringCellValue()+"";
        		                    break;
        		                case HSSFCell.CELL_TYPE_BLANK:
        		                    value=cell.getBooleanCellValue()+"";
        		                    break;
        		                case HSSFCell.CELL_TYPE_ERROR:
        		                    value=cell.getErrorCellValue()+"";
        		                    break;
        		                }
        		                
	        	            	mapUserInfo.put("jcCd", loginUserJcCd);
	        	            	mapUserInfo.put("regUserSeq", loginUser);        		                
        		                
	        	            	if (columnindex == 0) {
	        	            		mapUserInfo.put("userNmKh", value);
	        	            	} else if (columnindex == 1) {
	        	            		mapUserInfo.put("userNmEn", value);
	        	            	} else if (columnindex == 2) {
	        	            		encUserEmail = Encryption.encryptAES256(value);
	        	            		mapUserInfo.put("userEmail", encUserEmail);
	        	            	} else if (columnindex == 3) {
	        	            		encUserCell = Encryption.encryptAES256(value);
	        	            		mapUserInfo.put("userCell", encUserCell);
	        	            	} else if (columnindex == 4) {
	        	            		encUserPasswd = Encryption.encryptAES256(value);
	        	            		mapUserInfo.put("userPasswd", encUserPasswd);
	        	            	} else if (columnindex == 5) {
	        	            		mapUserInfo.put("userBirth", value);
	        	            	} else if (columnindex == 6) {
	        	            		mapUserInfo.put("userGender", value);
	        	            	} else if (columnindex == 7) {
	        	            		mapUserInfo.put("userAddrCd", value);
	        	            		mapUserInfo.put("userAddrFullCd", value);
	        	            	} else {
	        	            		mapUserInfo.put("userDtlAddr", value);
	        	            	}        		                
        		            }

        		        }
        		        
        		        userInfoList.add(mapUserInfo);
        		    }
        		}
       		
        	}
        	
        	rtnParam = userElementaryService.insertUserElementaryRegUserInfoByExcel(userInfoList, locale, request);
        	
        	if (rtnParam.getResultCode() == "0000") {
        		System.out.println("Success ========================================================================");
        	} else {
        		System.out.println("Fail ========================================================================");
        	}

        }catch(IllegalStateException | IOException e){
            throw new RuntimeException(e.getMessage(),e);
        }
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("rtnData", userInfoList);
        mv.addObject("rtnParam", rtnParam);
        
        //mv.setViewName("");
        return mv;

    }
    
    
	/**
	 * User Detail Info Main Elementary Job Seeker
	 * @param UserElementaryBean
	 * @param UserElementaryBean
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/selectUserElementaryDtlInfoMain")
    public ModelAndView selectUserElementaryDtlInfoMain(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userElementaryBean.setLang(locale.getLanguage().toLowerCase());
    	UserElementaryBean resultUserMain = (UserElementaryBean) userElementaryService.selectUserElementaryDtlInfoMain(userElementaryBean);
    	resultUserMain.setPreviousUrl(userElementaryBean.getPreviousUrl());

    	mv.addObject("rtnMain", resultUserMain);
    	mv.setViewName("user/userElementaryDtlInfoMain" + ".all");
    	return mv;
	}

	/**
	 * User Detail Info Base Using Elementary Job Seeker
	 * @param UserElementaryBean
	 * @param UserElementaryBean
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value= {"/selectUserElementaryDtlInfoBaseAjax", "/selectUserElementaryDtlInfoModifyAjax"})
    public ModelAndView selectUserElementaryDtlInfoBaseAjax(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userElementaryBean.setLang(locale.getLanguage().toLowerCase());
    	UserElementaryBean resultUserBase = (UserElementaryBean) userElementaryService.selectUserElementaryDtlInfoBase(userElementaryBean);

    	mv.addObject("rtnBase", resultUserBase);

    	String[] servletPath = ((String) request.getServletPath()).split("/");
    	String lastPath = (servletPath[servletPath.length -1]).replace(".do", "");

    	if (lastPath.equals("selectUserElementaryDtlInfoBaseAjax")) {
    		mv.setViewName("user/userElementaryDtlInfoBase" + ".empty");
    	} else {
    		mv.setViewName("user/userElementaryDtlInfoModify" + ".all");
    	}

    	return mv;
	}

    /**
     * Delete "User Detail Info
     * @param UserElementaryBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/deleteUserElementaryInfoAjax")
    public ModelAndView deleteUserElementaryInfoAjax(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	UserElementaryBean resultParam = new UserElementaryBean();

        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
        userElementaryBean.setRegUserSeq(sessUser.getUserSeq());
        userElementaryBean.setModUserSeq(sessUser.getUserSeq());
        userElementaryBean.setLang(locale.getLanguage().toLowerCase());

    	try {

			resultParam = userElementaryService.deleteUserElementaryInfo(userElementaryBean);

    		if(resultParam.getResultCode() == "0000") {
    			result.put("resultCode", "success");
    			result.put("resultMsg", "Save Success");
    		} else {
    			result.put("resultCode", resultParam.getResultCode());
    			result.put("resultMsg", resultParam.getMsg());
    		}

        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage());
       	}

  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;
    }

    /**
     * Update User Detail Info
     * @param UserElementaryBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/updateUserElementaryDtlInfoAjax")
    public ModelAndView updateUserElementaryDtlInfoAjax(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	UserElementaryBean resultParam = new UserElementaryBean();

    	try {
	    	// login user setting
	        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
	        userElementaryBean.setRegUserSeq(sessUser.getUserSeq());
	        userElementaryBean.setModUserSeq(sessUser.getUserSeq());
	        userElementaryBean.setLang(locale.getLanguage().toLowerCase());
			resultParam = userElementaryService.updateUserElementaryDtlInfo(userElementaryBean);

			if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
				result.put("resultCode", "success");
				result.put("resultMsg", "Save Success");
			} else {
				result.put("resultCode", resultParam.getResultCode());
				result.put("resultMsg", resultParam.getMsg());
			}

        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage());
       	}

  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;
    }

	/**
	 * Registration User Base Info
	 * @param UserElementaryBean
	 * @param UserElementaryBean
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value= "/selectUserElementaryRegBaseInfo")
    public ModelAndView selectUserElementaryRegBaseInfo(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userElementaryBean.setLang(locale.getLanguage().toLowerCase());
    	UserElementaryBean resultUserBase = (UserElementaryBean) userElementaryService.selectUserElementaryRegBaseInfo(userElementaryBean);

    	mv.addObject("rtnBase", resultUserBase);
    	mv.setViewName("user/userElementaryDtlInfoReg" + ".all");
    	return mv;
	}

	/**
	 * Check User Cell Duplication
	 * @param UserElementaryBean
	 * @param UserElementaryBean
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/selectUserCellDuplicationCheckAjax")
    public ModelAndView selectUserCellDuplicationCheckAjax(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userElementaryBean.setLang(locale.getLanguage().toLowerCase());
    	UserElementaryBean resultUserBase = (UserElementaryBean) userElementaryService.selectUserCellDuplicationCheck(userElementaryBean);

    	mv.addObject("chkDup", resultUserBase.getUserCellDup().toString());
    	mv.setViewName("jsonView");
    	return mv;
	}

    /**
     * Registration User Detail Info
     * @param UserElementaryBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/insertUserElementaryInfoAjax")
    public ModelAndView insertUserElementaryInfoAjax(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	UserElementaryBean resultParam = new UserElementaryBean();

    	try {
	    	// login user setting
	        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
	        userElementaryBean.setRegUserSeq(sessUser.getUserSeq());
	        userElementaryBean.setModUserSeq(sessUser.getUserSeq());
	        userElementaryBean.setLang(locale.getLanguage().toLowerCase());
			resultParam = userElementaryService.insertUserElementaryInfo(userElementaryBean);

			if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
				result.put("resultCode", "success");
				result.put("resultMsg", "Save Success");
			} else {
				result.put("resultCode", resultParam.getResultCode());
				result.put("resultMsg", resultParam.getMsg());
			}

        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage());
       	}

  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;
    }
    
    /**
     * Change User Type
     * @param UserElementaryBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserElementaryDtlInfoUserTypeChgAjax")
    public ModelAndView selectUserElementaryDtlInfoUserTypeChgAjax(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userElementaryBean.setLang(locale.getLanguage().toLowerCase());
    	UserElementaryBean resultData = (UserElementaryBean) userElementaryService.selectUserElementaryDtlInfoUserTypeChg(userElementaryBean);

    	mv.addObject("rtnData", resultData);
    	mv.setViewName("user/userElementaryDtlInfoUserTypeChg" + ".empty");
    	return mv;
	}
    
    /**
     * Update User Type
     * @param UserElementaryBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/insertUserElementaryDtlInfoUserTypeChgAjax")
    public ModelAndView insertUserElementaryDtlInfoUserTypeChgAjax(@ModelAttribute("UserElementaryBean") UserElementaryBean userElementaryBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	UserElementaryBean resultParam = new UserElementaryBean();

    	try {
	    	// login user setting
	        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
	        userElementaryBean.setRegUserSeq(sessUser.getUserSeq());
	        userElementaryBean.setModUserSeq(sessUser.getUserSeq());
	        userElementaryBean.setLang(locale.getLanguage().toLowerCase());

			resultParam = userElementaryService.insertUserElementaryDtlInfoUserTypeChg(userElementaryBean);

			if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
				result.put("resultCode", "success");
				result.put("resultMsg", "Save Success");
			} else {
				result.put("resultCode", resultParam.getResultCode());
				result.put("resultMsg", resultParam.getMsg());
			}

        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage());
       	}

  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;
    }    

    /**
     * User Detail Info Interview History List
     * @param UserElementaryIntvwBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserElementaryDtlInfoIntvwListMainAjax")
    public ModelAndView selectUserElementaryDtlInfoIntvwListMainAjax(@ModelAttribute("UserElementaryIntvwBean") UserElementaryIntvwBean userElementaryIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.addObject("rtnUserSeq", userElementaryIntvwBean.getUserSeq());
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());		//
    	mv.setViewName("user/userElementaryDtlInfoIntvwList" + ".empty");
    	return mv;
	}

    @RequestMapping(value="/selectUserElementaryDtlInfoIntvwListSubAjax")
	public ModelAndView selectUserElementaryDtlInfoIntvwListSubAjax(@ModelAttribute("UserElementaryIntvwBean") UserElementaryIntvwBean userElementaryIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {

  		ModelAndView mv = new ModelAndView();
  		userElementaryIntvwBean.setLang(locale.getLanguage().toLowerCase());
		// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null)
  			userElementaryIntvwBean.setOrderStr(Integer.parseInt(orderColumnIndex));

  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			userElementaryIntvwBean.setOrderColumnSort(orderDir);

  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			userElementaryIntvwBean.setOrderColumn(orderColumn);

  			UserElementaryIntvwBean result = (UserElementaryIntvwBean) userElementaryService.selectUserElementaryDtlInfoIntvwList(userElementaryIntvwBean);

  	  	    mv.addObject("aaData", result.getList());
  			mv.addObject("draw", userElementaryIntvwBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}

	  	mv.setViewName("jsonView");
	  	return mv;
	}

    /**
     * User Detail Info Interview History Registration
     * @param UserElementaryIntvwBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserElementaryDtlInfoIntvwRegAjax")
    public ModelAndView selectUserElementaryDtlInfoIntvwRegAjax(@ModelAttribute("UserElementaryIntvwBean") UserElementaryIntvwBean userElementaryIntvwBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();

    	mv.addObject("rtnUserSeq", userElementaryIntvwBean.getUserSeq());
    	mv.setViewName("user/userElementaryDtlInfoIntvwReg" + ".empty");
    	return mv;
	}

    /**
     * Registration User Detail Info Interview History
     * @param UserElementaryIntvwBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/insertUserElementaryDtlInfoIntvwRegAjax")
    public ModelAndView insertUserElementaryDtlInfoIntvwRegAjax(@ModelAttribute("UserElementaryIntvwBean") UserElementaryIntvwBean userElementaryIntvwBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	UserElementaryIntvwBean resultParam = new UserElementaryIntvwBean();
    	
    	try {
	    	// login user setting
	        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
	        userElementaryIntvwBean.setRegUserSeq(sessUser.getUserSeq());
	        userElementaryIntvwBean.setModUserSeq(sessUser.getUserSeq());
	        userElementaryIntvwBean.setLang(locale.getLanguage().toLowerCase());
			resultParam = userElementaryService.insertUserElementaryDtlInfoIntvw(userElementaryIntvwBean);

			if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
				result.put("resultCode", "success");
				result.put("resultMsg", "Save Success");
			} else {
				result.put("resultCode", resultParam.getResultCode());
				result.put("resultMsg", resultParam.getMsg());
			}

        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage());
       	}

  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;
    }

    /**
     * User Interview Detail Info for Modify
     * @param UserElementaryIntvwBean
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserElementaryDtlInfoIntvwModifyAjax")
    public ModelAndView selectUserElementaryDtlInfoIntvwModifyAjax(@ModelAttribute("UserElementaryIntvwBean") UserElementaryIntvwBean userElementaryIntvwBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	userElementaryIntvwBean.setLang(locale.getLanguage().toLowerCase());
    	UserElementaryIntvwBean resultData = (UserElementaryIntvwBean) userElementaryService.selectUserElementaryDtlInfoIntvwModify(userElementaryIntvwBean);

    	mv.addObject("rtnData", resultData);
    	mv.setViewName("user/userElementaryDtlInfoIntvwModify" + ".empty");
    	return mv;
	}

    /**
     * Update User Detail Info Interview History
     * @param UserElementaryIntvwBean
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/updateUserElementaryDtlInfoIntvwModifyAjax")
    public ModelAndView updateUserElementaryDtlInfoIntvwModifyAjax(@ModelAttribute("UserElementaryIntvwBean") UserElementaryIntvwBean userElementaryIntvwBean, Locale locale, HttpServletResponse response, HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	UserElementaryIntvwBean resultParam = new UserElementaryIntvwBean();

    	try {
	    	// login user setting
	        UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
	        userElementaryIntvwBean.setRegUserSeq(sessUser.getUserSeq());
	        userElementaryIntvwBean.setModUserSeq(sessUser.getUserSeq());
	        userElementaryIntvwBean.setLang(locale.getLanguage().toLowerCase());
			resultParam = userElementaryService.updateUserElementaryDtlInfoIntvwModify(userElementaryIntvwBean);

			if(resultParam.getResultCode().equals("0000") || resultParam.getResultCode().equals("0")) {
				result.put("resultCode", "success");
				result.put("resultMsg", "Save Success");
			} else {
				result.put("resultCode", resultParam.getResultCode());
				result.put("resultMsg", resultParam.getMsg());
			}

        } catch (Exception e) {
			result.put("resultCode", resultParam.getResultCode());
			result.put("resultMsg", e.getCause().getMessage());
       	}

  	    mv.addObject("resultCode", result.get("resultCode"));
  	    mv.addObject("resultMsg", result.get("resultMsg"));
  	    mv.setViewName("jsonView");
		return mv;
    }


    /*
     * Counsel Info
     */
    @RequestMapping(value="/selectElementaryCounselInfoAjax")
    public ModelAndView selectCounselInfoAjax(@ModelAttribute("UserBean") UserBean userBean, Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();


    	mv.addObject("rtnUserSeq", userBean.getUserSeq());			//Resume Base(Human) Data
    	mv.addObject("rtnLangCd", locale.getLanguage().toLowerCase());		//
    	mv.setViewName("user/elementaryCounselList.empty");
    	return mv;
	}
    
    
    @RequestMapping(value="/elementaryCounselRegAjax")
    public ModelAndView elementaryCounselRegAjax(@ModelAttribute("CounselBean") CounselBean CounselBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	UserElementaryBean user = userElementaryService.selectelementaryUserInfo(CounselBean);
    	
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();
    	CounselBean.setRegUserSeq(sessUser.getUserSeq());
    	
    	CounselBean = userElementaryService.selectCounselUserInfo(CounselBean);


    	mv.addObject("elmtryUserInfo", user);			//Resume Base(Human) Data
    	mv.addObject("CounselUserInfo", CounselBean);		//
    	mv.setViewName("user/elementaryCounselReg.empty");
    	return mv;
	}
    
    @RequestMapping("/insertElemtryCounselAjax")
	public ModelAndView insertElemtryCounselAjax(@ModelAttribute("CounselBean") CounselBean CounselBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		
		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	CounselBean.setUser(sessUser);
    	CounselBean.setCounselCateDivCd("CCD0000000003");
    	CounselBean.setDelYn("N");
    	CounselBean.setSecretYn("N");
    	CounselBean.setCounselStsCd("CSC0000000001");
		
		result = userElementaryService.insertElemtryCounsel(request,CounselBean);
		
		mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	mv.setViewName("jsonView");
	  	return mv;
	}


}
