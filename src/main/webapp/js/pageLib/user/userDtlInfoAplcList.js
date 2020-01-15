	
	var	userDtlInfoAplcList = {
			pageYn : 'N',
			name: 'userDtlInfoAplcList',
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
					userDtlInfoAplcList.pageYn = 'Y';
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
					{"data": "vacancyId"},
					{"data": "compnyNm"},
					{"data": "vacancyTypeNm"},
					{"data": "vacancyTitle"},
					{"data": "resumeTitle"},
					{"data": "regDt"},
					{"data": "resumeOpenDt"},
					{"data": "aplcStsNm"},
					{"data": "applicProcNm"},
					{"data": "userSeq"},
					{"data": "resumeSeq"},
					{"data": "vacancySeq"},
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
			            localStorage.setItem( userDtlInfoAplcList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (userDtlInfoAplcList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( userDtlInfoAplcList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( userDtlInfoAplcList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/user/selectUserDtlInfoAplcListSubAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
							return $.extend( {}, d, {
								userSeq: $('#userSeq').val()
							} );
						}
						, dataType: 'json'
			        },
			        columns: setColumns,
			        columnDefs: [
			        	{
	                    	targets: 4,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"popVacancyDtlInfoLayerBtn(\'' + full.vacancySeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: 5,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"popResumeDtlInfoLayerBtn(\'' + full.resumeSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [10,11,12,13],
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
				},
				//게시물 그리기
				drawList : function(dataJson) {
				}			
			}
	}