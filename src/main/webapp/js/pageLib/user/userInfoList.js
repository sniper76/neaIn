
	var	userInfoList = {
			pageYn : 'N',
			name: 'userInfoList',
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
	                $('input:radio[name="userAuthCd"][value="' + sessData.userAuthCd + '"]').prop("checked", true);
	                $("#jobskStsCd").val(sessData.jobskStsCd);
	                $('input:radio[name="genderCd"][value="' + sessData.genderCd + '"]').prop("checked", true);
	                $('input:radio[name="userStsCd"][value="' + sessData.userStsCd + '"]').prop("checked", true);
	                $("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					userInfoList.pageYn = 'Y';
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
					{"data": "userAuthNm"},
	            	{"data": "userNm"},
		            {"data": "userEmail"},
		            {"data": "userCell"},
		            {"data": "age"},
		            {"data": "genderNm"},
		            {"data": "jobskStsNm"},
		            {"data": "userStsNm"},
		            {"data": "regDt"},
		            {"data": "modDt"},
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
			            localStorage.setItem( userInfoList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (userInfoList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( userInfoList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( userInfoList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/user/selectUserInfoListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            , data: function ( d ) {
			                return $.extend( {}, d, {
			                	jcCd: $('#jcCd').val(),
			                	srchDivCd: $('#srchDivCd').val(),
			                	srchDivKeyword: $('#srchDivKeyword').val(),
			                	userAuthCd: $('input[name="userAuthCd"]:checked').val(),
			                	jobskStsCd: $('#jobskStsCd').val(),
			                	genderCd: $('input[name="genderCd"]:checked').val(),
			                	userStsCd: $('input[name="userStsCd"]:checked').val(),
			                	startDate: $('#startDate').val(),
			                	endDate: $('#endDate').val()
			                } );
			            }
			        },
			        columns: setColumns,
			        columnDefs: [
			        	{
	                    	targets: 2,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"userInfoList.fn.pageAction(\'' + full.userSeq + '\');\">' + data + '</a>';
	                        }
	                    },
			        	{
	                    	targets: [11, 12],
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
				
				$('button.btnPeriod').on('click', function() {
					$('button.btnPeriod').removeClass('on');
					$('button#'+$(this).attr('id')).addClass('on');
					$('#startDate').datepicker('setDate', $(this).attr('id'));
					$('#endDate').datepicker('setDate', 'today');
					$('#periodOn').val($(this).attr('id'));
				});
				
				// Search Button
	            $('#btnSearch').on('click', function(e) {
		            that$.dataTables.ajax.reload();
		        });
	            
	            $('#btnUsrReg').on('click', function(e) {
	                location.href="/internal/user/userDtlInfoReg.do";

	            });
		        
			},
			fn: {
				// User Detail view
				pageAction : function(userSeq) {
					
					$("#frmUserInfoList").find("#userSeq").val(userSeq);
					var previousUrl = window.location.href;
					$("#frmUserInfoList").find("#previousUrl").val(previousUrl);
					var formData = $('#frmUserInfoList').serializeObject();
					
					var searchFrm = $('#frmUserInfoList').serializeObject();
					
					sessionStorage.setItem(userInfoList.name + "." + userInfoList.method, JSON.stringify(searchFrm));
					
					$("#frmUserInfoList").attr("method", "post");
					$("#frmUserInfoList").attr("action", contextPath + "/internal/user/selectUserDtlInfoMain.do");
					$("#frmUserInfoList").submit();
				},
				//게시물 그리기
				drawList : function(dataJson) {
				}
			}

	}
