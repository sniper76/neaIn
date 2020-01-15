var UploadHolder = "dext5uploadArea";
var uploadId = "commonUpload";
$(document).ready(function() {

    selectUserInfo();
    if(fileYn == "Y"){
        dext5uploadEvnt();
    }
    

    //selectBulletinConf();

    CKEDITOR.replace('contentKhTxt', {

        height: 500,
        filebrowserImageUploadUrl: '/common/ckeditorImgUpload.do'
    });

    CKEDITOR.replace('contentEnTxt', {

        height: 500,
        filebrowserImageUploadUrl: '/common/ckeditorImgUpload.do'
    });

    

});




function insertBulletinBasic(){
    
	alertify.confirm(saveMsg, function (e) {
		if(e) {
        	var uploadCnt = DEXT5UPLOAD.GetTotalFileCount(uploadId);
			if(uploadCnt > 0){
				// 파일전송
				DEXT5UPLOAD.Transfer('commonUpload');
			}else{
				fnFileFormSave();
			}
		} else {
			alertify.alert(cancelMsg);
		}
	});
}

function fnFileFormSave(){
	var contentKhVal = CKEDITOR.instances.contentKhTxt.getData();
    var contentEnVal = CKEDITOR.instances.contentEnTxt.getData();

    $('#contentKh').val(contentKhVal);
    $('#contentEn').val(contentEnVal);

    var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/insertBulletinBasicAjax.do?pg="+$("#programId").val(), // URL
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

function selectBulletinNotiCnt(){
    if ($("#titleKh").val() == "") {
		alertify.alert(titleKhBlank, function (e) {
	        if (e) {
                $("#titleKh").focus();
	        }
        });
        return;
    }
    if ($("#titleEn").val() == "") {
		alertify.alert(titleEnBlank, function (e) {
	        if (e) {
                $("#titleEn").focus();
	        }
        });
        return;
    }
    if (CKEDITOR.instances.contentKhTxt.getData() == "") {
		alertify.alert(contentKhBlank, function (e) {
	        if (e) {
                $("#contentKhTxt").focus();
	        }
        });
        return;
    }
    if (CKEDITOR.instances.contentEnTxt.getData() == "") {
		alertify.alert(contentEnBlank, function (e) {
	        if (e) {
                $("#contentEnTxt").focus();
	        }
        });
        return;
    }
    
    var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/selectBulletinNotiCntAjax.do?pg="+$("#programId").val(), // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var notiCnt = result.notiCnt;

            var notiYn = $(':radio[name="ntcYn"]:checked').val();

            if(notiYn == "Y"){
                if(notiCnt >= 5){
                    alertify.alert(notiMsg);
                    $("#ntcYn").focus();
                    return;
                }else{
                    insertBulletinBasic();
                  
                }
            }else{
                insertBulletinBasic();
               
            }

        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}

function selectBulletinConf(){

    var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/selectBulletinConfAjax.do?pg="+$("#programId").val(), // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            bulletinConfSet(result);

        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}

function bulletinConfSet(result){
    var fileYn = result.fileYn;
    var fileSize = result.fileSize;
    var fileCnt = result.fileCnt;

    if(fileYn == "Y"){
        $("#attFile").show();
        $("#fileYn").val(fileYn);
        $("#fileSize").val(fileSize);
        $("#fileCnt").val(fileCnt);
    }else{
        $("#attFile").hide();
    }


}


function selectUserInfo(){


    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/selectUserInfoAjax.do", // URL
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
    var pgmId = $("#programId").val();
    location.href = contextPath + "/internal/bulletin/bulletinBasic.do?programId="+pgmId;

}


/*********************************************************************************
 * DEXT5 UPLOAD FUNCTION
 * uploadHolder : call Position
 * new Dext5Upload : call upload module
 **********************************************************************************/
function dext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = UploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	new Dext5Upload(uploadId);

	var fileGrpSeq = $('#fileGrpSeq').val();

	if(fileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : fileGrpSeq
			},
			success: function(data) {

				if(data.result.length > 0){
					for(var i in data.result){
						var obj = data.result[i];
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", uploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("시스템 에러.");
			}
		});
	}
}