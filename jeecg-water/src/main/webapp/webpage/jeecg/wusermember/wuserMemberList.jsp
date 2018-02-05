<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wUserMemberList" checkbox="true" pagination="true" fitColumns="false" title="会员表" actionUrl="wuserMemberController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="净水器型号id"  field="memberDeviceId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
    <t:dgCol title="初装套餐类型id"  field="memberPackageId" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="正常套餐类型id"  field="memberNormalPackageId" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="会员姓名"  field="memberName"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="联系方式"  field="memberType" query="true" queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="会员id"  field="memberPhone"  query="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="居住地址"  field="memberAddress"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="水表id"  field="memberId"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="初始水量L"  field="memberInitialWater"  queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="当前剩余水量L"  field="waterSurplus"    queryMode="single"  width="120"></t:dgCol>
<%--     <t:dgCol title="关联用户"  field="memberUser"    queryMode="single"  width="120"></t:dgCol> --%>
    <t:dgCol title="附件合同"  field="menberContract"  formatterjs="selectFile"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="附件证件"  field="menberCertificates"  formatterjs="selectFile"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="押金"  field="memberDeposit"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="memberRemarks"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="是否有效"  field="memberState"  replace="无效_0,有效_1"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="套餐类型"  field="memberPackageType" hidden="true" replace="首冲套餐_0,正常套餐_1" width="120"></t:dgCol>
    <t:dgCol title="初装套餐类型"  field="memberPackageMsg"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="正常套餐类型"  field="memberNormalPackageMsg"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="净水器型号"  field="memberDeviceType"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="录入时间"  field="createDate" formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="来源"  field="memberSource" queryMode="single" replace="线下签约_0,商城下单_1" width="120"></t:dgCol>
    <t:dgCol title="指派安装公司"  field="memberAssignInstall" queryMode="single" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="300"></t:dgCol>
   <t:dgConfOpt title="有效" url="wuserMemberController.do?effective&id={id}" urlclass="ace_button" urlfont="fa-eye" message="有效"/>
   <t:dgConfOpt title="无效" url="wuserMemberController.do?invalid&id={id}" urlclass="ace_button" urlfont="fa-eye-slash" message="无效"/>
   <t:dgDelOpt title="删除" url="wuserMemberController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuserMemberController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuserMemberController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="指派安装公司" icon="icon-user-set-o"  url="wuserMemberController.do?assignErector" funname="assignErector" ></t:dgToolBar>
   <t:dgToolBar title="亲属关系" icon="icon-user-set"  url="wuserMemberController.do?relationship" funname="relationship" ></t:dgToolBar>
  </t:datagrid>
  	  
  </div>
  </div>
 </div>
 <script src = "webpage/jeecg/wusermember/wuserMemberList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 }); 

function selectFile(value,row,index){
	return '<a style="color:red" href="systemController/showOrDownByurl.do?down=1&dbPath='+value+'">'+value+'</a>';
}
 
 //指派安装工
function assignErector(title,url,gridname){
	var rowData = $('#'+gridname).datagrid('getSelected');
	if (!rowData) {
		tip('请选择一位会员用户指派');
		return;
	}
	var id = rowData['id'];
	var path = url + '&id=' + id;
	createwindow('指派安装公司',path,500,500);
}
 
//亲属关系
function relationship(title,url,gridname){
	var rowData = $('#'+gridname).datagrid('getSelected');
	if (!rowData) {
		tip('请选择一位会员用户指定亲属');
		return;
	}
	var id = rowData['id'];
	var path = url + '&id=' + id;
	createwindow('亲属关系',path,500,350);
}

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuserMemberController.do?upload', "wuserMemberList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuserMemberController.do?exportXls","wuserMemberList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuserMemberController.do?exportXlsByT","wuserMemberList");
}

 </script>