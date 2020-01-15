
$(document).ready(function() {
    common.sys.getDatepicker();
    $('#bgnDt').datepicker('setDate', 'today');
    $('#endDt').datepicker('setDate', '1D');

    //현재시간 가져오기
    var now = new Date();
    var hour = now.getHours();
    var mint = now.getMinutes();
    var amOrPm = (hour < 12) ? "AM" : "PM";
    hour = hour % 12;
    mint = (mint < 10) ? "0"+mint : mint;
    hour = (hour < 10) ? "0"+hour : hour;

    $('#bgnAmpm').val(amOrPm).prop("selected",true);
    $('#bgnHour').val(hour).prop("selected",true);
    $('#bgnMinute').val(mint).prop("selected",true);
    $('#endAmpm').val(amOrPm).prop("selected",true);
    $('#endHour').val(hour).prop("selected",true);
    $('#endMinute').val(mint).prop("selected",true);
    
    $("#endNtDt").change(function(){
        if($("#endNtDt").is(":checked")){
            $('#endAmpm').attr('disabled', 'true');
            $('#endHour').attr('disabled', 'true');
            $('#endMinute').attr('disabled', 'true');
            $('#endDt').prop('disabled', true);
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

    selectUserInfo();

    
   


    
});

function insertPopUpConf(){
    alertify.confirm("do you Save?", function (e) {
        if (e) {
            insertPopUp();
        } else {
            return;
        }
    });
}


function insertPopUp(){

    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/sitemgmt/insertPopUp.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert("Save Complete");
                forList();
            }else{
                alertify.alert("Save failed");
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
    

}



function selectUserInfo(){


    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/selectUserInfo.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        //data : param,
        success : function(result) { // 결과 성공
            var userNm = result.userNm;
            $("#writerNm").val(userNm);
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}


function forList(){
    
    location.href = contextPath + "/internal/sitemgmt/popUpList.do";
    
}