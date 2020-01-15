<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/neaUserMod.js"></script>
<script>
	var passchkMsg 	= '<spring:message code="field.dic.pass.desc" text="password error"></spring:message>';
	var deleteMsg 	= '<spring:message code="cpes.save.btn.delete.msg" text="Success"></spring:message>';
	var modifyMsg 	= '<spring:message code="cpes.save.btn.modify.msg" text="Success"></spring:message>';
	var pwdInitMsg='<spring:message code="user.reg.passwdinit.btn.msg" text="Do you want to reset password?"></spring:message>';

	var nmKmBlank	= '<spring:message code="msg.err.kmr.name.empty" text="please input name(KHMER)"></spring:message>';
	var nmEnBlank	= '<spring:message code="msg.err.eng.name.empty" text="please input name(KHMER)"></spring:message>';
	var mngIdRuleInvalid = '<spring:message code="login.mngid.rule.invalid" text="Please enter Engling and number of 7 ~ 15 letters."></spring:message>';
	var passwdBlank = '<spring:message code="user.regist.password.blank.error" text="please input password"></spring:message>';
	var passwdConfirmBlank = '<spring:message code="user.regist.password_confirm.blank.error" text="please input password confirm"></spring:message>';
	var tellNumberBlank = '<spring:message code="user.regist.userTel.blank.error" text="please input tel number"></spring:message>';
	var emailBlank = '<spring:message code="user.regist.email.blank.error" text="please input tel number"></spring:message>';
	var emailRuleInvalid = '<spring:message code="user.regist.email.valid.error" text="wrong password rule"></spring:message>';
	var cellNumberBlank = '<spring:message code="user.regist.userCell.blank.error" text="please input mobile number"></spring:message>';
	var pwdFailCntBlank = '<spring:message code="user.regist.pwd.fail.error" text="please input password Fail count"></spring:message>';
	var userPwdValidError = '<spring:message code="user.regist.password.valid.error" text="error!"></spring:message>';
</script>

<div class="tab_obj n5">
        
	<div class="bbs_basic">
		<form id="frm" method="post" >
			<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${user.userSeq}" />" />
			<input type="hidden" id="urlChk" name="urlChk" value="nea" />
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
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.instt.nm" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><spring:message code="nea.user.mng.nea" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.usernm.kh" /></label></th>
						<td ><input type="text" name="userNmKh" id="userNmKh" value="${user.userNmKh }" size="50" maxlength="50"/></td>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.usernm.en" /></label></th>
						<td ><input type="text" name="userNmEn" id="userNmEn" value="${user.userNmEn }" size="50" maxlength="50"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="userChg.list.title.gender" /></label></th>
						<td >
							<commCode:commcode codeKind="commCode" tagName="genderCd" grpCd="GENDER_CD" drawType="radio" initValue="${user.genderCd }" exceptValue="ALL" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.mngid" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="mngId" id="mngId" maxlength="50" size="50" value="${user.mngId }"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.now.workyn" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
								<commCode:commcode codeKind="commCode" tagName="workRetireCd" grpCd="WORK_RETIRE_CD" drawType="radio" initValue="${user.workRetireCd }" exceptValue="ALL" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.password" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<input type="password" name="userPwd" id="userPwd" size="80" maxlength="110" value="${user.userPwd }"/>
							<input type="hidden" name="oldPwd" id="oldPwd" value="${user.userPwd }"/>
							<button type="button" value="popup" class="bbs_btn list" onclick="passwrdReset();"><spring:message code="field.dic.init.btn" /></button>
						</br>
							<spring:message code="field.dic.pass.desc" />
							
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.pass.confirm" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<input type="password" name="userPwdconf" id="userPwdconf" size="80" maxlength="110"/>
							<div class="alert alert-danger" id="alert-danger"><spring:message code="security.error.BadCredentials" /></div>


						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.tel" /></label></th>
						<td ><input type="text" name="userTel" id="userTel"  value="${user.userTel }" size="30" maxlength="30"/></td>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="userChg.list.title.email" /></label></th>
						<td ><input type="text" name="userEmail" id="userEmail" size="35" maxlength="100" value="${user.userEmail }"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.mobile" /></label></th>
						<td ><input type="text" name="userCell" id="userCell" value="${user.userCell }" size="30" maxlength="30"/></td>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="title.sample.useYn" /></label></th>
						<td >
							<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="${user.useYn }" exceptValue="ALL" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.passfail.cnt" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="pwdFailCnt" id="pwdFailCnt" size="3" maxlength="3" value="${user.pwdFailCnt }"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.dtladdr" /></label></th>
						<td colspan="3">
								<input type="hidden" name="addrCd" id="addrCd" value="${user.addrCd }" required/>
								<input type="hidden" name="addrFullCd" id="addrFullCd" value="${user.addrFullCd }" required/>
								<button type="button" value="popup" class="bbs_btn type03" onclick="popAddrLayerBtn('addrCd', 'addrFullCd', 'addrFullNm', 'addrFullNmView');"><spring:message code="field.dic.area" /></button>
								<input type="text" name="addrFullNm" id="addrFullNm"  required  size="80" maxlength="100" value="${user.addrFullNm }"/>
							<div>
									<input type="text" name="addrDtl" id="addrDtl" size="100" maxlength="100" value="${user.addrDtl }"/>
							</div>
						</td>
						
					</tr>
					
					</tbody>
				</table>
				
				
				<div class="bbs_btn_wrap clearfix">
					<span class="bbs_left">
						<button type="button" class="bbs_btn list" onclick="forList();"><spring:message code="cpes.btn.list" /></button>
						<button type="button" class="bbs_btn list" onclick="authMngAction();"><spring:message code="field.dic.auth.mng" /></button>
					</span>
					<span class="bbs_right">
						<button type="button" id="save" name="save" value="save" class="bbs_btn save" onclick="updateNeaUserConf();"><spring:message code="cpes.btn.save" /></button>
						<button type="button" value="delete" class="bbs_btn delete" onclick="deleteNeaUserConf();"><spring:message code="cpes.btn.delete" /></button>
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