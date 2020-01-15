var	jobFairMng = {
		name: 'jobFairMng',
		pageYn : 'N',
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
//			var deferred = $.Deferred();
//			
//			var commCdParams = {
//					data: {
//						commGrpCdList: ['fairDivCd', 'fairStsCd'],
//						commGrpUseYn: 'Y'
//					}
//				};
//
//			$.when( that$.fn.getCommCd(commCdParams), that$.fn.getJcCd(), that$.fn.getAddrCd1Depth() ).done(function( commCd, jcCd, addrCd1Depth ) {
//				
//				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
//				that$.commCode['fairDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('fairDivCd', 'snake') ];
//				that$.commCode['fairStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('fairStsCd', 'snake') ];
//				
//				that$.commCode['jcCd'] = jcCd;
//				that$.commCode['addrCd1Depth'] = addrCd1Depth;
//				
//				that$.fn.initSelJcCd( '', '' );
				
				common.sys.getDatepicker();

				$(".datepicker").datepicker('option', {maxDate: '1Y'});
	            $('#startDate').datepicker('setDate', '-14D');
	            $('#endDate').datepicker('setDate', 'today');
	            $('button#-14D').addClass('on');
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
	                jobFairMng.pageYn = 'Y';
	                sessionStorage.clear();
	            }		

//	            deferred.resolve();	
//			});
//
//            return deferred.promise();
		},
		bind: function() {
			var that$ = this;

			var setColumns = [
				{"data": "rowNum"},							//넘버
				{"data": "fairDivNm"},						//행사구분코드
				{"data": "fairNm"},							//행사명
				{"data": "addrFullNm"},						//지역full
				{"data": "mstJcNm"},						//등록잡센터코드							
				{"data": "jcNm"},							//주관잡센터코드
				{"data": "recurmtDt"},						//모집기간
				{"data": "fairDt"},							//행사기간
				{"data": "fairStsNm"},						//행사상태
				{"data": "fairViewYn"},						//전시여부
				{"data": "regDt"},							//등록일시
				{"data": "regUserNm"},						//등록자
				
				{"data": "fairSeq"},						//시퀀스
				{"data": "fairNmKh"},						//행사명KH
				{"data": "fairNmEn"},						//행사명EN
				{"data": "fairBgnDt"},						//행사시작일
				{"data": "fairBgnHour"},					//행사시작일
				{"data": "fairBgnMinute"},					//행사시작일
				{"data": "fairBgnAmpm"},					//행사시작일
				{"data": "fairEndDt"},						//행사마감일
				{"data": "fairEndHour"},					//행사마감일
				{"data": "fairEndMinute"},					//행사마감일
				{"data": "fairEndAmpm"},					//행사마감일
				{"data": "recurmtBgnDt"},					//모집시작일
				{"data": "recurmtBgnHour"},					//모집시작일
				{"data": "recurmtBgnMinute"},				//모집시작일
				{"data": "recurmtBgnAmpm"},					//모집시작일
				{"data": "recurmtEndDt"},					//모집종료일
				{"data": "recurmtEndHour"},					//모집종료일
				{"data": "recurmtEndMinute"},				//모집종료일
				{"data": "recurmtEndAmpm"},					//모집종료일
				];
			
			var orderColumns = setColumns.map(function(x) { return x.data });
			
			that$.dataTables = $('#jobFairMngTable').DataTable({
				stateSave : true,
				pageLength: 10,
	            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
			    processing: true,
			    serverSide: true,
			    searching: false,
			    destroy: true,
			    serverMethod: 'post',
			    stateSaveCallback: function(settings,data) {
		            localStorage.setItem( jobFairMng.name + settings.sInstance, JSON.stringify(data) );
		          },
		        stateLoadCallback: function(settings) {
		        	if (jobFairMng.pageYn == 'Y') {
		        		return JSON.parse( localStorage.getItem( jobFairMng.name + settings.sInstance ) );
		        	} else {
		        		localStorage.clear();
		        		return JSON.parse( localStorage.getItem( jobFairMng.name + settings.sInstance ) );
		        	}
		          },
			    ajax: {
			    	url: contextPath + '/internal/fair/selectJobFairMngListAjax.do?orderColumns='+orderColumns
			    	, data: function ( d ) {
			    		
			        	return $.extend( {}, d, {
			        		jcCd: $('#jcCd option:selected').val(),
			        		fairDivCd: $('#fairDivCd option:selected').val(),
			        		fairStsCd: $('input[name=fairStsCd]:checked').val(),
			        		addrCd1Depth: $.trim($('#addrCd1Depth option:selected').val()),
			        		fairViewYn: $('input[name=fairViewYn]:checked').val(),
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
			    	/*{ targets: 0, checkboxes: { selectRow: true } },*/
//                    { targets: 1, render: function ( data, type, full, meta ) {
//	                		var obj = that$.commCode['fairDivCd'].find(function(x) { return x.dtlCd == data });
//	                		return that$.fn.commCdLang(obj) ;                    	
//	        			}
//	                },
                    { targets: 2, render: function ( data, type, full, meta ) {
                    		var fairNm = full.fairNm
	        				return "<a href=\"javascript:void(0);\" onclick=\"jobFairMng.fn.pageAction('" + full.fairSeq + "');\">" + fairNm + "</font>" ;
                    	}
	                },
//                    { targets: 3, render: function ( data, type, full, meta ) {
//                    		var addrCd1Depth = $.trim((full.addrFullCd).split(',')[0]);
//	                		var obj = that$.commCode['addrCd1Depth'].find(function(x) { return x.dtlCd == addrCd1Depth });
//	                		return that$.fn.commCdLang(obj) ;                    	
//	        			}
//	                },
//                    { targets: 4, render: function ( data, type, full, meta ) {
//                    		if (data != null && data != '') {
//                        		var obj = that$.commCode['jcCd'].find(function(x) { return x.jcCd == data });
//    	                		return lang == 'kh' ?  obj.jcKh : obj.jcEn ;                    	
//                    		} else {
//                    			return '';
//                    		}
//	        			}
//	                },
//                    { targets: 5, render: function ( data, type, full, meta ) {
//                			if (data != null && data != '') {
//	                    		var obj = that$.commCode['jcCd'].find(function(x) { return x.jcCd == data });
//		                		return lang == 'kh' ?  obj.jcKh : obj.jcEn ;                    	
//	                		} else {
//	                			return '';
//	                		}
//	        			}
//	                },
	                { targets: 6, render: function ( data, type, full, meta ) {
                    		return full.recurmtBgnDt + '&nbsp;' + full.recurmtBgnHour + ':' +  full.recurmtBgnMinute + ':' + '&nbsp;' + full.recurmtBgnAmpm + '<br/>' +  full.recurmtEndDt + '&nbsp;' + full.recurmtEndHour + ':' +  full.recurmtEndMinute + ':' + '&nbsp;' + full.recurmtEndAmpm ;
                		}
                    },			
	                { targets: 7, render: function ( data, type, full, meta ) {
                			return full.fairBgnDt + '&nbsp;' + full.fairBgnHour + ':' +  full.fairBgnMinute + ':' + '&nbsp;' + full.fairBgnAmpm + '<br/>' +  full.fairEndDt + '&nbsp;' + full.fairEndHour + ':' +  full.fairEndMinute + ':' + '&nbsp;' + full.fairEndAmpm ;
	            		}
	                },		
//                    { targets: 8, render: function ( data, type, full, meta ) {
//	                		var obj = that$.commCode['fairStsCd'].find(function(x) { return x.dtlCd == data });
//	                		return that$.fn.commCdLang(obj) ;                    	
//	        			}
//	                },
                    { targets: 10, render: function ( data, type, full, meta ) {
	                		return moment(data).format("DD/MM/YYYY");     	
	        			}
	                },
                    { targets: [12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30], visible: false, searchable: false },
			    ],
			    /*
			    select: { 
			    	style: 'multi' 
			    },
			    */
			    order: [[10, 'desc']],
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
			
			$('#btnRegist').on('click', function() {
				that$.fn.pageAction('');
			});
			
			$('#neaJcDiv').on('change', function(e) {
				that$.fn.initSelJcCd( $(this).val() , '' );
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
				
//				return lang == 'kh' ?  obj.cdKhNm : obj.cdKhNm ;
//				return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
			},
		}
}
