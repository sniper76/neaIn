var	privateUserJoinMng = {
		name: 'privateUserJoinMng',
		dataTables: null,
		commCode: {},
		init: function() {
			this.beforeBind();
	        this.bind();
	        this.afterBind();
		},
		
		beforeBind: function() {
//			var that$ = this;
//			var deferred = $.Deferred();
			
//			var commCdParams = {
//					data: {
//						commGrpCdList: ['userAuthCd', 'fairDivCd', 'fairStsCd', 'genderCd', 'jobskStsCd', 'jcAgreeStsCd'],
//						commGrpUseYn: 'Y'
//					}
//				};

//			$.when( that$.fn.getCommCd(commCdParams), that$.fn.getJcCd() ).done(function( commCd, jcCd ) {
				
//				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
//				that$.commCode['userAuthCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('userAuthCd', 'snake') ];
//				that$.commCode['fairDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('fairDivCd', 'snake') ];
//				that$.commCode['fairStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('fairStsCd', 'snake') ];
//				that$.commCode['genderCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('genderCd', 'snake') ];
//				that$.commCode['jobskStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('jobskStsCd', 'snake') ];
//				that$.commCode['jcAgreeStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('jcAgreeStsCd', 'snake') ];
//				that$.commCode['jcCd'] = jcCd;
				
//				var nea = ($.trim($('#mstJcCd').val()) == 'JCT0000000015' || $.trim($('#mstJcCd').val()) == 'JCT0000000099') ? true : false ;
//				$('#jcCd').attr('disabled', ( nea == true ? false : true ));				
//				$('#jcCd').val(( nea == true ? '' : $('#mstJcCd').val() ));				
//				
//	            deferred.resolve();	
//			});

//            return deferred.promise();
		},
		bind: function() {
			var that$ = this;
//			if ( $('#fairSeq').val() != null && $('#fairSeq').val() != '') {
				var setColumns = [
					{"data": "rowNum"},
					{"data": "userAuthNm"},
					{"data": "userNm"},
					{"data": "userEmail"},
					{"data": "userCell"},
					{"data": "age"},
					{"data": "genderNm"},
					{"data": "jobskStsNm"},
					{"data": "regDt"},
					{"data": "jcAgreeStsCd"},
					{"data": "mstJcNm"},
					{"data": "jcAgreeDt"},

					{"data": "userSeq"},
					{"data": "fairSeq"},
					];
				
				var orderColumns = setColumns.map(function(x) { return x.data });
				
				that$.dataTables = $('#privateUserJoinMngTable').DataTable({
					pageLength: 10,
		            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
				    processing: true,
				    serverSide: true,
				    searching: false,
				    destroy: true,
				    serverMethod: 'post',
				    ajax: {
				    	url: contextPath + '/internal/fair/selectPrivateUserJoinMngListAjax.do?orderColumns='+orderColumns
				    	//, traditional: true
				    	, data: function ( d ) {
				    		var preferntCondCdList = [];
				    		for (var i = 0; i < 3; i ++) {
				    			if ($('input[name=preferntCondCd_' + i + ']').is(':checked')) {
				    				preferntCondCdList.push($('input[name=preferntCondCd_' + i + ']').val());
				    			}
				    		}
				    		var ageList = $('input[name=ageList]:checked').map(function(x) {return $(this).val() }).toArray();

				    		return $.extend( {}, d, {
				        		fairSeq: $('#fairSeq').val(),
				    			mstJcCd: $('#mstJcCd option:selected').val(),
				        		searchKeyword: $('#searchKeyword option:selected').val(),
				        		searchValue: $.trim($('#searchValue').val()),
				        		userAuthCd: $('input[name=userAuthCd]:checked').val(),
				        		genderCd: $('#genderCd').val(),
				        		jcAgreeStsCd: $('#jcAgreeStsCd').val(),
				        		jobskStsCd: $('#jobskStsCd').val(),
				        		preferntCondCd: preferntCondCdList.join(),
				        		age: ageList.join(),
				    		} );
				        }
				        , dataType: 'json'
				    },
				    columns: setColumns,
				    columnDefs: [
//	                    { targets: 1, render: function ( data, type, full, meta ) {
//		                		var obj = that$.commCode['userAuthCd'].find(function(x) { return x.dtlCd == data });
//		                		return that$.fn.commCdLang(obj) ;                    	
//		        			}
//		                },
//	                    { targets: 6, render: function ( data, type, full, meta ) {
//		                		var obj = that$.commCode['genderCd'].find(function(x) { return x.dtlCd == data });
//		                		return that$.fn.commCdLang(obj) ;                    	
//		        			}
//		                },
//	                    { targets: 7, render: function ( data, type, full, meta ) {
//		                		var obj = that$.commCode['jobskStsCd'].find(function(x) { return x.dtlCd == data });
//		                		return that$.fn.commCdLang(obj) ;                    	
//		        			}
//		                },
	                    { targets: 8, render: function ( data, type, full, meta ) {
		                		return moment(data).format("DD/MM/YYYY");     	
		        			}
		                },
		                { targets: 9, render: function ( data, type, full, meta ) {
		    					var seljcAgreeStsCdStr  = "<select name='jcAgreeStsCd' id='" + full.userSeq + "'>";
			    					seljcAgreeStsCdStr += "<option value='JAS0000000001' " + ( 'JAS0000000001' == full.jcAgreeStsCd ? 'selected=seleected' : '' ) + ">Agree</option>";
			    					seljcAgreeStsCdStr += "<option value='JAS0000000002' " + ( 'JAS0000000002' == full.jcAgreeStsCd ? 'selected=seleected' : '' ) + ">Wait</option>";
			    					seljcAgreeStsCdStr += "<option value='JAS0000000003' " + ( 'JAS0000000003' == full.jcAgreeStsCd ? 'selected=seleected' : '' ) + ">Reject</option>";
		    					seljcAgreeStsCdStr += "</select>";
		    					
		    					return seljcAgreeStsCdStr;
		                	}
		                },
//	                    { targets: 10, render: function ( data, type, full, meta ) {
//	                    		if (data != null && data != '') {
//	                        		var obj = that$.commCode['jcCd'].find(function(x) { return x.jcCd == data });
//	    	                		return lang == 'kh' ?  obj.jcKh : obj.jcEn ;                    	
//	                    		} else {
//	                    			return '';
//	                    		}
//		        			}
//		                },		                
//	                    { targets: 11, render: function ( data, type, full, meta ) {
//		                		return moment(data).format("DD/MM/YYYY");     	
//		        			}
//		                },
		                { targets: [12, 13], visible: false, searchable: false }
				    ],
				    /*
				    select: { 
				    	style: 'multi' 
				    },
				    */
				    order: [[2, 'desc']],
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
//			}
		},
		
		afterBind: function() {
			var that$ = this;
			
			$('#btnFairChoose').on('click', function(e) {
				popFairLayerBtn();
			});
			
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
			
			if ( $("#privateUserJoinMngTable").dataTables == null ) {
//				return false;
			}
			
//			$('button.btnPeriod').on('click', function() {
//                $('button.btnPeriod').removeClass('on');
//            	$('button#'+$(this).attr('id')).addClass('on');
//	            $('#startDate').datepicker('setDate', $(this).attr('id'));
//	            $('#endDate').datepicker('setDate', 'today');
//	            $('#periodOn').val($(this).attr('id'));
//			});
			
			
//			if ( $("#privateUserJoinMngTable").dataTables != null ) {
//				$("#privateUserJoinMngTable").on('focus', 'select[name=jcAgreeStsCd]', function() {
//				    $(this).data('lastValue',$(this).val());
//				});
//			}
			
//			if ( $("#privateUserJoinMngTable").dataTables != null ) {
				//DataTables Render Button Click event
			
				$("#privateUserJoinMngTable").on('change', 'select[name=jcAgreeStsCd]', function(e) {
					
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
										userSeq: jcAgreeStsCd$.attr('id'),
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
						}
					});
				});			
//			}
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
			// ajax update action aftre event 
			updateAction : function( params ) {
			    var deferred = $.Deferred();
				var options = {
				    method: 'post',
				    url: contextPath + '/internal/fair/updatePrivateUserJoinMngAjax.do',
				    data: params.data,
				    traditional: params.traditional,
				    dataType: 'json',
				};
				
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.userSeq ) {
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