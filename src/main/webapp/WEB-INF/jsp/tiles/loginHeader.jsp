<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/alertify/themes/alertify.core.css" />
	<!-- include a theme, can be included into the core instead of 2 separate files -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/alertify/themes/alertify.default.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/pageLib/login/login.js"></script>
    <!--  ALERTFY -->
	<script src="${pageContext.request.contextPath}/js/alertify/lib/alertify.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.form.js"></script>
	
	
	<script>
		var contextPath = '${pageContext.request.contextPath}';
		var lang = '${ pageContext.request.locale.language }';
		var i18n = {};
		
		$.ajax({ method: 'get', url: contextPath + '/message/message-common.do', dataType: 'json'})
		.done(function (res, status, responseObj) {
			res.i18n.forEach(function (item) {
				i18n[Object.keys(item)] = item[Object.keys(item)];
			});
			//console.log( i18n );
			//console.log( t('errors.maxlength', ["'문자열'", "2"]) );	
			//console.log(t('button.delete'));
		}).fail(function (result, status, responseObj) {
			console.log(status);
		});
		
		function t(key, arrValue) {
			var reVal = value = i18n[key];
			
			if ($.isArray(arrValue)) {
				arrValue.forEach(function (v, i) {
					value = value.replace('{'+i+'}', v);
				});
				reVal = value;
			}
		
			return reVal; 
		}
		</script>
		
		
    <title>National Employment Agency Internal Portal</title>
    
</head>
<body>

<div class="accessibility">
    <a href="#contents">Contents shortcut</a>
</div>

<hr />

<div id="wrapper">
	<div class="login_wrap">
		<header id="header">
			<h1 class="title"><strong>CPES</strong> Administrator</h1>
		</header>
		<!-- //header -->
		
		<main id="container">
			<article>
				<div id="contents">