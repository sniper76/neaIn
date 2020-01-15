var	bsnsRecptList = {
	//----------------------------
	// InfoIndex 객체
	//----------------------------
	name: 'bsnsRecptList',
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
		
		//임시저장여부
		common.sys.getSelectBox("TEMP_YN", "tempYn", "", "Y");
		
		//검증상태코드
		common.sys.getSelectBox("VERYFY_STATUS_CD", "veryfyStatusCd", "", "Y");
	},

	afterBind: function() {
		
		bsnsRecptList.fn.getList();
	},
	fn: {
		/** 게시물 데이터**/
		getList : function() {

			var param = {
				"pageNo"		:	bsnsRecptList.currentPage,
				"listBlock"		:	bsnsRecptList.listBlock,
			};
			var	opts = {
				url		: contextPath + "/myPage/getBsnsRecptList.do",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {
					// 목록 데이터 그리기
					bsnsRecptList.fn.drawList(resJSON.data);
				}
			};
			common.http.ajax(opts);
		},
		
		/** 게시물 그리기 **/
		drawList : function(dataJson) {
			
			var data   = dataJson.list;
			var paging   = dataJson.paging;
			var pageSettings = {
				pageNo   	: paging.pageNo,
				listBlock  	: paging.listBlock,
				totalCount 	: paging.totalCount,
				funcName 	: "bsnsList.fn.goPage"
			};
			
			
			$("#listTable").empty();
			//등록게시물이 없을경우
			if (data.length == 0) {
				$("#listTable").append("<tr><td colspan='7'>데이터가 없습니다.</td></tr>");
				$("#paging").html("");
			}else{
				
				// 게시물 존재시 Row작성
				var	html = '';
				for(var i in data){
					html += '<tr bsnsSeq="'+data[i].bsnsSeq+'" recptSeq="'+data[i].recptSeq+'" >';
					html += '	<td class="datailClick">'+(paging.totalCount - (paging.listBlock * (paging.pageNo - 1 )) - i)+'</td>';
					html += '	<td class="datailClick">'+data[i].tpNm1+'</td>';
					html += '	<td class="tAL datailClick">'+data[i].bsnsTitle+'</td>';
					html += '	<td class="datailClick">'+data[i].bsnsStartDate+' ~ '+data[i].bsnsEndDate+'</td>';
					html += '	<td class="datailClick">'+data[i].regDate+'</td>';
					html += '	<td class="datailClick">'+data[i].tempYnNm+'</td>';
					html += '	<td class="datailClick">'+data[i].veryfyStatusNm+'</td>';
					html += '</tr>';
				}
				$("#listTable").html(html);
				
				$(".datailClick").click(function(){
					var bsnsSeq = $(this).parent().attr("bsnsSeq");
					var recptSeq = $(this).parent().attr("recptSeq");
					
					bsnsRecptList.fn.goDatail(bsnsSeq, recptSeq);
				});
				
				$("#paging").html(common.paging.getNavigator(pageSettings));
			}
		},
		
		goDatail : function(bsnsSeq, recptSeq){
			
			console.log("bsnsSeq="+bsnsSeq);
			console.log("recptSeq="+recptSeq);
			var form = $("<form id='forward'/>");
			form.attr("method", "post");
			form.attr("action", contextPath + "/myPage/bsnsRecptDetailView.do");
			
			var input  = "<input type='hidden' name='bsnsSeq' value='"+bsnsSeq+"' />";
			input += "<input type='hidden' name='recptSeq' value='"+recptSeq+"' />";
			
			form.append(input);
			form.appendTo("body").submit();
		},
		
	}
}