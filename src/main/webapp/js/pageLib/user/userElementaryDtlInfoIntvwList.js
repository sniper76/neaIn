	
	var	userElementaryDtlInfoIntvwList = {
			pageYn : 'N',
			name: 'userElementaryDtlInfoIntvwList',
			dataTables: null,
			
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
				
				var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
				
				if (sessData) {
					userElementaryDtlInfoIntvwList.pageYn = 'Y';
	                sessionStorage.clear();
	                
	            } else {
	            	//
	            }				
				
				deferred.resolve();	

			},
			
			bind: function() {
				var that$ = this;
				
				var setColumns = [				
					{"data": "rowNum"},
					{"data": "intvwDt"},
					{"data": "compnyNm"},
					{"data": "intvwAddr"},
					{"data": "jcNm"},
					{"data": "regUserNm"},
					{"data": "regDt"},
					{"data": "intvwHisSeq"},
					{"data": "userSeq"},
					{"data": "resumeSeq"},
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
			            localStorage.setItem( userElementaryDtlInfoIntvwList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (userElementaryDtlInfoIntvwList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( userElementaryDtlInfoIntvwList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( userElementaryDtlInfoIntvwList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/user/selectUserElementaryDtlInfoIntvwListSubAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
							return $.extend( {}, d, {
								userSeq: $('#userSeq').val()
							} );
						}
			        },
			        columns: setColumns,
			        columnDefs: [                   
	                    {
	                    	targets: 1,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"fnUserElementaryDtlInfoIntvwForModify(\'' + full.intvwHisSeq + '\',\'' + full.userSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [7, 8, 9, 10],
	                    	visible: false,
	                        searchable: false
	                    }	                    
	                    	                    
			        ],
			        select: { 
			        	style: 'multi' 
			        },			        
			        order: [[6, 'desc']],
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
			},
			
			fn: {
				pageAction : function() {
					/*
					$("#frmUserElementaryDtlInfoIntvw").find("#intvwHisSeq").val(intvwHisSeq);
					$("#frmUserElementaryDtlInfoIntvw").find("#userSeq").val(userSeq);
					var formData = $('#frmUserElementaryDtlInfoIntvw').serializeObject();
					sessionStorage.setItem("userElementaryDtlInfoIntvw", JSON.stringify(formData));
					
					$("#frmUserElementaryDtlInfoIntvw").attr("method", "post");
					$("#frmUserElementaryDtlInfoIntvw").attr("action", contextPath + "/internal/user/selectUserElementaryDtlInfoIntvwModifyAjax.do");
					$("#frmUserElementaryDtlInfoIntvw").submit();
					*/					
				},
				//게시물 그리기
				drawList : function(dataJson) {
				}				
			}
	}
	
	/*
	function fnUserIntvwHisReg(){
		var formData = $('#frmUserElementaryDtlInfoIntvw').serializeObject();
		sessionStorage.setItem("UserElementaryDtlInfoIntvw", JSON.stringify(formData));

		$("#frmUserElementaryDtlInfoIntvw").attr("method", "post");
		$("#frmUserElementaryDtlInfoIntvw").attr("action", contextPath + "/internal/user/selectUserElementaryDtlInfoIntvwRegAjax.do");
		$("#frmUserElementaryDtlInfoIntvw").submit();		
	}
	*/
	