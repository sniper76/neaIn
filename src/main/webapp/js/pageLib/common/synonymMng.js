var	synonymMng = {
    pageYn : 'N',
    name: 'synonymMng',
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
            $("#searchValue").val(sessData.searchValue);
            
            synonymMng.pageYn = 'Y';
            sessionStorage.clear();
        }				
        
        deferred.resolve();	

       
    },

    
    bind: function() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "synonymSeq"},
            {"data": "rowNum"},
            {"data": "kh"},
            {"data": "en"},
            {"data": "regDt"},
            {"data": "modDt"},
            {"data": ""}, 
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        that$.dataTables = $('#synonymList').DataTable({
            pageLength: 10,
            lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
            serverSide: true,
            searching: false,
            destroy: true,
            stateSaveCallback: function(settings,data) {
                localStorage.setItem( synonymMng.name + settings.sInstance, JSON.stringify(data) );
              },
            stateLoadCallback: function(settings) {
                if (synonymMng.pageYn == 'Y') {
                    return JSON.parse( localStorage.getItem( synonymMng.name + settings.sInstance ) );
                } else {
                    localStorage.clear();
                    return JSON.parse( localStorage.getItem( synonymMng.name + settings.sInstance ) );
                }
              },
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/common/selectSynonymMngListAjax.do?orderColumns="+orderColumns // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        searchValue: $('#searchValue').val()
                        
                    } );
                }
            },
            columns : setColumns,
            columnDefs: [
                { targets: 0, checkboxes: { selectRow: true } },
                { targets: 2, render: function ( data, type, full, meta ) {
                    
                        var html = "";
                        //html = "<a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.banwordSeq + "');\">" + data + "</font>" ;
                        html = "<input type=\"text\" size=\"25\" maxlength=\"50\" id=\"khtxt"+full.rowNum+"\" name=\"khtxt"+full.rowNum+"\" value=\""+ data +"\"/>" ;
                        
                        return html;
                    }
                },
                { targets: 3, render: function ( data, type, full, meta ) {
                    
                    var html = "";
                    //html = "<a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.banwordSeq + "');\">" + data + "</font>" ;
                    html = "<input type=\"text\" size=\"25\" maxlength=\"50\" id=\"entxt"+full.rowNum+"\" name=\"entxt"+full.rowNum+"\" value=\""+ data +"\"/>" ;
                    
                    return html;
                    }
                },
                { targets: 6, render: function ( data, type, full, meta ) {
                    
                    var html = "";
                    html = "<input type=\"button\" value=\"Modify\" id=\"btnSearch\" class=\"bbs_btn type03\" onclick=\"updateSynonymConf('"+ full.synonymSeq +"','"+ full.rowNum +"');\" />" ;
                    
                    return html;
                }

                }
            ],
            order: [[4, 'desc']],
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
                    deleteSynonym(param);
                }else{
                    return;
                }
             });

           
            
            
        });
     
    },
    
    fn: {
        
    } 
}


function deleteSynonym(param){
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/deleteSynonymMngAjax.do", // URL
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

function insertSynonymMngConf(){
    if ($('#kh').val() == "") {
        alertify.alert(khBlankMsg, function (e) {
            if (e) {
                $("#kh").focus();
            }
        });
        return;
    }
    if ($('#en').val() == "") {
        alertify.alert(enBlankMsg, function (e) {
            if (e) {
                $("#en").focus();
            }
        });
        return;
    }

    alertify.confirm(saveMsg, function (e) {
        if (e) {
            insertSynonymMng();
        } else {
            return;
        }
    });
    
}

function insertSynonymMng(){
    
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/insertSynonymMngAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                $('#kh').val("");
                $('#en').val("");
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

function updateSynonymConf(seq,rowNum){
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            updateSynonymMng(seq,rowNum);
        } else {
            return;
        }
    });
    
}


function updateSynonymMng(seq,rowNum){
    var khconts = $('#khtxt'+rowNum).val();
    var enconts = $('#entxt'+rowNum).val();
    //console.log("tconts: "+tconts);
    $('#khtxt').val(khconts);
    $('#entxt').val(enconts);
    $('#synonymSeq').val(seq);

    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/updateSynonymMngAjax.do", // URL
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
