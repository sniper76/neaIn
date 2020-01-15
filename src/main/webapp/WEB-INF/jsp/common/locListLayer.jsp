<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
var callbackFnNm = null;
var eventObj = null;
$(document).ready(function(){
	//initAddrLayer();
});


function initAddrLayer() {
	$("#addrModalContent").empty();
		var	opts = {
				url		: contextPath + "/common/selectLocList.do",
				type	: "post",
				sendDataType	: "html",
				success	: function(resHTML, resCode) {
					$("#addrModalContent").append(resHTML);
				},
				error : function() {

				}
			};
			common.http.ajax(opts);
}

function popAddrLayerBtn(obj, objFull, objTxt, objFullTxt, htmlObj) {
	$("#addrObj").val(obj);
	$("#addrFullObj").val(objFull);
	$("#addrFullObjTxt").val(objTxt);
	$("#addrFullObjTxtView").val(objFullTxt);

	eventObj = htmlObj;
	//$("#addrModal").modal('show');
	event.preventDefault();

	$("#addrModalContent").modal();
	// init selected
	initAddrLayer();
}

function popAddrLayerBtnMulti(callback, multiFlag){
	$("#multiFlag").val(multiFlag);
	callbackFnNm = callback;

	//$("#addrModal").modal('show');
	event.preventDefault();

	$("#addrModalContent").modal();
	// init selected
	initAddrLayer();
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

<div class="modal" id="addrModalContent">

</div>
<input type="hidden" name="addrObj" id="addrObj" />
<input type="hidden" name="addrFullObj" id="addrFullObj" />
<input type="hidden" name="addrFullObjTxt" id="addrFullObjTxt" />
<input type="hidden" name="addrFullObjTxtView" id="addrFullObjTxtView" />
<input type="hidden" id="multiFlag" />