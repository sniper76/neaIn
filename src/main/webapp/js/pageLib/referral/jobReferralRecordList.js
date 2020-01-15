
	var	jobReferralRecordList = {
		pageYn : 'N',
			name: 'jobReferralRecordList',
			dataTables: null,
	
			init: function() {
				this.beforeBind();
				this.bind();
				this.afterBind();
			},
			
			beforeBind: function() {
				var that$ = this;
				
				common.sys.getDatepicker();

				$('#startDate').datepicker('setDate', '-14D');
				$('#endDate').datepicker('setDate', 'today');
				$('button#-14D').addClass('on');
				$("#periodOn").val("-14D");	

				var deferred = $.Deferred();
				var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
				
				if (sessData) {
					$("#Keyword_sel").val(sessData.Keyword_sel);
					$("#keyword").val(sessData.keyword);
					$('#jcList option:selected').val(sessData.jcList)
					$('#referralTypeCd option:selected').val(sessData.referralTypeCd)
					$('#referralStsCd option:selected').val(sessData.referralStsCd)

					$("#startDate").val(sessData.startDate);
					$("#endDate").val(sessData.endDate);
					$('button.btnPeriod').removeClass('on');
						
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					jobReferralRecordList.pageYn = 'Y';
					sessionStorage.clear();
				}				
				
				deferred.resolve();	
				
			},

			bind: function() {
				var that$ = this;
				
				var setColumns = [
					{"data": "rowNum"},
					{"data": "referralTypeNm"},
	            	{"data": "compnyNm"},
		            {"data": "vacancyTitle"},
		            {"data": "jobUserNm"},
		            {"data": "modDt"},
		            {"data": "jcUserNm"},
					{"data": "jcNm"},
					{"data": ""},
		            {"data": "referralStsCd"},
					
					
					{"data": "vacancySeq"},
					{"data": "resumeSeq"},
					{"data": "compnySeq"},
					{"data": "userSeq"},
					{"data": "referralTypeCd"}
			    ];
				
				var orderColumns = setColumns.map(function(x) {return x.data });
				
				that$.dataTables = $('#jobReferralRecord').DataTable({
					pageLength: 10,
	                lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
			        processing: true,
					serverSide: true,
					bStateSave : true,
			        searching: false,
					destroy: true,
					stateSaveCallback: function(settings,data) {
						localStorage.setItem( jobReferralRecordList.name + settings.sInstance, JSON.stringify(data) );
					  },
					stateLoadCallback: function(settings) {
						if (jobReferralRecordList.pageYn == 'Y') {
							return JSON.parse( localStorage.getItem( jobReferralRecordList.name + settings.sInstance ) );
						} else {
							localStorage.clear();
							return JSON.parse( localStorage.getItem( jobReferralRecordList.name + settings.sInstance ) );
						}
					  },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/referral/selectJobReferralRecordListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
								KeywordSel: $('#Keyword_sel').val(),
                        		keyword: $('#keyword').val(),
			                	jcCd: $('#jcList option:selected').val(),
			                	referralTypeCd: $('#referralTypeCd option:selected').val(),
			                	referralStsCd: $('#referralStsCd option:selected').val(),
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
	                    	targets: 2,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"pageActionCompnyInfo(\'' + full.compnySeq + '\');\">' + data + '</a>';
	                        }
						},
						{
	                    	targets: 4,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"pageActionUserInfo(\'' + full.userSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: 8,
	                        render: function ( data, type, full, meta ) {
	                        	var html = "";
								html = "<input type=\"button\" value=\"Manage\" id=\"btnSearch\" class=\"bbs_btn type02 small writing\" onclick=\"popReferralManageLayerBtn('"+ full.vacancySeq +"','"+ full.resumeSeq +"','"+ full.referralTypeCd +"','2');\" />" ;
								
								return html;
	                        }
						},
						{ targets: [10,11,12,13,14], visible: false, searchable: false }
			        ],		        
					order: [[1, 'asc']],
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

	function pageActionCompnyInfo(compnySeq){
		var previousUrl = contextPath + "/internal/referral/vacancyReferralReqList.do";
		$("#frmReferral").find("#previousUrl").val(previousUrl);
		$("#frmReferral").find("#compnySeq").val(compnySeq);
		var sessData = $('#frmReferral').serializeObject();
    	sessionStorage.setItem(jobReferralRecordList.name + "." + jobReferralRecordList.method, JSON.stringify(sessData));
		
		$("#frmReferral").attr("method", "post");
		$("#frmReferral").attr("action", contextPath + "/internal/user/selectUserCmpnyDtlInfoMain.do");
		$("#frmReferral").submit();

	}

	function pageActionUserInfo(userSeq){
		var previousUrl = contextPath + "/internal/referral/jobskReferralReqList.do";
		$("#frmReferral").find("#previousUrl").val(previousUrl);
		$("#frmReferral").find("#userSeq").val(userSeq);
		var sessData = $('#frmReferral').serializeObject();
    	sessionStorage.setItem(jobReferralRecordList.name + "." + jobReferralRecordList.method, JSON.stringify(sessData));
		
		$("#frmReferral").attr("method", "post");
		$("#frmReferral").attr("action", contextPath + "/internal/user/selectUserDtlInfoMain.do");
		$("#frmReferral").submit();

	}

