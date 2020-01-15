<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(document).ready(function(){

});


function initResumeDtlInfoLayer() {

	$("#resumeDtlInfoModalContent").empty();
	var param = {
					resumeSeq: $("#popParamResumeSeq").val()
				};

	var	opts = {
			url		: contextPath + "/internal/resume/selectResumeDtlInfoAjax.do",
			type	: "post",
			sendDataType	: "html",
			data : param,
			success	: function(resHTML, resCode) {
				$("#resumeDtlInfoModalContent").append(resHTML);
			},
			error : function() {
				
			}
	};
	common.http.ajax(opts);
}

function popResumeDtlInfoLayerBtn(resumeSeq) {

	$("#popParamResumeSeq").val(resumeSeq);
	
	event.preventDefault();

	$("#resumeDtlInfoModalContent").modal();
	
	initResumeDtlInfoLayer();
	
}
	
	
</script>	
  
<div class="title_box">
	<h1 class="title"><spring:message code="field.dic.resume.dtl" /></h1>
</div>

<div class="modal" id="resumeDtlInfoModalContent">  
</div>

<input type="hidden" name="popParamResumeSeq" id="popParamResumeSeq" />