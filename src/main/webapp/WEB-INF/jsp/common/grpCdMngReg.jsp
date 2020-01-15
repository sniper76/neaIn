<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/grpCdMngReg.js"></script>
<script>
	var deleteMsg 	= '<spring:message code="cpes.save.btn.delete.msg" text="delete"></spring:message>';
	var modifyMsg 	= '<spring:message code="cpes.save.btn.modify.msg" text="Modify"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';
	var emptyMsg  	= '<spring:message code="grpcd.chk.empty.msg" text="Please Write Code!"></spring:message>';
</script>

<div class="tab_obj n5">
        
	<div class="bbs_basic">
		<form id="frm" method="post" >
			<fieldset>
				<h3><spring:message code="field.dic.grpcd.mng" /></h3>
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
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.grpcd" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<input type="text" name="grpCd" id="grpCd" />
							<button type="button" value="popup" class="bbs_btn type03" onclick="chkGrpCode();"><spring:message code="field.dic.double.chk" /></button>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.grpcd.nm" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="grpNm" id="grpNm" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="title.sample.regUser" /></label></th>
						<td><input type="text" name="regUserNm" id="regUserNm" value="<c:out value="${userNm}" />"  disabled="disabled" /></td>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.reg.date" /></label></th>
						<td><input type="text" name="regDt" id="regDt"  disabled="disabled" /></td>
					</tr>
					
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="title.sample.description" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<textarea id="expln" name="expln" cols="1" rows="1" title="content" class="bbs_write_content"></textarea>
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
						<button type="button" value="save" class="bbs_btn save" onclick="insertGrpCdConf();"><spring:message code="cpes.btn.save" /></button>
					</span>
				</div>
				<!-- //bbs_btn_wrap -->
	
			</fieldset>
		</form>
	
	</div>
	<!-- //bbs_basic write -->
	
		</div>
		<!-- // n5 -->