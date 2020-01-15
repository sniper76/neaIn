<%@page import="com.clipsoft.clipreport.oof.OOFFile"%>
<%@page import="com.clipsoft.clipreport.oof.OOFDocument"%>
<%@page import="com.clipsoft.clipreport.oof.connection.*"%>
<%@page import="java.io.File"%>
<%@page import="com.clipsoft.clipreport.server.service.ReportUtil"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//필수 - 레포트 생성 객체
	OOFDocument oof = OOFDocument.newOOF();

	//필수 - 레포트 파일명
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/CLIP.crf");
	
	
	// 옵션 - 레포트 파라메터(파라메터 NAME 대문자 중요!)
	oof.addField("PARAM1", "param&&&#---1value");
	oof.addField("한 글 123 abc", " param&&&#---1value");
	
	
	//-------------------------------------
	// //옵션 - 데이터베이스 연결 정보 (서버로 통해 데이터를 가져올 때)	
	//-------------------------------------	
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/DBTEST.crf");	
	//oof.addConnectionData("*", "oracle1");
	
	
	//-------------------------------------
	// 1. file을 통해 데이터를 가져오는 방법(XML/CSV/JSON)
	//-------------------------------------
	
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/oracle_emp.crf");
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/json.crf");
	
	//OOFConnectionFile c = oof.addConnectionFile("*","C:/Workspace/ClipReport4/WebContent/oracle_emp.xml"); 	//(리포트파일설정의커넥션명(*-ALL),data파일 절대경로)
	//c.addContentParamXML("*", "euc-kr", "gubun/rpt1/rexdataset/rexrow");										//(데이터셋명,encoding,반복노드root설정) 
	
	//OOFConnectionFile c = oof.addConnectionFile("*","C:/Workspace/ClipReport4/WebContent/oracle_emp.csv");
	//c.addContentParamCSV("*", "UTF-8", "|*|", "|#|", "|@|", "1");
	
	//OOFConnectionFile c = oof.addConnectionFile("*","C:/Workspace/ClipReport4/WebContent/jsondata.json");
	//c.addContentParamCSV("*", "UTF-8", "{%dataset.json.root%}");
	
	//-----------------------------------------
	// 2. memo값을 통해 데이터를 가져오는 방법(XML/CSV/JSON)
	//-----------------------------------------
	
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/oracle_emp.crf");
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/CLIPjson.crf");
	
	//OOFConnectionMemo c = oof.addConnectionMemo("*", "<gubun><rpt1><rexdataset><rexrow><EMPNO><![CDATA[7369]]></EMPNO><ENAME><![CDATA[SMITH]]></ENAME><JOB><![CDATA[CLERK]]></JOB><MGR><![CDATA[7902]]></MGR><HIREDATE><![CDATA[1980-12-17 00:00:00.0]]></HIREDATE><SAL><![CDATA[800]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[20]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7499]]></EMPNO><ENAME><![CDATA[ALLEN]]></ENAME><JOB><![CDATA[SALESMAN]]></JOB><MGR><![CDATA[7698]]></MGR><HIREDATE><![CDATA[1981-02-20 00:00:00.0]]></HIREDATE><SAL><![CDATA[1600]]></SAL><COMM><![CDATA[300]]></COMM><DEPTNO><![CDATA[30]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7521]]></EMPNO><ENAME><![CDATA[WARD]]></ENAME><JOB><![CDATA[SALESMAN]]></JOB><MGR><![CDATA[7698]]></MGR><HIREDATE><![CDATA[1981-02-22 00:00:00.0]]></HIREDATE><SAL><![CDATA[1250]]></SAL><COMM><![CDATA[500]]></COMM><DEPTNO><![CDATA[30]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7566]]></EMPNO><ENAME><![CDATA[JONES]]></ENAME><JOB><![CDATA[MANAGER]]></JOB><MGR><![CDATA[7839]]></MGR><HIREDATE><![CDATA[1981-04-02 00:00:00.0]]></HIREDATE><SAL><![CDATA[2975]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[20]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7654]]></EMPNO><ENAME><![CDATA[MARTIN]]></ENAME><JOB><![CDATA[SALESMAN]]></JOB><MGR><![CDATA[7698]]></MGR><HIREDATE><![CDATA[1981-09-28 00:00:00.0]]></HIREDATE><SAL><![CDATA[1250]]></SAL><COMM><![CDATA[1400]]></COMM><DEPTNO><![CDATA[30]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7698]]></EMPNO><ENAME><![CDATA[BLAKE]]></ENAME><JOB><![CDATA[MANAGER]]></JOB><MGR><![CDATA[7839]]></MGR><HIREDATE><![CDATA[1981-05-01 00:00:00.0]]></HIREDATE><SAL><![CDATA[2850]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[30]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7782]]></EMPNO><ENAME><![CDATA[CLARK]]></ENAME><JOB><![CDATA[MANAGER]]></JOB><MGR><![CDATA[7839]]></MGR><HIREDATE><![CDATA[1981-06-09 00:00:00.0]]></HIREDATE><SAL><![CDATA[2450]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[10]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7788]]></EMPNO><ENAME><![CDATA[SCOTT]]></ENAME><JOB><![CDATA[ANALYST]]></JOB><MGR><![CDATA[7566]]></MGR><HIREDATE><![CDATA[1987-04-19 00:00:00.0]]></HIREDATE><SAL><![CDATA[3000]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[20]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7839]]></EMPNO><ENAME><![CDATA[KING]]></ENAME><JOB><![CDATA[PRESIDENT]]></JOB><MGR><![CDATA[null]]></MGR><HIREDATE><![CDATA[1981-11-17 00:00:00.0]]></HIREDATE><SAL><![CDATA[5000]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[10]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7844]]></EMPNO><ENAME><![CDATA[TURNER]]></ENAME><JOB><![CDATA[SALESMAN]]></JOB><MGR><![CDATA[7698]]></MGR><HIREDATE><![CDATA[1981-09-08 00:00:00.0]]></HIREDATE><SAL><![CDATA[1500]]></SAL><COMM><![CDATA[0]]></COMM><DEPTNO><![CDATA[30]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7876]]></EMPNO><ENAME><![CDATA[ADAMS]]></ENAME><JOB><![CDATA[CLERK]]></JOB><MGR><![CDATA[7788]]></MGR><HIREDATE><![CDATA[1987-05-23 00:00:00.0]]></HIREDATE><SAL><![CDATA[1100]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[20]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7900]]></EMPNO><ENAME><![CDATA[JAMES]]></ENAME><JOB><![CDATA[CLERK]]></JOB><MGR><![CDATA[7698]]></MGR><HIREDATE><![CDATA[1981-12-03 00:00:00.0]]></HIREDATE><SAL><![CDATA[950]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[30]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7902]]></EMPNO><ENAME><![CDATA[FORD]]></ENAME><JOB><![CDATA[ANALYST]]></JOB><MGR><![CDATA[7566]]></MGR><HIREDATE><![CDATA[1981-12-03 00:00:00.0]]></HIREDATE><SAL><![CDATA[3000]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[20]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[7934]]></EMPNO><ENAME><![CDATA[MILLER]]></ENAME><JOB><![CDATA[CLERK]]></JOB><MGR><![CDATA[7782]]></MGR><HIREDATE><![CDATA[1982-01-23 00:00:00.0]]></HIREDATE><SAL><![CDATA[1300]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[10]]></DEPTNO></rexrow><rexrow><EMPNO><![CDATA[8888]]></EMPNO><ENAME><![CDATA[홍길동]]></ENAME><JOB><![CDATA[기술]]></JOB><MGR><![CDATA[7788]]></MGR><HIREDATE><![CDATA[null]]></HIREDATE><SAL><![CDATA[null]]></SAL><COMM><![CDATA[null]]></COMM><DEPTNO><![CDATA[null]]></DEPTNO></rexrow></rexdataset></rpt1></gubun>");  //(리포트파일설정의커넥션명(*-ALL),data memo)
	//c.addContentParamXML("*", "euc-kr", "gubun/rpt1/rexdataset/rexrow"); //(데이터셋명,encoding,반복노드root설정) 
	//리포트 파일에 설정된 반복노드 사용할 경우("*", "euc-kr", "{%dataset.xml.root%}");
	
	
	//OOFConnectionMemo c = oof.addConnectionMemo("*", "7369|*|SsdfITH|*|CLE&&&&&RK|*|7902|*|1980-12-17 00:00:00.0|*|800|*|null|*|20|#|7499|*|ALLEN|*|SALESMAN|*|7698|*|1981-02-20 00:00:00.0|*|1600|*|300|*|30|#|7521|*|WARD|*|SALESMAN|*|7698|*|1981-02-22 00:00:00.0|*|1250|*|500|*|30|#|7566|*|JONES|*|MANAGER|*|7839|*|1981-04-02 00:00:00.0|*|2975|*|null|*|20|#|7654|*|MARTIN|*|SALESMAN|*|7698|*|1981-09-28 00:00:00.0|*|1250|*|1400|*|30|#|7698|*|BLAKE|*|MANAGER|*|7839|*|1981-05-01 00:00:00.0|*|2850|*|null|*|30|#|7782|*|CLARK|*|MANAGER|*|7839|*|1981-06-09 00:00:00.0|*|2450|*|null|*|10|#|7788|*|SCOTT|*|ANALYST|*|7566|*|1987-04-19 00:00:00.0|*|3000|*|null|*|20|#|7839|*|KING|*|PRESIDENT|*|null|*|1981-11-17 00:00:00.0|*|5000|*|null|*|10|#|7844|*|TURNER|*|SALESMAN|*|7698|*|1981-09-08 00:00:00.0|*|1500|*|0|*|30|#|7876|*|ADAMS|*|CLERK|*|7788|*|1987-05-23 00:00:00.0|*|1100|*|null|*|20|#|7900|*|JAMES|*|CLERK|*|7698|*|1981-12-03 00:00:00.0|*|950|*|null|*|30|#|7902|*|FORD|*|ANALYST|*|7566|*|1981-12-03 00:00:00.0|*|3000|*|null|*|20|#|7934|*|MILLER|*|CLERK|*|7782|*|1982-01-23 00:00:00.0|*|1300|*|null|*|10|#|8888|*|홍길동|*|기술|*|7788|*|null|*|null|*|null|*|null");
	//c.addContentParamCSV("*", "UTF-8", "|*|", "|#|", "|@|", "1");
	
	String jsonStr = "{ \"employee\" : { \"age\":32, \"name\" : \"ABC DEF\",  \"married\" : \"true\"}}"; 
	OOFConnectionMemo c = oof.addConnectionMemo("*", jsonStr);  
	c.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}"); 
	
	//------------------------------------------
	// 3. http(post)를 통해 데이터를 가져오는 방법(XML/CSV/JSON)
	//------------------------------------------
	
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/oracle_emp.crf");
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/json.crf");
	
	//OOFConnectionHTTP c = oof.addConnectionHTTP("*", "http://localhost:8080/ClipReport4/oracle_emp.xml", "post"); //(리포트파일설정의커넥션명(*-ALL),data연결URL,method)
	//c.addContentParamXML("*", "euc-kr", "gubun/rpt1/rexdataset/rexrow"); 											//(데이터셋명,data encoding,반복노드root설정) 
	
	//OOFConnectionHTTP c = oof.addConnectionHTTP("*", "http://localhost:8080/ClipReport4/oracle_emp.csv", "post"); 
	//c.addContentParamCSV("*", "UTF-8", "|*|", "|#|", "|@|", "1");
	
	//OOFConnectionHTTP c = oof.addConnectionHTTP("*", "http://localhost:8080/ClipReport4/jsondata.json", "post"); 
	//c.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	
	//------------------------------------------
	// 4. JDBC를 통해 데이터를 가져오는 방법
	//------------------------------------------
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/DBTEST.crf");
	//OOFConnectionJDBC c = oof.addConnectionJDBC("*", "oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@192.168.0.216:1521:orcl", "cliptest1", "clipsoft815"); //(커넥션명,DB드라이브명,DBConnURL)
	//c.addContentParamDB("SQLDS1"); //addContentParamDB 연결된 데어터 셋 명
	//c.addContentParamDB("ds1");
	
	//------------------------------------------
	// 5. 여러 레포트파일을 한번에 미리보기
	//------------------------------------------
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/DBTEST.crf");
	//			   oof.addFile("crf.root", "%root%/crf/Rexpert1.crf");
	//			   oof.addConnectionData("*", "oracle1");
	//			   oof.addField("SECTION", "1");
	//----------------------------------------------
	// 6. 하나의 리포트에서 다중 커넥션을 통해  데이터를 가져오는 방법 - 디자인시 만든 커넥션 명에 따라 설정
	//----------------------------------------------	
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/Multiconn.crf");	
	//			          oof.addConnectionData("JDBC1", "oracle1");
	//OOFConnectionFile c = oof.addConnectionFile("JSON1","C:/Workspace/ClipReport4/WebContent/jsondata.json");  
	//				      c.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}"); 
	//----------------------------------------------
	// 7. 다중 리포트에서 다중 커넥션을 통해  데이터를 가져오는 방법 - 디자인시 만든 커넥션 명에 따라 설정
	//----------------------------------------------
	//OOFFile file = oof.addFile("crf.root", "%root%/crf/DBTEST.crf");
	//    		   oof.addConnectionData("JDBC1", "oracle1");  
	//    		   oof.addFile("crf.root", "%root%/crf/CLIPjson.crf");
	//OOFConnectionMemo c = oof.addConnectionMemo("JSON3", "{ \"employee\" : { \"age\":32, \"name\" : \"ABC DEF\",  \"married\" : \"true\"}}");  
	//				    c.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}"); 
					
				   
	
				   
	//System.out.println(oof);
%><%@include file="Property.jsp"%><%
String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);
System.out.println(oof);
%>
<!doctype html>
<html>
<head>
<title>Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="./css/clipreport.css">
<link rel="stylesheet" type="text/css" href="./css/UserConfig.css">
<link rel="stylesheet" type="text/css" href="./css/font.css">
<script type='text/javascript' src='./js/clipreport.js'></script>
<script type='text/javascript' src='./js/jquery-1.11.1.js'></script>
<script type='text/javascript' src='./js/UserConfig.js'></script>

<script type='text/javascript'>

var urlPath = document.location.protocol + "//" + document.location.host;
var report = "";

window.onload = function(){
	 var reportkey = "<%=resultKey%>";
	    report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", reportkey, document.getElementById("targetDiv1"));
	    report.view();
};

</script>
</head>
<body>
<div id='targetDiv1' style='position:absolute;left:0px;top:0px;height:100%;width:100%'></div>
</body>
</html>
