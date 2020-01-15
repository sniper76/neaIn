<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/annualPlan/APList.js"></script>

<script>
$(function() {
	common.invoker.invoke("APList");
});
</script>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="selectForm">
			<fieldset>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<colgroup>
						<col style="width:20%;" />
						<col style="width:80%;" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">Year</th>
							<td colspan="3">
								<input type="text" id="year" name="year" class="inputNo" value="${param.year }">
							</td>
						</tr>
						<tr>
							<th scope="row">Title</th>
							<td colspan="3">
								<input type="text" id="title" name="title" value="${param.title }">
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
			<!-- Selected hidden value -->
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
	</span>
	<span class="bbs_right">
		<button type="button" id="btnSelect" class="bbs_btn save" >검색</button>
	</span>
</div>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<fieldset>
			<table>
				<caption>Contents Search - Search, User Type, Period</caption>
				<colgroup>
					<col style="width:20%;" />
					<col style="width:80%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="row">No.</th>
						<th scope="row">Title</th>
					</tr>
				</thead>
				<tbody id="data_tbody">
					<c:if test="">
						<tr>
							<th scope="row" colspan="2">No Data.</th>
						</tr>
					</c:if>
					<c:forEach items="${resultList }" var="result">
						<tr>
							<td><c:out value="${result.number }" /></td>
							<td><c:out value="${result.title }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
			<!-- Selected hidden value -->
	</div>
	<!-- //contents_box -->
</div>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
	</span>
	<span class="bbs_right">
		<button type="button" id="btnInsert" class="bbs_btn save" >지표 등록</button>
	</span>
</div>
