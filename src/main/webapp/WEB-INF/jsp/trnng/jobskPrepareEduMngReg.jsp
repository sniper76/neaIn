<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/trnng/jobskPrepareEduMngReg.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("jobskPrepareEduMngReg");
	});
</script>
<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
/*아이콘(icon) 위치*/
button.ui-datepicker-trigger{position: relative; cursor: pointer; margin-left:-20px;}
</style>

<form id="frmJobskPrepareEduMngReg" >
<input type="hidden" id="eduDivCd" name="eduDivCd" value="<c:out value="${EduTrnngMngBean.eduDivCd}" />" />
<input type="hidden" id="neaEduDivCd" name="neaEduDivCd" value="<c:out value="${EduTrnngMngBean.neaEduDivCd}" />" />
<input type="hidden" id="teachOneCommonUploadResult" name="teachOneCommonUploadResult">
<input type="hidden" id="teachTwoCommonUploadResult" name="teachTwoCommonUploadResult">
<input type="hidden" id="lectureCommonUploadResult" name="lectureCommonUploadResult">

<h3><spring:message code="field.dic.edu.info" /></h3>
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
			<th scope="row"><span class="exactly y">necessary</span><label for="eduTrnngNm"><spring:message code="field.dic.jobedu.nm" /></label></th>
			<td colspan="3"><input type="text" id="eduTrnngNm" name="eduTrnngNm" value="<c:out value="${EduTrnngMngBean.eduTrnngNm}" />" style="width:100%;" required /></td>
		</tr>
		<tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="content"><spring:message code="title.sample.description" /></label></th>
			<td colspan="3"><textarea id="content" name="content" cols="30" rows="10" title="content" required ><c:out value="${EduTrnngMngBean.content}" /></textarea></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="curricl"><spring:message code="field.dic.curricl.explain" /></label></th>
			<td colspan="3"><textarea id="curricl" name="curricl" cols="30" rows="10" title="curricl" required ><c:out value="${EduTrnngMngBean.curricl}" /></textarea></td>
		</tr>
		<tr>
			<th scope="row"><label for="matr"><spring:message code="field.dic.matr" /></label></th>
			<td colspan="3"><textarea id="matr" name="matr" cols="30" rows="10" title="matr" ><c:out value="${EduTrnngMngBean.matr}" /></textarea></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="teachDt"><spring:message code="field.dic.edu.dt" /></label></th>
			<td colspan="3">
				<span class="period_box">
					<span class="date_box">
						<input type="text" id="teachDt" name="teachDt" value="<c:out value="${EduTrnngMngBean.teachDt}" />" class="datepicker" title="date Select from calendar" placeholder="date" required />
					</span>
				</span>
				<span class="bbs_date" style="padding-left:25px;">
					<select id="teachBgnHour" name="teachBgnHour" title="hour">
					<c:forEach var="hour" begin="1" end="12">
					<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setHour}"/>"  <c:if test="${setHour eq EduTrnngMngBean.teachBgnHour}"> selected="selected" </c:if> ><c:out value="${setHour}"/></option>
					</c:forEach>
					</select>
					<label for="teachBgnHour">HH</label>
				</span>
				<span class="bbs_date">
					<select id="teachBgnMinute" name="teachBgnMinute" title="minute">
					<c:forEach var="minute" begin="0" end="59">
					<c:choose>
						<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
						<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setMinute}"/>" <c:if test="${setMinute eq EduTrnngMngBean.teachBgnMinute}"> selected="selected" </c:if> ><c:out value="${setMinute}"/></option>						
					</c:forEach>
					</select>
					<label for="teachBgnMinute">MM</label>
				</span>
				<span class="bbs_date">
					<select id="teachBgnAmpm" name="teachBgnAmpm" title="Ampm">
						<option value="AM" <c:if test="${'AM' eq EduTrnngMngBean.teachBgnAmpm}"> selected="selected" </c:if> >AM</option>
						<option value="PM" <c:if test="${'PM' eq EduTrnngMngBean.teachBgnAmpm}"> selected="selected" </c:if> >PM</option>
					</select>
					<label for="teachBgnAmpm">AMPM</label>
				</span>
				~
				<span class="bbs_date" style="padding-left:25px;">
					<select id="teachEndHour" name="teachEndHour" title="hour">
					<c:forEach var="hour" begin="1" end="12">
					<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setHour}"/>"  <c:if test="${setHour eq EduTrnngMngBean.teachEndHour}"> selected="selected" </c:if> ><c:out value="${setHour}"/></option>
					</c:forEach>
					</select>
					<label for="teachEndHour">HH</label>
				</span>
				<span class="bbs_date">
					<select id="teachEndMinute" name="teachEndMinute" title="minute">
					<c:forEach var="minute" begin="0" end="59">
					<c:choose>
						<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
						<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setMinute}"/>" <c:if test="${setMinute eq EduTrnngMngBean.teachEndMinute}"> selected="selected" </c:if> ><c:out value="${setMinute}"/></option>						
					</c:forEach>
					</select>
					<label for="teachEndMinute">MM</label>
				</span>
				<span class="bbs_date">
					<select id="teachEndAmpm" name="teachEndAmpm" title="Ampm">
						<option value="AM" <c:if test="${'AM' eq EduTrnngMngBean.teachEndAmpm}"> selected="selected" </c:if> >AM</option>
						<option value="PM" <c:if test="${'PM' eq EduTrnngMngBean.teachEndAmpm}"> selected="selected" </c:if> >PM</option>
					</select>
					<label for="teachEndAmpm">AMPM</label>
				</span>								
			</td>
		</tr>		
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="area"><spring:message code="field.dic.trnng.place" /></label></th>
			<td colspan="3"><input type="text" id="area" name="area" value="<c:out value="${EduTrnngMngBean.area}" />" style="width:100%;" required /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="addrCd"><spring:message code="userChg.list.title.address" /></label></th>
			<td colspan="3">
               	<input type="hidden" name="addrCd" id="addrCd" value="<c:out value="${EduTrnngMngBean.addrCd}" />" />
               	<input type="hidden" name="addrFullCd" id="addrFullCd" value="<c:out value="${EduTrnngMngBean.addrFullCd}" />" />
               	<input type="hidden" name="addrFullNm" id="addrFullNm" value="<c:out value="${EduTrnngMngBean.addrFullNm}" />" />
               	<input type="button" class="bbs_btn type03" onclick="popAddrLayerBtn('addrCd','addrFullCd','addrFullNm','addrFullNmView');" value="<spring:message code="button.addr.nm" />" />
               	<span id="addrFullNmView"><c:out value="${EduTrnngMngBean.addrFullNm}" /></span>
				<br/>
				<input type="text" id="addrDtl" name="addrDtl" value="<c:out value="${EduTrnngMngBean.addrDtl}" />" style="width:100%;" required />
			</td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="googleMapLink"><spring:message code="field.dic.google.map.link" /></label></th>
			<td colspan="3"><input type="text" id="googleMapLink" name="googleMapLink" value="<c:out value="${EduTrnngMngBean.googleMapLink}" />" style="width:100%;" required /></td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->

<h3>담당자</h3>
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
			<th scope="row"><span class="exactly y">necessary</span><label for="eduTarget"><spring:message code="field.dic.target" /></label></th>
			<td><input type="text" id="eduTarget" name="eduTarget" value="<c:out value="${EduTrnngMngBean.eduTarget}" />"  required /></td>
			<th scope="row"><span class="exactly y">necessary</span><label for="recrumtMemb"><spring:message code="field.dic.recrumt.memb" /></label></th>
			<td><input type="text" id="recrumtMemb" name="recrumtMemb" value="<c:out value="${EduTrnngMngBean.recrumtMemb}" />" onKeyUp="onlyNumberCommon(this);" required /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="teacherNm1"><spring:message code="field.dic.teacher.one" /></label></th>
			<td><input type="text" id="teacherNm1" name="teacherNm1" value="<c:out value="${EduTrnngMngBean.teacherNm1}" />" /></td>
			<th scope="row"><label for="teacherNm2"><spring:message code="field.dic.teacher.two" /></label></th>
			<td><input type="text" id="teacherNm2" name="teacherNm2" value="<c:out value="${EduTrnngMngBean.teacherNm2}" />" /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="teacher1PhotoFileGrpSeq"><spring:message code="field.dic.teacherphoto.one" /></label></th>
			<td style="vertical-align:middle;">
				<input type="hidden" id="teacher1PhotoFileGrpSeq" name="teacher1PhotoFileGrpSeq" value="">
				<div id="teachOneDext5uploadArea"></div>
			</td>
			<th scope="row"><label for="teacher2PhotoFileGrpSeq"><spring:message code="field.dic.teacherphoto.two" /></label></th>
			<td style="vertical-align:middle;">
				<input type="hidden" id="teacher2PhotoFileGrpSeq" name="teacher2PhotoFileGrpSeq" value="">
				<div id="teachTwoDext5uploadArea"></div>
			</td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="teacher1Career"><spring:message code="field.dic.teachercareer.one" /></label></th>
			<td colspan="3"><textarea id="teacher1Career" name="teacher1Career" cols="30" rows="10" title="teacher1Career" required ><c:out value="${EduTrnngMngBean.teacher1Career}" /></textarea></td>
		</tr>
		<tr>
			<th scope="row"><label for="teacher2Career"><spring:message code="field.dic.teachercareer.two" /></label></th>
			<td colspan="3"><textarea id="teacher2Career" name="teacher2Career" cols="30" rows="10" title="teacher2Career" ><c:out value="${EduTrnngMngBean.teacher2Career}" /></textarea></td>
		</tr>
		<tr>
			<th scope="row"><label for="lecturePhotoFileGrpSeq"><spring:message code="field.dic.lecture.photo" /></label></th>
			<td colspan="3">
					<!--img src="/images/board/dummy_photo.png" alt=" image" /-->
				<input type="hidden" id="lecturePhotoFileGrpSeq" name="lecturePhotoFileGrpSeq" value="">
				<div id="lectureDext5uploadArea"></div>
			</td>
		</tr>						
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->

<div class="bbs_basic margin_b_20">
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<a href="${pageContext.request.contextPath}/internal/trnng/jobskPrepareEduMng.do" class="bbs_btn list">list</a>
		</span>
		<span class="bbs_right">
			<input type="submit" id="btnSubmit" value="Save" class="bbs_btn modify" />
		</span>
	</div>
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->
</form>