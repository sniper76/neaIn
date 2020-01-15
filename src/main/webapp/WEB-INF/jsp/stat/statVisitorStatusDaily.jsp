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
	
	String startDate = request.getAttribute("startDate").toString();
	String endDate = request.getAttribute("endDate").toString();
	String totalVisitorCnt = request.getAttribute("totalVisitorCnt").toString();
	String totalPcCnt = request.getAttribute("totalPcCnt").toString();
	String totalMobileCnt = request.getAttribute("totalMobileCnt").toString();
	String guestCnt = request.getAttribute("guestCnt").toString();
	String normalCnt = request.getAttribute("normalCnt").toString();
	String stditCnt = request.getAttribute("stditCnt").toString();
	String compnyCnt = request.getAttribute("compnyCnt").toString();
	String insttCnt = request.getAttribute("insttCnt").toString();
	String regDt = request.getAttribute("regDt").toString();
	String sysLangCd = request.getAttribute("sysLangCd").toString();

%>
<%
	OOFDocument oof = OOFDocument.newOOF();
	OOFFile file = oof.addFile("crf.root", "%root%/crf/stat/statVisitorStatusDaily.crf");
	oof.addConnectionData("*", "CPES_DEV");
	oof.addField("START_DATE", startDate);
	oof.addField("END_DATE", endDate);
	oof.addField("TOTAL_VISITOR_CNT", totalVisitorCnt);
	oof.addField("TOTAL_PC_CNT", totalPcCnt);
	oof.addField("TOTAL_MOBILE_CNT", totalMobileCnt);
	oof.addField("GUEST_CNT", guestCnt);
	oof.addField("NORMAL_CNT", normalCnt);
	oof.addField("STDIT_CNT", stditCnt);
	oof.addField("COMPNY_CNT", compnyCnt);
	oof.addField("INSTT_CNT", insttCnt);
	oof.addField("REG_DT", regDt);
	oof.addField("LANG", sysLangCd);
	
	String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);
%>
<input type="hidden" id="resultKey" name="resultKey" value="<%=resultKey%>" />
