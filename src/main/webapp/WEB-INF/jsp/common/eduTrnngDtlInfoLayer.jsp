<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(document).ready(function(){

});


function initEduTrnngDtlInfoLayer() {

	$("#eduTrnngDtlInfoModalContent").empty();
	var param = {
					eduTrnngSeq: $("#popParamEduTrnngSeq").val()
				};

	var	opts = {
			url		: contextPath + "/internal/trnng/selectEduTrnngDtlInfoAjax.do",
			type	: "post",
			sendDataType	: "html",
			data : param,
			success	: function(resHTML, resCode) {
				$("#eduTrnngDtlInfoModalContent").append(resHTML);
			},
			error : function() {
				
			}
	};
	common.http.ajax(opts);
}

function popEduTrnngDtlInfoLayerBtn(eduTrnngSeq) {

	$("#popParamEduTrnngSeq").val(eduTrnngSeq);
	
	event.preventDefault();

	$("#eduTrnngDtlInfoModalContent").modal();
	
	initEduTrnngDtlInfoLayer();
	
}
	
	
</script>	
  
<div class="title_box">
	<h1 class="title"><spring:message code="field.dic.edu.trnng.dtl" /></h1>
</div>

<div class="modal" id="eduTrnngDtlInfoModalContent">  
</div>

<input type="hidden" name="popParamEduTrnngSeq" id="popParamEduTrnngSeq" />