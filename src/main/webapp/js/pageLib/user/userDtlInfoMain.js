	
	var	userDtlInfoMain = {
			name: 'userDtlInfoMain',
			
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
				
				var action = contextPath + "/internal/user/selectUserDtlInfoBaseAjax.do"
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
		var action = contextPath + "/internal/user/selectUserDtlInfoBaseAjax.do"
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
		
		var action = contextPath + "/internal/user/selectResumeDtlInfoAjax.do"
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
	
	function tabJobskDtlInfo(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectUserDtlInfoJobskMainAjax.do"
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
	
	function tabAplcDtlInfo(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectUserDtlInfoAplcListMainAjax.do"
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
	
	function tabOfferDtlInfo(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectUserDtlInfoOfferListMainAjax.do"
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
		
		var action = contextPath + "/internal/user/selectUserDtlInfoIntvwListMainAjax.do"
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
	
	function tabReferralDtlInfo(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectUserDtlInfoReferralListMainAjax.do"
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
		
		var action = contextPath + "/internal/user/selectCounselInfoAjax.do"
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
                $("#innerDtlInfo").html(response);
            }
        });
        
	}

	function tabJobfairDtlInfo(){
		
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectUserDtlInfoFairListMainAjax.do"
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
	
	function goDetil() {
		$('#frmUserDtlInfoMain').prop('action','/internal/user/userDtlInfoModify.do').submit();
	}
	
	function fnGoPageUserInfoListBack(){
		
		var previousUrl = $("#previousUrl").val();
		location.href = previousUrl;
		
		/*
		window.location.href - return href(URL) of current page
		window.location.hostname - return domain name of Web host 
		window.location.pathname - return the path and file name of current page
		window.location.protocol - return using web protocol (http:// or https://)
		window.location.assign - load new document
		
		histroy.go(-1);		// return to the previous page of 1 step 
		histroy.go(-2);		// return to the previous page of 2 steps
		histroy.go(-3);		// return to the previous page of 3 steps
		history.back();		// same history.go(-1)
		history.forward();	// same history go(1)	
		*/
	}