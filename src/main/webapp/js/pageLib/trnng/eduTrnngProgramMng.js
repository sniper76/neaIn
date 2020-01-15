var	eduTrnngProgramMng = {
		name: 'eduTrnngProgramMng',
		dataTables: null,
		commCode: {},
		majorCode: {
			major1DepthCd:[],
			major2DepthCd:[]
		},
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
			var commCdParams = {
					data: {
						commGrpCdList: ['jcCd', 'trnngNatnexpDivCd', 'insttTypeCd', 'jcAgreeStsCd', 'eduDivCd', 'insttStsCd', 'insttOwnershipCd', 'recrumtStsCd', 'insttTypeCd', 'pcTypeCd' , 'tvcDivCd', 'hgepDivCd'],
						commGrpUseYn: 'Y'
					}
				};
			var majorCdParams = { 
					data: {
						grpCd: '', 
						commGrpUseYn: 'Y'
					}
				};
			$.when( that$.fn.getCommCd(commCdParams), that$.fn.getMajorCd(majorCdParams) ).done(function( commCd, majorCd ) {
				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
				that$.commCode['trnngNatnexpDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('trnngNatnexpDivCd', 'snake') ];
				that$.commCode['insttTypeCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttTypeCd', 'snake') ];
				that$.commCode['jcAgreeStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('jcAgreeStsCd', 'snake') ];
				that$.commCode['eduDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('eduDivCd', 'snake') ];
				that$.commCode['insttStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttStsCd', 'snake') ];
				that$.commCode['insttOwnershipCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttOwnershipCd', 'snake') ];
				that$.commCode['recrumtStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('recrumtStsCd', 'snake') ];
				that$.commCode['insttTypeCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttTypeCd', 'snake') ];
				that$.commCode['pcTypeCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('pcTypeCd', 'snake') ];
				that$.commCode['tvcDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('tvcDivCd', 'snake') ];
				that$.commCode['hgepDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('hgepDivCd', 'snake') ];
				
				that$.majorCode['major1DepthCd'] = (JSON.parse(JSON.stringify(majorCd))).filter(function(x) {
					return x.grpCd == x.dtlCd;
				});
				that$.majorCode['major2DepthCd'] = (JSON.parse(JSON.stringify(majorCd))).filter(function(x) {
					return x.grpCd != x.dtlCd;
				});

				$.each(that$.majorCode['major1DepthCd'], function (i, item) {
				    $('#major1DepthCd').append($('<option>', { 
				        value: item.dtlCd,
				        text : that$.fn.commCdLang(item) 
				    }));
				});
				
				that$.fn.setSelDynamicMajorCd( $('#major1DepthCd option:selected').val() );

				common.sys.getDatepicker();
	            
	            $('#startDate').datepicker('setDate', '-14D');
	            $('#endDate').datepicker('setDate', 'today');
	            $('button#-14D').addClass('on');
	            $("#periodOn").val("-14D");

	            var sessData = JSON.parse(sessionStorage.getItem(that$.name));
	            if (sessData) {
	        		$('#eduDivCd').val(sessData.eduDivCd);		        		
	        		$('#jcCd').val(sessData.jcCd);
	        		$('#trnngNatnexpDivCd').val(sessData.trnngNatnexpDivCd);
	        		$('#insttTypeCd').val(sessData.insttTypeCd);
	        		$('#pcTypeCd').val(sessData.pcTypeCd);
	        		$('#tvcDivCd').val(sessData.tvcDivCd);
	        		$('#hgepDivCd').val(sessData.hgepDivCd);			        		
	        		$('#searchKeyword').val(sessData.searchKeyword);
	        		$('#searchValue').val(sessData.searchValue);
	        		$('#periodKeyword').val(sessData.periodKeyword);

	        		$('#major1DepthCd').val(sessData.major1DepthCd);		        		
					that$.fn.setSelDynamicMajorCd( $('#major1DepthCd option:selected').val() );
	        		
	        		$('input[name=jcAgreeStsCd]:input[value=' + sessData.jcAgreeStsCd + ']').attr('checked', true);			        		
	        		$('input[name=recrumtStsCd]:input[value=' + sessData.recrumtStsCd + ']').attr('checked', true);			        	
	        		$('input[name=insttOwnershipCd]:input[value=' + sessData.insttOwnershipCd + ']').attr('checked', true);
	        		
	                $("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
	                
	                if (sessData.periodOn != "") {
		                $("#periodOn").val(sessData.periodOn);
		            	$('button#'+sessData.periodOn).addClass('on');
	                }
	                
	                sessionStorage.clear();
	            }		
	            
				deferred.resolve();	
			});

            return deferred.promise();
		},
		bind: function() {
			var that$ = this;


			var setColumns = [
				{"data": "eduTrnngSeq"},					//시퀀스
				{"data": "rowNum"},							//넘버
				{"data": "insttNm"},						//교육기관
				{"data": "trnngNatnexpDivCd"},				//구분
				{"data": "eduTrnngNm"},						//프로그램명
				{"data": "programCorsTypeCd"},				//프로그램코스유형
				{"data": "provcCd"},						//지역
				{"data": "recurmtDt"},						//모집기간
				{"data": "eduDt"},							//수행기간
				{"data": "jcAgreeStsCd"},					//승인여부
				{"data": "recrumtStsCd"},					//모집상태
				{"data": "regDt"},							//신청일시
				{"data": "jcAgreeDt"},						//승인일시
				{"data": "jcUserNm"},						//승인자

				{"data": "eduTrnngSubSeq"},
				{"data": "insttSeq"},
				{"data": "userSeq"},
				{"data": "jcUserSeq"},

				{"data": "insttNmKh"},
				{"data": "insttNmEn"},
				{"data": "recurmtBgnDt"},
				{"data": "recurmtEndDt"},
				{"data": "eduBgnDt"},
				{"data": "eduEndDt"},

				{"data": "jcCd"},
				{"data": "eduDivCd"},
				{"data": "insttTypeCd"},
				{"data": "insttStsCd"},
				{"data": "insttOwnerCd"},
				{"data": "tvcDivCd"},
				{"data": "hgepDivCd"},
				{"data": "skillJobProgramCorsCd"},
				{"data": "major1DepthCd"},
				{"data": "major2DepthCd"},
				{"data": "skillJobProgramCorsCd"},
				{"data": "highGenrlEduCorsCd"},
				{"data": "addrCd"},
				{"data": "dataStsCd"},
				{"data": "timeWeek"},
			];
			
			var orderColumns = setColumns.map(function(x) { return x.data });
			
			that$.dataTables = $('#eduTrnngProgramMngTable').DataTable({
				pageLength: 10,
	            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
			    processing: true,
			    serverSide: true,
			    searching: false,
			    destroy: true,
			    serverMethod: 'post',
			    ajax: {
			    	url: contextPath + '/internal/trnng/selectEduTrnngProgramMngListAjax.do?orderColumns='+orderColumns
			    	, data: function ( d ) {
			        	return $.extend( {}, d, {
			        		eduDivCd: $('#eduDivCd').val(),			        		
			        		jcCd: $('#jcCd option:selected').val(),
			        		trnngNatnexpDivCd: $('#trnngNatnexpDivCd option:selected').val(),
			        		insttTypeCd: $('#insttTypeCd option:selected').val(),
			        		pcTypeCd: $('#pcTypeCd option:selected').val(),
			        		major1DepthCd: $('#major1DepthCd option:selected').val(),			        		
			        		major2DepthCd: $('#major2DepthCd option:selected').val(),			        		
			        		jcAgreeStsCd: $('input[name=jcAgreeStsCd]:checked').val(),			        		
			        		recrumtStsCd: $('input[name=recrumtStsCd]:checked').val(),			        	
			        		insttOwnershipCd: $('input[name=insttOwnershipCd]:checked').val(),
			        		tvcDivCd: $('#tvcDivCd option:selected').val(),
			        		hgepDivCd: $('#hgepDivCd option:selected').val(),			        		
			        		searchKeyword: $('#searchKeyword option:selected').val(),
			        		searchValue: $.trim($('#searchValue').val()),
			        		periodKeyword: $('#periodKeyword option:selected').val(),
			        		startDate: $('#startDate').val(),
			        		endDate: $('#endDate').val(),
			        	} );
			        }
 			        , dataType: 'json'
			    },
			    columns: setColumns,
			    columnDefs: [
			    	{ targets: 0, checkboxes: { selectRow: true } },
			    	{ targets: 1, orderable: false },
                    { targets: 3, render: function ( data, type, full, meta ) {
	                		var obj = that$.commCode['trnngNatnexpDivCd'].find(function(x) { return x.dtlCd == data });
	                		return that$.fn.commCdLang(obj) ;                    	
            			}
                    },
                    { targets: 4, render: function ( data, type, full, meta ) {
                    		return "<a href=\"javascript:void(0);\" onclick=\"eduTrnngProgramMng.fn.pageAction('" + full.eduTrnngSeq + "');\">" + data + "</font>" ;
                    	}
	                },
                    { targets: 5, render: function ( data, type, full, meta ) {
	                		var obj = that$.commCode['pcTypeCd'].find(function(x) { return x.dtlCd == data });
	                		return that$.fn.commCdLang(obj) ;
	                	}
	                },			    	
                    { targets: 7, orderable: false, render: function ( data, type, full, meta ) {
	                		return  full.recurmtBgnDt + ' ~ <br/>' + full.recurmtEndDt ;
                    	}
	                },			    	
                    { targets: 8, orderable: false, render: function ( data, type, full, meta ) {
	                		return  full.eduBgnDt + ' ~ <br/>' + full.eduEndDt ;
	                	}
	                },
	                { targets: 9, render: function ( data, type, full, meta ) {
	    					var seljcAgreeStsCdStr  = "<select name='jcAgreeStsCd' id='" + full.eduTrnngSeq + "'>";
		    				$.each(that$.commCode['jcAgreeStsCd'], function (i, item) {
		    					seljcAgreeStsCdStr += "<option value='" + item.dtlCd + "'" + ( item.dtlCd == data ? 'selected=seleected' : '' ) + ">" + that$.fn.commCdLang(item) + "</option>";
				    		});
	    					seljcAgreeStsCdStr += "</select>";
	    						
	    					return seljcAgreeStsCdStr;
	                	}
	                },
	                { targets: 10, render: function ( data, type, full, meta ) {
                			var obj = that$.commCode['recrumtStsCd'].find(function(x) { return x.dtlCd == data });
                			return that$.fn.commCdLang(obj) ;                 	
	                	}
	                },
	                { targets: [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,32, 33, 34, 35, 36, 37, 38], visible: false, searchable: false },
			    ],
			    select: { 
			    	style: 'multi' 
			    },
			    order: [[1, 'asc']],
			    dom : 'lBfrtip',
			    buttons: [
			        {
			            extend: 'excel',
			            text: '<button>EXCEL DOWNLOAD<button>',
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
			
			$('button.btnPeriod').on('click', function() {
                $('button.btnPeriod').removeClass('on');
            	$('button#'+$(this).attr('id')).addClass('on');
	            $('#startDate').datepicker('setDate', $(this).attr('id'));
	            $('#endDate').datepicker('setDate', 'today');
	            $('#periodOn').val($(this).attr('id'));
			});
			
			$('#btnSearch').on('click', function() {
				that$.dataTables.ajax.reload();
			});
			
			$('#major1DepthCd').on('change', function(e) {
				that$.fn.setSelDynamicMajorCd( $(this).val() );
			});
			
			that$.dataTables.on('focus', 'select[name=jcAgreeStsCd]', function() {
			    $(this).data('lastValue',$(this).val());
			});
			
			that$.dataTables.on('change', 'select[name=jcAgreeStsCd]', function(e) {
				var jcAgreeStsCd$ = $(this);
			    var lastRole = jcAgreeStsCd$.data('lastValue');
			    var newRole = jcAgreeStsCd$.val();
			    
				alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (ex) { 
					if (ex) {
						jcAgreeStsCd$.data('lastValue',newRole);
						var params = {
								traditional:true,
								data: {
									eduTrnngSeqList: [jcAgreeStsCd$.attr('id')],
									jcAgreeStsCd : newRole
								}
							};
						$.when( that$.fn.updateAction( params ) ).done(function( result ) {
							alertify.alert( t( 'cpes.reg.success.msg' ), function (e) { if (e) {
								that$.dataTables.ajax.reload();
							} });
						}).fail(function ( result ) {
							alertify.alert(result, function (e) { if (e) {} });
						});								
					} else {
						jcAgreeStsCd$.val(lastRole);
					}
				});
			});
/*
			$('#btnVerify, #btnReject, #btnFinish, #btnRecruiting').on('click', function(e) {
				var rows = that$.fn.getDataTableRowSelected( that$.dataTables );

				if ( !rows.length ) {
					alertify.alert( t( 'errors.minimum.one' ), function (e) {
						return;
					});					

				} else {
					var params = {
							traditional:true,
							data: {
								eduTrnngSeqList: rows
							}
						};
						
					if ( $(this).attr('id') == 'btnVerify' ) {
						params.data['jcAgreeStsCd'] = 'JAS0000000001';
						params.data['cofirmMsg'] = '승인';
					} else if ( $(this).attr('id') == 'btnReject' ) {
						params.data['jcAgreeStsCd'] = 'JAS0000000003';
						params.data['cofirmMsg'] = '반려';
					} else if ( $(this).attr('id') == 'btnFinish' ) {
						params.data['recrumtStsCd'] = 'RSC0000000002';
						params.data['cofirmMsg'] = '마감';
					} else if ( $(this).attr('id') == 'btnRecruiting' ) {
						params.data['recrumtStsCd'] = 'RSC0000000001';
						params.data['cofirmMsg'] = '모집 중으로';
					}

					alertify.confirm("선택한 교육 프로그램을 " + params.data['cofirmMsg'] + " 하시겠습니까?", function (ex) {
						if (ex) {
							$('#btnVerify').attr('disabled', true);
							$('#btnReject').attr('disabled', true);
							$('#btnFinish').attr('disabled', true);
							$('#btnRecruiting').attr('disabled', true);
							
							$.when( that$.fn.updateAction( params ) ).done(function( result ) {
								alertify.alert("저장 성공", function (e) {
									if(e) {
										$('#btnVerify').attr('disabled', false);
										$('#btnReject').attr('disabled', false);
										$('#btnFinish').attr('disabled', false);
										$('#btnRecruiting').attr('disabled', false);
										that$.dataTables.ajax.reload();
									}
								});
							}).fail(function ( result ) {
								alertify.alert(result, function (e) {
									if(e) {
										$('#btnVerify').attr('disabled', false);
										$('#btnReject').attr('disabled', false);
										$('#btnFinish').attr('disabled', false);
										$('#btnRecruiting').attr('disabled', false);
									}
								});
							});							
						}
					});
				}
			});
*/			
		},
		
		fn: {
			getCommCd : function(params) {
			    var deferred = $.Deferred();
			    var options = {
			    	method: 'post',
			    	url: contextPath + '/common/selectCommCodeListAjax.do',
			    	traditional: true,
			    	data: params.data,
			    	dataType: 'json',
			    };
			    
			    $.ajax(options)
			    .done(function (res, status, responseObj) {
			        deferred.resolve(res.result);
			    }).fail(function (result, status, responseObj) {
			    	deferred.reject(status);
			    });

			    return deferred.promise();
			},
			getMajorCd : function(params) {
			    var deferred = $.Deferred();
			    var options = {
			    	method: 'post',
			    	url: contextPath + '/internal/trnng/selectMajorCodeListAjax.do',
			    	data: params.data,
			    	dataType: 'json',
			    };
			    
			    $.ajax(options)
			    .done(function (res, status, responseObj) {
			        deferred.resolve(res.result);
			    }).fail(function (result, status, responseObj) {
			    	deferred.reject( t( 'cpes.error.msg' ) );
			        //deferred.reject(status);
			    });

			    return deferred.promise();
			},			
			// response result array object group by
			groupBy : function(xs, key) {
				return xs.reduce(function(rv, x) {
					(rv[x[key]] = rv[x[key]] || []).push(x);
					return rv;
				}, {});
			},			
			
			// response result array object order by 
			// orderBy([{a:1,b:1}, {a:2,b:2}], 'a', (['DESC'|'ASC'|'desc'|'asc']))
			orderBy : function(arr, columnName, range) {
				range = typeof range !== 'undefined' ? range : 'DESC';
				return arr.sort(function(a, b) { // 오름차순
					if (range.toUpperCase() == 'DESC') {
						return a[columnName] < b[columnName] ? -1 : a[columnName] > b[columnName] ? 1 : 0;
					} else {
						return a[columnName] > b[columnName] ? -1 : a[columnName] < b[columnName] ? 1 : 0;
					}
				});
			},
			
			// response result orthography string value replase with toCamel Or Snake 
			// toCamelOrSnake(['STRING_VALUE'| 'string_value'], ['CAMEL'| 'camel']) | toCamelOrSnake('stringValue', ['SNAKE'| 'snake'])
			toCamelOrSnake : function(string, orthography) {
				orthography = typeof orthography !== 'undefined' ? orthography : 'CAMEL';
				if (orthography.toUpperCase() == "CAMEL") {
					return string.toLowerCase().replace(/(_\w)/g, function(m) {
						return m[1].toUpperCase();
					});
				} else {
					return string.replace(/[\w]([A-Z])/g, function(m) {
						return m[0] + "_" + m[1];
					}).toUpperCase();
				}
			},
			// page link action for post submit
			pageAction : function(eduTrnngSeq) {
				$("#frmEduTrnngProgramMng").find("#eduTrnngSeq").val(eduTrnngSeq);
				var sessData = $("#frmEduTrnngProgramMng").serializeObject();
				sessionStorage.setItem(eduTrnngProgramMng.name, JSON.stringify(sessData));

				$("#frmEduTrnngProgramMng").attr("method", "post");
				$("#frmEduTrnngProgramMng").attr("action", contextPath + "/internal/trnng/eduTrnngProgramMngDtl.do");
				$("#frmEduTrnngProgramMng").submit();
			},
			// return code name string
			// common code lenguage choose
			commCdLang : function(obj) {
				return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
			},
			// dynamic create select element for major2code 
			setSelDynamicMajorCd: function( parentCd ) {
				$('#major2DepthCd').find('option:not(:first)').remove();				
				eduTrnngProgramMng.majorCode['major2DepthCd'].filter(function(x) {
					return parentCd != '' ? x.grpCd == parentCd : x.grpCd != parentCd
				}).forEach(function (item, i) {
				    $('#major2DepthCd').append($('<option>', { 
				        value: item.dtlCd,
				        text : eduTrnngProgramMng.fn.commCdLang(item) 
				    }));
				});				
			},
			// return array string
			// object datatable selected rows
			getDataTableRowSelected: function( dataTables ) {
	              return (dataTables.column(0).checkboxes.selected()).toArray();
			},
			// ajax update action aftre event 
			updateAction : function( params ) {
			    var deferred = $.Deferred();
				var options = {
				    method: 'post',
				    url: contextPath + '/internal/trnng/updateEduTrnngProgramMngArrayAjax.do',
				    data: params.data,
				    traditional: params.traditional,
				    dataType: 'json',
				};
				
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.eduTrnngSeq ) {
				        deferred.resolve(res.result);
					} else {
						deferred.reject( t( 'cpes.error.msg' ) );
				    	//deferred.reject("user auth cert fail");				
					}
				}).fail(function (result, status, responseObj) {
					deferred.reject( t( 'cpes.error.msg' ) );
					//deferred.reject("system error: " + status);
				});				
			    return deferred.promise();				
			},
		}
}
