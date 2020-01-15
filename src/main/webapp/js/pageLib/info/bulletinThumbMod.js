var	bulletinThumbMod = {
    name: 'bulletinThumbMod',
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
        
        $('#btnDelete').on('click', function(e) {
        	var form$ = $("#frmBulletinThumbMod");
			form$.find("#btnDelete").attr('disabled', true);
    		form$.find("#btnSubmit").attr('disabled', true);
        	
        	e.preventDefault();
    		
            alertify.confirm("do you Delete?", function (e) {
                if (e) {
                	$.when( that$.fn.deleteAction() ).done(function( result ) {
                		alertify.alert(result, function (e) {
							if(e) {
                        		that$.fn.pageAction();
							}
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
        
        $("#frmBulletinThumbMod").submit(function(e) {
        	var form$ = $("#frmBulletinThumbMod");
        	
			form$.find("#btnDelete").attr('disabled', true);
    		form$.find("#btnSubmit").attr('disabled', true);
        	e.preventDefault();
        	
            alertify.confirm("do you Save?", function (ex) {
                if (ex) {
                	$.when( that$.fn.updateAction() ).done(function( result ) {
                		alertify.alert(result, function (e) {
							if(e) {
                        		that$.fn.pageAction();
							}
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
    },
    fn: {
    	updateAction: function() {
    		var deferred = $.Deferred();
    	    var param = $("#frmBulletinThumbMod").serializeObject();
    	    
    	    console.log(param);
    	    
    	    var options = {
				method : 'post',
				url : contextPath + '/internal/info/updateBulletinAjax.do',
				data : param,
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
    	
    	deleteAction: function() {
    		var deferred = $.Deferred();
    	    var param = $("#frmBulletinThumbMod").serializeObject();

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
    } 
}
