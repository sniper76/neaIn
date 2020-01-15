<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/stat/statVacancyStatus.js"></script>

<link rel="stylesheet" type="text/css" href="/ClipReport4/css/clipreport.css">
<link rel="stylesheet" type="text/css" href="/ClipReport4/css/UserConfig.css">
<link rel="stylesheet" type="text/css" href="/ClipReport4/css/font.css">
<script type='text/javascript' src='/ClipReport4/js/clipreport.js'></script>
<script type='text/javascript' src='/ClipReport4/js/UserConfig.js'></script>

<script>
var msgErrDailySrchCond = '<spring:message code="msg.err.daily.srch.cond" text=""></spring:message>';
var msgErrMonthlySrchCond = '<spring:message code="msg.err.monthly.srch.cond" text=""></spring:message>';

var currentTab = "tabTotalStatus";
var srchTermDivCd = "STD0000000001";

$(function() {
	common.invoker.invoke("statVacancyStatus");	
	
	$("input:radio[name=srchTermDivCd]").click(function(){
    	srchTermDivCd = $('input[name="srchTermDivCd"]:checked').val();
    });	
	
    $('#btnSearch').on('click', function(e) {
    	
    	var startDate = $("#startDate").val();
    	var endDate = $("#endDate").val();
    	
    	var diffDays = getDateDiff(endDate, startDate);
    	
    	if (srchTermDivCd == "STD0000000001" && diffDays > 31){
    		alertify.alert(msgErrDailySrchCond);
    		return;
    	}
    	
    	if (srchTermDivCd == "STD0000000002" && diffDays > 365){
    		alertify.alert(msgErrMonthlySrchCond);
    		return;
    	}    	
    	
    	if (srchTermDivCd == "STD0000000001" && currentTab == "tabTotalStatus"){
            fnTotalStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabJobCenterStatus") {
    		fnJobCenterStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabLocationStatus") {
    		fnLocationStatusDaily();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabTotalStatus") {
    		fnUserTotalStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabJobCenterStatus") {
    		fnJobCenterStatusMonthly();
    	} else {
    		fnLocationStatusMonthly();
    	}
    	
    });
	
});
</script>

<form id="frmStatUserStatus" name="frmStatUserStatus">
<div class="search_box active">
	<!-- //top_box -->
	<div class="contents_box">
			<fieldset>
				<legend>Contents Search</legend>
				<div class="detail_table">
					<table id="example">
						<caption>Detail Contents Search - </caption>
						<colgroup>
							<col style="width:12%;" />
							<col style="width:12%;" />
							<col style="width:12%;" />
							<col style="width:64%;" />
						</colgroup>						
						<tbody>
							<tr> 
								<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
								<td>
									<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="" exceptValue="" disable=""/>
								</td>
								<th scope="row"><spring:message code="field.dic.period" /></th>
								<td>
									<commCode:commcode codeKind="commCode" tagName="srchTermDivCd" grpCd="SRCH_TERM_DIV_CD" drawType="radio" initValue="STD0000000001" exceptValue="ALL" disable=""/>
									&nbsp;&nbsp;&nbsp;	
										
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
										<button type="button" id="-1M" class="btnPeriod" >1Month</button>
										<button type="button" id="-3M" class="btnPeriod" >3Month</button>
										<button type="button" id="-6M" class="btnPeriod" >6Month</button>
										<button type="button" id="-1Y" class="btnPeriod" >1Year</button>
									</span>
									<span class="bbs_right">
										<input type="button" value="SEARCH" id="btnSearch" class="bbs_btn type03" />
									</span>
								</td>
							</tr>							
						</tbody>
					</table>
				</div>
			</fieldset>
			<!-- Selected hidden value --> 		
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->
</form>

<div class="bbs_tab action">
	<ul class="clearfix">
		<li class="on"><a href="javascript:void(0);" id="tabTotalStatus" name="tabTotalStatus" onclick="fnTabClick('tabTotalStatus');"><spring:message code="field.dic.total.info" /></a></li>
		<li><a href="javascript:void(0);" id="tabJobCenterStatus" name="tabJobCenterStatus" onclick="fnTabClick('tabJobCenterStatus');"><spring:message code="field.dic.jobcntr" /></a></li>
		<li><a href="javascript:void(0);" id="tabLocationStatus" name="tabLocationStatus" onclick="fnTabClick('tabLocationStatus');"><spring:message code="field.dic.area" /></a></li>
	</ul>
</div>

<div id="innerResultReport" style='position:absolute;height:70%;width:90%;top:25%;left:2%;right:1%;bottom:2%;'>
</div>
<div id="innerTabDetail" >
</div>
