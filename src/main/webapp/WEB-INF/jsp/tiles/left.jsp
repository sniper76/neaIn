<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:importAttribute name="depth1" />
<tiles:importAttribute name="depth2" />
<tiles:importAttribute name="depth3" />
<tiles:importAttribute name="depth4" />
<tiles:importAttribute name="depth1Nm" />
<tiles:importAttribute name="depth2Nm" />
<tiles:importAttribute name="depth3Nm" />
<tiles:importAttribute name="depth4Nm" />
<tiles:importAttribute name="depth1Url" />
<tiles:importAttribute name="depth2Url" />
<tiles:importAttribute name="depth3Url" />
<tiles:importAttribute name="depth4Url" />
<tiles:importAttribute name="menuList" />

<!-- Sidebar -->
<div id="container">
	<div id="lnb">
		<button type="button" class="lnb_btn">side menu hide and show</button>
		<nav class="lnb_menu">
			<h2 class="skip">Side Menu</h2>
			<!-- div class="lnb_title">
				<strong>User Management</strong>
			</div-->
			<ul class="dep1">
			
			<c:forEach var="menu1" items="${menuList}" varStatus="status1">
			<c:if test="${menu1.menuOrder eq depth1}">
				<c:if test="${fn:length(menu1.tailListMenu) > 0 }">
					<c:forEach var="menu2" items="${menu1.tailListMenu}" varStatus="status2">
						<c:choose>
						<c:when test="${menu2.menuUrl ne null && menu2.menuUrl ne ''}">
						<li><a href="${menu2.menuUrl }">${menu2.menuNm }</a>
						</c:when>
						<c:otherwise>
						<li><a href="">${menu2.menuNm }</a>
						</c:otherwise>
						</c:choose>
						<c:if test="${fn:length(menu2.tailListMenu) > 0 }">
							<ul class="dep2">
							<c:forEach var="menu3" items="${menu2.tailListMenu}" varStatus="status3">
							<c:choose>
							<c:when test="${menu3.menuUrl ne null  && menu3.menuUrl ne ''}">
							<li><a href="${menu3.menuUrl }">${menu3.menuNm }</a>
							</c:when>
							<c:otherwise>
							<li><a href="">${menu3.menuNm }</a>
							</c:otherwise>
							</c:choose>
								<c:if test="${fn:length(menu3.tailListMenu) > 0 }">
								<ul class="dep3">
								<c:forEach var="menu4" items="${menu3.tailListMenu}" varStatus="status3">
								<c:choose>
								<c:when test="${menu4.menuUrl ne null }">
								<li><a href="${menu4.menuUrl }">${menu4.menuNm }</a>
								</c:when>
								<c:otherwise>
								<li><a href="">${menu4.menuNm }</a>
								</c:otherwise>
								</c:choose>
								</c:forEach>
								</ul>
								</c:if>
							</li>
							</c:forEach>
							</ul>
						</c:if>
						</li>
					</c:forEach>
				</c:if>
			</c:if>
			</c:forEach>

			<script>
				//<![CDATA[
					
				jQuery(function(){
					lnb_menu(${depth2},${depth3},${depth4});//첫번째 1depth , 두 번째 2depth 활성화 , 세 번째 3depth 활성화
				});
				//]]>
			</script>
		</nav>
		<!-- //lnb_menu -->
	</div>
	<!-- //lnb -->
	
	<main class="colgroup" id="colgroup">
		<article>
			<header class="sub_head">
				<div class="sub_title"><h2>
				<c:choose>
				<c:when test="${depth4Nm ne null && depth4Nm ne '' }">
				${depth4Nm }
				</c:when>
				<c:when test="${depth3Nm ne null && depth3Nm ne '' }">
				${depth3Nm }
				</c:when>
				<c:when test="${depth2Nm ne null && depth2Nm ne '' }">
				${depth2Nm }
				</c:when>
				<c:otherwise>
				${depth1Nm }
				</c:otherwise>
				</c:choose>
				</h2></div>
				<div class="path">
					<span class="home">${depth1Nm }</span>
					<c:if test="${depth2Nm ne '' }">
					<a href=""><span>${depth2Nm }</span></a>
					</c:if>
					<c:if test="${depth3Nm ne '' }">
					<a href=""><span>${depth3Nm }</span></a>
					</c:if>
					<c:if test="${depth4Nm ne '' }">
					<a href=""><span>${depth4Nm }</span></a>
					</c:if>
				</div>
			</header>

			<div id="contents">
