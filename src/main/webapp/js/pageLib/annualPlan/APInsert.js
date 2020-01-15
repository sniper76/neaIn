
var resumeInsertErrorMsg = "<spring:message code='resume.write.insert.error'/>";

	var	APInsert = {
			name: 'APInsert',

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

				$('#depth').on('change', function(){
					var selectVal = $(this).val();

					if(selectVal == 1){
						$('#depth_1').hide();
						$('#depth_2').hide();
					}else if(selectVal == 2){
						fnSelectLmiDepth(selectVal, "");
						$('#depth_1').show();
						$('#depth_2').hide();
					}else if(selectVal == 3){
						fnSelectLmiDepth('2', "");
						$('#depth_1').show();
						$('#depth_2').show();
					}
				});

				$('#depth_1').on('change', function(){
					var depth = $('#depth').val();

					if(depth == 3){
						var selectVal = $(this).val();
						fnSelectLmiDepth(depth, selectVal);
					}
				});

				$('#btnSave').on('click', function(){
					var year = $('#year').val();
					var title = $('#title').val();
					var indicItemNm = $('#indicItemNm').val();
					var depth = $('#depth').val();
					var upperYearBaseIndicSeq = "";
					var fullYearBaseIndicSeq = "";

					if(depth == 2){
						upperYearBaseIndicSeq = $('#depth_1').val();
						fullYearBaseIndicSeq = $('#depth_1').val();
					}else if(depth == 3){
						upperYearBaseIndicSeq = $('#depth_2').val();
						fullYearBaseIndicSeq = $('#depth_1').val() + "," + $('#depth_2').val();
					}

					if(year == ""){
						alertify.alert("년도를 입력해주세요.");
						return false;
					}

					if(title == ""){
						alertify.alert("제목을 입력해주세요.");
						return false;
					}

					if(indicItemNm == ""){
						alertify.alert("지표명을 입력해주세요.");
						return false;
					}

					if(depth != 1){
						if(upperYearBaseIndicSeq == ""){
							alertify.alert("상위 지표를 선택해 주세요");
							return false;
						}

					}

					$.ajax({
						type: 'post',
						url: contextPath + "/internal/annualPlan/insertAPAJax.do",
						dataType: 'json',
						data: {
							"year" : year,
							"title" : title,
							"indicItemNm" : indicItemNm,
							"depth" : depth,
							"upperYearBaseIndicSeq" : upperYearBaseIndicSeq,
							"fullYearBaseIndicSeq" : fullYearBaseIndicSeq
						},
						success: function(data) {

							if(data.result == 1){
								alertify.alert("AnnualPlan 등록이 완료되었습니다.", function(){
									$("#frm").attr("method", "post");
									$("#frm").attr("action", contextPath + "/internal/annualPlan/insertAPForm.do");
									$('#frm').submit();
								});
							}else if(data.result == 99){
								alertify.alert("이미 등록되어 있는 AnnualPlan 입니다.");
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

	function fnSelectLmiDepth(depth, upperYearBaseIndicSeq){
		var year = $('#year').val();
		var title = $('#title').val();
		if(year != "" && title != ""){
			$.ajax({
				type: 'post',
				url: contextPath + "/internal/annualPlan/selectAPDepthListAjax.do",
				dataType: 'json',
				data: {
					"year" : year,
					"depth" : (Number(depth) - 1),
					"title" : title,
					"upperYearBaseIndicSeq" : upperYearBaseIndicSeq
				},
				success: function(data) {

					var html = "<option value=''>select</option>";

					for(var i in data.result){
						var obj = data.result[i];
						html += "<option value='" + obj.yearBaseIndicSeq + "'>" + obj.indicItemNm + "</option>";
					}

					if(depth == 2){
						$('#depth_1').html(html);
						$('#depth_2').html("<option value=''>select</option>");
					}else if(depth == 3){
						$('#depth_2').html(html);
					}

				},
				error: function(xhr, status, error) {
					alertify.alert(resumeInsertErrorMsg);
				}
			});
		}

	}