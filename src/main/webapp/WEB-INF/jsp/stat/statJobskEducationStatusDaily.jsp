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
	String fEducation = request.getAttribute("fEducation").toString();
	String fJobsk = request.getAttribute("fJobsk").toString();
	String fActiveCV = request.getAttribute("fActiveCV").toString();
	String fMale = request.getAttribute("fMale").toString();
	String fFemale = request.getAttribute("fFemale").toString();
	String fDisabled = request.getAttribute("fDisabled").toString();
	String fNonDisabled = request.getAttribute("fNonDisabled").toString();
	String regDt = request.getAttribute("regDt").toString();
	String sysLangCd = request.getAttribute("sysLangCd").toString();

%>
<%
	OOFDocument oof = OOFDocument.newOOF();
	OOFFile file = oof.addFile("crf.root", "%root%/crf/stat/statJobskEducationStatusDaily.crf");
	oof.addConnectionData("*", "CPES_DEV");
	oof.addField("JC_CD", jcCd);
	oof.addField("START_DATE", startDate);
	oof.addField("END_DATE", endDate);
	oof.addField("EDUCATION", fEducation);
	oof.addField("JOB_SEEKER", fJobsk);
	oof.addField("ACTIVE_CV", fActiveCV);
	oof.addField("MALE", fMale);
	oof.addField("FEMALE", fFemale);
	oof.addField("DISABLED", fDisabled);
	oof.addField("NON_DISABLED", fNonDisabled);
	oof.addField("REG_DT", regDt);
	oof.addField("LANG", sysLangCd);
	
	String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);
%>
<input type="hidden" id="resultKey" name="resultKey" value="<%=resultKey%>" />
