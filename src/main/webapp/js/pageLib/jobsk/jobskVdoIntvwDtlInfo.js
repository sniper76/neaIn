	
	var	jobskVdoIntvwDtlInfo = {
			name: 'jobskVdoIntvwDtlInfo',
			
			init: function() {
				var that$ = this;
			
				$.when( that$.beforeBind() ).done(function( res ) {
					that$.bind();
					that$.afterBind();
				});
			},
			
			beforeBind: function() {
				var that$ = this;
				
				common.sys.getDatepicker();
				$('#intvwDt').datepicker('setDate', 'today');

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

	function btnCompnyDtlInfo(){
		var formData = $('#frmJobskVdoIntvwDtlInfo').serializeObject();
		sessionStorage.setItem("UserCompnyDtlInfo", JSON.stringify(formData));

		$("#frmJobskVdoIntvwDtlInfo").attr("method", "post");
		$("#frmJobskVdoIntvwDtlInfo").attr("action", contextPath + "/internal/user/selectUserCmpnyDtlInfoMain.do");
		$("#frmJobskVdoIntvwDtlInfo").submit();			
	}
	
	function btnUserDtlInfo(){
		var formData = $('#frmJobskVdoIntvwDtlInfo').serializeObject();
		sessionStorage.setItem("UserDtlInfo", JSON.stringify(formData));

		$("#frmJobskVdoIntvwDtlInfo").attr("method", "post");
		$("#frmJobskVdoIntvwDtlInfo").attr("action", contextPath + "/internal/user/selectUserDtlInfoMain.do");
		$("#frmJobskVdoIntvwDtlInfo").submit();			
	}	
	
	function btnJobskVdoIntvwDelete(){
		var videoIntvwSeq = $('#videoIntvwSeq').val();
		alert(videoIntvwSeq);
        var param = {
        				videoIntvwSeq: videoIntvwSeq
        			};
        
        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/jobsk/deleteJobskVdoIntvwAjax.do", // URL
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
	
	function btnJobskVdoIntvwDtlInfoSave(){
		var videoIntvwSeq = $('#videoIntvwSeq').val();
		var jcAgreeStsCd = $('input[name="jcAgreeStsCd"]:checked').val();
		var intvwDtAgreeOpt = $('input[name="intvwDtAgreeOpt"]:checked').val();
		var videoIntvwBgnDt = $('#intvwDt').val();
		var videoIntvwEndDt = $('#intvwDt').val();
		var videoIntvwBgnHour = $('#videoIntvwBgnHour').val();
		var videoIntvwEndHour = $('#videoIntvwEndHour').val();
		var videoIntvwBgnMinute = $('#videoIntvwBgnMinute').val();
		var videoIntvwEndMinute = $('#videoIntvwEndMinute').val();
		var videoIntvwBgnAmpm = $('#videoIntvwBgnAmpm').val();
		var videoIntvwEndAmpm= $('#videoIntvwEndAmpm').val();
		
        var param = {
        				videoIntvwSeq: videoIntvwSeq, 
        				jcAgreeStsCd: jcAgreeStsCd,
        				intvwDtAgreeOpt: intvwDtAgreeOpt,
        				videoIntvwBgnDt: videoIntvwBgnDt,
        				videoIntvwEndDt: videoIntvwEndDt,
        				videoIntvwBgnHour: videoIntvwBgnHour,
        				videoIntvwEndHour: videoIntvwEndHour,
        				videoIntvwBgnMinute: videoIntvwBgnMinute,
        				videoIntvwEndMinute: videoIntvwEndMinute,
        				videoIntvwBgnAmpm: videoIntvwBgnAmpm,
        				videoIntvwEndAmpm: videoIntvwEndAmpm
        			};
        
        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/jobsk/updateJobskVdoIntvwDtlInfoAjax.do", // URL
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
	
	