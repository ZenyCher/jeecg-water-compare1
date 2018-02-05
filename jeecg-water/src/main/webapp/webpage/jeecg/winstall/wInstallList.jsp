<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wInstallList" checkbox="true" pagination="true" fitColumns="false" title="安装管理表" actionUrl="wInstallController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="设备id"  field="deviceId"   queryMode="single" dictionary="usm_device,device_id,device_id" popup="true" width="120"></t:dgCol>
    <t:dgCol title="安装进度"  field="installProgress" replace="待安装_0,已安装_1"  query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="会员姓名"  field="installMembername"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="会员联系方式"  field="instalPhont"  query="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装地址"  field="installAddress"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="水表id"  field="installNumber"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="当前水量"  field="installWater"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="滤芯"  field="installFilterId" hidden="true"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯前水量"  field="installFilterWater"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--  <t:dgCol title="会员类型"  field="installSource" replace="线下签约_0,商城下单_1"   queryMode="single"  width="120"></t:dgCol> --%>
    <t:dgCol title="安装公司"  field="installWorker"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="计划安装时间"  field="installTime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装完成时间"  field="installEndtime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装等级信息"  field="installMessage"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="证件"  field="installCertificates"  formatterjs="selectFile"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="合同"  field="installContract" formatterjs="selectFile"   queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="wInstallController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
<%--    <t:dgToolBar title="新增" icon="icon-add" url="wInstallController.do?goAdd" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar title="安装登记" icon="icon-edit" url="wInstallController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wInstallController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wInstallController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/winstall/wInstallList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
function selectFile(value,row,index){
	return '<a style="color:red" href="systemController/showOrDownByurl.do?down=1&dbPath='+value+'">'+value+'</a>';
}   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wInstallController.do?upload', "wInstallList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wInstallController.do?exportXls","wInstallList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wInstallController.do?exportXlsByT","wInstallList");
}

 </script>