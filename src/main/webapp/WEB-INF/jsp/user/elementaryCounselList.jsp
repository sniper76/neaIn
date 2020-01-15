<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/counselList.js"></script>
<script>
	var method = '<c:out value="${param.method}" />' == '' ? 'online' : ('<c:out value="${param.method}" />').toLowerCase();
	$(function() {
		common.invoker.invoke("counselList");
	});
</script>

<div class="search_box">
	<!--div class="top_box clearfix">
		<h3>Contents Search</h3>
		<a href="" class="btn_registration">User Registration</a>
	</div-->
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmCourse" >
			<input type="hidden" id="counselSeq" name="counselSeq" value="" />
			<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${rtnUserSeq}" />" />
			<input type="hidden" id="counselCateDivCd" name="counselCateDivCd" value="<c:out value="${CounselBean.counselCateDivCd}" />" />
			<input type="hidden" id="counselMethodDivCd" name="counselMethodDivCd" value="<c:out value="${CounselBean.counselMethodDivCd}" />" />
			<input type="hidden" id="periodOn" name="periodOn" value="" />
			
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_basic">
	<table id="counselTable" class="display dataTable bbs_table list">
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:3%;" />
				<col style="width:20%;" />
				<col style="width:10%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col />
			</colgroup>    
	    <thead>
	        <tr>
	            <th scope="col"></th>
	            <th scope="col">counselTargetCd</th>
	            <th scope="col">qustTitle</th>
	            <th scope="col">counselStsCd</th>
	            <th scope="col">secretYn</th>
	            <th scope="col">파일</th>
	            <th scope="col">userNm</th>
	            <th scope="col">likeCnt</th>
	            <th scope="col">viewCnt</th>
	            <th scope="col">qustRegDt</th>
	        </tr>
	    </thead>
	</table>
</div>

<div class="put_box" style="text-align:right;">
	<span class="bbs_left">
		<a href="#" class="bbs_btn list" onclick="fnGoPageUserInfoListBack();"><spring:message code="button.list" /></a>
	</span>
		
	<button type="button" class="bbs_btn type03" onclick="insertElemtryCounselReg();"><spring:message code="button.create" /></button>
	
</div>
