var	eduTrnngProgramMngDtl = {
		name: 'eduTrnngProgramMngDtl',
		
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
			
			//승인여부 Default 대기중
			if (!$("input[name=jcAgreeStsCd]:checked").length) {
				$("input[name=jcAgreeStsCd]").eq(0).attr("checked", "true");
			}
			
			// 승인여부가 승인인 상태에서만 활성화
			$("input[name=jcAgreeStsCd]").on('change', function(e) {
				if ( $(this).val() == 'JAS0000000001' ) {
					$("input[name=recrumtStsCd]").attr('disabled', false);
				} else {
					$("input[name=recrumtStsCd]").attr('disabled', true);
				}
			});
			
			deferred.resolve();	
            return deferred.promise();
		},
		
		bind: function() {
			var that$ = this;

		},
		
		afterBind: function() {
			var that$ = this;
            // Handle form submission event
            $('#btnSubmit').on('click', function(e) {
            	//form submit button click 시 submit 전 로직 구현
            });
            
			$("#frmEduTrnngMngDtl").submit(function(e) {
			    var form$ = $(this);
				form$.find("#btnSubmit").attr('disabled', true);

				e.preventDefault();

				alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (ex) {
					if(ex) {
						var params = {
								data: form$.serializeObject()
							};
						$.when( that$.fn.updateAction( params ) ).done(function( result ) {
							alertify.alert( t( 'cpes.reg.success.msg' ), function (e) { if (e) {
								window.location.href = contextPath + '/internal/trnng/eduTrnngProgramMng.do';
							} });
						}).fail(function ( result ) {
							form$.find("#btnSubmit").attr('disabled', false);
							alertify.alert(result, function (e) { if (e) {} });
						});						
					} else {
						form$.find("#btnSubmit").attr('disabled', false);
					}
				});
			});            
		},		
		fn: {
			updateAction : function(params) {
				var deferred = $.Deferred();
				var options = {
					    method: 'post',
					    url: contextPath + '/internal/trnng/updateEduTrnngProgramMngAjax.do',
					    data: params.data,
					    dataType: 'json',
					};
					    
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.eduTrnngSeq ) {
				        deferred.resolve(res.result);
					} else {
						deferred.reject( t( 'cpes.error.msg' ) );
				    	//deferred.reject("user auth cert fail");				
					}
				}).fail(function (result, status, responseObj) {
					deferred.reject( t( 'cpes.error.msg' ) );
					//deferred.reject("system error: " + status);			
				});				
				return deferred.promise();
			},
		}
}
