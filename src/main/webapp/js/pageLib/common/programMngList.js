
	var	programMngList = {
			name: 'programMngList',
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
	                sessionStorage.clear();
	            }				
				
				deferred.resolve();	
			},

			bind: function() {
				var that$ = this;
			
				var setColumns = [
					{"data": "rowNum"},
					{"data": "programId"},
					{"data": "programNm"},
					{"data": "programUrl"},
					{"data": "useYn"},
		            {"data": "regNm"},
		            {"data": "regDt"}
			    ];

				var orderColumns = setColumns.map(function(x) { return x.data });
				
				that$.dataTables = $('#myTable').DataTable({
					pageLength: 10,
		            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
				    processing: true,
				    serverSide: true,
				    searching: false,
				    destroy: true,
				    serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/common/selectProgramMngListAjax.do?orderColumns="+orderColumns
			            //, data: param
		            	, data: function ( d ) {
				        	return $.extend( {}, d, {
				        		searchKeyword: $('#searchKeyword option:selected').val(),
				        		searchValue: $.trim($('#searchValue').val()),
				        		rangeCd : $("#rangeCd").val()
				        	} );
				        }
				        , dataType: 'json'
			        },
			        columns: setColumns,
			        columnDefs: [
			        	{ targets: 1, render: function ( data, type, full, meta ) {
        					return "<a href=\"javascript:void(0);\" onclick=\"programMngList.fn.pageAction('" + full.programSeq + "');\">" + data + "</font>" ;
                		}
                    }
			        ],
			        select: { 
				    	style: 'os' ,
				    	selector: 'td:first-child'
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
				var rangeCd = $("#rangeCd").val();
				$("#btnReg").click(function(){
					$("#searchFrm").attr("method", "post");
					if (rangeCd == 'RNG0000000002') {
						$("#searchFrm").attr("action", contextPath + "/internal/common/programMngInternalReg.do");
					} else {
						$("#searchFrm").attr("action", contextPath + "/internal/common/programMngExternalReg.do");
					}
					$("#searchFrm").submit();
				});
				
				//검색버튼
				$('#btnSearch').on('click', function() {
					that$.dataTables.ajax.reload();
				});
				
			},
			fn: {
				pageAction : function(programSeq) {
					var rangeCd = $("#rangeCd").val();
					$("#programSeq").val(programSeq);
					var sessData = $('#searchFrm').serializeObject();
					sessionStorage.setItem(programMngList.name + "." + programMngList.method, JSON.stringify(sessData));

					$("#paramFrm").attr("method", "post");
					
					if (rangeCd == 'RNG0000000002') {
						$("#paramFrm").attr("action", contextPath + "/internal/common/programMngInternalReg.do");
					} else {
						$("#paramFrm").attr("action", contextPath + "/internal/common/programMngExternalReg.do");
					}
					
					$("#paramFrm").submit();
				}
			}

	}
