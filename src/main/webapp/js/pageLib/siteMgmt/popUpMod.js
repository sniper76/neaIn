
$(document).ready(function() {
    common.sys.getDatepicker();

    onLoadList();
    
    
    $("#endNtDt").change(function(){
        if($("#endNtDt").is(":checked")){
            $('#endAmpm').attr('disabled', 'true');
            $('#endHour').attr('disabled', 'true');
            $('#endMinute').attr('disabled', 'true');
            $('#endDt').prop('disabled', true);

            $('#endDt').val("");
            $('#endHour').val("").prop("selected",true);
            $('#endMinute').val("").prop("selected",true);
            $('#endAmpm').val("").prop("selected",true);
        }else{
            $('#endAmpm').removeAttr('disabled');
            $('#endHour').removeAttr('disabled');
            $('#endMinute').removeAttr('disabled');
            $('#endDt').prop('disabled', false);
        }
    });

    $("input:radio[name=resvYn]").click(function(){
        var resvYn = $(':radio[name="resvYn"]:checked').val();
        if(resvYn == "Y"){
            $('#strDiv').show();
            $('#endDiv').show();
        }else{
            $('#strDiv').hide();
            $('#endDiv').hide();
        }
    });


    
   


    
});

function onLoadList(){
    var popupSeq = $('#popupSeq').val();
    
    var param = {
        "popupSeq"        :   popupSeq
    };

    //var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/sitemgmt/selectPopUpDtlAjax.do", // URL
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
    $('#title').val(reList.title);
    $('#content').val(reList.content);
    $('#regDt').val(reList.regDt);
    $('#writerNm').val(reList.regUserNm);
    $('#bgnDt').val(reList.bgnDt);
    $('#endDt').val(reList.endDt);

    if(reList.endDate == "9999"){
        $('#endAmpm').attr('disabled', 'true');
        $('#endHour').attr('disabled', 'true');
        $('#endMinute').attr('disabled', 'true');
        $('#endDt').prop('disabled', true);
        $('#endNtDt').prop("checked",true);
        
        $('#endHour').val("").prop("selected",true);
        $('#endMinute').val("").prop("selected",true);
        $('#endAmpm').val("").prop("selected",true);
    }else{
        $('#endHour').val(reList.endHour).prop("selected",true);
        $('#endMinute').val(reList.endMinute).prop("selected",true);
        $('#endAmpm').val(reList.endAmpm).prop("selected",true);
    }

    $('#bgnHour').val(reList.bgnHour).prop("selected",true);
    $('#bgnMinute').val(reList.bgnMinute).prop("selected",true);
    $('#bgnAmpm').val(reList.bgnAmpm).prop("selected",true);
}

function updatePopUpConf(){
    alertify.confirm("do you Modify?", function (e) {
        if (e) {
            updatePopUp();
        } else {
            return;
        }
    });
}


function updatePopUp(){
    var resvYn = $(':radio[name="resvYn"]:checked').val();
    if(resvYn == "N"){
        $('#endDt').val("");
        $('#endHour').val("").prop("selected",true);
        $('#endMinute').val("").prop("selected",true);
        $('#endAmpm').val("").prop("selected",true);

        $('#bgnDt').val("");
        $('#bgnHour').val("").prop("selected",true);
        $('#bgnMinute').val("").prop("selected",true);
        $('#bgnAmpm').val("").prop("selected",true);
    }

    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/sitemgmt/updatePopUpAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert("Modify Complete");
                forList();
            }else{
                alertify.alert("Modify failed");
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
    

}


function deletePopUpConf(){
    alertify.confirm("do you Delete?", function (e) {
        if (e) {
            deletePopUp();
        } else {
            return;
        }
    });
}

function deletePopUp(){
   
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/sitemgmt/deletePopUpDtlAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            if(result.stat == "0000"){
                forList();
            }else{
                alertify.alert("delete failed");
            }
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}




function forList(){
    
    location.href = contextPath + "/internal/sitemgmt/popUpList.do";
    
}