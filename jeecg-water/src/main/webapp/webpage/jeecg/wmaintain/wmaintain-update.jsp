<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>w_maintain</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wmaintainController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wMaintainPage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wMaintainPage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wMaintainPage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wMaintainPage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wMaintainPage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wMaintainPage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wMaintainPage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wMaintainPage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wMaintainPage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wMaintainPage.bpmStatus }"/>
			<input id="maintainRemarks" name="maintainRemarks" type="hidden" value="${wMaintainPage.maintainRemarks }"/>
			<input id="maintainSign" name="maintainSign" type="hidden" value="${wMaintainPage.maintainSign }"/>
			<input id="maintainSubphoto" name="maintainSubphoto" type="hidden" value="${wMaintainPage.maintainSubphoto }"/>
			<input id="maintainFilter" name="maintainFilter" type="hidden" value="${wMaintainPage.maintainFilter }">
			<input id="maintainWater" name="maintainWater" type="hidden" value="${wMaintainPage.maintainWater }">
		<fieldset class="step">
			<div class="form">
				<label class="Validform_label">会员姓名:</label>
				<input id="memberName" name="memberName" type="text" style="width: 150px" class="searchbox-inputtext"
					ignore="checked" datatype="*" value='${wMaintainPage.memberName}' onclick="popupClick(this,'member_name,member_phone,member_address,device_id','memberName,memberPhone,memberAddress,deviceId','smember');" value='${wMaintainPage.memberName}'/>			 
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">维护地址:</label>
		     	<input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" ignore="ignore" value='${wMaintainPage.memberAddress}'/>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">联系方式:</label>
		      	<input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" ignore="ignore" value='${wMaintainPage.memberPhone}'/>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		   		<label class="Validform_label">设备id:</label>
		   		<input id="deviceId" name="deviceId" type="text" style="width: 150px" class="inputxt" ignore="ignore" value='${wMaintainPage.deviceId}'/>
		      	<span class="Validform_checktip"></span>
<%-- 		     	<select id="deviceId" name="deviceId"><option>${wMaintainPage.deviceId }</option></select>  --%>
<!-- 		      	<span class="Validform_checktip"></span> -->
<!-- 		      	<a href="#" class="easyui-linkbutton l-btn l-btn-plain" plain="true" onClick="saveUserDevice()"> -->
<!-- 		     		<span class="l-btn-text icon-search l-btn-icon-left">获取数据</span> -->
<!-- 		     	</a> -->
		    </div>
		    <div class="form">
		    	<label class="Validform_label">维护类型:</label>
		     	<t:dictSelect field="maintainType" type="list" 
		     		typeGroupCode="maintainT" defaultVal="${wMaintainPage.maintainType}" hasLabel="false"  title="维护类型" datatype="*"></t:dictSelect>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">需服务内容:</label>
		    	<input id="maintainService" name="maintainService" type="text" style="width: 300px;height:100px;" class="inputxt" ignore="checked" value='${wMaintainPage.maintainService}'/>
		      	<span class="Validform_checktip"></span>
		    </div>
		   	<div class="form">
		   		<label class="Validform_label">计划维护时间:</label>
		   			<input id="maintainTime" name="maintainTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" ignore="checked"
		      						  value='<fmt:formatDate value='${wMaintainPage.maintainTime}' type="date" pattern="yyyy-MM-dd"/>'/>   
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">维护公司:</label>
		     	<input id="erectorCompany" name="erectorCompany" value='${wMaintainPage.registerName}' type="text" style="width: 150px" class="inputxt" ignore="ignore" />
		     	<input id="registerId" name="registerId" type="hidden" value="${wMaintainPage.registerId }"/>
		     	<t:choose hiddenName="registerId" hiddenid="id" url="wmaintainController.do?assign" name="erectirList" icon="icon-search" title="选择安装工" textname="erectorCompany" isclear="true" isInit="true"></t:choose>
		      	<span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护状态:</label>
					<t:dictSelect field="maintainState" type="list" 
						typeGroupCode="maintainS" defaultVal="${wMaintainPage.maintainState}" hasLabel="false"  title="维护状态"></t:dictSelect>     
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护记录:</label>
		     	 <input id="maintainRecord" name="maintainRecord" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMaintainPage.maintainRecord}'/>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		   		<label class="Validform_label">维护完成时间:</label>
		   			<input id="maintainEndtime" name="maintainEndtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" ignore="checked"
		      						  value='<fmt:formatDate value='${wMaintainPage.maintainEndtime}' type="date" pattern="yyyy-MM-dd"/>'/>   
		      	<span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wmaintain/wmaintain.js"></script>		
