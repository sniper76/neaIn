var	communityMng = {
		name: 'communityMng',
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

				common.sys.getDatepicker();

				$(".datepicker").datepicker('option', {maxDate: '1Y'});
	            $('#startDate').datepicker('setDate', '-14D');
	            $('#endDate').datepicker('setDate', 'today');
	            /*$('button#-14D').addClass('on');
	            $("#periodOn").val("-14D");

	            var sessData = JSON.parse(sessionStorage.getItem(that$.name));

	            if (sessData) {
	            	$('#neaJcDiv').val( sessData.neaJcDiv );
	            	that$.fn.initSelJcCd( sessData.neaJcDiv, sessData.jcCd );

	            	$('#searchKeyword').val(sessData.searchKeyword);
	        		$('#searchValue').val(sessData.searchValue);

	        		$('#fairDivCd').val(sessData.fairDivCd);
	        		if (sessData.fairStsCd != null && sessData.fairStsCd != '') {
	        			$('input[name=fairStsCd]:input[value=' + sessData.fairStsCd + ']').attr('checked', true);
	        		}


	                $("#addrCd1Depth").val(sessData.addrCd1Depth);

	                if (sessData.fairStsCd != null && sessData.fairStsCd != '') {
	                	$('input[name=fairViewYn]:input[value=' + sessData.fairViewYn + ']').attr('checked', true);
	        		}


	                $('#periodKeyword').val(sessData.periodKeyword);
	                $("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
	                if (sessData.periodOn != "") {
		                $("#periodOn").val(sessData.periodOn);
		            	$('button#'+sessData.periodOn).addClass('on');
	                }
	                sessionStorage.clear();
	            }*/

		},
		bind: function() {
			var that$ = this;

			var setColumns = [
				{"data": "banwordContent"},
				{"data": "filteringStsNm"},
				{"data": "viewYn"},
				{"data": "regNm"},
				{"data": "likeCnt"},
				{"data": "viewCnt"},
				{"data": "regDt"},
				];

			var orderColumns = setColumns.map(function(x) { return x.data });

			that$.dataTables = $('#communityMngTable').DataTable({
				pageLength: 10,
	            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
			    processing: true,
			    serverSide: true,
			    searching: false,
			    destroy: true,
			    serverMethod: 'post',
			    ajax: {
			    	url: contextPath + '/internal/community/selectBanworkIncludeListAjax.do?orderColumns='+orderColumns
			    	, data: function ( d ) {

			        	return $.extend( {}, d, {
			        		searchType: $('#searchType').val(),
			        		searchKeyword: $('#searchKeyword').val(),
			        		FilteringStsCd: $('#FilteringStsCd').val(),
			        		viewYn: $.trim($('#viewYn').val()),
			        		startDate: $('#startDate').val(),
			        		endDate: $('#endDate').val(),
			        	} );
			        }
			        , dataType: 'json'
			    },
			    columns: setColumns,
			    columnDefs: [
                    /*{ targets: 2, render: function ( data, type, full, meta ) {
                    		var fairNm = full.fairNm
	        				return "<a href=\"javascript:void(0);\" onclick=\"jobFairMng.fn.pageAction('" + full.fairSeq + "');\">" + fairNm + "</font>" ;
                    	}
	                },*/
			    ],
			   // order: [[10, 'desc']],
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
			getAddrCd1Depth : function() {
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
			initSelJcCd : function ( divCd, value ) {
				$('#jcCd').attr('disabled', ( divCd == 'jc' ? false : true )).val( value );
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
			pageAction : function(fairSeq) {
				$("#frmJobFairMng").find("#fairSeq").val(fairSeq);
				var sessData = $("#frmJobFairMng").serializeObject();
				sessionStorage.setItem(jobFairMng.name, JSON.stringify(sessData));

				var urlParam = fairSeq != '' ? 'jobFairMngDtl' : 'jobFairMngReg' ;

				$("#frmJobFairMng").attr("method", "post");
				$("#frmJobFairMng").attr("action", contextPath + "/internal/fair/" + urlParam + ".do");
				$("#frmJobFairMng").submit();
			},
			// return code name string
			// common code lenguage choose
			commCdLang : function(obj) {

				try {
					return lang == 'kh' ?  obj.cdKhNm : obj.cdKhNm ;
				} catch (e) {
					return "aa";
				}

			},
		}
}
