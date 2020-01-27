<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/communityMng/communityMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("communityMng");
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
		<form id="frmJobFairMng" >
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
								<option value="title"><spring:message code="field.dic.title" /></option>
								<option value="contents"><spring:message code="bulletin.select.content" /></option>
								<option value="regUser"><spring:message code="field.dic.reg.user" /></option>
							</select>
							<label for="searchKeyword" class="skip"></label>
							<input type="text" id="searchKeyword" name="searchKeyword" value= "" style="width: 80%;"/>
						</td>
					</tr>
					<tr>
						<th scope="row">Filtering Status</th>
						<td>
							<label for="FilteringStsCd" class="skip">keyword selection</label>
							<select id="FilteringStsCd" name="FilteringStsCd">
								<option value="">All</option>
								<option value="Y">점검필요</option>
								<option value="N">점검완료</option>
							</select>
						</td>
						<th scope="row"><spring:message code="course.list.title.viewyn" /></th>
						<td>
							<label for="viewYn" class="skip">keyword selection</label>
							<select id="viewYn" name="viewYn">
								<option value="">All</option>
								<option value="Y">Y</option>
								<option value="N" selected="selected">N</option>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.period" /></th>
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
	<table id="communityMngTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:35%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:15%;" />
			</colgroup>
	    <thead>
	        <tr>
	            <!-- <th scope="col"></th> -->
	            <th scope="col"><spring:message code="field.dic.title" /></th>
	            <th scope="col">필터링 상태</th>
	            <th scope="col"><spring:message code="course.list.title.viewyn" /></th>
	            <th scope="col"><spring:message code="field.dic.reg.user" /></th>
	            <th scope="col"><spring:message code="field.dic.like.cnt" /></th>
	            <th scope="col"><spring:message code="field.dic.srch.cnt" /></th>
	            <th scope="col"><spring:message code="bulletin.dic.regdate" /></th>
	        </tr>
	    </thead>
	</table>
</div>

