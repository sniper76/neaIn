var	iscedCdList = {
    name: 'iscedCdList',
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
            {"data": "iscedCd"},
            {"data": "lvl"},
            {"data": "khNm"},
            {"data": "enNm"},
            {"data": "regUserNm"}, 
            {"data": "regDt"},
            {"data": "useYn"}
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#iscedCd').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            bStateSave : true,
            serverSide: true,
            searching: false,
            destroy: true,
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/common/selectIscedCdMngListAjax.do?orderColumns="+orderColumns // URL
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

                        
                        html = "<a href=\"javascript:void(0);\" onclick=\"iscedCdList.fn.pageAction('" + full.iscedCd + "');\">" + data + "</font>" ;
                        
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
      pageAction(iscedCd){
   
        $("#schFrm").find("#iscedCd").val(iscedCd);
        var sessData = $('#frm').serializeObject();
        sessionStorage.setItem(iscedCdList.name + "." + iscedCdList.method, JSON.stringify(sessData));
    
        $("#schFrm").attr("method", "post");
        $("#schFrm").attr("action", contextPath + "/internal/common/iscedCdMngMod.do");
        $("#schFrm").submit();
    },
    pageCreate(){
        var sessData = $('#frm').serializeObject();
        //console.log("sessData: "+sessData);
        sessionStorage.setItem(iscedCdList.name + "." + iscedCdList.method, JSON.stringify(sessData));
    
        $("#schFrm").attr("method", "post");
        $("#schFrm").attr("action", contextPath + "/internal/common/iscedCdMngReg.do");
        $("#schFrm").submit();
    }
        
    } 
}


