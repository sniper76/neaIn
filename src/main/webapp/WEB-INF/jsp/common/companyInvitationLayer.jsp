<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/inc.jsp" %>

<script>
$(document).ready(function(){
	$('.btn_coInvitationPopupClose').on('click', function(){
		var html = "<td colspan='7'>No data.</td>";
		$('#popup_tbody').html(html);

		var popupObj = $('#coInvitationPopup');
		popupObj.find('#mstJcCd').val('');
		popupObj.find('#searchKeyword').val('');
		popupObj.find('#searchValue').val('');
		popupObj.find('#compnyTypeCd').val('');
		popupObj.find('#nationCd').val('');

		$('#coInvitationPopup').hide();
	});

	$('#popup_search').on('click', function(){
		var popupObj = $('#coInvitationPopup');
		var mstJcCd = popupObj.find('#mstJcCd').val();
		var searchKeyword = popupObj.find('#searchKeyword').val();
		var searchValue = popupObj.find('#searchValue').val();
		var compnyTypeCd = popupObj.find('#compnyTypeCd').val();
		//var sectorCd = popupObj.find('#sectorCd').val();
		var nationCd = popupObj.find('#nationCd').val();

		$.ajax({
			type: 'post',
			url: contextPath + "/internal/fair/searchCoInvitation.do",
			dataType: 'json',
			data: {
				"fairSeq" : $('#fairSeq').val(),
				"mstJcCd" : mstJcCd,
				"searchKeyword" : searchKeyword,
				"searchValue" : searchValue,
				"compnyTypeCd" : compnyTypeCd,
				//"sectorCd" : sectorCd,
				"nationCd" : nationCd
			},
			success: function(data) {
				var html = "";
				if(data.result != null && data.result.length > 0){
					for(var i in data.result){
						var resultObj = data.result[i];

						html += "<tr>";
						html += "<td><input type='checkbox' value='" + resultObj.compnySeq + "' class='chk'/></td>";
						html += "<td>" + resultObj.compnyTypeNm + "</td>";
						html += "<td>" + resultObj.compnyNm + "</td>";
						html += "<td>" + resultObj.regNum + "</td>";
						html += "<td>" + resultObj.mngerNm + "</td>";
						html += "<td>" + resultObj.mngerEmail + "</td>";
						html += "<td>" + resultObj.mngerCell + "</td>";
						html += "</tr>";
					}

				}else{
					html = "<td colspan='7'>No data.</td>";
				}

				$('#popup_tbody').html(html);

			},
			error: function(xhr, status, error) {

			}
		});
	});

	$('.chkAll').on('click', function(){
		if($(this).prop('checked')){
			$('.chk').prop('checked', true);
		}else{
			$('.chk').prop('checked', false);
		}
	});

	$('.btn_save').on('click', function(){
		var compnySeqList = [];
		$('.chk').each(function(){
			if($(this).prop('checked')){
				compnySeqList.push($(this).val());
			}
		});

		if(compnySeqList.length == 0){
			alertify.alert("<spring:message code='invitation.compny.noSelect'/>");
			return false;
		}

		$.ajax({
			type: 'post',
			url: contextPath + "/internal/fair/insertFairPatcptnCompny.do",
			dataType: 'json',
			data: {
				"fairSeq" : $('#fairSeq').val(),
				"compnySeqListStr" : JSON.stringify(compnySeqList)
			},
			success: function(data) {

				if(data.result == compnySeqList.length){
					alertify.alert("<spring:message code='invitation.compny.compelete'/>", function(){
						location.reload();
					});
				}else{
					alertify.alert("<spring:message code='resume.write.insert.error'/>");
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("<spring:message code='resume.write.insert.error'/>");
			}
		});
	});

});

</script>

<div id="coInvitationPopup" style="position: fixed; top: 0; right: 0; bottom: 0; left: 0; z-index: 1000; background-color: rgba(0,0,0, 0.4); overflow-x: hidden; display: none;">
	<div class="popup_box " style="position: fixed; width: 60%; top: 15%; left: 25%;">
		<div class="bbs_popup"><!-- 팝업 가로, 세로 지정하지 않았습니다. 필요에 딸라 지정해서 사용 -->
			<section class="box_wrap">
				<div class="title_box">
					<h1 class="title"><span id="popup_title"></span> Selection</h1>
				</div>
				<div class="search_box">
					<div class="contents_box">
						<fieldset>
							<table>
								<colgroup>
									<col style="width:10%;" />
									<col style="width:40%;" />
									<col style="width:10%;" />
									<col style="width:40%;" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row"><spring:message code="field.dic.jobcntr" /></th>
										<td colspan="3">
											<commCode:commcode codeKind="jcCode" tagName="mstJcCd" grpCd="" drawType="select" initValue="" exceptValue="" disable=""/>
										</td>
									</tr>
									<tr>
										<th scope="row"><spring:message code="field.dic.srchdiv" /></th>
										<td>
											<commCode:commcode codeKind="commCode" tagName="searchKeyword" grpCd="SRCH_DIV_CD" drawType="select" initValue="" exceptValue="SDC0000000001,SDC0000000003,SDC0000000004,SDC0000000008,SDC0000000010" disable=""/>
											<input type="text" id="searchValue" name="searchValue" value= "" />
										</td>
										<th scope="row"><spring:message code="field.dic.compny.type" /></th>
										<td>
											<commCode:commcode codeKind="commCode" tagName="compnyTypeCd" grpCd="COMPNY_TYPE_CD" drawType="select" initValue="" exceptValue="" disable=""/>
										</td>
									</tr>
									<tr>
										<%-- <th scope="row"><spring:message code="field.dic.sector" /></th>
										<td>
											<commCode:commcode codeKind="isicCode" tagName="sectorCd" grpCd="" drawType="select" initValue="" exceptValue="" disable=""/>
										</td> --%>
										<th scope="row"><spring:message code="invitation.field.nation" /></th>
										<td colspan="3">
											<commCode:commcode codeKind="commCode" tagName="nationCd" grpCd="NATION_CD" drawType="select" initValue="" exceptValue="" disable=""/>
										</td>
									</tr>
								</tbody>
							</table>
							<div class="put_box">
								<input type="button" value="SEARCH" id="popup_search" class="bbs_btn save" />
							</div>
						</fieldset>

						<div class="bbs_scroll_y">
							<div class="bbs_basic">
								<table id="compnyInvitationTable" class="bbs_table" style="color: white;">
									<caption>{Board name} Write - 상담게시판, 제목, 상담상태, 공개여부, 첨부파일, 작성자, 좋아요수, 조회수, 등록일</caption>
										<colgroup>
											<col style="width:5%;" />
											<col style="width:10%;" />
											<col style="width:20%;" />
											<col style="width:20%;" />
											<col style="width:10%;" />
											<col style="width:25%;" />
											<col style="width:10%;" />
											<col style="width:10%;" />
										</colgroup>
								    <thead>
								        <tr>
								            <th scope="col"><input type="checkbox" class="chkAll"></th>
								            <th scope="col"><spring:message code="field.dic.compny.type" /></th>
								            <th scope="col"><spring:message code="field.dic.compny.name" /></th>
								            <th scope="col"><spring:message code="field.dic.reg.num" /></th>
								            <th scope="col"><spring:message code="field.dic.resprsnnm" /></th>
								            <th scope="col"><spring:message code="userChg.list.title.email" /></th>
								            <th scope="col"><spring:message code="userChg.list.title.cell" /></th>
								        </tr>
								    </thead>
								    <tbody id="popup_tbody">
								    	<tr>
								    		<td colspan="7">No data.</td>
								    	</tr>
								    </tbody>
								</table>
							</div>
						</div>

						<div class="button_box">
							<button type="button" class="bbs_btn save btn_save">Select</button>
							<button type="button" class="bbs_btn cancel btn_coInvitationPopupClose">Cancel</button>
						</div>
						<button type="button" class="close btn_coInvitationPopupClose">close of popup</button>

					</div>
				</div>
			</section>
		</div>
	</div>
</div>