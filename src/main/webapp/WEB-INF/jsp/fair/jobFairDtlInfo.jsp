<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/jobFairDtlInfo.js"></script>

<script type="text/javascript">
$(function() {
	common.invoker.invoke("jobFairDtlInfo");
});
</script>

<form id="frmJobFairDtlInfo">
<input type="hidden" id="fairSeq" name="fairSeq" value="<c:out value="${rtnData.fairSeq}" />" />

	<h3><spring:message code="field.dic.fair.base.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.fair.div" /></th>
				<td colspan="3"><c:out value="${rtnData.fairDivNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.fair.name" /></th>
				<td colspan="3"><c:out value="${rtnData.fairNm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.fair.thumb.img" /></th>
				<td colspan="3">추후에 변경 필요.<c:out value="${rtnData.thumbFileGrpSeq}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.fair.poster.img" /></th>
				<td colspan="3">추후에 변경 필요.<c:out value="${rtnData.fairFileGrpSeq}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.subject.center" /></th>
				<td colspan="3"><c:out value="${rtnData.jcNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="userChg.list.title.address" /></th>
				<td colspan="3"><c:out value="${rtnData.addrFullNm}" /></td>
			</tr>
			</tbody>
		</table>
	</div>

	<h3><spring:message code="field.dic.fair.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption></caption> 
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.fair.term" /></th> 
				<td colspan="3"><c:out value="${rtnData.fairTerm}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.recurmt.term" /></th> 
				<td colspan="3"><c:out value="${rtnData.recurmtTerm}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.tel" /> 1</th> 
				<td colspan="3"><c:out value="${rtnData.tel1}" /></td> 
			</tr>
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.tel" /> 2</th> 
				<td colspan="3"><c:out value="${rtnData.tel2}" /></td>
			</tr>
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.email" /></th> 
				<td colspan="3"><c:out value="${rtnData.email}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.fair.booth.img" /></th> 
				<td colspan="3">추후에 변경 필요.<c:out value="${rtnData.boothFileGrpSeq}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.fair.desc" /></th> 
				<td colspan="3"><c:out value="${rtnData.fairDtlExpln}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.fair.keyword" /></th> 
				<td colspan="3"><c:out value="${rtnData.fairHashtag}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.fair.view.item" /></th> 
				<td colspan="3">
					<c:choose>
						<c:when test="${rtnData.fairCompnyViewYn eq 'Y' }">
							<spring:message code="field.dic.fair.compny.view" /><br>
						</c:when>
						<c:when test="${rtnData.fairVacancyViewYn eq 'Y' }">
							<spring:message code="field.dic.compny.vccy" /><br>
						</c:when>
						<c:when test="${rtnData.fairInsttViewYn eq 'Y' }">
							<spring:message code="field.dic.instt" /><br>
						</c:when>
						<c:when test="${rtnData.fairTrnngViewYn eq 'Y'}">
							<spring:message code="field.dic.trnng.prog" /><br>
						</c:when>													
					</c:choose>
				</td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="title.sample.useYn" /></th> 
				<td colspan="3"><c:out value="${rtnData.useYn}" /></td> 
			</tr> 
			</tbody> 
		</table>
	</div>
	
	<!-- //bbs_btn_wrap 
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<a href="" class="bbs_btn list">list</a>
		</span>
		<span class="bbs_right">
	
		</span>
	</div>
	-->

</form>