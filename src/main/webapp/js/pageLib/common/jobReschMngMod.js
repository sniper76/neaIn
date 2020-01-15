
$(document).ready(function() {
   

    onLoadList();
    
    
    
});

function onLoadList(){
    var iscoCd = $('#iscoCd').val();
    
    var param = {
        "iscoCd"        :   iscoCd
    };

    //var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/selectJobReschMngDtlAjax.do?lang="+lang, // URL
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
    $('#enNm').val(reList.enNm);
    $('#khNm').val(reList.khNm);
    $('#iscoCdtxt').val(reList.iscoCd);
    $('#defEn').val(reList.defEn);
    $('#defKh').val(reList.defKh);
    $('#regUserNm').val(reList.regUserNm);
    $('#regDt').val(reList.regDt);

   
    $('input:radio[name=useYn]:input[value=' + reList.useYn + ']').attr("checked", true);
    $('#jobCateCd').val(reList.jobCateCd).prop("selected",true);
}

function updateJobReschMngConf(){
    alertify.confirm(modifyMsg, function (e) {
        if (e) {
            updateJobReschMng();
        } else {
            return;
        }
    });
}


function updateJobReschMng(){
    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/updateJobReschMngAjax.do", // URL
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
    
    location.href = contextPath + "/internal/common/jobReschMngList.do";
    
}