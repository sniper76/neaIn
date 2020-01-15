var	userChgList = {
		name: 'userChgList',
		dataTables: null,
		commCode: {},
		
		init: function() {
			var that$ = this;
			
			$.when( this.beforeBind() ).done(function( res ) {
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
            	$("#jcCd").val(sessData.jcCd);
                $("#searchKeyword").val(sessData.searchKeyword);
                $("#searchValue").val(sessData.searchValue);

                $('input:radio[name=userAuthCd]:input[value=' + sessData.userAuthCd + ']').attr("checked", true);
                
                $('input:radio[name=schgAgreeStsCd]:input[value=' + sessData.schgAgreeStsCd + ']').attr("checked", true);
                $('input:radio[name=genderCd]:input[value=' + sessData.genderCd + ']').attr("checked", true);

                $("#startDate").val(sessData.startDate);
                $("#endDate").val(sessData.endDate);
                $('button.btnPeriod').removeClass('on');
				
				if (sessData.periodOn != "") {
					$("#periodOn").val(sessData.periodOn);
					$('button#'+sessData.periodOn).addClass('on');
				}
				
                sessionStorage.clear();
            } else {
				common.sys.setDateDiff();
				$('button#-14D').addClass('on');
				$("#periodOn").val("-14D");
            }
            deferred.resolve();	
		},
		bind: function() {
			var that$ = this;

			var setColumns = [
				{"data": "userChgSeq"},
				{"data": "rowNum"},
				{"data": "chgPrevNm"},
				{"data": "chgNextNm"},
				{"data": "user.userNm"},
				{"data": "user.userEmail"},
				{"data": "user.userCell"},
				{"data": "user.age"},
				{"data": "user.genderNm"},
				{"data": "chgAgreeStsNm"},
				{"data": "regDt"},
				{"data": "stsChgDt"}
		    ];
			
			var orderColumns = setColumns.map(function(x) { return x.data });
				
			that$.dataTables = $('#userChgTable').DataTable({
				stateSave : true,
				pageLength: 10,
	            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
			    processing: true,
			    serverSide: true,
			    searching: false,
			    destroy: true,
			    serverMethod: 'post',
			    ajax: {
			    	url: contextPath + '/internal/userChg/selectUserChgListAjax.do?orderColumns='+orderColumns
			        , dataType: 'json'
			        , type: "POST"
		        	, data: function ( d ) {
			        	return $.extend( {}, d, {
			        		jcCd: $('#jcCd').val(),
			        		searchKeyword: $('#searchKeyword option:selected').val(),
			        		searchValue: $('#searchValue').val(),
			        		userAuthCd: $('input[name="userAuthCd"]:checked').val(),
			        		chgAgreeStsCd: $('input[name="schgAgreeStsCd"]:checked').val(),
			        		genderCd: $('input[name="genderCd"]:checked').val(),
			        		startDate: $('#startDate').val(),
			        		endDate: $('#endDate').val(),
			        	} );
			        }
			    },
			    columns: setColumns,
			    columnDefs: [
			    	{ targets: 0, checkboxes: { selectRow: true },className: 'select-checkbox' ,orderable: false },
			    	{ targets: 2, render: function ( data, type, full, meta ) {
        				return "<a href=\"javascript:void(0);\" onclick=\"userChgList.fn.detail('" + full.userChgSeq + "');\">" + data + "</font>" ;
                	}
                },
			    ],
			    select: { 
			    	style: 'os' ,
			    	selector: 'td:first-child'
			    },
			    order: [[10, 'desc']]
			});

		},
		
		afterBind: function() {
			
			var that$ = this;
			
			$('#btnSearch').on('click', function() {
				
				// 회원구분
				var radioVal = $('input[name="userAuthCd"]:checked').val();
				
				$('#userChgTable').DataTable().ajax.reload();
			});
			
			$("#btnAgree").click(function(){
				userChgList.fn.chgSts('CAS0000000002');
            });
			
			$("#btnReject").click(function(){
				userChgList.fn.chgSts('CAS0000000003');
            });
		},
		
		fn: {
			detail : function (seq) {
				
				$("#userChgSeq").val(seq);
				
				var sessData = $('form').serializeObject();
				sessionStorage.setItem(userChgList.name, JSON.stringify(sessData));
				console.log(sessionStorage.getItem("userChgList"));
				$('#frm').attr('action',contextPath + '/internal/userChg/userChgDtl.do').attr('method', 'post').submit();
			},
			
			chgSts : function (stsCd) {
				$("#chgAgreeStsCd").val(stsCd);
				var form = this;
			    var dTable = $('#userChgTable').DataTable();
			    var rows_selected = dTable.column(0).checkboxes.selected();
			    var matches = [];
			    
			    $.each(rows_selected, function(index, rowId){
			         // Create a hidden element
			    	matches.push(rowId);
			    });
			    
			    $("#userChgSeq").val(matches);
			    
			    var AccountsJsonString = JSON.stringify(matches);
                if($("#userChgSeq").val() == "" ) {
                	alertify.alert(errorOneMsg);
                } else {
                	alertify.confirm(confirmMsg, function(e) {
                		if (e) {
                			var param = $("#frm").serializeObject();
        					var	opts = {
        							url		: contextPath + "/internal/userChg/updateUserChgStsAjax.do",
        							data	: param,
        							type	: "post",
        							sendDataType	: "json",
        							success	: function(resJSON, resCode) {
        								// failed
        								if(resJSON.data.resultCode != '0000') {
        									alertify.alert(errorMsg);
        									return false;
        								} else {
        									alertify.alert(proccesMsg, function(e) {
        										that$.dataTables.ajax.reload();
        									});
        								}
        							},
        							error : function() {
        								alertify.alert(errorMsg);
        							}
        						};
        						common.http.ajax(opts);
                		} else {
                			alertify.alert(cancelMsg);
                		}
                	});
                }
			}
		}
}