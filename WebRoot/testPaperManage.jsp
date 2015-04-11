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
	
	function deleteQuestion(){
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
				$.post("question!delete",{delIds:ids},function(result){
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

	function searchQuestion(){
		$('#dg').datagrid('load',{
			questions:$('#questions').val(),
			optionA:$('#optionA').val(),
			optionB:$('#optionB').val(),
			optionC:$('#optionC').val(),
			optionD:$('#optionD').val(),
			answer:$('#answer').val(),
			score:$('#score').val(),
		});
	}
	
	
	function openQuestionAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加试题");
		url="question!save";
	}
	
	function saveQuestion(){
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
		$("#questions").val("");
		$("#optionA").val("");
		$("#optionB").val("");
		$("#optionC").val("");
		$("#optionD").val("");
		$("#answer").val("");
		$("#score").val("");
	}
	
	function closeQuestionDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openQuestionModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑学生信息");
		//$("#fm").form("load",row);
		$("#question").val(row.question);
		$("#optionA").val(row.optionA);
		$("#optionB").val(row.optionB);
		$("#optionC").val(row.optionC);
		$("#optionD").val(row.optionD);
		$("#answer").val(row.answer);
		$("#score").val(row.score);
		url="question!save?questionId="+row.questionId;
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="试题信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="question" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="questionId" width="50" align="center">编号</th>
				<th field="questions" width="100" align="center">题目</th>
				<th field="optionA" width="70" align="center">选项A</th>
				<th field="optionB" width="70" align="center">选项B</th>
				<th field="optionC" width="70" align="center">选项C</th>
				<th field="optionD" width="70" align="center">选项D</th>
				<th field="answer" width="50" align="center">正确答案</th>
				<th field="score" width="50" align="center">分值</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openQuestionAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openQuestionModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteQuestion()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<!-- <div>&nbsp;试题题目：&nbsp;<input type="text" name="questions" id="question" size="10"/>
			&nbsp;姓名：&nbsp;<input type="text" name="stuName" id="stuName" size="10"/>
			&nbsp;性别：&nbsp;<select class="easyui-combobox" id="s_sex" name="s_sex" editable="false" panelHeight="auto">
		    <option value="">请选择...</option>
			<option value="男">男</option>
			<option value="女">女</option>
		</select>
		&nbsp;出生日期：&nbsp;<input class="easyui-datebox" name="bStuBirthday" id="bStuBirthday" editable="false" size="10"/>-><input class="easyui-datebox" name="eStuBirthday" id="eStuBirthday" editable="false" size="10"/>
		    
		<a href="javascript:searchStudent()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
	</div> -->
	
	<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>试题题目：</td>
					<td><input type="text" name="question.questions" id="questions" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr >
					<td>选项A：</td>
					<td><input type="text" name="question.optionA" id="optionA" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>选项B：</td>
					<td><input type="text" name="question.optionB" id="optionB" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>	
					<td>选项C：</td>
					<td><input type="text" name="question.optionC" id="optionC" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>选项D：</td>
					<td><input type="text" name="question.optionD" id="optionD" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>		
					<td>正确答案：</td>
					<td><input type="text" name="question.answer" id="answer" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>分值：</td>
					<td><input type="text" name="question.score" id="score" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveQuestion()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeQuestionDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>