
	var	jobskReferralReqList = {
		pageYn : 'N',
			name: 'jobskReferralReqList',
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
					$('#userAuthCd option:selected').val(sessData.userAuthCd);
					$("#emplm_sts").val(sessData.emplm_sts);

					$("#startDate").val(sessData.startDate);
					$("#endDate").val(sessData.endDate);
					$('button.btnPeriod').removeClass('on');
						
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					jobskReferralReqList.pageYn = 'Y';
					sessionStorage.clear();
				}				
				
				deferred.resolve();	
				
			},

			bind: function() {
				var that$ = this;
				
				var setColumns = [
					{"data": "rowNum"},
					{"data": "userAuthCd"},
	            	{"data": "userNm"},
		            {"data": "resumeTitle"},
		            {"data": "nowWorkSts"},
		            {"data": "cell"},
		            {"data": "emailAddr"},
		            {"data": "modDt"},
					{"data": "jcNm"},
					{"data": ""},
		            {"data": "jobskStsCd"},
					
					
					{"data": "resumeSeq"},
					{"data": "jobskReqSeq"},
					{"data": "userSeq"}
			    ];
				
				var orderColumns = setColumns.map(function(x) {return x.data });
				
				that$.dataTables = $('#jobskReferral').DataTable({
					pageLength: 10,
	                lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
			        processing: true,
					serverSide: true,
					bStateSave : true,
			        searching: false,
					destroy: true,
					stateSaveCallback: function(settings,data) {
						localStorage.setItem( jobskReferralReqList.name + settings.sInstance, JSON.stringify(data) );
					  },
					stateLoadCallback: function(settings) {
						if (jobskReferralReqList.pageYn == 'Y') {
							return JSON.parse( localStorage.getItem( jobskReferralReqList.name + settings.sInstance ) );
						} else {
							localStorage.clear();
							return JSON.parse( localStorage.getItem( jobskReferralReqList.name + settings.sInstance ) );
						}
					  },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/referral/selectJobskReferralReqListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
								KeywordSel: $('#Keyword_sel').val(),
                        		keyword: $('#keyword').val(),
			                	jcCd: $('#jcList option:selected').val(),
			                	userAuthCd: $('#userAuthCd option:selected').val(),
			                	nowWorkSts: $('#emplm_sts').val(),
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
	                        	return '<a herf=\"#\" onclick=\"pageActionUserInfo(\'' + full.userSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: 9,
	                        render: function ( data, type, full, meta ) {
	                        	var html = "";
								html = "<input type=\"button\" value=\"Matching\" id=\"btnSearch\" class=\"bbs_btn type02 small writing\" onclick=\"referralMatchConf('"+ full.jobskReqSeq +"','"+ full.resumeSeq +"');\" />" ;
								
								return html;
	                        }
						},
						{ targets: [11,12,13], visible: false, searchable: false }
			        ],		        
					order: [[1, 'asc']],
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

	function pageActionUserInfo(userSeq){
		var previousUrl = contextPath + "/internal/referral/jobskReferralReqList.do";
		$("#frmParam").find("#previousUrl").val(previousUrl);
		$("#frmParam").find("#userSeq").val(userSeq);
		var sessData = $('#frmParam').serializeObject();
    	sessionStorage.setItem(jobskReferralReqList.name + "." + jobskReferralReqList.method, JSON.stringify(sessData));
		
		$("#frmParam").attr("method", "post");
		$("#frmParam").attr("action", contextPath + "/internal/user/selectUserDtlInfoMain.do");
		$("#frmParam").submit();

	}

	function referralMatchConf(jobskReqSeq,resumeSeq){
		$("#frmParam").find("#resumeSeq").val(resumeSeq);
		var sessData = $('#frmParam').serializeObject();
    	sessionStorage.setItem(jobskReferralReqList.name + "." + jobskReferralReqList.method, JSON.stringify(sessData));
		
		$("#frmParam").attr("method", "post");
		$("#frmParam").attr("action", contextPath + "/internal/referral/jobReferralMatchList.do");
		$("#frmParam").submit();
	}

