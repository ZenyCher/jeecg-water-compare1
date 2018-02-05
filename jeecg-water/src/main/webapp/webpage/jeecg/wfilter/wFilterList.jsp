<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wFilterList" checkbox="true" pagination="true" fitColumns="false" title="滤芯设备" actionUrl="wFilterController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
    <t:dgCol title="滤芯状态"  field="filterState"  replace="未使用_0,已使用_1"  queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="滤芯id"  field="filterId"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯名称"  field="filterName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯型号"  field="filterModel"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="生产日期"  field="filterTime" formatter="yyyy-MM-dd"  query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="导入时间"  field="filterImporttime" formatter="yyyy-MM-dd"  query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="防伪码"  field="filterCode"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装时水量"  field="filterInstalledwater" hidden="true"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯总水量"  field="filterTotalwater" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wFilterController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wFilterController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wFilterController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wFilterController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wFilterController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  <t:dgToolBar title="验真" icon="icon-ok"  url="wFilterController.do?theTrue" funname="theTrue" ></t:dgToolBar> 
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wfilter/wFilterList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 

 //验真
 function theTrue(title,url,gridname){
 	createwindow('验真操作',url,500,100);
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wFilterController.do?upload', "wFilterList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wFilterController.do?exportXls","wFilterList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wFilterController.do?exportXlsByT","wFilterList");
}

 </script>