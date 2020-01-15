	
	var	userDtlInfoJobsk = {
			pageYn : 'N',
			name: 'userDtlInfoJobsk',
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
					userDtlInfoJobsk.pageYn = 'Y';
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
					{"data": "resumeTitle"},
		            {"data": "urgentJobseekYn"},
		            {"data": "nowWorkYn"},
		            {"data": "regDt"},
		            {"data": "jcAgreeStsNm"},
		            {"data": "jcAgreeDt"},
		            {"data": "jcUserNm"},
		            {"data": "jobskStsNm"},
		            {"data": "jobskReqSeq"},
		            {"data": "resumeSeq"},
	            	{"data": "userSeq"},
	            	{"data": "userId"}
		            
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
			            localStorage.setItem( userDtlInfoJobsk.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (userDtlInfoJobsk.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( userDtlInfoJobsk.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( userDtlInfoJobsk.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/user/selectUserDtlInfoJobskSubAjax.do?orderColumns="+orderColumns
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
	                        	return '<a herf=\"#\" onclick=\"popResumeDtlInfoLayerBtn(\'' + full.resumeSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [9, 10, 11, 12],
	                        visible: false,
	                        searchable: false
	                    }
	                    	                    
			        ],
			        select: { 
			        	style: 'multi' 
			        },			        
			        order: [[4, 'desc']],
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
				
				// resume Detail popup view
				pageAction : function(resumeSeq) {				
				},
				//게시물 그리기
				drawList : function(dataJson) {
				}
			}
	}