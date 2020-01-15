
$(document).ready(function() {

    $('#category').hide();
    $('#cateCnt').val("0");
    $('#bulletinTypeCd').on('change',function(){
        var Type_sel = $(this).val();
        if(Type_sel == "BTC0000000005"){
            $('#category').show();
            cateAdd();
        }else{
            $('#category').hide();
            $('#cateCnt').val("0");
        }
    });

    $("input:radio[name=fileYn]").change(function(){
        console.log("fileYn: "+ $(this).val());
        var value = $(this).val();
        if(value == "Y"){
            $('#fileNum').prop('disabled', false);
            $('#fileCap').prop('disabled', false);
        }else{
            $('#fileNum').prop('disabled', true);
            $('#fileCap').prop('disabled', true);
        }
    });

    
});

function cateAdd(){
    var intId = $("#categoryType div").length + 1;
    if(intId > 10){
        //alert("limit 10 Categories");
        alertify.alert(cateLitMsg);
        return;
    }else{
        var fieldWrapper = $("<div class=\"fieldwrapper\" id=\"field" + intId + "\"/>");
        var fName = $("<input type=\"text\" id=\"cate" + intId + "\" name=\"cate" + intId + "\"/>");
        var fKey = $("<input type=\"hidden\" id=\"cate" + intId + "_key\" name=\"cate" + intId + "_key\"/>");
        if(intId == 1){
            var removeButton = $("");
        }else{
            var removeButton = $("<button type=\"button\" class=\"bbs_btn btn_del\">Del</button>");
        }
        removeButton.click(function() {
            $(this).parent().remove();
            $("#cateCnt").val(intId-1);
        });
        fieldWrapper.append(fName);
        fieldWrapper.append(fKey);
        fieldWrapper.append("&nbsp;");
        fieldWrapper.append(removeButton);
        $("#categoryType").append(fieldWrapper);
        $("#cateCnt").val(intId);
    }
}


function insertBulletinMngConf(){
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            insertBulletinMng();
        } else {
            return;
        }
    });
}

function insertBulletinMng(){

    if($("input:checkbox[name=jobskYn1]").is(":checked") == true) {
        $("#jobskYn").val("Y");
    }else{
        $("#jobskYn").val("N");
    }

    if($("input:checkbox[name=stdtYn1]").is(":checked") == true) {
        $("#stdtYn").val("Y");
    }else{
        $("#stdtYn").val("N");
    }

    if($("input:checkbox[name=employYn1]").is(":checked") == true) {
        $("#employYn").val("Y");
    }else{
        $("#employYn").val("N");
    }

    if($("input:checkbox[name=trnngInsttYn1]").is(":checked") == true) {
        $("#trnngInsttYn").val("Y");
    }else{
        $("#trnngInsttYn").val("N");
    }
  
    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletinMng/insertBulletinMngAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert(successMsg);
                forList();
            }else{
                alertify.alert(errorMsg);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
    

}


function forList(){
    
    location.href = contextPath + "/internal/bulletinMng/bulletinMng.do";
    
}