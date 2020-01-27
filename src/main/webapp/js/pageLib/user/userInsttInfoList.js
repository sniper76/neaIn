
	var	userInsttInfoList = {
			pageYn : 'N',
			name: 'userInsttInfoList',
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
	                $('input:radio[name="insttOwnerCd"][value="' + sessData.insttOwnerCd + '"]').prop("checked", true);
	                $("#insttTypeCd").val(sessData.insttTypeCd);
	                $('input:radio[name="userStsCd"][value="' + sessData.userStsCd + '"]').prop("checked", true);
	                
	                $("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
					
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					userInsttInfoList.pageYn = 'Y';
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
					{"data": "insttOwnershipNm"},
		            {"data": "insttTypeNm"},
		            {"data": "insttNm"},
		            {"data": "insttMngerNm"},
		            {"data": "insttEmail"},
		            {"data": "insttCell"},
		            {"data": "userStsNm"},
		            {"data": "regDt"},
		            {"data": "modDt"},
		            {"data": "insttSeq"},
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
			            localStorage.setItem( userInsttInfoList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (userInsttInfoList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( userInsttInfoList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( userInsttInfoList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/user/selectUserInsttInfoListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
			                	jcCd: $('#jcCd').val(),
			                	srchDivCd: $('#srchDivCd').val(),
			                	srchDivKeyword: $('#srchDivKeyword').val(),
			                	insttOwnerCd: $('input[name="insttOwnerCd"]:checked').val(),
			                	insttTypeCd: $('#insttTypeCd').val(),
			                	userStsCd: $('input[name="userStsCd"]:checked').val(),
			                	startDate: $('#startDate').val(),
			                	endDate: $('#endDate').val()
			                	
			                } );
			            }
			        },
			        columns: setColumns,
			        columnDefs: [
	                    {
	                    	targets: 3,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"userInsttInfoList.fn.pageAction(\'' + full.insttSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [10,11,12],
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
	            
				$('#btnSearch').on('click', function(e) {
		            that$.dataTables.ajax.reload();
		        });
	            	        
			},
			fn: {
				// User Detail view
				pageAction : function(insttSeq) {
					
					$("#frmUserInsttInfoList").find("#insttSeq").val(insttSeq);
					var previousUrl = window.location.href;
					$("#frmUserInsttInfoList").find("#previousUrl").val(previousUrl);
					var formData = $('#frmUserInsttInfoList').serializeObject();
					
					var searchFrm = $('#frmUserInsttInfoList').serializeObject();
					sessionStorage.setItem(userInsttInfoList.name + "." + userInsttInfoList.method, JSON.stringify(searchFrm));
					
					$("#frmUserInsttInfoList").attr("method", "post");
					$("#frmUserInsttInfoList").attr("action", contextPath + "/internal/user/selectUserInsttDtlInfoMainAjax.do");
					$("#frmUserInsttInfoList").submit();
				},
				//게시물 그리기
				drawList : function(dataJson) {
				}
			}

	}
