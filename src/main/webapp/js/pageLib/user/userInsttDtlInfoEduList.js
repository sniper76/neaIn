	
	var	userInsttDtlInfoEduList = {
			pageYn : 'N',
			name: 'userInsttDtlInfoEduList',
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
					userInsttDtlInfoEduList.pageYn = 'Y';
	                sessionStorage.clear();
	                
	            } else {
	            }				
				
				deferred.resolve();	
			},
			
			bind: function() {
				var that$ = this;
				
				var setColumns = [				
					{"data": "rowNum"},
					{"data": "eduTrnngId"},
					{"data": "eduDivNm"},
					{"data": "eduTrnngNm"},
					{"data": "recurmtTerm"},
					{"data": "regDt"},
					{"data": "eduCloseDt"},
					{"data": "eduTerm"},
					{"data": "eduAddr"},
					{"data": "jcAgreeStsNm"},
					{"data": "bkmkCnt"},
					{"data": "viewCnt"},
					{"data": "insttSeq"},
					{"data": "eduTrnngSeq"}
					
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
			            localStorage.setItem( userInsttDtlInfoEduList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (userInsttDtlInfoEduList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( userInsttDtlInfoEduList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( userInsttDtlInfoEduList.name + settings.sInstance ) );
			        	}
			          },			        
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/user/selectUserInsttDtlInfoEduListSubAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
							return $.extend( {}, d, {
								insttSeq: $('#insttSeq').val()
							} );
						}
			        },
			        columns: setColumns,
			        columnDefs: [
	                    {
	                    	targets: 3,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"popEduTrnngDtlInfoLayerBtn(\'' + full.eduTrnngSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [12, 13],
	                    	visible: false,
	                        searchable: false
	                    }	                    
	                    	                    
			        ],
			        select: { 
			        	style: 'multi' 
			        },			        
			        order: [[5, 'desc']],
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
				},
				//게시물 그리기
				drawList : function(dataJson) {
				}				
			}
	}