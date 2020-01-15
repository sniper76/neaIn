<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(document).ready(function(){

});


function initVacancyDtlInfoLayer() {

	$("#vacancyDtlInfoModalContent").empty();
	var param = {
					vacancySeq: $("#popParamVacancySeq").val()
				};
	
	var	opts = {
			url		: contextPath + "/internal/vacancy/selectVacancyDtlInfoAjax.do",
			type	: "post",
			sendDataType	: "html",
			data : param,
			success	: function(resHTML, resCode) {
				$("#vacancyDtlInfoModalContent").append(resHTML);
			},
			error : function() {
				
			}
	};
	common.http.ajax(opts);
}

function popVacancyDtlInfoLayerBtn(resumeSeq) {
	
	$("#popParamVacancySeq").val(resumeSeq);
	
	event.preventDefault();

	$("#vacancyDtlInfoModalContent").modal();
	
	initVacancyDtlInfoLayer();
}
	
	
</script>	

<div class="title_box">
	<h1 class="title"><spring:message code="field.dic.vacancy.dtl" /></h1>
</div>
<div class="modal" id="vacancyDtlInfoModalContent">  
</div>

<input type="hidden" name="popParamVacancySeq" id="popParamVacancySeq" />