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
<!--  
<c:set var="startDate" value="${startDate}" />
<c:set var="endDate" value="${endDate}" />
<c:set var="userTotalCnt" value="${userTotalCnt}" />
<c:set var="jobskUserCnt" value="${jobskUserCnt}" />
<c:set var="compnyUserCnt" value="${compnyUserCnt}" />
<c:set var="insttUserCnt" value="${insttUserCnt}" />
<c:set var="regDt" value="${regDt}" />
-->
<%
	/*
	String startDate = (String)pageContext.getAttribute("startDate");
	String endDate = (String)pageContext.getAttribute("endDate");
	String userTotalCnt = (String)pageContext.getAttribute("userTotalCnt");
	String jobskUserCnt = (String)pageContext.getAttribute("jobskUserCnt");
	String compnyUserCnt = (String)pageContext.getAttribute("compnyUserCnt");
	String insttUserCnt = (String)pageContext.getAttribute("insttUserCnt");
	String regDt = (String)pageContext.getAttribute("regDt");
	*/
	
	String jcCd = request.getAttribute("jcCd").toString();
	String startDate = request.getAttribute("startDate").toString();
	String endDate = request.getAttribute("endDate").toString();
	String jobCenter = request.getAttribute("jobCenter").toString();
	String userTotalCnt = request.getAttribute("userTotalCnt").toString();
	String jobskUserCnt = request.getAttribute("jobskUserCnt").toString();
	String compnyUserCnt = request.getAttribute("compnyUserCnt").toString();
	String insttUserCnt = request.getAttribute("insttUserCnt").toString();
	String regDt = request.getAttribute("regDt").toString();
	String sysLangCd = request.getAttribute("sysLangCd").toString();

%>
<%
	OOFDocument oof = OOFDocument.newOOF();
	OOFFile file = oof.addFile("crf.root", "%root%/crf/stat/statUserJobCenterStatusDaily.crf");
	oof.addConnectionData("*", "CPES_DEV");
	oof.addField("JC_CD", jcCd);
	oof.addField("START_DATE", startDate);
	oof.addField("END_DATE", endDate);
	oof.addField("JOB_CENTER", jobCenter);
	oof.addField("USER_TOTAL_CNT", userTotalCnt);
	oof.addField("JOBSK_USER_CNT", jobskUserCnt);
	oof.addField("COMPNY_USER_CNT", compnyUserCnt);
	oof.addField("INSTT_USER_CNT", insttUserCnt);
	oof.addField("REG_DT", regDt);
	oof.addField("LANG", sysLangCd);
	
	String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);
%>
<input type="hidden" id="resultKey" name="resultKey" value="<%=resultKey%>" />
