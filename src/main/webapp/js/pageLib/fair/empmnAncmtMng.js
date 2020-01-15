var	empmnAncmtMng = {
		name: 'empmnAncmtMng',
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
						commGrpCdList: ['employFormCd', 'vacancyStsCd', 'jcAgreeStsCd', 'preferntCondCd'],
						commGrpUseYn: 'Y'
					}
				};

			$.when( that$.fn.getCommCd(commCdParams), that$.fn.getJcCd(), that$.fn.getAddrCd2Depth() ).done(function( commCd, jcCd, addrCd2Depth ) {
				
				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
				that$.commCode['employFormCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('employFormCd', 'snake') ];
				that$.commCode['vacancyStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('vacancyStsCd', 'snake') ];
				that$.commCode['jcAgreeStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('jcAgreeStsCd', 'snake') ];
				that$.commCode['preferntCondCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('preferntCondCd', 'snake') ];
				
				that$.commCode['jcCd'] = jcCd;
				that$.commCode['addrCd2Depth'] = addrCd2Depth;
				
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
					{"data": "rowNum"},							//넘버
					{"data": "vacancyCertNo"},					//공고번호
					{"data": "employFormCd"},					//공고TYPE
					{"data": "compnyNm"},						//기업명
					{"data": "vacancyTitle"},					//채용공고제목							
					{"data": "period"},							//기간
					{"data": "regDt"},							//신청일시
					{"data": "vacancyStsCd"},					//모집상태
					{"data": "jcAgreeDt"},						//승인일시
					{"data": "jcAgreeStsCd"},					//승인여부
					{"data": "recrumtMemb"},					//모집인원
					{"data": "jcCd"},							//관할JC
					
					{"data": "fairSeq"},						//채용행사시퀀스
					{"data": "vacancySeq"},						//구인시퀀스
					{"data": "bgnDt"},							//기간-시작일
					{"data": "endDt"},							//기간-종료일
					];
				
				var orderColumns = setColumns.map(function(x) { return x.data });
				
				that$.dataTables = $('#empmnAncmtMngTable').DataTable({
					pageLength: 10,
		            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
				    processing: true,
				    serverSide: true,
				    searching: false,
				    destroy: true,
				    serverMethod: 'post',
				    ajax: {
				    	url: contextPath + '/internal/fair/selectEmpmnAncmtMngListAjax.do?orderColumns='+orderColumns
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
				        		addrCd2Depth: $.trim($('#addrCd2Depth option:selected').val()),
				        		searchKeyword: $('#searchKeyword option:selected').val(),
				        		searchValue: $.trim($('#searchValue').val()),
				        		employFormCd: $.trim($('#employFormCd option:selected').val()),
				        		vacancyStsCd: $('input[name=vacancyStsCd]:checked').val(),
				        		jcAgreeStsCd: $('input[name=jcAgreeStsCd]:checked').val(),
				        		recrumtDiffcltYn: $('input[name=recrumtDiffcltYn]:checked').val(),
				        		preferntCondCd: preferntCondCdList.join(),
				        		startDate: $('#startDate').val(),
				        		endDate: $('#endDate').val(),
				        	} );
				        }
				        , dataType: 'json'
				    },
				    columns: setColumns,
				    columnDefs: [
				    	{ targets: 0, orderable: false },
	                    { targets: 2, render: function ( data, type, full, meta ) {
	                    		if (data != null && data != '') {
		                    		var obj = that$.commCode['employFormCd'].find(function(x) { return x.dtlCd == data });
			                		return that$.fn.commCdLang(obj) ;                    	
	                    		} else {
	                    			return '';
	                    		}
		        			}
		                },
	                    { targets: 4, render: function ( data, type, full, meta ) {
		        				return "<a href=\"javascript:void(0);\" onclick=\"empmnAncmtMng.fn.popupAction('" + full.vacancySeq + "');\">" + data + "</font>" ;
	                    	}
		                },
	                    { targets: 5, orderable: false, render: function ( data, type, full, meta ) {
	                    		var bgnDt = (full.bgnDt != null && full.bgnDt != '') ? moment(full.bgnDt).format("DD/MM/YYYY") : '';
	                    		var endDt = (full.endDt != null && full.endDt != '') ? moment(full.endDt).format("DD/MM/YYYY") : '';
	                    		return bgnDt + '~<br/>' + endDt;
	                    	}
		                },			    	
	                    { targets: 6, render: function ( data, type, full, meta ) {
	                    		if (data != null && data != '') {
	                    			return moment(data).format('DD/MM/YYYY hh:mm A');
	                    		} else {
	                    			return '';
	                    		}
		        			}
		                },
	                    { targets: 7, render: function ( data, type, full, meta ) {
	                			if (data != null && data != '') {
	    	                		var obj = that$.commCode['vacancyStsCd'].find(function(x) { return x.dtlCd == data });
	    	                		return that$.fn.commCdLang(obj) ;                    	
		                		} else {
		                			return '';
		                		}
		        			}
		                },			    	
	                    { targets: 8, render: function ( data, type, full, meta ) {
		                		if (data != null && data != '') {
		                			return moment(data).format('DD/MM/YYYY hh:mm A');
		                		} else {
		                			return '';
		                		}
		        			}
		                },
		                { targets: 9, render: function ( data, type, full, meta ) {
		    					var seljcAgreeStsCdStr  = "<select name='jcAgreeStsCd' id='" + full.vacancySeq + "'>";
			    				$.each(that$.commCode['jcAgreeStsCd'], function (i, item) {
			    					seljcAgreeStsCdStr += "<option value='" + item.dtlCd + "' " + ( item.dtlCd == data ? 'selected=seleected' : '' ) + ">" + that$.fn.commCdLang(item) + "</option>";
					    		});
		    					seljcAgreeStsCdStr += "</select>";
		    						
		    					return seljcAgreeStsCdStr;
			                }
		                },
		                { targets: 11, render: function ( data, type, full, meta ) {
		                		if (data != null && data != '') {
		                    		var obj = that$.commCode['jcCd'].find(function(x) { return x.jcCd == data });
			                		return lang == 'kh' ?  obj.jcKh : obj.jcEn ;                    	
		                		} else {
		                			return '';
		                		}
			                }
		                },
	                    { targets: [12, 13, 14, 15], visible: false, searchable: false },
	                    //{ targets: [5], orderable: false },
				    ],
				    /*
				    select: { 
				    	style: 'multi' 
				    },
				    */
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
						alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ), function (e) {
							if(e) {
								return false;
							}
						});
					}
				}
			});
			
			if ( that$.dataTables != null ) {
				that$.dataTables.on('focus', 'select[name=jcAgreeStsCd]', function() {
				    $(this).data('lastValue',$(this).val());
				});
			}

			if ( that$.dataTables != null ) {
				that$.dataTables.on('change', 'select[name=jcAgreeStsCd]', function(e) {
					var jcAgreeStsCd$ = $(this);
				    var lastRole = jcAgreeStsCd$.data('lastValue');
				    var newRole = jcAgreeStsCd$.val();
				    
					alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (e) { 
						if (e) {
							jcAgreeStsCd$.data('lastValue',newRole);
							var params = {
									data: {
										fairSeq: $('#fairSeq').val(),
										vacancySeq: jcAgreeStsCd$.attr('id'),
										jcAgreeStsCd : jcAgreeStsCd$.val()
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
			}

			$('#btnRegist').off().on('click', function(e) {
				if ($('#fairSeq').val() != null && $('#fairSeq').val() != '') {
					popEmpmnAncmtListLayerBtn();
				} else {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ), function (e) {
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
			    	deferred.reject( t( 'cpes.error.msg' ) );
			    	//deferred.reject(status);
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
			    	deferred.reject( t( 'cpes.error.msg' ) );
			    	//deferred.reject(status);
			    });

			    return deferred.promise();
			},			
			getAddrCd2Depth : function() {
			    var deferred = $.Deferred();
			    var options = {
			    	method: 'post',
			    	url: contextPath + '/internal/fair/selectLOC2DepthListAjax.do',
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
			popupAction : function(vacancySeq) {
			},
			// ajax update action aftre event 
			updateAction : function( params ) {
			    var deferred = $.Deferred();
				var options = {
				    method: 'post',
				    url: contextPath + '/internal/fair/updateEmpmnAncmtMngAjax.do',
				    data: params.data,
				    dataType: 'json',
				};
				
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.vacancySeq ) {
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
			pageAction : function(vacancySeq) {
			},
			commCdLang : function(obj) {
				return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
			},
		}
}
