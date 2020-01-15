
var resumeInsertErrorMsg = "<spring:message code='resume.write.insert.error'/>";

	var	APList = {
			name: 'APList',

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

				common.form.fnInputValidation('inputNo', '1');

				$('#btnSelect').on('click', function(){

					$("#selectForm").attr("method", "post");
					$("#selectForm").attr("action", contextPath + "/internal/annualPlan/APList.do");
					$('#selectForm').submit();
				});

				$('#btnInsert').on('click', function(){
					$("#selectForm").attr("method", "post");
					$("#selectForm").attr("action", contextPath + "/internal/annualPlan/insertAPForm.do");
					$('#selectForm').submit();
				});

			},

			afterBind: function() {
				var that$ = this;
			},

			fn: {
				pageAction : function() {
				},
			}
	}
