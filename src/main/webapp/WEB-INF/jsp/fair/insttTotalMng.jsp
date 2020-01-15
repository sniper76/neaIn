<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/insttTotalMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("insttTotalMng");
	});
</script>

<style>
.dataTables_wrapper .dt-buttons { float:right; width: 50%; text-align:right; }
</style>

<div class="search_box">
	<div class="contents_box">
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row">채용행사 선택</th>
						<td colspan="3">
							<input type="button" id="btnFairChoose" value="행사선택" class="bbs_btn type03 registration" />
							<input type="hidden" id="fairSeq" name="fairSeq" value="" />
							<span id="spanFairNm"></span>
						</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
	</div>
</div>
<!-- //search_box -->

<div class="bbs_tab action">
	<ul class="clearfix">
		<li class="on"><a href="#" id="tabInsttJoinMng" name="tabInsttJoinMng" >참가기관(insttJoin)</a></li>
		<li><a href="#" id="tabInsttReqestMng" name="tabInsttReqestMng" >신청기관(insttReqest)</a></li>
		<li><a href="#" id=tabInsttInviteMng name="tabInsttInviteMng" >초청기관(insttInvite)</a></li>
	</ul>
</div>
<div id="totalInsttMngDiv"></div>
