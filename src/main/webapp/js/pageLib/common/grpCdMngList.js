var	grpCdList = {
    pageYn : 'N',
    name: 'grpCdList',
    dataTables: null,
    
    init: function() {
        this.beforeBind();
        this.bind();
        this.afterBind();
        
    },
    
    beforeBind: function() {
        var that$ = this;
        var deferred = $.Deferred();
        var sessData = JSON.parse(sessionStorage.getItem(that$.name + "." + that$.method));
        
        if (sessData) {
            $('#searchKeyword option:selected').val(sessData.searchKeyword);
            $("#searchValue").val(sessData.searchValue);
            $("#useYn").val(sessData.useYn);
            
            grpCdList.pageYn = 'Y';
            sessionStorage.clear();
        }				
        
        deferred.resolve();	

      
    },

    
    bind: function() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "grpCd"},
            {"data": "grpNm"},
            {"data": "useYn"},
            {"data": "regUserNm"}, 
            {"data": "regDt"}
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#grpCd').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            bStateSave : true,
            serverSide: true,
            searching: false,
            destroy: true,
            stateSaveCallback: function(settings,data) {
                localStorage.setItem( grpCdList.name + settings.sInstance, JSON.stringify(data) );
              },
            stateLoadCallback: function(settings) {
                if (grpCdList.pageYn == 'Y') {
                    return JSON.parse( localStorage.getItem( grpCdList.name + settings.sInstance ) );
                } else {
                    localStorage.clear();
                    return JSON.parse( localStorage.getItem( grpCdList.name + settings.sInstance ) );
                }
              },
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/common/selectGrpCdMngListAjax.do?orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        
                        searchKeyword: $('#searchKeyword').val(),
                        searchValue: $('#searchValue').val(),
                        useYn: $('#useYn').val()
                    } );
                }

            },
            columns : setColumns,
            order: [[4, 'desc']],
            columnDefs: [
                { targets: 1, render: function ( data, type, full, meta ) {
                    
                        var html = "";

                        
                        html = "<a href=\"javascript:void(0);\" onclick=\"grpCdList.fn.pageAction('" + full.grpCd + "');\">" + data + "</font>" ;
                        
                        return html;
                    }
                }
                
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
            ]
        });
    },
    
    afterBind: function() {
        var that$ = this;

       
        
        //console.log(that$.dataTables);
			
        //검색버튼
        $('#btnSearch').click(function() {
            //$('#searchInsttNm').val( '33' );
            that$.dataTables.ajax.reload();
        });

        $('#btnCreate').click(function() {
            //$('#searchInsttNm').val( '33' );
            that$.fn.pageCreate();
        });
     
    },
    
    fn: {
        getDataTableRowSelected: function( dataTables ) {
            return (dataTables.column(0).checkboxes.selected()).toArray();
      },
      pageAction(grpCd){
   
        $("#schFrm").find("#grpCd").val(grpCd);
        var sessData = $('#frm').serializeObject();
        sessionStorage.setItem(grpCdList.name + "." + grpCdList.method, JSON.stringify(sessData));
    
        $("#schFrm").attr("method", "post");
        $("#schFrm").attr("action", contextPath + "/internal/common/grpCdMngMod.do");
        $("#schFrm").submit();
    },
    pageCreate(){
   
        var sessData = $('#frm').serializeObject();
        console.log("sessData: "+sessData);
        sessionStorage.setItem(grpCdList.name + "." + grpCdList.method, JSON.stringify(sessData));
    
        $("#schFrm").attr("method", "post");
        $("#schFrm").attr("action", contextPath + "/internal/common/grpCdMngReg.do");
        $("#schFrm").submit();
    }
        
    } 
}


