<%@page import="com.clipsoft.clipreport.oof.connection.OOFConnectionFile"%>
<%@page import="com.clipsoft.clipreport.oof.connection.OOFConnectionData"%>
<%@page import="com.clipsoft.clipreport.oof.connection.OOFConnectionHTTP"%>
<%@page import="com.clipsoft.clipreport.oof.OOFFile"%>
<%@page import="com.clipsoft.clipreport.oof.OOFDocument"%>
<%@page import="java.io.File"%>
<%@page import="java.util.*"%>
<%@page import="com.clipsoft.clipreport.server.service.ReportUtil"%>
<%@page import="com.clipsoft.clipreport.oof.connection.OOFConnectionMemo" %>
<%
//인코딩 타입 UTF-8
request.setCharacterEncoding("UTF-8");
    
//필수 - 리포트 생성에 필요한 파라미터
//String crfName   = (request.getParameter("crfName")   == "" || request.getParameter("crfName")   == null ? "CLIP" : request.getParameter("crfName") );
String crfName=		(request.getParameter("crfName")==""||request.getParameter("crfName")	==null?"CLIP.crf":request.getParameter("crfName"));
String connection1=	(request.getParameter("chk_con")==""||request.getParameter("chk_con")	==null?"":request.getParameter("chk_con"));
String connection2=	(request.getParameter("chk_data")==""||request.getParameter("chk_data")	==null?"":request.getParameter("chk_data"));
String conName=		(request.getParameter("conName")==""||request.getParameter("conName")	==null?"":request.getParameter("conName"));
String conInfo=		(request.getParameter("conInfo")==""||request.getParameter("conInfo")	==null?"":request.getParameter("conInfo"));
String crfParams=	(request.getParameter("crfParams")==""||request.getParameter("crfParams")==null?"":request.getParameter("crfParams"));
String print=		(request.getParameter("print")==""||request.getParameter("print")		==null?"":request.getParameter("print"));

//엔진 컴파일
OOFDocument oof = OOFDocument.newOOF();						//oof doucument 생성 
Enumeration params = request.getParameterNames();			//집합(Vector)에서 객체들을 한순간에 하나씩 처리하는 메소드 

//리포트 파일 별로 커넥션과 매게변수를 설정할 수 있는 OOFFile 객체를 생성
//addFile("crf.root","%root%/crf/crfName.crf") -> root : WEB-INF/clipreport4/
//addFile("crf", "물리경로/crfName.crf")
OOFFile file = oof.addFile("crf.root", "%root%/crf/"+crfName);

//리포트에 사용한 파라미터, 임의로 |과 :로 split 한 상태.
//System.out.println("crfParams:" + crfParams);	
String[] crfParamsArr = crfParams.split("\\|");

for(String param : crfParamsArr){
	String[] temp = param.split(":");
	String name  = ""; 
	String value = "";
	
	if( temp.length == 0 ){
		name  = "";
		value = "";
	} else if( temp.length == 1 ){
		name  = temp[0];
		value = "";
	} else if( temp.length == 2 ){
		name  = temp[0];
		value = temp[1];
	}
	//System.out.println("param ->" + name + ":" + value);
	oof.addField(name, value);
}

//Data, File, Http, Memo 커넥션을 생성
OOFConnectionData d;
OOFConnectionFile f;
OOFConnectionHTTP h;
OOFConnectionMemo m;

if(connection1!=null){
 	switch(connection1){
 	//JDBC-DB 연결 -		file.addConnectionData("*", "oracle1");
 	case "1":	d=	file.addConnectionData(conName, conInfo); break;	//커넥션의 네임스페이스, 서버에 설정된 커넥션의 이름
 	//File 연결 - CSV,XML,JSON	oof.addConnectionFile("*", "/sw/ClipReport4/data/result.xml");
 	case "2":	f=	oof.addConnectionFile(conName, conInfo);		//커넥션의 네임스페이스, 데이터파일의 경로
 				if(connection2.equals("2")) f.addContentParamCSV("*", "UTF-8", "|*|", "|#|", "|@|", ""); 	//데이터셋 네임스페이스, 인코딩, 열 구분자, 행 구분자, 데이터셋 구분자, 데이터셋 인덱스
 				if(connection2.equals("3")) f.addContentParamXML("*", "UTF-8", "{%dataset.xml.root%}");		//데이터셋 네임스페이스, 데이터 인코딩, XML 데이터의 root 경로(Xpath)
 				if(connection2.equals("4")) f.addContentParamJSON("*", "UTF-8", "{%dataset.json.root%}");	//데이터셋 네임스페이스, 데이터 인코딩, JSON 데이터의 root 경로(Xpath)
 				break;
 	//Http 연결 - CSV,XML,JSON	oof.addConnectionFile("*", "http://ClipReport4/data/result.xml","post");
 	case "3":	h=	oof.addConnectionHTTP(conName, conInfo, "post"); //커넥션의 네임스페이스, url경로, 전송방법
 				if(connection2.equals("2")) h.addContentParamCSV("*", "UTF-8", "|*|", "|#|", "|@|", "");	
 				if(connection2.equals("3")) h.addContentParamXML("*", "UTF-8", "{%dataset.xml.root%}");		
 				if(connection2.equals("4")) h.addContentParamJSON("*", "UTF-8", "{%dataset.json.root%}");	
 				break;
 	//Memo 연결 - CSV<XML,JSON	oof.addConnectionFile("*", "<rexroot><rexrow><field1>data</field1></rexrow></rexroot>");
 	case "4":	m=	oof.addConnectionMemo(conName, conInfo);			//커넥션의 네임스페이스, XML/CSV/JSON 데이터 문자열.. CSV데이터일 경우에 <![CDATA[]]>로 쌓아서 사용
 				if(connection2.equals("2")) m.addContentParamCSV("*", "UTF-8", "|*|", "|#|", "|@|", "");	
 				if(connection2.equals("3")) m.addContentParamXML("*", "UTF-8", "{%dataset.xml.root%}");		
 				if(connection2.equals("4")) m.addContentParamJSON("*", "UTF-8", "{%dataset.json.root%}");	
 				break;
 	}
}

//oof출력 - 클립리포트 4.0 OOF Generator 메뉴얼 참고 !!!
//System.out.println("oof : "+oof.toString());
%>

<%@include file="Property.jsp"%> <!-- file을 핸들링 함 -->
<%
//세션을 활용하여 리포트키들을 관리하지 않는 옵션       
//request.getSession().setAttribute("ClipReport-SessionList-Allow", false);\

//리포트 고유의 Key를 생성
String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);

//리포트의 특정 사용자 ID를 부여합니다.
//clipreport4.properties 의 useuserid 옵션이 true 일 때만 적용됩니다. 
//clipreport4.properties 의 useuserid 옵션이 true 이고 기본 예제[String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);] 사용 했을 때 세션ID가 userID로 사용 됩니다.
//String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath, "userID");

//리포트key의 사용자문자열을 추가합니다.(문자숫자만 가능합니다.)
//String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath, "", "usetKey");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="./css/clipreport.css">
<link rel="stylesheet" type="text/css" href="./css/UserConfig.css">
<link rel="stylesheet" type="text/css" href="./css/font.css">
<script type='text/javascript' src='./js/jquery-1.11.1.js'></script>
<script type='text/javascript' src='./js/clipreport.js'></script>
<script type='text/javascript' src='./js/UserConfig.js'></script>
<script type='text/javascript'>

var urlPath = document.location.protocol + "//" + document.location.host;	
function html2xml(divPath){	
	console.log('html2xml====>'+divPath);

	// key 요청, 사용자마다 고유한 key를 가진다.
    var reportkey = "<%=resultKey%>";
    var print = "<%=print%>";

	console.log('reportkey=====>', reportkey);
	console.log('print=====>', print);

	// key를 통해 temp로 가 svg 백터 이미지 생성
	var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", reportkey, document.getElementById(divPath));

	// 타겟에게 view
	if(print=="true"){report.setDirectPrint(true);}
    report.view();
    
}
</script>
</head>
<!-- 이 타겟에게 내가 요청한 걸 붙임 -->
<body onload="html2xml('targetDiv1')">
<div id='targetDiv1' style='position:absolute;top:5px;left:5px;right:5px;bottom:5px;'></div>
</body>
</html>
