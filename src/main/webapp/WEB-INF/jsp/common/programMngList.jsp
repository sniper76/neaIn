<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/programMngList.js"></script>

<script>
	$(function() {
		common.invoker.invoke("programMngList");
	});
</script>
<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="searchFrm">
		<input type="hidden" name="rangeCd"			id="rangeCd" value="${rangeCd}"/>
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
						<th scope="row"><spring:message code="search.keyword" /></th>
						<td colspan="3">
							<commCode:commcode codeKind="commCode" tagName="searchKeyword" grpCd="SCH_FRM_INTERNAL_PROGRAM_CD" drawType="select" initValue="" exceptValue="ALL" disable=""/>
							<input type="text" id="searchValue" name="searchValue" value=""/>
						</td>
					</tr>
					</tbody>
				</table>
				<div class="put_box">
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
			<!-- Selected hidden value -->
 		</form>
 		<form id="paramFrm">
 			<input type="hidden" name="programSeq"		id="programSeq" value="" />
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="myTable" class="display dataTable bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:10%;" />
			<col style="width:20%;" />
			<col style="width:30%;" />
			<col style="width:5%;" />
			<col style="width:15%;" />
			<col style="width:15%;" />
		</colgroup>
		<thead>
		<tr>
			<th scope="col"><spring:message code="userChg.list.title.no"></spring:message></th>
			<th scope="col"><spring:message code="program.programtitle.id" /></th>
			<th scope="col"><spring:message code="program.programtitle.nm" /></th>
			<th scope="col"><spring:message code="menu.menunm.url" /></th>
			<th scope="col"><spring:message code="title.sample.useYn" /></th>
			<th scope="col"><spring:message code="title.sample.regUser" /></th>
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