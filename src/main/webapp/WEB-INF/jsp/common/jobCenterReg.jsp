<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/jobCenterReg.js"></script>
<script>
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
</script>

<div class="tab_obj n5">

	<div class="bbs_basic">
		<form id="frm" method="post" >
			<input type="hidden" id="jcCd" name="jcCd" value="<c:out value="${jcCd}" />" />
			<fieldset>
				<h3><spring:message code="bulletin.dic.basic.content" /></h3>
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
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="title.sample.regUser" /></label></th>
						<td><input type="text" name="regUserNm" id="regUserNm" value="<c:out value="${userNm}" />"  disabled="disabled" /></td>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.reg.date" /></label></th>
						<td><input type="text" name="regDt" id="regDt"  disabled="disabled" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.jobcntr.nmkh" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="jcKh" id="jcKh" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.jobcntr.nmen" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="jcEn" id="jcEn" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.jobcntr.cd" /></label></th>
						<td colspan="3"><input type="text" name="jcCd" id="jcCd"  disabled="disabled" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.dtladdr" /></label></th>
						<td colspan="3">
								<input type="hidden" name="addrCd" id="addrCd" value="" required/>
								<input type="hidden" name="addrFullCd" id="addrFullCd" value="" required/>
							<button type="button" value="popup" class="bbs_btn type03" onclick="popAddrLayerBtn('addrCd', 'addrFullCd', 'addrFullNm', 'addrFullNmView');"><spring:message code="field.dic.area" /></button>
							<input type="text" name="addrFullNm" id="addrFullNm"  required/>
							<div>
									<label for="addrKh"><spring:message code="field.dic.khmer" /> </label><input type="text" name="addrKh" id="addrKh"  />
							</div>
							<div>
									<label for="addrEn"><spring:message code="field.dic.english" /> </label><input type="text" name="addrEn" id="addrEn"  />
							</div>
						</td>

					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.google.link" /></label></th>
						<td colspan="3"><input type="text" name="mapLink" id="mapLink"  /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.tel" /></label></th>
						<td><input type="text" name="tel1" id="tel1"  /></td>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.tel2" /></label></th>
						<td><input type="text" name="tel2" id="tel2"  /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.email" /></label></th>
						<td><input type="text" name="email" id="email"  /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.rpt.img" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<img id="uploadImg" src="" alt="">
							<input type="file" id="uploadImgFile" >
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="title.sample.useYn" /></label></th>
						<td colspan="3">
							<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
						</td>
					</tr>
					</tbody>
				</table>


				<div class="bbs_btn_wrap clearfix">
					<span class="bbs_left">
						<button type="button" class="bbs_btn list" onclick="forList();"><spring:message code="cpes.btn.list" /></button>
					</span>
					<span class="bbs_right">
						<button type="button" value="save" class="bbs_btn save" onclick="insertJobCenterConf();"><spring:message code="button.create" /></button>
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