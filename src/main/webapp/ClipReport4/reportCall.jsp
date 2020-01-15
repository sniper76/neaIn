<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="Content-Type" content="stext/html; charset=UTF-8">
<title>Insert title here</title>
<%
//response.setHeader("Access-Control-Allow-Origin", "*");
%>
<script>

	//form을 지정한 페이지로 전송 - 공통페이지 (reportView.jsp)
	//팝업으로 리포트 호출
	function view_popup() {
		window.open('about:blank','popwin','width=1200,height=600');
		form = document.rexForm;
		form.target = "popwin";
		rexForm.submit();
	}
	
	//지정한 iframe 에 리포트 호출
	function view_iframe() {
		form = document.rexForm;
		form.target = "main_frame";
		form.submit();
		
		//document.getElementById("main_frame").src = "./sample.jsp?"
		//											+ "crfname="+url;
	}
	
	//리포트 view 없이 바로 프린트 출력
	function directPrint() {
		document.getElementById('print').value="true";
		form = document.rexForm;
		form.target = "print_iframe";
		rexForm.submit();
		
		document.getElementById('print').value="false";
	}
	
	//커넥션타입별로 데이터타입 선택지를 바꾼다.
	function con_div(v, id){
		if(v=="1"){	//JDBC선택할경우 DB버튼만 보이게하고 DB버튼 체크
			document.getElementById('data_db').style.display="";
			document.getElementById('data_other').style.display="none";
			if(document.getElementById('chk_db').checked!=true) 
				document.getElementById('chk_db').checked=true;
			}
		else{		//아닐경우 DB버튼을 숨기고 다른버튼 활성화, 가장 윗단 버튼 체크
			document.getElementById('data_db').style.display="none";
			document.getElementById('data_other').style.display="";
			if(document.getElementById('chk_db').checked==true) 
				document.getElementsByName('chk_data')[1].checked=true;
			}
	}

</script>
</head>

<body>
	<<!-- form : action="url" name="식별자" method="http메소드" -->
	<form id="rexForm" name="rexForm" action="./reportView.jsp" method="post" target="popwin">
	
		<!-- 전송버튼  -->
		<input type="button" value="popup" onclick="view_popup()">
		<input type="button" value="iframe" onclick="view_iframe()">
		<input type="button" value="print" onclick="directPrint()"><br>
		<!-- print -->
		<input type="hidden" id="print" name="print" value="false">
		
		<div style="float:left; width:33%; padding:10px;">
		
		<!-- CRF 파일 이름  -->
		1. crf name: <input type="text" name="crfName" value="CLIP.crf" size=25><br><br>
			
		<!-- 커넥션 타입, 데이터 종류 선택 -->
		<!-- 커넥션 타입 선택  -->
		2. Connection Type<br>
		<input type="radio" name="chk_con" value="1" onclick="con_div(this.value,'con_jdbc')" checked="checked">JDBC<br>
		<input type="radio" name="chk_con" value="2" onclick="con_div(this.value,'con_file')">FILE<br>
		<input type="radio" name="chk_con" value="3" onclick="con_div(this.value,'con_http')">HTTP<br>
		<input type="radio" name="chk_con" value="4" onclick="con_div(this.value,'con_memo')">MEMO<br><br>
		
		<!-- 데이터 종류 선택 -->
		3. Content Type<br>
		<div id="data_db">
		<input type="radio" id="chk_db" name="chk_data" value="1" checked="checked">DB<br>
		</div>
		<div id="data_other" style="display:none">
		<input type="radio" name="chk_data" value="2" >csv<br>
		<input type="radio" name="chk_data" value="3" >xml<br>
		<input type="radio" name="chk_data" value="4" >json<br><br>
		</div>
		
		<!-- 커넥션 정보 입력 --><br>
		-connection name : <input type="text" id='conName' name="conName" placeholder="* - JDBC Connction Name"><br>
		-connection info : <input type="text" id='conInfo' name="conInfo" placeholder="oracle1 - dbname"><br><br>
		
		<!-- parameter -->
		4. Parameter<br>
		<div id="param" style="padding:10px;">
		- parameter field :  <input type="text" name="crfParams" placeholder="key:value|key:value|key:value| ..."><br>
		</div>
	</div>
	
	<!-- 리포트 출력 영역 -->
	<div style="float:left; width:66%; border: solid; padding:10px; max-width: 820px; height:800px;">
	<iframe width="100%" height="100%" frameborder="0" border="0" scrolling="yes" bgcolor=#EEEEEE bordercolor="#FF000000" marginwidth="0"  marginheight="0" name="main_frame" id="main_frame"></iframe>
	<iframe  width="0%" height="0%"name="print_iframe" id="print_iframe"></iframe>
	</div>
</form>
</body>
</html> 