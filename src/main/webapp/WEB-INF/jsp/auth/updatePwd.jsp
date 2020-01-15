<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
    <script>
		$(function() {
			common.invoker.invoke("Login");
		});
		
		var userPwdValidError = '<spring:message code="user.regist.password.valid.error" text="error!"></spring:message>';
		
	</script>
<!-- 비밀번호 초기화 -->
<div class="login_box type2">
	<form name="frm" id="frm">
		<fieldset>
			<legend>Change Password</legend>
			<div class="login_info">
				<p>Input your verification number received by e-Mail. <br />Please register your password by combining 8-15 characters with capital and small letters, number, and special characters (!$$%)</p>
			</div>
			<table class="bbs_table">
				<caption>Change Password</caption>
				<colgroup>
					<col style="width:25%" />
					<col />
				</colgroup>
				<tbody>
				<tr>
					<th scope="row"><label for="emailUserAuthValue">Verification No.</label></th>
					<td>
						<input type="text" id="emailUserAuthValue" name="emailUserAuthValue" maxlength="10"/>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="userNewPwd">New Password</label></th>
					<td>
						<input type="password" id="userNewPwd" name="userNewPwd"  maxlength="30"/>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="confirm_new_password">Confirm New Password</label></th>
					<td>
						<input type="password" id="confirm_new_password"  maxlength="30"/>
					</td>
				</tr>
				</tbody>
			</table>
			<div class="put_box">
				<input type="button" value="CHANGE PW" class="submit" onclick="Login.fn.setAuthPwd();"/>
			</div>
		</fieldset>
	</form>
</div>