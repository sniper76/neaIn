	
	var	userElementaryDtlInfoUserTypeChg = {
			name: 'userElementaryDtlInfoUserTypeChg',
			
			init: function() {
				var that$ = this;
			
				$.when( that$.beforeBind() ).done(function( res ) {
					that$.bind();
					that$.afterBind();
				});
			},
			
			beforeBind: function() {
				var that$ = this;
			
			},
			
			bind: function() {
				var that$ = this;
				
			},
			
			afterBind: function() {
				var that$ = this;
				
			},
			
			fn: {
				pageAction : function() {
				}
			}
	}
	
	function fnUserTypeChgSave(){
		
		var userSeq = $('#userSeq').val();
		var userEmail = $('#userEmail').val();
		userEmail = userEmail.replace(/(\s*)/g, "");
		var beforeUserAuthCd = $('#beforeUserAuthCd').val();
		var afterUserAuthCd = $('#afterUserAuthCd').val();
		var chgReason = $('#chgReason').val();
		
		/*
		alert("userSeq : " + userSeq);
		alert("userEmail : " + userEmail + "========");
		alert("beforeUserAuthCd : " + beforeUserAuthCd);
		alert("afterUserAuthCd : " + afterUserAuthCd);
		alert("chgReason : " + chgReason);
		*/
		
		if (userEmail == null || userEmail == ""){
			alertify.alert(msgErrUserEmailEmpty);
			return;
		}
		
		if (chgReason == null || chgReason == ""){
			alertify.alert(msgErrChgReasonEmpty);
			return;			
		}

		var param = {
						userSeq: userSeq,
						userEmail: userEmail,
						beforeUserAuthCd: beforeUserAuthCd, 
						afterUserAuthCd: afterUserAuthCd,
						chgReason: chgReason
        			};

        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/user/insertUserElementaryDtlInfoUserTypeChgAjax.do", // URL
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
	
	
	function searchCmpnyInfo(compnySeq, compnyNmKh, compnyNmEn){
		
		$("#compnySeq").val(compnySeq);
		$("#compnyNmKh").val(compnyNmKh);
		$("#compnyNmEn").val(compnyNmEn);
	}
	