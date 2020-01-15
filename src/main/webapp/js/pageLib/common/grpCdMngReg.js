
$(document).ready(function() {
   

    //onLoadList();
    
    
    
});

function chkGrpCode(){
    var grpCd = $('#grpCd').val();

    if(grpCd == null || grpCd == "Undefined" || grpCd == ""){
        alertify.alert(emptyMsg);
        $('#grpCd').focus();
        return;
    }
    
    var param = {
        "grpCd"        :   grpCd
    };

    //var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/selectChkGrpCdAjax.do?lang="+lang, // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        //traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var stat = result.stat;

            if(stat > 0){
                alertify.alert(result.msg);
                $('#grpCd').val("");
                $('#grpCd').focus();
            }else{
                alertify.alert(result.msg);
            }
            
            
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}



function insertGrpCdConf(){
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            insertGrpCd();
        } else {
            return;
        }
    });
}


function insertGrpCd(){
    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/insertGrpCdMngAjax.do", // URL
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
    
    location.href = contextPath + "/internal/common/grpCdMngList.do";
    
}