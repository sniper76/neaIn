var fairNoSelect = "<spring:message code='invitation.fair.noSelect'/>";
var	workshopList = {
		name: 'workshopList',
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

		},
		bind: function() {
			var that$ = this;
//			if ( $('#fairSeq').val() != null && $('#fairSeq').val() != '') {
				var setColumns = [
					{"data": "rowNum"},
					{"data": "workshopNm"},
					{"data": "teacherNm1"},
					{"data": "tuition"},
					{"data": "lectureRoom"},
					{"data": "workshopDt"},
					{"data": "recurmtMan"},
					{"data": "workshopStsNm"},
					{"data": "patcptnCnt"},
					{"data": "regDt"},
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
				    	url: contextPath + '/internal/workshop/selectWorkshopListAjax.do?orderColumns='+orderColumns
				    	//, traditional: true
				    	, data: function ( d ) {
				    		return $.extend( {}, d, {
				    			fairSeq: $('#fairSeq').val()
				    		} );
				        }
				        , dataType: 'json'
				    },
				    columns: setColumns,
				    columnDefs: [
				    	{
				    		targets: 1, render: function ( data, type, full, meta ) {
		        				return "<a href=\"javascript:void(0);\" onclick=\"goWorkshopUpdateForm('" + full.fairWorkshopSeq + "');\">" + full.workshopNm;
	                    	}
		                },
		                {
		                	targets: 7, render: function ( data, type, full, meta ) {
		                		var result = "";

		                		if(full.workshopStsCd == "WSC0000000002"){
		                			result = "<a href=\"javascript:void(0);\" onclick=\"goWorkshopPatcptnList('" + full.fairWorkshopSeq + "');\">" + full.workshopStsNm;
		                		}else{
		                			result = full.workshopStsNm;
		                		}

		                		return result;
	                    	}
		                },
		                /*{ targets: 11, render: function ( data, type, full, meta ) {
	                    		if (data != null && data != '') {
	                    			return moment(data).format("DD/MM/YYYY");
	                    		} else {
	                    			return '';
	                    		}
		        			}
		                },
		                { targets: [12, 13, 14, 15], visible: false, searchable: false },*/
				    ],
				    /*
				    select: {
				    	style: 'multi'
				    },
				    */
				    //order: [[0, 'desc']],
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

			/*if ( that$.dataTables != null ) {
				that$.dataTables.on('focus', 'select[name=jcAgreeStsCd]', function() {
				    $(this).data('lastValue',$(this).val());
				});
			}*/
			/*if ( that$.dataTables != null ) {
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
										compnySeq: jcAgreeStsCd$.attr('id'),
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
			}*/


			$('#btnFairChoose').on('click', function(e) {
				popFairLayerBtn();
			});

			$('#btn_insertForm').on('click', function(){

				if($('#fairSeq').val() != ""){
					$("#frm").attr("method", "post");
					$("#frm").attr("action", contextPath + "/internal/workshop/workshopReg.do");
					$("#frm").submit();
				}else{
					alertify.alert(fairNoSelect);
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
			}

		}
}

function goWorkshopUpdateForm(fairWorkshopSeq){
	$('#fairWorkshopSeq').val(fairWorkshopSeq);
	$("#frm").attr("method", "post");
	$("#frm").attr("action", contextPath + "/internal/workshop/workshopMod.do");
	$("#frm").submit();
}

function goWorkshopPatcptnList(fairWorkshopSeq){
	$('#fairWorkshopSeq').val(fairWorkshopSeq);
	$("#frm").attr("method", "post");
	$("#frm").attr("action", contextPath + "/internal/workshop/workshopPatcptnList.do");
	$("#frm").submit();
}

