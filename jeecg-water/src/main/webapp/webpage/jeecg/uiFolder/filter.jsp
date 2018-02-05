<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>滤芯</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid  pagination="false"  name="filterList" title="滤芯"  actionUrl="wdeviceController.do?datagridFilter" idField="filterId" checkbox="true" showRefresh="false"  fit="true"  queryMode="group" onLoadSuccess="initCheck">
	<t:dgCol title="Id" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="滤芯名称" field="filterName" width="50" query="true" ></t:dgCol>
	<t:dgCol title="滤芯Id" field="filterId" width="50" query="true" ></t:dgCol>
</t:datagrid>
</body>
</html>
<script type="text/javascript">
function initCheck(data){
	var ids = "${ids}";
	var idArr = ids.split(",");
	for(var i=0;i<idArr.length;i++){
		if(idArr[i]!=""){
			$("#filterList").datagrid("selectRecord",idArr[i]);
		}
	}
}
</script>