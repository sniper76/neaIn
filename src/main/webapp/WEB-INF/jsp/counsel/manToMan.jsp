<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/counsel/manToMan.js"></script>
<script>
	var method = '<c:out value="${param.method}" />' == '' ? 'online' : ('<c:out value="${param.method}" />').toLowerCase();
	$(function() {
		common.invoker.invoke("manToMan");
	});
</script>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmManToMan" >
			<input type="hidden" id="counselSeq" name="counselSeq" value="" />
			<input type="hidden" id="counselCateDivCd" name="counselCateDivCd" value="<c:out value="${CounselBean.counselCateDivCd}" />" />
			<input type="hidden" id="counselMethodDivCd" name="counselMethodDivCd" value="<c:out value="${CounselBean.counselMethodDivCd}" />" />
			<input type="hidden" id="periodOn" name="periodOn" value="" />
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.keyword" /></th>
						<td colspan="3">
							<label for="searchKeyword" class="skip">keyword selection</label>
							<select id="searchKeyword" name="searchKeyword">
								<option value="qustTitle"><spring:message code="field.dic.question" /></option>
								<option value="qustContent"><spring:message code="bulletin.select.content" /></option>
								<option value="userNm"><spring:message code="field.dic.reg.user" /></option>
							</select>
							<label for="searchValue" class="skip"></label>
							<input type="text" id="searchValue" name="searchValue" value= ""  maxlength="50" />
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.user.type" /></th>
						<td colspan="3">
							<label for="userAuthCd" class="skip">type selection</label>
							<select id="userAuthCd" name="userAuthCd">
								<option value="">All</option>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="course.list.title.status" /></th>
						<td>
							<label for="counselStsCd" class="skip">status selection</label>
							<select id="counselStsCd" name="counselStsCd">
								<option value="">All</option>
							</select>
						</td>
						<th scope="row"><spring:message code="course.list.title.viewyn" /></th>
						<td>
							<label for="secretYn" class="skip">secret selection</label>
							<select id="secretYn" name="secretYn">
								<option value="">All</option>
								<option value="Y">YES</option>
								<option value="N">NO</option>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row">Period</th>
						<td colspan="3">
							<span class="period_box">
								<span class="date_box">
									<label for="sDate" class="skip">start date</label>
									<input type="text" id="startDate" name="startDate" class="datepicker" title="Start date Select from calendar" placeholder="start date" />
								</span>
								-&nbsp;
								<span class="date_box">
									<label for="eDate" class="skip">end date</label>
									<input type="text" id="endDate" name="endDate" class="datepicker" title="End date Select from calendar" placeholder="end date" />
								</span>
							</span>
							<span class="period_choose">
								<button type="button" id="today" class="btnPeriod" >Today</button>
								<button type="button" id="-14D" class="btnPeriod" >2Week</button>
								<button type="button" id="-1M" class="btnPeriod" >1Month</button>
								<button type="button" id="-3M" class="btnPeriod" >3Month</button>
								<button type="button" id="-1Y" class="btnPeriod" >1Year</button>
							</span>
						</td>
					</tr>
					</tbody>
				</table>
				<div class="detail_table">
					<table id="example">
						<caption>Detail Contents Search - </caption>
						
						<tbody>
							
						</tbody>
					</table>
				</div>
				<div class="put_box">
					<button type="button" class="open_detail">Open Detail Search</button>
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_basic">
	<table id="counselTable" class="display dataTable bbs_table list">
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:3%;" />
				<col style="width:20%;" />
				<col style="width:10%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col />
			</colgroup>    
	    <thead>
	        <tr>
	            <th scope="col"></th>
	            <th scope="col"><spring:message code="field.dic.title" /></th>
	            <th scope="col"><spring:message code="userChg.list.title.userDiv" /></th>
	            <th scope="col"><spring:message code="course.list.title.status" /></th>
	            <th scope="col"><spring:message code="course.list.title.viewyn" /></th>
	            <th scope="col"><spring:message code="field.dic.attach.file" /></th>
	            <th scope="col"><spring:message code="field.dic.reg.user" /></th>
	            <th scope="col"><spring:message code="field.dic.like.cnt" /></th>
	            <th scope="col"><spring:message code="field.dic.srch.cnt" /></th>
	            <th scope="col"><spring:message code="bulletin.dic.regdate" /></th>
	        </tr>
	    </thead>
	</table>
</div>