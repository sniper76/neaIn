<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/iscoMng/iscoMngList.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("iscoMngList");
	});
</script>

<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
/*아이콘(icon) 위치*/
img.ui-datepicker-trigger{cursor:pointer; margin-left:5px;}
.dataTables_wrapper .dt-buttons { float:right; width: 50%; text-align:right; }
</style>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm" >
			<input type="hidden" id="detailIscoCd" name="detailIscoCd">
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.keyword" /></th>
						<td colspan="3">
							<label for="searchType" class="skip">keyword selection</label>
							<select id="searchType" name="" >
								<option value="iscoNm"><spring:message code="field.dic.jobtype.nm" /></option>
								<option value="def"><spring:message code="field.dic.def.nm" /></option>
								<option value="iscoCd"><spring:message code="field.dic.code" /></option>
							</select>
							<label for="searchKeyword" class="skip"></label>
							<input type="text" id="searchKeyword" name="searchKeyword" value= "" style="width: 80%;"/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.depth.category" /></th>
						<td colspan="3">
							<label for="iscoCd" class="skip">keyword selection</label>
							<select id="iscoCd" name="iscoCd">
								<option value="">All</option>
								<c:forEach items="${depth1List }" var="depth1">
									<option value="${depth1.cd }"><c:out value="${depth1.cdNm }" /></option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="title.sample.useYn" /></th>
						<td colspan="3">
							<label for="useYn" class="skip">keyword selection</label>
							<select id="useYn" name="useYn">
								<option value="">All</option>
								<option value="Y">Y</option>
								<option value="N">N</option>
							</select>
						</td>
					</tr>
					</tbody>
				</table>
				<div class="put_box">
					<input type="button" value="<spring:message code="button.search" />" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_basic">
	<table id="iscoMngTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:5%;" />
				<col style="width:15%;" />
				<col style="width:15%;" />
				<col style="width:15%;" />
				<col style="width:15%;" />
				<col style="width:10%;" />
				<col style="width:5%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
			</colgroup>
	    <thead>
	        <tr>
	            <th scope="col">No</th>
	            <th scope="col"><spring:message code="field.dic.1depth" /></th>
	            <th scope="col"><spring:message code="field.dic.2depth" /></th>
	            <th scope="col"><spring:message code="field.dic.3depth" /></th>
	            <th scope="col"><spring:message code="field.dic.4depth" /></th>
	            <th scope="col"><spring:message code="field.dic.code" /></th>
	            <th scope="col"><spring:message code="title.sample.useYn" /></th>
	            <th scope="col"><spring:message code="field.dic.reg.user" /></th>
	            <th scope="col"><spring:message code="field.dic.regModDt" /></th>
	        </tr>
	    </thead>
	</table>
</div>

