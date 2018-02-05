<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wdeviceList" checkbox="true" pagination="true" fitColumns="false" title="净水器设备表" actionUrl="wdeviceController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="商城产品id"  field="mallIntroduceId"  hidden="true"  queryMode="single" dictionary="mall_introduce_id" width="120"></t:dgCol>
    <t:dgCol title="商城产品名称"  field="mallIntroduceName"  hidden="true"  queryMode="single" dictionary="mall_introduce_name" width="120"></t:dgCol>
    <t:dgCol title="滤芯id"  field="filterId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="设备id"  field="deviceId"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="设备型号"  field="deviceModel"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="设备名称"  field="deviceName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯数量"  field="filterNember"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="生产日期"  field="deviceTime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="防伪码"  field="deviceCode"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wdeviceController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wdeviceController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wdeviceController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wdeviceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wdeviceController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  <t:dgToolBar title="验真" icon="icon-ok"  url="wdeviceController.do?theTrue" funname="theTrue" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wdevice/wdeviceList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 //验真
 function theTrue(title,url,gridname){
 	createwindow('验真操作',url,500,100);
 }
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wdeviceController.do?upload', "wdeviceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wdeviceController.do?exportXls","wdeviceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wdeviceController.do?exportXlsByT","wdeviceList");
}

 </script>