<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/jobsk/jobskVdoIntvwDtlInfo.js"></script>

<script>
$(function() {
	common.invoker.invoke("jobskVdoIntvwDtlInfo");
});
</script>

<form id="frmJobskVdoIntvwDtlInfo">
<input type="hidden" id="videoIntvwSeq" name="videoIntvwSeq" value="<c:out value="${rtnBase.videoIntvwSeq}" />" />
<input type="hidden" id="videoIntvwUserSeq" name="videoIntvwUserSeq" value="<c:out value="${rtnBase.videoIntvwUserSeq}" />" />
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnBase.userSeq}" />" />
<input type="hidden" id="compnySeq" name="compnySeq" value="<c:out value="${rtnBase.compnySeq}" />" />
<input type="hidden" id="jcAgreeStsCdValue" name="jcAgreeStsCdValue" value="<c:out value="${rtnBase.jcAgreeStsCd}" />" />

	<h3><spring:message code="field.dic.intvw.compny.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.intvw.compny.info" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"> <spring:message code="field.dic.intvw.compny.name" /></th>
				<td><a href="#" onclick="btnCompnyDtlInfo();"><c:out value="${rtnBase.compnyNm}" /></a></td>
				<th scope="row"> <spring:message code="field.dic.resprsnnm" /></th>
				<td><c:out value="${rtnBase.mngerNm}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.mobile" /></th>
				<td><c:out value="${rtnBase.mngerCell}" /></td>
				<th scope="row"> <spring:message code="field.dic.email" /></th>
				<td><c:out value="${rtnBase.mngerEmail}" /></td>
			</tr>
			</tbody>
		</table>
	</div>
	
	<h3><spring:message code="field.dic.intvw.user.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.intvw.user.info" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"> <spring:message code="field.dic.intvwer" /></th>
				<td><a href="#" onclick="btnUserDtlInfo();"><c:out value="${rtnBase.userNm}" /></a></td>
				<th scope="row"> <spring:message code="field.dic.mobile" /></th>
				<td><c:out value="${rtnBase.userCell}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.apply.intvw.dt" /></th>
				<td colspan="3"><c:out value="${rtnBase.videoIntvwTime}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.intvw.apply.contents" /></th>
				<td colspan="3"><c:out value="${rtnBase.reqContent}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.intvw.user.center" /></th>
				<td><c:out value="${rtnBase.userJcNm}" /></td>
				<th scope="row"> <spring:message code="field.dic.intvw.compny.center" /></th>
				<td><c:out value="${rtnBase.compnyJcNm}" /></td>
			</tr>
			</tbody>
		</table>
	</div>	
	
	<h3><spring:message code="field.dic.intvw.agree.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.intvw.agree.info" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.jc.agreeyn" /></th>
				<td colspan="3">
					<commCode:commcode codeKind="commCode" tagName="jcAgreeStsCd" grpCd="JC_AGREE_STS_CD" drawType="radio" initValue="" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.agree.intvw.dt" /></th>
				<td colspan="3">
					<input type="radio" id="intvwDtAgreeOpt" name="intvwDtAgreeOpt" value="original" checked="checked"><spring:message code="field.dic.intvw.agree.opt.original" />
					&nbsp;&nbsp;
					<input type="radio" id="intvwDtAgreeOpt" name="intvwDtAgreeOpt" value="change"><spring:message code="field.dic.intvw.agree.opt.change" />
					<br>
					<label for="intvwDt" class="skip">interview date</label>
					<input type="text" id="intvwDt" name="intvwDt" class="datepicker" title="interview date Select from calendar" placeholder="interview date" />
					&nbsp;&nbsp;
					<select id="videoIntvwBgnHour" name="videoIntvwBgnHour" title="Hour">
						<c:forEach var="hour" begin="1" end="12">
						<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
						</c:choose>
						<option value="<c:out value="${setHour}"/>"><c:out value="${setHour}"/></option>
						</c:forEach>
					</select>
					<select id="videoIntvwBgnMinute" name="videoIntvwBgnMinute" title="Minute">
						<c:forEach var="minute" begin="0" end="59">
					<c:choose>
					<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
					<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
					<option value="<c:out value="${setMinute}"/>"><c:out value="${setMinute}"/></option>						
					</c:forEach>
					</select>
					<select id="videoIntvwBgnAmpm" name="videoIntvwBgnAmpm" title="AmPm">
						<option value="AM">AM</option>
						<option value="PM">PM</option>
					</select>
					&nbsp; ~ &nbsp;
					<select id="videoIntvwEndHour" name="videoIntvwEndHour" title="Hour">
						<c:forEach var="hour" begin="1" end="12">
						<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
						</c:choose>
						<option value="<c:out value="${setHour}"/>"><c:out value="${setHour}"/></option>
						</c:forEach>
					</select>
					<select id="videoIntvwEndMinute" name="videoIntvwEndMinute" title="Minute">
						<c:forEach var="minute" begin="0" end="59">
					<c:choose>
					<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
					<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
					<option value="<c:out value="${setMinute}"/>"><c:out value="${setMinute}"/></option>						
					</c:forEach>
					</select>
					<select id="videoIntvwEndAmpm" name="videoIntvwEndAmpm" title="AmPm">
						<option value="AM">AM</option>
						<option value="PM">PM</option>
					</select>
				</td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.approveDt" /></th>
				<td><c:out value="${rtnBase.jcAgreeDt}" /></td>
				<th scope="row"> <spring:message code="field.dic.rsps.prsn" /></th>
				<td><c:out value="${rtnBase.intvwMnger}" /></td>
			</tr>
			</tbody>
		</table>
	</div>
	
	<!-- //bbs_btn_wrap -->
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<a href="${pageContext.request.contextPath}/internal/jobsk/jobskVdoIntvwList.do" class="bbs_btn list"><spring:message code="cpes.btn.list" /></a>
		</span>
		<span class="bbs_right">
		<span class="bbs_right">
			<button type="button" class="bbs_btn delete" onclick="btnJobskVdoIntvwDelete();"><spring:message code="cpes.btn.delete" /></button>
			<button type="button" class="bbs_btn save" onclick="btnJobskVdoIntvwDtlInfoSave();"><spring:message code="cpes.btn.save" /></button>
		</span>
		</span>
	</div>
	<!-- //bbs_btn_wrap -->

</form>