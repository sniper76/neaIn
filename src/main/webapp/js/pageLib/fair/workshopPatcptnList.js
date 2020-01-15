var	workshopPatcptnList = {
		name: 'workshopPatcptnList',
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
						commGrpCdList: ['jcAgreeStsCd'],
						commGrpUseYn: 'Y'
					}
				};
			var majorCdParams = {
					data: {
						grpCd: '',
						commGrpUseYn: 'Y'
					}
				};
			$.when( that$.fn.getCommCd(commCdParams)).done(function( commCd, majorCd ) {
				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
				that$.commCode['jcAgreeStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('jcAgreeStsCd', 'snake') ];

	            var sessData = JSON.parse(sessionStorage.getItem(that$.name));

				deferred.resolve();
			});

            return deferred.promise();
		},
		bind: function() {
			var that$ = this;
			var setColumns = [
				{"data": "rowNum"},
				{"data": "userAuthNm"},
				{"data": "userNm"},
				{"data": "jcUserNm"},
				{"data": "userEmail"},
				{"data": "userCell"},
				{"data": "userAge"},
				{"data": "userGenderNm"},
				{"data": "regDt"},
				{"data": "jcAgreeStsCd"},
				];

			var orderColumns = setColumns.map(function(x) { return x.data });

			that$.dataTables = $('#workshopListTable').DataTable({
				pageLength: 10,
	            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
			    processing: true,
			    serverSide: true,
			    searching: false,
			    destroy: true,
			    serverMethod: 'post',
			    ajax: {
			    	url: contextPath + '/internal/workshop/selectWorkshopPatcptnListAjax.do?orderColumns='+orderColumns
			    	//, traditional: true
			    	, data: function ( d ) {
			    		return $.extend( {}, d, {
			    			fairSeq: $('#fairSeq').val(),
			    			fairWorkshopSeq: $('#fairWorkshopSeq').val()
			    		} );
			        }
			        , dataType: 'json'
			    },
			    columns: setColumns,
			    columnDefs: [
			    	/*{
			    		targets: 1, render: function ( data, type, full, meta ) {
	        				return "<a href=\"javascript:void(0);\" onclick=\"goWorkshopUpdateForm('" + full.fairWorkshopSeq + "');\">" + full.workshopNm;
                    	}
	                },*/
	                {
	                	targets: 9, render: function ( data, type, full, meta ) {
	                		var seljcAgreeStsCdStr  = "<select name='jcAgreeStsCd' id='" + full.fairWorkshopPatcptnSeq + "'>";
		    				$.each(that$.commCode['jcAgreeStsCd'], function (i, item) {
		    					seljcAgreeStsCdStr += "<option value='" + item.dtlCd + "'" + ( item.dtlCd == data ? 'selected=seleected' : '' ) + ">" + that$.fn.commCdLang(item) + "</option>";
				    		});
	    					seljcAgreeStsCdStr += "</select>";

	    					return seljcAgreeStsCdStr;
                    	}
	                },
			    ],
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

			/*if ( that$.dataTables != null ) {
				that$.dataTables.on('focus', 'select[name=jcAgreeStsCd]', function() {
				    $(this).data('lastValue',$(this).val());
				});
			}*/
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
										fairWorkshopPatcptnSeq: jcAgreeStsCd$.attr('id'),
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
			    	deferred.reject( t( 'cpes.error.msg' ) );
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
			commCdLang : function(obj) {
				return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
			},
			updateAction : function( params ) {
			    var deferred = $.Deferred();
				var options = {
				    method: 'post',
				    url: contextPath + '/internal/workshop/updateWorkshopPatcptnJcAgreeCdAjax.do',
				    data: params.data,
				    traditional: params.traditional,
				    dataType: 'json',
				};

				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result > 0 ) {
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

