var	courseHistDtl = {
		name: 'courseHistDtl',
		
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
            // Handle form submission event
            $('#btnSubmit').on('click', function(e) {
            	that$.fn.pageAction();
            });
		},
		
		fn: {
			pageAction : function() {
				$("#frmCourseDtl").attr("method", "post");
				$("#frmCourseDtl").attr("action", contextPath + "/internal/counsel/courseAnsReg.do");
				$("#frmCourseDtl").submit();
			},
		}
}

function SelectCounselHisList(){
	$("#innerDtlInfo").empty();
	
	var action = contextPath + "/internal/user/selectCounselInfoAjax.do";
	var param = {
		"userSeq" : $('#userSeq').val(), 
		"sysLangCd" : lang
	};
	
	$.ajax({
		type: "POST",
		url: action,
		data: param,                   
		cache: true,
		success: function(response) {
			//alert(response);
			$("#innerDtlInfo").html(response);
		}
	});
	
}
