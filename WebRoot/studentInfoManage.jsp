<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息管理</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	function deleteStudent(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].stuId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("student!delete",{delIds:ids},function(result){
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

	function searchStudent(){
		$('#dg').datagrid('load',{
			stuNo:$('#stuNo').val(),
			stuName:$('#stuName').val(),
			s_sex:$('#s_sex').combobox("getValue"),
			bStuBirthday:$('#bStuBirthday').datebox("getValue"),
			eStuBirthday:$('#eStuBirthday').datebox("getValue"),
		});
	}
	
	
	function openStudentAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加学生信息");
		url="student!save";
	}
	
	function saveStudent(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				if($('#stuSex').combobox("getValue")==""){
					$.messager.alert("系统提示","请选择性别");
					return false;
				}
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
		$("#stuNo").val("");
		$("#stuName").val("");
		$("#stuSex").combobox("setValue","");
		$("#stuBirthday").datebox("setValue","");
		$("#stuEmail").val("");
	}
	
	function closeStudentDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openStudentModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑学生信息");
		//$("#fm").form("load",row);
		$("#stuNo").val(row.stuNo);
		$("#stuName").val(row.stuName);
		$("#stuSex").combobox("setValue",row.stuSex);
		$("#stuBirthday").datebox("setValue",row.stuBirthday);
		$("#stuEmail").val(row.stuEmail);
		url="student!save?stuId="+row.stuId;
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="学生信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="student" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="stuId" width="50" align="center">编号</th>
				<th field="stuNo" width="100" align="center">学号</th>
				<th field="stuName" width="100" align="center">姓名</th>
				<th field="stuSex" width="100" align="center">性别</th>
				<th field="birthday" width="100" align="center">出生日期</th>
				<th field="email" width="150" align="center">Email</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openStudentAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openStudentModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteStudent()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>&nbsp;学号：&nbsp;<input type="text" name="stuNo" id="stuNo" size="10"/>
		&nbsp;姓名：&nbsp;<input type="text" name="stuName" id="stuName" size="10"/>
		&nbsp;性别：&nbsp;<select class="easyui-combobox" id="s_sex" name="s_sex" editable="false" panelHeight="auto">
		    <option value="">请选择...</option>
			<option value="男">男</option>
			<option value="女">女</option>
		</select>
		&nbsp;出生日期：&nbsp;<input class="easyui-datebox" name="bStuBirthday" id="bStuBirthday" editable="false" size="10"/>-><input class="easyui-datebox" name="eStuBirthday" id="eStuBirthday" editable="false" size="10"/>
		    
		<a href="javascript:searchStudent()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>学号：</td>
					<td><input type="text" name="student.stuNo" id="stuNo" class="easyui-validatebox" required="true"/></td>
					<td></td>
					<td>姓名：</td>
					<td><input type="text" name="student.stuName" id="stuName" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><select class="easyui-combobox" id="stuSex" name="student.stuSex" editable="false" panelHeight="auto" style="width: 155px">
					    <option value="">请选择...</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select></td>
					<td></td>
					<td>出生日期：</td>
					<td><input class="easyui-datebox" name="student.stuBirthday" id="stuBirthday" required="true" editable="false" /></td>
				</tr>
				<tr>
					
					<td>Email：</td>
					<td><input type="text" name="student.stuEmail" id="stuEmail" class="easyui-validatebox" required="true" validType="email"/></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>

			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveStudent()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeStudentDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>