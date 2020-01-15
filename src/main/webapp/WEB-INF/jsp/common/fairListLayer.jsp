<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(document).ready(function(){
	//initAddrLayer();
});


function fairListLayer() {
	$("#fairModalContent").empty();
		var	opts = {
				url		: contextPath + "/internal/fair/fairListLayer.do",
				type	: "post",
				sendDataType	: "html",
				success	: function(resHTML, resCode) {
					$("#fairModalContent").append(resHTML);
				},
				error : function() {
					
				}
			};
			common.http.ajax(opts);
}

function popFairLayerBtn() {
	
	//$("#addrModal").modal('show');
	event.preventDefault();
	$("#fairModalContent").css({'max-width': '700px'});
	$("#fairModalContent").modal();
	// init selected
	fairListLayer()
}
	
	
</script>	
<!-- div class="modal fade" id="addrModal" tabindex="-1" role="dialog" aria-labelledby="addrModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
		<div class="modal-body" id="addrModalContent">
		</div>
    </div>
  </div>
</div-->

<div class="modal" id="fairModalContent" >
  
</div>
<input type="hidden" name="fairObj" id="fairObj" />