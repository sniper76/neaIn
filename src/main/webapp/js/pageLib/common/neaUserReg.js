
$(document).ready(function() {

    //onLoadList();
    $("#pwdFailCnt").val(0); 
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

function insertNeaUserConf(){
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            insertNeaUser();
        } else {
            return;
        }
    });
}


function insertNeaUser(){
    
	if ($("#userNmKh").val == "") {
		alertify.alert(nmKmBlank, function (e) {
	        	$("#userNmKh").focus();
	    });
		return;
	}
	
	if ($("#userNmEn").val == "") {
		alertify.alert(nmEnBlank, function (e) {
	        	$("#userNmEn").focus();
	    });
		return;
	}
	
	if ($("#userId").val == "") {
		alertify.alert(mngIdRuleInvalid, function (e) {
	        	$("#userId").focus();
	    });
		return;
	}
	
	if ($("#userPwd").val == "") {
		alertify.alert(passwdBlank, function (e) {
	        	$("#userPwd").focus();
	    });
		return;
	}
	
	if ($("#userPwdconf").val == "") {
		alertify.alert(passwdConfirmBlank, function (e) {
	        	$("#userPwdconf").focus();
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
	
	if ($("#userTel").val == "") {
		alertify.alert(tellNumberBlank, function (e) {
	        	$("#userTel").focus();
	    });
		return;
	}
	
	if ($("#userEmail").val == "") {
		alertify.alert(emailBlank, function (e) {
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
	
	if ($("#userCell").val == "") {
		alertify.alert(cellNumberBlank, function (e) {
	        	$("#userCell").focus();
	    });
		return;
	}
	
	if ($("#pwdFailCnt").val == "") {
		alertify.alert(pwdFailCntBlank, function (e) {
	        	$("#pwdFailCnt").focus();
	    });
		return;
	}
	
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/insertNeaUserAjax.do?lang="+lang, // URL
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