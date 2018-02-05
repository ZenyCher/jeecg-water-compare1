<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>设备id</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid  pagination="false"  name="deviceList" title="设备"  actionUrl="wInstallController.do?datagridDevice" idField="deviceId" checkbox="true" showRefresh="false"  fit="true"  queryMode="group" onLoadSuccess="initCheck">
	<t:dgCol title="设备Id" field="deviceId" width="50" query="true" ></t:dgCol>
	<t:dgCol title="设备名称" field="deviceName" width="50" query="true" ></t:dgCol>
</t:datagrid>
</body>
</html>
<script type="text/javascript">
function initCheck(data){
	var str = "${str}";
	$.messager.alert('提示', str);
	var ids = "${ids}";
	var idArr = ids.split(",");
	for(var i=0;i<idArr.length;i++){
		if(idArr[i]!=""){
			$("#deviceList").datagrid("memberPhone",idArr[i]);
		}
	}
}
</script>