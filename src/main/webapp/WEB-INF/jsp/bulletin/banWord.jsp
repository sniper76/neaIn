<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/bulletin/banWord.js"></script>
<script>
	var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
	var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';
	var deleteMsg 	= '<spring:message code="cpes.save.btn.delete.msg" text="delete"></spring:message>';
	var modifyMsg 	= '<spring:message code="cpes.save.btn.modify.msg" text="Modify"></spring:message>';
	$(function() {
		common.invoker.invoke("banWordList");
	});
</script>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
				<input type="hidden" id="banwordtxt" name="banwordtxt" value=""/>
				<input type="hidden" id="banwordSeq" name="banwordSeq" value=""/>
			<fieldset>
				<legend>Bulletin Management Search</legend>
				<table>
					<caption>Bulletin Management Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="button.search" /> <spring:message code="field.dic.keyword" /></th>
						<td>
							<label for="" class="skip"></label>
							<input type="text" id="keyword" name="keyword" size="50" maxlength="50"/>
							<input type="button" value="SEARCH" id="btnSearch" class="bbs_btn type03" />
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.banword" /></th>
						<td>
							<label for="" class="skip"></label>
							<input type="text" id="banword" name="banword" value="" size="50" maxlength="50"/>
							<button type="button" value="save" class="bbs_btn save" onclick="insertBanWordConf();"><spring:message code="button.create" /></button>
						</td>
					</tr>
					
					</tbody>
				</table>
				
			</fieldset>
		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->


<table id="banwordList" class="display dataTable bbs_table list">
	<caption>{Board name} Write - 금지어, No, 금지어, 등록일, 수정일, 수정</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:8%;" />
			<col style="width:45%;" />
			<col style="width:15%;" />
			<col style="width:15%;" />
			<col style="width:10%;" />
		</colgroup>
    <thead>
        <tr>
			<th scope="col"></th>
			<th scope="col">No</th>
            <th scope="col"><spring:message code="field.dic.banword.banword" /></th>
            <th scope="col"><spring:message code="field.dic.reg.dt" /></th>
            <th scope="col"><spring:message code="field.dic.moddt" /></th>
            <th scope="col"><spring:message code="field.dic.modify" /></th>
        </tr>
    </thead>
</table>
<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<input type="button" value="<spring:message code="button.delete" />" id="btnDelete" class="bbs_btn type06" />
	</span>
</div>