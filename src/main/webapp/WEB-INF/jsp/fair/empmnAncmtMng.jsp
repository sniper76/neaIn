<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/empmnAncmtMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("empmnAncmtMng");
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
	<div class="contents_box">
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row">채용행사 선택</th>
						<td colspan="3"><input type="button" id="btnFairChoose" value="행사선택" class="bbs_btn type03 registration" /><span id="spanFairNm"></span></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
	</div>
</div>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmEmpmnAncmtMng" >	
			<input type="hidden" id="fairSeq" name="fairSeq" value="" />
			<input type="hidden" id="periodOn" name="periodOn" value="" />
			<input type="hidden" id="mstJcCd" name="mstJcCd" value="<c:out value=" ${FairMngBean.mstJcCd}" />" />
			
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
						<td>
							<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="ALL" exceptValue="" disable="true"/>
						</td>
						<th scope="row"><spring:message code="field.dic.area" /></th>
						<td>
							<select id="addrCd2Depth" name="addrCd2Depth">
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
					</tr>					
					<tr>
						<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="searchKeyword" grpCd="SRCH_DIV_CD" drawType="select" initValue="" exceptValue="SDC0000000001,SDC0000000004,SDC0000000006,SDC0000000009,SDC0000000010" disable=""/>
							<input type="text" id="searchValue" name="searchValue" value= "" />
						</td>
						<th scope="row"><spring:message code="field.dic.vccy.type" /></th>
						<td>								
							<commCode:commcode codeKind="commCode" tagName="employFormCd" grpCd="EMPLOY_FORM_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.vccy.sts" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="vacancyStsCd" grpCd="VACANCY_STS_CD" drawType="radio" initValue="ALL" exceptValue="" disable=""/>
						</td>
						<th scope="row"><spring:message code="field.dic.jc.agreeyn" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="jcAgreeStsCd" grpCd="JC_AGREE_STS_CD" drawType="radio" initValue="ALL" exceptValue="" disable=""/>
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.concil.req" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="recrumtDiffcltYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="ALL" exceptValue="" disable=""/>
						</td>
						<th scope="row"><spring:message code="field.dic.prefernt.vccy.cond" /></th>
						<td>								
							<commCode:commcode codeKind="commCode" tagName="preferntCondCd" grpCd="PREFERNT_COND_CD" drawType="check" initValue="" exceptValue="" disable=""/>
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.period" /></th>
						<td colspan="3">
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
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_basic">
	<table id="empmnAncmtMngTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:7%;" />
			<col style="width:9%;" />
			<col style="width:11%;" />
			<col style="width:11%;" />
			<col style="width:9%;" />
			<col style="width:8%;" />
			<col style="width:7%;" />
			<col style="width:8%;" />
			<col style="width:9%;" />
			<col style="width:6%;" />
			<col style="width:10%;" />
		</colgroup>    
	    <thead>
	        <tr>
	            <th scope="col">ROWNUM</th>
	            <th scope="col">공고번호<p>(vacancyCertNo)</p></th>
	            <th scope="col">공고TYPE<p>(employFormCd)</p></th>
	            <th scope="col">기업명<p>(compnyNm)</p></th>
	            <th scope="col">채용공고제목<p>(vacancyTitle)</p></th>
	            <th scope="col">기간<p>(bgnDt~endDt)</p></th>
	            <th scope="col">신청일시<p>(regDt)</p></th>
	            <th scope="col">모집상태<p>(vacancyStsCd)</p></th>
	            <th scope="col">승인일시<p>(jcAgreeDt)</p></th>
	            <th scope="col">승인여부<p>(jcAgreeStsCd)</p></th>
	            <th scope="col">모집인원<p>(recrumtMemb)</p></th>
	            <th scope="col">관할JC<p>(jcCd)</p></th>
	        </tr>
	    </thead>
	</table>
</div>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_right">
		<input type="button" id="btnRegist" value="채용공고매핑" class="bbs_btn type03 registration">
	</span>	
</div>
 