
$(document).ready(function() {

    //onLoadList();

	$('#uploadImgFile').on('change', function(e){
		var files = e.target.files;
		var fileList = Array.prototype.slice.call(files);

		fileList.forEach(function(f){
			if(!f.type.match("image.*")){
				alertify.alert("<spring:message code='error.insertFile.onlyImgFile'/>");
				return false;
			}

			var reader = new FileReader();
			reader.onload = function(event){
				$('#uploadImg').attr("src", event.target.result);
			}
			reader.readAsDataURL(f);

		});

		$('#uploadImg').show();
	});

});


function insertJobCenterConf(){
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            insertJobCenter();
        } else {
            return;
        }
    });
}


function insertJobCenter(){

    var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/insertJobCenterAjax.do?lang="+lang, // URL
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

    location.href = contextPath + "/internal/common/jobCenterList.do";

}