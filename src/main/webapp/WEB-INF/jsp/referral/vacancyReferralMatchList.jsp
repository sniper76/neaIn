<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/referral/vacancyReferralMatchList.js"></script>

<script>
var resumeCntMsg 	= '<spring:message code="alert.message.resume.seq" text="Success"></spring:message>';
var oneDepthMsg 	= '<spring:message code="referral.occup.blank.onedepth" text="Success"></spring:message>';
var twoDepthMsg 	= '<spring:message code="referral.occup.blank.twodepth" text="Success"></spring:message>';
var threeDepthMsg 	= '<spring:message code="referral.occup.blank.threedepth" text="Success"></spring:message>';
var fourDepthMsg 	= '<spring:message code="referral.occup.blank.fourdepth" text="Success"></spring:message>';
var provinceMsg 	= '<spring:message code="referral.loc.blank.province" text="Success"></spring:message>';
var districtMsg 	= '<spring:message code="referral.loc.blank.district" text="Success"></spring:message>';
var wageMsg 	= '<spring:message code="referral.wage.blank" text="Success"></spring:message>';
var eduMsg 	= '<spring:message code="referral.edu.blank" text="Success"></spring:message>';

	$(function() {
		common.invoker.invoke("vacancyReferralMatchList");
	});
</script>
<div class="search_box">
	<div class="top_box clearfix">
		<h3><spring:message code="field.dic.vacancy.match" /></h3>
	</div>
	<input type="hidden" id="userAuth" name="userAuth" value="<c:out value="${userAuth.neaJcDivCd}" />" />
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
				<input type="hidden" id="hidVacancySeq" name="hidVacancySeq" value="<c:out value="${ReferralMatchBean.vacancySeq}" />" />
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<colgroup>
						<col style="width:12%;" />
						<col style="width:38%;" />
						<col style="width:12%;" />
						<col style="width:38%;" />
					</colgroup>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.search.cmpny" /></th>
						<td colspan="3">
							<button type="button" value="popup" class="bbs_btn list" onclick="popreferralCmpnySearchLayerBtn();"><spring:message code="button.search" /></button>
						</td>
					</tr>
					
					</tbody>
				</table>
				<div class="detail_table">
						<table class="bbs_table">
								<caption>Profile - Name, Member Type, Nobile No, E-mail, Job search status, Address</caption>
								<colgroup>
									<col style="width:10%;" />
									<col style="width:15%;" />
									<col style="width:24%;" />
									<col style="width:15%;" />
									<col style="width:24%;" />
									<col />
								</colgroup>
								<tbody>
								<tr>
									<td rowspan="4" style="vertical-align:middle;">
										<div class="text_center"><img src="../../images/board/dummy_cmny.png" alt=" image" /></div>
									</td>
									<th scope="row"><spring:message code="field.dic.compny" /></th>
									<td>
										<input type="text" id="compnyNm" value="<c:out value="${ReferralMatchBean.compnyNm}" />" readonly="true">
									</td>
									<th scope="row"><spring:message code="field.dic.compny.tel" /></th>
									<td>
										<input type="text" id="mngerTel" value="<c:out value="${ReferralMatchBean.mngerTel}" />" readonly="true">
									</td>
									<td rowspan="4" style="vertical-align:middle;">
										<button type="button" value="search" class="bbs_btn" onclick="detailCompnyView();"><spring:message code="field.dic.detailview" /></button>
									</td>
								</tr>
								<tr>
									<th scope="row"><spring:message code="field.dic.resprsnnm" /></th>
									<td>
										<input type="text" id="mngerNm" value="<c:out value="${ReferralMatchBean.mngerNm}" />" readonly="true">
									</td>
									<th scope="row"><spring:message code="field.dic.res.prsn.tel" /></th>
									<td>
										<input type="text" id="mngerCell" value="<c:out value="${ReferralMatchBean.mngerCell}" />" readonly="true">
									</td>
								</tr>
								<tr>
									<th scope="row"><spring:message code="userChg.list.title.address" /></th>
									<td colspan="3">
										<input type="text" id="addrNm" value="<c:out value="${ReferralMatchBean.addrNm}" />" readonly="true">
									</td>
								</tr>
								</tbody>
							</table>
					</div>
				<div class="put_box">
					<button type="button" class="open_detail">Open Detail Search</button>  
					<input type="button" value="Referral Matching" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
			<!-- Selected hidden value -->
 		</form>
 		<form id="frmParam">
			 <input type="hidden" id="compnySeq" name="compnySeq" value="<c:out value="${ReferralMatchBean.compnySeq}" />
			 
			 <input type="hidden" id="userSeq" name="userSeq" value="" />
			 <input type="hidden" id="previousUrl" name="previousUrl" value="" />
 		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->
<div class="detail_table">
	<form id="frmMatchParam">
		<table class="bbs_table">
				<caption>Profile - Name, Member Type, Nobile No, E-mail, Job search status, Address</caption>
				<colgroup>
					<col style="width:12%;" />
					<col style="width:55%;" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row"><spring:message code="referral.match.title.occup" /></th>
						<td>
							<select id="oneDepth" name="oneDepth" title="oneDepth" style="width: 24%;"> 
									<option value="">1 Depth</option>
								<c:forEach items="${oneDepth}" var="item" varStatus="status">
									<option value="<c:out value="${item.iscoId}"/>" <c:if test="${item.iscoId eq ReferralMatchBean.oneDepth}"> selected="selected" </c:if> >
									<c:out value="${item.cateNm}" />
									</option>
								</c:forEach>
							</select>
							<select id="twoDepth" name="twoDepth" title="twoDepth" style="width: 24%;">
								
									<option value="${ReferralMatchBean.twoDepth}"><c:out value="${ReferralMatchBean.twoDepthNm}" /></option>
								
							</select>
							<select id="threeDepth" name="threeDepth" title="threeDepth" style="width: 24%;">
								
									<option value="${ReferralMatchBean.threeDepth}"><c:out value="${ReferralMatchBean.threeDepthNm}" /></option>
								
							</select>
							<select id="fourDepth" name="fourDepth" title="fourDepth" style="width: 24%;">
								
									<option value="${ReferralMatchBean.fourDepth}"><c:out value="${ReferralMatchBean.fourDepthNm}" /></option>
								
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="referral.match.title.loc" /></th>
						<td>
							<select id="province" name="province" title="province" style="width: 24%;"> 
									<option value="">Province</option>
								<c:forEach items="${provin}" var="item" varStatus="status">
									<option value="<c:out value="${item.lvlCd}"/>" <c:if test="${item.lvlCd eq ReferralMatchBean.province}"> selected="selected" </c:if> >
									<c:out value="${item.nm}" />
									</option>
								</c:forEach>
							</select>
							<select id="district" name="district" title="district" style="width: 24%;"> 
									<option value="${ReferralMatchBean.district}"><c:out value="${ReferralMatchBean.distNm}" /></option>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="referral.match.title.wage" /> </th>
						<td>
							<input type="text" id="wage" value="${ReferralMatchBean.salary}" >&nbsp;$
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="referral.match.title.edu" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="minEduDegreeCd" grpCd="MIN_EDU_DEGREE_CD" drawType="radio" initValue="${ReferralMatchBean.edu}" exceptValue="ALL" disable=""/>
						</td>
					</tr>
				</tbody>
		</table>
	</form>
</div>

<!-- Data List Zone: Start -->
<div class="bbs_basic">
	<table id="vacancyReferralMatch" class="bbs_table list">
		<caption>Data List Zone</caption>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:5%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:5%;" />
			<col style="width:5%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:8%;" />
			<col style="width:15%;" />
			<col style="width:8%;" />
		</colgroup>
		<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col">No</th>		
			<th scope="col"><spring:message code="referral.match.title.occup" /></th>
			<th scope="col"><spring:message code="referral.match.title.loc" /></th>
			<th scope="col"><spring:message code="referral.match.title.edu" /></th>
			<th scope="col"><spring:message code="referral.match.title.wage" /></th>
			<th scope="col"><spring:message code="search.name" /></th>
			<th scope="col"><spring:message code="userChg.list.title.gender" /></th>
			<th scope="col"><spring:message code="userChg.list.title.age" /></th>			
			<th scope="col"><spring:message code="field.dic.mobile" /></th>
			<th scope="col"><spring:message code="userChg.list.title.email" /></th>
			<th scope="col"><spring:message code="field.dic.resume.title" /></th>
			<th scope="col">Manage</th>
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<!-- //Data List Zone: End -->
<!--  
<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<input type="button" value="Select Approve" id="btnApprove" class="bbs_btn type06" />
		<input type="button" value="Select Return" id="btnReturn" class="bbs_btn type06" />
		<input type="button" value="Select Not Seeking" id="btnNotSeeking" class="bbs_btn type06" />
	</span>
</div>
-->