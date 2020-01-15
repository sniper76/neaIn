var emailFormatErrorMsg = "<spring:message code='login.idsearch.email.incorrect'/>";
/**
 * 공통 레이어 팝업 세팅
 * @param flag
 * @returns
 */
function commonPopupSet(flag, lastDepthFlag){
	$.ajax({
		type: 'post',
		url: contextPath +"/common/viewCommonPopup.do",
		data: {
			"flag" : flag
		},
		dataType: 'html',
		success: function(data) {
			var cloneDiv = $('#div_common').clone();
			$('#div_common').after(cloneDiv);
			cloneDiv.addClass(flag);
			cloneDiv.html(data);
			cloneDiv.find('#popup_title').html(flag.toUpperCase());

			commonPopupList.init(flag, lastDepthFlag);
		},
		error: function(xhr, status, error) {
			alertify.alert("error to connecting server");
		}
	});
}


var commonPopupList = {
	list : [],
	init : function(flag, lastDepthFlag){
		var commonPopupObj = new Object();
		commonPopupObj.flag = flag;
		var obj = new commonPopup(flag, lastDepthFlag);
		obj.init();
		commonPopupObj.obj = obj;
		commonPopupList.list.push(commonPopupObj);
	},
	reset : function(flag){
		for(var i in commonPopupList.list){
			var obj = commonPopupList.list[i];
			if(flag == obj.flag){
				obj.obj.select();
			}
		}
	}
}

function callback(fn, flag){
	for(var i in commonPopupList.list){
		var obj = commonPopupList.list[i];
		if(flag == obj.flag){
			obj.obj.callback(fn);
		}
	}
}

function commonPopup(flag, lastDepthFlag){
	this.values = {
		"commonFullCd" : "",
		"commonFullNm" : "",
		"commonCd" : "",
		"commonNm" : ""
	};
	this.valueList = [];
	this.config = flag;
	this.callbackFnNm = null;
	this.eventObj = null;
	this.lastDepthFlag = lastDepthFlag;
	this.buttonEvent = null;
	this.targetId = "";
	this.init = function() {
	    // init
		this.click();
		this.select();
		this.input();
	};
	this.callback = function(fn){
		this.callbackFnNm = fn;
		this.init();
	};
	this.select = function(){
		var config = this.config;
		$('.' + config).find('.common_selectRow').unbind();
		$('.' + config).find('.common_selectRow').on('click', function(e){
			var depth = $(e.target).closest('.dep1').index() + 1;
			var lastDepth = $(e.target).closest('.popup_box').find('.dep1').length;
			var selectVal = $(e.target).val();

			// 선택한 li 선택 css 적용
			$(this).closest('.dep1').find('li').removeClass('on');
			$(this).closest('li').addClass('on');

			// 선택한 depth가 마지막 요소가 아닐 경우 다음 depth의 정보 조회
			if(depth != lastDepth){
				$.ajax({
					type: 'post',
					url: contextPath +"/common/nextDepthCdSelectAjax.do",
					dataType: 'json',
					data: {
						"flag" : config,
						"depth" : depth,
						"cd" : selectVal,
						"condGrpCd" : selectVal,
						"cdLength" : selectVal.length
					},
					success: function(data) {

						var html = "";
						if(data.result.length > 0){
							for(var i in data.result){
								var resultObj = data.result[i];
								html += "<li><button type='button' class='common_selectRow' value='" + resultObj.cd +"'>" + resultObj.cdNm + "</button></li>";
							}
						}

						$(e.target).closest('.popup_box').find('.dep1:eq(' + depth + ')').find('.scroll_cont ul').empty();
						$(e.target).closest('.popup_box').find('.dep1:eq(' + depth + ')').find('.scroll_cont ul').html(html);

						commonPopupList.reset(config);
					},
					error: function(xhr, status, error) {
						alertify.alert("error to connecting server");
					}
				});
			}
		});
	};
	this.input = function(){
  		// select 버튼
  		var config = this.config;
  		var eventObj = this.eventObj;
  		var values = this.values;
  		var callbackFnNm = this.callbackFnNm;
  		var popupClose = this.popupClose;
  		var lastDepthFlag = this.lastDepthFlag;
  		var targetId = this.targetId;

		$('.' + config).find('.btn_commonPopupSave').unbind();
		$('.' + config).find('.btn_commonPopupSave').on('click', function(e){
			if(!lastDepthFlag){
				var selectFlag = false;
				$(e.target).closest('.popup_box').find('.dep1:last').find('li').each(function(i){
					if($(this).hasClass('on')){
						selectFlag = true;
					}
				});

				if(!selectFlag){
					alertify.alert("모든 정보를 선택해 주세요");
					return false;
				}
			}

			var selectValHtml = "";
			var html = "";
			var fullCd = "";

			// 선택한 값 세팅
			$(e.target).closest('.popup_box').find('.dep1').each(function(i){
				var selectText = $(this).find('.on').find('button').text();
				var selectVal = $(this).find('.on').find('button').val();

				if(selectText != "" && selectVal != ""){
					if(selectValHtml == ""){
						selectValHtml += selectText;
					}else{
						selectValHtml += " " + selectText;
					}

					if(fullCd == ""){
						fullCd += selectVal;
					}else{
						fullCd += ","+selectVal;
					}

					values.commonCd = selectVal;
					values.commonNm = selectText;
				}

			});

			values.commonFullCd = fullCd;
			values.commonFullNm = selectValHtml;

			// 입력하는 항목에 따라 분류
			/*if(flag == "text"){

				if(config == "addr"){
					$('.popup_input_' + config).val(values.commonFullNm);
				}else if(config == "isco"){
					$('.popup_input_' + config).val(values.commonNm);
				}
			}else{

				// 이후 다른 입력 폼이 존재할 때 추가 작업 진행
				 var $li = $(e.target).closest('.popup_box').find('.dep1:last').find('.on');
				html += "<span>" + selectValHtml + "<input type='hidden' name='" + formFlag + "Nm' value='" + selectValHtml + "'/>";
				html += "<input type='hidden' name='" + formFlag + "Cd' value='" + lastSelectVal + "'/><button type='button'>delete</button></span>";

				var $li = $(e.target).closest('.popup_box').find('.dep1:last').find('.on');
				html += "<span>" + $li.find('button').text() + "<input type='hidden' name='" + formFlag + "Nm' value='" + selectValHtml + "'/>";
				html += "<input type='hidden' name='" + formFlag + "Cd' value='" + lastSelectVal + "'/><button type='button'>delete</button></span>";

				// 기존에 등록된 동일한 값이 있는지 체크
				var inputFlag = false;
				$(e.target).closest('.pick').find('.text_box').find('span').each(function(i){
					if($(this).find('input:last').val() == lastSelectVal){
						inputFlag = true;
					}
				})

				if(!inputFlag){
					$(e.target).closest('.pick').find('.text_box').append(html);
					$(e.target).closest('.pick').addClass('active');
				}
			}*/

			if(typeof callbackFnNm == 'function'){
				callbackFnNm(values);
			}else{

				// 이력서 추천인에서 사용
				var targetnm = $('#' + callbackFnNm).closest('.form_element').find('.common_target').data('targetnm');

				var addrHtml = "<span>" + values.commonFullNm + "<input type='hidden' name='" + targetnm + "_" + config + "Cd' value='" + values.commonCd + "'/>";
	    		addrHtml += "<input type='hidden' name='" + targetnm + "_" + config + "FullNm' value='" + values.commonFullNm + "'/>";
	    		addrHtml += "<input type='hidden' name='" + targetnm + "_" + config + "FullCd' value='" + values.commonFullCd + "'/>";
	    		addrHtml += "<button type='button'>delete</button></span>";

	    		var form_element = $('#' + callbackFnNm).closest('.form_element');
	    		form_element.find('.common_target').html(addrHtml);
	    		form_element.addClass('active');
			}

			popupClose(config);
			$('.' + config).find('#commonPopup').hide();
		});
	};
	this.click = function (){
		// 주소 선택 결과가 inputbox (text 형태)
		var flag = this.config;
		$('.popup_' + flag).on('click', function(e){
			$('.' + flag).find('#commonPopup').show();
		});

		// 공통 popup 닫기
		var popupClose = this.popupClose;
		$('.btn_commonPopupClose').unbind();
		$('.btn_commonPopupClose').on('click', function(e){
			popupClose(flag);
			$(e.target).closest('#commonPopup').hide();
		});
	};
	this.popupClose = function(flag){
		$('.' + flag).find('.dep1').each(function(i){
			if(i > 0){
				$(this).find('.scroll_cont ul').empty();
			}else{
				$(this).find('.scroll_cont ul li').removeClass('on');
			}
		});
	};
}

function fnScriptReset(){
	// 새로생성된 등록 폼 스크립트 세팅
	$('.form_close').unbind();
	$('.form_element').find('input:text').unbind();
	$('.form_element').find('.select_box button,.select_box input:radio').unbind();
	$('.form_element').find('.open').unbind();
	$('.form_element').find('.text_box button').unbind();
	$('.form_element').find('.popup_box .close, .popup_box .cancel').unbind();

	$('.form_element').find('.text_box button').on('click', function(){
		$number=$(this).parents('.text_box').find('span').length;

		if($number==1){
			$(this).parents('.form_element').removeClass('active');
		};
		$(this).parent('span').remove();
	});

	$('.form_close').on('click', function(){
		$(this).parents('.form_contents').remove();
	});

	$('.form_element').find('.text_box button').on('click', function(){
		$number=$(this).parents('.text_box').find('span').length;

		if($number==1){
			$(this).parents('.form_element').removeClass('active');
		};
		$(this).parent('span').remove();
	});

	$('.form_element').find('input:text').on('focusin', function(){
		$('.form_element').removeClass('on');
		$(this).parents('.form_element').addClass('active on');
	});

	$('.form_element').find('input:text').on('focusout', function(){
		var $val=$(this).val();
		if($val==''){
			$(this).parents('.form_element').removeClass('active on');
		}else{
			$(this).parents('.form_element').removeClass('on');
		};
	});

	$('.form_element').find('.open').on('click', function(){
		$('.form_element').removeClass('on');
		$(this).parents('.form_element').addClass('on');
	});

	$('.form_element').find('.select_box button,.select_box input:radio').on('click', function(event){
		var $target=$(event.target),
			$text='';
			$child='';
			$cd='';
		if($target.is('input:radio')){
			$text=$(this).siblings('label').text().toLowerCase(),
			$child=$(this).attr('class');

			if($child=='have'){
				$(this).parents('.form_element').next('.child_form').addClass('show').find('.form_element').removeClass('active');
			}else if($child=='no_have'){
				$(this).parents('.form_element').next('.child_form').removeClass('show active').find('.text_box').text('');
				$(this).parents('.form_element').next('.child_form').find('.check_box input:checkbox').prop('checked', false);
			};
		}else{
			$text=$(this).find('span').text();
			$cd=$(this).val();
		};
		if($target.is('.ohter')){
			$(this).parents('.form_element').siblings('.other_child').addClass('show');
		}else{
			$(this).parents('.form_element').siblings('.other_child').removeClass('show');
		};
		$target.closest('.form_element').removeClass('on').addClass('active').find('.text_box span').text($text);
		$target.parents('.form_element').removeClass('on').addClass('active').find('.text_box input').val($cd);
	});

	$('.form_element').find('.popup_box .close, .popup_box .cancel').on('click', function(){
		$(this).parents('.form_element').removeClass('on');
	});
}

/**
 * dext5upload 업로드 후 콜백 함수
 *
 * commonUploadFlag
 * I : 등록 (fnFileFormSave)
 * TI : 임시등록 (fnFileFormTempSave)
 *
 * @param uploadID
 * @returns
 */
function DEXT5UPLOAD_OnTransfer_Complete(uploadID) {
    var resultJson = DEXT5UPLOAD.GetAllFileListForJson(uploadID);
    $('#' + uploadID + 'Result').val(JSON.stringify(resultJson));

//    var commonUploadFlag = $('#commonUploadFlag').val();

    /*if(commonUploadFlag == "I"){
    	fnFileFormSave();
    }else if(commonUploadFlag == "TI"){
    	fnFileFormTempSave();
    }*/
	
    if(uploadID == 'thumbCommonUploadFair') {
    	fileFairUploadId();
    } else if (uploadID == 'fairCommonUploadFair') {
    	fileSupporterUploadId();
    }else if (uploadID == 'supporterCommonUploadFair') {
    	fileSponsorUploadId();
    }else if (uploadID == 'sponsorCommonUploadFair') {
    	fileBoothUploadId();
    }else if (uploadID == 'teachOneCommonUpload') {
    	teachTwoUploadFn();
    }else if (uploadID == 'teachTwoCommonUpload') {
    	lectureUploadFn();
    } else {
    	fnFileFormSave();
    }

}

/**
 * 입력 validate 관련
 * flag ::
 * 1 : 숫자만 입력
 * 2 : mm (월)만 입력
 * 3 : yy (년)만 입력
 * 4 : 시간 (0 ~ 24)만 입력
 * 5 : 주(0 ~ 7) 만 입력
 */
function fnInputValidation(classNm, flag){
	$('.'+classNm).keyup(function(e){
		var checkVal = $(e.target).val();
		var regStr = null;

		if(flag == 1){
			regStr = /[^0-9]/gi;
			$(e.target).val(checkVal.replace(regStr, ''));
		}else if(flag == 2){
			regStr = /[^0-9]/gi;
			var checkInt = checkVal.replace(regStr, '');

			if(checkInt > 12 || checkInt < 1){
				checkInt = '';
			}

			$(e.target).val(checkInt);
		}else if(flag == 3){
			regStr = /[^0-9]/gi;
			var checkInt = checkVal.replace(regStr, '');

			$(e.target).val(checkInt);

			$(e.target).focusout(function(event){
				var checkLengh = $(event.target).val().length;

				if(checkLengh < 4){
					alertify.alert(yearFormatErrorMsg, function (e){
						$(event.target).focus();
					});
				}
			});
		}else if(flag == 4){
			regStr = /[^0-9]/gi;
			var checkInt = checkVal.replace(regStr, '');

			if(checkInt > 24 || checkInt < 1){
				checkInt = '';
			}
			$(e.target).val(checkInt);
		}else if(flag == 5){
			regStr = /[^0-9]/gi;
			var checkInt = checkVal.replace(regStr, '');

			if(checkInt > 7 || checkInt < 1){
				checkInt = '';
			}
			$(e.target).val(checkInt);
		}
	});
}

//이메일 형식 체크
function fnCheckEmail(classNm){
	var regStr = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var checkVal = $('.' + classNm).val();

	if(checkVal != ""){
		if(!regStr.test(checkVal)){
			alertify.alert(emailFormatErrorMsg, function(){
				$(classNm).val('');
				$(classNm).focus();
			});
		}
	}

}
