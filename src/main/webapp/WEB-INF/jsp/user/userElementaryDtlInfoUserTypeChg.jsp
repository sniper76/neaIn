<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userElementaryDtlInfoUserTypeChg.js"></script>

<script>
$(function() {
	common.invoker.invoke("userElementaryDtlInfoUserTypeChg");
});


$("#userDtlInfoModifyBtn").click(function(){
	goDetil();
});


var msgErrUserEmailEmpty = '<spring:message code="msg.err.user.email.empty" text=""></spring:message>';
var msgErrChgReasonEmpty = '<spring:message code="msg.err.chg.reason.empty" text=""></spring:message>';

</script>

<form id="frmUserElementaryDtlInfoUserTypeChg">

	<h3><spring:message code="field.dic.user.type.chg" /></h3>
	<div class="bbs_basic">

		<table class="bbs_table view">
			<caption><spring:message code="field.dic.user.type.chg" /></caption>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><spring:message code="field.dic.email" /></th>
				<td colspan="3">
					<input type="text" name="userEmail" id="userEmail" value="<c:out value="${rtnData.userEmail}" />" style="width:30%"/>
				</td>
				<!--  
				<th scope="row"><spring:message code="userChg.list.title.agreeDt" /></th>
				<td>
					<input type="text" name="saveDt" id="saveDt" value="" disabled="disabled" />
				</td>
				-->
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.before.user.type.chg" /></th>
				<td>
					<input type="hidden" id="beforeUserAuthCd" name="beforeUserAuthCd" value="<c:out value="${rtnData.userAuthCd}" />" />
					<c:out value="${rtnData.userAuthNm}" />
				</td>
				<th scope="row"><spring:message code="field.dic.after.user.type.chg" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="afterUserAuthCd" grpCd="USER_AUTH_CD" drawType="select" initValue="" exceptValue="ALL,ROLE_ADMIN,ROLE_CMPNY,ROLE_TRNCT,ROLE_USER" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.user.type.chg.reason" /></th>
				<td colspan="3">
					<textarea id="chgReason" name="chgReason"></textarea>
				</td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<a href="#" class="bbs_btn list" onclick="fnGoPageUserInfoListBack();"><spring:message code="button.list" /></a>
			</span>
			<span class="bbs_right">
				<button type="button" id="btnUserTypeChgSave" class="bbs_btn save" onclick="fnUserTypeChgSave();"><spring:message code="cpes.btn.save" /></button>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->

</form>