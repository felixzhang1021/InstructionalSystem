<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="welcome.jsp">
    
    <title>在线测试</title>
    <%
	// 权限验证
	if(session.getAttribute("currentStu")==null){
		response.sendRedirect("index.jsp");
		return;
	}
%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <frameset rows=140,*  bordercolor='#006699' border=1 >
      <frame id=topFrame name=topFrame src="top.jsp" noResize scrolling=no>
       <frameset rows=* cols=10%,*>
       <frame name=left src="left.jsp">  
       <frame name=main src="#">
     </frameset>
</frameset>
</html>
