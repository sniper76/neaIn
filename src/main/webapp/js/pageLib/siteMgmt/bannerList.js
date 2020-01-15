var	bannerList = {
    pageYn : 'N',
    name: 'bannerList',
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
            bannerList.pageYn = 'Y';
            sessionStorage.clear();
        }				
        
        deferred.resolve();	
    },

    
    bind: function() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "bannerSeq"},
            {"data": ""},
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
                localStorage.setItem( bannerList.name + settings.sInstance, JSON.stringify(data) );
              },
            stateLoadCallback: function(settings) {
                if (bannerList.pageYn == 'Y') {
                    return JSON.parse( localStorage.getItem( bannerList.name + settings.sInstance ) );
                } else {
                    localStorage.clear();
                    return JSON.parse( localStorage.getItem( bannerList.name + settings.sInstance ) );
                }
              },
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/sitemgmt/selectBannerList.do?orderColumns="+orderColumns // URL
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
                { targets: 1,orderable: false, render: function ( data, type, full, meta ) {
                    //return "<img id=\"thumbnail\" src=\""+ contextPath + "/images/dummy_photo.png\" width=\"100%\" >" ;
                    return "<img id=\"thumbnail\" src=\""+ contextPath + "/images/board/dummy_photo.png\" width=\"100%\" >" ;
                    }
                },
                { targets: 2, render: function ( data, type, full, meta ) {
                    
                        var html = "";

                        
                        html = "<a href=\"javascript:void(0);\" onclick=\"pageAction('" + full.bannerSeq + "');\">" + data + "</font>" ;
                        
                        return html;
                    }
                },
                { targets: 4, render: function ( data, type, full, meta ) {
                    
                    var bgnDt = full.bgnDate;
                    

                    bgnDt = (bgnDt == "9999") ? endDtMsg : bgnDt;
                    
                    return bgnDt;
                    }
                },
                { targets: 5, render: function ( data, type, full, meta ) {
                    
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

function insertBanner(){
    var sessData = $('#schFrm').serializeObject();
    sessionStorage.setItem(bannerList.name + "." + bannerList.method, JSON.stringify(sessData));
    location.href = contextPath + "/internal/sitemgmt/bannerReg.do";
    
}


function pageAction(bannerSeq){
   
    $("#schFrm").find("#bannerSeq").val(bannerSeq);
    var sessData = $('#schFrm').serializeObject();
    sessionStorage.setItem(bannerList.name + "." + bannerList.method, JSON.stringify(sessData));

    $("#schFrm").attr("method", "post");
    $("#schFrm").attr("action", contextPath + "/internal/sitemgmt/bannerMod.do");
    $("#schFrm").submit();
}
