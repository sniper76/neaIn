<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userElementaryDtlInfoReg.js"></script>

<script>
$(function() {
	common.invoker.invoke("userElementaryDtlInfoReg");
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

<form id="frmUserElementaryInfoReg">

	<h3>Account information</h3>
	<div class="bbs_basic">
		<table class="bbs_table view margin_b_20">
			<caption>Account information - Name, Membership status, e-mail, Moblie No., Password, Membership Registration Path</caption>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="userChg.list.title.userDiv" /></th>
				<td colspan="3"><c:out value="${rtnBase.userAuthNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="search.name" /> (Khmer)</th>
				<td><input type="text" name="userNmKh" id="userNmKh" value="" required/></td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="search.name" /> (English)</th>
				<td><input type="text" name="userNmEn" id="userNmEn" value="" required/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.mobile" /></th>
				<td>
					<input type="text" name="userCell" id="userCell" value="" required />
					<input type="hidden" name="userCellCheck" id="userCellCheck" value="" />
					<button type="button" id="btnUserCellChk" class="bbs_btn save" onclick="fnUserCellChk();"><spring:message code="field.dic.dup.check" /></button>
				</td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.usrsts" /></th>
				<td><c:out value="${rtnBase.userStsNm}" /></td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<h3>Other Member Information</h3>
		<table class="bbs_table view">
			<caption>Other Member Information - Gender, date of birth, ID Number, Current address Detailed address</caption>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.gender" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="genderCd" grpCd="GENDER_CD" drawType="radio" initValue="GEN0000000001" exceptValue="ALL" disable=""/>
				</td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.birth" /></th>
				<td>
					<select id="birthDay" name="birthDay" title="D">
						<c:forEach var="day" begin="1" end="31">
						<c:choose>
						<c:when test="${day < 10}"><c:set var="setDay" value="0${day}" /></c:when>
						<c:otherwise><c:set var="setDay" value="${day}" /></c:otherwise>
						</c:choose>
						<option value="<c:out value="${setDay}"/>"><c:out value="${setDay}"/></option>
						</c:forEach>
					</select>
					Day&nbsp;&nbsp;
					<select id="birthMonth" name="birthMonth" title="M">
						<c:forEach var="month" begin="1" end="12">
						<c:choose>
						<c:when test="${month < 10}"><c:set var="setMonth" value="0${month}" /></c:when>
						<c:otherwise><c:set var="setMonth" value="${month}" /></c:otherwise>
						</c:choose>
						<option value="<c:out value="${setMonth}"/>"><c:out value="${setMonth}"/></option>
						</c:forEach>
					</select>
					Month&nbsp;&nbsp;
					<select id="birthYear" name="birthYear" title="Y">
						<c:set var="now" value="<%=new java.util.Date()%>" />
						<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
						<c:forEach var="year" begin="1900" end="${sysYear}">
							<option value="<c:out value="${year}"/>"><c:out value="${year}"/></option>
						</c:forEach>
					</select>
					Year
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.sid" /></th>
				<td colspan="3">
					<input type="text" id="nid" name="nid" value="" required />
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.current.addr" /></th>
				<td colspan="3">
					<input type="hidden" name="addrCd" id="addrCd" value="" required/>
					<input type="hidden" name="addrFullCd" id="addrFullCd" value="" required/>
					<button type="button" value="popup" class="bbs_btn type03" onclick="popAddrLayerBtn('addrCd', 'addrFullCd', 'addrFullNm', 'addrFullNmView');"><spring:message code="field.dic.area" /></button>
					<br>
					<label for="addrDtl"><spring:message code="field.dic.addr.base" /></label>&nbsp;&nbsp;<input type="text" name="addrFullNm" id="addrFullNm" value="" style="width:50%;" disabled="disabled" /><br>
					<label for="addrDtl"><spring:message code="field.dic.dtladdr" /></label>&nbsp;&nbsp;<input type="text" name="addrDtl" id="addrDtl" style="width:50%;" value="" />
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.sms.agree" /></th>
				<td colspan="3">
					<commCode:commcode codeKind="commCode" tagName="smsNtceAgreeYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<a href="${pageContext.request.contextPath}/internal/user/userElementaryInfoList.do" class="bbs_btn list" onclick="fnGoPageUserInfoListBack();"><spring:message code="button.list" /></a>
			</span>
			<span class="bbs_right">
				<button type="button" id="btnUserInfoReg" class="bbs_btn save" onclick="fnUserInfoReg();"><spring:message code="button.create" /></button>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->

</form>