<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/boothRegMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("boothRegMng");
	});
</script>

<form id="frmBoothRegMng" >

<div class="bbs_basic margin_b_20">
	<table class="bbs_table write">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="boothTel"><spring:message code="field.dic.tel" /></label></th>
			<td><input type="text" id="boothTel"  name="boothTel" value="" required /></td>
			<th scope="row"><span class="exactly y">necessary</span><label for="boothEmail"><spring:message code="field.dic.email" /></label></th>
			<td><input type="text" id="boothEmail"  name="boothEmail" value="" required /></td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="boothFeeExpln"><spring:message code="field.dic.booth.use.pay.method" /></label></th>
			<td colspan="3"><textarea id="boothFeeExpln" name="boothFeeExpln" cols="30" rows="4" title="Contents" required ></textarea></td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table write -->
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->
<h1>USE/TOTAL: <span id="boothUseCnt">0</span>/<span id="boothTotalCnt">0</span></h1>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table">
		<caption>table name - table explain</caption>
		<colgroup>
			<col style="width:20%;">
			<col style="width:20%;">
			<col style="width:10%;">
			<col style="width:20%;">
			<col style="width:20%;">
			<col style="width:10%;">
		</colgroup>
		<thead>
		<tr>
			<th scope="col"><span class="exactly y">necessary</span><spring:message code="field.dic.booth.nm" /></th>
			<th scope="col"><span class="exactly y">necessary</span><spring:message code="field.dic.booth.use.pay" />($)</th>
			<th scope="col"><spring:message code="title.sample.useYn" /></th>
			<th scope="col"><span class="exactly y">necessary</span><spring:message code="field.dic.booth.nm" /></th>
			<th scope="col"><span class="exactly y">necessary</span><spring:message code="field.dic.booth.use.pay" />($)</th>
			<th scope="col"><spring:message code="title.sample.useYn" /></th>
		</tr>
		</thead>
		<tbody id="boothLoop" ></tbody>
	</table>

	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_right">
			<input type="button" id="btnAddBooth" value="Add Booth" class="bbs_btn type03" />
			<input type="button" id="btnReset" value="Reset" class="bbs_btn type06" />
			<input type="submit" id="btnSubmit" value="Save" class="bbs_btn save" />
		</span>
	</div>
</div>
</form>


