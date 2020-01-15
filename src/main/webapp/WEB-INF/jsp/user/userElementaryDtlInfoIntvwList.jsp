<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userElementaryDtlInfoIntvwList.js"></script>

<script>
$(function() {
	common.invoker.invoke("userElementaryDtlInfoIntvwList");
});
</script>

<form id="frmUserElementaryDtlInfoIntvw">
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnUserSeq}" />" />
<input type="hidden" id="intvwHisSeq" name="intvwHisSeq" value="" />

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="myTable" class="bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col />
			<col />
			<col />
			<col />		
			<col style="width:10%;" />
			<col />
			<col style="width:15%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
		</colgroup>
		<thead>
		<tr>
			<th scope="col">No</th>
			<th scope="col"></th>
			<th scope="col"></th>
			<th scope="col"></th>
			<th scope="col"></th>
			<th scope="col"><spring:message code="field.dic.intvw.dt" /></th>
			<th scope="col"><spring:message code="field.dic.company.name" /></th>
			<th scope="col"><spring:message code="field.dic.compny.addr" /></th>
			<th scope="col"><spring:message code="field.dic.controll.center" /></th>
			<th scope="col"><spring:message code="field.dic.reg.user" /></th>
			<th scope="col"><spring:message code="field.dic.reg.date" /></th>
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
		<a href="${pageContext.request.contextPath}/internal/user/userElementaryInfoList.do" class="bbs_btn list" ><spring:message code="button.list" /></a>
	</span>
	<span class="bbs_right">
		<button type="button" id="btnUserIntvwHisReg" class="bbs_btn save" onclick="fnUserIntvwHisReg();"><spring:message code="field.dic.intvw.his.reg" /></button>
	</span>	
</div>
<!--   //bbs_btn_wrap -->

</form>