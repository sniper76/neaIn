var	Login = {
	//----------------------------
	// InfoIndex 객체
	//----------------------------

	init: function() {
		this.beforeBind();
		this.bind();
		this.afterBind();
	},

	beforeBind: function() {
	},

	bind: function() {
		
	},

	afterBind: function() {
		
	},
	fn: {
		
		
		getSeachId : function() {
			
			$(".find_box").empty();
			
			if ($("#userNm").val() == "") {
				alertify.alert("Please enter User Name", function (e){
						$("#userNm").focus();
				});
				
				return false;
			} 
			
			if ($("#userEmail").val() == "") {
				alertify.alert("Please enter User Email", function (e){
						$("#userEmail").focus();
				});
				
				return false;
			}
			
			var param = $("#frm").serializeObject();
			
			var	opts = {
					url		: contextPath + "/selectSearchIdAjax.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						// failed
						if(resJSON.data.resultCode != '0000') {
							alertify.alert(resJSON.data.msg);
						} else {
							var html = '';
								html +='	<div class="find_cont">';
								html +='		<p>Your ID is <strong>'+resJSON.data.mngId+'</strong></p>';
								html +='	</div>';
								html +='	<div class="find_put">';
								html +='		<a href="'+contextPath+'/authLogin.do">LOGIN</a>';
								html +='		<a href="'+contextPath+'/searchPwd.do">SEARCH PW</a>';
								html +='	</div>';
							$(".find_box").append(html);
						}
						
					},
					error : function() {
						alertify.alert(resJSON.data.msg);
					}
				};
				common.http.ajax(opts);
		},
		
		getSeachPwd : function() {
			
			if ($("#mngId").val() == "") {
				alertify.alert("Please enter Manager ID", function (e){
						$("#mngId").focus();
				});
				
				return false;
			} 
			
			if ($("#userNm").val() == "") {
				alertify.alert("Please enter User Name", function (e){
						$("#userNm").focus();
				});
				
				return false;
			} 
			
			if ($("#userEmail").val() == "") {
				alertify.alert("Please enter User Email", function (e){
						$("#userEmail").focus();
				});
				
				return false;
			}
			
			var param = $("#frm").serializeObject();
			
			var	opts = {
					url		: contextPath + "/selectSearchPwdAjax.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						// failed
						if(resJSON.data.resultCode != '0000') {
							alertify.alert(resJSON.data.msg);
						} else {
							location.href=contextPath + "/updatePwd.do";
						}
					},
					error : function() {
						
					}
				};
				common.http.ajax(opts);
		},
		
		setAuthPwd : function() {
			if ($("#emailUserAuthValue").val() == "") {
				alertify.alert("Please enter Verification number", function (e){
						$("#emailUserAuthValue").focus();
				});
				
				return false;
			} 
			
			if ($("#userNewPwd").val() == "") {
				alertify.alert("Please enter New Password", function (e){
						$("#userNewPwd").focus();
				});
				
				return false;
			} 
			
			if ($("#confirm_new_password").val() == "") {
				alertify.alert("Please enter Confirm Password", function (e){
						$("#confirm_new_password").focus();
				});
				
				return false;
			}
			
			if($("#userNewPwd").val() != $("#confirm_new_password").val()) {
				alertify.alert("incorrect the confirm password", function (e){
						$("#confirm_new_password").focus();
				});
				return false;
			}
			
			var pwdBool = common.string.checkerPassword($("#userNewPwd").val());
			if (pwdBool) {
				alertify.alert(userPwdValidError, function(e) {
					$("#userNewPwd").focus();
				});
				return;
			}
			
			var param = $("#frm").serializeObject();
			
			var	opts = {
					url		: contextPath + "/updateAuthPwdAjax.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						// failed
						if(resJSON.data.resultCode != '0000') {
							alertify.alert(resJSON.data.msg);
						} else {
							alertify.alert(resJSON.data.msg, function (e){
									location.href=contextPath + "/authLogin.do";
							});
						}
					},
					error : function() {
						
					}
				};
				common.http.ajax(opts);
		},
		
		setNewPwd : function() {
			if ($("#userPwd").val() == "") {
				alertify.alert("Please enter Current your password", function (e){
						$("#userPwd").focus();
				});
				
				return false;
			} 
			
			if ($("#userNewPwd").val() == "") {
				alertify.alert("Please enter New Password", function (e){
						$("#userNewPwd").focus();
				});
				
				return false;
			} 
			
			if ($("#confirm_new_password").val() == "") {
				alertify.alert("Please enter Confirm Password", function (e){
						$("#confirm_new_password").focus();
				});
				
				return false;
			}
			
			if($("#userNewPwd").val() != $("#confirm_new_password").val()) {
				alertify.alert("incorrect the confirm password", function (e){
						$("#confirm_new_password").focus();
				});
				return false;
			}
			
			var param = $("#frm").serializeObject();
			
			var	opts = {
					url		: contextPath + "/updateOverDuraPwdAjax.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						// failed
						if(resJSON.data.resultCode != '0000') {
							alertify.alert(resJSON.data.msg);
							return false;
						}
						alertify.alert(resJSON.data.msg, function (e){
								location.href=contextPath + "/internal/index.do";
						});
					},
					error : function() {
						
					}
				};
				common.http.ajax(opts);
		}
	}
}

$(document).ready(function(){
    var cpesMngId = getCookie("cpesMngId");
    $("input[name='mngId']").val(cpesMngId); 
     
    if($("input[name='mngId']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idSaveCheck").prop("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            var cpesMngId = $("input[name='mngId']").val();
            setCookie("cpesMngId", cpesMngId, 1000); // save for 1000 days
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("cpesMngId");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("input[name='id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var cpesMngId = $("input[name='mngId']").val();
            setCookie("cpesMngId", cpesMngId, 7); // 7일 동안 쿠키 보관
        }
    });
});

function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}