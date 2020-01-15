var	bulletinThumb = {
    name: 'bulletinThumb',
    
    dataTables: null,
    getRowData:[],
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

    },

    
    bind: function() {
        var that$ = this;

        var setColumns = [
            {"data": "bulletinSeq"},
            {"data": "fileGrpSeq"},
            {"data": "title"},
            {"data": "viewYn"},
            {"data": "fileCnt"}, 
            {"data": "userNm"}, 
            {"data": "likeCnt"}, 
            {"data": "viewCnt"},
            {"data": "regDt"},
            
            {"data": "bulletinMngSeq"},
            {"data": "programId"},
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#bulletinThumbTable').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            serverSide: true,
            searching: false,
            destroy: true,
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/info/selectBulletinListAjax.do?orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        KeywordSel: $('#Keyword_sel').val(),
                        keyword: $('#keyword').val(),
                        viewYn: $('#viewYn').val(),
		        		startDate: $('#startDate').val(),
		        		endDate: $('#endDate').val(),
                        bulletinTypeCd: $('#bulletinTypeCd').val(),
                        programId: $('#programId').val()
                    } );
                }
        		, dataSrc: function(res) {
        			that$.getRowData = res.aaData;
        			return res.aaData;
        		}
            },
            columns : setColumns,
            columnDefs: [
                { targets: 0, checkboxes: { selectRow: true },className: 'select-checkbox' ,orderable: false },
                { targets: 1, render: function ( data, type, full, meta ) {
	                    return html = "<img src=\""+ contextPath + "/images/noimg.png\">" ;
	                }
	            },
                { targets: 2, render: function ( data, type, full, meta ) {
                    
                        var html = "";

                        if(full.ntcYn == "Y"){
                            html = "<img src=\""+ contextPath + "/images/icon_info.png\"><a href=\"javascript:void(0);\" onclick=\"bulletinThumb.fn.pageAction('" + full.bulletinSeq + "');\">" + data + "</font>" ;
                        }else{
                            html = "<a href=\"javascript:void(0);\" onclick=\"bulletinThumb.fn.pageAction('" + full.bulletinSeq + "');\">" + data + "</font>" ;
                        }
                        return html;
                    }
                },
                { targets: [9, 10], visible: false, searchable: false },
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
        
        $('#btnSearch').click(function() {
            that$.dataTables.ajax.reload();
        });
     
        $('#btnRegist').click(function() {
            that$.fn.pageAction('');
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
				url : contextPath + '/internal/info/selectBulletinNotiCntAjax.do',
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
				url : contextPath + '/internal/info/updateBulletinArrayAjax.do',
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
    	    	
    	pageAction : function (bulletinSeq){
    	   
    	    $("#frmBulletinThumb").find("#bulletinSeq").val(bulletinSeq);
    	    var formData = $('form').serializeObject();
    	    sessionStorage.setItem("bulletinSeq", JSON.stringify(formData));

    	    var currUrl = document.location.href;
        	var urlMethod = "";
        	
    	    if (currUrl.indexOf('bulletinManual') !=  -1) {
    	    	urlMethod = 'bulletinManual';
    	    } else if (currUrl.indexOf('bulletinFaq') !=  -1) {
    	    	urlMethod = 'bulletinFaq';
    	    } else if (currUrl.indexOf('bulletinAncmt') !=  -1) {
    	    	urlMethod = 'bulletinAncmt';
    	    } else if (currUrl.indexOf('bulletinNews') !=  -1) {
    	    	urlMethod = 'bulletinNews';
    	    }
    	    
			var urlParam = bulletinSeq != '' ? urlMethod + 'Mod' : urlMethod + 'Reg' ;
    	    
    	    $("#frmBulletinThumb").attr("method", "post");
    	    $("#frmBulletinThumb").attr("action", contextPath + "/internal/info/" + urlParam + ".do");
    	    $("#frmBulletinThumb").submit();
    	},

    	commCdLang : function (obj){
    	    return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
    	},        
    } 
}
