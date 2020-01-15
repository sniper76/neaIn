var	applicListMng = {
		name: 'applicListMng',
		dataTables: null,
		commCode: {},
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
						commGrpCdList: ['userAuthCd', 'genderCd', 'employFormCd', 'preferntCondCd', 'applicProcCd'],
						commGrpUseYn: 'Y'
					}
				};

			$.when( that$.fn.getCommCd(commCdParams), that$.fn.getJcCd() ).done(function( commCd, jcCd ) {				
				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
				that$.commCode['userAuthCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('userAuthCd', 'snake') ];
				that$.commCode['genderCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('genderCd', 'snake') ];
				that$.commCode['employFormCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('employFormCd', 'snake') ];
				that$.commCode['preferntCondCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('preferntCondCd', 'snake') ];
				that$.commCode['applicProcCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('applicProcCd', 'snake') ];
				
				that$.commCode['jcCd'] = jcCd;
				
				var nea = ($.trim($('#mstJcCd').val()) == 'JCT0000000015' || $.trim($('#mstJcCd').val()) == 'JCT0000000099') ? true : false ;
				$('#jcCd').attr('disabled', ( nea == true ? false : true ));				
				$('#jcCd').val(( nea == true ? '' : $('#mstJcCd').val() ));				
				
				common.sys.getDatepicker();

				$(".datepicker").datepicker('option', {maxDate: '1Y'});
	            $('#startDate').datepicker('setDate', '-14D');
	            $('#endDate').datepicker('setDate', 'today');
	            $('button#-14D').addClass('on');
	            $("#periodOn").val("-14D");

	            deferred.resolve();	
			});

            return deferred.promise();
		},
		bind: function() {
			var that$ = this;
			if ( $('#fairSeq').val() != null && $('#fairSeq').val() != '') {
				var setColumns = [
					{"data": "applicSeq"},						//입사지원시퀀스
					{"data": "rowNum"},							//넘버
					{"data": "userAuthCd"},						//회원구분
					{"data": "userNm"},							//회원명
					{"data": "resumeTitle"},					//이력서명
					{"data": "userEmail"},						//이메일
					{"data": "age"},							//연령							
					{"data": "employFormCd"},					//채용공고구분
					{"data": "vacancyTitle"},					//채용공고명
					{"data": "compnyNm"},						//기업명
					{"data": "mngerCell"},						//담당전화
					{"data": "mngerEmail"},						//담당이메일
					{"data": "regDt"},							//입사지원일시
					{"data": "resumeOpenDt"},					//열람일시
					{"data": "referralYn"},						//알선여부
					{"data": "applicProcCd"},					//심사상태
					
					{"data": "fairSeq"},						//채용행사시퀀스
					{"data": "vacancySeq"},						//구인시퀀스
					{"data": "resumeSeq"},						//이력서시퀀스
					
					];
				
				var orderColumns = setColumns.map(function(x) { return x.data });
				
				that$.dataTables = $('#applicListMngTable').DataTable({
					pageLength: 10,
		            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
				    processing: true,
				    serverSide: true,
				    searching: false,
				    destroy: true,
				    serverMethod: 'post',
				    ajax: {
				    	url: contextPath + '/internal/fair/selectApplicMngListAjax.do?orderColumns='+orderColumns
				    	, data: function ( d ) {
				    		var preferntCondCdList = [];
				    		for (var i = 0; i < 3; i ++) {
				    			if ($('input[name=preferntCondCd_' + i + ']').is(':checked')) {
				    				preferntCondCdList.push($('input[name=preferntCondCd_' + i + ']').val());
				    			}
				    		}
				        	return $.extend( {}, d, {
				        		fairSeq: $('#fairSeq').val(),
				        		jcCd: $('#jcCd option:selected').val(),
				        		searchKeyword: $('#searchKeyword option:selected').val(),
				        		searchValue: $.trim($('#searchValue').val()),
				        		userAuthCd: $('input[name=userAuthCd]:checked').val(),
				        		genderCd: $('input[name=genderCd]:checked').val(),
				        		employFormCd: $.trim($('#employFormCd option:selected').val()),
				        		preferntCondCd: preferntCondCdList.join(),
				        		resumeOpenYn: $('input[name=resumeOpenYn]:checked').val(),
				        		applicProcCd: $.trim($('#applicProcCd option:selected').val()),
				        		referralYn: $('input[name=referralYn]:checked').val(),
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
	                    { targets: 2, render: function ( data, type, full, meta ) {
                    			var obj = that$.commCode['userAuthCd'].find(function(x) { return x.dtlCd == data });
                    			return that$.fn.commCdLang(obj) ;                    	
	                    	}
		                },
	                    { targets: 4, render: function ( data, type, full, meta ) {
		        				return "<a href=\"javascript:void(0);\" onclick=\"applicListMng.fn.popupRsmAction('" + full.resumeSeq + "');\">" + data + "</font>" ;
	                    	}
		                },
	                    { targets: 7, render: function ( data, type, full, meta ) {
	                			if (data != null && data != '') {
	    	                		var obj = that$.commCode['employFormCd'].find(function(x) { return x.dtlCd == data });
	    	                		return that$.fn.commCdLang(obj) ;                    	
		                		} else {
		                			return '';
		                		}
		        			}
		                },			    	
	                    { targets: 8, render: function ( data, type, full, meta ) {
		        				return "<a href=\"javascript:void(0);\" onclick=\"applicListMng.fn.popupVccyAction('" + full.vacancySeq + "');\">" + data + "</font>" ;
	                    	}
		                },
		                { targets: 12, render: function ( data, type, full, meta ) {
	                    		if (data != null && data != '') {
	                    			return moment(data).format('DD/MM/YYYY hh:mm A');
	                    		} else {
	                    			return '';
	                    		}
		        			}
		                },
		                { targets: 13, render: function ( data, type, full, meta ) {
		                		if (data != null && data != '') {
		                			return moment(data).format('DD/MM/YYYY hh:mm A');
		                		} else {
		                			return '';
		                		}
		        			}
		                },
		                { targets: 14, render: function ( data, type, full, meta ) {
		                		if (data != null && data == 'Y') {
		                			return 'Y';
		                		} else {
		                			return 'N';
		                		}
		        			}
		                },
		                { targets: 15, render: function ( data, type, full, meta ) {
	                			if (data != null && data != '') {
	    	                		var obj = that$.commCode['applicProcCd'].find(function(x) { return x.dtlCd == data });
	    	                		return that$.fn.commCdLang(obj) ;                    	
		                		} else {
		                			return '';
		                		}
		        			}
		                },			    	
		                { targets: [16, 17, 18], visible: false, searchable: false },
				    ],
				    select: { 
				    	style: 'multi' 
				    },
				    order: [[6, 'desc']],
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
			}
		},
		
		afterBind: function() {
			var that$ = this;
			
			$('button.btnPeriod').off().on('click', function() {
                $('button.btnPeriod').removeClass('on');
            	$('button#'+$(this).attr('id')).addClass('on');
	            $('#startDate').datepicker('setDate', $(this).attr('id'));
	            $('#endDate').datepicker('setDate', 'today');
	            $('#periodOn').val($(this).attr('id'));
			});

			$('#btnFairChoose').off().on('click', function(e) {
				popFairLayerBtn();
			});
			
			$('#btnSearch').off().on('click', function() {
				if ( that$.dataTables != null ) {
					that$.dataTables.ajax.reload();
				} else {
					if ($('#fairSeq').val() != null && $('#fairSeq').val() != '') {
						that$.bind();
						that$.afterBind();
					} else {
						alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ) , function (e) {
							if(e) {
								return false;
							}
						});
					}
				}
			});

			$('#btnOpenMsgSend').off().on('click', function(e) {
				
				if ($('#fairSeq').val() != null && $('#fairSeq').val() != '') {
					var rows = that$.fn.getDataTableRowSelected( that$.dataTables );
					if ( !rows.length ) {
						alertify.alert( t( 'errors.minimum.one' ), function (e) {
							return;
						});					

					} else {
						var params = {
								traditional:true,
								data: {
									fairSeq: $('#fairSeq').val(),
									applicSeqList: rows
								}
							};
						
						alert('선택 열람확인 알림 발송');
						/*
						alertify.confirm("do you want save?", function (ex) {
							if (ex) {
								$('#btnOpenMsgSend').attr('disabled', true);
								
								$.when( that$.fn.insertAction( params ) ).done(function( result ) {
									alertify.alert("저장 성공", function (e) {
										if(e) {
											$('#btnOpenMsgSend').attr('disabled', false);
											that$.dataTables.ajax.reload();
										}
									});
								}).fail(function ( result ) {
									alertify.alert(result, function (e) {
										if(e) {
											$('#btnOpenMsgSend').attr('disabled', false);
										}
									});
								});							
							}
						});
						*/						
					}					
				} else {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ) , function (e) {
						if(e) {
							return false;
						}
					});
				}
			});
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
			getJcCd : function() {
			    var deferred = $.Deferred();
			    var options = {
			    	method: 'post',
			    	url: contextPath + '/internal/fair/selectJcCdListAjax.do',
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
			groupBy : function(xs, key) {
				return xs.reduce(function(rv, x) {
					(rv[x[key]] = rv[x[key]] || []).push(x);
					return rv;
				}, {});
			},			
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
			getDataTableRowSelected: function( dataTables ) {
	              return (dataTables.column(0).checkboxes.selected()).toArray();
			},
			popupRsmAction : function(resumeSeq) {
				alert(resumeSeq + ' 이력서 상세 팝업');
			},
			popupVccyAction : function(vacancySeq) {
				alert(vacancySeq + ' 채용공고 상세 팝업');
			},
			insertAction : function( params ) {
			    var deferred = $.Deferred();
				var options = {
				    method: 'post',
				    url: contextPath + '',
				    data: params.data,
				    traditional: params.traditional,
				    dataType: 'json',
				};
				
				$.ajax(options)
				.done(function (res, status, responseObj) {
			        deferred.resolve(res.result);
				}).fail(function (result, status, responseObj) {
			    	deferred.reject("system error: " + status);
				});				
			    return deferred.promise();
			},
			pageAction : function(vacancySeq) {
			},
			commCdLang : function(obj) {
				return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
			},
		}
}
