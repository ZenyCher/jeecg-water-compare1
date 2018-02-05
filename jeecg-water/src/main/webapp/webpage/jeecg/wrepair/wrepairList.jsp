<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wRepairList" checkbox="true" pagination="true" fitColumns="false" title="维护保养管理" actionUrl="wrepairController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护状态"  field="maintainState"   query="true" queryMode="single" dictionary="maintainS" width="120"></t:dgCol>
    <t:dgCol title="设备id"  field="deviceId"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护负责人id"  field="registerId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="维护负责人"  field="registerName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="维护类型"  field="maintainType"  replace="故障_0,滤芯更换_1,其它_2"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="会员姓名"  field="memberName"   query="true" queryMode="single" dictionary="smember,member_name,member_phone,member_address,member_name,member_phone,member_address" popup="true" width="120"></t:dgCol>
    <t:dgCol title="联系方式"  field="memberPhone"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护地址"  field="memberAddress"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="需服务内容"  field="maintainService"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护时间"  field="maintainTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护记录"  field="maintainRecord"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="maintainRemarks"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="位置签到"  field="maintainSign"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="提交照片"  field="maintainSubphoto"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护完成时间"  field="maintainEndtime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
<%--     <t:dgCol title="维护滤芯"  field="maintainFilter"    queryMode="single"  width="120"></t:dgCol> --%>
<%--     <t:dgCol title="维护滤芯时水量"  field="maintainWater"    queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="wrepairController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="wrepairController.do?goAdd" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar title="登记" icon="icon-edit" url="wrepairController.do?goUpdate" funname="update" width="700" height="400"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wrepairController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wrepairController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wrepair/wrepairList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wrepairController.do?upload', "wRepairList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wrepairController.do?exportXls","wRepairList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wrepairController.do?exportXlsByT","wRepairList");
}

 </script>