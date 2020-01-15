<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/trnng/eduTrnngDtlInfo.js"></script>

<script>
$(function() {
	common.invoker.invoke("eduTrnngDtlInfo");
});
</script>

<form id="frmEduTrnngDtlInfo">
<input type="hidden" id="eduTrnngSeq" name="eduTrnngSeq" value="<c:out value="${rtnData.eduTrnngSeq}" />" />

	<h3><spring:message code="field.dic.edu.trnng.base" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.edu.trnng.base" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"> <spring:message code="field.dic.trnng.nm" /></th>
				<td colspan="3"><c:out value="${rtnData.eduTrnngNm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.trnng.div" /></th>
				<td colspan="3"><c:out value="${rtnData.eduDivNm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.skill.job.cors" /></th>
				<td><c:out value="${rtnData.skillJobProgramCorsNm}" /></td>
				<th scope="row"> <spring:message code="field.dic.high.genrl.cors" /></th>
				<td><c:out value="${rtnData.highGenrlEduCorsNm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.recurmt.term" /></th>
				<td colspan="3"><c:out value="${rtnData.recurmtTerm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.edu.term" /></th>
				<td><c:out value="${rtnData.eduTerm}" /></td>
				<th scope="row"> <spring:message code="field.dic.period" /></th>
				<td><c:out value="${rtnData.eduDura}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.edu.teach.time" /></th>
				<td colspan="3">
				<c:if test="${not empty rtnData.teachDt && rtnData.teachDt ne ''}" >
					<c:out value="${rtnData.teachDt}" />,
				</c:if>
				<c:if test="${not empty rtnData.teachTime && rtnData.teachTime ne ''}" >
					<c:out value="${rtnData.teachTime}" />, 
				</c:if>
				<c:if test="${not empty rtnData.timeWeek && rtnData.timeWeek ne ''}" >
					<c:out value="${rtnData.timeWeek}" />
				</c:if>				
				</td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.trnng.place" /></th>
				<td colspan="3"><c:out value="${rtnData.addrFullNm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.edu.trnng.type" /></th>
				<td colspan="3"><c:out value="${rtnData.programCorsTypeNm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.major.prog.rsrch" /></th>
				<td colspan="3"><c:out value="${rtnData.major2depthNm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.connt.major" /></th>
				<td colspan="3"><c:out value="${rtnData.major1depthNm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.tuition.fee" /></th>
				<td colspan="3">
				<c:if test="${rtnData.freePaidYn eq 'Y' }">
					<spring:message code="field.dic.free.pay" />
				</c:if>
				<c:if test="${rtnData.freePaidYn ne 'Y' }">
					<c:out value="${rtnData.tuition}" />
				</c:if>
				</td>
			</tr>												
			</tbody>
		</table>
	</div>

	<h3><spring:message code="field.dic.edu.trnng.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.edu.trnng.info" /></caption> 
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.edu.target" /></th> 
				<td colspan="3"><c:out value="${rtnData.eduTarget}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.admss.criteria" /></th> 
				<td colspan="3"><c:out value="${rtnData.admssCriteria}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.edu.prog.expln" /></th> 
				<td colspan="3"><c:out value="${rtnData.content}" /></td> 
			</tr>
			<tr> 
				<th scope="row"> <spring:message code="field.dic.edu.enrol.method" /></th> 
				<td colspan="3"><c:out value="${rtnData.enrolMethod}" /></td>
			</tr>
			</tbody> 
		</table>
	</div>

	<h3><spring:message code="field.dic.jc.agreeyn" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.jc.agreeyn" /></caption> 
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.signupDt" /></th> 
				<td colspan="3"><c:out value="${rtnData.regDt}" /></td> 
				<th scope="row"> <spring:message code="field.dic.approveDt" /></th> 
				<td colspan="3"><c:out value="${rtnData.jcAgreeDt}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.jc.agreeyn" /></th> 
				<td colspan="3"><c:out value="${rtnData.jcAgreeStsNm}" /></td>
				<th scope="row"> <spring:message code="field.dic.rsps.prsn" /></th> 
				<td colspan="3"><c:out value="${rtnData.jcUserNm}" /></td>  
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