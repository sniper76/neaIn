<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userCmpnyDtlInfoProfile.js"></script>

<script>
$(function() {
	common.invoker.invoke("userCmpnyDtlInfoProfile");
});
</script>

<form id="frmUserDtlInfoProfile">
<input type="hidden" id="compnySeq" name="compnySeq" value="<c:out value="${rtnProfData.compnySeq}" />" />

	<!-- <h3></h3> -->
	<div class="bbs_basic">
		<table class="bbs_table view margin_b_20">
			<caption>company</caption>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><spring:message code="field.dic.compny.intro" /></th>
				<td colspan="3"><c:out value="${rtnProfData.profile}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.compny.history" /></th>
				<td colspan="3"><c:out value="${rtnProfData.compnyHis}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.compny.img" /></th>
				<td colspan="3" style="color:red">Need to Add, Later</td>
			</tr>	
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<button type="button" class="bbs_btn list" onclick="fnGoPageCompnyInfoListBack();"><spring:message code="button.list" /></button>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->

</form>