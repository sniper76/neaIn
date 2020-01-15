var	bulletinBasicMod = {
    name: 'bulletinBasicMod',
    dataTables: null,
    uploader1: null,
    uploader1Data: [],
    uploadHasData: [],
    init: function() {
    	var that$ = this;
    	
    	$.when( that$.beforeBind() ).done(function ( res ) {
    		that$.bind();
    		that$.afterBind();
    	});
    },
    
    beforeBind: function() {
        var that$ = this;
		var deferred = $.Deferred();

        common.sys.getDatepicker();

        that$.uploader1 = new dndAjaxUploader('info', $('#programId').val());
        
        var fileGrpSeq = $('#fileGrpSeq').val();
        $.when( that$.uploader1.selectSaveFileList( fileGrpSeq ) ).done(function( result ) {
        	that$.uploadHasData = result;
        	result.forEach(function(item) {        		
        		that$.uploader1.status = new that$.uploader1.createStatusbar($("#dragandrophandler"));
        		that$.uploader1.status.setHasClass();
        		that$.uploader1.status.setFileNameSize(item.originalNm, item.fileSize, item.fileSeq);
        		that$.uploader1.status.setProgress(100);
        	});
        	that$.fn.initDndMsg( $("#dragandrophandler") );
        	deferred.resolve("success before bind !!");
        });
        
        return deferred.promise();
    },

    
    bind: function() {
        var that$ = this;
    },
    
    afterBind: function() {
        var that$ = this;
        $('#btnList').on('click', function(e) {
    		that$.fn.pageAction();
        });
        
        $('#btnDelete').on('click', function(e) {
        	var form$ = $("#frmBulletinBasicMod");
			form$.find("#btnDelete").attr('disabled', true);
    		form$.find("#btnSubmit").attr('disabled', true);
        	
        	e.preventDefault();
    		
            alertify.confirm("do you Delete?", function (e) {
                if (e) {
                	$.when( that$.fn.deleteAction() ).done(function( result ) {
                		var msg = result;
                		var fileGrpSeq = $('#fileGrpSeq').val();
                		$.when( that$.uploader1.deleteAllFileToServer( fileGrpSeq ) ).done(function( result ) {
                    		alertify.alert(msg, function (e) {
    							if(e) {
                            		that$.fn.pageAction();
    							}
    						});			                        		
                		});
                	}).fail(function( result ) {
            			form$.find("#btnDelete").attr('disabled', false);
                		form$.find("#btnSubmit").attr('disabled', false);
                		alertify.alert(result);
                		return;
                	});                	
                } else {
                    return;
                }
            });        	
        });
        
        $('#btnSubmit').on('click', function(e) {
    		$('#titleKh').attr('required', ($('#titleEn').val() != "" ? false : true));
        	$('#titleEn').attr('required', ($('#titleKh').val() != "" ? false : true));
    		$('#contentKh').attr('required', ($('#contentEn').val() != "" ? false : true));
    		$('#contentEn').attr('required', ($('#contentKh').val() != "" ? false : true));
        });
        
        $("#frmBulletinBasicMod").submit(function(e) {
        	var form$ = $("#frmBulletinBasicMod");
        	
			form$.find("#btnDelete").attr('disabled', true);
    		form$.find("#btnSubmit").attr('disabled', true);
        	e.preventDefault();
        	
            alertify.confirm("do you Save?", function (ex) {
                if (ex) {
                	$.when( that$.fn.updateAction() ).done(function( result ) {
                		if ( (that$.uploader1Data).length > 0 ) {
                    		that$.uploader1Data = (that$.uploader1Data).map(function(x) {
                    			x.fileSeq = (x.saveNm).split('.')[0];
                    			x.fileGrpSeq = $('#fileGrpSeq').val();
                    			return x;
                    		});
                    		$.when( that$.uploader1.insertFileDbToServer(that$.uploader1Data) ).done(function( results ) {
                        		alertify.alert('success save !!', function (e) {
        							if(e) {
                                		that$.fn.pageAction();
        							}
        						});			                        		
            				});
                		} else {
                    		alertify.alert('success save !!', function (e) {
    							if(e) {
                            		that$.fn.pageAction();
    							}
    						});			                        		
                		}			                        		
                	}).fail(function( result ) {
            			form$.find("#btnDelete").attr('disabled', false);
                		form$.find("#btnSubmit").attr('disabled', false);
                		alertify.alert(result);
                		return;
                	});                       	
                } else {
                    return;
                }
            });        	
        });
        
		/* 첨부파일1 처리 이벤트 핸들러 S */
        var file1Div$ = $("#dragandrophandler");
        file1Div$.on('dragenter', function(e) {
			e.stopPropagation();
			e.preventDefault();
			$(this).css('border', '2px solid #0B85A1');
		});
		
        file1Div$.on('dragover', function(e) {
			e.stopPropagation();
			e.preventDefault();
		});
		
        file1Div$.on('drop', function(e) {
			$(this).css('border', '2px dotted #0B85A1');
			e.preventDefault();
			var files = e.originalEvent.dataTransfer.files;
			var maxLength = ( $.isNumeric($('#fileQty').val()) ) ? parseInt($('#fileQty').val()) : 5 ;
			
			if ((that$.uploadHasData).length + (that$.uploader1Data).length + files.length > maxLength) {
				alertify.alert('max file limit ' + maxLength + ' !!');
			} else {
				$.when( that$.uploader1.handleFileUpload(files, file1Div$) ).done(function( results ) {
					that$.uploader1Data = $.merge(that$.uploader1Data, results);
					that$.fn.initDndMsg( file1Div$ );
				}).fail(function(result) {
					alertify.alert(result, function (e) {
						if(e) {
							/* $.when( that$.uploader1.deleteFileToServer( that$.uploader1Data ) ).done(function( res ) {
								that$.uploader1Data = [];
								that$.fn.initDndMsg( file1Div$ );
							}); */							
							return false;
						}
					});							
				});
			}
		});

        $(document).on('click', 'input.btnFileDelete',function() {
        	var fileSeq = $(this).attr('id');
			alertify.confirm('do you delete file? ', function (e) {
				if(e) {
					var deleteData = (that$.uploadHasData).find(function (x) {
						return x.fileSeq == fileSeq;
					});

					if (typeof deleteData === 'undefined' || deleteData == null) {
						deleteData = (that$.uploader1Data).find(function (x) {
							return (x.saveNm).split('.')[0] == fileSeq;
						});						

					} else {
						deleteData['bizName'] = (deleteData.saveFilePath).substring(1, (deleteData.saveFilePath).length);
					}
					
					$.when( that$.uploader1.deleteFileToServer( [deleteData] ) ).done(function( res ) {
						(that$.uploader1Data).forEach(function( item, i ) {
							if ( item['saveNm'].split('.')[0] === fileSeq ) {
								(that$.uploader1Data).splice(i, 1);	
							}
						});						
						(that$.uploadHasData).forEach(function( item, i ) {
							if ( item['saveNm'].split('.')[0] === fileSeq ) {
								(that$.uploadHasData).splice(i, 1);	
							}
						});

						that$.uploader1.status.removeItem( fileSeq );
						that$.fn.initDndMsg( file1Div$ );
					});							
				} else {
					return false;
				}
			});		        	
        });
        
        $(document).on('dragenter', function(e) {
			e.stopPropagation();
			e.preventDefault();
		});
		
		$(document).on('dragover', function(e) {
			e.stopPropagation();
			e.preventDefault();
		});
		
		$(document).on('drop', function(e) {
			e.stopPropagation();
			e.preventDefault();
		});
		/* 첨부 파일 처리 이벤트 핸들러 E */        
    },
    fn: {
    	updateAction: function() {
    		var deferred = $.Deferred();
    	    var param = $("#frmBulletinBasicMod").serializeObject();
    	    
    	    var options = {
				method : 'post',
				url : contextPath + '/internal/info/updateBulletinAjax.do',
				data : param,
				dataType : 'json',
			};

		    $.ajax(options).done(function(result, status, responseObj) {
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
    	
    	deleteAction: function() {
    		var deferred = $.Deferred();
    	    var param = $("#frmBulletinBasicMod").serializeObject();

    	    var options = {
				method : 'post',
				url : contextPath + '/internal/info/deleteBulletinAjax.do',
				data : param,
				dataType : 'json',
			};

		    $.ajax(options).done(function(result, status, responseObj) {
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

    	pageAction : function() {
    		
    	    var currUrl = document.location.href;
        	var urlParam = "";
        	
    	    if (currUrl.indexOf('bulletinManual') !=  -1) {
    	    	urlParam = 'bulletinManual';
    	    } else if (currUrl.indexOf('bulletinFaq') !=  -1) {
    	    	urlParam = 'bulletinFaq';
    	    } else if (currUrl.indexOf('bulletinAncmt') !=  -1) {
    	    	urlParam = 'bulletinAncmt';
    	    } else if (currUrl.indexOf('bulletinNews') !=  -1) {
    	    	urlParam = 'bulletinNews';
    	    }
    	    
    	    location.href = "/internal/info/" + urlParam + ".do";
    	},

    	commCdLang : function(obj) {
    	    return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
    	}, 

    	initDndMsg : function ( dndObj$ ) {
			if ((bulletinBasicMod.uploader1Data).length > 0 || (bulletinBasicMod.uploadHasData).length > 0) {
				dndObj$.find('div.dragndrop-init-message').hide();
			} else {
				dndObj$.find('div.dragndrop-init-message').show();
			}
    	},
    } 
}
