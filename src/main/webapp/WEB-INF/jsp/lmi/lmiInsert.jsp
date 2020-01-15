<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/lmi/lmiInsert.js"></script>

<script>
$(function() {
	common.invoker.invoke("lmiInsert");
});
</script>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
			<fieldset>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<colgroup>
						<col style="width:20%;" />
						<col style="width:80%;" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">Year</th>
							<td colspan="3">
								<input type="text" id="year" name="year" class="inputNo">
							</td>
						</tr>
						<tr>
							<th scope="row">지표명</th>
							<td colspan="3">
								<input type="text" id="indicItemNm" name="indicItemNm">
							</td>
						</tr>
						<tr>
							<th scope="row">depth</th>
							<td colspan="3">
								<select id="depth" name="depth">
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">상위 지표</th>
							<td colspan="3">
								<select id="depth_1" name="depth_1" style="display: none;">
									<option>select</option>
								</select>
								<select id="depth_2" name="depth_2" style="display: none;">
									<option>select</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<!-- Selected hidden value -->
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
	</span>
	<span class="bbs_right">
		<button type="button" id="btnSave" class="bbs_btn save" >저장</button>
	</span>
</div>