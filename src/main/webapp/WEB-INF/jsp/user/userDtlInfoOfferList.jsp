<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/userDtlInfoOfferList.js"></script>

<script>
$(function() {
	common.invoker.invoke("userDtlInfoOfferList");
});
</script>

<form id="frmUserDtlInfoOffer">
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnUserSeq}" />" />

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="myTable" class="bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col />
			<col />
			<col />
			
		</colgroup>
		<thead>
		<tr>
			<th scope="col">No</th>
			<th scope="col"><spring:message code="field.dic.company.name" /></th>
			<th scope="col"><spring:message code="field.dic.resprsnnm" /></th>
			<th scope="col"><spring:message code="field.dic.res.prsn.email" /></th>
			<th scope="col"><spring:message code="field.dic.res.prsn.tel" /></th>
			<th scope="col"><spring:message code="field.dic.resume.title" /></th>
			<th scope="col"><spring:message code="field.dic.offer.dt" /></th>
			<th scope="col"><spring:message code="field.dic.open.yn" /></th>
			<th scope="col"><spring:message code="field.dic.open.dttm" /></th>
			<th scope="col"><spring:message code="field.dic.aplc.yn" /></th>
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
		<button type="button" class="bbs_btn list" onclick="fnGoPageUserInfoListBack();"><spring:message code="button.list" /></button>
	</span>
</div>
<!--   //bbs_btn_wrap -->

</form>