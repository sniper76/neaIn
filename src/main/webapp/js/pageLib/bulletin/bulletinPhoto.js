var	bulletinBasicList = {
    pageYn : 'N',
    name: 'bulletinBasicList',
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
            {"data": "bulletinSeq"},
            {"data": ""},
            {"data": "title"},
            {"data": "viewYn"},
            {"data": "fileCnt"}, 
            {"data": "userNm"}, 
            {"data": "likeCnt"}, 
            {"data": "viewCnt"},
            {"data": "regDt"},
            {"data": "ntcYn"},

            {"data": "bulletinMngSeq"},
            {"data": "programId"},
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#bulletinBasic').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            serverSide: true,
            bStateSave : true,
            searching: false,
            destroy: true,
            stateSaveCallback: function(settings,data) {
                localStorage.setItem( bulletinBasicList.name + settings.sInstance, JSON.stringify(data) );
              },
            stateLoadCallback: function(settings) {
                if (bulletinBasicList.pageYn == 'Y') {
                    return JSON.parse( localStorage.getItem( bulletinBasicList.name + settings.sInstance ) );
                } else {
                    localStorage.clear();
                    return JSON.parse( localStorage.getItem( bulletinBasicList.name + settings.sInstance ) );
                }
              },
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/bulletin/selectBulletinBasicListAjax.do?pg="+$("#programId").val()+"&orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        
                        KeywordSel: $('#Keyword_sel').val(),
                        keyword: $('#keyword').val(),
                        viewYn: $('#viewYn').val(),
                        startDate: $('#startDate').val(),
		        		endDate: $('#endDate').val(),
                        bulletinTypeCd: $('#bulletinTypeCd').val(),
                        programId: $('#programId').val(),
                        lang: lang
                    } );
                }
                , dataSrc: function(res) {
        			that$.getRowData = res.aaData;
        			return res.aaData;
        		}

            },
            columns : setColumns,
            order: [[8, 'desc']],
            columnDefs: [
                { targets: 1,orderable: false, render: function ( data, type, full, meta ) {
                    //return "<img id=\"thumbnail\" src=\""+ contextPath + "/images/dummy_photo.png\" width=\"100%\" >" ;
                    return "<img id=\"thumbnail\" src=\""+ contextPath + "/images/board/dummy_photo.png\" width=\"100%\" >" ;
                    }
                },
                { targets: 2, render: function ( data, type, full, meta ) {
                    var html = "";

                    if(full.ntcYn == "Y"){
                        html = "<button type=\"button\" class=\"bbs_btn type02 small writing\">Notice</button><a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.bulletinSeq + "');\">" + data + "</font>" ;
                    }else{
                        html = "<a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.bulletinSeq + "');\">" + data + "</font>" ;
                    }
                    return html;
                    }
                },
                { targets: [0,10, 11], visible: false, searchable: false },
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


function insertBulletin(){
    var sessData = $('#frm').serializeObject();
    sessionStorage.setItem(bulletinBasicList.name + "." + bulletinBasicList.method, JSON.stringify(sessData));
    $("#frm").attr("method", "post");
    $("#frm").attr("action", contextPath + "/internal/bulletin/bulletinPhotoReg.do?pg="+$("#programId").val());
    $("#frm").submit();
    
}


function pageAction(bulletinSeq){
   
    $("#frm").find("#bulletinSeq").val(bulletinSeq);
    var sessData = $('#frm').serializeObject();
    sessionStorage.setItem(bulletinBasicList.name + "." + bulletinBasicList.method, JSON.stringify(sessData));

    $("#frm").attr("method", "post");
    $("#frm").attr("action", contextPath + "/internal/bulletin/bulletinPhotoDtl.do?pg="+$("#programId").val());
    $("#frm").submit();
}

function commCdLang(obj){
    return lang == 'kh' ?  obj.cdKhNm : obj.cdEnNm ;
}