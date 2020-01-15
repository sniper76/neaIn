<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/bulletin/bulletinAtch.js"></script>
<script>

var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
var errorOneMsg = '<spring:message code="errors.minimum.one" text="Please select one"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';

	$(function() {
		common.invoker.invoke("bulletinAtchList");
	});
</script>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
				<input type="hidden" name="bulletinTypeCd" id="bulletinTypeCd" value="BTC0000000004" />
				<input type="hidden" name="programId" id="programId" value="${programId }" />
				<input type="hidden" name="bulletinSeq" id="bulletinSeq" value=""/>
			<fieldset>
				<legend>Bulletin Attchment Search</legend>
				<table>
					<caption>Bulletin Attchment Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.keyword" /></th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<select id="Keyword_sel" name="Keyword_sel">
								<option value=""><spring:message code="field.dic.select.all" /></option>
								<option value="1"><spring:message code="bulletin.select.name" /></option>
								<option value="2"><spring:message code="bulletin.select.content" /></option>
								<option value="3"><spring:message code="bulletin.select.register" /></option>
							</select>
							<label for="keyword" class="skip"></label>
							<input type="text" id="keyword" />
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="bulletin.dic.viewyn" /></th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<commCode:commcode codeKind="commCode" tagName="viewYn" grpCd="FIELD_YN_CD" drawType="select" initValue="ALL" exceptValue="" disable=""/>
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


<table id="bulletinAtch" class="display dataTable bbs_table list">
	<caption>{Board name} Write - 상담게시판, 제목, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
		<colgroup>
			<col style="width:30%;" />
			<col style="width:8%;" />
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
			<th scope="col"><spring:message code="bulletin.dic.name" /></th>
            <th scope="col"><spring:message code="bulletin.dic.viewyn" /></th>
            <th scope="col"><spring:message code="bulletin.dic.fileyn" /></th>
            <th scope="col"><spring:message code="bulletin.select.register" /></th>
            <th scope="col"><spring:message code="bulletin.dic.likecnt" /></th>
            <th scope="col"><spring:message code="bulletin.dic.viewcnt" /></th>
			<th scope="col"><spring:message code="bulletin.dic.regdate" /></th>
			<th scope="col"><spring:message code="bulletin.dic.notiyn" /></th>
        </tr>
    </thead>
</table>
<div class="put_box" style="text-align:right;">
	<form id="schFrm">
		<input type="hidden" name="bulletinSeq" id="bulletinSeq" value=""/>
	</form>
</div>

<div class="bbs_btn_wrap clearfix">
	<!--span class="bbs_left">
		<input type="button" value="공지글 등록" id="btnNotiAdd" class="bbs_btn type06" />
		<input type="button" value="공지글 해제" id="btnNotiRm" class="bbs_btn type06" />
	</span-->
	<span class="bbs_right">
		<button type="button" class="bbs_btn type03" onclick="insertBulletin();"><spring:message code="button.create" /></button>
	</span>
</div>