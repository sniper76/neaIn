
var resumeInsertErrorMsg = "<spring:message code='resume.write.insert.error'/>";

	var	lmiInsert = {
			name: 'lmiInsert',

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
					var indicItemNm = $('#indicItemNm').val();
					var depth = $('#depth').val();
					var upperLmiYearBaseIndicSeq = "";
					var fullLmiYearBaseIndicSeq = "";

					if(depth == 2){
						upperLmiYearBaseIndicSeq = $('#depth_1').val();
						fullLmiYearBaseIndicSeq = $('#depth_1').val();
					}else if(depth == 3){
						upperLmiYearBaseIndicSeq = $('#depth_2').val();
						fullLmiYearBaseIndicSeq = $('#depth_1').val() + "," + $('#depth_2').val();
					}

					if(year == ""){
						alertify.alert("년도를 입력해주세요.");
						return false;
					}

					if(indicItemNm == ""){
						alertify.alert("지표명을 입력해주세요.");
						return false;
					}

					if(depth != 1){
						if(upperLmiYearBaseIndicSeq == ""){
							alertify.alert("상위 지표를 선택해 주세요");
							return false;
						}

					}

					$.ajax({
						type: 'post',
						url: contextPath + "/internal/lmi/insertLmiAjax.do",
						dataType: 'json',
						data: {
							"year" : year,
							"indicItemNm" : indicItemNm,
							"depth" : depth,
							"upperLmiYearBaseIndicSeq" : upperLmiYearBaseIndicSeq,
							"fullLmiYearBaseIndicSeq" : fullLmiYearBaseIndicSeq
						},
						success: function(data) {

							if(data.result == 1){
								alertify.alert("지표 등록이 완료되었습니다.", function(){
									//location.reload();
								});
							}else if(data.result == 99){
								alertify.alert("이미 등록되어 있는 지표 입니다.");
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

	function fnSelectLmiDepth(depth, upperLmiYearBaseIndicSeq){
		var year = $('#year').val();

		if(year != ""){
			$.ajax({
				type: 'post',
				url: "/internal/lmi/selectLmiDepthListAjax.do",
				dataType: 'json',
				data: {
					"year" : year,
					"depth" : (Number(depth) - 1),
					"upperLmiYearBaseIndicSeq" : upperLmiYearBaseIndicSeq
				},
				success: function(data) {

					var html = "<option value=''>select</option>";

					for(var i in data.result){
						var obj = data.result[i];
						html += "<option value='" + obj.lmiYearBaseIndicSeq + "'>" + obj.indicItemNm + "</option>";
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
		}else{
			alertify.alert("먼저 년도를 입력하여야 상위 지표를 검색할 수 있습니다.");
		}

	}