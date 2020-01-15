<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/menuMngList.js"></script>

<script>
<c:if test="${menuBean.rangeCd eq 'RNG0000000002'}">
var menuListPage = "menuMngInternalList";
var menuRegPage = "menuMngInternalReg";
</c:if>

<c:if test="${menuBean.rangeCd eq 'RNG0000000003'}">
var menuListPage = "menuMngExternalList";
var menuRegPage = "menuMngExternalReg";
</c:if>
	$(function() {
		common.invoker.invoke("menuMngList");
	});
</script>
<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="searchFrm">
		<input type="hidden" name="rangeCd"	id="rangeCd" value="${menuBean.rangeCd}" />
		<input type="hidden" name="menuCd" id="menuCd" value="" />
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<colgroup>
						<col style="width:12%;" />
						<col style="width:38%;" />
						<col style="width:12%;" />
						<col style="width:38%;" />
					</colgroup>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
						<td colspan="3">
							<commCode:commcode codeKind="commCode" tagName="searchKeyword" grpCd="SCH_FRM_INTERNAL_MENU_CD" drawType="select" initValue="" exceptValue="ALL" disable=""/>
							<input type="text" name="searchValue"  name="searchValue" value="" />
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
						<td colspan="3">
							<select name="menuLvl" id="menuLvl">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</td>
					</tr>
					</tbody>
				</table>
				<div class="put_box">
					<button type="button" class="open_detail">Open Detail Search</button>  
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
			<!-- Selected hidden value -->
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="myTable" class="bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:15%;" />
			<col style="width:15%;" />
			<col style="width:5%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:5%;" />
			<col style="width:32%;" />
			<col style="width:8%;" />
		</colgroup>
		<thead>
		<tr>
			<th scope="col"><spring:message code="userChg.list.title.no"></spring:message></th>
			<th scope="col"><spring:message code="menu.menunm.kh" /></th>
			<th scope="col"><spring:message code="menu.menunm.en" /></th>
			<th scope="col"><spring:message code="menu.menunm.depth" /></th>
			<th scope="col"><spring:message code="menu.menunm.menuid" /></th>
			<th scope="col"><spring:message code="menu.menunm.upper.menuid" /></th>
			<th scope="col"><spring:message code="menu.menunm.sort" /></th>
			<th scope="col"><spring:message code="menu.menunm.url" /></th>
			<th scope="col"><spring:message code="field.dic.reg.dt" /></th>
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<!-- //Data List Zone: End -->
<div class="bbs_btn_wrap clearfix">
	<span class="bbs_right">
		<input type="button" value="<spring:message code="button.create" />" id="btnReg" class="bbs_btn type03 registration" />
	</span>
</div>