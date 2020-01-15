<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/annualPlan/APInsert.js"></script>

<script>
$(function() {
	common.invoker.invoke("APInsert");
});
</script>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
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
							<th scope="row">제목</th>
							<td colspan="3">
								<input type="text" id="title" name="title" value="${param.title }">
							</td>
						</tr>
						<tr>
							<th scope="row">항목명</th>
							<td colspan="3">
								<input type="text" id="indicItemNm" name="indicItemNm" value="${param.indicItemNm }">
							</td>
						</tr>
						<tr>
							<th scope="row">depth</th>
							<td colspan="3">
								<select id="depth" name="depth">
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">상위 지표</th>
							<td colspan="3">
								<select id="depth_1" name="depth_1" style="display: none;">
									<option>select</option>
								</select>
								<select id="depth_2" name="depth_2" style="display: none;">
									<option>select</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<!-- Selected hidden value -->
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
	</span>
	<span class="bbs_right">
		<button type="button" id="btnSave" class="bbs_btn save" >저장</button>
	</span>
</div>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<fieldset>
			<table>
				<caption>Contents Search - Search, User Type, Period</caption>
				<colgroup>
					<col style="width:30%;" />
					<col style="width:30%;" />
					<col style="width:30%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="row">1 Depth</th>
						<th scope="row">2 Depth</th>
						<th scope="row">3 Depth</th>
					</tr>
				</thead>
				<tbody id="data_tbody">
					<c:if test="${empty resultList }">
						<tr>
							<td colspan="3" class="" style="text-align: center;">no data.</td>
						</tr>
					</c:if>
					<c:forEach items="${resultList }" var="result">
						<tr>
							<th scope="row" colspan="3" class="" style="text-align: left;"><c:out value="${result.indicItemNm }" /></th>
						</tr>
						<c:forEach items="${result.underList }" var="depth2">
							<tr>
								<th scope="row" colspan="3" class="" style="text-align: center;"><c:out value="${depth2.indicItemNm }" /></th>
							</tr>
							<c:forEach items="${depth2.underList}" var="depth3">
								<tr>
									<th scope="row" colspan="3" class="" style="text-align: right;"><c:out value="${depth3.indicItemNm }" /></th>
								</tr>
							</c:forEach>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
			<!-- Selected hidden value -->
	</div>
	<!-- //contents_box -->
</div>