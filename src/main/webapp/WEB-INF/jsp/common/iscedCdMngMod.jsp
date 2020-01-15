<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/common/iscedCdMngMod.js"></script>
<script>
	var deleteMsg 	= '<spring:message code="cpes.save.btn.delete.msg" text="delete"></spring:message>';
	var modifyMsg 	= '<spring:message code="cpes.save.btn.modify.msg" text="Modify"></spring:message>';
	var successMsg = '<spring:message code="cpes.success.msg" text="Please select one"></spring:message>';
	var errorMsg  	= '<spring:message code="fail.common.msg" text="error!"></spring:message>';
	var saveMsg 	= '<spring:message code="cpes.save.btn.confirm.msg" text="save"></spring:message>';
	var emptyMsg  	= '<spring:message code="grpcd.chk.empty.msg" text="Please Write Code!"></spring:message>';

	var iscoNmKhMsg  	= '<spring:message code="field.blank.isco.kh" text="Please Write Code!"></spring:message>';
	var iscoNmEnMsg  	= '<spring:message code="field.blank.isco.en" text="Please Write Code!"></spring:message>';
	var iscoDepthMsg  	= '<spring:message code="field.blank.isco.depth" text="Please Write Code!"></spring:message>';
	var oneDepthMsg  	= '<spring:message code="field.blank.isco.onedepth" text="Please Write Code!"></spring:message>';
	var twoDepthMsg  	= '<spring:message code="field.blank.isco.twodepth" text="Please Write Code!"></spring:message>';
	var threeDepthMsg  	= '<spring:message code="field.blank.isco.threedepth" text="Please Write Code!"></spring:message>';

</script>

<div class="tab_obj n5">
        
	<div class="bbs_basic">
		<form id="frm" method="post" >
			<input type="hidden" name="iscedCd" id="iscedCd" value="">
			<input type="hidden" name="iscedId" id="iscedId" value="${iscedCdMngBean.iscedId}">
			<fieldset>
				<h3><spring:message code="field.dic.isced.mng" /></h3>
				<legend>Write a post</legend>
				<div class="bbs_write_top"><span><span class="exactly y">necessary</span>Necessary</span></div>
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
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.isced.cd" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<input type="text" name="txtIscedCd" id="txtIscedCd" value="${iscedCdMngBean.iscedCd}" size="80" maxlength="300" disabled="disabled"/>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.isced.kh" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="khNm" id="khNm" value="${iscedCdMngBean.khNm}" size="80" maxlength="300"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.isced.en" /></label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="enNm" id="enNm" value="${iscedCdMngBean.enNm}" size="80" maxlength="300"/></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.isco.depth" /></label></th>
						<td colspan="3">
							<select id="depth" name="depth" style="width: 32%;">
								<c:forEach var="item" begin="1" end="4">
									<option value="${item}" <c:if test="${item eq iscedCdMngBean.depth}">selected="selected" </c:if> ><c:out value="${item}" /></option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for=""><spring:message code="field.dic.isco.upperdepth" /></label></th>
						<td colspan="3">
							<select id="oneDepth" name="oneDepth" title="oneDepth" style="width: 24%;"> 
									<option value="">1 Depth</option>
								<c:if test="${iscedCdMngBean.depth > '1'}">
									<c:forEach items="${oneDepth}" var="item" varStatus="status">
										<option value="<c:out value="${item.iscedId}"/>" <c:if test="${item.iscedId eq iscedCdMngBean.oneDepth}"> selected="selected" </c:if> >
										<c:out value="${item.cateNm}" />
										</option>
									</c:forEach>
								</c:if>
							</select>
							<select id="twoDepth" name="twoDepth" title="twoDepth" style="width: 33%;">
								<c:choose>
									<c:when test="${iscedCdMngBean.depth > '2'}">
										<option value="${iscedCdMngBean.twoDepth}"><c:out value="${iscedCdMngBean.twoDepthNm}" /></option>
									</c:when>
									<c:otherwise>
										<option value="">2 Depth</option>
									</c:otherwise>
								</c:choose>
							</select>
							<select id="threeDepth" name="threeDepth" title="threeDepth" style="width: 33%;">
								<c:choose>
									<c:when test="${iscedCdMngBean.depth > '3'}">
										<option value="${iscedCdMngBean.threeDepth}"><c:out value="${iscedCdMngBean.threeDepthNm}" /></option>
									</c:when>
									<c:otherwise>
										<option value="">3 Depth</option>
									</c:otherwise>
								</c:choose>
							</select>
						</td>
					</tr>
					
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="title.sample.useYn" /></label></th>
						<td colspan="3">
							<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="${iscedCdMngBean.useYn}" exceptValue="ALL" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="title.sample.regUser" /></label></th>
						<td>
							<input type="text" name="enNm" id="enNm" value="${iscedCdMngBean.regUserNm}" disabled="disabled"/>
						</td>
						<th scope="row"><span class="exactly">necessary</span> <label for=""><spring:message code="field.dic.reg.date" /></label></th>
						<td>
							<input type="text" name="regDate" id="regDate" value="${iscedCdMngBean.regDt}" disabled="disabled"/>
						</td>
					</tr>
					</tbody>
				</table>
				
				
				<div class="bbs_btn_wrap clearfix">
					<span class="bbs_left">
						<button type="button" class="bbs_btn list" onclick="forList();"><spring:message code="cpes.btn.list" /></button>
					</span>
					<span class="bbs_right">
						<button type="button" value="delete" class="bbs_btn delete" onclick="deleteIscedCdConf();"><spring:message code="cpes.btn.delete" /></button>
						<button type="button" value="save" class="bbs_btn save" onclick="updateIscedCdConf();"><spring:message code="cpes.btn.save" /></button>
					</span>
				</div>
				<!-- //bbs_btn_wrap -->
	
			</fieldset>
		</form>
	
	</div>
	<!-- //bbs_basic write -->
	
		</div>
		<!-- // n5 -->