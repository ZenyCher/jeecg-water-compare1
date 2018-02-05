<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wWaterWarningList" checkbox="true" pagination="true" fitColumns="false" title="用户用水告警统计" actionUrl="wWaterWarningController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="会员姓名"  field="memberName"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="会员联系方式"  field="memberPhone"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="告警状态"  field="waterState"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="剩余水量(升)"  field="waterNumber"    queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="wWaterWarningController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="wWaterWarningController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="wWaterWarningController.do?goUpdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wWaterWarningController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wWaterWarningController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
    	  <div id="jeecgMysearchListtb" style="padding: 3px; height: 25px">
		  	 <div style="float: left;">
<!-- 				  <a href="#" class="easyui-linkbutton"  iconCls="icon-search" onclick="wRechargeStatisticsListsearch('日统计','wRechargeStatisticsController.do?dayStatistics',wRechargeStatisticsList)">日统计</a>  -->
				  <a href="#" class="easyui-linkbutton"  iconCls="icon-search" onclick="add(0)">剩余水量不足</a>
				  <a href="#" class="easyui-linkbutton"  iconCls="icon-search" onclick="add(1)">连续六天没用水</a>
				  <input type="hidden" name="sysCompanyCode">
			  </div>
	  		  <div align="right">
	  			  会员姓名：<input class="inuptxt ac_input" type="text" name="memberName">
	  			 <a id="save_statisticsList" href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="wWaterWarningListsearch();">查询</a>
				 <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="searchReset('wWaterWarningList')">重置</a>
	  		 </div>
  	  </div>
  </div>
 </div>
 <script src = "webpage/jeecg/wwaterWarning/wWaterWarningList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 //0为剩余水量不足，1为连续6天没用水
 function add(name){
	 if( name == '0'){
		 $("input[name=sysCompanyCode]").val(name);
	 }else if( name == '1'){
		 $("input[name=sysCompanyCode]").val(name);
	 }
	 $("#save_statisticsList").click();
 }
 
 //根据会员姓名查询统计充值金额
 function saveMemberName(){
	 debugger
	 search();
	 var name = $("input[name = member_name]").val();
		$.ajax({
	  		   type: "post",
	  		   url: "wWaterWarningController.do?saveName&name=" +  name,
	  		   success: function(data){
	  			 var arrayFileObj = jQuery.parseJSON(data).obj;
	  			 
	  		   }
 	});
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wWaterWarningController.do?upload', "wWaterWarningList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wWaterWarningController.do?exportXls","wWaterWarningList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wWaterWarningController.do?exportXlsByT","wWaterWarningList");
}

 </script>