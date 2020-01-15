<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
var lang = '<c:out value="${pageContext.request.locale.language}" />';
var fairDivCdList = [];
var jcCdList = [];
var dataList = [];
$(document).ready(function() {
	$("#frmFairSearch").find('input[name=fairDivCd]').each(function(index, item) {
		fairDivCdList.push( {dtlCd: $(this).attr('id'), fairDivCdNm: $(this).val()} );
	});
	
	$("#frmFairSearch").find('#jcCd > option').each(function(index, item) {
		if (index > 0) {
			jcCdList.push( {jcCd: $(this).val(), jcNm: $.trim($(this).text() )} );
		}
	});

	$("#frmFairSearch").find('#btnSearch').on('click', function() {
		fairAjaxCallFunc();
	});
	
	$("#frmFairSearch").find('#btnSelect').on('click', function() {
		
		var fairSeq = $("#frmFairSearch").find('input[name=fairSeq]:checked').val();
		
		//if ( typeof fairSeq == "undefined" || fairSeq == null || fairSeq == "" ) {
		if ($("input:radio[name='fairSeq']").is(":checked")) {
			var fairObj = dataList.find(function(x) {return x.fairSeq == fairSeq});
			$("#fairSeq").val(fairSeq);
			$("#mstJcCd").val(fairObj.mstJcCd);
			$("#spanFairNm").html(( lang == 'kh' ? fairObj.fairNmKh : fairObj.fairNmEn ));
			$("#fairModalContent").modal('hide');
		 	$("#fairModalContent").find('a.close-modal').trigger('click');
		} else {
			alertify.alert("채용행사를 선택해 주세요.", function (e) {
				if(e) {
					return false;
				}
			});
		}
	});
});


function fairAjaxCallFunc() {
	var params = { 
			"jcCd" : $("#frmFairSearch").find('#jcCd option:selected').val(),
			"fairDivCd" : $("#frmFairSearch").find('#fairDivCd option:selected').val(),
			"searchKeyword" : $("#frmFairSearch").find('#searchKeyword').val(),
			"searchValue" : $.trim($("#frmFairSearch").find('#searchValue').val())
		};
	
	var options = {
			method : 'post',
			url : contextPath + "/internal/fair/selectJobFairListLayerAjax.do",
			data: params,
			dataType : 'json',
		};

		$.ajax(options).done(function(result, status, responseObj) {
			dataList = result.list;
			initTableList(dataList);
		});		
}

function initTableList(list) {
	$('#fairLoop').empty();

	list.forEach(function (item) {
		var fairDivCdNm = fairDivCdList.find(function(x) { return x.dtlCd == item.fairDivCd })['fairDivCdNm'];
		var mstJcObj = jcCdList.find(function(x) { return x.jcCd == item.mstJcCd });
		var mstJcNm = (typeof mstJcObj != 'undefined' && typeof mstJcObj != undefined) ? mstJcObj['jcNm'] : '';
		var jcObj = jcCdList.find(function(x) { return x.jcCd == item.jcCd });
		var jcNm = (typeof jcObj != 'undefined' && typeof jcObj != undefined) ? jcObj['jcNm'] : '';
		
		var fairDt = item.fairBgnDt + '&nbsp;' + item.fairBgnHour + ':' +  item.fairBgnMinute + ':' + '&nbsp;' + item.fairBgnAmpm + '<br/>' +  item.fairEndDt + '&nbsp;' + item.fairEndHour + ':' +  item.fairEndMinute + ':' + '&nbsp;' + item.fairEndAmpm ;

		var html = '<tr>';
		html += '<th scope="row"><input type="radio" name="fairSeq" value="' + item.fairSeq + '" /></th>';
		html += '<th scope="row">' + fairDivCdNm + '</th>';
		html += '<th scope="row">' + ( lang == 'kh' ? item.fairNmKh : item.fairNmEn )  + '</th>';
		html += '<th scope="row">' + mstJcNm + '</th>';
		html += '<th scope="row">' + jcNm + '</th>';
		html += '<th scope="row">' + fairDt + '</th>';
		html += '</tr>';

		$('#fairLoop').append( html );
	});
}

function closeAddrLayer() {
	$("#fairModalContent").modal('hide');
 	$("#fairModalContent").find('a.close-modal').trigger('click');
}

</script>

<div class="bbs_popup">	
	<section class="box_wrap">
		<div class="title_box">
			<h1 class="title">Job Fair Selection</h1>
		</div>
	<form name="frmFairSearch" id="frmFairSearch">
	
		<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
			<c:if test="${item.grpCd eq 'FAIR_DIV_CD'}">
				<c:choose>
					<c:when test="${pageContext.request.locale.language eq 'en'}"><c:set var="fairNm" value="${item.cdEnNm}" /></c:when>
					<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:set var="fairNm" value="${item.cdKhNm}" /></c:when>
					<c:otherwise><c:set var="fairNm" value="${item.cdKhNm}" /></c:otherwise>
				</c:choose>
				<input type="hidden" name="fairDivCd" id="<c:out value="${item.dtlCd}"/>" value="<c:out value="${fairNm}" />" />	
			</c:if>
		</c:forEach>

		<div class="search_box" style="margin-bottom:0px;margin-top:25px;">
			<div class="contents_box" style="padding: 0 0 0 0;">
				<fieldset>
					<legend>Contents Search</legend>
					<table>
						<caption>Contents Search - Search, User Type, Period</caption>
						<tbody>
						<tr>
							<th scope="row"><spring:message code="fair.list.fair.div" /></th>
							<td colspan="3">
								<commCode:commcode codeKind="commCode" tagName="fairDivCd" grpCd="FAIR_DIV_CD" drawType="select" initValue="" exceptValue="" disable=""/>
								<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="" exceptValue="" disable=""/>
							</td>															
						</tr>
						<tr>
							<th scope="row"><spring:message code="fair.list.fair.nm" /></th>
							<td colspan="3">
								<input type="hidden" id="searchKeyword" name="searchKeyword" value="fairNm" />
								<label for="searchValue" class="skip"></label>
								<input type="text" id="searchValue" name="searchValue" value= "" />
							</td>														
						</tr>
						</tbody>
					</table>
					<div class="put_box">
						<input type="button" value="SEARCH" id="btnSearch" class="btn_submit" />
					</div>						
				</fieldset>									
			</div>
		</div>
		<div class="contents_box" style="padding:0 0 0 0;">
			<div class="bbs_scroll_y">
				<table class="bbs_table">
					<caption>테이블명 - 테이블 설명</caption>
					<colgroup>
						<col style="width:5%;" />
						<col style="width:10%;" />
						<col style="width:35%;" />
						<col style="width:10%;" />
						<col style="width:15%;" />
						<col style="width:25%;" />
					</colgroup>
					<thead>
						<th scope="col">select</th>
						<th scope="col"><spring:message code="fair.list.fair.div" /></p></th>
				        <th scope="col"><spring:message code="fair.list.fair.nm" /></p></th>
						<th scope="col"><spring:message code="fair.list.mng.div" /><p>(mstJcCd)</p></th>
						<th scope="col"><spring:message code="fair.list.mng.div" /><spring:message code="field.dic.jobcntr" /></th>
						<th scope="col"><spring:message code="fair.list.fair.dura" /></p></th>
					</thead>
					<tbody id="fairLoop" >
					</body>
				</table>
			</div>
			<div class="bbs_btn_wrap clearfix" style="text-align:center;">
				<button type="button" class="bbs_btn type02" onclick="closeAddrLayer();" data-dismiss="modal">Cancel</button>
				<button type="button" class="bbs_btn type03 registration" id="btnSelect" data-dismiss="modal">Select</button>
			</div>
		</div>
	
	</form>
	
		<button type="button" class="close" onclick="closeAddrLayer();">close of popup</button>
	
	</section>
</div>
<!-- //bbs_popup -->
