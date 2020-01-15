<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userCmpnyInfoList.js"></script>

<script>
	$(function() {
		common.invoker.invoke("userCmpnyInfoList");
	});
</script>
<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmUserCmpnyInfoList">
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
							<commCode:commcode codeKind="commCode" tagName="srchDivCd" grpCd="SRCH_COMPNY_DIV_CD" drawType="select" initValue="SCD0000000001" exceptValue="" disable=""/>
							<input type="text" id="srchDivKeyword" />
						</td>
						<th scope="row"><spring:message code="field.dic.compny.type" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="compnyTypeCd" grpCd="COMPNY_TYPE_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.sector" /></th>
						<td colspan="3">
						<select id="isicCd" name="isicCd">
							<option value=""><spring:message code="field.dic.select.all" /></option>
							<c:if test="${not empty rtnIsic}">
								<c:forEach items="${rtnIsic}" var="isisCdList" >
									<option value="<c:out value="${isisCdList.isicCd}" />"><c:out value="${isisCdList.isicNm}" /></option>
								</c:forEach>
							</c:if>
						</select>
						</td>
					<tr>
						<th scope="row"><spring:message code="field.dic.usrsts" /></th>
						<td colspan="3">
							<commCode:commcode codeKind="commCode" tagName="userSts" grpCd="USER_STS_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
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
						</tbody>
					</table>
				</div>
				<div class="put_box">
					<button type="button" class="open_detail">Open Detail Search</button>
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
			<!-- Selected hidden value -->
 			<input type="hidden" id="compnySeq" name="compnySeq" value="" />
 			<input type="hidden" id="previousUrl" name="previousUrl" value="" />
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
			<col style="width:10%;" />
			<col />
			<col style="width:10%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col />
			<col />
			<col />
			
		</colgroup>
		<thead>
		<tr>
			<th scope="col">No</th>
			<th scope="col"><spring:message code="field.dic.compny.type" /></th>
			<th scope="col"><spring:message code="field.dic.compny.usernm" /></th>
			<th scope="col"><spring:message code="field.dic.resprsnnm" /></th>
			<th scope="col"><spring:message code="field.dic.email" /></th>
			<th scope="col"><spring:message code="field.dic.mobile" /></th>
			<th scope="col"><spring:message code="field.dic.usrsts" /></th>
			<th scope="col"><spring:message code="field.dic.regdt" /></th>
			<th scope="col"><spring:message code="field.dic.moddt" /></th>
			<th scope="col"></th>
			<th scope="col"></th>
			<th scope="col"></th>
			
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<!-- //Data List Zone: End -->

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<!--  
		<input type="button" value="Select Normal" id="btnNormal" class="bbs_btn type06" />
		<input type="button" value="Select Dormancy" id="btnDormancy" class="bbs_btn type06" />
		<input type="button" value="Select Withdrawal" id="btnWithdrawal" class="bbs_btn type06" />
		<input type="button" value="Select Delete" id="btnDelete" class="bbs_btn type06" />
		-->
	</span>
</div>
