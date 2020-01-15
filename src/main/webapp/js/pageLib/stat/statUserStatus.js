	
	var	statUserStatus = {
			name: 'statUserStatus',
			
			init: function() {
				var that$ = this;
			
				$.when( that$.beforeBind() ).done(function( res ) {
					that$.bind();
					that$.afterBind();
				});
				
			},
			
			beforeBind: function() {
				common.sys.getDatepicker();
				
				var that$ = this;
				var deferred = $.Deferred();
				
				var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
				
				if (sessData) {
					
					$('input:radio[name="srchTermDivCd"][value="' + sessData.srchTermDivCd + '"]').prop("checked", true);
	                
					$("#startDate").val(sessData.startDate);
	                $("#endDate").val(sessData.endDate);
	                $('button.btnPeriod').removeClass('on');
					
					if (sessData.periodOn != "") {
						$("#periodOn").val(sessData.periodOn);
						$('button#'+sessData.periodOn).addClass('on');
					}
					
	                sessionStorage.clear();
	                
	            } else {
	            	$('#startDate').datepicker('setDate', '-1M');
					$('#endDate').datepicker('setDate', 'today');
					$('button#-1M').addClass('on');
					$("#periodOn").val("-1M");
	            }				
				
				deferred.resolve();	
			},
			
			bind: function() {
				var that$ = this;

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

				/* test complete : OK ======================================================================================================
                
                var urlPath = document.location.protocol + "//" + document.location.host;
	            var divPath = 'innerTabDetail';
	            //var report = createJSPReport(urlPath + "/ClipReport4/Clip.jsp", urlPath + "/WEB-INF/jsp/stat/statUserTotalStatus.jsp", "" ,document.getElementById(divPath));
	            var report = createJSPReport(urlPath + "/ClipReport4/Clip.jsp", urlPath + "/ClipReport4/statUserTotalStatus.jsp", "" ,document.getElementById(divPath));
	            //리포트 뷰어의 옵션
	            report.setSlidePage(true);
	            //리포트 뷰어 실행
	            report.view();				
	            
	    	    test complete ====================================================================================================== */

	            
	    		$("#innerResultReport").empty();
	    		$("#innerTabDetail").empty();
	    		
	    	    var action = contextPath + "/internal/stat/statUserTotalStatusDailyAjax.do"
	    		var param = {
	    	    				jcCd : $('#jcCd').val(),
	    	    				startDate: $('#startDate').val(),
	    	    				endDate: $('#endDate').val()
	    	    			};
	    		
	            $.ajax({
	                type: "POST",
	                url: action,
	                data: param,                   
	                cache: true,
	                success: function(response) {
	                    $("#innerTabDetail").html(response);
	                    
	                    var urlPath = document.location.protocol + "//" + document.location.host;
	                    var resultKey = $("#resultKey").val();
	                    var divPath = 'innerResultReport';
	                	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
	                   
	                	report.setStyle('close_button', "display:none;");
	                	report.view();
	                    	                    
	                }
	            });

			},
			
			fn: {
					//
			}
	}
	
	function fnTabClick(seletedTab){
		
		currentTab = seletedTab;
		
    	var startDate = $("#startDate").val();
    	var endDate = $("#endDate").val();
    	
    	var diffDays = getDateDiff(endDate, startDate);
    	
    	if (srchTermDivCd == "STD0000000001" && diffDays > 31){
    		alertify.alert(msgErrDailySrchCond);
    		return;
    	}
    	
    	if (srchTermDivCd == "STD0000000001" && currentTab == "tabUserTotalStatus"){
            fnUserTotalStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabJobCenterStatus") {
    		fnJobCenterStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabLocationStatus") {
    		fnLocationStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabJobskStatus") {
    		fnJobskStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabUserCompnyStatus") {
    		fnUserCompnyStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabUserInsttStatus") {
    		fnUserInsttStatusDaily();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabUserTotalStatus") {
    		fnUserTotalStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabJobCenterStatus") {
    		fnJobCenterStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabLocationStatus") {
    		fnLocationStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabJobskStatus") {
    		fnJobskStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabUserCompnyStatus") {
    		fnUserCompnyStatusMonthly();
    	} else {
    		fnUserInsttStatusMonthly();
    	}
	};
	
	// User Total Daily Status
	function fnUserTotalStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserTotalStatusDailyAjax.do"
		var param = {
				
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });
        
	}; 
	
	// User Total Monthly Status
	function fnUserTotalStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserTotalStatusMonthlyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });
        
	}; 
	
	
	// User Job Center Daily Status
	function fnJobCenterStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserJobCenterStatusDailyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });
        
	};
	
	// User Job Center Monthly Status
	function fnJobCenterStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserJobCenterStatusMonthlyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });

	};

	// User Location Daily Status
	function fnLocationStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserLocationStatusDailyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });
        
	};
	
	// User Location Monthly Status
	function fnLocationStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserLocationStatusMonthlyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });

	};

	// User Job Seeker Daily Status
	function fnJobskStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserJobskStatusDailyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });
        
	};
	
	// User Job Seeker Monthly Status
	function fnJobskStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserJobskStatusMonthlyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });

	};

	
	// User Company Status Daily
	function fnUserCompnyStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserCompnyStatusDailyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });
        
	};
	
	// User Company Status Monthly
	function fnUserCompnyStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserCompnyStatusMonthlyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });

	};
	
	// User Institution Status Daily
	function fnUserInsttStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserInsttStatusDailyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });
        
	};
	
	// User Institution Status Monthly
	function fnUserInsttStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statUserInsttStatusMonthlyAjax.do"
		var param = {
	    		jcCd : $('#jcCd').val(),
				startDate: $('#startDate').val(),
				endDate: $('#endDate').val()
			};
		
        $.ajax({
            type: "POST",
            url: action,
            data: param,                   
            cache: true,
            success: function(response) {
                $("#innerTabDetail").html(response);
                
                var urlPath = document.location.protocol + "//" + document.location.host;
                var resultKey = $("#resultKey").val();
                var divPath = 'innerResultReport';
            	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", resultKey, document.getElementById(divPath));
            	
            	report.setStyle('close_button', "display:none;");	
            	report.view();
                	                    
            }
        });

	};	
	