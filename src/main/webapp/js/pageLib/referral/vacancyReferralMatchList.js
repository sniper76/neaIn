
	var	vacancyReferralMatchList = {
			name: 'vacancyReferralMatchList',
			dataTables: null,
	
			init: function() {
				this.beforeBind();
				this.bind();
				this.afterBind();
			},
			
			beforeBind: function() {
				var that$ = this;
	
			},

			bind: function() {
				var that$ = this;
				
				var setColumns = [
					{"data": "resumeSeq"},
					{"data": "rowNum"},
					{"data": "occup"},
	            	{"data": "loc"},
		            {"data": "edu"},
		            {"data": "wage"},
		            {"data": "userNm"},
		            {"data": "gender"},
		            {"data": "age"},
					{"data": "cell"},
					{"data": "email"},
					{"data": "resumeTitle"},
					{"data": ""},
		           
					{"data": "vacancySeq"},
					{"data": "totPoint"}
			    ];
				
				var orderColumns = setColumns.map(function(x) {return x.data });
				
				that$.dataTables = $('#vacancyReferralMatch').DataTable({
					stateSave : true,
					pageLength: 10,
	                lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
			        processing: true,
			        serverSide: true,
					searching: false,
			        destroy: true,
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/referral/selectVacancyReferralMatchListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
								oneDepth: $('#oneDepth option:selected').val(),
                        		twoDepth: $('#twoDepth option:selected').val(),
			                	threeDepth: $('#threeDepth option:selected').val(),
								fourDepth: $('#fourDepth option:selected').val(),
								vacancySeq: $('#hidVacancySeq').val(),
								province: $('#province option:selected').val(),
								district: $('#district option:selected').val(),
			                	wage: $('#wage').val(),
								minEduDegreeCd: $('input[name="minEduDegreeCd"]:checked').val()
								
			                	
			                } );
						}
						, dataSrc: function(res) {
							that$.getRowData = res.aaData;
							return res.aaData;
						}
			        },
			        columns: setColumns,
			        columnDefs: [
						{ targets: 0, checkboxes: { selectRow: true } },
	                    {
	                    	targets: 12,
	                        render: function ( data, type, full, meta ) {
								var html = "";
								// referral Management Popup param : vacancySeq,resumeSeq,알선 구분 코드,1:수정모드 2: 읽기모드
								html = "<input type=\"button\" value=\"Manage\" id=\"btnSearch\" class=\"bbs_btn type02 small writing\" onclick=\"popReferralManageLayerBtn('"+ full.vacancySeq +"','"+ full.resumeSeq +"','RFT0000000001','1');\" />" ;
								
								return html;
	                        }
						},
						{ targets: [13,14], visible: false, searchable: false }
			        ],		        
					order: [[2, 'asc']],
					dom : 'lBfrtip',
					buttons: [
						{
							extend: 'excel',
							name: 'EXCELDOWNLOAD',
							className: 'bbs_btn type03 download',
							exportOptions: {
								modifier: {
									page: 'current'
								}
							}
						}
					],
			    });
			},
			afterBind: function() {
				var that$ = this;
				
				
				// Search Button
	            $('#btnSearch').on('click', function(e) {
						if ($('#oneDepth option:selected').val() == "") {
							alertify.alert(oneDepthMsg, function (e) {
								if (e) {
									$("#oneDepth").focus();
								}
							});
							return;
						}
						if ($('#twoDepth option:selected').val() == "") {
							alertify.alert(twoDepthMsg, function (e) {
								if (e) {
									$("#twoDepth").focus();
								}
							});
							return;
						}
						if ($('#threeDepth option:selected').val() == "") {
							alertify.alert(threeDepthMsg, function (e) {
								if (e) {
									$("#threeDepth").focus();
								}
							});
							return;
						}
						if ($('#fourDepth option:selected').val() == "") {
							alertify.alert(fourDepthMsg, function (e) {
								if (e) {
									$("#fourDepth").focus();
								}
							});
							return;
						}
						if ($('#province option:selected').val() == "") {
							alertify.alert(provinceMsg, function (e) {
								if (e) {
									$("#province").focus();
								}
							});
							return;
						}
						if ($('#district option:selected').val() == "") {
							alertify.alert(districtMsg, function (e) {
								if (e) {
									$("#district").focus();
								}
							});
							return;
						}
						if ($('#wage').val() == "") {
							alertify.alert(wageMsg, function (e) {
								if (e) {
									$("#wage").focus();
								}
							});
							return;
						}
						if ($('input[name="minEduDegreeCd"]:checked').val() == "") {
							alertify.alert(eduMsg, function (e) {
								if (e) {
									$("#minEduDegreeCd").focus();
								}
							});
							return;
						}
		            that$.dataTables.ajax.reload();
				});
				

				$('#oneDepth').change(function(e) {
		            $('#twoDepth,#threeDepth,#fourDepth').find('option').each(function(){
						
						$(this).remove();
					});
					$('#twoDepth').append("<option value=\"\">2 Depth</option>");
					$('#threeDepth').append("<option value=\"\">3 Depth</option>");
					$('#fourDepth').append("<option value=\"\">4 Depth</option>");

					var selectVal = $(this).val();

					if(selectVal != ""){
						var param = {iscoId: selectVal};

						$.ajax({
							type : 'post', // 타입
							url :  contextPath + "/internal/referral/selectIscoTwoListAjax.do", // URL
							dataType : 'json', // 데이터 타입
							traditional: true,
							data : param,
							success:function(result){
								
								if(result.twoDepth.length != null){
									$('#twoDepth option:first').remove();
									$('#twoDepth').append("<option value=\"\">2 Depth</option>");
									for(var i in result.twoDepth){
										var depthobj = result.twoDepth[i];
										$('#twoDepth').append("<option value=\""+ depthobj.iscoId +"\">"+ depthobj.cateNm +"</option>");
									}
								}
								
							},
							complete:function(){
								//
							}
						})
						
					}

				});


				$('#twoDepth').change(function(e) {
		            $('#threeDepth,#fourDepth').find('option').each(function(){
						
						$(this).remove();
					});
					$('#threeDepth').append("<option value=\"\">3 Depth</option>");
					$('#fourDepth').append("<option value=\"\">4 Depth</option>");

					var selectVal = $(this).val();

					if(selectVal != ""){
						var param = {iscoId: selectVal};

						$.ajax({
							type : 'post', // 타입
							url :  contextPath + "/internal/referral/selectIscoThreeListAjax.do", // URL
							dataType : 'json', // 데이터 타입
							traditional: true,
							data : param,
							success:function(result){
								
								if(result.threeDepth.length != null){
									$('#threeDepth option:first').remove();
									$('#threeDepth').append("<option value=\"\">3 Depth</option>");
									for(var i in result.threeDepth){
										var depthobj = result.threeDepth[i];
										$('#threeDepth').append("<option value=\""+ depthobj.iscoId +"\">"+ depthobj.cateNm +"</option>");
									}
								}
								
							},
							complete:function(){
								//
							}
						})
						
					}

				});

				$('#threeDepth').change(function(e) {
		            $('#fourDepth').find('option').each(function(){
						
						$(this).remove();
					});
					
					$('#fourDepth').append("<option value=\"\">4 Depth</option>");

					var selectVal = $(this).val();

					if(selectVal != ""){
						var param = {iscoId: selectVal};

						$.ajax({
							type : 'post', // 타입
							url :  contextPath + "/internal/referral/selectIscoFourListAjax.do", // URL
							dataType : 'json', // 데이터 타입
							traditional: true,
							data : param,
							success:function(result){
								
								if(result.fourDepth.length != null){
									$('#fourDepth option:first').remove();
									$('#fourDepth').append("<option value=\"\">4 Depth</option>");
									for(var i in result.fourDepth){
										var depthobj = result.fourDepth[i];
										$('#fourDepth').append("<option value=\""+ depthobj.iscoId +"\">"+ depthobj.cateNm +"</option>");
									}
								}
								
							},
							complete:function(){
								//
							}
						})
						
					}

				});


				$('#province').change(function(e) {
		            $('#district').find('option').each(function(){
						
						$(this).remove();
					});
					
					$('#district').append("<option value=\"\">District</option>");

					var selectVal = $(this).val();

					if(selectVal != ""){
						var param = {lvlCd: selectVal};

						$.ajax({
							type : 'post', // 타입
							url :  contextPath + "/internal/referral/selectDistrictListAjax.do", // URL
							dataType : 'json', // 데이터 타입
							traditional: true,
							data : param,
							success:function(result){
								
								if(result.distrc.length != null){
									$('#district option:first').remove();
									$('#district').append("<option value=\"\">District</option>");
									for(var i in result.distrc){
										var depthobj = result.distrc[i];
										$('#district').append("<option value=\""+ depthobj.lvlCd +"\">"+ depthobj.nm +"</option>");
									}
								}
								
							},
							complete:function(){
								//
							}
						})
						
					}

				});
	            
	            
			},
			fn: {
				//게시물 그리기
				drawList : function(dataJson) {
				}
			}

	}


	function searchCmpnyInfo(cmpnySeq,cmpnyNmkh,cmpnyNmEn){
		var param = {cmpnySeq: cmpnySeq};
		$.ajax({
			type : 'post', // 타입
			url :  contextPath + "/internal/referral/selectCmpnyInfoAjax.do", // URL
			dataType : 'json', // 데이터 타입
			traditional: true,
			data : param,
			success:function(result){
				var setValue = result.ReferralMatchBean;
				
				setResumeInfo(setValue);
				
			},
			complete:function(){
				//
			}
		})

	}

	function setResumeInfo(setValue){
		$('#compnyNm').val(setValue.compnyNm);
		$('#mngerTel').val(setValue.mngerTel);
		$('#mngerNm').val(setValue.mngerNm);
		$('#mngerCell').val(setValue.mngerCell);
		$('#addrNm').val(setValue.addrNm);
		$('#cmpnySeq').val(setValue.cmpnySeq);

	}


	function detailCompnyView(){
		var previousUrl = contextPath + "/internal/referral/vacancyReferralMatchList.do";
		$("#frmParam").find("#previousUrl").val(previousUrl);
		$("#frmParam").attr("method", "post");
		$("#frmParam").attr("action", contextPath + "/internal/user/selectUserCmpnyDtlInfoMain.do");
		$("#frmParam").submit();

	}

