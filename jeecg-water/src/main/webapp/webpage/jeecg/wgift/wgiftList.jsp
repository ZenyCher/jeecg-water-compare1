<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wGiftList" checkbox="true" pagination="true" fitColumns="false" title="礼品管理" actionUrl="wGiftController.do?datagrid" idField="id" fit="true" queryMode="group">
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
    <t:dgCol title="礼品名称"  field="giftName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="礼品描述"  field="giftDescribe"    queryMode="single"  width="500"></t:dgCol>
    <t:dgCol title="礼品兑换积分"  field="giftChange"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="礼品总数量"  field="giftSum"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="礼品剩余数量"  field="giftSurplus"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="礼品图片"  field="giftImage" formatterjs="selectFile"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="礼品是否可兑换"  field="giftYesonno"   query="true" queryMode="single" dictionary="giftYesNo" width="120"></t:dgCol>
    <t:dgCol title="礼品是否上下架"  field="giftType"   query="true" queryMode="single" dictionary="giftType" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wGiftController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wGiftController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wGiftController.do?goUpdate" funname="update" width="1000" height="600"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="wGiftController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="wGiftController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
     	<t:dgToolBar title="上架" icon="icon-edit"  url="wGiftController.do?doShelves" funname="doShelves" ></t:dgToolBar>
     	<t:dgToolBar title="下架" icon="icon-edit"  url="wGiftController.do?doTheShelf" funname="doTheShelf" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/jeecg/wgift/wGiftList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
function selectFile(value,row,index){
	var str = value.split(',');
	var fileStr = "";
	for(var i=0;i<str.length;i++){
		fileStr  += '<a style="color:red;display: inline-block;padding-right: 10px;" href="systemController/showOrDownByurl.do?down=1&dbPath='+str[i]+'">'+str[i]+'</a>';
	}
	return fileStr;
	
}
 
     	//自定义按钮-上架
	 	function doShelves(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择上架项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
     	//自定义按钮-下架
	 	function doTheShelf(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择下架项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wGiftController.do?upload', "wGiftList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wGiftController.do?exportXls","wGiftList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wGiftController.do?exportXlsByT","wGiftList");
}

 </script>