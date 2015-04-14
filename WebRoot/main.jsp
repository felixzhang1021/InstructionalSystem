<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息管理系统主界面</title>
<%
	// 权限验证
	if(session.getAttribute("currentTea")==null){
		response.sendRedirect("index.jsp");
		return;
	}
%>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		// 数据
		var treeData=[{
			text:"菜单",
			children:[{
				text:"学生信息管理",
				attributes:{
					url:"studentInfoManage.jsp"
				}
			},{
				text:"试题信息管理",
				attributes:{
					url:"questionManage.jsp"
				}
			},{
				text:"试卷管理",
				attributes:{
					url:"testPaperManage.jsp"
				}
			},{
				text:"成绩查询",
				attributes:{
					url:"testPaperManage.jsp"
				}
			}
			]
		}];
		
		// 实例化树菜单
		$("#tree").tree({
			data:treeData,
			lines:true,
			onClick:function(node){
				if(node.attributes){
					openTab(node.text,node.attributes.url);
				}
			}
		});
		
		// 新增Tab
		function openTab(text,url){
			if($("#tabs").tabs('exists',text)){
				$("#tabs").tabs('select',text);
			}else{
				var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
				$("#tabs").tabs('add',{
					title:text,
					closable:true,
					content:content
				});
			}
		}
	});
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 80px;background-color: #E0EDFF">
		<div align="left" style="width: 80%;float: left;font:60px 微软雅黑; color:red;" ><img src="images/main.jpg">大连民族大学</div>
		
		<div style="padding-top: 50px;padding-right: 20px;">当前用户：&nbsp;<font color="red" >${currentTea.teacherName }</font></div>
		
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" >
				<div align="center" style="padding-top: 100px;"><font color="red" size="10">欢迎使用</font></div>
			</div>
		</div>
	</div>
	<div region="west" style="width: 150px;" title="导航菜单" split="true">
		<ul id="tree"></ul>
	</div>
	<div region="south" style="height: 25px;" align="center">Copyright By <a href="http://www.java1234.com">大连民族大学-民族工作专用信息网络工程工作室</a></div>
</body>
</html>