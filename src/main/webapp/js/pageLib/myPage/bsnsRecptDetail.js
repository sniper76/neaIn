var	bsnsRecptDetail = {
	//----------------------------
	// InfoIndex 객체
	//----------------------------
	name: 'bsnsRecptDetail',
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
		$('#btn_cancel').hide();
		$('#btn_save').hide();
		$('#btn_reqst').hide();
	},

	bind: function() {
		
		bsnsRecptDetail.fn.getDetail();
		
	},

	afterBind: function() {
		
		//취소
		$('#btn_cancel').on('click', function(){
			if(bsnsRecptDetail.fn.valCheck()){
				bsnsRecptDetail.fn.setbsnsRecptCancel();
			}
		});
		
		//수정
		$('#btn_save').on('click', function(){
			if(bsnsRecptDetail.fn.valCheck()){
				bsnsRecptDetail.fn.setBsnsRecptUpdate();
			}
		});
		
		//면접정장신청하기
		$('#btn_reqst').on('click', function(){
			location.href = contextPath + "/bsnsRecpt/interviewSuitView.do"+$('#bsnsSeq').val();
		});
		
		// 주소 찾기
		$('#bnt_findAddr').on('click', function(){
			new daum.Postcode({
		        oncomplete: function(data) {
		        	// 주소 지정 (선택한 주소 타입에 따라 다름 * 지번/도로명)
		           $('#addr').val(data.address);
		        }
		    }).open();
		});
		
	},
	fn: {
		
		/** 게시물 데이터**/
		getDetail : function() {
			
			var fileGroupId = "0";
			var param = {
				"recptSeq" : $('#recptSeq').val(),
				"bsnsSeq" : $('#bsnsSeq').val()
			};
			
			var	opts = {
				url		: contextPath + "/myPage/getBsnsRecptDetail.do",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				async	: false,
				success	: function(resJSON, resCode) {
					var detailInfo = resJSON.data;
					
					$("#usrName").val(detailInfo.usrName);
					$('#birthDate').val(detailInfo.birthDate);
					$('#addr').val(detailInfo.addr);
					$('#detailAddr').val(detailInfo.detailAddr);
					$('#tel1').val(detailInfo.tel1);
					$('#tel2').val(detailInfo.tel2);
					$('#tel3').val(detailInfo.tel3);
					$('#cell').val(detailInfo.cell);
					$('#email').val(detailInfo.email);
					$('#attach').val(detailInfo.attach);
					$('#lastSchl').val(detailInfo.lastSchl);
					$('#lang').val(detailInfo.lang);
					$('#genderCd').val(detailInfo.genderCd);
					$('#joinJobFair').val(detailInfo.joinJobFair);
					$('#contents').val(detailInfo.contents);
					
					$('#fileDiv #attachGroupId').val(detailInfo.fileGroupId);
					
					
					if(detailInfo.cancelYn != 'Y'){
						if(detailInfo.cancelChk != '0'){
							$('#btn_cancel').show();
						}
						
						if(detailInfo.updateChk != '0'){
							$('#btn_save').show();
						}
						
						if(detailInfo.veryfyStatusCd == '02'){
							$('#btn_reqst').show();
						}
					}
					
				}
			};
			common.http.ajax(opts);
			
			var	opts2 = {
				url		: contextPath + "/bsnsRecpt/getAddItemList.do",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				async	: false,
				success	: function(resJSON, resCode) {
					// 데이터 그리기
					bsnsRecptDetail.fn.drawList(resJSON.data);
					
				}
			};
			common.http.ajax(opts2);
			
			if($('#btn_save').css('display') == 'none'){
				FileUtil.fn.setFileViewMode('fileDiv');
				$("#recpt_info :input").prop("disabled", true);
			}
			
			var	opts3 = {
				url		: contextPath + "/myPage/getBsnsAdminFeedbackList.do",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				async	: false,
				success	: function(resJSON, resCode) {
					// 데이터 그리기
					bsnsRecptDetail.fn.drawFeedbackList(resJSON.data);
				}
			};
			common.http.ajax(opts3);
			
			
			common.invoker.invoke("FileUtil");
			
			FileUtil.fn.getFileList($('#fileDiv #attachGroupId').val(),'fileDiv');
			
		},
		
		/** 게시물 그리기 **/
		drawList : function(dataJson) {
			
			var html = "";
			
			for(var i in dataJson.list){
				var objValue = dataJson.list[i];
				
				html += "<tr class='addItem_tr'>";
				html += "<th scope='col'><label for='' id='addItem_title'><span class='must'></span>" + objValue.itemCdName + "</label></th>";
				html += "<td colspan='3'>";
				html += "<input type='hidden' class='pptYnFlag' value='" + objValue.pptYn + "'>";
				html += "<input type='hidden' class='duplYnFlag' value='" + objValue.duplYn + "'>";
				
				if(objValue.pptYn == "N"){
					
					if(objValue.valTypeCd == "01"){
						html += "<textarea class='form-control w100p addItem isNumberTrue maxChk' maxChk='" + objValue.textLength + "' style='height:"+(36*objValue.textLineCnt)+"px' id='" + objValue.itemCd + "' >" + objValue.usrValue + "</textarea>";
					}else if(objValue.valTypeCd == "02"){
						html += "<textarea class='form-control w100p addItem isNumberFalse maxChk' maxChk='" + objValue.textLength + "' style='height:"+(36*objValue.textLineCnt)+"px' id='" + objValue.itemCd + "' >" + objValue.usrValue + "</textarea>";
					}else if(objValue.valTypeCd == "03"){
						html += "<textarea class='form-control w100p addItem maxChk' maxChk='" + objValue.textLength + "' style='height:"+(36*objValue.textLineCnt)+"px' id='" + objValue.itemCd + "' >" + objValue.usrValue + "</textarea>";
					}
					
				}else{
					if(objValue.duplYn == "Y"){
						
						html += "<div class='row'>";
						html += "<div class='col-md-12'>";
						html += "<div class='labelWrap'>";
						
						for(var j in objValue.addPptList){
							var addPptValue = objValue.addPptList[j];
							var checked = ""
							if(addPptValue.usrValue != ""){
								checked = "checked";
							}
							html += "<label><input type='checkbox' class='addItem' id='" + objValue.itemCd + "' value='" + addPptValue.pptCd + "' addPptSeq='"+addPptValue.addPptSeq+"' "+checked+"/>" + addPptValue.pptName + "</label>";
						}
						
						html += "</div>";
						html += "</div>";
						html += "</div>";
						
					}else if(objValue.duplYn == "N"){
						for(var j in objValue.addPptList){
							var addPptValue = objValue.addPptList[j];
							var checked = "";
							if(addPptValue.usrValue != ""){
								checked = "checked";
							}
							html += "<label><input type='radio' class='addItem' id='" + objValue.itemCd + "' name='addItem_" + i + "' value='" + addPptValue.pptCd + "' addPptSeq='"+addPptValue.addPptSeq+"' "+checked+"/>" + addPptValue.pptName + "</label>";
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
		
		/** 게시물 그리기 **/
		drawFeedbackList : function(dataJson) {
			
			var html = "";
			
			for(var i in dataJson.list){
				var objValue = dataJson.list[i];

				html += '<tr>';
				if(i == 0){
					html += '	<th scope="row" rowspan="'+(dataJson.list.length)+'"><label for="">코멘트</label></th>';
				}
				html += '	<td>';
				html += '		<div class="row">';
				html += '			<div class="col-md-5">';
				html += '				<span class="c-cyan infoTxt">'+objValue.comment+'</span>';
				html += '			</div>';
				html += '		</div>';
				if(objValue.reqFileYn == 'Y'){
					if(objValue.fileGroupId == ''){
						html += '		<div class="row">';
						html += '			<div class="col-md-11">';
						html += '				<div class="dragAndDropDiv filebox" id="fbFileDiv'+objValue.fbSeq+'" onClick="javascript:FileUtil.fn.selectFiles(\'fbFileDiv'+objValue.fbSeq+'\');">';
						html += '					<input type="hidden" id="attachGroupId" name="attachGroupId"  value="'+(objValue.fileGroupId == ''?'0':objValue.fileGroupId)+'"/>';
						html += '				</div>';
						html += '			</div>';
						html += '			<div class="col-md-1 pl05">';
						html += '				<button type="button" class="w100p blue-white" onClick="javascript:bsnsRecptDetail.fn.setBsnsAdminFeedbackUpdate(\''+objValue.fbSeq+'\');"><span class="c-blue">등록</span></button>';
						html += '			</div>';
						html += '		</div>';
					}else{
						html += '		<div class="row">';
						html += '			<div class="col-md-12">';
						html += '				<div class="dragAndDropDiv filebox" id="fbFileDiv'+objValue.fbSeq+'" onClick="javascript:FileUtil.fn.selectFiles(\'fbFileDiv'+objValue.fbSeq+'\');">';
						html += '					<input type="hidden" id="attachGroupId" name="attachGroupId"  value="'+(objValue.fileGroupId == ''?'0':objValue.fileGroupId)+'"/>';
						html += '				</div>';
						html += '			</div>';
						html += '		</div>';
					}
				}
				html += '	</td>';
				html += '</tr>';
			}
			
			$('#feedback_tbody').append(html);
			
			for(var i in dataJson.list){
				var objValue = dataJson.list[i];
				
				if(objValue.reqFileYn == 'Y'){
					FileUtil.fileConfig.push({
						attachGroupId : "",
						attachMultiGroupId : "",
						fileCheckNum : 1,
						fileCheckType : 4,  //1==isImage , 2==isVideo , 3==isDoc 4==AllFile
						width : "",
						height : "",
						thumnailFlag : "",
						imgView : "",
						bizName : "bsns_admin_feedback_file",
						downButtonYn : "N",
						delButtonYn : "Y",		//삭제버튼 유무
						addButtonYn : "Y",		//첨부버튼 유무
						targetId : "fbFileDiv"+objValue.fbSeq
					});
				}
			}
			
			for(var i in dataJson.list){
				var objValue = dataJson.list[i];
				
				if(objValue.fileGroupId != ''){
					
					FileUtil.fn.getFileList(objValue.fileGroupId,'fbFileDiv'+objValue.fbSeq);
					
					FileUtil.fn.setFileViewMode('fbFileDiv'+objValue.fbSeq);
				}
			}
		},
		
		valCheck : function(){
			var usrName				= $("#usrName").val();
			var birthDate			= $.trim($('#birthDate').val());
			var addr				= $.trim($('#addr').val());
			var tel1			= $.trim($('#tel1').val());
			var tel2			= $.trim($('#tel2').val());
			var tel3		= $.trim($('#tel3').val());
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
					$('#009').focus();	
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
		
		// 참여 사업 수정
		setBsnsRecptUpdate : function(){
			$.confirm('수정 하시겠습니까?', function(){
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
					"recptSeq" : $('#recptSeq').val(),
					"bsnsSeq" : $('#bsnsSeq').val(),
					"usrName" : $("#usrName").val(),
					"birthDate" : $.trim($('#birthDate').val()),
					"addr" : $.trim($('#addr').val()),
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
					"tempYn" : "N",
					"agreeYn" : 'Y',
					"veryfyStatusCd" : '01'
				};
				
				if($("#fileDiv #attachGroupId").val() != "0"){
					param['fileGroupId'] = $("#fileDiv #attachGroupId").val();
				}
				
				var	opts = {
					url		: contextPath + "/myPage/setBsnsRecptUpdate.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						$.alert('수정 되었습니다.', function(){
							location.href = "/myPage/bsnsRecptListView.do";
						});
					}
				};
				common.http.ajax(opts);
			});
			
		},
		
		// 참여 사업 취소
		setbsnsRecptCancel : function(){
			$.confirm('취소 하시겠습니까?', function(){
				var param = {
						"recptSeq" : $('#recptSeq').val(),
					};
					
					var	opts = {
						url		: contextPath + "/myPage/setBsnsRecptCancelUpdate.do",
						data	: param,
						type	: "post",
						sendDataType	: "json",
						success	: function(resJSON, resCode) {
							$.alert('취소 되었습니다.', function(){
								location.href = contextPath + "/myPage/bsnsRecptListView.do";
							});
						}
					};
					common.http.ajax(opts);

			});
			
		},
		
		
		setBsnsAdminFeedbackUpdate : function(fbSeq){
			
			if(FileUtil.fn.getFileCnt("fbFileDiv"+fbSeq) == 0){
				$.alert('첨부파일을 등록해주시기 바랍니다.');
				return false;
			}
			
			$.confirm('등록 하시겠습니까?', function(){
				
				FileUtil.fn.setFileUpload();
				
				var param = {
					"fbSeq" : fbSeq,
				};
			
				if($("#fbFileDiv"+fbSeq+" #attachGroupId").val() != "0"){
					param['fileGroupId'] = $("#fbFileDiv"+fbSeq+" #attachGroupId").val();
				}
				
				var	opts = {
					url		: contextPath + "/myPage/setBsnsAdminFeedbackUpdate.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						$.alert('등록 되었습니다.', function(){
							location.reload();
						});
					}
				};
				common.http.ajax(opts);

			});
		},
		
	}
}