<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/user/courseHistDtl.js"></script>
<script>
	$(function() {
		common.invoker.invoke("courseHistDtl");
	});

	function SelectCounselHisList(){
		$("#innerDtlInfo").empty();
		
		var action = contextPath + "/internal/user/selectCounselInfoAjax.do";
		var param = {
			"userSeq" : $('#userSeq').val(), 
			"sysLangCd" : lang
		};
		
		$.ajax({
			type: "POST",
			url: action,
			data: param,                   
			cache: true,
			success: function(response) {
				//alert(response);
				$("#innerDtlInfo").html(response);
			}
		});
		
		//$("#innerUserDtlInfoBase").hide();
		//$("#innerResumeDtlInfo").hide();	
		//$("#innerCounselInfo").show();		
	}
</script>

<form id="frmCourseDtl" >
<input type="hidden" id="counselSeq" name="counselSeq" value="<c:out value="${CounselBean.counselSeq}" />" />
<input type="hidden" id="userSeq" name="userSeq" value="<c:out value="${CounselBean.qustRegUserSeq}" />" />

<h3>기본내용</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row">제목</th>
			<td colspan="3">
				<c:out value="${CounselBean.qustTitle}" />
			</td>
		</tr>
		<tr>
			<th scope="row">작성자</th>
			<td>
				<c:out value="${CounselBean.userNm}" />
			</td>
			<th scope="row">회원Type</th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq CounselBean.userAuthCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row">상담방법</th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq CounselBean.counselMethodDivCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
			<th scope="row">상담게시판</th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq CounselBean.counselTargetCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row">좋아요 수</th>
			<td>
				<c:out value="${CounselBean.likeCnt}" />
			</td>
			<th scope="row">조회수</th>
			<td>
				<c:out value="${CounselBean.viewCnt}" />
			</td>
		</tr>
		<tr>
			<th scope="row">공개여부</th>
			<td>
				<c:out value="${CounselBean.secretYn}" />
			</td>
			<th scope="row">작성/수정일시</th>
			<td>
				<c:out value="${CounselBean.qustRegDt}" />
			</td>			
		</tr>						
		</tbody>
	</table>
	<!-- //bbs_table view -->
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->

<h3>상담자 정보</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row">관할 잡 센터</th>
			<td>
				<c:out value="${CounselBean.jcNm}" />
			</td>
			<th scope="row">상담 직원명</th>
			<td>
				<c:out value="${CounselBean.jcUserNm}" />
			</td>
		</tr>
		<tr>
			<th scope="row">상담상태</th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.grpCd eq 'COUNSEL_STS_CD'}">
						<input type="radio" <c:if test="${item.dtlCd eq CounselBean.counselStsCd}"> checked="true" </c:if> disabled="true" />
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>					
					</c:if>
				</c:forEach>			
			</td>
			<th scope="row">답변일시</th>
			<td>
				<c:out value="${CounselBean.ansModDt}" />
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->

<c:choose>
	<c:when test="${'CMD0000000001' ne CounselBean.counselMethodDivCd}">
	
<h3>상담요청내용</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row">희망 상담일시</th>
			<td colspan="3">
				<c:out value="${CounselBean.hopeCounselDt}" />
			</td>
		</tr>
		<tr>
			<th scope="row">기타 당부사항</th>
			<td colspan="3">
				<c:out value="${CounselBean.qustEtcReq}" />
			</td>
		</tr>							
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->
	</c:when>
	<c:otherwise>
	
<h3>상담내용</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row">상담내용</th>
			<td colspan="3">
				<c:out value="${CounselBean.qustContent}" />
			</td>
		</tr>					
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->

	</c:otherwise>
</c:choose>

<h3>답변내용</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table view">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
<c:if test="${'CMD0000000001' ne CounselBean.counselMethodDivCd}">
		<tr>
			<th scope="row">상담일시</th>
			<td colspan="3">
				<c:out value="${CounselBean.counselDt}" />&nbsp;
				<c:out value="${CounselBean.counselHour}" />&nbsp;
				<c:out value="${CounselBean.counselMinute}" />&nbsp;
				<c:out value="${CounselBean.counselAmpm}" />&nbsp;
			</td>
		</tr>
		<tr>
			<th scope="row">상담 전 알림</th>
			<td colspan="3">
				<c:out value="${CounselBean.counselNtce}" />
			</td>
		</tr>
</c:if>		
		<tr>
			<th scope="row">
	<c:choose>
		<c:when test="${'CMD0000000001' ne CounselBean.counselMethodDivCd}">
			상담결과
		</c:when>
		<c:otherwise>
			답변내용
		</c:otherwise>
	</c:choose>			
			</th>
			<td colspan="3">
				<c:out value="${CounselBean.ansContent}" />
			</td>
		</tr>
		<tr>
			<th scope="row">첨부파일</th>
			<td colspan="3">
				<c:out value="${CounselBean.ansFileGrpSeq}" />
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
	
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<button type="button" class="bbs_btn list" onclick="tabCounselDtlInfo();">list</button>
		</span>
	</div>
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->
</form>


