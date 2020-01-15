<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
/*아이콘(icon) 위치*/
button.ui-datepicker-trigger{position: relative; cursor: pointer; margin-left:-20px;}
</style>

<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/jobFairMngDtl.js"></script>
<script type="text/javascript">
	$(function() {
		common.invoker.invoke("jobFairMngDtl");
	});
	
	var thumbFileBlank = '<spring:message code="fair.reg.msg.fair.thumb.file.blank" />';
	var fairFileBlank = '<spring:message code="fair.reg.msg.fair.fair.file.blank" />';
	var divcdBlank = '<spring:message code="fair.reg.msg.fair.divcd.blank" />';
	var nmkhBlank = '<spring:message code="fair.reg.msg.fair.nm.kh.blank" />';
	var nmenBlank = '<spring:message code="fair.reg.msg.fair.nm.en.blank" />';
	var jcBlank = '<spring:message code="fair.reg.msg.fair.jc.blank" />';
	var addrkhBlank = '<spring:message code="fair.reg.msg.fair.addr.dtl.kh.blank" />';
	var addrenBlank = '<spring:message code="fair.reg.msg.fair.addr.dtl.en.blank" />';
	var tel1Blank = '<spring:message code="fair.reg.msg.fair.tel1.blank" />';
	var tel2Blank = '<spring:message code="fair.reg.msg.fair.tel2.blank" />';
	var emailBlank = '<spring:message code="user.regist.email.blank.error" />';
	var sponsorFileBlank = '<spring:message code="fair.reg.msg.fair.sponsor.file.blank" />';
	var supporterFileBlank = '<spring:message code="fair.reg.msg.fair.supporter.file.blank" />';
	var explnBlank = '<spring:message code="fair.reg.msg.fair.expln.blank" />';
	
</script>

<form id="frmJobFairMngDtl" >
<input type="hidden" id="fairSeq" name="fairSeq" value="<c:out value="${FairMngBean.fairSeq}" />" />
<input type="hidden" id="mstJcCd" name="mstJcCd" value="<c:out value="${FairMngBean.user.jcCd}" />" />
<input type="hidden" id="fairHashtag" name="fairHashtag" value="<c:out value="${FairMngBean.fairHashtag}" />" />
<input type="hidden" id="fairStsCd" name="fairStsCd" value="<c:out value="${FairMngBean.fairStsCd}" />" />

<input type="hidden" name="fileYn" id="fileYn" value="" />
<input type="hidden" name="fileSize" id="fileSize" value="" />
<input type="hidden" name="fileCnt" id="fileCnt" value="" />
<input type="hidden" id="thumbCommonUploadFairResult" name="thumbCommonUploadFairResult">
<input type="hidden" id="fairCommonUploadFairResult" name="fairCommonUploadFairResult">
<input type="hidden" id="supporterCommonUploadFairResult" name="supporterCommonUploadFairResult">
<input type="hidden" id="sponsorCommonUploadFairResult" name="sponsorCommonUploadFairResult">
<input type="hidden" id="boothCommonUploadFairResult" name="boothCommonUploadFairResult">

<h3><spring:message code="field.dic.fair.base.info" /></h3>

<div class="bbs_basic margin_b_20">
	<table class="bbs_table write">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="fairDivCd"><spring:message code="field.dic.fair.div" /></label></th>
			<td colspan="3">
 				<c:forEach items="${CommonCodeDtlBean}" var="item" varStatus="status">
					<c:if test="${item.grpCd eq 'FAIR_DIV_CD'}">
						<c:choose>
							<c:when test="${FairMngBean.fairDivCd eq 'FDC0000000001' or FairMngBean.fairDivCd eq 'FDC0000000002' or FairMngBean.fairDivCd eq 'FDC0000000005'}">
								<c:if test="${item.dtlCd eq 'FDC0000000001' or item.dtlCd eq 'FDC0000000002' or item.dtlCd eq 'FDC0000000005'}">
									<input type="radio" name="fairDivCd" value="<c:out value="${item.dtlCd}"/>" <c:if test="${item.dtlCd eq FairMngBean.fairDivCd}"> checked="true" </c:if> disabled="true" required />
									<c:choose>
										<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
										<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
										<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
									</c:choose>
								</c:if>
							</c:when>							
							<c:otherwise>
								<c:if test="${item.dtlCd eq 'FDC0000000003' or item.dtlCd eq 'FDC0000000004'}">
									<input type="radio" name="fairDivCd" value="<c:out value="${item.dtlCd}"/>" <c:if test="${item.dtlCd eq FairMngBean.fairDivCd}"> checked="true" </c:if> disabled="true" required />
									<c:choose>
										<c:when test="${pageContext.request.locale.language eq 'en'}"><c:out value=" ${item.cdEnNm}" /></c:when>
										<c:when test="${pageContext.request.locale.language eq 'kh'}"><c:out value=" ${item.cdKhNm}" /></c:when>
										<c:otherwise><c:out value=" ${item.cdKhNm}" /></c:otherwise>
									</c:choose>
								</c:if>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="fairNmKh"><spring:message code="field.dic.fair.name" /> (kh)</label></th>
			<td colspan="3">
				<input type="text" id="fairNmKh" name="fairNmKh" value="<c:out value="${FairMngBean.fairNmKh}" escapeXml="false" />" style="width:80%;" required />
			</td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="fairNmKh"><spring:message code="field.dic.fair.name" /> (en)</label></th>
			<td colspan="3">
				<input type="text" id="fairNmEn" name="fairNmEn" value="<c:out value="${FairMngBean.fairNmEn}" escapeXml="false" />" style="width:80%;" required />
			</td>
		</tr>
<c:if test="${FairMngBean.fairDivCd ne 'FDC0000000005'}">		
		<tr class="thumbNailTr" >
			<th scope="row"><label for=""><spring:message code="field.dic.fair.thumb.img" /></label></th>
			<td colspan="3" style="vertical-align:middle;">
				<input type="hidden" id="thumbFileGrpSeq" name="thumbFileGrpSeq" value="<c:out value="${FairMngBean.thumbFileGrpSeq}"/>" />
				<div id="thumbDext5uploadArea"></div>
			</td>
		</tr>
</c:if>
		<tr>
			<th scope="row"><label for=""><spring:message code="field.dic.fair.thumb.img" /></label></th>
			<td colspan="3" style="vertical-align:middle;">
				<input type="hidden" id="fairFileGrpSeq" name="fairFileGrpSeq" value="<c:out value="${FairMngBean.fairFileGrpSeq}"/>" />
				<div id="fairDext5uploadArea"></div>
			</td>
		</tr>
<c:if test="${FairMngBean.fairDivCd eq 'FDC0000000005'}">
		<tr class="urlTr" >
			<th scope="row"><span class="exactly y">necessary</span><label for=""><spring:message code="menu.menunm.url" /></label></th>
			<td colspan="3">
				<input type="text" id="url" name="url" value="<c:out value="${FairMngBean.url}" />" style="width:80%;" required />
			</td>
		</tr>
</c:if>

<c:if test="${FairMngBean.fairDivCd ne 'FDC0000000005'}">
<c:choose>
	<c:when test="${FairMngBean.fairDivCd eq 'FDC0000000001' or FairMngBean.fairDivCd eq 'FDC0000000002'}">
		<tr class="jcCdTr">
			<th scope="row"><span class="exactly y">necessary</span><label for="teacher2PhotoFileGrpSeq"><spring:message code="field.dic.subject.center" /></label></th>
			<td colspan="3">
				<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="${FairMngBean.jcCd}" exceptValue="ALL" disable=""/>
			</td>
		</tr>
	</c:when>
	<c:otherwise>
		<tr class="jcCdTr">
			<th scope="row"><span class="exactly y">necessary</span><label for="teacher2PhotoFileGrpSeq"><spring:message code="field.dic.subject.center" /></label></th>
			<td colspan="3">
				<commCode:commcode codeKind="jcCode" tagName="jcCd" grpCd="" drawType="select" initValue="${FairMngBean.jcCd}" exceptValue="ALL" disable="true"/>
			</td>
		</tr>
	</c:otherwise>	
</c:choose>
</c:if>
		
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="teacher2PhotoFileGrpSeq"><spring:message code="userChg.list.title.address" /></label></th>
			<td colspan="3">
               	<input type="hidden" name="addrCd" id="addrCd" value="<c:out value="${FairMngBean.addrCd}" escapeXml="false" />"  required />
               	<input type="hidden" name="addrFullCd" id="addrFullCd" value="<c:out value="${FairMngBean.addrFullCd}" escapeXml="false" />" required />
               	<input type="button" class="bbs_btn type03" onclick="popAddrLayerBtn('addrCd','addrFullCd','addrFullNm','addrFullNmView');" value="<spring:message code="button.addr.nm" />" />
				<input type="text" name="addrFullNm" id="addrFullNm" value="<c:out value="${FairMngBean.addrFullNm}" escapeXml="false" />" style="border:0px; width:80%; outline: none;" placeholder="choose address" onclick="popAddrLayerBtn('addrCd','addrFullCd','addrFullNm','addrFullNmView');" onkeypress="return false;" required />
				<br/>
				<label for="addrDtl">kh </label><input type="text" id="addrDtl" name="addrDtl" value="<c:out value="${FairMngBean.addrDtl}" escapeXml="false" />" style="width:80%;" required />						
				<br/>
				<label for="addrDtl2">en </label><input type="text" id="addrDtl2" name="addrDtl2" value="<c:out value="${FairMngBean.addrDtl2}" escapeXml="false" />" style="width:80%;" required />
				<br/>
				<label for="googleMapLink"><spring:message code="field.dic.google.map.link" /> </label><input type="text" id="googleMapLink" name="googleMapLink" value="<c:out value="${FairMngBean.googleMapLink}" escapeXml="false" />" style="width:80%;"/>						
			</td>
		</tr>
		</tbody>
	</table>
	<!-- //bbs_table write -->
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->

<h3><spring:message code="field.dic.fair.info" /></h3>
<div class="bbs_basic margin_b_20">
	<table class="bbs_table write">
		<caption>{Board name} View - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="teacher2PhotoFileGrpSeq"><spring:message code="field.dic.fair.term" /></label></th>
			<td colspan="3">
				<span class="period_box">
					<span class="date_box">
						<input type="text" id="fairBgnDt" name="fairBgnDt" value="<c:out value="${FairMngBean.fairBgnDt}" />" class="datepicker" title="date Select from calendar" placeholder="date" required />
					</span>
				</span>
				<span class="bbs_date" style="padding-left:25px;">
					<select id="fairBgnHour" name="fairBgnHour" title="hour">
					<c:forEach var="hour" begin="1" end="12">
					<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setHour}"/>"  <c:if test="${setHour eq FairMngBean.fairBgnHour}"> selected="selected" </c:if> ><c:out value="${setHour}"/></option>
					</c:forEach>
					</select>
					<label for="fairBgnHour">HH</label>
				</span>
				<span class="bbs_date">
					<select id="fairBgnMinute" name="fairBgnMinute" title="minute">
					<c:forEach var="minute" begin="0" end="59">
					<c:choose>
						<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
						<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setMinute}"/>" <c:if test="${setMinute eq FairMngBean.fairBgnMinute}"> selected="selected" </c:if> ><c:out value="${setMinute}"/></option>						
					</c:forEach>
					</select>
					<label for="fairBgnMinute">MM</label>
				</span>
				<span class="bbs_date">
					<select id="fairBgnAmpm" name="fairBgnAmpm" title="Ampm">
						<option value="AM" <c:if test="${'AM' eq FairMngBean.fairBgnAmpm}"> selected="selected" </c:if> >AM</option>
						<option value="PM" <c:if test="${'PM' eq FairMngBean.fairBgnAmpm}"> selected="selected" </c:if> >PM</option>
					</select>
					<label for="fairBgnAmpm">AMPM</label>
				</span>
				<br/>
				<span class="period_box">
					<span class="date_box">
						<input type="text" id="fairEndDt" name="fairEndDt" value="<c:out value="${FairMngBean.fairEndDt}" />" class="datepicker" title="date Select from calendar" placeholder="date" required />
					</span>
				</span>
				<span class="bbs_date" style="padding-left:25px;">
					<select id="fairEndHour" name="fairEndHour" title="hour">
					<c:forEach var="hour" begin="1" end="12">
					<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setHour}"/>"  <c:if test="${setHour eq FairMngBean.fairEndHour}"> selected="selected" </c:if> ><c:out value="${setHour}"/></option>
					</c:forEach>
					</select>
					<label for="fairEndHour">HH</label>
				</span>
				<span class="bbs_date">
					<select id="fairEndMinute" name="fairEndMinute" title="minute">
					<c:forEach var="minute" begin="0" end="59">
					<c:choose>
						<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
						<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setMinute}"/>" <c:if test="${setMinute eq FairMngBean.fairEndMinute}"> selected="selected" </c:if> ><c:out value="${setMinute}"/></option>						
					</c:forEach>
					</select>
					<label for="fairEndMinute">MM</label>
				</span>
				<span class="bbs_date">
					<select id="fairEndAmpm" name="fairEndAmpm" title="Ampm">
						<option value="AM" <c:if test="${'AM' eq FairMngBean.fairEndAmpm}"> selected="selected" </c:if> >AM</option>
						<option value="PM" <c:if test="${'PM' eq FairMngBean.fairEndAmpm}"> selected="selected" </c:if> >PM</option>
					</select>
					<label for="fairEndAmpm">AMPM</label>
				</span>			
			</td>
		</tr>
		
<c:if test="${FairMngBean.fairDivCd ne 'FDC0000000005'}">		
		<tr class="recurmtTr">
			<th scope="row"><span class="exactly y">necessary</span><label for="teacher2PhotoFileGrpSeq"><spring:message code="field.dic.recurmt.term" /></label></th>
			<td colspan="3">
				<span class="period_box">
					<span class="date_box">
						<input type="text" id="recurmtBgnDt" name="recurmtBgnDt" value="<c:out value="${FairMngBean.recurmtBgnDt}" />" class="datepicker" title="date Select from calendar" placeholder="date" required />
					</span>
				</span>
				<span class="bbs_date" style="padding-left:25px;">
					<select id="recurmtBgnHour" name="recurmtBgnHour" title="hour">
					<c:forEach var="hour" begin="1" end="12">
					<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setHour}"/>"  <c:if test="${setHour eq FairMngBean.recurmtBgnHour}"> selected="selected" </c:if> ><c:out value="${setHour}"/></option>
					</c:forEach>
					</select>
					<label for="recurmtBgnHour">HH</label>
				</span>
				<span class="bbs_date">
					<select id="recurmtBgnMinute" name="recurmtBgnMinute" title="minute">
					<c:forEach var="minute" begin="0" end="59">
					<c:choose>
						<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
						<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setMinute}"/>" <c:if test="${setMinute eq FairMngBean.recurmtBgnMinute}"> selected="selected" </c:if> ><c:out value="${setMinute}"/></option>						
					</c:forEach>
					</select>
					<label for="recurmtBgnMinute">MM</label>
				</span>
				<span class="bbs_date">
					<select id="recurmtBgnAmpm" name="recurmtBgnAmpm" title="Ampm">
						<option value="AM" <c:if test="${'AM' eq FairMngBean.recurmtBgnAmpm}"> selected="selected" </c:if> >AM</option>
						<option value="PM" <c:if test="${'PM' eq FairMngBean.recurmtBgnAmpm}"> selected="selected" </c:if> >PM</option>
					</select>
					<label for="recurmtBgnAmpm">AMPM</label>
				</span>
				<br/>
				<span class="period_box">
					<span class="date_box">
						<input type="text" id="recurmtEndDt" name="recurmtEndDt" value="<c:out value="${FairMngBean.recurmtEndDt}" />" class="datepicker" title="date Select from calendar" placeholder="date" required />
					</span>
				</span>
				<span class="bbs_date" style="padding-left:25px;">
					<select id="recurmtEndHour" name="recurmtEndHour" title="hour">
					<c:forEach var="hour" begin="1" end="12">
					<c:choose>
						<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
						<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setHour}"/>"  <c:if test="${setHour eq FairMngBean.recurmtEndHour}"> selected="selected" </c:if> ><c:out value="${setHour}"/></option>
					</c:forEach>
					</select>
					<label for="recurmtEndHour">HH</label>
				</span>
				<span class="bbs_date">
					<select id="recurmtEndMinute" name="recurmtEndMinute" title="minute">
					<c:forEach var="minute" begin="0" end="59">
					<c:choose>
						<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
						<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
					</c:choose>
						<option value="<c:out value="${setMinute}"/>" <c:if test="${setMinute eq FairMngBean.recurmtEndMinute}"> selected="selected" </c:if> ><c:out value="${setMinute}"/></option>						
					</c:forEach>
					</select>
					<label for="recurmtEndMinute">MM</label>
				</span>
				<span class="bbs_date">
					<select id="recurmtEndAmpm" name="recurmtEndAmpm" title="Ampm">
						<option value="AM" <c:if test="${'AM' eq FairMngBean.recurmtEndAmpm}"> selected="selected" </c:if> >AM</option>
						<option value="PM" <c:if test="${'PM' eq FairMngBean.recurmtEndAmpm}"> selected="selected" </c:if> >PM</option>
					</select>
					<label for="recurmtEndAmpm">AMPM</label>
				</span>
			</td>
		</tr>
</c:if>

		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="tel1"><spring:message code="field.dic.tel" /> 1</label></th>
			<td colspan="3">
				<input type="text" id="tel1" name="tel1" value="<c:out value="${FairMngBean.tel1}" escapeXml="false" />" required />
			</td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="tel2"><spring:message code="field.dic.tel" /> 2</label></th>
			<td colspan="3">
				<input type="text" id="tel2" name="tel2" value="<c:out value="${FairMngBean.tel2}" escapeXml="false" />" required />
			</td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="email"><spring:message code="field.dic.email" /></label></th>
			<td colspan="3">
				<input type="text" id="email" name="email" value="<c:out value="${FairMngBean.email}" escapeXml="false" />" required />
			</td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for=""><spring:message code="field.dic.fair.supporter" /></label></th>
			<td colspan="3" style="vertical-align:middle;">
				<input type="hidden" id="supporterFileGrpSeq" name="supporterFileGrpSeq" value="<c:out value="${FairMngBean.supporterFileGrpSeq}" />">
				<div id="supporterDext5uploadArea"></div>
			</td>
		</tr>
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for=""><spring:message code="field.dic.fair.sponsor" /></label></th>
			<td colspan="3" style="vertical-align:middle;">
				<input type="hidden" id="sponsorFileGrpSeq" name="sponsorFileGrpSeq" value="<c:out value="${FairMngBean.sponsorFileGrpSeq}" />">
				<div id="sponsorDext5uploadArea"></div>
			</td>
		</tr>
	<c:if test="${FairMngBean.user.jcCd eq 'JCT0000000015' or FairMngBean.user.jcCd eq 'JCT0000000099'}">
		<script language="javascript">
		boothDext5uploadEvnt();
		</script>
		<tr class="boothImgTr">
			<th scope="row"><label for=""><spring:message code="field.dic.fair.booth.img" /></label></th>
			<td colspan="3" style="vertical-align:middle;">
				<input type="hidden" id="boothFileGrpSeq" name="boothFileGrpSeq" value="<c:out value="${FairMngBean.boothFileGrpSeq}" />">
				<div id="boothDext5uploadArea"></div>
			</td>
		</tr>
	</c:if>
<c:if test="${FairMngBean.fairDivCd ne 'FDC0000000005'}">
		<tr class="fairDtlExplnKhTr">
			<th scope="row"><span class="exactly y">necessary</span><label for="fairDtlExplnKh"><spring:message code="field.dic.fair.desc" /> (kh)</label></th>
			<td colspan="3">
				<textarea id="fairDtlExplnKh" name="fairDtlExplnKh" cols="30" rows="10" title="fairDtlExplnKh" required ><c:out value="${FairMngBean.fairDtlExplnKh}" escapeXml="false" /></textarea>
			</td>
		</tr>
		<tr class="fairDtlExplnEnTr">
			<th scope="row"><label for="fairDtlExplnEn"><spring:message code="field.dic.fair.desc" /> (en)</label></th>
			<td colspan="3">
				<textarea id="fairDtlExplnEn" name="fairDtlExplnEn" cols="30" rows="10" title="fairDtlExplnEn" ><c:out value="${FairMngBean.fairDtlExplnEn}" escapeXml="false" /></textarea>
			</td>
		</tr>
</c:if>

<c:if test="${FairMngBean.fairDivCd ne 'FDC0000000005'}">
		<tr class="fairHashtagTr">
			<th scope="row"><label for="keyword"><spring:message code="field.dic.fair.keyword" /></label></th>
			<td colspan="3">
				<div class="form_wrap">
					<div class="form_contents">
						<div class="form_box">
							<div class="form_element keyword active"><!-- 수정일 경우 등록된 키워드가 있다면 클래스 active 추가 -->
								<div class="view_area">
									<label for="keyword" class="skip">Keyword input</label>
									<span class="text_box">
									<c:forEach items="${fn:split(FairMngBean.fairHashtag, ',') }" var="item" varStatus="status">
									    <span><c:out value="${item}" escapeXml="false" /><button type="button">delete</button></span>
									</c:forEach>
									</span>
									<input type="text" id="keyword" class="input_key" />
								</div>
							</div>
							<div class="keyword_info">
								<strong>※ After entering #+ keyword and press enter button, you can add a keyword. Max Count is 5.</strong>
								<span>Please enter keywords about related your interesting and preference. Keyword will be used for searching and  matching CV and referral.</span>
							</div>
						</div>
						<!-- //form_box -->
					</div>
					<!-- //form_contents -->
				</div>
				<!-- //form_wrap -->
			</td>
		</tr>
</c:if>
		
<c:if test="${FairMngBean.fairDivCd ne 'FDC0000000005'}">
		<tr class="fairitemViewTr">
			<th scope="row"><label for="teacher2PhotoFileGrpSeq"><spring:message code="field.dic.fair.view.item" /></label></th>
			<td colspan="3">
				<input type="checkbox" id="fairCompnyViewYn" name="fairCompnyViewYn" <c:if test="${FairMngBean.fairCompnyViewYn eq 'Y'}">checked="true"</c:if> /><label for="fairCompnyViewYn"><spring:message code="field.dic.fair.compny.view" /></label>
				<input type="checkbox" id="fairVacancyViewYn" name="fairVacancyViewYn" <c:if test="${FairMngBean.fairVacancyViewYn eq 'Y'}">checked="true"</c:if> /><label for="fairVacancyViewYn"><spring:message code="field.dic.compny.vccy" /></label>
				<input type="checkbox" id="fairInsttViewYn" name="fairInsttViewYn" <c:if test="${FairMngBean.fairInsttViewYn eq 'Y'}">checked="true"</c:if> /><label for="fairInsttViewYn"><spring:message code="field.dic.instt" /></label>
				<input type="checkbox" id="fairTrnngViewYn" name="fairTrnngViewYn" <c:if test="${FairMngBean.fairTrnngViewYn eq 'Y'}">checked="true"</c:if> /><label for="fairTrnngViewYn"><spring:message code="field.dic.trnng.prog" /></label>
				<br/> 
				※ 선택을 하시면 해당 탭이 External Potal에서 활성화 됩니다.
 			</td>
		</tr>
</c:if>				
		<tr>
			<th scope="row"><span class="exactly y">necessary</span><label for="teacher2PhotoFileGrpSeq">전시 여부</label></th>
			<td colspan="3">
				<input type="radio" id="fairViewYn0" name="fairViewYn" value="Y" <c:if test="${FairMngBean.fairViewYn eq 'Y'}">checked="true"</c:if> /><label for="fairViewYn0">Y</label>
				<input type="radio" id="fairViewYn1" name="fairViewYn" value="N" <c:if test="${FairMngBean.fairViewYn eq 'N'}">checked="true"</c:if> /><label for="fairViewYn1">N</label>
			</td>
		</tr>			
		</tbody>
	</table>
	<!-- //bbs_table write -->
</div>
<!-- //bbs_basic view -->
	
	<div class="bbs_btn_wrap clearfix">
		<span class="bbs_left">
			<!-- a href="${pageContext.request.contextPath}/internal/fair/jobFairMng.do" class="bbs_btn list">list</a -->
			<a href="javascript:history.back(-1);" class="bbs_btn list">list</a>
		</span>	
		<span class="bbs_right">
			<input type="button" id="btnDelete" value="Delete" class="bbs_btn delete" />
			<input type="button" id="btnSubmit" value="Save" class="bbs_btn save" />
		</span>
	</div>
	<!-- //bbs_btn_wrap -->
</div>
<!-- //bbs_basic view -->
</form>


<script>

function fileBoothUploadId() {
	
	<c:choose>
	<c:when test="${FairMngBean.user.jcCd eq 'JCT0000000015' or FairMngBean.user.jcCd eq 'JCT0000000099'}">
    var boothFileGrpCnt  = DEXT5UPLOAD.GetTotalFileCount("boothCommonUploadFair");
    
	if(boothFileGrpCnt > 0){
		// 파일전송
		DEXT5UPLOAD.Transfer(boothUploadId);
	} else {
		fnFileFormSave();
	}
	</c:when>
	<c:otherwise>
	fnFileFormSave();
	</c:otherwise>
	</c:choose>
}

</script>