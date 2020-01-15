var	jobFairJoinSts = {
		name: 'jobFairJoinSts',
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
			
			/*
			var commCdParams = {
					data: {
						commGrpCdList: ['fairDivCd', 'fairStsCd'],
						commGrpUseYn: 'Y'
					}
				};
			 */
//			$.when( that$.fn.getCommCd(commCdParams), that$.fn.getJcCd(), that$.fn.getAddrCd1Depth() ).done(function( commCd, jcCd, addrCd1Depth ) {
				
//				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
//				that$.commCode['fairDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('fairDivCd', 'snake') ];
//				that$.commCode['fairStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('fairStsCd', 'snake') ];
				
//				that$.commCode['jcCd'] = jcCd;
//				that$.commCode['addrCd1Depth'] = addrCd1Depth;
				
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
	        		if(sessData.fairStsDiv != '') {
	        			$('input[name=fairStsDiv]:input[value=' + sessData.fairStsDiv + ']').attr('checked', true);
	        		}
	            	
	                $("#addrCd1Depth").val(sessData.addrCd1Depth); 
	                if(sessData.fairViewYn != '') {
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
	            }		

	            deferred.resolve();	
//			});

            return deferred.promise();
		},
		bind: function() {
			var that$ = this;

			var setColumns = [
				{"data": "rowNum"},							//넘버
				{"data": "fairDivNm"},						//행사구분코드
				{"data": "fairNm"},							//행사명
				//{"data": "addrFullCd"},						//지역full코드
				//{"data": "mstJcCd"},						//등록잡센터코드							
				//{"data": "jcCd"},							//주관잡센터코드
				{"data": "jobskTot"},						//구직자수
				{"data": "compnyTot"},						//기업수
				{"data": "vacancyAncmtTot"},				//채용공고수
				{"data": "insttTot"},						//교육기관수
				{"data": "eduProgramTot"},					//교육프로그램수
				{"data": "applicTot"},						//입사지원수
				{"data": "vacancyTot"},						//채용확정수
				{"data": "fairStsNm"},						//행사상태
				{"data": "fairDt"},							//행사기간
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
				];
			
			var orderColumns = setColumns.map(function(x) { return x.data });
			
			that$.dataTables = $('#jobFairJoinStsTable').DataTable({
				pageLength: 10,
	            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
			    processing: true,
			    serverSide: true,
			    searching: false,
			    destroy: true,
			    serverMethod: 'post',
			    ajax: {
			    	url: contextPath + '/internal/fair/selectJobFairJoinStsListAjax.do?orderColumns='+orderColumns
			    	, data: function ( d ) {
			    		
			        	return $.extend( {}, d, {
			        		jcCd: $('#jcCd option:selected').val(),
			        		fairDivCd: $('#fairDivCd option:selected').val(),
			        		fairStsDiv: $('input[name=fairStsDiv]:checked').val(),
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
			    	{ targets: 0, orderable: false },
                    /*{ targets: 1, render: function ( data, type, full, meta ) {
	                		var obj = that$.commCode['fairDivCd'].find(function(x) { return x.dtlCd == data });
	                		return that$.fn.commCdLang(obj) ;                    	
	        			}
	                },*/
                    { targets: 2, render: function ( data, type, full, meta ) {
                    		var fairNm = lang == 'kh' ?  full.fairNmKh : full.fairNmEn ;
	        				return "<a href=\"javascript:void(0);\" onclick=\"jobFairJoinSts.fn.pageAction('" + full.fairSeq + "');\">" + fairNm + "</font>" ;
	        				//return "<a href=\"javascript:void(0);\" onclick=\"course.fn.pageAction('" + full.fairSeq + "');\">" + data + "</font>" ;
                    	}
	                },
	                { targets: 3, render: function ( data, type, full, meta ) {
        				return "<a href=\"javascript:void(0);\" onclick=\"jobFairJoinSts.fn.jobskPageAction('" + full.fairSeq + "');\">" + full.jobskTot + "</font>" ;
        				//return "<a href=\"javascript:void(0);\" onclick=\"course.fn.pageAction('" + full.fairSeq + "');\">" + data + "</font>" ;
                		}
	                },
	                { targets: 4, render: function ( data, type, full, meta ) {
        				return "<a href=\"javascript:void(0);\" onclick=\"jobFairJoinSts.fn.compnyPageAction('" + full.fairSeq + "');\">" + full.compnyTot + "</font>" ;
        				//return "<a href=\"javascript:void(0);\" onclick=\"course.fn.pageAction('" + full.fairSeq + "');\">" + data + "</font>" ;
                		}
	                },
	                { targets: 5, render: function ( data, type, full, meta ) {
                		var fairNm = lang == 'kh' ?  full.fairNmKh : full.fairNmEn ;
        				return "<a href=\"javascript:void(0);\" onclick=\"jobFairJoinSts.fn.compnyPageAction('" + full.fairSeq + "');\">" + full.vacancyAncmtTot + "</font>" ;
        				//return "<a href=\"javascript:void(0);\" onclick=\"course.fn.pageAction('" + full.fairSeq + "');\">" + data + "</font>" ;
                		}
	                },
	                { targets: 6, render: function ( data, type, full, meta ) {
                		var fairNm = lang == 'kh' ?  full.fairNmKh : full.fairNmEn ;
        				return "<a href=\"javascript:void(0);\" onclick=\"jobFairJoinSts.fn.insttPageAction('" + full.fairSeq + "');\">" + full.vacancyAncmtTot + "</font>" ;
        				//return "<a href=\"javascript:void(0);\" onclick=\"course.fn.pageAction('" + full.fairSeq + "');\">" + data + "</font>" ;
                		}
	                },
			    	/*
                    { targets: 3, render: function ( data, type, full, meta ) {
                    		var addrCd1Depth = $.trim((full.addrFullCd).split(',')[0]);
	                		var obj = that$.commCode['addrCd1Depth'].find(function(x) { return x.dtlCd == addrCd1Depth });
	                		return that$.fn.commCdLang(obj) ;                    	
	        			}
	                },
	                */
			    	/*
                    { targets: 4, render: function ( data, type, full, meta ) {
                    		if (data != null && data != '') {
                        		var obj = that$.commCode['jcCd'].find(function(x) { return x.jcCd == data });
    	                		return lang == 'kh' ?  obj.jcKh : obj.jcEn ;                    	
                    		} else {
                    			return '';
                    		}
	        			}
	                },*/
			    	/*
                    { targets: 5, render: function ( data, type, full, meta ) {
                			if (data != null && data != '') {
	                    		var obj = that$.commCode['jcCd'].find(function(x) { return x.jcCd == data });
		                		return lang == 'kh' ?  obj.jcKh : obj.jcEn ;                    	
	                		} else {
	                			return '';
	                		}
	        			}
	                },*/
			    	/*
                    { targets: 13, render: function ( data, type, full, meta ) {
	                		var obj = that$.commCode['fairStsCd'].find(function(x) { return x.dtlCd == data });
	                		return that$.fn.commCdLang(obj) ;                    	
	        			}
	                },*/
	                { targets: 11, orderable: false, render: function ( data, type, full, meta ) {
	            			return full.fairBgnDt + '&nbsp;' + full.fairBgnHour + ':' +  full.fairBgnMinute + ':' + '&nbsp;' + full.fairBgnAmpm + '<br/>' +  full.fairEndDt + '&nbsp;' + full.fairEndHour + ':' +  full.fairEndMinute + ':' + '&nbsp;' + full.fairEndAmpm ;
	            		}
	                },		
	                { targets: 12, render: function ( data, type, full, meta ) {
	                		return moment(data).format("DD/MM/YYYY");     	
	        			}
	                },
                    { targets: [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24], visible: false, searchable: false },
			    ],
			    /*
			    select: { 
			    	style: 'multi' 
			    },
			    */
			    order: [[12, 'desc']],
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
//			getCommCd : function(params) {
//			    var deferred = $.Deferred();
//			    var options = {
//			    	method: 'post',
//			    	url: contextPath + '/common/selectCommCodeListAjax.do',
//			    	traditional: true,
//			    	data: params.data,
//			    	dataType: 'json',
//			    };
//			    
//			    $.ajax(options)
//			    .done(function (res, status, responseObj) {
//			        deferred.resolve(res.result);
//			    }).fail(function (result, status, responseObj) {
//			    	deferred.reject(status);
//			    });
//
//			    return deferred.promise();
//			},
//			getJcCd : function() {
//			    var deferred = $.Deferred();
//			    var options = {
//			    	method: 'post',
//			    	url: contextPath + '/internal/fair/selectJcCdListAjax.do',
//			    	dataType: 'json',
//			    };
//			    
//			    $.ajax(options)
//			    .done(function (res, status, responseObj) {
//			    	deferred.resolve(res.result);
//			    }).fail(function (result, status, responseObj) {
//			    	deferred.reject(status);
//			    });
//
//			    return deferred.promise();
//			},			
//			getAddrCd1Depth : function() {
//			    var deferred = $.Deferred();
//			    var options = {
//			    	method: 'post',
//			    	url: contextPath + '/internal/fair/selectLOC2DepthListAjax.do',
//			    	dataType: 'json',
//			    };
//			    
//			    $.ajax(options)
//			    .done(function (res, status, responseObj) {
//			        deferred.resolve(res.result);
//			    }).fail(function (result, status, responseObj) {
//			    	deferred.reject(status);
//			    });
//
//			    return deferred.promise();
//			},				
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
				$("#frmJobFairJoinSts").find("#fairSeq").val(fairSeq);
				var sessData = $("#frmJobFairJoinSts").serializeObject();
				sessionStorage.setItem(jobFairJoinSts.name, JSON.stringify(sessData));

//				var urlParam = fairSeq != '' ? 'jobFairMngDtl' : 'jobFairMngReg' ;
				
				$("#frmJobFairJoinSts").attr("method", "post");
				$("#frmJobFairJoinSts").attr("action", contextPath + "/internal/fair/jobFairMngDtl.do");
				$("#frmJobFairJoinSts").submit();
			},
			// page link action for post submit
			jobskPageAction : function(fairSeq) {
				$("#frmJobFairJoinSts").find("#fairSeq").val(fairSeq);
				$("#frmJobFairJoinSts").attr("method", "post");
				$("#frmJobFairJoinSts").attr("action", contextPath + "/internal/fair/privateUserJoinMng.do");
				$("#frmJobFairJoinSts").submit();
			},
			compnyPageAction : function(fairSeq) {
				$("#frmJobFairJoinSts").find("#fairSeq").val(fairSeq);
				$("#frmJobFairJoinSts").attr("method", "post");
				$("#frmJobFairJoinSts").attr("action", contextPath + "/internal/fair/compnyJoinMng.do");
				$("#frmJobFairJoinSts").submit();
			},
			insttPageAction : function(fairSeq) {
				$("#frmJobFairJoinSts").find("#fairSeq").val(fairSeq);
				$("#frmJobFairJoinSts").attr("method", "post");
				$("#frmJobFairJoinSts").attr("action", contextPath + "/internal/fair/insttJoinMng.do");
				$("#frmJobFairJoinSts").submit();
			},
			// return code name string
			// common code lenguage choose
			commCdLang : function(obj) {
				return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
			},
			
		}
}
