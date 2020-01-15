<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/jobCenterMapAddr.js"></script>
<script>
	$(function() {
		common.invoker.invoke("jobCtMapAddr");
	});
</script>

<div class="search_box">
	<div class="top_box clearfix">
		<h3>금지어 관리</h3>
	</div>
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
				<input type="hidden" id="banwordtxt" name="banwordtxt" value=""/>
				<input type="hidden" id="banwordSeq" name="banwordSeq" value=""/>
			<fieldset>
				<legend>Bulletin Management Search</legend>
				<table>
					<caption>Bulletin Management Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row">검색</th>
						<td>
							<label for="" class="skip"></label>
							<input type="text" id="keyword" name="keyword"/>
							<input type="button" value="SEARCH" id="btnSearch" class="bbs_btn type03" />
						</td>
					</tr>
					<tr>
						<th scope="row">금지어</th>
						<td>
							<label for="" class="skip"></label>
							<input type="text" id="banword" name="banword" value=""/>
							<button type="button" value="save" class="bbs_btn save" onclick="insertBanWordConf();">등록</button>
						</td>
					</tr>
					
					</tbody>
				</table>
				
			</fieldset>
		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->


<table id="banwordList" class="display dataTable bbs_table list">
	<caption>{Board name} Write - 금지어, No, 금지어, 등록일, 수정일, 수정</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:8%;" />
			<col style="width:45%;" />
			<col style="width:15%;" />
			<col style="width:15%;" />
			<col style="width:10%;" />
		</colgroup>
    <thead>
        <tr>
			<th scope="col"></th>
			<th scope="col">No</th>
            <th scope="col">금지어</th>
            <th scope="col">등록일</th>
            <th scope="col">수정일</th>
            <th scope="col">수정</th>
        </tr>
    </thead>
</table>
<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<input type="button" value="삭제" id="btnDelete" class="bbs_btn type06" />
	</span>
</div>