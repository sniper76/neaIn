<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/info/bulletinFaqReg.js"></script>
<script>
	$(function() {
		common.invoker.invoke("bulletinFaqReg");
	});
</script>

<div class="tab_obj n5">
        
	<div class="bbs_basic">
		<form id="frmBulletinFaqReg" method="post" >
			<!-- To-Do 게시판관리번호 정의 필요 -->
			<input type="hidden" name="programId" id="programId" value="<c:out value="${BulletinBean.programId}" />" />
			<input type="hidden" name="bulletinTypeCd" id="bulletinTypeCd" value="<c:out value="${BulletinBean.bulletinTypeCd}" />" />
			<input type="hidden" name="fileYn" id="fileYn" value="<c:out value="${BulletinBean.fileYn}" />" />
			<input type="hidden" name="fileSize" id="fileSize" value="<c:out value="${BulletinBean.fileSize}" />" />
			<input type="hidden" name="fileCnt" id="fileCnt" value="<c:out value="${BulletinBean.fileCnt}" />" />
			<input type="hidden" name="likeYn" id="likeYn" value="<c:out value="${BulletinBean.likeYn}" />" />
				
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
						<th scope="row"><span class="exactly y">necessary</span> <label for="">제목(Khmer)</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="titleKh" id="titleKh" value="<c:out value="${BulletinBean.titleKh}" />" required /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for="">제목(English)</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="titleEn" id="titleEn" value="<c:out value="${BulletinBean.titleEn}" />" required /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for="">카테고리</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<select id="bulletinCateSeq" name="bulletinCateSeq" title="bulletinCateSeq">
				 			<c:forEach items="${BulletinCateBean}" var="item" varStatus="status">
								<option value="${item.bulletinCateSeq}"><c:out value="${item.bulletinCateNm}" /></option>	
							</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for="">작성자</label></th>
						<td><input type="text" name="writerNm" id="writerNm"  value="<c:out value="${BulletinBean.writerNm}" />"  disabled="disabled" /></td>
						<th scope="row"><span class="exactly">necessary</span> <label for="">작성일</label></th>
						<td><input type="text" name="regDate" id="regDate"  value="<c:out value="${BulletinBean.writeDt}" />"  disabled="disabled" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly ">necessary</span> <label for="">노출여부</label></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="viewYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="N" exceptValue="ALL" disable=""/>
						</td>
						<th scope="row"><span class="exactly ">necessary</span> <label for="">공지여부</label></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="ntcYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="N" exceptValue="ALL" disable=""/>
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
							<th scope="row"><span class="exactly y">necessary</span> <label for="">글내용(Khmer)</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
							<td colspan="3">
								<textarea id="contentKh" name="contentKh" cols="1" rows="1" title="contentKh" class="bbs_write_content" required><c:out value="${BulletinBean.contentKh}" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><span class="exactly y">necessary</span> <label for="">글내용(English)</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
							<td colspan="3">
								<textarea id="contentEn" name="contentEn" cols="1" rows="1" title="contentEn" class="bbs_write_content" required><c:out value="${BulletinBean.contentEn}" /></textarea>
							</td>
						</tr>
						<tr id="attFile">
							<th scope="row"><span class="exactly y">necessary</span> <label for="">첨부파일</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
							<td colspan="3">
								<input type="file" name="files[]" multiple />
							</td>
						</tr>
						</tbody>
					</table>
				
				<div class="bbs_btn_wrap clearfix">
					<span class="bbs_left">
						<input type="button" id="btnList" class="bbs_btn list"  value="list"  />
					</span>
					<span class="bbs_right">
						<input type="submit" id="btnSubmit" value="save" class="bbs_btn save" />
					</span>
				</div>
				<!-- //bbs_btn_wrap -->
	
			</fieldset>
		</form>
	
	</div>
	<!-- //bbs_basic write -->
	
		</div>
		<!-- // n5 -->