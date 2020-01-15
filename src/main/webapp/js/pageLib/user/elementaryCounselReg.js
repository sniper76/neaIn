
$(document).ready(function() {

   
    CKEDITOR.replace('txtAnsContent', {
       
        height: 500,
        filebrowserImageUploadUrl: '/common/ckeditorImgUpload.do'
    });
    
});


function insertElemtryCounselConf(){
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            insertElemtryCounsel();
        } else {
            return;
        }
    });
}

function insertElemtryCounsel(){
    var contentVal = CKEDITOR.instances.txtAnsContent.getData();

    $('#ansContent').val(contentVal);
    
    var param = $("#frmCourseReg").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/user/insertElemtryCounselAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert(successMsg);
                tabCounselDtlInfo();
            }else{
                alertify.alert(errorMsg);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
    

}




function forList(){
    
    location.href = contextPath + "/internal/bulletin/bulletinBasic.do?programId="+pgmId;
    
}