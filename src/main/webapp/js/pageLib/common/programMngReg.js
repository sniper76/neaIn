	var	programMngReg = {
			name: 'programMngReg',
			dataTables: null,
	
			init: function() {
				
				this.beforeBind();
				this.bind();
				this.afterBind();
							
			},
			
			beforeBind: function() {
			},

			bind: function() {
				
			},
			afterBind: function() {
				
				$("#saveBtn").click(function(){
					if ($("#programNmKh").val() == '') {
						alertify.alert(programnmkhblank, function(e){
							$("#programNmKh").focus();
						});
						return;
					}
					if ($("#programNmEn").val() == '') {
						alertify.alert(programnmenblank, function(e){
							$("#programNmEn").focus();
						});
						return;
					}
					if ($("#programUrl").val() == '') {
						alertify.alert(programurldepth, function(e){
							$("#programUrl").focus();
						});
						return;
					}
					
					var useYnTemp = $('input[name="useYnTemp"]:checked').val();
			        $("#useYn").val(useYnTemp);
			        
					programMngReg.fn.setProgram();
				});
				
				
				$("#delBtn").click(function(){
					alertify.confirm(deleteConfirmMsg, function (e) {
						if(e) {
							var param = $("#frm").serializeObject();
							var	opts = {
								url		: contextPath + "/internal/common/deleteProgramMng.do",
								data	: param,
								type	: "post",
								sendDataType	: "json",
								success	: function(resJSON, resCode) {
									if(resJSON.data.resultCode != '0000') {
										alertify.alert(resJSON.data.msg);
										return false;
									} else {
										alertify.alert(resJSON.data.msg, function(e){
											if($("#rangeCd").val() == 'RNG0000000003') {
												location.href=contextPath + "/internal/common/programMngExternalList.do";
											} else {
												location.href=contextPath + "/internal/common/programMngInternalList.do";
											}
											
										});
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
				
				/* 신청양식 첨부파일명 조회 */
				setProgram : function() {
					alertify.confirm(confirmMsg, function (e) {
						if(e) {
							var param = $("#frm").serializeObject();
								var	opts = {
									url		: contextPath + "/internal/common/insertProgramMng.do",
									data	: param,
									type	: "post",
									sendDataType	: "json",
									success	: function(resJSON, resCode) {
										if(resJSON.data.resultCode != '0000') {
											alertify.alert(resJSON.data.msg);
											return false;
										} else {
											alertify.alert(resJSON.data.msg, function(e){
												if($("#rangeCd").val() == 'RNG0000000003') {
													//location.href=contextPath + "/internal/common/programMngExternalList.do";
												} else {
													//location.href=contextPath + "/internal/common/programMngInternalList.do";
												}
												
											});
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
			}
		}
	}
	
	