<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userDtlInfoModify.js"></script>
<script>
//defined screen message
var confirmMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="Do you want save?"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	
var pwdFailCntBlank = '<spring:message code="user.regist.password.blank.error" text="Enter password Fail Count"></spring:message>';
var pwdInitMsg='<spring:message code="user.reg.passwdinit.btn.msg" text="Do you want to reset password?"></spring:message>';
	$(function() {
		common.invoker.invoke("userDtlInfoModify");
	});
	
</script>

<div id="contents">
	<form name="frm" id="frm" method="post">
	<input type="hidden" name="birth" 				id="birth" value=""/>
	<input type="hidden" name="useYn" 				id="useYn" value=""/>
	<input type="hidden" name="infoOpenYn" 			id="infoOpenYn" value=""/>
	<input type="hidden" name="concilReqYn" 		id="concilReqYn" value=""/>
	<input type="hidden" name="smsNtceAgreeYn" 		id="smsNtceAgreeYn" value=""/>
	<input type="hidden" name="emailNtceAgreeYn" 	id="emailNtceAgreeYn" value=""/>
	<input type="hidden" name="userSeq" 			id="userSeq" value="${user.userSeq }"/>
	<input type="hidden" id="previousUrl" name="previousUrl" value="<c:out value="${user.previousUrl}" />" />	
	
		<table class="bbs_table write margin_b_30">
			<caption>Profile - Name, Member Type, Nobile No, E-mail, Job search status, Address</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="userChg.list.title.userDiv" text="Member Type."></spring:message></th>
				<td colspan="3">${user.userAuthNm }</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.jobcntr" text="Job Center"></spring:message></th>
				<td colspan="3">${user.jcNm }</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.usernm" text="User Name."></spring:message></th>
				<td><c:out value="${user.userNmKh}" /></td>
				<th scope="row"><span class="exactly y"></span><spring:message code="field.dic.usernmen" text="UserName.Eng."></spring:message></th>
				<td><c:out value="${user.userNmEn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="userChg.list.title.email" text="E-mail"></spring:message></th>
				<td><c:out value="${user.userEmail}" /></td>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.usrsts" text="User Status."></spring:message></th>
				<td><commCode:commcode codeKind="commCode" tagName="userStsCd" grpCd="USER_STS_CD" drawType="select" initValue="${userStsCd }" exceptValue="ALL" disable=""/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.mobile" text="Mobile No."></spring:message></th>
				<td colspan="3">${user.userCell }</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.authcmplt" text="Auth Status" />/<spring:message code="field.dic.route" text="Method" /></span></th>
				<td colspan="3">${user.authCmpltNm} / ${user.smsEmailAuthDivNm }</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.password" text="Password"></spring:message></th>
				<td><a class="bbs_btn type03"  onclick="userDtlInfoModify.fn.initPwd();"><spring:message code="field.dic.init.btn" text="Initialize Password" /></td>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.password.error.count" text="Password Fail Count"></spring:message></th>
				<td><input type="text" class="pwdFailCnt" id="pwdFailCnt" value="${user.pwdFailCnt }" name="pwdFailCnt" maxlength="3" onKeyUp="onlyNumberCommon(this);"/></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="title.sample.useYn" text="Use" /></th>
				<td colspan="3">
					<commCode:commcode codeKind="commCode" tagName="useYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="${user.useYn }" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.user.join.div.route" text="Join Route"></spring:message></th>
				<td colspan="3">${user.joinRouteDivNm}</td>
			</tr>
			</tbody>
		</table>

		<h3><spring:message code="Title.user.other.info" text="Ohter Information" /></h3>
		<table class="bbs_table write">
			<caption>Other Member Information - Gender, date of birth, ID Number, Current address Detailed address</caption>
			<colgroup>
				<col style="width:15%;">
				<col style="width:25%;">
				<col style="width:15%;">
				<col style="width:45%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.gender" text="Join Route" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="genderCd" grpCd="GENDER_CD" drawType="radio" initValue="${user.genderCd }" exceptValue="ALL" disable=""/>
				</td>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.birth" text="Join Route" /></th>
				<td>
					<commCode:commcode codeKind="birthCode" tagName="birth" grpCd="" drawType="select" initValue="${user.birth }" exceptValue="" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly"></span> <label for="ID_number"><spring:message code="field.dic.nid" text="NID" /></label></th>
				<td colspan="3"><input type="text" id="nid" name="nid" maxlength="12" value="${user.nid }"/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <label for="address"><spring:message code="field.dic.current.addr" text="Address" /></label></th>
				<td colspan="3">
					<input type="hidden" name="addrCd" id="addrCd" value="${user.addrCd }" />
					<input type="hidden" name="addrFullCd" id="addrFullCd" value="<c:out value="${user.addrFullCd }"/>" />
					<input type="hidden" name="addrFullNm" id="addrFullNm" value="<c:out value="${user.addrFullNm }"/>" />
					<a class="bbs_btn type03"  onclick="popAddrLayerBtn('addrCd','addrFullCd','addrFullNm','addrFullNmView');"><spring:message code="button.addr.nm" text="Address" /></a>
					<span id="addrFullNmView"><c:out value="${user.addrFullNm }" escapeXml="false"/></span>
					<br/> <input type="text" id="addrDtl" name="addrDtl" value="<c:out value="${user.addrDtl }" escapeXml="false" />" maxlength="100" size="100"/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.info.open" text="Info.Open" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="infoOpenYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="${user.infoOpenYn}" exceptValue="ALL" disable=""/>
				</td>
				<th scope="row"><spring:message code="field.dic.concil.req" text="Req.Referral" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="concilReqYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="${user.concilReqYn }" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.sms.agree" text="SMS Agree" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="smsNtceAgreeYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="${user.smsNtceAgreeYn }" exceptValue="ALL" disable=""/>
				</td>
				<th scope="row"><spring:message code="field.dic.email.agree" text="E-mail Agree" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="emailNtceAgreeYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="${user.emailNtceAgreeYn }" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table write -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<button type="button" class="bbs_btn list" onclick="fnGoBackList();"><spring:message code="button.list" /></button>
			</span>
			<span class="bbs_right">
				<a class="bbs_btn save" id="saveBtn"><spring:message code="cpes.btn.save" text="Save" /></a>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</form>
</div>
