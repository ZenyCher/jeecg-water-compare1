<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>维护保养管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wrepairController.do?doAdd" >
			<input id="id" name="id" type="hidden" value="${wRepairPage.id }">
			<input id="createName" name="createName" type="hidden" value="${wRepairPage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wRepairPage.createBy }">
			<input id="createDate" name="createDate" type="hidden" value="${wRepairPage.createDate }">
			<input id="updateName" name="updateName" type="hidden" value="${wRepairPage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wRepairPage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wRepairPage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wRepairPage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wRepairPage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wRepairPage.bpmStatus }">
			<input id="deviceId" name="deviceId" type="hidden" value="${wRepairPage.deviceId }">
			<input id="registerId" name="registerId" type="hidden" value="${wRepairPage.registerId }">
			<input id="maintainSign" name="maintainSign" type="hidden" value="${wRepairPage.maintainSign }">
			<input id="maintainSubphoto" name="maintainSubphoto" type="hidden" value="${wRepairPage.maintainSubphoto }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">维护状态:</label>
					<t:dictSelect field="maintainState" type="list" 
						typeGroupCode="maintainS" defaultVal="${wRepairPage.maintainState}" hasLabel="false"  title="维护状态"></t:dictSelect>     
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护负责人:</label>
		     	 <input id="registerName" name="registerName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护类型:</label>
		     	 <input id="maintainType" name="maintainType" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员姓名:</label>
			<input id="memberName" name="memberName" type="text" style="width: 150px" class="searchbox-inputtext" 
			ignore="checked"
			 onclick="inputClick(this,'member_name,member_phone,member_address','smember')"/>		 
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系方式:</label>
		     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护地址:</label>
		     	 <input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">需服务内容:</label>
		     	 <input id="maintainService" name="maintainService" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护时间:</label>
					  <input id="maintainTime" name="maintainTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
									ignore="checked"
					    />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护记录:</label>
		     	 <input id="maintainRecord" name="maintainRecord" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">备注:</label>
		     	 <input id="maintainRemarks" name="maintainRemarks" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护完成时间:</label>
		     	 <input id="maintainEndtime" name="maintainEndtime" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">维护滤芯:</label>
		     	<input id="maintainFilter" name="maintainFilter" type="text" style="width: 150" class="inputxt" ignore="checked"/>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">维护滤芯时水量:</label>
		     	<input id="maintainWater" name="maintainWater" type="text" style="width: 150" class="inputxt" ignore="checked"/>
		      	<span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wrepair/wrepair.js"></script>	
	