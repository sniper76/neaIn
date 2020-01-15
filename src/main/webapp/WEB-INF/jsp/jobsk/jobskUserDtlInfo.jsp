<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/jobsk/jobskUserDtlInfo.js"></script>

<script>
$(function() {
	common.invoker.invoke("jobskUserDtlInfo");
});
</script>

<form id="frmUserDtlInfoMain">
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnCommInfo.userSeq}" />" />

<div class="bbs_basic">
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
			<th scope="row"><spring:message code="search.name" /> / <spring:message code="field.dic.usrtype" /></th>
			<td><c:out value="${rtnCommInfo.userNm}" /> / <c:out value="${rtnCommInfo.userAuthNm}" /></td>
			<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
			<td><c:out value="${rtnCommInfo.jcNm}" /></td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.mobile" /></th>
			<td><c:out value="${rtnCommInfo.userCell}" /></td>
			<th scope="row"><spring:message code="field.dic.age" /> / <spring:message code="field.dic.gender" /></th>
			<td><c:out value="${rtnCommInfo.age}" /> / <c:out value="${rtnCommInfo.genderNm}" /></td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.email" /></th>
			<td><c:out value="${rtnCommInfo.userEmail}" /></td>
			<th scope="row"><spring:message code="field.dic.jobsksts" /></th>
			<td><c:out value="${rtnCommInfo.jobskStsNm}" /></td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="userChg.list.title.address" /></th>
			<td colspan="3"><c:out value="${rtnCommInfo.addrDtl}" /></td>
		</tr>
		</tbody>
	</table>
</div>

<h3><spring:message code="field.dic.jobsk.info" /></h3>
<div class="bbs_basic">
	<table class="bbs_table write margin_b_20"> 
		<caption><spring:message code="field.dic.jobsk.info" /></caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.now.workyn" /></th>
			<td><c:out value="${rtnCommInfo.nowWorkYn}" /></td>
			<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.urgent.jobseekyn" /></th>
			<td><c:out value="${rtnCommInfo.urgentJobseekYn}" /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.attach.file" /></th>
			<td colspan="3">추후에 추가해야 함.</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
	
<h3><spring:message code="field.dic.resume.title" /></h3>
<div class="bbs_basic">	
	<table class="bbs_table write margin_b_20"> 
		<caption><spring:message code="field.dic.resume.title" /></caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><spring:message code="field.dic.resume.title" /></th>
			<td colspan="3"><c:out value="${rtnCommInfo.resumeTitle}" /></td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
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
			<td colspan="3"><c:out value="${rtnCommInfo.birthAddrDtl}" /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.marricd" /></th>
			<td colspan="3"><c:out value="${rtnCommInfo.marriNm}" /></td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.family.info" /> (<spring:message code="field.dic.family.cnt" />)</th>
			<td colspan="3"><c:out value="${rtnCommInfo.familyCnt}" /></td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.family.under15" /></th>
			<td><c:out value="${rtnCommInfo.underAge15FamilyCnt}" /></td>
			<th scope="row"><spring:message code="field.dic.family.over65" /></th>
			<td><c:out value="${rtnCommInfo.overAge64FamilyCnt}" /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.first.jobseek" /></th>
			<td><c:out value="${rtnCommInfo.frstimeJobSeekerYn}" /></td>
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.studying.yn" /></th>
			<td><c:out value="${rtnCommInfo.studyingYn}" /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.ret.migrat" /></th>
			<td><c:out value="${rtnCommInfo.retMigratYn}" /></td>
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.srvc.yn" /></th>
			<td><c:out value="${rtnCommInfo.srvcYn}" /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.ethnic.minor" /></th>
			<td colspan="3"><c:out value="${rtnCommInfo.ethnicMinorYn}" /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.disable.yn" /></th>
			<td colspan="3"><c:out value="${rtnCommInfo.disablYn}" /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.disable.option" /></th>
			<td colspan="3"><c:out value="${rtnCommInfo.disablOptionNm}" /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.self.employee" /></th>
			<td colspan="3"><c:out value="${rtnCommInfo.selfempYn}" /></td>
		</tr>
		</tbody>
	</table>		
</div>

<h3><spring:message code="field.dic.prefer.job.condition" /></h3>
<div class="bbs_basic">
	<table class="bbs_table write margin_b_20"> 
		<caption><spring:message code="field.dic.prefer.job.condition" /></caption> 
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.job" />/<spring:message code="field.dic.job.resp" /></th> 
			<td colspan="3"><c:out value="${rtnCommInfo.preferJobTitle}" /> / <c:out value="${rtnCommInfo.preferPosition}" /></td> 
		</tr> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.isco" /></th> 
			<td colspan="3"><c:out value="${rtnCommInfo.iscoList}" /></td> 
		</tr> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.work.place" /></th> 
			<td colspan="3">
				<c:forEach items="${rtnLocData}" var="rtnLocList">
					<c:out value="${rtnLocList.addrFullNm}" /><br>
				</c:forEach>			
			</td> 
		</tr> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.form" /></th> 
			<td colspan="3"><c:out value="${rtnCommInfo.employFormNm}" /></td> 
		</tr> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.type" /></th> 
			<td colspan="3"><c:out value="${rtnCommInfo.preferEmployTypeNm}" /></td> 
		</tr>
		<tr> 
			<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.hour" /></th> 
			<td>
			<c:set var="typeEmployHourDay" value="${rtnCommInfo.typeEmployHourDay}" />
			<c:if test="${typeEmployHourDay gt 0}" >
				<c:out value="${rtnCommInfo.typeEmployHourDay}" /> <spring:message code="field.dic.emp.timeday" />
			</c:if>
			</td>
			<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.day" /></th> 
			<td>
			<c:set var="typeEmployDayWeek" value="${rtnCommInfo.typeEmployDayWeek}" />
			<c:if test="${typeEmployDayWeek gt 0}" >
				<c:out value="${rtnCommInfo.typeEmployDayWeek}" /> <spring:message code="field.dic.emp.dayweek" />
			</c:if>
			</td>
		</tr> 
		<tr> 
			<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.week.day" /></th> 
			<td colspan="3"><c:out value="${rtnCommInfo.preferWorkWeekDay}" /></td> 
		</tr> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.ctct.type" /></th> 
			<td><c:out value="${rtnCommInfo.preferCrtctTypeNm}" /></td> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.overyn" /></th> 
			<td><c:out value="${rtnCommInfo.additionalWorkOver}" /></td> 
		</tr> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.salary" /></th> 
			<td>
			<c:set var="salaryMinAmt" value="${rtnCommInfo.expctMinSalaryAmt}" />
			<c:set var="salaryMaxAmt" value="${rtnCommInfo.expctMaxSalaryAmt}" />
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
			<td><c:out value="${rtnCommInfo.diffProvcWorkYn}" /></td> 
		</tr> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.bgndt" /></th> 
			<td colspan="3"><c:out value="${rtnCommInfo.workBgnAbleWithin}" /></td> 
		</tr>
		</tbody> 
	</table>
</div>

<h3><spring:message code="field.dic.edu.especial.training" /></h3>
<div class="bbs_basic">
	<table class="bbs_table write margin_b_20"> 
		<caption><spring:message code="field.dic.edu.especial.training" /></caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.edu.gnrl" /></th> 
			<td><c:out value="${rtnCommInfo.eduGnrlIscedNm}" /></td> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.edu.skill" /></th> 
			<td><c:out value="${rtnCommInfo.eduSkillIscedNm}" /></td> 
		</tr> 
		</tbody> 
	</table>
</div>

<h3><spring:message code="field.dic.rsch.especial.training" /></h3>
<div class="bbs_basic">
	<table class="bbs_table write margin_b_20"> 
		<caption><spring:message code="field.dic.rsch.especial.training" /></caption>
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
				<th scope="col"><spring:message code="field.dic.rsch.term" /></th> 
				<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.insttnm" /></th> 
				<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.nation" /></th> 
				<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.city.state" /></th> 
			</tr> 
		</thead> 
		<tbody class="text_center">  
			<c:forEach items="${rtnSpcEduData}" var="rtnSpcEduList">
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
		<caption><spring:message code="field.dic.license.owner.yn" /></caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:85%;" />
		</colgroup>
		<tbody> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.licns.certification" /></th> 
			<td><c:out value="${rtnCommInfo.proLicnsSpec}" /></td> 
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
	<c:forEach items="${rtnOtrTrngData}" var="rtnOtrTrngList">
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
		<c:forEach items="${rtnLangData}" var="rtnlanglist">
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
		</tbody> 
	</table>
</div>

<h3><spring:message code="field.dic.career.info" /><span class="em_blue small">
<spring:message code="field.dic.total" /> 
<c:out value="${rtnCommInfo.totCareerTermYearCnt}" /><spring:message code="field.dic.year" /> 
<c:out value="${rtnCommInfo.totCareerTermMonthCnt}" /><spring:message code="field.dic.month.cnt" />
</span></h3>
<div class="bbs_basic">
	<table class="bbs_table write margin_b_20"> 
		<caption><spring:message code="field.dic.career.info" /></caption>
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
			<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.isic" /></th> 
			<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.self.employee" /></th> 
			<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.retire.reason" /></th> 
			<th scope="col"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.term" /></th> 
		</tr> 
		</thead> 
		<tbody class="text_center">
		<c:forEach items="${rtnWorkExpData}" var="rtnWorkExplist">
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
		<c:forEach items="${rtnSkillData}" var="rtnSkillList">
		<c:forEach items="${rtnSkillList}" var="rtnSkillMap">
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <c:out value="${rtnSkillMap.key}" /></th> 
			<td><c:out value="${rtnSkillMap.value}" /></td> 
		</tr>
		</c:forEach>
		</c:forEach> 
		</tbody> 
	</table>
	
</div>

<h3><spring:message code="field.dic.recmnd.prsn" /></h3>
<div class="bbs_basic">
	<table class="bbs_table write margin_b_20"> 
		<caption><spring:message code="field.dic.recmnd.prsn" /></caption>
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
		<c:forEach items="${rtnRefmanData}" var="rtnRefmanList"> 
		<tr> 
			<th scope="row"><c:out value="${rtnRefmanList.nm}" /></th> 
			<td><c:out value="${rtnRefmanList.orgnzNm}" /></td> 
			<td><c:out value="${rtnRefmanList.position}" /></td> 
			<td><c:out value="${rtnRefmanList.ref}" /></td> 
			<td><c:out value="${rtnRefmanList.cell}" /></td> 
			<td><c:out value="${rtnRefmanList.email}" /></td> 
			<td><c:out value="${rtnRefmanList.addr}" /></td> 
		</tr> 
		</c:forEach>
		</tbody> 
	</table>
</div>

<h3><spring:message code="field.dic.jc.agreeyn" /></h3>
<div class="bbs_basic">
	<table class="bbs_table write margin_b_20"> 
		<caption><spring:message code="field.dic.jc.agreeyn" /></caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:85%;" />
		</colgroup>
		<tbody> 
		<tr> 
			<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.jc.agreeyn" /></th> 
			<td><c:out value="${rtnCommInfo.jcAgreeStsNm}" /></td> 
		</tr> 
		</tbody> 
	</table>
</div>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<a href="" class="bbs_btn list">list</a>
	</span>
	<span class="bbs_right">
		<a href="" class="bbs_btn list">Update</a>
	</span>
</div>
</form>