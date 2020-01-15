<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/jobReschMngList.js"></script>
<script>

var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
var errorOneMsg = '<spring:message code="errors.minimum.one" text="Please select one"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';
var endDtMsg    = '<spring:message code="popup.list.title.endDt"></spring:message>';

	$(function() {
		common.invoker.invoke("jobReschMngList");
	});
</script>

<div class="search_box">
	<div class="top_box clearfix">
		<h3><spring:message code="field.dic.jobreschmng.title" /></h3>
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
						<th scope="row"><spring:message code="field.dic.keyword" /></th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<select id="searchKeyword" name="searchKeyword">
								<option value=""><spring:message code="field.dic.select.all" /></option>
								<option value="1"><spring:message code="field.dic.jobtype.nm" /></option>
								<option value="2"><spring:message code="field.dic.def.nm" /></option>
								<option value="3"><spring:message code="field.dic.code" /></option>
							</select>
							<label for="keyword" class="skip"></label>
							<input type="text" id="searchValue" />
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.depth.category" /></th>
						<td>
							<select id="iscoId" name="iscoId" title="iscoId">
								<c:forEach items="${cateOneList}" var="item" varStatus="status">
									<option value="${item.iscoId}"><c:out value="${item.cateNm}" /></option>
								</c:forEach>
							</select>
						</td>
						
					</tr>
					<tr>
						<th scope="row"><spring:message code="title.sample.useYn" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="select" initValue="ALL" exceptValue="" disable=""/>
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
					<input type="button" value="<spring:message code="button.search" />" id="btnSearch" class="btn_submit" />
					
				</div>
			</fieldset>
		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->


<table id="jobReschMng" class="display dataTable bbs_table list">
	<caption>{Board name} Write -  팝업제목, 예약설정, 시작일시, 종료일시, 사용여부, 작성자, 등록일</caption>
		<colgroup>
			<col style="width:8%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col />
		</colgroup>
    <thead>
        <tr>
			<th scope="col">No</th>
			<th scope="col"><spring:message code="field.dic.1depth" /></th>
            <th scope="col"><spring:message code="field.dic.2depth" /></th>
            <th scope="col"><spring:message code="field.dic.3depth" /></th>
            <th scope="col"><spring:message code="field.dic.4depth" /></th>
            <th scope="col"><spring:message code="field.dic.code" /></th>
            <th scope="col"><spring:message code="title.sample.useYn" /></th>
			<th scope="col"><spring:message code="field.dic.reg.user" /></th>
			<th scope="col"><spring:message code="field.dic.reg.dt" /></th>
        </tr>
    </thead>
</table>
<div class="put_box" style="text-align:right;">
	<form id="schFrm">
		<input type="hidden" name="iscoCd" id="iscoCd" value=""/>
	</form>
</div>