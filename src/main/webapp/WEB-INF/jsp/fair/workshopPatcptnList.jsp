<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/workshopPatcptnList.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("workshopPatcptnList");

	});
</script>

<div class="search_box">
	<div class="contents_box">
		<input type="hidden" name="fairSeq" id="fairSeq" value="${fairWorkshopInfo.fairSeq}"/>
		<input type="hidden" name="fairWorkshopSeq" id="fairWorkshopSeq" value="${fairWorkshopInfo.fairWorkshopSeq}"/>
		<fieldset>
			<legend>Contents Search</legend>
			<table>
				<caption>Contents Search - Search, User Type, Period</caption>
				<colgroup>
					<col style="width:15%;" />
					<col style="width:35%;" />
					<col style="width:15%;" />
					<col style="width:35%;" />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row"><spring:message code="fair.list.fair.nm" /></th>
						<td colspan="3"><c:out value="${fairMngInfo.fairNm }" /></td>
					</tr>
					<tr>
						<th scope="row">워크샵 명</th>
						<td colspan="3"><c:out value="${fairWorkshopInfo.workshopNm }" /></td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="title.sample.description" /></th>
						<td colspan="3"><c:out value="${fairWorkshopInfo.expln }" /></td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.recurmt.term" /></th>
						<td colspan="3">
							<c:out value="${fairMngInfo.recurmtBgnDt }" />&nbsp;
							<c:out value="${fairMngInfo.recurmtBgnHour }" />:<c:out value="${fairMngInfo.recurmtBgnMinute }" />&nbsp;
							<c:out value="${fairMngInfo.recurmtBgnAmpm }" /> ~&nbsp;
							<c:out value="${fairMngInfo.recurmtEndDt }" />&nbsp;
							<c:out value="${fairMngInfo.recurmtEndHour }" />:<c:out value="${fairMngInfo.recurmtEndMinute }" />&nbsp;
							<c:out value="${fairMngInfo.recurmtEndAmpm }" />
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.period" /></th>
						<td>
							<c:out value="${fairWorkshopInfo.workshopDt }" />&nbsp;
							<c:out value="${fairWorkshopInfo.bgnHour }" />:<c:out value="${fairWorkshopInfo.bgnMinute }" />&nbsp;
							<c:out value="${fairWorkshopInfo.bgnAmpm }" /> ~&nbsp;
							<c:out value="${fairWorkshopInfo.endHour }" />:<c:out value="${fairWorkshopInfo.endMinute }" />&nbsp;
							<c:out value="${fairWorkshopInfo.endAmpm }" />
						</td>
						<th scope="row"><spring:message code="field.dic.recrumt.memb" /></th>
						<td><c:out value="${fairWorkshopInfo.recurmtMan }" /></td>
					</tr>
					<tr>
						<th scope="row">강의실</th>
						<td colspan="3"><c:out value="${fairWorkshopInfo.lectureRoom }" /></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
</div>
<!-- //search_box -->

<!-- //search_box -->
<div class="bbs_basic">
	<table id="workshopListTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
			</colgroup>
	    <thead>
	        <tr>
	            <th scope="col">No</th>
	            <th scope="col"><spring:message code="userChg.list.title.userDiv" /></th>
	            <th scope="col"><spring:message code="userChg.list.title.userNm" /></th>
	            <th scope="col"><spring:message code="field.dic.resprsnnm" /></th>
	            <th scope="col"><spring:message code="userChg.list.title.email" /></th>
	            <th scope="col"><spring:message code="userChg.list.title.cell" /></th>
	            <th scope="col"><spring:message code="userChg.list.title.age" /></th>
	            <th scope="col"><spring:message code="userChg.list.title.gender" /></th>
	            <th scope="col"><spring:message code="field.dic.signupDt" /></th>
	            <th scope="col"><spring:message code="field.dic.jc.agreeyn" /></th>
	        </tr>
	    </thead>
	</table>

	<!-- <div class="put_box" style="text-align:right;">
		<button type="button" class="bbs_btn save" id="btn_insertForm">INSERT</button>
	</div> -->
</div>



