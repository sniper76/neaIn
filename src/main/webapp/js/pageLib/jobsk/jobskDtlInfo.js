	
	var	jobskDtlInfo = {
			name: 'jobskDtlInfo',
			
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
			},
			
			fn: {
					//
			}
	}
	
	function btnJobskDtlInfoModify(){
		var formData = $('#frmJobskDtlInfo').serializeObject();
		sessionStorage.setItem("JobskDtlInfo", JSON.stringify(formData));

		$("#frmJobskDtlInfo").attr("method", "post");
		$("#frmJobskDtlInfo").attr("action", contextPath + "/internal/jobsk/selectJobskDtlInfoModifyAjax.do");
		$("#frmJobskDtlInfo").submit();			
	}
	
	