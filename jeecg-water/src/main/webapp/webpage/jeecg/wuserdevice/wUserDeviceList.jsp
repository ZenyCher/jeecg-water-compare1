<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wUserDeviceList" checkbox="true" pagination="true" fitColumns="false" title="用户关联设备表" actionUrl="wUserDeviceController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    
    
    <t:dgCol title="会员联系方式"  field="memberPhone"   query="true" queryMode="single"  width="150"></t:dgCol>
    <t:dgCol title="会员姓名"  field="memberName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="设备id"  field="deviceId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="设备名称"  field="deviceName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="水表id"  field="watermeterId"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="净水器类型"  field="deviceTypeId" hidden="true"  query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="净水器类型名称"  field="deviceTypeName"    queryMode="single"  width="120"></t:dgCol>
    
    
    <t:dgCol title="滤芯id_1"  field="oneFilterId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯更换读数_1"  field="oneFilterName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯id_2"  field="twoFilterId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯更换读数_2"  field="twoFilterName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯id_3"  field="threeFilterId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯更换读数_3"  field="threeFilterName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯id_4"  field="fourFilterId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯更换读数_4"  field="fourFilterName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯id_5"  field="fiveFilterId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯更换读数_5"  field="fiveFilterName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯id_6"  field="sixFilterId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯更换读数_6"  field="sixFilterName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装公司id"  field="installErectorId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装公司名称"  field="installErectorName"    queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="wUserDeviceController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="wUserDeviceController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="wUserDeviceController.do?goUpdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wUserDeviceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wUserDeviceController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wuserdevice/wUserDeviceList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wUserDeviceController.do?upload', "wUserDeviceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wUserDeviceController.do?exportXls","wUserDeviceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wUserDeviceController.do?exportXlsByT","wUserDeviceList");
}

 </script>