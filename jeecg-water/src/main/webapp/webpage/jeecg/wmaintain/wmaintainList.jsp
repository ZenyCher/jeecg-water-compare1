<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wMaintainList" checkbox="true" pagination="true" fitColumns="false" title="维修保养管理" actionUrl="wmaintainController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护状态"  field="maintainState"   query="true" queryMode="single" dictionary="maintainS" width="120"></t:dgCol>
    <t:dgCol title="设备id"  field="deviceId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护负责人id"  field="registerId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="维护公司"  field="registerName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="维护类型"  field="maintainType" replace="故障_0,滤芯更换_1,其它_2"   queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="会员姓名"  field="memberName"   query="true" queryMode="single" dictionary="smember,member_name,member_phone,member_address,member_name,member_phone,member_address" popup="true" width="120"></t:dgCol>
    <t:dgCol title="联系方式"  field="memberPhone"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护地址"  field="memberAddress"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="需服务内容"  field="maintainService"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护时间"  field="maintainTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护记录"  field="maintainRecord"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="maintainRemarks"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="位置签到"  field="maintainSign"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="提交照片"  field="maintainSubphoto"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="维护完成时间"  field="maintainEndtime"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="维护滤芯"  field="maintainFilter"  hidden="true"  queryMode="single"  width="100"></t:dgCol>
    <t:dgCol title="维护滤芯时水量"  field="maintainWater"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯1id"  field="oneFilterId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯1名称"  field="oneFilterName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯2id"  field="twoFilterId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯2名称"  field="twoFilterName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯3id"  field="threeFilterId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯3名称"  field="threeFilterName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯4id"  field="fourFilterId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯4名称"  field="fourFilterName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯5id"  field="fiveFilterId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯5名称"  field="fiveFilterName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯6id"  field="sixFilterId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="更换滤芯6名称"  field="sixFilterName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="登记日期"  field="createDate" formatter="yyyy-MM-dd" width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="wmaintainController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
   <t:dgToolBar title="新增" icon="icon-add" url="wmaintainController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wmaintainController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wmaintainController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wmaintainController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wmaintain/wmaintainList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wmaintainController.do?upload', "wMaintainList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wmaintainController.do?exportXls","wMaintainList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wmaintainController.do?exportXlsByT","wMaintainList");
}

 </script>