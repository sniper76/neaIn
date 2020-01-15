
	var	neaUserList = {
		pageYn : 'N',
		name: 'neaUserList',
		dataTables: null,

		init: function() {
			this.beforeBind();
			this.bind();
			this.afterBind();
		},
		
		beforeBind: function() {
			
			var that$ = this;
			
			common.sys.getDatepicker();

			$('#startDate').datepicker('setDate', '-3M');
			$('#endDate').datepicker('setDate', 'today');
			$('button#-3M').addClass('on');
			$("#periodOn").val("-3M");	

			var deferred = $.Deferred();
			var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
			
			if (sessData) {
				$("#Keyword_sel").val(sessData.Keyword_sel);
				$("#keyword").val(sessData.keyword);
				$("#gender").val(sessData.gender);
				$("#workRetireCd").val(sessData.workRetireCd);
				$("#urlChk").val(sessData.urlChk);

				$("#startDate").val(sessData.startDate);
				$("#endDate").val(sessData.endDate);
				$('button.btnPeriod').removeClass('on');
					
				if (sessData.periodOn != "") {
					$("#periodOn").val(sessData.periodOn);
					$('button#'+sessData.periodOn).addClass('on');
				}
				neaUserList.pageYn = 'Y';
				sessionStorage.clear();
			}				
			
			deferred.resolve();	
			
		},

		bind: function() {
			
			var that$ = this;
			
			var setColumns = [
				{"data": "rowNum"},
				{"data": "insttNmCd"},
				{"data": "userNm"},
				{"data": "userId"},
				{"data": "userEmail"},
				{"data": "userCell"},
				{"data": "workRetireNm"},
				{"data": ""},
				{"data": "useYn"},
				{"data": "regDt"},
				{"data": "userSeq"}
			];
			
			var orderColumns = setColumns.map(function(x) {return x.data });
			
			that$.dataTables = $('#neaUserList').DataTable({
				stateSave : true,
				pageLength: 10,
				lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
				processing: true,
				serverSide: true,
				bStateSave : true,
				searching: false,
				destroy: true,
				stateSaveCallback: function(settings,data) {
					localStorage.setItem( neaUserList.name + settings.sInstance, JSON.stringify(data) );
				  },
				stateLoadCallback: function(settings) {
					if (neaUserList.pageYn == 'Y') {
						return JSON.parse( localStorage.getItem( neaUserList.name + settings.sInstance ) );
					} else {
						localStorage.clear();
						return JSON.parse( localStorage.getItem( neaUserList.name + settings.sInstance ) );
					}
				  },
				serverMethod: 'post',
				ajax: {
					url: contextPath +"/internal/common/selectNeaUserListAjax.do?orderColumns="+orderColumns
					, dataType: 'json'
					//, data: param
					, data: function ( d ) {
						return $.extend( {}, d, {
							KeywordSel: $('#Keyword_sel').val(),
							keyword: $('#keyword').val(),
							genderCd: $('#gender').val(),
							workRetireCd: $('#workRetireCd').val(),
							startDate: $('#startDate').val(),
							endDate: $('#endDate').val(),
							urlChk: $('#urlChk').val()
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
						targets: 2,
						render: function ( data, type, full, meta ) {
							return '<a herf=\"#\" onclick=\"pageAction(\'' + full.userSeq + '\');\">' + data + '</a>';
						}
					},
					{
						targets: 7,
						render: function ( data, type, full, meta ) {
							var html = "";
							html = "<input type=\"button\" value='"+authMng+"' id=\"btnSearch\" class=\"bbs_btn type02 small writing\" onclick=\"authMngAction('"+ full.userSeq +"');\" />" ;
							
							return html;
						}
					},
					{ targets: 10, visible: false, searchable: false }
				],		        
				order: [[9, 'desc']],
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
			var that$ = this;
			
			$('button.btnPeriod').on('click', function() {
				$('button.btnPeriod').removeClass('on');
				$('button#'+$(this).attr('id')).addClass('on');
				$('#startDate').datepicker('setDate', $(this).attr('id'));
				$('#endDate').datepicker('setDate', 'today');
				$('#periodOn').val($(this).attr('id'));
			});
			
			// Search Button
			$('#btnSearch').on('click', function(e) {
				that$.dataTables.ajax.reload();
			});
			
			
		},
		fn: {
			//게시물 그리기
			drawList : function(dataJson) {
			}
		}

}

function authMngAction(userSeq){
	$("#userSeq").val(userSeq);
	var urlChk = $("#urlChk").val();
	var sessData = $('#schFrm').serializeObject();
    sessionStorage.setItem(neaUserList.name + "." + neaUserList.method, JSON.stringify(sessData));
	
	$("#schFrm").attr("method", "post");
	if(urlChk == "nea"){
		$("#schFrm").attr("action", contextPath + "/internal/common/mngerNeaMenuAuth.do");
	}else if(urlChk == "nonNea"){
		$("#schFrm").attr("action", contextPath + "/internal/common/mngerNoneNeaMenuAuth.do");
    }else if(urlChk == "jobCenter"){
    	$("#schFrm").attr("action", contextPath + "/internal/common/mngerJcMenuAuth.do");
    }
	$("#schFrm").submit();
}

function pageAction(userSeq){
	$("#schFrm").find("#userSeq").val(userSeq);
	var sessData = $('#schFrm').serializeObject();
    sessionStorage.setItem(neaUserList.name + "." + neaUserList.method, JSON.stringify(sessData));

	var urlChk = $("#urlChk").val(); 

	$("#schFrm").attr("method", "post");
    if(urlChk == "nea"){
        $("#schFrm").attr("action", contextPath + "/internal/common/neaUserMod.do");
    }else if(urlChk == "nonNea"){
        $("#schFrm").attr("action", contextPath + "/internal/common/nonNeaUserMod.do");
    }else if(urlChk == "jobCenter"){
        $("#schFrm").attr("action", contextPath + "/internal/common/jobCenterUserMod.do");
    }
	
	$("#schFrm").submit();

}

function insertNeaUser(){
	var urlChk = $("#urlChk").val(); 
	var sessData = $('#schFrm').serializeObject();
    sessionStorage.setItem(neaUserList.name + "." + neaUserList.method, JSON.stringify(sessData));

	$("#schFrm").attr("method", "post");
    if(urlChk == "nea"){
        $("#schFrm").attr("action", contextPath + "/internal/common/neaUserReg.do");
    }else if(urlChk == "nonNea"){
        $("#schFrm").attr("action", contextPath + "/internal/common/nonNeaUserReg.do");
    }else if(urlChk == "jobCenter"){
        $("#schFrm").attr("action", contextPath + "/internal/common/jobCenterUserReg.do");
    }
	
	
	$("#schFrm").submit();
}