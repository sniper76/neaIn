<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/annualPlan/APIndicDataResultInsert.js"></script>

<script>
$(function() {
	common.invoker.invoke("APIndicDataResultInsert");
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
							<th scope="row">Job Center</th>
							<td colspan="3">
								<select id="jcCd" name="jcCd">
									<c:forEach items="${jobCenter }" var="jobCenter">
										<option value="${jobCenter.jcCd }" <c:if test="${jobCenter.jcCd eq param.jcCd}">selected="selected"</c:if>>
											<c:out value="${jobCenter.jcEn }" />
										</option>
									</c:forEach>
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
		<button type="button" id="btnSearch" class="bbs_btn save" >검색</button>
	</span>
</div>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box" style="overflow-x: scroll;">
		<fieldset>
			<table>
				<caption>Contents Search - Search, User Type, Period</caption>
				<%-- <colgroup>
					<col style="width:30%;" />
					<col style="width:30%;" />
					<col style="width:30%;" />
				</colgroup> --%>
				<thead>
					<tr>
						<th scope="row" rowspan="2">1 Depth</th>
						<th scope="row" rowspan="2">2 Depth</th>
						<th scope="row" rowspan="2">3 Depth</th>
						<th scope="row" colspan="2">JAN</th>
						<th scope="row" colspan="2">FEB</th>
						<th scope="row" colspan="2">MAR</th>
						<th scope="row" colspan="2">APR</th>
						<th scope="row" colspan="2">MAY</th>
						<th scope="row" colspan="2">JUN</th>
						<th scope="row" colspan="2">JUL</th>
						<th scope="row" colspan="2">AUG</th>
						<th scope="row" colspan="2">SEP</th>
						<th scope="row" colspan="2">OCT</th>
						<th scope="row" colspan="2">NOV</th>
						<th scope="row" colspan="2">DEC</th>
					</tr>
					<tr>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
						<th scope="row">Target</th>
						<th scope="row">Result</th>
					</tr>
				</thead>
				<tbody id="data_tbody">
					<c:if test="${empty resultList }">
						<tr>
							<td colspan="27" class="" style="text-align: center;">no data.</td>
						</tr>
					</c:if>
					<c:forEach items="${resultList }" var="result">
						<tr>
							<td scope="row" colspan="3" class="" style="text-align: left;">
								<c:out value="${result.indicItemNm }" />
								<input type="hidden" class="yearBaseIndicSeq" value="${result.yearBaseIndicSeq }">
							</td>
							<c:forEach items="${result.dataList }" var="dataList">
								<td class="month">
									<c:out value="${dataList.content }" />
								</td>
								<td class="result">
									<c:if test="${not empty dataList.content}">
										<input type="text" class="${dataList.month }" value="${dataList.result }">
										<input type="hidden" class="indicDataSeq" value="${dataList.indicDataSeq }">
									</c:if>
								</td>
							</c:forEach>
						</tr>
						<c:forEach items="${result.underList }" var="depth2">
							<tr>
								<td scope="row" colspan="3" class="" style="text-align: center;">
									<c:out value="${depth2.indicItemNm }" />
									<input type="hidden" class="yearBaseIndicSeq" value="${depth2.yearBaseIndicSeq }">
								</td>
								<c:forEach items="${depth2.dataList }" var="dataList">
									<td class="month">
										<c:out value="${dataList.content }" />
									</td>
									<td class="result">
										<c:if test="${not empty dataList.content}">
											<input type="text" class="${dataList.month }" value="${dataList.result }">
											<input type="hidden" class="indicDataSeq" value="${dataList.indicDataSeq }">
										</c:if>
									</td>
								</c:forEach>
							</tr>
							<c:forEach items="${depth2.underList}" var="depth3">
								<tr>
									<td scope="row" colspan="3" class="" style="text-align: right;">
										<c:out value="${depth3.indicItemNm }" />
										<input type="hidden" class="yearBaseIndicSeq" value="${depth3.yearBaseIndicSeq }">
									</td>
									<c:forEach items="${depth3.dataList }" var="dataList">
										<td class="month">
											<c:out value="${dataList.content }" />
										</td>
										<td class="result">
											<c:if test="${not empty dataList.content}">
												<input type="text" class="${dataList.month }" value="${dataList.result }">
												<input type="hidden" class="indicDataSeq" value="${dataList.indicDataSeq }">
											</c:if>
										</td>
									</c:forEach>
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

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
	</span>
	<span class="bbs_right">
		<button type="button" id="btnSave" class="bbs_btn save" >저장</button>
	</span>
</div>