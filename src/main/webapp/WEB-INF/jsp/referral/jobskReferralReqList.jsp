<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/referral/jobskReferralReqList.js"></script>

<script>
	$(function() {
		common.invoker.invoke("jobskReferralReqList");
	});
</script>
<div class="search_box">
	<input type="hidden" id="userAuth" name="userAuth" value="<c:out value="${userAuth.neaJcDivCd}" />" />
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<colgroup>
						<col style="width:12%;" />
						<col style="width:38%;" />
						<col style="width:12%;" />
						<col style="width:38%;" />
					</colgroup>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
						<td colspan="3">
							<commCode:commcode codeKind="jcCode" tagName="jcList" grpCd="" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.usrtype" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="userAuthCd" grpCd="USER_AUTH_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row"><spring:message code="field.dic.usrsts" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="emplm_sts" grpCd="EMPL_STS_CD" drawType="select" initValue="ALL" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="search.keyword" /></th>
						<td colspan="3">
							<label for="Search_sel" class="skip">category selection</label>
							<select id="Keyword_sel">
								<option value=""><spring:message code="field.dic.select.all" /></option>
								<option value="1"><spring:message code="userChg.list.title.userNm" /></option>
								<option value="2"><spring:message code="field.dic.resume.title" /></option>
								<option value="3"><spring:message code="field.dic.tel" /></option>
							</select>
							<label for="keyword" class="skip"></label>
							<input type="text" id="keyword" />
						</td>
					</tr>					
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
				
				<div class="put_box">
					<!--button type="button" class="open_detail">Open Detail Search</button-->  
					<input type="button" value="<spring:message code="button.search" />" id="btnSearch" class="btn_submit" />
					<!--button type="button" value="popup" class="bbs_btn save" onclick="popreferralUserSearchLayerBtn();">popup</button-->
				</div>
			</fieldset>
			<!-- Selected hidden value -->
 		</form>
 		<form id="frmParam">
 			<input type="hidden" id="jobskReqSeq" name="jobskReqSeq" value="" />
			<input type="hidden" id="userSeq" name="userSeq" value="" />
			<input type="hidden" id="resumeSeq" name="resumeSeq" value="" />
			<input type="hidden" id="previousUrl" name="previousUrl" value="" />
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="jobskReferral" class="bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:15%;" />
			<col style="width:10%;" />
			<col style="width:5%;" />
			<col style="width:5%;" />
			<col style="width:10%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
		</colgroup>
		<thead>
		<tr>
			<th scope="col">No</th>		
			<th scope="col"><spring:message code="field.dic.usrtype" /></th>
			<th scope="col"><spring:message code="field.dic.usernm" /></th>
			<th scope="col"><spring:message code="field.dic.resume.title" /></th>
			<th scope="col"><spring:message code="field.dic.usrsts" /></th>
			<th scope="col"><spring:message code="field.dic.email" /></th>
			<th scope="col"><spring:message code="field.dic.mobile" /></th>
			<th scope="col"><spring:message code="field.dic.moddt" /></th>			
			<th scope="col"><spring:message code="field.dic.jobcntr" /></th>
			<th scope="col"><spring:message code="field.dic.match" /></th>
			<th scope="col"><spring:message code="field.dic.jobsksts" /></th>
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<!-- //Data List Zone: End -->
<!--  
<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<input type="button" value="Select Approve" id="btnApprove" class="bbs_btn type06" />
		<input type="button" value="Select Return" id="btnReturn" class="bbs_btn type06" />
		<input type="button" value="Select Not Seeking" id="btnNotSeeking" class="bbs_btn type06" />
	</span>
</div>
-->