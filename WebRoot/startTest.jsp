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
	
	<script type="text/javascript">
			function check(frm){
       			var allInput = document.getElementsByTagName("input"); //获得所有的input
       			var loopTime = allInput.length; //获得数量
       			var tempQuestionId ="";
       			var tempAnswer="";
    			var countOfChecked=0;
      			for(var i=0;i < loopTime;i++){
       				if(allInput[i].type == "radio")//只对radio进行检查
      	 			if(allInput[i].checked==true){ //如果被选择
                          tempQuestionId += allInput[i].name+",";//记录所选的值
                          tempAnswer += allInput[i].value+",";
                          
                          data = {'questionId':tempQuestionId,'answer':tempAnswer};
                          countOfChecked++;
                    	}
       				}
       				alert(tempQuestionId);
       				alert(tempAnswer);
       			if(countOfChecked==0){//都没选择
       			
       				alert("您还没有选择执行结果");
       			}else{
     				document.getElementById('questionIdList').value=tempQuestionId;  
     				document.getElementById('questionAnswerList').value=tempAnswer;
        			frm.action="testcheck";
        			document.getElementById('sub').click();  
        		}
    		}


	</script>
	<script type="text/javascript">
 	//错误提示信息
 		var count=""+'${request.tipCount}'; 
 		if(count!=""){ 
    	alert(count); 
 	} 
    //-->
</script>
  </head>
  
  <body>
  <div id="autotest">
  <form id="autochecksubmit" method="post">
  <%--Gson  g = new Gson();--%>
  <% 
  	JSONArray obj=(JSONArray)session.getAttribute("json");
  	%>
  	<h3> <%JSONObject j = (JSONObject) obj.get(0); %>
  		<%=j.get("paperName") %>
  	</h3>
  	<%
  	for (int i=0;i<obj.size();i++){
  		JSONObject jo = (JSONObject) obj.get(i);%>
   		<%=jo.get("questionNumber") %>.<%=jo.get("questions") %></br>
    	<input type="radio" value="A" name="<%=jo.get("questionId")%>">A.&nbsp<%=jo.get("optionA")%> <br>
    	<input type="radio" value="B" name="<%=jo.get("questionId")%>">B.&nbsp<%=jo.get("optionB")%> <br>
    	<input type="radio" value="C" name="<%=jo.get("questionId")%>">C.&nbsp<%=jo.get("optionC")%> <br>
    	<input type="radio" value="D" name="<%=jo.get("questionId")%>">D.&nbsp<%=jo.get("optionD")%></br>
			<br>
	<br>
		<% }%>
	<br>
	<br>
	<input type="text" name="questionIdList" id="questionIdList" style="display:none"/>
	<input type="text" name="questionAnswerList" id="questionAnswerList" style="display:none"/>
  	<input type="text" value="${currentStu.stuId }" name="stuId" id="stuId" style="display:none;"/>
  	<input type="text" value="${currentStu.stuName }" name="stuName" id="stuName"style="display:none;"/>
  	<input type="text" value="<%=j.get("paperId") %>" name="paperId" id="paperId"style="display:none;"/>
  	<input type="text" value="<%=j.get("paperName") %>" name="paperName" id="paperName"style="display:none;"/>
  	<input type="submit" name="submit" value="交卷" onclick="check(autochecksubmit)">
  	<input type="submit" id="sub" style="display:none"/></br>
  	</form>
  	</div>
    </body>
</html>
