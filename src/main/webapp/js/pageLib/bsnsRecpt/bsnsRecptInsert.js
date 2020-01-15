var	bsnsRecptInsert = {
	//----------------------------
	// InfoIndex 객체
	//----------------------------
	name: 'bsnsRecptInsert',
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
		bsnsRecptInsert.fn.getAttachNm();
	},

	bind: function() {
		
		bsnsRecptInsert.fn.getList();
		
	},

	afterBind: function() {
		common.sys.inputLimitLength("maxChk");
		
		//등록
		$('#btn_save').on('click', function(){
			if(bsnsRecptInsert.fn.valCheck()){
				bsnsRecptInsert.fn.setBsnsRecptInsert("N");
			}
		});
		
		// 임시저장
		$('#btn_tempSave').on('click', function(){
			/*if(bsnsRecptInsert.fn.valCheck()){
				bsnsRecptInsert.fn.setBsnsRecptInsert("Y");
			}*/
			bsnsRecptInsert.fn.setBsnsRecptInsert("Y");
		});
		
		// 이전 단계
		$('#btn_prev').on('click', function(){
			history.back();
		});
		
		// 주소 찾기
		$('#bnt_findAddr').on('click', function(){
			new daum.Postcode({
		        oncomplete: function(data) {
		        	// 주소 지정 (선택한 주소 타입에 따라 다름 * 지번/도로명)
		           $('#addr').val(data.address);
		           $('#post').val(data.zonecode);
		        }
		    }).open();
		});
		
	},
	fn: {
		
		/* 신청양식 첨부파일명 조회 */
		getAttachNm : function() {
			var param = {
					"bsnsSeq" : $('#bsnsSeq').val()
				};
				var	opts = {
					url		: contextPath + "/bsnsRecpt/getAttachNm.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						// 목록 데이터 그리기
						$('#attachNm').html(resJSON.data.recptAttachNm);
					}
				};
				common.http.ajax(opts);
		},
		
		/** 게시물 데이터**/
		getList : function() {
			var param = {
				"bsnsSeq" : $('#bsnsSeq').val()
			};
			var	opts = {
				url		: contextPath + "/bsnsRecpt/getAddItemList.do",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {
					// 목록 데이터 그리기
					bsnsRecptInsert.fn.drawList(resJSON.data);
				}
			};
			common.http.ajax(opts);
		},
		
		/** 게시물 그리기 **/
		drawList : function(dataJson) {
			
			
			
			var html = "";
			
			for(var i in dataJson.list){
				var objValue = dataJson.list[i];
				
				html += "<tr class='addItem_tr'>";
				html += "<th scope='row'><label for='' id='addItem_title'><span class='must'></span>" + objValue.itemCdName + "</label></th>";
				html += "<td colspan='3'>";
				html += "<input type='hidden' class='pptYnFlag' value='" + objValue.pptYn + "'>";
				html += "<input type='hidden' class='duplYnFlag' value='" + objValue.duplYn + "'>";
				
				if(objValue.pptYn == "N"){
					
					if(objValue.valTypeCd == "01"){
						html += "<textarea class='form-control w100p addItem isNumberTrue maxChk' maxChk='" + objValue.textLength + "' style='height:"+objValue.textLineCnt+"px' id='" + objValue.itemCd + "' >" + objValue.usrValue + "</textarea>";
					}else if(objValue.valTypeCd == "02"){
						html += "<textarea class='form-control w100p addItem isNumberFalse maxChk' maxChk='" + objValue.textLength + "' style='height:"+objValue.textLineCnt+"px' id='" + objValue.itemCd + "' >" + objValue.usrValue + "</textarea>";
					}else{
						html += "<textarea class='form-control w100p addItem maxChk' maxChk='" + objValue.textLength + "' style='height:"+objValue.textLineCnt+"px' id='" + objValue.itemCd + "' >" + objValue.usrValue + "</textarea>";
					}
					
				}else{
					if(objValue.duplYn == "Y"){
						
						html += "<div class='row'>";
						html += "<div class='col-md-12'>";
						html += "<div class='labelWrap'>";
						
						for(var j in objValue.addPptList){
							var addPptValue = objValue.addPptList[j];
							html += "<label><input type='checkbox' class='addItem' id='" + objValue.itemCd + "' value='" + addPptValue.pptCd + "' addPptSeq='"+addPptValue.addPptSeq+"' />" + addPptValue.pptName + "</label>";
						}
						
						html += "</div>";
						html += "</div>";
						html += "</div>";
						
					}else if(objValue.duplYn == "N"){
						for(var j in objValue.addPptList){
							var addPptValue = objValue.addPptList[j];
							html += "<label><input type='radio' class='addItem' id='" + objValue.itemCd + "' name='addItem_" + i + "' value='" + addPptValue.pptCd + "' addPptSeq='"+addPptValue.addPptSeq+"' />" + addPptValue.pptName + "</label>";
						}
					}
				}
				
				html += "</td>";
				html += "</tr>";
				
			}
			
			$('#addItemList_tbody').after(html);
			
			common.sys.inputRule("isNumberTrue", true);
			common.sys.inputRule("isNumberFalse", false);
			
			common.sys.inputLimitLength("maxChk");
			
		},
		
		valCheck : function(){
			var usrName				= $("#usrName").val();
			var birthDate			= $.trim($('#birthDate').val());
			var addr				= $.trim($('#addr').val());
			var tel1			= $.trim($('#tel1').val());
			var tel2			= $.trim($('#tel2').val());
			var tel3			= $.trim($('#tel3').val());
			var cell		= $.trim($('#cell').val());
			var email		= $.trim($('#email').val());
			var attach			= $.trim($('#attach').val());
			var lastSchl			= $.trim($('#lastSchl').val());
			var lang		= $.trim($('#lang').val());
			var genderCd		= $.trim($('#genderCd').val());
			var joinJobFair		= $.trim($('#joinJobFair').val());
			var contents		= $.trim($('#contents').val());
			var fileCnt			= FileUtil.fn.getFileCnt("fileDiv");
			
			if(usrName == ''){
				$.alert('이름을 입력해주시기 바랍니다.', function(){
					$('#usrName').focus();	
				});
				return false;
			}
			if(birthDate == ''){
				$.alert('생일을 입력해주시기 바랍니다.', function(){
					$('#birthDate').focus();	
				});
				return false;
			}
			if(addr == ''){
				$.alert('주소를 입력해주시기 바랍니다.', function(){
					$('#addr').focus();	
				});
				return false;
			}
			if(tel1 == ''){
				$.alert('연락처를 입력해주시기 바랍니다.', function(){
					$('#tel1').focus();	
				});
				return false;
			}
			if(tel2 == ''){
				$.alert('연락처를 입력해주시기 바랍니다.', function(){
					$('#tel2').focus();	
				});
				return false;
			}
			if(tel3 == ''){
				$.alert('연락처를 입력해주시기 바랍니다.', function(){
					$('#tel3').focus();	
				});
				return false;
			}
			if(cell == ''){
				$.alert('휴대폰번호를 입력해주시기 바랍니다.', function(){
					$('#cell').focus();	
				});
				return false;
			}
			if(email == ''){
				$.alert('email주소를 입력해주시기 바랍니다.', function(){
					$('#email').focus();	
				});
				return false;
			}
			if(attach == ''){
				$.alert('소속을 입력해주시기 바랍니다.', function(){
					$('#attach').focus();	
				});
				return false;
			}
			if(lastSchl == ''){
				$.alert('최종학력/전공을 입력해주시기 바랍니다.', function(){
					$('#lastSchl').focus();	
				});
				return false;
			}
			if(lang == ''){
				$.alert('보유어학능력을 입력해주시기 바랍니다.', function(){
					$('#lang').focus();	
				});
				return false;
			}
			if(genderCd == ''){
				$.alert('성별을 입력해주시기 바랍니다.', function(){
					$('#genderCd').focus();	
				});
				return false;
			}
			if(joinJobFair == ''){
				$.alert('참여취업박람회를 입력해주시기 바랍니다.', function(){
					$('#joinJobFair').focus();	
				});
				return false;
			}
			if(contents == ''){
				$.alert('내용을 입력해주시기 바랍니다.', function(){
					$('#contents').focus();	
				});
				return false;
			}
			if(fileCnt == 0){
				$.alert('신청서 첨부파일을 등록해주시기 바랍니다.');
				return false;
			}
			
			var validatorChk = true;
			// 추가 속성 값 체크
			$('.addItem_tr').each(function(){
				var addItem_title = $(this).find('#addItem_title').text();
				var pptYnFlag = $(this).find('.pptYnFlag').val();
				var duplYnFlag = $(this).find('.duplYnFlag').val();
				var usrValue = "";
				
				if(pptYnFlag == "N"){
					usrValue = $(this).find('.addItem').val();
					var usrObj = $(this).find('.addItem');
					if(usrValue == ""){
						$.alert(addItem_title + '를 입력해주시기 바랍니다.',function(){
							usrObj.focus();
						});
						validatorChk = false;
						return false;
					}
				}else{
					if(duplYnFlag == "Y"){						
						usrValue = "";
						$(this).find('.addItem').each(function(){
							if($(this).prop('checked')){
								usrValue += $(this).val();
							}
						});
						
						if(usrValue == ""){
							$.alert(addItem_title + '를 입력해주시기 바랍니다.');
							validatorChk = false;
							return false;
						}
					}else{
						usrValue = "";
						usrValue = $(this).find('.addItem:checked').val();
						
						if(usrValue == "" || usrValue == undefined ){
							$.alert(addItem_title + '를 입력해주시기 바랍니다.');
							validatorChk = false;
							return false;
						}
					}
				}
				
			});
			
			return validatorChk;
			
		},
		
		// 사업 저장
		setBsnsRecptInsert : function(tempYn){
			var msg = "등록";
			
			if(tempYn == "Y"){
				msg = "임시저장";
			}
			
			$.confirm(msg+' 하시겠습니까?', function(){
				var bsnsRecptPptList = [];
				
				$('.addItem_tr').each(function(){
					var pptYnFlag = $(this).find('.pptYnFlag').val();
					var duplYnFlag = $(this).find('.duplYnFlag').val();
					
					if(pptYnFlag == "N"){
						var obj = new Object();
						obj.bsnsSeq = $('#bsnsSeq').val();
						obj.itemCd = $(this).find('.addItem').attr('id');
						obj.usrValue = $(this).find('.addItem').val();
						obj.pptName = $(this).find('#addItem_title').text();
						bsnsRecptPptList.push(obj);
						
					}else{
						if(duplYnFlag == "Y"){
							$(this).find('.addItem').each(function(){
								if($(this).prop('checked')){
									var obj = new Object();
									obj.bsnsSeq = $('#bsnsSeq').val();
									obj.itemCd = $(this).attr('id');
									obj.usrValue = $(this).val();
									obj.pptName = $(this).closest('label').text();
									obj.addPptSeq = $(this).attr('addPptSeq');
									bsnsRecptPptList.push(obj);
								}
							});
						}else{
							var obj = new Object();
							obj.bsnsSeq = $('#bsnsSeq').val();
							obj.itemCd = $(this).find('.addItem:checked').attr('id');
							obj.usrValue = $(this).find('.addItem:checked').val();
							obj.pptName = $(this).find('.addItem:checked').closest('label').text();
							obj.addPptSeq = $(this).find('.addItem:checked').attr('addPptSeq');
							bsnsRecptPptList.push(obj);
						}
					}
					
				});
				
				FileUtil.fn.setFileUpload();
				
				var param = {
					"bsnsSeq" : $('#bsnsSeq').val(),
					"usrName" : $("#usrName").val(),
					"birthDate" : $.trim($('#birthDate').val()),
					"addr" : $.trim($('#addr').val()),
					"detailAddr" : $.trim($('#detailAddr').val()),
					"detailAddr" : $.trim($('#detailAddr').val()),
					"tel1" : $.trim($('#tel1').val()),
					"tel2" : $.trim($('#tel2').val()),
					"tel3" : $.trim($('#tel3').val()),
					"cell" : $.trim($('#cell').val()),
					"email"	: $.trim($('#email').val()),
					"attach" : $.trim($('#attach').val()),
					"lastSchl" : $.trim($('#lastSchl').val()),
					"lang" : $.trim($('#lang').val()),
					"genderCd" : $.trim($('#genderCd').val()),
					"joinJobFair" : $.trim($('#joinJobFair').val()),
					"contents" : $.trim($('#contents').val()),
					"bsnsRecptPptListArray" : bsnsRecptPptList,
					"tempYn" : tempYn,
					"agreeYn" : 'Y',
					"veryfyStatusCd" : '01'
				};
				
				if($("#fileDiv #attachGroupId").val() != "0"){
					param['fileGroupId'] = $("#fileDiv #attachGroupId").val();
				}
				
				var	opts = {
					url		: contextPath + "/bsnsRecpt/setBsnsRecptInsert.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						location.href = contextPath + "/bsnsRecpt/recptCompleteView.do?tempYn=" + tempYn;
					}
				};
				common.http.ajax(opts);
			});
			
		}
		
	}
}