<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/jobsk/jobskVacancyDtlInfoModify.js"></script>

<script>
$(function() {
	
	
	$("input:radio[name=jcAgreeStsCd]").click(function(){
    	var jcAgreeStsCd = $('input[name="jcAgreeStsCd"]:checked').val();
    	
		if (jcAgreeStsCd == 'JAS0000000001'){
			$('input[name="vacancyStsCd"]').attr('disabled', false);
		} else {
			$('input[name="vacancyStsCd"]').attr('disabled', true);
		}
			
    });
	
	common.invoker.invoke("jobskVacancyDtlInfoModify");
	commonPopupSet('isco');
	fnDeleteSpan();	
});
</script>

<form id="frmJobskVacancyDtlInfoModify">
<input type="hidden" id="vacancySeq" name="vacancySeq" value="<c:out value="${rtnBase.vacancySeq}" />" />
<input type="hidden" id="jcAgreeStsCdValue" name="jcAgreeStsCdValue" value="<c:out value="${rtnBase.jcAgreeStsCd}" />" />
<input type="hidden" id="vacancyStsCdValue" name="vacancyStsCdValue" value="<c:out value="${rtnBase.vacancyStsCd}" />" />

	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.vccy.dtl.info" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"> <spring:message code="field.dic.vccy.title" /></th>
				<td colspan="3"><c:out value="${rtnBase.vacancyTitle}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.vccy.type" /></th>
				<td><c:out value="${rtnBase.employFormNm}" /></td>
				<th scope="row">
					<spring:message code="field.dic.job.position" /> / 
					<spring:message code="field.dic.job.resp" /></th>
				<td><c:out value="${rtnBase.spot}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.isco" /></th>
				<td>
					<button type="button" id="btnIscoCd" class="bbs_btn type04 vertical_middle popup_isco" onclick="callback(fnSetIsco, 'isco');"><spring:message code="field.dic.isco.select" /></button>
					<span class="text_box" id="span_isco">
						<span class="bbs_add">
							<input type="hidden" class="iscoCd" id="iscoCd" name="iscoCd" value="<c:out value="${rtnBase.iscoCd}" />" >
							<c:out value="${rtnBase.iscoNm}" />
							<button type="button" class="delete">delete</button>
						</span>					
					</span>
				</td>
				<th scope="row"> <spring:message code="field.dic.recrumt.memb" /></th>
				<td><c:out value="${rtnBase.recrumtMemb}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.work.bgn.dt" /></th>
				<td><c:out value="${rtnBase.bgnDt}" /></td>
				<th scope="row"> <spring:message code="field.dic.vccy.close.dt" /></th>
				<td><c:out value="${rtnBase.vacancyCloseDt}" /></td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.work.place" /></th>
				<td colspan="3">
				<c:choose>
					<c:when test="${not empty rtnLoc}">
						<c:forEach items="${rtnLoc}" var="rtnLoclist"> 
						<c:out value="${rtnLoclist.addrFullNm}" /><br> 
					</c:forEach>
					</c:when>
				</c:choose>				
				</td>
			</tr>
			<tr>
				<th scope="row"> <spring:message code="field.dic.recrumt.diffclt.yn" /></th>
				<td colspan="3"><c:out value="${rtnBase.recrumtDiffcltYn}" /></td>
			</tr>			
			</tbody>
		</table>
	</div>

	<h3><spring:message code="field.dic.emp.form" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.emp.form" /></caption> 
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.emply.ctrt.cond" /></th> 
				<td><c:out value="${rtnBase.employCtrctCond}" /></td>
				<th scope="row"> <spring:message code="field.dic.emply.ctrt.type" /></th> 
				<td><c:out value="${rtnBase.employCtrctTypeNm}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.emp.type" /></th> 
				<td colspan="3"><c:out value="${rtnBase.preferEmploymtTypeNm}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.work.morn.time" /></th>
				<td><c:out value="${rtnBase.workMornTime}" /></td>
				<th scope="row"> <spring:message code="field.dic.work.afternn.time" /></th>
				<td><c:out value="${rtnBase.workAfternnTime}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.day.work.time" /></th>
				<td><c:out value="${rtnBase.dayWorkTime}" /></td>
				<th scope="row"> <spring:message code="field.dic.week.work.day" /></th>
				<td><c:out value="${rtnBase.weekWorkDay}" /></td> 
			</tr>
			</tbody> 
		</table>
	</div>
	
	<h3><spring:message code="field.dic.duty.requiremt" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.duty.requiremt" /></caption> 
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.work.night" /></th> 
				<td><c:out value="${rtnBase.nightWorkYn}" /></td>
				<th scope="row"> <spring:message code="field.dic.work.holiday" /></th> 
				<td><c:out value="${rtnBase.hldayWorkYn}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.flex.work" /></th> 
				<td><c:out value="${rtnBase.flexWorkYn}" /></td>
				<th scope="row"> <spring:message code="field.dic.work.overyn" /></th> 
				<td><c:out value="${rtnBase.overWorkYn}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.probt.term" /></th>
				<td><c:out value="${rtnBase.probtDesc}" /></td>
				<th scope="row"> <spring:message code="field.dic.newcomer.trnng" /></th>
				<td><c:out value="${rtnBase.trnngDesc}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.salary" /></th>
				<td colspan="3"><c:out value="${rtnBase.salaryDesc}" /></td> 
			</tr>
			<tr> 
				<th scope="row"> <spring:message code="field.dic.reg.nssf" /></th>
				<td><c:out value="${rtnBase.nssfYn}" /></td>
				<th scope="row"> <spring:message code="field.dic.reg.etc.insu" /></th>
				<td><c:out value="${rtnBase.etcInsuYn}" /></td> 
			</tr>			
			</tbody> 
		</table>
	</div>
		
	<h3><spring:message code="field.dic.requiremt" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.requiremt" /></caption> 
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.min.edu.yn" /></th> 
				<td colspan="3"><c:out value="${rtnBase.minEduDegreeYn}" /></td> 
			</tr> 
			<tr>
			<th scope="row"> <spring:message code="field.dic.min.edu.degree" /></th> 
				<td><c:out value="${rtnBase.minEduDegreeNm}" /></td> 
				<th scope="row"> <spring:message code="field.dic.need.rsch.spcl" /></th> 
				<td><c:out value="${rtnBase.iscedNm}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.pro.licns.yn" /></th>
				<td colspan="3"><c:out value="${rtnBase.prolicnsYn}" /></td>
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.min.work.exp" /></th>
				<td colspan="3"><c:out value="${rtnBase.minWorkExp}" /></td> 
			</tr>
			<tr> 
				<th scope="row"> <spring:message code="field.dic.min.work.expyn" /></th>
				<td><c:out value="${rtnBase.minWorkExpYn}" /></td> 			
				<th scope="row"> <spring:message code="field.dic.need.rlvt.exp" /></th>
				<td><c:out value="${rtnBase.isicNm}" /></td>
			</tr>			
			</tbody> 
		</table>
	</div>
	
	<h3><spring:message code="field.dic.foreign.lang" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.foreign.lang" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<c:choose>
				<c:when test="${empty rtnlang}">
					<th scope="row"> <spring:message code="field.dic.foreignlang.name" /></th> 
					<td></td> 
					<th scope="row"> <spring:message code="field.dic.foreign.lang.lvl" /></th> 
					<td></td> 			
				</c:when>
				<c:when test="${not empty rtnlang}">
					<c:forEach items="${rtnlang}" var="langlist"> 
					<tr> 
						<th scope="row"> <spring:message code="field.dic.foreignlang.name" /></th> 
						<td><c:out value="${langlist.langNm}" /></td> 
						<th scope="row"> <spring:message code="field.dic.foreign.lang.lvl" /></th> 
						<td><c:out value="${langlist.langlvlNm}" /></td> 
					</tr>
					</c:forEach>
				</c:when>
			</c:choose>
			</tbody> 
		</table>
	</div>

	<h3><spring:message code="field.dic.etc.prefer" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.etc.prefer" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.prefer.job.desc" /><br>
				<spring:message code="field.dic.job.desc.ex" /></th> 
				<td colspan="3"><c:out value="${rtnBase.jobDesc}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.job.ref.know" /><br>
				<spring:message code="field.dic.ref.know.ex" /></th> 
				<td colspan="3"><c:out value="${rtnBase.recrumtJobRefKnow}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.work.need.item" /><br>
				<spring:message code="field.dic.need.item.ex" /></th> 
				<td colspan="3"><c:out value="${rtnBase.recrumtJobRefWorkNeedItem}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.etc.prefer" /></th> 
				<td colspan="3"><c:out value="${rtnBase.etc}" /></td> 
			</tr> 
			</tbody> 
		</table>
	</div>

	<h3><spring:message code="field.dic.prefernt.vccy.cond" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.prefernt.vccy.cond" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.prefernt.vccy.cond" /></th> 
				<td colspan="3">
				<c:choose>
					<c:when test="${not empty rtnPrefernt}">
						<c:forEach items="${rtnPrefernt}" var="rtnPreferntlist"> 
						<c:out value="${rtnPreferntlist.preferntCondNm}" /><br>
						</c:forEach>
					</c:when>
				</c:choose>				
				</td> 
			</tr> 
			</tbody> 
		</table>
	</div>
	
	<h3><spring:message code="field.dic.vacancy.dtl.desc" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.vacancy.dtl.desc" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.dtl.desc" /></th> 
				<td colspan="3"><c:out value="${rtnBase.workExpln}" /><br>
				<c:out value="${rtnBase.imgFileGrpSeq}" /></td> 
			</tr> 
			</tbody> 
		</table>
	</div>
	
	<h3><spring:message code="field.dic.applic.mnger" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.applic.mnger" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.resprsnnm" /></th> 
				<td colspan="3"><c:out value="${rtnBase.mngerNm}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.res.prsn.email" /></th> 
				<td><c:out value="${rtnBase.mngerEmail}" /></td>
				<th scope="row"> <spring:message code="field.dic.res.prsn.tel" /></th> 
				<td><c:out value="${rtnBase.mngerCell}" /></td> 
			</tr> 
			</tbody> 
		</table>
	</div>
	
	<h3><spring:message code="field.dic.jc.agreeyn" /></h3>
	<div class="bbs_basic">
		<table class="bbs_table write margin_b_20"> 
			<caption><spring:message code="field.dic.jc.agreeyn" /></caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.signupDt" /></th> 
				<td><c:out value="${rtnBase.applicDt}" /></td>
				<th scope="row"> <spring:message code="field.dic.approveDt" /></th> 
				<td><c:out value="${rtnBase.jcAgreeDt}" /></td> 
			</tr> 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.jc.agreeyn" /></th> 
				<td>
					<commCode:commcode codeKind="commCode" tagName="jcAgreeStsCd" grpCd="JC_AGREE_STS_CD" drawType="radio" initValue="" exceptValue="ALL" disable="" />
				</td>
				<th scope="row"> <spring:message code="field.dic.rsps.prsn" /></th> 
				<td><c:out value="${rtnBase.jcUserNm}" /></td> 
			</tr>
			<tr> 
				<th scope="row"> <spring:message code="field.dic.not.agree.reason" /></th> 
				<td colspan="3">
					<textarea id="agreeRejectReason" name="agreeRejectReason"><c:out value="${rtnBase.agreeRejectReason}" /></textarea>
				</td>
			</tr> 						 
			<tr> 
				<th scope="row"> <spring:message code="field.dic.vccy.sts" /></th> 
				<td colspan="3">
					<commCode:commcode codeKind="commCode" tagName="vacancyStsCd" grpCd="VACANCY_STS_CD" drawType="radio" initValue="" exceptValue="ALL" disable=""/>
				</td>
			</tr> 			
			</tbody> 
		</table>
	</div>	
	
	<!-- //bbs_btn_wrap -->	
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<a href="${pageContext.request.contextPath}/internal/jobsk/jobskVacancyList.do" class="bbs_btn list"><spring:message code="cpes.btn.list" /></a>
		</span>
		<span class="bbs_right">
			<button type="button" class="bbs_btn delete" onclick="btnJobskVacancyDelete();"><spring:message code="cpes.btn.delete" /></button>
			<button type="button" class="bbs_btn save" onclick="btnJobskVacancyDtlInfoSave();"><spring:message code="cpes.btn.save" /></button>
		</span>
	</div>
	<!-- //bbs_btn_wrap -->

</form>