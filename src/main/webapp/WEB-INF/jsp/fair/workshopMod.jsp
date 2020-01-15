<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/fair/workshopMod.js"></script>
<script>
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';

	$(function() {
		common.invoker.invoke("workshopMod");

	});

</script>

<div class="tab_obj n5">

	<div class="bbs_basic">
		<form id="frm" method="post" >
			<input type="hidden" id="commonUploadResult" name="uploadResult">
			<input type="hidden" id="fairSeq" name="fairSeq" value="${param.fairSeq }">
			<input type="hidden" id="fairWorkshopSeq" name="fairWorkshopSeq" value="${result.fairWorkshopSeq }">
			<input type="hidden" id="teachFileGrpSeq" name="teachFileGrpSeq" value="${result.teachFileGrpSeq }">
			<input type="hidden" id="patcptnCnt" value="${result.patcptnCnt }">
			<fieldset>
				<h3><spring:message code="field.dic.workshopInfo" /></h3>
				<legend>Write a post</legend>
				<table class="bbs_table write">
					<caption>{Board name} Write - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트 입력</caption>
					<colgroup>
						<col style="width:15%;" />
						<col style="width:35%;" />
						<col style="width:15%;" />
						<col style="width:35%;" />
					</colgroup>
					<tbody>

					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="fair.list.fair.nm" /></label></th>
						<td><c:out value="${fairInfo.fairNm }" /></td>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.jobcntr" /></label></th>
						<td><c:out value="${fairInfo.mstJcNm}" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.workshopNm" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="workshopNm" id="workshopNm" value="${result.workshopNm }" style="width: 100%;"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="title.sample.description" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><textarea rows="" cols="" name="expln" id="expln"><c:out value="${result.expln }" /></textarea></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.workshopThum" /></label></th>
						<td colspan="3">
							<img id="thumFileImg" class="previewImg" src="${pageContext.request.contextPath}/common/imgLoading.do?url=${result.thumFilePath }" alt="" style="width: 225px; height: 225px;">
							<input type="file" class="previewImgFile" id="thumFile" >
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.workshopDt" /></label></th>
						<td colspan="3">
							<span class="period_box">
								<span class="date_box">
									<input type="text" id="workshopDt" name="workshopDt" value="${result.workshopDt }" class="datepicker" title="date Select from calendar" placeholder="date" readonly="readonly" />
								</span>
							</span>
							<span class="bbs_date" style="padding-left:25px;">
								<select id="bgnHour" name="bgnHour" title="hour">
									<c:forEach var="hour" begin="1" end="12">
										<c:choose>
											<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
											<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
										</c:choose>
										<option value="<c:out value="${setHour}"/>" <c:if test="${setHour eq result.bgnHour }">selected="selected"</c:if>>
											<c:out value="${setHour}"/>
										</option>
									</c:forEach>
								</select>
								<label for="bgnHour">HH</label>
							</span>
							<span class="bbs_date">
								<select id="bgnMinute" name="bgnMinute" title="minute">
									<c:forEach var="minute" begin="0" end="59">
										<c:choose>
											<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
											<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
										</c:choose>
										<option value="<c:out value="${setMinute}"/>" <c:if test="${setMinute eq result.bgnMinute }">selected="selected"</c:if>>
											<c:out value="${setMinute}"/>
										</option>
									</c:forEach>
								</select>
								<label for="bgnMinute">MM</label>
							</span>
							<span class="bbs_date">
								<select id="bgnAmpm" name="bgnAmpm" title="Ampm">
									<option value="AM" <c:if test="${'AM' eq result.bgnAmpm }">selected="selected"</c:if>>AM</option>
									<option value="PM" <c:if test="${'PM' eq result.bgnAmpm }">selected="selected"</c:if>>PM</option>
								</select>
								<label for="bgnAmpm">AMPM</label>
							</span>
							~
							<span class="bbs_date" style="padding-left:25px;">
								<select id="endHour" name="endHour" title="hour">
									<c:forEach var="hour" begin="1" end="12">
										<c:choose>
											<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
											<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
										</c:choose>
										<option value="<c:out value="${setHour}"/>" <c:if test="${setHour eq result.endHour}"> selected="selected" </c:if> >
											<c:out value="${setHour}"/>
										</option>
									</c:forEach>
								</select>
								<label for="endHour">HH</label>
							</span>
							<span class="bbs_date">
								<select id="endMinute" name="endMinute" title="minute">
									<c:forEach var="minute" begin="0" end="59">
										<c:choose>
											<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
											<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
										</c:choose>
										<option value="<c:out value="${setMinute}"/>" <c:if test="${setMinute eq result.endMinute}"> selected="selected" </c:if> >
											<c:out value="${setMinute}"/>
										</option>
									</c:forEach>
								</select>
								<label for="endMinute">MM</label>
							</span>
							<span class="bbs_date">
								<select id="endAmpm" name="endAmpm" title="Ampm">
									<option value="AM" <c:if test="${'AM' eq result.endAmpm}"> selected="selected" </c:if> >AM</option>
									<option value="PM" <c:if test="${'PM' eq result.endAmpm}"> selected="selected" </c:if> >PM</option>
								</select>
								<label for="endAmpm">AMPM</label>
							</span>

						</td>

					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.workshopAddr" /></label></th>
						<td colspan="3">
							<input type="button" class="bbs_btn type03" onclick="popAddrLayerBtn('addrCd','addrFullCd','addrFullNm','addrFullNmView');" value="<spring:message code="button.addr.nm" />" />
							<input type="hidden" name="workshopAddrCd" id="addrCd" value="${result.workshopAddrCd }"  />
               				<input type="hidden" name="workshopAddrFullCd" id="addrFullCd" value="${result.workshopAddrFullCd }" />
               				<input type="text" name="workshopAddrFullNm" id="addrFullNm" value="${result.workshopAddrFullNm }" readonly="readonly" style="width: 40%;"/>
               				<input type="text" name="workshopAddrDtl" id="addrFullDtl" value="${result.workshopAddrDtl }" style="width: 40%;" />
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.lectureRoom" /></label></th>
						<td colspan="3"><input type="text" name="lectureRoom" id="lectureRoom" value="${result.lectureRoom }" style="width: 100%;"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.tuition.fee" /></label></th>
						<td colspan="3">
							<commCode:commcode codeKind="commCode" tagName="tuitionGrpCd" grpCd="TUITION_GRP_CD" drawType="radio" initValue="${result.tuitionGrpCd }" exceptValue="ALL" disable="true"/>
							<input type="text" name="tuition" id="tuition" class="inputNo" value="${result.tuition }" readonly="readonly"/><label for="tuition">$</label>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.google.link" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<input type="text" name="googleMapLink" id="googleMapLink" value="${result.googleMapLink }" style="width: 100%;" />
						</td>
					</tr>
					</tbody>
				</table>

				<h3><spring:message code="field.dic.rsps.prsn" /></h3>
				<legend>Write a post</legend>
				<table class="bbs_table write">
					<caption>{Board name} Write - 공지사항여부, 부서, 제목, 작성자, 내용, 첨부파일, 이미지첨부파일의 대체텍스트 입력</caption>
					<colgroup>
						<col style="width:15%;" />
						<col style="width:35%;" />
						<col style="width:15%;" />
						<col style="width:35%;" />
					</colgroup>
					<tbody>

					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.resprsnnm" /></label></th>
						<td colspan="3"><input type="text" name="mngerNm" id="mngerNm" value="${result.mngerNm }" style="width: 100%;"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.res.prsn.tel" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td><input type="text" name="mngerTel" id="mngerTel" class="inputNo" value="${result.mngerTel }" style="width: 100%;"/></td>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="userChg.list.title.email" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td><input type="text" name="mngerEmail" id="mngerEmail" class="inputEmail" value="${result.mngerEmail }" style="width: 100%;"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.select.register" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td><c:out value="${result.modUserNm }" /></td>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.regModDt" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td><c:out value="${result.modDt }" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.target" /></label></th>
						<td><input type="text" name="target" id="target" value="${result.target }" style="width: 100%;"/></td>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.recrumt.memb" /></label></th>
						<td><input type="text" name="recurmtMan" id="recurmtMan" value="${result.recurmtMan }" class="inputNo" style="width: 100%;"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.teacherNm" /> 1</label></th>
						<td><input type="text" name="teacherNm1" id="teacherNm1" value="${result.teacherNm1 }" style="width: 100%;"/></td>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.teacherNm" /> 2</label></th>
						<td><input type="text" name="teacherNm2" id="teacherNm2" value="${result.teacherNm2 }" style="width: 100%;"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.teacherPhoto1" /></label></th>
						<td>
							<img id="teacherPhoto1Img" class="previewImg" src="${pageContext.request.contextPath}/common/imgLoading.do?url=${result.teacherPhoto1FilePath }" alt="" style="width: 225px; height: 225px;">
							<input type="file" class="previewImgFile" id="teacherPhoto1" >
						</td>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.teacherPhoto2" /></label></th>
						<td>
							<img id="teacherPhoto2Img" class="previewImg" src="${pageContext.request.contextPath}/common/imgLoading.do?url=${result.teacherPhoto2FilePath }" alt="" style="width: 225px; height: 225px;">
							<input type="file" class="previewImgFile" id="teacherPhoto2" >
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.teacherBhist1" /></label></th>
						<td colspan="3"><textarea rows="" cols="" id="teacherBhist1" name="teacherBhist1"><c:out value="${result.teacherBhist1}" /></textarea></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.teacherBhist2" /></label></th>
						<td colspan="3"><textarea rows="" cols="" id="teacherBhist2" name="teacherBhist2"><c:out value="${result.teacherBhist2}" /></textarea></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.teachPhoto" /></label></th>
						<td colspan="3">
							<div id="teachFileDext5uploadArea"></div>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="bulletin.dic.useyn" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<input type="radio" id="useYn_Y" name="useYn" value="Y" <c:if test="${'Y' eq result.useYn }">checked="checked"</c:if>/><label for="useYn_Y">Y</label>
							<input type="radio" id="useYn_N" name="useYn" value="N" <c:if test="${'N' eq result.useYn }">checked="checked"</c:if>/><label for="useYn_N">N</label>
						</td>
					</tr>
					</tbody>
				</table>


				<div class="bbs_btn_wrap clearfix">
					<span class="bbs_left">
						<button type="button" class="bbs_btn list" id="btn_list"><spring:message code="cpes.btn.list" /></button>
					</span>
					<span class="bbs_right">
						<button type="button" class="bbs_btn save" onclick="deleteWorkshopSave();"><spring:message code="button.delete" /></button>
						<button type="button" value="save" class="bbs_btn save" onclick="updateWorkshopSave();"><spring:message code="button.modify" /></button>
						<!--input type="submit" value="Modify" class="bbs_btn modify" />
						<a href="" class="bbs_btn delete">Delete</a-->
					</span>
				</div>
				<!-- //bbs_btn_wrap -->

			</fieldset>
		</form>

	</div>
	<!-- //bbs_basic write -->

		</div>
		<!-- // n5 -->