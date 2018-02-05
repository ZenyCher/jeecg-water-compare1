<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wComplaintList" checkbox="true" pagination="true" fitColumns="false" title="投诉与建议" actionUrl="wComplaintController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="会员姓名"  field="complaintMembername"   query="true" queryMode="single"  width="80"></t:dgCol>
    <t:dgCol title="联系方式"  field="complaintPhone"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="反馈内容"  field="complaintContent"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="问题类型"  field="complaintType"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="处理状态"  field="complaintState"    queryMode="single" dictionary="c_state" width="80"></t:dgCol>
    <t:dgCol title="提交时间"  field="complaintTime" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="投诉图片"  field="complaintImage"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="处理完成时间"  field="complaintEndtime"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="投诉与建议回复"  field="complaintMsg"    queryMode="single"  width="500" colspan="10"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="wComplaintController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="wComplaintController.do?goAdd" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar title="回复" icon="icon-edit" url="wComplaintController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wComplaintController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wComplaintController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
<%--      	<t:dgToolBar title="问题处理" icon="icon-edit"  url="wComplaintController.do?doHandle" funname="doHandle" ></t:dgToolBar> --%>
<%--      	<t:dgToolBar title="统计分析" icon="icon-bar-chart"  url="cgDynamGraphController.do?design" funname="statistics" ></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wcomplaint/wcomplaintList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
     	//自定义按钮-问题处理
	 	function doHandle(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择问题处理项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wComplaintController.do?upload', "wComplaintList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wComplaintController.do?exportXls","wComplaintList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wComplaintController.do?exportXlsByT","wComplaintList");
}

 </script>