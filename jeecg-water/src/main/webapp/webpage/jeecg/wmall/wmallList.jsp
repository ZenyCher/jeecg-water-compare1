<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wmallList" checkbox="true" pagination="true" fitColumns="false" title="净水器商城" actionUrl="wmallController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="净水器类型id"  field="mallDeviceTypeId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="产品标题"  field="mallName" funname="seeTable" query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="净水器类型"  field="mallDeviceType"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="净水器名称"  field="mallDeviceName"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="滤芯数量"  field="mallFilterNum"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所需押金元"  field="mallDeposit"   query="true" queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="产品图片"  field="mallImage" formatterjs="selectFile" style="text-decoration:underline;color:#0000FF;"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="产品说明"  field="mallExplain"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="操作手册"  field="mallOperation" formatterjs="selectFile" style="text-decoration:underline;color:#0000FF;"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="200"></t:dgCol>
   <t:dgDelOpt title="删除" url="wmallController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wmallController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wmallController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wmallController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wmallController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
<%--    <t:dgOpenOpt url="wmallController.do?test&id={id}" title="详情查看" openModel="OpenWin" urlclass="ace_button" urlfont="icon-search"></t:dgOpenOpt>  --%>
	<t:dgFunOpt title="详情查看" urlclass="ace_button" urlfont="fa-trash-o" funname="seeTable(id)"></t:dgFunOpt >
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wmall/wmallList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 function selectFile(value,row,index){
	return '<a style="color:red" href="systemController/showOrDownByurl.do?down=1&dbPath='+value+'">'+value+'</a>';
}
 
 function seeTable(id){
	 var path =   '<%=basePath %>/wmallController.do?saveMallIntroduce&id=' + id;
	 createwindow('净水器商城详情查看', path, 700,600);
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wmallController.do?upload', "wmallList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wmallController.do?exportXls","wmallList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wmallController.do?exportXlsByT","wmallList");
}

 </script>