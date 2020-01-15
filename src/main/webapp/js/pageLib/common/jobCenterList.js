var	jobCenterList = {
		pageYn : 'N',
		name: 'jobCenterList',
		dataTables: null,

		init: function() {
			this.beforeBind();
			this.bind();
			this.afterBind();

		},

		beforeBind: function() {
			var that$ = this;
			var deferred = $.Deferred();
			var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));

			if (sessData) {
				$("#Keyword_sel").val(sessData.KeywordSel);
				$("#keyword").val(sessData.keyword);
				$("#useYn").val(sessData.useYn);

				jobCenterList.pageYn = 'Y';
				sessionStorage.clear();
			}

			deferred.resolve();
		},


		bind: function() {
			var that$ = this;

			var setColumns = [
				{"data": "rowNum"},
				{"data": "jcNm"},
				{"data": "jcCd"},
				{"data": "locNm"},
				{"data": "tel1"},
				{"data": "tel2"},
				{"data": "email"},
				{"data": "mapLink"},
				{"data": "useYn"},
				{"data": "regDt"},
				{"data": "regUserNm"}
			];
			//jobCenterList.fn.getList();
			var orderColumns = setColumns.map(function(x) {return x.data });
			// init dataTable
			that$.dataTables = $('#jobCtList').DataTable({
				pageLength: 10,
				lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
				processing: true,
				serverSide: true,
				searching: false,
				destroy: true,
				stateSaveCallback: function(settings,data) {
					localStorage.setItem( jobCenterList.name + settings.sInstance, JSON.stringify(data) );
				  },
				stateLoadCallback: function(settings) {
					if (jobCenterList.pageYn == 'Y') {
						return JSON.parse( localStorage.getItem( jobCenterList.name + settings.sInstance ) );
					} else {
						localStorage.clear();
						return JSON.parse( localStorage.getItem( jobCenterList.name + settings.sInstance ) );
					}
				  },
				serverMethod: 'post',
		        ajax: {
		        	url :  contextPath + "/internal/common/selectJobCenterListAjax.do?orderColumns="+orderColumns // URL
					, dataType: 'json'
					, data: function ( d ) {
						return $.extend( {}, d, {
							KeywordSel: $('#Keyword_sel').val(),
							keyword: $('#keyword').val(),
							useYn: $('#useYn').val()
						} );
					}
	            	, dataSrc: function(res) {
						that$.getRowData = res.aaData;
						return res.aaData;
					}

				},
				columns: setColumns,
				columnDefs: [
					{
						targets: 1,
						render: function ( data, type, full, meta ) {
							var html = "";

							html = "<a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.jcCd + "');\">" + data + "</font>" ;

							return html;
						}
					},
					{
						targets: 7,
						render: function ( data, type, full, meta ) {
							var html = "";

							html = "<input type=\"button\" value=\"view\" id=\"btnSearch\" class=\"bbs_btn type02 small writing\" onclick=\"googleMapView('"+ full.mapLink +"');\" />" ;

							return html;
						}
					}
				],
				order: [[9, 'asc']],
				dom : 'lBfrtip',
				buttons: [
					{
						extend: 'excel',
						name: 'EXCELDOWNLOAD',
						className: 'bbs_btn type03 download',
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
			//common.sys.getDatepicker();
			//검색버튼
			//$('#btnSearch').click(function(){
			//	jobCenterList.currentPage = 1;
			//	jobCenterList.fn.getList();
			//});

			var that$ = this;


			// Search Button
			$('#btnSearch').on('click', function(e) {
				that$.dataTables.ajax.reload();
			});

		},

		fn: {
			/** 게시물 데이터*
			getList : function() {
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
				var param = {
						"pageNo"		:	jobCenterList.currentPage,
						"listBlock"		:	jobCenterList.listBlock
					};

				$.ajax({
				    type : 'post', // 타입
				    url :  contextPath + "/internal/common/selectJobCenterList.do", // URL
				    dataType : 'json', // 데이터 타입
				    data : param,
				    success : function(result) { // 결과 성공
				        console.log(result);
				    },
				    error : function(request, status, error) { // 결과 에러

				    }
				})
			},
			게시물 그리기 **/
			drawList : function(dataJson) {

			}
		}
}

function googleMapView(mLink){
	window.open(mLink, "_blank", "width=1000,height=600");
}

function pageAction(jcCd){
	$("#schFrm").find("#jcCd").val(jcCd);
	var sessData = $('#frm').serializeObject();
    sessionStorage.setItem(jobCenterList.name + "." + jobCenterList.method, JSON.stringify(sessData));
	$("#schFrm").attr("method", "post");
	$("#schFrm").attr("action", contextPath + "/internal/common/jobcenterMod.do");
	$("#schFrm").submit();
}

function insertJobCenter(){
	var sessData = $('#frm').serializeObject();
    sessionStorage.setItem(jobCenterList.name + "." + jobCenterList.method, JSON.stringify(sessData));
	$("#schFrm").attr("method", "post");
	$("#schFrm").attr("action", contextPath + "/internal/common/jobcenterReg.do");
	$("#schFrm").submit();
}