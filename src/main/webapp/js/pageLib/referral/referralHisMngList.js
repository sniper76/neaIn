var	referralList = {
		name: 'referralHisMngList',
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
			var orderColumns = ["referralTypeCd", "compnyNm", "vacancyTitle", "userNm", "refDate", "juserNm", "referralStsCd"];
			// init dataTable
			$('#myTable').dataTable({
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
		        	url :  contextPath + "/internal/referral/selectReferralList.do?orderColumns="+orderColumns // URL
		            ,type: "POST"
		            ,dataType: "json"
	            	,dataSrc: function(res) {
	                     var data = res.data;
	                     return data;
	                 }

		        },
		        sServerMethod: "POST",
	            columns: [
	            	{"data": "vacancySeq",'orderable': false},
	            	{"data": "resumeSeq",'orderable': false},
		            {"data": "referralTypeCd",'orderable': true},
		            {"data": "compnyNm",'orderable': true},
		            {"data": "vacancyTitle",'orderable': true},
		            {"data": "userNm",'orderable': true},
		            {"data": "refDate",'orderable': true},
		            {"data": "juserNm",'orderable': true},
		            {"data": "referralStsCd",'orderable': true}
		        ],
		        order: [[ 1, "desc" ]]
		    });
		},
		
		afterBind: function() {
			common.sys.getDatepicker();
			//검색버튼
			$('#btnSearch').click(function(){
				referralList.currentPage = 1;
				referralList.fn.getList();
			});
			
		},
		
		fn: {
			/** 게시물 데이터*
			getList : function() {
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
				var param = {
						"pageNo"		:	jobCenterList.currentPage,
						"listBlock"		:	jobCenterList.listBlock
					};
				
				$.ajax({
				    type : 'post', // 타입
				    url :  contextPath + "/internal/common/selectJobCenterList.do", // URL
				    dataType : 'json', // 데이터 타입
				    data : param,
				    success : function(result) { // 결과 성공
				        console.log(result);
				    },
				    error : function(request, status, error) { // 결과 에러

				    }
				})
			},
			게시물 그리기 **/
			drawList : function(dataJson) {
				
			}
		}
}

$("[name=btnDelete]").click(function(evt){
	
	var action = "deleteReferralHisMngList.do";
	/* Add Data selected from the data table */
	var param = "";
	$.ajax({
		type:'POST',
		url:action,
		data:param,
		dataType:'json',
		async:false,
		success:function(rtnData){
			if(rtnData.resultCode!="0000"){
				alert(rtnData.msg);
				return;
			}
	
			alert('Save Success');
		},
		complete:function(){
			//
		}
	});
});