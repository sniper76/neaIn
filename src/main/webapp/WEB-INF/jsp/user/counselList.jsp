<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/counselList.js"></script>
<script>
	var method = '<c:out value="${param.method}" />' == '' ? 'online' : ('<c:out value="${param.method}" />').toLowerCase();
	$(function() {
		common.invoker.invoke("counselList");
	});
</script>

<div class="search_box">
	<!--div class="top_box clearfix">
		<h3>Contents Search</h3>
		<a href="" class="btn_registration">User Registration</a>
	</div-->
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmCourse" >
			<input type="hidden" id="counselSeq" name="counselSeq" value="" />
			<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnUserSeq}" />" />
			<input type="hidden" id="counselCateDivCd" name="counselCateDivCd" value="<c:out value="${CounselBean.counselCateDivCd}" />" />
			<input type="hidden" id="counselMethodDivCd" name="counselMethodDivCd" value="<c:out value="${CounselBean.counselMethodDivCd}" />" />
			<input type="hidden" id="periodOn" name="periodOn" value="" />
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					
					<tr>
						<th scope="row"><spring:message code="field.dic.period" /></th>
						<td colspan="3">
							<span class="period_box">
								<span class="date_box">
									<label for="startDate" class="skip">start date</label>
									<input type="text" id="startDate" name="startDate" class="datepicker" title="Start date Select from calendar" placeholder="start date" />
								</span>
								-&nbsp;
								<span class="date_box">
									<label for="endDate" class="skip">end date</label>
									<input type="text" id="endDate" name="endDate" class="datepicker" title="End date Select from calendar" placeholder="end date" />
								</span>
							</span>
							<span class="period_choose">
								<button type="button" id="today" class="btnPeriod" ><spring:message code="field.dic.today" /></button>
								<button type="button" id="-14D" class="btnPeriod" ><spring:message code="field.dic.2weeks" /></button>
								<button type="button" id="-1M" class="btnPeriod" ><spring:message code="field.dic.1month" /></button>
								<button type="button" id="-3M" class="btnPeriod" ><spring:message code="field.dic.3months" /></button>
								<button type="button" id="-1Y" class="btnPeriod" ><spring:message code="field.dic.1year" /></button>
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
					<!--button type="button" class="open_detail">Open Detail Search</button-->
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
	            <th scope="col">counselTargetCd</th>
	            <th scope="col">qustTitle</th>
	            <th scope="col">counselStsCd</th>
	            <th scope="col">secretYn</th>
	            <th scope="col">파일</th>
	            <th scope="col">userNm</th>
	            <th scope="col">likeCnt</th>
	            <th scope="col">viewCnt</th>
	            <th scope="col">qustRegDt</th>
	        </tr>
	    </thead>
	</table>
</div>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<button type="button" class="bbs_btn list" onclick="fnGoPageCompnyInfoListBack();"><spring:message code="button.list" /></button>
	</span>
</div>
