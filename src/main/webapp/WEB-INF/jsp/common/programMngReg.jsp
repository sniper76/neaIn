<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/programMngReg.js"></script>
<script>
//defined screen message
var confirmMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="Do you want save?"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';

var programnmkhblank	=	'<spring:message code="program.programtitle.kh.blank" text=""></spring:message>';
var programnmenblank	=	'<spring:message code="program.programtitle.en.blank" text=""></spring:message>';
var programurlblank		=	'<spring:message code="program.programurl.blank" text=""></spring:message>';

var deleteConfirmMsg = '<spring:message code="cpes.delete.btn.confirm.msg" text="Do you want delete?"></spring:message>';

	$(function() {
		common.invoker.invoke("programMngReg");
	});
	
</script>

<div id="contents">
	<form name="frm" id="frm" method="post">
	<input type="hidden" name="upperMenuCd" 				id="upperMenuCd" value="" />
	<input type="hidden" name="fullMenuCd"		 			id="fullMenuCd" value="" />
	<input type="hidden" name="useYn"		 				id="useYn" value="" />
	<input type="hidden" name="priProgramSeq" 				id="priProgramSeq" value="" />
	<input type="hidden" name="programSeqArr"				id="programSeqArr" value="" />
	<input type="hidden" name="programSeq"					id="programSeq" value="${program.programSeq }" />
	<input type="hidden" name="rangeCd"						id="rangeCd" value="${program.rangeCd}" />
	
		<table class="bbs_table write margin_b_30">
			<caption>Profile - Name, Member Type, Nobile No, E-mail, Job search status, Address</caption>
			<colgroup>
				<col style="width:15%;" />
				<col style="width:35%;" />
				<col style="width:15%;" />
				<col style="width:35%;" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="program.programtitle.id" text="Program ID."></spring:message></th>
				<td colspan="3">
				<c:choose>
				<c:when test="${program.programId ne null && program.programId ne ''}">
				${program.programId }
				</c:when>
				<c:otherwise>
				<spring:message code="program.id.auto.txt" text="Auto Creation."></spring:message>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="program.programtitle.nm.kh" text="Program Name(KH)"></spring:message></th>
				<td colspan="3"><input type="text" maxlength="100" value="${program.programNmKh }" name="programNmKh" id="programNmKh" size="100"/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="program.programtitle.nm.en" text="Program Name(EN)"></spring:message></th>
				<td colspan="3"><input type="text" maxlength="100" value="${program.programNmEn }" name="programNmEn" id="programNmEn" size="100"/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="menu.menunm.url" text="Program URL" /></span></th>
				<td colspan="3"><input type="text" value="${program.programUrl}" name="programUrl" id="programUrl" maxlength="100" size="120"/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="title.sample.useYn" text="USE"></spring:message></th>
				<td colspan="3">
				<commCode:commcode codeKind="commCode" tagName="useYnTemp" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
				</td>
			</tr>
			<tr>
				<th scope="row"><spring:message code="title.sample.regUser" text="Register" /></th>
				<td>
					${program.regNm }
				</td>
				<th scope="row"><spring:message code="field.dic.reg.dt" text="Regist Date" /></th>
				<td>
					${program.regDt }
				</td>
			</tr>
			</tbody>
		</table>
		
		<!-- //bbs_table write -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<c:choose>
				<c:when test="${program.rangeCd eq 'RNG0000000003'}">
					<a href="${pageContext.request.contextPath}/internal/common/programMngExternalList.do" class="bbs_btn list"><spring:message code="cpes.btn.list" text="List" /></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/internal/common/programMngInternalList.do" class="bbs_btn list"><spring:message code="cpes.btn.list" text="List" /></a>
				</c:otherwise>
				</c:choose>
			</span>
			<span class="bbs_right">
				<a class="bbs_btn save" id="saveBtn"><spring:message code="cpes.btn.save" text="Save" /></a>
				<c:if test="${program.programSeq ne null && program.programSeq ne '' }">
					<a class="bbs_btn delete" id="delBtn"><spring:message code="cpes.btn.del" text="Delete" /></a>
				</c:if>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</form>
</div>