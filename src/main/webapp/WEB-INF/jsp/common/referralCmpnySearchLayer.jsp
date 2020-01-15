<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(document).ready(function(){

});


function initferralCmpnySearchLayer() {
	$("#cmpnySearchModalContent").empty();
	var param = {lang: lang};
	
	var	opts = {
			url		: contextPath + "/internal/referral/referralCmpnySearchLayerAjax.do",
			type	: "post",
			sendDataType	: "html",
			data : param,
			success	: function(resHTML, resCode) {
				$("#cmpnySearchModalContent").append(resHTML);
			},
			error : function() {
				
			}
	};
	common.http.ajax(opts);
}

function popreferralCmpnySearchLayerBtn() {
	
	event.preventDefault();
    $("#cmpnySearchModalContent").css({'max-width': '700px'});
	$("#cmpnySearchModalContent").modal();
	
	initferralCmpnySearchLayer()
}
	
	
</script>	

<div class="modal" id="cmpnySearchModalContent">  
</div>
<input type="hidden" name="popCmpnySeq" id="popCmpnySeq" />
<input type="hidden" name="popCmpnyNmKh" id="popCmpnyNmKh" />
<input type="hidden" name="popCmpnyNmEn" id="popCmpnyNmEn" />
