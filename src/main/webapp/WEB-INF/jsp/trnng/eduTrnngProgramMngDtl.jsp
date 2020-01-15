<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/trnng/eduTrnngProgramMngDtl.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("eduTrnngProgramMngDtl");
	});
</script>
<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
/*아이콘(icon) 위치*/
img.ui-datepicker-trigger{'cursor':'pointer', 'margin-left':'5px'}
</style>

<form id="frmEduTrnngMngDtl" >
<input type="hidden" id="eduTrnngSeq" name="eduTrnngSeq" value="<c:out value="${EduTrnngMngBean.eduTrnngSeq}" />" />

<div class="bbs_basic margin_b_20">
	<table class="bbs_table">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:10%;" />
			<col style="width:15%;" />
			<col style="width:30%;" />
			<col style="width:15%;" />
			<col style="width:30%;" />
		</colgroup>
		<tbody>
		<tr>
			<td rowspan="4" style="vertical-align:middle;">
				<div class="text_center"><img src="/images/board/dummy_photo.png" alt=" image" /></div>
			</td>		
			<th scope="row"><spring:message code="field.dic.insttnm" /></th>
			<td>
				<c:out value="${EduTrnngMngBean.insttNmEn}" />
			</td>
			<th scope="row"><spring:message code="field.dic.insttownership" /></th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq EduTrnngMngBean.insttOwnerCd}">
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
			<th scope="row"><spring:message code="field.dic.instttype" /></th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq EduTrnngMngBean.insttTypeCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
			<th scope="row"><spring:message code="field.dic.resprsnnm" /></th>
			<td>
				<c:out value="${EduTrnngMngBean.insttMngerNm}" />
			</td>			
		</tr>
		<tr>
			<th scope="row"><spring:message code="userChg.list.title.email" /></th>
			<td>
				<c:out value="${EduTrnngMngBean.insttEmail}" />
			</td>
			<th scope="row"><spring:message code="userChg.list.title.cell" /></th>
			<td>
				<c:out value="${EduTrnngMngBean.insttCell}" />
			</td>			
		</tr>
		<tr>
			<th scope="row"><spring:message code="userChg.list.title.address" /></th>
			<td colspan="3">
				<c:out value="${EduTrnngMngBean.insttAddrCd}" />
			</td>
		</tr>						
		</tbody>
	</table>
	<!-- //bbs_table view -->
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->

<h3>교육 프로그램 기본정보</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.trnng.nm" /></th>
			<td colspan="3"><c:out value=" ${EduTrnngMngBean.eduTrnngNm}" /></td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.trnng.div" /></th>
			<td colspan="3">
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq EduTrnngMngBean.programCorsTypeCd}">
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
			<th scope="row">기술/직업 교육 코스</th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq EduTrnngMngBean.skillJobProgramCorsCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>			
			</td>
			<th scope="row">고등/일반 교육 프로그램</th>
			<td>
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq EduTrnngMngBean.highGenrlEduCorsCd}">
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
			<th scope="row"><spring:message code="field.dic.recurmt.term" /></th>
			<td>
				<c:out value="${EduTrnngMngBean.recurmtBgnDt}" /> ~ <c:out value="${EduTrnngMngBean.recurmtEndDt}" />
			</td>
			<th scope="row"><spring:message code="field.dic.edu.term" /></th>
			<td>
				<c:out value="${EduTrnngMngBean.eduBgnDt}" /> ~ <c:out value="${EduTrnngMngBean.eduEndDt}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.period" /></th>
			<td colspan="3">
				<c:out value="${EduTrnngMngBean.eduDura}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.emp.timeday" />/<spring:message code="field.dic.emp.dayweek" /></th>
			<td colspan="3">
				<c:out value="${EduTrnngMngBean.timeWeek}" />
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.trnng.place" /></th>
			<td colspan="3">
				<c:out value="${EduTrnngMngBean.addrCd}" />
			</td>
		</tr>
		<tr>
			<th scope="row">수료증/과정</th>
			<td colspan="3">
				<c:out value="${EduTrnngMngBean.degreeAwards}" />
			</td>
		</tr>
		<tr>
			<th scope="row">프로그램/코스 Type</th>
			<td colspan="3">
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq EduTrnngMngBean.programCorsTypeCd}">
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
			<th scope="row"><spring:message code="field.dic.edu.major" /></th>
			<td colspan="3">
 				<c:forEach items="${MajorCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq EduTrnngMngBean.major2DepthCd}">
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
			<th scope="row"><spring:message code="field.dic.isco" /></th>
			<td>
 				<c:forEach items="${MajorCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.dtlCd eq EduTrnngMngBean.major1DepthCd}">
						<c:choose>
							<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
							<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
							<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
			<th scope="row">수강료</th>
			<td>
				<c:out value="${EduTrnngMngBean.tuition}" />
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->

<h3>교육 프로그램 정보</h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row">참가대상</th>
			<td colspan="3">
				<c:out value="${EduTrnngMngBean.eduTarget}" />
			</td>
		</tr>					
		<tr>
			<th scope="row">신청조건</th>
			<td colspan="3">
				<c:out value="${EduTrnngMngBean.admssCriteria}" />
			</td>
		</tr>					
		<tr>
			<th scope="row">교육 프로그램 설명</th>
			<td colspan="3">
				<c:out value="${EduTrnngMngBean.content}" />
			</td>
		</tr>					
		<tr>
			<th scope="row">신청 방법</th>
			<td colspan="3">
				<c:out value="${EduTrnngMngBean.enrolMethod}" />
			</td>
		</tr>					
		</tbody>
	</table>
	<!-- //bbs_table view -->
</div>
<!-- //bbs_basic view -->


<h3><spring:message code="field.dic.jc.agreeyn" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><spring:message code="field.dic.jc.agreeyn" /></th>
			<td colspan="3">
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.grpCd eq 'JC_AGREE_STS_CD'}">
						<span class="bbs_input_box">
							<input type="radio" id="jcAgreeStsCd<c:out value="${status.index}" />" name="jcAgreeStsCd" value="<c:out value="${item.dtlCd}" />" <c:if test="${item.dtlCd eq EduTrnngMngBean.jcAgreeStsCd}">checked=true</c:if> />
							<label for="jcAgreeStsCd<c:out value="${status.index}" />">
							<c:choose>
								<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
								<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
								<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
							</c:choose>
							</label>
						</span>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row"><spring:message code="field.dic.vccy.sts" /></th>
			<td colspan="3">
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.grpCd eq 'RECRUMT_STS_CD'}">
						<span class="bbs_input_box">
							<input type="radio" id="recrumtStsCd<c:out value="${status.index}" />" name="recrumtStsCd" value="<c:out value="${item.dtlCd}" />" <c:if test="${item.dtlCd eq EduTrnngMngBean.recrumtStsCd}">checked=true</c:if>   />
							<label for="recrumtStsCd<c:out value="${status.index}" />">
							<c:choose>
								<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
								<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
								<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
							</c:choose>
							</label>
						</span>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row">승인자</th>
			<td>${EduTrnngMngBean.jcUserNm}</td>
			<th scope="row"><spring:message code="field.dic.jcAgree.dt" /></th>
			<td>${EduTrnngMngBean.jcAgreeDt}</td>
		</tr>		
		</tbody>
	</table>
	<!-- //bbs_table view -->
	
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<a href="${pageContext.request.contextPath}/internal/trnng/eduTrnngProgramMng.do" class="bbs_btn list">list</a>
		</span>
		<span class="bbs_right">
			<input type="submit" id="btnSubmit" value="Save" class="bbs_btn modify" />
		</span>
	</div>
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->
</form>


