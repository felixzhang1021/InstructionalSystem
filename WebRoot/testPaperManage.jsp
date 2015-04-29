<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>试卷管理</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	function deletePaper(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].paperId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("testpaper!delete",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示',result.errorMsg);
					}
				},"json");
			}
		});
	}

	function showPaper(){
			var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#slg").dialog("open").dialog("setTitle","试卷信息");
		url="testpaper!show?paperId="+row.paperId;
		$("#fm2").form("submit",{
			url:url,
			dataType: "json",
			
			onSubmit:function(){
			},
			success:function(result){
			var dataArray = eval(result);
			var tableStr = "<table >";
  			tableStr = tableStr + "<thead><td>题号</td><td>题目</td><td>选项A</td><td>选项B</td><td>选项C</td><td>选项D</td><td>答案</td><td>分值</td></thead>";
  			var len = dataArray.length;
  			for(var i=0 ;i<len ; i++){
  				tableStr = tableStr + "<tr><td>"+ dataArray[i].numberId +"</td>"+"<td>"+dataArray[i].questions + "</td>"+"<td>"+dataArray[i].optionA +"</td>"+"<td>"+dataArray[i].optionB +"</td>"+"<td>"+dataArray[i].optionC +"</td>"+"<td>"+dataArray[i].optionD +"</td>"+"<td>"+dataArray[i].answer+"</td>"+"<td>"+dataArray[i].score +"</td></tr>";
  			}
  			tableStr = tableStr + "</table>";
  			//将动态生成的table添加的事先隐藏的div中.
  			$("#slg").html(tableStr);  
			 
			}
		});
	}
	function searchPaper(){
		$('#dg').datagrid('load',{
			paperName:$('#paperName').val(),
			startTime:$('#startTime').val(),
			durationTime:$('#durationTime').val(),
			questionCount:$('#questionCount').val(),
			paperStatus:$('#paperStatus').val(),
		});
	}
	
	
	function openPaperAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加试卷");
		url="testpaper!save";
	}
	
	function savePaper(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
			},
			success:function(result){
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function resetValue(){
		$("#paperName").val("");
		$("#startTime").val("");
		$("#durationTime").val("");
		$("#questionCount").val("");
		$("#paperStatus").val("");
	}
	
	function closePaperDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openPaperModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑试卷信息");
		$("#paperName").val(row.paperName);
		$("#startTime").val(row.startTime);
		$("#durationTime").val(row.durationTime);
		$("#questionCount").val(row.questionCount);
		$("#paperStatus").val(row.paperStatus);
		url="testpaper!save?paperId="+row.paperId;
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="试卷信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="testpaper" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="paperId" width="50" align="center">编号</th>
				<th field="paperName" width="100" align="center">试卷名称</th>
				<th field="startTime" width="70" align="center">考试时间</th>
				<th field="durationTime" width="70" align="center">考试时长</th>
				<th field="questionCount" width="70" align="center">试题数目</th>
				<th field="paperStatus" width="70" align="center">试卷状态</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
		<a href="javascript:showPaper()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查看</a>
			<a href="javascript:openPaperAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openPaperModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deletePaper()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<!-- <div>&nbsp;试题题目：&nbsp;<input type="text" name="questions" id="question" size="10"/>
			&nbsp;姓名：&nbsp;<input type="text" name="stuName" id="stuName" size="10"/>
			&nbsp;性别：&nbsp;<select class="easyui-combobox" id="s_sex" name="s_sex" editable="false" panelHeight="auto">
		    <option value="">请选择...</option>
			<option value="男">男</option>
			<option value="女">女</option>
		</select>
		&nbsp;出生日期：&nbsp;<input class="easyui-datebox" name="bStuBirthday" id="bStuBirthday" editable="false" size="10"/>-><input class="easyui-datebox" name="eStuBirthday" id="eStuBirthday" editable="false" size="10"/>
		    
		<a href="javascript:searchStudent()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>-->
	</div> 
	
	<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
			
				<tr>
					<td>试卷名称：</td>
					<td><input type="text" name="paper.paperName" id="paperName" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr >
					<td>考试时间：</td>
					<td><input type="text" name="paper.startTime" id="startTime" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>考试时长：</td>
					<td><input type="text" name="paper.durationTime" id="durationTime" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>	
					<td>试题数目：</td>
					<td><input type="text" name="paper.questionCount" id="questionCount" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>试卷状态：</td>
					<td><input type="text" name="paper.paperStatus" id="paperStatus" class="easyui-validatebox" required="true"/></td>
				</tr>
				
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:savePaper()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closePaperDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	<div id="slg" class="easyui-dialog" style="width: 1000px;height: 650px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm2" method="post">
			
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:savePaper()" class="easyui-linkbutton" iconCls="icon-ok">发布试卷</a>
		<a href="javascript:closePaperDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>