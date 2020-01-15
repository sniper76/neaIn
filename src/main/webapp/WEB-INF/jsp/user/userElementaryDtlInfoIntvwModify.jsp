<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userElementaryDtlInfoIntvwModify.js"></script>

<script>
$(function() {
	common.invoker.invoke("userElementaryDtlInfoIntvwModify");
});


var msgErrIntvwDtEmpty = '<spring:message code="msg.err.intvw.dt.empty" text=""></spring:message>';
var msgErrAddrEmpty = '<spring:message code="msg.err.addr.empty" text=""></spring:message>';
var msgErrIntvwCompnyEmpty = '<spring:message code="msg.err.intvw.compny.empty" text=""></spring:message>';

</script>

<form id="frmUserElementaryInfoIntvwModify">
<input type="hidden" id="intvwHisSeq" name="userSeq" value="<c:out value="${rtnData.intvwHisSeq}" />" />
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnData.userSeq}" />" />
<input type="hidden" id="resumeSeq" name="resumeSeq" value="<c:out value="${rtnData.resumeSeq}" />" />
<input type="hidden" id="intvwDtValue" name="intvwDtValue" value="<c:out value="${rtnData.intvwDt}" />" />
<input type="hidden" id="intvwDtHourValue" name="intvwDtHourValue" value="<c:out value="${rtnData.intvwDtHour}" />" />
<input type="hidden" id="intvwDtMinuteValue" name="intvwDtMinuteValue" value="<c:out value="${rtnData.intvwDtMinute}" />" />
<input type="hidden" id="intvwDtAmpmValue" name="intvwDtAmpmValue" value="<c:out value="${rtnData.intvwDtAmpm}" />" />

	<h3><spring:message code="field.dic.intvw.his.modify" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table view margin_b_20">
			<caption><spring:message code="field.dic.intvw.his.modify" /></caption>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.intvw.dt" /></th>
				<td colspan="3">
					<label for="intvwDt" class="skip">interview date</label>
					<input type="text" id="intvwDt" name="intvwDt" class="datepicker" title="interview date Select from calendar" placeholder="interview date" />
					&nbsp;&nbsp;
					<select id="intvwDtHour" name="intvwDtHour" title="Hour">
						<c:forEach var="hour" begin="1" end="12">
						<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
						</c:choose>
						<option value="<c:out value="${setHour}"/>"><c:out value="${setHour}"/></option>
						</c:forEach>
					</select>
					<select id="intvwDtMinute" name="intvwDtMinute" title="Minute">
						<c:forEach var="minute" begin="0" end="59">
					<c:choose>
					<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
					<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
					<option value="<c:out value="${setMinute}"/>"><c:out value="${setMinute}"/></option>						
					</c:forEach>
					</select>
					<select id="intvwDtAmpm" name="intvwDtAmpm" title="AmPm">
						<option value="AM">AM</option>
						<option value="PM">PM</option>
					</select>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.intvw.addr" /></th>
				<td colspan="3">
					<input type="hidden" name="addrCd" id="addrCd" value="<c:out value="${rtnData.addrCd}" />" required/>
					<input type="hidden" name="addrFullCd" id="addrFullCd" value="<c:out value="${rtnData.addrFullCd}" />" required/>
					<button type="button" value="popup" class="bbs_btn type03" onclick="popAddrLayerBtn('addrCd', 'addrFullCd', 'addrFullNm', 'addrFullNmView');"><spring:message code="field.dic.area" /></button>
					<br>
					<label for="addrDtl"><spring:message code="field.dic.addr.base" /></label>&nbsp;&nbsp;<input type="text" name="addrFullNm" id="addrFullNm" value="<c:out value="${rtnData.addrFullNm}" />" style="width:50%;" disabled="disabled" /><br>
					<label for="addrDtl"><spring:message code="field.dic.dtladdr" /></label>&nbsp;&nbsp;<input type="text" name="addrDtl" id="addrDtl" style="width:50%;" value="<c:out value="${rtnData.addrDtl}" />" />					
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.intvw.compny" /></th>
				<td colspan="3">
					<input type="hidden" name="compnySeq" id="compnySeq" value="" />
					<button type="button" value="popup" class="bbs_btn type03" onclick="popreferralCmpnySearchLayerBtn();"><spring:message code="field.dic.srch.compny" /></button>
					&nbsp;&nbsp;<label for="compnyNmKh">Khmer</label><input type="text" name="compnyNmKh" id="compnyNmKh" value="<c:out value="${rtnData.compnyNmKh}" />" disabled="disabled" />
					&nbsp;&nbsp;<label for="compnyNmEn">English</label><input type="text" name="compnyNmEn" id="compnyNmEn" value="<c:out value="${rtnData.compnyNmEn}" />" disabled="disabled" />
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.intvw.content" /></th>
				<td colspan="3">
					<textarea id="content" name="content"><c:out value="${rtnData.content}" /></textarea>
				</td>
			</tr>			
			</tbody>
		</table>
		<!-- //bbs_table view -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<a href="#" class="bbs_btn list" onclick="tabIntvwDtlInfo();"><spring:message code="button.list" /></a>
			</span>
			<span class="bbs_right">
				<button type="button" id="btnUserElementaryDtlInfoIntvwModify" class="bbs_btn save" onclick="fnUserElementaryDtlInfoIntvwModify();"><spring:message code="cpes.btn.save" /></button>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</div>
	<!-- //회원정보 -->

</form>