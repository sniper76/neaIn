<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/communityMng/communityMngDetail.js"></script>
<script>
	$(function() {
		common.invoker.invoke("communityMngDetail");
	});
</script>

<div class="tab_obj n5">

	<div class="bbs_basic">
		<form id="frmBulletinThumbReg" method="post" >
			<input type="hidden" id="seq" value="${param.seq }">
			<input type="hidden" id="contentsFlag" value="${param.contentsFlag }">
			<fieldset>
				<h3>기본내용</h3>
				<legend>Write a post</legend>
				<div class="bbs_write_top"><span><span class="exactly y">necessary</span>Necessary</span></div>
				<table class="bbs_table write">
					<caption>{Board name} Write - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트 입력</caption>
					<colgroup>
						<col style="width:15%;" />
						<col style="width:35%;" />
						<col style="width:15%;" />
						<col style="width:35%;" />
					</colgroup>
					<tbody>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for="">제목</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="titleEn" id="titleEn" value="<c:out value="${result.titleEn}" />" disabled="disabled" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for="">작성자</label></th>
						<td><input type="text" name="writerNm" id="writerNm"  value="<c:out value="${result.writerNm}" />" disabled="disabled" /></td>
						<th scope="row"><span class="exactly">necessary</span> <label for="">작성일</label></th>
						<td><input type="text" name="regDate" id="regDate"  value="<c:out value="${result.writeDt}" />" disabled="disabled" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly ">necessary</span> <label for="">노출여부</label></th>
						<td>
							<%-- <commCode:commcode codeKind="commCode" tagName="viewYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="${result.viewYn }" exceptValue="ALL" disable="true"/> --%>
							<c:out value="${result.viewYn }" />
						</td>
						<th scope="row"><span class="exactly ">necessary</span> <label for="">공지여부</label></th>
						<td>
							<%-- <commCode:commcode codeKind="commCode" tagName="ntcYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="${result.ntcYn }" exceptValue="ALL" disable="true"/> --%>
							<c:out value="${result.ntcYn }" />
						</td>
					</tr>
					</tbody>
				</table>
				<!-- //bbs_table write -->
				&nbsp;&nbsp;
				<h3>글내용</h3>
				<table class="bbs_table write">
						<caption>{Board name} Write - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트 입력</caption>
						<colgroup>
							<col style="width:15%;" />
							<col style="width:35%;" />
							<col style="width:15%;" />
							<col style="width:35%;" />
						</colgroup>
						<tbody>
						<tr>
							<th scope="row"><span class="exactly y">necessary</span> <label for="">글내용</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
							<td colspan="3">
								<textarea id="contentEn" name="contentEn" cols="1" rows="1" title="contentEn" class="bbs_write_content" disabled="disabled"><c:out value="${result.content}" /></textarea>
							</td>
						</tr>
						</tbody>
					</table>

				<div class="bbs_btn_wrap clearfix">
					<span class="bbs_left">
						<input type="button" id="btnList" class="bbs_btn list"  value="list" />
					</span>
					<span class="bbs_right">
						<input type="submit" id="btnAgree" value="save" class="bbs_btn save" />
					</span>
				</div>
				<!-- //bbs_btn_wrap -->

			</fieldset>
		</form>

	</div>
	<!-- //bbs_basic write -->

		</div>
		<!-- // n5 -->