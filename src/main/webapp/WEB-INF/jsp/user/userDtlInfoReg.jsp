<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userDtlInfoReg.js"></script>
<script>
//defined screen message
var confirmMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="Do you want save?"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	
var nameBlank = '<spring:message code="user.regist.name.blank.error" text="error!"></spring:message>';
var emailBlank = '<spring:message code="user.regist.email.blank.error" text="error!"></spring:message>';
var emailValid = '<spring:message code="user.regist.email.valid.error" text="error!"></spring:message>';
var passwordBlank = '<spring:message code="user.regist.password.blank.error" text="error!"></spring:message>';
var passwordConfirmBlank = '<spring:message code="user.regist.password_confirm.blank.error" text="error!"></spring:message>';
var passwordNotEqual = '<spring:message code="user.regist.password.equal.error" text="error!"></spring:message>';
var addrBlank = '<spring:message code="user.regist.addr.blank.error" text="error!"></spring:message>';
var addrDtlBlank = '<spring:message code="user.regist.addrDtl.blank.error" text="error!"></spring:message>';
var userCellBlank = '<spring:message code="user.regist.userCell.blank.error" text="error!"></spring:message>';
var userPwdValidError = '<spring:message code="user.regist.password.valid.error" text="error!"></spring:message>';
var chkDuplEmailError = '<spring:message code="user.regist.btn.email.dupl.no" text="error!"></spring:message>';
var chkDuplCellError = '<spring:message code="user.regist.btn.cell.dupl.no" text="error!"></spring:message>';

	$(function() {
		common.invoker.invoke("userDtlInfoReg");
	});
	
</script>

<div id="contents">
	<form name="frm" id="frm" method="post">
	<input type="hidden" name="duplEmailCheck" 		id="duplEmailCheck" value="N"/>
	<input type="hidden" name="duplCellCheck" 		id="duplCellCheck" value="N"/>
	<input type="hidden" name="userAuthCd" 			id="userAuthCd" value=""/>
	<input type="hidden" name="useYn" 				id="useYn" value=""/>
	<input type="hidden" name="infoOpenYn" 			id="infoOpenYn" value=""/>
	<input type="hidden" name="concilReqYn" 		id="concilReqYn" value=""/>
	<input type="hidden" name="smsNtceAgreeYn" 		id="smsNtceAgreeYn" value=""/>
	<input type="hidden" name="emailNtceAgreeYn" 	id="emailNtceAgreeYn" value=""/>
	<input type="hidden" name="birth" 				id="birth" value=""/>
	
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
				<td colspan="3"><commCode:commcode codeKind="commCode" tagName="userAuthCdTemp" grpCd="USER_AUTH_CD" drawType="radio" initValue="ROLE_USER" exceptValue="ALL,ROLE_ADMIN,ROLE_LOWJS,ROLE_CMPNY,ROLE_TRNCT" disable=""/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.jobcntr" text="Job Center"></spring:message></th>
				<td colspan="3"><commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="" exceptValue="ALL" disable=""/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.usernm" text="User Name."></spring:message></th>
				<td><input type="text" id="userNmKh" name="userNmKh"  maxlength="50" size="30"/></td>
				<th scope="row"><span class="exactly y"></span><spring:message code="field.dic.usernmen" text="User Name. Eng."></spring:message></th>
				<td><input type="text" id="userNmEn" name="userNmEn" maxlength="50" size="30"/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.mobile" text="Mobile No."></spring:message></th>
				<td>
					<input type="text" id="userCell" name="userCell" onKeyUp="userDtlInfoReg.fn.resetCellDub();" maxlength="20"/>
					&nbsp;&nbsp;<a class="bbs_btn type03" id="duplCheckCell"><spring:message code="user.regist.btn.cell.check" text="Check Cell"></spring:message></a>
				</td>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.usrsts" text="User Status."></spring:message></th>
				<td><commCode:commcode codeKind="commCode" tagName="userStsCd" grpCd="USER_STS_CD" drawType="select" initValue="USS0000000000" exceptValue="ALL" disable=""/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="userChg.list.title.email" text="E-mail"></spring:message></th>
				<td colspan="3">
					<input type="text" maxlength="80" id="userEmail" name="userEmail"  size="80" onKeyUp="userDtlInfoReg.fn.resetEmailDub();"/>
					&nbsp;&nbsp;<a class="bbs_btn type03" id="duplCheckEmail"><spring:message code="user.regist.btn.email.check" text="Check Email" /></a>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.password" text="Password"></spring:message></th>
				<td colspan="3"><input type="password" id="userPwd" name="userPwd" maxlength="15" size="50"/>
				(<spring:message code="user.regist.password.valid.error" text="Password"/>)
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.password.confirm" text="Confirm Password"></spring:message></th>
				<td colspan="3"><input type="password" id="userPwdConfirm" name="userPwdConfirm" maxlength="15" size="50"/></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="title.sample.useYn" text="Use" /></th>
				<td colspan="3">
					<commCode:commcode codeKind="commCode" tagName="useYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.user.join.div.route" text="Join Route"></spring:message></th>
				<td colspan="3">Internal</td>
			</tr>
			</tbody>
		</table>

		<h3><spring:message code="user.reg.title.second" text="Join Route" /></h3>
		<table class="bbs_table write">
			<caption>Other Member Information - Gender, date of birth, ID Number, Current address Detailed address</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:25%;" />
				<col style="width:15%;" />
				<col style="width:45%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.gender" text="Join Route" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="genderCd" grpCd="GENDER_CD" drawType="radio" initValue="GEN0000000001" exceptValue="ALL" disable=""/>
				</td>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.birth" text="Join Route" /></th>
				<td>
					<commCode:commcode codeKind="birthCode" tagName="birth" grpCd="" drawType="select" initValue="" exceptValue="" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <label for="address"><spring:message code="field.dic.current.addr" text="Address" /></label></th>
				<td colspan="3">
					<input type="hidden" name="addrCd" id="addrCd" value="" />
					<input type="hidden" name="addrFullCd" id="addrFullCd" value="" />
					<input type="hidden" name="addrFullNm" id="addrFullNm" value="" />
					<a class="bbs_btn type03"  onclick="popAddrLayerBtn('addrCd','addrFullCd','addrFullNm','addrFullNmView');"><spring:message code="button.addr.nm" text="Address" /></a>
					<span id="addrFullNmView"></span>
					<br/> <input type="text" id="addrDtl" name="addrDtl" maxlength="100" size="80"/>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly"></span> <label for="ID_number"><spring:message code="field.dic.nid" text="NID" /></label></th>
				<td colspan="3"><input type="text" id="nid" name="nid" maxlength="12" size="50"/></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.info.open" text="Info.Open" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="infoOpenYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
				</td>
				<th scope="row"><spring:message code="field.dic.concil.req" text="Req.Referral" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="concilReqYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.sms.agree" text="SMS Agree" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="smsNtceAgreeYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
				</td>
				<th scope="row"><spring:message code="field.dic.email.agree" text="E-mail Agree" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="emailNtceAgreeYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table write -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<a href="${pageContext.request.contextPath}/internal/user/userInfoList.do" class="bbs_btn list"><spring:message code="cpes.btn.list" text="List" /></a>
			</span>
			<span class="bbs_right">
				<a class="bbs_btn save" id="saveBtn"><spring:message code="cpes.btn.save" text="Save" /></a>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</form>
</div>
