<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/mngerJcDetailInfo.js"></script>

<script>
	$(function() {
		common.invoker.invoke("mngerJcDetailInfo");
	});
</script>
<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="searchFrm">
		<input type="hidden" name="userSeq"			id="userSeq" value="${user.userSeq}"/>
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
							<th scope="row"><spring:message code="field.dic.instt" /></th>
							<td colspan="3">
							<c:choose>
								<c:when test="${user.neaJcDivCd eq 'NJD0000000001' && user.nonNeaYn eq 'N'}">
								NEA
								</c:when>
								<c:when test="${user.neaJcDivCd eq 'NJD0000000001' && user.nonNeaYn eq 'Y'}">
								Non NEA
								</c:when>
							</c:choose>
							</td>
						</tr>
						<tr>
							<th scope="row"><spring:message code="field.dic.employer" /><spring:message code="field.dic.name" /></th>
							<td><c:out value="${user.userNmKh}" /> (Eng. <c:out value="${user.userNmEn}" />)</td>
							<th scope="row"><spring:message code="field.dic.gender" /></th>
							<td>${user.genderNm }</td>
						</tr>
						<tr>
							<th scope="row"><spring:message code="field.dic.mngid" /></th>
							<td colspan="3">${user.mngId }</td>
						</tr>
						<tr>
							<th scope="row"><spring:message code="title.sample.useYn" /></th>
							<td colspan="3">${user.useYn }</td>
						</tr>
					</tbody>
				</table>
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
<div class="bbs_basic">
	<table id="myTable" class="display dataTable bbs_table list">
		<caption>myTable</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:20%;" />
			<col style="width:20%;" />
			<col style="width:20%;" />
			<col style="width:25%;" />
		</colgroup>
		<thead>
		<tr>
			<th scope="col">1Depth</th>
			<th scope="col">2Depth</th>
			<th scope="col">3Depth</th>
			<th scope="col">4Depth</th>
			<th scope="col"><spring:message code="field.dic.page" /><spring:message code="field.dic.name" /></th>
		</tr>
		</thead>
		<tbody id="authList">
			
		</tbody>
	</table>
</div>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_right">
		<input type="button" value="<spring:message code="button.create" />" id="btnReg" class="bbs_btn type03 registration" />
	</span>
</div>