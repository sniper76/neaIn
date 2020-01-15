<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<link rel="stylesheet" href="https://cdn.datatables.net/select/1.2.1/css/select.dataTables.min.css" />
<script src="https://cdn.datatables.net/select/1.2.1/js/dataTables.select.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/dtlCdMngList.js"></script>
<script>
	var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
	var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';
	var deleteMsg 	= '<spring:message code="cpes.save.btn.delete.msg" text="delete"></spring:message>';
	var modifyMsg 	= '<spring:message code="cpes.save.btn.modify.msg" text="Modify"></spring:message>';
	var selGrpMsg 	= '<spring:message code="field.dic.select.msg" text="error"></spring:message>';
	//$(function() {
	//	common.invoker.invoke("dtlCdMngList");
	//});
	var txtGrp = '<spring:message code="field.dic.grp.nm" text="Modify"></spring:message>';
</script>

<div class="search_box">
	<div class="top_box clearfix">
		<h3><spring:message code="field.dic.dtl.mng" /></h3>
	</div>
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
				<input type="hidden" id="srchGrpCd" name="srchGrpCd" value="none"/>
			<fieldset>
				<legend>Bulletin Management Search</legend>
				<table>
					<caption>Bulletin Management Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="button.search" /></th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<select id="searchKeyword">
								<option value=""><spring:message code="field.dic.select.all" /></option>
								<option value="1"><spring:message code="field.dic.grpcd.nm" /></option>
								<option value="2"><spring:message code="field.dic.grpcd" /></option>
								<option value="3"><spring:message code="field.dic.reg.user" /></option>
							</select>
							<label for="keyword" class="skip"></label>
							<input type="text" id="searchValue" />
							<input type="button" value="SEARCH" id="btnSearch" class="bbs_btn type03" />
						</td>
					</tr>
					</tbody>
				</table>
				
			</fieldset>
		</form>
	</div>
	<!-- //contents_box -->
</div>
<table id="grpCdList" class="display dataTable bbs_table list">
	<caption>{Board name} Write -  팝업제목, 예약설정, 시작일시, 종료일시, 사용여부, 작성자, 등록일</caption>
		<colgroup>
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col />
		</colgroup>
	<thead>
		<tr>
			<th scope="col"><spring:message code="field.dic.grpcd" /></th>
			<th scope="col"><spring:message code="field.dic.grpcd.nm" /></th>
			<th scope="col"><spring:message code="title.sample.useYn" /></th>
			<th scope="col"><spring:message code="field.dic.reg.user" /></th>
			<th scope="col"><spring:message code="field.dic.reg.dt" /></th>
		</tr>
	</thead>
</table>
<!-- //search_box -->
<div class="margin_t_10 clearfix">
		<div class="bbs_left" style="width:59%;">
			<h3><spring:message code="field.dic.grp.nm" /></h3>	<h3 id="txtgrpNm"></h3>
			<table id="dtlCdList" class="display dataTable bbs_table list">
				<caption>{Board name} Write - 금지어, No, 금지어, 등록일, 수정일, 수정</caption>
					<colgroup>
						<col style="width:15%;" />
						<col style="width:15%;" />
						<col style="width:15%;" />
						<col style="width:8%;" />
					</colgroup>
				<thead>
					<tr>
						<th scope="col"><spring:message code="field.dic.dtl" /></th>
						<th scope="col"><spring:message code="field.dic.dtl.kh" /></th>
						<th scope="col"><spring:message code="field.dic.dtl.en" /></th>
						<th scope="col"><spring:message code="title.sample.useYn" /></th>
					</tr>
				</thead>
			</table>  
		</div>
		
		<div class="bbs_right" style="width:39%;">
			<form id="txtfrm">
			<h3><spring:message code="field.dic.dtl.info" /></h3>
		   <table class="bbs_table write">
				<caption>{Board name} Write - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트 입력</caption>
				<colgroup>
					<col style="width:30%;" />
					<col style="width:70%;" />
				</colgroup>
				<tbody>
				<tr>
					<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.grpcd" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
					<td >
						<input type="text" name="grpCd" id="grpCd" value="" readonly="true" />
					</td>
				</tr>
				<tr>
					<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.dtl" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
					<td >
						<input type="text" name="dtlCd" id="dtlCd" value=""  />
					</td>
				</tr>
				<tr>
					<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.dtl.kh" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
					<td ><input type="text" name="cdKhNm" id="cdKhNm" /></td>
				</tr>
				<tr>
					<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.dtl.en" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
					<td ><input type="text" name="cdEnNm" id="cdEnNm" /></td>
				</tr>
				<tr>
					<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="title.sample.description" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
					<td ><input type="text" name="cdContent" id="cdContent" /></td>
				</tr>
				<tr>
					<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="title.sample.useYn" /></label></th>
					<td colspan="3">
						<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="" exceptValue="ALL" disable=""/>
					</td>
				</tr>
		   </table>
		   <div class="bbs_btn_wrap clearfix">
				<span class="bbs_left">
					<input type="button" value="<spring:message code="button.delete" />" id="btnDelete" class="bbs_btn type06" onclick="deleteDtlCdConf();"/>
				</span>
				<span class="bbs_right">
					<button type="button" value="save" class="bbs_btn save" onclick="newDtlCd();"><spring:message code="btn.new.write" /></button>
					<button type="button" value="save" class="bbs_btn save" onclick="saveDtlCdConf();"><spring:message code="cpes.btn.save" /></button>
				</span>
			</div>
		</form>
		</div>
		
	 </div>
