<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.sf.json.*" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'autoTest.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	
  </head>
  
  <body>
  <div id="autotest" style="padding-top:10px; padding-left:5px;">
    <% 
  	JSONArray obj=(JSONArray)session.getAttribute("jsonErrorList");
  	%>
  <%session.getAttribute("json"); %>
 	您本次的成绩为：${json} 分.</br>
 	错误题目：</br>
  <% 
  	for (int i=0;i<obj.size();i++){
  		JSONObject jo = (JSONObject) obj.get(i);%>
   		 <%=jo.get("questionId") %>.<%=jo.get("questions") %></br>
   		A: <%=jo.get("optionA") %></br>
   		B: <%=jo.get("optionB") %></br>
   		C: <%=jo.get("optionC") %></br>
   		D: <%=jo.get("optionD") %></br>
   		正确答案：<%=jo.get("answer")%></br></br>
   		<%} %>
  	</div>
    </body>
</html>
