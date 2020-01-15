var teachFileUploadHolder = "teachFileDext5uploadArea";
var uploadId = "commonUpload";
var resumeInsertErrorMsg = "<spring:message code='resume.write.insert.error'/>";
var	workshopReg = {
		name: 'workshopReg',
		dataTables: null,
		commCode: {},
		init: function() {

			var that$ = this;
			$.when( that$.beforeBind() ).done(function( res ) {
				that$.bind();
				that$.afterBind();
			});
		},

		beforeBind: function() {

			dext5uploadEvnt();

			$("#workshopDt").datepicker({
                dateFormat: 'dd/mm/yy' //Input Display Format 변경
                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
                ,changeYear: true //콤보박스에서 년 선택 가능
                ,changeMonth: true //콤보박스에서 월 선택 가능
                ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
                ,buttonImage: "/images/common/btn_calender.png" //버튼 이미지 경로
                ,buttonImageOnly: false //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
                ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트
                ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
        		,minDate: '-1Y' //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
        		,maxDate: '+1Y' //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
        		,beforeShow: function(input, inst) {
                    setTimeout(function() {
                        $('.ui-datepicker').css('z-index', 99999999999999);
                    }, 0);
                }
            });

			fnInputValidation('inputNo', '1');
			//fnCheckEmail('inputEmail');

			$('.previewImgFile').on('change', function(e){
				var files = e.target.files;
				var fileList = Array.prototype.slice.call(files);

				fileList.forEach(function(f){
					if(!f.type.match("image.*")){
						alertify.alert("<spring:message code='error.insertFile.onlyImgFile'/>");
						return false;
					}

					var reader = new FileReader();
					reader.onload = function(event){
						$(e.target).closest('td').find('.previewImg').attr("src", event.target.result);
					}
					reader.readAsDataURL(f);

				});

    		});

			$('input[name=tuitionGrpCd]').on('change', function(){
				var checkVal = $(this).val();

				if(checkVal == "TGC0000000002"){
					$('#tuition').attr('readonly', false);
				}else{
					$('#tuition').val('');
					$('#tuition').attr('readonly', true);
				}
			});

		},
		bind: function() {
			var that$ = this;
		},

		afterBind: function() {
			var that$ = this;

			$('#btn_list').on('click', function(){
				location.href = contextPath + "/internal/workshop/list.do";
			});

		},

		fn: {

		}
}

/*********************************************************************************
 * DEXT5 UPLOAD FUNCTION
 * uploadHolder : call Position
 * new Dext5Upload : call upload module
 **********************************************************************************/
function dext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = teachFileUploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	DEXT5UPLOAD.config.Views = 'thumbs';
	DEXT5UPLOAD.config.MaxTotalFileCount = '5';
	DEXT5UPLOAD.config.ExtensionAllowOrLimit = '1';
	DEXT5UPLOAD.config.ExtensionArr = 'jpeg,bmp,jpg,gif,png';
	new Dext5Upload(uploadId);

	/*var thumbFileGrpSeq = $('#thumbFileGrpSeq').val();

	if(thumbFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : thumbFileGrpSeq
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
	}*/
}

function insertWorkshopSave(){

	var workshopNm = $('#workshopNm').val();
	var expln = $('#expln').val();
	var workshopDt = $('#workshopDt').val();
	var bgnHour = $('#bgnHour').val();
	var bgnMinute = $('#bgnMinute').val();
	var bgnAmpm = $('#bgnAmpm').val();
	var endHour = $('#endHour').val();
	var endMinute = $('#endMinute').val();
	var endAmpm = $('#endAmpm').val();
	var addrCd = $('#addrCd').val();
	var addrFullCd = $('#addrFullCd').val();
	var addrFullNm = $('#addrFullNm').val();
	var addrFullDtl = $('#addrFullDtl').val();
	var lectureRoom = $('#lectureRoom').val();
	var tuitionGrpCd = $('input[name=tuitionGrpCd]:checked').val();
	var tuition = $('#tuition').val();
	var googleMapLink = $('#googleMapLink').val();
	var mngerNm = $('#mngerNm').val();
	var mngerTel = $('#mngerTel').val();
	var mngerEmail = $('#mngerEmail').val();
	var target = $('#target').val();
	var recurmtMan = $('#recurmtMan').val();
	var teacherNm1 = $('#teacherNm1').val();
	var teacherNm2 = $('#teacherNm2').val();
	var teacherBhist1 = $('#teacherBhist1').val();
	var teacherBhist2 = $('#teacherBhist2').val();
	var useYn = $('input[name=useYn]:checked').val();

	if(workshopNm == ""){
		alertify.alert("워크샵 명을 입력하세요.", function(){
			$('#workshopNm').focus();
		});
		return false;
	}
	if(expln == ""){
		alertify.alert("설명을 입력하세요.", function(){
			$('#expln').focus();
		});
		return false;
	}
	if($('#thumFile').val() == ""){
		alertify.alert("워크샵 썸네일을 입력하세요.", function(){
			$('#thumFile').focus();
		});
		return false;
	}
	if(workshopDt == ""){
		alertify.alert("워크샵 일자를 입력하세요.", function(){
			$('#workshopDt').focus();
		});
		return false;
	}
	if(bgnHour == ""){
		alertify.alert("워크샵 시작시간을 입력하세요.", function(){
			$('#bgnHour').focus();
		});
		return false;
	}
	if(bgnMinute == ""){
		alertify.alert("워크샵 시작시간(분)을 입력하세요.", function(){
			$('#bgnMinute').focus();
		});
		return false;
	}
	if(bgnAmpm == ""){
		alertify.alert("워크샵 시작시간(AM/PM)을 입력하세요.", function(){
			$('#bgnAmpm').focus();
		});
		return false;
	}
	if(endHour == ""){
		alertify.alert("워크샵 종료시간을 입력하세요.", function(){
			$('#endHour').focus();
		});
		return false;
	}
	if(endMinute == ""){
		alertify.alert("워크샵 종료시간(분)을 입력하세요.", function(){
			$('#endMinute').focus();
		});
		return false;
	}
	if(endAmpm == ""){
		alertify.alert("워크샵 종료시간(AM/PM)을 입력하세요.", function(){
			$('#endAmpm').focus();
		});
		return false;
	}
	if(addrFullNm == ""){
		alertify.alert("워크샵 장소를 입력하세요.", function(){
			$('#addrFullNm').focus();
		});
		return false;
	}
	if(addrFullDtl == ""){
		alertify.alert("워크샵 상세주소를 입력하세요.", function(){
			$('#addrFullDtl').focus();
		});
		return false;
	}
	if(lectureRoom == ""){
		alertify.alert("강의실을 입력하세요.", function(){
			$('#lectureRoom').focus();
		});
		return false;
	}
	if(tuitionGrpCd == ""){
		alertify.alert("수강료를 선택하세요.", function(){
			$('#tuitionGrpCd').focus();
		});
		return false;
	}
	if(tuitionGrpCd == "TGC0000000002" && tuition == ""){
		alertify.alert("수강료를 입력하세요.", function(){
			$('#tuition').focus();
		});
		return false;
	}
	if(googleMapLink == ""){
		alertify.alert("구글지도링크를 입력하세요.", function(){
			$('#googleMapLink').focus();
		});
		return false;
	}
	if(mngerNm == ""){
		alertify.alert("담당자명을 입력하세요.", function(){
			$('#mngerNm').focus();
		});
		return false;
	}
	if(mngerTel == ""){
		alertify.alert("담당자전화번호를 입력하세요.", function(){
			$('#mngerTel').focus();
		});
		return false;
	}
	if(mngerEmail == ""){
		alertify.alert("담당자이메일을 입력하세요.", function(){
			$('#mngerEmail').focus();
		});
		return false;
	}
	if(target == ""){
		alertify.alert("대상을 입력하세요.", function(){
			$('#target').focus();
		});
		return false;
	}
	if(recurmtMan == ""){
		alertify.alert("모집인원을 입력하세요.", function(){
			$('#recurmtMan').focus();
		});
		return false;
	}
	if(teacherNm1 == ""){
		alertify.alert("강사명1을 입력하세요.", function(){
			$('#teacherNm1').focus();
		});
		return false;
	}
	if(teacherNm2 == ""){
		alertify.alert("강사명2를 입력하세요.", function(){
			$('#teacherNm2').focus();
		});
		return false;
	}
	if($('#teacherPhoto1').val() == ""){
		alertify.alert("강사1 사진을 입력하세요.", function(){
			$('#teacherPhoto1').focus();
		});
		return false;
	}
	if($('#teacherPhoto2').val() == ""){
		alertify.alert("강사2 사진을 입력하세요.", function(){
			$('#teacherPhoto2').focus();
		});
		return false;
	}
	if(teacherBhist1 == ""){
		alertify.alert("강사1 약력을 입력하세요.", function(){
			$('#teacherBhist1').focus();
		});
		return false;
	}
	if(teacherBhist2 == ""){
		alertify.alert("강사2 약력을 입력하세요.", function(){
			$('#teacherBhist2').focus();
		});
		return false;
	}
	var uploadCnt = DEXT5UPLOAD.GetTotalFileCount("commonUpload");
	if(uploadCnt == 0){
		alertify.alert("강의 사진을 입력하세요.", function(){
			$('#useYn').focus();
		});
		return false;
	}
	if(useYn == ""){
		alertify.alert("사용여부를 입력하세요.", function(){
			$('#useYn_Y').focus();
		});
		return false;
	}

	alertify.confirm("워크샵을 등록하시겠습니까?", function(e){
		if(e){
			DEXT5UPLOAD.Transfer('commonUpload');
		}
	});

}

function fnFileFormSave(){
	var form = $('#frm')[0];
	var formData = new FormData(form);
	formData.append("thumFileImg", $('#thumFile')[0].files[0]);
	formData.append("teacherPhoto1Img", $('#teacherPhoto1')[0].files[0]);
	formData.append("teacherPhoto2Img", $('#teacherPhoto2')[0].files[0]);

	$.ajax({
		type: 'post',
		url: contextPath + "/internal/workshop/insertWorkshopAjax.do",
		dataType: 'json',
		data: formData,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data.result > 0){
				alertify.alert("워크샵 등록이 완료되었습니다.", function(){
					location.href = contextPath + "/internal/workshop/list.do";
				});
			}else{
				alertify.alert(resumeInsertErrorMsg);
			}
		},
		error: function(xhr, status, error) {
			alertify.alert(resumeInsertErrorMsg);
		}
	});

}

