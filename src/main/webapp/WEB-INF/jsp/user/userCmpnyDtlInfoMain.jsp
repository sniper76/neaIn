<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userCmpnyDtlInfoMain.js"></script>

<script>
$(function() {
	common.invoker.invoke("userCmpnyDtlInfoMain");
});
</script>

<form id="frmUserCmpnyDtlInfoMain">
<input type="hidden" id="compnySeq" name="compnySeq" value="<c:out value="${rtnMainData.compnySeq}" />" />
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnMainData.userSeq}" />" />
<input type="hidden" id="previousUrl" name="previousUrl" value="<c:out value="${rtnMainData.previousUrl}" />" />

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
		<td rowspan="5" style="vertical-align:middle;">
			<div class="text_center"><img src="${pageContext.request.contextPath}/common/imgLoading.do?url=${rtnMainData.filePath}" alt=" image" /></div>
		</td>
		<th scope="row"><spring:message code="field.dic.company.name" />/<spring:message code="field.dic.reg.num" /></th>
		<td><c:out value="${rtnMainData.compnyNm}" /> / <c:out value="${rtnMainData.regNum}" /></td>
		<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
		<td><c:out value="${rtnMainData.jcNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="field.dic.compny.type" /></th>
		<td><c:out value="${rtnMainData.compnyTypeNm}" /></td>
		<th scope="row"><spring:message code="field.dic.resprsnnm" /></th>
		<td><c:out value="${rtnMainData.mngerNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="field.dic.email" /></th>
		<td><c:out value="${rtnMainData.mngerEmail}" /></td>
		<th scope="row"><spring:message code="field.dic.mobile" /></th>
		<td><c:out value="${rtnMainData.mngerCell}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userChg.list.title.address" /></th>
		<td colspan="3"><c:out value="${rtnMainData.addrDtl}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="field.dic.bkmk.cnt" /></th>
		<td><c:out value="${rtnMainData.bkmkCnt}" /></td>
		<th scope="row"><spring:message code="field.dic.like.cnt" /></th>
		<td><c:out value="${rtnMainData.likeCnt}" /></td>
	</tr>	
	</tbody>
</table>

<div class="bbs_tab action">
	<ul class="clearfix">
		<li class="on"><a href="#" id="tabUserDtlInfo" name="tabUserDtlInfo" onclick="tabUserDtlInfo();"><spring:message code="field.dic.user.info" /></a></li>
		<li><a href="#" id="tabProfileDtlInfo" name="tabProfileDtlInfo" onclick="tabProfileDtlInfo();"><spring:message code="field.dic.user.profile" /></a></li>
		<li><a href="#" id="tabVccyDtlInfo" name="tabVccyDtlInfo" onclick="tabVccyDtlInfo();"><spring:message code="field.dic.hrsk.list" /></a></li>
		<li><a href="#" id="tabAplcDtlInfo" name="tabAplcDtlInfo" onclick="tabAplcDtlInfo();"><spring:message code="field.dic.join.cmpny.app.list" /></a></li>
		<li><a href="#" id="tabOfferDtlInfo" name="tabOfferDtlInfo" onclick="tabOfferDtlInfo();"><spring:message code="field.dic.join.cmpny.sgtn.list" /></a></li>
		<li><a href="#" id="tabIntvwDtlInfo" name="tabIntvwDtlInfo" onclick="tabIntvwDtlInfo();"><spring:message code="field.dic.interview.sgtn.list" /></a></li>
		<li><a href="#" id="tabCounselDtlInfo" name="tabCounselDtlInfo" onclick="tabCounselDtlInfo();"><spring:message code="field.dic.councsel.list" /></a></li>
		<li><a href="#" id="tabJobfairDtlInfo" name="tabJobfairDtlInfo" onclick="tabJobfairDtlInfo();"><spring:message code="field.dic.jobfair.list" /></a></li>
	</ul>
</div>

<div id="innerDtlInfo">
</div>

<!--  
<div id="innerUserDtlDtlInfo">
</div>

<div id="innerProfileDtlInfo">
</div>

<div id="innerVccyDtlInfo">
</div>

<div id="innerAplcDtlInfo">
</div>

<div id="innerOfferDtlInfo">
</div>

<div id="innerIntvwDtlInfo">
</div>

<div id="innerCounselDtlInfo">
</div>

<div id="innerJobfairDtlInfo">
</div>
-->

</form>