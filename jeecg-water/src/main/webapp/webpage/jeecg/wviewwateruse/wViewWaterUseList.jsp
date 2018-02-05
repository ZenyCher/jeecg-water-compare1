<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wViewWaterUseList" checkbox="false" pagination="true" fitColumns="false" title="用水明细" actionUrl="wViewWaterUseController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="会员姓名"  field="memberName"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="会员联系方式"  field="memberPhone"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="会员联系地址"  field="memberAddress"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="安装时间"  field="installEndtime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="水表id"  field="deviceId"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="水表初始值"  field="waterNum"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="水表当前读数"  field="waterCurrent"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="充值金额合计"  field="rechargeSum"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="充值合计水量"  field="rechargeWaterCount"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="已用水量"  field="waterUsed"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="剩余水量"  field="waterSurplus"    queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="wViewWaterUseController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="wViewWaterUseController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="wViewWaterUseController.do?goUpdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wViewWaterUseController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wViewWaterUseController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wviewwateruse/wViewWaterUseList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wViewWaterUseController.do?upload', "wViewWaterUseList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wViewWaterUseController.do?exportXls","wViewWaterUseList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wViewWaterUseController.do?exportXlsByT","wViewWaterUseList");
}

 </script>