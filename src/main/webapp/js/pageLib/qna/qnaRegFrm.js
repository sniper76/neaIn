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
		
	},

	afterBind: function() {
		
	},
	fn: {
		
		/** 게시물 데이터**/
		bsnsQnaRegBtn : function() {
			
			if(!List.fn.bsnsQnaRegValidation()) {
				return;
			}
			
			var emailReceiveYn = "N";
			
			if ($("#emailReceiveYn").is(":checked")) {
				emailReceiveYn = "Y";
			}
			
			FileUtil.fn.setFileUpload();
			
			var param = {
				"tel"			:	$.trim($("#tel").val()),
				"email"			:	$.trim($("#email").val()),
				"qnaTitle"		:	$.trim($("#qnaTitle").val()),
				"qnaContents"	:	$.trim($("#qnaContents").val()),
				"bsnsSeq"		:	$("#bsnsSeq").val(),
				"emailReceiveYn":	emailReceiveYn
			};
			
			if($("#fileDiv #attachGroupId").val() != "0"){
				param['fileGroupId'] = $("#fileDiv #attachGroupId").val();
			}
			
			if (confirm("등록 하시겠습니까?")) {
				var	opts = {
						url		: contextPath + "/qna/setQnaQuestionInsert.do",
						data	: param,
						type	: "post",
						sendDataType	: "json",
						success	: function(resJSON, resCode) {
							if(resJSON.data.resultCode == '0000') {
								$.alert("등록되었습니다.");
								location.href=contextPath + "/qna/qnaListView.do?bsnsSeq=" + $("#bsnsSeq").val();
								return;
							}
						}
					};
					common.http.ajax(opts);
			}
			
			
		},
		
		bsnsQnaRegValidation : function() {
			if($.trim($("#tel").val()) == "") {
				$("#tel").focus(); $.alert("전화번호를 입력하세요"); return false;
			}
			if($.trim($("#email").val()) == "") {
				$("#email").focus();$.alert("이메일을 입력하세요");  return false;
			}
			if($.trim($("#qnaTitle").val()) == "") {
				$("#qnaTitle").focus();$.alert("제목을 입력하세요");  return false;
			}
			if($.trim($("#qnaContents").val()) == "") {
				$("#qnaContents").focus();$.alert("내용을 입력하세요");  return false;
			}
			
			return true;
		}
		
	}
}