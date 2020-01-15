	
	var	userElementaryDtlInfoModify = {
			name: 'userElementaryDtlInfoModify',
			
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
				
				var userStsCd = $("#userStsCdValue").val();
				$("#userStsCd").val(userStsCd);
				
				var genderCd = $("#genderCdValue").val();
				$('input:radio[name="genderCd"][value="' + genderCd + '"]').prop("checked", true);
				
				var birthYear = $("#birthYearValue").val();
				var birthMonth = $("#birthMonthValue").val();
				var birthDay = $("#birthDayValue").val();
				$("#birthYear").val(birthYear);
				$("#birthMonth").val(birthMonth);
				$("#birthDay").val(birthDay);
				
				var smsNtceAgreeYn = $("#smsNtceAgreeYnValue").val();
				$('input:radio[name="smsNtceAgreeYn"][value="' + smsNtceAgreeYn + '"]').prop("checked", true);	
				
			},
			
			fn: {
				pageAction : function() {
				}
			}
	}
	
	function fnUserInfoDelete(){
		
		var userSeq = $('#userSeq').val();
		//alert("userSeq : " + userSeq);
		
        var param = {
        				userSeq: userSeq
        			};

        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/user/deleteUserElementaryInfoAjax.do", // URL
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
	
	function fnUserInfoSave(){
		
		var userSeq = $('#userSeq').val();
		var userStsCd = $('#userStsCd').val();
		var genderCd = $('input[name="genderCd"]:checked').val();
		var birth = $('#birthDay').val() + "/" + $('#birthMonth').val() + "/" + $('#birthYear').val();
		var nid = $('#nid').val();
		var addrCd = $('#addrCd').val();
		var addrFullCd = $('#addrFullCd').val();
		var addrFullNm = $('#addrFullNm').val();
		var addrDtl = $('#addrDtl').val();
		var smsNtceAgreeYn = $('input[name="smsNtceAgreeYn"]:checked').val();
		/*
		alert("userSeq : " + userSeq);
		alert("userStsCd : " + userStsCd);
		alert("genderCd : " + genderCd);
		alert("birth : " + birth);
		alert("nid : " + nid);
		alert("addrCd : " + addrCd);
		alert("addrFullCd : " + addrFullCd);
		alert("addrFullNm : " + addrFullNm);
		alert("addrDtl : " + addrDtl);
		alert("smsNtceAgreeYn : " + smsNtceAgreeYn);
		*/
        var param = {
        				userSeq: userSeq,
        				userStsCd: userStsCd, 
        				genderCd: genderCd,
        				birth: birth,
        				nid: nid,
        				addrCd: addrCd,
        				addrFullCd: addrFullCd,
        				addrFullNm: addrFullNm,
        				addrDtl: addrDtl,
        				smsNtceAgreeYn: smsNtceAgreeYn
        			};

        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/user/updateUserElementaryDtlInfoAjax.do", // URL
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