var uploadHoler = "dext5uploadArea";
var uploadId = "commonUpload";
$(document).ready(function() {

    //onLoadList();

    if(fileYn == "Y"){
        dext5uploadEvnt();
    }


});



function updateBulletinBasicConf(){
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
    alertify.confirm(modifyMsg, function (e) {
        if (e) {
            var uploadCnt = DEXT5UPLOAD.GetTotalFileCount(uploadId);
			if(uploadCnt > 0){
				// 파일전송
				DEXT5UPLOAD.Transfer('commonUpload');
			}else{
				fnFileFormSave();
			}
        } else {
            return;
        }
    });
}

function deleteBulletinBasicConf(){
    alertify.confirm(deleteMsg, function (e) {
        if (e) {
            deleteBulletinBasic();
        } else {
            return;
        }
    });
}

function fnFileFormSave(){

    var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/updateBulletinDtlAjax.do?pg="+$("#programId").val(), // URL
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


function deleteBulletinBasic(){

    var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/deleteBulletinDtlAjax.do?pg="+$("#programId").val(), // URL
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

function onLoadList(){

    var bulletinSeq = $('#bulletinSeq').val();

    var param = {
        "bulletinSeq"        :   bulletinSeq
    };

    //var param = $("#frm").serialize();

    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/selectBulletinDtlAjax.do?pg="+$("#programId").val(), // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        //traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var reList = result.dtlList;

            setBullletinValue(reList);

        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}

function setBullletinValue(reList){
    $('#titleKh').val(reList.titleKh);
    $('#titleEn').val(reList.titleEn);
    $('#writerNm').val(reList.writerNm);
    $('#writeDt').val(reList.writeDt);
    $('#likeCnt').val(reList.likeCnt);
    $('#viewCnt').val(reList.viewCnt);

    $('input:radio[name=viewYn]:input[value=' + reList.viewYn + ']').attr("checked", true);
    $('input:radio[name=noticeYn]:input[value=' + reList.noticeYn + ']').attr("checked", true);



}

function forList(){
    var pgmId = $("#programId").val();
    location.href = contextPath + "/internal/bulletin/bulletinAtch.do?programId="+pgmId;

}

/*********************************************************************************
 * DEXT5 UPLOAD FUNCTION
 * uploadHolder : call Position
 * new Dext5Upload : call upload module
 **********************************************************************************/
function dext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = uploadHoler;
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