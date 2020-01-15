<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="bbs_popup"><!-- 팝업 가로, 세로 지정하지 않았습니다. 필요에 딸라 지정해서 사용 -->
	<section class="box_wrap">
		<div class="title_box">
			<h1 class="title">Selection Program</h1>
		</div>
		<div class="contents_box">
			<input type="hidden" id="seqVal" name="seqVal" value=""/>
			<div id="programList">
				
			</div>
			<div class="button_box">
				<button type="button" class="bbs_btn save" onclick="goSelMapProgram();"  data-dismiss="modal">Select</button>
				<button type="button" class="bbs_btn cancel" data-dismiss="modal" onclick="forceClose();">Cancel</button>
			</div>
		</div>
		<button type="button" class="close" onclick="forceClose();">close of popup</button>
	</section>
</div>
		
<script>

$(document).ready(function(){
	//$("#addrModal").modal('show');
	addrAjaxCallFunc();
});

function addrAjaxCallFunc() {
	
	var param = { "rangeCd" : $("#rangeCd").val()};
	var	opts = {
			url		: contextPath + "/common/selectProgramLayerListAjax.do",
			type	: "post",
			data	: param,
			sendDataType	: "json",
			success	: function(resJSON, resCODE) {
				// failed
				makeLi(resJSON.data.list);
			},
			error : function() {
				
			}
		};
		common.http.ajax(opts);
}

function makeLi(list) {
	var html = "";
	html +='<div class="bbs_info clearfix">';
	html +='	<div class="bbs_right bbs_category">';
	html +='		<select name="searchKeyword" id="searchKeyword" title="select division">';
	html +='			<option value="">Program ID</option>';
	html +='			<option value="">Program NAME</option>';
	html +='		</select>';
	html +='		<input type="text" id="searchValue" class="input_text" name="searchValue" title="input Search" />';
	html +='		<input type="button" class="bbs_btn type03" value="Search" />';
	html +='	</div>';
	html +='</div>';
	html +='<div class="bbs_scroll_y">';
	html +='	<table class="bbs_table">';
	html +='		<caption>Selection Program</caption>';
	html +='		<colgroup>';
	html +='			<col style="width:8%;" />';
	html +='			<col style="width:18%;" />';
	html +='			<col style="width:37%;" />';
	html +='			<col style="width:37%;" />';
	html +='		</colgroup>';
	html +='		<thead class="text_center">';
	html +='		<tr>';
	html +='			<th scope="row">Select</th>';
	html +='			<th scope="row">Program ID</th>';
	html +='			<th scope="row">Program Name</th>';
	html +='			<th scope="row">URL</th>';
	html +='		</tr>';
	html +='		</thead>';
	html +='		<tbody>';

	for(i =0; i < list.length; i++) {
		html += '<tr>';
		html += '	<td class="text_center"><input type="checkbox" name="radioProgramSeq[]" class="radioProgramSeq" value="'+list[i].programSeq+'"/></td>';
		html += '	<td>'+list[i].programId+'</td>';
		html += '	<td id="'+list[i].programSeq+'">'+list[i].programNm+'</td>';
		html += '	<td>'+list[i].programUrl+'</td>';
		html += '	<input type="hidden" name="radioProgramNm[]" class="radioProgramNm" value="'+list[i].programNm+'"/>';
		html += '</tr>';
	}
	html +='		</tbody>';
	html +='	</table>';
	html +='</div>';
	
	$("#programList").append(html);
}

function goSelMapProgram() {
	// var seqVal = $("#seqVal").val();
	var send_array_val = Array();
	var send_array_text = Array();
	var send_cnt = 0;
	var chkbox = $(".radioProgramSeq");

	var chkInvalid = false;
	var outputVal = "";
	var outputText = "";
	for(i=0;i<chkbox.length;i++) {
	    if (chkbox[i].checked == true){
	    	chkInvalid = true;
	    	send_array_val[send_cnt] = chkbox[i].value;
			send_array_text[send_cnt] = $("#" + chkbox[i].value).text();
	        send_cnt++;
	    }
	}
	
	/*
	$( ".radioProgramSeq" ).each(function( index ) {
			if ($(this).is(':checked')) {
				chkInvalid = true;
				
				$this = $(this).parents("tr");
				var answer = $this.find(".radioProgramNm").val();
				var seq    = $this.find(".radioProgramSeq").val();
				$("#programSeqTemp_"+seqVal).val(seq);
				$("#programNm_"+seqVal).val(answer);
				$("#priProgramYn_"+seqVal).val(seq);
			}
		});
*/
	
	if(!chkInvalid) {
		alertify.alert("please select",function(e){
			
		});
	} else {
		addProgram(send_array_val, send_array_text);
		$("#programModalContent").modal('hide');
	 	$("#programModalContent").find('a.close-modal').trigger('click');
	}
	
}

function forceClose() {
	$("#programModalContent").modal('hide');
 	$("#programModalContent").find('a.close-modal').trigger('click');
}

</script>