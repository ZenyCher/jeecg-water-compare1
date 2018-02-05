<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户地址表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wAddressController.do?doAdd" >
			<input id="id" name="id" type="hidden" value="${wAddressPage.id }">
			<input id="createName" name="createName" type="hidden" value="${wAddressPage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wAddressPage.createBy }">
			<input id="createDate" name="createDate" type="hidden" value="${wAddressPage.createDate }">
			<input id="updateName" name="updateName" type="hidden" value="${wAddressPage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wAddressPage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wAddressPage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wAddressPage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wAddressPage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wAddressPage.bpmStatus }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">注册用户id:</label>
		     	 <input id="registerId" name="registerId" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">所在地区:</label>
		     	 <input id="addressRegion" name="addressRegion" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">收货人电话:</label>
		     	 <input id="addressPhone" name="addressPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">街道地址:</label>
		     	 <input id="addressStreet" name="addressStreet" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">收货人:</label>
		     	 <input id="addressName" name="addressName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员联系方式:</label>
		     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/waddress/wAddress.js"></script>	
	