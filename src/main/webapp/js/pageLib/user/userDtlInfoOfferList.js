
	var userDtlInfoOfferList = {
			pageYn : 'N',
			name: 'userDtlInfoOfferList',
			dataTables: null,
	
		init : function() {
			var that$ = this;
	
			$.when(that$.beforeBind()).done(function(res) {
				that$.bind();
				that$.afterBind();
			});
		},
	
		beforeBind : function() {
			var that$ = this;
			var deferred = $.Deferred();
			
			var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
			
			if (sessData) {
				userDtlInfoOfferList.pageYn = 'Y';
                sessionStorage.clear();
                
            } else {
            	//
            }				
			
			deferred.resolve();	
		},
	
		bind : function() {
			var that$ = this;
	
			var setColumns = [ 
				{"data" : "rowNum"}, 
				{"data" : "compnyNm"}, 
				{"data" : "mngerNm"}, 
				{"data" : "mngerEmail"}, 
				{"data" : "mngerTel"}, 
				{"data" : "resumeTitle"}, 
				{"data" : "offerDt"}, 
				{"data" : "offerOpenYn"}, 
				{"data" : "offerOpenDt"}, 
				{"data" : "aplcYn"},
				{"data" : "userSeq"}, 
				{"data" : "resumeSeq"}, 
				{"data" : "compnySeq"}
				
			];
	
			var orderColumns = setColumns.map(function(x) {
				return x.data
			});
	
			that$.dataTables = $('#myTable').DataTable({
				stateSave : true,
				pageLength : 10,
				lengthMenu : [ [ 10, 20, 30, 50, -1 ],[ 10, 20, 30, 50, "All" ] ],
				processing : true,
				serverSide : true,
				searching : false,
				destroy : true,
		        stateSaveCallback: function(settings,data) {
		            localStorage.setItem( userDtlInfoOfferList.name + settings.sInstance, JSON.stringify(data) );
		          },
		        stateLoadCallback: function(settings) {
		        	if (userDtlInfoOfferList.pageYn == 'Y') {
		        		return JSON.parse( localStorage.getItem( userDtlInfoOfferList.name + settings.sInstance ) );
		        	} else {
		        		localStorage.clear();
		        		return JSON.parse( localStorage.getItem( userDtlInfoOfferList.name + settings.sInstance ) );
		        	}
		          },
				serverMethod : 'post',
				ajax : {
					url : contextPath + "/internal/user/selectUserDtlInfoOfferListSubAjax.do?orderColumns=" + orderColumns,
					dataType : 'json',
					data : function(d) {
						return $.extend({}, d, {
							userSeq : $('#userSeq').val()
						});
					}
				},
				columns : setColumns,
				columnDefs : [
						{
							targets : 5,
							render : function(data, type, full,
									meta) {
								return '<a herf=\"#\" onclick=\"popResumeDtlInfoLayerBtn(\'' + full.resumeSeq + '\');\">' + data + '</a>';
							}
						},
						{
							targets : [10,11,12],
							visible : false,
							searchable : false
						}
				],
				select : {
					style : 'multi'
				},
				order : [ [ 6, 'desc' ] ],
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
	
		afterBind : function() {
			var that$ = this;
		},
	
		fn : {
			pageAction : function() {
			},
			// 게시물 그리기
			drawList : function(dataJson) {
			}
		}
	}