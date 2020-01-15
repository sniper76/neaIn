var	boothResvMng = {
		name: 'boothResvMng',
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
						commGrpCdList: ['compnyInsttDivCd', 'resvStsCd'],
						commGrpUseYn: 'Y'
					}
				};

			$.when( that$.fn.getCommCd(commCdParams), that$.fn.getJcCd() ).done(function( commCd, jcCd ) {
				
				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
				that$.commCode['compnyInsttDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('compnyInsttDivCd', 'snake') ];
				that$.commCode['resvStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('resvStsCd', 'snake') ];				
				that$.commCode['jcCd'] = jcCd;
				
	            deferred.resolve();	
			});

            return deferred.promise();
		},
		bind: function() {
			var that$ = this;
			
			if ( $('#fairSeq').val() != null && $('#fairSeq').val() != '') {
				var setColumns = [
					{"data": "rowNum"},
					{"data": "compnyInsttNm"},
					{"data": "mngerNm"},
					{"data": "tel"},
					{"data": "email"},
					{"data": "boothReqDt"},
					{"data": "resvStsCd"},
					{"data": "boothNm"},

					{"data": "boothSeq"},
					{"data": "fairSeq"},
					{"data": "compnyInsttSeq"},
					{"data": "compnyInsttDivCd"},
					];
				
				var orderColumns = setColumns.map(function(x) { return x.data });
				
				that$.dataTables = $('#boothResvMngTable').DataTable({
					pageLength: 10,
		            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
				    processing: true,
				    serverSide: true,
				    searching: false,
				    destroy: true,
				    serverMethod: 'post',
				    ajax: {
				    	url: contextPath + '/internal/fair/selectBoothResvMngListAjax.do?orderColumns='+orderColumns
				    	//, traditional: true
				    	, data: function ( d ) {
				    		return $.extend( {}, d, {
				        		fairSeq: $('#fairSeq').val(),
				        		searchKeyword: $('#searchKeyword option:selected').val(),
				        		searchValue: $.trim($('#searchValue').val()),
				    		} );
				        }
				        , dataType: 'json'
				    },
				    columns: setColumns,
				    columnDefs: [
	                    { targets: 5, render: function ( data, type, full, meta ) {
	                    		if (data != null && data != '') {
			                		return moment(data).format("DD/MM/YYYY");     	
	                    		} else {
	                    			return '';
	                    		}	                    	
		        			}
		                },
	                    { targets: 6, render: function ( data, type, full, meta ) {
		                    	if (data != null && data != '') {
			                		var obj = that$.commCode['resvStsCd'].find(function(x) { return x.dtlCd == data });
			                		return that$.fn.commCdLang(obj) ;                    	
		                    	} else {
		                    		return '-';
		                    	}
		        			}
		                },
		                { targets: [8, 9, 10, 11], visible: false, searchable: false },
				    ],
				    /*
				    select: { 
				    	style: 'multi' 
				    },
				    */
				    order: [[1, 'desc']],
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
			
			$('#btnSearch').on('click', function() {
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
				that$.dataTables.on('click', 'input[name=btnDelete]', function() {
					alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (e) { 
						if (e) {
							var params = {
									traditional:false,
									data: {
										fairSeq: $('#fairSeq').val(),
										boothSeq: $(this).attr('id')
									}
								};
							$.when( that$.fn.deleteAction( params ) ).done(function( result ) {
								alertify.alert( t( 'cpes.delete.success.msg' ), function (e) { if (e) {
									that$.dataTables.ajax.reload();
								} });
							}).fail(function ( result ) {
								alertify.alert(result, function (e) { if (e) {} });
							});								
						} else {
							return false;
						}
					});
				});

				that$.dataTables.on('click', 'input[name=btnChange]', function() {
					var result = popChangeBoothLayerBtn();
					if (typeof result != 'undefined' && result != null && result != '') {
						var params = {
								traditional:false,
								data: {
									fairSeq: $('#fairSeq').val(),
									boothSeq: $(this).attr('id'),
									compnyInsttSeq: result.compnyInsttSeq,
									compnyInsttDivCd: result.compnyInsttDivCd
								}
							};
						$.when( that$.fn.changeAction( params ) ).done(function( result ) {
							alertify.alert( t( 'cpes.reg.success.msg' ) , function (e) { if (e) {
								that$.dataTables.ajax.reload();
							} });
						}).fail(function ( result ) {
							alertify.alert(result, function (e) { if (e) {} });
						});						
					}
				});

				that$.dataTables.on('focus', 'select[name=resvStsCd]', function() {
				    $(this).data('lastValue',$(this).val());
				});

				//DataTables Render Button Click event
				that$.dataTables.on('change', 'select[name=resvStsCd]', function(e) {
					var resvStsCd$ = $(this);
				    var lastRole = resvStsCd$.data('lastValue');
				    var newRole = resvStsCd$.val();
				    
					alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (e) { 
						if (e) {
							resvStsCd$.data('lastValue',newRole);
							var params = {
									traditional:false,
									data: {
										fairSeq: $('#fairSeq').val(),
										boothSeq: resvStsCd$.attr('id'),
										resvStsCd : resvStsCd$.val()
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
							resvStsCd$.val(lastRole);
						}
					});
				});			
			}			
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
			// response result array object group by
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
			deleteAction : function( params ) {
			    var deferred = $.Deferred();
				var options = {
				    method: 'post',
				    url: contextPath + '/internal/fair/deleteBoothReqMngAjax.do',
				    data: params.data,
				    traditional: params.traditional,
				    dataType: 'json',
				};
				
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.boothSeq ) {
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
			changeAction : function( params ) {
			    var deferred = $.Deferred();
				var options = {
				    method: 'post',
				    url: contextPath + '/internal/fair/changeBoothReqMngAjax.do',
				    data: params.data,
				    traditional: params.traditional,
				    dataType: 'json',
				};
				
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.boothSeq ) {
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
			updateAction : function( params ) {
			    var deferred = $.Deferred();
				var options = {
				    method: 'post',
				    url: contextPath + '/internal/fair/updateBoothReqMngAjax.do',
				    data: params.data,
				    traditional: params.traditional,
				    dataType: 'json',
				};
				
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.boothSeq ) {
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
			pageAction : function(fairSeq) {

			},
			commCdLang : function(obj) {
				return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
			},
		}
}
