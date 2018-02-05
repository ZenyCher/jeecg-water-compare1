<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wRechargeStatisticsList" checkbox="true" pagination="true" fitColumns="false" title="会员充值统计" actionUrl="wRechargeStatisticsController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="会员姓名"  field="memberName"    queryMode="single"  width="300"></t:dgCol>
    <t:dgCol title="充值金额合计"  field="rechargeStatistics" hidden="true"  queryMode="single"  width="300"></t:dgCol>
    <t:dgCol title="充值金额合计(元)"  field="rechargeStatistics1"    queryMode="single"  width="300"></t:dgCol>
    <t:dgCol title="会员联系方式"  field="memberPhone"    queryMode="single"  width="120"></t:dgCol>
  </t:datagrid>
  
  	  <div id="jeecgMysearchListtb" style="padding: 3px; height: 25px">
		  	 <div style="float: left;">
<!-- 				  <a href="#" class="easyui-linkbutton"  iconCls="icon-search" onclick="wRechargeStatisticsListsearch('日统计','wRechargeStatisticsController.do?dayStatistics',wRechargeStatisticsList)">日统计</a>  -->
				  <a href="#" class="easyui-linkbutton"  iconCls="icon-search" onclick="add(0)">日统计</a>
				  <a href="#" class="easyui-linkbutton"  iconCls="icon-search" onclick="add(1)">月统计</a>
				  <a href="#" class="easyui-linkbutton"  iconCls="icon-search" onclick="add(2)">年统计</a>
				  <input type="hidden" name="sysCompanyCode">
			  </div>
	  		  <div align="right">
	  			  会员姓名：<input class="inuptxt ac_input" type="text" name="memberName">
	  			 <a id="save_statisticsList" href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="wRechargeStatisticsListsearch();">查询</a>
				 <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="searchReset('wRechargeStatisticsList')">重置</a>
	  		 </div>
  	  </div>
  
  </div>
 </div>
 <script src = "webpage/jeecg/wrechargestatistics/wRechargeStatisticsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 function add(name){
	 if( name == '0'){
		 $("input[name=sysCompanyCode]").val(name);
	 }else if( name == '1'){
		 $("input[name=sysCompanyCode]").val(name);
	 }else if( name == '2')
		 $("input[name=sysCompanyCode]").val(name);
	 $("#save_statisticsList").click();
 }

 
 //根据会员姓名查询统计充值金额
 function saveMemberName(){
	 search();
	 var name = $("input[name = member_name]").val();
		$.ajax({
	  		   type: "post",
	  		   url: "wRechargeStatisticsController.do?saveName&name=" +  name,
	  		   success: function(data){
	  			 var arrayFileObj = jQuery.parseJSON(data).obj;
	  			 
	  		   }
 	});
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wRechargeStatisticsController.do?upload', "wRechargeStatisticsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wRechargeStatisticsController.do?exportXls","wRechargeStatisticsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wRechargeStatisticsController.do?exportXlsByT","wRechargeStatisticsList");
}

 </script>