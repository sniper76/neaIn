var	bulletinFaqReg = {
    name: 'bulletinFaqReg',
    dataTables: null,
    
    init: function() {
        this.beforeBind();
        this.bind();
        this.afterBind();
        
    },
    
    beforeBind: function() {
        var that$ = this;
        common.sys.getDatepicker();

    },

    
    bind: function() {
        var that$ = this;
    },
    
    afterBind: function() {
        var that$ = this;
        $('#btnList').on('click', function(e) {
    		that$.fn.pageAction();
        });
        
        $('#btnSubmit').on('click', function(e) {
    		$('#titleKh').attr('required', ($('#titleEn').val() != "" ? false : true));
        	$('#titleEn').attr('required', ($('#titleKh').val() != "" ? false : true));
    		$('#contentKh').attr('required', ($('#contentEn').val() != "" ? false : true));
    		$('#contentEn').attr('required', ($('#contentKh').val() != "" ? false : true));
        });
        
        $("#frmBulletinFaqReg").submit(function(e) {
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
                            		alertify.alert(result, function (e) {
            							if(e) {
                                    		that$.fn.pageAction();
            							}
            						});			                        		
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
       						alertify.alert(result, function (e) {
    							if(e) {
                            		that$.fn.pageAction();
    							}
    						});			                        		
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
    	    var param = $("#frmBulletinFaqReg").serializeObject();

    	    var options = {
				method : 'post',
				url : contextPath + '/internal/info/insertBulletinAjax.do?',
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
    } 
}
