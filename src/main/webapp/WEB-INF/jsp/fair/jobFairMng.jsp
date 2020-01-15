<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/jobFairMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("jobFairMng");
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
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmJobFairMng" >	
			<input type="hidden" id="fairSeq" name="fairSeq" value="" />
			<input type="hidden" id="periodOn" name="periodOn" value="" />

			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.subject.center" /></th>
						<td colspan="3">
							<label for="neaJcDiv" class="skip">keyword selection</label>
							<select id="neaJcDiv" name="neaJcDiv" >
								<option value="">All</option>
								<option value="nea"><spring:message code="nea.user.mng.nea" /></option>
								<option value="jc"><spring:message code="field.dic.jobcntr" /></option>
							</select>
							<label for="jcCd" class="skip">keyword selection</label>
							<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="ALL" exceptValue="" disable="true"/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
						<td>
							<label for="searchKeyword" class="skip">keyword selection</label>
							<select id="searchKeyword" name="searchKeyword">
								<option value="">All</option>
								<option value="fairNm"><spring:message code="field.dic.fair.name" /></option>
								<option value="regUserNm"><spring:message code="title.sample.regUser" /></option>
							</select>
							<label for="searchValue" class="skip"></label>
							<input type="text" id="searchValue" name="searchValue" value= "" />
						</td>
						<th scope="row"><spring:message code="field.dic.fair.div" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="fairDivCd" grpCd="FAIR_DIV_CD" drawType="select" initValue="ALL" exceptValue="" disable=""/>								
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.fair.status" /></th>
						<td colspan="3">
							<commCode:commcode codeKind="commCode" tagName="fairStsCd" grpCd="FAIR_STS_CD" drawType="radio" initValue="ALL" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.area" /></th>
						<td>
							<label for="addrCd1Depth" class="skip">keyword selection</label>
							<select id="addrCd1Depth" name="addrCd1Depth">
								<option value="">All</option>
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
						<th scope="row"><spring:message code="course.list.title.viewyn" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="fairViewYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="ALL" exceptValue="" disable=""/>
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.period" /></th>
						<td colspan="3">
							<span class="date_box" style="padding-right:10px;">
								<label for="periodKeyword" class="skip"><spring:message code="field.dic.fair.period.search.cond" /></label>
								<select id="periodKeyword" name="periodKeyword">
									<option value="regDt"><spring:message code="field.dic.reg.dt" /></option>
									<option value="recurmtDt"><spring:message code="field.dic.recurmt.term" /></option>
									<option value="fairDt"><spring:message code="field.dic.fair.term" /></option>
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
								<button type="button" id="today" class="btnPeriod" >Today</button>
								<button type="button" id="-14D" class="btnPeriod" >2Week</button>
								<button type="button" id="-1M" class="btnPeriod" >1Month</button>
								<button type="button" id="-3M" class="btnPeriod" >3Month</button>
								<button type="button" id="-1Y" class="btnPeriod" >1Year</button>
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
					<input type="button" value="<spring:message code="button.search" />" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_basic">
	<table id="jobFairMngTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<%-- <col style="width:3%;" /> --%>
				<col style="width:5%;" />
				<col style="width:7%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:13%;" />
				<col style="width:13%;" />
				<col style="width:8%;" />
				<col style="width:6%;" />
				<col style="width:10%;" />
				<col />
			</colgroup>    
	    <thead>
	        <tr>
	            <!-- <th scope="col"></th> -->
	            <th scope="col">No</th>
	            <th scope="col"><spring:message code="fair.list.fair.div" /></th>
	            <th scope="col"><spring:message code="fair.list.fair.nm" /></th>
	            <th scope="col"><spring:message code="field.dic.area" /></th>
	            <th scope="col"><spring:message code="fair.list.mng.div" /></th>
	            <th scope="col"><spring:message code="field.dic.subject.center" /></th>
	            <th scope="col"><spring:message code="field.dic.recurmt.term" /></th>
	            <th scope="col"><spring:message code="fair.list.fair.dura" /></th>
	            <th scope="col"><spring:message code="field.dic.fair.status" /></th>
	            <th scope="col"><spring:message code="title.sample.useYn" /></th>
	            <th scope="col"><spring:message code="bulletin.dic.regdate" /></th>
	            <th scope="col"><spring:message code="title.sample.regUser" /></th>
	        </tr>
	    </thead>
	</table>
</div>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_right">
		<input type="button" id="btnRegist" value="registration" class="bbs_btn type03 registration">
	</span>	
</div>
