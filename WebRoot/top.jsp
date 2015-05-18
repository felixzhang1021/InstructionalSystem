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
    <title>My JSP 'top.jsp' starting page</title>
    
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
   <div id="autoHeader">
      <div id="header">
        <div id="logo">
          <img src="./images/logo.png" alt="大连民族大学">
        </div>
        <div id="headBtn"><p style="font:35px 微软雅黑" text-align:right;>  &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;课件设计大赛</p></div>
      </div>
    </div>
    <div class="custom-menu-wrapper" style="text-align:center";>
    <div class="pure-menu custom-menu custom-menu-top">
        <a href="#" class="pure-menu-heading custom-menu-brand">Brand</a>
        <a href="#" class="custom-menu-toggle" id="toggle"><s class="bar"></s><s class="bar"></s></a>
    </div>
    <div class="pure-menu pure-menu-horizontal pure-menu-scrollable custom-menu custom-menu-bottom custom-menu-tucked" id="tuckedMenu">
      <div class="custom-menu-screen"></div>
         <ul class="pure-menu-list">
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">首页</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">课程简介</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">教学大纲</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">课件教案</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">习题解答</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">实验指导</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">教学录像</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">教学研究</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">在线答疑</a></li>
            <li class="pure-menu-item"><a href="welcome.jsp" class="pure-menu-link">在线测试</a></li>
        </ul> 
       
    </div>
   
  </div>
  </body>
</html>
