<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/js/pageLib/common/jobCenterList.js"></script>

<script>
	$(function() {
		common.invoker.invoke("jobCenterList");
	});
</script>

<div class="search_box">
	<div class="top_box clearfix">
		<h3><spring:message code="field.dic.jobcntr.mgmt" /></h3>
	</div>
	<!-- //top_box -->
	<div class="contents_box">
		<form id="schFrm">
				<input type="hidden" id="jcCd" name="jcCd" value="" />
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
								<option value="1"><spring:message code="field.dic.jobcntr" /></option>
								<option value="2"><spring:message code="field.dic.dtl.desc" /></option>
								<option value="3"><spring:message code="field.dic.reg.user" /></option>
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
		<table id="jobCtList" class="bbs_table list">
			<caption>job center list</caption>
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
				<th scope="col"><spring:message code="field.dic.jobcntr" /></th>
				<th scope="col"><spring:message code="field.dic.code" /></th>
				<th scope="col"><spring:message code="field.dic.area" /></th>
				<th scope="col"><spring:message code="field.dic.tel" /></th>
				<th scope="col"><spring:message code="field.dic.tel2" /></th>
				<th scope="col"><spring:message code="field.dic.email" /></th>
				<th scope="col"><spring:message code="field.dic.google.map" /></th>
				<th scope="col"><spring:message code="title.sample.useYn" /></th>
				<th scope="col"><spring:message code="field.dic.reg.date" /></th>
				<th scope="col"><spring:message code="field.dic.reg.user" /></th>
			</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>

	<div class="put_box" style="text-align:right;">


			<button type="button" class="bbs_btn type03" onclick="insertJobCenter();"><spring:message code="button.create" /></button>

	</div>


