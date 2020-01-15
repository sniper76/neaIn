var	jobReschMngList = {
    pageYn : 'N',
    name: 'jobReschMngList',
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
            $("#iscoCd").val(sessData.iscoCd);
            $("#useYn").val(sessData.useYn);
            
            jobReschMngList.pageYn = 'Y';
            sessionStorage.clear();
        }				
        
        deferred.resolve();	

      
    },

    
    bind: function() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "rowNum"},
            {"data": "oneDepth"},
            {"data": "twoDepth"},
            {"data": "threeDepth"}, 
            {"data": "fourDepth"},
            {"data": "iscoCd"}, 
            {"data": "useYn"}, 
            {"data": "regUserNm"},
            {"data": "regDt"},

            {"data": "iscoId"}
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#jobReschMng').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            bStateSave : true,
            serverSide: true,
            searching: false,
            destroy: true,
            stateSaveCallback: function(settings,data) {
                localStorage.setItem( jobReschMngList.name + settings.sInstance, JSON.stringify(data) );
              },
            stateLoadCallback: function(settings) {
                if (jobReschMngList.pageYn == 'Y') {
                    return JSON.parse( localStorage.getItem( jobReschMngList.name + settings.sInstance ) );
                } else {
                    localStorage.clear();
                    return JSON.parse( localStorage.getItem( jobReschMngList.name + settings.sInstance ) );
                }
              },
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/common/selectJobReschMngListAjax.do?orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        
                        searchKeyword: $('#searchKeyword').val(),
                        searchValue: $('#searchValue').val(),
                        iscoId: $('#iscoId option:selected').val(),
                        useYn: $('#useYn').val(),
                        lang: lang
                    } );
                }

            },
            columns : setColumns,
            order: [[8, 'desc']],
            columnDefs: [
                { targets: 9, visible: false, searchable: false },
                { targets: 4, render: function ( data, type, full, meta ) {
                    
                        var html = "";

                        
                        html = "<a href=\"javascript:void(0);\" onclick=\"jobReschMngList.fn.pageAction('" + full.iscoCd + "');\">" + data + "</font>" ;
                        
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
     
    },
    
    fn: {
        getDataTableRowSelected: function( dataTables ) {
            return (dataTables.column(0).checkboxes.selected()).toArray();
      },
      pageAction(iscoCd){
   
        $("#schFrm").find("#iscoCd").val(iscoCd);
        var sessData = $('#frm').serializeObject();
        sessionStorage.setItem(jobReschMngList.name + "." + jobReschMngList.method, JSON.stringify(sessData));
    
        $("#schFrm").attr("method", "post");
        $("#schFrm").attr("action", contextPath + "/internal/common/jobReschMngMod.do");
        $("#schFrm").submit();
    }
        
    } 
}


