<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>水表开关阀</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wWaterOpenController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wWaterOpenPage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wWaterOpenPage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wWaterOpenPage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wWaterOpenPage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wWaterOpenPage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wWaterOpenPage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wWaterOpenPage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wWaterOpenPage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wWaterOpenPage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wWaterOpenPage.bpmStatus }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">水表id:</label>
		     	 <input id="waterId" name="waterId" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wWaterOpenPage.waterId}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">开关状态:</label>
		     	 <input id="waterOpenType" name="waterOpenType" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wWaterOpenPage.waterOpenType}'/>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/wwaterOpen/wWaterOpen.js"></script>		
