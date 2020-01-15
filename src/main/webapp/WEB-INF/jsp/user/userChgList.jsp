<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userChgList.js"></script>
<script>


var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
var errorOneMsg = '<spring:message code="errors.minimum.one" text="Please select one"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';

	$(function() {
		common.invoker.invoke("userChgList");
		//common.sys.getDatepicker();
		//common.sys.setDateDiff();
	});
</script>

<form name="frm" action="${pageContext.request.contextPath}/user/userChgDtl.do" id="frm" method="post">
<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
						<td colspan="3">
							<label for="jcCd" class="skip"><spring:message code="field.dic.jobcntr" /></label>
							<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
						<td>
							<label for="searchKeyword" class="skip">method selection</label>
							<commCode:commcode codeKind="commCode" tagName="searchKeyword" grpCd="SRCH_DIV_CD" drawType="select" initValue="" exceptValue="" disable=""/>
							<label for="searchValue" class="skip"></label>
							<input type="text" id="searchValue" name="searchValue" value= "" />
						</td>
						<th scope="row">회원구분</th>
						<td>
							<label for="userAuthCd" class="skip">type selection</label>
							<commCode:commcode codeKind="commCode" tagName="userAuthCd" grpCd="USER_AUTH_CD" drawType="radio" initValue="" exceptValue="ROLE_ADMIN, ROLE_LOWJS" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row">승인상태</th>
						<td>
							<label for="schgAgreeStsCd" class="skip">status selection</label>
							<commCode:commcode codeKind="commCode" tagName="schgAgreeStsCd" grpCd="CHG_AGREE_STS_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row">성별</th>
						<td>
							<label for="genderCd" class="skip">secret selection</label>
							<commCode:commcode codeKind="commCode" tagName="genderCd" grpCd="GENDER_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row">기간</th>
						<td colspan="3">
							<span class="period_box">
								<span class="date_box">
									<label for="startDate" class="skip">start date</label>
									<input type="text" id="startDate" name="startDate" class="datepicker" title="Start date Select from calendar" placeholder="start date" />
									<!-- <button type="button">Start date Select from calendar</button> -->
								</span>
								-&nbsp;
								<span class="date_box">
									<label for="endDate" class="skip">end date</label>
									<input type="text" id="endDate" name="endDate" class="datepicker" title="End date Select from calendar" placeholder="end date" />
									<!-- <button type="button">End date Select from calendar</button> -->
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
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_basic">
	<table id="userChgTable" class="display dataTable bbs_table list">
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:2%;" />
				<col style="width:3%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:13%;" />
				<col style="width:10%;" />
				<col style="width:5%;" />
				<col style="width:7%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col />
			</colgroup>    
	    <thead>
	        <tr>
	            <th scope="col"></th>
	            <th scope="col"><spring:message code="userChg.list.title.no"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.userDiv"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.chgUserDiv"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.userNm"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.email"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.cell"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.age"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.gender"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.agreeSts"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.chgReqDt"></spring:message></th>
	            <th scope="col"><spring:message code="userChg.list.title.agreeDt"></spring:message></th>
	        </tr>
	    </thead>
	</table>
</div>
<!-- div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<a class="bbs_btn list" id="btnAgree"><spring:message code="userChg.list.btn.selAgree" text="Agree" /></a>
		<a class="bbs_btn list" id="btnReject"><spring:message code="userChg.list.btn.selReject" text="Reject" /></a>
	</span>
</div -->
<!-- //bbs_btn_wrap -->

<input type="hidden" name="userChgSeq" id="userChgSeq" value="" />
<input type="hidden" name="chgAgreeStsCd" id="chgAgreeStsCd" value="" />

</form>
