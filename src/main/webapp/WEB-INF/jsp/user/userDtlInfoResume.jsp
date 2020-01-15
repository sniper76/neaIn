<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userDtlInfoResume.js"></script>

<script>
$(function() {
	common.invoker.invoke("userDtlInfoResume");
});
</script>

<form id="frmUserInsttDeatilInfoBase">
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnBaseData.userSeq}" />" />
<input type="hidden" id="resumeSeq" name="resumeSeq" value="<c:out value="${rtnBaseData.resumeSeq}" />" />

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
				<td colspan="3"><c:out value="${rtnBaseData.birthAddrDtl}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.marricd" /></th>
				<td colspan="3"><c:out value="${rtnBaseData.marriNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.family.info" /> (<spring:message code="field.dic.family.cnt" />)</th>
				<td colspan="3"><c:out value="${rtnBaseData.familyCnt}" /></td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="field.dic.family.under15" /></th>
				<td><c:out value="${rtnBaseData.underAge15FamilyCnt}" /></td>
				<th scope="row"><spring:message code="field.dic.family.over65" /></th>
				<td><c:out value="${rtnBaseData.overAge64FamilyCnt}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.first.jobseek" /></th>
				<td><c:out value="${rtnBaseData.frstimeJobSeekerYn}" /></td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.studying.yn" /></th>
				<td><c:out value="${rtnBaseData.studyingYn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.ret.migrat" /></th>
				<td><c:out value="${rtnBaseData.retMigratYn}" /></td>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.srvc.yn" /></th>
				<td><c:out value="${rtnBaseData.srvcYn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.ethnic.minor" /></th>
				<td colspan="3"><c:out value="${rtnBaseData.ethnicMinorYn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.disable.yn" /></th>
				<td colspan="3"><c:out value="${rtnBaseData.disablYn}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.disable.option" /></th>
				<td colspan="3"><c:out value="${rtnBaseData.disablOptionNm}" /></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.self.employee" /></th>
				<td colspan="3"><c:out value="${rtnBaseData.selfempYn}" /></td>
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
					<c:out value="${rtnBaseData.iscoList}" />
					<!-- <button type="button" class="bbs_btn type04 vertical_middle" onclick="popUpIsco();">희망직종 수정</button> -->
					</td> 
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
				<td colspan="3"><c:out value="${rtnBaseData.employFormNm}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.type" /></th> 
				<td colspan="3"><c:out value="${rtnBaseData.preferEmployTypeNm}" /></td> 
			</tr>
			<tr> 
				<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.hour" /></th> 
				<td>
				<c:set var="typeEmployHourDay" value="${rtnBaseData.typeEmployHourDay}" />
				<c:if test="${typeEmployHourDay gt 0}" >
					<c:out value="${rtnBaseData.typeEmployHourDay}" /> <spring:message code="field.dic.emp.timeday" />
				</c:if>
				</td>
				<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.emp.day" /></th> 
				<td>
				<c:set var="typeEmployDayWeek" value="${rtnBaseData.typeEmployDayWeek}" />
				<c:if test="${typeEmployDayWeek gt 0}" >
					<c:out value="${rtnBaseData.typeEmployDayWeek}" /> <spring:message code="field.dic.emp.dayweek" />
				</c:if>
				</td>
			</tr> 
			<tr> 
				<th scope="row"><spring:message code="field.dic.prefer" /><spring:message code="field.dic.week.day" /></th> 
				<td colspan="3"><c:out value="${rtnBaseData.preferWorkWeekDay}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.ctct.type" /></th> 
				<td><c:out value="${rtnBaseData.preferCrtctTypeNm}" /></td> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.overyn" /></th> 
				<td><c:out value="${rtnBaseData.additionalWorkOver}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.prefer" /><spring:message code="field.dic.salary" /></th> 
				<td>
				<c:set var="salaryMinAmt" value="${rtnBaseData.expctMinSalaryAmt}" />
				<c:set var="salaryMaxAmt" value="${rtnBaseData.expctMaxSalaryAmt}" />
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
				<td><c:out value="${rtnBaseData.diffProvcWorkYn}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.work.bgndt" /></th> 
				<td colspan="3"><c:out value="${rtnBaseData.workBgnAbleWithin}" /></td> 
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
				<td><c:out value="${rtnBaseData.eduGnrlIscedNm}" /></td> 
				<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.edu.skill" /></th> 
				<td><c:out value="${rtnBaseData.eduSkillIscedNm}" /></td> 
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
				<td><c:out value="${rtnBaseData.proLicnsSpec}" /></td> 
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
			<c:choose>
				<c:when test="${empty rtnLangData}">
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
				<c:when test="${not empty rtnLangData}">									
					<c:forEach items="${rtnLangData}" var="rtnlanglist">
						<c:set var="langTypeCd" value="${rtnlanglist.langTypeCd}" />
						<c:choose>
							<c:when test="${langTypeCd eq 'LTC0000000001'}" >
								<tr> 
									<th scope="row"><span class="exactly y">necessary</span> <spring:message code="field.dic.lang.native" /></th> 
									<td colspan="3"><c:out value="${rtnlanglist.langNm}" /></td> 
								</tr>
							</c:when>
							<c:when test="${langTypeCd eq 'LTC0000000002'}" >
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
	<c:out value="${rtnBaseData.totCareerTermYearCnt}" /><spring:message code="field.dic.year" /> 
	<c:out value="${rtnBaseData.totCareerTermMonthCnt}" /><spring:message code="field.dic.month.cnt" />
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
			<c:choose>
				<c:when test="${empty rtnSkillData}">
					<th scope="row"><span class="exactly y">necessary</span> </th> 
					<td></td>				
				</c:when>
				<c:when test="${not empty rtnSkillData}">
					<c:forEach items="${rtnSkillData}" var="rtnSkillList">
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
			<c:forEach items="${rtnRefmanData}" var="rtnRefmanList"> 
			<tr> 
				<th scope="row"><c:out value="${rtnRefmanList.nm}" /></th> 
				<td><c:out value="${rtnRefmanList.orgnzNm}" /></td> 
				<td><c:out value="${rtnRefmanList.position}" /></td> 
				<td><c:out value="${rtnRefmanList.ref}" /></td> 
				<td><c:out value="${rtnRefmanList.cell}" /></td> 
				<td><c:out value="${rtnRefmanList.email}" /></td> 
				<td><c:out value="${rtnRefmanList.addrFullNm}" /></td> 
			</tr> 
			</c:forEach>
			</tbody> 
		</table>
	</div>

	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<!-- <a href="javascript:fnGoPageUserInfoListBack();" class="bbs_btn list" ><spring:message code="button.list" /></a> -->
			<button type="button" class="bbs_btn list" onclick="fnGoPageUserInfoListBack();"><spring:message code="button.list" /></button>
		</span>
		<span class="bbs_right">
	
		</span>
	</div>
	<!-- //bbs_btn_wrap -->

</form>