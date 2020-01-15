<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/bulletin/bulletinMng.js"></script>
<script>

var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
var errorOneMsg = '<spring:message code="errors.minimum.one" text="Please select one"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';

	$(function() {
		common.invoker.invoke("bulletinMNGList");
	});
</script>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
			<fieldset>
				<legend>Bulletin Management Search</legend>
				<table>
					<caption><spring:message code="page.title.bulletin.list.caption" text=""></spring:message></caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.keyword" text=""></spring:message></th>
						<td colspan="3">
							<label for="Search_sel" class="skip">category selection</label>
							<commCode:commcode codeKind="commCode" tagName="Keyword_sel" grpCd="SRCH_BULLETIN_KEYWORK_CD" drawType="select" initValue="" exceptValue="" disable=""/>
							<label for="keyword" class="skip"></label>
							<input type="text" id="keyword" size="50" />
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="bulletin.dic.useyn" text=""></spring:message></th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
						</td>
						<th scope="row"><spring:message code="bulletin.dic.range" text=""></spring:message></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="bulletinRangeCd" grpCd="RANGE_CD" drawType="radio" initValue="RNG0000000001" exceptValue="ALL,RNG0000000003" disable=""/>
							
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="bulletin.dic.type" text=" Bulletin Type"></spring:message></th>
						<td>
							<label for="Type_sel" class="skip">category selection</label>
							<commCode:commcode codeKind="commCode" tagName="bulletinTypeCd" grpCd="BULLETIN_TYPE_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row"><spring:message code="userChg.list.title.userDiv" text=""></spring:message></th>
						<td>
							<label for="User_sel" class="skip">category selection</label>
							<commCode:commcode codeKind="commCode" tagName="User_sel" grpCd="USER_AUTH_CD" drawType="select" initValue="" exceptValue="ROLE_ADMIN,ROLE_LOWJS" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.period" text=""></spring:message></th>
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
								<button type="button" id="today" class="btnPeriod" ><spring:message code="field.dic.today" text="Today"></spring:message></button>
								<button type="button" id="-14D" class="btnPeriod" ><spring:message code="field.dic.2weeks" text="2weeks"></spring:message></button>
								<button type="button" id="-1M" class="btnPeriod" ><spring:message code="field.dic.1month" text="1month"></spring:message></button>
								<button type="button" id="-3M" class="btnPeriod" ><spring:message code="field.dic.3months" text="3months"></spring:message></button>
								<button type="button" id="-1Y" class="btnPeriod" ><spring:message code="field.dic.1year" text="1year"></spring:message></button>
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
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" value="<spring:message code="button.search" text="SEARCH"></spring:message>"/>
					<!--input type="button" id="btnSearch" value="SEARCH" class="btn_submit" onclick="selectBulletinMng();"/-->
					<!--input type="button" id="btnInsert" value="INSERT" class="btn_submit" onclick="insertBulletinMng();"/-->
					<!--input type="button" id="btnDelete" value="DELETE" class="btn_submit" onclick="deleteBulletinMng();"/>
					<input type="button" id="btnUdate" value="UPDATE" class="btn_submit" onclick="updateBulletinMng();"/-->
					
				</div>
			</fieldset>
		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_basic">
	<table id="bulletinMng" class="bbs_table list">
		<caption>Bulletin Management table</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:40%;" />
			<col style="width:10%;"/>
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:10%;" />
			<col style="width:7%;" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col"><spring:message code="bulletin.dic.name" text="Bulletin Title"></spring:message></th>
				<th scope="col"><spring:message code="bulletin.dic.type" text="Bulletin Type"></spring:message></th>
				<th scope="col"><spring:message code="program.programtitle.id" text="Program ID"></spring:message></th>
				<th scope="col"><spring:message code="bulletin.dic.likeyn" text="Like Yn"></spring:message></th>
				<th scope="col"><spring:message code="bulletin.dic.useyn" text="Use Yn"></spring:message></th>
				<th scope="col"><spring:message code="bulletin.select.register" text="Register"></spring:message></th>
				<th scope="col"><spring:message code="bulletin.dic.regdate" text="Regist Date"></spring:message></th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<div class="put_box" style="text-align:right;">
	<form id="schFrm">
		<input type="hidden" name="bulletinMngSeq" id="bulletinMngSeq" value=""/>
	</form>
</div>
&nbsp;
<div class="put_box" style="text-align:right;">
		
		
		<button type="button" class="bbs_btn type03" onclick="insertBulletinMng();"><spring:message code="button.create" text="INSERT"></spring:message></button>
		
</div>