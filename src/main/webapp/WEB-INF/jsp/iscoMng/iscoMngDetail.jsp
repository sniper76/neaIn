<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/iscoMng/iscoMngDetail.js"></script>
<script>
	$(function() {
		common.invoker.invoke("iscoMngDetail");
	});
</script>

<div class="tab_obj n5">

	<div class="bbs_basic">
		<form id="frm" method="post" >
			<input type="hidden" name="iscoCd" value="${result.iscoCd }">
			<fieldset>
				<legend>Write a post</legend>
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
							<th scope="row"><label for=""><spring:message code="field.dic.jobtype.en" /></label></th>
							<td colspan="3">
								<c:out value="${result.depth1EnNm}" /> &gt; <c:out value="${result.depth2EnNm}" /> &gt; <c:out value="${result.depth3EnNm}" /> &gt; <c:out value="${result.enNm}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><spring:message code="field.dic.jobtype.kh" /></label></th>
							<td colspan="3">
								<c:out value="${result.depth1KhNm}" /> &gt; <c:out value="${result.depth2KhNm}" /> &gt; <c:out value="${result.depth3KhNm}" /> &gt; <c:out value="${result.khNm}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><spring:message code="field.dic.code" /></label></th>
							<td colspan="3">
								<c:out value="${result.iscoCd }" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><spring:message code="field.dic.def.en" /></label></th>
							<td colspan="3">
								<textarea id="defEn" name="defEn" rows="" cols=""><c:out value="${result.defEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><spring:message code="field.dic.def.kh" /></label></th>
							<td colspan="3">
								<textarea id="defKh" name="defKh" rows="" cols=""><c:out value="${result.defKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">직업 내부 (en)</label></th>
							<td colspan="3">
								<textarea id="occupIncEn" name="occupIncEn" rows="" cols=""><c:out value="${result.occupIncEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">직업 내부 (kh)</label></th>
							<td colspan="3">
								<textarea id="occupIncKh" name="occupIncKh" rows="" cols=""><c:out value="${result.occupIncKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">직업 외부 (en)</label></th>
							<td colspan="3">
								<textarea id="occupExcEn" name="occupExcEn" rows="" cols=""><c:out value="${result.occupExcEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">직업 외부 (kh)</label></th>
							<td colspan="3">
								<textarea id="occupExcKh" name="occupExcKh" rows="" cols=""><c:out value="${result.occupExcKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">노트 (en)</label></th>
							<td colspan="3">
								<textarea id="noteEn" name="noteEn" rows="" cols=""><c:out value="${result.noteEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">노트 (kh)</label></th>
							<td colspan="3">
								<textarea id="noteKh" name="noteKh" rows="" cols=""><c:out value="${result.noteKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">task (en)</label></th>
							<td colspan="3">
								<textarea id="taskEn" name="taskEn" rows="" cols=""><c:out value="${result.taskEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">task (kh)</label></th>
							<td colspan="3">
								<textarea id="taskKh" name="taskKh" rows="" cols=""><c:out value="${result.taskKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><spring:message code="bulletin.dic.title.en" /></label></th>
							<td colspan="3">
								<textarea id="titleEn" name="titleEn" rows="" cols=""><c:out value="${result.titleEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><spring:message code="bulletin.dic.title.kh" /></label></th>
							<td colspan="3">
								<textarea id="titleKh" name="titleKh" rows="" cols=""><c:out value="${result.titleKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">직장 (en)</label></th>
							<td colspan="3">
								<textarea id="dutiesEn" name="dutiesEn" rows="" cols=""><c:out value="${result.dutiesEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">직장 (kh)</label></th>
							<td colspan="3">
								<textarea id="dutiesKh" name="dutiesKh" rows="" cols=""><c:out value="${result.dutiesKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">기술 (en)</label></th>
							<td colspan="3">
								<textarea id="skillEn" name="skillEn" rows="" cols=""><c:out value="${result.skillEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">기술 (kh)</label></th>
							<td colspan="3">
								<textarea id="skillKh" name="skillKh" rows="" cols=""><c:out value="${result.skillKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">책임 (en)</label></th>
							<td colspan="3">
								<textarea id="responsibilitiesEn" name="responsibilitiesEn" rows="" cols=""><c:out value="${result.responsibilitiesEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">책임 (kh)</label></th>
							<td colspan="3">
								<textarea id="responsibilitiesKh" name="responsibilitiesKh" rows="" cols=""><c:out value="${result.responsibilitiesKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">교육훈련 (en)</label></th>
							<td colspan="3">
								<textarea id="eduTrnngEn" name="eduTrnngEn" rows="" cols=""><c:out value="${result.eduTrnngEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">교육훈련 (kh)</label></th>
							<td colspan="3">
								<textarea id="eduTrnngKh" name="eduTrnngKh" rows="" cols=""><c:out value="${result.eduTrnngKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">고등교육 (en)</label></th>
							<td colspan="3">
								<textarea id="highEduEn" name="highEduEn" rows="" cols=""><c:out value="${result.highEduEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">교육훈련 (kh)</label></th>
							<td colspan="3">
								<textarea id="highEduKh" name="highEduKh" rows="" cols=""><c:out value="${result.highEduKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">전공 학업 (en)</label></th>
							<td colspan="3">
								<textarea id="majorStudyEn" name="majorStudyEn" rows="" cols=""><c:out value="${result.majorStudyEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">전공 학업 (kh)</label></th>
							<td colspan="3">
								<textarea id="majorStudyKh" name="majorStudyKh" rows="" cols=""><c:out value="${result.majorStudyKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">기술 관련 경험 (en)</label></th>
							<td colspan="3">
								<textarea id="skillRelatedExpEn" name="skillRelatedExpEn" rows="" cols=""><c:out value="${result.skillRelatedExpEn }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="">기술 관련 경험 (kh)</label></th>
							<td colspan="3">
								<textarea id="skillRelatedExpKh" name="skillRelatedExpKh" rows="" cols=""><c:out value="${result.skillRelatedExpKh }" /></textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><spring:message code="field.dic.job.cate" /></label></th>
							<td colspan="3">
								<commCode:commcode codeKind="commCode" tagName="jobCateCd" grpCd="JOB_CATE_CD" drawType="select" initValue="${result.jobCateCd }" exceptValue="ALL" disable=""/>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><spring:message code="field.dic.job.cate" /></label></th>
							<td colspan="3">
								<img id="uploadImg" src="${pageContext.request.contextPath}/common/imgLoading.do?url=${result.filePath}" alt="" style="width: 120px; height: 170px;" >
								<input type="file" id="uploadImgFile" >
							</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><spring:message code="title.sample.useYn" /></label></th>
							<td colspan="3">
								<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="${result.useYn }" exceptValue="ALL" disable="true"/>
							</td>
						</tr>
					</tbody>
				</table>
				<!-- //bbs_table write -->

				<div class="bbs_btn_wrap clearfix">
					<span class="bbs_left">
						<input type="button" id="btnList" class="bbs_btn list"  value="list" />
					</span>
					<span class="bbs_right">
						<input type="button" id="btnSave" value="save" class="bbs_btn save" />
					</span>
				</div>
				<!-- //bbs_btn_wrap -->

			</fieldset>
		</form>

	</div>
	<!-- //bbs_basic write -->

		</div>
		<!-- // n5 -->