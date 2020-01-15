	var	menuMngReg = {
			name: 'menuMngReg',
			dataTables: null,
	
			init: function() {
				
				this.beforeBind();
				this.bind();
				this.afterBind();
							
			},
			
			beforeBind: function() {
				var that$ = this;
				var deferred = $.Deferred();
			},

			bind: function() {
				
			},
			afterBind: function() {
				
				$("#saveBtn").click(function(){
					if ($("#menuNmKh").val() == '') {
						alertify.alert(menunmkhblank, function(e){
							$("#menuNmKh").focus();
						});
						return;
					}
					if ($("#menuNmEn").val() == '') {
						alertify.alert(menunmenblank, function(e){
							$("#menuNmEn").focus();
						});
						return;
					}
					if ($("#selMenu1").val() == '') {
						alertify.alert(menuonedepth, function(e){
							$("#selMenu1").focus();
						});
						return;
					}
					if(parseInt($("#menuLvl").val()) > 1) {
						if ($("#selMenu2").val() == '') {
							alertify.alert(menutwodepth, function(e){
								$("#selMenu2").focus();
							});
							return;
						}
					}
					if(parseInt($("#menuLvl").val()) > 2) {
						if ($("#selMenu3").val() == '') {
							alertify.alert(menuthreedepth, function(e){
								$("#selMenu3").focus();
							});
							return;
						}
					}
					
					/*
					if ($("#menuUrl").val() == '') {
						alertify.alert(menuurldepth, function(e){
							$("#menuUrl").focus();
						});
						return;
					}
					*/
					
					if ($("#menuSort").val() == '') {
						alertify.alert(menusortdepth, function(e){
							$("#menuSort").focus();
						});
						return;
					}
					
					var useYnTemp = $('input[name="useYnTemp"]:checked').val();
			        $("#useYn").val(useYnTemp);
			        
					var menuLvlTemp = $("#menuLvl").val();
					
					// set upper & full
					var upperMenuCd = "";
					var fullMenuCd = "";
					
					if(menuLvlTemp == 1) {
						fullMenuCd = "";
						upperMenuCd = "";
					} else if (menuLvlTemp == 2) {
						fullMenuCd = $("#selMenu1").val();
						upperMenuCd = $("#selMenu1").val();
					} else if (menuLvlTemp == 3) {
						fullMenuCd = $("#selMenu1").val() + "," + $("#selMenu2").val();
						upperMenuCd = $("#selMenu2").val();
					} else if (menuLvlTemp == 4) {
						fullMenuCd = $("#selMenu1").val() + "," + $("#selMenu2").val() + "," + $("#selMenu3").val();
						upperMenuCd = $("#selMenu3").val();
					}
					
					$("#fullMenuCd").val(fullMenuCd);
					$("#upperMenuCd").val(upperMenuCd);
					
					var st = $(":input:radio[name=priProgramYn]:checked").val();
					$("#priProgramSeq").val(st);
					/*
					if (st == '' || st == null) {
						alertify.alert(menupriprogramblank, function(e){
						});
						return;
					}*/
					
					// 
					var programSeqArr = "";
					$(".programDiv").each(function(index){
						if ($(this).find('.programSeqTemp').val() == '') {
							/*
							alertify.alert(menuprogramblank, function(e){
								$(this).focus();
							});
							return;*/
						} else {
							if (programSeqArr != '' ) {
								programSeqArr += "," + $(this).find('.programSeqTemp').val();
							} else {
								programSeqArr = $(this).find('.programSeqTemp').val();
							}
							 
						}
						
						$("#programSeqArr").val(programSeqArr);
						
					});
					menuMngReg.fn.setMenu();
				});
					
/*				$("#selProgramBtn").click(function(){
					popProgramLayerBtn();
				});*/
				
				$("#deleteMenuBtn").click(function(){
					alertify.confirm(deleteConfirmMsg, function (e) {
						if(e) {
							var param = $("#frm").serializeObject();
							var	opts = {
								url		: contextPath + "/internal/common/deleteMenuMng.do",
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
												location.href=contextPath + "/internal/common/menuMngExternalList.do";
											} else {
												location.href=contextPath + "/internal/common/menuMngInternalList.do";
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
				
				/* SETTING MENU */
				setMenu : function() {
					alertify.confirm(confirmMsg, function (e) {
						if(e) {
							var param = $("#frm").serializeObject();
								var	opts = {
									url		: contextPath + "/internal/common/insertMenuMng.do",
									data	: param,
									type	: "post",
									sendDataType	: "json",
									success	: function(resJSON, resCode) {
										if(resJSON.data.resultCode != '0000') {
											alertify.alert(resJSON.data.msg);
											return false;
										} else {
											alertify.alert(resJSON.data.msg);
											location.href=contextPath + "/internal/common/menuMngInternalList.do"
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
	
function drawUpperMenu(cLvl) {
	
	$("#selMenu1Div").empty();
	$("#selMenu2Div").empty();
	$("#selMenu3Div").empty();

	var menuLvl = $("#menuLvl").val();
	var selHtml1 = "<select id='selMenu1' onChange='chgUpperMenu(this.value, 1);'></select>";
	var selHtml2 = "<select id='selMenu2' onChange='chgUpperMenu(this.value, 2);'></select>";
	var selHtml3 = "<select id='selMenu3' onChange='chgUpperMenu(this.value, 3);'></select>";
	
	if (2 == parseInt(menuLvl)) {
		$("#selMenu1Div").append(selHtml1);
	} else if (3 == parseInt(menuLvl)) {
		$("#selMenu1Div").append(selHtml1);
		$("#selMenu2Div").append(selHtml2);
	} else if (4 == parseInt(menuLvl)) {
		$("#selMenu1Div").append(selHtml1);
		$("#selMenu2Div").append(selHtml2);
		$("#selMenu3Div").append(selHtml3);
	}		
	
	if (parseInt(menuLvl) != 1) {
		initUpperMenu(cLvl);
	}
	
}
	
function initUpperMenu(cLvl) {
	var html = "";
	var upperMenuCd = "";
	if (parseInt(cLvl) != 1) {
		
		var param = {"upperMenuCd":upperMenuCd, "menuLvl":1};
	
		$.ajax({
			type: "POST",
            url :  contextPath + "/internal/common/selectCurrentLvlMenuMngListAjax.do", // URL
            dataType : 'json', // 데이터 타입
            data : param,
			success:function(rtnData){
				console.log(rtnData.data.tailListMenu.length);
				html += "<option value=''>Choose</option>";
				for (i = 0; i < rtnData.data.tailListMenu.length; i++) {
					html += "<option value='"+rtnData.data.tailListMenu[i].menuCd+"'>"+rtnData.data.tailListMenu[i].menuNmEn+"</option>";
					console.log(html);
				}
			},
			error:function(){
				//
			}, complete: function() {
				
				if(parseInt(cLvl) != 1) {
					$("#selMenu1").append(html);
				}
			}
        });
	}
}

function chgUpperMenu(upperMenuCd, depth) {
	var html = "";
	
	if(upperMenuCd != '') {
		
		var param = {"upperMenuCd":upperMenuCd, "menuLvl":parseInt(depth) + 1};
		
			$.ajax({
				type: "POST",
                url :  contextPath + "/internal/common/selectCurrentLvlMenuMngListAjax.do", // URL
                dataType : 'json', // 데이터 타입
                data : param,
    			success:function(rtnData){
    				console.log(rtnData.data.tailListMenu.length);
    				html += "<option value=''>Choose</option>";
    				for (i = 0; i < rtnData.data.tailListMenu.length; i++) {
    					html += "<option value='"+rtnData.data.tailListMenu[i].menuCd+"'>"+rtnData.data.tailListMenu[i].menuNmEn+"</option>";
    					console.log(html);
    				}
    			},
    			error:function(){
    				//
    			}, complete: function() {
    				if (depth == 1) {
    					$("#selMenu2 option").remove();
    					$("#selMenu2").append(html);
    				} else if(depth == 2) {
    					$("#selMenu3 option").remove();
    					$("#selMenu3").append(html);
    				} else if(depth == 3) {
    					$("#selMenu4 option").remove();
    					$("#selMenu4").append(html);
    				}
    			}
            });
	} else {
		html = "<option value=''>Choose</option>";
		if (depth == 1) {
			$("#selMenu2 option").remove();
			$("#selMenu2").append(html);
		} else if(depth == 2) {
			$("#selMenu3 option").remove();
			$("#selMenu3").append(html);
		} else if(depth == 3) {
			$("#selMenu4 option").remove();
			$("#selMenu4").append(html);
		}
	}
}

function addProgram(send_array_val, send_array_text) {
	
	var html = "";
	for (i=0; i < send_array_val.length; i++) {
		
		var dupl = false;
		
		$(".programDiv").each(function(){
			var hval = $(this).find(".programSeqTemp").val();
			if (hval == send_array_val[i]) {
				dupl = true;
			}
		});

		if(!dupl) {
			html += "<div id='programDiv' class='programDiv'>";
			html += "<input type='hidden' id='programSeqTemp_"+send_array_val[i]+"' class='programSeqTemp' name='programSeqTemp' value='"+send_array_val[i]+"'>";
			html += "<input type='radio' name='priProgramYn' value='' class='priProgramYn' id='priProgramYn_"+send_array_val[i]+"'/>&nbsp;";
			html += "<input type='text' name='programNm' id='programNm_"+send_array_val[i]+"' title='input program name' size='40' value='"+send_array_text[i]+"'/>&nbsp;";
			html += "<input type='button' value='Del' id='delBtn' class='bbs_btn type06' onclick='delProgram(this);'/>&nbsp;";
			html += "</div>";
		}
		
	}
	$("#programTd").append(html);
}

function addOneProgram() {
	var html = "";
	html = "<div id='programDiv' class='programDiv'>";
	html += "<input type='hidden' id='programSeqTemp_"+seq+"' class='programSeqTemp' name='programSeqTemp' value=''>";
	html += "<input type='radio' name='priProgramYn' value='' class='priProgramYn' id='priProgramYn_"+seq+"'/>&nbsp;";
	html += "<input type='text' name='programNm' id='programNm_"+seq+"' title='input program name' size='40'/>&nbsp;";
	html += "<input type='button' value='Del' id='delBtn' class='bbs_btn type06' onclick='delProgram(this);'/>&nbsp;";
	html += "</div>";
	$("#programTd").append(html);
	seq++;
	initBtnProgramLayer();
}

/*
var seq = 0;

function addProgram() {
	var html = "";
	html = "<div id='programDiv' class='programDiv'>";
	html += "<input type='hidden' id='programSeqTemp_"+seq+"' class='programSeqTemp' name='programSeqTemp' value=''>";
	html += "<input type='radio' name='priProgramYn' value='' class='priProgramYn' id='priProgramYn_"+seq+"'/>&nbsp;";
	html += "<input type='text' name='programNm' id='programNm_"+seq+"' title='input program name' size='40'/>&nbsp;";
	html += "<input type='button' onclick='selProgramBtn("+seq+");' id='selProgram' class='bbs_btn type06' value='Select Program'/>&nbsp;";
	html += "<input type='button' value='Del' id='delBtn' class='bbs_btn type06' onclick='delProgram(this);'/>&nbsp;";
	html += "<input type='button' value='Add' id='addBtn' class='addBtn bbs_btn type06' onclick='addProgram();'/>";
	html += "</div>";
	$("#programTd").append(html);
	seq++;
	initBtnProgramLayer();
}
*/

function addModProgram(programSeqTemp, priProgramYn, programNm) {
	
	
	var seq = 0;
	var html = "";
	var chk = "";
	if (priProgramYn == 'Y') {
		chk = "checked";
	}
	html = "<div id='programDiv' class='programDiv'>";
	html += "<input type='hidden' id='programSeqTemp_"+seq+"' class='programSeqTemp' name='programSeqTemp' value='"+programSeqTemp+"' />";
	html += "<input type='radio' name='priProgramYn' value='" + programSeqTemp + "' class='priProgramYn' id='priProgramYn_"+seq+"' " + chk + "/>&nbsp;";
	html += "<input type='text' name='programNm' id='programNm_"+seq+"' value='"+programNm+"' title='input program name' size='40' />&nbsp;";
	html += "<input type='button' value='Del' id='delBtn' class='bbs_btn type06' onclick='delProgram(this);' />&nbsp;";
	html += "</div>";
	$("#programTd").append(html);
	seq++;
	initBtnProgramLayer();
}

function delProgram(ths) {
	ths.closest('div').remove();
	initBtnProgramLayer();
}

function initBtnProgramLayer() {
	var i = 0;
	
	$(".programDiv").each(function(index){
		$(this).find('input.addBtn').remove();
	});
	
	$(".programDiv").each(function(index){
		if (i == 0) {
			$(this).append("<input type='button' value='Add' id='addBtn' class='addBtn bbs_btn type06' onclick='selProgramBtn();' />");
		}
		i++;
	});
	// do not empty the programMap
	if (i == 0) {
		addProgram();
	}
}


function selProgramBtn() {
	popProgramLayerBtn();
}


function initSetDrawUpperMenu(cLvl) {
	
	$("#selMenu1Div").empty();
	$("#selMenu2Div").empty();
	$("#selMenu3Div").empty();

	var menuLvl = $("#menuLvl").val();
	var selHtml1 = "<select id='selMenu1' onChange='chgUpperMenu(this.value, 1);'></select>";
	var selHtml2 = "<select id='selMenu2' onChange='chgUpperMenu(this.value, 2);'></select>";
	var selHtml3 = "<select id='selMenu3' onChange='chgUpperMenu(this.value, 3);'></select>";
	
	if (2 == parseInt(menuLvl)) {
		$("#selMenu1Div").append(selHtml1);
	} else if (3 == parseInt(menuLvl)) {
		$("#selMenu1Div").append(selHtml1);
		$("#selMenu2Div").append(selHtml2);
	} else if (4 == parseInt(menuLvl)) {
		$("#selMenu1Div").append(selHtml1);
		$("#selMenu2Div").append(selHtml2);
		$("#selMenu3Div").append(selHtml3);
	}		
	
	initSetUpperMenuOne();
}

function initSetUpperMenuOne() {

	var menuLvl = $("#menuLvl").val();
	var fullMenuCd = $("#fullMenuCd").val();
	var menuCd	=	$("#menuCd").val();
	
	var splitUpperMenuCd = fullMenuCd.split(',');
	var html = "";
	if(menuLvl > 1) {
		var param = {"upperMenuCd":"", "menuLvl":1};
		
		// 1 depth
		$.ajax({
			type: "POST",
            url :  contextPath + "/internal/common/selectCurrentLvlMenuMngListAjax.do", // URL
            dataType : 'json', // 데이터 타입
            data : param,
			success:function(rtnData){
				console.log(rtnData.data.tailListMenu.length);
				html += "<option value=''>Choose</option>";
				for (i = 0; i < rtnData.data.tailListMenu.length; i++) {
					if (splitUpperMenuCd[0] == rtnData.data.tailListMenu[i].menuCd) {
						html += "<option value='"+rtnData.data.tailListMenu[i].menuCd+"' selected>"+rtnData.data.tailListMenu[i].menuNmEn+"</option>";
					} else {
						html += "<option value='"+rtnData.data.tailListMenu[i].menuCd+"'>"+rtnData.data.tailListMenu[i].menuNmEn+"</option>";
					}
				}
				
			},
			error:function(){
				//
			}, complete: function() {
					$("#selMenu1 option").remove();
					$("#selMenu1").append(html);
					
					// 2depth					
					if(menuLvl > 2) {
						html = "";
						var param = {"upperMenuCd":splitUpperMenuCd[0], "menuLvl":2};
						$.ajax({
							type: "POST",
				            url :  contextPath + "/internal/common/selectCurrentLvlMenuMngListAjax.do", // URL
				            dataType : 'json', // 데이터 타입
				            data : param,
							success:function(rtnData){
								console.log(rtnData.data.tailListMenu.length);
								html += "<option value=''>Choose</option>";
								for (i = 0; i < rtnData.data.tailListMenu.length; i++) {
									if (splitUpperMenuCd[1] == rtnData.data.tailListMenu[i].menuCd) {
										html += "<option value='"+rtnData.data.tailListMenu[i].menuCd+"' selected>"+rtnData.data.tailListMenu[i].menuNmEn+"</option>";
									} else {
										html += "<option value='"+rtnData.data.tailListMenu[i].menuCd+"'>"+rtnData.data.tailListMenu[i].menuNmEn+"</option>";
									}
								}
								
							},
							error:function(){
								//
							}, complete: function() {
									$("#selMenu2 option").remove();
									$("#selMenu2").append(html);
									
									// 3depth
									if(menuLvl > 3) {
										html = "";
										var param = {"upperMenuCd":splitUpperMenuCd[1], "menuLvl":3};
										$.ajax({
											type: "POST",
								            url :  contextPath + "/internal/common/selectCurrentLvlMenuMngListAjax.do", // URL
								            dataType : 'json', // 데이터 타입
								            data : param,
											success:function(rtnData){
												console.log(rtnData.data.tailListMenu.length);
												html += "<option value=''>Choose</option>";
												for (i = 0; i < rtnData.data.tailListMenu.length; i++) {
													if (splitUpperMenuCd[2] == rtnData.data.tailListMenu[i].menuCd) {
														html += "<option value='"+rtnData.data.tailListMenu[i].menuCd+"' selected>"+rtnData.data.tailListMenu[i].menuNmEn+"</option>";
													} else {
														html += "<option value='"+rtnData.data.tailListMenu[i].menuCd+"'>"+rtnData.data.tailListMenu[i].menuNmEn+"</option>";
													}
												}
												
											},
											error:function(){
												//
											}, complete: function() {
													$("#selMenu3 option").remove();
													$("#selMenu3").append(html);
													
													
											}
								        });
									}
									
							}
				        });
					}
			}
        });
	}
	
}