<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userCmpnyDtlInfoOfferList.js"></script>

<script>
$(function() {
	common.invoker.invoke("userCmpnyDtlInfoOfferList");
});
</script>

<form id="frmUserCmpnyDtlInfoOffer">
<input type="hidden" id="compnySeq" name="compnySeq" value="<c:out value="${rtnCompnySeq}" />" />

<div class="search_box">
	<div class="contents_box">
		<fieldset>
			<legend>Contents Search</legend>
			<table>
				<caption>Contents Search - Search, User Type, Period</caption>
				<colgroup>
					<col style="width:12%;" />
					<col style="width:38%;" />
					<col style="width:12%;" />
					<col style="width:38%;" />
				</colgroup>
				<tbody>
				<tr>
					<th scope="row"><spring:message code="field.dic.vccy.year" /></th>
					<td><input type="text" id="vacancyYear" name="vacancyYear" onkeyup="getVccyList();"/></td>
					<th scope="row"><label for="vacancyList"><spring:message code="field.dic.compny.vccy" /></label></th>
					<td>
						<select id="vacancyList" name="vacancyList">
							<c:forEach items="${rtnVccyData}" var="rtnVccyList">
							<option value='<c:out value="${rtnVccyList.vacancySeq}" />' >
								<c:out value="${rtnVccyList.vacancyTitle}" />
							</option>
							</c:forEach>
						</select>
					</td>					
				</tr>
				<tr>
					<th scope="row"><label for="vacancyList"><spring:message code="field.dic.close.yn" /></label></th>
					<td colspan="3">
						<label for="vacancyStsCd" class="skip">vacancy close code</label>
						<commCode:commcode codeKind="commCode" tagName="vacancyStsCd" grpCd="VACANCY_STS_CD" drawType="radio" initValue="" exceptValue="" disable=""/>					
					</td>					
				</tr>									
				</tbody>
			</table>
			<div class="put_box"> 
				<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
			</div>
		</fieldset>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="myTable" class="bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col />
			<col />
			<col />
			<col />
			<col />			
			
		</colgroup>
		<thead>
		<tr>
			<th scope="col">No</th>
			<th scope="col"><spring:message code="field.dic.name" /></th>
			<th scope="col"><spring:message code="field.dic.age" /></th>
			<th scope="col"><spring:message code="field.dic.gender" /></th>
			<th scope="col"><spring:message code="field.dic.resume.title" /></th>
			<th scope="col"><spring:message code="field.dic.edu.level" /></th>
			<th scope="col"><spring:message code="field.dic.career.info" /></th>
			<th scope="col"><spring:message code="field.dic.edu.major" /></th>
			<th scope="col"><spring:message code="field.dic.open.stauts" /></th>
			<th scope="col"><spring:message code="field.dic.aplc.yn" /></th>
			<th scope="col"><spring:message code="field.dic.signupDt" /></th>
			<th scope="col"><spring:message code="field.dic.vccy.title" /></th>
			<th scope="col"></th>
			<th scope="col"></th>
			<th scope="col"></th>
			<th scope="col"></th>
			
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<!-- //Data List Zone: End -->

<!--   //bbs_btn_wrap -->
<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<button type="button" class="bbs_btn list" onclick="fnGoPageCompnyInfoListBack();"><spring:message code="button.list" /></button>
	</span>
</div>
<!--   //bbs_btn_wrap -->

</form>