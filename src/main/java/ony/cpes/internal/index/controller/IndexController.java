package ony.cpes.internal.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ony.framework.BaseController;




@Controller
@RequestMapping("/internal")
public class IndexController extends BaseController{

  private static Log log = LogFactory.getLog(IndexController.class);

    @RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		return "index/index.index";
		
	}
}
