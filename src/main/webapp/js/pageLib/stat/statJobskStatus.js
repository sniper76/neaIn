	
	var	statJobskStatus = {
			name: 'statJobskStatus',
			
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
	    		
	    	    var action = contextPath + "/internal/stat/statJobskTotalStatusDailyAjax.do"
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
    	
    	if (srchTermDivCd == "STD0000000001" && currentTab == "tabJobskTotalStatus"){
            fnJobskTotalStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabJobCenterStatus") {
    		fnJobCenterStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabLocationStatus") {
    		fnLocationStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabAgeStatus") {
    		fnAgeStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabEducationStatus") {
    		fnEducationStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabOccupationStatus") {
    		fnOccupationStatusDaily();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabJobskTotalStatus") {
    		fnJobskTotalStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabJobCenterStatus") {
    		fnJobCenterStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabLocationStatus") {
    		fnLocationStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabAgeStatus") {
    		fnAgeStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabEducationStatus") {
    		fnEducationStatusMonthly();
    	} else {
    		fnOccupationStatusMonthly();
    	}
	};
	
	// Job Seeker Total Daily Status
	function fnJobskTotalStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskTotalStatusDailyAjax.do"
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
	
	// Job Seeker Total Monthly Status
	function fnJobskTotalStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskTotalStatusMonthlyAjax.do"
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
	
	
	// Job Seeker Job Center Daily Status
	function fnJobCenterStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskJobCenterStatusDailyAjax.do"
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
	
	// Job Seeker Job Center Daily Status
	function fnJobCenterStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskJobCenterStatusMonthlyAjax.do"
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

	// Job Seeker Location Daily Status
	function fnLocationStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskLocationStatusDailyAjax.do"
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
	
	// Job Seeker Location Daily Status
	function fnLocationStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskLocationStatusMonthlyAjax.do"
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

	// Job Seeker Age Daily Status
	function fnAgeStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskAgeStatusDailyAjax.do"
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
	
	// Job Seeker Age Daily Status
	function fnAgeStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskAgeStatusMonthlyAjax.do"
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
	
	// Job Seeker Education Daily Status
	function fnEducationStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskEducationStatusDailyAjax.do"
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
	
	// Job Seeker Education Monthly Status
	function fnEducationStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskEducationStatusMonthlyAjax.do"
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
	
	// Job Seeker Occupation Daily Status
	function fnOccupationStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskOccupationStatusDailyAjax.do"
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
	
	// Job Seeker Occupation Monthly Status
	function fnOccupationStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobskOccupationStatusMonthlyAjax.do"
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
	

	
	