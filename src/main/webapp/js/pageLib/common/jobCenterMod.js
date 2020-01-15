
$(document).ready(function() {

    onLoadList();



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

function onLoadList(){
    var jcCd = $('#jcCd').val();

    var param = {
        "jcCd"        :   jcCd
    };

    //var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/selectJobCenterDtlAjax.do?lang="+lang, // URL
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
    $('#regUserNm').val(reList.regUserNm);
    $('#regDt').val(reList.regDt);
    $('#jcEn').val(reList.jcEn);
    $('#jcKh').val(reList.jcKh);
    $('#jcCd').val(reList.jcCd);
    $('#addrCd').val(reList.addrCd);
    $('#addrFullCd').val(reList.addrFullCd);
    var fullNm = replaceAll(reList.addrFullNm,"&gt",">");
    $('#addrFullNm').val(fullNm.replace(/;/g," "));
    $('#addrEn').val(reList.addrEn);
    $('#addrKh').val(reList.addrKh);
    $('#mapLink').val(reList.mapLink);
    $('#tel1').val(reList.tel1);
    $('#tel2').val(reList.tel2);
    $('#email').val(reList.email);
    $('#useYn').val(reList.useYn);
    $('#uploadImg').attr('src', contextPath + '/common/imgLoading.do?url=' + reList.filePath);
}

function updateJobCenterConf(){
    alertify.confirm("do you Modify?", function (e) {
        if (e) {
            updateJobCenter();
        } else {
            return;
        }
    });
}


function updateJobCenter(){


    //var param = $("#frm").serialize();

    var form = $('#frm')[0];
	var formData = new FormData(form);
	formData.append("uploadImgFile", $('#uploadImgFile')[0].files[0]);

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/updateJobCenterAjax.do?lang="+lang, // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        //traditional: true,
        data : formData,
        contentType: false,
		processData: false,
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


function deleteJobCenterConf(){
    alertify.confirm("do you Delete?", function (e) {
        if (e) {
            deleteJobCenter();
        } else {
            return;
        }
    });
}

function deleteJobCenter(){

    var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/deleteJobCenterDtlAjax.do?lang="+lang, // URL
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

    location.href = contextPath + "/internal/common/jobCenterList.do";

}