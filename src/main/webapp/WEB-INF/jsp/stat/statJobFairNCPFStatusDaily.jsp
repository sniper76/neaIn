<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.clipsoft.clipreport.oof.OOFFile"%>
<%@page import="com.clipsoft.clipreport.oof.OOFDocument"%>
<%@page import="java.io.File"%>
<%@page import="com.clipsoft.clipreport.server.service.ReportUtil"%>
<%@page import="com.clipsoft.org.apache.commons.lang.StringEscapeUtils"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.clipsoft.org.json.simple.JSONObject"%>
<%@page import="com.clipsoft.org.json.simple.parser.JSONParser"%>

<%@include file="../common/Property.jsp"%>
<%
	
	String jcCd = request.getAttribute("jcCd").toString();
	String startDate = request.getAttribute("startDate").toString();
	String endDate = request.getAttribute("endDate").toString();
	
	String totalJobFairCnt = request.getAttribute("totalJobFairCnt").toString();
	String compnyPatcptnCnt = request.getAttribute("compnyPatcptnCnt").toString();
	String insttPatcptnCnt = request.getAttribute("insttPatcptnCnt").toString();
	String jobskCnt = request.getAttribute("jobskCnt").toString();
	String vacancyCnt = request.getAttribute("vacancyCnt").toString();
	String recrumtCnt = request.getAttribute("recrumtCnt").toString();
	String boothCnt = request.getAttribute("boothCnt").toString();
	String passCnt = request.getAttribute("passCnt").toString();
	String regDt = request.getAttribute("regDt").toString();
	String sysLangCd = request.getAttribute("sysLangCd").toString();

%>
<%
	OOFDocument oof = OOFDocument.newOOF();
	OOFFile file = oof.addFile("crf.root", "%root%/crf/stat/statJobFairNCPFStatusDaily.crf");
	oof.addConnectionData("*", "CPES_DEV");
	oof.addField("JC_CD", jcCd);
	oof.addField("START_DATE", startDate);
	oof.addField("END_DATE", endDate);
	oof.addField("TOTAL_JOBFAIR_CNT", totalJobFairCnt);
	oof.addField("COMPNY_PATCPTN_CNT", compnyPatcptnCnt);
	oof.addField("INSTT_PACTCPTN_CNT", insttPatcptnCnt);
	oof.addField("JOBSK_CNT", jobskCnt);
	oof.addField("VACANCY_CNT", vacancyCnt);
	oof.addField("RECRUMT_CNT", recrumtCnt);
	oof.addField("BOOTH_CNT", boothCnt);
	oof.addField("PASS_CNT", passCnt);
	oof.addField("REG_DT", regDt);
	oof.addField("LANG", sysLangCd);
	
	String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);
%>
<input type="hidden" id="resultKey" name="resultKey" value="<%=resultKey%>" />
