var	counselList = {
	pageYn : 'N',
	name: 'counselList',
	method:'',
	dataTables: null,
	commCode: {},
	
	init: function() {
		var that$ = this;
		that$.method = method;
		
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
				commGrpCdList: [ 'counselCateDivCd', 'counselMethodDivCd', 'counselTargetCd', 'counselStsCd', 'userAuthCd' ],
				commGrpUseYn: 'Y'
			}
		};

		common.sys.getDatepicker();
			
			$('#startDate').datepicker('setDate', '-14D');
			$('#endDate').datepicker('setDate', 'today');
			$('button#-14D').addClass('on');
			$("#periodOn").val("-14D");

		$.when( that$.fn.getCommCd(commCdParams) ).done(function( commCd ) {
			var groupByCommCd = that$.fn.groupBy( JSON.parse(JSON.stringify(commCd)), 'grpCd' );
			that$.commCode['counselCateDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('counselCateDivCd', 'snake') ];
			that$.commCode['counselMethodDivCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('counselMethodDivCd', 'snake') ];
			that$.commCode['counselTargetCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('counselTargetCd', 'snake') ];
			that$.commCode['counselStsCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('counselStsCd', 'snake') ];
			that$.commCode['userAuthCd'] = groupByCommCd[ that$.fn.toCamelOrSnake('userAuthCd', 'snake') ];
			
			$.each(that$.commCode['counselTargetCd'], function (i, item) {
				$('#counselTargetCd').append($('<option>', { 
					value: item.dtlCd,
					text : that$.fn.commCdLang(item) 
				}));
			});

			$.each(that$.commCode['counselStsCd'], function (i, item) {
				$('#counselStsCd').append($('<option>', { 
					value: item.dtlCd,
					text : that$.fn.commCdLang(item) 
				}));
			});

			$.each(that$.commCode['userAuthCd'], function (i, item) {
				if (['ROLE_USER', 'ROLE_STDIT'].indexOf(item.dtlCd) != -1) {
					$('#userAuthCd').append($('<option>', { 
						value: item.dtlCd,
						text : that$.fn.commCdLang(item)
					}));
				}
			});

			
			
			var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
			if (sessData) {
				//$("#counselCateDivCd").val(sessData.counselCateDivCd);
				//$("#counselMethodDivCd").val(sessData.counselMethodDivCd);
				//$("#searchKeyword").val(sessData.searchKeyword);
				//$("#searchValue").val(sessData.searchValue);
				//$("#counselTargetCd").val(sessData.counselTargetCd);
				//$("#userAuthCd").val(sessData.userAuthCd);
				//$("#counselStsCd").val(sessData.counselStsCd);
				//$("#secretYn").val(sessData.secretYn);
				
				$("#startDate").val(sessData.startDate);
				$("#endDate").val(sessData.endDate);
				$('button.btnPeriod').removeClass('on');
				
				if (sessData.periodOn != "") {
					$("#periodOn").val(sessData.periodOn);
					$('button#'+sessData.periodOn).addClass('on');
				}
				counselList.pageYn = 'Y';
				sessionStorage.clear();
			}				
			
			deferred.resolve();	
		});
		
		return deferred.promise();
	},
	bind: function() {
		var that$ = this;

		var setColumns = [
			{"data": "counselSeq"},
			{"data": "counselMethodDivNm"},
			{"data": "qustTitle"},
			{"data": "counselStsCd"},
			{"data": "secretYn"},
			{"data": "qustFileGrpSeq"},
			{"data": "userNm"},
			{"data": "likeCnt"},
			{"data": "viewCnt"},				
			{"data": "qustRegDt"},
			
			{"data": "userAuthCd"},
			{"data": "qustRegUserSeq"},
			{"data": "counselMethodDivCd"},
			{"data": "counselCateDivCd"},
			{"data": "qustRegUserSeq"},
			{"data": "iscoCd"},
			{"data": "qustJcCd"},
			{"data": "qustContent"},
			{"data": "qustEtcReq"},
			{"data": "hopeCounselDt"},
			{"data": "ansTitle"},
			{"data": "ansContent"},
			{"data": "ansFileGrpSeq"},
			{"data": "ansRegUserSeq"},
			{"data": "ansRegDt"},
			{"data": "ansModUserSeq"},
			{"data": "ansModDt"},
			{"data": "jcUserSeq"},
			{"data": "delYn"}
		];
		
		var orderColumns = setColumns.map(function(x) { return x.data });
		
		that$.dataTables = $('#counselTable').DataTable({
			pageLength: 10,
			lengthMenu : [ [ 10, 30, 50, 100, -1 ], [ 10, 30, 50, 100, "All" ] ],
			processing: true,
			serverSide: true,
			searching: false,
			destroy: true,
			stateSaveCallback: function(settings,data) {
				localStorage.setItem( counselList.name + settings.sInstance, JSON.stringify(data) );
			  },
			stateLoadCallback: function(settings) {
				if (counselList.pageYn == 'Y') {
					return JSON.parse( localStorage.getItem( counselList.name + settings.sInstance ) );
				} else {
					localStorage.clear();
					return JSON.parse( localStorage.getItem( counselList.name + settings.sInstance ) );
				}
			  },
			serverMethod: 'post',
			ajax: {
				url: contextPath + '/internal/counsel/selectUserCounselHisAjax.do?orderColumns='+orderColumns
//			    	, data: function ( d ) {
//			    		return $.extend( {}, d, $('#frmCourse').serializeObject());
//			    	}
				, data: function ( d ) {
					return $.extend( {}, d, {
						userSeq: $('#userSeq').val(),
						startDate: $('#startDate').val(),
						endDate: $('#endDate').val(),
					} );
				}
				, dataType: 'json'
			},
			columns: setColumns,
			columnDefs: [
				{ targets: 0, visible: false, searchable: false },
				/*
				{ targets: 1, visible: false, searchable: false, render: function ( data, type, full, meta ) {
						var obj = that$.commCode['counselTargetCd'].find(function(x) { return x.dtlCd == data });
						return that$.fn.commCdLang(obj) ;
					}
				},*/ 	
				{ targets: 2, render: function ( data, type, full, meta ) {
						//return "<a href=\"javascript:void(0);\" onclick=\"counselList.fn.pageAction('" + full.counselSeq + "','"+ full.counselCateDivCd +"');\">" + data + "</font>" ;
						return "<a href=\"javascript:void(0);\" onclick=\"counselList.fn.pageAction('" + full.counselSeq + "');\">" + data + "</font>" ;
					}
				},
				{ targets: 3, render: function ( data, type, full, meta ) {
						var obj = that$.commCode['counselStsCd'].find(function(x) { return x.dtlCd == data });
						var fontColor = data == "CSC0000000001" ? "red" : ( data == "CSC0000000002" ? "orange" : "black" ) ;
						return "<font color='" + fontColor + "'>" + that$.fn.commCdLang(obj) + "</font>" ;
					}
				},
				{ targets: [10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28], visible: false, searchable: false },
			],
			select: { 
				style: 'multi' 
			},
			order: [[1, 'asc']],
			dom : 'lBfrtip',
			buttons: [
				{
					extend: 'excel',
					text: 'EXCEL DOWNLOAD',
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
		
		//검색버튼
		$('#btnSearch').on('click', function() {
			that$.dataTables.ajax.reload();
		});
		
		//DataTables Render Button Click event
		that$.dataTables.on('click', '.btnRender', function() {
			console.log($(this).attr('id'));
		});

//             Handle form submission event
//            $('#btnSubmit').on('click', function(e) {
//                var rows_selected = that$.dataTables.column(0).checkboxes.selected();
//                var rowId = rows_selected.toArray();
//            });
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
		pageAction : function(counselSeq) {
			//$("#frmCourse").find("#counselSeq").val(counselSeq);
			//var sessData = $('form').serializeObject();
			//sessionStorage.setItem(counselList.name + "." + counselList.method, JSON.stringify(sessData));

			//$("#frmCourse").attr("method", "post");
			//$("#frmCourse").attr("action", contextPath + "/internal/counsel/courseDtlUser.do");
			//$("#frmCourse").submit();
			CounselDtl(counselSeq);
		},
		commCdLang : function(obj) {
			return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
		},
		// 게시물 데이터
		getList : function() {
		},
		//게시물 그리기
		drawList : function(dataJson) {
		},
	}
}


function pageAction(counselSeq,counselCateDivCd){
	$("#innerCounselInfo").empty();
	var sessData = $('#frmParam').serializeObject();
    	sessionStorage.setItem(counselList.name + "." + counselList.method, JSON.stringify(sessData));
	
	var action = contextPath + "/internal/counsel/selectCounselHisDtlAjax.do";
	var param = {
		"cateDivCd" : counselCateDivCd, 
		"counselSeq" : counselSeq, 
		"lang" : lang
	};
	
	$.ajax({
		type: "POST",
		url: action,
		data: param,                   
		cache: true,
		success: function(response) {
			//alert(response);
			$("#innerCounselInfo").html(response);
		}
	});
	
	$("#innerUserDtlInfoBase").hide();
	$("#innerResumeDtlInfo").hide();	
	$("#innerCounselInfo").show();		
}

/*
function insertElemtryCounsel(){
	$("#frmUserElementaryDtlInfoMain").attr("method", "post");
	$("#frmUserElementaryDtlInfoMain").attr("action", contextPath + "/internal/user/elementaryCounselReg.do");
	$("#frmUserElementaryDtlInfoMain").submit();
}*/
