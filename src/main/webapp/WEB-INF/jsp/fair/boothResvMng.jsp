<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/boothResvMng.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("boothResvMng");
	});
</script>
		
<div class="search_box">
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frmBoothResvMng" >	
		
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
						<td colspan="3">
							<commCode:commcode codeKind="commCode" tagName="searchKeyword" grpCd="SRCH_DIV_CD" drawType="select" initValue="" exceptValue="SDC0000000001,SDC0000000002,SDC0000000003,SDC0000000004,SDC0000000006,SDC000000008,SDC0000000010" disable=""/>
							<input type="text" id="searchValue" name="searchValue" value= "" />
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
	<table id="boothResvMngTable" class="display dataTable bbs_table list" style="word-break: break-all;" >
		<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
			<colgroup>
				<col style="width:5%;" />
				<col style="width:12%;" />
				<col style="width:10%;" />
				<col style="width:8%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
				<col style="width:8%;" />
				<col style="width:10%;" />
			</colgroup>
	    <thead>
	        <tr>
	            <th scope="col">ROWNUM</th>
	            <th scope="col">신청기업/기관<p>(compnyInsttNm)</p></th>
	            <th scope="col">담당자명<p>(mngerNm)</p></th>
	            <th scope="col">전화번호<p>(tel)</p></th>
	            <th scope="col">이메일<p>(email)</p></th>
	            <th scope="col">신청일<p>(boothReqDt)</p></th>
	            <th scope="col">예약상태<p>(resvStsCd)</p></th>
	            <th scope="col">부스지정<p>(boothNm)</p></th>
	        </tr>
	    </thead>
	</table>
</div>