
var resumeInsertErrorMsg = "<spring:message code='resume.write.insert.error'/>";

	var	lmiDataInsert = {
			name: 'lmiDataInsert',

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
					var year = $('#year').val();

					if(year == ""){
						alertify.alert("년도를 입력해주세요.");
						return false;
					}

					$("#selectForm").attr("method", "post");
					$("#selectForm").attr("action", contextPath + "/internal/lmi/insertLmiDataForm.do");
					$('#selectForm').submit();
				});

				$('#btnSave').on('click', function(){
					var objList = [];
					$('#data_tbody').find('tr').each(function(){
						var obj = new Object();
						obj.lmiYearBaseIndicSeq = $(this).find('input[name=lmiYearBaseIndicSeq]').val();
						obj.lmiIndicDataSeq = $(this).find('input[name=lmiIndicDataSeq]').val();
						obj.content = $(this).find('input[name=content]').val();

						objList.push(obj);
					});

					$.ajax({
						type: 'post',
						url: contextPath + "/internal/lmi/insertLmiDataAjax.do",
						dataType: 'json',
						data: {
							"listStr" : JSON.stringify(objList)
						},
						success: function(data) {
							lalertify.alert("지표 결과 값이 저장되었습니다.");
						},
						error: function(xhr, status, error) {
							alertify.alert(resumeInsertErrorMsg);
						}
					});

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
