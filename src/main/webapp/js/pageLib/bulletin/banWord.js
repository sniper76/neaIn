var	banWordList = {
    pageYn : 'N',
    name: 'banWordList',
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
            $("#useYn").val(sessData.useYn);
            
            banWordList.pageYn = 'Y';
            sessionStorage.clear();
        }				
        
        deferred.resolve();	

       
    },

    
    bind: function() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "banwordSeq"},
            {"data": "rowNum"},
            {"data": "banword"},
            {"data": "regDt"},
            {"data": "modDt"},
            {"data": ""}, 
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#banwordList').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            serverSide: true,
            searching: false,
            destroy: true,
            stateSaveCallback: function(settings,data) {
                localStorage.setItem( banWordList.name + settings.sInstance, JSON.stringify(data) );
              },
            stateLoadCallback: function(settings) {
                if (banWordList.pageYn == 'Y') {
                    return JSON.parse( localStorage.getItem( banWordList.name + settings.sInstance ) );
                } else {
                    localStorage.clear();
                    return JSON.parse( localStorage.getItem( banWordList.name + settings.sInstance ) );
                }
              },
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/bulletin/selectBanWordList.do?orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        keyword: $('#keyword').val()
                        
                    } );
                }
            },
            columns : setColumns,
            columnDefs: [
                { targets: 0, checkboxes: { selectRow: true } },
                { targets: 2, render: function ( data, type, full, meta ) {
                    
                        var html = "";
                        //html = "<a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.banwordSeq + "');\">" + data + "</font>" ;
                        html = "<input type=\"text\" size=\"60\" maxlength=\"50\" id=\"banwordtxt"+full.rowNum+"\" name=\"banwordtxt"+full.rowNum+"\" value=\""+ data +"\"/>" ;
                        
                        return html;
                    }
                },
                { targets: 5, render: function ( data, type, full, meta ) {
                    
                    var html = "";
                    html = "<input type=\"button\" value=\"Modify\" id=\"btnSearch\" class=\"bbs_btn type03\" onclick=\"updateBanWordConf('"+ full.banwordSeq +"','"+ full.rowNum +"');\" />" ;
                    
                    return html;
                }

                }
            ],
            order: [[4, 'asc']],
		    dom : 'lBfrtip',
		    buttons: [
		        {
		            extend: 'excel',
                    name: 'EXCELDOWNLOAD',
                    className: 'bbs_btn type03 download',
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
        
            
        
        //console.log(that$.dataTables);
			
        //검색버튼
        $('#btnSearch').click(function() {
            //$('#searchInsttNm').val( '33' );
            that$.dataTables.ajax.reload();
        });

        $('#btnDelete').on('click', function(e) {
            var rows_selected = that$.dataTables.column(0).checkboxes.selected();
            var rowId = rows_selected.toArray();
            var rowData = rowId.slice(0);
            var param = {"selectedList": rowId};
            alertify.confirm(deleteMsg, function (e) {
                if(e){
                    deleteBanWord(param);
                }else{
                    return;
                }
             });

           
            
            
        });
     
    },
    
    fn: {
        
    } 
}


function deleteBanWord(param){
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/deleteBanWordAjax.do", // URL
        dataType : 'json', // 데이터 타입
        traditional: true,
        data : param,
        success:function(result){
            var sucCode = result.stat;
            if(sucCode == "0000"){
                $('#btnSearch').trigger('click');
            }else{
                alertify.alert(errorMsg);
            }
        },
        complete:function(){
            //
        }
    })
}

function insertBanWordConf(){
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            insertBanWord();
        } else {
            return;
        }
    });
    
}

function insertBanWord(){
    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/insertBanWordAjax.do?lang="+lang, // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                $('#banword').val("");
                $('#btnSearch').trigger('click');
                //$('#banword').DataTable.ajax.reload();
            }else{
                alertify.alert(errorMsg);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
    

}

function updateBanWordConf(seq,rowNum){
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            update(seq,rowNum);
        } else {
            return;
        }
    });
    
}


function update(seq,rowNum){
    var tconts = $('#banwordtxt'+rowNum).val();
    //console.log("tconts: "+tconts);
    $('#banwordtxt').val(tconts);
    $('#banwordSeq').val(seq);

    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/bulletin/updateBanWordAjax.do?lang="+lang, // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                $('#btnSearch').trigger('click');
            }else{
                alertify.alert(errorMsg);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}
