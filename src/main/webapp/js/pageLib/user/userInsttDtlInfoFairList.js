	
	var	userInsttDtlInfoFairList = {
			pageYn : 'N',
			name: 'userInsttDtlInfoFairList',
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
					userInsttDtlInfoFairList.pageYn = 'Y';
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
					{"data": "fairDivNm"},
					{"data": "fairNm"},
					{"data": "fairLoc"},
					{"data": "jcNm"},
					{"data": "recurmtTerm"},
					{"data": "fairTerm"},
					{"data": "fairStsNm"},
					{"data": "jcAgreeStsNm"},
					{"data": "regDt"},
					{"data": "insttSeq"},
					{"data": "fairSeq"}
					
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
			            localStorage.setItem( userInsttDtlInfoFairList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (userInsttDtlInfoFairList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( userInsttDtlInfoFairList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( userInsttDtlInfoFairList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/user/selectUserInsttDtlInfoJobfairSubAjax.do?orderColumns="+orderColumns
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
	                    	targets: 2,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"popJobFairDtlInfoLayerBtn(\'' + full.fairSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [10, 11],
	                    	visible: false,
	                        searchable: false
	                    }		                    
	                    	                    
			        ],
			        select: { 
			        	style: 'multi' 
			        },			        
			        order: [[9, 'desc']],
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