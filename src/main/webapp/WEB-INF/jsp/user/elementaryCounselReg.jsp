<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/elementaryCounselReg.js"></script>
<script>
   var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
	var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';

	function SelectCounselHisList(){
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectCounselInfoAjax.do";
		var param = {
			"userSeq" : $('#userSeq').val(), 
			"sysLangCd" : lang
		};
		
		$.ajax({
			type: "POST",
			url: action,
			data: param,                   
			cache: true,
			success: function(response) {
				//alert(response);
				$("#innerDtlInfo").html(response);
			}
		});
		
		//$("#innerUserDtlInfoBase").hide();
		//$("#innerResumeDtlInfo").hide();	
		//$("#innerCounselInfo").show();		
	}
</script>

<form id="frmCourseReg" >
<input type="hidden" id="counselSeq" name="counselSeq" value="<c:out value="${CounselBean.counselSeq}" />" />
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${elmtryUserInfo.userSeq}" />" />
<input type="hidden" name="ansContent" id="ansContent" value="" />

<h3>기본내용</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.title" /></th>
			<td colspan="3">
				<input type="text" name="qustTitle" id="qustTitle" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="userChg.list.title.userNm" /></th>
			<td colspan="3">
				<input type="text" name="userNm" id="userNm" disabled="disabled" value="<c:out value="${elmtryUserInfo.userNm}" />"/>
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.councel.method" /></th>
			<td>
				<commCode:commcode codeKind="commCode" tagName="counselMethodDivCd" grpCd="COUNSEL_METHOD_DIV_CD" drawType="select" initValue="" exceptValue="ALL" disable=""/>
			</td>
			<th scope="row"><spring:message code="field.dic.reg.date" /></th>
			<td>
				<input type="text" name="qustRegDt" id="qustRegDt" disabled="disabled"/>
			</td>
		</tr>
			
		</tbody>
	</table>
	<!-- //bbs_table view -->
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->

<h3><spring:message code="field.dic.ansuser.info" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.controll.center" /></th>
			<td>
				<input type="text" name="jcNm" id="jcNm" disabled="disabled" value="<c:out value="${CounselUserInfo.jcNm}" />"/>
				<input type="hidden" name="jcCd" id="jcCd"  value="<c:out value="${CounselUserInfo.jcCd}" />"/>
			</td>
			<th scope="row"><spring:message code="field.dic.ans.usernm" /></th>
			<td>
				<input type="text" name="jcUserNm" id="jcUserNm" disabled="disabled" value="<c:out value="${CounselUserInfo.jcUserNm}" />"/>
				<input type="hidden" name="jcUserSeq" id="jcUserSeq"  value="<c:out value="${CounselUserInfo.jcUserSeq}" />"/>
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->



<h3><spring:message code="field.dic.ans.info" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
			<tr>
				<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.councel.result" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
				<td colspan="3">
					<!--textarea id="content" name="content" cols="1" rows="1" title="contentKh" class="bbs_write_content"></textarea-->
					<textarea id="txtAnsContent" cols="30" rows="10" title="Contents" class="bbs_write_content"></textarea>
				</td>
			</tr>
			<tr id="attFile"">
				<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.attach.file" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
				<td colspan="3">
					<input type="file" name="files[]" multiple />
				</td>
			</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
	
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<button type="button" class="bbs_btn list" onclick="tabCounselDtlInfo();"><spring:message code="cpes.btn.list" /></button>
		</span>
		<span class="bbs_right">
			<button type="button" value="save" class="bbs_btn save" onclick="insertElemtryCounselConf();"><spring:message code="cpes.btn.save" /></button>
		</span>
	</div>
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->
</form>


