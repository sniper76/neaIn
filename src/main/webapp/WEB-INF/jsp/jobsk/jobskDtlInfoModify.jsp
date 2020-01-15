<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/jobsk/jobskDtlInfoModify.js"></script>

<script type="text/javascript">
$(function() {
	common.invoker.invoke("jobskDtlInfoModify");
	commonPopupSet('isco');
	fnDeleteSpan();
});
</script>

<form id="frmJobskDtlInfoModify">
<input type="hidden" id="jobskReqSeq" name="jobskReqSeq" value="<c:out value="${rtnBase.jobskReqSeq}" />" />
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnBase.userSeq}" />" />
<input type="hidden" id="resumeSeq" name="resumeSeq" value="<c:out value="${rtnBase.resumeSeq}" />" />
<input type="hidden" id="jcAgreeStsCdValue" name="jcAgreeStsCdValue" value="<c:out value="${rtnBase.jcAgreeStsCd}" />" />

	<table class="bbs_table margin_b_30">
		<caption>Profile - Name, Member Type, Nobile No, E-mail, Job search status, Address</caption>
		<colgroup>
			<col style="width:10%;" />
			<col style="width:15%;" />
			<col style="width:30%;" />
			<col style="width:15%;" />
			<col style="width:30%;" />
		</colgroup>
		<tbody>
		<tr>
			<td rowspan="4" style="vertical-align:middle;">
				<div class="text_center"><img src="../../images/board/dummy_photo.png" alt=" image" /></div>
			</td>
			<th scope="row"><spring:message code="field.dic.usernm" /></th>
			<td><c:out value="${rtnBase.userNm}" /></td>
			<th scope="row"><spring:message code="field.dic.usrtype" /></th>
			<td><c:out value="${rtnBase.userAuthNm}" /></td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.mobile" /></th>
			<td><c:out value="${rtnBase.userCell}" /></td>
			<th scope="row"><spring:message code="field.dic.age" /> / <spring:message code="field.dic.gender" /></th>
			<td><c:out value="${rtnBase.age}" /> / <c:out value="${rtnBase.genderNm}" /></td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.email" /></th>
			<td><c:out value="${rtnBase.userEmail}" /></td>
			<th scope="row"><spring:message code="field.dic.jobsksts" /></th>
			<td><c:out value="${rtnBase.jobskStsNm}" /></td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="userChg.list.title.address" /></th>
			<td colspan="3"><c:out value="${rtnBase.addrFullNm}" /></td>
		</tr>
		</tbody>
	</table>

	<h3><spring:message code="field.dic.jobsk.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.now.workyn" /></th>
				<td><c:out value="${rtnBase.nowWorkYn}" /></td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.urgent.jobseekyn" /></th>
				<td><c:out value="${rtnBase.urgentJobseekYn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.attach.file" /></th>
				<td colspan="3"><c:out value="${rtnBase.fileGrpSeq}" /></td>
			</tr>
			</tbody>
		</table>
	</div>
	
	<h3><spring:message code="field.dic.resume.title" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.resume.title" /></th>
				<td colspan="3"><c:out value="${rtnBase.resumeTitle}" /></td>
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
				<td colspan="3"><c:out value="${rtnBase.birthAddrDtl}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.marricd" /></th>
				<td colspan="3"><c:out value="${rtnBase.marriNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.family.info" /> (<spring:message code="field.dic.family.cnt" />)</th>
				<td colspan="3"><c:out value="${rtnBase.familyCnt}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.family.under15" /></th>
				<td><c:out value="${rtnBase.underAge15FamilyCnt}" /></td>
				<th scope="row"><spring:message code="field.dic.family.over65" /></th>
				<td><c:out value="${rtnBase.overAge64FamilyCnt}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.first.jobseek" /></th>
				<td><c:out value="${rtnBase.frstimeJobSeekerYn}" /></td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.studying.yn" /></th>
				<td><c:out value="${rtnBase.studyingYn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.ret.migrat" /></th>
				<td><c:out value="${rtnBase.retMigratYn}" /></td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.srvc.yn" /></th>
				<td><c:out value="${rtnBase.srvcYn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.ethnic.minor" /></th>
				<td colspan="3"><c:out value="${rtnBase.ethnicMinorYn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.disable.yn" /></th>
				<td colspan="3"><c:out value="${rtnBase.disablYn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.disable.option" /></th>
				<td colspan="3"><c:out value="${rtnBase.disablOptionNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.self.employee" /></th>
				<td colspan="3"><c:out value="${rtnBase.selfempYn}" /></td>
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
				<td colspan="3"><c:out value="${rtnBaseData.preferJobTitle}" /> / <c:out value="${rtnBaseData.preferPosition}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.isco" /></th> 
				<td colspan="3">
					<div class="bbs_add_wrap">
						<button type="button" id="btnIscoCd" class="bbs_btn type04 vertical_middle popup_isco" onclick="callback(fnSetIsco, 'isco');"><spring:message code="field.dic.isco.select" /></button>
						<span class="text_box" id="span_isco">
							<c:if test="${not empty rtnIsco}">
							<c:forEach items="${rtnIsco}" var="IscoList">
								<span class="bbs_add">
									<input type="hidden" class="iscoCd" name="iscoCd" value="<c:out value="${IscoList.iscoNm}" />" >
									<c:out value="${IscoList.iscoNm}" />
									<button type="button" class="delete">delete</button>
								</span>
							</c:forEach>
							</c:if>						
						</span>
					</div>
				</td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.work.place" /></th> 
				<td colspan="3">
					<c:forEach items="${rtnLoc}" var="rtnLocList">
						<c:out value="${rtnLocList.addrFullNm}" /><br>
					</c:forEach> 
				</td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.form" /></th> 
				<td colspan="3"><c:out value="${rtnBase.employFormNm}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.type" /></th> 
				<td colspan="3"><c:out value="${rtnBase.preferEmployTypeNm}" /></td> 
			</tr>
			<tr> 
				<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.hour" /></th> 
				<td>
				<c:set var="typeEmployHourDay" value="${rtnBase.typeEmployHourDay}" />
				<c:if test="${typeEmployHourDay gt 0}" >
					<c:out value="${rtnBase.typeEmployHourDay}" /> <spring:message code="field.dic.emp.timeday" />
				</c:if>
				</td>
				<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.day" /></th> 
				<td>
				<c:set var="typeEmployDayWeek" value="${rtnBase.typeEmployDayWeek}" />
				<c:if test="${typeEmployDayWeek gt 0}" >
					<c:out value="${rtnBase.typeEmployDayWeek}" /> <spring:message code="field.dic.emp.dayweek" />
				</c:if>
				</td>
			</tr> 
			<tr> 
				<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.week.day" /></th> 
				<td colspan="3"><c:out value="${rtnBase.preferWorkWeekDay}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.ctct.type" /></th> 
				<td><c:out value="${rtnBase.preferCrtctTypeNm}" /></td> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.overyn" /></th> 
				<td><c:out value="${rtnBase.additionalWorkOver}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.salary" /></th> 
				<td>
				<c:set var="salaryMinAmt" value="${rtnBase.expctMinSalaryAmt}" />
				<c:set var="salaryMaxAmt" value="${rtnBase.expctMaxSalaryAmt}" />
				<c:choose>
					<c:when test="${salaryMinAmt eq null && salaryMinAmt eq ''}" >
					$0
					</c:when>
					<c:when test="${salaryMinAmt ne null && salaryMinAmt ne ''}" >
					$<c:out value="${salaryMinAmt}" />
					</c:when>
				</c:choose>
				 ~ 
				<c:choose>
					<c:when test="${salaryMaxAmt eq null && salaryMaxAmt eq ''}" >
					$0
					</c:when>
					<c:when test="${salaryMaxAmt ne null && salaryMaxAmt ne ''}" >
					$<c:out value="${salaryMaxAmt}" />
					</c:when>
				</c:choose>				 
				</td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.otrplaceyn" /></th> 
				<td><c:out value="${rtnBase.diffProvcWorkYn}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.bgndt" /></th> 
				<td colspan="3"><c:out value="${rtnBase.workBgnAbleWithin}" /></td> 
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
				<td><c:out value="${rtnBase.eduGnrlIscedNm}" /></td> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.edu.skill" /></th> 
				<td><c:out value="${rtnBase.eduSkillIscedNm}" /></td> 
			</tr> 
			</tbody> 
		</table>
	</div>

	<h3><spring:message code="field.dic.rsch.especial.training" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption>연구 및 전문 교육 - 연구/전문 분야명, 연구기간, 교육기관명, 국가, 시/도 제공</caption>
			<colgroup>
				<col style="width:20%;" />
				<col style="width:20%;" />
				<col style="width:20%;" />
				<col style="width:20%;" />
				<col style="width:20%;" />
			</colgroup>
			<thead> 
				<tr> 
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.rsch.especial.fieldnm" /></th> 
					<th scope="col"> <spring:message code="field.dic.rsch.term" /></th> 
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.insttnm" /></th> 
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.nation" /></th> 
					<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.city.state" /></th> 
				</tr> 
			</thead> 
			<tbody class="text_center">  
				<c:forEach items="${rtnSpcEdu}" var="rtnSpcEduList">
				<tr> 
					<th scope="row"><c:out value="${rtnSpcEduList.specialStudyNm}" /></th> 
					<td><c:out value="${rtnSpcEduList.bgnDt}" /> ~ <c:out value="${rtnSpcEduList.endDt}" />
					</td>
					<td><c:out value="${rtnSpcEduList.insttNm}" /></td> 
					<td><c:out value="${rtnSpcEduList.cntryNm}" /></td>
					<td><c:out value="${rtnSpcEduList.provcNm}" /></td>
				</tr>
				</c:forEach> 			
			</tbody> 
		</table>
	</div>

	<h3><spring:message code="field.dic.license.owner.yn" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:85%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.licns.certification" /></th> 
				<td><c:out value="${rtnBase.proLicnsSpec}" /></td> 
			</tr> 
			</tbody> 
		</table>
	</div>

	<h3><spring:message code="field.dic.etc.training" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption>기타 교육 - 레벨/수료/학위졸업/학위, 전공/전문/분야, 기관명, 지역, 연구기간 제공 </caption>
			<colgroup>
				<col style="width:20%;" />
				<col style="width:20%;" />
				<col style="width:20%;" />
				<col style="width:20%;" />
				<col style="width:20%;" />
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
			</tr> 
		</thead> 
		<tbody class="text_center"> 
		<c:forEach items="${rtnOtrTrnng}" var="rtnOtrTrngList">
		<tr> 
			<th scope="row"><c:out value="${rtnOtrTrngList.trnngEduDegreeNm}" /></th> 
			<td><c:out value="${rtnOtrTrngList.iscedNm}" /></td>
			<td><c:out value="${rtnOtrTrngList.insttNm}" /></td> 
			<td><c:out value="${rtnOtrTrngList.addrProvcNm}" /></td>
			<td><c:out value="${rtnOtrTrngList.bgnDt}" /> ~ 
			<c:out value="${rtnOtrTrngList.endDt}" /></td> 
		</tr>
		</c:forEach> 
		</tbody> 		
		</table>
	</div>

	<h3><spring:message code="field.dic.language.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption>어학 - 모국어, 외국어 명</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>			
			<c:choose>
				<c:when test="${empty rtnLang}">
					<tr> 
						<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.lang.native" /></th> 
						<td colspan="3"></td> 
					</tr>	
					<tr> 
						<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.foreignlang.name" /></th> 
						<td></td> 
						<th scope="row"><spring:message code="field.dic.foreign.lvl" /></th>  
						<td></td> 
					</tr>				
				</c:when>
				<c:when test="${not empty rtnLang}">									
					<c:forEach items="${rtnLang}" var="rtnlanglist">
						<c:set var="langTypeCd" value="${rtnlanglist.langTypeCd}" />
						<c:choose>
							<c:when test="${langTypeCd eq 'RTC0000000001'}" >
								<tr> 
									<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.lang.native" /></th> 
									<td colspan="3"><c:out value="${rtnlanglist.langNm}" /></td> 
								</tr>
							</c:when>
							<c:when test="${langTypeCd eq 'RTC0000000002'}" >
								<tr> 
									<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.foreignlang.name" /></th> 
									<td><c:out value="${rtnlanglist.langNm}" /></td> 
									<th scope="row"><spring:message code="field.dic.foreign.lvl" /></th>  
									<td><c:out value="${rtnlanglist.langLvlNm}" /></td> 
								</tr> 
							</c:when>
						</c:choose>					
					</c:forEach>
				</c:when>									
			</c:choose> 
			</tbody> 
		</table>
	</div>

	<h3><spring:message code="field.dic.career.info" /> <span class="em_blue small">
	<spring:message code="field.dic.total" /> 
	<c:out value="${rtnBase.totCareerTermYearCnt}" /><spring:message code="field.dic.year" /> 
	<c:out value="${rtnBase.totCareerTermMonthCnt}" /><spring:message code="field.dic.month.cnt" />
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
				<col style="width:20%;" />
			</colgroup>
			<thead> 
			<tr> 
				<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.company.name" /></th> 
				<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.isco" /></th> 
				<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.job.position" />/<spring:message code="field.dic.job.resp" /></th> 
				<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.self.employee" /></th> 
				<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.retire.reason" /></th> 
				<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.term" /></th> 
			</tr> 
			</thead> 
			<tbody class="text_center">
			<c:forEach items="${rtnWorkExp}" var="rtnWorkExplist">
			<tr> 
				<th scope="row"><c:out value="${rtnWorkExplist.orgnzNm}" /></th> 
				<td><c:out value="${rtnWorkExplist.jobSector}" /></td>
				<td><c:out value="${rtnWorkExplist.jobPosition}" /></td> 
				<td><c:out value="${rtnWorkExplist.selfempYn}" /></td> 
				<td><c:out value="${rtnWorkExplist.leaveReason}" /></td> 
				<td><c:out value="${rtnWorkExplist.bgnDt}" /> ~ <c:out value="${rtnWorkExplist.endDt}" /></td> 
			</tr>
			</c:forEach> 
			</tbody> 
		</table>
		
	</div>
	
	<h3><spring:message code="field.dic.skill.info" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption>Skil - Social Skill, Resource Management Skills, Technical Skills, System Skills, Basic Computer Skills, Complex Problem Solving Skills</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:85%;" />
			</colgroup>
			<tbody>
			<c:choose>
				<c:when test="${empty rtnSkill}">
					<th scope="row"><span class="exactly y">necessary</span> </th> 
					<td></td>				
				</c:when>
				<c:when test="${not empty rtnSkill}">
					<c:forEach items="${rtnSkill}" var="rtnSkillList">
					<c:forEach items="${rtnSkillList}" var="rtnSkillMap">
					<tr> 
						<th scope="row"><span class="exactly y">necessary</span> <c:out value="${rtnSkillMap.key}" /></th> 
						<td><c:out value="${rtnSkillMap.value}" /></td> 
					</tr>
					</c:forEach>
					</c:forEach>
				</c:when>
			</c:choose> 
			</tbody> 
		</table>
		
	</div>

	<h3><spring:message code="field.dic.recmnd.prsn" /></h3>
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
				<col style="width:30%;" />
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
			</tr> 
			</thead> 
			<tbody class="text_center">
			<c:forEach items="${rtnRcmdman}" var="rtnRcmdmanList"> 
			<tr> 
				<th scope="row"><c:out value="${rtnRcmdmanList.nm}" /></th> 
				<td><c:out value="${rtnRcmdmanList.orgnzNm}" /></td> 
				<td><c:out value="${rtnRcmdmanList.position}" /></td> 
				<td><c:out value="${rtnRcmdmanList.ref}" /></td> 
				<td><c:out value="${rtnRcmdmanList.cell}" /></td> 
				<td><c:out value="${rtnRcmdmanList.email}" /></td> 
				<td><c:out value="${rtnRcmdmanList.addrFullNm}" /></td> 
			</tr> 
			</c:forEach>
			</tbody> 
		</table>
	</div>
	
	<h3><spring:message code="field.dic.jc.agreeyn" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"> <spring:message code="field.dic.signupDt" /></th>
				<td><c:out value="${rtnBase.regDt}" /></td>
				<th scope="row"> <spring:message code="field.dic.jcAgree.dt" /></th>
				<td><c:out value="${rtnBase.jcAgreeDt}" /></td>				
			</tr>
						
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.jc.agreeyn" /></th>
				<td><commCode:commcode codeKind="commCode" tagName="jcAgreeStsCd" grpCd="JC_AGREE_STS_CD" drawType="radio" initValue="" exceptValue="ALL" disable=""/></td>
				<th scope="row"> <spring:message code="field.dic.rsps.prsn" /></th>
				<td><c:out value="${rtnBase.jcUserNm}" /></td>				
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.not.agree.reason" /></th>
				<td colspan="3">
					<textarea id="agreeRejectReason" name="agreeRejectReason"><c:out value="${rtnBase.agreeRejectReason}" /></textarea>
				</td>
			</tr>			
			</tbody>
		</table>
	</div>
	
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<a href="${pageContext.request.contextPath}/internal/jobsk/jobskList.do" class="bbs_btn list"><spring:message code="button.list" /></a>
		</span>
		<span class="bbs_right">
			<button type="button" class="bbs_btn delete" onclick="btnJobskRequestDelete();"><spring:message code="cpes.btn.delete" /></button>
			<button type="button" class="bbs_btn save" onclick="btnJobskDtlInfoSave();"><spring:message code="cpes.btn.save" /></button>
		</span>
	</div>
	<!-- //bbs_btn_wrap -->

</form>