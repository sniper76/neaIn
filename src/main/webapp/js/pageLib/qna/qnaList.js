var	List = {
	//----------------------------
	// InfoIndex 객체
	//----------------------------
	name: 'List',
	currentPage:1,			//페이지 번호
	listBlock:10,			//페이징갯수
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
		
		List.fn.getList();
	},

	afterBind: function() {
		
		//검색버튼
		$('#btnSearch').click(function(){
			List.currentPage = 1;
			List.fn.getList();
		});
		
		common.sys.getDatepicker();
	},
	fn: {
		
		/** 게시물 데이터**/
		getList : function() {
				
			var param = {
				"pageNo"		:	List.currentPage,
				"listBlock"		:	List.listBlock,
				"qnasDate"		:	$.trim($("#qnasDate").val()),
				"qnaeDate"		:	$.trim($("#qnaeDate").val()),
				"ansStatusCd"	:	$.trim($("#ansStatusCd").val()),
				"qnaSchStr"		:	$.trim($("#qnaSchStr").val()),
				"sDate"		:   $("#sDate").val(),
				"eDate"		:   $("#eDate").val(),
				"tpCd1"		:   $("#tpCd1").val(),
				"statusCd"		:   $("#statusCd").val(),
				"bsnsTitle"		:   $("#bsnsTitle").val(),
				"cateCd"		:   $("#cateCd").val(),
				"bsnsSeq"		:   $("#bsnsSeq").val()
			};
			var	opts = {
				url		: contextPath + "/qna/getQnaList.do",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {
					// 목록 데이터 그리기
					List.fn.drawList(resJSON.data);
				}
			};
			common.http.ajax(opts);
		},
		
		/** 게시물 그리기 **/
		drawList : function(dataJson) {
			
			var data   = dataJson.qnaList;
			var paging   = dataJson.paging;
			var pageSettings = {
				pageNo   	: paging.pageNo,
				listBlock  	: paging.listBlock,
				totalCount 	: paging.totalCount,
				funcName 	: "List.fn.goPage"
			};
			
			
			$("#listTable").empty();
			//등록게시물이 없을경우
			if (data.length == 0) {
				$("#listTable").append("<tr><td colspan='5'> 등록된 질문이 없습니다.</td></tr>");
				$("#paging").html("");
			}else{
			// 게시물 존재시 Row작성
				var	html = '';
				for(var i in data){
				
					html += '<tr>';							
					html += '		<td>'+(paging.totalCount - (paging.listBlock * (paging.pageNo - 1 )) - i)+'</td>';
					html += '		<td onclick="List.fn.goDetail(\''+data[i].qnaSeq+'\');">'+ data[i].qnaTitle +'</td>';
					html += '		<td class="tAL pl10">'+ data[i].regDate +'</td>';
					html += '		<td>'+ data[i].usrName +'</td>';
					html += '		<td><span class="c-grey">'+ data[i].ansStatusCdNm +'</span></td>';
					html += '</tr>';
					
				}
				$("#listTable").html(html);
				
				$("#paging").html(common.paging.getNavigator(pageSettings));
			}
		},
		
		//페이징 조회
		goPage : function(pageNo){
			List.currentPage = pageNo;
			List.fn.getList();
		},
		
		goDetail : function(qnaSeq){
			$("#qnaSeq").val(qnaSeq);
			var bsnsSeq = $("#bsnsSeq").val();
			var sDate = $("#sDate").val();
			var eDate = $("#eDate").val();
			var tpCd1 = $("#tpCd1").val();
			var statusCd = $("#statusCd").val();
			var bsnsTitle = $("#bsnsTitle").val();
			var cateCd = $("#cateCd").val();
			var qnasDate = $("#qnasDate").val();
			var qnaeDate = $("#qnaeDate").val();
			var qnaSchStr = $("#qnaSchStr").val();
			var ansStatusCd = $("#ansStatusCd").val();
			var param2 = '&tab=qna&bsnsSeq='+bsnsSeq+'&sDate='+sDate+'&eDate='+eDate+'&tpCd1='+tpCd1+'&statusCd='+statusCd+'&bsnsTitle='+bsnsTitle+'&cateCd='+cateCd+'&qnasDate='+qnasDate+'&qnaeDate='+qnaeDate+'&qnaSchStr='+qnaSchStr+'&ansStatusCd='+ansStatusCd;
			document.listFrm.action=contextPath + "/qna/getQnaDetail.do?Enconde=false" + param2;
			document.listFrm.method="post";
			document.listFrm.submit();
			
		},
		
		goQnaReg : function(){
			var bsnsSeq = $("#bsnsSeq").val();
			var sDate = $("#sDate").val();
			var eDate = $("#eDate").val();
			var tpCd1 = $("#tpCd1").val();
			var statusCd = $("#statusCd").val();
			var bsnsTitle = $("#bsnsTitle").val();
			var cateCd = $("#cateCd").val();
			var qnasDate = $("#qnasDate").val();
			var qnaeDate = $("#qnaeDate").val();
			var qnaSchStr = $("#qnaSchStr").val();
			var ansStatusCd = $("#ansStatusCd").val();
			var param2 = '&tab=qna&bsnsSeq='+bsnsSeq+'&sDate='+sDate+'&eDate='+eDate+'&tpCd1='+tpCd1+'&statusCd='+statusCd+'&bsnsTitle='+bsnsTitle+'&cateCd='+cateCd+'&qnasDate='+qnasDate+'&qnaeDate='+qnaeDate+'&qnaSchStr='+qnaSchStr+'&ansStatusCd='+ansStatusCd;
			location.href=contextPath + "/qna/qnaRegFrm.do?Enconde=false" + param2;
		}
	}
}