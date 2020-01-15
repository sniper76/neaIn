var	List = {
		name: 'List',
		dataTables: null,
		commCode: {},
		
		init: function() {
			var that$ = this;
			
			$.when( this.beforeBind() ).done(function( res ) {
				that$.bind();
				that$.afterBind();
			});
		},
		
		beforeBind: function() {
		},
		bind: function() {

		},
		
		afterBind: function() {
			
			$("#saveBtn").click(function(){
				alertify.confirm(confirmMsg, function (e) {
					if(e) {
						var param = $("#frm").serializeObject();
						var	opts = {
								url		: contextPath + "/internal/userChg/updateUserChgStsAjax.do",
								data	: param,
								type	: "post",
								sendDataType	: "json",
								success	: function(resJSON, resCode) {
									alertify.alert(resJSON.data.msg);
									// failed
									if(resJSON.data.resultCode != '0000') {
										return false;
									} else {
										List.fn.changeSaveForm();
									}
									
								},
								error : function() {
									
								}
							};
							common.http.ajax(opts);
					} else {
						alertify.alert(cancelMsg);
					}
				});
				
			});
				
		},
		
		fn: {
			changeSaveForm : function() {
				if ($("#chgAgreeStsCd option:selected").val() == 'CAS0000000002' || $("#chgAgreeStsCd option:selected").val() == 'CAS0000000003') {
					$("#chgAgreeStsCd option").not(":selected").prop("disabled", "disabled");
					$("#agreeRejectReason").prop("readonly",true);
				} else 	{
					
				}
			} 
		}
}