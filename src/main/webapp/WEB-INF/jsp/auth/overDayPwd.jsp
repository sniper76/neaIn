<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
    <script>
		$(function() {
			common.invoker.invoke("Login");
		});
	</script>
		
		<main id="container">
			<article>
				<div id="contents">
					<!-- 분기별 비밀번호 변경 -->
					<div class="login_box">
						<form name="frm" id="frm">
							<fieldset>
								<legend>Change Password</legend>
								<div class="login_info">
									<p>You have not changed your password more than 3 months. <br />Please register your password by combining 8-15 characters with capital and small letters, number, and special characters (!$$%)</p>
								</div>
								<table class="bbs_table">
									<caption>Change Password</caption>
									<colgroup>
										<col style="width:25%" />
										<col />
									</colgroup>
									<tbody>
									<tr>
										<th scope="row"><label for="userPwd">Current Password</label></th>
										<td>
											<input type="password" id="userPwd" name="userPwd" />
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="userNewPwd">New Password</label></th>
										<td>
											<input type="password" id="userNewPwd" name="userNewPwd"/>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="confirm_new_password">Confirm New Password</label></th>
										<td>
											<input type="password" id="confirm_new_password" name="confirm_new_password"/>
										</td>
									</tr>
									</tbody>
								</table>
								<div class="find_box">
									<div class="find_put">
										<a href="${pageContext.request.contextPath}/internal/index.do">CHANGE LATER</a>
										<input type="button" value="CHANGE NOW" class="submit" onclick="Login.fn.setNewPwd();"/>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</article>
		</main>
		<!-- //container -->
