<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/menuMngReg.js"></script>
<script>
//defined screen message
var confirmMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="Do you want save?"></spring:message>';
var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	
	
var menunmkhblank	=	'<spring:message code="menu.menunm.kh.blank" text=""></spring:message>';
var menunmenblank	=	'<spring:message code="menu.menunm.en.blank" text=""></spring:message>';
var menuonedepth	=	'<spring:message code="menu.menulvl.one.blank" text=""></spring:message>';
var menutwodepth	=	'<spring:message code="menu.menulvl.two.blank" text=""></spring:message>';
var menutherrdepth	=	'<spring:message code="menu.menulvl.three.blank" text=""></spring:message>';
var menuurldepth	=	'<spring:message code="menu.menuurl.blank" text=""></spring:message>';
var menusortdepth	=	'<spring:message code="menu.menusort.blank" text=""></spring:message>';
var menuprogramblank		= '<spring:message code="menu.menuprogram.blank" text=""></spring:message>';
var menupriprogramblank		= '<spring:message code="menu.menuprogram.blank" text=""></spring:message>';
var pwdFailCntBlank = '<spring:message code="user.regist.password.blank.error" text="Enter password Fail Count"></spring:message>';
var deleteConfirmMsg = '<spring:message code="cpes.delete.btn.confirm.msg" text="Do you want delete?"></spring:message>';
	$(function() {
		common.invoker.invoke("menuMngReg");
	});
	
</script>

<div id="contents">
	<form name="frm" id="frm" method="post">
	<input type="hidden" name="upperMenuCd" 				id="upperMenuCd" value="${menu.upperMenuCd }"/>
	<input type="hidden" name="fullMenuCd"		 			id="fullMenuCd" value="${menu.fullMenuCd }"/>
	<input type="hidden" name="useYn"		 				id="useYn" value="${menu.useYn }"/>
	<input type="hidden" name="priProgramSeq" 				id="priProgramSeq" value=""/>
	<input type="hidden" name="programSeqArr"				id="programSeqArr" value=""/>
	<input type="hidden" name="menuCd"						id="menuCd" value="${menu.menuCd }"/>
	<input type="hidden" name="rangeCd"						id="rangeCd" value="${menu.rangeCd}"/>
	
		<h3><spring:message code="Title.user.base.info" text="Base Information" /></h3>
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
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="menu.menunm.kh" text="Member Type."></spring:message></th>
				<td colspan="3"><input type="text" maxlength="50" value="${menu.menuNmKh }" name="menuNmKh" id="menuNmKh" size="50"/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="menu.menunm.en" text="Job Center"></spring:message></th>
				<td colspan="3"><input type="text" maxlength="50" value="${menu.menuNmEn }" name="menuNmEn" id="menuNmEn" size="50"/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="menu.menunm.depth" text="Depth"></spring:message></th>
				<td colspan="3">
					<select id="menuLvl" name="menuLvl" onChange="drawUpperMenu(this.value);">
						<option value="1" <c:if test="${menu.menuLvl eq 1 }">selected</c:if>>1</option>
						<option value="2" <c:if test="${menu.menuLvl eq 2 }">selected</c:if>>2</option>
						<option value="3" <c:if test="${menu.menuLvl eq 3 }">selected</c:if>>3</option>
						<option value="4" <c:if test="${menu.menuLvl eq 4 }">selected</c:if>>4</option>
					</select>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="menu.menunm.upper.menuid" text="E-mail"></spring:message></th>
				<td colspan="3" id="selMenuTd">
					<div id="selMenu1Div"></div>
					<div id="selMenu2Div"></div>
					<div id="selMenu3Div"></div>
					<div id="selMenu4Div"></div>
				</td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="menu.menunm.menuid" text="Menu ID."></spring:message></th>
				<td colspan="3">
					<c:choose>
					<c:when test="${menu.menuCd ne null && menu.menuCd ne ''}">
					${menu.menuCd }
					</c:when>
					<c:otherwise>
					Auto Creation.
					</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<!-- tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="menu.menunm.url" text="Menu URL" /></span></th>
				<td colspan="3"><input type="text" value="${menu.menuUrl}" name="menuUrl" id="menuUrl" maxlength="100" size="80"/></td>
			</tr-->
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="menu.menunm.sort" text="Menu Sort" /></span></th>
				<td colspan="3"><input type="text" value="${menu.menuSort}" name="menuSort" id="menuSort" onKeyUp="onlyNumberCommon(this);" maxlength="2" size="3"/></td>
			</tr>
			<tr>
				<th scope="row"><span class="exactly y">necessary</span><spring:message code="menu.menunm.programmap" text="ProgramMap"/></span></th>
				<td colspan="3" id="programTd"></td>
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
					${menu.regNm }
				</td>
				<th scope="row"><spring:message code="field.dic.reg.dt" text="Regist Date" /></th>
				<td>
					${menu.regDt }
				</td>
			</tr>
			</tbody>
		</table>

		
		<!-- //bbs_table write -->

		<div class="bbs_btn_wrap clearfix">
			<span class="bbs_left">
				<c:choose>
				<c:when test="${menu.rangeCd eq 'RNG0000000003'}">
					<a href="${pageContext.request.contextPath}/internal/common/menuMngExternalList.do" class="bbs_btn list"><spring:message code="cpes.btn.list" text="List" /></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/internal/common/menuMngInternalList.do" class="bbs_btn list"><spring:message code="cpes.btn.list" text="List" /></a>
				</c:otherwise>
				</c:choose>
				
			</span>
			<span class="bbs_right">
				<a class="bbs_btn save" id="saveBtn"><spring:message code="cpes.btn.save" text="Save" /></a>
				<c:if test="${menu.menuCd ne null && menu.menuCd ne '' }">
					<a class="bbs_btn delete" id="deleteMenuBtn"><spring:message code="cpes.btn.del" text="Delete" /></a>
				</c:if>
			</span>
		</div>
		<!-- //bbs_btn_wrap -->
	</form>
</div>

<%@ include file="/WEB-INF/jsp/common/programLayer.jsp" %>

<script>
$(document).ready(function(){
	var menuVal = $("#menuLvl").val();
	$("#upperMenuCd").val("");
	
	<c:choose>
	<c:when test="${menu.menuLvl ne null &&  menu.menuLvl != ''}">
	// UPPER MENU INIT (Inquiry Value)
	initSetDrawUpperMenu(${menu.menuLvl});
	</c:when>
	<c:otherwise>
	// default init
	drawUpperMenu(0);
	</c:otherwise>
	</c:choose>
	
	
	// mapping program init
	<c:choose>
	<c:when test="${menu.menuProgramMapList ne null &&  fn:length(menu.menuProgramMapList) > 0}">
	<c:forEach var="item" items="${menu.menuProgramMapList }" varStatus="status">
		addModProgram('${item.programSeq }','${item.priProgramYn }','${item.programNm}');
	</c:forEach>
	</c:when>
	<c:otherwise>
		addOneProgram();
	</c:otherwise>
	</c:choose>
	
});
</script>