<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>套餐</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid  pagination="false"  name="packageList" title="套餐"  actionUrl="wuserMemberController.do?datagridPackage" idField="packageId" checkbox="true" showRefresh="false"  fit="true"  queryMode="group" onLoadSuccess="initCheck">
	<t:dgCol title="Id" field="id" hidden="true"></t:dgCol>
<%-- 	<t:dgCol title="套餐名称" field="packageMode" width="50" query="true" ></t:dgCol> --%>
	<t:dgCol title="套餐名称" field="pakcageName" width="50" query="true" ></t:dgCol>
	<t:dgCol title="规则描述" field="packageDescribe" width="50" query="true" ></t:dgCol>
	<t:dgCol title="套餐类型" field="packageType" replace="充钱送水_0,首冲优惠_1,充钱送积分_2" width="50" query="true" ></t:dgCol>
</t:datagrid>
</body>
</html>
<script type="text/javascript">
function initCheck(data){
	var ids = "${ids}";
	var idArr = ids.split(",");
	for(var i=0;i<idArr.length;i++){
		if(idArr[i]!=""){
			$("#packageList").datagrid("selectRecord",idArr[i]);
		}
	}
}
</script>