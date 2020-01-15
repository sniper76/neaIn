	
	var	userCmpnyDtlInfoIntvwList = {
			pageYn : 'N',
			name: 'userCmpnyDtlInfoIntvwList',
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
				
				var thisDate = new Date();
				var thisYear = thisDate.getFullYear();
				$('#vacancyYear').val(thisYear);
				
				var deferred = $.Deferred();
				
				var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
				
				if (sessData) {
					userInfoList.pageYn = 'Y';
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
					{"data": "userNm"},
					{"data": "age"},
					{"data": "genderNm"},
					{"data": "resumeTitle"},
					{"data": "eduDegreeNm"},
					{"data": "totCareerTerm"},
					{"data": "iscoNm"},
	            	{"data": "openYnNm"},
	            	{"data": "intvwTypeNm"},
	            	{"data": "intvwDt"},
	            	{"data": "recruitStsNm"},
	            	{"data": "regDt"},
	            	{"data": "vacancyTitle"},
	            	{"data": "vacancySeq"},
					{"data": "compnySeq"},
					{"data": "resumeSeq"},
					{"data": "userSeq"}
						            	
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
			            localStorage.setItem( userCmpnyDtlInfoIntvwList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (userCmpnyDtlInfoIntvwList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( userCmpnyDtlInfoIntvwList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( userCmpnyDtlInfoIntvwList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/user/selectUserCmpnyDtlInfoIntvwListSubAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
							return $.extend( {}, d, {
								compnySeq: $('#compnySeq').val(),
								vacancySeq: $('#vacancyList').val(),
								vacancyYear: $('#vacancyYear').val(),
								vacancyStsCd: $('input[name="vacancyStsCd"]:checked').val()
							} );
						}
						, dataType: 'json'
			        },
			        columns: setColumns,
			        columnDefs: [
			        	{
	                    	targets: 4,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"popResumeDtlInfoLayerBtn(\'' + full.resumeSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: 13,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"popVacancyDtlInfoLayerBtn(\'' + full.vacancySeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [14, 15, 16, 17],
	                    	visible: false,
	                        searchable: false
	                    }         
	                    
			        ],
			        select: { 
			        	style: 'multi' 
			        },			        
			        order: [[12, 'desc']],
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
				
				//검색버튼
				$('#btnSearch').on('click', function() {
					that$.dataTables.ajax.reload();
				});
				
			},
			
			fn: {
				pageAction : function() {
				},
				//게시물 그리기
				drawList : function(dataJson) {
				}				
			}
	}
	
	
	function getVccyList() {
		
		var vacancyYear = $('#vacancyYear').val();
		if(vacancyYear.length < 4){
			return;
		} else {
			var action = contextPath + "/internal/user/selectUserCmpnyCommonVccyListAjax.do";
			var compnySeq = $('#compnySeq').val();
			var param = {
							compnySeq: compnySeq, 
							vacancyYear: vacancyYear
						};

	        $.ajax({
	            type: "POST",
	            url: action,
	            data: param,                   
	            cache: true,
	            success: function(Data) {
	            	
	            	$("#vacancyList").find("option").remove();
	            	for(var i=0;i<Data.rtnVccyData.length;i++){            		
	            		$("#vacancyList").append("<option value='"+Data.rtnVccyData[i].vacancySeq+"'>"+Data.rtnVccyData[i].vacancyTitle+"</option>");
	            	};    
	            }
	        });	
		}
	}	