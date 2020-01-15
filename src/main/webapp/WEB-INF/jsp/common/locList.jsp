<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form name="addrFrm" id="addrFrm">
<input type="hidden" name="countryId" id="countryId" value="1" />
<input type="hidden" name="provinceId" id="provinceId" value="" />
<input type="hidden" name="districtId" id="districtId" value="" />
<input type="hidden" name="communeId" id="communeId" value="" />
<input type="hidden" name="villageId" id="villageId" value="" />
<input type="hidden" name="lvl" id="lvl" value="2" />
<input type="hidden" name="lvlCd" id="lvlCd" value="1" />

</form>

<div class="bbs_popup"><!-- 팝업 가로, 세로 지정하지 않았습니다. 필요에 딸라 지정해서 사용 -->
	<section class="box_wrap">
		<div class="title_box">
			<h1 class="title">Location Selection</h1>
		</div>
		<div class="contents_box">
			<div class="pop_scroll_box count4"><!-- 한줄에 들어갈 개수 변경해야 할 경우 클래스 count2 ~ count5 추가 -->
				<ul class="clearfix">
				<li class="dep1">
					<div class="scroll_box">
						<div class="scroll_title">
							<strong>Province</strong>
						</div>
						<div class="scroll_cont">
							<ul id="provinceLi">

							</ul>
						</div>
					</div>
				</li>
				<li class="dep1">
					<div class="scroll_box">
						<div class="scroll_title">
							<strong>District</strong>
						</div>
						<div class="scroll_cont">
							<ul id="districtLi">
							</ul>
						</div>
					</div>
				</li>
				<li class="dep1">
					<div class="scroll_box">
						<div class="scroll_title">
							<strong>Commune</strong>
						</div>
						<div class="scroll_cont">
							<ul id="communeLi">
							</ul>
						</div>
					</div>
				</li>
				<li class="dep1">
					<div class="scroll_box">
						<div class="scroll_title">
							<strong>Village</strong>
						</div>
						<div class="scroll_cont">
							<ul id="villageLi">
							</ul>
						</div>
					</div>
				</li>
				</ul>
			</div>
			<div class="button_box">
				<button type="button" class="btn btn-primary" onclick="goSel();"  data-dismiss="modal">Select</button>
				<button type="button" class="btn btn-default" onclick="fnPopupClose();">Cancel</button>
			</div>
		</div>
		<button type="button" class="close" onclick="fnPopupClose();">close of popup</button>
	</section>
</div>


<!-- //bbs_popup -->

<script>

$(document).ready(function(){
	//$("#addrModal").modal('show');
	addrAjaxCallFunc();
});

var addrTxt = "";
var lastaddrTxt = "";
var addrFullCd = "";

function goSel() {

	var addrObj1 = $("#addrObj").val();

	/* 유승우 addrFullCd 수정 2019.11.15 */
	var provinceLvlCd = "", districtLvlCd = "", communeLvlCd = "", villageLvlCd = "";
	$('ul#provinceLi > li').each(function(i, item) { if($(this).hasClass('on')) { provinceLvlCd = ($.trim($(this).attr('id'))).replace('btn_', ''); } });
	$('ul#districtLi > li').each(function(i, item) { if($(this).hasClass('on')) { districtLvlCd = ($.trim($(this).attr('id'))).replace('btn_', ''); } });
	$('ul#communeLi > li').each(function(i, item) { if($(this).hasClass('on')) { communeLvlCd = ($.trim($(this).attr('id'))).replace('btn_', ''); } });
	$('ul#villageLi > li').each(function(i, item) { if($(this).hasClass('on')) { villageLvlCd = ($.trim($(this).attr('id'))).replace('btn_', ''); } });
	addrFullCd = provinceLvlCd + (districtLvlCd != "" ? "," + districtLvlCd : "") + (communeLvlCd != "" ? "," + communeLvlCd : "") + (villageLvlCd != "" ? "," + villageLvlCd : "");
	/* 유승우 addrFullCd 수정 2019.11.15 */

	var addrFullObj1 = $("#addrFullObj").val();
	var addrFullObjTxt1 = $("#addrFullObjTxt").val();
	var addrFullObjTxtView1 = $("#addrFullObjTxtView").val();
/*
	alert(addrFullObj1);
	alert(addrFullObjTxt1);
	alert(addrFullObjTxtView1);
 */

	var multiFlag = $("#multiFlag").val();

	if(multiFlag == "true"){
		if(typeof callbackFnNm == 'function'){
			var obj = new Object();
			obj.commonNm = lastaddrTxt;
			obj.commonCd = $("#lvlCd").val();
			obj.commonFullCd = addrFullCd;
			obj.commonFullNm = addrTxt;
			$("#addrModalContent").modal('hide');
		 	$("#addrModalContent").find('a.close-modal').trigger('click');
			callbackFnNm(obj);
		}
	}else{
		if(eventObj != null){
			$(eventObj).closest('tr').find("#" + addrObj1).val($("#lvlCd").val());
			$(eventObj).closest('tr').find("#" + addrFullObj1).val(addrFullCd);
			$(eventObj).closest('tr').find("#" + addrFullObjTxt1).val(addrTxt);
			$(eventObj).closest('tr').find("#" + addrFullObjTxtView1).text(addrTxt);
		}else{
			$("#" + addrObj1).val($("#lvlCd").val());
			$("#" + addrFullObj1).val(addrFullCd);
			$("#" + addrFullObjTxt1).val(addrTxt);
			$("#" + addrFullObjTxtView1).text(addrTxt);
		}

	}

/*
	alert($("#" + addrFullObj1).val());
	alert($("#" + addrFullObjTxt1).val());
	alert($("#" + addrFullObjTxtView1).val());

	alert(addrFullCd);
	alert(addrTxt);
	alert($("#lvlCd").val());
 */
 	$("#multiFlag").val('');
	$("#addrModalContent").modal('hide');
 	$("#addrModalContent").find('a.close-modal').trigger('click');

}

function addrAjaxCallFunc() {

	var param = { "provinceId" : $("#provinceId").val()
			, "districtId" : $("#districtId").val()
			, "communeId" : $("#communeId").val()
			, "villageId" : $("#villageId").val()
			, "lvl" : $("#lvl").val()
			};

	var	opts = {
			url		: contextPath + "/common/selectLocListAjax.do",
			type	: "post",
			data	: param,
			sendDataType	: "json",
			success	: function(resJSON, resCODE) {
				// failed
				makeLi(resJSON.data.list);
			},
			error : function() {

			}
		};
		common.http.ajax(opts);
}

function makeLi(list) {
	var html = "";
	var lvlVal = "";

	var idNm = "";

	for(i =0; i < list.length; i++) {
		lvlVal = list[i].lvl;

		html += '<li class="cls_'+list[i].lvl+'" id="btn_'+list[i].lvlCd+'"><button type="button" onclick="clkProvince('+list[i].lvlCd+','+list[i].provinceId+','+list[i].districtId+','+list[i].communeId+','+list[i].villageId+',' +list[i].lvl+ ');">'+list[i].nmEn+'</button></li>';
	}


	// draw li
	if (lvlVal == "2") {
		$("#provinceLi").empty();
		$("#provinceLi").append(html);
		$("#districtLi").empty();
		$("#communeLi").empty();
		$("#villageLi").empty();
	} else if (lvlVal == "3") {
		$("#districtLi").empty();
		$("#districtLi").append(html);
		$("#communeLi").empty();
		$("#villageLi").empty();
	} else if (lvlVal == "4") {
		$("#communeLi").empty();
		$("#communeLi").append(html);
		$("#villageLi").empty();
	} else if (lvlVal == "5") {
		$("#villageLi").empty();
		$("#villageLi").append(html);
	}
}

function clkProvince(lvlCd, pid, did, cid, vid, lvl) {

	$('.cls_' + lvl).removeClass("on");
	$('#btn_' + lvlCd).addClass("on");

	$("#provinceId").val("");
	$("#districtId").val("");
	$("#communeId").val("");
	$("#villageId").val("");
	$("#lvl").val("");
	$("#lvlCd").val("");


	if(lvl == 2) {
		$("#provinceId").val(pid);
		addrFullCd = pid;
		// get Text
		$('.cls_2').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt = $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});

	} else if (lvl ==3) {
		$("#provinceId").val(pid);
		$("#districtId").val(did);
		addrFullCd = pid+'>'+did;
		var txt = "";
		$('.cls_2').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt = $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});

		$('.cls_3').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt += " > " + $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});
	} else if (lvl == 4) {
		$("#provinceId").val(pid);
		$("#districtId").val(did);
		$("#communeId").val(cid);
		addrFullCd = pid+'>'+did+'>'+cid;
		$('.cls_2').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt = $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});

		$('.cls_3').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt += " > " + $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});

		$('.cls_4').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt += " > " + $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});

	} else if (lvl == 5) {
		$("#provinceId").val(pid);
		$("#districtId").val(did);
		$("#communeId").val(cid);
		$("#villageId").val(vid);
		addrFullCd = pid+'>'+did+'>'+cid+'>'+vid;
		$('.cls_2').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt = $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});

		$('.cls_3').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt +=" > " + $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});

		$('.cls_4').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt +=" > " + $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});

		$('.cls_5').each(function(i){
			if ($(this).hasClass("on")) {
				addrTxt +=" > " + $(this).find('button').text();
				lastaddrTxt = $(this).find('button').text();
			}
		});
	}

	// 다음 주소를 조회하기 위해 레빌을 +1 한다.
	var lvlTemp2 = parseInt(lvl) + 1;

	$("#lvl").val(lvlTemp2);
	$("#lvlCd").val(lvlCd);

	// 마지막 주소는 조회 하지 않는다.
	if (lvl != 5) {
		addrAjaxCallFunc();
	}
}

function fnPopupClose(){
	$("#addrModalContent").modal('hide');
	$("#addrModalContent").find('a.close-modal').trigger('click');
}
</script>