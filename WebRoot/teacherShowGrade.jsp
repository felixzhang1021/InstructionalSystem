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
  <% 
  	JSONArray obj=(JSONArray)session.getAttribute("json");
  	%>
  	<h3> 
  	<% 
  	
  		if(obj.size()>0) {
  		JSONObject j = (JSONObject) obj.get(0);
  		out.println(j.get("paperName"));
  		}%>
  	</h3>
  <table width="900" border="1">
  	<tr>
  		<th width="10%">编号</th>
  		<th width="50%">学号</th>
  		<th width="20%">姓名</th>
  		<th width="20%">成绩</th>
  	</tr>

  	<%
  	for (int i=0;i<obj.size();i++){
  		JSONObject jo = (JSONObject) obj.get(i);%>
  		<tr>
  			<td width="10%"><%=jo.get("gradeNumber") %></td>
  			<td width="50%"><%=jo.get("stuId") %></td>
  			<td width="20%"><%=jo.get("stuName") %></td>
  			<td width="20%"><%=jo.get("stuScore") %></td>
  		</tr>
		<% }%>
		</table>

  	</form>
  	</div>
    </body>
</html>
