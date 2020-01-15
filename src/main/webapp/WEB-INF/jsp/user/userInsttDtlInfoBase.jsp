<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userInsttDtlInfoBase.js"></script>

<script>
$(function() {
	common.invoker.invoke("userInsttDtlInfoBase");
});

$("#userDtlInfoModifyBtn").click(function(){
	goDetil();
});
</script>

<form id="frmUserInsttDeatilInfoBase">
<!--  
<input type="hidden" id="insttSeq" name="insttSeq" value="<c:out value="${rtnData.insttSeq}" />" />
-->
	<h3>Account information</h3>
	<div class="bbs_basic">
		<table class="bbs_table view margin_b_20">
			<caption>Account information - Name, Membership status, e-mail, Moblie No., Password, Membership Registration Path</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><spring:message code="field.dic.insttnm" /></th>
				<td colspan="3"><c:out value="${rtnData.insttNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.insttownership" /></th>
				<td><c:out value="${rtnData.insttOwnershipNm}" /></td>
				<th scope="row"><spring:message code="field.dic.instttype" /></th>
				<td><c:out value="${rtnData.insttTypeNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.license" />/<spring:message code="field.dic.regno" /></th>
				<td colspan="3"><c:out value="${rtnData.insttRegNum}" /></td>
			</tr>			
			<tr>
				<th scope="row"><spring:message code="userChg.list.title.address" /></th>
				<td colspan="3"><c:out value="${rtnData.insttAddrDtl}" /></td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->
		
		<h3>Contact Information</h3>
		<table class="bbs_table view">
			<caption>Other Member Information - Gender, date of birth, ID Number, Current address Detailed address</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><spring:message code="field.dic.resprsnnm" /></th>
				<td colspan="3"><c:out value="${rtnData.insttMngerNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.mobile" /></th>
				<td><c:out value="${rtnData.insttCell}" /></td>			
				<th scope="row"><spring:message code="field.dic.email" /></th>
				<td><c:out value="${rtnData.insttEmail}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.authcmplt" /> / <spring:message code="field.dic.route" /></th>
				<td colspan="3"><c:out value="${rtnData.authCmpltYn}" /> / <c:out value="${rtnData.smsEmailAuthDivNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.officetel" /></th>
				<td><c:out value="${rtnData.insttOfficeTel}" /></td>			
				<th scope="row"><spring:message code="field.dic.fax" /></th>
				<td><c:out value="${rtnData.insttFax}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.website" /></th>
				<td colspan="3"><c:out value="${rtnData.insttWebsite}" /></td>			
			</tr>						
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<button type="button" class="bbs_btn list" onclick="fnGoPageUserInsttInfoListBack();"><spring:message code="button.list" /></button>
			</span>
			<span class="bbs_right">
				<input type="button" value="<spring:message code="cpes.btn.modify" />" class="bbs_btn modify" id="userDtlInfoModifyBtn" />
			</span>			
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->

</form>