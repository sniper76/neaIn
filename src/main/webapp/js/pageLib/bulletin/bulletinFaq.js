var	bulletinBasicList = {
    pageYn : 'N',
    name: 'bulletinBasicList',
    dataTables: null,
    
    init: function() {
        this.beforeBind();
        this.bind();
        this.afterBind();
        
    },
    
    beforeBind: function() {
        var that$ = this;

        common.sys.getDatepicker();
        
        $('#startDate').datepicker('setDate', '-14D');
        $('#endDate').datepicker('setDate', 'today');
        $('button#-14D').addClass('on');
        $("#periodOn").val("-14D");

        var deferred = $.Deferred();
        var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
        
        if (sessData) {
            $("#searchKeyword").val(sessData.searchKeyword);
            $("#searchValue").val(sessData.searchValue);
            $("#viewYn").val(sessData.viewYn);

            $("#startDate").val(sessData.startDate);
            $("#endDate").val(sessData.endDate);
            $('button.btnPeriod').removeClass('on');
				
            if (sessData.periodOn != "") {
                $("#periodOn").val(sessData.periodOn);
                $('button#'+sessData.periodOn).addClass('on');
            }
            bulletinBasicList.pageYn = 'Y';
            sessionStorage.clear();
        }				
        
        deferred.resolve();	
    },

    
    bind: function() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "bulletinSeq"},
            {"data": "title"},
            {"data": "viewYn"},
            {"data": "fileCnt"}, 
            {"data": "userNm"}, 
            {"data": "likeCnt"}, 
            {"data": "viewCnt"},
            {"data": "regDt"},
            {"data": "ntcYn"},

            {"data": "bulletinMngSeq"},
            {"data": "programId"},
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#bulletinBasic').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            bStateSave : true,
            serverSide: true,
            searching: false,
            destroy: true,
            stateSaveCallback: function(settings,data) {
                localStorage.setItem( bulletinBasicList.name + settings.sInstance, JSON.stringify(data) );
              },
            stateLoadCallback: function(settings) {
                if (bulletinBasicList.pageYn == 'Y') {
                    return JSON.parse( localStorage.getItem( bulletinBasicList.name + settings.sInstance ) );
                } else {
                    localStorage.clear();
                    return JSON.parse( localStorage.getItem( bulletinBasicList.name + settings.sInstance ) );
                }
              },
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/bulletin/selectBulletinBasicListAjax.do?pg="+$("#programId").val()+"&orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        
                        KeywordSel: $('#Keyword_sel').val(),
                        keyword: $('#keyword').val(),
                        viewYn: $('#viewYn').val(),
                        startDate: $('#startDate').val(),
		        		endDate: $('#endDate').val(),
                        bulletinTypeCd: $('#bulletinTypeCd').val(),
                        programId: $('#programId').val(),
                        lang: lang
                    } );
                }
                , dataSrc: function(res) {
        			that$.getRowData = res.aaData;
        			return res.aaData;
        		}

            },
            columns : setColumns,
            order: [[7, 'desc']],
            columnDefs: [
                { targets: 1, render: function ( data, type, full, meta ) {
                    
                        var html = "";

                        if(full.ntcYn == "Y"){
                            html = "<button type=\"button\" class=\"bbs_btn type02 small writing\">Notice</button><a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.bulletinSeq + "');\">" + data + "</font>" ;
                        }else{
                            html = "<a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.bulletinSeq + "');\">" + data + "</font>" ;
                        }
                        return html;
                    }
                },
                { targets: [0, 9, 10], visible: false, searchable: false },
            ],
            order: [[7, 'desc']],
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
		    ],
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
		
        $('#btnNotiAdd').on('click', function(e) {
			var rows = that$.fn.getDataTableRowSelected( that$.dataTables );
			if ( !rows.length || rows.length > 5 ) {
				alertify.alert('checkbox check : min > 0, max < 6 !!');
				
			} else {
				$('#btnNotiAdd').attr('disabled', true);
				$('#btnNotiRm').attr('disabled', true);

				var data = (that$.getRowData).find(function(x) { return x.bulletinSeq == rows[0] ; });
				$.when( that$.fn.selectNotiCntAction( { programId: data.programId } ) ).done(function( result ) {
					if (parseInt(result.notiCnt) + rows.length > 5) {
						alertify.alert('check box cheched num(' + rows.length + ') + aleady notice num(' + result.notiCnt + ') > 5 !!' , function(e) {
							if (e) {
								$('#btnNotiAdd').attr('disabled', false);
								$('#btnNotiRm').attr('disabled', false);
								return false;
							}
						});						
					} else {
		                alertify.confirm("do you Save?", function (ex) {
		                    if (ex) {
								var params = {
										traditional:true,
										data: {
											bulletinSeqList: rows,
											ntcYn: 'Y'
										}
									};
								$.when( that$.fn.updateAction( params ) ).done(function( result ) {
									alertify.alert("저장 성공", function (e) {
										if(e) {
											$('#btnNotiAdd').attr('disabled', false);
											$('#btnNotiRm').attr('disabled', false);
											that$.dataTables.ajax.reload();
										}
									});							
								}).fail(function(result) {
									$('#btnNotiAdd').attr('disabled', false);
									$('#btnNotiRm').attr('disabled', false);
									alertify.alert(result);
									return;
								});
		                    } else {
		                        return;
		                    }
		                });
					}
				}).fail(function(result) {
					alertify.alert(result);
					return;
				});     
			}
        });
            
        $('#btnNotiRm').on('click', function(e) {
			var rows = that$.fn.getDataTableRowSelected( that$.dataTables );
			if ( !rows.length ) {
				alertify.alert('checkbox check : min > 0, max < 6 !!');
				
			} else {
				$('#btnNotiAdd').attr('disabled', true);
				$('#btnNotiRm').attr('disabled', true);
			
                alertify.confirm("do you Save?", function (ex) {
                    if (ex) {
						var params = {
								traditional:true,
								data: {
									bulletinSeqList: rows,
									ntcYn: 'N'
								}
							};
						$.when( that$.fn.updateAction( params ) ).done(function( result ) {
							alertify.alert("저장 성공", function (e) {
								if(e) {
									$('#btnNotiAdd').attr('disabled', false);
									$('#btnNotiRm').attr('disabled', false);
									that$.dataTables.ajax.reload();
								}
							});							
						}).fail(function(result) {
							$('#btnNotiAdd').attr('disabled', false);
							$('#btnNotiRm').attr('disabled', false);
							alertify.alert(result);
							return;
						});
                    } else {
                        return;
                    }
                });				
			}        	
        });
            
        
        //console.log(that$.dataTables);
			
        //검색버튼
        $('#btnSearch').click(function() {
            //$('#searchInsttNm').val( '33' );
            that$.dataTables.ajax.reload();
        });
     
    },
    
    fn: {
        getDataTableRowSelected: function( dataTables ) {
            return (dataTables.column(0).checkboxes.selected()).toArray();
      },
      
      selectNotiCntAction: function( param ) {
            var deferred = $.Deferred();
            var options = {
                method : 'post',
                url : contextPath + '/internal/bulletin/selectBulletinNotiCntAjax.do?pg='+$("#programId").val(),
                data: param,
                dataType : 'json',
            };

            $.ajax(options).done(function(result, status, responseObj) {
                deferred.resolve(result);
            }).fail(function(result, status, responseObj) {
                deferred.reject(status);
            });

            return deferred.promise();
       },
      updateAction: function(params) {
        var deferred = $.Deferred();
        var options = {
            method : 'post',
            url : contextPath + '/internal/bulletin/updateBulletinNotiAjax.do?pg='+$("#programId").val(),
            data: params.data,
            traditional: params.traditional,
            dataType : 'json',
        };

        $.ajax(options).done(function(result, status, responseObj) {
            console.log(result);
            
            var sucCode = result.stat;
            if(sucCode == "0000"){
                deferred.resolve("Save Complete");
            }else{
                deferred.reject("Save failed");
            }		    	
        }).fail(function(result, status, responseObj) {
            deferred.reject(status);
        });
        
        return deferred.promise();
    },
        
    } 
}

function insertBulletin(){
    var sessData = $('#frm').serializeObject();
    sessionStorage.setItem(bulletinBasicList.name + "." + bulletinBasicList.method, JSON.stringify(sessData));
    $("#frm").attr("method", "post");
    $("#frm").attr("action", contextPath + "/internal/bulletin/bulletinFaqReg.do?pg="+$("#programId").val());
    $("#frm").submit();
    
}


function pageAction(bulletinSeq){
   
    $("#frm").find("#bulletinSeq").val(bulletinSeq);
    var sessData = $('#frm').serializeObject();
    sessionStorage.setItem(bulletinBasicList.name + "." + bulletinBasicList.method, JSON.stringify(sessData));

    $("#frm").attr("method", "post");
    $("#frm").attr("action", contextPath + "/internal/bulletin/bulletinFaqDtl.do?pg="+$("#programId").val());
    $("#frm").submit();
}

function commCdLang(obj){
    return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
}