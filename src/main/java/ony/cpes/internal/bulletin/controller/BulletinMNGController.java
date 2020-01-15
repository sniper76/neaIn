package ony.cpes.internal.bulletin.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.common.base.CaseFormat;

import ony.cpes.internal.bulletin.service.BulletinMNGService;
import ony.cpes.internal.user.bean.UserBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.bulletin.bean.BulletinMNGBean;
import ony.cpes.internal.bulletin.bean.BulletinCateBean;
import ony.framework.BaseController;


@RequestMapping("/internal/bulletinMng")
@Controller
public class BulletinMNGController extends BaseController{

	private static Log log = LogFactory.getLog(BulletinMNGController.class);
  
	@Autowired
	private BulletinMNGService BulletinMNGService;
	
	@Autowired
	private CommonService CommonService;
	
	@RequestMapping("/bulletinMng")
	public String bulletinMNG(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "bulletin/bulletinMng.all";
	}
	
	@RequestMapping("/bulletinMngReg")
	public String bulletinMNGInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView mv = new ModelAndView();
		//mv.setView(new RedirectView("bulletin/bulletinMNGInsert.all",true));
		//return mv;
		return "bulletin/bulletinMngReg.all";
	}
    
    @RequestMapping("/selectBulletinMngListAjax")
	public ModelAndView selectBulletinMNGListAjax(@ModelAttribute("BulletinMNGBean") BulletinMNGBean BulletinMNGBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	BulletinMNGBean.setUser(sessUser);
    	
    	// sorting
  		String orderColumnIndex = request.getParameter("order[0][column]");
  		if (orderColumnIndex != null) 
  			BulletinMNGBean.setOrderStr(Integer.parseInt(orderColumnIndex));
  		
  		String orderDir = request.getParameter("order[0][dir]");
  		if (orderDir != null)
  			BulletinMNGBean.setOrderColumnSort(orderDir);
  		
  		String orderColumns = request.getParameter("orderColumns");
  		String orderColumn = "";
  		if(orderColumns != null) {
  			String[] temp = orderColumns.split(",");
  			orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, temp[Integer.parseInt(orderColumnIndex)]);
  			BulletinMNGBean.setOrderColumn(orderColumn);
  			BulletinMNGBean result = BulletinMNGService.selectBulletinMNGList(BulletinMNGBean);
  			
  			mv.addObject("aaData", result.getList());
  			mv.addObject("draw", BulletinMNGBean.getDraw());
  	  	    mv.addObject("iTotalRecords", result.getiTotalRecords());
  			mv.addObject("iTotalDisplayRecords", result.getiTotalDisplayRecords());
  		}
  			
		//this.outputJSON(request, response, BulletinMNGService.selectBulletinMNGList(BulletinMNGBean));
		mv.setViewName("jsonView");
	  	return mv;  
    	
    	
	}
    
    @RequestMapping("/insertBulletinMngAjax")
    //@RequestBody
	public ModelAndView insertBulletinMNGAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	Map<String,Object> cateMp = new HashMap<String,Object>();
    	BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
    	//UserBean userBean = new UserBean();

		// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	bulletinMNGBean.setUser(sessUser);
    	
    	bulletinMNGBean.setBulletinNm(request.getParameter("bulletinNm"));
    	bulletinMNGBean.setBulletinTypeCd(request.getParameter("bulletinTypeCd"));
    	bulletinMNGBean.setBulletinRangeCd(request.getParameter("bulletinRange"));
    	bulletinMNGBean.setContent(request.getParameter("content"));
    	bulletinMNGBean.setDelYn("N");
    	bulletinMNGBean.setJobskYn(request.getParameter("jobskYn"));
    	bulletinMNGBean.setStdtYn(request.getParameter("stdtYn"));
    	bulletinMNGBean.setEmployYn(request.getParameter("employYn"));
    	bulletinMNGBean.setTrnngInsttYn(request.getParameter("trnngInsttYn"));
    	
    	bulletinMNGBean.setFileYn(request.getParameter("fileYn"));
    	if(request.getParameter("fileYn").equals("Y")) {
    		bulletinMNGBean.setFileQty(Integer.parseInt(request.getParameter("fileNum")));
        	bulletinMNGBean.setFileSize(request.getParameter("fileCap"));
    	}else {
    		bulletinMNGBean.setFileQty(0);
        	bulletinMNGBean.setFileSize("0");
    	}
    	
    	bulletinMNGBean.setLikeYn(request.getParameter("likeYn"));
    	bulletinMNGBean.setUseYn(request.getParameter("useYn"));
    	
    	
    	int cateCnt = Integer.parseInt(request.getParameter("cateCnt"));
    	
    	if(cateCnt > 0) {
    		//Setting increased by the number of categories
        	for(int i=1; i < cateCnt+1; i++) {
        		cateMp.put("cate"+i, request.getParameter("cate"+i));
        	}
        	cateMp.put("cateCnt", Integer.toString(cateCnt));
    	}else {
    		cateMp.put("cateCnt", Integer.toString(cateCnt));
    	}

    	result = BulletinMNGService.insertBulletinMNG(request, bulletinMNGBean,cateMp);
    	
    	mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	
    	mv.setViewName("jsonView");
	  	return mv;
		//this.outputJSON(request, response, BulletinMNGService.insertBulletinMNG(param));
	}
    
    @RequestMapping("/BulletinMngDtl")
	public ModelAndView BulletinMNGDtl(@ModelAttribute("BulletinMNGBean") BulletinMNGBean BulletinMNGBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	String bulletinMngSeq = BulletinMNGBean.getBulletinMngSeq();
    	mv.addObject("bulletinMngSeq",bulletinMngSeq);	
    	mv.setViewName("bulletin/bulletinMngMod.all");
	  	return mv;  
	}
    
    @RequestMapping("/selectBulletinMNGDtlAjax")
	public ModelAndView selectBulletinMNGDtlAjax(@ModelAttribute("BulletinMNGBean") BulletinMNGBean BulletinMNGBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	BulletinCateBean bulletinCateBean = new BulletinCateBean();
    	BulletinCateBean tempCate = new BulletinCateBean();
    	BulletinMNGBean dtlList = new BulletinMNGBean();
    	ArrayList<Map<String,Object>> tList = new ArrayList<Map<String,Object>>();
    	
    	
    	//bulletinMng detail select
    	dtlList = BulletinMNGService.selectBulletinMngDtl(BulletinMNGBean);
    	
    	//bulletinMng category list
    	bulletinCateBean = BulletinMNGService.selectBulletinCateList(BulletinMNGBean);
    	
    	//category list Add in HashMap
    	for(int i=0; i < bulletinCateBean.getList().size(); i++) {
    		Map<String,Object> tMp = new HashMap<String,Object>();
    		
    		tempCate = bulletinCateBean.getList().get(i);
    		tMp.put("bulletinCateNm", tempCate.getBulletinCateNm());
    		tMp.put("bulletinCateSeq", tempCate.getBulletinCateSeq());
    		tMp.put("bulletinMngSeq", tempCate.getBulletinMngSeq());
    		tMp.put("sort", tempCate.getSort());
    		tList.add(tMp);
    	}
    	
    	mv.addObject("bulldtlList",dtlList);
  		mv.addObject("bulletinCateBean", tList);  		
    	mv.setViewName("jsonView");
    	
	  	return mv;  
	}
    
    
    @RequestMapping("/updateBulletinMNGAjax")
    //@RequestBody
	public ModelAndView updateBulletinMNGAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	Map<String,Object> cateMp = new HashMap<String,Object>();
    	BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
    	//UserBean userBean = new UserBean();

    	// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	bulletinMNGBean.setUser(sessUser);
    	
    	bulletinMNGBean.setBulletinMngSeq(request.getParameter("bulletinMngSeq"));
    	bulletinMNGBean.setBulletinNm(request.getParameter("bulletinNm"));
    	bulletinMNGBean.setBulletinTypeCd(request.getParameter("bulletinType"));
    	bulletinMNGBean.setBulletinRangeCd(request.getParameter("bulletinRange"));
    	bulletinMNGBean.setContent(request.getParameter("content"));
    	bulletinMNGBean.setDelYn("N");
    	bulletinMNGBean.setJobskYn(request.getParameter("jobskYn"));
    	bulletinMNGBean.setStdtYn(request.getParameter("stdtYn"));
    	bulletinMNGBean.setEmployYn(request.getParameter("employYn"));
    	bulletinMNGBean.setTrnngInsttYn(request.getParameter("trnngInsttYn"));
    	
    	bulletinMNGBean.setFileYn(request.getParameter("fileYn"));
    	if(request.getParameter("fileYn").equals("Y")) {
    		bulletinMNGBean.setFileQty(Integer.parseInt(request.getParameter("fileNum")));
        	bulletinMNGBean.setFileSize(request.getParameter("fileCap"));
    	}else {
    		bulletinMNGBean.setFileQty(0);
        	bulletinMNGBean.setFileSize("0");
    	}
    	
    	bulletinMNGBean.setLikeYn(request.getParameter("likeYn"));
    	bulletinMNGBean.setUseYn(request.getParameter("useYn"));
    	
    	
    	int cateCnt = Integer.parseInt(request.getParameter("cateCnt"));
    	
    	if(cateCnt > 0) {
    		//Setting increased by the number of categories
        	for(int i=1; i < cateCnt+1; i++) {
        		cateMp.put("cate"+i, request.getParameter("cate"+i));
        	}
        	cateMp.put("cateCnt", Integer.toString(cateCnt));
    	}else {
    		cateMp.put("cateCnt", Integer.toString(cateCnt));
    	}
    	
    	
    	
    	result = BulletinMNGService.updateBulletinMNG(bulletinMNGBean,cateMp);
    	
    	mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	
    	mv.setViewName("jsonView");
	  	return mv;
	}
    
    @RequestMapping("/deleteBulletinMngAjax")
	public ModelAndView deleteBulletinMngAjax(@ModelAttribute("BulletinMNGBean") BulletinMNGBean BulletinMNGBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mv = new ModelAndView();
    	Map<String,Object> result = new HashMap<String,Object>();
    	// login user setting
    	UserBean sessUser = (UserBean) CommonService.selectCommonUserDtlInfo();  		
    	BulletinMNGBean.setUser(sessUser);
    	BulletinMNGBean.setDelYn("Y");
    	
    	BulletinMNGBean.setBulletinMngSeq(request.getParameter("bulletinMngSeq"));
    	
    	
    	result = BulletinMNGService.deleteBulletinMNG(BulletinMNGBean);
    	
    	mv.addObject("stat", result.get("stat"));
    	mv.addObject("msg", result.get("msg"));
    	
    	mv.setViewName("jsonView");
    	return mv;
	}
    
}
