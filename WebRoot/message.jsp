<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.sf.json.*" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0023)http://www.eye0311.com/ -->
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">

<script>
(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

ga('create', 'UA-41480445-1', 'purecss.io');
ga('send', 'pageview');
</script>

    <title>主页</title>
            <%
	// 权限验证
	if(session.getAttribute("currentStu")==null){
		response.sendRedirect("index.jsp");
		return;
	}
%>
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
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">在线测试</a></li>
        </ul>
    </div>
  </div>
    <img id="containerBg" src="./images/container1.gif" >

    <div id="block1Lb">


  </div>
    <div id="containerTest">
  <%--Gson  g = new Gson();--%>
  <% 
  	JSONArray obj=(JSONArray)session.getAttribute("json");
  	%>
	<form action="messageshow!save" method="post">
  	<div style="width:960px;margin:10px">
  		<div style="background:#87CEFA; height:30px;padding-top: 5px;padding-left: 5px;">发表留言</div>
  		<div><textarea style="width:955px;height:150px" type="text" name="content"></textarea></div>
		<div style="text-align:right; height:30px">
			<input type="text" value="${currentStu.stuName }" name="stuName" id="stuName"style="display:none;"/>
			<input type="reset" value="重置"/>
			<input type="submit" value="留言"/>
		</div>
  	</div>
  	</form>
  	<%
  		if(obj.size()>=1){
  			for (int i=0;i<obj.size();i++){
  				JSONObject jo = (JSONObject) obj.get(i);%>
  				  	<div style="border:1px dashed #000;width:960px;margin:10px">
  						<div style="background:#B0E0E6; height:30px">
  							<div style="float:left; width:300px;background:#B0E0E6;padding-top: 5px;padding-left: 5px;">留言人：<%=jo.get("stuName") %></div> 
  							<div style="float:left; width:300px;background:#B0E0E6;padding-top: 5px;padding-left: 5px;">留言时间：<%=jo.get("messageDate") %></div>
  							<div style="float:left; width:300px;background:#B0E0E6;padding-top: 5px;padding-left: 5px;"><a href="showcomment?messageId=<%=jo.get("messageId")%>">评论</a></div>
  						</div>
  						<div style="height:auto !important; padding:5px"><%=jo.get("content") %></div>
  					</div>
  					<%
  				}
  		}else{%>
  			<div style="border:1px dashed #000;width:960px;margin:10px">
  					<%out.print("暂时没有评论！！！"); %>	
  			</div>
  			<%
  		}
  		 %>

	<br>
  
		
    </div>
    <img id="containerBt" src="./images/bt.gif">
    <div id="bottom">
     <p style="text-align:center;color:#FFFFFF;">CopyRight By 大连民族大学-民族工作专用信息网络工程工作室</p> 
    </div>
  </body>
</html>
<script>
(function (window, document) {
document.getElementById('toggle').addEventListener('click', function (e) {
    document.getElementById('tuckedMenu').classList.toggle('custom-menu-tucked');
    document.getElementById('toggle').classList.toggle('x');
});
})(this, this.document);
</script>