var uploadHoler = "dext5uploadArea";
var uploadId = "commonUpload";
var	courseAnsReg = {
		name: 'courseAnsReg',

		init: function() {
			var that$ = this;

			$.when( that$.beforeBind() ).done(function( res ) {
				that$.bind();
				that$.afterBind();
			});
		},

		beforeBind: function() {
			var that$ = this;
			var deferred = $.Deferred();

			$.when( ).done(function( ) {
				deferred.resolve();
			});

			dext5uploadEvnt();

			$("#counselDt").datepicker({
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

			if ( $('#counselDt').val() == '' ) {
				$('#counselDt').datepicker('setDate', 'today');
			} else {
				$('#counselDt').datepicker('setDate', $('#counselDt').val());
			}

			return deferred.promise();
		},

		bind: function() {
			var that$ = this;

		},

		afterBind: function() {
			var that$ = this;
            $('#btnDelete').on('click', function(e) {
            	// confirm dialog
            	alertify.confirm(delConfirmMsg, function (ex) {
            	    if (ex) {
            	    	courseAnsReg.fn.deleteAction();
            	    } else {
            	    	return;
            	    }
            	});
            });

            $('#btnSubmit').on('click', function(e) {
//            	courseAnsReg.fn.updateAction(e);
            	//that$.fn.updateAction(e);
            	alertify.confirm(confirmMsg, function (e) {
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
            });
		},

		fn: {
			deleteAction : function() {
					var form$ = $('#frmCourseAnsReg');
					var param = form$.serializeObject();
	
					form$.find("#btnDelete").attr('disabled', true);
					form$.find("#btnSubmit").attr('disabled', true);
	
					//e.preventDefault();
	
					var options = {
					    method: 'post',
					    url: contextPath + '/internal/counsel/deleteCounselAjax.do',
					    data: param,
					    dataType: 'json',
					};
	
					$.ajax(options)
					.done(function (res, status, responseObj) {
						if ( res.result.counselSeq ) {
							var method = param.counselMethodDivCd == 'CMD0000000001' ? 'ONLINE' : ( param.counselMethodDivCd == 'CMD0000000002' ? 'TEL' : 'CENTER' ) ;
							window.location.href = contextPath + '/internal/counsel/course.do?method=' + method;
						} else {
							alertify.alert("인증 안됨", function (e) {
								if(e) {
									form$.find("#btnDelete").attr('disabled', false);
									form$.find("#btnSubmit").attr('disabled', false);
								}
							});
						}
					}).fail(function (result, status, responseObj) {
						alertify.alert("시스템 에러.", function (e) {
							if(e) {
								form$.find("#btnDelete").attr('disabled', false);
								form$.find("#btnSubmit").attr('disabled', false);
							}
						});
					});
			},
			updateAction : function(e) {
				$("#frmCourseAnsReg").submit(function(e) {
				    var form$ = $(this);
					var param = form$.serializeObject();

					form$.find("#btnDelete").attr('disabled', true);
					form$.find("#btnSubmit").attr('disabled', true);

					e.preventDefault();

					var options = {
					    method: 'post',
					    url: contextPath + '/internal/counsel/updateCounselAjax.do',
					    data: param,
					    dataType: 'json',
					};

					$.ajax(options)
					.done(function (res, status, responseObj) {
						if ( res.result.counselSeq ) {
							var method = param.counselMethodDivCd == 'CMD0000000001' ? 'ONLINE' : ( param.counselMethodDivCd == 'CMD0000000002' ? 'TEL' : 'CENTER' ) ;
							window.location.href = contextPath + '/internal/counsel/course.do?method=' + method;
						} else {
    						alertify.alert("인증 안됨", function (e) {
    							if(e) {
    								form$.find("#btnDelete").attr('disabled', false);
    								form$.find("#btnSubmit").attr('disabled', false);
    							}
    						});
						}
					}).fail(function (result, status, responseObj) {
						alertify.alert("시스템 에러.", function (e) {
							if(e) {
								form$.find("#btnDelete").attr('disabled', false);
								form$.find("#btnSubmit").attr('disabled', false);
							}
						});
					});
				});
			},
		}
}

function fnFileFormSave() {
	//var $("#frmCourseAnsReg") = $(this);
	var param = $("#frmCourseAnsReg").serializeObject();

	$("#frmCourseAnsReg").find("#btnDelete").attr('disabled', true);
	$("#frmCourseAnsReg").find("#btnSubmit").attr('disabled', true);

	var options = {
	    method: 'post',
	    url: contextPath + '/internal/counsel/updateCounselAjax.do',
	    data: param,
	    dataType: 'json',
	};

	$.ajax(options)
	.done(function (res, status, responseObj) {
		if ( res.result.counselSeq ) {
			var method = param.counselMethodDivCd == 'CMD0000000001' ? 'ONLINE' : ( param.counselMethodDivCd == 'CMD0000000002' ? 'TEL' : 'CENTER' ) ;
			window.location.href = contextPath + '/internal/counsel/course.do?method=' + method;
		} else {
			alertify.alert("인증 안됨", function (e) {
				if(e) {
					$("#frmCourseAnsReg").find("#btnDelete").attr('disabled', false);
					$("#frmCourseAnsReg").find("#btnSubmit").attr('disabled', false);
				}
			});
		}
	}).fail(function (result, status, responseObj) {
		alertify.alert("시스템 에러.", function (e) {
			if(e) {
				$("#frmCourseAnsReg").find("#btnDelete").attr('disabled', false);
				$("#frmCourseAnsReg").find("#btnSubmit").attr('disabled', false);
			}
		});
	});

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

	var ansFileGrpSeq = $('#ansFileGrpSeq').val();

	if(ansFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : ansFileGrpSeq
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
