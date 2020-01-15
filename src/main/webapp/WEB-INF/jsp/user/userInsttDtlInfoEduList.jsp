<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userInsttDtlInfoEduList.js"></script>

<script>
$(function() {
	common.invoker.invoke("userInsttDtlInfoEduList");
});
</script>

<form id="frmUserInsttDtlInfoEdu">
<input type="hidden" id="insttSeq" name="insttSeq" value="<c:out value="${rtnInsttSeq}" />" />

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="myTable" class="bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col />
			<col style="width:8%;" />
			<col style="width:6%;" />
			<col style="width:6%;" />
			<col style="width:8%;" />
			<col />
			<col style="width:6%;" />
			<col style="width:6%;" />
			<col style="width:5%;" />
			<col />
			<col />
			
		</colgroup>
		<thead>
		<tr>
			<th scope="col">No</th>
			<th scope="col"><spring:message code="field.dic.trnng.id" /></th>
			<th scope="col"><spring:message code="field.dic.trnng.div" /></th>
			<th scope="col"><spring:message code="field.dic.trnng.nm" /></th>
			<th scope="col"><spring:message code="field.dic.recurmt.term" /></th>
			<th scope="col"><spring:message code="field.dic.reg.dt" /></th>
			<th scope="col"><spring:message code="field.dic.close.dt" /></th>
			<th scope="col"><spring:message code="field.dic.edu.term" /></th>
			<th scope="col"><spring:message code="field.dic.trnng.place" /></th>
			<th scope="col"><spring:message code="field.dic.jc.agreeyn" /></th>
			<th scope="col"><spring:message code="field.dic.bkmk.cnt" /></th>
			<th scope="col"><spring:message code="field.dic.srch.cnt" /></th>
			<th scope="col"></th>
			<th scope="col"></th>
			
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<!-- //Data List Zone: End -->

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<button type="button" class="bbs_btn list" onclick="fnGoPageUserInsttInfoListBack();"><spring:message code="button.list" /></button>
	</span>
</div>


</form>