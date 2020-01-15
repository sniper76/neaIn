	
	var	userElementaryDtlInfoReg = {
			name: 'userElementaryDtlInfoReg',
			
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
				
				var today = new Date();
				var currYear = today.getFullYear();
				var currMonth = today.getMonth() + 1;
				if (currMonth < 10){
					currMonth = '0' + currMonth;
				}
				var currDay = today.getDate();
				if (currDay < 10){
					currDay = '0' + currDay;
				}
				//alert(currYear + "-" + currMonth + "-" + currDay);
				$("#birthYear").val(currYear);
				$("#birthMonth").val(currMonth);
				$("#birthDay").val(currDay);
				
			},
			
			fn: {
				pageAction : function() {
				}
			}
	}

	function fnUserCellChk(){
		
		var userCell = $('#userCell').val();
		//alert("userCell : " + userCell);

		var param = {
						userCell: userCell
        			};

        $.ajax({
            type : 'post', // 타입
            url :  contextPath + "/internal/user/selectUserCellDuplicationCheckAjax.do", // URL
            dataType : 'json', // 데이터 타입
            traditional: true,
            data : param,
			success:function(rtnData){
				//alert(rtnData.chkDup);
				$('#userCellCheck').val(rtnData.chkDup);
				if(rtnData.chkDup =="Y"){
					alertify.alert(userCellDupMsg);
					return;
				}
				
				alertify.alert(userCellDupMsgErr);
				return;
			},
			complete:function(){
				//
			}
        })
		
	}
	
	function fnUserInfoReg(){
		
		var userNmKh = $('#userNmKh').val();
		var userNmEn = $('#userNmEn').val();
		var userCell = $('#userCell').val();
		var userCellCheck = $('#userCellCheck').val();
		var genderCd = $('input[name="genderCd"]:checked').val();
		var birthYear = $('#birthYear').val(); 
		var birthMonth = $('#birthMonth').val();
		var birthDay = $('#birthDay').val();
		var birth = $('#birthDay').val() + "/" + $('#birthMonth').val() + "/" + $('#birthYear').val();
		var nid = $('#nid').val();
		var addrCd = $('#addrCd').val();
		var addrFullCd = $('#addrFullCd').val();
		var addrFullNm = $('#addrFullNm').val();
		var addrDtl = $('#addrDtl').val();
		var smsNtceAgreeYn = $('input[name="smsNtceAgreeYn"]:checked').val();
		
		/*
		alert("userNmKh : " + userNmKh);
		alert("userNmEn : " + userNmEn);
		alert("userCell : " + userCell);
		alert("userCellCheck : " + userCellCheck);
		alert("genderCd : " + genderCd);
		alert("birthYear : " + birthYear);
		alert("birthMonth : " + birthMonth);
		alert("birthDay : " + birthDay);
		alert("birth : " + birth);
		alert("nid : " + nid);
		alert("addrCd : " + addrCd);
		alert("addrFullCd : " + addrFullCd);
		alert("addrFullNm : " + addrFullNm);
		alert("addrDtl : " + addrDtl);
		alert("smsNtceAgreeYn : " + smsNtceAgreeYn);
		*/
		
		if (userNmKh == null || userNmKh == ""){
			alertify.alert(msgErrKhNameEmpty);
			return;
		}
		
		if (userNmEn == null || userNmEn == ""){
			alertify.alert(msgErrEnNameEmpty);
			return;
		}
		
		if (userCell == null || userCell == ""){
			alertify.alert(msgErrCellEmpty);
			return;
		}

		if (nid == null || nid == ""){
			alertify.alert(msgErrNidEmpty);
			return;
		}
		
		if (addrCd == null || addrCd == "" || 
				addrFullCd == null || addrFullCd == "" ||
				addrFullNm == null || addrFullNm == ""){
			alertify.alert(msgErrAddrEmpty);
			return;
		}
		
		if (userCellCheck == null || userCellCheck == ""){
			alertify.alert(msgErrCellDupCheckEmpty);
			return;			
		}
		
		if (userCellCheck != null && userCellCheck != "" && userCellCheck == "N"){
			alertify.alert(msgErrCellDupCheckFalse);
			return;			
		}
		
		var param = {
        				userNmKh: userNmKh,
        				userNmEn: userNmEn, 
        				userCell: userCell,
        				userCellCheck: userCellCheck,
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
            url :  contextPath + "/internal/user/insertUserElementaryInfoAjax.do", // URL
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