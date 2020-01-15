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
<!-- 계벙잠금 안내 -->
<div class="login_box type2">
	<div class="login_warning">
		<div class="title_box">
			<div class="title">You have exceeded the number of login attempts (5 times).</div>
		</div>
		<div class="cont_box">
			<p>계정 차단 시에는 CPES 내부행정망을 이용할 수 없습니다. <br />계정 차단 원인 및 재사용을 위해서는 전산 담당자에게 문의하신 후 차단을 해제해 주세요.</p>
		</div>
	</div>
	<div class="put_box">
		<a href="./authLogin.do" class="submit">GO TO LOGIN</a>
	</div>
</div>
