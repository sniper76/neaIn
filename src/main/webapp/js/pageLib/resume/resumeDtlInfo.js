	
	var	resumeDtlInfo = {
			name: 'resumeDtlInfo',
			
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
				},
			}
	}


	function popUpIsco(){
		$.ajax({
			type : 'post', // 타입
			url :  contextPath + "/internal/resume/selectIscoListAjax.do", // URL
			dataType : 'json', // 데이터 타입
			traditional: true,
			//data : param,
			success:function(rtnData){
				
			},
			complete:function(){
				//
			}
		})
	}