var	jobskPrepareEduMng = {
		name: 'jobskPrepareEduMng',
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
						commGrpCdList: ['jcCd', 'trnngNatnexpDivCd', 'insttTypeCd', 'jcAgreeStsCd', 'eduDivCd', 'insttStsCd', 'insttOwnershipCd', 'recrumtStsCd', 'insttTypeCd', 'pcTypeCd' , 'tvcDivCd', 'hgepDivCd'],
						commGrpUseYn: 'Y'
					}
				};

			$.when( that$.fn.getCommCd(commCdParams) ).done(function( commCd ) {
				
				var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
				that$.commCode['trnngNatnexpDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('trnngNatnexpDivCd', 'snake') ];
				that$.commCode['insttTypeCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttTypeCd', 'snake') ];
				that$.commCode['jcAgreeStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('jcAgreeStsCd', 'snake') ];
				that$.commCode['eduDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('eduDivCd', 'snake') ];
				that$.commCode['insttStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttStsCd', 'snake') ];
				that$.commCode['insttOwnershipCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttOwnershipCd', 'snake') ];
				that$.commCode['recrumtStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('recrumtStsCd', 'snake') ];
				that$.commCode['insttTypeCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('insttTypeCd', 'snake') ];
				that$.commCode['pcTypeCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('pcTypeCd', 'snake') ];
				that$.commCode['tvcDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('tvcDivCd', 'snake') ];
				that$.commCode['hgepDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('hgepDivCd', 'snake') ];

				common.sys.getDatepicker();

				$(".datepicker").datepicker('option', {maxDate: '1Y'});
	            $('#startDate').datepicker('setDate', '-14D');
	            $('#endDate').datepicker('setDate', 'today');
	            $('button#-14D').addClass('on');
	            $("#periodOn").val("-14D");

	            var sessData = JSON.parse(sessionStorage.getItem(that$.name));

	            if (sessData) {
	            	$('#jcCd').val(sessData.jcCd);
	            	/*
	            	if ((sessData.recrumtStsCd).length > 0) {
		        		$('input[name=recrumtStsCd]:input[value=' + sessData.recrumtStsCd + ']').attr('checked', true);			        	
	            	}
	        		*/
	            	$('#searchKeyword').val(sessData.searchKeyword);
	        		$('#searchValue').val(sessData.searchValue);
	                $("#addrCd2Depth").val(sessData.addrCd2Depth); 
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
			});

            return deferred.promise();
		},
		bind: function() {
			var that$ = this;

			var setColumns = [
				{"data": "rowNum"},							//넘버
				{"data": "eduTrnngNm"},						//직업직원교육명
				{"data": "area"},							//지역/Venue
				{"data": "teacherNm1"},						//강사명1
				{"data": "teachDayInfo"},					//강의일시정보
				{"data": "recrumtMemb"},					//모집인원
				{"data": "recrumtStsCd"},					//모집상태
				{"data": "subscriberCnt"},					//신청자수
				{"data": "regDt"},							//등록일시
				{"data": "regUserNm"},						//등록자

				{"data": "teachDt"},						//강의 일
				{"data": "teachBgnHour"},					//강의 시작시
				{"data": "teachBgnMinute"},					//강의 시작분
				{"data": "teachBgnAmpm"},					//강의 시작AMPM
				{"data": "teachEndHour"},					//강의 종료시
				{"data": "teachEndMinute"},					//강의 종료분
				{"data": "teachEndAmpm"},					//강의 종료AMPM
				{"data": "eduTrnngSeq"},					//시퀀스
			];
			
			var orderColumns = setColumns.map(function(x) { return x.data });
			
			that$.dataTables = $('#jobskPrepareEduMngTable').DataTable({
				pageLength: 10,
	            lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
			    processing: true,
			    serverSide: true,
			    searching: false,
			    destroy: true,
			    serverMethod: 'post',
			    ajax: {
			    	url: contextPath + '/internal/trnng/selectJobskPrepareEduMngListAjax.do?orderColumns='+orderColumns
			    	, data: function ( d ) {
			        	return $.extend( {}, d, {
			        		eduDivCd: $('#eduDivCd').val(),
			        		neaEduDivCd: $('#neaEduDivCd').val(),
			        		jcCd: $('#jcCd option:selected').val(),
			        		//recrumtStsCd: $('input[name=recrumtStsCd]:checked').val(),
			        		searchKeyword: $('#searchKeyword option:selected').val(),
			        		searchValue: $.trim($('#searchValue').val()),
			        		periodKeyword: $('#periodKeyword option:selected').val(),
			        		addrCd2Depth: $.trim($('#addrCd2Depth option:selected').val()),
			        		startDate: $('#startDate').val(),
			        		endDate: $('#endDate').val(),
			        	} );
			        }
			        , dataType: 'json'
			    },
			    columns: setColumns,
			    columnDefs: [
			    	//{ targets: 0, checkboxes: { selectRow: true } },
			    	{ targets: 0, orderable: false },
			    	{ targets: 1, render: function ( data, type, full, meta ) {
			    			return "<a href=\"javascript:void(0);\" onclick=\"jobskPrepareEduMng.fn.pageAction('" + full.eduTrnngSeq + "');\"><span style=\"text-decoration: underline;\" >" + data + "</span></a>" ;
	            		}
	                },			    	
			    	{ targets: 4, orderable: false, render: function ( data, type, full, meta ) {
                    		return full.teachDt + '<br/>' + full.teachBgnAmpm + '&nbsp;' + full.teachBgnHour + ':' + full.teachBgnMinute + '~' + full.teachEndAmpm + '&nbsp;' + full.teachEndHour + ':' + full.teachEndMinute;
                		}
                    },			
			    	{ targets: 6, render: function ( data, type, full, meta ) {
                			var obj = that$.commCode['recrumtStsCd'].find(function(x) { return x.dtlCd == data });
                			return that$.fn.commCdLang(obj) ;  			    		
	            		}
	                },
                    { targets: 7, render: function ( data, type, full, meta ) {
			    			return "<a href=\"javascript:void(0);\" onclick=\"jobskPrepareEduMng.fn.subscrAction('" + full.eduTrnngSeq + "');  \"><span style=\"text-decoration: underline;\" >" + data + "</span></a>" ;
	            		}
	                },
                    { targets: [10, 11, 12, 13, 14, 15, 16, 17], visible: false, searchable: false },
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
			/*
			$('#btnFinish, #btnRecruiting, #btnDelete').on('click', function(e) {
				var rows = that$.fn.getDataTableRowSelected( that$.dataTables );
				if ( !rows.length ) {
					alertify.alert("선택 없음", function (e) {
						return;
					});					

				} else {
					var params = {
							traditional:true,
							data: {
								eduTrnngSeqList: rows
							}
						};
						
					if ( $(this).attr('id') == 'btnFinish' ) {
						params.data['recrumtStsCd'] = 'RSC0000000002';
						params.data['cofirmMsg'] = '마감';
					} else if ( $(this).attr('id') == 'btnRecruiting' ) {
						params.data['recrumtStsCd'] = 'RSC0000000001';
						params.data['cofirmMsg'] = '모집 중으로';
					} else if ( $(this).attr('id') == 'btnDelete' ) {
						params.data['delYn'] = 'Y';
						params.data['cofirmMsg'] = '삭제';
					}

					alertify.confirm("선택한 구직준비 교육을 " + params.data['cofirmMsg'] + " 하시겠습니까?", function (ex) {
						if (ex) {
							$('#btnFinish').attr('disabled', true);
							$('#btnRecruiting').attr('disabled', true);
							$('#btnDelete').attr('disabled', true);
							
							$.when( that$.fn.updateAction( params ) ).done(function( result ) {
								alertify.alert("저장 성공", function (e) {
									if(e) {
										$('#btnFinish').attr('disabled', false);
										$('#btnRecruiting').attr('disabled', false);
										$('#btnDelete').attr('disabled', false);
										that$.dataTables.ajax.reload();
									}
								});
							}).fail(function ( result ) {
								alertify.alert(result, function (e) {
									if(e) {
										$('#btnFinish').attr('disabled', false);
										$('#btnRecruiting').attr('disabled', false);
										$('#btnDelete').attr('disabled', false);
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
			// page link action for post submit
			pageAction : function(eduTrnngSeq) {
				$("#frmJobskPrepareEduMng").find("#eduTrnngSeq").val(eduTrnngSeq);
				var sessData = $("#frmJobskPrepareEduMng").serializeObject();
				sessionStorage.setItem(jobskPrepareEduMng.name, JSON.stringify(sessData));

				var urlParam = eduTrnngSeq != '' ? 'jobskPrepareEduMngDtl' : 'jobskPrepareEduMngReg' ;
				
				$("#frmJobskPrepareEduMng").attr("method", "post");
				$("#frmJobskPrepareEduMng").attr("action", contextPath + "/internal/trnng/" + urlParam + ".do");
				$("#frmJobskPrepareEduMng").submit();
			},
			// subscriber list page link action for post submit
			subscrAction : function(eduTrnngSeq) {
				$("#frmJobskPrepareEduMng").find("#eduTrnngSeq").val(eduTrnngSeq);
				var sessData = $("#frmJobskPrepareEduMng").serializeObject();
				sessionStorage.setItem(jobskPrepareEduMng.name, JSON.stringify(sessData));

				$("#frmJobskPrepareEduMng").attr("method", "post");
				$("#frmJobskPrepareEduMng").attr("action", contextPath + "/internal/trnng/jobskPrepareSubscriber.do");
				$("#frmJobskPrepareEduMng").submit();
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
				    url: contextPath + '/internal/trnng/updateJobskPrepareEduMngArrayAjax.do',
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
