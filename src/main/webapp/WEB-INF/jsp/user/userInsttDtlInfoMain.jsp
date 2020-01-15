<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userInsttDtlInfoMain.js"></script>

<script>
$(function() {
	common.invoker.invoke("userInsttDtlInfoMain");
});
</script>

<form id="frmUserInsttDtlInfoMain">
<input type="hidden" id="insttSeq" name="insttSeq" value="<c:out value="${rtnData.insttSeq}" />" />
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnData.userSeq}" />" />
<input type="hidden" id="previousUrl" name="previousUrl" value="<c:out value="${rtnData.previousUrl}" />" />

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
			<div class="text_center"><img src="${pageContext.request.contextPath}/common/imgLoading.do?url=${rtnData.filePath}" alt=" image" /></div>
		</td>
		<th scope="row"><spring:message code="field.dic.insttnm" /></th>
		<td><c:out value="${rtnData.insttNm}" /></td>
		<th scope="row"><spring:message code="field.dic.insttownership" /></th>
		<td><c:out value="${rtnData.insttOwnershipNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="field.dic.instttype" /></th>
		<td><c:out value="${rtnData.insttTypeNm}" /></td>
		<th scope="row"><spring:message code="field.dic.resprsnnm" /></th>
		<td><c:out value="${rtnData.insttMngerNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="field.dic.email" /></th>
		<td><c:out value="${rtnData.insttEmail}" /></td>
		<th scope="row"><spring:message code="field.dic.mobile" /></th>
		<td><c:out value="${rtnData.insttCell}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userChg.list.title.address" /></th>
		<td colspan="3"><c:out value="${rtnData.insttAddrDtl}" /></td>
	</tr>
	</tbody>
</table>

<div class="bbs_tab action">
	<ul class="clearfix">
		<li class="on"><a href="#" id="tabUserDtlInfo" name="tabUserDtlInfo" onclick="tabUserDtlInfo();"><spring:message code="field.dic.user.info" /></a></li>
		<li><a href="#" id="tabProfileDtlInfo" name="tabProfileDtlInfo" onclick="tabProfileDtlInfo();"><spring:message code="field.dic.user.profile" /></a></li>
		<li><a href="#" id="tabTrnngProgDtlInfo" name="tabTrnngProgDtlInfo" onclick="tabTrnngProgDtlInfo();"><spring:message code="field.dic.trnng.prog" /></a></li>
		<li><a href="#" id="tabCounselInfo" name="tabCounselInfo" onclick="tabCounselInfo();"><spring:message code="field.dic.councsel.list" /></a></li>
		<li><a href="#" id="tabJobfairDtlInfo" name="tabJobfairDtlInfo" onclick="tabJobfairDtlInfo();"><spring:message code="field.dic.jobfair.list" /></a></li>
	</ul>
</div>

<div id="innerDtlInfo">
</div>

<!--  
<div id="innerUserDtlInfo">
</div>

<div id="innerProfileDtlInfo">
</div>

<div id="innerTrnngProgDtlInfo">
</div>

<div id="innerCounselInfo">
</div>

<div id="innerJobfairDtlInfo">
</div>
-->

</form>