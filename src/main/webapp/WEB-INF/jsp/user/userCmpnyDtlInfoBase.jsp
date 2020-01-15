<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userCmpnyDtlInfoBase.js"></script>

<script>
$(function() {
	common.invoker.invoke("userCmpnyDtlInfoBase");
});

$("#userDtlInfoModifyBtn").click(function(){
	goDetil();
});
</script>

<form id="frmUserCmpnyDtlInfoBase">
<!--  
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnBaseData.userSeq}" />" />
<input type="hidden" id="compnySeq" name="compnySeq" value="<c:out value="${rtnBaseData.compnySeq}" />" />
-->

	<h3><spring:message code="field.dic.accout.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table view margin_b_20">
			<caption>Account information - Name, Membership status, e-mail, Moblie No., Password, Membership Registration Path</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><spring:message code="field.dic.company.name" /> (Khmer)</th>
				<td><c:out value="${rtnBaseData.compnyNmKh}" /></td>
				<th scope="row"><spring:message code="field.dic.company.name" /> (English)</th>
				<td><c:out value="${rtnBaseData.compnyNmEn}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.compny.type" /></th>
				<td><c:out value="${rtnBaseData.compnyTypeNm}" /></td>
				<th scope="row"><spring:message code="field.dic.usrsts" /></th>
				<td><c:out value="${rtnBaseData.userStsNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.sector" /></th>
				<td colspan="3"><c:out value="${rtnBaseData.isicNm}" /></td>
			</tr>	
			<tr>
				<th scope="row"><spring:message code="field.dic.reg.num" /></th>
				<td><c:out value="${rtnBaseData.regNum}" /></td>
				<th scope="row"><spring:message code="field.dic.patent.num" /></th>
				<td><c:out value="${rtnBaseData.patentNum}" /></td>
			</tr>	
			<tr>
				<th scope="row"><spring:message code="field.dic.nation" /></th>
				<td><c:out value="${rtnBaseData.ownerNationNm}" /></td>
				<th scope="row"><spring:message code="field.dic.excutive.rate" /></th>
				<td><c:out value="${rtnBaseData.exeEmployeeRate}" /> %</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.current.addr" /></th>
				<td colspan="3"><c:out value="${rtnBaseData.addrDtl}" /></td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->
		
		<h3><spring:message code="field.dic.contact.info" /></h3>
		<table class="bbs_table view">
			<caption><spring:message code="field.dic.contact.info" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><spring:message code="field.dic.resprsnnm" /></th>
				<td><c:out value="${rtnBaseData.mngerNm}" /></td>
				<th scope="row"><spring:message code="field.dic.job.position" /></th>
				<td><c:out value="${rtnBaseData.mngerPosition}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.officetel" /></th>
				<td><c:out value="${rtnBaseData.mngerTel}" /></td>			
				<th scope="row"><spring:message code="field.dic.fax" /></th>
				<td><c:out value="${rtnBaseData.compnyFax}" /></td>
			</tr>						
			<tr>
				<th scope="row"><spring:message code="field.dic.website" /></th>
				<td colspan="3"><c:out value="${rtnBaseData.compnyWebsite}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.sms.agree" /></th>
				<td><c:out value="${rtnBaseData.smsNcteAgreeYn}" /></td>			
				<th scope="row"><spring:message code="field.dic.email.agree" /></th>
				<td><c:out value="${rtnBaseData.emailNcteAgreeYn}" /></td>
			</tr>			
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<button type="button" class="bbs_btn list" onclick="fnGoPageCompnyInfoListBack();"><spring:message code="button.list" /></button>
			</span>
			<span class="bbs_right">
				<input type="button" value="<spring:message code="cpes.btn.modify" />" class="bbs_btn modify" id="userDtlInfoModifyBtn" />
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->

</form>