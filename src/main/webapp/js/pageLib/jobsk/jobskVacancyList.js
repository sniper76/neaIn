
	var	jobskVacancyList = {
			pageYn : 'N',
			name: 'jobskVacancyList',
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
	                $("#employFormCd").val(sessData.employFormCd);
	                $('input:radio[name="vacancyStsCd"][value="' + sessData.vacancyStsCd + '"]').prop("checked", true);
	                $('input:radio[name="jcAgreeStsCd"][value="' + sessData.jcAgreeStsCd + '"]').prop("checked", true);
	                $('input:radio[name="urgentVccyCd"][value="' + sessData.urgentVccyCd + '"]').prop("checked", true);
	                $('input:radio[name="preferntCondCd"][value="' + sessData.preferntCondCd + '"]').prop("checked", true);
	                
	                $("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
					
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					jobskVacancyList.pageYn = 'Y';
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
					{"data": "vacancyId"},
		            {"data": "employFormNm"},
		            {"data": "compnyNm"},
		            {"data": "vacancyTitle"},
		            {"data": "vacancyTerm"},
		            {"data": "regDt"},
		            {"data": "jcAgreeStsNm"},
		            {"data": "jcAgreeDt"},
		            {"data": "vacancyStsNm"},
		            {"data": "recrumtMemb"},
		            {"data": "applicCnt"},
		            {"data": "passCnt"},
		            {"data": "jcNm"},
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
			            localStorage.setItem( jobskVacancyList.name + settings.sInstance, JSON.stringify(data) );
			          },
			        stateLoadCallback: function(settings) {
			        	if (jobskVacancyList.pageYn == 'Y') {
			        		return JSON.parse( localStorage.getItem( jobskVacancyList.name + settings.sInstance ) );
			        	} else {
			        		localStorage.clear();
			        		return JSON.parse( localStorage.getItem( jobskVacancyList.name + settings.sInstance ) );
			        	}
			          },
			        serverMethod: 'post',
			        ajax: {
			            url: contextPath +"/internal/jobsk/selectJobskVacancyListAjax.do?orderColumns="+orderColumns
			            , dataType: 'json'
			            //, data: param
			            , data: function ( d ) {
			                return $.extend( {}, d, {
			                	jcCd: $('#jcCd').val(),
			                	srchDivCd: $('#srchDivCd').val(),
			                	srchDivKeyword: $('#srchDivKeyword').val(),
			                	employFormCd: $('#employFormCd').val(),
			                	vacancyStsCd: $('input[name="vacancyStsCd"]:checked').val(),
			                	jcAgreeStsCd: $('input[name="jcAgreeStsCd"]:checked').val(),
			                	urgentVccyCd: $('input[name="urgentVccyCd"]:checked').val(),
			                	preferntCondCd: $('input[name="preferntCondCd"]:checked').val(),
			                	startDate: $('#startDate').val(),
			                	endDate: $('#endDate').val()
			                	
			                } );
			            }
			        },
			        columns: setColumns,
			        columnDefs: [
	                    {
	                    	targets: 4,
	                        render: function ( data, type, full, meta ) {
	                        	return '<a herf=\"#\" onclick=\"jobskVacancyList.fn.pageAction(\'' + full.vacancySeq + '\');\">' + data + '</a>';
	                        }
	                    },
	                    {
	                    	targets: [14, 15],
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
				// Vacancy Detail view
				pageAction : function(vacancySeq) {
					$("#frmJobskVacancyList").find("#vacancySeq").val(vacancySeq);
					var formData = $('#frmJobskVacancyList').serializeObject();
					
					var searchFrm = $('#frmJobskVacancyList').serializeObject();
					sessionStorage.setItem(jobskVacancyList.name + "." + jobskVacancyList.method, JSON.stringify(searchFrm));
					
					
					$("#frmJobskVacancyList").attr("method", "post");
					$("#frmJobskVacancyList").attr("action", contextPath + "/internal/jobsk/selectJobskVacancyDtlInfoAjax.do");
					$("#frmJobskVacancyList").submit();					
				},
				//게시물 그리기
				drawList : function(dataJson) {
				}
			}

	}
