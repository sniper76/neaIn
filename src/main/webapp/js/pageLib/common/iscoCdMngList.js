var	iscoCdList = {
    name: 'iscoCdList',
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
            $("#searchKeyword").val(sessData.searchKeyword);
            $("#searchValue").val(sessData.searchValue);
            sessionStorage.clear();
        }				
        
        deferred.resolve();	

      
    },

    
    bind: function() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "rowNum"},
            {"data": "iscoCd"},
            {"data": "lvl"},
            {"data": "khNm"},
            {"data": "enNm"},
            {"data": "regUserNm"}, 
            {"data": "regDt"},
            {"data": "useYn"}
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#iscoCd').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            bStateSave : true,
            serverSide: true,
            searching: false,
            destroy: true,
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/common/selectIscoCdMngListAjax.do?orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        
                        searchKeyword: $('#searchKeyword').val(),
                        searchValue: $('#searchValue').val()
                    } );
                }

            },
            columns : setColumns,
            order: [[6, 'desc']],
            columnDefs: [
                { targets: 3, render: function ( data, type, full, meta ) {
                    
                        var html = "";

                        
                        html = "<a href=\"javascript:void(0);\" onclick=\"iscoCdList.fn.pageAction('" + full.iscoCd + "');\">" + data + "</font>" ;
                        
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
      pageAction(iscoCd){
   
        $("#schFrm").find("#iscoCd").val(iscoCd);
        var sessData = $('#frm').serializeObject();
        sessionStorage.setItem(iscoCdList.name + "." + iscoCdList.method, JSON.stringify(sessData));
    
        $("#schFrm").attr("method", "post");
        $("#schFrm").attr("action", contextPath + "/internal/common/iscoCdMngMod.do");
        $("#schFrm").submit();
    },
    pageCreate(){
        var sessData = $('#frm').serializeObject();
        //console.log("sessData: "+sessData);
        sessionStorage.setItem(iscoCdList.name + "." + iscoCdList.method, JSON.stringify(sessData));
    
        $("#schFrm").attr("method", "post");
        $("#schFrm").attr("action", contextPath + "/internal/common/iscoCdMngReg.do");
        $("#schFrm").submit();
    }
        
    } 
}


