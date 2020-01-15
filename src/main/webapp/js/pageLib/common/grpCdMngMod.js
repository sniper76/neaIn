
$(document).ready(function() {
   

    onLoadList();
    
    
    
});

function onLoadList(){
    var grpCd = $('#grpCd').val();
    
    var param = {
        "grpCd"        :   grpCd
    };

    //var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/selectGrpCdMngDtlAjax.do?lang="+lang, // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        //traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var reList = result.dtlList;
            
            setValue(reList);
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })

}

function setValue(reList){
    $('#grpNm').val(reList.grpNm);
    $('#regUserNm').val(reList.regUserNm);
    $('#regDt').val(reList.regDt);
    $('#expln').val(reList.expln);

   
    $('input:radio[name=useYn]:input[value=' + reList.useYn + ']').attr("checked", true);
}



function updateGrpCdConf(){
    alertify.confirm(modifyMsg, function (e) {
        if (e) {
            updateGrpCd();
        } else {
            return;
        }
    });
}


function updateGrpCd(){
    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/updateGrpCdMngAjax.do?lang="+lang, // URL
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

function deleteGrpCdConf(){
    alertify.confirm(deleteMsg, function (e) {
        if (e) {
            deleteGrpCd();
        } else {
            return;
        }
    });
}

function deleteGrpCd(){
    
    var grpCd = $('#grpCd').val();
    
    var param = {
        "grpCd"        :   grpCd
    };

    //console.debug(param);
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/deleteGrpCdMngAjax.do?lang="+lang, // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert(result.msg);
                forList();
            }else if(sucCode == "1"){
                alertify.alert(result.msg);
                return;
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