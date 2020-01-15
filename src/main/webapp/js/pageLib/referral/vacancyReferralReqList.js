
	var	vacancyReferralReqList = {
		pageYn : 'N',
			name: 'vacancyReferralReqList',
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
					$('#jcList option:selected').val(sessData.jcList);
					$('#employFormCd option:selected').val(sessData.employFormCd);
					$("#vccy_sts").val(sessData.vccy_sts);

					$("#startDate").val(sessData.startDate);
					$("#endDate").val(sessData.endDate);
					$('button.btnPeriod').removeClass('on');
						
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					vacancyReferralReqList.pageYn = 'Y';
					sessionStorage.clear();
				}				
				
				deferred.resolve();	
				
			},

			bind: function() {
				var that$ = this;
				
				var setColumns = [
					{"data": "rowNum"},
					{"data": "compnyNm"},
	            	{"data": "employFormCd"},
		            {"data": "vacancyTitle"},
					{"data": "mngerNm"},
					{"data": "mngerEmail"},
		            {"data": "mngerCell"},
		            {"data": "endDt"},
					{"data": "jcNm"},
					{"data": ""},
		            {"data": "vacancyStsCd"},
					
					
					{"data": "vacancySeq"},
					{"data": "compnySeq"}
			    ];
				
				var orderColumns = setColumns.map(function(x) {return x.data });
				
				that$.dataTables = $('#vacancyReferral').DataTable({
					pageLength: 10,
	                lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
			        processing: true,
			        serverSide: true,
					searching: false,
					bStateSave : true,
					destroy: true,
					stateSaveCallback: function(settings,data) {
						localStorage.setItem( vacancyReferralReqList.name + settings.sInstance, JSON.stringify(data) );
					  },
					stateLoadCallback: function(settings) {
						if (vacancyReferralReqList.pageYn == 'Y') {
							return JSON.parse( localStorage.getItem( vacancyReferralReqList.name + settings.sInstance ) );
						} else {
							localStorage.clear();
							return JSON.parse( localStorage.getItem( vacancyReferralReqList.name + settings.sInstance ) );
						}
					  },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/referral/selectVacancyReferralReqListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
								KeywordSel: $('#Keyword_sel').val(),
                        		keyword: $('#keyword').val(),
			                	jcCd: $('#jcList option:selected').val(),
			                	employFormCd: $('#employFormCd option:selected').val(),
			                	vacancyStsCd: $('#vccy_sts').val(),
			                	startDate: $('#startDate').val(),
			                	endDate: $('#endDate').val()
			                	
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
	                        	return '<a herf=\"#\" onclick=\"pageActionCmpnyInfo(\'' + full.compnySeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: 9,
	                        render: function ( data, type, full, meta ) {
	                        	var html = "";
								html = "<input type=\"button\" value=\"Matching\" id=\"btnSearch\" class=\"bbs_btn type02 small writing\" onclick=\"referralMatchConf('"+ full.vacancySeq +"','"+ full.compnySeq +"');\" />" ;
								
								return html;
	                        }
						},
						{ targets: [11,12], visible: false, searchable: false }
			        ],		        
					order: [[7, 'asc']],
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

	function pageActionCmpnyInfo(compnySeq){
		var previousUrl = contextPath + "/internal/referral/vacancyReferralReqList.do";
		$("#frmParam").find("#previousUrl").val(previousUrl);
		$("#frmParam").find("#compnySeq").val(compnySeq);
		var sessData = $('#frmParam').serializeObject();
    	sessionStorage.setItem(vacancyReferralReqList.name + "." + vacancyReferralReqList.method, JSON.stringify(sessData));
		$("#frmParam").attr("method", "post");
		$("#frmParam").attr("action", contextPath + "/internal/user/selectUserCmpnyDtlInfoMain.do");
		$("#frmParam").submit();

	}


	function referralMatchConf(vacancySeq,compnySeq){
		$("#frmParam").find("#compnySeq").val(compnySeq);
		$("#frmParam").find("#vacancySeq").val(vacancySeq);
		var sessData = $('#frmParam').serializeObject();
    	sessionStorage.setItem(vacancyReferralReqList.name + "." + vacancyReferralReqList.method, JSON.stringify(sessData));
		$("#frmParam").attr("method", "post");
		$("#frmParam").attr("action", contextPath + "/internal/referral/vacancyReferralMatchList.do");
		$("#frmParam").submit();

	}