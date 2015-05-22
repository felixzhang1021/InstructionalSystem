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
	<br>
	<br>
	<input type="text" name="questionIdList" id="questionIdList" style="display:none"/>
	<input type="text" name="questionAnswerList" id="questionAnswerList" style="display:none"/>
  	<input type="submit" id="sub" style="display:none"/></br>
  	</form>
  	</div>
    </body>
</html>
