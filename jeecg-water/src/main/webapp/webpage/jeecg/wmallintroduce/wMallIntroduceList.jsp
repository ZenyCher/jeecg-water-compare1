<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wMallIntroduceList" checkbox="true" pagination="true" fitColumns="false" title="商城产品介绍" actionUrl="wMallIntroduceController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="商城产品id"  field="mallId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="产品标题"  field="title"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="产品介绍"  field="introduce"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="押金"  field="deposit"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="颜色"  field="colour"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="品牌"  field="brand"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="型号"  field="model"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装方式"  field="mode"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="过滤原理"  field="principle"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="额定净水量"  field="netWater"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="产品尺寸"  field="size"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="产品净重"  field="netWeight"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="净流水量"  field="water"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="商品描述"  field="commodityDescribe"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="详情图片"  field="detailsPicture"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wMallIntroduceController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wMallIntroduceController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wMallIntroduceController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wMallIntroduceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wMallIntroduceController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wmallIntroduce/wMallIntroduceList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wMallIntroduceController.do?upload', "wMallIntroduceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wMallIntroduceController.do?exportXls","wMallIntroduceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wMallIntroduceController.do?exportXlsByT","wMallIntroduceList");
}

 </script>