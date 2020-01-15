
var resumeInsertErrorMsg = "<spring:message code='resume.write.insert.error'/>";

	var	lmiList = {
			name: 'lmiList',

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

				$('#preYear').on('click', function(){
					var year = Number($('#year').val()) - 1;
					$('#year').val(year);

					$("#selectForm").attr("method", "post");
					$("#selectForm").attr("action", contextPath + "/internal/lmi/selectLmiDetailForm.do");
					$('#selectForm').submit();
				});

				$('#nextYear').on('click', function(){
					var year = Number($('#year').val()) + 1;
					$('#year').val(year);

					$("#selectForm").attr("method", "post");
					$("#selectForm").attr("action", contextPath + "/internal/lmi/selectLmiDetailForm.do");
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
