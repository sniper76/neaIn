<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	//$(function() {
	//	common.invoker.invoke("userSearchList");
	//});
</script>

<div class="bbs_popup"><!-- 팝업 가로, 세로 지정하지 않았습니다. 필요에 딸라 지정해서 사용 -->
	<section class="box_wrap">
		<div class="title_box">
			<h1 class="title"><spring:message code="field.dic.referral.mgmt" /></h1>
		</div>
		<div class="contents_box">
			<div>
					<h4><spring:message code="field.dic.compny.vccy" /></h4>
					<table class="bbs_table">
						<caption>테이블명 - 테이블 설명</caption>
						<colgroup>
							<col style="width:15%;" />
							<col style="width:25%;" />
							<col style="width:10%;" />
						</colgroup>
						<thead>
						<tr>
							<th scope="col"><spring:message code="field.dic.company.name" /></th>
							<th scope="col"><spring:message code="field.dic.vccy.title" /></th>
							<th scope="col"><spring:message code="field.dic.close.dt" /></th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td><c:out value="${vacancy.compnyNm}" /></td>
							<td><c:out value="${vacancy.vacancyTitle}" /></td>
							<td><c:out value="${vacancy.vacancyCloseDt}" /></td>
						</tr>
						</body>
					</table>
			</div>
			&nbsp;
			<div>
					<h4><spring:message code="field.dic.jobsk.info" /></h4>
					<table class="bbs_table">
						<caption>테이블명 - 테이블 설명</caption>
						<colgroup>
							<col style="width:10%;" />
							<col style="width:10%;" />
							<col style="width:10%;" />
							<col style="width:15%;" />
							<col style="width:25%;" />
						</colgroup>
						<thead>
						<tr>
							<th scope="col"><spring:message code="field.dic.name" /></th>
							<th scope="col"><spring:message code="field.dic.gender" /></th>
							<th scope="col"><spring:message code="field.dic.age" /></th>
							<th scope="col"><spring:message code="field.dic.contact.info" /></th>
							<th scope="col"><spring:message code="field.dic.resume.title" /></th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td><c:out value="${resume.fullUserNm}" /></td>
							<td><c:out value="${resume.genderCd}" /></td>
							<td><c:out value="${resume.age}" /></td>
							<td><c:out value="${resume.cell}" /></td>
							<td><c:out value="${resume.resumeTitle}" /></td>
						</tr>
						</body>
					</table>
			</div>
			&nbsp;
			<form id="frmMgmt">
				<h4><spring:message code="field.dic.councsel.list" /></h4>
				<textarea id="referralCounselRecord" name="referralCounselRecord" cols="15" rows="5" title="counsel" class="bbs_write_content" style="width:100%;"><c:out value="${referral.referralCounselRecord}" /></textarea>
				<strong>※ <spring:message code="referral.mgmt.councell.noti" /></strong>
				&nbsp;
				<h4><spring:message code="field.dic.councsel.list" /></h4>
				<textarea id="mngerOpinion" name="mngerOpinion" cols="15" rows="5" title="counsel" class="bbs_write_content" style="width:100%;"><c:out value="${referral.mngerOpinion}" /></textarea>
				<strong>※ <spring:message code="referral.mgmt.opinion.noti" /></strong>
				<br />
				&nbsp;
				<table class="bbs_table write">
					<caption><spring:message code="field.dic.referral.sts" /></caption>
					<colgroup>
						<col style="width:20%;" />
						<col />
					</colgroup>
					<tbody>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for="referralStsCd"><spring:message code="field.dic.referral.sts" /></label></th>
						<td>
							<!--commCode:commcode codeKind="commCode" tagName="referralStsCd" grpCd="REFERRAL_STS_CD" drawType="select" initValue="select" exceptValue="" disable=""/-->
							<!--select id="referralStsCd" name="referralStsCd" title="referralStsCd">
									<option value=""><spring:message code="bulletin.select.select" /></option>
							<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
								<c:if test="${item.grpCd eq 'REFERRAL_STS_CD'}">
									<option value="<c:out value="${item.dtlCd}"/>" <c:if test="${item.dtlCd eq referral.referralStsCd}"> selected="selected" </c:if> >
										<c:choose>
											<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
											<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
											<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
										</c:choose>
									</option>
								</c:if>
							</c:forEach>
							</select-->
							<commCode:commcode codeKind="commCode" tagName="referralStsCd" grpCd="REFERRAL_STS_CD" drawType="select" initValue="${referral.referralStsCd}" exceptValue="ALL" disable=""/>
						</td>
					</tr>
					</tbody>
				</table>
				<input type="hidden" id="vacancySeq" name="vacancySeq" value="<c:out value="${vacancy.vacancySeq}" />" />
				<input type="hidden" id="resumeSeq" name="resumeSeq" value="<c:out value="${resume.resumeSeq}" />" />
				<input type="hidden" id="referralTypeCd" name="referralTypeCd" value="${referralTypeCd}" />
				<input type="hidden" id="viewChk" name="viewChk" value="<c:out value="${chk}" />" />
		    </form>
			<div class="button_box">
				<button type="button" class="btn btn-default" data-dismiss="modal" onclick="modalClose();"><spring:message code="field.btn.cancel" /></button>
				<button type="button" class="btn btn-primary" id="saveReferralMgmt" onclick="saveReferralMgmt();"  data-dismiss="modal"><spring:message code="cpes.btn.save" /></button>
			</div>
		</div>
		<button type="button" class="close" onclick="modalClose();">close of popup</button>
	</section>
</div>


<!-- //bbs_popup -->

<script>
$(document).ready(function() {
var viewChk = $("#viewChk").val();

// 2 : read Only Mode
if(viewChk == "2"){
	$('#referralCounselRecord').prop('readonly', true);
	$('#mngerOpinion').prop('readonly', true);
	$("#referralStsCd option").not(":selected").attr("disabled", "disabled");
	$("#saveReferralMgmt").hide();
}


});

function saveReferralMgmt() {

	alertify.confirm(saveMsg, function (e) {
		if (e) {
			var param = $("#frmMgmt").serialize();
    
			$.ajax({
				type : 'post', // 타입
				url :  contextPath + "/internal/referral/insertReferralMgmtAjax.do", // URL
				dataType : 'json', // 데이터 타입
				//data : param,
				traditional: true,
				data : param,
				success : function(result) { // 결과 성공
					var sucCode = result.stat;
					if(sucCode == "0000"){
						alertify.alert(successMsg);
						modalClose();
					}else{
						alertify.alert(errorMsg);
					}
				
				},
				error : function(request, status, error) { // 결과 에러

				}
			})
		} else {
			return;
		}
	});
	
        
}


function modalClose(){
	$("#referralManageModalContent").modal('hide');
	$("#referralManageModalContent").find('a.close-modal').trigger('click');

}

// To-Do 상태 알선완료시 신청자에게 메일 알람 전송

</script>