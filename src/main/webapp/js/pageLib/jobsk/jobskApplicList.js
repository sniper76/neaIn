
	var	jobskApplicList = {
			pageYn : 'N',
			name: 'jobskApplicList',
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
	                $('input:radio[name="genderCd"][value="' + sessData.genderCd + '"]').prop("checked", true);
	                $("#employFormCd").val(sessData.employFormCd);
	                $("#preferntCondCdDisabled").val(sessData.preferntCondCdDisabled);
	                $("#preferntCondCdRtnLabor").val(sessData.preferntCondCdRtnLabor);
	                $("#preferntCondCdYouth").val(sessData.preferntCondCdYouth);
	                $('input:radio[name="resumeOpenYn"][value="' + sessData.resumeOpenYn + '"]').prop("checked", true);
	                $("#applicTypeCd").val(sessData.applicTypeCd);

	                $("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
					
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					jobskApplicList.pageYn = 'Y';
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
		            {"data": "resumeTitle"},
		            {"data": "userEmail"},
		            {"data": "age"},
		            {"data": "employFormNm"},
		            {"data": "vacancyTitle"},
		            {"data": "compnyNm"},
		            {"data": "mngerTel"},
		            {"data": "mngerEmail"},
		            {"data": "regDt"},
		            {"data": "resumeOpenDt"},
		            {"data": "emailNtceYn"},
		            {"data": "referralYn"},
		            {"data": "applicTypeNm"},
		            {"data": "userSeq"},
					{"data": "resumeSeq"},
	            	{"data": "vacancySeq"}
	            			            
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
			            localStorage.setItem( jobskApplicList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (jobskApplicList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( jobskApplicList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( jobskApplicList.name + settings.sInstance ) );
			        	}
			          },			        
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/jobsk/selectJobskApplicListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
			                	jcCd: $('#jcCd').val(),
			                	srchDivCd: $('#srchDivCd').val(),
			                	srchDivKeyword: $('#srchDivKeyword').val(),
			                	userAuthCd: $('#userAuthCd').val(),
			                	genderCd: $('input[name="genderCd"]:checked').val(),
			                	employFormCd: $('#employFormCd').val(),
			                	preferntCondCdDisabled: $('#preferntCondCdDisabled').val(),
			                	preferntCondCdRtnLabor: $('#preferntCondCdRtnLabor').val(),
			                	preferntCondCdYouth: $('#preferntCondCdYouth').val(),
			                	resumeOpenYn: $('input[name="resumeOpenYn"]:checked').val(),
			                	applicTypeCd: $('#applicTypeCd').val(),
			                	referralYn: $('input[name="referralYn"]:checked').val(),
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
	                        	return '<a herf=\"#\" onclick=\"jobskApplicList.fn.pageUserInfoAction(\'' + full.userSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: 3,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"popResumeDtlInfoLayerBtn(\'' + full.resumeSeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: 7,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"popVacancyDtlInfoLayerBtn(\'' + full.vacancySeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [16, 17, 18],
	                    	visible: false,
	                        searchable: false
	                    }	                    
	                    	                    
			        ],
			        select: { 
			        	style: 'multi' 
			        },			        
			        order: [[11, 'desc']],
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
	            	
					if($("input:checkbox[name=preferntCondCd_0]").is(":checked") == true) {
						$('#preferntCondCdDisabled').val($('input[name="preferntCondCd_0"]:checked').val());
					}
					
					if($("input:checkbox[name=preferntCondCd_1]").is(":checked") == true) {
						$('#preferntCondCdRtnLabor').val($('input[name="preferntCondCd_1"]:checked').val());
					}
					
					if($("input:checkbox[name=preferntCondCd_2]").is(":checked") == true) {
						$('#preferntCondCdYouth').val($('input[name="preferntCondCd_2"]:checked').val());
					}
					
					/*
					alert($('#preferntCondCdDisabled').val());
					alert($('#preferntCondCdRtnLabor').val());
					alert($('#preferntCondCdYouth').val());
					*/
		            that$.dataTables.ajax.reload();
		        });
	            
			},
			fn: {
				pageUserInfoAction : function(userSeq) {
					$("#frmJobskApplicList").find("#userSeq").val(userSeq);
					var previousUrl = window.location.href;
					$("#frmJobskApplicList").find("#previousUrl").val(previousUrl);
					var formData = $('#frmJobskApplicList').serializeObject();
					
					var searchFrm = $('#frmJobskApplicList').serializeObject();
					sessionStorage.setItem(jobskApplicList.name + "." + jobskApplicList.method, JSON.stringify(searchFrm));
					
					$("#frmJobskApplicList").attr("method", "post");
					$("#frmJobskApplicList").attr("action", contextPath + "/internal/user/selectUserDtlInfoMain.do");
					$("#frmJobskApplicList").submit();
				},			
				//게시물 그리기
				drawList : function(dataJson) {
				}
			}

	}
