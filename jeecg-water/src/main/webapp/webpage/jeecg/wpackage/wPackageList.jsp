<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wPackageList" checkbox="true" pagination="true" fitColumns="false" title="套餐管理" actionUrl="wPackageController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
    <t:dgCol title="套餐名称"  field="packageMode"    queryMode="single"  width="200"></t:dgCol>
    <t:dgCol title="套餐类型"  field="packageType"   query="true" queryMode="single" dictionary="packageT" width="120"></t:dgCol>
    <t:dgCol title="优惠规则描述"  field="packageDescribe"    queryMode="single"  width="300"></t:dgCol>
    <t:dgCol title="充值金额（元）"  field="packageMax"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="赠送部分（L/个）"  field="packageValue"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="水单价（元）"  field="packageConver"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="状态"  field="packageState"   query="true" queryMode="single" dictionary="package" width="120"></t:dgCol>
    <t:dgCol title="package_father"  field="packageFather"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="充值类型"  field="packageClass"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wPackageController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wPackageController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wPackageController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wPackageController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wPackageController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
     	<t:dgToolBar title="启用" icon="icon-edit"  url="wPackageController.do?doEnable" funname="doEnable" ></t:dgToolBar>
     	<t:dgToolBar title="停用" icon="icon-edit"  url="wPackageController.do?doDisable" funname="doDisable" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wpackage/wPackageList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
     	//自定义按钮-启用
	 	function doEnable(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择启用项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
     	//自定义按钮-停用
	 	function doDisable(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择停用项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wPackageController.do?upload', "wPackageList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wPackageController.do?exportXls","wPackageList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wPackageController.do?exportXlsByT","wPackageList");
}

 </script>