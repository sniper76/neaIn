<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/intvwListMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("intvwListMng");
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
		<form id="frmIntvwListMng" >	
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
						<td colspan="3">
							<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="ALL" exceptValue="" disable="true"/>
						</td>
					</tr>					
					<tr>
						<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="searchKeyword" grpCd="SRCH_DIV_CD" drawType="select" initValue="" exceptValue="SDC0000000004,SDC0000000005,SDC0000000006,SDC0000000009" disable=""/>
							<input type="text" id="searchValue" name="searchValue" value= "" />
						</td>
						<th scope="row"><spring:message code="field.dic.usrtype" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="userAuthCd" grpCd="USER_AUTH_CD" drawType="radio" initValue="" exceptValue="ROLE_ADMIN,ROLE_CMPNY,ROLE_TRNCT" disable=""/>
						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.gender" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="genderCd" grpCd="GENDER_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row"><spring:message code="field.dic.vccy.type" /></th>
						<td>								
							<commCode:commcode codeKind="commCode" tagName="employFormCd" grpCd="EMPLOY_FORM_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>						
					</tr>

					<tr>
						<th scope="row"><spring:message code="field.dic.prefernt.vccy.cond" /></th>
						<td>								
							<commCode:commcode codeKind="commCode" tagName="preferntCondCd" grpCd="PREFERNT_COND_CD" drawType="check" initValue="" exceptValue="" disable=""/>
						</td>						
						<th scope="row"><spring:message code="field.dic.accept.yn" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="intvwAgreeYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
 						</td>						
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.intvw.type" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="intvwTypeCd" grpCd="INTVW_TYPE_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
						</td>
						<th scope="row"><spring:message code="field.dic.referral.yn" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="referralYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
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
	<table id="intvwListMngTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
		<colgroup>
			<col style="width:3%;" />
			<col style="width:4%;" />
			<col style="width:9%;" />
			<col style="width:6%;" />
			<col style="width:9%;" />
			<col style="width:7%;" />
			<col style="width:7%;" />
			<col style="width:6%;" />
			<col style="width:9%;" />
			<col style="width:7%;" />
			<col style="width:7%;" />
			<col style="width:8%;" />
			<col style="width:7%;" />
			<col style="width:4%;" />
			<col style="width:8%;" />
			<col style="width:4%;" />
		</colgroup>    
	    <thead>
	        <tr>
	        	<th scope="col"></th>
	            <th scope="col">ROWNUM</th>
	            <th scope="col">기업명<p>(compnyNm)</p></th>
	            <th scope="col">채용공고<p>구분<p>(employFormCd)</p></th>
	            <th scope="col">채용공고명<p>(vacancyTitle)</p></th>
	            <th scope="col">담당이메일<p>(mngerEmail)</p></th>
	            <th scope="col">담당전화<p>(mngerCell)</p></th>
	            <th scope="col">회원구분<p>(userAuthCd)</p></th>
	            <th scope="col">회원명<p>(userNm)</p></th>
	            <th scope="col">이메일<p>(userEmail)</p></th>
	            <th scope="col">휴대폰<p>(userCell)</p></th>
	            <th scope="col">면접일시<p>(intvwDt)</p></th>
	            <th scope="col">면접방법<p>(intvwTypeCd)</p></th>
	            <th scope="col">면접수락여부<p>(intvwAgreeYn)</p></th>
	            <th scope="col">열람일시<p>(intvwOpenDt)</p></th>
	            <th scope="col">알선여부<p>(referralYn)</p></th>
	        </tr>
	    </thead>
	</table>
</div>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<input type="button" id="btnOpenMsgSend" value="선택 열람확인 알림 발송" class="bbs_btn type03 registration">
	</span>	
</div>
 