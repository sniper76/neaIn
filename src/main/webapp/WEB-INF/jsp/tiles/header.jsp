<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%
	pageContext.setAttribute("cn", "\n"); //Enter
   	pageContext.setAttribute("br", "<br />");
%>

<meta id="_csrf" name="_csrf" th:content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>

<!-- css -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/file.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/DataTables/datatables.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/DataTables/Datatables-Checkboxes-1.2.11/css/dataTables.checkboxes.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/DataTables/buttons.dataTables.min.css" type="text/css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css" />

<!--  bootstrap Css
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor/bootstrap.min.css"> -->
<!-- include the core styles
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/alertify/themes/alertify.core.css" />
<!-- include a theme, can be included into the core instead of 2 separate files -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/alertify/themes/alertify.default.css" />

<!-- js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.4.1.min.js"></script> -->

<!-- jQuery Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />

<!-- bootstrap scripts
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->

<script src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.9.2.custom.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/plugins/DataTables/datatables.js"></script>
<script src="${pageContext.request.contextPath}/plugins/DataTables/Datatables-Checkboxes-1.2.11/js/dataTables.checkboxes.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/DataTables/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/DataTables/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/DataTables/jszip.min.js"></script>

<script src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/js/ckeditor/config.js"></script>
<script src="${pageContext.request.contextPath}/plugins/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/cpesExcommon.js"></script>

<!-- dext5upload -->
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/dext5upload/js/dext5upload.js"></script>

<script>
var contextPath = '${pageContext.request.contextPath}';
var lang = '${ pageContext.request.locale.language }';
var i18n = {};

$.ajax({ method: 'get', url: contextPath + '/message/message-common.do', dataType: 'json'})
.done(function (res, status, responseObj) {

	res.i18n.forEach(function (item) {
		i18n[Object.keys(item)] = item[Object.keys(item)];
	});
	//console.log( i18n );
	//console.log( t('errors.maxlength', ["'문자열'", "2"]) );
	//console.log(t('button.delete'));
}).fail(function (result, status, responseObj) {
	console.log(status);
});

function t(key, arrValue) {
	var reVal = value = i18n[key];

	if ($.isArray(arrValue)) {
		arrValue.forEach(function (v, i) {
			value = value.replace('{'+i+'}', v);
		});
		reVal = value;
	}

	return reVal;
}

</script>
<style>
	#mask {  
	  position:absolute;  
	  left:0;
	  top:0;
	  z-index:100;  
	  background-color:#000;  
	  display:none;  
	}
       #loadingImg {
	  position:absolute;
	  left:45%;
	  top:50%;
	  z-index:120;
	}
</style>


<!--  ALERTFY -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/alertify/lib/alertify.min.js"></script>

<div id="div_common">
</div>
