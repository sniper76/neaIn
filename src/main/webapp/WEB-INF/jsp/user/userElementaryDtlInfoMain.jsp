<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userElementaryDtlInfoMain.js"></script>

<script>
$(function() {
	common.invoker.invoke("userElementaryDtlInfoMain");
});
</script>

<form name="frmUserElementaryDtlInfoMain" id="frmUserElementaryDtlInfoMain">
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnMain.userSeq}" />" />
<input type="hidden" id="previousUrl" name="previousUrl" value="<c:out value="${rtnMain.previousUrl}" />" />

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
			<div class="text_center"><img src="${pageContext.request.contextPath}/common/imgLoading.do?url=${rtnMain.filePath}" alt=" image" /></div>
		</td>
		<th scope="row"><spring:message code="search.name" /> / <spring:message code="field.dic.usrtype" /></th>
		<td><c:out value="${rtnMain.userNm}" /> / <c:out value="${rtnMain.userAuthNm}" /></td>
		<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
		<td><c:out value="${rtnMain.jcNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="field.dic.mobile" /></th>
		<td><c:out value="${rtnMain.userCell}" /></td>
		<th scope="row"><spring:message code="field.dic.age" /> / <spring:message code="field.dic.gender" /></th>
		<td><c:out value="${rtnMain.age}" /> / <c:out value="${rtnMain.genderNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="field.dic.email" /></th>
		<td><c:out value="${rtnMain.userEmail}" /></td>
		<th scope="row"><spring:message code="field.dic.jobsksts" /></th>
		<td><c:out value="${rtnMain.jobskStsNm}" /></td>
	</tr>
	<tr>
		<th scope="row"><spring:message code="userChg.list.title.address" /></th>
		<td colspan="3"><c:out value="${rtnMain.addrDtl}" /></td>
	</tr>
	</tbody>
</table>

<div class="bbs_tab action">
	<ul class="clearfix">
		<li class="on"><a href="#" id="tabUserDtlInfo" name="tabUserDtlInfo" onclick="tabUserDtlInfo();"><spring:message code="field.dic.user.info" /></a></li>
		<li><a href="#" id="tabResumeDtlInfo" name="tabResumeDtlInfo" onclick="tabResumeDtlInfo();"><spring:message code="field.dic.main.resume" /></a></li>
		<li><a href="#" id="tabIntvwDtlInfo" name="tabIntvwDtlInfo" onclick="tabIntvwDtlInfo();"><spring:message code="field.dic.interview.sgtn.list" /></a></li>
		<li><a href="#" id="tabCounselDtlInfo" name="tabCounselDtlInfo" onclick="tabCounselDtlInfo();"><spring:message code="field.dic.councsel.list" /></a></li>
	</ul>
</div>

<div id="innerDtlInfo">
</div>

</form>