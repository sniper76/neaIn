	
	var	statJobFairStatus = {
			name: 'statJobFairStatus',
			
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
	    		
	    	    var action = contextPath + "/internal/stat/statJobFairNCPFStatusDailyAjax.do"
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
    	
    	if (srchTermDivCd == "STD0000000001" && currentTab == "tabNCPFStatus"){
            fnNCPFStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabPCPFStatus") {
    		fnPCPFStatusDaily();
    	} else if (srchTermDivCd == "STD0000000001" && currentTab == "tabEmploymentForumStatus") {
    		fnEmploymentForumStatusDaily();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabNCPFStatus"){
            fnNCPFStatusMonthly();
    	} else if (srchTermDivCd == "STD0000000002" && currentTab == "tabPCPFStatus") {
    		fnPCPFStatusMonthly();
    	} else {
    		fnEmploymentForumStatusMonthly();
    	}
	};
	
	// NCPF Daily Status
	function fnNCPFStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobFairNCPFStatusDailyAjax.do"
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
	
	// NCPF Monthly Status
	function fnNCPFStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobFairNCPFStatusMonthlyAjax.do"
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
	
	
	// PCPF Daily Status
	function fnPCPFStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobFairPCPFStatusDailyAjax.do"
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
	
	// PCPF Monthly Status
	function fnPCPFStatusMonthly(){

		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobFairPCPFStatusMonthlyAjax.do"
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

	// Employment Forum Daily Status
	function fnEmploymentForumStatusDaily(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobFairEmploymentForumStatusDailyAjax.do"
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
	
	// Employment Forum Monthly Status
	function fnEmploymentForumStatusMonthly(){
		
		$("#innerResultReport").empty();
		$("#innerTabDetail").empty();
		
	    var action = contextPath + "/internal/stat/statJobFairEmploymentForumStatusMonthlyAjax.do"
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


	