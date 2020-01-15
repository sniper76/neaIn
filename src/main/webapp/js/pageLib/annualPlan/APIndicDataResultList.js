
var resumeInsertErrorMsg = "<spring:message code='resume.write.insert.error'/>";

	var	APIndicDataResultList = {
			name: 'APIndicDataResultList',

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

				$('#btnSearch').on('click', function(){

					var year = $('#year').val();
					var title = $('#title').val();

					if(year == ""){
						alertify.alert("년도를 입력해주세요.");
						return false;
					}

					if(title == ""){
						alertify.alert("제목을 입력해주세요.");
						return false;
					}

					$("#frm").attr("method", "post");
					$("#frm").attr("action", contextPath + "/internal/annualPlan/APIndicDataResultListForm.do");
					$('#frm').submit();

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
