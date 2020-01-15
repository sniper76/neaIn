
	var	menuMngList = {
			name: 'menuMngList',
			dataTables: null,
	
			init: function() {
				
				this.beforeBind();
				this.bind();
				this.afterBind();
							
			},
			
			beforeBind: function() {
				var that$ = this;
				var deferred = $.Deferred();
				var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
				
				if (sessData) {
	                $("#searchKeyword").val(sessData.searchKeyword);
	                $("#searchValue").val(sessData.searchValue);
	                $("#menuLvl").val(sessData.menuLvl);
	                sessionStorage.clear();
	            }				
				
				deferred.resolve();	
			},

			bind: function() {
				var that$ = this;
			
				var setColumns = [
					{"data": "rowNum"},
					{"data": "menuNmKh"},
					{"data": "menuNmEn"},
					{"data": "menuLvl"},
	            	{"data": "menuCd"},
	            	{"data": "upperMenuCd"},
		            {"data": "menuSort"},
		            {"data": "menuUrl"},
		            {"data": "regDt"}
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
				    serverMethod: 'post',
			        ajax: {
			        	url: contextPath +"/internal/common/selectMenuMngListAjax.do?orderColumns="+orderColumns
			            //, data: param
		            	, data: function ( d ) {
				        	return $.extend( {}, d, {
				        		searchKeyword: $('#searchKeyword option:selected').val(),
				        		searchValue: $.trim($('#searchValue').val()),
				        		menuLvl: $.trim($('#menuLvl').val()),
				        		rangeCd : $("#rangeCd").val()
				        	} );
				        }
				        , dataType: 'json'
			        },
			        columns: setColumns,
			        columnDefs: [
			        	{ targets: 1, render: function ( data, type, full, meta ) {
        					return "<a href=\"javascript:void(0);\" onclick=\"menuMngList.fn.pageAction('" + full.menuCd + "');\">" + data + "</font>" ;
                			}
			        	}
			        ],
			        select: { 
				    	style: 'os' ,
				    	selector: 'td:first-child'
				    },
				    order: [[1, 'asc']],
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
				
				$("#btnReg").click(function(){
					$("#menuCd").val("");
					$("#searchFrm").attr("method", "post");
					$("#searchFrm").attr("action", contextPath + "/internal/common/"+menuRegPage+".do");
					$("#searchFrm").submit();
				});
				
				//검색버튼
				$('#btnSearch').on('click', function() {
					that$.dataTables.ajax.reload();
				});
		        
			},
			fn: {
				
				pageAction : function(menuCd) {
					$("#menuCd").val(menuCd);
					var sessData = $('#searchFrm').serializeObject();
					sessionStorage.setItem(menuMngList.name + "." + menuMngList.method, JSON.stringify(sessData));

					$("#searchFrm").attr("method", "post");
					$("#searchFrm").attr("action", contextPath + "/internal/common/"+menuRegPage+".do");
					$("#searchFrm").submit();
				}
			}
	}
