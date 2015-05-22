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
  <div id="autotest">
  <form id="autochecksubmit" method="post">
  <%--Gson  g = new Gson();--%>
  <table width="900" border="1">
  	<tr>
  		<th width="10%">编号</th>
  		<th width="40%">试卷名称</th>
  		<th width="10%">开始时间</th>
  		<th width="10%">考试时长</th>
  		<th width="10%">试题数目</th>
  		<th width="10%">试卷状态</th>
  		<th width="10%">开始考试</th>
  	</tr>
	  <% 
  	JSONArray obj=(JSONArray)session.getAttribute("json");
  	for (int i=0;i<obj.size();i++){
  		JSONObject jo = (JSONObject) obj.get(i);%>
  		<tr>
  			<td width="10%"><%=jo.get("paperNumber") %></td>
  			<td width="40%"><%=jo.get("paperName") %></td>
  			<td width="10%"><%=jo.get("startTime") %></td>
  			<td width="10%"><%=jo.get("durationTime") %></td>
  			<td width="10%"><%=jo.get("questionCount") %></td>
  			<td width="10%"><%=jo.get("paperStatus") %></td>
  			<td width="10%"><a href="starttest?paperId=<%=jo.get("paperId") %>">开始考试</a></td>
  		</tr>
		<% }%>
		</table>

  	</form>
  	</div>
    </body>
</html>
