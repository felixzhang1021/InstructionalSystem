<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <base href="<%=basePath%>">
    <base target="main">
    <title>My JSP 'left.jsp' starting page</title>
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
  
  <body>
    <div id="ssbox">
      <h3>导航菜单</h3>
    </div>
    <ul id="ssList">
       <!--栏目列表--> 
           <li><a href="studenttest"><font color="#46A3FF">考试通知</font></a></li>
           </br>       
           <li><a href="autotest"><font color="#46A3FF">自主练习</font></a></li>
           </br>      
           <li><a href="studentshowgrade?stuId=${currentStu.stuId}"><font color="#46A3FF">我的成绩</font></a></li>      
           </br>
           <li><a href="showHistoryPaper"><font color="#46A3FF">历次考题</font></a></li>      
  
           </br>                      
        <!--/栏目列表-->	
    </ul>
  </body>
</html>
