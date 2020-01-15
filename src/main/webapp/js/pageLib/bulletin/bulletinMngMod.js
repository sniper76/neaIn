
$(document).ready(function() {

    onLoadList();

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



function updateBulletinMngConf(){
    alertify.confirm(modifyMsg, function (e) {
        if (e) {
            updateBulletinMng();
        } else {
            return;
        }
    });
}

function deleteBulletinMngConf(){
    alertify.confirm(deleteMsg, function (e) {
        if (e) {
            deleteBulletinMng();
        } else {
            return;
        }
    });
}

function updateBulletinMng(){
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
        url :  contextPath + "/internal/bulletinMng/updateBulletinMNGAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            if(result.stat == "0000"){
                forList();
            }else{
                alertify.alert(errorMsg);
            }
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}


function deleteBulletinMng(){
   
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletinMng/deleteBulletinMngAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            if(result.stat == "0000"){
                forList();
            }else if(result.stat == "9999"){
                alertify.alert(alMenuMsg);
            }else{
                alertify.alert(errorMsg);
            }
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}

function onLoadList(){

    var bulletinMngSeq = $('#bulletinMngSeq').val();
    
    var param = {
        "bulletinMngSeq"        :   bulletinMngSeq
    };

    //var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletinMng/selectBulletinMNGDtlAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        //traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var reList = result.bulldtlList;
            var cateList = result.bulletinCateBean;
            var cateSize = result.bulletinCateBean.length;

            console.log("reList: "+reList);
            
            setBulMngValue(reList);

            if(cateSize != null || cateSize != ""){
                crCate(cateList);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}

function crCate(cateList){
    var intId = 1;
    //console.log("length: "+cateList.length);
    for(var i=0; i < cateList.length; i++){
        
        cateAdd();
        //category value set
        $('#cate'+intId).val(cateList[i].bulletinCateNm);
        $('#cate'+intId+'_key').val(cateList[i].bulletinCateSeq);
        intId++;
    }
}

function setBulMngValue(reList){
    $('#bulletinNm').val(reList.bulletinNm);
    $('#programId').val(reList.programId);
    $('#bulletinTypeCd').val(reList.bulletinTypeCd).prop("selected",true);
    if(reList.bulletinTypeCd == "BTC0000000005"){
        $('#category').show();
    }else{
        $('#category').hide();
        $('#cateCnt').val("0");
    }
    //$("select[name='bulletinRange']").val(reList.bulletinRangeCd).attr("selected","selected");
    $('input:radio[name=bulletinRange]:input[value=' + reList.bulletinRangeCd + ']').attr("checked", true);
    $('#content').val(reList.content);
    
    if(reList.jobskYn == "Y"){
        $('#jobskYn1').prop("checked",true);
    }else{
        $('#jobskYn1').prop("checked",false);
    }
    if(reList.stdtYn == "Y"){
        $('#stdtYn1').prop("checked",true);
    }else{
        $('#stdtYn1').prop("checked",false);
    }
    if(reList.employYn == "Y"){
        $('#employYn1').prop("checked",true);
    }else{
        $('#employYn1').prop("checked",false);
    }
    if(reList.trnngInsttYn == "Y"){
        $('#trnngInsttYn1').prop("checked",true);
    }else{
        $('#trnngInsttYn1').prop("checked",false);
    }

    $('input:radio[name=fileYn]:input[value=' + reList.fileYn + ']').attr("checked", true);
    $('#fileNum').val(reList.fileQty).prop("selected",true);
    $('#fileCap').val(reList.fileSize);
    $('input:radio[name=likeYn]:input[value=' + reList.likeYn + ']').attr("checked", true);
    //$("select[name='useYn']").val(reList.useYn).attr("checked",true);
    //$('input:radio[name=useYn]:input[value='+ reList.useYn +']').attr("checked",true);
    $('input:radio[name=useYn]:input[value=' + reList.useYn + ']').attr("checked", true);

}

function forList(){
    
    location.href = contextPath + "/internal/bulletinMng/bulletinMng.do";
    
}