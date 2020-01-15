	
	var	userElementaryDtlInfoIntvwModify = {
			name: 'userElementaryDtlInfoIntvwModify',
			
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
				
				var intvwDt = $("#intvwDtValue").val();
				var intvwDtHour = $("#intvwDtHourValue").val();
				var intvwDtMinute = $("#intvwDtMinuteValue").val();
				var intvwDtAmpm = $("#intvwDtAmpmValue").val();
				
				common.sys.getDatepicker();
				$('#intvwDt').datepicker('setDate', intvwDt);			
				$("#intvwDtHour").val(intvwDtHour);
				$("#intvwDtMinute").val(intvwDtMinute);
				$("#intvwDtAmpm").val(intvwDtAmpm);				
				
			},
			
			fn: {
				pageAction : function() {
				}
			}
	}
	
	function fnUserElementaryDtlInfoIntvwModify(){
		
		var intvwHisSeq = $('#intvwHisSeq').val();
		var userSeq = $('#userSeq').val();
		var intvwDt = $('#intvwDt').val();
		var intvwDtHour = $('#intvwDtHour').val();
		var intvwDtMinute = $('#intvwDtMinute').val();
		var intvwDtAmpm = $('#intvwDtAmpm').val();
		var addrCd = $('#addrCd').val();
		var addrFullCd = $('#addrFullCd').val();
		var addrFullNm = $('#addrFullNm').val();
		var addrDtl = $('#addrDtl').val();
		var compnySeq = $('#compnySeq').val();
		var content = $('#content').val();
		
		/*
		alert("intvwHisSeq : " + intvwHisSeq);
		alert("userSeq : " + userSeq);
		alert("intvwDt : " + intvwDt);
		alert("intvwDtHour : " + intvwDtHour);
		alert("intvwDtMinute : " + intvwDtMinute);
		alert("intvwDtAmpm : " + intvwDtAmpm);
		alert("addrCd : " + addrCd);
		alert("addrFullCd : " + addrFullCd);
		alert("addrFullNm : " + addrFullNm);
		alert("addrDtl : " + addrDtl);
		alert("compnySeq : " + compnySeq);
		alert("content : " + content);
		*/
		
		if (intvwDt == null || intvwDt == ""){
			alertify.alert(msgErrIntvwDtEmpty);
			return;
		}
		
		if (addrCd == null || addrCd == "" || 
				addrFullCd == null || addrFullCd == "" ||
				addrFullNm == null || addrFullNm == ""){
			alertify.alert(msgErrAddrEmpty);
			return;
		}
		
		if (compnySeq == null || compnySeq == ""){
			alertify.alert(msgErrIntvwCompnyEmpty);
			return;			
		}
		
		var param = {
						intvwHisSeq: intvwHisSeq,
						userSeq: userSeq,
						intvwDt: intvwDt, 
						intvwDtHour: intvwDtHour,
						intvwDtMinute: intvwDtMinute,
						intvwDtAmpm: intvwDtAmpm,
        				addrCd: addrCd,
        				addrFullCd: addrFullCd,
        				addrFullNm: addrFullNm,
        				addrDtl: addrDtl,
        				compnySeq: compnySeq,
        				content: content
        			};

        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/user/updateUserElementaryDtlInfoIntvwModifyAjax.do", // URL
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
	