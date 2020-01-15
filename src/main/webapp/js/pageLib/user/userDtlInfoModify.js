var	userDtlInfoModify = {
		name: 'userDtlInfoModify',
		dataTables: null,
		commCode: {},
		
		init: function() {
			var that$ = this;
			
			$.when( this.beforeBind() ).done(function( res ) {
				that$.bind();
				that$.afterBind();
			});
		},
		
		beforeBind: function() {
		},
		bind: function() {

		},
		afterBind: function() {
			
			$("#saveBtn").click(function(){
				
		        $("#birth").val($("#birthY").val() + "-" + $("#birthM").val() +"-"+ $("#birthD").val());
		        
		        var useYnTemp = $('input[name="useYnTemp"]:checked').val();
		        $("#useYn").val(useYnTemp);
		        
		        var infoYnTemp = $('input[name="infoOpenYnTemp"]:checked').val();
		        $("#infoOpenYn").val(infoYnTemp);
		        
		        var concilYnTemp = $('input[name="concilReqYnTemp"]:checked').val();
		        $("#concilReqYn").val(concilYnTemp);
		        
		        var smsNtceAgreeYnTemp = $('input[name="smsNtceAgreeYnTemp"]:checked').val();
		        $("#smsNtceAgreeYn").val(smsNtceAgreeYnTemp);
		        
		        var emailNtceAgreeYnTemp = $('input[name="emailNtceAgreeYnTemp"]:checked').val();
		        $("#emailNtceAgreeYn").val(emailNtceAgreeYnTemp);
		        
				if($("#pwdFailCnt").val() == "") {
					alertify.alert(pwdFailCntBlank, function(e) {
						$("#pwdFailCnt").focus();
					});
					return;
				}
				
				if ($("#addrCd").val() == "") {
					alertify.alert(addrBlank, function(e) {
						$("#addrCd").focus();
					});
					return;
				}
				
				if ($("#addrDtl").val() == "") {
					alertify.alert(addrDtlBlank, function(e) {
						$("#addrDtl").focus();
					});
					return;
				}
				
				alertify.confirm(confirmMsg, function (e) {
					if(e) {
						var param = $("#frm").serializeObject();
						var	opts = {
								url		: contextPath + "/internal/user/updateUserDtlInfoAjax.do",
								data	: param,
								type	: "post",
								sendDataType	: "json",
								success	: function(resJSON, resCode) {
									// failed
									if(resJSON.data.resultCode != '0000') {
										alertify.alert(resJSON.data.msg);
										return false;
									} else {
										alertify.alert(resJSON.data.msg);
										location.href="/internal/user/userInfoList.do"
									}
									
								},
								error : function() {
									
								}
							};
							common.http.ajax(opts);
					} else {
						alertify.alert(cancelMsg);
					}
				});
				
			});
			
			$("#searchAddr").click(function(){
				userDtlInfoReg.fn.searchAddr();
			});
			

		},
		
		fn: {
			initPwd : function() {
				alertify.confirm(pwdInitMsg, function (e) {
					if(e) {
						var param = $("#frm").serializeObject();
						var	opts = {
								url		: contextPath + "/internal/user/updateUserPasswordAjax.do",
								data	: param,
								type	: "post",
								sendDataType	: "json",
								success	: function(resJSON, resCode) {
									// failed
									if(resJSON.data.resultCode != '0000') {
										alertify.alert(resJSON.data.msg);
										return false;
									} else {
										alertify.alert(resJSON.data.msg);
										//location.href="/internal/user/userInfoList.do"
									}
									
								},
								error : function() {
									
								}
							};
							common.http.ajax(opts);
					} else {
						alertify.alert(cancelMsg);
					}
				});
			}
		}
		
		
}

function fnGoBackList(){
	
	var previousUrl = $("#previousUrl").val();
	location.href = previousUrl;
	
	/*
	window.location.href - return href(URL) of current page
	window.location.hostname - return domain name of Web host 
	window.location.pathname - return the path and file name of current page
	window.location.protocol - return using web protocol (http:// or https://)
	window.location.assign - load new document
	
	histroy.go(-1);		// return to the previous page of 1 step 
	histroy.go(-2);		// return to the previous page of 2 steps
	histroy.go(-3);		// return to the previous page of 3 steps
	history.back();		// same history.go(-1)
	history.forward();	// same history go(1)	
	*/
}