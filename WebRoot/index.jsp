<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息管理系统登录</title>
<script type="text/javascript">
	function resetValue(){
		document.getElementById("stuName").value="";
		document.getElementById("password").value="";
	}
</script>
  <style type="text/css">
* {
	margin-left: auto;
	margin-right: auto;
	padding: 0;
	list-style-type: none;
}
a, img {
	border: 0;
}
body {
	text-align: center;
	font: 12px/180% Arial, Helvetica, sans-serif, "新宋体";
}
.flexslider {
	position: relative;
	width: 930px;
	height: 415px;
	overflow: hidden;
	background: url(banner/loading.gif) 50% no-repeat;
}
.slides {
	position: relative;
	z-index: 1;
}
.slides li {
	height: 400px;
}
.flex-control-nav {
	position: absolute;
	bottom: 10px;
	z-index: 2;
	width: 100%;
	text-align: center;
}
.flex-control-nav li {
	display: inline-block;
	width: 14px;
	height: 14px;
	margin: 0 5px;
 *display: inline;
	zoom: 1;
}
.flex-control-nav a {
	display: inline-block;
	width: 14px;
	height: 14px;
	line-height: 40px;
	overflow: hidden;
	background: url(banner/dot.png) right 0 no-repeat;
	cursor: pointer;
}
.flex-control-nav .flex-active {
	background-position: 0 0;
}
.flex-direction-nav {
	position: absolute;
	z-index: 3;
	width: 100%;
	top: 45%;
}
.flex-direction-nav li a {
	display: block;
	width: 50px;
	height: 50px;
	overflow: hidden;
	cursor: pointer;
	position: absolute;
}
.flex-direction-nav li a.flex-prev {
	left: 40px;
	background: url(banner/prev.png) center center no-repeat;
}
.flex-direction-nav li a.flex-next {
	right: 40px;
	background: url(banner/next.png) center center no-repeat;
}
</style>
  <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
  <script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
        $('.flexslider').flexslider({
            directionNav: true,
            pauseOnAction: false
        });
    });
  </script>
</head>
<body>
<div align="center" style="width:930px;">
    <div class="flexslider">
      <ul class="slides">
        <li style="background:url(banner/img1.jpg) 50% 0 no-repeat;"></li>
        <li style="background:url(banner/img2.jpg) 50% 0 no-repeat;"></li>
        <li style="background:url(banner/img3.jpg) 50% 0 no-repeat;"></li>
        <li style="background:url(banner/img4.jpg) 50% 0 no-repeat;"></li>
        <li style="background:url(banner/img5.jpg) 50% 0 no-repeat;"></li>
      </ul>
    </div>
    <div style="background-image:url(images/home_bg.jpg); width:930px; height:250px;"> <br/>
      <br/>
      <div><span style="font:40px 宋体; color:#FFF;line-height:60px;">2014年辽宁省教育软件大赛参赛作品</span></div>
      <div><span style="font:30px 宋体; color:#FFF;line-height:55px;">大连民族学院</span></div>
      
            <div align="right"  float="right" margin-left: 500px;>
		<form action="login" method="post">
		<table   >
			<tr>
				<td colspan="4"></td>
			</tr>
			<tr height="10">
				<td width="40%"></td>
				<td width="10%" style="color:#FFF; font:10px 微软雅黑">用户名：</td>
				<td><input type="text" value="${student.stuId }" name="student.stuId" id="stuId"/></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="40%"></td>
				<td width="10%" style="color:#FFF; font:10px 微软雅黑">密  码：</td>
				<td><input type="password" value="${student.password }" name="student.password" id="password"/></td>
				<td width="30%"></td>
			</tr>
			
			<tr height="10">
				<td width="40%"></td>
				<td width="10%"><input type="submit" value="登录"/></td>
				<td><input type="button" value="重置" onclick="resetValue()"/></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="40%"></td>
				<td colspan="3">
					<font color="red">${error }</font>
				</td>
			</tr>
			<tr >
				<td></td>
			</tr>
		</table>
		</form>
	</div>
	<div>
		<a href="teacherLogin.jsp">教师登录</a>
	</div>
      <br/>

    </div>
  </div>
	
</body>
</html>