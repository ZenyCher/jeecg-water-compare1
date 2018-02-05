<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wWaterStatisticsList" checkbox="true" pagination="true" fitColumns="false" title="会员用水量统计" actionUrl="wWaterStatisticsController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="会员姓名"  field="memberName"   query="true" queryMode="single" dictionary="user_register,member_name,register_name" popup="true" width="120"></t:dgCol>
    <t:dgCol title="用水统计(升)"  field="waterStatistics"    queryMode="single"  width="300"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="wWaterStatisticsController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="wWaterStatisticsController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="wWaterStatisticsController.do?goUpdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wWaterStatisticsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wWaterStatisticsController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  <t:dgToolBar title="刷新" icon="icon-edit_add"  url="" funname="refresh" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wWaterStatistics/wWaterStatisticsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
	//自定义按钮-刷新本页面
	function refresh(title,url,gridname){
		history.go(0);
	}  
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wWaterStatisticsController.do?upload', "wWaterStatisticsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wWaterStatisticsController.do?exportXls","wWaterStatisticsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wWaterStatisticsController.do?exportXlsByT","wWaterStatisticsList");
}

 </script>