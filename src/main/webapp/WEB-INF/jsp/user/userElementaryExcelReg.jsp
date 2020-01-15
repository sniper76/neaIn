<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userElementaryExcelReg.js"></script>

<script>
$(function() {
	common.invoker.invoke("userElementaryExcelReg");
});

var userCellDupMsgErr = '<spring:message code="user.regist.dupl.cell.error" text=""></spring:message>';
var userCellDupMsg = '<spring:message code="cpes.use.ok.msg" text=""></spring:message>';

var msgErrKhNameEmpty = '<spring:message code="msg.err.kmr.name.empty" text=""></spring:message>';
var msgErrEnNameEmpty = '<spring:message code="msg.err.eng.name.empty" text=""></spring:message>';
var msgErrCellEmpty = '<spring:message code="msg.err.cell.num.empty" text=""></spring:message>';
var msgErrNidEmpty = '<spring:message code="msg.err.nid.empty" text=""></spring:message>';
var msgErrAddrEmpty = '<spring:message code="msg.err.addr.empty" text=""></spring:message>';
var msgErrCellDupCheckEmpty = '<spring:message code="msg.err.cell.dup.check.empty" text=""></spring:message>';
var msgErrCellDupCheckFalse = '<spring:message code="msg.err.cell.dup.check.false" text=""></spring:message>';

</script>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmUserElementaryExcelReg">
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption><spring:message code="field.dic.user.registration.excel" /></caption>
					<colgroup>
						<col style="width:12%;" />
						<col style="width:38%;" />
						<col style="width:12%;" />
						<col style="width:38%;" />
					</colgroup>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.excel.form.download" /></th>
						<td colspan="3">
							<button type="button" value="popup" class="bbs_btn type03 download" onclick="popAddrLayerBtn('addrCd', 'addrFullCd', 'addrFullNm', 'addrFullNmView');"><spring:message code="field.dic.form.download" /></button>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.excel.form.input" /></th>
						<td colspan="3">
							<input type="file" id="resumeExcelFile" name="resumeExcelFile" >
						</td>
					</tr>
					</tbody>
				</table>
				<div class="put_box">
					<!--  
					<input type="button" id="btnUserExcelReg" class="btn_submit" value="<spring:message code="field.dic.excel.form.upload" />" >
					-->
					<button type="button" id="btnUserExcelReg" class="bbs_btn save" onclick="fnUserExcelReg();"><spring:message code="field.dic.excel.form.upload" /></button>
				</div>
			</fieldset>
						
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

