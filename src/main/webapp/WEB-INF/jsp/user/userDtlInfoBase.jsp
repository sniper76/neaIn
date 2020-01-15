<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userDtlInfoBase.js"></script>

<script>
$(function() {
	common.invoker.invoke("userDetailInfoBase");
});


$("#userDtlInfoModifyBtn").click(function(){
	goDetil();
});
</script>

<form id="frmUserDtlInfoBase">
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${resultUserBase.userSeq}" />" />

	<h3>Account information</h3>
	<div class="bbs_basic">
		<table class="bbs_table view margin_b_20">
			<caption>Account information - Name, Membership status, e-mail, Moblie No., Password, Membership Registration Path</caption>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><spring:message code="search.name" /></th>
				<td><c:out value="${resultUserBase.userNm}" /></td>
				<th scope="row"><spring:message code="field.dic.usrsts" /></th>
				<td><c:out value="${resultUserBase.userStsNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.email" /></th>
				<td colspan="3"><c:out value="${resultUserBase.userEmail}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.mobile" /></th>
				<td colspan="3"><c:out value="${resultUserBase.userCell}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.authcmplt" /> / <spring:message code="field.dic.route" /></th>
				<td colspan="3"><c:out value="${resultUserBase.authCmpltYn}" /> / <c:out value="${resultUserBase.smsEmailAuthDivNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.joinroute" /></th>
				<td colspan="3"><c:out value="${resultUserBase.joinRouteDivNm}" /></td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->
		
		<h3>Other Member Information</h3>
		<table class="bbs_table view">
			<caption>Other Member Information - Gender, date of birth, ID Number, Current address Detailed address</caption>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><spring:message code="field.dic.gender" /></th>
				<td><c:out value="${resultUserBase.genderNm}" /></td>
				<th scope="row"><spring:message code="field.dic.birth" /></th>
				<td><c:out value="${resultUserBase.birth}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.sid" /></th>
				<td colspan="3"><c:out value="${resultUserBase.nid}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.current.addr" /> <br /><spring:message code="field.dic.dtladdr" /></th>
				<td colspan="3"><c:out value="${resultUserBase.addrDtl}" /></td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<button type="button" class="bbs_btn list" onclick="fnGoPageUserInfoListBack();"><spring:message code="button.list" /></button>
			</span>
			<span class="bbs_right">
				<input type="button" value="<spring:message code="cpes.btn.modify" />" class="bbs_btn modify" id="userDtlInfoModifyBtn" />
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->

</form>