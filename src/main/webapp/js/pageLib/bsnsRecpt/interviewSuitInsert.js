var	interviewSuitInsert = {
	//----------------------------
	// InfoIndex 객체
	//----------------------------
	name: 'interviewSuitInsert',

	init: function() {
		this.beforeBind();
		this.bind();
		this.afterBind();
	},

	beforeBind: function() {
		var wearStartTime = $('#wearStartTime').val();
		var wearEndTime = $('#wearEndTime').val();
		
		var wearStartTimeTemp = wearStartTime.split(" ");
		var wearEndTimeTemp = wearEndTime.split(" ");
		
		$('#wearTime').html(wearStartTimeTemp[0] + " " + wearStartTimeTemp[1] + " ~ " + wearEndTimeTemp[1]);
		
	},

	bind: function() {
		
	},

	afterBind: function() {
		
		// 이전 단계
		$('#btn_prev').on('click', function(){
			history.back();
		});
		
		// 취소(메인 화면 이동)
		$('#btn_cancel').on('click', function(){
			// 추가 확인 후 진행
			
		});
		
		// 주소 찾기
		$('#btn_findAddr').on('click', function(){
			new daum.Postcode({
		        oncomplete: function(data) {
		        	// 주소 지정 (선택한 주소 타입에 따라 다름 * 지번/도로명)
		           $('#addr').val(data.address);
		        }
		    }).open();
		});
		
		$('#btn_next').on('click', function(){
			var addr = $('#addr').val();
			var cell = $('#cell').val();
			var email = $('#email').val();
			var wearGoods = $('#wearGoods').val();
			
			if(addr == ""){
				$.alert('주소를 입력하세요.');
				$('#addr').focus();
				return false;
			}
			
			if(cell == ""){
				$.alert('연락처를 입력하세요.');
				$('#cell').focus();
				return false;
			}
			
			if(email == ""){
				$.alert('Email을 입력하세요.');
				$('#email').focus();
				return false;
			}
			
			if(wearGoods == ""){
				$.alert('신청물품을 입력하세요.');
				$('#wearGoods').focus();
				return false;
			}
			
			var param = {
				"wearStartTime" : $('#wearStartTime').val(),
				"wearEndTime" : $('#wearEndTime').val(),
				"bsnsSeq" : $('#bsnsSeq').val(),
				"wearAdminSeq" : $('#wearAdminSeq').val(),
				"addr" : addr,
				"cell" : cell,
				"email" : email,
				"wearGoods" : wearGoods,
			};
			
			var	opts = {
				url		: contextPath + "/bsnsRecpt/setInterviewSuitInsert.do",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {
					
					if(resJSON.data.resultCode == "0000"){
						location.href = contextPath + "/bsnsRecpt/interviewSuitCompleteView.do";
					}else{
						$.alert(resJSON.data.msg);
					}
					
				}
			};
			common.http.ajax(opts);
			
		});
		
	},
	fn: {
		
	}
}