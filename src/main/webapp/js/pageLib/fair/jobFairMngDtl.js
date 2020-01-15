var thumbUploadHolder = "thumbDext5uploadArea";
var thumbUploadId = "thumbCommonUploadFair";
var fairUploadHolder = "fairDext5uploadArea";
var fairUploadId = "fairCommonUploadFair";
var supporterUploadHolder = "supporterDext5uploadArea";
var supporterUploadId = "supporterCommonUploadFair";
var sponsorUploadHolder = "sponsorDext5uploadArea";
var sponsorUploadId = "sponsorCommonUploadFair";
var boothUploadHolder = "boothDext5uploadArea";
var boothUploadId = "boothCommonUploadFair";

var	jobFairMngDtl = {
		name: 'jobFairMngDtl',
		
		init: function() {
			var that$ = this;
		
			$.when( that$.beforeBind() ).done(function( res ) {
				that$.bind();
				that$.afterBind();
			});
			
			thumbDext5uploadEvnt();
			fairDext5uploadEvnt();
			supporterDext5uploadEvnt();
			sponsorDext5uploadEvnt();
		},
		
		beforeBind: function() {
			var that$ = this;
			var deferred = $.Deferred();
			
			$('#jcCd').attr('required', true);
			
			$("#fairBgnDt, #fairEndDt, #recurmtBgnDt, #recurmtEndDt").datepicker({
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

			$('#fairBgnDt').datepicker('setDate', $('#fairBgnDt').val() == '' ? 'today' : $('#fairBgnDt').val() );
			$('#fairEndDt').datepicker('setDate', $('#fairEndDt').val() == '' ? 'today' : $('#fairEndDt').val() );
			$('#recurmtBgnDt').datepicker('setDate', $('#recurmtBgnDt').val() == '' ? 'today' : $('#recurmtBgnDt').val() );
			$('#recurmtEndDt').datepicker('setDate', $('#recurmtEndDt').val() == '' ? 'today' : $('#recurmtEndDt').val() );
			
			deferred.resolve();	
            return deferred.promise();
		},
		
		bind: function() {
			var that$ = this;

		},
		
		afterBind: function() {
			var that$ = this;
			
			$('input[name=fairDivCd]').on('click', function() {
				if ($('input[name=fairDivCd]:checked').val() == 'FDC0000000005') {

					$('.urlTr').show();

					$('.thumbNailTr').hide();
					
					$('.jcCdTr').hide();
					$('.recurmtTr').hide();
					$('.boothImgTr').hide();
					$('.fairDtlExplnKhTr').hide();
					$('.fairDtlExplnEnTr').hide();
					$('.fairHashtagTr').hide();
					$('.fairitemViewTr').hide();

					
				} else {

					$('.urlTr').hide();

					$('.thumbNailTr').show();
					$('.jcCdTr').show();
					$('.recurmtTr').show();
					$('.boothImgTr').show();
					$('.fairDtlExplnKhTr').show();
					$('.fairDtlExplnEnTr').show();
					$('.fairHashtagTr').show();
					$('.fairitemViewTr').show();
					
				}				
			});
			
			$('#keyword').on('keydown', function(e) {
				var count = $(this).prev('span.text_box').children('span').length;
				if ( count > 4 ) {
					$('#keyword').val('');
					return false;
				}
            });
			
            $('#btnDelete').on('click', function(e) {
				alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (ex) {
					if (ex) {
						that$.fn.deleteAction(e);
					} else {
						return;
					}
				});
            });			
			
			$('#btnSubmit').on('click', function(e) {
				
				var form$ = $(this);
//				form$.find("#btnDelete").attr('disabled', true);
//				form$.find("#btnSubmit").attr('disabled', true);

				e.preventDefault();
			    
				if ($('#keyword').length > 0) {
				    var keywordList = "";
				    var keywordClone$ = $('#keyword').prev('span.text_box').clone();
				    keywordClone$.find('button').remove();
				    keywordClone$.children('span').each(function(i, v) {
				    	keywordList = (keywordList == "") ? $.trim($(this).text()) : keywordList + "," + $.trim($(this).text());
				    });
				    
				    $('#fairHashtag').val(keywordList);
				}
				
				if (!$('input:radio[name=fairDivCd]').is(':checked')) {
		    		alertify.alert(divcdBlank, function(e) {
						$("#fairDivCd").focus();
					});
					return;
			    }
			    
			    if ($("#fairNmKh").val() == "") {
		    		alertify.alert(nmkhBlank, function(e) {
						$("#fairNmKh").focus();
					});
					return;
			    }

			    if ($("#fairNmEn").val() == "") {
		    		alertify.alert(nmenBlank, function(e) {
						$("#fairNmEn").focus();
					});
					return;
			    }
			    
			    if ($("#jcCd").val() == "") {
		    		alertify.alert(jcBlank, function(e) {
						$("#jcCd").focus();
					});
					return;
			    }
			    
			    if ($("#addrDtl").val() == "") {
		    		alertify.alert(addrkhBlank, function(e) {
						$("#addrDtl").focus();
					});
					return;
			    }
			    
			    if ($("#addrDtl2").val() == "") {
		    		alertify.alert(addrenBlank, function(e) {
						$("#addrDtl2").focus();
					});
					return;
			    }
			    
			    if ($("#tel1").val() == "") {
		    		alertify.alert(tel1Blank, function(e) {
						$("#tel1").focus();
					});
					return;
			    }
			    
			    if ($("#tel2").val() == "") {
		    		alertify.alert(tel2Blank, function(e) {
						$("#tel2").focus();
					});
					return;
			    }
			    
			    if ($("#email").val() == "") {
		    		alertify.alert(emailBlank, function(e) {
						$("#email").focus();
					});
					return;
			    }
			    
				var sponsorUploadCnt = DEXT5UPLOAD.GetTotalFileCount("sponsorCommonUploadFair");
			    var supporterUploadCnt = DEXT5UPLOAD.GetTotalFileCount("supporterCommonUploadFair");
			    var thumbFileGrpCnt = DEXT5UPLOAD.GetTotalFileCount("thumbCommonUploadFair");
			    var fairFileGrpCnt  = DEXT5UPLOAD.GetTotalFileCount("fairCommonUploadFair");
			    
			    if (parseInt(thumbFileGrpCnt) < 1 ) {
		    		alertify.alert(thumbFileBlank, function(e) {
						$("#thumbFileGrpSeq").focus();
					});
					return;
			    }
			    
			    if (parseInt(fairFileGrpCnt) < 1 ) {
		    		alertify.alert(fairFileBlank, function(e) {
						$("#fairFileGrpSeq").focus();
					});
					return;
			    }
			    
			    
			    if (parseInt(sponsorUploadCnt) < 1 ) {
		    		alertify.alert(sponsorFileBlank, function(e) {
						$("#sponsorFileGrpSeq").focus();
					});
					return;
			    }
			    
			    if (parseInt(supporterUploadCnt) < 1) {
		    		alertify.alert(supporterFileBlank, function(e) {
						$("#supporterFileGrpSeq").focus();
					});
					return;
			    }
			    
			    alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (e) {
					if(e) {
						
						if(thumbFileGrpCnt > 0){
							// 파일전송
							DEXT5UPLOAD.Transfer(thumbUploadId);
						} else {
							fileFairUploadId();
						}
						
					} else {
						alertify.alert(cancelMsg);
					}
				});
            });
			
		},
		
		fn: {	
			deleteAction : function(e) {
				var form$ = $('#frmJobFairMngDtl');
				var param = form$.serializeObject();
				
				form$.find("#btnDelete").attr('disabled', true);
				form$.find("#btnSubmit").attr('disabled', true);
				
				e.preventDefault();
				
				var options = {
				    method: 'post',
				    url: contextPath + '/internal/fair/deleteJobFairMngAjax.do',
				    data: param,
				    dataType: 'json',
				};				
				
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.fairSeq ) {
						alertify.alert( t( 'cpes.delete.success.msg' ), function (e) {
							if(e) {
								window.location.href = contextPath + '/internal/fair/jobFairMng.do';
							}
						});							
					} else {
						alertify.alert( t( 'cpes.error.msg' ), function (e) {
							if(e) {
								form$.find("#btnDelete").attr('disabled', false);
								form$.find("#btnSubmit").attr('disabled', false);
							}
						});							
					}
				}).fail(function (result, status, responseObj) {
					alertify.alert( t( 'cpes.error.msg' ), function (e) {
						if(e) {
							form$.find("#btnDelete").attr('disabled', false);
							form$.find("#btnSubmit").attr('disabled', false);
						}
					});							
				});
			},			
			updateAction : function(params) {
				
				debugger;
				
				var deferred = $.Deferred();
				var options = {
					    method: 'post',
					    url: contextPath + '/internal/fair/updateJobFairMngAjax.do',
					    data: params.data,
					    dataType: 'json',
					};
					    
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.FairMngBean.fairSeq ) {
						deferred.resolve(res.FairMngBean.fairSeq);
					} else {
				    	deferred.reject( t( 'cpes.error.msg' ) );
				    	//deferred.reject( "user auth cert fail");
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
function thumbDext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = thumbUploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	DEXT5UPLOAD.config.Views = 'thumbs';
	DEXT5UPLOAD.config.MaxTotalFileCount = '1';
	DEXT5UPLOAD.config.ExtensionAllowOrLimit = '1';
	DEXT5UPLOAD.config.ExtensionArr = 'jpeg,bmp,jpg,gif,png';
	new Dext5Upload(thumbUploadId);

	var thumbFileGrpSeq = $('#thumbFileGrpSeq').val();

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
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", thumbUploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("System Error.");
			}
		});
	}
}


function fairDext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = fairUploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	DEXT5UPLOAD.config.Views = 'thumbs';
	DEXT5UPLOAD.config.MaxTotalFileCount = '1';
	DEXT5UPLOAD.config.ExtensionAllowOrLimit = '1';
	DEXT5UPLOAD.config.ExtensionArr = 'jpeg,bmp,jpg,gif,png';
	new Dext5Upload(fairUploadId);

	var fairFileGrpSeq = $('#fairFileGrpSeq').val();

	if(fairFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : fairFileGrpSeq
			},
			success: function(data) {

				if(data.result.length > 0){
					for(var i in data.result){
						var obj = data.result[i];
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", fairUploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("System Error.");
			}
		});
	}
}


function sponsorDext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = sponsorUploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	DEXT5UPLOAD.config.Views = 'thumbs';
	DEXT5UPLOAD.config.MaxTotalFileCount = '1';
	DEXT5UPLOAD.config.ExtensionAllowOrLimit = '1';
	DEXT5UPLOAD.config.ExtensionArr = 'jpeg,bmp,jpg,gif,png';
	new Dext5Upload(sponsorUploadId);

	var sponsorFileGrpSeq = $('#sponsorFileGrpSeq').val();

	if(sponsorFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : sponsorFileGrpSeq
			},
			success: function(data) {

				if(data.result.length > 0){
					for(var i in data.result){
						var obj = data.result[i];
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", supporterUploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("System Error.");
			}
		});
	}
}


function supporterDext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = supporterUploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	DEXT5UPLOAD.config.Views = 'thumbs';
	DEXT5UPLOAD.config.MaxTotalFileCount = '1';
	DEXT5UPLOAD.config.ExtensionAllowOrLimit = '1';
	DEXT5UPLOAD.config.ExtensionArr = 'jpeg,bmp,jpg,gif,png';
	new Dext5Upload(supporterUploadId);

	var supporterFileGrpSeq = $('#supporterFileGrpSeq').val();

	if(supporterFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : supporterFileGrpSeq
			},
			success: function(data) {

				if(data.result.length > 0){
					for(var i in data.result){
						var obj = data.result[i];
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", sponsorUploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("System Error.");
			}
		});
	}
}

function boothDext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = boothUploadHolder;
	DEXT5UPLOAD.config.Mode = 'edit'; // edit, view
	DEXT5UPLOAD.config.Views = 'thumbs';
	DEXT5UPLOAD.config.MaxTotalFileCount = '1';
	DEXT5UPLOAD.config.ExtensionAllowOrLimit = '1';
	DEXT5UPLOAD.config.ExtensionArr = 'jpeg,bmp,jpg,gif,png';
	new Dext5Upload(supporterUploadId);

	var boothFileGrpSeq = $('#boothFileGrpSeq').val();

	if(supporterFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : boothFileGrpSeq
			},
			success: function(data) {

				if(data.result.length > 0){
					for(var i in data.result){
						var obj = data.result[i];
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", boothUploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("시스템 에러.");
			}
		});
	}
}


function fileFairUploadId() {
	
    var fairFileGrpCnt  = DEXT5UPLOAD.GetTotalFileCount("fairCommonUploadFair");
    
	if(fairFileGrpCnt > 0){
		// 파일전송
		DEXT5UPLOAD.Transfer(fairUploadId);
	} else {
		fileSupporterUploadId();
	}
}

function fileSupporterUploadId() {
	
    var supporterUploadCnt = DEXT5UPLOAD.GetTotalFileCount("supporterCommonUploadFair");
    
	if(supporterUploadCnt > 0){
		// 파일전송
		DEXT5UPLOAD.Transfer(supporterUploadId);
	} else {
		fileSponsorUploadId();
	}
}

function fileSponsorUploadId() {
	
	var sponsorUploadCnt = DEXT5UPLOAD.GetTotalFileCount("sponsorCommonUploadFair");
    
	if(sponsorUploadCnt > 0){
		// 파일전송
		DEXT5UPLOAD.Transfer(sponsorUploadId);
	} else {
		fileBoothUploadId();
	}
}

function fnFileFormSave() {
	var params = {
			data: $("#frmJobFairMngDtl").serializeObject()
		};
	params.data['fairCompnyViewYn'] = $('#fairCompnyViewYn').is(":checked") ? 'Y' : 'N' ;
	params.data['fairVacancyViewYn'] = $('#fairVacancyViewYn').is(":checked") ? 'Y' : 'N' ;
	params.data['fairInsttViewYn'] = $('#fairInsttViewYn').is(":checked") ? 'Y' : 'N' ;
	params.data['fairTrnngViewYn'] = $('#fairTrnngViewYn').is(":checked") ? 'Y' : 'N' ;

			$.when( jobFairMngDtl.fn.updateAction( params ) ).done(function( result ) {
				alertify.alert( t( 'cpes.reg.success.msg' ), function (e) { if (e) {
					window.location.href = contextPath + '/internal/fair/jobFairMng.do';
				} });
			}).fail(function ( result ) {
				$("#frmJobFairMngDtl").find("#btnDelete").attr('disabled', false);
				$("#frmJobFairMngDtl").find("#btnSubmit").attr('disabled', false);
				alertify.alert(result, function (e) { if (e) {} });
			});						
			
}

