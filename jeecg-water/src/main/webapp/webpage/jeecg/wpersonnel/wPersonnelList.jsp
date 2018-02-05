<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wUserRegisterList" checkbox="true" pagination="true" fitColumns="false" title="安装工人管理" actionUrl="wPersonnel.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="会员联系方式"  field="memberPhone"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="用户名"  field="registerName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="手机号码"  field="registerPhone"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="关联会员"  field="registerRelation"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="密码"  field="passWord"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="用户类型"  field="registerType"  replace="会员用户_0,亲属用户_1,安装工人_2"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="账号状态"  field="registerState" replace="待激活_0,激活_1,禁用_2"  query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="头像"  field="registerHead"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wPersonnel.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wPersonnel.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wPersonnel.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wPersonnel.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wPersonnel.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
     	<t:dgToolBar title="激活" icon="icon-edit"  url="wPersonnel.do?doActivation" funname="doActivation" ></t:dgToolBar>
     	<t:dgToolBar title="禁用" icon="icon-edit"  url="wPersonnel.do?doDisable" funname="doDisable" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wpersonnel/wPersonnelList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
     	//自定义按钮-激活
	 	function doActivation(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择激活项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
     	//自定义按钮-禁用
	 	function doDisable(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择禁用项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wPersonnel.do?upload', "wUserRegisterList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wPersonnel.do?exportXls","wUserRegisterList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wPersonnel.do?exportXlsByT","wUserRegisterList");
}

 </script>