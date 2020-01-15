var teachOneUploadHolder = "teachOneDext5uploadArea";
var teacheOneUploadId = "teachOneCommonUpload";
var teachTwoUploadHolder = "teachTwoDext5uploadArea";
var teachTwoUploadId = "teachTwoCommonUpload";
var lectureUploadHolder = "lectureDext5uploadArea";
var lectureUploadId = "lectureCommonUpload";

var	softSkillEduMngReg = {
		name: 'softSkillEduMngReg',
		
		init: function() {
			var that$ = this;

			teachOneDext5uploadEvnt();
			teachTwoDext5uploadEvnt();
			lectureDext5uploadEvnt();
		
			$.when( that$.beforeBind() ).done(function( res ) {
				that$.bind();
				that$.afterBind();
			});
		},
		
		beforeBind: function() {
			var that$ = this;
			var deferred = $.Deferred();
			
			$("#teachDt").datepicker({
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

			if ( $('#teachDt').val() == '' ) {
				$('#teachDt').datepicker('setDate', 'today');
			} else {
				$('#teachDt').datepicker('setDate', $('#teachDt').val());
			}			
			
			deferred.resolve();	
            return deferred.promise();
		},
		
		bind: function() {
			var that$ = this;

		},
		
		afterBind: function() {
			var that$ = this;
			$('#btnSubmit').on('click', function(e) {
				//form submit button click 시 submit 전 로직 구현
            });
			
			$("#frmSoftSkillEduMngReg").submit(function(e) {
			    var form$ = $(this);
				form$.find("#btnSubmit").attr('disabled', true);

				e.preventDefault();

				alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (ex) {
					if(ex) {
						var teachOneCnt  = DEXT5UPLOAD.GetTotalFileCount("teachOneCommonUpload");
				
							if(teachOneCnt > 0){
								// 파일전송
								DEXT5UPLOAD.Transfer(teacheOneUploadId);
							} else {
								teachTwoUploadFn();
							}				
						
					} else {
						form$.find("#btnSubmit").attr('disabled', false);
					}					
				});
			});			
		},
		fn: {
			insertAction : function(params) {
				var deferred = $.Deferred();
				var options = {
					    method: 'post',
					    url: contextPath + '/internal/trnng/insertSoftSkillEduMngAjax.do',
					    data: params.data,
					    dataType: 'json',
					};
					    
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.eduTrnngSeq ) {
				        deferred.resolve(res.result);
					} else {
						deferred.reject( t( 'cpes.error.msg' ) );
						//deferred.reject("user auth cert fail");				
					}
				}).fail(function (result, status, responseObj) {
					deferred.reject( t( 'cpes.error.msg' ) );
					//deferred.reject("system error: " + status);			
				});				
				return deferred.promise();
			},
		}
}


/*********************************************************************************
 * DEXT5 UPLOAD FUNCTION
 * uploadHolder : call Position
 * new Dext5Upload : call upload module
 **********************************************************************************/
function teachOneDext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = teachOneUploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	DEXT5UPLOAD.config.Views = 'thumbs';
	DEXT5UPLOAD.config.MaxTotalFileCount = '1';
	DEXT5UPLOAD.config.ExtensionAllowOrLimit = '1';
	DEXT5UPLOAD.config.ExtensionArr = 'jpeg,bmp,jpg,gif,png';
	new Dext5Upload(teacheOneUploadId);

	var teacher1PhotoFileGrpSeq = $('#teacher1PhotoFileGrpSeq').val();

	if(teacher1PhotoFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : teacher1PhotoFileGrpSeq
			},
			success: function(data) {

				if(data.result.length > 0){
					for(var i in data.result){
						var obj = data.result[i];
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", teacheOneUploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("System Error.");
			}
		});
	}
}

function lectureDext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = lectureUploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	DEXT5UPLOAD.config.Views = 'thumbs';
	DEXT5UPLOAD.config.MaxTotalFileCount = '1';
	DEXT5UPLOAD.config.ExtensionAllowOrLimit = '1';
	DEXT5UPLOAD.config.ExtensionArr = 'jpeg,bmp,jpg,gif,png';
	new Dext5Upload(lectureUploadId);

	var lecturePhotoFileGrpSeq = $('#lecturePhotoFileGrpSeq').val();

	if(lecturePhotoFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : lecturePhotoFileGrpSeq
			},
			success: function(data) {

				if(data.result.length > 0){
					for(var i in data.result){
						var obj = data.result[i];
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", lectureUploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("System Error.");
			}
		});
	}
}

function teachTwoDext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = teachTwoUploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	DEXT5UPLOAD.config.Views = 'thumbs';
	DEXT5UPLOAD.config.MaxTotalFileCount = '1';
	DEXT5UPLOAD.config.ExtensionAllowOrLimit = '1';
	DEXT5UPLOAD.config.ExtensionArr = 'jpeg,bmp,jpg,gif,png';
	new Dext5Upload(teachTwoUploadId);

	var teacher2PhotoFileGrpSeq = $('#teacher2PhotoFileGrpSeq').val();

	if(teacher2PhotoFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : teacher2PhotoFileGrpSeq
			},
			success: function(data) {

				if(data.result.length > 0){
					for(var i in data.result){
						var obj = data.result[i];
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", teachTwoUploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("System Error.");
			}
		});
	}
}


function teachTwoUploadFn() {
	
    var teachTwoCnt  = DEXT5UPLOAD.GetTotalFileCount("teachTwoCommonUpload");
    
	if(teachTwoCnt > 0){
		// 파일전송
		DEXT5UPLOAD.Transfer(teachTwoUploadId);
	} else {
		lectureUploadFn();
	}
}

function lectureUploadFn() {
	
    var lectureUploadCnt = DEXT5UPLOAD.GetTotalFileCount("lectureCommonUpload");
    
	if(lectureUploadCnt > 0){
		// 파일전송
		DEXT5UPLOAD.Transfer(lectureUploadId);
	} else {
		fnFileFormSave();
	}
}


function fnFileFormSave(){
	var params = {
			data: $("#frmSoftSkillEduMngReg").serialize()
		};
		
	$.when( softSkillEduMngReg.fn.insertAction( params ) ).done(function( result ) {
		alertify.alert( t( 'cpes.reg.success.msg' ), function (e) { if (e) {
			window.location.href = contextPath + '/internal/trnng/softSkillEduMng.do';
		} });
	}).fail(function ( result ) {
		$("#frmSoftSkillEduMngReg").find("#btnSubmit").attr('disabled', false);
		alertify.alert(result, function (e) { if (e) {} });
	});							
	
}