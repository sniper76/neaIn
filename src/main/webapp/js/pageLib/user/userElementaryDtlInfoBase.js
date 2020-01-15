	
	var	userElementaryDtlInfoBase = {
			name: 'userElementaryDtlInfoBase',
			
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
				pageAction : function() {
				}
			}
	}
	
	function fnUserInfoModify(){

		var formData = $('#frmUserElementaryDtlInfoBase').serializeObject();
		sessionStorage.setItem("UserElementaryInfo", JSON.stringify(formData));

		$("#frmUserElementaryDtlInfoBase").attr("method", "post");
		$("#frmUserElementaryDtlInfoBase").attr("action", contextPath + "/internal/user/selectUserElementaryDtlInfoModifyAjax.do");
		$("#frmUserElementaryDtlInfoBase").submit();			
	}	