<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/bulletin/bulletinMngMod.js"></script>
<script>
	var confirmMsg 	= '<spring:message code="userChg.list.confirm.selAgree" text="Do you want save?"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	var cancelMsg 	= '<spring:message code="cpes.save.btn.confirm.cancel.msg" text="You canceled"></spring:message>';
	var proccesMsg 	= '<spring:message code="cpes.process.success.msg" text="Success"></spring:message>';
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';
	var deleteMsg 	= '<spring:message code="cpes.save.btn.delete.msg" text="delete"></spring:message>';
	var modifyMsg 	= '<spring:message code="cpes.save.btn.modify.msg" text="Modify"></spring:message>';
	var alMenuMsg 	= '<spring:message code="bulletin.menu.delete.msg" text="Success"></spring:message>';
	var cateLitMsg 	= '<spring:message code="bulletin.cate.limit.msg" text="Success"></spring:message>';
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
			<input type="hidden" name="bulletinMngSeq" id="bulletinMngSeq" value="<c:out value="${bulletinMngSeq}" />" />
			<fieldset>
				<h3><spring:message code="bulletin.dic.basic.content" text="Base Description"></spring:message></h3>
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
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.title" text="Bulletin Name"></spring:message></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="bulletinNm" id="bulletinNm" value=""/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="program.programtitle.id" text="Program ID"></spring:message></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="programId" id="programId" placeholder="Auto Create"  disabled="disabled" value=""/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.type" text="Bulletin Type"></spring:message></label></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="bulletinTypeCd" grpCd="BULLETIN_TYPE_CD" drawType="select" initValue="" exceptValue="ALL" disable="true"/>
						</td>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.range" text="Bulletin Range"></spring:message></label></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="bulletinRange" grpCd="RANGE_CD" drawType="radio" initValue="" exceptValue="ALL,RNG0000000003" disable=""/>
							
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly ">necessary</span> <label for=""><spring:message code="bulletin.dic.desc" text="Bulletin Description"></spring:message></label></th>
						<td colspan="3">
							<textarea id="content" name="content" cols="30" rows="5" title="Contents" class="bbs_write_content"></textarea>
						</td>
					</tr>
					</tbody>
				</table>
				<!-- //bbs_table write -->
				&nbsp;&nbsp;
				<h3><spring:message code="bulletin.dic.function.set" text="Function Setting"></spring:message></h3>
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
							<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.function.set" text="Writer Permission"></spring:message></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
							<td colspan="3">
								<span class="bbs_input_box">
									<input type="checkbox" name="jobskYn1" id="jobskYn1" value="" />
									<label for="checkbox1"><spring:message code="bulletin.dic.pms.jobsk" text="job Seeker"></spring:message></label>
								</span>
								<span class="bbs_input_box">
									<input type="checkbox" name="stdtYn1" id="stdtYn1" value="" />
									<label for="checkbox2"><spring:message code="bulletin.dic.pms.stin" text="student/Intern"></spring:message></label>
								</span>
								<span class="bbs_input_box">
									<input type="checkbox" name="employYn1" id="employYn1" value="" />
									<label for="checkbox2"><spring:message code="bulletin.dic.pms.emp" text="Employee"></spring:message></label>
								</span>
								<span class="bbs_input_box">
									<input type="checkbox" name="trnngInsttYn1" id="trnngInsttYn1" value="" />
									<label for="checkbox2"><spring:message code="field.dic.instt" text="Training Institutions"></spring:message></label>
								</span>
								<input type="hidden" id="jobskYn" name="jobskYn" value=""/>
								<input type="hidden" id="stdtYn" name="stdtYn" value=""/>
								<input type="hidden" id="employYn" name="employYn" value=""/>
								<input type="hidden" id="trnngInsttYn" name="trnngInsttYn" value=""/>
							</td>
						</tr>
						<tr id="category">
							<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.cate.set" text="Category Setting"></spring:message></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
							<td colspan="3">
								<span class="bbs_right">
									<!--input type="button" name="Add" value="Add" class="bbs_btn type02 small copy" onclick="cateAdd();"-->
									<button type="button" class="bbs_btn type02 small copy" onclick="cateAdd();"><spring:message code="bulletin.dic.add" text="Add"></spring:message></button>
								</span>
								<input type="hidden" id="cateCnt" name="cateCnt" value=""/>
								<fieldset id="categoryType">
									
								</fieldset>
							</td>
						</tr>
						<tr>
							<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.fileyn" text="Attachment file Y/N"></spring:message></label></th>
							<td>
									<commCode:commcode codeKind="commCode" tagName="fileYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="" exceptValue="ALL" disable=""/>
							</td>
							<th scope="row"><span class="exactly ">necessary</span> <label for=""><spring:message code="bulletin.dic.numberfile" text="Number of Files"></spring:message></label></th>
							<td>
								<select id="fileNum" name="fileNum" title="fileNum">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.filesize" text="Capacity limit per file"></spring:message></label></th>
							<td colspan="3"><input type="text" id="fileCap" name="fileCap"/>&nbsp; mb</td>
							
						</tr>
						<tr>
							<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.likeyn" text="Like Y/N"></spring:message></label></th>
							<td>
								<commCode:commcode codeKind="commCode" tagName="likeYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="" exceptValue="ALL" disable=""/>
							</td>
							<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.useyn" text="Use Y/N"></spring:message></label></th>
							<td>
								<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="" exceptValue="ALL" disable=""/>
							</td>
						</tr>
						</tbody>
					</table>
				
				<div class="bbs_btn_wrap clearfix">
					<span class="bbs_left">
						<button type="button" class="bbs_btn list" onclick="forList();"><spring:message code="cpes.btn.list" text="list"></spring:message></button>
					</span>
					<span class="bbs_right">
						<button type="button" value="save" class="bbs_btn modify" onclick="updateBulletinMngConf();"><spring:message code="cpes.btn.modify" text="Modify"></spring:message></button>
						<button type="button" value="delete" class="bbs_btn delete" onclick="deleteBulletinMngConf();"><spring:message code="cpes.btn.delete" text="Delete"></spring:message></button>
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