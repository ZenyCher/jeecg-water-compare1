<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>维修保养管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wmaintainController.do?doAdd" >
			<input id="id" name="id" type="hidden" value="${wMaintainPage.id }">
			<input id="createName" name="createName" type="hidden" value="${wMaintainPage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wMaintainPage.createBy }">
			<input id="createDate" name="createDate" type="hidden" value="${wMaintainPage.createDate }">
			<input id="updateName" name="updateName" type="hidden" value="${wMaintainPage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wMaintainPage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wMaintainPage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wMaintainPage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wMaintainPage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wMaintainPage.bpmStatus }">
			<input id="registerId" name="registerId" type="hidden" value="${wMaintainPage.registerId }">
			<input id="maintainRemarks" name="maintainRemarks" type="hidden" value="${wMaintainPage.maintainRemarks }">
			<input id="maintainSign" name="maintainSign" type="hidden" value="${wMaintainPage.maintainSign }">
			<input id="maintainSubphoto" name="maintainSubphoto" type="hidden" value="${wMaintainPage.maintainSubphoto }">
			<input id="maintainEndtime" name="maintainEndtime" type="hidden" value="${wMaintainPage.maintainEndtime }">
			<input id="maintainFilter" name="maintainFilter" type="hidden" value="${wMaintainPage.maintainFilter }">
			<input id="maintainWater" name="maintainWater" type="hidden" value="${wMaintainPage.maintainWater }">
		<fieldset class="step">
			<div class="form">
				<label class="Validform_label">会员姓名:</label>
				<input id="memberName" name="memberName" type="text" style="width: 150px" class="searchbox-inputtext" ignore="checked" datatype="*"
					onclick="popupClick(this,'member_name,member_phone,member_address,device_id','memberName,memberPhone,memberAddress,deviceId','smember');"/>
				<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">维护地址:</label>
		    	<input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" ignore="ignore"/>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">联系方式:</label>
		    	<input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" ignore="ignore"/>
		      	<span class="Validform_checktip"></span>
		    </div>
		   	<div class="form">
		   		<label class="Validform_label">设备id:</label>
		   		<input id="deviceId" name="deviceId" type="text" style="width: 150px" class="inputxt" ignore="ignore"/>
		   		<span class="Validform_checktip"></span>
<!-- 		     	<select id="deviceId" name="deviceId"></select>  -->
<!-- 		      	<span class="Validform_checktip"></span> -->
<!-- 		      	<a href="#" class="easyui-linkbutton l-btn l-btn-plain" plain="true" onClick="saveUserDevice()"> -->
<!-- 		     		<span class="l-btn-text icon-search l-btn-icon-left">获取数据</span> -->
<!-- 		     	</a> -->
		    </div>
		    <div class="form">
		    	<label class="Validform_label">维护类型:</label>
		     	<t:dictSelect field="maintainType" type="list" 
		     		typeGroupCode="maintainT" hasLabel="false"  title="维护类型" datatype="*"></t:dictSelect>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">需服务内容:</label>
		     	<input id="maintainService" name="maintainService" type="text" style="width: 300px;height:100px;" class="inputxt" ignore="checked"/>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<label class="Validform_label">计划维护时间:</label>
		    	<input id="maintainTime" name="maintainTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" ignore="checked"/>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
<!-- 		    	<label class="Validform_label">维护负责人:</label> -->
<!-- 		     	<input id="registerName" name="registerName" type="text" style="width: 150px" class="inputxt" ignore="ignore"/> -->
<!-- 		     	<input id="registerId" name="registerId" type="hidden" value=""/> -->
<%-- 		     	<t:choose hiddenName="registerId" hiddenid="id" url="wmaintainController.do?assign" name="registerList" icon="icon-search" title="选择安装工" textname="registerName" isclear="true" isInit="true"></t:choose> --%>
<!-- 		      	<span class="Validform_checktip"></span> -->
		    	<label class="Validform_label">维护公司:</label>
		     	<input id="erectorCompany" name="erectorCompany" type="text" style="width: 150px" class="inputxt" ignore="ignore"/>
<%-- 		     	<input id="registerId" name="registerId" type="hidden" value="${wMaintainPage.registerId }"/> --%>
		     	<t:choose hiddenName="registerId" hiddenid="id" url="wmaintainController.do?assign" name="erectirList" icon="icon-search" title="选择安装工" textname="erectorCompany" isclear="true" isInit="true"></t:choose>
		      	<span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wmaintain/wmaintain.js"></script>	
	