<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/info/bulletinFaq.js"></script>
<script>
	$(function() {
		common.invoker.invoke("bulletinFaq");
	});
</script>

<div class="search_box">
	<div class="top_box clearfix">
		<h3>Bulletin FAQ</h3>
	</div>
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmBulletinFaq">
			<input type="hidden" name="bulletinSeq" id="bulletinSeq" value=""/>		
			<input type="hidden" name="programId" id="programId" value="<c:out value="${BulletinBean.programId}" />" />
			<input type="hidden" name="bulletinTypeCd" id="bulletinTypeCd" value="<c:out value="${BulletinBean.bulletinTypeCd}" />" />
			<fieldset>
				<legend>Bulletin FAQ Search</legend>
				<table>
					<caption>Bulletin FAQ Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row">Keyword</th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<select id="Keyword_sel">
								<option value="">select</option>
								<option value="1">Bulletin Name</option>
								<option value="2">Content</option>
								<option value="3">Register</option>
							</select>
							<label for="keyword" class="skip"></label>
							<input type="text" id="keyword" />
						</td>
					</tr>
					<tr>
						<th scope="row">노출여부</th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<commCode:commcode codeKind="commCode" tagName="viewYn" grpCd="FIELD_YN_CD" drawType="select" initValue="ALL" exceptValue="" disable=""/>
						</td>
						
					</tr>
					<tr>
						<th scope="row">Period</th>
						<td colspan="3">
							<span class="period_box">
								<span class="date_box">
									<label for="startDate" class="skip">start date</label>
									<input type="text" id="startDate" name="startDate" class="datepicker" title="Start date Select from calendar" placeholder="start date" />
								</span>
								-&nbsp;
								<span class="date_box">
									<label for="endDate" class="skip">end date</label>
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
					<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
				</div>
			</fieldset>
		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->


<table id="bulletinFaqTable" class="display dataTable bbs_table list">
	<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
		<colgroup>
			<col style="width:3%;" />
			<col style="width:30%;" />
			<col style="width:8%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col />
		</colgroup>
    <thead>
        <tr>
			<th scope="col"></th>
			<th scope="col">제목</th>
            <th scope="col">노출여부</th>
            <th scope="col">첨부파일</th>
            <th scope="col">작성자</th>
            <th scope="col">좋아요 수</th>
            <th scope="col">조회수</th>
			<th scope="col">등록일</th>
			<th scope="col">공지여부</th>
        </tr>
    </thead>
</table>

<div class="bbs_btn_wrap clearfix">
	<span class="bbs_left">
		<input type="button" value="공지글 등록" id="btnNotiAdd" class="bbs_btn type06" />
		<input type="button" value="공지글 해제" id="btnNotiRm" class="bbs_btn type06" />
	</span>
	<span class="bbs_right">
		<input type="button" id="btnRegist" value="registration"  class="bbs_btn type03 registration"  />
	</span>
</div>