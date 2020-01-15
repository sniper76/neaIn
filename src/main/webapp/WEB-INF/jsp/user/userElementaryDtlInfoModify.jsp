<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userElementaryDtlInfoModify.js"></script>

<script>
$(function() {
	common.invoker.invoke("userElementaryDtlInfoModify");
});
</script>

<form id="frmUserElementaryDtlInfoModify">
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnBase.userSeq}" />" />
<input type="hidden" id="userStsCdValue" name="userStsCdValue" value="<c:out value="${rtnBase.userStsCd}" />" />
<input type="hidden" id="genderCdValue" name="genderCdValue" value="<c:out value="${rtnBase.genderCd}" />" />
<input type="hidden" id="birthYearValue" name="birthYearValue" value="<c:out value="${rtnBase.birthYear}" />" />
<input type="hidden" id="birthMonthValue" name="birthMonthValue" value="<c:out value="${rtnBase.birthMonth}" />" />
<input type="hidden" id="birthDayValue" name="birthDayValue" value="<c:out value="${rtnBase.birthDay}" />" />
<input type="hidden" id="smsNtceAgreeYnValue" name="smsNtceAgreeYnValue" value="<c:out value="${rtnBase.smsNtceAgreeYn}" />" />

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
				<th scope="row"><spring:message code="userChg.list.title.userDiv" /></th>
				<td colspan="3"><c:out value="${rtnBase.userAuthNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="search.name" /> (Khmer)</th>
				<td><c:out value="${rtnBase.userNmKh}" /></td>
				<th scope="row"><spring:message code="search.name" /> (English)</th>
				<td><c:out value="${rtnBase.userNmEn}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.mobile" /></th>
				<td><c:out value="${rtnBase.userCell}" /></td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.usrsts" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="userStsCd" grpCd="USER_STS_CD" drawType="select" initValue="" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.authcmplt" /> / <spring:message code="field.dic.route" /></th>
				<td><c:out value="${rtnBase.authCmpltYn}" /> / <c:out value="${rtnBase.smsEmailAuthDivNm}" /></td>
				<th scope="row"><spring:message code="field.dic.joinroute" /></th>
				<td><c:out value="${rtnBase.joinRouteDivNm}" /></td>
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
					<commCode:commcode codeKind="commCode" tagName="genderCd" grpCd="GENDER_CD" drawType="radio" initValue="" exceptValue="ALL" disable=""/>
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
					<input type="text" id="nid" name="nid" value="<c:out value="${rtnBase.nid}" />" >
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.current.addr" /></th>
				<td colspan="3">
					<input type="hidden" name="addrCd" id="addrCd" value="<c:out value="${rtnBase.addrCd}" />" required/>
					<input type="hidden" name="addrFullCd" id="addrFullCd" value="<c:out value="${rtnBase.addrFullCd}" />" required/>
					<button type="button" value="popup" class="bbs_btn type03" onclick="popAddrLayerBtn('addrCd', 'addrFullCd', 'addrFullNm', 'addrFullNmView');"><spring:message code="field.dic.area" /></button>
					&nbsp;&nbsp;
					<c:out value="${rtnBase.addrDtl}" />&nbsp;&nbsp;${rtnBase.addrFullNm}<br>
					<label for="addrFullNm"><spring:message code="field.dic.addr.base" /></label>&nbsp;&nbsp;<input type="text" name="addrFullNm" id="addrFullNm" style="width:50%;" value="${rtnBase.addrFullNm}" required/><br>
					<label for="addrDtl"><spring:message code="field.dic.dtladdr" /></label>&nbsp;&nbsp;<input type="text" name="addrDtl" id="addrDtl" style="width:50%;" value="<c:out value="${rtnBase.addrDtl}" />"/>					
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.sms.agree" /></th>
				<td colspan="3">
					<commCode:commcode codeKind="commCode" tagName="smsNtceAgreeYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<a href="${pageContext.request.contextPath}/internal/user/userElementaryInfoList.do" class="bbs_btn list" ><spring:message code="button.list" /></a>
			</span>
			<span class="bbs_right">
				<button type="button" id="btnUserInfoDelete" class="bbs_btn delete" onclick="fnUserInfoDelete();"><spring:message code="cpes.btn.delete" /></button>
				<button type="button" id="btnUserInfoSave" class="bbs_btn save" onclick="fnUserInfoSave();"><spring:message code="cpes.btn.save" /></button>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->

</form>