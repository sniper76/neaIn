var	bulletinBasicReg = {
    name: 'bulletinBasicReg',
    dataTables: null,
    uploader1: null,
    uploader1Data: [],
    uploadHasData: [],
    init: function() {
        this.beforeBind();
        this.bind();
        this.afterBind();
        
    },
    
    beforeBind: function() {
        var that$ = this;
        that$.uploader1 = new dndAjaxUploader('info', $('#programId').val());
        //that$.uploader2 = new dndAjaxUploader('info');
        common.sys.getDatepicker();
    },

    
    bind: function() {
        var that$ = this;
    },
    
    afterBind: function() {
        var that$ = this;
        
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
			if ((that$.uploader1Data).length + files.length > maxLength) {
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
/*		
        var file2Div$ = $("#dragandrophandler2");
        file2Div$.on('dragenter', function(e) {
			e.stopPropagation();
			e.preventDefault();
			$(this).css('border', '2px solid #0B85A1');
		});
		
        file2Div$.on('dragover', function(e) {
			e.stopPropagation();
			e.preventDefault();
		});
		
        file2Div$.on('drop', function(e) {
			$(this).css('border', '2px dotted #0B85A1');
			e.preventDefault();
			var files = e.originalEvent.dataTransfer.files;
			$.when( that$.uploader2.handleFileUpload(files, file2Div$) ).done(function( results ) {
				console.log(results);
			});
		});
*/
        $(document).on('click', 'input.btnFileDelete',function() {
        	var fileSeq = $(this).attr('id');
			alertify.confirm('do you delete file? ', function (e) {
				if(e) {
					var deleteData = (that$.uploader1Data).find(function (x) {
						return (x.saveNm).split('.')[0] == fileSeq;
					});						
					
					$.when( that$.uploader1.deleteFileToServer( [deleteData] ) ).done(function( res ) {
						(that$.uploader1Data).forEach(function( item, i ) {
							if ( item['saveNm'].split('.')[0] === fileSeq ) {
								(that$.uploader1Data).splice(i, 1);
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
        
		
        $('#btnList').on('click', function(e) {
    		that$.fn.pageAction();
        });
        
        $('#btnSubmit').on('click', function(e) {
    		$('#titleKh').attr('required', ($('#titleEn').val() != "" ? false : true));
        	$('#titleEn').attr('required', ($('#titleKh').val() != "" ? false : true));
    		$('#contentKh').attr('required', ($('#contentEn').val() != "" ? false : true));
    		$('#contentEn').attr('required', ($('#contentKh').val() != "" ? false : true));
        });
        
        $("#frmBulletinBasicReg").submit(function(e) {
        	var form$ = $("#frmBulletinBasicReg");
        	
        	form$.find("#btnSubmit").attr('disabled', true);
        	e.preventDefault();
        	
            var notiYn = $(':radio[name="ntcYn"]:checked').val();
            
            if (notiYn == "Y") {
            	$.when( that$.fn.selectNotiCntAction( { programId: $('#programId').val() } ) ).done(function( result ) {
                    if (result.notiCnt >= 5) {
                		alertify.alert("limit 5 Notice", function (e) {
							if(e) {
		                    	form$.find("#btnSubmit").attr('disabled', false);
		                        $("#ntcYn").focus();
		                        return;
							}
						});                    	
                    } else {
                        alertify.confirm("do you Save?", function (ex) {
                            if (ex) {
                            	$.when( that$.fn.insertAction() ).done(function( result ) {
                            		if ( (that$.uploader1Data).length > 0 ) {
                                		that$.uploader1Data = (that$.uploader1Data).map(function(x) {
                                			x.fileSeq = (x.saveNm).split('.')[0];
                                			x.fileGrpSeq = result.fileGrpSeq;
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
                        			form$.find("#btnSubmit").attr('disabled', false);
                            		alertify.alert(result);
                            		return;
                            	});                       	
                            } else {
                                return;
                            }
                        });
                    }				
            	}).fail(function(result) {
                	form$.find("#btnSubmit").attr('disabled', false);
					alertify.alert(result);
					return;            		
            	});
            } else {
                alertify.confirm("do you Save?", function (ex) {
                    if (ex) {
                    	$.when( that$.fn.insertAction() ).done(function( result ) {
                    		if ( (that$.uploader1Data).length > 0 ) {
                        		that$.uploader1Data = (that$.uploader1Data).map(function(x) {
                        			x.fileSeq = (x.saveNm).split('.')[0];
                        			x.fileGrpSeq = result.fileGrpSeq;
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
	                    	form$.find("#btnSubmit").attr('disabled', false);
                    		alertify.alert(result);
                    		return;
                    	});
                    } else {
                        return;
                    }
                });
            }
        });
        
    },
    fn: {
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
    	
    	insertAction: function() {
    		var deferred = $.Deferred();
    	    var param = $("#frmBulletinBasicReg").serializeObject();

    	    var options = {
				method : 'post',
				url : contextPath + '/internal/info/insertBulletinAjax.do',
				data : param,
				dataType : 'json',
			};

		    $.ajax(options).done(function(result, status, responseObj) {
	            var sucCode = result.stat;
	            if(sucCode == "0000"){
					deferred.resolve(result);
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
			if ((bulletinBasicReg.uploader1Data).length > 0 || (bulletinBasicReg.uploadHasData).length > 0) {
				dndObj$.find('div.dragndrop-init-message').hide();
			} else {
				dndObj$.find('div.dragndrop-init-message').show();
			}
    	},
    } 
}
