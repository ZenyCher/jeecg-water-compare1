<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wDeviceTypeList" checkbox="true" pagination="true" fitColumns="false" title="净水器类型" actionUrl="wDeviceTypeController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="型号"  field="deviceType"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="名称"  field="deviceName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯数量"  field="deviceFilterNum"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯1更换水量"  field="filterNumOne"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯2更换水量"  field="filterNumTwo"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯3更换水量"  field="filterNumThree"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯4更换水量"  field="filterNumFour"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯5更换水量"  field="filterNumFive"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯6更换水量"  field="filterNumSix"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="remarks"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wDeviceTypeController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wDeviceTypeController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wDeviceTypeController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wDeviceTypeController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wDeviceTypeController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wdevicetype/wDeviceTypeList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wDeviceTypeController.do?upload', "wDeviceTypeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wDeviceTypeController.do?exportXls","wDeviceTypeList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wDeviceTypeController.do?exportXlsByT","wDeviceTypeList");
}

 </script>