<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(document).ready(function(){

});


function initJobFairDtlInfoLayer() {

	$("#jobFairDtlInfoModalContent").empty();
	var param = {
					fairSeq: $("#popParamJobFairSeq").val()
				};

	var	opts = {
			url		: contextPath + "/internal/fair/selectJobFairDtlInfoAjax.do",
			type	: "post",
			sendDataType	: "html",
			data : param,
			success	: function(resHTML, resCode) {
				$("#jobFairDtlInfoModalContent").append(resHTML);
			},
			error : function() {
				
			}
	};
	common.http.ajax(opts);
}

function popJobFairDtlInfoLayerBtn(fairSeq) {

	$("#popParamJobFairSeq").val(fairSeq);
	
	event.preventDefault();

	$("#jobFairDtlInfoModalContent").modal();
	
	initJobFairDtlInfoLayer();
	
}
	
	
</script>	
  
<div class="title_box">
	<h1 class="title"><spring:message code="field.dic.fair.dtl" /></h1>
</div>

<div class="modal" id="jobFairDtlInfoModalContent">  
</div>

<input type="hidden" name="popParamJobFairSeq" id="popParamJobFairSeq" />