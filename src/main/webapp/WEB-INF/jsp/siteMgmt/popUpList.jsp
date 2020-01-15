<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/siteMgmt/popUpList.js"></script>
<script>

var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
var errorOneMsg = '<spring:message code="errors.minimum.one" text="Please select one"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';
var endDtMsg    = '<spring:message code="popup.list.title.endDt"></spring:message>';

	$(function() {
		common.invoker.invoke("popUpList");
	});
</script>

<div class="search_box">
	<div class="top_box clearfix">
		<h3>팝업 관리</h3>
	</div>
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
			<fieldset>
				<legend>popUp Management Search</legend>
				<table>
					<caption>popUp Management Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row">Keyword</th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<select id="Keyword_sel" name="Keyword_sel">
								<option value="">select</option>
								<option value="1">Title</option>
								<option value="2">Register</option>
							</select>
							<label for="keyword" class="skip"></label>
							<input type="text" id="keyword" />
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="title.sample.useYn" /></th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="select" initValue="ALL" exceptValue="" disable=""/>
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


<table id="popUp" class="display dataTable bbs_table list">
	<caption>{Board name} Write -  팝업제목, 예약설정, 시작일시, 종료일시, 사용여부, 작성자, 등록일</caption>
		<colgroup>
			<col style="width:20%;" />
			<col style="width:8%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col />
		</colgroup>
    <thead>
        <tr>
			<th scope="col"></th>
			<th scope="col">팝업제목</th>
            <th scope="col">예약설정</th>
            <th scope="col">시작일시</th>
            <th scope="col">종료일시</th>
            <th scope="col">사용여부</th>
            <th scope="col">작성자</th>
			<th scope="col">등록일</th>
        </tr>
    </thead>
</table>
<div class="put_box" style="text-align:right;">
	<form id="schFrm">
		<input type="hidden" name="popupSeq" id="popupSeq" value=""/>
	</form>
</div>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_right">
		<button type="button" class="bbs_btn type03" onclick="insertPopUp();">INSERT</button>
	</span>
</div>