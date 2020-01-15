var	popUpList = {
    pageYn : 'N',
    name: 'popUpList',
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
            $("#Keyword_sel").val(sessData.Keyword_sel);
            $("#keyword").val(sessData.keyword);
            $("#useYn").val(sessData.useYn);

            $("#startDate").val(sessData.startDate);
            $("#endDate").val(sessData.endDate);
            $('button.btnPeriod').removeClass('on');
                
            if (sessData.periodOn != "") {
                $("#periodOn").val(sessData.periodOn);
                $('button#'+sessData.periodOn).addClass('on');
            }
            popUpList.pageYn = 'Y';
            sessionStorage.clear();
        }				
        
        deferred.resolve();	
    },

    
    bind: function() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "popupSeq"},
            {"data": "title"},
            {"data": "resvYn"},
            {"data": "bgnDate"}, 
            {"data": "endDate"}, 
            {"data": "useYn"}, 
            {"data": "regUserNm"},
            {"data": "regDt"},
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#popUp').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            serverSide: true,
            searching: false,
            bStateSave : true,
            destroy: true,
            stateSaveCallback: function(settings,data) {
                localStorage.setItem( popUpList.name + settings.sInstance, JSON.stringify(data) );
              },
            stateLoadCallback: function(settings) {
                if (popUpList.pageYn == 'Y') {
                    return JSON.parse( localStorage.getItem( popUpList.name + settings.sInstance ) );
                } else {
                    localStorage.clear();
                    return JSON.parse( localStorage.getItem( popUpList.name + settings.sInstance ) );
                }
              },
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/sitemgmt/selectPopUpList.do?orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        
                        KeywordSel: $('#Keyword_sel').val(),
                        keyword: $('#keyword').val(),
                        useYn: $('#useYn').val(),
                        startDate: $('#startDate').val(),
						endDate: $('#endDate').val()
                    } );
                }

            },
            columns : setColumns,
            order: [[7, 'desc']],
            columnDefs: [
                { targets: 0, visible: false, searchable: false },
                { targets: 1, render: function ( data, type, full, meta ) {
                    
                        var html = "";

                        
                        html = "<a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.popupSeq + "');\">" + data + "</font>" ;
                        
                        return html;
                    }
                },
                { targets: 3, render: function ( data, type, full, meta ) {
                    
                    var bgnDt = full.bgnDate;
                    

                    bgnDt = (bgnDt == "9999") ? endDtMsg : bgnDt;
                    
                    return bgnDt;
                    }
                },
                { targets: 4, render: function ( data, type, full, meta ) {
                    
                    var endDt = full.endDate;
                    

                    endDt = (endDt == "9999") ? endDtMsg : endDt;
                    
                    return endDt;
                }
            }
            ]
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
        getDataTableRowSelected: function( dataTables ) {
            return (dataTables.column(0).checkboxes.selected()).toArray();
      },
        
    } 
}

function insertPopUp(){
    var sessData = $('#schFrm').serializeObject();
    sessionStorage.setItem(popUpList.name + "." + popUpList.method, JSON.stringify(sessData));
    location.href = contextPath + "/internal/sitemgmt/popUpReg.do";
    
}


function pageAction(popupSeq){
   
    $("#schFrm").find("#popupSeq").val(popupSeq);
    var sessData = $('#schFrm').serializeObject();
    sessionStorage.setItem(popUpList.name + "." + popUpList.method, JSON.stringify(sessData));

    $("#schFrm").attr("method", "post");
    $("#schFrm").attr("action", contextPath + "/internal/sitemgmt/popUpMod.do");
    $("#schFrm").submit();
}
