
var resumeInsertErrorMsg = "<spring:message code='resume.write.insert.error'/>";

	var	APIndicDataInsert = {
			name: 'APIndicDataInsert',

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
					$("#frm").attr("action", contextPath + "/internal/annualPlan/insertAPIndicDataForm.do");
					$('#frm').submit();

				});

				$('#btnSave').on('click', function(){

					var dataList = [];

					var jcCd = $('#jcCd').val();

					$('#data_tbody').find('tr').each(function(){
						var yearBaseIndicSeq = $(this).find('.yearBaseIndicSeq').val();

						$(this).find('.month').each(function(){
							var month = $(this).find('input').attr('class');
							var content = $(this).find('input').val();
							var indicDataSeq = $(this).find('.indicDataSeq').val();

							if(content != ''){
								var obj = new Object();
								obj.yearBaseIndicSeq = yearBaseIndicSeq;
								obj.indicDataSeq = indicDataSeq;
								obj.month = month;
								obj.content = content;
								obj.jcCd = jcCd;

								dataList.push(obj);
							}
						});
					});

					if(dataList.length == 0){
						alertify.alert("저장할 데이터를 입력하세요.");
						return false;
					}

					$.ajax({
						type: 'post',
						url: contextPath + "/internal/annualPlan/insertAPIndicDataAjax.do",
						dataType: 'json',
						data: {
							"listStr" : JSON.stringify(dataList)
						},
						success: function(data) {

							if(data.result > 0){
								alertify.alert("AnnualPlan 목표 등록이 완료되었습니다.", function(){

								});
							}else{
								alertify.alert(resumeInsertErrorMsg);
							}

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
