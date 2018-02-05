<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wErectorList" checkbox="true" pagination="true" fitColumns="false" title="安装工" actionUrl="werectorController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
    <t:dgCol title="安装公司"  field="erectorCompany"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装负责人"  field="erectorPerson"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="联系方式"  field="erectorPhone"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="固定电话"  field="erectorFixedline"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="服务区域"  field="erectorRegion"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="对应后台账号"  field="erectorAdmin"    queryMode="single" dictionary="user_msg,erector_admin,erector_admin" popup="true" width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="erectorRemarks"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="是否有效"  field="erectorState"    queryMode="single" dictionary="erectorS" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="werectorController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="werectorController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="werectorController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wErectorController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wErectorController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
     	<t:dgToolBar title="有效" icon="icon-edit"  url="werectorController.do?doEffective" funname="doEffective" ></t:dgToolBar>
     	<t:dgToolBar title="无效" icon="icon-edit"  url="werectorController.do?doInvalid" funname="doInvalid" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/werector/werectorList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
     	//自定义按钮-有效
	 	function doEffective(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择有效项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
     	//自定义按钮-无效
	 	function doInvalid(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择无效项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wErectorController.do?upload', "wErectorList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wErectorController.do?exportXls","wErectorList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wErectorController.do?exportXlsByT","wErectorList");
}

 </script>