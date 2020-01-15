package ony.cpes.internal.batch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ony.cpes.internal.batch.service.BatchService;
import ony.framework.BaseController;

@RequestMapping("/internal/batch")
@Controller
public class BatchController extends BaseController {

	@Autowired
	private BatchService batchSvc;


	@RequestMapping("/selectOverThreeDaysApplic")
	public void selectOverThreeDaysApplic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		batchSvc.selectOverThreeDaysApplic();
	}

	@RequestMapping("/selectOverThreeDaysOffer")
	public void selectOverThreeDaysOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		batchSvc.selectOverThreeDaysOffer();
	}

}
