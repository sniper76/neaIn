<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(document).ready(function(){

});


function initReferralManageLayer(vacancySeq,resumeSeq,referralTypeCd,viewChk) {
	$("#referralManageModalContent").empty();
	var param = {vacancySeq: vacancySeq,resumeSeq: resumeSeq,referralTypeCd:referralTypeCd,viewChk:viewChk};
	
	
	var	opts = {
			url		: contextPath + "/internal/referral/referralManageLayerAjax.do",
			type	: "post",
			sendDataType	: "html",
			data : param,
			success	: function(resHTML, resCode) {
				$("#referralManageModalContent").append(resHTML);
			},
			error : function() {
				
			}
	};
	common.http.ajax(opts);
}

function popReferralManageLayerBtn(vacancySeq,resumeSeq,referralTypeCd,viewChk) {
	event.preventDefault();
    $("#referralManageModalContent").css({'max-width': '1000px'});
	$("#referralManageModalContent").modal();
	
	initReferralManageLayer(vacancySeq,resumeSeq,referralTypeCd,viewChk)
}
	
	
</script>	

<div class="modal" id="referralManageModalContent">  
</div>
<input type="hidden" name="popCmpnySeq" id="popCmpnySeq" />
