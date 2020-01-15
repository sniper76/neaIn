	
	var	jobskVacancyDtlInfoModify = {
			name: 'jobskVacancyDtlInfoModify',
			
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

	            return deferred.promise();
			},
			
			bind: function() {
				var that$ = this;

			},
			
			afterBind: function() {
				var that$ = this;
				var jcAgreeStsCd = $("#jcAgreeStsCdValue").val();
				$('input:radio[name="jcAgreeStsCd"][value="' + jcAgreeStsCd + '"]').prop("checked", true);
				var vacancyStsCd = $("#vacancyStsCdValue").val();
				$('input:radio[name="vacancyStsCd"][value="' + vacancyStsCd + '"]').prop("checked", true);	
				
				if (jcAgreeStsCd != 'JAS0000000001'){
					$('input[name="vacancyStsCd"]').attr('disabled', true);
				}
			},
			
			fn: {
					//
			}
	}

	function fnSetIsco(json){
		
		var iscoHtml = '<span class="bbs_add">' + json.commonNm + '<input type="hidden" class="iscoCd" id="iscoCd" name="iscoCd" value="' + json.commonCd + '"/>';
		iscoHtml += '<button type="button" class="delete">delete</button></span>';
		$('#span_isco').html(iscoHtml);
		
		fnDeleteSpan();
	}

	function fnDeleteSpan(){
		/*
		 * 직종 / 근무지역 삭제 버튼 처리
		 * 해당 화면에서만 사용할 것 같아 이곳에 추가
		 */
		$('.delete').unbind();
		$('.delete').on('click', function(e){
			$(e.target).closest('span').remove();
		});
	}
	
	function btnJobskVacancyDelete(){
		
		var vacancySeq = $('#vacancySeq').val();
		//alert(vacancySeq);
        var param = {
        				vacancySeq: vacancySeq
        			};
        
        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/jobsk/deleteJobskVacancyAjax.do", // URL
            dataType : 'json', // 데이터 타입
            traditional: true,
            data : param,
			success:function(rtnData){
				if(rtnData.resultCode!="success"){
					alertify.alert(rtnData.resultMsg);
					return;
				}
		
				alertify.alert(rtnData.resultMsg);
				return;
			},
			complete:function(){
				//
			}
        })
			
	}
	
	function btnJobskVacancyDtlInfoSave(){
		
		var vacancySeq = $('#vacancySeq').val();
		var jcAgreeStsCd = $('input[name="jcAgreeStsCd"]:checked').val();
		var agreeRejectReason = $('#agreeRejectReason').val();
		var vacancyStsCd = $('input[name="vacancyStsCd"]:checked').val();
		var iscoCd= $('#iscoCd').val();;
		
		/*
		alert("vacancySeq : " + vacancySeq);
		alert("jcAgreeStsCd : " + jcAgreeStsCd);
		alert("agreeRejectReason : " + agreeRejectReason);
		alert("vacancyStsCd : " + vacancyStsCd);
		alert("iscoCd : " + iscoCd);
		*/
		
        var param = {
        				vacancySeq: vacancySeq,
        				iscoCd: iscoCd, 
        				jcAgreeStsCd: jcAgreeStsCd,
        				agreeRejectReason: agreeRejectReason,
        				vacancyStsCd: vacancyStsCd
        			};
        
        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/jobsk/updateJobskVacancyDtlInfoAjax.do", // URL
            dataType : 'json', // 데이터 타입
            traditional: true,
            data : param,
			success:function(rtnData){
				if(rtnData.resultCode!="success"){
					alertify.alert(rtnData.resultMsg);
					return;
				}
		
				alertify.alert(rtnData.resultMsg);
				return;
			},
			complete:function(){
				//
			}
        })
        
	}



	