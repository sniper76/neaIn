var	userDtlInfoReg = {
		name: 'userDtlInfoReg',
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
				
				var userAuthCdVal = $('input[name="userAuthCdTemp"]:checked').val();
		        $("#userAuthCd").val(userAuthCdVal);
		        
		        alert($("#jcCd").val());
		         
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
		        
		        $("#birth").val($("#birthY").val() + "-" + $("#birthM").val() +"-"+ $("#birthD").val());
		        
				if($("#userNmKh").val() == "") {
					alertify.alert(nameBlank, function(e) {
						$("#userNmKh").focus();
					});
					return;
				}
				
				if($("#userNmEn").val() == "") {
					alertify.alert(nameBlank, function(e) {
						$("#userNmEn").focus();
					});
					return;
				}
				
				if ($("#userEmail").val() == "") {
					alertify.alert(emailBlank, function(e) {
						$("#userEmail").focus();
					});
					return;
				}
				
				var emailBool = common.form.checkEmailVal($("#userEmail").val(),emailValid);
				
				if(!emailBool) {
					alertify.alert(emailValid, function(e) {
						$("#userEmail").focus();
					});
					return;
				}
				
				if ($("#userCell").val() == "") {
					alertify.alert(userCellBlank, function(e) {
						$("#userCell").focus();
						
					});
					return;
				}
				
				if ($("#userPwd").val() == "") {
					alertify.alert(passwordBlank, function(e) {
						$("#userPwd").focus();
						
					});
					return;
				}
				
				if ($("#userPwdConfirm").val() == "") {
					alertify.alert(passwordConfirmBlank, function(e) {
						$("#userPwdConfirm").focus();
					});
					return;
				}
				
				var pwdBool = common.string.checkerPassword($("#userPwd").val());
				if (pwdBool) {
					alertify.alert(userPwdValidError, function(e) {
						$("#userPwd").focus();
					});
					return;
				}
				
				if ($("#userPwd").val() != $("#userPwdConfirm").val()) {
					alertify.alert(passwordNotEqual, function(e) {
						$("#userPwdConfirm").focus();
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
				
				if ($("#duplEmailCheck").val() == 'N') {
					alertify.alert(chkDuplEmailError, function(e) {
						$("#userEmail").focus();
					});
					return;
				}
				if ($("#duplCellCheck").val() == 'N') {
					alertify.alert(chkDuplCellError, function(e) {
						$("#usercell").focus();
					});
					return;
				}
				
				alertify.confirm(confirmMsg, function (e) {
					if(e) {
						var param = $("#frm").serializeObject();
						var	opts = {
								url		: contextPath + "/internal/user/insertUserDtlInfoAjax.do",
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
			
			$("#duplCheckEmail").click(function(){
				userDtlInfoReg.fn.checkDuplEmail();
			});
			
			$("#duplCheckCell").click(function(){
				userDtlInfoReg.fn.checkDuplCell();
			});
			
			$("#searchAddr").click(function(){
				userDtlInfoReg.fn.searchAddr();
			});
			

		},
		
		fn: {
			changeSaveForm : function() {
				if ($("#chgAgreeStsCd option:selected").val() == 'CAS0000000002' || $("#chgAgreeStsCd option:selected").val() == 'CAS0000000003') {
					$("#chgAgreeStsCd option").not(":selected").prop("disabled", "disabled");
					$("#agreeRejectReason").prop("readonly",true);
				} else 	{
					
				}
			}, 
			checkDuplEmail : function() {
				
				if ($("#userEmail").val() == "") {
					alertify.alert(emailBlank, function(e) {
						$("#userEmail").focus();
					});
					return;
				}
				
				var emailBool = common.form.checkEmailVal($("#userEmail").val(),emailValid);
				
				if(!emailBool) {
					alertify.alert(emailValid, function(e) {
						$("#userEmail").focus();
					});
					return;
				}
				
				var param = $("#frm").serializeObject();
				var	opts = {
						url		: contextPath + "/internal/user/selectUserEmailDuplAjax.do",
						data	: param,
						type	: "post",
						sendDataType	: "json",
						success	: function(resJSON, resCode) {
							// failed
							if(resJSON.data.resultCode != '0000') {
								alertify.alert(resJSON.data.msg,function(e){
									return false;
								});
								
							} else {
								alertify.alert(resJSON.data.msg,function(e) {
									$("#duplEmailCheck").val("Y");
								});
							}
							
						},
						error : function() {
							
						}
					};
					common.http.ajax(opts);
			}, 
			checkDuplCell : function() {
				
				if ($("#userCell").val() == "") {
					alertify.alert(userCellBlank, function(e) {
						$("#userCell").focus();
						
					});
					return;
				}
				
				var param = {"userCell" : $("#userCell").val()}
				var	opts = {
						url		: contextPath + "/internal/user/selectUserCellDuplAjax.do",
						data	: param,
						type	: "post",
						sendDataType	: "json",
						success	: function(resJSON, resCode) {
							// failed
							if(resJSON.data.resultCode != '0000') {
								alertify.alert(resJSON.data.msg,function(e){
									return false;
								});
							} else {
								alertify.alert(resJSON.data.msg,function(e) {
									$("#duplCellCheck").val("Y");
								});
							}
							
						},
						error : function() {
							
						}
					};
					common.http.ajax(opts);
			},
			
			resetEmailDub : function () {
				$("#duplEmailCheck").val("N");
			},
			 
			resetCellDub : function () {
				$("#duplCellCheck").val("N");
			}
		}
		
		
}