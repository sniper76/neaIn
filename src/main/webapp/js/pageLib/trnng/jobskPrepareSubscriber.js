var	jobskPrepareSubscriber = {
		name: 'jobskPrepareSubscriber',
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
						commGrpCdList: ['jcAgreeStsCd', 'userAuthCd', 'genderCd', 'jobskStsCd'],
						commGrpUseYn: 'Y'
					}
				};

			$.when( that$.fn.getCommCd(commCdParams) ).done(function( commCd ) {
				
				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
				that$.commCode['jcAgreeStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('jcAgreeStsCd', 'snake') ];
				that$.commCode['userAuthCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('userAuthCd', 'snake') ];
				that$.commCode['genderCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('genderCd', 'snake') ];
				that$.commCode['jobskStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('jobskStsCd', 'snake') ];

	            deferred.resolve();	
			});

            return deferred.promise();
		},
		bind: function() {
			var that$ = this;

			var setColumns = [
				{"data": "rowNum"},							//넘버
				{"data": "userAuthCd"},						//사용자CD
				{"data": "userNm"},							//사용자명
				{"data": "userEmail"},						//사용자이메일
				{"data": "userCell"},						//사용자휴대전화
				{"data": "age"},							//나이
				{"data": "genderCd"},						//성별
				{"data": "jobskStsCd"},						//구직상태
				{"data": "regDt"},							//등록일시
				{"data": "jcAgreeStsCd"},					//승인상태

				{"data": "userSeq"},						//사용자시퀀스

			];
			
			var orderColumns = setColumns.map(function(x) { return x.data });
			
			that$.dataTables = $('#jobskPrepareSubscriberTable').DataTable({
				pageLength: 10,
	            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
			    processing: true,
			    serverSide: true,
			    searching: false,
			    destroy: true,
			    serverMethod: 'post',
			    ajax: {
			    	url: contextPath + '/internal/trnng/selectJobskPrepareSubscriberListAjax.do?orderColumns='+orderColumns
			    	, data: function ( d ) {
			        	return $.extend( {}, d, {
			        		eduTrnngSeq: $('#eduTrnngSeq').val()
			        	} );
			        }			    	
			        , dataType: 'json'
			    },
			    columns: setColumns,
			    columnDefs: [
			    	//{ targets: 0, checkboxes: { selectRow: true } },
			    	{ targets: 0, orderable: false },
			    	{ targets: 1, render: function ( data, type, full, meta ) {
	                		var obj = that$.commCode['userAuthCd'].find(function(x) { return x.dtlCd == data });
	                		return that$.fn.commCdLang(obj) ;
	                	}
                    },			    	
                    { targets: 6, render: function ( data, type, full, meta ) {
	                		var obj = that$.commCode['genderCd'].find(function(x) { return x.dtlCd == data });
	                		return that$.fn.commCdLang(obj) ;
	                	}
	                },			    	
	                { targets: 7, render: function ( data, type, full, meta ) {
	                		data = (!data) ? 'JSC0000000002' : data ;
	                		var obj = that$.commCode['jobskStsCd'].find(function(x) { return x.dtlCd == data });
	                		return that$.fn.commCdLang(obj) ;
	                	}
	                },
	                { targets: 9, render: function ( data, type, full, meta ) {
	    					var seljcAgreeStsCdStr  = "<select name='jcAgreeStsCd' id='" + full.userSeq + "'>";
		    				$.each(that$.commCode['jcAgreeStsCd'], function (i, item) {
		    					seljcAgreeStsCdStr += "<option value='" + item.dtlCd + "'" + ( item.dtlCd == data ? 'selected=seleected' : '' ) + ">" + that$.fn.commCdLang(item) + "</option>";
				    		});
	    					seljcAgreeStsCdStr += "</select>";
	    						
	    					return seljcAgreeStsCdStr;
	                	}
	                },
	                { targets: [10], visible: false, searchable: false },
	            ],
	            /*
			    select: { 
			    	style: 'multi' 
			    },
			    */
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
									subscriberUserSeqList: [jcAgreeStsCd$.attr('id')],
									eduTrnngSeq: $('#eduTrnngSeq').val(),
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
			$('#btnAgree, #btnReject').on('click', function(e) {
				var rows = that$.fn.getDataTableRowSelected( that$.dataTables );
				if ( !rows.length ) {
					alertify.alert("선택 없음", function (e) {
						return;
					});					

				} else {
					var params = {
							traditional:true,
							data: {
								subscriberUserSeqList: rows,
								eduTrnngSeq: $('#eduTrnngSeq').val()
							}
						};
						
					if ( $(this).attr('id') == 'btnAgree' ) {
						params.data['jcAgreeStsCd'] = 'JAS0000000001';
						params.data['cofirmMsg'] = '승인';
					} else if ( $(this).attr('id') == 'btnReject' ) {
						params.data['jcAgreeStsCd'] = 'JAS0000000003';
						params.data['cofirmMsg'] = '미승인';
					}

					alertify.confirm("선택한 회원을 " + params.data['cofirmMsg'] + "으로 변경 하시겠습니까?", function (ex) {
						if (ex) {
							$('#btnAgree').attr('disabled', true);
							$('#btnReject').attr('disabled', true);
							
							$.when( that$.fn.updateAction( params ) ).done(function( result ) {
								alertify.alert("저장 성공", function (e) {
									if(e) {
										$('#btnAgree').attr('disabled', false);
										$('#btnReject').attr('disabled', false);
										that$.dataTables.ajax.reload();
									}
								});
							}).fail(function ( result ) {
								alertify.alert(result, function (e) {
									if(e) {
										$('#btnAgree').attr('disabled', false);
										$('#btnReject').attr('disabled', false);
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
			pageAction : function() {

			},
			// return code name string
			// common code lenguage choose
			commCdLang : function(obj) {
				return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
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
				    url: contextPath + '/internal/trnng/updateJobskPrepareSubscriberArrayAjax.do',
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
