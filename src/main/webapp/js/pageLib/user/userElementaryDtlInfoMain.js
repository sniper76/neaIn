	
	var	userElementaryDtlInfoMain = {
			name: 'userElementaryDtlInfoMain',
			
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
				$("#innerDtlInfo").empty();
				
				var action = contextPath + "/internal/user/selectUserElementaryDtlInfoBaseAjax.do"
				var userSeq = $('#userSeq').val();
				var param = {
								userSeq: userSeq
							};
				
	            $.ajax({
	                type: "POST",
	                url: action,
	                data: param,                   
	                cache: true,
	                success: function(response) {
	                	$("#innerDtlInfo").html(response);
	                }
	            });
				
			},
			
			fn: {
					//
			}
	}

	function tabUserDtlInfo(){
		
		$("#innerDtlInfo").empty();
		var action = contextPath + "/internal/user/selectUserElementaryDtlInfoBaseAjax.do"
		var userSeq = $('#userSeq').val();
		var param = {
						userSeq: userSeq
					};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerDtlInfo").html(response);
            }
        });
        
	}
	
	function fnUserTypeModify(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectUserElementaryDtlInfoUserTypeChgAjax.do"
		var userSeq = $('#userSeq').val();
		var param = {
						userSeq: userSeq
					};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
            	$("#innerDtlInfo").html(response);
            }
        });
               	
	}
	
	
	function tabResumeDtlInfo(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectElementaryResumeDtlInfoAjax.do"
		var userSeq = $('#userSeq').val();
		var param = {
						userSeq: userSeq
					};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerDtlInfo").html(response);
            }
        });
        
	}
	
	function tabIntvwDtlInfo(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectUserElementaryDtlInfoIntvwListMainAjax.do"
		var userSeq = $('#userSeq').val();
		var param = {
						userSeq: userSeq
					};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
            	$("#innerDtlInfo").html(response);
            }
        });
        
	}
	
	function tabCounselDtlInfo(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectElementaryCounselInfoAjax.do"
		var userSeq = $('#userSeq').val();
		var param = {
						userSeq: userSeq
					};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
            	$("#innerDtlInfo").html(response);
            }
        });
        
	}

	function CounselDtl(counselSeq){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/counsel/courseDtlUserAjax.do"
		var param = {
						counselSeq: counselSeq
					};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                //alert(response);
                //$("#innerCounselDtlInfo").html(response);
            	$("#innerDtlInfo").html(response);
            }
        });
        
	}
	
	function fnUserIntvwHisReg(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectUserElementaryDtlInfoIntvwRegAjax.do"
		var userSeq = $('#userSeq').val();
		var param = {
						userSeq: userSeq
					};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
            	$("#innerDtlInfo").html(response);
            }
        });
               	
	}	
	
	function fnUserElementaryDtlInfoIntvwForModify(intvwHisSeq, userSeq){

		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectUserElementaryDtlInfoIntvwModifyAjax.do"
		var param = {
						intvwHisSeq: intvwHisSeq,
						userSeq: userSeq
					};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
            	$("#innerDtlInfo").html(response);
            }
        });
        
	}

	function insertElemtryCounselReg(){
		
		$("#innerDtlInfo").empty();

		var action = contextPath + "/internal/user/elementaryCounselRegAjax.do"
		var param = {
						userSeq: $("#frmUserElementaryDtlInfoMain").find("#userSeq").val()
					};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
            	$("#innerDtlInfo").html(response);
            }
        });
        
	}
	
	function goDetil() {
		$('#frmUserDtlInfoMain').prop('action','/internal/user/userDtlInfoModify.do').submit();
	}
	
	function fnGoPageUserInfoListBack(){
		
		var previousUrl = $("#previousUrl").val();
		location.href = previousUrl;
		
		/*
		window.location.href - 현재 페이지의 href (URL) 반환
		window.location.hostname - 웹 호스트의 도메인 네임 반환
		window.location.pathname - 현재 페이지의 경로와 파일 이름 반환
		window.location.protocol - 사용하는 웹 프로토콜 반환 (http:// 혹은 https://)
		window.location.assign - 새 document 로드
		
		histroy.go(-1);		// 이전 페이지... 즉 한단계 뒤로 돌아가기
		histroy.go(-2);		// 두단계 이전의 페이지로 이동
		histroy.go(-3);		// 세단계 이전의 페이지로 이동
		history.back();		// history.go(-1)과 동일한 기능을 구현하나 go(-1)이 보편적으로 사용됨
		history.forward();	// history.go(1)과 동일하며 앞으로 이동	
		*/
	}