<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
	
<style>
	#mask {  
	  position:absolute;  
	  left:0;
	  top:0;
	  z-index:100;  
	  background-color:#000;  
	  display:none;  
	}
       #loadingImg {
	  position:absolute;
	  left:45%;
	  top:50%;
	  z-index:120;
	}
</style>

<script>
	    var mngIdRuleInvalid = '<spring:message code="login.mngid.rule.invalid" text="Please enter Engling and number of 7 ~ 15 letters."></spring:message>';
	    var mngidPwdBlank = '<spring:message code="login.mngid.pwd.blank" text="Please enter a value for both ID and Password"></spring:message>';
	    var mngidPwdNullvalue = '<spring:message code="login.mngid.pwd.nullvalue" text="Please enter User Account"></spring:message>';
	    //var mngIdRuleInvalid = eval(t('login.mngid.rule.invalid'));
	    //var mngidPwdBlank = eval(t('login.mngid.pwd.blank'));
	    //var mngidPwdNullvalue = eval(t('login.mngid.pwd.nullvalue'));
    
		$(function() {
			
			common.invoker.invoke("Login");

			$("#frm").ajaxForm({
				dataType : 'json',
				beforeSubmit : function(formData, $form, options) {
					LoadingWithMask();
					for ( var i = 0; i < formData.length; i++) {
						if (!formData[i].value) {
							alertify.alert(mngidPwdBlank,function(e) {
							HideLoadingWithMask();
							});
							return false;
						}
					}
					if ($("#mngId").val() == "") {
						alertify.alert(mngidPwdNullvalue, function (e){
								$("#mngId").focus();
								HideLoadingWithMask();
						});
						return false;
					} 
					
					// check Rule MngID
					var idReg = /^[a-z]+[a-z0-9]{6,14}$/g;
			        if( !idReg.test( $("input[name=mngId]").val() ) ) {
			        	alertify.alert(mngIdRuleInvalid, function (e){
								$("#mngId").focus();
								HideLoadingWithMask();
						});
			        	
			            return false;
			        }

					if ($("#password").val() == "") {
						alertify.alert(mngidPwdNullvalue, function (e){
								$("#password").focus();
								HideLoadingWithMask();
						});
						return false;
					}
				},
				success : function(json, statusText, xhr, $form) {
					if (json.success == true) {
						var url = json.returnUrl || './';
						document.location.href = url;
					} else {
						alertify.alert(json.message);
						if(json.loginCd == '0004') {
							document.location.href = json.defaultFailureUrl;
						}
						HideLoadingWithMask();
					}
				},
				error : function(xhr) {
					alertify.alert(xhr.statusText);
					HideLoadingWithMask();
				}
			});
		});
		
	</script>
	
<c:choose>
	<c:when test="${loginCd == '0004'}">
	<script language="javascript">
  		location.href="${pageContext.request.contextPath}/overDayPwd.do";
  	</script>
	</c:when>
	<c:when test="${loginCd == '0001' || loginCd == '0002' || loginCd == '0003' }">
	<script language="javascript">
		alertify.alert("${errormsgname}", function (e) {
		location.href="${pageContext.request.contextPath}/authLogin.do";
	});
   </script>
	</c:when>
</c:choose>
		    
<!-- 로그인 -->
<div class="login_box">
	<div class="contents_box">
		<form name="frm" id="frm" action="${pageContext.request.contextPath}/authProcess.do" method="post">
			<fieldset>
				<legend>login</legend>
				<ul class="clearfix">
				<li>
					<div class="cont_box">
						<label for="id">ID</label>
						<input type="text" id="mngId" name="mngId" placeholder="Enter Manager ID" />
					</div>
				</li>
				<li>
					<div class="cont_box">
						<label for="password">Password</label>
						<input type="password" id="password" name="password" placeholder="Password" />
					</div>
				</li>
				</ul>
				<p class="save_check">
					<input type="checkbox" name="idSaveCheck" id="idSaveCheck" id="save_id" />
					<label for="save_id">Save ID</label>
				</p>
				<input type="submit" value="LOGIN" class="submit"/>
			</fieldset>
			<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
		</form>
	</div>
	<div class="put_box">
		<ul class="clearfix">
		<li><a href="${pageContext.request.contextPath}/searchId.do">Find ID</a></li>
		<li><a href="${pageContext.request.contextPath}/searchPwd.do">Forgot your Password</a></li>
		</ul>
	</div>
</div>
