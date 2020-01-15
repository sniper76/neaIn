<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/counsel/manToManDtl.js"></script>
<script>
	$(function() {
		common.invoker.invoke("manToManDtl");
	});
</script>

<form id="frmManToManDtl" >
<input type="hidden" id="counselSeq" name="counselSeq" value="<c:out value="${CounselBean.counselSeq}" />" />
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.title" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.qustTitle}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.reg.user" /></th>
			<td>
				<c:out value="${CounselBean.userNm}" />
			</td>
			<th scope="row"><spring:message code="field.dic.user.type" /></th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq CounselBean.userAuthCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="course.list.title.method" /></th>
			<td colspan="3">
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq CounselBean.counselMethodDivCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.like.cnt" /></th>
			<td>
				<c:out value="${CounselBean.likeCnt}" />
			</td>
			<th scope="row"><spring:message code="field.dic.srch.cnt" /></th>
			<td>
				<c:out value="${CounselBean.viewCnt}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="course.list.title.viewyn" /></th>
			<td>
				<c:out value="${CounselBean.secretYn}" />
			</td>
			<th scope="row"><spring:message code="bulletin.dic.regdate" /></th>
			<td>
				<c:out value="${CounselBean.qustRegDt}" />
			</td>			
		</tr>						
		</tbody>
	</table>
	<!-- //bbs_table view -->
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->

<h3><spring:message code="field.dic.counselor.info" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.controll.center" /></th>
			<td>
				<c:out value="${CounselBean.jcNm}" />
			</td>
			<th scope="row"><spring:message code="field.dic.councsel" /><spring:message code="field.dic.employee.nm" /></th>
			<td>
				<c:out value="${CounselBean.jcUserNm}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="course.list.title.status" /></th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.grpCd eq 'COUNSEL_STS_CD'}">
						<input type="radio" <c:if test="${item.dtlCd eq CounselBean.counselStsCd}"> checked="true" </c:if> disabled="true" />
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>					
					</c:if>
				</c:forEach>			
			</td>
			<th scope="row"><spring:message code="field.dic.answer.dt" /></th>
			<td>
				<c:out value="${CounselBean.ansModDt}" />
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->

<c:choose>
	<c:when test="${'CMD0000000001' ne CounselBean.counselMethodDivCd}">
	
<h3><spring:message code="field.dic.counsel.req.content" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.hope.counsel.dt" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.hopeCounselDt}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.etc.req.option" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.qustEtcReq}" />
			</td>
		</tr>							
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->
	</c:when>
	<c:otherwise>
	
<h3><spring:message code="field.dic.councsel" /><spring:message code="bulletin.select.content" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.councsel" /><spring:message code="bulletin.select.content" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.qustContent}" />
			</td>
		</tr>					
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->

	</c:otherwise>
</c:choose>

<h3><spring:message code="field.dic.answer.content" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
<c:if test="${'CMD0000000001' ne CounselBean.counselMethodDivCd}">
		<tr>
			<th scope="row"><spring:message code="field.dic.councsel" /><spring:message code="field.dic.date" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.counselDt}" />&nbsp;
				<c:out value="${CounselBean.counselHour}" />&nbsp;
				<c:out value="${CounselBean.counselMinute}" />&nbsp;
				<c:out value="${CounselBean.counselAmpm}" />&nbsp;
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.counsel.noti" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.counselNtce}" />
			</td>
		</tr>
</c:if>		
		<tr>
			<th scope="row">
	<c:choose>
		<c:when test="${'CMD0000000001' ne CounselBean.counselMethodDivCd}">
			<spring:message code="field.dic.counsel.result" />
		</c:when>
		<c:otherwise>
			<spring:message code="field.dic.answer.content" />
		</c:otherwise>
	</c:choose>			
			</th>
			<td colspan="3">
				<c:out value="${CounselBean.ansContent}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.attach.file" /></th>
			<td colspan="3">
				<input type="hidden" id="ansFileGrpSeq" name="ansFileGrpSeq" value="${CounselBean.ansFileGrpSeq}">
				<div id="dext5uploadArea"></div>
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
	
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
		<c:choose>
			<c:when test="${CounselBean.counselMethodDivCd eq 'CMD0000000001'}"><c:set var="method" value="ONLINE" /></c:when>
			<c:when test="${CounselBean.counselMethodDivCd eq 'CMD0000000002'}"><c:set var="method" value="TEL" /></c:when>
			<c:when test="${CounselBean.counselMethodDivCd eq 'CMD0000000003'}"><c:set var="method" value="CENTER" /></c:when>
		</c:choose>
			<a href="${pageContext.request.contextPath}/internal/counsel/manToMan.do?method=<c:out value="${method}" />" class="bbs_btn list">list</a>
		</span>
		<span class="bbs_right">
			<input type="button" id="btnSubmit" value="Answer" class="bbs_btn modify" />
		</span>
	</div>
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->
</form>


