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
	String jobCenter = request.getAttribute("jobCenter").toString();
	String totalTrnngCnt = request.getAttribute("totalTrnngCnt").toString();
	String preEmploymentCnt = request.getAttribute("preEmploymentCnt").toString();
	String softSkillCnt = request.getAttribute("softSkillCnt").toString();
	String recrumtCnt = request.getAttribute("recrumtCnt").toString();
	String applicCnt = request.getAttribute("applicCnt").toString();
	String maleCnt = request.getAttribute("maleCnt").toString();
	String femaleCnt = request.getAttribute("femaleCnt").toString();
	String regDt = request.getAttribute("regDt").toString();
	String sysLangCd = request.getAttribute("sysLangCd").toString();

%>
<%
	OOFDocument oof = OOFDocument.newOOF();
	OOFFile file = oof.addFile("crf.root", "%root%/crf/stat/statNEATrnngJobCenterStatusDaily.crf");
	oof.addConnectionData("*", "CPES_DEV");
	oof.addField("JC_CD", jcCd);
	oof.addField("START_DATE", startDate);
	oof.addField("END_DATE", endDate);
	oof.addField("JOB_CENTER", jobCenter);
	oof.addField("TOTAL_TRNNG_CNT", totalTrnngCnt);
	oof.addField("PRE_EMPLOYMENT_CNT", preEmploymentCnt);
	oof.addField("SOFT_SKILL_CNT", softSkillCnt);
	oof.addField("RECRUMT_CNT", recrumtCnt);
	oof.addField("APPLIC_CNT", applicCnt);
	oof.addField("MALE_CNT", maleCnt);
	oof.addField("FEMALE_CNT", femaleCnt);
	oof.addField("REG_DT", regDt);
	oof.addField("LANG", sysLangCd);
	
	String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);
%>
<input type="hidden" id="resultKey" name="resultKey" value="<%=resultKey%>" />
