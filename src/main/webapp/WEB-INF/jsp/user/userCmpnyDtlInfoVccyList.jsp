<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userCmpnyDtlInfoVccyList.js"></script>

<script>
$(function() {
	common.invoker.invoke("userCmpnyDtlInfoVccyList");
});
</script>

<form id="frmUserDtlInfoProfile">
<input type="hidden" id="compnySeq" name="compnySeq" value="<c:out value="${rtnCompnySeq}" />" />

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="myTable" class="bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col />
			<col style="width:10%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col />
			<col />
			
		</colgroup>
		<thead>
		<tr>
			<th scope="col">No</th>
			<th scope="col"><spring:message code="field.dic.vccy.no" /></th>
			<th scope="col"><spring:message code="field.dic.vccy.type" /></th>
			<th scope="col"><spring:message code="field.dic.vccy.title" /></th>
			<th scope="col"><spring:message code="field.dic.period" /></th>
			<th scope="col"><spring:message code="field.dic.jc.agreeyn" /></th>
			<th scope="col"><spring:message code="field.dic.reg.dt" /></th>
			<th scope="col"><spring:message code="field.dic.close.dt" /></th>
			<th scope="col"><spring:message code="field.dic.vccy.sts" /></th>
			<th scope="col"><spring:message code="field.dic.recrumt.memb" /></th>
			<th scope="col"><spring:message code="field.dic.applic.tot" /></th>
			<th scope="col"><spring:message code="field.dic.pass.join" /></th>
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