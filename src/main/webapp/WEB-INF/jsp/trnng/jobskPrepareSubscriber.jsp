<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/trnng/jobskPrepareSubscriber.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("jobskPrepareSubscriber");
	});
</script>

<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
/*아이콘(icon) 위치*/
img.ui-datepicker-trigger{cursor:pointer; margin-left:5px;}
.dataTables_wrapper .dt-buttons { float:right; width: 50%; text-align:right; }
</style>

<div class="search_box">
	<div class="top_box clearfix">
		<h3>Contents Search</h3>
	</div>
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmJobskPrepareEduMng" >
			<input type="hidden" id="eduTrnngSeq" name="eduTrnngSeq" value="<c:out value="${EduTrnngMngBean.eduTrnngSeq}" />" />
			<input type="hidden" id="eduDivCd" name="eduDivCd" value="<c:out value="${EduTrnngMngBean.eduDivCd}" />" />
			<input type="hidden" id="neaEduDivCd" name="neaEduDivCd" value="<c:out value="${EduTrnngMngBean.neaEduDivCd}" />" />
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row">직업지원 교육명</th>
						<td colspan="3">
							<c:out value="${EduTrnngMngBean.eduTrnngNm}" />
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="title.sample.description" /></th>
						<td colspan="3">
							<c:out value="${EduTrnngMngBean.content}" />
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.period" /></th>
						<td>
							<c:out value="${EduTrnngMngBean.teachDt}" />&nbsp;<c:out value="${EduTrnngMngBean.teachBgnHour}" />:<c:out value="${EduTrnngMngBean.teachBgnMinute}" />&nbsp;<c:out value="${EduTrnngMngBean.teachBgnAmpm}" />&nbsp;~&nbsp;<c:out value="${EduTrnngMngBean.teachEndHour}" />:<c:out value="${EduTrnngMngBean.teachEndMinute}" />&nbsp;<c:out value="${EduTrnngMngBean.teachEndAmpm}" />
						</td>						
						<th scope="row"><spring:message code="field.dic.recrumt.memb" /></th>
						<td>
							<c:out value="${EduTrnngMngBean.recrumtMemb}" />
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.trnng.place" /></th>
						<td colspan="3">
							<c:out value="${EduTrnngMngBean.area}" />
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

<div class="bbs_basic">
	<table id="jobskPrepareSubscriberTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<%-- <col style="width:3%;" /> --%>
				<col style="width:5%;" />
				<col style="width:12%;" />
				<col style="width:15%;" />
				<col style="width:15%;" />
				<col style="width:10%;" />
				<col style="width:5%;" />
				<col style="width:5%;" />
				<col style="width:7%;" />
				<col style="width:15%;" />
				<col />
			</colgroup>    
	    <thead>
	        <tr>
	            <!-- <th scope="col"></th> -->
	            <th scope="col">ROWNUM</th>
	            <th scope="col">일반<p>(userAuth)</p></th>
	            <th scope="col">회원명(userNm)</p></th>
	            <th scope="col">이메일(email)</th>
	            <th scope="col">휴대전화<p>(cell)</p></th>
	            <th scope="col">연령<p>(recrumtMemb)</p></th>
	            <th scope="col">성별<p>(recrumtStsCd)</p></th>
	            <th scope="col">구직상태<p>(subscriberCnt)</p></th>
	            <th scope="col">신청일시<p>(regDt)</p></th>
	            <th scope="col">합격여부<p>(regUserNm)</p></th>
	        </tr>
	    </thead>
	</table>
</div>

<div class="bbs_btn_wrap clearfix">
	<!-- 
	<span class="bbs_left">
 		<input type="button" id="btnAgree" class="bbs_btn approve"  value="선택합격" />
 		<input type="button" id="btnReject" class="bbs_btn approve"  value="선택불합격" />
	</span>
 	-->
</div>
