<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	var selectMsg 	= '<spring:message code="field.dic.one.select" text="Success"></spring:message>';
	//$(function() {
	//	common.invoker.invoke("userSearchList");
	//});
</script>

<div class="bbs_popup"><!-- 팝업 가로, 세로 지정하지 않았습니다. 필요에 딸라 지정해서 사용 -->
	<section class="box_wrap">
		<div class="title_box">
			<h1 class="title"><spring:message code="field.dic.jobsk.serach" /></h1>
		</div>
		<div class="contents_box">
			<div>
					<label for="Search_sel" class="skip">category selection</label>
					<select id="keyword_sel">
						<option value=""><spring:message code="bulletin.select.select" /></option>
						<option value="1"><spring:message code="userChg.list.title.userNm" /></option>
						<option value="2"><spring:message code="field.dic.mobile" /></option>
						<option value="3"><spring:message code="field.dic.email" /></option>
					</select>
					<label for="keyword" class="skip"></label>
					<input type="text" id="txtKeyword" value=""/>
					<input type="button" value="<spring:message code="button.search" />" id="btnSearch" class="bbs_btn type03" onclick="reloadTable();"/>
			</div>
			<table id="userList" class="display dataTable bbs_table list">
					<caption>{Board name} Write - 금지어, No, 금지어, 등록일, 수정일, 수정</caption>
						<colgroup>
							<col style="width:5%;" />
							<col style="width:10%;" />
							<col style="width:15%;" />
							<col style="width:10%;" />
							<col style="width:10%;" />
						</colgroup>
					<thead>
						<tr>
							<th scope="col"><spring:message code="bulletin.select.select" /></th>
							<th scope="col"><spring:message code="field.dic.mobile" /></th>
							<th scope="col"><spring:message code="userChg.list.title.userNm" /></th>
							<th scope="col"><spring:message code="field.dic.email" /></th>
							<th scope="col"><spring:message code="field.dic.usrtype" /></th>
						</tr>
					</thead>
				</table>
			<div class="button_box">
				<button type="button" class="btn btn-primary" onclick="selReferralUserInfo();"  data-dismiss="modal"><spring:message code="bulletin.select.select" /></button>
				<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="field.btn.cancel" /></button>
			</div>
		</div>
		<button type="button" class="close" onclick="modalClose();">close of popup</button>
	</section>
</div>


<!-- //bbs_popup -->

<script>
$(document).ready(function() {

init();



});
var userTables = "";

function init() {
        bind();
        
}

function bind() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "userSeq"},
            {"data": "userCell"},
            {"data": "userNm"},
            {"data": "userEmail"},
            {"data": "userAuthCd"},
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
		userTables = $('#userList').DataTable({
            //pageLength: 10,
            lengthMenu : false,
            processing: true,
			serverSide: true,
			paging: false,
			scrollCollapse: true,
			scrollY: "200px",
			searching: false,
			ordering: false,
			destroy: true,
			lenthChange: false,
			info: false,
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/referral/selectReferralUserSearchListAjax.do" // URL
                ,dataType: "json"
                , data: function ( d ) {
						d.keywordSel = $('#keyword_sel').val();
						d.keyword = $('#txtKeyword').val();
						d.lang = lang;
                        
				}
				
            },
            columns : setColumns,
            columnDefs: [
				//{ targets: 0, checkboxes: { selectRow: true } }
				
				{
	                    	targets: 0,
	                        render: function ( data, type, full, meta ) {
	                        	var html = "";
								html = "<input type=\"radio\" name=\"chkUser\" id=\"chkUser\" value=\"\" onclick=\"eRadio('"+full.userSeq+"');\"/>" ;
								
								return html;
	                        }
				}
                
            ],
            order: [[4, 'asc']]
        });
}


function reloadTable(){
	userTables.ajax.reload();
}

function eRadio(userSeq){
	 $('#popUserSeq').val(userSeq);
}


function modalClose(){
	$("#userSearchModalContent").modal('hide');
	$("#userSearchModalContent").find('a.close-modal').trigger('click');

}



function selReferralUserInfo(){
	var pUserSeq = $('#popUserSeq').val();
	if(pUserSeq == null || pUserSeq == "undefind" || pUserSeq == ""){
		alertify.alert(selectMsg);
        return;
	}else{
		searchResumeInfo(pUserSeq);
		modalClose();
	}

	

}
</script>