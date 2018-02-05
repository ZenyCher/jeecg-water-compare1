<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>会员</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid  pagination="false"  name="memberList" title="会员"  actionUrl="wmaintainController.do?member" idField="id" checkbox="true" showRefresh="false"  fit="true"  queryMode="group" onLoadSuccess="initCheck">
	<t:dgCol title="id" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="会员姓名" field="memberName" width="50" query="true" ></t:dgCol>
</t:datagrid>
</body>
</html>
<script type="text/javascript">
function initCheck(data){
	var ids = "${ids}";
	var idArr = ids.split(",");
	for(var i=0;i<idArr.length;i++){
		if(idArr[i]!=""){
			$("#memberList").datagrid("selectRecord",idArr[i]);
		}
	}
}
</script>