<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/compnyInviteMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("compnyInviteMng");
	});
</script>

<div class="search_box">
	<div class="contents_box">
		<fieldset>
			<legend>Contents Search</legend>
			<table>
				<caption>Contents Search - Search, User Type, Period</caption>
				<tbody>
				<tr>
					<th scope="row"><spring:message code="field.dic.job.fair" /> <spring:message code="bulletin.select.select" /></th>
					<td colspan="3"><input type="button" id="btnFairChoose" value="<spring:message code="field.dic.fair.select" />" class="bbs_btn type03 registration" />&nbsp;&nbsp;<span id="spanFairNm"></span></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
</div>
<!-- //search_box -->	
<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmCompnyInviteMng" >	
		<input type="hidden" name="fairSeq" id="fairSeq" value="${fairMngBean.fairSeq }"/>
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
						<td colspan="3">
							<commCode:commcode codeKind="jcCode" tagName="mstJcCd" grpCd="" drawType="select" initValue="" exceptValue="" disable="true"/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="searchKeyword" grpCd="SRCH_DIV_CD" drawType="select" initValue="" exceptValue="SDC0000000004,SDC0000000005,SDC0000000006,SDC0000000007,SDC0000000008,SDC0000000009,SDC0000000010" disable=""/>
							<input type="text" id="searchValue" name="searchValue" value= "" />
						</td>
						<th scope="row"><spring:message code="field.dic.compny.type" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="compnyTypeCd" grpCd="COMPNY_TYPE_CD" drawType="select" initValue="" exceptValue="" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><spring:message code="field.dic.sector" /></th>
						<td>
							<select id="sectorCd" name="sectorCd">
								<option value="">전체</option>
							</select>
						</td>
						<th scope="row"><spring:message code="field.dic.jc.agreeyn" /></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="jcAgreeStsCd" grpCd="JC_AGREE_STS_CD" drawType="radio" initValue="" exceptValue="" disable=""/>
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
<div class="search_box">
	<div class="contents_box">
		<fieldset>
			<legend>Contents Search</legend>
			<table>
				<tbody>
				<tr>
					<td scope="row" style="text-align:center"><a href="javascript:void(0);" onclick="compnyJoinMng.fn.pageActionPartici();"><spring:message code="field.dic.fair.compny.view" /></a></td>
					<td scope="row" style="text-align:center"><a href="javascript:void(0);" onclick="compnyJoinMng.fn.pageActionRequest();"><spring:message code="field.dic.intvw.compny.name" /></a></td>
					<td scope="row" style="text-align:center"><a href="javascript:void(0);" onclick="compnyJoinMng.fn.pageActionInvite();"><spring:message code="field.dic.invite.compny.name" /></a></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
</div>
<div class="bbs_basic">
	<table id="compnyInviteMngTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:5%;" />
				<col style="width:7%;" />
				<col style="width:12%;" />
				<col style="width:10%;" />
				<col style="width:13%;" />
				<col style="width:10%;" />
				<col style="width:6%;" />
				<col style="width:9%;" />
				<col style="width:10%;" />	
				<col style="width:10%;" />
				<col style="width:9%;" />
			</colgroup>
	    <thead>
	        <tr>
	            <th scope="col">No</th>
	            <th scope="col"><spring:message code="field.dic.compny.type" /></th>
	            <th scope="col"><spring:message code="field.dic.compny.name" /></th>
	            <th scope="col"><spring:message code="field.dic.resprsnnm" /></th>
	            <th scope="col"><spring:message code="userChg.list.title.email" /></th>
	            <th scope="col"><spring:message code="userChg.list.title.cell" /></th>
	            <th scope="col"><spring:message code="field.dic.booth.req.yn" /></th>
	            <th scope="col"><spring:message code="field.dic.signupDt" /></th>
	            <th scope="col"><spring:message code="field.dic.controll.center" /></th>
	            <th scope="col"><spring:message code="field.dic.invite.mnger.nm" /></th>
	            <th scope="col"><spring:message code="field.dic.invite.dt" /></th>
	        </tr>
	    </thead>
	</table>
</div>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_right">
		<input type="button" id="btnCompnyInvite" value="기업 초청하기" class="bbs_btn type03 registration">
	</span>	
</div>
