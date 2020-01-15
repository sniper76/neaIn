var	insttRequestMng = {
		name: 'insttRequestMng',
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
//			var that$ = this;
//			var deferred = $.Deferred();
//			
//			var commCdParams = {
//					data: {
//						commGrpCdList: ['fairDivCd', 'fairStsCd', 'insttOwnerCd', 'insttTypeCd', 'jcAgreeStsCd'],
//						commGrpUseYn: 'Y'
//					}
//				};
//
//			$.when( that$.fn.getCommCd(commCdParams), that$.fn.getJcCd() ).done(function( commCd, jcCd ) {
//				
//				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
//				that$.commCode['fairDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('fairDivCd', 'snake') ];
//				that$.commCode['fairStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('fairStsCd', 'snake') ];				
//				that$.commCode['insttOwnerCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttOwnerCd', 'snake') ];
//				that$.commCode['insttTypeCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttTypeCd', 'snake') ];
//				that$.commCode['jcAgreeStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('jcAgreeStsCd', 'snake') ];
//				that$.commCode['jcCd'] = jcCd;
//				
//	            deferred.resolve();	
//			});
//
//            return deferred.promise();
		},
		bind: function() {
			var that$ = this;
			
			if ( $('#fairSeq').val() != null && $('#fairSeq').val() != '') {
				var setColumns = [
					{"data": "rowNum"},
					{"data": "insttOwnerCd"},
					{"data": "insttTypeCd"},
					{"data": "insttNm"},
					{"data": "insttMngerNm"},
					{"data": "insttEmail"},
					{"data": "insttCell"},
					{"data": "jcAgreeStsCd"},
					{"data": "mstJcCd"},
					{"data": "jcAgreeDt"},

					{"data": "insttSeq"},
					{"data": "fairSeq"},
					{"data": "regUserSeq"},
					{"data": "jcAgreeUserSeq"},
					];
				
				var orderColumns = setColumns.map(function(x) { return x.data });
				
				that$.dataTables = $('#insttRequestMngTable').DataTable({
					pageLength: 10,
		            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
				    processing: true,
				    serverSide: true,
				    searching: false,
				    destroy: true,
				    serverMethod: 'post',
				    ajax: {
				    	url: contextPath + '/internal/fair/selectInsttRequestMngListAjax.do?orderColumns='+orderColumns
				    	//, traditional: true
				    	, data: function ( d ) {
				    		return $.extend( {}, d, {
				        		fairSeq: $('#fairSeq').val(),
				    			mstJcCd: $('#mstJcCd option:selected').val(),
				        		searchKeyword: $('#searchKeyword option:selected').val(),
				        		searchValue: $.trim($('#searchValue').val()),
				        		insttOwnerCd: $('input[name=insttOwnerCd]:checked').val(),
				        		insttTypeCd: $('#insttTypeCd option:selected').val(),
				        		sectorCd: $('#sectorCd option:selected').val(),
				        		jcAgreeStsCd: $('input[name=jcAgreeStsCd]:checked').val(),
				    		} );
				        }
				        , dataType: 'json'
				    },
				    columns: setColumns,
				    columnDefs: [
//	                    { targets: 1, render: function ( data, type, full, meta ) {
//		                    	if (data != null && data != '') {
//			                		var obj = that$.commCode['insttOwnerCd'].find(function(x) { return x.dtlCd == data });
//			                		return that$.fn.commCdLang(obj) ;                    	
//		                    	} else {
//		                    		return '';
//		                    	}
//		        			}
//		                },
//	                    { targets: 2, render: function ( data, type, full, meta ) {
//		                		var obj = that$.commCode['insttTypeCd'].find(function(x) { return x.dtlCd == data });
//		                		return that$.fn.commCdLang(obj) ;                    	
//		        			}
//		                },
				    	{ targets: 7, render: function ( data, type, full, meta ) {
		    					var seljcAgreeStsCdStr  = "<select name='jcAgreeStsCd' id='" + full.userSeq + "'>";
			    					seljcAgreeStsCdStr += "<option value='JAS0000000001' " + ( 'JAS0000000001' == full.jcAgreeStsCd ? 'selected=seleected' : '' ) + ">Agree</option>";
			    					seljcAgreeStsCdStr += "<option value='JAS0000000002' " + ( 'JAS0000000002' == full.jcAgreeStsCd ? 'selected=seleected' : '' ) + ">Wait</option>";
			    					seljcAgreeStsCdStr += "<option value='JAS0000000003' " + ( 'JAS0000000003' == full.jcAgreeStsCd ? 'selected=seleected' : '' ) + ">Reject</option>";
		    					seljcAgreeStsCdStr += "</select>";
		    					
		    					return seljcAgreeStsCdStr;
		                	}
		                },
//		                { targets: 7, render: function ( data, type, full, meta ) {
//	                    		if (data != null && data != '') {
//	    	    					var seljcAgreeStsCdStr  = "<select name='jcAgreeStsCd' id='" + full.insttSeq + "'>";
//	    		    				$.each(that$.commCode['jcAgreeStsCd'], function (i, item) {
//	    		    					seljcAgreeStsCdStr += "<option value='" + item.dtlCd + "'" + ( item.dtlCd == data ? 'selected=seleected' : '' ) + ">" + that$.fn.commCdLang(item) + "</option>";
//	    				    		});
//	    	    					seljcAgreeStsCdStr += "</select>";
//	    	    						
//	    	    					return seljcAgreeStsCdStr;
//	                    		} else {
//	                    			return '';
//	                    		}		                	
//		                    }
//		                },
//		                { targets: 8, render: function ( data, type, full, meta ) {
//	                    		if (data != null && data != '') {
//	                        		var obj = that$.commCode['jcCd'].find(function(x) { return x.jcCd == data });
//	    	                		return lang == 'kh' ?  obj.jcKh : obj.jcEn ;                    	
//	                    		} else {
//	                    			return '';
//	                    		}
//		                    }
//		                },
		                { targets: 9, render: function ( data, type, full, meta ) {
	                    		if (data != null && data != '') {
	                    			return moment(data).format("DD/MM/YYYY");                    	
	                    		} else {
	                    			return '';
	                    		}
		        			}
		                },
		                { targets: [10, 11, 12, 13], visible: false, searchable: false },
				    ],
				    /*
				    select: { 
				    	style: 'multi' 
				    },
				    */
				    order: [[3, 'desc']],
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
				that$.dataTables.on('focus', 'select[name=jcAgreeStsCd]', function() {
				    $(this).data('lastValue',$(this).val());
				});
			}
			
			if ( that$.dataTables != null ) {
				//DataTables Render Button Click event
				that$.dataTables.on('change', 'select[name=jcAgreeStsCd]', function(e) {
					var jcAgreeStsCd$ = $(this);
				    var lastRole = jcAgreeStsCd$.data('lastValue');
				    var newRole = jcAgreeStsCd$.val();
				    
					alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (e) { 
						if (e) {
							jcAgreeStsCd$.data('lastValue',newRole);
							var params = {
									traditional:false,
									data: {
										fairSeq: $('#fairSeq').val(),
										insttSeq: jcAgreeStsCd$.attr('id'),
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
			updateAction : function( params ) {
			    var deferred = $.Deferred();
				var options = {
				    method: 'post',
				    url: contextPath + '/internal/fair/updateInsttRequestMngAjax.do',
				    data: params.data,
				    traditional: params.traditional,
				    dataType: 'json',
				};
				
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.insttSeq ) {
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
			
			pageActionPartici : function(obj) {
				$("#frmInsttRequestMng").attr("method", "post");
				$("#frmInsttRequestMng").attr("action", contextPath + "/internal/fair/insttJoinMng.do");
				$("#frmInsttRequestMng").submit();				
			},
		
			pageActionRequest : function(obj) {
				$("#frmInsttRequestMng").attr("method", "post");
				$("#frmInsttRequestMng").attr("action", contextPath + "/internal/fair/insttRequestMng.do");
				$("#frmInsttRequestMng").submit();				
			},

			pageActionInvite : function(obj) {
				$("#frmInsttRequestMng").attr("method", "post");
				$("#frmInsttRequestMng").attr("action", contextPath + "/internal/fair/insttInviteMng.do");
				$("#frmInsttRequestMng").submit();				
			}
		}
}
