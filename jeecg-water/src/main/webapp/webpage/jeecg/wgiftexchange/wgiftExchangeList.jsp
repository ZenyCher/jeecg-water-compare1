<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wGiftExchangeList" checkbox="true" pagination="true" fitColumns="false" title="礼品兑换表" actionUrl="wGiftExchangeController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="礼品id"  field="giftId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="单号"  field="giftexchangeOrder"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="处理状态"  field="giftexchangeState" replace="待支付_0,待发货_1,待收货_2,已完成_3"  query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="处理人"  field="giftexchangeHandle"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="礼品名称"  field="giftName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="礼品数量"  field="giftexchangeNumber"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="兑换时间"  field="giftexchangeTime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="收货人"  field="giftexchangeConsignee"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="联系方式"  field="giftexchangePhone"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="收货地址"  field="giftexchangeAddress"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="快递公司"  field="giftexchangeExpress"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="快递单号"  field="giftexchangeCouriernumber"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="经办人"  field="giftexchangeOperator"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="快递费"  field="giftexchangeCost"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="寄出时间"  field="giftexchangeMailtime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="兑换积分"  field="giftexchangeIntegral"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wGiftExchangeController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="wGiftExchangeController.do?goAdd" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar title="维护" icon="icon-edit" url="wGiftExchangeController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wGiftExchangeController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wGiftExchangeController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wgiftExchange/wGiftExchangeList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wGiftExchangeController.do?upload', "wGiftExchangeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wGiftExchangeController.do?exportXls","wGiftExchangeList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wGiftExchangeController.do?exportXlsByT","wGiftExchangeList");
}

 </script>