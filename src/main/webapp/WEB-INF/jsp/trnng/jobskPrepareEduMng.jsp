<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/trnng/jobskPrepareEduMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("jobskPrepareEduMng");
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
			<input type="hidden" id="eduTrnngSeq" name="eduTrnngSeq" value="" />
			<input type="hidden" id="eduDivCd" name="eduDivCd" value="<c:out value="${EduTrnngMngBean.eduDivCd}" />" />
			<input type="hidden" id="neaEduDivCd" name="neaEduDivCd" value="<c:out value="${EduTrnngMngBean.neaEduDivCd}" />" />
			<input type="hidden" id="periodOn" name="periodOn" value="" />
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
						<td colspan="3">
							<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
<%-- 						
						<th scope="row"><spring:message code="field.dic.vccy.sts" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="recrumtStsCd" grpCd="RECRUMT_STS_CD" drawType="radio" initValue="" exceptValue="RSC0000000001" disable=""/>
						</td>
 --%>												
					</tr>					
					<tr>
						<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
						<td>
							<label for="searchKeyword" class="skip">keyword selection</label>
							<select id="searchKeyword" name="searchKeyword">
								<option value=""><spring:message code="field.dic.select.all" /></option>
								<option value="eduTrnngNm"><spring:message code="field.dic.jobedu.nm" /></option>
								<option value="teacherNm"><spring:message code="field.dic.teacher.nm" /></option>
							</select>
							<label for="searchValue" class="skip"></label>
							<input type="text" id="searchValue" name="searchValue" value= "" />
						</td>
						<th scope="row"><spring:message code="field.dic.area" /></th>
						<td>								
							<label for="addrCd2Depth" class="skip">keyword selection</label>
							<select id="addrCd2Depth" name="addrCd2Depth">
								<option value=""><spring:message code="field.dic.select.all" /></option>
				 				<c:forEach items="${LocCdBean}" var="item" varStatus="status">
				 				<option value="<c:out value=" ${item.dtlCd}" />">
									<c:choose>
										<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
										<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
										<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
									</c:choose>
								</option>
								</c:forEach>
							</select>
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.period" /></th>
						<td colspan="3">
							<span class="date_box" style="padding-right:10px;">
								<label for="periodKeyword" class="skip">기간검색조건</label>
								<select id="periodKeyword" name="periodKeyword">
									<option value="regDt"><spring:message code="field.dic.reg.dt" /></option>
									<option value="teachDt"><spring:message code="field.dic.lecture.dt" /></option>
								</select>							
							</span>
							<span class="period_box">
								<span class="date_box">
									<label for="sDate" class="skip">start date</label>
									<input type="text" id="startDate" name="startDate" class="datepicker" title="Start date Select from calendar" placeholder="start date" />
								</span>
								-&nbsp;
								<span class="date_box">
									<label for="eDate" class="skip">end date</label>
									<input type="text" id="endDate" name="endDate" class="datepicker" title="End date Select from calendar" placeholder="end date" />
								</span>
							</span>
							<span class="period_choose">
								<button type="button" id="today" class="btnPeriod" ><spring:message code="field.dic.today" /></button>
								<button type="button" id="-14D" class="btnPeriod" ><spring:message code="field.dic.2weeks" /></button>
								<button type="button" id="-1M" class="btnPeriod" ><spring:message code="field.dic.1month" /></button>
								<button type="button" id="-3M" class="btnPeriod" ><spring:message code="field.dic.3months" /></button>
								<button type="button" id="-1Y" class="btnPeriod" ><spring:message code="field.dic.1year" /></button>
							</span>
						</td>
					</tr>
					</tbody>
				</table>
				<div class="detail_table">
					<table id="example">
						<caption>Detail Contents Search - </caption>
						
						<tbody>
							
						</tbody>
					</table>
				</div>
				<div class="put_box">
					<button type="button" class="open_detail">Open Detail Search</button>
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_basic">
	<table id="jobskPrepareEduMngTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<%-- <col style="width:3%;" /> --%>
				<col style="width:5%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:15%;" />
				<col style="width:7%;" />
				<col style="width:8%;" />
				<col style="width:7%;" />
				<col style="width:15%;" />
				<col />
			</colgroup>    
	    <thead>
	        <tr>
	            <!-- <th scope="col"></th> -->
	            <th scope="col"><spring:message code="userChg.list.title.no" /></th>
	            <th scope="col"><spring:message code="field.dic.jobedu.nm" /></th>
	            <th scope="col"><spring:message code="field.dic.area" /></th>
	            <th scope="col"><spring:message code="field.dic.teacher.nm" /></th>
	            <th scope="col"><spring:message code="field.dic.lecture.dt" /></th>
	            <th scope="col"><spring:message code="field.dic.recrumt.memb" /></th>
	            <th scope="col"><spring:message code="field.dic.vccy.sts" /></th>
	            <th scope="col"><spring:message code="field.dic.subcribe.cnt" /></th>
	            <th scope="col"><spring:message code="title.sample.regUser" /></th>
	            <th scope="col"><spring:message code="bulletin.dic.regdate" /></th>
	        </tr>
	    </thead>
	</table>
</div>

<div class="bbs_btn_wrap clearfix">
<!-- 
	<span class="bbs_left">
 		<input type="button" id="btnFinish" class="bbs_btn approve"  value="선택마감" />
 		<input type="button" id="btnRecruiting" class="bbs_btn approve"  value="선택모집중" />
 		<input type="button" id="btnDelete" class="bbs_btn delete"  value="선택삭제" />
	</span>
 -->
	<span class="bbs_right">
		<input type="button" id="btnRegist" value="registration" class="bbs_btn type03 registration">
	</span>	
</div>
