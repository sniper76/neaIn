var uploadHoler = "dext5uploadArea";
var uploadId = "commonUpload";
$(document).ready(function() {

    //onLoadList();

    // ckeditor 입력값
    // CKEDITOR.instances.(ckeditor가 적용된 요소의 id).getData();
    // ex) CKEDITOR.instances.content.getData();
    // ex) CKEDITOR.instances.content.setData('test');
    CKEDITOR.replace('contentKhTxt', {
        height: 500,
        filebrowserImageUploadUrl: '/common/ckeditorImgUpload.do'
    });

    CKEDITOR.replace('contentEnTxt', {

        height: 500,
        filebrowserImageUploadUrl: '/common/ckeditorImgUpload.do'
    });

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
    if (CKEDITOR.instances.contentKhTxt.getData() == "") {
		alertify.alert(contentEnBlank, function (e) {
	        if (e) {
                $("#contentKhTxt").focus();
	        }
        });
        return;
    }
    if (CKEDITOR.instances.contentEnTxt.getData() == "") {
		alertify.alert(contentKhBlank, function (e) {
	        if (e) {
                $("#contentEnTxt").focus();
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
    var contentKhVal = CKEDITOR.instances.contentKhTxt.getData();
    var contentEnVal = CKEDITOR.instances.contentEnTxt.getData();

    $('#contentKh').val(contentKhVal);
    $('#contentEn').val(contentEnVal);

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
    $('#bulletinCateNm').val(reList.bulletinCateNm);
    CKEDITOR.instances.contentKhTxt.setData(reList.contentKh);
    CKEDITOR.instances.contentEnTxt.setData(reList.contentEn);
    //$('#contentKh').val(reList.contentKh);
    //$('#contentEn').val(reList.contentEn);
    $('#likeCnt').val(reList.likeCnt);
    $('#viewCnt').val(reList.viewCnt);

    $('input:radio[name=viewYn]:input[value=' + reList.viewYn + ']').attr("checked", true);
    $('input:radio[name=ntcYn]:input[value=' + reList.ntcYn + ']').attr("checked", true);



}

function forList(){
    var pgmId = $("#programId").val();
    location.href = contextPath + "/internal/bulletin/bulletinFaq.do?programId="+pgmId;

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