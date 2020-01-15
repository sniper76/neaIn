	
	var	jobskDtlInfoModify = {
			name: 'jobskDtlInfoModify',
			
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
			},
			
			fn: {
					//
			}
	}

	function fnSetIsco(json){
		
		var iscoHtml = '<span class="bbs_add">' + json.commonNm + '<input type="hidden" class="iscoCd" name="iscoCd" value="' + json.commonCd + '"/>';
		iscoHtml += '<button type="button" class="delete">delete</button></span>';
		$('#span_isco').append(iscoHtml);
		
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
	
	function btnJobskRequestDelete(){
		
		var jobskReqSeq = $('#jobskReqSeq').val();
        var param = {
        				jobskReqSeq: jobskReqSeq
        			};
        
        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/jobsk/deleteJobskRequestAjax.do", // URL
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
	
	function btnJobskDtlInfoSave(){
		
		var jobskReqSeq = $('#jobskReqSeq').val();
		var resumeSeq = $('#resumeSeq').val();
		var jcAgreeStsCd = $('input[name="jcAgreeStsCd"]:checked').val();
		var agreeRejectReason = $('#agreeRejectReason').val();
		
		/*
		alert("jobskReqSeq : " + jobskReqSeq);
		alert("resumeSeq : " + resumeSeq);
		alert("jcAgreeStsCd : " + jcAgreeStsCd);
		alert("agreeRejectReason : " + agreeRejectReason);
		*/
		
		var iscoCd= "";
		
        var size = $("input[name='iscoCd']").length;
        for(i=0;i<size;i++){
        	if(i == 0){
        		iscoCd = $("input[name='iscoCd']").eq(i).attr("value");
        	} else {
        		iscoCd += "," + $("input[name='iscoCd']").eq(i).attr("value");
        	}
        }
        //alert("iscoCd : " + iscoCd);
      
        var param = {
        				jobskReqSeq: jobskReqSeq,
        				resumeSeq: resumeSeq,
        				iscoCd: iscoCd, 
        				jcAgreeStsCd: jcAgreeStsCd,
        				agreeRejectReason: agreeRejectReason
        			};
        
        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/jobsk/updateJobskDtlInfoAjax.do", // URL
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
	
	