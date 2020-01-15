	
	var	jobskVacancyDtlInfo = {
			name: 'jobskVacancyDtlInfo',
			
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
	
	function btnJobskVacancyDtlInfoModify(){
		var formData = $('#frmJobskVacancyDtlInfo').serializeObject();
		sessionStorage.setItem("JobskVacancyDtlInfo", JSON.stringify(formData));

		$("#frmJobskVacancyDtlInfo").attr("method", "post");
		$("#frmJobskVacancyDtlInfo").attr("action", contextPath + "/internal/jobsk/selectJobskVacancyDtlInfoModifyAjax.do");
		$("#frmJobskVacancyDtlInfo").submit();			
	}
	
	