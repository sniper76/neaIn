<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/counsel/courseAnsReg.js"></script>
<script>
	$(function() {
		common.invoker.invoke("courseAnsReg");
	});
	
	var delConfirmMsg = '<spring:message code="cpes.delete.btn.confirm.msg" />';
	var confirmMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="Do you want save?"></spring:message>';
	var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
</script>

<form id="frmCourseAnsReg" >
<input type="hidden" id="counselSeq" name="counselSeq" value="<c:out value="${CounselBean.counselSeq}" />" />
<input type="hidden" id="counselMethodDivCd" name="counselMethodDivCd" value="<c:out value="${CounselBean.counselMethodDivCd}" />" />
<input type="hidden" id="ansRegDt" name="ansRegDt" value="<c:out value="${CounselBean.ansRegDt}" />" />
<input type="hidden" id="commonUploadResult" name="uploadResult">

<h3>기본내용</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table write">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.title" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.qustTitle}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.reg.user" /></th>
			<td>
				<c:out value="${CounselBean.userNm}" />
			</td>
			<th scope="row"><spring:message code="field.dic.user.type" /></th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq CounselBean.userAuthCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="course.list.title.method" /></th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq CounselBean.counselMethodDivCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
			<th scope="row"><spring:message code="course.list.title.cate.div" /></th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq CounselBean.counselTargetCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.like.cnt" /></th>
			<td>
				<c:out value="${CounselBean.likeCnt}" />
			</td>
			<th scope="row"><spring:message code="field.dic.srch.cnt" /></th>
			<td>
				<c:out value="${CounselBean.viewCnt}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="course.list.title.viewyn" /></th>
			<td>
				<c:out value="${CounselBean.secretYn}" />
			</td>
			<th scope="row"><spring:message code="bulletin.dic.regdate" /></th>
			<td>
				<c:out value="${CounselBean.qustRegDt}" />
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table write -->
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->

<h3>상담자 정보</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table write">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.controll.center" /></th>
			<td>
				<c:out value="${CounselBean.jcNm}" />
			</td>
			<th scope="row"><spring:message code="field.dic.councsel" /><spring:message code="field.dic.employee.nm" /></th>
			<td>
				<c:out value="${CounselBean.jcUserNm}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="course.list.title.status" /></th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.grpCd eq 'COUNSEL_STS_CD'}">
						<input type="radio" id="counselStsCd<c:out value="${status.index}"/>" name="counselStsCd" value="<c:out value="${item.dtlCd}"/>" <c:if test="${item.dtlCd eq CounselBean.counselStsCd}"> checked="true" </c:if> />
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
			<th scope="row"><spring:message code="field.dic.answer.dt" /></th>
			<td>
				<c:out value="${CounselBean.ansModDt}" />
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table write -->
</div>
<!-- //bbs_basic view -->
<c:choose>
	<c:when test="${'CMD0000000001' ne CounselBean.counselMethodDivCd}">

<h3>상담요청내용</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table write">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.hope.counsel.dt" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.hopeCounselDt}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.etc.req.option" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.qustEtcReq}" />
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->

	</c:when>
	<c:otherwise>

<h3><spring:message code="field.dic.councsel" /><spring:message code="bulletin.select.content" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table write">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.councsel" /><spring:message code="bulletin.select.content" /></th>
			<td colspan="3">
				<c:out value="${CounselBean.qustContent}" />
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table write -->
</div>
<!-- //bbs_basic view -->

	</c:otherwise>
</c:choose>

<c:if test="${'CMD0000000001' ne CounselBean.counselMethodDivCd}">
<h3><spring:message code="field.dic.counsel.noti" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table write">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row">
				<span class="exactly y">necessary</span>
				<label for=""><spring:message code="field.dic.councsel" /><spring:message code="field.dic.date" /></label>
			</th>
			<td colspan="3">
				<span class="period_box">
					<span class="date_box">
						<input type="text" id="counselDt" name="counselDt" value="<c:out value="${CounselBean.counselDt}" />" class="datepicker" title="date Select from calendar" placeholder="hope counsel date" required />
					</span>
				</span>
				<span class="bbs_date" style="padding-left:25px;">
					<select id="counselHour" name="counselHour" title="hour">
					<c:forEach var="hour" begin="1" end="12">
					<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setHour}"/>"  <c:if test="${setHour eq CounselBean.counselHour}"> selected="selected" </c:if> ><c:out value="${setHour}"/></option>
					</c:forEach>
					</select>
					<label for="counselHour">HOUR</label>

				</span>
				<span class="bbs_date">
					<select id="counselMinute" name="counselMinute" title="minute">
					<c:forEach var="minute" begin="0" end="59">
					<c:choose>
						<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
						<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setMinute}"/>" <c:if test="${setMinute eq CounselBean.counselMinute}"> selected="selected" </c:if> ><c:out value="${setMinute}"/></option>
					</c:forEach>
					</select>
					<label for="counselMinute">MINUTE</label>
				</span>
				<span class="bbs_date">
					<select id="counselAmpm" name="counselAmpm" title="Ampm">
						<option value="AM" <c:if test="${'AM' eq CounselBean.counselAmpm}"> selected="selected" </c:if> >AM</option>
						<option value="PM" <c:if test="${'PM' eq CounselBean.counselAmpm}"> selected="selected" </c:if> >PM</option>
					</select>
					<label for="counselAmpm">AMPM</label>
				</span>
			</td>
		</tr>
		<tr>
			<th scope="row">
				<span class="exactly y">necessary</span>
				<label for=""><spring:message code="field.dic.counsel.noti" /></label>			
			</th>
			<td colspan="3">
				<textarea id="counselNtce" name="counselNtce" cols="30" rows="4" title="Contents" class="bbs_write_content" required ><c:out value="${CounselBean.counselNtce}" /></textarea>
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table write -->
</div>
<!-- //bbs_basic view -->
</c:if>

<h3><spring:message code="field.dic.answer.content" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table write">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row">
				<c:if test="${'CMD0000000001' eq CounselBean.counselMethodDivCd}">
					<span class="exactly y">necessary</span>
				</c:if>
				<label for=""><spring:message code="field.dic.answer.content" /></label>
			</th>
			<td colspan="3">
				<textarea id="ansContent" name="ansContent" cols="30" rows="10" title="Contents" class="bbs_write_content" <c:if test="${'CMD0000000001' eq CounselBean.counselMethodDivCd}">required</c:if> ><c:out value="${CounselBean.ansContent}" /></textarea>
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.attach.file" /></th>
			<td colspan="3">
				<input type="hidden" id="ansFileGrpSeq" name="ansFileGrpSeq" value="${CounselBean.ansFileGrpSeq}">
				<div id="dext5uploadArea"></div>
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table write -->

	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
		<c:choose>
			<c:when test="${CounselBean.counselMethodDivCd eq 'CMD0000000001'}"><c:set var="method" value="ONLINE" /></c:when>
			<c:when test="${CounselBean.counselMethodDivCd eq 'CMD0000000002'}"><c:set var="method" value="TEL" /></c:when>
			<c:when test="${CounselBean.counselMethodDivCd eq 'CMD0000000003'}"><c:set var="method" value="CENTER" /></c:when>
		</c:choose>
			<a href="${pageContext.request.contextPath}/internal/counsel/course.do?method=<c:out value="${method}" />" class="bbs_btn list">list</a>
		</span>
		<span class="bbs_right">
			<input type="button" id="btnDelete" value="Delete" class="bbs_btn delete" />
			<input type="button" id="btnSubmit" value="Save" class="bbs_btn save" />
		</span>
	</div>
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->
</form>


