<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:importAttribute name="depth1" />
<tiles:importAttribute name="depth2" />
<tiles:importAttribute name="depth3" />
<tiles:importAttribute name="depth4" />
<tiles:importAttribute name="menuList" />
<tiles:importAttribute name="topUserName" />
<body>
<div class="accessibility">
    <a href="#container">Contents shortcut</a>
</div>

<hr />

<div id="wrapper">
<header id="header">
	<h1 class="logo">
		<a href="/">
			<img src="/images/common/logo.png" alt="NEA logo" />
			<span class="cont">
				<strong>ទីភ្នាក់ងារជាតិមុខរបរ និងការងារ</strong>
				<span>Internal Portal</span>
			</span>
		</a>
	</h1>
	<div class="top_box clearfix">
		<ul class="clearfix">
		<li><span class="name">${topUserName }</span></li>
		<li><a href="">Change Password</a></li>
		<li><a href="">Manual</a></li>
		<li><a href="${pageContext.request.contextPath}/authLogout.do">Logout</a></li>
		<li><button type="button" class="language">Language</button>
			<div class="language_box">
				<ul>
					<li><a href="${pageContext.request.contextPath}/internal/index.do?lang=kh">Khmer</a></li>
					<li><a href="${pageContext.request.contextPath}/internal/index.do?lang=en">English</a></li>
					<li><a href="${pageContext.request.contextPath}/internal/index.do?lang=ko">Korea</a></li>
				</ul>
			</div>
		</li>
		</ul>
	</div>
	<!-- //header_top -->
	<nav id="gnb_box">
		<h2 class="skip">Global Navigation Bar</h2>
		<div id="gnb">
			<ul class="clearfix">
			<c:forEach var="menu" items="${menuList}" varStatus="status">
				<li class="depth1"><a href="${menu.menuUrl }" <c:if test="${status.count.toString() eq depth1 }">class="on"</c:if>>${menu.menuNm }</a></li><!-- 현재 메뉴에 클래스 on 추가 -->
			</c:forEach>
			</ul>
		</div>
	</nav>
	<!-- //gnb -->
</header>
<!-- //header -->

<hr />