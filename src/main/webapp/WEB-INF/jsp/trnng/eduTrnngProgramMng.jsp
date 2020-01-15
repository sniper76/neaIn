<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/trnng/eduTrnngProgramMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("eduTrnngProgramMng");
	});
</script>

<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
/*아이콘(icon) 위치*/
img.ui-datepicker-trigger{cursor:pointer; margin-left:5px;}
.dataTables_wrapper .dt-buttons {
  float:right;
  width: 50%;
  text-align:right;
}

</style>

<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmEduTrnngProgramMng" >
			<input type="hidden" id="eduTrnngSeq" name="eduTrnngSeq" value="" />
			<input type="hidden" id="eduDivCd" name="eduDivCd" value="<c:out value="${EduTrnngMngBean.eduDivCd}" />" />
			<input type="hidden" id="insttSeq" name="insttSeq" value="" />
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
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
						<td>
							<label for="searchKeyword" class="skip">keyword selection</label>
							<select id="searchKeyword" name="searchKeyword">
								<option value="">All</option>
								<option value="insttNmKh"><spring:message code="field.dic.insttnm" />(kh)</option>
								<option value="insttNmEn"><spring:message code="field.dic.insttnm" />(en)</option>
								<option value="eduTrnngNm"><spring:message code="field.dic.trnng.nm" /></option>
							</select>
							<label for="searchValue" class="skip"></label>
							<input type="text" id="searchValue" name="searchValue" value= "" />
						</td>
						<th scope="row"><spring:message code="field.dic.trnng.div" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="trnngNatnexpDivCd" grpCd="TRNNG_NATNEXP_DIV_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.instttype" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="insttTypeCd" grpCd="INSTT_TYPE_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row">프로그램/코스유형</p></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="pcTypeCd" grpCd="PC_TYPE_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.edu.major" /></th>
						<td>
							<label for="major1DepthCd" class="skip">status selection</label>
							<select id="major1DepthCd" name="major1DepthCd">
								<option value="">All</option>
							</select>
							<label for="major2DepthCd" class="skip">status selection</label>
							<select id="major2DepthCd" name="major2DepthCd">
								<option value="">All</option>
							</select>							
						</td>
						<th scope="row"><spring:message code="field.dic.jc.agreeyn" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="jcAgreeStsCd" grpCd="JC_AGREE_STS_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.vccy.sts" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="recrumtStsCd" grpCd="RECRUMT_STS_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row"><spring:message code="field.dic.insttownership" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="insttOwnershipCd" grpCd="INSTT_OWNERSHIP_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row">기술/직업훈련<p>프로그램/코스</p></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="tvcDivCd" grpCd="TVC_DIV_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row">고등/일반<p>교육 프로그램</p></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="hgepDivCd" grpCd="HGEP_DIV_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>					
					<tr>
						<th scope="row"><spring:message code="field.dic.period" /></th>
						<td colspan="3">
							<span class="date_box" style="padding-right:10px;">
								<label for="periodKeyword" class="skip">기간검색조건</label>
								<select id="periodKeyword" name="periodKeyword">
									<option value="regDt"><spring:message code="field.dic.signupDt" /></option>
									<option value="recurmtDt"><spring:message code="field.dic.recurmt.term" /></option>
									<option value="eduDt"><spring:message code="field.dic.edu.term" /></option>
									<option value="jcAgreeDt"><spring:message code="field.dic.jcAgree.dt" /></option>
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
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->

<div class="bbs_basic">
	<table id="eduTrnngProgramMngTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:3%;" />
				<col style="width:5%;" />
				<col style="width:15%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
				<col style="width:7%;" />
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
	            <th scope="col">ROWNUM</th>
	            <th scope="col">insttNm</th>
	            <th scope="col">trnngNatnexpDivCd</th>
	            <th scope="col">eduTrnngNm</th>
	            <th scope="col">skillJobProgramCorsCd</th>
	            <th scope="col">addrCd</th>
	            <th scope="col">recurmtBgnDt~recurmtEndDt</th>
	            <th scope="col">eduBgnDt~eduEndDt</th>
	            <th scope="col">jcAgreeStsCd</th>
	            <th scope="col">recrumtStsCd</th>
	            <th scope="col">regDt</th>
	            <th scope="col">jcAgreeDt</th>
	            <th scope="col">jcUserNm</th>
	        </tr>
	    </thead>
	</table>
</div>
<!-- 
<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
 		<input type="button" id="btnVerify"  class="bbs_btn approve"  value="선택승인" />
 		<input type="button" id="btnReject"  class="bbs_btn approve"  value="선택반려" />
 		<input type="button" id="btnFinish" class="bbs_btn approve"  value="선택마감" />
 		<input type="button" id="btnRecruiting" class="bbs_btn approve"  value="선택모집중" />
	</span>
</div>
 -->