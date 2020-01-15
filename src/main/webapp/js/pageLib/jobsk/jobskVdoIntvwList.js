
	var	jobskVdoIntvwList = {
			pageYn : 'N',
			name: 'jobskVdoIntvwList',
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
	                $('input:radio[name="jcAgreeStsCd"][value="' + sessData.jcAgreeStsCd + '"]').prop("checked", true);
	                
	                $("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
					
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					jobskVdoIntvwList.pageYn = 'Y';
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
					{"data": "compnyNm"},
	            	{"data": "mngerTel"},
	            	{"data": "compnyJcNm"},
	            	{"data": "userAuthNm"},
	            	{"data": "userNm"},
	            	{"data": "userTel"},
	            	{"data": "userJcNm"},
	            	{"data": "regDt"},
		            {"data": "jcAgreeStsNm"},
		            {"data": "videoIntvwTime"},
		            {"data": "intvwMnger"},
		            {"data": "videoIntvwSeq"},
	            	{"data": "userSeq"},
	            	{"data": "compnySeq"}
	            			            
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
			            localStorage.setItem( jobskVdoIntvwList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (jobskVdoIntvwList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( jobskVdoIntvwList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( jobskVdoIntvwList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/jobsk/selectJobskVdoIntvwListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
			                	srchJcCd:$('#jcCd').val(), 
			                	jcCd: $('#jcCd').val(),
			                	srchDivCd: $('#srchDivCd').val(),
			                	srchDivKeyword: $('#srchDivKeyword').val(),
			                	jcAgreeStsCd: $('input[name="jcAgreeStsCd"]:checked').val(),
			                	startDate: $('#startDate').val(),
			                	endDate: $('#endDate').val()
			                } );
			            }
			        },
			        columns: setColumns,
			        columnDefs: [
			        	{
	                    	targets: 1,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"jobskVdoIntvwList.fn.pageAction(\'' + full.videoIntvwSeq + '\');\">' + data + '</a>';
	                        }
	                    },
			        	{
	                    	targets: [12, 13, 14],
	                        visible: false,
	                        searchable: false
	                    }	                    
	                    			        	
			        ],
			        select: { 
			        	style: 'multi' 
			        },			        
			        order: [[8, 'desc']],
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
				pageAction : function(videoIntvwSeq) {
					$("#frmJobskVdoIntvwList").find("#videoIntvwSeq").val(videoIntvwSeq);
					var formData = $('#frmJobskVdoIntvwList').serializeObject();
					
					var searchFrm = $('#frmJobskVdoIntvwList').serializeObject();
					sessionStorage.setItem(jobskVdoIntvwList.name + "." + jobskVdoIntvwList.method, JSON.stringify(searchFrm));

					
					$("#frmJobskVdoIntvwList").attr("method", "post");
					$("#frmJobskVdoIntvwList").attr("action", contextPath + "/internal/jobsk/selectJobskVdoIntvwDtlInfoAjax.do");
					$("#frmJobskVdoIntvwList").submit();					
				},				
				//게시물 그리기
				drawList : function(dataJson) {
				}
			}

	}
