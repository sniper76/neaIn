<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/bulletin/bulletinThumbMod.js"></script>
<script>
	var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
	var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';
	var deleteMsg 	= '<spring:message code="cpes.save.btn.delete.msg" text="delete"></spring:message>';
	var modifyMsg 	= '<spring:message code="cpes.save.btn.modify.msg" text="Modify"></spring:message>';
	var notiMsg 	= '<spring:message code="bulletin.notice.limit" text="NotifiCation"></spring:message>';

	var titleKhBlank 	= '<spring:message code="bulletin.title.kh.blank" text="NotifiCation"></spring:message>';
	var titleEnBlank 	= '<spring:message code="bulletin.title.en.blank" text="NotifiCation"></spring:message>';
	var contentEnBlank 	= '<spring:message code="bulletin.content.en.blank" text="NotifiCation"></spring:message>';
	var contentKhBlank 	= '<spring:message code="bulletin.content.kh.blank" text="NotifiCation"></spring:message>';

	var fileYn = '${bulletinMngInfo.fileYn }';
	$(function() {
		common.invoker.invoke("bulletinMNGList");
	});
</script>
<%--
<c:out value="${bulletinMngSeq}" />
 --%>

<div class="tab_obj n5">

	<div class="bbs_basic">
		<form id="frm" method="post" >
				<input type="hidden" name="bulletinSeq" id="bulletinSeq" value="<c:out value="${bulletinSeq}" />" />
			<input type="hidden" name="programId" id="programId" value="${programId }" />
			<input type="hidden" name="contentKh" id="contentKh" value="" />
			<input type="hidden" name="contentEn" id="contentEn" value="" />
			<input type="hidden" id="commonUploadResult" name="uploadResult">
				<fieldset>
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
								<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.title.kh" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
								<td colspan="3"><input type="text" name="titleKh" id="titleKh" size="80" maxlength="300" value="${bulletinInfo.titleKh }" /></td>
							</tr>
							<tr>
									<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.title.en" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
								<td colspan="3"><input type="text" name="titleEn" id="titleEn" size="80" maxlength="300" value="${bulletinInfo.titleEn }" /></td>
							</tr>
							<tr>
									<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="bulletin.select.register" /></label></th>
								<td><input type="text" name="writerNm" id="writerNm" size="30" value="${bulletinInfo.writerNm }" disabled="disabled" /></td>
								<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="bulletin.dic.regdate" /></label></th>
								<td><input type="text" name="writeDt" id="writeDt" size="30" value="${bulletinInfo.writeDt }" disabled="disabled" /></td>
							</tr>
							<tr>
									<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="bulletin.dic.likecnt" /></label></th>
								<td><input type="text" name="likeCnt" id="likeCnt" size="30" value="${bulletinInfo.likeCnt }" disabled="disabled" /></td>
								<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="bulletin.dic.viewcnt" /></label></th>
								<td><input type="text" name="viewCnt" id="viewCnt" size="30" value="${bulletinInfo.viewCnt }" disabled="disabled" /></td>
							</tr>
							<tr>
									<th scope="row"><span class="exactly ">necessary</span> <label for=""><spring:message code="bulletin.dic.viewyn" /></label></th>
								<td>
									<commCode:commcode codeKind="commCode" tagName="viewYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="${bulletinInfo.viewYn }" exceptValue="ALL" disable="true"/>
								</td>
								<th scope="row"><span class="exactly ">necessary</span> <label for=""><spring:message code="bulletin.dic.notiyn" /></label></th>
								<td>
									<commCode:commcode codeKind="commCode" tagName="ntcYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="${bulletinInfo.ntcYn }" exceptValue="ALL" disable="true"/>
								</td>
							</tr>
							</tbody>
						</table>
						<!-- //bbs_table write -->
						&nbsp;&nbsp;
						<h3><spring:message code="bulletin.dic.content" /></h3>
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
										<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.content.kh" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
									<td colspan="3">
										<textarea id="contentKhTxt" name="contentKhTxt" cols="1" rows="1" title="contentKh" class="bbs_write_content"><c:out value="${bulletinInfo.contentKh}" escapeXml="false" /></textarea>
									</td>
								</tr>
								<tr>
										<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.content.en" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
									<td colspan="3">
										<textarea id="contentEnTxt" name="contentEnTxt" cols="1" rows="1" title="contentEn" class="bbs_write_content"><c:out value="${bulletinInfo.contentEn}" escapeXml="false" /></textarea>
									</td>
								</tr>
								<c:if test="${bulletinMngInfo.fileYn eq 'Y' }">
									<tr id="attFile">
										<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.file" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
										<td colspan="3">
											<input type="hidden" id="fileGrpSeq" name="fileGrpSeq" value="${bulletinInfo.fileGrpSeq }">
											<div id="dext5uploadArea"></div>
										</td>
									</tr>
								</c:if>
								</tbody>
							</table>

					<div class="bbs_btn_wrap clearfix">
						<span class="bbs_left">
							<button type="button" class="bbs_btn list" onclick="forList();"><spring:message code="cpes.btn.list" /></button>
						</span>
						<span class="bbs_right">
							<button type="button" value="save" class="bbs_btn modify" onclick="updateBulletinBasicConf();"><spring:message code="cpes.btn.modify" /></button>
							<button type="button" value="delete" class="bbs_btn delete" onclick="deleteBulletinBasicConf();"><spring:message code="cpes.btn.delete" /></button>
							<!--input type="submit" value="Modify" class="bbs_btn modify" />
							<a href="" class="bbs_btn delete">Delete</a-->
						</span>
					</div>
				<!-- //bbs_btn_wrap -->

			</fieldset>
		</form>

	</div>
	<!-- //bbs_basic write -->

		</div>

		<!-- // n5 -->