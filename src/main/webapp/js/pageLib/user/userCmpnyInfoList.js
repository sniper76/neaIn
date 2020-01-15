
	var	userCmpnyInfoList = {
			pageYn : 'N',
			name: 'userCmpnyInfoList',
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
	                $("#compnyTypeCd").val(sessData.compnyTypeCd);
	                $("#isicCd").val(sessData.isicCd);
	                $('input:radio[name="userStsCd"][value="' + sessData.userStsCd + '"]').prop("checked", true);
	                
	                $("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
					
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					userCmpnyInfoList.pageYn = 'Y';
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
					{"data": "compnyTypeNm"},
		            {"data": "compnyNm"},
		            {"data": "mngerNm"},
		            {"data": "mngerEmail"},
		            {"data": "mngerCell"},
		            {"data": "userStsNm"},
		            {"data": "regDt"},
		            {"data": "modDt"},
		            {"data": "compnySeq"},
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
			            localStorage.setItem( userCmpnyInfoList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (userCmpnyInfoList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( userCmpnyInfoList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( userCmpnyInfoList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/user/selectUserCmpnyInfoListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
			                	jcCd: $('#jcCd').val(),
			                	srchDivCd: $('#srchDivCd').val(),
			                	srchDivKeyword: $('#srchDivKeyword').val(),
			                	compnyTypeCd: $('#compnyTypeCd').val(),
			                	isicCd: $('#isicCd').val(),
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
	                        	return '<a herf=\"#\" onclick=\"userCmpnyInfoList.fn.pageAction(\'' + full.compnySeq + '\');\">' + data + '</a>';
	                        }
	                    },
			        	{
	                    	targets: [9, 10, 11],
	                        visible: false,
	                        searchable: false
	                    }
			        ],
			        select: { 
			        	style: 'multi' 
			        },			        
			        order: [[7, 'asc']],
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
		        
			},
			fn: {
				
				// User Detail view
				pageAction : function(compnySeq) {
					$("#frmUserCmpnyInfoList").find("#compnySeq").val(compnySeq);
					var previousUrl = window.location.href;
					$("#frmUserCmpnyInfoList").find("#previousUrl").val(previousUrl);
					var formData = $('#frmUserCmpnyInfoList').serializeObject();
					
					var searchFrm = $('#frmUserCmpnyInfoList').serializeObject();
					sessionStorage.setItem(userCmpnyInfoList.name + "." + userCmpnyInfoList.method, JSON.stringify(searchFrm));
					
					$("#frmUserCmpnyInfoList").attr("method", "post");
					$("#frmUserCmpnyInfoList").attr("action", contextPath + "/internal/user/selectUserCmpnyDtlInfoMain.do");
					$("#frmUserCmpnyInfoList").submit();
				},
				//게시물 그리기
				drawList : function(dataJson) {
				}
			}

	}
