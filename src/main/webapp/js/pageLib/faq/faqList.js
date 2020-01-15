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
				"schStr"		:	$.trim($("#schStr").val()),
				"sDate"		    :   $("#sDate").val(),
				"eDate"		    :   $("#eDate").val(),
				"bsnsSeq"		:   $('#bsnsSeq').val()
			};
			var	opts = {
				url		: contextPath + "/faq/getFAQList.do",
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
			
			var data   = dataJson.faqList;
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
					
					html += "<tr class='que'>";
					html += "	<td>10</td>";
					html += "	<td class='tAL pl10'>";
					html += "		<p class=''>" + data[i].faqTitle + "</p>";
					html += "	</td>";
					html += "	<td>2019.01.21</td>";
					html += "</tr>";
					html += "<tr class='ans'>";
					html += "	<td class='tAL' colspan='3'>";
					html += "		<p>";
					html += "			<strong>답변</strong><br/>";
					html += "			<span>" + data[i].faqContents + "</span>";
					html += "		</p>";
					html += "	</td>";
					html += "</tr>";
					
				}
				$("#listTable").html(html);
				List.fn.trClick();
				$("#paging").html(common.paging.getNavigator(pageSettings));
			}
		},
		
		//페이징 조회
		goPage : function(pageNo){
			List.currentPage = pageNo;
			List.fn.getList();
		},
		
		trClick : function(){
			$('.que').on('click',function(){
				$(this).toggleClass('on');
				$(this).next('tr.ans').toggleClass('on');
			});
		}
	}
}