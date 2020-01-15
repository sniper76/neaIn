<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userDtlInfoMain.js"></script>

<script>
$(function() {
	common.invoker.invoke("userDtlInfoMain");
});
</script>

<form name="frmUserDtlInfoMain" id="frmUserDtlInfoMain">
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${resultUserMain.userSeq}" />" />
<input type="hidden" id="previousUrl" name="previousUrl" value="<c:out value="${resultUserMain.previousUrl}" />" />

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
			<div class="text_center"><img src="${pageContext.request.contextPath}/common/imgLoading.do?url=${resultUserMain.filePath}" alt=" image" /></div>
		</td>
		<th scope="row"><spring:message code="search.name" /> / <spring:message code="field.dic.usrtype" /></th>
		<td><c:out value="${resultUserMain.userNm}" /> / <c:out value="${resultUserMain.userAuthNm}" /></td>
		<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
		<td><c:out value="${resultUserMain.jcNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="field.dic.mobile" /></th>
		<td><c:out value="${resultUserMain.userCell}" /></td>
		<th scope="row"><spring:message code="field.dic.age" /> / <spring:message code="field.dic.gender" /></th>
		<td><c:out value="${resultUserMain.age}" /> / <c:out value="${resultUserMain.genderNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="field.dic.email" /></th>
		<td><c:out value="${resultUserMain.userEmail}" /></td>
		<th scope="row"><spring:message code="field.dic.jobsksts" /></th>
		<td><c:out value="${resultUserMain.jobskStsNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userChg.list.title.address" /></th>
		<td colspan="3"><c:out value="${resultUserMain.addrDtl}" /></td>
	</tr>
	</tbody>
</table>

<div class="bbs_tab action">
	<ul class="clearfix">
		<li class="on"><a href="#" id="tabUserDtlInfo" name="tabUserDtlInfo" onclick="tabUserDtlInfo();"><spring:message code="field.dic.user.info" /></a></li>
		<li><a href="#" id="tabResumeDtlInfo" name="tabResumeDtlInfo" onclick="tabResumeDtlInfo();"><spring:message code="field.dic.main.resume" /></a></li>
		<li><a href="#" id="tabJobskDtlInfo" name="tabJobskDtlInfo" onclick="tabJobskDtlInfo();"><spring:message code="field.dic.jobsk.list" /></a></li>
		<li><a href="#" id="tabAplcDtlInfo" name="tabAplcDtlInfo" onclick="tabAplcDtlInfo();"><spring:message code="field.dic.join.cmpny.app.list" /></a></li>
		<li><a href="#" id="tabOfferDtlInfo" name="tabOfferDtlInfo" onclick="tabOfferDtlInfo();"><spring:message code="field.dic.join.cmpny.sgtn.list" /></a></li>
		<li><a href="#" id="tabIntvwDtlInfo" name="tabIntvwDtlInfo" onclick="tabIntvwDtlInfo();"><spring:message code="field.dic.interview.sgtn.list" /></a></li>
		<li><a href="#" id="tabReferralDtlInfo" name="tabReferralDtlInfo" onclick="tabReferralDtlInfo();"><spring:message code="field.dic.referral.list" /></a></li>
		<li><a href="#" id="tabCounselDtlInfo" name="tabCounselDtlInfo" onclick="tabCounselDtlInfo();"><spring:message code="field.dic.councsel.list" /></a></li>
		<li><a href="#" id="tabJobfairDtlInfo" name="tabJobfairDtlInfo" onclick="tabJobfairDtlInfo();"><spring:message code="field.dic.jobfair.list" /></a></li>
	</ul>
</div>

<div id="innerDtlInfo">
</div>

<!--  
<div id="innerUserDtlInfoBase">
</div>

<div id="innerResumeDtlInfo">
</div>

<div id="innerJobskDtlInfo">
</div>

<div id="innerAplcDtlInfo">
</div>

<div id="innerOfferDtlInfo">
</div>

<div id="innerIntvwDtlInfo">
</div>

<div id="innerReferralDtlInfo">
</div>

<div id="innerCounselDtlInfo">
</div>

<div id="innerJobfairDtlInfo">
</div>
-->

</form>