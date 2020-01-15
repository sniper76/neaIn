<%@page import="java.io.File"%><%
    //clipreport4.properties 서버환경에 따라 파일 위치를 지정합니다.
    String propertyPath  = request.getSession().getServletContext().getRealPath("/") +  "WEB-INF" + File.separator + "clipreport4" + File.separator + "clipreport4.properties";
    //String propertyPath  = request.getSession().getServletContext().getRealPath("/") + "clipreport4" + File.separator + "WEB-INF" + File.separator + "clipreport4" + File.separator + "clipreport4.properties";
%>