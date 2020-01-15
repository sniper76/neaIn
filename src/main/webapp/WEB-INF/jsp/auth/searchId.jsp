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

<!-- 아이디 찾기 -->
<div class="login_box type2">
	<form name="frm" id="frm">
		<fieldset>
			<legend>Find ID</legend>
			<table class="bbs_table">
				<caption>Find ID</caption>
				<colgroup>
					<col style="width:25%" />
					<col />
				</colgroup>
				<tbody>
				<tr>
					<th scope="row"><label for="name1">Name</label></th>
					<td>
						<input type="text" id="userNm" name="userNm" maxlength="50"/>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="email">E-mail</label></th>
					<td>
						<input type="text" id="userEmail" name="userEmail"  maxlength="100"/>
					</td>
				</tr>
				</tbody>
			</table>
			<div class="put_box">
				<input type="button" value="SEARCH ID" class="submit" onclick="Login.fn.getSeachId();"/>
			</div>
		</fieldset>
	</form>
	<div class="find_box">
	</div>
</div>



