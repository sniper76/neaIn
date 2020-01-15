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
			<h1 class="title"><spring:message code="field.dic.cmny.search" /></h1>
		</div>
		<div class="contents_box">
			<div>
					<label for="Search_sel" class="skip">category selection</label>
					<select id="keyword_sel">
						<option value=""><spring:message code="bulletin.select.select" /></option>
						<option value="1"><spring:message code="field.dic.company.name" /></option>
						<option value="2"><spring:message code="field.dic.reg.num" /></option>
						<option value="3"><spring:message code="field.dic.tel" /></option>
						<option value="4"><spring:message code="field.dic.resprsnnm" /></option>
						<option value="5"><spring:message code="userChg.list.title.email" /></option>
					</select>
					<label for="keyword" class="skip"></label>
					<input type="text" id="txtKeyword" value=""/>
					<input type="button" value="<spring:message code="button.search" />" id="btnSearch" class="bbs_btn type03" onclick="reloadTable();"/>
			</div>
				<table id="cmpnyList" class="bbs_table">
						<caption>{Board name} Write - 금지어, No, 금지어, 등록일, 수정일, 수정</caption>
							<colgroup>
								<col style="width:5%;" />
								<col style="width:15%;" />
								<col style="width:10%;" />
								<col style="width:10%;" />
								<col style="width:10%;" />
								<col style="width:10%;" />
								<col />
								<col />
							</colgroup>
						<thead>
							<tr>
								<th scope="col"><spring:message code="bulletin.select.select" /></th>
								<th scope="col"><spring:message code="field.dic.company.name" /></th>
								<th scope="col"><spring:message code="field.dic.reg.num" /></th>
								<th scope="col"><spring:message code="field.dic.vccy.prsn" /></th>
								<th scope="col"><spring:message code="userChg.list.title.email" /></th>
								<th scope="col"><spring:message code="field.dic.contract" /></th>
								<th scope="col"></th>
								<th scope="col"></th>
							</tr>
						</thead>
				</table>
			<div class="button_box">
				<button type="button" class="btn btn-primary" onclick="selReferralCmpnyInfo();"  data-dismiss="modal"><spring:message code="bulletin.select.select" /></button>
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
var dataTables = "";

function init() {
        bind();
        
}

function bind() {
        var that$ = this;
        //bulletinMNGList.fn.getList();
        var setColumns = [
            {"data": "compnySeq"},
            {"data": "compnyNm"},
            {"data": "regNum"},
            {"data": "mngerNm"},
			{"data": "mngerEmail"},
			{"data": "mngerCell"},
			{"data": "compnyNmKh"},
			{"data": "compnyNmEn"}
            
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
         dataTables = $('#cmpnyList').DataTable({
            //pageLength: 10,
            //lengthMenu : [ [ 10, 20, 30, 50, -1 ], [ 10, 20, 30, 50, "All" ] ],
            processing: true,
			serverSide: true,
			paging: false,
			scrollCollapse: true,
			scrollY: "200px",
			searching: false,
			ordering: false,
            destroy: true,
			info: false,
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/referral/selectReferralCmpnySearchListAjax.do" // URL
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
								html = "<input type=\"radio\" name=\"chkCmpny\" id=\"chkCmpny\" value=\"\" onclick=\"eRadio('"+full.compnySeq+"','"+full.compnyNmKh+"','"+full.compnyNmEn+"');\"/>" ;
								
								return html;
	                        }
				},
                {
                	targets: 6,
                    visible: false,
                    searchable: false
                },
                {
                	targets: 7,
                    visible: false,
                    searchable: false
                }                
                
            ],
            order: [[1, 'asc']]
        });
}


function reloadTable(){
	dataTables.ajax.reload();
}

function eRadio(compnySeq, compnyNmKh, compnyNmEn){
	 $('#popCmpnySeq').val(compnySeq);
	 $('#popCmpnyNmKh').val(compnyNmKh);
	 $('#popCmpnyNmEn').val(compnyNmEn);
}


function modalClose(){
	$("#cmpnySearchModalContent").modal('hide');
	$("#cmpnySearchModalContent").find('a.close-modal').trigger('click');

}



function selReferralCmpnyInfo(){
	var pCmpnySeq = $('#popCmpnySeq').val();
	var pCmpnyNmKh = $('#popCmpnyNmKh').val();
	var pCmpnyNmEn = $('#popCmpnyNmEn').val();
	if(pCmpnySeq == null || pCmpnySeq == "undefind" || pCmpnySeq == ""){
		alertify.alert(selectMsg);
        return;
	}

	searchCmpnyInfo(pCmpnySeq, pCmpnyNmKh, pCmpnyNmEn);
	modalClose();

}
</script>