<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/resume/resumeUpdate.js"></script>

<script>
$(function() {
	common.invoker.invoke("resumeUpdate");
});
</script>

<form id="frmUserInsttDeatilInfoBase">

	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20">
			<caption>이력서 제목</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:85%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> Title</th>
				<td>
					<input type="text" id="profile_title" name="resumeTitle" maxlength="500" style="width: 100%;" value="${resumeDetail.resumeTitle }"/>
					<input type="hidden" id="userSeq" name="userSeq" value="${resumeDetail.userSeq }"/>
					<input type="hidden" id="resumeSeq" name="resumeSeq" value="${resumeDetail.resumeSeq }"/>
				</td>
			</tr>
			</tbody>
		</table>
	</div>

	<h3><spring:message code="field.dic.hr.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20">
			<caption>인적사항 - 출생지, 결혼여부, 가족정보 등의 정보</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.birth.addr" /></th>
				<td colspan="3">
					<input type="hidden" name="addrCd" id="addrCd" value="${resumeDetail.addrCd }" required/>
					<input type="hidden" name="addrFullCd" id="addrFullCd" value="${resumeDetail.addrFullCd }" required/>
					<button type="button" value="popup" class="bbs_btn type03" onclick="popAddrLayerBtn('addrCd', 'addrFullCd', 'addrFullNm', 'addrFullNmView');"><spring:message code="field.dic.area" /></button>
					<br>
					<label for="addrDtl"><spring:message code="field.dic.addr.base" /></label>&nbsp;&nbsp;<input type="text" name="addrFullNm" id="addrFullNm" value="${resumeDetail.addrFullNm }" style="width:50%;" disabled="disabled" /><br>
					<label for="addrDtl"><spring:message code="field.dic.dtladdr" /></label>&nbsp;&nbsp;<input type="text" name="addrDtl" id="addrDtl" style="width:50%;" value="${resumeDetail.addrDtl }" />
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.marricd" /></th>
				<td colspan="3">
					<commCode:commcode codeKind="commCode" tagName="marriCd" grpCd="MARITA_STATUS_ID" drawType="radio" initValue="${resumeDetail.marriCd }" exceptValue="" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.family.info" /> (<spring:message code="field.dic.family.cnt" />)</th>
				<td colspan="3">
					<input type="text" id="familyCnt" name="familyCnt" class="inputNo" value="${resumeDetail.familyCnt }">
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.family.under15" /></th>
				<td><input type="text" id="underAge15FamilyCnt" name="underAge15FamilyCnt" class="inputNo" value="${resumeDetail.underAge15FamilyCnt }"></td>
				<th scope="row"><spring:message code="field.dic.family.over65" /></th>
				<td><input type="text" id="overAge64FamilyCnt" name="overAge64FamilyCnt" class="inputNo" value="${resumeDetail.overAge64FamilyCnt }"></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.first.jobseek" /></th>
				<td>
					<select id="frstimeJobSeekerYn" name="frstimeJobSeekerYn">
						<option <c:if test="${resumeDetail.frstimeJobSeekerYn eq 'Y' }">selected="selected"</c:if>>Y</option>
						<option <c:if test="${resumeDetail.frstimeJobSeekerYn eq 'N' }">selected="selected"</c:if>>N</option>
					</select>
				</td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.studying.yn" /></th>
				<td>
					<select id="studyingYn" name="studyingYn">
						<option <c:if test="${resumeDetail.studyingYn eq 'Y' }">selected="selected"</c:if>>Y</option>
						<option <c:if test="${resumeDetail.studyingYn eq 'N' }">selected="selected"</c:if>>N</option>
					</select>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.ret.migrat" /></th>
				<td>
					<select id="retMigratYn" name="retMigratYn">
						<option <c:if test="${resumeDetail.retMigratYn eq 'Y' }">selected="selected"</c:if>>Y</option>
						<option <c:if test="${resumeDetail.retMigratYn eq 'N' }">selected="selected"</c:if>>N</option>
					</select>
				</td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.srvc.yn" /></th>
				<td>
					<select id="srvcYn" name="srvcYn">
						<option <c:if test="${resumeDetail.srvcYn eq 'Y' }">selected="selected"</c:if>>Y</option>
						<option <c:if test="${resumeDetail.srvcYn eq 'N' }">selected="selected"</c:if>>N</option>
					</select>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.ethnic.minor" /></th>
				<td colspan="3">
					<select id="ethnicMinorYn" name="ethnicMinorYn">
						<option <c:if test="${resumeDetail.ethnicMinorYn eq 'Y' }">selected="selected"</c:if>>Y</option>
						<option <c:if test="${resumeDetail.ethnicMinorYn eq 'N' }">selected="selected"</c:if>>N</option>
					</select>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.disable.yn" /></th>
				<td colspan="3">
					<select id="disablYn" name="disablYn">
						<option <c:if test="${resumeDetail.disablYn eq 'Y' }">selected="selected"</c:if>>Y</option>
						<option <c:if test="${resumeDetail.disablYn eq 'N' }">selected="selected"</c:if>>N</option>
					</select>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.disable.option" /></th>
				<td colspan="3" id="disablOptionCd">
					<commCode:commcode codeKind="commCode" tagName="disablOptionCd" grpCd="DISABL_OPTION_CD" drawType="check" initValue="${disableList }" exceptValue="" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.self.employee" /></th>
				<td colspan="3">
					<select id="selfempYn" name="selfempYn">
						<option <c:if test="${resumeDetail.selfempYn eq 'Y' }">selected="selected"</c:if>>Y</option>
						<option <c:if test="${resumeDetail.selfempYn eq 'N' }">selected="selected"</c:if>>N</option>
					</select>
				</td>
			</tr>
			</tbody>
		</table>
	</div>

	<h3><spring:message code="field.dic.prefer.job.condition" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20">
			<caption>희망근무조건 - 희망 직업/직책, 희망직종, 희망 근무 지역, 희망고용형태, 희망고용형태, 희망 고용 Type, 희망근무 시간, 희망근무일수, 희망근무요일, 희망 계약형태, 근무가능여부, 희망 급여, 파견 근무 가능여부, 근무 시작 가능일</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.job" />/<spring:message code="field.dic.job.resp" /></th>
				<td colspan="3">
					<input type="text" id="preferJobTitle" name="preferJobTitle" value="${resumeDetail.preferJobTitle }"> /
					<input type="text" id="preferPosition" name="preferPosition" value="${resumeDetail.preferPosition }">
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.isco" /></th>
				<td colspan="3">
					<div class="form_element keyword active">
						<button type="button" class="bbs_btn type04 vertical_middle popup_isco" onclick="callback(fnSetIsco, 'isco');"><spring:message code="field.dic.isco.select" /></button>
						<div class="view_area">
							<span class="text_box" id="span_isco">
								<c:forEach items="${iscoList }" var="iscoCd" >
									<span>
										<c:out value="${iscoCd.iscoNm }" />
										<input type="hidden" class='iscoCd' name='iscoCd' value="${iscoCd.iscoCd }">
										<button type="button" class="delete">delete</button>
									</span>
								</c:forEach>
							</span>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.work.place" /></th>
				<td colspan="3">
					<div class="form_element keyword active">
						<button type="button" value="popup" class="bbs_btn type03" onclick="popAddrLayerBtnMulti(fnSetHopeLoc, 'true');"><spring:message code="field.dic.area" /></button>
						<div class="view_area">
							<span class="text_box" id="span_hopeLoc">
								<c:forEach items="${hopeWorkLocList }" var="hopeWorkLoc">
									<span>
										<c:out value="${hopeWorkLoc.addrCdNm }" />
										<input type="hidden" name="hopeLocCd" value="${hopeWorkLoc.addrCd }"/>
										<input type="hidden" name="hopeLocFullNm" value="${hopeWorkLoc.addrFullNm }"/>
										<input type="hidden" name="hopeLocFullCd" value="${hopeWorkLoc.addrFullCd }"/>
										<button type="button">delete</button></span>
									</span>
								</c:forEach>
							</span>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.form" /></th>
				<td colspan="3">
					<commCode:commcode codeKind="commCode" tagName="employFormCd" grpCd="EMPLOY_FORM_CD" drawType="select" initValue="${resumeDetail.employFormCd }" exceptValue="" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.type" /></th>
				<td colspan="3">
					<commCode:commcode codeKind="commCode" tagName="preferEmployTypeCd" grpCd="PREFER_EMPLOYMT_TYPE_CD" drawType="radio" initValue="${resumeDetail.preferEmployTypeCd }" exceptValue="" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.hour" /></th>
				<td>
					<input type="text" id="typeEmployHourDay" name="typeEmployHourDay" class="inputNo" value="${resumeDetail.typeEmployHourDay }">
				</td>
				<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.day" /></th>
				<td>
					<input type="text" id="typeEmployDayWeek" name="typeEmployDayWeek" class="inputNo" value="${resumeDetail.typeEmployDayWeek }">
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.week.day" /></th>
				<td colspan="3">
					<input type="checkbox" id="preferDayMon" name="preferDayMon" value="Y" <c:if test="${resumeDetail.preferDayMon eq 'Y' }">checked="checked"</c:if>>
					<label for="preferDayMon">Monday</label>
					<input type="checkbox" id="preferDayTue" name="preferDayTue" value="Y" <c:if test="${resumeDetail.preferDayTue eq 'Y' }">checked="checked"</c:if>>
					<label for="preferDayTue">Tuesday</label>
					<input type="checkbox" id="preferDayWed" name="preferDayWed" value="Y" <c:if test="${resumeDetail.preferDayWed eq 'Y' }">checked="checked"</c:if>>
					<label for="preferDayWed">Wednesday</label>
					<input type="checkbox" id="preferDayThu" name="preferDayThu" value="Y" <c:if test="${resumeDetail.preferDayThu eq 'Y' }">checked="checked"</c:if>>
					<label for="preferDayThu">Thursday</label>
					<input type="checkbox" id="preferDayFri" name="preferDayFri" value="Y" <c:if test="${resumeDetail.preferDayFri eq 'Y' }">checked="checked"</c:if>>
					<label for="preferDayFri">Friday</label>
					<input type="checkbox" id="preferDaySat" name="preferDaySat" value="Y" <c:if test="${resumeDetail.preferDaySat eq 'Y' }">checked="checked"</c:if>>
					<label for="preferDaySat">Saturday</label>
					<input type="checkbox" id="preferDaySun" name="preferDaySun" value="Y" <c:if test="${resumeDetail.preferDaySun eq 'Y' }">checked="checked"</c:if>>
					<label for="preferDaySun">Sunday</label>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.ctct.type" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="preferCrtctType" grpCd="EMPLOY_CTRCT_CD" drawType="radio" initValue="${resumeDetail.preferCrtctType}" exceptValue="" disable=""/>
				</td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.overyn" /></th>
				<td>
					<input type="checkbox" id="nightWorkYn" name="nightWorkYn" value="Y" <c:if test="${resumeDetail.nightWorkYn eq 'Y' }">checked="checked"</c:if>/><label for="nightWorkYn">Night shift(pm 10:00~am 05:00)</label>
					<input type="checkbox" id="overTimeWorkYn" name="overTimeWorkYn" value="Y" <c:if test="${resumeDetail.overTimeWorkYn eq 'Y' }">checked="checked"</c:if>/><label for="overTimeWorkYn">Overtime</label>
					<input type="checkbox" id="hldayWorkYn" name="hldayWorkYn" value="Y" <c:if test="${resumeDetail.hldayWorkYn eq 'Y' }">checked="checked"</c:if>/><label for="hldayWorkYn">Work on Sunday/Public Holidays</label>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.salary" /></th>
				<td>
					<input type="text" id="expctMinSalaryAmt" name="expctMinSalaryAmt" class="inputNo" value="${resumeDetail.expctMinSalaryAmt }">
				 ~
					<input type="text" id="expctMaxSalaryAmt" name="expctMaxSalaryAmt" class="inputNo" value="${resumeDetail.expctMaxSalaryAmt }">
				</td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.otrplaceyn" /></th>
				<td>
					<input type="radio" id="diffProvcWorkYn_1" name="diffProvcWorkYn" value="Y" <c:if test="${resumeDetail.diffProvcWorkYn eq 'Y' }">checked="checked"</c:if>/><label for="diffProvcWorkYn_1">Yes</label>
					<input type="radio" id="diffProvcWorkYn_2" name="diffProvcWorkYn" value="N" <c:if test="${resumeDetail.diffProvcWorkYn eq 'N' }">checked="checked"</c:if>/><label for="diffProvcWorkYn_2">No</label>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.bgndt" /></th>
				<td colspan="3">
					<input type="radio" name="workBgnAbleYn" id="workBgnAbleYn_1" value="Y" <c:if test="${resumeDetail.workBgnAbleYn eq 'Y' }">checked="checked"</c:if>/><label for="workBgnAbleYn_1"><spring:message code="resume.text.workBgnAbleY"/></label>
					<input type="radio" name="workBgnAbleYn" id="workBgnAbleYn_2" value="N" <c:if test="${resumeDetail.workBgnAbleYn eq 'N' }">checked="checked"</c:if>/><label for="workBgnAbleYn_2"><spring:message code="resume.text.workBgnAbleN"/></label>
					<input type="text" id="workBgnAbleWithin" name="workBgnAbleWithin" value="${resumeDetail.workBgnAbleWithin }">
				</td>
			</tr>
			</tbody>
		</table>
	</div>

	<h3><spring:message code="field.dic.edu.especial.training" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20">
			<caption>학력 및 전문 교육 - 일반교육, 기술직업 교육 및 훈련</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.edu.gnrl" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="eduDegreeCd" grpCd="EDU_DEGREE_CD" drawType="select" initValue="${genrlEdu.eduDegreeCd }" exceptValue="" disable=""/>
				</td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.edu.skill" /></th>
				<td>
					<commCode:commcode codeKind="commCode" tagName="eduDegreeCd2" grpCd="EDU_DEGREE_CD" drawType="select" initValue="" exceptValue="" disable=""/>
				</td>
			</tr>
			</tbody>
		</table>
	</div>

	<div>
		<h3><spring:message code="field.dic.rsch.especial.training" /> <button type="button" id="btnUsrReg" class="bbs_btn type03 btn_addForm">+</button></h3>
		<div class="bbs_basic">
			<table class="bbs_table write margin_b_20">
				<caption>연구 및 전문 교육 - 연구/전문 분야명, 연구기간, 교육기관명, 국가, 시/도 제공</caption>
				<colgroup>
					<col style="width:15%;" />
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:5%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.rsch.especial.fieldnm" /></th>
						<th scope="col"> <spring:message code="field.dic.rsch.term" /></th>
						<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.insttnm" /></th>
						<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.nation" /></th>
						<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.city.state" /></th>
						<th scope="col">삭제</th>
					</tr>
				</thead>
				<tbody class="text_center" id="ss_form">
					<c:if test="${empty specialStudyList }">
						<tr class="tr_original">
							<th scope="row"><input type="text" name="ss_specialStudyNm"></th>
							<td>
								<select name="ss_bgnDt_mm" title="M">
									<c:forEach var="month" begin="1" end="12">
										<c:choose>
											<c:when test="${month < 10}"><c:set var="bgnMonth" value="0${month}" /></c:when>
											<c:otherwise><c:set var="bgnMonth" value="${month}" /></c:otherwise>
										</c:choose>
										<option value="<c:out value="${bgnMonth}"/>"><c:out value="${bgnMonth}"/></option>
									</c:forEach>
								</select>
								Month
								<select name="ss_bgnDt_yy" title="Y">
									<c:set var="now" value="<%=new java.util.Date()%>" />
									<c:set var="bgnYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
									<c:forEach var="year" begin="1900" end="${bgnYear}">
										<option value="<c:out value="${year}"/>"><c:out value="${year}"/></option>
									</c:forEach>
								</select>
								Year
								~<br>
								<select name="ss_endDt_mm" title="M">
									<c:forEach var="month" begin="1" end="12">
										<c:choose>
											<c:when test="${month < 10}"><c:set var="endMonth" value="0${month}" /></c:when>
											<c:otherwise><c:set var="endMonth" value="${month}" /></c:otherwise>
										</c:choose>
										<option value="<c:out value="${endMonth}"/>"><c:out value="${endMonth}"/></option>
									</c:forEach>
								</select>
								Month
								<select name="ss_endDt_yy" title="Y">
									<c:set var="endYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
									<c:forEach var="year" begin="1900" end="${endYear}">
										<option value="<c:out value="${year}"/>"><c:out value="${year}"/></option>
									</c:forEach>
								</select>
								Year
							</td>
							<td><input type="text" name="ss_insttNm"></td>
							<td>
								<select name="ss_cntryCd" class="cntryCd">
									<c:forEach items="${nationalityList }" var="nationality">
										<option value="${nationality.lvlCd }"><c:out value="${nationality.nmEn }" /></option>
									</c:forEach>
								</select>
							</td>
							<td>
								<select name="ss_provcCd" class="provcCd">
								</select>
							</td>
							<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
						</tr>
					</c:if>
					<c:if test="${not empty specialStudyList }">
						<c:forEach items="${specialStudyList}" var="specialStudy" varStatus="stat">
							<tr class="tr_original">
								<th scope="row"><input type="text" name="ss_specialStudyNm" value="${specialStudy.specialStudyNm }"></th>
								<td>
									<select name="ss_bgnDt_mm" title="M">
										<c:forEach var="month" begin="1" end="12">
											<c:choose>
												<c:when test="${month < 10}"><c:set var="bgnMonth" value="0${month}" /></c:when>
												<c:otherwise><c:set var="bgnMonth" value="${month}" /></c:otherwise>
											</c:choose>
											<option value="<c:out value="${bgnMonth}"/>" <c:if test="${specialStudy.bgnDtMm eq bgnMonth }">selected="selected"</c:if>>
												<c:out value="${bgnMonth}"/>
											</option>
										</c:forEach>
									</select>
									Month
									<select name="ss_bgnDt_yy" title="Y">
										<c:set var="now" value="<%=new java.util.Date()%>" />
										<c:set var="bgnYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
										<c:forEach var="year" begin="1900" end="${bgnYear}">
											<option value="<c:out value="${year}"/>" <c:if test="${specialStudy.bgnDtYy eq year }">selected="selected"</c:if>>
												<c:out value="${year}"/>
											</option>
										</c:forEach>
									</select>
									Year
									~<br>
									<select name="ss_endDt_mm" title="M">
										<c:forEach var="month" begin="1" end="12">
											<c:choose>
												<c:when test="${month < 10}"><c:set var="endMonth" value="0${month}" /></c:when>
												<c:otherwise><c:set var="endMonth" value="${month}" /></c:otherwise>
											</c:choose>
											<option value="<c:out value="${endMonth}"/>" <c:if test="${specialStudy.endDtMm eq endMonth }">selected="selected"</c:if>>
												<c:out value="${endMonth}"/>
											</option>
										</c:forEach>
									</select>
									Month
									<select name="ss_endDt_yy" title="Y">
										<c:set var="endYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
										<c:forEach var="year" begin="1900" end="${endYear}">
											<option value="<c:out value="${year}"/>" <c:if test="${specialStudy.endDtYy eq year }">selected="selected"</c:if>>
												<c:out value="${year}"/>
											</option>
										</c:forEach>
									</select>
									Year
								</td>
								<td><input type="text" name="ss_insttNm" value="${specialStudy.insttNm }"></td>
								<td>
									<select name="ss_cntryCd" class="cntryCd">
										<c:forEach items="${nationalityList }" var="nationality">
											<option value="${nationality.lvlCd }" <c:if test="${specialStudy.cntryCd eq nationality.lvlCd }">selected="selected"</c:if>>
												<c:out value="${nationality.nmEn }" />
											</option>
										</c:forEach>
									</select>
								</td>
								<td>
									<select name="ss_provcCd" class="provcCd">
										<c:forEach items="${specialStudy.provcCdList }" var="provcCdList">
											<option value="${provcCdList.lvlCd }" <c:if test="${specialStudy.provcCd eq provcCdList.lvlCd }">selected="selected"</c:if>>
												<c:out value="${provcCdList.nmEn }" />
											</option>
										</c:forEach>
									</select>
								</td>
								<c:choose>
									<c:when test="${stat.count eq '1' }">
										<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
									</c:when>
									<c:otherwise>
										<td><button type="button" class="bbs_btn type03 tr_delete" >x</button></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>

	<div>
		<h3><spring:message code="field.dic.license.owner.yn" /> <button type="button" id="btnUsrReg" class="bbs_btn type03 btn_addForm">+</button></h3>
		<div class="bbs_basic">
			<table class="bbs_table write margin_b_20">
				<caption><spring:message code="field.dic.license.owner.yn" /></caption>
				<colgroup>
					<col style="width:15%;" />
					<col style="width:80%;" />
					<col style="width:5%;" />
				</colgroup>
				<tbody id="proLicnsSpec_form">
					<c:if test="${empty resumeDetail.proLicnsSpecList }">
						<tr class="tr_original">
							<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.licns.certification" /></th>
							<td><input type="text" name="proLicnsSpec"></td>
							<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
						</tr>
					</c:if>
					<c:if test="${not empty resumeDetail.proLicnsSpecList }">
						<c:forEach items="${resumeDetail.proLicnsSpecList}" var="proLicnsSpec" varStatus="stat">
							<c:choose>
								<c:when test="${stat.count eq 1 }">
									<tr class="tr_original">
										<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.licns.certification" /></th>
										<td><input type="text" name="proLicnsSpec" value="${proLicnsSpec }" ></td>
										<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr class="tr_original">
										<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.licns.certification" /></th>
										<td><input type="text" name="proLicnsSpec" value="${proLicnsSpec }"></td>
										<td><button type="button" class="bbs_btn type03 tr_delete">x</button></td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>

	<div>
		<h3><spring:message code="field.dic.etc.training" /> <button type="button" id="btnUsrReg" class="bbs_btn type03 btn_addForm">+</button></h3>
		<div class="bbs_basic">
			<table class="bbs_table write margin_b_20">
				<caption>기타 교육 - 레벨/수료/학위졸업/학위, 전공/전문/분야, 기관명, 지역, 연구기간 제공 </caption>
				<colgroup>
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:15%;" />
					<col style="width:20%;" />
					<col style="width:5%;" />
				</colgroup>
				<thead>
				<tr>
					<th scope="col"><span class="exactly y">necessary</span>
					<spring:message code="field.dic.etctrng.lvl" />/
					<spring:message code="field.dic.etctrng.cmplt" />/
					<spring:message code="field.dic.etctrng.gradt" />/
					<spring:message code="field.dic.etctrng.degree" /></th>
					<th scope="col"><span class="exactly y">necessary</span>
					<spring:message code="field.dic.etctrng.major" />/
					<spring:message code="field.dic.etctrng.profsn" />/
					<spring:message code="field.dic.etctrng.field" /></th>
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.instttype" /></th>
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.area" /></th>
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.rsch.term" /></th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody class="text_center" id="ot_form">
				<c:if test="${empty otherTrnngList }">
					<tr class="tr_original">
						<th scope="row"><input type="text" name="ot_trnngEduDegreeCd"></th>
						<td><input type="text" name="ot_iscedCd"></td>
						<td><input type="text" name="ot_insttNm"></td>
						<td>
							<select name="ot_addrProvcCd">
								<c:forEach items="${locCdList }" var="locCd">
									<option value="${locCd.lvlCd }"><c:out value="${locCd.nmEn }" /></option>
								</c:forEach>
							</select>
						</td>
						<td>
							<select name="ot_bgnDt_mm" title="M">
								<c:forEach var="month" begin="1" end="12">
									<c:choose>
										<c:when test="${month < 10}"><c:set var="ot_bgnMonth" value="0${month}" /></c:when>
										<c:otherwise><c:set var="ot_bgnMonth" value="${month}" /></c:otherwise>
									</c:choose>
									<option value="<c:out value="${ot_bgnMonth}"/>"><c:out value="${ot_bgnMonth}"/></option>
								</c:forEach>
							</select>
							Month
							<select name="ot_bgnDt_yy" title="Y">
								<c:set var="ot_bgnYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
								<c:forEach var="year" begin="1900" end="${ot_bgnYear}">
									<option value="<c:out value="${year}"/>"><c:out value="${year}"/></option>
								</c:forEach>
							</select>
							Year
							~<br>
							<select name="ot_endDt_mm" title="M">
								<c:forEach var="month" begin="1" end="12">
									<c:choose>
										<c:when test="${month < 10}"><c:set var="ot_endMonth" value="0${month}" /></c:when>
										<c:otherwise><c:set var="ot_endMonth" value="${month}" /></c:otherwise>
									</c:choose>
									<option value="<c:out value="${ot_endMonth}"/>"><c:out value="${ot_endMonth}"/></option>
								</c:forEach>
							</select>
							Month
							<select name="ot_endDt_yy" title="Y">
								<c:set var="ot_endYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
								<c:forEach var="year" begin="1900" end="${ot_endYear}">
									<option value="<c:out value="${year}"/>"><c:out value="${year}"/></option>
								</c:forEach>
							</select>
							Year
						</td>
						<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
					</tr>
					<c:if test="${not empty otherTrnngList }">
						<c:forEach items="${otherTrnngList }" var="otherTrnng" varStatus="stat">
							<tr class="tr_original">
								<th scope="row"><input type="text" name="ot_trnngEduDegreeCd" value="${otherTrnng.trnngEduDegreeCd }"></th>
								<td><input type="text" name="ot_iscedCd" value="${otherTrnng.iscedCd }"></td>
								<td><input type="text" name="ot_insttNm" value="${otherTrnng.insttNm }"></td>
								<td>
									<select name="ot_addrProvcCd">
										<c:forEach items="${locCdList }" var="locCd">
											<option value="${locCd.lvlCd }" <c:if test="${otherTrnng.addrProvcCd eq locCd.lvlCd }">selected="selected"</c:if>>
												<c:out value="${locCd.nmEn }" />
											</option>
										</c:forEach>
									</select>
								</td>
								<td>
									<select name="ot_bgnDt_mm" title="M">
										<c:forEach var="month" begin="1" end="12">
											<c:choose>
												<c:when test="${month < 10}"><c:set var="ot_bgnMonth" value="0${month}" /></c:when>
												<c:otherwise><c:set var="ot_bgnMonth" value="${month}" /></c:otherwise>
											</c:choose>
											<option value="<c:out value="${ot_bgnMonth}"/>" <c:if test="${otherTrnng.bgnDtMm eq ot_bgnMonth }">selected="selected"</c:if>>
												<c:out value="${ot_bgnMonth}"/>
											</option>
										</c:forEach>
									</select>
									Month
									<select name="ot_bgnDt_yy" title="Y">
										<c:set var="ot_bgnYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
										<c:forEach var="year" begin="1900" end="${ot_bgnYear}">
											<option value="<c:out value="${year}"/>" <c:if test="${otherTrnng.bgnDtYy eq year }">selected="selected"</c:if>>
												<c:out value="${year}"/>
											</option>
										</c:forEach>
									</select>
									Year
									~<br>
									<select name="ot_endDt_mm" title="M">
										<c:forEach var="month" begin="1" end="12">
											<c:choose>
												<c:when test="${month < 10}"><c:set var="ot_endMonth" value="0${month}" /></c:when>
												<c:otherwise><c:set var="ot_endMonth" value="${month}" /></c:otherwise>
											</c:choose>
											<option value="<c:out value="${ot_endMonth}"/>" <c:if test="${otherTrnng.endDtMm eq ot_endMonth }">selected="selected"</c:if>>
												<c:out value="${ot_endMonth}"/>
											</option>
										</c:forEach>
									</select>
									Month
									<select name="ot_endDt_yy" title="Y">
										<c:set var="ot_endYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
										<c:forEach var="year" begin="1900" end="${ot_endYear}">
											<option value="<c:out value="${year}"/>" <c:if test="${otherTrnng.endDtYy eq year }">selected="selected"</c:if>>
												<c:out value="${year}"/>
											</option>
										</c:forEach>
									</select>
									Year
								</td>
								<c:choose>
									<c:when test="${stat.count eq '1' }">
										<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
									</c:when>
									<c:otherwise>
										<td><button type="button" class="bbs_btn type03 tr_delete">x</button></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</c:if>
				</c:if>
			</tbody>
			</table>
		</div>
	</div>

	<div>
		<h3><spring:message code="field.dic.language.info" /> <button type="button" id="btnUsrReg" class="bbs_btn type03 btn_addForm">+</button></h3>
		<div class="bbs_basic">
			<table class="bbs_table write margin_b_20">
				<caption>어학 - 모국어, 외국어 명</caption>
				<colgroup>
					<col style="width:15%;" />
					<col style="width:35%;" />
					<col style="width:15%;" />
					<col style="width:30%;" />
					<col style="width:5%;" />
				</colgroup>
				<tbody>
					<c:if test="${empty langResult }">
						<tr>
							<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.lang.native" /></th>
							<td colspan="4"><commCode:commcode codeKind="commCode" tagName="rl_langCd_native" grpCd="LANG_CD" drawType="select" initValue="" exceptValue="" disable=""/></td>
						</tr>
						<tr class="tr_original rl_form">
							<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.foreignlang.name" /></th>
							<td>
								<commCode:commcode codeKind="commCode" tagName="rl_langCd" grpCd="LANG_CD" drawType="select" initValue="" exceptValue="" disable=""/>
							</td>
							<th scope="row"><spring:message code="field.dic.foreign.lvl" /></th>
							<td><commCode:commcode codeKind="commCode" tagName="rl_langLvlCd" grpCd="LANG_LVL_CD" drawType="select" initValue="" exceptValue="" disable=""/></td>
							<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
						</tr>
					</c:if>
					<c:if test="${not empty langResult }">
						<c:forEach items="${langResult }" var="lang" varStatus="stat">
							<c:choose>
								<c:when test="${lang.langTypeCd eq 'LTC0000000001'}">
									<tr>
										<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.lang.native" /></th>
										<td colspan="4"><commCode:commcode codeKind="commCode" tagName="rl_langCd_native" grpCd="LANG_CD" drawType="select" initValue="${lang.langCd }" exceptValue="" disable=""/></td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr class="tr_original rl_form">
										<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.foreignlang.name" /></th>
										<td>
											<commCode:commcode codeKind="commCode" tagName="rl_langCd" grpCd="LANG_CD" drawType="select" initValue="${lang.langCd }" exceptValue="" disable=""/>
										</td>
										<th scope="row"><spring:message code="field.dic.foreign.lvl" /></th>
										<td><commCode:commcode codeKind="commCode" tagName="rl_langLvlCd" grpCd="LANG_LVL_CD" drawType="select" initValue="${lang.langLvlCd }" exceptValue="" disable=""/></td>
										<c:choose>
											<c:when test="${stat.count eq '2' }">
												<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
											</c:when>
											<c:otherwise>
												<td><button type="button" class="bbs_btn type03 tr_delete">x</button></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>

	<div>
		<h3><spring:message code="field.dic.career.info" /> <span class="em_blue small">
		<spring:message code="field.dic.total" />
		<span class="totYear">0</span><spring:message code="field.dic.year" />
		<span class="totMonths">0</span><spring:message code="field.dic.month.cnt" />
		<button type="button" id="btnUsrReg" class="bbs_btn type03 btn_addForm">+</button>
		</span></h3>
		<div class="bbs_basic">
			<table class="bbs_table write margin_b_20">
				<caption>경력 - 회사명, 부문, 직급/직책, 자영업/무급 종사자여부, 퇴직사유, 재직기간 제공</caption>
				<colgroup>
					<col style="width:18%;" />
					<col style="width:16%;" />
					<col style="width:8%;" />
					<col style="width:16%;" />
					<col style="width:19%;" />
					<col style="width:15%;" />
					<col style="width:5%;" />
				</colgroup>
				<thead>
				<tr>
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.company.name" /></th>
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.isco" /></th>
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.job.position" />/<spring:message code="field.dic.job.resp" /></th>
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.self.employee" /></th>
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.retire.reason" /></th>
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.term" /></th>
					<th scope="col">삭제</th>
				</tr>
				</thead>
				<tbody class="text_center">
					<c:if test="${empty workExpList }">
						<tr class="tr_original exp_form">
							<th scope="row"><input type="text" name="exp_orgnzNm"></th>
							<td><input type="text" name="exp_iscoCd"></td>
							<td><input type="text" name=""></td>
							<td>
								<select name="exp_selfempYn">
									<option value="Y">Yes</option>
									<option value="N">No</option>
								</select>
							</td>
							<td><input type="text" name="exp_leaveReason"></td>
							<td>
								<select name="exp_bgnDt_mm" title="M" class="calCareer">
									<c:forEach var="month" begin="1" end="12">
										<c:choose>
											<c:when test="${month < 10}"><c:set var="exp_bgnMonth" value="0${month}" /></c:when>
											<c:otherwise><c:set var="exp_bgnMonth" value="${month}" /></c:otherwise>
										</c:choose>
										<option value="<c:out value="${exp_bgnMonth}"/>"><c:out value="${exp_bgnMonth}"/></option>
									</c:forEach>
								</select>
								Month
								<select name="exp_bgnDt_yy" title="Y" class="calCareer">
									<c:set var="exp_bgnYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
									<c:forEach var="year" begin="1900" end="${exp_bgnYear}">
										<option value="<c:out value="${year}"/>"><c:out value="${year}"/></option>
									</c:forEach>
								</select>
								Year
								~<br>
								<select name="exp_endDt_mm" title="M" class="calCareer">
									<c:forEach var="month" begin="1" end="12">
										<c:choose>
											<c:when test="${month < 10}"><c:set var="exp_endMonth" value="0${month}" /></c:when>
											<c:otherwise><c:set var="exp_endMonth" value="${month}" /></c:otherwise>
										</c:choose>
										<option value="<c:out value="${exp_endMonth}"/>"><c:out value="${exp_endMonth}"/></option>
									</c:forEach>
								</select>
								Month
								<select name="exp_endDt_yy" title="Y" class="calCareer">
									<c:set var="exp_endYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
									<c:forEach var="year" begin="1900" end="${exp_endYear}">
										<option value="<c:out value="${year}"/>"><c:out value="${year}"/></option>
									</c:forEach>
								</select>
								Year
							</td>
							<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
						</tr>
					</c:if>
					<c:if test="${not empty workExpList }">
						<c:forEach items="${workExpList }" var="workExp" varStatus="stat">
							<tr class="tr_original exp_form">
								<th scope="row"><input type="text" name="exp_orgnzNm" value="${workExp.orgnzNm }"></th>
								<td><input type="text" name="exp_iscoCd" value="${workExp.iscoCd }"></td>
								<td><input type="text" name=""></td>
								<td>
									<select name="exp_selfempYn">
										<option value="Y" <c:if test="${workExp.selfempYn eq 'Y'}">selected="selected"</c:if>>Yes</option>
										<option value="N" <c:if test="${workExp.selfempYn eq 'N'}">selected="selected"</c:if>>No</option>
									</select>
								</td>
								<td><input type="text" name="exp_leaveReason" value="${workExp.leaveReason }"></td>
								<td>
									<select name="exp_bgnDt_mm" title="M" class="calCareer">
										<c:forEach var="month" begin="1" end="12">
											<c:choose>
												<c:when test="${month < 10}"><c:set var="exp_bgnMonth" value="0${month}" /></c:when>
												<c:otherwise><c:set var="exp_bgnMonth" value="${month}" /></c:otherwise>
											</c:choose>
											<option value="<c:out value="${exp_bgnMonth}"/>" <c:if test="${workExp.bgnDtMm eq exp_bgnMonth}">selected="selected"</c:if>>
												<c:out value="${exp_bgnMonth}"/>
											</option>
										</c:forEach>
									</select>
									Month
									<select name="exp_bgnDt_yy" title="Y" class="calCareer">
										<c:set var="exp_bgnYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
										<c:forEach var="year" begin="1900" end="${exp_bgnYear}">
											<option value="<c:out value="${year}"/>" <c:if test="${workExp.bgnDtYy eq year}">selected="selected"</c:if>>
												<c:out value="${year}"/>
											</option>
										</c:forEach>
									</select>
									Year
									~<br>
									<select name="exp_endDt_mm" title="M" class="calCareer">
										<c:forEach var="month" begin="1" end="12">
											<c:choose>
												<c:when test="${month < 10}"><c:set var="exp_endMonth" value="0${month}" /></c:when>
												<c:otherwise><c:set var="exp_endMonth" value="${month}" /></c:otherwise>
											</c:choose>
											<option value="<c:out value="${exp_endMonth}"/>" <c:if test="${workExp.endDtMm eq exp_endMonth}">selected="selected"</c:if>>
												<c:out value="${exp_endMonth}"/>
											</option>
										</c:forEach>
									</select>
									Month
									<select name="exp_endDt_yy" title="Y" class="calCareer">
										<c:set var="exp_endYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
										<c:forEach var="year" begin="1900" end="${exp_endYear}">
											<option value="<c:out value="${year}"/>" <c:if test="${workExp.endDtYy eq year}">selected="selected"</c:if>>
												<c:out value="${year}"/>
											</option>
										</c:forEach>
									</select>
									Year
								</td>
								<c:choose>
									<c:when test="${stat.count eq '1' }">
										<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
									</c:when>
									<c:otherwise>
										<td><button type="button" class="bbs_btn type03 tr_delete">x</button></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>

	<h3><spring:message code="field.dic.skill.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20">
			<caption>Skil - Social Skill, Resource Management Skills, Technical Skills, System Skills, Basic Computer Skills, Complex Problem Solving Skills</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:85%;" />
			</colgroup>
			<tbody class="sk_form">
				<c:forEach items="${skillCdList}" var="skillCd">
					<tr>
						<th scope="row"><c:out value="${skillCd.cdEnNm }" escapeXml="false"/></th>
						<td>
							<c:forEach items="${skillCd.list }" var="cd">
								<c:choose>
									<c:when test="${empty skillList}">
										<input type="checkbox" id="skill${cd.dtlCd }" name="sk_skillCd" value="${cd.dtlCd }">
										<label for="skill${cd.dtlCd }"><c:out value="${cd.cdEnNm }" escapeXml="false"/></label>
									</c:when>
									<c:otherwise>
										<c:set var="skillFlag" value="false" />
										<c:forEach items="${skillList }" var="skill">
											<c:if test="${cd.dtlCd eq skill.skillCd }">
												<c:set var="skillFlag" value="true" />
											</c:if>
										</c:forEach>

										<c:choose>
											<c:when test="${skillFlag eq 'true'}">
												<input type="checkbox" id="skill${cd.dtlCd }" name="sk_skillCd" value="${cd.dtlCd }" checked="checked">
												<label for="skill${cd.dtlCd }"><c:out value="${cd.cdEnNm }" escapeXml="false"/></label>
											</c:when>
											<c:otherwise>
												<input type="checkbox" id="skill${cd.dtlCd }" name="sk_skillCd" value="${cd.dtlCd }">
												<label for="skill${cd.dtlCd }"><c:out value="${cd.cdEnNm }" escapeXml="false"/></label>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<h3>Keyword</h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20">
			<colgroup>
				<col style="width:15%;" />
				<col style="width:85%;" />
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">Keyword</th>
					<td>
						<div >
							<div class="form_element keyword active">
								<div class="view_area">
									<span class="text_box" id="keyword_area">
										<c:forEach items="${resumeDetail.resumeKeywordList }" var="keyword">
											<span>
												<c:out value="${keyword }" />
												<button type="button" class="delete">delete</button>
											</span>
										</c:forEach>
									</span>
									<input type="text" id="keyword" class="input_key" />
								</div>
							</div>
							<div class="keyword_info">
								<strong>※ After entering #+ keyword and press enter button, you can add a keyword.</strong>
								<span>Please enter keywords about related your interesting and preference. Keyword will be used for searching and  matching CV and referral.</span>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div>
		<h3><spring:message code="field.dic.recmnd.prsn" /> <button type="button" id="btnUsrReg" class="bbs_btn type03 btn_addForm">+</button></h3>
		<div class="bbs_basic">
			<table class="bbs_table write margin_b_20">
				<caption>추천인 - 추천인명, 회사/조직명, 직급/직책, 본인과의 관계, 연락처, 이메일, 주소 제공</caption>
				<colgroup>
					<col style="width:12%;" />
					<col style="width:16%;" />
					<col style="width:8%;" />
					<col style="width:10%;" />
					<col style="width:11%;" />
					<col style="width:13%;" />
					<col style="width:25%;" />
					<col style="width:5%;" />
				</colgroup>
				<thead>
				<tr>
					<th scope="col"><spring:message code="field.dic.recmnd.prsnnm" /></th>
					<th scope="col"><spring:message code="field.dic.cmny" />/<spring:message code="field.dic.orgnz.nm" /></th>
					<th scope="col"><spring:message code="field.dic.job.position" />/<spring:message code="field.dic.job.resp" /></th>
					<th scope="col"><spring:message code="field.dic.myself.relation" /></th>
					<th scope="col"><spring:message code="field.dic.contract" /></th>
					<th scope="col"><spring:message code="field.dic.email" /></th>
					<th scope="col"><spring:message code="userChg.list.title.address" /></th>
					<th scope="col">삭제</th>
				</tr>
				</thead>
				<tbody class="text_center ref_form">
					<c:if test="${empty refManList }">
						<tr class="tr_original">
							<th scope="row"><input type="text" name="ref_nm"></th>
							<td><input type="text" name="ref_orgnzNm"></td>
							<td><input type="text" name="ref_position"></td>
							<td><input type="text" name="ref_ref"></td>
							<td><input type="text" name="ref_cell" class="inputNo"></td>
							<td><input type="text" name="ref_email" class="inputEmail"></td>
							<td>
								<input type="hidden" name="ref_addrCd" id="ref_addrCd" value="" required/>
								<input type="hidden" name="ref_addrFullCd" id="ref_addrFullCd" value="" required/>
								<button type="button" value="popup" class="bbs_btn type03" id="test" onclick="popAddrLayerBtn('ref_addrCd', 'ref_addrFullCd', 'ref_addrFullNm', 'ref_addrFullNmView', this);"><spring:message code="field.dic.area" /></button>
								<br>
								<label for="addrDtl"><spring:message code="field.dic.addr.base" /></label>&nbsp;&nbsp;<input type="text" name="ref_addrFullNm" id="ref_addrFullNm" value="" style="width:50%;" disabled="disabled" /><br>
								<label for="addrDtl"><spring:message code="field.dic.dtladdr" /></label>&nbsp;&nbsp;<input type="text" name="ref_addrDtl" id="ref_addrDtl" style="width:50%;" value="" />
							</td>
							<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
						</tr>
					</c:if>
					<c:if test="${not empty refManList }">
						<c:forEach items="${refManList }" var="refMan" varStatus="stat">
							<tr class="tr_original">
								<th scope="row"><input type="text" name="ref_nm" value="${refMan.nm }"></th>
								<td><input type="text" name="ref_orgnzNm" value="${refMan.orgnzNm }"></td>
								<td><input type="text" name="ref_position" value="${refMan.position }"></td>
								<td><input type="text" name="ref_ref" value="${refMan.ref }"></td>
								<td><input type="text" name="ref_cell" class="inputNo" value="${refMan.cell }"></td>
								<td><input type="text" name="ref_email" class="inputEmail" value="${refMan.email }"></td>
								<td>
									<input type="hidden" name="ref_addrCd" id="ref_addrCd" value="${refMan.addrCd }" required/>
									<input type="hidden" name="ref_addrFullCd" id="ref_addrFullCd" value="${refMan.addrFullCd }" required/>
									<button type="button" value="popup" class="bbs_btn type03" id="test" onclick="popAddrLayerBtn('ref_addrCd', 'ref_addrFullCd', 'ref_addrFullNm', 'ref_addrFullNmView', this);"><spring:message code="field.dic.area" /></button>
									<br>
									<label for="addrDtl"><spring:message code="field.dic.addr.base" /></label>&nbsp;&nbsp;<input type="text" name="ref_addrFullNm" id="ref_addrFullNm" value="${refMan.addrFullNm }" style="width:50%;" disabled="disabled" /><br>
									<label for="addrDtl"><spring:message code="field.dic.dtladdr" /></label>&nbsp;&nbsp;<input type="text" name="ref_addrDtl" id="ref_addrDtl" style="width:50%;" value="${refMan.addrDtl }" />
								</td>
								<td><button type="button" class="bbs_btn type03 tr_delete" style="display: none;">x</button></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>

	<!-- //bbs_btn_wrap -->
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<a href="${pageContext.request.contextPath}/internal/user/userElementaryInfoList.do" class="bbs_btn list"><spring:message code="button.list" /></a>
		</span>
		<span class="bbs_right">
			<button type="button" id="btnDelete" class="bbs_btn type03 " >삭제</button>
			<button type="button" id="btnSave" class="bbs_btn save" >저장</button>
		</span>
	</div>


</form>