	
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
			},
			
			fn: {
				pageAction : function() {
				}
			}
	}
	
	
	
	$("#btnUserExcelReg").click(function (event) {

		var formData = $('#frmUserElementaryExcelReg').serializeObject();		
		$("#frmUserElementaryExcelReg").attr("method", "post");
		$("#frmUserElementaryExcelReg").attr("enctype", "multipart/form-data");
		$("#frmUserElementaryExcelReg").attr("action", contextPath + "/internal/user/insertUserInfoByExcel.do");
		$("#frmUserElementaryExcelReg").submit();
	})
	
	function fnUserExcelReg(){

		$("#frmUserElementaryExcelReg").attr("method", "post");
		$("#frmUserElementaryExcelReg").attr("enctype", "multipart/form-data");
		$("#frmUserElementaryExcelReg").attr("action", contextPath + "/internal/user/insertUserInfoByExcel.do");
		$("#frmUserElementaryExcelReg").submit();
	}
