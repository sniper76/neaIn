<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(document).ready(function(){

});


function initferralUserSearchLayer() {
	$("#userSearchModalContent").empty();
	var param = {lang: lang};
	
	var	opts = {
			url		: contextPath + "/internal/referral/referralUserSearchLayerAjax.do",
			type	: "post",
			sendDataType	: "html",
			data : param,
			success	: function(resHTML, resCode) {
				$("#userSearchModalContent").append(resHTML);
			},
			error : function() {
				
			}
	};
	common.http.ajax(opts);
}

function popreferralUserSearchLayerBtn() {
	
	event.preventDefault();

	$("#userSearchModalContent").css({'max-width': '700px'});
	$("#userSearchModalContent").modal();
	
	initferralUserSearchLayer()
}
	
	
</script>	

<div class="modal" id="userSearchModalContent">  
</div>
<input type="hidden" name="popUserSeq" id="popUserSeq" />
