<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/lmi/lmiList.js"></script>

<script>
$(function() {
	common.invoker.invoke("lmiList");
});
</script>

<div class="bbs_btn_wrap clearfix">
	<form id="selectForm">
		<input type="hidden" id="year" name="year" value="${year }">
		<span class="bbs_left">
			<button type="button" id="preYear" class="bbs_btn save">pre</button>
			<span><c:out value="${year }" /></span>
			<button type="button" id="nextYear" class="bbs_btn save">next</button>
		</span>
	</form>
</div>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<fieldset>
			<table>
				<caption>Contents Search - Search, User Type, Period</caption>
				<colgroup>
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:40%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="row">1 Depth</th>
						<th scope="row">2 Depth</th>
						<th scope="row">3 Depth</th>
						<th scope="row">Value</th>
					</tr>
				</thead>
				<tbody id="data_tbody">
					<c:if test="${empty resultList }">
						<tr>
							<td colspan="4" class="" style="text-align: center;">no data.</td>
						</tr>
					</c:if>
					<c:forEach items="${resultList }" var="result">
						<tr>
							<th scope="row" colspan="3" class="" style="text-align: left;"><c:out value="${result.indicItemNm }" /></th>
							<td>
								<c:out value="${result.content }" />
							</td>
						</tr>
						<c:forEach items="${result.underList }" var="depth2">
							<tr>
								<th scope="row" colspan="3" class="" style="text-align: center;"><c:out value="${depth2.indicItemNm }" /></th>
								<td>
									<c:out value="${depth2.content }" />
								</td>
							</tr>
							<c:forEach items="${depth2.underList}" var="depth3">
								<tr>
									<th scope="row" colspan="3" class="" style="text-align: right;"><c:out value="${depth3.indicItemNm }" /></th>
									<td>
										<c:out value="${depth3.content }" />
									</td>
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
