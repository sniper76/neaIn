<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/pageLib/siteMgmt/bannerMod.js"></script>
<script>
	
</script>

<div class="tab_obj n5">
        
	<div class="bbs_basic">
		<form id="frm" method="post" >
			<input type="hidden" name="bannerSeq" id="bannerSeq" value="<c:out value="${bannerSeq}" />" />
			<fieldset>
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
						<th scope="row"><span class="exactly y">necessary</span> <label for="">제목</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="title" id="title" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly">necessary</span> <label for="">등록일시</label></th>
						<td><input type="text" name="regDt" id="regDt"  disabled="disabled" /></td>
						<th scope="row"><span class="exactly">necessary</span> <label for="">작성자</label></th>
						<td><input type="text" name="writerNm" id="writerNm"  disabled="disabled" /></td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for="">예약 설정</label></th>
						<td colspan="3">

							<div>
								<label for="">예약설정 사용</label>
								<commCode:commcode codeKind="commCode" tagName="resvYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
							</div>
							<div id="strDiv">
								<label for="">예약 시작일</label>&nbsp;&nbsp;
								<input type="text" id="bgnDt" name="bgnDt" class="datepicker" title="Start date Select from calendar" placeholder="start date" />
								<select id="bgnAmpm" name="bgnAmpm" title="AmPm">
									<option value="AM">AM</option>
									<option value="PM">PM</option>
								</select>
								<select id="bgnHour" name="bgnHour" title="Hour">
									<c:forEach var="hour" begin="1" end="12">
									<c:choose>
										<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
										<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
									</c:choose>
										<option value="<c:out value="${setHour}"/>"><c:out value="${setHour}"/></option>
									</c:forEach>
								</select>
								<select id="bgnMinute" name="bgnMinute" title="Minute">
									<c:forEach var="minute" begin="0" end="59">
									<c:choose>
										<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
										<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
									</c:choose>
										<option value="<c:out value="${setMinute}"/>"><c:out value="${setMinute}"/></option>						
									</c:forEach>
								</select>
							</div>
							<div id="endDiv">
								<label for="">예약 종료일</label>&nbsp;&nbsp;
								<input type="text" id="endDt" name="endDt" class="datepicker" title="Start date Select from calendar" placeholder="start date" />
								<select id="endAmpm" name="endAmpm" title="AmPm">
									<option value="AM">AM</option>
									<option value="PM">PM</option>
								</select>
								<select id="endHour" name="endHour" title="Hour">
									<c:forEach var="hour" begin="1" end="12">
									<c:choose>
										<c:when test="${hour < 10}"><c:set var="setHour" value="0${hour}" /></c:when>
										<c:otherwise><c:set var="setHour" value="${hour}" /></c:otherwise>
									</c:choose>
										<option value="<c:out value="${setHour}"/>"><c:out value="${setHour}"/></option>
									</c:forEach>
								</select>
								<select id="endMinute" name="endMinute" title="Minute">
									<c:forEach var="minute" begin="0" end="59">
									<c:choose>
										<c:when test="${minute < 10}"><c:set var="setMinute" value="0${minute}" /></c:when>
										<c:otherwise><c:set var="setMinute" value="${minute}" /></c:otherwise>
									</c:choose>
										<option value="<c:out value="${setMinute}"/>"><c:out value="${setMinute}"/></option>						
									</c:forEach>
								</select>
								&nbsp;
								<input type="checkbox" id="endNtDt" name="endNtDt" value="" /><spring:message code="popup.dtl.title.todayOpen"/>
							</div>

						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for="">사용여부</label></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="useYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
						</td>
						<th scope="row"><span class="exactly y">necessary</span> <label for="">하루동안 보지 않기</label></th>
						<td>
							<commCode:commcode codeKind="commCode" tagName="todayOpenYn" grpCd="FIELD_YN_CD" drawType="radio" initValue="Y" exceptValue="ALL" disable=""/>
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for="">배너 이미지</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3">
							<img src="${pageContext.request.contextPath}/images/board/dummy_photo.png" alt="">
							<input type="file" name="files[]" multiple />
						</td>
					</tr>
					<tr>
						<th scope="row"><span class="exactly y">necessary</span> <label for="">연결 URL</label></th><!-- 필수 황목일 경우 exacly 에 클래스 y 추가 -->
						<td colspan="3"><input type="text" name="connUrl" id="connUrl" /></td>
					</tr>
					</tbody>
				</table>
				
				
				<div class="bbs_btn_wrap clearfix">
					<span class="bbs_left">
						<button type="button" class="bbs_btn list" onclick="forList();">list</button>
					</span>
					<span class="bbs_right">
						<button type="button" value="save" class="bbs_btn save" onclick="updateBannerConf();">Save</button>
						<button type="button" value="delete" class="bbs_btn delete" onclick="deleteBannerConf();">Delete</button>
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