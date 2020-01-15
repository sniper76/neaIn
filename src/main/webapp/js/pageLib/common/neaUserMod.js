
$(document).ready(function() {

    onLoadList();
    $("#alert-danger").hide(); 

    $("#userPwdconf").on("propertychange keyup paste input", function(){
        var pwd1=$("#userPwd").val(); 
        var pwd2=$("#userPwdconf").val(); 
        if(pwd1 != "" || pwd2 != ""){ 
            if(pwd1 == pwd2){ 
                //$("#alert-success").show(); 
                $("#alert-danger").hide(); 
                $("#save").attr('disabled', false); 
            }else{ 
                //$("#alert-success").hide(); 
                $("#alert-danger").show(); 
                $("#save").attr('disabled', true); 
            } 
        }
    });

    $("#userPwd").change(function(){
        checkPassword($('#userPwd').val(),$('#userId').val());
    });
});

function onLoadList(){
    var userSeq = $('#userSeq').val();
    
    var param = {
        "userSeq"        :   userSeq,
        "lang"           :   lang
    };

    //var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/selectNeaUserMngDtlAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        //traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var reList = result.dtlList;
            
            setPopUpValue(reList);
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })

}

function setPopUpValue(reList){
	
	console.log(reList);
	
    $('#userNmKh').val(reList.userNmKh);
    $('#userNmEn').val(reList.userNmEn);
    $('input:radio[name=genderCd]:input[value=' + reList.genderCd + ']').attr("checked", true);
    $('#mngId').val(reList.mngId);
    $('input:radio[name=workRetireCd]:input[value=' + reList.workRetireCd + ']').attr("checked", true);
    $('#userPwd').val(reList.userPwd);
    $('#oldPwd').val(reList.userPwd);
    $('#userPwdconf').val(reList.userPwd);
    $('#userTel').val(reList.userTel);
    $('#userEmail').val(reList.userEmail);
    $('#userCell').val(reList.userCell);
    $('input:radio[name=useYn]:input[value=' + reList.useYn + ']').attr("checked", true);
    $('#addrCd').val(reList.addrCd);
    $('#addrFullCd').val(reList.addrFullCd);
    var fullNm = "";
    
    if (reList.addrFullNm != null && reList.addrFullNm != undefined) {
    	fullNm = replaceAll(reList.addrFullNm,"&gt",">");
    }
    
    $('#addrFullNm').val(fullNm.replace(/;/g," "));
    $('#addrDtl').val(reList.addrDtl);
    $('#pwdFailCnt').val(reList.pwdFailCnt);

}

function replaceAll(str, searchStr, replaceStr) {
    return str.split(searchStr).join(replaceStr);
}
  


function checkPassword(password,id){
        
    if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/.test(password)){
        alertify.alert(passchkMsg);            
        $('#userPwd').val('').focus();
        return false;
    }    
    /*
    var checkNumber = password.search(/[0-9]/g);
    var checkEnglish = password.search(/[a-z]/ig);
    if(checkNumber <0 || checkEnglish <0){
        alert("숫자와 영문자를 혼용하여야 합니다.");
        $('#userPwd').val('').focus();
        return false;
    }
    if(/(\w)\1\1\1/.test(password)){
        alert('같은 문자를 4번 이상 사용하실 수 없습니다.');
        $('#password').val('').focus();
        return false;
    }
        
    if(password.search(id) > -1){
        alert("비밀번호에 아이디가 포함되었습니다.");
        $('#userPwd').val('').focus();
        return false;
    }*/
    return true;
}

function updateNeaUserConf(){
    alertify.confirm(modifyMsg, function (e) {
        if (e) {
            updateNeaUser();
        } else {
            return;
        }
    });
}


function updateNeaUser(){
    if ($("#userNmKh").val == "") {
		alertify.alert(nmKmBlank, function (e) {
	        if (e) {
	        	$("#userNmKh").focus();
	        }
	    });
	}
	
	if ($("#userNmEn").val == "") {
		alertify.alert(nmEnBlank, function (e) {
	        if (e) {
	        	$("#userNmEn").focus();
	        }
	    });
	}
	
	if ($("#userId").val == "") {
		alertify.alert(mngIdRuleInvalid, function (e) {
	        if (e) {
	        	$("#userId").focus();
	        }
	    });
	}
	
	if ($("#userPwd").val == "") {
		alertify.alert(passwdBlank, function (e) {
	        if (e) {
	        	$("#userPwd").focus();
	        }
	    });
	}
	
	if ($("#userPwdconf").val == "") {
		alertify.alert(passwdConfirmBlank, function (e) {
	        if (e) {
	        	$("#userPwdconf").focus();
	        }
	    });
	}
	
	var pwdBool = common.string.checkerPassword($("#userPwd").val());
	if (pwdBool) {
		alertify.alert(userPwdValidError, function(e) {
			$("#userPwd").focus();
		});
		return;
	}
	
	if ($("#userTel").val == "") {
		alertify.alert(tellNumberBlank, function (e) {
	        if (e) {
	        	$("#userTel").focus();
	        }
	    });
	}
	
	if ($("#userEmail").val == "") {
		alertify.alert(emailBlank, function (e) {
	        if (e) {
	        	$("#userEmail").focus();
	        }
	    });
	}
	
	var emailBool = common.form.checkEmailVal($("#userEmail").val(),emailValid);
	
	if(!emailBool) {
		alertify.alert(emailValid, function(e) {
			$("#userEmail").focus();
		});
		return;
	}
	
	if ($("#userCell").val == "") {
		alertify.alert(cellNumberBlank, function (e) {
	        if (e) {
	        	$("#userCell").focus();
	        }
	    });
	}
	
	if ($("#pwdFailCnt").val == "") {
		alertify.alert(pwdFailCntBlank, function (e) {
	        if (e) {
	        	$("#pwdFailCnt").focus();
	        }
	    });
	}
    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/updateNeaUserAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert(result.msg);
                forList();
            }else{
                alertify.alert(result.msg);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })

}

function deleteNeaUserConf(){
    alertify.confirm(deleteMsg, function (e) {
        if (e) {
            deleteNeaUser();
        } else {
            return;
        }
    });
}

function deleteNeaUser(){
    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/deleteNeaUserAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert(result.msg);
                forList();
            }else{
                alertify.alert(result.msg);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })

}

function authMngAction(){
		
	$("#frm").attr("method", "post");
	var urlChk = $("#urlChk").val();
	
	if(urlChk == "nea"){
		$("#frm").attr("action", contextPath + "/internal/common/mngerNeaMenuAuth.do");
	}else if(urlChk == "nonNea"){
		$("#frm").attr("action", contextPath + "/internal/common/mngerNoneNeaMenuAuth.do");
    }else if(urlChk == "jobCenter"){
    	$("#frm").attr("action", contextPath + "/internal/common/mngerJcMenuAuth.do");
    }
	$("#frm").submit();
}

function forList(){
    var urlChk = $("#urlChk").val(); 

    if(urlChk == "nea"){
        location.href = contextPath + "/internal/common/neaUserList.do";
    }else if(urlChk == "nonNea"){
        location.href = contextPath + "/internal/common/nonNeaUserList.do";
    }else if(urlChk == "jobCenter"){
        location.href = contextPath + "/internal/common/jobCenterUserList.do";
    }
}



function passwrdReset() {
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