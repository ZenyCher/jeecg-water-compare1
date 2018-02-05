<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wViewInstallCompanyList" checkbox="false" pagination="true" fitColumns="false" title="安装公司结算" actionUrl="wViewInstallCompanyController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="安装公司"  field="installWorker"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="会员姓名"  field="memberName"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="会员联系方式"  field="memberPhone"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="会员联系地址"  field="memberAddress"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="下单时间"  field="orderDate" formatter="yyyy-MM-dd hh:mm:ss"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="水表di"  field="deviceId"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="型号"  field="memberDeviceType"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装状态"  field="installProgress"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装完成时间"  field="installEndtime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="wViewInstallCompanyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="wViewInstallCompanyController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="wViewInstallCompanyController.do?goUpdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wViewInstallCompanyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wViewInstallCompanyController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wviewinstallcompany/wViewInstallCompanyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wViewInstallCompanyController.do?upload', "wViewInstallCompanyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wViewInstallCompanyController.do?exportXls","wViewInstallCompanyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wViewInstallCompanyController.do?exportXlsByT","wViewInstallCompanyList");
}

 </script>