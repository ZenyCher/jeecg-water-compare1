<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户关联设备表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wUserDeviceController.do?doAdd" >
			<input id="id" name="id" type="hidden" value="${wUserDevicePage.id }">
			<input id="createName" name="createName" type="hidden" value="${wUserDevicePage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wUserDevicePage.createBy }">
			<input id="createDate" name="createDate" type="hidden" value="${wUserDevicePage.createDate }">
			<input id="updateName" name="updateName" type="hidden" value="${wUserDevicePage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wUserDevicePage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wUserDevicePage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wUserDevicePage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wUserDevicePage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wUserDevicePage.bpmStatus }">
			<input id="deviceId" name="deviceId" type="hidden" value="${wUserDevicePage.deviceId }">
			<input id="watermeterId" name="watermeterId" type="hidden" value="${wUserDevicePage.watermeterId }">
			<input id="oneFilterId" name="oneFilterId" type="hidden" value="${wUserDevicePage.oneFilterId }">
			<input id="oneFilterName" name="oneFilterName" type="hidden" value="${wUserDevicePage.oneFilterName }">
			<input id="twoFilterId" name="twoFilterId" type="hidden" value="${wUserDevicePage.twoFilterId }">
			<input id="twoFilterName" name="twoFilterName" type="hidden" value="${wUserDevicePage.twoFilterName }">
			<input id="threeFilterId" name="threeFilterId" type="hidden" value="${wUserDevicePage.threeFilterId }">
			<input id="threeFilterName" name="threeFilterName" type="hidden" value="${wUserDevicePage.threeFilterName }">
			<input id="fourFilterId" name="fourFilterId" type="hidden" value="${wUserDevicePage.fourFilterId }">
			<input id="fourFilterName" name="fourFilterName" type="hidden" value="${wUserDevicePage.fourFilterName }">
			<input id="fiveFilterId" name="fiveFilterId" type="hidden" value="${wUserDevicePage.fiveFilterId }">
			<input id="fiveFilterName" name="fiveFilterName" type="hidden" value="${wUserDevicePage.fiveFilterName }">
			<input id="sixFilterId" name="sixFilterId" type="hidden" value="${wUserDevicePage.sixFilterId }">
			<input id="sixFilterName" name="sixFilterName" type="hidden" value="${wUserDevicePage.sixFilterName }">
			<input id="installErectorId" name="installErectorId" type="hidden" value="${wUserDevicePage.installErectorId }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">会员联系方式:</label>
		     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员姓名:</label>
		     	 <input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">设备名称:</label>
		     	 <input id="deviceName" name="deviceName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">净水器类型:</label>
		     	 <input id="deviceTypeId" name="deviceTypeId" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">净水器类型名称:</label>
		     	 <input id="deviceTypeName" name="deviceTypeName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">安装公司名称:</label>
		     	 <input id="installErectorName" name="installErectorName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/wuserDevice/wUserDevice.js"></script>	
	