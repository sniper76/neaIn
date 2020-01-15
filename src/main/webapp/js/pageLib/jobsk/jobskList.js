
	var	jobskList = {
			pageYn : 'N',
			name: 'jobskList',
			dataTables: null,
	
			init: function() {
				this.beforeBind();
				this.bind();
				this.afterBind();
			},
			
			beforeBind: function() {
				
				common.sys.getDatepicker();
				
				var that$ = this;
				var deferred = $.Deferred();
				
				var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
				
				if (sessData) {
					
					$("#jcCd").val(sessData.jcCd);
					$("#srchDivCd").val(sessData.srchDivCd);
	                $("#srchDivKeyword").val(sessData.srchDivKeyword);
	                $('input:radio[name="userAuthCd"][value="' + sessData.userAuthCd + '"]').prop("checked", true);
	                $("#jobskStsCd").val(sessData.jobskStsCd);
	                $('input:radio[name="genderCd"][value="' + sessData.genderCd + '"]').prop("checked", true);
	                $('input:radio[name="userStsCd"][value="' + sessData.userStsCd + '"]').prop("checked", true);
	                
	                $('input:radio[name="jcAgreeStsCd"][value="' + sessData.jcAgreeStsCd + '"]').prop("checked", true);
	                $('input:radio[name="urgentJobseekYn"][value="' + sessData.urgentJobseekYn + '"]').prop("checked", true);
	                $('input:radio[name="nowWorkYn"][value="' + sessData.nowWorkYn + '"]').prop("checked", true);
	                
	                $("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
					
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					jobskList.pageYn = 'Y';
	                sessionStorage.clear();
	                
	            } else {
	            	$('#startDate').datepicker('setDate', '-14D');
					$('#endDate').datepicker('setDate', 'today');
					$('button#-14D').addClass('on');
					$("#periodOn").val("-14D");
	            }				
				
				deferred.resolve();	

				
			},

			bind: function() {
				var that$ = this;
				
				var setColumns = [
					{"data": "rowNum"},
					{"data": "userAuthNm"},
		            {"data": "userNm"},
		            {"data": "resumeTitle"},
		            {"data": "userEmail"},
		            {"data": "userCell"},
		            {"data": "age"},
		            {"data": "genderNm"},
		            {"data": "jcAgreeStsNm"},
		            {"data": "jobskStsNm"},
		            {"data": "regDt"},
		            {"data": "jcAgreeDt"},
		            {"data": "jobskReqSeq"},
	            	{"data": "userSeq"},
	            	{"data": "userId"},
	            	{"data": "resumeSeq"}
		            
			    ];
				
				var orderColumns = setColumns.map(function(x) {return x.data });
				
				that$.dataTables = $('#myTable').DataTable({
					stateSave : true,
					pageLength: 10,
	                lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
			        processing: true,
			        serverSide: true,
			        searching: false,
			        destroy: true,
			        stateSaveCallback: function(settings,data) {
			            localStorage.setItem( jobskList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (jobskList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( jobskList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( jobskList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/jobsk/selectJobskListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
			                	jcCd: $('#jcCd').val(),
			                	srchDivCd: $('#srchDivCd').val(),
			                	srchDivKeyword: $('#srchDivKeyword').val(),
			                	userAuthCd: $('input[name="userAuthCd"]:checked').val(),
			                	jobskStsCd: $('#jobskStsCd').val(),
			                	genderCd: $('input[name="genderCd"]:checked').val(),
			                	userStsCd: $('input[name="userStsCd"]:checked').val(),
			                	jcAgreeStsCd: $('input[name="jcAgreeStsCd"]:checked').val(),
			                	urgentJobseekYn: $('input[name="urgentJobseekYn"]:checked').val(),
			                	nowWorkYn: $('input[name="nowWorkYn"]:checked').val(),
			                	startDate: $('#startDate').val(),
			                	endDate: $('#endDate').val()
			                	
			                } );
			            }
			        },
			        columns: setColumns,
			        columnDefs: [
	                    {
	                    	targets: 2,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"jobskList.fn.pageUserInfoAction(\'' + full.userSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: 3,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"jobskList.fn.pageJobskDtlInfoAction(\'' + full.jobskReqSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [12, 13, 14, 15],
	                    	visible: false,
	                        searchable: false
	                    }
	                    	                    
			        ],
			        select: { 
			        	style: 'multi' 
			        },			        
			        order: [[10, 'desc']],
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
			        ]			        
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
				// User Detail view
				pageUserInfoAction : function(userSeq) {
					$("#frmJobskList").find("#userSeq").val(userSeq);
					var previousUrl = window.location.href;
					$("#frmJobskList").find("#previousUrl").val(previousUrl);
					var formData = $('#frmJobskList').serializeObject();
					
					var searchFrm = $('#frmJobskList').serializeObject();
					sessionStorage.setItem(jobskList.name + "." + jobskList.method, JSON.stringify(searchFrm));
					
					$("#frmJobskList").attr("method", "post");
					$("#frmJobskList").attr("action", contextPath + "/internal/user/selectUserDtlInfoMain.do");
					$("#frmJobskList").submit();
				},
				pageJobskDtlInfoAction : function(jobskReqSeq) {
					$("#frmJobskList").find("#jobskReqSeq").val(jobskReqSeq);
					var previousUrl = window.location.href;
					$("#frmJobskList").find("#previousUrl").val(previousUrl);
					var formData = $('#frmJobskList').serializeObject();
					
					var searchFrm = $('#frmJobskList').serializeObject();
					sessionStorage.setItem(jobskList.name + "." + jobskList.method, JSON.stringify(searchFrm));
					
					$("#frmJobskList").attr("method", "post");
					$("#frmJobskList").attr("action", contextPath + "/internal/jobsk/selectJobskDtlInfoAjax.do");
					$("#frmJobskList").submit();
				},				
				//게시물 그리기
				drawList : function(dataJson) {
				}
			}

	}
