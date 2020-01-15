<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/js/pageLib/common/neaUserList.js"></script>

<script>
	var authMng 	= '<spring:message code="field.dic.auth.mng" text="Auth Management"></spring:message>';
	$(function() {
		common.invoker.invoke("neaUserList");
	});
</script>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="schFrm">
				<input type="hidden" id="userSeq" name="userSeq" value="" />
				<input type="hidden" id="urlChk" name="urlChk" value="jobCenter" />
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row">Search</th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<select id="Keyword_sel" name="Keyword_sel">
								<option value=""><spring:message code="field.dic.select.all" /></option>
								<option value="1"><spring:message code="field.dic.employee.nm" /></option>
								<option value="2"><spring:message code="field.dic.mngid" /></option>
								<option value="3"><spring:message code="userChg.list.title.email" /></option>
								<option value="4"><spring:message code="field.dic.mobile" /></option>
							</select>
							<label for="keyword" class="skip"></label>
							<input type="text" id="keyword" />
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="userChg.list.title.gender" /></th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<commCode:commcode codeKind="commCode" tagName="gender" grpCd="GENDER_CD" drawType="radio" initValue="ALL" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.work.retire" /></th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<commCode:commcode codeKind="commCode" tagName="workRetireCd" grpCd="WORK_RETIRE_CD" drawType="radio" initValue="ALL" exceptValue="" disable=""/>
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
					<input type="submit" value="<spring:message code="button.search" />" class="btn_submit" />
				</div>
			</fieldset>
		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->
<div class="bbs_basic">
		<table id="neaUserList" class="bbs_table list">
			<caption>Nea User List</caption>
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
			</colgroup>
			<thead>
			<tr>
				<th scope="col">No</th>		
				<th scope="col"><spring:message code="field.dic.instt.nm" /></th>
				<th scope="col"><spring:message code="field.dic.employee.nm" /></th>
				<th scope="col"><spring:message code="field.dic.mngid" /></th>
				<th scope="col"><spring:message code="userChg.list.title.email" /></th>
				<th scope="col"><spring:message code="field.dic.mobile" /></th>
				<th scope="col"><spring:message code="field.dic.work.retire" /></th>
				<th scope="col"><spring:message code="field.dic.auth.mng" /></th>			
				<th scope="col"><spring:message code="title.sample.useYn" /></th>
				<th scope="col"><spring:message code="field.dic.reg.date" /></th>
			</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>

	<div class="put_box" style="text-align:right;">
		
		
			<button type="button" class="bbs_btn type03" onclick="insertNeaUser();"><spring:message code="button.create" /></button>
			
	</div>


