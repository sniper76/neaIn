var	bulletinMNGList = {
    pageYn : 'N',
    name: 'bulletinMNGList',
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
            {"data": "rowNum"},
            {"data": "bulletinNm"},
            {"data": "bulletinTypeNm"},
            {"data": "programId"}, 
            {"data": "likeYn"}, 
            {"data": "useYn"}, 
            {"data": "userNm"},
            {"data": "regDt"},
            {"data": ""},

            
            {"data": "bulletinMngSeq"},
            {"data": "bulletinTypeCd"}
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#bulletinMng').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            serverSide: true,
            bStateSave : true,
            searching: false,
            destroy: true,
            stateSaveCallback: function(settings,data) {
                localStorage.setItem( bulletinMNGList.name + settings.sInstance, JSON.stringify(data) );
              },
            stateLoadCallback: function(settings) {
                if (bulletinMNGList.pageYn == 'Y') {
                    return JSON.parse( localStorage.getItem( bulletinMNGList.name + settings.sInstance ) );
                } else {
                    localStorage.clear();
                    return JSON.parse( localStorage.getItem( bulletinMNGList.name + settings.sInstance ) );
                }
              },
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/bulletinMng/selectBulletinMngListAjax.do?orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        //insttNm: $('#searchInsttNm').val(),
                        KeywordSel: $('#Keyword_sel').val(),
                        keyword: $('#keyword').val(),
                        useYn: $('#Use_sel').val(),
                        bulletinRangeCd: $('input[name="bulletinRangeCd"]:checked').val(),
                        bulletinTypeCd: $('#Type_sel option:selected').val(),
                        userType: $('#User_sel option:selected').val(),
                        startDate: $('#startDate').val(),
                        endDate: $('#endDate').val(),
                        lang: lang
                    } );
                }

            },
            columns : setColumns,
            order: [[7, 'asc']],
            columnDefs: [
                { targets: 1, render: function ( data, type, full, meta ) {
                    //return "<a href=\"javascript:void(0);\" onclick=\"course.fn.pageAction();\">" + data + "</font>" ;
                    return "<a href=\"javascript:void(0);\" onclick=\"bulletinConfList('" + full.programId +"','"+ full.bulletinTypeCd +"');\">" + data + "</font>" ;
                    }
                },
                { targets: 8, render: function ( data, type, full, meta ) {
                    //return "<a href=\"javascript:void(0);\" onclick=\"course.fn.pageAction();\">" + data + "</font>" ;
                    var html = "";
                    //return "<a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.bulletinMngSeq + "');\">" + data + "</font>" ;
                    html = "<input type=\"button\" value=\"Manage\" id=\"btnSearch\" class=\"bbs_btn type03\" onclick=\"pageAction('"+ full.bulletinMngSeq +"');\" />" ;
                    return html;
                    }
                },
                { targets: [9,10], visible: false, searchable: false },
            ],
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
            
        
        //console.log(that$.dataTables);
			
        //검색버튼
        $('#btnSearch').click(function() {
            //$('#searchInsttNm').val( '33' );
            that$.dataTables.ajax.reload();
        });
     
    },
    
    fn: {
        
    } 
}

function insertBulletinMng(){
    var sessData = $('#frm').serializeObject();
    sessionStorage.setItem(bulletinMNGList.name + "." + bulletinMNGList.method, JSON.stringify(sessData));
    location.href = contextPath + "/internal/bulletinMng/bulletinMngReg.do";
    
}


function pageAction(bulletinMngSeq){
   
    $("#schFrm").find("#bulletinMngSeq").val(bulletinMngSeq);
    var sessData = $('#frm').serializeObject();
    sessionStorage.setItem(bulletinMNGList.name + "." + bulletinMNGList.method, JSON.stringify(sessData));

    $("#schFrm").attr("method", "post");
    $("#schFrm").attr("action", contextPath + "/internal/bulletinMng/BulletinMngDtl.do");
    $("#schFrm").submit();
}

function bulletinConfList(programId,bulletinTypeCd){
    var path = "";
  
   if(bulletinTypeCd == "BTC0000000001"){
    path = "bulletinBasic";
   }else if(bulletinTypeCd == "BTC0000000002"){
    path = "bulletinThumb";
   }else if(bulletinTypeCd == "BTC0000000003"){
    path = "bulletinPhoto";
   }else if(bulletinTypeCd == "BTC0000000004"){
    path = "bulletinAtch";
   }else if(bulletinTypeCd == "BTC0000000005"){
    path = "bulletinFaq";
   }else if(bulletinTypeCd == "BTC0000000006"){
    path = "bulletinCommunity";
   }
   
   location.href = contextPath + "/internal/bulletin/"+path+".do?programId="+programId;
}

function commCdLang(obj){
    return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
}