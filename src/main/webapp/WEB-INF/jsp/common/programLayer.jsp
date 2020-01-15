<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="modal" id="programModalContent">
  
</div>




<!-- //bbs_popup -->

<script>
function initProgramPopLayer() {
	$("#programModalContent").empty();
	
		var	opts = {
				url		: contextPath + "/common/selectProgramLayerList.do?rangeCd=" + $("#rangeCd").val(),
				type	: "post",
				sendDataType	: "html",
				success	: function(resHTML, resCode) {
					$("#programModalContent").append(resHTML);
					//$("#seqVal").val(seqVal);
				},
				error : function() {
					
				}
			};
			common.http.ajax(opts);
}

function popProgramLayerBtn() {
	event.preventDefault();
	$("#programModalContent").modal();
	initProgramPopLayer();
}
</script>