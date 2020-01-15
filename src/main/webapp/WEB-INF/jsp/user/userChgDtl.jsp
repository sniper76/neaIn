<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userChgDtl.js"></script>
<script>
//defined screen message
var confirmMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="Do you want save?"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	
	$(function() {
		common.invoker.invoke("List");
	});
</script>

<div id="contents">
<form name="frm" id="frm" method="post">
<table class="bbs_table margin_b_30">
	<caption>Profile - Name, Member Type, Nobile No, E-mail, Job search status, Address</caption>
	<colgroup>
		<col style="width:10%;" />
		<col style="width:15%;" />
		<col style="width:30%;" />
		<col style="width:15%;" />
		<col style="width:30%;" />
	</colgroup>
	<tbody>
	<tr>
		<td rowspan="4" style="vertical-align:middle;">
			<div class="text_center"><img src="../../images/board/dummy_photo.png" alt=" image" /></div>
		</td>
		<th scope="row"><spring:message code="userChg.list.title.userNm" text="Name"></spring:message></th>
		<td>${userChg.user.userNm }</td>
		<th scope="row"><spring:message code="userChg.list.title.userDiv" text="Member Type"></spring:message></th>
		<td>${userChg.user.userAuthNm }</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userChg.list.title.cell" text="Mobile No."></spring:message></th>
		<td>${userChg.user.userCell }</td>
		<th scope="row"><spring:message code="userChg.list.title.age" text="Age"></spring:message>/<spring:message code="userChg.list.title.gender" text="Gender"></spring:message></th>
		<td>${userChg.user.age }/${userChg.user.genderNm }</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userChg.list.title.email" text="E-mail"></spring:message></th>
		<td colspan="3">${userChg.user.userEmail }</td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userChg.list.title.address" text="Address"></spring:message></th>
		<td colspan="3"></td>
	</tr>
	</tbody>
</table>
<div id="tab_contents1" class="tab_contents">
	<div class="bbs_basic">
		<table class="bbs_table view margin_b_20">
			<caption>회원정보</caption>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><spring:message code="userChg.dtl.title.regDt" text="Request Date" /></th>
				<td>${userChg.regDt }</td>
				<th scope="row"><spring:message code="userChg.list.title.agreeDt" text="Agree Date" /></th>
				<td>${userChg.stsChgDt }</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="userChg.dtl.title.chgPrevUserType" text="Previous Type" /></th>
				<td colspan="3">${userChg.chgPrevNm }</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="userChg.dtl.title.chgNextUserType" text="Next Type" /></th>
				<td colspan="3">${userChg.chgNextNm }</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="userChg.dtl.title.reason" text="Reason" /></th>
				<td colspan="3"><c:out value="${userChg.chgReason}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="userChg.dtl.title.agreeSts" text="Status" /></th>
				<td colspan="3"><commCode:commcode codeKind="commCode" tagName="chgAgreeStsCd" grpCd="CHG_AGREE_STS_CD" drawType="select" initValue="${userChg.chgAgreeStsCd }" exceptValue="ALL" disable="${userChg.disable }"/>
				<input type="text" name="agreeRejectReason" id="agreeRejectReason" value="${userChg.agreeRejectReason }" ${user.disable }/>
				</td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->
		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<a href="${pageContext.request.contextPath}/internal/userChg/userChgList.do" class="bbs_btn list"><spring:message code="cpes.btn.list" text="List" /></a>
			</span>
			<c:if test="${userChg.disable ne 'true'}">
			<span class="bbs_right">
				<a class="bbs_btn save" id="saveBtn"><spring:message code="cpes.btn.save" text="Save" /></a>
			</span>
			</c:if>
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->
	</div>
<input type="hidden" name="userChgSeq" id="userChgSeq" value="${userChg.userChgSeq }" />
</form>
</div>

<script>
	$(document).ready(function(){
		List.fn.changeSaveForm();
	});
</script>