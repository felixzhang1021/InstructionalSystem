<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <div id="slider" style="text-align:center;">
      <img height=276 name=katochan src="./images/0banner.jpg" width=984>
      <script language=JavaScript> 
      <!-- 
      function fuyase(n){document.katochan.src = ("./images/"+n+"banner.jpg")} 
      //--> 
      </script>
     <form name=honsuu>
      <input check name=kami onclick=fuyase(0) type=radio>
      <input name=kami onclick=fuyase(1) type=radio>
      </form>
    </div>
    <img id="containerBg" src="./images/container1.gif" >
    <div id="container">
      <div id="firstcolumn">
        <div id="c11">
          <div class="newsBlockNav"> <a class="moreaa" href="/aierdongtai">更多</a>
            <ul style="padding-left:0px; list-style-type:none;">
              <li><a href="/aierdongtai"style="padding-top: 4px;">课程建设</a></li>
            </ul>
            <div class="clear"></div>
          </div>
          <div id="c11content">
            <ul>
              <li>省级精品课程</li>
              <li>省级精品课程</li>
              <li>省级精品课程</li>
            </ul>
          </div>
        </div>
        <div id="c12">
          <div class="newsBlockNav"> <a class="moreaa" href="/aierdongtai">更多</a>
            <ul style="padding-left:0px; list-style-type:none;">
              <li><a href="/aierdongtai"style="padding-top: 4px;">教学课件</a></li>
            </ul>
            <div class="clear"></div>
          </div>
                    <div id="c11content">
            <ul>
              <li>防火墙部分课件</li>
              <li>防火墙部分课件</li>
              <li>防火墙部分课件</li>
            </ul>
          </div>
        </div>
                <div id="c13">
          <div class="newsBlockNav"> <a class="moreaa" href="/aierdongtai">更多</a>
            <ul style="padding-left:0px; list-style-type:none;">
              <li><a href="/aierdongtai"style="padding-top: 4px;">教学研究</a></li>
            </ul>
            <div class="clear"></div>
          </div>
                    <div id="c11content">
            <ul>
              <li>教学奖励</li>
              <li>教改立项</li>
              <li>教学论文</li>
            </ul>
          </div>
        </div>
      </div>
      <div id="secondcolumn">
        <div id="c21">
          <div class="newsBlockNav"> <a class="moreaa" href="/aierdongtai">更多</a>
            <ul style="padding-left:0px; list-style-type:none;">
              <li><a href="/aierdongtai"style="padding-top: 4px;">课程建设</a></li>
            </ul>
            <div class="clear"></div>
          </div>
          <div id="c11content">
            <ul>
              <li>省级精品课程</li>
              <li>省级精品课程</li>
              <li>省级精品课程</li>
            </ul>
          </div>
        </div>
        <div id="c22">
          <div class="newsBlockNav"> <a class="moreaa" href="/aierdongtai">更多</a>
            <ul style="padding-left:0px; list-style-type:none;">
              <li><a href="/aierdongtai"style="padding-top: 4px;">教学课件</a></li>
            </ul>
            <div class="clear"></div>
          </div>
                    <div id="c11content">
            <ul>
              <li>防火墙部分课件</li>
              <li>防火墙部分课件</li>
              <li>防火墙部分课件</li>
            </ul>
          </div>
        </div>
                <div id="c23">
          <div class="newsBlockNav"> <a class="moreaa" href="/aierdongtai">更多</a>
            <ul style="padding-left:0px; list-style-type:none;">
              <li><a href="/aierdongtai"style="padding-top: 4px;">教学研究</a></li>
            </ul>
            <div class="clear"></div>
          </div>
                    <div id="c11content">
            <ul>
              <li>教学奖励</li>
              <li>教改立项</li>
              <li>教学论文</li>
            </ul>
          </div>
        </div>
      </div>
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