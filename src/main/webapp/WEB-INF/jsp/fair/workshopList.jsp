<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/workshopList.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("workshopList");

	});
</script>

<div class="search_box">
	<div class="contents_box">
		<fieldset>
			<legend>Contents Search</legend>
			<table>
				<caption>Contents Search - Search, User Type, Period</caption>
				<tbody>
				<tr>
					<th scope="row"><spring:message code="field.dic.job.fair" /> <spring:message code="bulletin.select.select" /></th>
					<td colspan="3"><input type="button" id="btnFairChoose" value="<spring:message code="field.dic.fair.select" />" class="bbs_btn type03 registration" />&nbsp;&nbsp;<span id="spanFairNm"></span></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
</div>
<!-- //search_box -->

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm" >
		<input type="hidden" name="fairSeq" id="fairSeq" value="${fairMngBean.fairSeq}"/>
		<input type="hidden" name="fairWorkshopSeq" id="fairWorkshopSeq" value=""/>
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					</tbody>
				</table>
				<div class="put_box">
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->
<div class="bbs_basic">
	<table id="workshopListTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:5%;" />
				<col style="width:18%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:15%;" />
				<col style="width:7%;" />
				<col style="width:10%;" />
				<col style="width:5%;" />
				<col style="width:10%;" />
			</colgroup>
	    <thead>
	        <tr>
	            <th scope="col">No</th>
	            <th scope="col"><spring:message code="field.dic.fair.workshop" /></th>
	            <th scope="col"><spring:message code="field.dic.teacherNm" /></th>
	            <th scope="col"><spring:message code="field.dic.tuition.fee" /></th>
	            <th scope="col"><spring:message code="field.dic.lectureRoom" /></th>
	            <th scope="col"><spring:message code="field.dic.workshopDt" /></th>
	            <th scope="col"><spring:message code="field.dic.recrumt.memb" /></th>
	            <th scope="col"><spring:message code="field.dic.vccy.sts" /></th>
	            <th scope="col"><spring:message code="field.dic.applicantNm" /></th>
	            <th scope="col"><spring:message code="field.dic.reg.date" /></th>
	        </tr>
	    </thead>
	</table>

	<div class="put_box" style="text-align:right;">
		<button type="button" class="bbs_btn save" id="btn_insertForm">INSERT</button>
	</div>
</div>



