<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userElementaryDtlInfoBase.js"></script>

<script>
$(function() {
	common.invoker.invoke("userElementaryDtlInfoBase");
});


$("#userDtlInfoModifyBtn").click(function(){
	goDetil();
});
</script>

<form id="frmUserElementaryDtlInfoBase">
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnBase.userSeq}" />" />

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
				<th scope="row"><spring:message code="search.name" /> (Khmer)</th>
				<td><c:out value="${rtnBase.userNmKh}" /></td>
				<th scope="row"><spring:message code="search.name" /> (English)</th>
				<td><c:out value="${rtnBase.userNmEn}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.mobile" /></th>
				<td><c:out value="${rtnBase.userCell}" /></td>
				<th scope="row"><spring:message code="field.dic.usrsts" /></th>
				<td><c:out value="${rtnBase.userStsNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.authcmplt" /> / <spring:message code="field.dic.route" /></th>
				<td><c:out value="${rtnBase.authCmpltYn}" /> / <c:out value="${rtnBase.smsEmailAuthDivNm}" /></td>
				<th scope="row"><spring:message code="field.dic.joinroute" /></th>
				<td><c:out value="${rtnBase.joinRouteDivNm}" /></td>
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
				<td><c:out value="${rtnBase.genderNm}" /></td>
				<th scope="row"><spring:message code="field.dic.birth" /></th>
				<td><c:out value="${rtnBase.birth}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.sid" /></th>
				<td colspan="3"><c:out value="${rtnBase.nid}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.current.addr" /> <br /><spring:message code="field.dic.dtladdr" /></th>
				<td colspan="3"><c:out value="${rtnBase.addrDtl}" />&nbsp;&nbsp;${rtnBase.addrFullNm}</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.sms.agree" /></th>
				<td colspan="3"><c:out value="${rtnBase.smsNtceAgreeYn}" /></td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<a href="#" class="bbs_btn list" onclick="fnGoPageUserInfoListBack();"><spring:message code="button.list" /></a>
			</span>
			<span class="bbs_right">
				<button type="button" id="btnUserInfoModify" class="bbs_btn modify" onclick="fnUserInfoModify();"><spring:message code="button.modify" /></button>
				<button type="button" id="btnUserTypeModify" class="bbs_btn modify" onclick="fnUserTypeModify();"><spring:message code="field.dic.user.type.modify" /></button>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->

</form>