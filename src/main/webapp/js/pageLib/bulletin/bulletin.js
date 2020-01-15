var	bulletinList = {
    name: 'bulletinList',
    currentPage:1,			//페이지 번호
    listBlock:16,			//페이징갯수
    totalCount:0,			//게시물 전체갯수
    regId : "",
    
    init: function() {
        this.beforeBind();
        this.bind();
        this.afterBind();
        
    },
    
    beforeBind: function() {
    },

    
    bind: function() {
        //bulletinMNGList.fn.getList();
        var orderColumns = ["TITLE", "CONTENT", "BULLETIN_SEQ", "WRITE_DT", "USE_YN", "REG_USER_SEQ", "REG_DT"];
        // init dataTable
        $('#bulletinMng').dataTable({
            pageLength: 3,
            pagingType : "full_numbers",
            bPaginate: true,
            bLengthChange: true,
            lengthMenu : [ [ 3, 20, 30, 50, -1 ], [ 3, 20, 30, 50, "All" ] ],
            responsive: true,
            bAutoWidth: false,
            processing: true,
            ordering: true,
            bServerSide: true,
            searching: false,
            filter : false,
            language: {
                "zeroRecords": "No data Found",
                "processing": 'Loading'
              },
            info: false,
            ajax: {
                url :  contextPath + "/internal/bulletin/selectBulletinList.do?orderColumns="+orderColumns // URL
                ,type: "POST"
                ,dataType: "json"
                ,dataSrc: function(res) {
                     var data = res.data;
                     return data;
                 }

            },
            //sAjaxSource : contextPath + "/selectBulletinMNGList.do?columns="+columns,
            sServerMethod: "POST",
            columns: [
                 {"data": "title",'orderable': true},
                 {"data": "content",'orderable': true},
                 {"data": "bulletinSeq",'orderable': true},
                 {"data": "writeDt",'orderable': true},
                 {"data": "useYn",'orderable': true},
                 {"data": "regUserSeq",'orderable': true},
                 {"data": "regDt",'orderable': true}
            ],
            order: [[ 1, "desc" ]]
        });
    },
    
    afterBind: function() {
        //common.sys.getDatepicker();
        //검색버튼
        $('#btnSearch').click(function(){
            bulletinList.currentPage = 1;
            bulletinList.fn.getList();
        });
        
    },
    
    fn: {
        /** 게시물 데이터**/
        getList : function() {
          //  var token = $("meta[name='_csrf']").attr("content");
          //  var header = $("meta[name='_csrf_header']").attr("content");
            var param = {
                    "pageNo"		:	bulletinList.currentPage,
                    "listBlock"		:	bulletinList.listBlock
                };
            
            $.ajax({
                type : 'post', // 타입
                url :  contextPath + "/internal/bulletin/selectBulletinList.do", // URL
                dataType : 'json', // 데이터 타입
                data : param,
                success : function(result) { // 결과 성공
                    console.log(result);
                },
                error : function(request, status, error) { // 결과 에러

                }
            })
        },
        /** 게시물 그리기 **/
        drawList : function(dataJson) {
            
        }
    }
}