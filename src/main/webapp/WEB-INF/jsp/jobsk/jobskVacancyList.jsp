<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/jobsk/jobskVacancyList.js"></script>

<script>
	$(function() {
		common.invoker.invoke("jobskVacancyList");
	});
</script>
<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmJobskVacancyList">
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
							<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="srchDivCd" grpCd="SRCH_VACANCY_DIV_CD" drawType="select" initValue="" exceptValue="" disable=""/>
							<input type="text" id="srchDivKeyword" />
						</td>
						<th scope="row"><spring:message code="field.dic.vccy.type" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="employFormCd" grpCd="EMPLOY_FORM_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.vccy.sts" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="vacancyStsCd" grpCd="VACANCY_STS_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row"><spring:message code="field.dic.jc.agreeyn" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="jcAgreeStsCd" grpCd="JC_AGREE_STS_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>					
					<tr>
						<th scope="row"><spring:message code="field.dic.urgent.vccy.yn" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="urgentVccyCd" grpCd="FIELD_YN_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row"><spring:message code="field.dic.prefernt.vccy.cond" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="preferntCondCd" grpCd="PREFERNT_COND_CD" drawType="check" initValue="" exceptValue="" disable=""/>
							<!--  
							<input type="checkbox" id="preferntCondCd1" name="preferntCondCd1" value="" ></br>
							<input type="checkbox" id="preferntCondCd2" name="preferntCondCd2" value="" ></br>
							<input type="checkbox" id="preferntCondCd3" name="preferntCondCd3" value="" >
							-->
						</td>
					</tr>
					</tbody>
				</table>
				<div class="detail_table">
					<table id="example">
						<caption>Detail Contents Search - </caption>
						<colgroup>
							<col style="width:12%;" />
							<col style="width:38%;" />
							<col style="width:12%;" />
							<col style="width:38%;" />
						</colgroup>						
						<tbody>
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
				</div>
				<div class="put_box">
					<button type="button" class="open_detail">Open Detail Search</button>  
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
			<!-- Selected hidden value -->
 			<input type="hidden" id="vacancySeq" name="vacancySeq" value="" />
 			<input type="hidden" id="resumeSeq" name="resumeSeq" value="" />
 			<input type="hidden" id="periodOn" name="periodOn" value="" />			
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="myTable" class="bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:6%;" />
			<col style="width:6%;" />
			<col style="width:10%;" />
			<col />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:6%;" />
			<col style="width:8%;" />
			<col style="width:6%;" />
			<col style="width:6%;" />
			<col style="width:7%;" />
			<col style="width:6%;" />
			<col style="width:6%;" />
			<col />
			<col />
			
		</colgroup>
		<thead>
		<tr>
			<th scope="col">No</th>
			<th scope="col"><spring:message code="field.dic.vccy.no" /></th>
			<th scope="col"><spring:message code="field.dic.vccy.type" /></th>
			<th scope="col"><spring:message code="field.dic.company.name" /></th>
			<th scope="col"><spring:message code="field.dic.vccy.title" /></th>
			<th scope="col"><spring:message code="field.dic.period" /></th>
			<th scope="col"><spring:message code="field.dic.signupDt" /></th>
			<th scope="col"><spring:message code="field.dic.jc.agreeyn" /></th>
			<th scope="col"><spring:message code="field.dic.jcAgree.dt" /></th>
			<th scope="col"><spring:message code="field.dic.vccy.sts" /></th>
			<th scope="col"><spring:message code="field.dic.recrumt.memb" /></th>
			<th scope="col"><spring:message code="field.dic.applic.tot" /></th>
			<th scope="col"><spring:message code="field.dic.pass.join" /></th>
			<th scope="col"><spring:message code="field.dic.controll.center" /></th>
			<th scope="col"></th>
			<th scope="col"></th>
			
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<!-- //Data List Zone: End -->
